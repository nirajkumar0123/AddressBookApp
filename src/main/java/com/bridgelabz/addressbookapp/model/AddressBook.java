package com.bridgelabz.addressbookapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
//
//    public AddressBook(String name, String address, String phoneNumber) {
//        this.name = name;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//    }
}
