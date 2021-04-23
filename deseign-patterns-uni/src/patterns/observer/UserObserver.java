package patterns.observer;

public class UserObserver implements Observer {

  private User entity;

  @Override
  public void updated(User user, User oldUser) {
    System.out
        .println("Information about user has been updated successfully\n"
            + "From : " + oldUser.toString()
            + "\nTo : " +user.toString());
  }

  @Override
  public void created(User user) {
    System.out.println("A new user has been created \nWelcome "+ user.getUsername());
  }

  @Override
  public void setObserved(Observable entity) {
    this.entity = (User) entity;
  }
}
