package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basemethod.basemethod;

public class Formfilling_page extends basemethod{
  
    WebDriverWait wait;
	

	@FindBy(id="fullname")
	WebElement web_fullname;
	
	@FindBy(id="empCode")
	WebElement empcode;
	
	@FindBy(id="salary")
	WebElement salary;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	public Formfilling_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
	}
	
	public Formfilling_page sendusername(String username) {
		webwait("fullname", username);
		return this;
	}
	
	public Formfilling_page sendempcode(String empcode) {
		webwait("empCode", empcode);
		return this;
	}
	
	public Formfilling_page sendsalary(String salary) {
		webwait("salary", salary);
		return this;
	}
	
	public Formfilling_page sendcity(String city) {
		webwait("city", city);
		return this;
	}
	
	public void formsubmit() {
		websubmit("//input[@type='submit']");
	}
    
	
	@FindBy(xpath="//body//table//tbody//tr//td[2]//table//tbody//tr[2]//td[5]//button[1]")
	WebElement namechange;
	
	@FindBy(xpath="//body//table//tbody//tr//td[2]//table//tbody//tr[3]//td[5]//button[1]")
	WebElement citychange;
	
	@FindBy(xpath="//body//table//tbody//tr//td[2]//table//tbody//tr[4]//td[5]//button[1]")
	WebElement salarychange;
	
	@FindBy(xpath="//body//table//tbody//tr//td[2]//table//tbody//tr[5]//td[5]//button[1]")
	WebElement namechange1;
   
	public Formfilling_page namechange() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(namechange));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	    Thread.sleep(1000);
	    web_fullname.clear();
	    webwait("fullname", "Abinaya");
	    formsubmit();
	    Thread.sleep(2000);
		return new Formfilling_page(driver);
	}
	
	public Formfilling_page salarychange() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(salarychange));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	    Thread.sleep(1000);
	    salary.clear();
	    webwait("salary", "54000");
	    formsubmit();
	    Thread.sleep(2000);
		return new Formfilling_page(driver);
	}
	
	public Formfilling_page citychange() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(citychange));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	    Thread.sleep(1000);
	    city.clear();
	    webwait("city", "Delhi");
	    formsubmit();
	    Thread.sleep(2000);
		return new Formfilling_page(driver);
	}
	
	public Formfilling_page namechange1() throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(namechange1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	    Thread.sleep(1000);
	    web_fullname.clear();
	    webwait("fullname", "Rajewari");
	    formsubmit();
	    Thread.sleep(2000);
	    return new Formfilling_page(driver);
	}
	
	
}
