package TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObject.Builderhomeproject;
import Resource.Base;

public class BuilderHome extends Base {
	@BeforeTest
	public void btest() throws IOException{

		driver=InitializeDriver();

		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void NewProject()
	{
		
		test.log(LogStatus.INFO,"Driver Initialized" );
		test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
		Builderhomeproject np=new Builderhomeproject(driver);
		np.NewProject().click();
		test.log(LogStatus.INFO,"Clicked on New Builder Projects" );
		np.slctPune().click();
		test.log(LogStatus.INFO,"Clicked on pune" );
		if(driver.getTitle().contains("New Projects in Pune")) {
			test.log(LogStatus.PASS,"Test Passed");
		}else {
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL,"Test Failed");
		}
		test.log(LogStatus.PASS,"Test Passed" );

		
		
		
	}

		@AfterTest
		public void aftest() {

			driver.close();
			test.log(LogStatus.INFO,"Driver Closed" );
			extent.endTest(test);
		}
}
