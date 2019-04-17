package auto.utility;
/*
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Init {

	static Logger logger = Logger.getLogger(Init.class.getName());

	protected WebDriver driver = null;

	/**
	 * This function is used for doing web driver setup.
	 */
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		logger.info("# Setup.");
		FirefoxProfile ffprofile = createFirefoxProfile();
		driver = new FirefoxDriver(ffprofile);
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/**
	 * This function is quit the driver instance.
	 */
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		logger.info("# Teardown.");
		if (driver != null)
			driver.quit();

	}

	public FirefoxProfile createFirefoxProfile() {
		logger.info("# Setting up Firefox profile.");
		FirefoxProfile firefoxProfile = new FirefoxProfile();

		firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.dir", "E:\\git_projects\\download");
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/csv,application/pdf,application/vnd.ms-excel,application/octet-stream");
		firefoxProfile.setPreference("pdfjs.disabled", true);

		return firefoxProfile;
	}

}
