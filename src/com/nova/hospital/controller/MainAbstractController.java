package com.nova.hospital.controller;

import com.nova.hospital.database.UserDataBase;
import com.nova.hospital.model.User;

import java.util.Scanner;

import static com.nova.hospital.view.AbstractView.*;

/**
 * @author bingolalii
 */
public abstract class MainAbstractController {

    protected boolean loggedIn;

    protected User loggedInUser;

    public boolean login() {
        if (!loggedIn) {
            Scanner scan = scanner();
            print("Enter username : ");
            String username = scan.next();
            print("Enter password : ");
            String password = scan.next();
            if (UserDataBase.exists(new User(username, password)).isPresent()) {
                loggedInUser = UserDataBase.exists(new User(username, password)).get();
                loggedIn = true;
                println(">>>>>>>>>>>>>>>> Login Successful!");
            } else {
                println(">>>>>>>>>>>>>> Invalid Credentials!! Please try again!!!");
                loggedIn = false;
            }
        }
        return loggedIn;
    }

    public void logout() {
        loggedIn = false;
        println(">>>>>>>>>>>>>>>>> Logout Successful!");
    }

    public void printTableHeader(String[] headers) {
        int count = 0;
        println("----------------------------------------------------------");
        for (String header : headers) {
            if (count == 0) {
                print("|      " + header + "      ");
            } else {
                println("|      " + header + "      ");
            }
            count++;
        }
        println("----------------------------------------------------------");
    }

    public void printTableData(String[][] data) {
        for (String[] row : data) {
            int count = 0;
            for (String rowData : row) {
                if (count == 0) {
                    print("|       " + rowData + "             ");
                } else {
                    println("|      " + rowData + "      ");
                }
                count++;
            }
            println("----------------------------------------------------------");
        }
    }
}
