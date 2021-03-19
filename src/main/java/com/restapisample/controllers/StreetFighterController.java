package com.restapisample.controllers;

import com.restapisample.usecase.GetAllFighters;
import com.restapisample.usecase.GetCurrentPosition;
import com.restapisample.usecase.GetMove;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StreetFighterController {

    private final GetCurrentPosition getCurrentPosition;
    private final GetAllFighters getAllFighters;
    private final GetMove getMove;

    @GetMapping("/street-fighter/current-position")
    public GetCurrentPosition.Response getCurrentPosition() {
        return getCurrentPosition.execute();
    }

    @GetMapping("/street-fighter/all-fighters")
    public GetAllFighters.Response getAllFilters() {
        return getAllFighters.execute();
    }

    @GetMapping("/street-fighter/move/{move}")
    public GetMove.Response getMove(@PathVariable String move) {
        return getMove.execute(move);
    }

}
