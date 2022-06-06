package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {
	public WebDriver driver;
	public Properties prop ;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeMethod
	public void bmethod(Method method) {
		test = extent.startTest((this.getClass().getSimpleName() + "::" + method.getName()), method.getName());
		test.assignAuthor("Akshay Chaudhari");
	}
	@BeforeSuite
	public void beforesuit() {
		extent=new ExtentReports(".\\Extentreports\\MyExtentReport.html",true);
		extent.loadConfig(new File(".\\Extentreports//extent-config.xml"));
	}
	public WebDriver InitializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				".\\src\\main\\java\\Resource\\data.properties");
		prop.load(fis);

		String browsername =prop.getProperty("browser");
		
		System.out.println(browsername);

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					".\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {

		 //System.setProperty("webdriver.gecko.driver","");
			//driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver","");
			//driver=new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
			return driver;
	}
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	               
	                String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "/TestsScreenshots/"+screenshotName+dateName+".png";
			File finalDestination = new File("."+ "/TestsScreenshots/"+screenshotName+dateName+".png");
			FileUtils.copyFile(source, finalDestination);
			return destination;
	}
	public void BrowserStackReadExcelTest()throws IOException{
		//Path of the excel file
		FileInputStream fs = new FileInputStream(".//Excelfile//testdata.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row1 = sheet.getRow(0);
		Cell cell1 = row1.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		Row row2 = sheet.getRow(1);
		
		}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		String screenshotPath = Base.getScreenshot(driver, result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
		test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());

			

			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}else if (result.getStatus() == ITestResult.SUCCESS) {
		test.log(LogStatus.PASS, test.addScreenCapture(screenshotPath));
		}
		extent.endTest(test);
	}      
	
	@AfterSuite
	public void aftersuit() {
		driver.quit();
		extent.flush();
		extent.close();
	}
}
