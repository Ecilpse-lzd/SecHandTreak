package com.example.lzd_develop.sechandtreak.doman;

/**
 * Created by lzd-develop on 16-4-25.
 */
public class User {

    private int LOGIN_MESSAGE;

    private String username;
    private int userId;
    private int isSignin;                           //签到
    private int isAuthenticate;                     //认证

    public int getLOGIN_MESSAGE() {
        return LOGIN_MESSAGE;
    }

    public void setLOGIN_MESSAGE(int LOGIN_MESSAGE) {
        this.LOGIN_MESSAGE = LOGIN_MESSAGE;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsSignin() {
        return isSignin;
    }

    public void setIsSignin(int isSignin) {
        this.isSignin = isSignin;
    }

    public int getIsAuthenticate() {
        return isAuthenticate;
    }

    public void setIsAuthenticate(int isAuthenticate) {
        this.isAuthenticate = isAuthenticate;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
