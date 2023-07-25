package io.github.kleberrhuan.restapi.entities;

import io.github.kleberrhuan.restapi.records.client.ClientData;
import io.github.kleberrhuan.restapi.records.client.ClientPutData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clients")
@Entity(name = "Client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @Embedded
    private Address address;
    @NotNull
    private boolean inactive;

    public Client(ClientData client) {
        this.name = client.name();
        this.email = client.email();
        this.phone = client.phone();
        this.address = new Address(client.addressData());
        this.inactive = false;
    }

    public void update(ClientPutData putData) {
        if(putData.name() != null) this.name = putData.name();
        if(putData.phone() != null) this.phone = putData.phone();
        if(putData.addressData() != null) this.address.update(putData.addressData());
    }

    public void delete() {
        this.inactive = true;
    }

}
