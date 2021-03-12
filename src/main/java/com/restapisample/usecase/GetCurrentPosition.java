package com.restapisample.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetCurrentPosition {

    public Response execute() {
        // TODO get x,y from database
        return Response.builder()
                .position(Position.builder()
                        .x(1)
                        .y(1)
                        .build())
                .build();
    }

    @AllArgsConstructor
    @Data
    @Builder
    public static class Position {
        private int x;
        private int y;
    }

    @AllArgsConstructor
    @Data
    @Builder
    public static class Response{
        Position position;
    }
}
