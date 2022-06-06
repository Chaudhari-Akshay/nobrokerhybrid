package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage{
	
		WebDriver driver;
			
			public LoginPage(WebDriver driver) {
				this.driver=driver;
			PageFactory.initElements(driver, this);
			}
			
			@FindBy(xpath="(//div[@class='nb__19hcF'])[2]")
			WebElement Login;
			@FindBy(xpath="//input[@id='signUp-phoneNumber']")
			WebElement mono;
			
			@FindBy(xpath="//button[@id=\'signUpSubmit\']")
			WebElement cont;
			@FindBy(xpath="//input[@id=\'login-signup-form-login-radio-password\']")
			WebElement redio;
			@FindBy(xpath="//input[@id=\'login-signup-form__password-input\']")
			WebElement pass;
			
			
			public WebElement Login(){
				return Login;
			}
			public WebElement Mobileno(){
				return mono;
			}
			public WebElement Continue(){
				return cont;
			}
			public WebElement UsePassword(){
				return redio;
			}
			public WebElement Password(){
				return pass;
			}
		}

