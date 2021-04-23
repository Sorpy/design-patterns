package patterns.observer;

public class ObserverMain {

  public static void main(String[] args) {

    User user = new User();
    Observer userObserver = new UserObserver();

    user.subscribe(userObserver);
    user.register("pesho","goteniq");
    user.setUsername("gergo");


  }
}
