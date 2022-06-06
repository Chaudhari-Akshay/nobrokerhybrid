package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObject.Flatsonrent;
import Resource.Base;

public class FlatsOnRent extends Base{
	@BeforeTest
	public void btest() throws IOException{

		driver=InitializeDriver();

		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void Flatonrent()
	{
		
		test.log(LogStatus.INFO,"Driver Initialized" );
		test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
		Flatsonrent f=new Flatsonrent(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		f.Flatsonrent().click();
		test.log(LogStatus.INFO,"Clicked on Flats on Rent" );
		f.ForInKharadi().click();
		test.log(LogStatus.INFO,"Clicked on Flats on Rent In Kharadi" );
		
		
	}

		@AfterTest
		public void aftest() {

			driver.close();
			driver.quit();
			test.log(LogStatus.INFO,"Driver Closed" );
			extent.endTest(test);
		}
}
