
package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.HomePage_PF;
import pagefactory.LoginPage_PF;
import pages.loginPage;

public class loginStep_PF {

	WebDriver driver = null;
	LoginPage_PF login;
	HomePage_PF home;

	@Given("chrome is open")
	public void browser_is_open() {

		System.out.println("Chrome is open");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().window().maximize();

	}

	@And("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {		
		driver.navigate().to("https://example.testproject.io/web/");
		Thread.sleep(2000);
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException  {
		
		login = new LoginPage_PF(driver);
		login.enterUsername(username);
		login.enterPwd(password);
	}

	@And("user clicks on login")
	public void user_clicks_on_login() {		
		login.clickLogin();
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
		home = new HomePage_PF(driver);
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
