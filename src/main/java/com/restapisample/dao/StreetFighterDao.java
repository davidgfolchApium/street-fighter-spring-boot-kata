package com.restapisample.dao;

import com.restapisample.model.Position;
import org.springframework.stereotype.Repository;

@Repository
public class StreetFighterDao {

    Position currentPosition;

    public StreetFighterDao() {
        currentPosition = Position.builder()
                .x(1)
                .y(1)
                .build();
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setPosition(Position position) {
        currentPosition.setX(position.getX());
        currentPosition.setY(position.getY());
    }
}
