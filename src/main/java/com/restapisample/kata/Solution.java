package com.restapisample.kata;

import com.restapisample.usecase.GetMove;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Solution {

    private final GetMove getMove;

    public String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
        for (String move: moves) {
            getMove.execute(move);
        }
        return null;
    }
}