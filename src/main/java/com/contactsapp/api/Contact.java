package com.contactsapp.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.jackson.JsonSnakeCase;

@JsonSnakeCase
public class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String postCode;
    private String city;
    private String phoneNumber;

    @JsonCreator
    public Contact(
        @JsonProperty String firstName,
        @JsonProperty String lastName,
        @JsonProperty String address,
        @JsonProperty String postCode,
        @JsonProperty String city,
        @JsonProperty String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    @JsonProperty
    public String getAddress() {
        return address;
    }

    @JsonProperty
    public String getPostCode() {
        return postCode;
    }

    @JsonProperty
    public String getCity() {
        return city;
    }

    @JsonProperty
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
