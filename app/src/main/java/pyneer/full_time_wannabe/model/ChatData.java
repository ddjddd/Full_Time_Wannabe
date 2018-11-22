package pyneer.full_time_wannabe.model;

/**
 * Created by ddjdd on 2018-11-04.
 */

public class ChatData {
    private String userName;
    private String chat;
    private int type;

    public ChatData() {}
    public ChatData(String userName, String message) {
        this.userName = userName;
        this.chat = message;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setChat(String chat) {
        this.chat = chat;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }
    public String getChat() {
        return chat;
    }
    public int getType() {
        return type;
    }
}
