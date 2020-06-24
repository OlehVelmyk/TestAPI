package in.reqres.actionHelpers;

import in.reqres.logging.CustomReporter;
import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseBody {

    public static void GetResponseBodyAndStatusCode(Response response, int status) {
        int statusCode = response.getStatusCode();
        CustomReporter.logAction("Response body is " + response.body().asString());
        System.out.println("Response body: " + response.body().asString());
        CustomReporter.logAction("Status code: " + statusCode);
        System.out.println("Status code: " + statusCode);

        Assert.assertTrue(response.body().asString().length() >= 0);
        Assert.assertEquals(statusCode, status);
    }
}
