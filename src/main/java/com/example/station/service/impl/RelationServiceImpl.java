package com.example.station.service.impl;

import com.example.station.repository.jpa.AgencyPhoneRepository;
import com.example.station.repository.jpa.DriverPhoneRepository;
import com.example.station.repository.jpa.RelationRepository;
import com.example.station.repository.jpa.RelationThroughRepository;
import com.example.station.service.RelationService;
import com.example.station.view.AgencyPhone;
import com.example.station.view.DriverPhone;
import com.example.station.view.Relation;
import com.example.station.view.RelationThrough;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RelationServiceImpl implements RelationService {

    private final RelationRepository relationRepository;
    private final RelationThroughRepository relationThroughRepository;
    private final AgencyPhoneRepository agencyPhoneRepository;
    private final DriverPhoneRepository driverPhoneRepository;


    public RelationServiceImpl(RelationRepository relationRepository, RelationThroughRepository relationThroughRepository, AgencyPhoneRepository agencyPhoneRepository, DriverPhoneRepository driverPhoneRepository) {
        this.relationRepository = relationRepository;
        this.relationThroughRepository = relationThroughRepository;
        this.agencyPhoneRepository = agencyPhoneRepository;
        this.driverPhoneRepository = driverPhoneRepository;
    }

    @Override
    public List<Relation> filterRelations(String date, String from_city, String to_city, String agency) {
        return relationRepository.filterRelations(date,from_city,to_city,agency);
    }
    @Override
    public List<RelationThrough> findRelationThroughsByRelationId(Long id) {
        return relationThroughRepository.findRelationThroughsByRelationId(id);
    }

    @Override
    public List<RelationThrough> findRelationThroughs(int id, String fromCity, String toCity) {
        return relationThroughRepository.findRelationThroughs(id, fromCity, toCity);
    }

    @Override
    public List<AgencyPhone> findRelationAgencyPhones(Long id) {
        return agencyPhoneRepository.findAgenciesByRelationId(id);
    }

    @Override
    public List<DriverPhone> findRelationDriverPhones(Long id) {
        return driverPhoneRepository.findDriverPhonesById(id);
    }


}
