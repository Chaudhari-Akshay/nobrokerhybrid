package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObject.LoginPage;
import Resource.Base;

public class Loginapp extends Base{

	

	
@BeforeTest
public void btest() throws IOException{

	driver=InitializeDriver();

	driver.get(prop.getProperty("url"));
	
	
}
	
@Test
public void Login()
{
	
	test.log(LogStatus.INFO,"Driver Initialized" );
	test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
	LoginPage lp=new LoginPage(driver);
	lp.Login().click();
	test.log(LogStatus.INFO,"clicked on login successfully" );
lp.Mobileno().sendKeys("9172926596");
test.log(LogStatus.INFO,"Entered Mobile no successfully" );
lp.UsePassword().click();
test.log(LogStatus.INFO,"Clicked on i have password" );
lp.Password().sendKeys("aksh1050");
test.log(LogStatus.INFO,"Entered Password" );
lp.Continue().click();
test.log(LogStatus.INFO,"Clicked on continue" );
test.log(LogStatus.PASS,"Test Passed");
	test.log(LogStatus.PASS,"Test Passed");
	
	
}

	@AfterTest
	public void aftest() {

		driver.close();
		test.log(LogStatus.INFO,"Driver Closed" );
		extent.endTest(test);
	}

}
