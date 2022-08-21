package com.alexiageriatrics.testcases;


import java.io.IOException;
import java.util.HashMap;

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
import com.alexiageriatrics.ExtentReportListener.*;
import com.alexiageriatrics.base.TestBase;
import com.alexiageriatrics.pages.HomePage;
import com.alexiageriatrics.pages.LoginPage;
import com.alexiageriatrics.util.TestUtil;


public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;


	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("LoginPageData");
	}
	
	@Test(priority=1, enabled=true)
	public void LoginTestCase1() throws Exception {

		homePage = loginPage.loginToSite(prop.getProperty("email"), prop.getProperty("password"));		 
		extent = ExtentReportManager.getReports();

		loginPage.verifyEmail();
		loginPage.verifyPassword();
		loginPage.verifysignInBtn();
		
		Thread.sleep(10000);
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}

