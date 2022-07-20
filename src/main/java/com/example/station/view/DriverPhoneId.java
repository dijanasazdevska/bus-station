package com.example.station.view;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Data
@Embeddable
public class DriverPhoneId implements Serializable {
    @Column(name = "id_relacija")
    private Long relationId;

    @Column(name = "ime")
    private String name;

    @Column(name = "prezime")
    private String surname;
}
