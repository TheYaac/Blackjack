package com.theyaac.blackjack.application.game;

import com.theyaac.blackjack.application.Deck;
import com.theyaac.blackjack.application.Hand;

import java.util.Scanner;

public class Game {

    private Deck deck;
    private final Hand playerHand;
    private final Hand dealerHand;

    private String response;

    private boolean ongoing;

    private int playerChoice;

    public Game() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        response = "";
        ongoing = false;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getResponse() {
        return response;
    }

    public void startGame() {
        ongoing = true;
        deck = new Deck();
        deck.shuffle();
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        response += "Welcome to Blackjack!\n";
        displayHands();

        while (ongoing) {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            playerTurn(choice);

            if (playerHand.isBust()) {
                System.out.println("Bust! You lose.");
                ongoing = false;
                break;
            }

            dealerTurn();

            displayHands();

            if (dealerHand.isBust() || playerHand.getScore() > dealerHand.getScore()) {
                System.out.println("You win!");
                ongoing = false;
            } else if (playerHand.getScore() < dealerHand.getScore()) {
                System.out.println("You lose.");
                ongoing = false;
            } else {
                System.out.println("It's a tie! Dealer wins the house.");
                ongoing = false;
            }
            break;
        }
    }

    public void playerTurn(int choice) {

        while (true) {
            System.out.println("1. Hit");
            System.out.println("2. Stay");

            if (choice == 1) {
                playerHand.addCard(deck.drawCard());
                System.out.println("You hit");
                displayHands();
                if (playerHand.isBust()) {
                    break;
                }
            } else if (choice == 2) {
                System.out.println("You stay");
                displayHands();
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }

    public void dealerTurn() {
        while (dealerHand.getScore() < 17) {
            dealerHand.addCard(deck.drawCard());
        }
    }

    public void displayHands() {
        response += "Your hand:\n";
        response += playerHand.displayPlayer();

        response += "Dealer's hand:\n";
        response += dealerHand.displayDealer();

    }
}
