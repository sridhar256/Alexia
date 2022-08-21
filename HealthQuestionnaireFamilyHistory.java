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

public class HealthQuestionnaireFamilyHistory extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public HealthQuestionnaireFamilyHistory() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		tcData = TestUtil.readDataFromTC("PatientAcknowledgement");
	}


	@Test(priority=1)
	public void verifySaveDataHealthQuestionnaireFamilyHistory() throws Exception {

		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifySaveDataHealthQuestionnaireFamilyHistory_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataHealthQuestionnaireFamilyHistory_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifySaveDataHealthQuestionnaireFamilyHistory_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataHealthQuestionnaireFamilyHistory_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifySaveDataHealthQuestionnaireFamilyHistory_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataHealthQuestionnaireFamilyHistory_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement healthQuestionnaire = driver.findElement(By.xpath("//div[@id='health-questionnaire']/div/h4"));
		healthQuestionnaire.click();
		Thread.sleep(3000);	

		WebElement reasonForVisit= driver.findElement(By.xpath("//select[@formcontrolname='HQ_reason_for_visit']"));
		Select reasonForVisitValue = new Select(reasonForVisit);
		reasonForVisitValue.selectByValue("2");
		Thread.sleep(3000);
		
		WebElement epilepsy = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[1]"));
		if (!epilepsy.isSelected()){
			System.out.println("epilepsy checkbox is selected");  
			js.executeScript("arguments[0].click();", epilepsy);
		}
		else {
			System.out.println("epilepsy checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement epilepsyRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[1]"));
		Select epilepsyRelationValue = new Select(epilepsyRelation);
		epilepsyRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		
		WebElement migraines = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[2]"));
		if (!migraines.isSelected()){
			System.out.println("migraines checkbox is selected");  
			js.executeScript("arguments[0].click();", migraines);
		}
		else {
			System.out.println("migraines checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement migrainesRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[2]"));
		Select migrainesRelationValue = new Select(migrainesRelation);
		migrainesRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement mentalIllness = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[3]"));
		if (!mentalIllness.isSelected()){
			System.out.println("mentalIllness checkbox is selected");  
			js.executeScript("arguments[0].click();", mentalIllness);
		}
		else {
			System.out.println("mentalIllness checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement mentalIllnessRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[3]"));
		Select mentalIllnessRelationValue = new Select(mentalIllnessRelation);
		mentalIllnessRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement glaucoma = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[4]"));
		if (!glaucoma.isSelected()){
			System.out.println("glaucoma checkbox is selected");  
			js.executeScript("arguments[0].click();", glaucoma);
		}
		else {
			System.out.println("glaucoma checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement glaucomaRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[4]"));
		Select glaucomaRelationValue = new Select(glaucomaRelation);
		glaucomaRelationValue.selectByValue("1");
		Thread.sleep(3000);		
		
		WebElement diabetes = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[5]"));
		if (!diabetes.isSelected()){
			System.out.println("diabetes checkbox is selected");  
			js.executeScript("arguments[0].click();", diabetes);
		}
		else {
			System.out.println("diabetes checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement diabetesRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[5]"));
		Select diabetesRelationValue = new Select(diabetesRelation);
		diabetesRelationValue.selectByValue("1");
		Thread.sleep(3000);				
	
		WebElement thyroidDisease = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[6]"));
		if (!thyroidDisease.isSelected()){
			System.out.println("thyroidDisease checkbox is selected");  
			js.executeScript("arguments[0].click();", thyroidDisease);
		}
		else {
			System.out.println("thyroidDisease checkbox is not selected");
		}
		Thread.sleep(3000);
		
		//WebElement thyroidDiseaseRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[6]"));
		//Select thyroidDiseaseRelationValue = new Select(thyroidDiseaseRelation);
		//thyroidDiseaseRelationValue.selectByValue("1");
		
		WebElement thyroidDiseaseRelation= driver.findElement(By.xpath("(//ng-select[@formcontrolname='family_history_textbox'])[4]"));
		thyroidDiseaseRelation.click();
		Thread.sleep(1500);
		WebElement thyroidDiseaseRelationFather= driver.findElement(By.xpath("//div[contains(text(),'Father')]"));
		js.executeScript("arguments[0].click();", thyroidDiseaseRelationFather);
		Thread.sleep(3000);				
		
		
		
		WebElement hayfever = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[7]"));
		if (!hayfever.isSelected()){
			System.out.println("hayfever checkbox is selected");  
			js.executeScript("arguments[0].click();", hayfever);
		}
		else {
			System.out.println("hayfever checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement hayfeverRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[7]"));
		Select hayfeverRelationValue = new Select(hayfeverRelation);
		hayfeverRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		
		WebElement asthma = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[8]"));
		if (!asthma.isSelected()){
			System.out.println("asthma checkbox is selected");  
			js.executeScript("arguments[0].click();", asthma);
		}
		else {
			System.out.println("asthma checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement asthmaRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[8]"));
		Select asthmaRelationValue = new Select(asthmaRelation);
		asthmaRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement anemia = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[9]"));
		if (!anemia.isSelected()){
			System.out.println("anemia checkbox is selected");  
			js.executeScript("arguments[0].click();", anemia);
		}
		else {
			System.out.println("anemia checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement anemiaRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[9]"));
		Select anemiaRelationValue = new Select(anemiaRelation);
		anemiaRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		
		WebElement cancer = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[10]"));
		if (!cancer.isSelected()){
			System.out.println("cancer checkbox is selected");  
			js.executeScript("arguments[0].click();", cancer);
		}
		else {
			System.out.println("cancer checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement cancerRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[10]"));
		Select cancerRelationValue = new Select(cancerRelation);
		cancerRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		
		WebElement bleedsEasily = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[11]"));
		if (!bleedsEasily.isSelected()){
			System.out.println("bleedsEasily checkbox is selected");  
			js.executeScript("arguments[0].click();", bleedsEasily);
		}
		else {
			System.out.println("bleedsEasily checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement bleedsEasilyRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[11]"));
		Select bleedsEasilyRelationValue = new Select(bleedsEasilyRelation);
		bleedsEasilyRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		
		WebElement osteoporosis = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[12]"));
		if (!osteoporosis.isSelected()){
			System.out.println("osteoporosis checkbox is selected");  
			js.executeScript("arguments[0].click();", osteoporosis);
		}
		else {
			System.out.println("osteoporosis checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement osteoporosisRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[12]"));
		Select osteoporosisRelationValue = new Select(osteoporosisRelation);
		osteoporosisRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement arthritis = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[13]"));
		if (!arthritis.isSelected()){
			System.out.println("arthritis checkbox is selected");  
			js.executeScript("arguments[0].click();", arthritis);
		}
		else {
			System.out.println("arthritis checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement arthritisRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[13]"));
		Select arthritisRelationValue = new Select(arthritisRelation);
		arthritisRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement heartDisease = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[14]"));
		if (!heartDisease.isSelected()){
			System.out.println("heartDisease checkbox is selected");  
			js.executeScript("arguments[0].click();", heartDisease);
		}
		else {
			System.out.println("heartDisease checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement heartDiseaseRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[14]"));
		Select heartDiseaseRelationValue = new Select(heartDiseaseRelation);
		heartDiseaseRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		
		WebElement stroke = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[15]"));
		if (!stroke.isSelected()){
			System.out.println("stroke checkbox is selected");  
			js.executeScript("arguments[0].click();", stroke);
		}
		else {
			System.out.println("stroke checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement strokeRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[15]"));
		Select strokeRelationValue = new Select(strokeRelation);
		strokeRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement highBloodPressure = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[16]"));
		if (!highBloodPressure.isSelected()){
			System.out.println("highBloodPressure checkbox is selected");  
			js.executeScript("arguments[0].click();", highBloodPressure);
		}
		else {
			System.out.println("highBloodPressure checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement highBloodPressureRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[16]"));
		Select highBloodPressureRelationValue = new Select(highBloodPressureRelation);
		highBloodPressureRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		
		WebElement highCholesterol = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[17]"));
		if (!highCholesterol.isSelected()){
			System.out.println("highCholesterol checkbox is selected");  
			js.executeScript("arguments[0].click();", highCholesterol);
		}
		else {
			System.out.println("highCholesterol checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement highCholesterolRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[17]"));
		Select highCholesterolRelationValue = new Select(highCholesterolRelation);
		highCholesterolRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		
		WebElement alcoholism = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[18]"));
		if (!alcoholism.isSelected()){
			System.out.println("alcoholism checkbox is selected");  
			js.executeScript("arguments[0].click();", alcoholism);
		}
		else {
			System.out.println("alcoholism checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement alcoholismRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[18]"));
		Select alcoholismRelationValue = new Select(alcoholismRelation);
		alcoholismRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement hepatitis = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[19]"));
		if (!hepatitis.isSelected()){
			System.out.println("hepatitis checkbox is selected");  
			js.executeScript("arguments[0].click();", hepatitis);
		}
		else {
			System.out.println("hepatitis checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement hepatitisRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[19]"));
		Select hepatitisRelationValue = new Select(hepatitisRelation);
		hepatitisRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement othersPleaseSpecify = driver.findElement(By.xpath("(//input[@formcontrolname='family_history_checkbox'])[20]"));
		if (!othersPleaseSpecify.isSelected()){
			System.out.println("othersPleaseSpecify checkbox is selected");  
			js.executeScript("arguments[0].click();", othersPleaseSpecify);
		}
		else {
			System.out.println("othersPleaseSpecify checkbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement othersPleaseSpecifyRelation= driver.findElement(By.xpath("(//select[@formcontrolname='family_history_textbox'])[20]"));
		Select othersPleaseSpecifyRelationValue = new Select(othersPleaseSpecifyRelation);
		othersPleaseSpecifyRelationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement otherTextbox = driver.findElement(By.xpath("//input[@formcontrolname='other_textbox']"));
		otherTextbox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		otherTextbox.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	
		
		WebElement yearOpen= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[1]"));
		Select yearValue = new Select(yearOpen);
		yearValue.selectByValue("1979");
		Thread.sleep(3000);
		
		WebElement illnessOperationOpen= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[1]"));
		Select illnessOperationValue = new Select(illnessOperationOpen);
		illnessOperationValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement addNewAdmission1 = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[2]"));
		addNewAdmission1.click();
		Thread.sleep(3000);	
		
		WebElement yearNewAdmission1Open= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[2]"));
		Select yearNewAdmission1Value = new Select(yearNewAdmission1Open);
		yearNewAdmission1Value.selectByValue("1979");
		Thread.sleep(3000);
		
		WebElement illnessOperationNewAdmissionOpen= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[2]"));
		Select illnessOperationNewAdmissionValue = new Select(illnessOperationNewAdmissionOpen);
		illnessOperationNewAdmissionValue.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement addNewAdmission2 = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[2]"));
		addNewAdmission2.click();
		Thread.sleep(3000);	
		
		WebElement yearNewAdmission2Open= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[3]"));
		Select yearNewAdmission2Value = new Select(yearNewAdmission2Open);
		yearNewAdmission2Value.selectByValue("1979");
		Thread.sleep(3000);
		
		WebElement illnessOperationNewAdmission2Open= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[3]"));
		Select illnessOperationNewAdmission2Value = new Select(illnessOperationNewAdmission2Open);
		illnessOperationNewAdmission2Value.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement addNewAdmission3 = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[2]"));
		addNewAdmission3.click();
		Thread.sleep(3000);	
		
		WebElement yearNewAdmission3Open= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[4]"));
		Select yearNewAdmission3Value = new Select(yearNewAdmission3Open);
		yearNewAdmission3Value.selectByValue("1979");
		Thread.sleep(3000);
		
		WebElement illnessOperationNewAdmission3Open= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[4]"));
		Select illnessOperationNewAdmission3Value = new Select(illnessOperationNewAdmission3Open);
		illnessOperationNewAdmission3Value.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement addNewAdmission4 = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[2]"));
		addNewAdmission4.click();
		Thread.sleep(3000);	
		
		WebElement yearNewAdmission4Open= driver.findElement(By.xpath("(//select[@formcontrolname='year'])[5]"));
		Select yearNewAdmission4Value = new Select(yearNewAdmission4Open);
		yearNewAdmission4Value.selectByValue("1979");
		Thread.sleep(3000);
		
		WebElement illnessOperationNewAdmission4Open= driver.findElement(By.xpath("(//select[@formcontrolname='illness_or_operation'])[5]"));
		Select illnessOperationNewAdmission4Value = new Select(illnessOperationNewAdmission4Open);
		illnessOperationNewAdmission4Value.selectByValue("1");
		Thread.sleep(3000);
		
		WebElement medications = driver.findElement(By.xpath("//textarea[@formcontrolname='HQ_medications']"));
		medications.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		medications.sendKeys(tcData.get("Label3"));
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
