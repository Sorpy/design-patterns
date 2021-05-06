package patterns.chat;

import java.util.Set;

public interface ChatMediator {

  void sendMessage(String message, User user);
  Set<User> getUserList();

  void addUser(User user);
  void removeUser(User user);

}
