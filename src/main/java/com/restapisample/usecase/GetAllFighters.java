package com.restapisample.usecase;

import com.restapisample.dao.StreetFighterDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetAllFighters {

    StreetFighterDao dao;

    public Response execute() {
        String[][] result = dao.getAllFighters();
        return Response.builder()
                .allFigthers(result)
                .build();
    }

    @AllArgsConstructor
    @Data
    @Builder
    public static class Response {
        String[][] allFigthers;
    }

}
