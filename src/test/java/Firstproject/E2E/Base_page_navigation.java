package Firstproject.E2E;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_page_navigation extends Base {
	
	public WebDriver driver;
	@BeforeTest
	public void intializedriver() throws IOException {
		driver=setdriver();
		
	}
	
	
	@Test()
	public void Go_home() throws IOException, InterruptedException {
		
		String url=url();
	
		
		driver.get(prop.getProperty("url"));
	
	}
	
	@Test()
	public void gettitle() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Flipkart");
	}
	
	
	
	
	@AfterTest()
	public void aftertest(){
		driver.close();
	}
	
	@AfterSuite()
	public void driverclose() {
		System.out.println("test finished");
	}
	
}
