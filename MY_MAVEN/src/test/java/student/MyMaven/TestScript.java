package student.MyMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScript {
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		extent=ExtentManager.GetExtent();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");

	}
	@Test
	public void checkGoogle() {
		try {
			driver.get("https://www.google.com/");
			test=extent.createTest("Google","verify Homepage");
			String title =driver.getTitle();
			if (title.contains("Google")) {
				test.pass("Contains Title as Google");
				
				
			} else {
				test.log(Status.FAIL,"Doesnot Contains Title as Google");

			}
			
		} catch (Exception e) {
			test.log(Status.ERROR,e.getMessage());
			
		}
		@AfterMethod
		public void tearDown() {
			extent.flush();
			driver.quit();
		}
		
		
	}

}
