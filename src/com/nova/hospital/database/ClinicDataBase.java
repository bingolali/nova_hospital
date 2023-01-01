package com.nova.hospital.database;

import com.nova.hospital.model.*;

import java.time.LocalTime;

/**
 * @author bingolalii
 */
public class ClinicDataBase {

    private static final String TEN = "10:00";
    private static final String NINE = "09:00";
    private static final String EIGHT = "08:00";
    private static final String ELEVEN = "11:00";
    private static final String SIXTEEN = "16:00";
    private static final String FIFTEEN = "15:00";
    private static final String THIRTEEN = "13:00";
    private static final String FOURTEEN = "14:00";
    private static final String USER_TYPE = "doctor";

    public static Clinic[] clinics = new Clinic[]{

            new Clinic(1, "Dermatology", new Doctor[]{
                    new Doctor("Seher Bal", "123", USER_TYPE, new Appointment[]{
                            new Appointment(LocalTime.parse(EIGHT)),
                            new Appointment(LocalTime.parse(NINE)),
                            new Appointment(LocalTime.parse(TEN)),
                            new Appointment(LocalTime.parse(THIRTEEN)),
                            new Appointment(LocalTime.parse(FOURTEEN)),
                            new Appointment(LocalTime.parse(FIFTEEN)),
                    }, false, false)
            }),
            new Clinic(2, "Otorhinolaryngology", new Doctor[]{
                    new Doctor("Busra Soylu", "123", USER_TYPE, new Appointment[]{
                            new Appointment(LocalTime.parse(NINE)),
                            new Appointment(LocalTime.parse(TEN)),
                            new Appointment(LocalTime.parse(ELEVEN)),
                            new Appointment(LocalTime.parse(THIRTEEN)),
                            new Appointment(LocalTime.parse(FOURTEEN)),
                            new Appointment(LocalTime.parse(SIXTEEN)),
                    }, false, false),
                    new Doctor("Hatice Keser", "123", USER_TYPE, new Appointment[]{
                            new Appointment(LocalTime.parse(EIGHT)),
                            new Appointment(LocalTime.parse(NINE)),
                            new Appointment(LocalTime.parse(ELEVEN)),
                            new Appointment(LocalTime.parse(FIFTEEN)),
                            new Appointment(LocalTime.parse(SIXTEEN)),
                    }, false, false)

            }),
            new Clinic(3, "Internal Medicine", new Doctor[]{
                    new Doctor("Kemal Cetin", "123", USER_TYPE, new Appointment[]{
                            new Appointment(LocalTime.parse(THIRTEEN)),
                            new Appointment(LocalTime.parse(FOURTEEN)),
                            new Appointment(LocalTime.parse(FIFTEEN)),
                            new Appointment(LocalTime.parse(SIXTEEN)),
                    }, true, false),
                    new Doctor("Fatih Mehmet İris", "123", USER_TYPE, new Appointment[]{
                            new Appointment(LocalTime.parse(THIRTEEN)),
                            new Appointment(LocalTime.parse(FOURTEEN)),
                            new Appointment(LocalTime.parse(FIFTEEN)),
                            new Appointment(LocalTime.parse(SIXTEEN)),
                    }, true, false),
                    new Doctor("Betul Birce", "123", USER_TYPE, new Appointment[]{
                            new Appointment(LocalTime.parse(TEN)),
                            new Appointment(LocalTime.parse(ELEVEN)),
                            new Appointment(LocalTime.parse(THIRTEEN)),
                            new Appointment(LocalTime.parse(FOURTEEN)),
                            new Appointment(LocalTime.parse(FIFTEEN)),
                            new Appointment(LocalTime.parse(SIXTEEN)),
                    }, false, false)
            }),
            new Clinic(4, "Pediatrics", new Doctor[]{
                    new Doctor("Kaan Kalem", "123", USER_TYPE, new Appointment[]{
                            new Appointment(LocalTime.parse(EIGHT)),
                            new Appointment(LocalTime.parse(NINE)),
                            new Appointment(LocalTime.parse(ELEVEN)),
                            new Appointment(LocalTime.parse(THIRTEEN)),
                            new Appointment(LocalTime.parse(SIXTEEN)),
                    }, false, false)
            }),
            new Clinic(5, "Orthopedics and Traumatology", new Doctor[]{
                    new Doctor("Kemal Unlu", "123", USER_TYPE, new Appointment[]{
                            new Appointment(LocalTime.parse(EIGHT)),
                            new Appointment(LocalTime.parse(NINE)),
                            new Appointment(LocalTime.parse(TEN)),
                            new Appointment(LocalTime.parse(ELEVEN)),
                            new Appointment(LocalTime.parse(THIRTEEN)),
                    }, false, false)
            }),
    };
}
