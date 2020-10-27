package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	
	WebDriver driver = null;	

	@Given("browser is open")
	public void browser_is_open() {
		//System.out.println("Browser is open");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}

	
	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		
		//System.out.println("user is on google page");
		driver.navigate().to("https://google.com");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		//System.out.println("user enters text on search page");
		driver.findElement(By.name("q")).sendKeys("Spelling the Dream");
		Thread.sleep(2000);
	}

	@When("hit enter")
	public void hit_enter() {
		//System.out.println("user hits enters");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		
		if(driver.getPageSource().contains("Spelling the Dream | Official Trailer | Netflix")){
			System.out.println("Google search returned accurate Netflix trailer link");
		}
		
		driver.close();
		driver.quit();
		
		//System.out.println("user is navigated to search results");
	}

}