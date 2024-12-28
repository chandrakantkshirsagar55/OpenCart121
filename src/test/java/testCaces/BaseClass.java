package testCaces;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class BaseClass {

	public static WebDriver driver;
	HomePage homePage;
	public Properties p;
	
	AccountRegistrationPage registrationPage;
	public Logger logger;

	@Parameters({"browser"})
	@BeforeClass(groups="Sanity")
	public void setup(String browser) throws IOException {
		
		logger = LogManager.getLogger(Log4jExample.class);
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		// Set up ChromeDriver and initialize WebDriver

		if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Launching Chrome browser");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            logger.info("Launching Edge browser");
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
		

		// Navigate to the URL
		//driver.get("https://tutorialsninja.com/demo/");

		driver.get(p.getProperty("url"));

		// Initialize Page Objects
		homePage = new HomePage(driver);
		registrationPage = new AccountRegistrationPage(driver);
	}

	@AfterClass(groups="Sanity")
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public String captureScreen(String testName) {
        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(destinationPath);
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationPath;
    }

}
