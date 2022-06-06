package TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObject.Payrent;
import Resource.Base;

public class PayRentapp extends Base{
	@BeforeTest
	public void btest() throws IOException{

		driver=InitializeDriver();

		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void Payrent() throws InterruptedException
	{
		
		test.log(LogStatus.INFO,"Driver Initialized" );
		test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
		Payrent p=new Payrent(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		p.PayRent().click();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		String parent=I1.next();
		String child=I1.next();
		driver.switchTo().window(child);
		test.log(LogStatus.INFO,"Cliked on Payrent" );
		p.Name().sendKeys("Akshay");
		test.log(LogStatus.INFO,"Filled the name " );
		p.Mobileno().sendKeys("888888888");
		test.log(LogStatus.INFO,"Filled the Number" );
	
		p.Getstarted().click();
		test.log(LogStatus.INFO,"Cliked on GetStarted" );
		test.log(LogStatus.PASS,"Test Passed" );
	}

		@AfterTest
		public void aftest() {

			driver.close();
			driver.quit();
			test.log(LogStatus.INFO,"Driver Closed" );
			extent.endTest(test);
		}
}
