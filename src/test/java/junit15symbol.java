import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class junit15symbol {

    @ParameterizedTest
    @ValueSource(strings = {"", "Alexanderr", "Maiia", "Issabella"})
    public void testHelloMethodName(String name){
        Map<String, String> queryParams = new HashMap<>();

        if(name.length() >0){
            queryParams.put("name", name);
        }

        JsonPath response = RestAssured
                .given()
                .queryParams(queryParams)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");

        int length = answer.length();
        System.out.print("length = ");
        System.out.println(length);
        System.out.println(answer);

        assertTrue(answer.length() > 15,"answer length < 15");

    }
}
