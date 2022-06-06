package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommercialPage {
WebDriver driver;
	
	public CommercialPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class=\'heading-6 nb__3YrHu'])[5]")
	WebElement cmrcl;
	
	public WebElement Commercial(){
		return cmrcl;
	}
	
	@FindBy(xpath="//a[@href=\'/rent-office-space-in-pune_pune\']")
	WebElement office;
	
	public WebElement office(){
		return office;
	}
	
}
