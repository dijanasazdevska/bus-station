package com.example.station.repository.jpa;

import com.example.station.view.Card;
import org.postgresql.util.PSQLException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Transactional
    @Modifying
    @Query(value = "call kupi_karta(:korisnichko, :od_g, :do_g, :id_relacija, :ag);", nativeQuery = true)
    void buyCard(@Param("korisnichko")String userId, @Param("od_g") String fromCity,@Param("do_g") String toCity,@Param("id_relacija") int relationId, @Param("ag") String agency);
    @Query(value = "SELECT * FROM filter_na_karti(:userId, :date, :fromCity, :toCity);",nativeQuery = true)
    List<Card> filterCards(String userId, String date, String fromCity, String toCity);
}
