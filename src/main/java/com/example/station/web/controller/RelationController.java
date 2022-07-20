package com.example.station.web.controller;

import com.example.station.service.CardService;
import com.example.station.service.RelationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/relations")
public class RelationController {
    private final RelationService relationService;
    private final CardService cardService;

    public RelationController(RelationService relationService, CardService cardService) {
        this.relationService = relationService;
        this.cardService = cardService;
    }

    @GetMapping
    public String getRelationListPage(Model model) {
        model.addAttribute("relations", relationService.filterRelations(LocalDateTime.now().toString(),"","",""));
        model.addAttribute("date", LocalDateTime.now().toLocalDate().toString());
        model.addAttribute("bodyContent", "relation-list");
        return "master-template";
    }

    @PostMapping
    public String postRelationListPage(@RequestParam Date date, @RequestParam String from, @RequestParam String to, @RequestParam String agency, Model model){
        model.addAttribute("relations", relationService.filterRelations(date.toString(),from,to,agency));
        model.addAttribute("date",date);
        model.addAttribute("from",from);
        model.addAttribute("to",to);
        model.addAttribute("agency",agency);
        model.addAttribute("bodyContent", "relation-list");
        return "master-template";
    }


    @GetMapping("/{id}")
    public String getRelationDetailsPage(@PathVariable Long id, Model model){
        model.addAttribute("bodyContent", "relation-details");
        model.addAttribute("relationThroughs", relationService.findRelationThroughsByRelationId(id));
        model.addAttribute("agencyPhones", relationService.findRelationAgencyPhones(id));
        model.addAttribute("driverPhones", relationService.findRelationDriverPhones(id));
        model.addAttribute("fromCity", null);
        model.addAttribute("toCity", null);
        return "master-template";
    }

    @PostMapping("/{id}")
    public String postRelationDetailsPage(@PathVariable int id, @RequestParam String fromCity, @RequestParam String toCity, @RequestParam String agency, HttpServletRequest servletRequest) {
        cardService.buyCard(servletRequest.getRemoteUser(), fromCity, toCity, id, agency);

        return "redirect:/cards";
    }

    @GetMapping("/access_denied")
    public String getAccessDeniedPage(Model model) {
        model.addAttribute("bodyContent", "access_denied");
        return "master-template";
    }

}
