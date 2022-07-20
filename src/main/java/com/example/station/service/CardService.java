package com.example.station.service;

import com.example.station.view.Card;
import org.postgresql.util.PSQLException;

import java.util.List;
import java.util.Optional;

public interface CardService {
    void buyCard(String userId,String fromCity, String toCity, int relationId, String agency);
    List<Card> filterCards(String username, String date, String fromCity, String toCity);
}
