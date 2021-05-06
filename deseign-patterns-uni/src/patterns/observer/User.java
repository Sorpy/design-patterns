package patterns.observer;


import patterns.observer.qualifier.Created;
import patterns.observer.qualifier.Updated;

class User extends Observable<User> implements Cloneable {

  private String username;
  private String password;

  public User() {
    super();

  }

  public void register(String username,String password){
    //some validation added
    this.username = username;
    this.password = password;
    fireEvent(this,null, Created.class);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    User oldUser = tryCopyUser();
    this.username = username;
    fireEvent(this,oldUser, Updated.class);

  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    User oldUser = tryCopyUser();
    this.password = password;
    fireEvent(this,oldUser, Updated.class);
  }

  private User tryCopyUser() {
    User oldUser = null;
    try {
      oldUser = (User) this.clone();
    } catch (CloneNotSupportedException e) {
      System.err.println("Copy was not possible");
    }
    return oldUser;
  }

  @Override
  void fireEvent(User user,User oldUser, Class<?> action) {
   if (action.equals(Created.class)){
     super.observers.forEach(observer -> observer.created(user));
   } else if (action.equals(Updated.class)){
     super.observers.forEach(observer -> observer.updated(user,oldUser));
   }else {
     System.out.println("Unsupported behaviour");
   }
  }

  @Override
  public String toString() {
    return "username='" + username + ';' + ", password='" + password;

  }
}
