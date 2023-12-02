package com.theyaac.blackjack.application;

import java.util.ArrayList;
import java.util.List;
public class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = 0;
        int numAces = 0;

        for (Card card : cards) {
            score += card.getValue();
            if (card.getRank().equals("A")) {
                numAces++;
            }
        }

        while (numAces > 0 && score > 21) {
            score -= 10;
            numAces--;
        }

        return score;
    }

    public String displayPlayer() {
        String response = "";
        for (Card card : cards) {
            response += card + "\n";
        }
        response += "Current Highest Score: " + getScore() + "\n\n";
        return response;
    }

    public String displayDealer() {
        return cards.get(0) + "\n\n";
    }

    public boolean isBust() {
        return getScore() > 21;
    }
}