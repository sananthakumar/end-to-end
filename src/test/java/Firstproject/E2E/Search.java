package Firstproject.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Search extends Base {

	public WebDriver driver;
	@BeforeTest
	public void intializedriver() throws IOException {
		driver=setdriver();
		
	}
	
	
	
	@Test()
	public void Go_home() throws IOException, InterruptedException {
		
		String url=url();
		Login login=new Login(driver);
		
		driver.get(prop.getProperty("url"));
		login.close().click();
	
	}
	
	
	@Test (dataProvider="searchdata")
	public void search(String s) throws InterruptedException {
		
		Home home=new Home(driver);
		
		home.search_box().clear();
		home.search_box().sendKeys(s);
//		if(home.search_box().isDisplayed()) {
//			System.out.println("Search box is displayed");
//		}
//		else {
//			System.out.println(" Search box Not displayed");
//		}
		home.serach_btn().click();
		System.out.println(s);
		home.search_box().clear();
		Thread.sleep(2000);
		System.out.println(s);
	
	}
	
	
	
	
	@DataProvider()
	public Object[] searchdata() {
		Object data[]=new Object[3];
		data[0]="realme3pro";
		data[1]="Samsungs20";
		data[2]="Redmi";
		return data;
		
	}
	
	
	@AfterTest()
	public void aftertest(){
		driver.close();
	}
}
