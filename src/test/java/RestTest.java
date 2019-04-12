import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestTest {

    @Test
    void restTest() throws JSONException {
        Response response = get("http://restcountries.eu/rest/v1/name/russia");
        JSONArray jsonResponse = new JSONArray(response.asString());
        String change1;
        System.out.println(jsonResponse);
        String capital = jsonResponse.getJSONObject(0).getString("capital");

        for(int i = 0; i < jsonResponse.length(); i++){
            if(jsonResponse.getJSONObject(i).getString("capital").equals("Moscow")){
                System.out.println(jsonResponse.getJSONObject(i).getString("nativeName"));
            }
        }

        assertEquals(capital, "Moscow");
    }
}
