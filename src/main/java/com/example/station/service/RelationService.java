package com.example.station.service;

import com.example.station.view.AgencyPhone;
import com.example.station.view.DriverPhone;
import com.example.station.view.Relation;
import com.example.station.view.RelationThrough;

import java.util.List;
import java.util.Optional;

public interface RelationService {
     List<Relation> filterRelations(String date, String from_city, String to_city, String agency);

    List<RelationThrough> findRelationThroughsByRelationId(Long id);

    List<RelationThrough> findRelationThroughs(int id, String fromCity, String toCity);

    List<AgencyPhone> findRelationAgencyPhones(Long id);

    List<DriverPhone> findRelationDriverPhones(Long id);
}
