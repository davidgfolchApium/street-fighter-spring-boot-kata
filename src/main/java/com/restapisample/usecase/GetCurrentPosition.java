package com.restapisample.usecase;

import com.restapisample.dao.StreetFighterDao;
import com.restapisample.model.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetCurrentPosition {

    StreetFighterDao dao;

    public Response execute() {
        Position result = dao.getCurrentPosition();
        return Response.builder()
                .position(result)
                .build();
    }

    @AllArgsConstructor
    @Data
    @Builder
    public static class Response {
        Position position;
    }
}
