package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import basemethod.basemethod;
import Pages.Formfilling_page;

public class formfilling_Tests extends basemethod {

    
	@BeforeTest
    public void beforetest1() {
        sheetname = "DOM_Form_1";
        excelsheet = "Form1";
    }

    @Test(dataProvider = "readingdatafromexcel",priority=1)
    public void afterformfill(String username, String password, String salary, String city) throws InterruptedException {
        Formfilling_page formfill = new Formfilling_page(driver);
        formfill.sendusername(username);
        formfill.sendempcode(password);
        formfill.sendsalary(salary);
        formfill.sendcity(city);
        Thread.sleep(1000);
        formfill.formsubmit();
        Thread.sleep(2000);
    }
    
    @Test(priority=2)    
    public void edit() throws InterruptedException {
    	Formfilling_page formfill1 = new Formfilling_page(driver);
    	formfill1.namechange();
    	formfill1.citychange();
    	formfill1.salarychange();
    	formfill1.namechange1();
    }
}
