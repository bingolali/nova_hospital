package com.nova.hospital.controller;

import static com.nova.hospital.view.AbstractView.*;
import static com.nova.hospital.view.AdminView.showAdminOptions;

/**
 * @author bingolalii
 */
public class AdminController extends MainAbstractController implements MainController {

    @Override
    public void showMainMenu(boolean isAdmin) {
        if (login()) {
            showAdminOptions();
            int option = learnOptionFromUser();
            println("----------------------------------------\n");
            switch (option) {
                case 0:
                    logout();
                    break;
                case 1:
                    ClinicController clinicController = new ClinicController();
                    clinicController.list(isAdmin);
                    break;
                default:
                    println("Please Choose a valid option ");
                    showMainMenu(isAdmin);
            }
        }
    }
}