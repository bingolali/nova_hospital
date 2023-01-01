package com.nova.hospital.main;

import static com.nova.hospital.view.AbstractView.learnOptionFromUser;
import static com.nova.hospital.view.StartView.showApplicationEntryOptions;
import static com.nova.hospital.view.StartView.showBanner;

import com.nova.hospital.controller.AdminController;
import com.nova.hospital.controller.UserController;

/**
 * @author bingolalii
 */
public class NovaApp {

    public static void main(String[] args) {
        showBanner();

        NovaApp novaApp = new NovaApp();
        novaApp.manage();

    }

    private void manage() {
        showApplicationEntryOptions();
        int mode = learnOptionFromUser();

        switch (mode) {
            case 1:
                startAdminMode();
                break;
            case 2:
                startUserMode();
                break;
            default:
                System.out.println("Please Choose a valid option ");
                manage();
        }
    }

    private void startAdminMode() {
        AdminController adminController = new AdminController();
        adminController.showMainMenu(Boolean.TRUE);
    }

    private void startUserMode() {
        UserController userController = new UserController();
        userController.showMainMenu(Boolean.FALSE);
    }

}
