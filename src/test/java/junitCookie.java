import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class junitCookie {
    @Test
    public void testCookie(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();
        Map<String, String> responseCookies = response.getCookies();
        System.out.println("Cookies = " + responseCookies);

        String nameCookie = (String) responseCookies.keySet().toArray()[0];
        String valueCookie = responseCookies.get(nameCookie);

        System.out.println("nameCookie = " + nameCookie);
        System.out.println("valueCookie = " + valueCookie);
        assertEquals("hw_value", valueCookie, "Unexpected Cookie");
    }
}
