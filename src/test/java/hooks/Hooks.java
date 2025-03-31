package hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.pages.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;
	Properties p;
	@Before
	public void setup() throws IOException
	{
		driver=Base.initilizeBrowser();
		p=Base.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}


	@After(order = 0)
	public void tearDown() {
		driver.quit();
	}

	@After(order = 1)
	public void screnshot(Scenario scenario ) {
		if (scenario.isFailed()) {
			TakesScreenshot t=  (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			File dest = new File(System.getProperty("user.dir")+"/Screenshots/"+scenario.getName()+".png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
