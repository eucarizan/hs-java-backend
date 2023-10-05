package com.example.CinemaRoomREST;

import com.example.CinemaRoomREST.models.Seat;
import com.example.CinemaRoomREST.models.Token;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

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
        int totalRows = documentContext.read("$.rows");
        int totalColumns = documentContext.read("$.columns");
        int seats = documentContext.read("$.seats.length()");
        assertThat(totalRows).isEqualTo(9);
        assertThat(totalColumns).isEqualTo(9);
        assertThat(seats).isEqualTo(81);
    }

    @Test
    void shouldHandleWrongRowNumber() {
        Seat seat = new Seat(15, 4, true);
        ResponseEntity<String> createResponse = restTemplate
                .postForEntity("/purchase", seat, String.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        DocumentContext documentContext = JsonPath.parse(createResponse.getBody());
        String error = documentContext.read("$.error");
        assertThat(error).isEqualTo("The number of a row or a column is out of bounds!");

        Seat negativeSeat = new Seat(-1, -1, true);
        ResponseEntity<String> createNegativeSeatResponse = restTemplate
                .postForEntity("/purchase", negativeSeat, String.class);
        assertThat(createNegativeSeatResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DirtiesContext
    void shouldPurchaseATicket() {
        Seat seat = new Seat(3, 4, true);
        ResponseEntity<String> createResponse = restTemplate
                .postForEntity("/purchase", seat, String.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(createResponse.getBody());
        String token = documentContext.read("$.token");
        int row = documentContext.read("$.ticket.row");
        int col = documentContext.read("$.ticket.column");
        int price = documentContext.read("$.ticket.price");
        assertThat(token).isNotBlank();
        assertThat(row).isEqualTo(3);
        assertThat(col).isEqualTo(4);
        assertThat(price).isEqualTo(10);
    }

    @Test
    @DirtiesContext
    void shouldTicketShouldNotBePurchasedTwice() {
        Seat seat = new Seat(1, 1, true);
        ResponseEntity<String> purchaseResponse01 = restTemplate
                .postForEntity("/purchase", seat, String.class);
        assertThat(purchaseResponse01.getStatusCode()).isEqualTo(HttpStatus.OK);

        ResponseEntity<String> purchaseResponse02 = restTemplate
                .postForEntity("/purchase", seat, String.class);
        assertThat(purchaseResponse02.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        DocumentContext documentContext = JsonPath.parse(purchaseResponse02.getBody());
        String error = documentContext.read("$.error");
        assertThat(error).isEqualTo("The ticket has been already purchased!");
    }

    @Test
    @DirtiesContext
    void shouldReturnBoughtTicket() {
        Seat seat = new Seat(2, 2, true);
        ResponseEntity<String> purchaseResponse = restTemplate
                .postForEntity("/purchase", seat, String.class);
        assertThat(purchaseResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(purchaseResponse.getBody());
        String token = documentContext.read("$.token");

        Token returnToken = new Token(token);
        ResponseEntity<String> returnResponse = restTemplate
                .postForEntity("/return", returnToken, String.class);
        assertThat(returnResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
