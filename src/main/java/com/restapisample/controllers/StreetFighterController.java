package com.restapisample.controllers;

import com.restapisample.usecase.GetCurrentPosition;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StreetFighterController {

    GetCurrentPosition getCurrentPosition;

    @GetMapping("/street-fighter/current-position")
    public GetCurrentPosition.Response getAllStudents() {
        return getCurrentPosition.execute();
    }

    // TODO endpoint
//    street-fighter/all-fighters ()
//    street-fighter/move/("up"/"left"/"down"/"right")
}
