package com.nova.hospital.view;

/**
 * @author bingolalii
 */
public class ClinicView extends AbstractView{

    public static void showClinicOptions() {
        println("----------------------------------------\n");
        println("**** CLINIC OPERATIONS ****");
        println("\n[1] -> Dermatology");
        println("[2] -> Otorhinolaryngology");
        println("[3] -> Internal Medicine");
        println("[4] -> Pediatrics");
        println("[5] -> Orthopedics and Traumatology");
        println("[6] -> Back to Main Menu");
        println("[0] -> Logout");
        println("----------------------------------------");
    }
}
