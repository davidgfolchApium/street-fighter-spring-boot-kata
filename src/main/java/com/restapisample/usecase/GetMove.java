package com.restapisample.usecase;

import com.restapisample.dao.StreetFighterDao;
import com.restapisample.model.Move;
import com.restapisample.model.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetMove {

    private final StreetFighterDao dao;

    public Response execute(String move) {
        String[][] allFighters = dao.getAllFighters();
        Position currentPosition = dao.getCurrentPosition();
        switch (Move.valueOf(move)) {
            case UP:
                return moveUp();
            case DOWN:
                return moveDown();
            case LEFT:
                return moveLeft();
            case RIGHT:
                return moveRight();
            default:
                throw new IllegalArgumentException();
        }
    }

    private Response moveRight() {
        Position result = Position.builder().build();
        return Response.builder()
                .position(result)
                .build();
    }

    private Response moveLeft() {
        return null;
    }

    private Response moveDown() {
        return null;
    }

    private Response moveUp() {
        return null;
    }

    @AllArgsConstructor
    @Data
    @Builder
    public static class Response {
        Position position;
    }
}
