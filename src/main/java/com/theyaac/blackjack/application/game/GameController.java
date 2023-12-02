package com.theyaac.blackjack.application.game;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/game")
public class GameController {
    Game game21;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String startGame() {
        game21 = new Game();
        game21.startGame();
        return game21.getResponse();
    }

    @GetMapping("/hitPlayer")
    @ResponseStatus(HttpStatus.OK)
    public void hitPlayer() {
        game21.playerTurn();
    }

    @GetMapping("/hitDealer")
    @ResponseStatus(HttpStatus.OK)
    public void hitDealer() {
        game21.playerTurn();
    }

}