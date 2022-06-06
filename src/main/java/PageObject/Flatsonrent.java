package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flatsonrent {
	WebDriver driver;
	
	public Flatsonrent(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\'heading-6 nb__3YrHu nb__3S6MT\']")
	WebElement forent;
	@FindBy(xpath="(//a[@class='nb__1pJSa'])[39]")
	WebElement forkharadi;
	
	
	
	
	public WebElement Flatsonrent(){
		return forent;
	}
	public WebElement ForInKharadi(){
		return forkharadi;
	}
	
}
