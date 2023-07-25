package io.github.kleberrhuan.restapi.records.client;

import io.github.kleberrhuan.restapi.records.AddressData;
import jakarta.validation.constraints.NotNull;

public record ClientPutData(
        @NotNull
        Long id,
        String name,
        String phone,
        AddressData addressData) {

}
