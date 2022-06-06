package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyPage {
WebDriver driver;
	
	public BuyPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\'nb__17yFj nb__3_XZ6\']")
	WebElement buy;
	
	public WebElement ClkBuy(){
		return buy;
	}
	
	@FindBy(xpath="//div[@id=\'searchCity\']")
	WebElement loc;
	
	public WebElement Location(){
		return loc;
	}
	@FindBy(xpath="//input[@id=\'listPageSearchLocality\']")
	WebElement locality;
	
	public WebElement Locality(){
		return locality;
	}
	@FindBy(xpath="//button[@class=\'prop-search-button btn btn-primary btn-lg\']")
	WebElement search;
	
	public WebElement searchbtn(){
		return search;
	}
	
}
