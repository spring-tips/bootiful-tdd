package com.example.reservationservice;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationEntityTest {

    @Autowired
    private TestEntityManager tem;

    @Test
    public void persistence() throws Exception {

        Reservation reservation =
                this.tem.persistFlushFind(new Reservation(null, "Jane"));
        Assertions.assertThat(reservation.getId()).isNotNull();
        Assertions.assertThat(reservation.getReservationName()).isEqualTo("Jane");

    }
}
