package com.nova.hospital.controller;

import static com.nova.hospital.view.AbstractView.*;
import static com.nova.hospital.view.UserView.showUserOptions;

/**
 * @author bingolalii
 */
public class UserController extends MainAbstractController implements MainController {

    @Override
    public void showMainMenu(boolean isAdmin) {
        if (login()) {
            showUserOptions();
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
                    print("Please Choose a valid option ");
                    showMainMenu(isAdmin);
            }
        }
    }
}
