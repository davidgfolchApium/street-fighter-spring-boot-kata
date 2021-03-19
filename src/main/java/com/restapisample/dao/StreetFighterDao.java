package com.restapisample.dao;

import com.restapisample.model.Position;
import lombok.Getter;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class StreetFighterDao {

    private final String[][] allFighters = new String[][]{
            new String[] {      "",    "Ryu",  "E.Honda",  "Cammy",  "Blanka",   "Guile",        "", "Chun Li" },
            new String[] {"Balrog",    "Ken",  "Chun Li",       "", "M.Bison", "Zangief", "Dhalsim", "Sagat"},
            new String[] {  "Vega",       "", "Fei Long", "Balrog",  "Deejay",   "Cammy",        "", "T.Hawk" },
    };

    private final Position currentPosition = Position.builder()
            .x(1)
            .y(1)
            .build();

    public void setPosition(Position position) {
        currentPosition.setX(position.getX());
        currentPosition.setY(position.getY());
    }

}
