package com.smartsolutions.eshoponcontainersjava.orderingservice.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue
    private int addressId;

    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String country;
    private String zip;
}
