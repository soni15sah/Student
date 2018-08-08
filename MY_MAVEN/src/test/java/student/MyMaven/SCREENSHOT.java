package student.MyMaven;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SCREENSHOT {
	public static void getScreenShot(WebDriver driver,String folderpath) {
		SimpleDateFormat s=new SimpleDateFormat("mm-dd-yyyy hh-mm-ss");
		String dateTime=s.format(new Date());
		TakesScreenshot shot=(TakesScreenshot) driver;
		File srcFile=shot.getScreenshotAs(OutputType.FILE);
		File desFile=new File(folderpath+"_"+dateTime+"_"+".png");
		try {
			FileUtils.copyFile(srcFile, desFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
				
		
	}

}
