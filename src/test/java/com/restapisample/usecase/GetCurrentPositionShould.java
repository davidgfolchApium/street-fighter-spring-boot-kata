package com.restapisample.usecase;

import com.restapisample.dao.StreetFighterDao;
import com.restapisample.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GetCurrentPositionShould {

    public static final Position EXPECTED_POSITION = Position.builder()
            .x(3)
            .y(2)
            .build();
    private GetCurrentPosition getCurrentPosition;
    private StreetFighterDao streetFighterDao;

    @BeforeEach
    void setUp() {
        streetFighterDao = Mockito.spy(new StreetFighterDao());
        streetFighterDao.setPosition(EXPECTED_POSITION);
        getCurrentPosition = new GetCurrentPosition(streetFighterDao);
    }

    @Test
    void gets_current_position_from_dao() {
        GetCurrentPosition.Response actual = getCurrentPosition.execute();

        assertThat(actual.getPosition()).isEqualTo(EXPECTED_POSITION);
        verify(streetFighterDao).getCurrentPosition();
    }
}
