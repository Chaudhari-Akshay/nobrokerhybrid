package TestCases;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObject.AboutusPage;
import Resource.Base;

public class AboutUs extends Base {
	@BeforeTest
	public void btest() throws IOException{

		driver=InitializeDriver();

		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void Aboutus()
	{
		
		test.log(LogStatus.INFO,"Driver Initialized" );
		test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
		AboutusPage au=new AboutusPage(driver);
	au.Aboutus().click();
	test.log(LogStatus.INFO,"Clicked on About US" );
	au.Gettext().getText();
	System.out.println(au.Gettext().getText());
	test.log(LogStatus.INFO,"Details:"+au.Gettext().getText());
		
		test.log(LogStatus.PASS,"Test Passed" );
	}

		@AfterTest
		public void aftest() {

			driver.close();
			test.log(LogStatus.INFO,"Driver Closed" );
			extent.endTest(test);
		}
}
