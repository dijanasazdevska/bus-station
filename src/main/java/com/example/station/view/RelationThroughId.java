package com.example.station.view;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class RelationThroughId implements Serializable {

    @Column(name = "id_relacija")
    private Long relation_Id;

    @Column(name="id_stanica")
    private Long station_Id;
}
