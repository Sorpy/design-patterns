package patterns.chat;


public class ChatMain {

  public static void main(String[] args) {
    ChatMediator chat = new Chat();

    User user1 = new ChatUser(chat,"Tosho");
    User user2 = new ChatUser(chat,"qnko");
    User user3 = new ChatUser(chat,"petyk");

    user2.send("zdr");
    user2.send("addBot");
    user3.send("cat");
    user3.send("cat");

  }
}
