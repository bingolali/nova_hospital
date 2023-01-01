package com.nova.hospital.model;

/**
 * @author bingolalii
 */
public class Doctor extends User {

    private Appointment[] appointments;
    private boolean restrictAMHours;
    private boolean restrictPMHours;

    public Doctor(String name, String pwd, String type, Appointment[] appointments, boolean restrictAMHours, boolean restrictPMHours) {
        super(name, pwd, type);
        this.appointments = appointments;
        this.restrictAMHours = restrictAMHours;
        this.restrictPMHours = restrictPMHours;
    }

    public Doctor(String name, String pwd, Appointment[] appointments, boolean restrictAMHours, boolean restrictPMHours) {
        super(name, pwd);
        this.appointments = appointments;
        this.restrictAMHours = restrictAMHours;
        this.restrictPMHours = restrictPMHours;
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment[] appointments) {
        this.appointments = appointments;
    }

    public boolean isRestrictAMHours() {
        return restrictAMHours;
    }

    public void setRestrictAMHours(boolean restrictAMHours) {
        this.restrictAMHours = restrictAMHours;
    }

    public boolean isRestrictPMHours() {
        return restrictPMHours;
    }

    public void setRestrictPMHours(boolean restrictPMHours) {
        this.restrictPMHours = restrictPMHours;
    }
}
