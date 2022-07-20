package com.example.station.repository.jpa;

import com.example.station.view.RelationThrough;
import com.example.station.view.RelationThroughId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationThroughRepository  extends JpaRepository<RelationThrough, RelationThroughId> {

    @Query(value = "SELECT * FROM stanica.relacii_preku where id_relacija = :id", nativeQuery = true)
    List<RelationThrough> findRelationThroughsByRelationId(Long id);


    @Query(value ="SELECT * FROM stanica.prikaz_relacija_preku(:id, :fromCity, :toCity);", nativeQuery = true)
    List<RelationThrough> findRelationThroughs(int id, String fromCity, String toCity );

}
