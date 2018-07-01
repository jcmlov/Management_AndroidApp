package com.example.jcmcsy.management.vo;

public class User {

    String userId;
    String userPw;
    String userNm;
    String userEmail;

    public User(String userId, String userPw, String userNm, String userEmail) {
        this.userId = userId;
        this.userPw = userPw;
        this.userNm = userNm;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userNm='" + userNm + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
