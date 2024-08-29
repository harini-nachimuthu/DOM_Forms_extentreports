package basemethod;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.utility;

public class basemethod extends utility {
	
	//@Parameters({"browser","url"})
	
	@BeforeSuite
	public void beforemethod1() {
		launchbrowser("chrome");
		launchurl("https://nifty-leakey-10bea0.netlify.app/");
	}
	
//	@AfterSuite
//	public void Aftermethod1() {
//		closebrowser();
//	}
	
	@DataProvider(name="readingdatafromexcel")
	public String[][] excelread() throws IOException{
		String datas[][]=readexcel(sheetname,excelsheet);
		return datas;
	}
	
}
