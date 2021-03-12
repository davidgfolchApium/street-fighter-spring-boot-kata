package com.restapisample.dao;

import com.restapisample.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StreetFighterDaoShould {

    private StreetFighterDao streetFighterDao;

    @BeforeEach
    void setUp() {
        streetFighterDao = new StreetFighterDao();
    }

    @Test
    void default_position_is_1_1() {
        assertThat(streetFighterDao.getCurrentPosition().getX()).isEqualTo(1);
        assertThat(streetFighterDao.getCurrentPosition().getY()).isEqualTo(1);
    }

    @Test
    void changes_the_value_of_current_position() {
        streetFighterDao.setPosition(new Position(2, 2));
        assertThat(streetFighterDao.getCurrentPosition().getX()).isEqualTo(2);
        assertThat(streetFighterDao.getCurrentPosition().getY()).isEqualTo(2);
    }
}
