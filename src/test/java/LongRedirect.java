import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class LongRedirect {
    @Test
    public void TestLongRedirect() {

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        int statusCode = response.getStatusCode();
        String locationHeader = response.getHeader("Location");
        int cout = 0;

        while (statusCode != 200) {
            cout++;
            System.out.println(locationHeader);
            Response responseRedirect = RestAssured
                    .given().relaxedHTTPSValidation()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(locationHeader)
                    .andReturn();

            statusCode = responseRedirect.getStatusCode();

            locationHeader = responseRedirect.getHeader("Location");

        }
        System.out.print("\nКод ответа - ");
        System.out.println(statusCode);

        System.out.print("Количество редиректов - ");
        System.out.println(cout);
    }
}
