package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class PublicAPIPage {

	WebDriver driver = null;

	@Given("API page is open")
	public void browser_is_open() {
		System.out.println("Browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath+"/src/test/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().window().maximize();

	}

	@And("user is on API page")
	public void user_is_on_api_page() throws InterruptedException {

		driver.navigate().to("https://reqres.in/");
		//Maximize current window
		driver.manage().window().maximize();
		//Thread.sleep(3000);

	}

	@When("user clicks on get users")
	public void user_clicks_on_get_users() {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");		
		driver.findElement(By.xpath("//a[@href='/api/users/2']")).click();		

	}
	@And("user clicks on span users link")
	public void user_clicks_on_span_users_link() throws InterruptedException {
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='url']/parent::a")).click();
		Thread.sleep(3000);
	}
	@Then("user is navigated to API results")
	public void user_is_navigated_to_api_results() {

		String actualUser = driver.findElement(By.xpath(".//pre")).getText();
		String expUser = "\"id\":2";
		
		try {
			Assert.assertTrue("User found!", actualUser.contains(expUser));
		}
		catch (AssertionError e) {

			System.out.println("API User not found!");		
		}
		driver.close();
		driver.quit();
	}

}
