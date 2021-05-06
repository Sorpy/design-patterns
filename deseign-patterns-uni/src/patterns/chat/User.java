package patterns.chat;

public abstract class User {

  protected ChatMediator mediator;
  protected String name;

  public User(ChatMediator mediator, String name) {
    this.mediator = mediator;
    this.name = name;
  }

  protected User() {
  }

  public abstract void send(String message);

  public abstract void receive(User user,String message);
}
