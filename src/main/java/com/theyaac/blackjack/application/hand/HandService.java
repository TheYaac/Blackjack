package com.theyaac.blackjack.application.hand;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandService {
    public Hand getHand() {
        List<String> cards = List.of("","");
        return new Hand(cards, false, false, 0);
    }
}
