package org.acme;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.acme.Card.CardResource;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class CardResourceTest {

    @Test
    public void testGetWithNonExistentCard() {
        given()
        .when().get("/cards/Sample%20FCard")
        .then()
           .statusCode(404)
           .body(is("Card not found"));
    }
}
