package patterns.chat;

import java.util.HashSet;
import java.util.Set;

public class Chat implements ChatMediator {

  private final Set<User> users;

  public Chat() {
    this.users = new HashSet<>();
  }

  @Override
  public void addUser(User user) {
    this.users.add(user);
    System.out.println(user.name + " has been added to the chat");
  }

  @Override
  public void removeUser(User user) {
    this.users.remove(user);
    System.out.println(user.name + " has been removed from the chat");
  }



  @Override
  public void sendMessage(String message, User user) {
    for (User chatUser : this.users) {
      if (!chatUser.equals(user)) {
        chatUser.receive(user, message);
      }
    }
  }

  @Override
  public Set<User> getUserList() {
    return users;
  }
}
