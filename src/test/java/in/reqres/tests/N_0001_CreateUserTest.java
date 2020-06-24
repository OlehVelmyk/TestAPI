package in.reqres.tests;

import in.reqres.actionHelpers.GetParametersFromResponses;
import in.reqres.actionHelpers.ResponseBody;
import in.reqres.endpoints.UsersEndpoints;
import in.reqres.model.UserModel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class N_0001_CreateUserTest {

    @Test
    public void createUser() {
        UserModel newUser = new UserModel(UserModel.generate().getName(), UserModel.generate().getJob());

        JSONObject requestParams = new JSONObject()
                .put("name", newUser.getName())
                .put("job", newUser.getJob());

        RequestSpecification request = RestAssured.given()
                .header("Accept", "application/json")
                .body(requestParams.toString());

        Response response = request.post(UsersEndpoints.createUser);
        ResponseBody.GetResponseBodyAndStatusCode(response, 201);

        JsonPath jsonPathEvaluator = response.jsonPath();

        GetParametersFromResponses getParameters = new GetParametersFromResponses();
        getParameters.getStringParameterFromResponse(jsonPathEvaluator, "id");
        getParameters.getStringParameterFromResponse(jsonPathEvaluator, "createdAt");
    }
}
