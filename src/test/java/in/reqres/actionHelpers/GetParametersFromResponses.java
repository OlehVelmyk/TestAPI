package in.reqres.actionHelpers;

import in.reqres.logging.CustomReporter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.Map;

public class GetParametersFromResponses {

    public void getStringParameterFromResponse(JsonPath jsonPathEvaluator, String s) {
        String response = jsonPathEvaluator.get(s);
        CustomReporter.logAction("'" + s + "' " + "parameter received from Response is " + "'" + response + "'");
        System.out.println("'" + s + "' " + "parameter received from Response is " + "'" + response + "'");
        Assert.assertNotEquals(response, null);
    }

    public Map getObjectParameterFromResponse(JsonPath jsonPathEvaluator, String s) {
        Map response = jsonPathEvaluator.getMap(s);
        CustomReporter.logAction("'" + s + "' " + "parameter received from Response is " + "'" + response.toString() + "'");
        System.out.println("'" + s + "' " + "parameter received from Response is " + "'" + response.toString() + "'");
        Assert.assertNotEquals(response, null);
        return response;
    }

    public void getStringParameterFromObject(Map map, String s) {
        Object response = map.get(s);
        CustomReporter.logAction("'" + s + "' " + "parameter received from Response is " + "'" + response.toString() + "'");
        System.out.println("'" + s + "' " + "parameter received from Response is " + "'" + response.toString() + "'");
        Assert.assertNotEquals(response.toString(), null);
    }

    public void getStringParameterFromObjectForEquals(Map map, String s, int value) {
        Object response = map.get(s);
        CustomReporter.logAction("'" + s + "' " + "parameter received from Response is " + "'" + response.toString() + "'");
        System.out.println("'" + s + "' " + "parameter received from Response is " + "'" + response.toString() + "'");
        Assert.assertEquals(Integer.valueOf(response.toString()), value);
    }
}
