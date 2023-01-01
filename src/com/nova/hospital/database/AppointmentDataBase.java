package com.nova.hospital.database;

import com.nova.hospital.model.Appointment;
import com.nova.hospital.model.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author bingolalii
 */
public class AppointmentDataBase {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String saveAppointment(Doctor doctor, String appointmentDate, String appointmentTime) {

        Appointment newAppointment = new Appointment(LocalTime.parse(appointmentTime));
        newAppointment.setAppointmentDate(LocalDate.parse(appointmentDate, formatter));

        if(!isAvailable(doctor, newAppointment)){
            return "Doctor is busy at the date and time that want to make an appointment!";
        }

        return "Your appointment is created succesfully!";
    }

    public static boolean isAvailable(Doctor doctor, Appointment appointment) {

        if(!checkDays(appointment.getAppointmentDate())) {
            return false;
        }

        if(!checkTimeLimits(appointment.getAppointmentTime())) {
            return false;
        }

        if(!checkDoctorRestrictions(doctor,appointment)) {
            return false;
        }

        return checkDatabase(doctor.getAppointments(), appointment);
    }

    public static boolean checkDoctorRestrictions(Doctor doctor, Appointment newAppointment) {
        int startAppointmentHour = newAppointment.getAppointmentTime().getHour();

        if(doctor.isRestrictAMHours() && startAppointmentHour < 12) {
            return false;
        }

        return !doctor.isRestrictPMHours() || startAppointmentHour < 13;
    }

    public static boolean checkDatabase(Appointment[] currentAppointments, Appointment newAppointment) {
        // İstenilen tarihteki randevular çekilir
        List<Appointment> appointmentList = Arrays.stream(currentAppointments).filter(appointment ->
            Objects.equals(appointment.getAppointmentDate(),newAppointment.getAppointmentDate())
        ).toList();
        // O tarihte randevu yok ise true randevu var ise saatleri karşılaştırılır
        if(!appointmentList.isEmpty()) {
            //İstanilen saatte randevu var mı diye bakılır
            Optional<Appointment> currentAppointment = appointmentList.stream().filter(appointment ->
                    Objects.equals(appointment.getAppointmentTime(),newAppointment.getAppointmentTime())
            ).findFirst();
            //Eğer o saat için randevu var ise false çıkılır
            return currentAppointment.isEmpty();
        }

       return true;
    }

    public static boolean checkTimeLimits(LocalTime appointmentTime) {
        int endAppointmentHour = appointmentTime.getHour() + 1;
        int startAppointmentHour = appointmentTime.getHour();
        //Saat 8'den önce randevu olamaz
        if(startAppointmentHour < 8) {
            return false;
        }
        //Öğle arası randevu olamaz
        if(startAppointmentHour == 12 && endAppointmentHour == 13) {
            return false;
        }
        //Saat 5'den sonra randevu olamaz
        return endAppointmentHour <= 17;
    }

    public static boolean checkDays(LocalDate appointmentDay) {
        int appointmentDayValue = appointmentDay.getDayOfWeek().getValue();
        //Haftasonu randevu olamaz
        return appointmentDayValue != 6 && appointmentDayValue != 7;
    }
}
