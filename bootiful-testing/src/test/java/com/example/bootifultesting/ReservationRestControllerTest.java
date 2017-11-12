package com.example.bootifultesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@WebMvcTest
@RunWith(SpringRunner.class)
public class ReservationRestControllerTest {

    @MockBean
    private ReservationRepository reservationRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReservations() throws Exception {

        Mockito.when(this.reservationRepository.findAll())
                .thenReturn(Collections.singletonList(new Reservation(1L, "Jane")));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/reservations"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].reservationName").value("Jane"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
