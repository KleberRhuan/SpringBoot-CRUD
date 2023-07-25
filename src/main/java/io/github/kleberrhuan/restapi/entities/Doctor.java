package io.github.kleberrhuan.restapi.entities;

import io.github.kleberrhuan.restapi.records.doctor.DoctorData;
import io.github.kleberrhuan.restapi.enums.DoctorSpeciality;
import io.github.kleberrhuan.restapi.records.doctor.DoctorPutData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Email;
    private String crm;
    private String phone;
    @Enumerated(EnumType.STRING)
    private DoctorSpeciality speciality;
    @Embedded
    private Address address;
    @NotNull
    private boolean inactive;

    public Doctor(DoctorData doctor) {
        this.name = doctor.name();
        this.Email = doctor.email();
        this.crm = doctor.crm();
        this.phone = doctor.phone();
        this.speciality = doctor.speciality();
        this.address = new Address(doctor.addressData());
        this.inactive = false;
    }

    public void  update(DoctorPutData putData) {
        if(putData.name() != null) this.name = putData.name();
        if(putData.phone() != null) this.phone = putData.phone();
        if(putData.addressData() != null) this.address.update(putData.addressData());
    }

    public void delete() {
        this.inactive = true;
    }
}
