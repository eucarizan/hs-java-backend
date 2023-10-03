package com.example.CinemaRoomREST;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CinemaRoomControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnCinema() {
        ResponseEntity<String> response = restTemplate.getForEntity("/seats", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        int totalRows = documentContext.read("$.totalRows");
        int totalColumns = documentContext.read("$.totalColumns");
        int seats = documentContext.read("$.seats.length()");
        assertThat(totalRows).isEqualTo(9);
        assertThat(totalColumns).isEqualTo(9);
        assertThat(seats).isEqualTo(81);
    }
}
