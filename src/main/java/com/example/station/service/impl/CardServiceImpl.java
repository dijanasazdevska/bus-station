package com.example.station.service.impl;

import com.example.station.repository.jpa.CardRepository;
import com.example.station.repository.jpa.RelationThroughRepository;
import com.example.station.service.CardService;
import com.example.station.view.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final RelationThroughRepository relationThroughRepository;

    public CardServiceImpl(CardRepository cardRepository, RelationThroughRepository relationThroughRepository) {
        this.cardRepository = cardRepository;
        this.relationThroughRepository = relationThroughRepository;
    }

    @Override
    public void buyCard(String userId, String fromCity, String toCity, int relationId, String agency) {

            cardRepository.buyCard(userId, fromCity, toCity, relationId, agency);

        }

    @Override
    public List<Card> filterCards(String username, String date, String fromCity, String toCity) {
        List<Card> cards = cardRepository.filterCards(username ,date, fromCity, toCity);
        cards.forEach(c -> c.setRelationThroughs(relationThroughRepository.findRelationThroughs(Math.toIntExact(c.getRelationId()),c.getFromCity(),c.getToCity())));
        return cards;
    }
}
