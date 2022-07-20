package com.example.station.repository.jpa;

import com.example.station.view.AgencyPhone;
import com.example.station.view.AgencyPhoneId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgencyPhoneRepository extends JpaRepository<AgencyPhone, AgencyPhoneId> {
    @Query(value = "SELECT DISTINCT ON (ime_agencija) * FROM stanica.relacija_agencii_tel where id_relacija = :id", nativeQuery = true)
    List<AgencyPhone> findAgenciesByRelationId(Long id);
}
