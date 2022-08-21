package com.alexiageriatrics.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.alexiageriatrics.util.TestUtil;
import com.alexiageriatrics.util.WebEventListener;

public class TestBase{
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//Initialize properties 
	
	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\sridhar.j\\eclipse-workspace\\AlexiaGeriatrics\\src\\main\\java\\com\\alexiageriatrics\\config\\config.properties");
		prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// #Initialize Browser and URL #
	
	public static void initialization() throws InterruptedException {
		
	String downloadFilepath = "C:\\Users\\sridhar.j\\eclipse-workspace\\AlexiaGeriatrics\\src\\main\\java\\com\\alexiageriatrics";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        
        FirefoxOptions options1 = new FirefoxOptions();
        options1.addPreference("browser.download.dir", downloadFilepath);
        options1.addPreference("browser.download.folderList",2);
        options1.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
                 
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\chromedriver.exe");
			driver = new FirefoxDriver(options1);
		}
		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\BrowserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Browsername is invalid");
		}
		Thread.sleep(3000);
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);	
	}
}
