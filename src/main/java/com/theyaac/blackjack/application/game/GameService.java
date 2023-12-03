package com.theyaac.blackjack.application.game;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    public String startGame() {
        Game game21 = new Game();
        game21.startGame();
        return game21.getResponse();
    }
}
