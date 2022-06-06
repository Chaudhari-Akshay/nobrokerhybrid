package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Builderhomeproject {
WebDriver driver;
	
	public Builderhomeproject(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='builderHomeTile']")
	WebElement newbp;
	
	public WebElement NewProject(){
		return newbp;
	}
	
	@FindBy(xpath="(//div[@class='nb__2p4w1'])[4]")
	WebElement pune;
	
	public WebElement slctPune(){
		return pune;
	}
	
	
}
