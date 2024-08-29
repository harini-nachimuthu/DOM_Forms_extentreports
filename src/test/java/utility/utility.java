package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utility {
  
	public WebDriver driver=null;
	public String excelsheet;
	public String sheetname;
	
	public void launchbrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
	}
	
	public void launchurl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void newdetailsbyid(String idfullname,String fullname) {
		driver.findElement(By.id(idfullname)).sendKeys(fullname);;
	}
	
	public void firstsubmitclick(WebElement ele) {
		ele.click();
	}
	
	public void quitbrowser() {
		driver.quit();
	}
	
	public void closebrowser() {
		driver.close();
	}
	
	public String[][] readexcel(String sheetname, String excelsheet) throws IOException {
	    XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\harin\\eclipse-workspace\\DOM_Forms_1_Excelread\\Excel_sheet\\"+sheetname+".xlsx");
	    XSSFSheet sheet = book.getSheet(excelsheet);

	    int rowcount = sheet.getLastRowNum();
	    int columncount = sheet.getRow(0).getLastCellNum();
	    String data1[][] = new String[rowcount][columncount];

	    for (int i = 1; i <= rowcount; i++) {
	        XSSFRow row = sheet.getRow(i);
	        for (int j = 0; j < columncount; j++) {
	            XSSFCell cellnum = row.getCell(j); 
	            String cellValue = "";

	            if (cellnum!=null) { 
	                switch (cellnum.getCellType()) {
	                    case STRING:
	                        cellValue = cellnum.getStringCellValue();
	                        break;
	                    case NUMERIC:
	                        cellValue = String.valueOf(cellnum.getNumericCellValue());
	                        break;
	                    case BOOLEAN:
	                        cellValue = String.valueOf(cellnum.getBooleanCellValue());
	                        break;
	                    case FORMULA:
	                        cellValue = cellnum.getCellFormula();
	                        break;
	                    default:
	                        cellValue = "";
	                }
	            }

	            data1[i-1][j] = cellValue;
	        }
	    }
	    book.close();
	    return data1;
	}
	
	public void webwait(String id,String idname) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement idvalues= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		idvalues.sendKeys(idname);
	}
	
	public void websubmit(String xpathname) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathname))).click();
		
	}
	
	public void newdetailsbyxpath(String xpathname) {
		WebElement clickopt=driver.findElement(By.id(xpathname));
		clickopt.click();
	}
	
	public void usernamedatclear(String id) {
		driver.findElement(By.id(id)).clear();
	}
	
	public String takeScreenshot(String screenshotname) throws IOException {
		Date d=new Date();
		String date=d.toString();
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String time=new SimpleDateFormat("YYYYMMDD").format(new Date());
		String path="C:\\Users\\harin\\eclipse-workspace\\DOM_Forms_1_Excelread_extentreport\\Screenshot"+screenshotname+".jpg";
		File des=new File(path);
		FileUtils.copyFile(src, des);
		return path;
		
	}
}
