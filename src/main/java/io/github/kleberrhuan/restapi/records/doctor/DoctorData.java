package io.github.kleberrhuan.restapi.records.doctor;

import io.github.kleberrhuan.restapi.enums.DoctorSpeciality;
import io.github.kleberrhuan.restapi.records.AddressData;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;



public record DoctorData(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        @Pattern(regexp = "\\d{11}")
        String phone,
        @NotNull
        DoctorSpeciality speciality,
        @NotNull
        @Valid
        AddressData addressData) {
}
