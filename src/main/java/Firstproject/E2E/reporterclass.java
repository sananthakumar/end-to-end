package Firstproject.E2E;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reporterclass {

	
	public static ExtentReports getextentreporter() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("RESULTS");
		
		ExtentReports ext;
		//EXtenrtReports class is responsible for exporting results
		
		 ext=new ExtentReports();
		ext.attachReporter(reporter);
		ext.setSystemInfo("Tester" , "Ananth");
		return ext; 
	}
}
