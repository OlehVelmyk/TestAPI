package in.reqres.tests;

import in.reqres.actionHelpers.GetParametersFromResponses;
import in.reqres.actionHelpers.ResponseBody;
import in.reqres.dataProvider.UserId;
import in.reqres.endpoints.UsersEndpoints;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Map;

public class N_0002_GetUserByIdTest {

    @Test
    public void getUserById() {
        RequestSpecification request = RestAssured.given()
                .header("Accept", "application/json");

        Response response = request.get(UsersEndpoints.getOrUpdateOrDeleteUserById(UserId.userID));
        ResponseBody.GetResponseBodyAndStatusCode(response, 200);

        JsonPath jsonPathEvaluator = response.jsonPath();
        GetParametersFromResponses getParameters = new GetParametersFromResponses();

        Map data = getParameters.getObjectParameterFromResponse(jsonPathEvaluator, "data");
        getParameters.getStringParameterFromObjectForEquals(data, "id", UserId.userID);
        getParameters.getStringParameterFromObject(data, "email");
        getParameters.getStringParameterFromObject(data, "first_name");
        getParameters.getStringParameterFromObject(data, "last_name");
        getParameters.getStringParameterFromObject(data, "avatar");

        Map support = getParameters.getObjectParameterFromResponse(jsonPathEvaluator, "support");
        getParameters.getStringParameterFromObject(support, "url");
        getParameters.getStringParameterFromObject(support, "text");
    }
}