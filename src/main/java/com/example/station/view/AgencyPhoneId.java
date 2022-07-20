package com.example.station.view;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Embeddable
public class AgencyPhoneId implements Serializable {

    @Column(name = "id_relacija")
    private Long relationId;

    @Column(name = "ime_agencija")
    private String agency;
}
