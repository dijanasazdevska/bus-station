package com.example.station.view;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="relacii_lista", schema = "stanica")
public class Relation {
    @Id
    @Column(name="id_relacija")
    private Long Id;

    @Column(name = "od_grad")
    private String fromCity;

    @Column(name = "od_zemja")
    private String fromCountry;

    @Column(name = "do_grad")
    private String toCity;

    @Column(name = "do_zemja")
    private String toCountry;

    @Column(name = "datum_na_trganje")
    private Timestamp departure;

    @Column(name = "datum_na_pristiganje")
    private Timestamp arrival;

    @Column(name = "km")
    private int kilometers;
}
