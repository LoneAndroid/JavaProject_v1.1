package topsecretinformation.javaproject_v11;

/**
 * Created by LA on 3/22/1975.
 */

public class Message {

    static int SENDER_BOT = 0;
    static int SENDER_USER = 1;

    String text; // содержимое сообщения
    int sender; // отправитель: 0 - бот, 1 - пользователь

    Message(String text, int sender) {
        this.text = text;
        this.sender = sender;
    }

 }
