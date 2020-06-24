package in.reqres.tests;

import in.reqres.actionHelpers.GetParametersFromResponses;
import in.reqres.actionHelpers.ResponseBody;
import in.reqres.dataProvider.UserId;
import in.reqres.endpoints.UsersEndpoints;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class N_0003_UpdateUserByIdTest {

    @Test
    public void updateUser() {
        JSONObject requestParams = new JSONObject()
                .put("name", "Name " + System.currentTimeMillis())
                .put("job", "Job " + System.currentTimeMillis());

        RequestSpecification request = RestAssured.given()
                .header("Accept", "application/json")
                .body(requestParams.toString());

        Response response = request.put(UsersEndpoints.getOrUpdateOrDeleteUserById(UserId.userID));
        ResponseBody.GetResponseBodyAndStatusCode(response, 200);

        JsonPath jsonPathEvaluator = response.jsonPath();
        GetParametersFromResponses getParameters = new GetParametersFromResponses();

        getParameters.getStringParameterFromResponse(jsonPathEvaluator, "updatedAt");
    }
}
