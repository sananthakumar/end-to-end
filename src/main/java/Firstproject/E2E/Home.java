package Firstproject.E2E;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

	WebDriver driver;
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='_1_3w1N']")
	private WebElement login_btn;
	
	@FindBy(xpath="//*[@name='q']")
	private WebElement search_box;
	
	@FindBy(xpath="//*[@class='L0Z3Pu']")
	private WebElement serach_btn;
	
	@FindBy(xpath="(//*[@class='_1psGvi _3BvnxG'])[1]")
	private WebElement name;
	
	
	@FindBy(xpath="(//*[@class='xtXmba'])[1]")
	private WebElement top;
	
	public WebElement login_btn() {
		return login_btn;
	}
	
	public WebElement search_box() {
		return search_box;
	}
	
	public WebElement serach_btn() {
		return serach_btn;
	}
	
	
	public WebElement name() {
		return name;
	}
	public WebElement top() {
		return top;
	}
}
