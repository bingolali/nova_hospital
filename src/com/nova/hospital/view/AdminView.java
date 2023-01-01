package com.nova.hospital.view;

/**
 * @author bingolalii
 */
public class AdminView extends AbstractView{

    public static void showAdminOptions() {
        println("----------------------------------------\n");
        println("**** ADMIN OPERATIONS ****");
        println("\n[1] -> List Clinics");
        println("[0] -> Logout");
        println("----------------------------------------");
    }
}
