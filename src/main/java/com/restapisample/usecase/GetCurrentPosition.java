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

    StreetFighterDao streetFighterDao;

    public Response execute() {

        Position currentPosition = streetFighterDao.getCurrentPosition();

        return Response.builder()
                .position(currentPosition)
                .build();
    }

    @AllArgsConstructor
    @Data
    @Builder
    public static class Response{
        Position position;
    }
}
