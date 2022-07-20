package com.example.station.web.controller;

import com.example.station.service.CardService;
import com.example.station.service.RelationService;
import com.example.station.view.Card;
import com.example.station.view.RelationThrough;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;
    private final RelationService relationService;


    public CardController(CardService cardService, RelationService relationService) {
        this.cardService = cardService;
        this.relationService = relationService;
    }

    @GetMapping
    public String getCardsPage(Model model, HttpServletRequest request, @RequestParam(required = false) String error){
        model.addAttribute("date", LocalDateTime.now().toLocalDate().toString());
        model.addAttribute("bodyContent", "card-list");
        if(error == null){
            model.addAttribute("cards", cardService.filterCards(request.getRemoteUser(), LocalDateTime.now().toLocalDate().toString(), null, null));

        }
        else{
            model.addAttribute("cards", new ArrayList<>());

        }        return "master-template";
    }

    @PostMapping
    public String postCardListPage(@RequestParam Date date, @RequestParam String from, @RequestParam String to, Model model, @RequestParam(required = false) String error, HttpServletRequest request) {
        if(error == null){
            model.addAttribute("cards", cardService.filterCards(request.getRemoteUser(), date.toString(), from, to));

        }
        else{
            model.addAttribute("cards", new ArrayList<>());

        }
        model.addAttribute("date",date);
        model.addAttribute("from",from);
        model.addAttribute("to",to);
        model.addAttribute("bodyContent", "card-list");
        return "master-template";
    }
}
