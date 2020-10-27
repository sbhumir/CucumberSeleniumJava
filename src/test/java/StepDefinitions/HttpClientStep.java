// Generally Cucumber Selenium is used for Web Testing. This RESTful API test is just a demo, no need to use Selenium for this test
package StepDefinitions;

import Actions.ActionRESTPost;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HttpClientStep {
	ActionRESTPost restPost = new ActionRESTPost();
	
	@Given("user sends an http request")
	public void user_sends_an_http_request() {
		ActionRESTPost.main(null);	   
	}

	@Then("user verifies the response")
	public void user_verifies_the_response() {
			
		
	}

}
