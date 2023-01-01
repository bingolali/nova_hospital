package com.nova.hospital.view;

/**
 * @author bingolalii
 */
public class UserView extends AbstractView{
    public static void showUserOptions() {
        println("----------------------------------------\n");
        println("**** USER OPERATIONS ****");
        println("\n[1] -> List Clinics");
        println("[0] -> Logout");
        println("----------------------------------------");
    }
}
