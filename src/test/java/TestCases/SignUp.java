package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import PageObject.SignupPage;
import Resource.Base;

public class SignUp extends Base {
	@BeforeTest
	public void btest() throws IOException{

		driver=InitializeDriver();

		driver.get(prop.getProperty("url"));
		
		
	}
		
	@Test
	public void Signup()
	{
		
		test.log(LogStatus.INFO,"Driver Initialized" );
		test.log(LogStatus.INFO,"the current url of the web page :: "+prop.getProperty("url"));
		SignupPage sp=new SignupPage(driver);
		sp.SignUp().click();
		test.log(LogStatus.INFO,"clicked on SignUp successfully" );
			   sp.Mobileno().sendKeys("9172926596");
			 
			   test.log(LogStatus.INFO,"Entered Mobile Number" );
			 
			   if(sp.EnterName().isDisplayed()) {
				   sp.EnterName().sendKeys("Akshay");
				  
				  
				   test.log(LogStatus.INFO,"Enterd the Name" );
				   sp.EnterEmail().sendKeys("akshay@gmail.com");
						 
						   test.log(LogStatus.INFO,"Enterd the Email" );
						   sp.Signupbtn().click();
						   
						    test.log(LogStatus.INFO,"Clicked on Sign in Button" );
						   
					}else {
						test.log(LogStatus.WARNING,"Already Have an Account" );
					}
		
			   test.log(LogStatus.PASS,"Test Passed");
		
	}

		@AfterTest
		public void aftest() {

			driver.close();
			test.log(LogStatus.INFO,"Driver Closed" );
			extent.endTest(test);
		}

}
