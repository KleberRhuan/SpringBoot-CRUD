package io.github.kleberrhuan.restapi.entities;

import io.github.kleberrhuan.restapi.records.AddressData;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

        private String street;
        private String number;
        private String complement;
        private String neighborhood;
        private String city;
        private String state;
        private String zipcode;

        public Address(AddressData address){
                this.street = address.street();
                this.number = address.number();
                this.complement = address.complement();
                this.neighborhood = address.neighborhood();
                this.city = address.city();
                this.state = address.state();
                this.zipcode = address.zipcode();
        }

        public void update(AddressData data) {
               if(data.street() != null) this.street = data.street();
               if(data.number() != null )this.number = data.number();
               if(data.complement() != null)this.complement = data.complement();
               if(data.neighborhood() != null) this.neighborhood = data.neighborhood();
               if(data.city() != null) this.city = data.city();
               if(data.state() != null) this.state = data.state();
               if(data.zipcode() != null) this.zipcode = data.zipcode();
        }
}
