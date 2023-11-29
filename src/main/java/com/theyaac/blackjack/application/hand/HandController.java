package com.theyaac.blackjack.application.hand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/hand")
public class HandController {

    private final HandService handService;

    @Autowired
    public HandController(HandService handService) {
        this.handService = handService;
    }

    @GetMapping
    public Hand getHand() {
        return handService.getHand();
    }
}
