package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;




public class BankAccount__StepDefinitions {


    Response response;
    ValidatableResponse validatableResponse;
    RequestSpecification request = RestAssured.given();
    String token;




//---------------------------------------------------------------------------------------------------------------
    @Given("a SampleRequest with a valid JWT token")
    public void a_SampleRequest_with_a_valid_JWT_token() {

        token= "Q7DaxRnFls6IpwSW1SQ2FaTFOf7UdReAFNoKY68L";

    }

    @When("sample request is posted to api")
    public void sample_request_is_posted_to_api() {


        response=given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .header("X-Auth-Key", token)
                .body("{\"bankAccount\":\"GB09HAOE91311808002317\"}").
                        when()
                .post("https://api-test.afterpay.dev/api/v3/validate/bank-account");




    }

    @Then("Api returns ok")
    public void apiReturnsOk() {

        Assert.assertEquals(200,response.getStatusCode());

    }


    @Given("a SampleRequest without a JWT token")
    public void a_SampleRequest_without_a_JWT_token() {
        token = "";
    }

    @Then("Api returns \"Authorization has been denied for this request.“ message.")
    public void api_returns_Authorization_has_been_denied_for_this_request_message() {
        given().log().all()
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .header("X-Auth-Key", token)
                .body("{\"bankAccount\":\"GB09HAOE91311808002317\"}").
                when()
                .post("https://api-test.afterpay.dev/api/v3/validate/bank-account").
                then().log().all()
                .statusCode(401);
                //.contentType("application/json");
                //.body("message", is("Authorization has been denied for this request."));


    }

    @Then("Api returns status code {int}")
    public void apiReturnsStatusCode(int statusCode) {
        Assert.assertEquals(statusCode,response.statusCode());
    }


}