package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObject.OwnerplanPage;
import Resource.Base;

public class OwnerPlansApp extends Base{
	@BeforeTest
	public void btest() throws IOException{

		driver=InitializeDriver();

		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void OwnerPlan()
	{
		
		test.log(LogStatus.INFO,"Driver Initialized" );
		test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
		OwnerplanPage op=new OwnerplanPage(driver);
		op.Menu().click();
		test.log(LogStatus.INFO,"clicked on Menu successfully" );
	op.OwnerPlan().click();
	test.log(LogStatus.INFO,"clicked on Owner Plan successfully" );
	if(driver.getTitle().contains("Owner Plans")) {
		test.log(LogStatus.PASS,"Test Passed");
	}else {
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL,"Test Failed");
	}

		
		
		
	}

		@AfterTest
		public void aftest() {

			driver.close();
			test.log(LogStatus.INFO,"Driver Closed" );
			extent.endTest(test);
		}
}
