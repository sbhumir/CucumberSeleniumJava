package StepsForBackground;

import io.cucumber.java.en.*;

public class BackgroundDemoSteps {

	@Given("user1 is on login page")
	public void user_is_on_login_page() {
		System.out.println("User1 is on login page");
	}

	@When("user1 enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("user1 enters username and password");
	}
	@And("click on button")
	public void click_on_login_button() {
		System.out.println("click on button");
	}
	@Then("user1 is navigated to the homepage")
	public void user_is_navigated_to_the_homepage() {
		System.out.println("user1 is navigated to the homepage");
	}

	@When("user1 clicks on welcome link")
	public void user_clicks_on_welcome_link() {
		System.out.println("user1 clicks on welcome link");
	}
	@Then("logout link is displayed")
	public void logout_link_is_displayed() {
		System.out.println("logout link is displayed");
	}
	
	@When("user1 clicks on dashboard link")
	public void user1_clicks_on_dashboard_link() {
		System.out.println("user1 clicks on dashboard link");		
	}

	@Then("quick launch toolbar is displayed")
	public void quick_launch_toolbar_is_displayed() {
		System.out.println("quick launch toolbar is displayed");
	}
}
