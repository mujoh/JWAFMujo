package auto.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 19-Apr-19
 */
public class DriverFactory {
    private static Logger logger = getLogger(DriverFactory.class.getName());

    ChromeOptions options = new ChromeOptions();

    public WebDriver getDriver() {

        String browser = System.getProperty("browser");
        if (browser == null)
            browser = "chrome";
        logger.info("# WebDriver instance for browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--headless");
	    options.addArguments("--disable-gpu");
            return new ChromeDriver(options);
	}
        else if (browser.equalsIgnoreCase("ie"))
            return new InternetExplorerDriver();
        else {
            //FirefoxProfile ffprofile = createFirefoxProfile();
            return new FirefoxDriver();
        }
    }

    private FirefoxProfile createFirefoxProfile() {
        logger.info("# Setting up Firefox profile.");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", "E:\\git_projects\\download");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/pdf,application/vnd.ms-excel,application/octet-stream");
        firefoxProfile.setPreference("pdfjs.disabled", true);
        return firefoxProfile;
    }
}
