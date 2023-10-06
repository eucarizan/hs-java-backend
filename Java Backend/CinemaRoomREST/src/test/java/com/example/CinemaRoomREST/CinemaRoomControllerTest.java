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

import javax.print.Doc;

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
        ResponseEntity<String> createResponse = getPostResponse(15, 4);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        DocumentContext documentContext = JsonPath.parse(createResponse.getBody());
        String error = documentContext.read("$.error");
        assertThat(error).isEqualTo("The number of a row or a column is out of bounds!");

        ResponseEntity<String> createNegativeSeatResponse = getPostResponse(-1, -1);
        assertThat(createNegativeSeatResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DirtiesContext
    void shouldPurchaseATicket() {
        ResponseEntity<String> createResponse = getPostResponse(3, 4);
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
    void ticketShouldNotBePurchasedTwice() {
        ResponseEntity<String> purchaseResponse01 = getPostResponse(1, 1);
        assertThat(purchaseResponse01.getStatusCode()).isEqualTo(HttpStatus.OK);

        ResponseEntity<String> purchaseResponse02 = getPostResponse(1, 1);
        assertThat(purchaseResponse02.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        DocumentContext documentContext = JsonPath.parse(purchaseResponse02.getBody());
        String error = documentContext.read("$.error");
        assertThat(error).isEqualTo("The ticket has been already purchased!");
    }

    @Test
    @DirtiesContext
    void shouldReturnBoughtTicket() {
        ResponseEntity<String> purchaseResponse = getPostResponse(2, 2);
        assertThat(purchaseResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(purchaseResponse.getBody());
        String token = documentContext.read("$.token");

        Token returnToken = new Token(token);
        ResponseEntity<String> returnResponse = restTemplate
                .postForEntity("/return", returnToken, String.class);
        assertThat(returnResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DirtiesContext
    void shouldNotBeAbleToReturnTicketTwice() {
        ResponseEntity<String> purchaseResponse = getPostResponse(5, 5);
        assertThat(purchaseResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(purchaseResponse.getBody());
        String token = documentContext.read("$.token");

        Token returnToken = new Token(token);
        ResponseEntity<String> returnResponse = restTemplate
                .postForEntity("/return", returnToken, String.class);
        assertThat(returnResponse.getStatusCode()).isEqualTo(HttpStatus.OK);


        returnResponse = restTemplate
                .postForEntity("/return", returnToken, String.class);
        assertThat(returnResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        DocumentContext documentContext1 = JsonPath.parse(returnResponse.getBody());
        String error = documentContext1.read("$.error");
        assertThat(error).isEqualTo("Wrong token!");
    }

    @Test
    void shouldShowStatsForManagersWithPassword() {
        ResponseEntity<String> response = restTemplate.getForEntity("/stats?password=super_secret", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        int income = documentContext.read("$.income");
        int available = documentContext.read("$.available");
        int purchased = documentContext.read("$.purchased");
        assertThat(income).isEqualTo(0);
        assertThat(available).isEqualTo(81);
        assertThat(purchased).isEqualTo(0);
    }

    @Test
    void shouldReturnUnauthorizedWhenPasswordIsBlank() {
        ResponseEntity<String> response = restTemplate.getForEntity("/stats", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        String error = documentContext.read("$.error");
        assertThat(error).isEqualTo("The password is wrong!");
    }

    @Test
    void shouldNotShowStatsForWrongPassword() {
        ResponseEntity<String> response = restTemplate.getForEntity("/stats?password=super_secrets", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        String error = documentContext.read("$.error");
        assertThat(error).isEqualTo("The password is wrong!");
    }

    @Test
    @DirtiesContext
    void shouldUpdateStatsWhenTicketIsPurchased() {
        ResponseEntity<String> purchaseResponse = getPostResponse(4, 4);
        assertThat(purchaseResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext purchaseDocumentContext = JsonPath.parse(purchaseResponse.getBody());
        int price = purchaseDocumentContext.read("$.ticket.price");

        ResponseEntity<String> statsResponse = restTemplate.getForEntity("/stats?password=super_secret", String.class);
        assertThat(statsResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(statsResponse.getBody());
        int income = documentContext.read("$.income");
        int available = documentContext.read("$.available");
        int purchased = documentContext.read("$.purchased");
        assertThat(income).isEqualTo(price);
        assertThat(available).isEqualTo(80);
        assertThat(purchased).isEqualTo(1);
    }

    @Test
    @DirtiesContext
    void shouldUpdateStatsWhenTicketIsReturned() {
        ResponseEntity<String> purchaseResponse = getPostResponse(3, 4);
        assertThat(purchaseResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext purchaseDocumentContext = JsonPath.parse(purchaseResponse.getBody());
        String token = purchaseDocumentContext.read("$.token");

        ResponseEntity<String> statsResponse = restTemplate.getForEntity("/stats?password=super_secret", String.class);
        assertThat(statsResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(statsResponse.getBody());
        int income = documentContext.read("$.income");
        int available = documentContext.read("$.available");
        int purchased = documentContext.read("$.purchased");
        assertThat(income).isEqualTo(10);
        assertThat(available).isEqualTo(80);
        assertThat(purchased).isEqualTo(1);

        Token returnToken = new Token(token);
        ResponseEntity<String> returnResponse = restTemplate
                .postForEntity("/return", returnToken, String.class);
        assertThat(returnResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        statsResponse = restTemplate.getForEntity("/stats?password=super_secret", String.class);
        assertThat(statsResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext1 = JsonPath.parse(statsResponse.getBody());
        int income1 = documentContext1.read("$.income");
        int available1 = documentContext1.read("$.available");
        int purchased1 = documentContext1.read("$.purchased");
        assertThat(income1).isEqualTo(0);
        assertThat(available1).isEqualTo(81);
        assertThat(purchased1).isEqualTo(0);
    }

    private ResponseEntity<String> getPostResponse(int row, int col) {
        Seat seat = new Seat(row, col, true);

        return restTemplate
                .postForEntity("/purchase", seat, String.class);
    }

}
