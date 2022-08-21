package com.alexiageriatrics.testcases;


import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opensymphony.xwork2.Action;
import com.alexiageriatrics.util.TestUtil;
import com.alexiageriatrics.ExtentReportListener.*;
import com.alexiageriatrics.base.TestBase;
import com.alexiageriatrics.pages.HomePage;
import com.alexiageriatrics.pages.LoginPage;
import com.alexiageriatrics.pages.PatientAcknowledgementPage;

public class HealthQuestionnaireAllergiesVaccine extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public HealthQuestionnaireAllergiesVaccine() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("PatientAcknowledgement");
	}


	@Test(priority=1)
	public void verifySaveDataHealthQuestionnaire() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifySaveDataHealthQuestionnaire_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataHealthQuestionnaire_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifySaveDataHealthQuestionnaire_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataHealthQuestionnaire_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifySaveDataHealthQuestionnaire_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataHealthQuestionnaire_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement healthQuestionnaire = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		healthQuestionnaire.click();
		Thread.sleep(3000);	
		
		WebElement AddButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		js.executeScript("arguments[0].scrollIntoView();", AddButton);
		Thread.sleep(3000);	

		WebElement selectAllergies = driver.findElement(By.xpath("(//span[@class='dropdown-multiselect__caret'])[2]"));
		selectAllergies.click();
		Thread.sleep(3000);	
		
		WebElement selectAllAllergies = driver.findElement(By.xpath("(//ng-multiselect-dropdown[@formcontrolname='HQ_allergies']/div/div[2]/ul/li[1])[1]"));
		if (!selectAllAllergies.isSelected()){
			System.out.println("Select All checkbox is selected");  
			js.executeScript("arguments[0].click();", selectAllAllergies);
		}
		else {
			System.out.println("Select All checkbox is not selected");
		}
		Thread.sleep(3000);	
		
		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	
		
		WebElement healthQuestionnaire1 = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		healthQuestionnaire1.click();
		Thread.sleep(3000);	
		
		WebElement AddButton1 = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		js.executeScript("arguments[0].scrollIntoView();", AddButton1);
		Thread.sleep(3000);	
		
		WebElement tetanusTdYearOfLastOpen= driver.findElement(By.xpath("(//ng-select[@formcontrolname='year_of_last'])[1]"));
		Select tetanusTdYearOfLastValue = new Select(tetanusTdYearOfLastOpen);
		tetanusTdYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement influenzaFluYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[2]"));
		Select influenzaFluYearOfLastValue = new Select(influenzaFluYearOfLastOpen);
		influenzaFluYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement pneumoniaYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[3]"));
		Select pneumoniaYearOfLastValue = new Select(pneumoniaYearOfLastOpen);
		pneumoniaYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement hepatitisYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[4]"));
		Select hepatitisYearOfLastValue = new Select(hepatitisYearOfLastOpen);
		hepatitisYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement shinglesYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[5]"));
		Select shinglesYearOfLastValue = new Select(shinglesYearOfLastOpen);
		shinglesYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement hPVYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[6]"));
		Select hPVYearOfLastValue = new Select(hPVYearOfLastOpen);
		hPVYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement colonosCopyYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[7]"));
		Select colonosCopyYearOfLastValue = new Select(colonosCopyYearOfLastOpen);
		colonosCopyYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement rectalExamPSAYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[8]"));
		Select rectalExamPSAYearOfLastValue = new Select(rectalExamPSAYearOfLastOpen);
		rectalExamPSAYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement mammogramYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[9]"));
		Select mammogramYearOfLastValue = new Select(mammogramYearOfLastOpen);
		mammogramYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement tBTestYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[10]"));
		Select tBTestYearOfLastValue = new Select(tBTestYearOfLastOpen);
		tBTestYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement papSmearYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[11]"));
		Select papSmearYearOfLastValue = new Select(papSmearYearOfLastOpen);
		papSmearYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement boneDensityYearOfLastOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year_of_last'])[12]"));
		Select boneDensityYearOfLastValue = new Select(boneDensityYearOfLastOpen);
		boneDensityYearOfLastValue.selectByValue("2015");
		Thread.sleep(3000);
		
		WebElement update1 = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update1.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup1 = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup1.click();
		Thread.sleep(3000);	

	}


	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
