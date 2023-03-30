package com.bebopt.app.domain;

public class Client {
    private static String clientID = "your client ID";
    private static String clientSecret = "your client secret";
    
    public static String getClientID() {
        return clientID;
    }
    public static String getClientSecret() {
        return clientSecret;
    }
}