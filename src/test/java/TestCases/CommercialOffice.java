package TestCases;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObject.CommercialPage;
import Resource.Base;

public class CommercialOffice extends Base {
	@BeforeTest
	public void btest() throws IOException{

		driver=InitializeDriver();

		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void officecommercial()
	{
		test.log(LogStatus.INFO,"Driver Initialized" );
		test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
		CommercialPage c=new CommercialPage(driver);
		c.Commercial().click();
		test.log(LogStatus.INFO,"Clicked on Commercial" );
		c.office().click();
		Set<String> windows = driver.getWindowHandles();
		test.log(LogStatus.INFO,"Clicked on Commercial offices in pune" );
		for (String window : windows) 
		{ 
		driver.switchTo().window(window);
		}
		System.out.println(driver.getTitle());
		test.log(LogStatus.INFO,"Opens Page "+driver.getTitle() );
		test.log(LogStatus.PASS,"Test Passed" );
		
	}

		@AfterTest
		public void aftest() {

			driver.close();
			test.log(LogStatus.INFO,"Driver Closed" );
			extent.endTest(test);
		}
}
