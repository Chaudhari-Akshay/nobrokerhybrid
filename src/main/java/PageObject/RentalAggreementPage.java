package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentalAggreementPage {

	WebDriver driver;
		
		public RentalAggreementPage(WebDriver driver) {
			this.driver=driver;
		PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//a[@href=\'/rental-agreement\']")
		WebElement ra;
		@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
		WebElement price;
		@FindBy(xpath="(//div[@class='flex flex-col items-center nb__4kuzs'])[4]")
		WebElement pune;
		
		
		public WebElement Rentalagreement(){
			return ra;
		}
		public WebElement CheckPrice(){
			return price;
		}
		public WebElement Selectcity(){
			return price;
		}

}
