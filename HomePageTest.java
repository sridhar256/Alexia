package com.alexiageriatrics.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.alexiageriatrics.ExtentReportListener.*;
import com.alexiageriatrics.base.TestBase;
import com.alexiageriatrics.pages.HomePage;
import com.alexiageriatrics.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToSite(prop.getProperty("email"), prop.getProperty("password"));	
		Thread.sleep(10000);
	}
	
	
	@Test(priority=1)
	public void verifyFullScreenIconTest() throws Exception {
		
		homePage.clickOnPatientInformation();
		homePage.clickOnMedicalRecordsReleaseForm();
		homePage.clickOnGeriatrics();
		homePage.clickOnHealthQuestionnaire();
		homePage.clickOnPatientHealthQuestionnaire();
		homePage.clickOnMorseFallScale();
		homePage.clickCHAMPSActivities();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
	

}
