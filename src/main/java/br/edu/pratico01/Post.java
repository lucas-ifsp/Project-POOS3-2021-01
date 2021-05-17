package br.edu.pratico01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String quote;
    private LocalDateTime timeStamp;
    private int claps;
    private int boos;

    private UserAccount user;

    public Post(String quote, UserAccount user) {
        this.quote = quote;
        this.user = user;
        this.timeStamp = LocalDateTime.now();
    }

    public String getPostInfo(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss dd/MM/yy");
        return "[" + dtf.format(timeStamp) + "] " + user.getUserName()
                + " says \"" + quote + "\" | Claps: " + claps + " | Boos: " + boos;
    }

    public void clap(){
        claps++;
    }

    public void boo(){
        boos++;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getClaps() {
        return claps;
    }

    public int getBoos() {
        return boos;
    }

    public UserAccount getUser() {
        return user;
    }
}
