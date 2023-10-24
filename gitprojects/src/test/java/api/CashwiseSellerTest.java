package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.CAshwiseAuthorizationToken;
import utilities.Config;

import java.util.HashMap;
import java.util.Map;

public class CashwiseSellerTest {
    @Test
    public void getSingleSeller(){
        int id = 1720;
        String token = CAshwiseAuthorizationToken.getToken();
        String url = Config.getProperty("cashWiseURI")+"/api/myaccount/sellers/"+id;

        Response response = RestAssured.given().auth().oauth2(token).get(url);
        System.out.println("status code:" + response.statusCode());
        response.prettyPrint();
    }

    @Test
    public void getAllSellers(){
        String token = CAshwiseAuthorizationToken.getToken();
        String url = Config.getProperty("cashWiseURI")+"/api/myaccount/sellers";

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", true);
        params.put("page",1);
        params.put("size",3);

        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
        System.out.println("status code:" + response.statusCode());
        response.prettyPrint();

    }
}
