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

public class HealthQuestionnaireMedicalHistory extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public HealthQuestionnaireMedicalHistory() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
	}


	@Test(priority=1)
	public void verifySaveDataHealthQuestionnaireMedicalHistory() throws Exception {
		
		tcData = TestUtil.readDataFromTC("HealthQuestionnaire");
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifySaveDataHealthQuestionnaireMedicalHistory_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataHealthQuestionnaireMedicalHistory_TC_01): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifySaveDataHealthQuestionnaireMedicalHistory_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataHealthQuestionnaireMedicalHistory_TC_02): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifySaveDataHealthQuestionnaireMedicalHistory_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataHealthQuestionnaireMedicalHistory_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement healthQuestionnaire = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		healthQuestionnaire.click();
		Thread.sleep(3000);	

		WebElement  heartMurmur  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[1]"));
		if (!heartMurmur.isSelected()){
			System.out.println("heartMurmur checkbox is selected");  
			js.executeScript("arguments[0].click();", heartMurmur);
		}
		else {
			System.out.println("heartMurmur checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement heartMurmurAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[1]"));
		heartMurmurAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		heartMurmurAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		
		WebElement  swollenAnkles  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[2]"));
		if (!swollenAnkles.isSelected()){
			System.out.println("swollenAnkles checkbox is selected");  
			js.executeScript("arguments[0].click();", swollenAnkles);
		}
		else {
			System.out.println("swollenAnkles checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement swollenAnklesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[2]"));
		swollenAnklesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		swollenAnklesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		WebElement  IrregularPulse  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[3]"));
		if (!IrregularPulse.isSelected()){
			System.out.println("IrregularPulse checkbox is selected");  
			js.executeScript("arguments[0].click();", IrregularPulse);
		}
		else {
			System.out.println("IrregularPulse checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement IrregularPulseAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[3]"));
		IrregularPulseAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		IrregularPulseAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		WebElement  palpitations  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[4]"));
		if (!palpitations.isSelected()){
			System.out.println("palpitations checkbox is selected");  
			js.executeScript("arguments[0].click();", palpitations);
		}
		else {
			System.out.println("palpitations checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement palpitationsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[4]"));
		palpitationsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		palpitationsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		
		WebElement  shortnessOfBreath  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[5]"));
		if (!shortnessOfBreath.isSelected()){
			System.out.println("shortnessOfBreath checkbox is selected");  
			js.executeScript("arguments[0].click();", shortnessOfBreath);
		}
		else {
			System.out.println("shortnessOfBreath checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement shortnessOfBreathAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[5]"));
		shortnessOfBreathAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		shortnessOfBreathAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		
		WebElement  legPain  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[6]"));
		if (!legPain.isSelected()){
			System.out.println("legPain checkbox is selected");  
			js.executeScript("arguments[0].click();", legPain);
		}
		else {
			System.out.println("legPain checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement legPainAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[6]"));
		legPainAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		legPainAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		
		WebElement  shortnessOfBreathOnExertion  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[7]"));
		if (!shortnessOfBreathOnExertion.isSelected()){
			System.out.println("shortnessOfBreathOnExertion checkbox is selected");  
			js.executeScript("arguments[0].click();", shortnessOfBreathOnExertion);
		}
		else {
			System.out.println("shortnessOfBreathOnExertion checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement shortnessOfBreathOnExertionAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[7]"));
		shortnessOfBreathOnExertionAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		shortnessOfBreathOnExertionAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  shortnessOfBreathLyingFlat  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[8]"));
		if (!shortnessOfBreathLyingFlat.isSelected()){
			System.out.println("shortnessOfBreathLyingFlat checkbox is selected");  
			js.executeScript("arguments[0].click();", shortnessOfBreathLyingFlat);
		}
		else {
			System.out.println("shortnessOfBreathLyingFlat checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement shortnessOfBreathLyingFlatAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[8]"));
		shortnessOfBreathLyingFlatAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		shortnessOfBreathLyingFlatAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  mentalIllness  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[9]"));
		if (!mentalIllness.isSelected()){
			System.out.println("mentalIllness checkbox is selected");  
			js.executeScript("arguments[0].click();", mentalIllness);
		}
		else {
			System.out.println("mentalIllness checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement mentalIllnessAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[9]"));
		mentalIllnessAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		mentalIllnessAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  germanMeasles  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[10]"));
		if (!germanMeasles.isSelected()){
			System.out.println("germanMeasles checkbox is selected");  
			js.executeScript("arguments[0].click();", germanMeasles);
		}
		else {
			System.out.println("germanMeasles checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement germanMeaslesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[10]"));
		germanMeaslesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		germanMeaslesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  lossOfAppetite  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[11]"));
		if (!lossOfAppetite.isSelected()){
			System.out.println("lossOfAppetite checkbox is selected");  
			js.executeScript("arguments[0].click();", lossOfAppetite);
		}
		else {
			System.out.println("lossOfAppetite checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement lossOfAppetiteAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[11]"));
		lossOfAppetiteAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		lossOfAppetiteAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  difficultySwallowing  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[12]"));
		if (!difficultySwallowing.isSelected()){
			System.out.println("difficultySwallowing checkbox is selected");  
			js.executeScript("arguments[0].click();", difficultySwallowing);
		}
		else {
			System.out.println("difficultySwallowing checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement difficultySwallowingAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[12]"));
		difficultySwallowingAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		difficultySwallowingAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  heartburn  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[13]"));
		if (!heartburn.isSelected()){
			System.out.println("heartburn checkbox is selected");  
			js.executeScript("arguments[0].click();", heartburn);
		}
		else {
			System.out.println("heartburn checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement heartburnAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[13]"));
		heartburnAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		heartburnAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  pepticUlcer  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[14]"));
		if (!pepticUlcer.isSelected()){
			System.out.println("pepticUlcer checkbox is selected");  
			js.executeScript("arguments[0].click();", pepticUlcer);
		}
		else {
			System.out.println("pepticUlcer checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement pepticUlcerAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[14]"));
		pepticUlcerAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		pepticUlcerAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  nauseaVomiting  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[15]"));
		if (!nauseaVomiting.isSelected()){
			System.out.println("nauseaVomiting checkbox is selected");  
			js.executeScript("arguments[0].click();", nauseaVomiting);
		}
		else {
			System.out.println("nauseaVomiting checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement nauseaVomitingAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[15]"));
		nauseaVomitingAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		nauseaVomitingAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  abdominalPain  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[16]"));
		if (!abdominalPain.isSelected()){
			System.out.println("abdominalPain checkbox is selected");  
			js.executeScript("arguments[0].click();", abdominalPain);
		}
		else {
			System.out.println("abdominalPain checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement abdominalPainAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[16]"));
		abdominalPainAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		abdominalPainAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  gallbladderTrouble  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[17]"));
		if (!gallbladderTrouble.isSelected()){
			System.out.println("gallbladderTrouble checkbox is selected");  
			js.executeScript("arguments[0].click();", gallbladderTrouble);
		}
		else {
			System.out.println("gallbladderTrouble checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement gallbladderTroubleAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[17]"));
		gallbladderTroubleAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		gallbladderTroubleAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  jaundiceHepatitis  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[18]"));
		if (!jaundiceHepatitis.isSelected()){
			System.out.println("jaundiceHepatitis checkbox is selected");  
			js.executeScript("arguments[0].click();", jaundiceHepatitis);
		}
		else {
			System.out.println("jaundiceHepatitis checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement jaundiceHepatitisAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[18]"));
		jaundiceHepatitisAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		jaundiceHepatitisAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  seizures  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[19]"));
		if (!seizures.isSelected()){
			System.out.println("seizures checkbox is selected");  
			js.executeScript("arguments[0].click();", seizures);
		}
		else {
			System.out.println("seizures checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement seizuresAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[19]"));
		seizuresAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		seizuresAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  stroke  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[20]"));
		if (!stroke.isSelected()){
			System.out.println("stroke checkbox is selected");  
			js.executeScript("arguments[0].click();", stroke);
		}
		else {
			System.out.println("stroke checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement strokeAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[20]"));
		strokeAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		strokeAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  diarrhea  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[21]"));
		if (!diarrhea.isSelected()){
			System.out.println("diarrhea checkbox is selected");  
			js.executeScript("arguments[0].click();", diarrhea);
		}
		else {
			System.out.println("diarrhea checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement diarrheaAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[21]"));
		diarrheaAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		diarrheaAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  constipation  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[22]"));
		if (!constipation.isSelected()){
			System.out.println("constipation checkbox is selected");  
			js.executeScript("arguments[0].click();", constipation);
		}
		else {
			System.out.println("constipation checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement constipationAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[22]"));
		constipationAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		constipationAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  iverticulosis  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[23]"));
		if (!iverticulosis.isSelected()){
			System.out.println("iverticulosis checkbox is selected");  
			js.executeScript("arguments[0].click();", iverticulosis);
		}
		else {
			System.out.println("iverticulosis checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement iverticulosisAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[23]"));
		iverticulosisAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		iverticulosisAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  crohnsUlcerativeColitis  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[24]"));
		if (!crohnsUlcerativeColitis.isSelected()){
			System.out.println("crohnsUlcerativeColitis checkbox is selected");  
			js.executeScript("arguments[0].click();", crohnsUlcerativeColitis);
		}
		else {
			System.out.println("crohnsUlcerativeColitis checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement crohnsUlcerativeColitisAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[24]"));
		crohnsUlcerativeColitisAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		crohnsUlcerativeColitisAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  iBS  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[25]"));
		if (!iBS.isSelected()){
			System.out.println("iBS checkbox is selected");  
			js.executeScript("arguments[0].click();", iBS);
		}
		else {
			System.out.println("iBS checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement iBSAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[25]"));
		iBSAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		iBSAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  bloodyTarryStools  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[26]"));
		if (!bloodyTarryStools.isSelected()){
			System.out.println("bloodyTarryStools checkbox is selected");  
			js.executeScript("arguments[0].click();", bloodyTarryStools);
		}
		else {
			System.out.println("bloodyTarryStools checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement bloodyTarryStoolsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[26]"));
		bloodyTarryStoolsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		bloodyTarryStoolsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  hemorrhoids  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[27]"));
		if (!hemorrhoids.isSelected()){
			System.out.println("hemorrhoids checkbox is selected");  
			js.executeScript("arguments[0].click();", hemorrhoids);
		}
		else {
			System.out.println("hemorrhoids checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement hemorrhoidsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[27]"));
		hemorrhoidsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		hemorrhoidsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  hernia  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[28]"));
		if (!hernia.isSelected()){
			System.out.println("hernia checkbox is selected");  
			js.executeScript("arguments[0].click();", hernia);
		}
		else {
			System.out.println("hernia checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement herniaAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[28]"));
		herniaAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		herniaAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  urinationIncontinence  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[29]"));
		if (!urinationIncontinence.isSelected()){
			System.out.println("urinationIncontinence checkbox is selected");  
			js.executeScript("arguments[0].click();", urinationIncontinence);
		}
		else {
			System.out.println("urinationIncontinence checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement urinationIncontinenceAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[29]"));
		urinationIncontinenceAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		urinationIncontinenceAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  urinationBlood  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[30]"));
		if (!urinationBlood.isSelected()){
			System.out.println("urinationBlood checkbox is selected");  
			js.executeScript("arguments[0].click();", urinationBlood);
		}
		else {
			System.out.println("urinationBlood checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement urinationBloodAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[30]"));
		urinationBloodAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		urinationBloodAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  tremorHandshaking  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[31]"));
		if (!tremorHandshaking.isSelected()){
			System.out.println("tremorHandshaking checkbox is selected");  
			js.executeScript("arguments[0].click();", tremorHandshaking);
		}
		else {
			System.out.println("tremorHandshaking checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement tremorHandshakingAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[31]"));
		tremorHandshakingAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tremorHandshakingAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  headaches  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[32]"));
		if (!headaches.isSelected()){
			System.out.println("headaches checkbox is selected");  
			js.executeScript("arguments[0].click();", headaches);
		}
		else {
			System.out.println("headaches checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement headachesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[32]"));
		headachesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		headachesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  numbness  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[33]"));
		if (!numbness.isSelected()){
			System.out.println("numbness checkbox is selected");  
			js.executeScript("arguments[0].click();", numbness);
		}
		else {
			System.out.println("numbness checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement numbnessAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[33]"));
		numbnessAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		numbnessAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  arthritisRheumatism  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[34]"));
		if (!arthritisRheumatism.isSelected()){
			System.out.println("arthritisRheumatism checkbox is selected");  
			js.executeScript("arguments[0].click();", arthritisRheumatism);
		}
		else {
			System.out.println("arthritisRheumatism checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement arthritisRheumatismAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[34]"));
		arthritisRheumatismAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		arthritisRheumatismAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  boneFractureJointInjury  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[35]"));
		if (!boneFractureJointInjury.isSelected()){
			System.out.println("boneFractureJointInjury checkbox is selected");  
			js.executeScript("arguments[0].click();", boneFractureJointInjury);
		}
		else {
			System.out.println("boneFractureJointInjury checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement boneFractureJointInjuryAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[35]"));
		boneFractureJointInjuryAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		boneFractureJointInjuryAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  osteoporosis  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[36]"));
		if (!osteoporosis.isSelected()){
			System.out.println("osteoporosis checkbox is selected");  
			js.executeScript("arguments[0].click();", osteoporosis);
		}
		else {
			System.out.println("osteoporosis checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement osteoporosisAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[36]"));
		osteoporosisAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		osteoporosisAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  backpain  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[37]"));
		if (!backpain.isSelected()){
			System.out.println("backpain checkbox is selected");  
			js.executeScript("arguments[0].click();", backpain);
		}
		else {
			System.out.println("backpain checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement backpainAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[37]"));
		backpainAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		backpainAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  gout  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[38]"));
		if (!gout.isSelected()){
			System.out.println("gout checkbox is selected");  
			js.executeScript("arguments[0].click();", gout);
		}
		else {
			System.out.println("gout checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement goutAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[38]"));
		goutAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		goutAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  footPain  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[39]"));
		if (!footPain.isSelected()){
			System.out.println("footPain checkbox is selected");  
			js.executeScript("arguments[0].click();", footPain);
		}
		else {
			System.out.println("footPain checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement footPainAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[39]"));
		footPainAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		footPainAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  rashes  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[40]"));
		if (!rashes.isSelected()){
			System.out.println("rashes checkbox is selected");  
			js.executeScript("arguments[0].click();", rashes);
		}
		else {
			System.out.println("rashes checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement rashesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[40]"));
		rashesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		rashesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  kidneyStones  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[41]"));
		if (!kidneyStones.isSelected()){
			System.out.println("kidneyStones checkbox is selected");  
			js.executeScript("arguments[0].click();", kidneyStones);
		}
		else {
			System.out.println("kidneyStones checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement kidneyStonesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[41]"));
		kidneyStonesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		kidneyStonesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  urineInfectionsFrequent  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[42]"));
		if (!urineInfectionsFrequent.isSelected()){
			System.out.println("urineInfectionsFrequent checkbox is selected");  
			js.executeScript("arguments[0].click();", urineInfectionsFrequent);
		}
		else {
			System.out.println("urineInfectionsFrequent checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement urineInfectionsFrequentAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[42]"));
		urineInfectionsFrequentAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		urineInfectionsFrequentAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  weightLossGain  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[43]"));
		if (!weightLossGain.isSelected()){
			System.out.println("weightLossGain checkbox is selected");  
			js.executeScript("arguments[0].click();", weightLossGain);
		}
		else {
			System.out.println("weightLossGain checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement weightLossGainAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[43]"));
		weightLossGainAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		weightLossGainAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  heightloss  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[44]"));
		if (!heightloss.isSelected()){
			System.out.println("heightloss checkbox is selected");  
			js.executeScript("arguments[0].click();", heightloss);
		}
		else {
			System.out.println("heightloss checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement heightlossAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[44]"));
		heightlossAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		heightlossAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  appetite  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[45]"));
		if (!appetite.isSelected()){
			System.out.println("appetite checkbox is selected");  
			js.executeScript("arguments[0].click();", appetite);
		}
		else {
			System.out.println("appetite checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement appetiteAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[45]"));
		appetiteAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		appetiteAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  anemia  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[46]"));
		if (!anemia.isSelected()){
			System.out.println("anemia checkbox is selected");  
			js.executeScript("arguments[0].click();", anemia);
		}
		else {
			System.out.println("anemia checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement anemiaAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[46]"));
		anemiaAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		anemiaAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  bruiseEasily  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[47]"));
		if (!bruiseEasily.isSelected()){
			System.out.println("bruiseEasily checkbox is selected");  
			js.executeScript("arguments[0].click();", bruiseEasily);
		}
		else {
			System.out.println("bruiseEasily checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement bruiseEasilyAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[47]"));
		bruiseEasilyAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		bruiseEasilyAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  bloodTransfusions  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[48]"));
		if (!bloodTransfusions.isSelected()){
			System.out.println("bloodTransfusions checkbox is selected");  
			js.executeScript("arguments[0].click();", bloodTransfusions);
		}
		else {
			System.out.println("bloodTransfusions checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement bloodTransfusionsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[48]"));
		bloodTransfusionsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		bloodTransfusionsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  cancer  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[49]"));
		if (!cancer.isSelected()){
			System.out.println("cancer checkbox is selected");  
			js.executeScript("arguments[0].click();", cancer);
		}
		else {
			System.out.println("cancer checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement cancerAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[49]"));
		cancerAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		cancerAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  easilyFatigued  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[50]"));
		if (!easilyFatigued.isSelected()){
			System.out.println("easilyFatigued checkbox is selected");  
			js.executeScript("arguments[0].click();", easilyFatigued);
		}
		else {
			System.out.println("easilyFatigued checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement easilyFatiguedAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[50]"));
		easilyFatiguedAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		easilyFatiguedAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  diabetes  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[51]"));
		if (!diabetes.isSelected()){
			System.out.println("diabetes checkbox is selected");  
			js.executeScript("arguments[0].click();", diabetes);
		}
		else {
			System.out.println("diabetes checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement diabetesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[51]"));
		diabetesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		diabetesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  hives  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[52]"));
		if (!hives.isSelected()){
			System.out.println("hives checkbox is selected");  
			js.executeScript("arguments[0].click();", hives);
		}
		else {
			System.out.println("hives checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement hivesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[52]"));
		hivesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		hivesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  psoriasis  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[53]"));
		if (!psoriasis.isSelected()){
			System.out.println("psoriasis checkbox is selected");  
			js.executeScript("arguments[0].click();", psoriasis);
		}
		else {
			System.out.println("psoriasis checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement psoriasisAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[53]"));
		psoriasisAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		psoriasisAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  eczema  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[54]"));
		if (!eczema.isSelected()){
			System.out.println("eczema checkbox is selected");  
			js.executeScript("arguments[0].click();", eczema);
		}
		else {
			System.out.println("eczema checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement eczemaAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[54]"));
		eczemaAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		eczemaAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  sexualProblems  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[55]"));
		if (!sexualProblems.isSelected()){
			System.out.println("sexualProblems checkbox is selected");  
			js.executeScript("arguments[0].click();", sexualProblems);
		}
		else {
			System.out.println("sexualProblems checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement sexualProblemsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[55]"));
		sexualProblemsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		sexualProblemsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  depression  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[56]"));
		if (!depression.isSelected()){
			System.out.println("depression checkbox is selected");  
			js.executeScript("arguments[0].click();", depression);
		}
		else {
			System.out.println("depression checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement depressionAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[56]"));
		depressionAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		depressionAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  nervousness  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[57]"));
		if (!nervousness.isSelected()){
			System.out.println("nervousness checkbox is selected");  
			js.executeScript("arguments[0].click();", nervousness);
		}
		else {
			System.out.println("nervousness checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement nervousnessAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[57]"));
		nervousnessAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		nervousnessAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  memoryLoss  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[58]"));
		if (!memoryLoss.isSelected()){
			System.out.println("memoryLoss checkbox is selected");  
			js.executeScript("arguments[0].click();", memoryLoss);
		}
		else {
			System.out.println("memoryLoss checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement memoryLossAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[58]"));
		memoryLossAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		memoryLossAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  rheumaticFever  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[59]"));
		if (!rheumaticFever.isSelected()){
			System.out.println("rheumaticFever checkbox is selected");  
			js.executeScript("arguments[0].click();", rheumaticFever);
		}
		else {
			System.out.println("rheumaticFever checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement rheumaticFeverAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[59]"));
		rheumaticFeverAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		rheumaticFeverAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  scarletFever  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[60]"));
		if (!scarletFever.isSelected()){
			System.out.println("scarletFever checkbox is selected");  
			js.executeScript("arguments[0].click();", scarletFever);
		}
		else {
			System.out.println("scarletFever checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement scarletFeverAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[60]"));
		scarletFeverAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		scarletFeverAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  chickenpox  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[61]"));
		if (!chickenpox.isSelected()){
			System.out.println("chickenpox checkbox is selected");  
			js.executeScript("arguments[0].click();", chickenpox);
		}
		else {
			System.out.println("chickenpox checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement chickenpoxAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[61]"));
		chickenpoxAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		chickenpoxAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  measles  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[62]"));
		if (!measles.isSelected()){
			System.out.println("measles checkbox is selected");  
			js.executeScript("arguments[0].click();", measles);
		}
		else {
			System.out.println("measles checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement measlesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[62]"));
		measlesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		measlesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  herpes  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[63]"));
		if (!herpes.isSelected()){
			System.out.println("herpes checkbox is selected");  
			js.executeScript("arguments[0].click();", herpes);
		}
		else {
			System.out.println("herpes checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement herpesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[63]"));
		herpesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		herpesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  polio  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[64]"));
		if (!polio.isSelected()){
			System.out.println("polio checkbox is selected");  
			js.executeScript("arguments[0].click();", polio);
		}
		else {
			System.out.println("polio checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement polioAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[64]"));
		polioAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		polioAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  mumps  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[65]"));
		if (!mumps.isSelected()){
			System.out.println("mumps checkbox is selected");  
			js.executeScript("arguments[0].click();", mumps);
		}
		else {
			System.out.println("mumps checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement mumpsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[65]"));
		mumpsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		mumpsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  tuberculosis  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[66]"));
		if (!tuberculosis.isSelected()){
			System.out.println("tuberculosis checkbox is selected");  
			js.executeScript("arguments[0].click();", tuberculosis);
		}
		else {
			System.out.println("tuberculosis checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement tuberculosisAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[66]"));
		tuberculosisAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tuberculosisAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  aIDSHIV  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[67]"));
		if (!aIDSHIV.isSelected()){
			System.out.println("aIDSHIV checkbox is selected");  
			js.executeScript("arguments[0].click();", aIDSHIV);
		}
		else {
			System.out.println("aIDSHIV checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement aIDSHIVAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[67]"));
		aIDSHIVAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		aIDSHIVAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  sTDs  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[68]"));
		if (!sTDs.isSelected()){
			System.out.println("sTDs checkbox is selected");  
			js.executeScript("arguments[0].click();", sTDs);
		}
		else {
			System.out.println("sTDs checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement sTDsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[68]"));
		sTDsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		sTDsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  sleepProblems  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[69]"));
		if (!sleepProblems.isSelected()){
			System.out.println("sleepProblems checkbox is selected");  
			js.executeScript("arguments[0].click();", sleepProblems);
		}
		else {
			System.out.println("sleepProblems checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement sleepProblemsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[69]"));
		sleepProblemsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		sleepProblemsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  hairLossRecent  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[70]"));
		if (!hairLossRecent.isSelected()){
			System.out.println("hairLossRecent checkbox is selected");  
			js.executeScript("arguments[0].click();", hairLossRecent);
		}
		else {
			System.out.println("hairLossRecent checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement hairLossRecentAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[70]"));
		hairLossRecentAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		hairLossRecentAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  hairLossProgressive  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[71]"));
		if (!hairLossProgressive.isSelected()){
			System.out.println("hairLossProgressive checkbox is selected");  
			js.executeScript("arguments[0].click();", hairLossProgressive);
		}
		else {
			System.out.println("hairLossProgressive checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement hairLossProgressiveAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[71]"));
		hairLossProgressiveAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		hairLossProgressiveAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  maleProstateProblems  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[72]"));
		if (!maleProstateProblems.isSelected()){
			System.out.println("maleProstateProblems checkbox is selected");  
			js.executeScript("arguments[0].click();", maleProstateProblems);
		}
		else {
			System.out.println("maleProstateProblems checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement maleProstateProblemsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[72]"));
		maleProstateProblemsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		maleProstateProblemsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  femaleBCPll  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[73]"));
		if (!femaleBCPll.isSelected()){
			System.out.println("femaleBCPll checkbox is selected");  
			js.executeScript("arguments[0].click();", femaleBCPll);
		}
		else {
			System.out.println("femaleBCPll checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement femaleBCPllAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[73]"));
		femaleBCPllAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		femaleBCPllAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  flushingMenopausel  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[74]"));
		if (!flushingMenopausel.isSelected()){
			System.out.println("flushingMenopausel checkbox is selected");  
			js.executeScript("arguments[0].click();", flushingMenopausel);
		}
		else {
			System.out.println("flushingMenopausel checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement flushingMenopauselAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[74]"));
		flushingMenopauselAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		flushingMenopauselAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  fevers  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[75]"));
		if (!fevers.isSelected()){
			System.out.println("fevers checkbox is selected");  
			js.executeScript("arguments[0].click();", fevers);
		}
		else {
			System.out.println("fevers checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement feversAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[75]"));
		feversAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		feversAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  chills  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[76]"));
		if (!chills.isSelected()){
			System.out.println("chills checkbox is selected");  
			js.executeScript("arguments[0].click();", chills);
		}
		else {
			System.out.println("chills checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement chillsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[76]"));
		chillsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		chillsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  nightSweats  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[77]"));
		if (!nightSweats.isSelected()){
			System.out.println("nightSweats checkbox is selected");  
			js.executeScript("arguments[0].click();", nightSweats);
		}
		else {
			System.out.println("nightSweats checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement nightSweatsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[77]"));
		nightSweatsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		nightSweatsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  swollenGlands  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[78]"));
		if (!swollenGlands.isSelected()){
			System.out.println("swollenGlands checkbox is selected");  
			js.executeScript("arguments[0].click();", swollenGlands);
		}
		else {
			System.out.println("swollenGlands checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement swollenGlandsAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[78]"));
		swollenGlandsAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		swollenGlandsAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement  jointAches  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[79]"));
		if (!jointAches.isSelected()){
			System.out.println("jointAches checkbox is selected");  
			js.executeScript("arguments[0].click();", jointAches);
		}
		else {
			System.out.println("jointAches checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement jointAchesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[79]"));
		jointAchesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		jointAchesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  muscleAches  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[80]"));
		if (!muscleAches.isSelected()){
			System.out.println("muscleAches checkbox is selected");  
			js.executeScript("arguments[0].click();", muscleAches);
		}
		else {
			System.out.println("muscleAches checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement muscleAchesAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[80]"));
		muscleAchesAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		muscleAchesAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  urinaryFrequency  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[81]"));
		if (!urinaryFrequency.isSelected()){
			System.out.println("urinaryFrequency checkbox is selected");  
			js.executeScript("arguments[0].click();", urinaryFrequency);
		}
		else {
			System.out.println("urinaryFrequency checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement urinaryFrequencyAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[81]"));
		urinaryFrequencyAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		urinaryFrequencyAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  frequentThirst  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[82]"));
		if (!frequentThirst.isSelected()){
			System.out.println("frequentThirst checkbox is selected");  
			js.executeScript("arguments[0].click();", frequentThirst);
		}
		else {
			System.out.println("frequentThirst checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement frequentThirstAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[82]"));
		frequentThirstAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		frequentThirstAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  chestPain  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[83]"));
		if (!chestPain.isSelected()){
			System.out.println("chestPain checkbox is selected");  
			js.executeScript("arguments[0].click();", chestPain);
		}
		else {
			System.out.println("chestPain checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement chestPainAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[83]"));
		chestPainAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		chestPainAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement  cough  = driver.findElement(By.xpath("(//input[@formcontrolname='mh'])[84]"));
		if (!cough.isSelected()){
			System.out.println("cough checkbox is selected");  
			js.executeScript("arguments[0].click();", cough);
		}
		else {
			System.out.println("cough checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement coughAge = driver.findElement(By.xpath("(//input[@placeholder = 'Age'])[84]"));
		coughAge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		coughAge.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement alcoholOzWeek = driver.findElement(By.xpath("//input[@placeholder = 'Alcohol (oz/week)']"));
		alcoholOzWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		alcoholOzWeek.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement howLong = driver.findElement(By.xpath("//input[@placeholder = 'How long']"));
		howLong.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		howLong.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement howFrequent = driver.findElement(By.xpath("//input[@placeholder = 'How frequent']"));
		howFrequent.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		howFrequent.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement coffeeTeaCupsDday = driver.findElement(By.xpath("//input[@placeholder = 'Coffee/tea (cups/day)']"));
		coffeeTeaCupsDday.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		coffeeTeaCupsDday.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement smokingCigDay = driver.findElement(By.xpath("//input[@placeholder = 'Smoking (cig/day)']"));
		smokingCigDay.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		smokingCigDay.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement howManyYears = driver.findElement(By.xpath("//input[@placeholder = 'How many years?']"));
		howManyYears.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		howManyYears.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		WebElement yearQuit = driver.findElement(By.xpath("//input[@placeholder = 'Year quit']"));
		yearQuit.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		yearQuit.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);
		
		
		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	
		
		

	}


	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
