package com.example.station.view;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name="karti_lista", schema = "stanica")
public class Card {

    @Id
    @Column(name = "id_karta")
    private Long cardId;

    @Column(name = "patnik_embg")
    private Long userId;

    @Column(name="korisnichko_ime")
    private String username;

    @Column(name = "ime")
    private String name;

    @Column(name = "prezime")
    private String surname;

    @Column(name = "od_grad")
    private String fromCity;

    @Column(name = "od_zemja")
    private String fromCountry;

    @Column(name = "do_grad")
    private String toCity;

    @Column(name ="do_zemja")
    private String toCountry;

    @Column(name = "datum_na_trganje")
    private Timestamp departure;

    @Column(name = "datum_na_pristiganje")
    private Timestamp arrival;

    @Column(name = "cena")
    private int price;

    @Column(name = "br_peron")
    private int gate;

    @Column(name = "relacija_od")
    private String relationFromCity;

    @Column(name = "relacija_od_zemja")
    private String relationFromCountry;

    @Column(name = "relacija_do")
    private String relationToCity;

    @Column(name = "relacija_do_zemja")
    private String relationToCountry;

    @Column(name = "id_relacija")
    private Long relationId;

    @Transient
    private List<RelationThrough> relationThroughs;

}
