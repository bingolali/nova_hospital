package com.nova.hospital.model;

/**
 * @author bingolalii
 */
public class Clinic {

    private Integer clinicId;
    private String clinicName;
    private Doctor[] doctors;

    public Clinic(Integer clinicId, String clinicName, Doctor[] doctors) {
        this.clinicId = clinicId;
        this.clinicName = clinicName;
        this.doctors = doctors;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

}
