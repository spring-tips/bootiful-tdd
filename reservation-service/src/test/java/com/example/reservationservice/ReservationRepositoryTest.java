package com.example.reservationservice;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository repository;

    @Test
    public void findByReservationName() {

        Reservation save = this.repository.save(new Reservation(null, "Jane"));
        Assert.assertNotNull(save);

        Collection<Reservation> jane = this.repository.findByReservationName("Jane");
        Assertions.assertThat(jane.size()).isEqualTo(1);


    }

}
