package com.restapisample.controllers;

import com.restapisample.usecase.GetCurrentPosition;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StreetFighterController {

    GetCurrentPosition getCurrentPosition;

    @GetMapping("/street-fighter/current-position")
    public GetCurrentPosition.Response getAllStudents(){
        return getCurrentPosition.execute();
    }
}
