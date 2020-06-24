package in.reqres.tests;

import in.reqres.actionHelpers.ResponseBody;
import in.reqres.dataProvider.UserId;
import in.reqres.endpoints.UsersEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class N_0004_DeleteUserByIdTest {

    @Test
    public void deleteUser() {
        RequestSpecification request = RestAssured.given()
                .header("Accept", "application/json");

        Response response = request.delete(UsersEndpoints.getOrUpdateOrDeleteUserById(UserId.userID));
        ResponseBody.GetResponseBodyAndStatusCode(response, 204);
    }
}
