package com.nova.hospital.controller;

import com.nova.hospital.model.Clinic;

import java.util.Objects;

import static com.nova.hospital.database.ClinicDataBase.clinics;
import static com.nova.hospital.view.AbstractView.*;
import static com.nova.hospital.view.ClinicView.showClinicOptions;

/**
 * @author bingolalii
 */
public class ClinicController extends MainAbstractController {

    private static final String[] headers = new String[]{"CLINIC ID", "CLINIC NAME"};


    public void list(boolean isAdmin) {

        String[][] data = new String[clinics.length][2];

        println(":: LIST CLINICS ::");
        printTableHeader(headers);

        for (int i = 0; i < clinics.length; i++) {
            Clinic clinic = clinics[i];
            int rowId = i + 1;
            String[] rowData = new String[2];
            rowData[0] = String.valueOf(rowId);
            rowData[1] = clinic.getClinicName();
            data[i] = rowData;
        }
        printTableData(data);
        operation(isAdmin);
    }

    public void operation(boolean isAdmin) {
        showClinicOptions();
        int option = learnOptionFromUser();

        if (option == 0) {
            logout();
        } else if (isBetween(option, 1, 5)) {
            DoctorController doctorController = new DoctorController();
            doctorController.listDoctors(option, isAdmin);
        } else if (option == 6) {
            roleBasedMainMenuManagement();
        } else {
            print("Please Choose a valid option ");
            operation(isAdmin);
        }
    }

    public void roleBasedMainMenuManagement() {
        if (Objects.nonNull(loggedInUser) && Objects.equals(loggedInUser.getType(), "admin")) {
            AdminController adminController = new AdminController();
            adminController.showMainMenu(Boolean.TRUE);
        } else {
            UserController userController = new UserController();
            userController.showMainMenu(Boolean.FALSE);
        }
    }

    private static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
