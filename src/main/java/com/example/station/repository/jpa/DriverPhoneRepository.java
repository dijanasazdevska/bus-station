package com.example.station.repository.jpa;

import com.example.station.view.DriverPhone;
import com.example.station.view.DriverPhoneId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverPhoneRepository extends JpaRepository<DriverPhone, DriverPhoneId> {

    @Query(value = "SELECT DISTINCT ON (ime, prezime) * FROM stanica.relacija_vozachi_tel where id_relacija = :id", nativeQuery = true)
    List<DriverPhone> findDriverPhonesById(Long id);
}
