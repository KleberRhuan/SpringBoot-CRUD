package io.github.kleberrhuan.restapi.records.doctor;

import io.github.kleberrhuan.restapi.entities.Doctor;
import io.github.kleberrhuan.restapi.enums.DoctorSpeciality;

public record DoctorListData(
        long id,
        String name,
        String email,
        String crm,
        DoctorSpeciality speciality
) {
    public DoctorListData(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
    }
}
