package com.example.crxc.funny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by crxc on 2016/7/7.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GitMode {
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    //    private String login;
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
}
