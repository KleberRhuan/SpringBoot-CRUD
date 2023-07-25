package io.github.kleberrhuan.restapi.records.client;


import io.github.kleberrhuan.restapi.records.AddressData;

public record ClientData(String name, String email, String phone, AddressData addressData) {

}
