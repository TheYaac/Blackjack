package com.theyaac.blackjack.application.hand;

import java.util.List;

public class Hand {
    private List<String> cards;
    private boolean hit;
    private boolean stay;
    private int value;

    public Hand() {
    }

    public Hand(List<String> cards, boolean hit, boolean stay, int value) {
        this.cards = cards;
        this.hit = hit;
        this.stay = stay;
        this.value = value;
    }

    public Hand(List<String> cards, boolean hit, boolean stay) {
        this.cards = cards;
        this.hit = hit;
        this.stay = stay;
    }

    public List<String> getCards() {
        return cards;
    }

    public boolean isHit() {
        return hit;
    }

    public boolean isStay() {
        return stay;
    }

    public int getValue() {
        return value;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setStay(boolean stay) {
        this.stay = stay;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
