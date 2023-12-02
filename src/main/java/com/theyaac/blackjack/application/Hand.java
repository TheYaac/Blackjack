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

    public void displayPlayer() {
        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println("Score: " + getScore());
        System.out.println();
    }

    public void displayDealer() {
        System.out.println(cards.get(0));
        System.out.println();
    }

    public boolean isBust() {
        return getScore() > 21;
    }
}