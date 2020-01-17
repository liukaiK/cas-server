package com.unicom.smartcity.cas;

import org.apereo.cas.authentication.Credential;

public class UsernamePasswordClientIdCredential implements Credential {


    private String username;

    private String password;

    private String clientId;

    @Override
    public String getId() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
