package com.example.station.view;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="relacija_agencii", schema="stanica")
public class AgencyPhone {
    @EmbeddedId
    private  AgencyPhoneId agencyPhoneId;

    @Column(name = "tel_broj")
    private String phone;

}
