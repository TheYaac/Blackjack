package com.theyaac.blackjack.application.hand;

import com.theyaac.blackjack.application.Hand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/hand")
public class HandsController {

    @PostMapping
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Hand startGame() {
        return new Hand();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Hand hit(Hand hand) {
        return Hand.hit(hand);
    }


}
