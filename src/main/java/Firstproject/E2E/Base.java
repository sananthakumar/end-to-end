package Firstproject.E2E;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	 public WebDriver driver;
	 public Properties prop;
	 
	 
	 public String url() throws IOException {
		  prop=new Properties();
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Properties");
	        prop.load(file);
	        String url=prop.getProperty("url");
			return url;	
	 }
	public WebDriver setdriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Properties");
        prop.load(file);	
        String browser=System.getProperty("browser");
       //String browser= prop.getProperty("browser");
       System.out.println(browser);
       
       if(browser.contains("chrome")) {
    	   System.setProperty("webdriver.chrome.driver",
   				System.getProperty("user.dir")+"\\\\resources\\chromedriver.exe");
    	   ChromeOptions options=new ChromeOptions();
//Headless mode code
    	   //    	   ChromeOptions options=new ChromeOptions();
//    	   options.addArguments("--headless");
//   		 driver=new ChromeDriver(options);
    	   if(browser.contains("headless"))
    		   options.addArguments("headless");
    	   driver =new ChromeDriver(options);
       }
       
       else if(browser.equalsIgnoreCase("firefox")) {
    	   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\resources\\geckodriver.exe");
			//Creating webdriver
			 driver=new FirefoxDriver();
       }
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
       return driver;	
       
	}
	public String getscreenshot(String name,WebDriver driver) throws IOException {
		TakesScreenshot scrshot=(TakesScreenshot)driver;
		File src=scrshot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String path=System.getProperty("user.dir")+"\\reports\\"+name+timeStamp+".png";
		FileUtils.copyFile(src,new File(path));
		return path;
	}

}
