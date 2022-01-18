package Firstproject.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Login_check extends Base {
 
	Home home;
	
    public WebDriver driver;	
	@BeforeTest
	public void intializedriver() throws IOException {
		driver=setdriver();
		home=new Home(driver);
	}
	
	
	
	
	@Test()
	public void Go_home() throws IOException, InterruptedException {
		String url=url();
		driver.get(prop.getProperty("url"));
	}
	@Test(dataProvider="getdata")
	public void logincheck(String mobile,String pass) throws InterruptedException, IOException {
		
		 
		Login login=new Login(driver);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(home.login_btn()).click().perform();
		//home.login_btn().click();
		Thread.sleep(2000);
	    login.mobile().sendKeys(mobile);
		login.password().sendKeys(pass);
		Thread.sleep(2000);
		login.proceed().click();
		Thread.sleep(3000);
		String name=home.name().getText();
		System.out.println(name);
		Assert.assertEquals("Ananth", name);
		
	}
	
	@Test
	public void topofffers_click() {
		home.top().click();
	}
	
	
	
	@DataProvider()
	public Object[][] getdata() {
		Object[][]data=new Object[1][2];
		
		
		data[0][0]="9994704312";
		data[0][1]="Ananth@123";
		
		return data;
		
	}
	
	@AfterTest()
	public void aftertest(){
		driver.close();
	}
}
