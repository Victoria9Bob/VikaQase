package adapters;

import com.google.gson.Gson;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public abstract class BaseAdapter {
    final String BASE_API_URL = System.getenv().getOrDefault("BASE_API_URL", PropertyReader.getProperty("qase.base_api_url"));
    final String AUTRTH_TOKEN = System.getenv().getOrDefault("AUTRTH_TOKEN", PropertyReader.getProperty("qase.autrth_token"));

    Gson gson = new Gson();
    public String get(String uri, int expectedCode) {
        return
                given().
                        header("Token", AUTRTH_TOKEN).
                        header("content-type", "application/json").

                        when().
                        get(BASE_API_URL + uri).
                        then().log().all().
                        statusCode(expectedCode).extract().body().asString();
    }

    public String post(String uri, String requestBody, int expectedCode) {
        return
                given().
                        header("Token", AUTRTH_TOKEN).
                        header("content-type", "application/json").
                        body(requestBody).
                        when().
                        log().all().
                        post(BASE_API_URL + uri).
                        then().
                        log().all().
                        statusCode(expectedCode).extract().body().asString();
    }
}
