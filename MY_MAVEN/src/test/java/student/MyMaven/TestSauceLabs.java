package student.MyMaven;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestSauceLabs {

	public static final String USERNAME="soni15sah";
	public static final String ACCESS_KEY="52e7dd09-20a8-44aa-bc63-dd4500081ba2";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps=DesiredCapabilities.chrome();
		caps.setCapability("platform","Windows 10");
		caps.setCapability("Version","54.0");
		WebDriver driver=new RemoteWebDriver(new java.net.URL(URL),caps);
		driver.get("http://www.google.com/");
		WebElement ele = driver.findElement(By.name("q"));
		ele.sendKeys("Automation");
		ele.sendKeys(Keys.ENTER);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(3000);
		driver.close();
		
	}

	}


