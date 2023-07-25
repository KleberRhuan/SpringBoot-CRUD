package io.github.kleberrhuan.restapi.records.doctor;

import io.github.kleberrhuan.restapi.records.AddressData;
import jakarta.validation.constraints.NotNull;

public record DoctorPutData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData addressData) {


}
