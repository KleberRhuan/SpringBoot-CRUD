package io.github.kleberrhuan.restapi.enums;

public enum DoctorSpeciality {
    ORTOPEDIA(1),
    CARDIOLOGIA(2),
    GINECOLOGIA(3),
    DERMATOLOGIA(4);

    private final int value;

    private DoctorSpeciality(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DoctorSpeciality fromValue(int value) {
        for (DoctorSpeciality speciality : DoctorSpeciality.values()) {
            if (speciality.getValue() == value) {
                return speciality;
            }
        }
        throw new IllegalArgumentException("Invalid speciality value: " + value);
    }

    public static DoctorSpeciality fromName(String name) {
        for (DoctorSpeciality speciality : DoctorSpeciality.values()) {
            if (speciality.name().equals(name)) {
                return speciality;
            }
        }
        throw new IllegalArgumentException("Invalid speciality name: " + name);
    }


}
