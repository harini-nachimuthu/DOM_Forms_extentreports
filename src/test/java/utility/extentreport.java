package utility;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreport {
 public static ExtentReports getreport() {
	 String path="C:\\Users\\harin\\eclipse-workspace\\DOM_Forms_1_Excelread_extentreport\\Reports\\index.html";
	 ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	 reporter.config().setReportName("DOM_forms_automations");
	 reporter.config().setDocumentTitle("Form_fill and edit");
	 reporter.config().setTheme(Theme.DARK);
	 
	 ExtentReports extent=new ExtentReports();
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Path for system info : ", path);
	 return extent;
	 
 }
}
