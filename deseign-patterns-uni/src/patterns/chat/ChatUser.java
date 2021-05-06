package patterns.chat;

public class ChatUser extends User{


  public ChatUser(ChatMediator mediator, String name) {
    super(mediator, name);
    mediator.addUser(this);
  }

  @Override
  public void send(String message) {
    if (mediator.getUserList().contains(this)) {
      System.out.println(name + " sent : " + message);
      mediator.sendMessage(message, this);
      checkBotCommands(message);
    }
  }

  @Override
  public void receive(User user,String message) {
    System.out.println(name + " received : " + message);
  }

  private void checkBotCommands(String message) {
    if (message.equals("addBot")){
      SingletonCatBot.getInstance(mediator,"catBot");
    }else if (message.equals("removeBot") && SingletonCatBot.isNull()){
      mediator.removeUser(SingletonCatBot.getInstance(mediator,"kogata"));
    }
  }
}
