import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class GetJson {
    @Test
    public void TestGetJson(){
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        ArrayList<HashMap <String, String>> messages = response.get("messages");
        //System.out.println(messages);

        int index = 0;
        for (HashMap<String , String> message:messages) {
            if(index==1){
                String secondMessage = message.get("message");
                System.out.println("Текст второго сообщения:");
                System.out.println(secondMessage);
                break;
            }
            index++;
        }
    }
}

