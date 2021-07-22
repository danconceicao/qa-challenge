package webServiceTesting;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class User {

    private String name;
    private String surname;
    private String job;
    private String email;
    private final RequestSpecification REQUEST_SPECIFICATION;

    public User() {
        this.REQUEST_SPECIFICATION = RestAssured.given()
                .baseUri("https://reqres.in/api")
                .basePath("/users");
    }

    public User(String basePath) {
        this.REQUEST_SPECIFICATION = RestAssured.given()
                .baseUri("https://reqres.in/api")
                .basePath(basePath);
    }

    public RequestSpecification getRequestSpecification() {
        return REQUEST_SPECIFICATION;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String buildBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", this.name);
        jsonObject.put("job", this.job);
        return jsonObject.toString(4);
    }

    public String buildBodyWithSurname() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", this.name.concat(" ").concat(this.surname));
        jsonObject.put("job", this.job);
        return jsonObject.toString(4);
    }

    String buildRegisterBody() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", this.email);
        return jsonObject.toString(4);
    }
}
