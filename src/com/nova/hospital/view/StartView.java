package com.nova.hospital.view;

/**
 * @author bingolalii
 */
public class StartView extends AbstractView {

    public static void showBanner() {
        println("********************************************************************");
        println("************************** NOVA HOSPITAL ***************************");
        println("********************************************************************\n");
    }

    public static void showApplicationEntryOptions() {
        println("\n[1] -> Administrator Login");
        println("[2] -> User Login");
        println("[0] -> Logout");
        println("----------------------------------------");
    }

}
