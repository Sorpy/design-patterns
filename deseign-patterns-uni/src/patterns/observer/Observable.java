package patterns.observer;

import java.util.ArrayList;
import java.util.List;
import patterns.observer.qualifier.Created;

public abstract class Observable<T> {

  protected List<Observer> observers;

  protected Observable() {
    this.observers = new ArrayList<>();
  }

  void subscribe(Observer observer) {
    this.observers.add(observer);
    observer.setObserved(this);
  }

  void unsubscribe(Observer observer) {
    this.observers.remove(observer);
  }



  abstract void fireEvent(T entity, T oldEntity, Class<?> action);


}
