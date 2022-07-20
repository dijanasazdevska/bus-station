package com.example.station.view;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class DriverPhone {
    @EmbeddedId
    private  DriverPhoneId driverPhoneId;

    @Column(name = "tel_broj")
    private String phone;

}
