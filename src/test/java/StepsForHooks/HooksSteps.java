package StepsForHooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;

public class HooksSteps {

	WebDriver driver = null;

	@Before(value = "@smoke",order=1)
	public void browserSetup() {
		System.out.println("Inside Before order 1");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.manage().window().maximize();		
	}
	@Before(order=2)
	public void setup2() {
		System.out.println("Inside Before order 2");
	}

	@After(value="@smoke",order=1)
	public void teardown() {
		System.out.println("Inside after order 1");
		driver.close();
		driver.quit();
	}
	
	@After(order=2)
	public void teardown2() {
		System.out.println("Inside after order 2");
	}

//	@BeforeStep
//	public void beforeSteps() {
//		System.out.println("@Before Hook - set up block");
//	}
//
//	@AfterStep
//	public void afterSteps() {
//		System.out.println("@After Hook tear down block");
//	}

	@Given("Hooks is on login page")
	public void user_Hooks_is_on_login_page() {
		System.out.println("user Hooks is on login page");
		
	}

	@When("Hooks enters valid username and password")
	public void user_enters_valid_username_and_password() {
		System.out.println("user enters valid username and password");
	}
	@And("click on login button")
	public void click_on_login_button() {
		System.out.println("click on login button");
	}
	@Then("Hooks is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("user is navigated to the home page");
	}

}
