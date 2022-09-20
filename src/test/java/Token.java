import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;


public class Token {
    @Test
    public void testToken() throws InterruptedException {
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        System.out.println("Шаг 1:");

        String token = response.get("token");
        System.out.print("token = ");
        System.out.println(token);

        int seconds = response.getByte("seconds");
        System.out.print("seconds = ");
        System.out.println(seconds);

        JsonPath responseToken = RestAssured
                .given()
                .queryParam("token", token)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        System.out.println("Шаг 2:");

        String status = responseToken.get("status");

        if (!status.equals("Job is NOT ready")){
            System.out.print("Error, status incorrect");
        }
        System.out.print("status = ");
        System.out.println(status);

        Thread.sleep(seconds*1000);

        System.out.println("Шаг 3:");

        JsonPath responseSeconds = RestAssured
                .given()
                .queryParam("token", token)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        status = responseSeconds.get("status");
        System.out.print("status = ");
        System.out.println(status);

        String result = responseSeconds.get("result");
        System.out.print("result = ");
        System.out.println(result);

    }
}
