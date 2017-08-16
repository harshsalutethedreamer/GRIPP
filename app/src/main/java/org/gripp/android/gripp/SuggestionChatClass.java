package org.gripp.android.gripp;

/**
 * Created by harshgupta on 19/07/17.
 */

public class SuggestionChatClass {
    public String name;
    public String chat;
    public String email;


    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public SuggestionChatClass() {
    }

    public SuggestionChatClass(String name, String chat,String email) {
        this.name = name;
        this.chat = chat;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
