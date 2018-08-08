package student.MyMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class APPLICATION {
	public WebDriver driver;

	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");

	}

	@Test
	public void testScript() {
		String title = driver.getTitle();
		WebElement ele = driver.findElement(By.name("q"));
		
		if (title.equals("Google1111")) {
			Reporter.log("Test Fail", true);

		} else {
			Reporter.log("Test Pass", true);
			Assert.fail();

		}

	}

	@AfterMethod(alwaysRun = true)
	public void CLOSE(ITestResult r) {
		String path = "./image/";
		if (r.getStatus() == 2) {
			SCREENSHOT.getScreenShot(driver, path);
		}
		driver.close();

	}

}
