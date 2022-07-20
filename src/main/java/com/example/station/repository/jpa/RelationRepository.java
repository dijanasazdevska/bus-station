package com.example.station.repository.jpa;

import com.example.station.view.AgencyPhone;
import com.example.station.view.Relation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {
    @Query(value = "SELECT  * FROM filter_na_relacii(:date, :from_city, :to_city, :agency)", nativeQuery = true)
    List<Relation> filterRelations(String date, String from_city, String to_city, String agency);

}
