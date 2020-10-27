 package pagefactory;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage_PF {
	
	@FindBy(id="name")
	@CacheLookup  //this annotation keeps the element in cache. This will not work if the elements are dynamic
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_pwd;
	
	@FindBy(id="login")
	WebElement btn_login;
	
	//on this page all the links with text "AWS" will get stored in myLinks. And they can be used aferwards
	@FindBy(partialLinkText = "AWS")
	List<WebElement> myLinks;	
	
	@FindBy(how = How.ID,using="name")
	WebElement abc;
	
	WebDriver driver;
	
	public LoginPage_PF(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//this will wait for the Ajax element for 30 secs
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
	}
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPwd(String password) {
		txt_pwd.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_login.click();
	}

}
