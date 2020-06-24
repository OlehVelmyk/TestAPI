package in.reqres.endpoints;

import org.kohsuke.rngom.parse.host.Base;

import static in.reqres.endpoints.BaseEndpoint.baseURL;

public class UsersEndpoints extends Base {
    public static final String createUser = baseURL + "api/users";

    public static String getOrUpdateOrDeleteUserById(int userId) {
        return baseURL + "api/users/" + userId;
    }

}
