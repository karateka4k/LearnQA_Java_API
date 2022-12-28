import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class junitHeader {
    @Test
    public void testHeader(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();
        Headers responseHeaders = response.getHeaders();
        System.out.println("Headers: \n" + responseHeaders);

        String valueHeader = responseHeaders.getValue("x-secret-homework-header");
        System.out.println("\nvalueHeader = " +valueHeader);

        assertEquals("Some secret value", valueHeader, "Unexpected Header");
    }
}

