package com.nova.hospital.controller;

import com.nova.hospital.model.Doctor;

import java.util.*;

import static com.nova.hospital.database.AppointmentDataBase.saveAppointment;
import static com.nova.hospital.database.ClinicDataBase.clinics;
import static com.nova.hospital.view.AbstractView.*;
import static com.nova.hospital.view.AdminView.showAdminOptions;
import static com.nova.hospital.view.DoctorView.showDoctorOptionsForAdmin;
import static com.nova.hospital.view.DoctorView.showDoctorOptionsForUsers;

/**
 * @author bingolalii
 */
public class DoctorController extends MainAbstractController {

    private static final String[] headers = new String[]{"DOCTOR ID", "DOCTOR NAME"};

    public void listDoctors(int index, boolean isAdmin) {
        List<Doctor> doctors = new ArrayList<>();

        if (isAdmin) {
            doctors = sortDoctors(index);
        } else {
            doctors = Arrays.stream(clinics[index - 1].getDoctors()).toList();
        }

        String[][] data = new String[doctors.size()][2];

        println(":: LIST DOCTORS ::");
        printTableHeader(headers);

        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            int rowId = i + 1;
            String[] rowData = new String[2];
            rowData[0] = String.valueOf(rowId);
            rowData[1] = doctor.getName();
            data[i] = rowData;
        }

        printTableData(data);
        operation(doctors, isAdmin, index);
    }

    public void operation(List<Doctor> doctors, boolean isAdmin, int index) {

        if (Boolean.TRUE.equals(isAdmin)) {
            showDoctorOptionsForAdmin();
        } else {
            showDoctorOptionsForUsers();
        }

        int option = learnOptionFromUser();

        if (Objects.equals(option, 0)) {
            logout();
        } else if (Objects.equals(option, 1)) {
            createAppointment(doctors);
        } else if (Boolean.TRUE.equals(isAdmin) && Objects.equals(option, 2)) {
            listDoctors(index, isAdmin);
        } else if (Boolean.TRUE.equals(isAdmin) && Objects.equals(option, 3)) {
            showAdminOptions();
        } else if (Boolean.FALSE.equals(isAdmin) && Objects.equals(option, 2)) {
            showAdminOptions();
        } else {
            print("Please Choose a valid option ");
            operation(doctors, isAdmin, index);
        }
    }

    private void createAppointment(List<Doctor> doctors) {
        Scanner scan = scanner();
        println("\nPlease enter your doctor id : ");
        int doctorId = scanner().nextInt() - 1;
        println("Please enter appointment date that you want (example:12.12.2022)");
        String appointmentDate = scan.next();
        println("Please enter appointment time that you want (example:09:00)");
        String appointmentTime = scan.next();
        String message = saveAppointment(doctors.get(doctorId), appointmentDate, appointmentTime);
        println(message);
    }

    public static List<Doctor> sortDoctors(int index) {
        return Arrays
                .stream(clinics[index - 1].getDoctors())
                .sorted((o1, o2) -> {
                    if (o1.getAppointments().length != o2.getAppointments().length) {
                        return o1.getAppointments().length - o2.getAppointments().length;
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                })
                .toList();
    }
}
