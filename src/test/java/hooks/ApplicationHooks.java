package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.baseDriver.BaseDriver;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	ConfigReader configreader;
	BaseDriver baseDriver;
	Properties prop;
	WebDriver driver;
	
	@Before(order=0)
	public void getReader() throws IOException {
		configreader = new ConfigReader();
		prop=configreader.configReader();
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browser= prop.getProperty("browser");
		baseDriver = new BaseDriver();
		driver=baseDriver.initializeBrowser(browser);
	}
	
	@After(order=0)
	public void closeBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
		 String scenarioName=	scenario.getName().replace(" ", "_");
		byte[] imagePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(imagePath, "image/png", scenarioName);
		}
		
	}

}
