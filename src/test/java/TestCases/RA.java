package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObject.RentalAggreementPage;
import Resource.Base;

public class RA extends Base {
	@BeforeTest
	public void btest() throws IOException{

		driver=InitializeDriver();

		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void rentalagreement()
	{
		
		test.log(LogStatus.INFO,"Driver Initialized" );
		test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
		RentalAggreementPage ra=new RentalAggreementPage(driver);
	ra.Rentalagreement().click();
	test.log(LogStatus.INFO,"Clicked on rental aggreement" );
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	ra.Selectcity().click();
	test.log(LogStatus.INFO,"City Selected" );
		ra.CheckPrice().click();
		test.log(LogStatus.INFO,"Clicked on Cheak Price" );
		test.log(LogStatus.PASS,"Test Passed" );
	}

		@AfterTest
		public void aftest() {

			driver.close();
			test.log(LogStatus.INFO,"Driver Closed" );
			extent.endTest(test);
		}
}
