package pyneer.full_time_wannabe.model;

import java.io.Serializable;


public class ChatListData implements Serializable {
    private String chatName;
    private String lastChat;

    public ChatListData() {}
    public ChatListData(String chatName) {
        this.chatName = chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
    public void setLastChat(String lastChat) { this.lastChat = lastChat; }

    public String getChatName() { return chatName; }
    public String getLastChat() { return lastChat; }
}
