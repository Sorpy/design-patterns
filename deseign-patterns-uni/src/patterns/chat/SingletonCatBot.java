package patterns.chat;

import javax.jws.soap.SOAPBinding.Use;

public class SingletonCatBot extends ChatUser {

  private static SingletonCatBot instance;

  private SingletonCatBot(ChatMediator mediator, String name) {
    super(mediator, name);
    send("HELLO HELLO HELLO! I AM A BOT");
  }

  @Override
  public void send(String message) {
    System.out.println(name + " sent : " + message);
    mediator.sendMessage(message,this);
  }

  @Override
  public void receive(User user,String message) {
    if (message.contains("cat")){
      send("cat is forbidden word " + user.name + " will be removed");
      mediator.removeUser(user);
    }
  }

  public static SingletonCatBot getInstance(ChatMediator mediator, String name) {

    if(instance == null) {
      instance = new SingletonCatBot(mediator,name);
    }

    return instance;
  }

  public static boolean isNull(){
    return instance != null;
  }
}
