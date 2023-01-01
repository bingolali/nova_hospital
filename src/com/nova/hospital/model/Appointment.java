package com.nova.hospital.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author bingolalii
 */
public class Appointment {

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final String DATE_OF_APP = "06.12.2022";

    public Appointment( LocalTime appointmentTime) {
        this.appointmentDate = LocalDate.parse(DATE_OF_APP, formatter);
        this.appointmentTime = appointmentTime;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
