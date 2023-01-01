package com.nova.hospital.model;

/**
 * @author bingolalii
 */
public class Admin extends User {

    public Admin(String name, String pwd) {
        super(name, pwd, "admin");
    }
}
