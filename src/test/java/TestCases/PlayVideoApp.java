package TestCases;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObject.PlayVideo;
import Resource.Base;

public class PlayVideoApp extends Base{
	@BeforeTest
	public void btest() throws IOException{

		driver=InitializeDriver();

		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void PlayVideoapp() throws InterruptedException
	{
		
		test.log(LogStatus.INFO,"Driver Initialized" );
		test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
		PlayVideo p=new PlayVideo(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(5000);
         driver.switchTo().frame(0);
		p.Playvideo().click();
		Thread.sleep(5000);
		test.log(LogStatus.INFO,"Played The Video" );
		test.log(LogStatus.PASS,"Test Passed" );
	}

		@AfterTest
		public void aftest() {

			driver.close();
			test.log(LogStatus.INFO,"Driver Closed" );
			extent.endTest(test);
		}
}
