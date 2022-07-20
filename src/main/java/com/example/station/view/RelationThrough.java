package com.example.station.view;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="relacii_preku", schema="stanica")
public class RelationThrough implements Serializable {
    @EmbeddedId
    private  RelationThroughId relationThroughId;

    @Column(name = "id_grad")
    private Long city_Id;

    @Column(name="ime")
    private String city;

    @Column(name="zemja")
    private String country;

    @Column(name="redosled")
    private int order;

    @Column(name="datum_na_trganje")
    private Timestamp departure;

    @Column(name ="br_peron")
    private int gate;

    @Column(name ="km")
    private int kilometres;

    @Column(name ="lat")
    private float latitude;

    @Column(name ="long")
    private float longitude;




}
