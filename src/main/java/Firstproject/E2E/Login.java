package Firstproject.E2E;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='_2IX_2- VJZDxU']")
	WebElement mobile;
	
	
	@FindBy(xpath="//*[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement password;
	
	
	@FindBy(xpath="//*[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement proceed;
	
	@FindBy(xpath="//*[@class='_2KpZ6l _2doB4z']")
	private WebElement close;
	
	public WebElement mobile() {
		return mobile;
	}
	
	
	public WebElement password() {
		return password;
	}
	
	
	public WebElement proceed() {
		return proceed;
	}
	
	public WebElement close() {
		return close;
	}

}
