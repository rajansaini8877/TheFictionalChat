package com.myappcompany.rajan.thefictionalchat;

public class ChatText {

    private String message="";
    private String messageType;
    private int imageResource=-1;

    public ChatText(String message, String messageType) {
        this.message = message;
        this.messageType = messageType;
    }

    public ChatText(int imageResource, String messageType) {
        this.imageResource = imageResource;
        this.messageType = messageType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageType() {
        return messageType;
    }

    public int getImageResource() {
        return imageResource;
    }
}
