package com.example.reservationservice;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ReservationTest {

    @Test
    public void creation() {

        Reservation reservation = new Reservation(1L, "Jane");
        Assert.assertEquals(reservation.getReservationName(), "Jane");
        Assert.assertThat(reservation.getId(), Matchers.equalTo(1L));
        Assertions.assertThat(reservation.getId()).isEqualTo(1L);
        BDDAssertions.then (reservation.getId()).isEqualTo(1L);
    }
}
