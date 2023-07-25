package io.github.kleberrhuan.restapi.records.client;

import io.github.kleberrhuan.restapi.entities.Client;
import io.github.kleberrhuan.restapi.entities.Doctor;
import io.github.kleberrhuan.restapi.enums.DoctorSpeciality;

public record ClientListData(
        Long id,
        String name,
        String email
) {
    public ClientListData(Client client) {
        this(client.getId(), client.getName(), client.getEmail());
    }
}
