package com.theyaac.blackjack.application.game;

import com.theyaac.blackjack.application.Deck;
import com.theyaac.blackjack.application.Hand;

import java.util.Scanner;

class Game {
    private final Deck deck;
    private final Hand playerHand;
    private final Hand dealerHand;

    public Game() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
    }

    public void startGame() {
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        System.out.println("Welcome to Blackjack!");
        displayHands();

        while (true) {
            playerTurn();

            if (playerHand.isBust()) {
                System.out.println("Bust! You lose.");
                break;
            }

            dealerTurn();

            displayHands();

            if (dealerHand.isBust() || playerHand.getScore() > dealerHand.getScore()) {
                System.out.println("You win!");
            } else if (playerHand.getScore() < dealerHand.getScore()) {
                System.out.println("You lose.");
            } else {
                System.out.println("It's a tie!");
            }

            break;
        }
    }

    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Hit");
            System.out.println("2. Stay");

            int choice = scanner.nextInt();

            if (choice == 1) {
                playerHand.addCard(deck.drawCard());
                displayHands();
                if (playerHand.isBust()) {
                    break;
                }
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }

    private void dealerTurn() {
        while (dealerHand.getScore() < 17) {
            dealerHand.addCard(deck.drawCard());
        }
    }

    private void displayHands() {
        System.out.println("Your hand:");
        playerHand.displayPlayer();

        System.out.println("Dealer's hand:");
        dealerHand.displayDealer();
    }
}
