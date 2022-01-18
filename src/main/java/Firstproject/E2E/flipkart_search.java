package Firstproject.E2E;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class flipkart_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int c=0;
		int count = 0;
		int k=0,column=0;
		List<String>data1=new ArrayList();
		Object[] data=null;
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
								System.out.println(wrkbook.getSheetName(i));
								int row_c=0;
								Iterator<Row> row=sheet.iterator();
//								while(row.hasNext()) 
//								{
//						      	row_c+=1;
//								}
								System.out.println("Row cpunt----------"+row_c);
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
								System.out.println(column);
								
								System.out.println(first.getCell(column));
								while(row.hasNext())
								{
									
									System.out.println("inside while");
									Row r=row.next();
									System.out.println(r.getCell(column));
									data[c]=r.getCell(column);
									data1.add(r.getCell(column).getStringCellValue());
									c++;
								}
									
								}
							System.out.println("While finished");
							}
						for(int i=0;i<data.length;i++) {
							System.out.println(data[i]);
							}

						
						}						
						 catch (Exception e) {
								e.printStackTrace();
								System.out.println("inside catch");
							}
						
	}

}
