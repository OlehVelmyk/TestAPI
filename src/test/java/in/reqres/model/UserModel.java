package in.reqres.model;

public class UserModel {
    private String name;
    private String job;

    public UserModel(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public static UserModel generate() {
        return new UserModel(
                "Name " + System.currentTimeMillis(),
                "Job " + System.currentTimeMillis());
    }
}
