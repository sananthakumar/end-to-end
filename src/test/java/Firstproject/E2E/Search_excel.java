package Firstproject.E2E;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Search_excel extends Base{
	
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
	
	
	@Test (dataProvider="excelsearchdata")
	public void search_excel(String s) throws InterruptedException {
		
		Home home=new Home(driver);
		
		home.search_box().clear();
		home.search_box().sendKeys(s);
//		if(home.search_box().isDisplayed()) {
//			System.out.println("Search box is displayed");
//		}
//		else {
//			System.out.println(" Search box Not displayed");
//	}
		home.serach_btn().click();
		System.out.println(s);
		home.search_box().clear();
		Thread.sleep(2000);
		System.out.println(s);
	
	}
	
	
	
	
	@DataProvider()
	public Object[] excelsearchdata() {
		Object[] data = null;
		int count = 0;
		int k=0,column=0,c=0;
		
		try {
			// File file = new File(); //creating a new file instance
			// FileInputStream fis = new FileInputStream();
			FileInputStream fname = new FileInputStream(
					"C:\\Users\\91999\\Downloads\\Selenium_learning\\flipkart_search.xlsx");
			// XSSFWorkbook wrkbook=new XSSFWorkbook();
						XSSFWorkbook wrkbook = new XSSFWorkbook(fname);
						 count=wrkbook.getNumberOfSheets();
						 data=new Object[4];
						
						for(int i=0;i<count;i++) {
							
							if(wrkbook.getSheetAt(i).getSheetName().equalsIgnoreCase("mobile")) {
								
								XSSFSheet sheet=wrkbook.getSheetAt(i);
								
								Iterator<Row> row=sheet.rowIterator();
								
								Row first=row.next();
								
								Iterator<Cell>ce =first.cellIterator();
								
								while(ce.hasNext()) {
									Cell value=ce.next();
									if (value.getStringCellValue().equalsIgnoreCase("mobile")) {
								System.out.println("Crossed mpboile if");	
									column = k;
								}
								k++;
								}
								System.out.println("Out of mobile while");
								
								while(row.hasNext())
								{
									System.out.println("inside while");
									Row r=row.next();
									data[c]=r.getCell(column).getStringCellValue();
								    c++;
								}
									
								}
							}
						
						}						
						 catch (Exception e) {
								e.printStackTrace();
								System.out.println("inside catch");
							}
						
for(int i=0;i<count;i++) {
System.out.println(data[i]);
}
		return data;
		
	}
	
	
	@AfterTest()
	public void aftertest(){
		driver.close();
	}


}
