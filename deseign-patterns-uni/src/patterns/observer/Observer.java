package patterns.observer;

public interface Observer {

  void updated(User user, User oldUser);
  void created(User user);

  <T> void setObserved(Observable entity);
}
