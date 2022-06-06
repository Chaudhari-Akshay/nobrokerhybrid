package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	WebDriver driver;
	
	public SignupPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class=\'nb__19hcF\'])[1]")
	@CacheLookup
	WebElement signup;
	
	
	//WebElement mono=driver.findElement(By.xpath("//input[@id=\'signUp-phoneNumber\']"));
	@FindBy(xpath="//input[@id=\'signUp-phoneNumber\']")
	@CacheLookup
	WebElement mono;
	
	@FindBy(xpath="//input[@id=\'login-signup-form__name-input\']")
	@CacheLookup
	WebElement name;
	@FindBy(xpath="//input[@id=\'login-signup-form__email-input\']")
	@CacheLookup
	WebElement email;
	@FindBy(xpath="//button[@id=\"signUpSubmit\"']")
	@CacheLookup
	WebElement btn;
	
	
	public WebElement SignUp(){
		return signup;
	}
	public WebElement Mobileno(){
		return mono;
	}
	public WebElement EnterName(){
		return name;
	}
	public WebElement EnterEmail(){
		return email;
	}
	public WebElement Signupbtn(){
		return btn;
	}
}
