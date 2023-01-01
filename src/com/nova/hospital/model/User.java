package com.nova.hospital.model;

import java.util.UUID;

/**
 * @author bingolalii
 */
public class User {

    private String userid;
    private String pwd;
    private String name;
    private String type;

    public User(String name, String pwd, String type) {
        this.userid = UUID.randomUUID().toString();
        this.pwd = pwd;
        this.type = type;
        this.name = name;
    }

    public User(String name, String pwd) {
        this.pwd = pwd;
        this.name = name;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        return ((User) o).getUserid().equals(userid);
    }

    public String getType() {
        return type;
    }

}
