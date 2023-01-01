package com.nova.hospital.view;

/**
 * @author bingolalii
 */
public class DoctorView extends AbstractView{

    public static void showDoctorOptionsForUsers() {
        println("----------------------------------------\n");
        println("**** Doctor OPERATIONS ****");
        println("\n[1] -> Create an Appointment");
        println("[2] -> Back to Main Menu");
        println("[0] -> Logout");
        println("----------------------------------------");
    }

    public static void showDoctorOptionsForAdmin() {
        println("----------------------------------------\n");
        println("**** Doctor OPERATIONS ****");
        println("\n[1] -> Create an Appointment");
        println("[2] -> Sort Doctors by Calendar");
        println("[3] -> Back to Main Menu");
        println("[0] -> Logout");
        println("----------------------------------------");
    }

}
