package com.theyaac.blackjack.application.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/game")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    Game game21;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String startGame() {
        return gameService.startGame();
    }

    @GetMapping("/hitPlayer")
    @ResponseStatus(HttpStatus.OK)
    public void playerTurn(int choice) {
        game21.playerTurn(choice);
    }

    @GetMapping("/hitDealer")
    @ResponseStatus(HttpStatus.OK)
    public void dealerTurn() {
        game21.dealerTurn();
    }

}