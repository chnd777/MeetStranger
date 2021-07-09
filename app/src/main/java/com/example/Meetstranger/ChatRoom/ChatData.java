package com.example.Meetstranger.ChatRoom;

public class ChatData {

    String userName,message,date,id;

    public ChatData(String userName, String message,String date,String id) {
        this.userName = userName;
        this.message = message;
        this.date = date;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
