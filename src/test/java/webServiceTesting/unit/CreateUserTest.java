package webServiceTesting.unit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import webServiceTesting.User;

public class CreateUserTest {

    static User createUser = new User();
    String jsonWithUserAndJob = "{\n"
            + "    \"name\": \"testName\",\n"
            + "    \"job\": \"testJob\"\n"
            + "}";

    String jsonWithUserNameSurnameAndJob = "{\n"
            + "    \"name\": \"testName autoSurname\",\n"
            + "    \"job\": \"testJob\"\n"
            + "}";

    @BeforeClass
    public static void setup() {
        createUser.setName("testName");
        createUser.setJob("testJob");
    }

    @Test
    public void buildBody_validUserAndJob_shouldReturnJsonWithUserAndJob() {
        Assert.assertEquals(jsonWithUserAndJob, createUser.buildBody());
    }

    @Test
    public void buildBodyWithSurname_validUserAndJob_shouldReturnJsonWithUserNameSurnameAndJob() {
        createUser.setSurname("autoSurname");
        Assert.assertEquals(jsonWithUserNameSurnameAndJob, createUser.buildBodyWithSurname());
    }

}
