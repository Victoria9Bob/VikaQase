package adapters;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public abstract class BaseAdapter {
    final String BASE_URL = "https://api.qase.io/v1/";
//    final String AUTRTH_TOKEN = "4f7faca87e882d98cce5f4234195ac3c24f22d51";
    final String AUTRTH_TOKEN = "74d33400e63f102e391e5e1bc8cb9d365cd9d350";
    Gson gson = new Gson();
    public String get(String uri, int expectedCode) {
        return
                given().
                        header("Token", AUTRTH_TOKEN).
                        header("content-type", "application/json").

                        when().
                        get(BASE_URL + uri).
                        then().log().all().
                        statusCode(expectedCode).extract().body().asString();
    }
    public String get(String uri,String id, int expectedCode) {
        return
                given().
                        header("Token", AUTRTH_TOKEN).
                        header("content-type", "application/json").

                        when().
                        get(BASE_URL + uri+id).
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
                        post(BASE_URL + uri).
                        then().
                        log().all().
                        statusCode(expectedCode).extract().body().asString();
    }
}
