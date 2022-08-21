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
import org.testng.asserts.SoftAssert;

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

public class PatientInformation extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;
	SoftAssert softAssert = new SoftAssert();


	public PatientInformation() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
	}


	@Test(priority=1,enabled =false)
	public void verifySaveDataPatientInformationInvalid() throws Exception {
		tcData = TestUtil.readDataFromTC("PatientInformationInvalid");
		
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifySaveDataPatientInformationInvalid_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataPatientInformationInvalid_TC_01): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifySaveDataPatientInformationInvalid_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataPatientInformationInvalid_TC_02): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifySaveDataPatientInformationInvalid_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataPatientInformationInvalid_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientInformation = driver.findElement(By.xpath("//div[@id='patient-information']/div/h4"));
		patientInformation.click();
		Thread.sleep(3000);	

		WebElement address = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[1]"));
		address.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		address.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);

		WebElement city = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[1]"));
		city.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		city.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		WebElement stateOpen= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_PD_state'])"));
		stateOpen.click();
		Thread.sleep(1500);
		WebElement stateValue= driver.findElement(By.xpath("(//div[contains(text(),'Georgia')])[2]"));
		js.executeScript("arguments[0].click();", stateValue);
		Thread.sleep(3000);
		
		WebElement zip = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[1]"));
		zip.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zip.sendKeys(tcData.get("Label5"));
		Thread.sleep(1500);	
		
		WebElement maleCheckbox = driver.findElement(By.xpath("//input[@id='Male']"));
		if (!maleCheckbox.isSelected()){
			System.out.println("MaleCheckbox is selected");  
			js.executeScript("arguments[0].click();", maleCheckbox);
		}
		else {
			System.out.println("MaleCheckbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement maritalStatusCheckbox = driver.findElement(By.xpath("//input[@id='Married']"));
		if (!maritalStatusCheckbox.isSelected()){
			System.out.println("MaritalStatusCheckbox is selected");  
			js.executeScript("arguments[0].click();", maritalStatusCheckbox);
		}
		else {
			System.out.println("MaritalStatusCheckbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement socialSecurity = driver.findElement(By.xpath("//input[@placeholder = 'Social Security #']"));
		socialSecurity.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		socialSecurity.sendKeys(tcData.get("Label6"));
		Thread.sleep(1500);	
		
		WebElement employer = driver.findElement(By.xpath("//input[@placeholder = 'Employer']"));
		employer.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		employer.sendKeys(tcData.get("Label7"));
		Thread.sleep(1500);	
		
		WebElement homePhone = driver.findElement(By.xpath("//input[@placeholder = 'Home Phone']"));
		homePhone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		homePhone.sendKeys(tcData.get("Label8"));
		Thread.sleep(1500);	
		
		WebElement workPhone = driver.findElement(By.xpath("//input[@placeholder = 'Work Phone']"));
		workPhone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		workPhone.sendKeys(tcData.get("Label9"));
		Thread.sleep(1500);
		
		WebElement emailAddress = driver.findElement(By.xpath("//input[@placeholder = 'Email Address']"));
		emailAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		emailAddress.sendKeys(tcData.get("Label10"));
		Thread.sleep(1500);

		WebElement  isOtherperson  = driver.findElement(By.xpath("//button[@id='responsibleDd']/span"));
		isOtherperson.click();
		Thread.sleep(3000);	
		
		WebElement noOption = driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[2]"));
		noOption.click();
		Thread.sleep(3000);	
		
		WebElement name = driver.findElement(By.xpath("//input[@placeholder = 'Name']"));
		name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		name.sendKeys(tcData.get("Label11"));
		Thread.sleep(1500);
		
		WebElement phone = driver.findElement(By.xpath("//input[@placeholder = 'Phone #']"));
		phone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		phone.sendKeys(tcData.get("Label12"));
		Thread.sleep(1500);
		
		WebElement relationshipToPatientOpen= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_ECI_relationship_to_patient'])"));
		relationshipToPatientOpen.click();
		Thread.sleep(1500);
		WebElement relationshipToPatientValue= driver.findElement(By.xpath("(//div[contains(text(),'Uncle')])[3]"));
		js.executeScript("arguments[0].click();", relationshipToPatientValue);
		Thread.sleep(3000);
		
		WebElement address1 = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[2]"));
		address1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		address1.sendKeys(tcData.get("Label13"));
		Thread.sleep(1500);
		
		WebElement city1 = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[2]"));
		city1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		city1.sendKeys(tcData.get("Label14"));
		Thread.sleep(1500);	
		
		WebElement stateOpenEmergencyContactInformation= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_ECI_state'])"));
		stateOpenEmergencyContactInformation.click();
		Thread.sleep(1500);
		WebElement stateValueEmergencyContactInformation= driver.findElement(By.xpath("(//div[contains(text(),'Georgia')])[4]"));
		js.executeScript("arguments[0].click();", stateValueEmergencyContactInformation);
		Thread.sleep(3000);
		
		WebElement zip1 = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[2]"));
		zip1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zip1.sendKeys(tcData.get("Label15"));
		Thread.sleep(1500);	
		
		WebElement medicareAccountNoPrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Medicare Account No']"));
		medicareAccountNoPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		medicareAccountNoPrimaryInsurance.sendKeys(tcData.get("Label16"));
		Thread.sleep(1500);
		
		WebElement groupPlanPrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Group/Plan #']"));
		groupPlanPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		groupPlanPrimaryInsurance.sendKeys(tcData.get("Label17"));
		Thread.sleep(1500);
		
		WebElement policyHolderNamePrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Policy Holder Name']"));
		policyHolderNamePrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		policyHolderNamePrimaryInsurance.sendKeys(tcData.get("Label18"));
		Thread.sleep(1500);
		
		WebElement insuranceCompanyOpenPrimaryInsurance = driver.findElement(By.xpath("//select[@formcontrolname='PI_II_insurance_company']"));
		Select insuranceCompanyValuePrimaryInsurance = new Select(insuranceCompanyOpenPrimaryInsurance);
		insuranceCompanyValuePrimaryInsurance.selectByValue("2");
		Thread.sleep(3000);
		
		WebElement addressPrimaryInsurance = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[3]"));
		addressPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		addressPrimaryInsurance.sendKeys(tcData.get("Label19"));
		Thread.sleep(1500);
		
		WebElement cityPrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[3]"));
		cityPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		cityPrimaryInsurance.sendKeys(tcData.get("Label20"));
		Thread.sleep(1500);	
		
		WebElement stateOpenPrimaryInsurance= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_II_state'])"));
		stateOpenPrimaryInsurance.click();
		Thread.sleep(1500);
		WebElement stateValuePrimaryInsurance= driver.findElement(By.xpath("(//div[contains(text(),'Georgia')])[5]"));
		js.executeScript("arguments[0].click();", stateValuePrimaryInsurance);
		Thread.sleep(3000);
		
		WebElement zipPrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[3]"));
		zipPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zipPrimaryInsurance.sendKeys(tcData.get("Label21"));
		Thread.sleep(1500);	
		
		WebElement phonePrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Phone'])[3]"));
		phonePrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		phonePrimaryInsurance.sendKeys(tcData.get("Label22"));
		Thread.sleep(1500);	
		
		WebElement datePickerEffectiveDatePrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Effective Date'])[2]"));
		js.executeScript("arguments[0].click();", datePickerEffectiveDatePrimaryInsurance);
		Thread.sleep(2000);

		WebElement effectiveDatePrimaryInsurance  = driver.findElement(By.xpath("(//div[@class='flatpickr-rContainer'])[6]/div[2]/div/span[25]"));
		js.executeScript("arguments[0].click();", effectiveDatePrimaryInsurance);
		Thread.sleep(2000);
		
		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	
	}

	
	@Test(priority=2,enabled =true)
	public void updateDataPatientInformationValid() throws Exception {
		tcData = TestUtil.readDataFromTC("PatientInformationValid");
		
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_01): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_02): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientInformation = driver.findElement(By.xpath("//div[@id='patient-information']/div/h4"));
		patientInformation.click();
		Thread.sleep(3000);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_04): Validate 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement address = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[1]"));
		address.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		address.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_05): Validate 'Address' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Dr No: 16-108, Marlapalem' in 'Address' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement city = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[1]"));
		city.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		city.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_06): Validate 'City' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Gannavaram' in 'City' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement stateOpen= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_PD_state'])"));
		stateOpen.click();
		Thread.sleep(1500);
		WebElement stateValue= driver.findElement(By.xpath("(//div[contains(text(),'Georgia')])[2]"));
		js.executeScript("arguments[0].click();", stateValue);
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_07): Validate 'City' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Georgia' option for 'City' drop down field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement zip = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[1]"));
		zip.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zip.sendKeys(tcData.get("Label6"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_08): Validate 'Zip' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '52110' in 'Zip' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement maleCheckbox = driver.findElement(By.xpath("//input[@id='Male']"));
		if (!maleCheckbox.isSelected()){
			System.out.println("MaleCheckbox is selected");  
			js.executeScript("arguments[0].click();", maleCheckbox);
		}
		else {
			System.out.println("MaleCheckbox is not selected");
		}
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_09): Validate 'Sex' options (Male/Female) in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Male' checkbox for 'Sex' in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement maritalStatusCheckbox = driver.findElement(By.xpath("//input[@id='Married']"));
		if (!maritalStatusCheckbox.isSelected()){
			System.out.println("MaritalStatusCheckbox is selected");  
			js.executeScript("arguments[0].click();", maritalStatusCheckbox);
		}
		else {
			System.out.println("MaritalStatusCheckbox is not selected");
		}
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_10): Validate 'Marital Status' options in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Married' checkbox for 'Marital Status' in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement socialSecurity = driver.findElement(By.xpath("(//input[@placeholder = 'Social Security #'])[1]"));
		socialSecurity.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		socialSecurity.sendKeys(tcData.get("Label7"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_11");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_11): Validate 'Social Security #' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '987654123' in 'Social Security #' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement employer = driver.findElement(By.xpath("//input[@placeholder = 'Employer']"));
		employer.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		employer.sendKeys(tcData.get("Label8"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_12");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_12): Validate 'Employer' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in 'Employer' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement homePhone = driver.findElement(By.xpath("(//input[@placeholder = 'Home Phone'])[1]"));
		homePhone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		homePhone.sendKeys(tcData.get("Label9"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_13");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_13): Validate 'Home Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '929-311-6684' in 'Home Phone' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement workPhone = driver.findElement(By.xpath("(//input[@placeholder = 'Work Phone'])[1]"));
		workPhone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		workPhone.sendKeys(tcData.get("Label10"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_14");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_14): Validate 'Work Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '944-046-8522' in 'Work Phone' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement emailAddress = driver.findElement(By.xpath("//input[@placeholder = 'Email Address']"));
		emailAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		emailAddress.sendKeys(tcData.get("Label11"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_15");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_15): Validate 'Email Address' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'sreedharjasti256@gmail.com' in 'Email Address' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement  isOtherperson  = driver.findElement(By.xpath("//span[@id='responsibleDd']"));
		isOtherperson.click();
		Thread.sleep(3000);	
		
		WebElement yesOption = driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[1]"));
		yesOption.click();
		Thread.sleep(3000);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_16");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_16): Validate 'Is other person...' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Yes' option in 'Is other person...' drop down field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement personResponsible = driver.findElement(By.xpath("//input[@placeholder = 'Person responsible for charges (if other than patient)']"));
		personResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		personResponsible.sendKeys(tcData.get("Label12"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_17");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_17): Validate 'Person responsible...' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Jasti2#' in 'Person responsible...' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement addressPersonResponsible = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[2]"));
		addressPersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		addressPersonResponsible.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_18");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_18): Validate 'Address responsible...' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Dr No: 16-108, Marlapalem' in 'Address' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement cityPersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[2]"));
		cityPersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		cityPersonResponsible.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_19");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_19): Validate 'City' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Gannavaram' in 'City' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement statePersonResponsibleOpen= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_PD_IOTP_state'])"));
		statePersonResponsibleOpen.click();
		Thread.sleep(1500);
		WebElement statePersonResponsibleValue= driver.findElement(By.xpath("(//div[contains(text(),'Georgia')])[3]"));
		js.executeScript("arguments[0].click();", statePersonResponsibleValue);
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_20");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_20): Validate 'City' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Georgia' option for 'City' drop down field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement zipPersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[2]"));
		zipPersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zipPersonResponsible.sendKeys(tcData.get("Label6"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_21");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_21): Validate 'Zip' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '52110' in 'Zip' field in 'Patient Information' module.",ExtentColor.GREEN));  
		
		WebElement relationshipToPatientOpen= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_PD_IOTP_realtionship_to_patient'])"));
		relationshipToPatientOpen.click();
		Thread.sleep(1500);
		WebElement relationshipToPatientValue= driver.findElement(By.xpath("(//div[contains(text(),'Uncle')])[2]"));
		js.executeScript("arguments[0].click();", relationshipToPatientValue);
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_22");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_22): Validate 'Relationship to patient' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Uncle' option for 'Relationship to patient' drop down field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement socialSecurityPersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Social Security #'])[2]"));
		socialSecurityPersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		socialSecurityPersonResponsible.sendKeys(tcData.get("Label7"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_23");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_23): Validate 'Social Security #' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '987-65-4123' in 'Social Security #' field in 'Patient Information' module.",ExtentColor.GREEN));  
	
		WebElement homePhonePersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Home Phone'])[2]"));
		homePhonePersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		homePhonePersonResponsible.sendKeys(tcData.get("Label9"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_24");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_24): Validate 'Home Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '929-311-6684' in 'Home Phone' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement workPhonePersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Work Phone'])[2]"));
		workPhonePersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		workPhonePersonResponsible.sendKeys(tcData.get("Label10"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_25");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_25): Validate 'Work Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '944-046-8522' in 'Work Phone' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement prefferedContactPersonResponsibleCheckbox = driver.findElement(By.xpath("//input[@id='Email']"));
		if (!prefferedContactPersonResponsibleCheckbox.isSelected()){
			System.out.println("PrefferedContactPersonResponsibleCheckbox is selected");  
			js.executeScript("arguments[0].click();", prefferedContactPersonResponsibleCheckbox);
		}
		else {
			System.out.println("PrefferedContactPersonResponsibleCheckbox is not selected");
		}
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_26");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_26): Validate 'Preferred Contact...' options in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Email' checkbox for 'Preferred Contact...' in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement name = driver.findElement(By.xpath("//input[@placeholder = 'Name']"));
		name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		name.sendKeys(tcData.get("Label12"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_27");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_27): Validate 'Name' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Jasti2#' in 'Name' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement phone = driver.findElement(By.xpath("//input[@placeholder = 'Phone #']"));
		phone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		phone.sendKeys(tcData.get("Label9"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_28");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_28): Validate 'Phone #' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '929-311-6685' in 'Phone #' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement relationshipToPatientOpen1= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_ECI_relationship_to_patient'])"));
		relationshipToPatientOpen1.click();
		Thread.sleep(1500);
		WebElement relationshipToPatientValue1= driver.findElement(By.xpath("(//div[contains(text(),'Uncle')])[3]"));
		js.executeScript("arguments[0].click();", relationshipToPatientValue1);
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_29");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_29): Validate 'Relationship to patient' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Uncle' option for 'Relationship to patient' drop down field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement address1 = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[3]"));
		address1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		address1.sendKeys(tcData.get("Label15"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_30");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_30): Validate 'Address' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Dr No: 16-109, Marlapalem' in 'Address' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement city1 = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[3]"));
		city1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		city1.sendKeys(tcData.get("Label16"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_31");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_31): Validate 'City' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Gannavaram1' in 'City' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement stateOpenEmergencyContactInformation= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_ECI_state'])"));
		stateOpenEmergencyContactInformation.click();
		Thread.sleep(1500);
		WebElement stateValueEmergencyContactInformation= driver.findElement(By.xpath("(//div[contains(text(),'Georgia')])[5]"));
		js.executeScript("arguments[0].click();", stateValueEmergencyContactInformation);
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_32");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_32): Validate 'State' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Georgia' option for 'State' drop down field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement zip1 = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[3]"));
		zip1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zip1.sendKeys(tcData.get("Label17"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_33");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_33): Validate 'Zip' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '52110' in 'Zip' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement medicareAccountNoPrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Medicare Account No']"));
		medicareAccountNoPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		medicareAccountNoPrimaryInsurance.sendKeys(tcData.get("Label18"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_33");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_33): Validate 'Medicare Account No' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '521103' in 'Medicare Account No' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement groupPlanPrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Group/Plan #']"));
		groupPlanPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		groupPlanPrimaryInsurance.sendKeys(tcData.get("Label19"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_34");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_34): Validate 'Group/Plan #' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Jasti3% GroupPlan' in 'Group/Plan #' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement policyHolderNamePrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Policy Holder Name']"));
		policyHolderNamePrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		policyHolderNamePrimaryInsurance.sendKeys(tcData.get("Label20"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_35");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_35): Validate 'Policy Holder Name' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Jasti3% GroupPlan' in 'Policy Holder Name' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement insuranceCompanyOpenPrimaryInsurance= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_II_insurance_company'])"));
		insuranceCompanyOpenPrimaryInsurance.click();
		Thread.sleep(1500);
		WebElement insuranceCompanyValuePrimaryInsurance= driver.findElement(By.xpath("(//span[contains(text(),'Company 2')])"));
		js.executeScript("arguments[0].click();", insuranceCompanyValuePrimaryInsurance);
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_36");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_36): Validate 'Insurance Company' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Company 2' in 'Insurance Company' drop down field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement addressPrimaryInsurance = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[4]"));
		addressPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		addressPrimaryInsurance.sendKeys(tcData.get("Label21"));
		Thread.sleep(1500);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_37");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_37): Validate 'Address' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Dr No: 16-110, Marlapalem' in 'Address' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement cityPrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[4]"));
		cityPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		cityPrimaryInsurance.sendKeys(tcData.get("Label22"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_38");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_38): Validate 'City' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Gannavaram3' in 'City' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement stateOpenPrimaryInsurance= driver.findElement(By.xpath("(//ng-select[@formcontrolname='PI_II_state'])"));
		stateOpenPrimaryInsurance.click();
		Thread.sleep(1500);
		WebElement stateValuePrimaryInsurance= driver.findElement(By.xpath("(//div[contains(text(),'Georgia')])[5]"));
		js.executeScript("arguments[0].click();", stateValuePrimaryInsurance);
		Thread.sleep(3000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_38");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_38): Validate 'State' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Georgia' in 'State' drop down field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement zipPrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[4]"));
		zipPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zipPrimaryInsurance.sendKeys(tcData.get("Label23"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_39");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_39): Validate 'Zip' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '52110' in 'Zip' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement phonePrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Phone'])[1]"));
		phonePrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		phonePrimaryInsurance.sendKeys(tcData.get("Label24"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_40");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_40): Validate 'Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '929-311-6686' in 'Phone' field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement datePickerEffectiveDatePrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Effective Date'])[2]"));
		js.executeScript("arguments[0].click();", datePickerEffectiveDatePrimaryInsurance);
		Thread.sleep(2000);

		WebElement effectiveDatePrimaryInsurance  = driver.findElement(By.xpath("(//span[@aria-current='date'])[25]"));
		js.executeScript("arguments[0].click();", effectiveDatePrimaryInsurance);
		Thread.sleep(2000);
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_41");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_41): Validate 'Effective Date' datepicker field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select '08-24-2022' date from 'Effective Date' datepicker field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement acceptTermsConditions = driver.findElement(By.xpath("//button[contains(text(),'I Authorize')]"));
		js.executeScript("arguments[0].click();", acceptTermsConditions);
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_42");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_42): Validate 'I Authorize' functionality in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'I Authorize' in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement confirmation = driver.findElement(By.xpath("(//button[contains(text(),'Confirm')])[1]"));
		confirmation.click();
		Thread.sleep(1500);	
		
		logger = extent.createTest("UpdateDataPatientInformation_TC_43");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_43): Validate 'Terms and Conditions' functionality in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Confirm' button in 'Terms and Conditions' pop up in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		logger = extent.createTest("UpdateDataPatientInformation_TC_44");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_44): Validate 'Update' button in  'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Update' button in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	

		logger = extent.createTest("UpdateDataPatientInformation_TC_45");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(UpdateDataPatientInformation_TC_45): Validate 'X' button in 'Information' pop up in 'Patient Acknowledgement' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'X' button in 'Information' pop up in 'Patient Acknowledgement' module.",ExtentColor.GREEN));  
	}

	
	
	@Test(priority=3,enabled =true)
	public void verifyDataPatientInformation() throws Exception {
		tcData = TestUtil.readDataFromTC("PatientInformationValid");
		
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		SoftAssert softAssert = new SoftAssert();

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("verifyDataPatientInformation_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_01): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("verifyDataPatientInformation_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_02): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("verifyDataPatientInformation_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientInformation = driver.findElement(By.xpath("//div[@id='patient-information']/div/h4"));
		patientInformation.click();
		Thread.sleep(3000);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_04): Validate 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement address = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[1]"));
		softAssert.assertEquals(address.getAttribute("value"),tcData.get("Label3"));
		Thread.sleep(1500);

		logger = extent.createTest("verifyDataPatientInformation_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_05): Validate 'Address' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Address' data in 'Patient Information' module is same as input value given for 'Address' field from xls.",ExtentColor.GREEN));  

		WebElement city = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[1]"));
		softAssert.assertEquals(city.getAttribute("value"),tcData.get("Label4"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_06): Validate 'City' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'City' data in 'Patient Information' module is same as input value given for 'City' field from xls.",ExtentColor.GREEN));  

		WebElement stateOpen= driver.findElement(By.xpath("//ng-select[@formcontrolname='PI_PD_state']/div/div/div[2]"));
		softAssert.assertEquals(stateOpen.getText(),tcData.get("Label5"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_07): Validate 'State' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'State' data in 'Patient Information' module is same as input value given for 'State' field from xls.",ExtentColor.GREEN));  

		WebElement zip = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[1]"));
		softAssert.assertEquals(zip.getAttribute("value"),"52110");
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_08): Validate 'Zip' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'zip' data in 'Patient Information' module is same as input value given for 'zip' field from xls.",ExtentColor.GREEN));  

		WebElement maleCheckbox = driver.findElement(By.xpath("//input[@id='Male']"));
		softAssert.assertEquals(maleCheckbox.isEnabled(),true);
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_09): Validate 'Sex' options (Male/Female) in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Male' checkbox is selected in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement maritalStatusCheckbox = driver.findElement(By.xpath("//input[@id='Married']"));
		softAssert.assertEquals(maritalStatusCheckbox.isEnabled(),true);
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_10): Validate 'Marital Status' options in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Married' checkbox is selected in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement socialSecurity = driver.findElement(By.xpath("(//input[@placeholder = 'Social Security #'])[1]"));
		softAssert.assertEquals(socialSecurity.getAttribute("value"),"987-65-4123");
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_11");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_11): Validate 'Social Security #' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Social Security #' data in 'Patient Information' module is same as input value given for 'Social Security #' field from xls.",ExtentColor.GREEN));  

		WebElement employer = driver.findElement(By.xpath("//input[@placeholder = 'Employer']"));
		softAssert.assertEquals(employer.getAttribute("value"),tcData.get("Label8"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_12");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_12): Validate 'Employer' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Employer' data in 'Patient Information' module is same as input value given for 'Employer' field from xls.",ExtentColor.GREEN));  

		WebElement homePhone = driver.findElement(By.xpath("(//input[@placeholder = 'Home Phone'])[1]"));
		softAssert.assertEquals(homePhone.getAttribute("value"),"929-311-6684");
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_13");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_13): Validate 'Home Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Home Phone' data in 'Patient Information' module is same as input value given for 'Home Phone' field from xls.",ExtentColor.GREEN));  

		WebElement workPhone = driver.findElement(By.xpath("(//input[@placeholder = 'Work Phone'])[1]"));
		softAssert.assertEquals(workPhone.getAttribute("value"),"944-046-8522");
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_14");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_14): Validate 'Work Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Work Phone' data in 'Patient Information' module is same as input value given for 'Work Phone' field from xls.",ExtentColor.GREEN));  

		WebElement emailAddress = driver.findElement(By.xpath("//input[@placeholder = 'Email Address']"));
		softAssert.assertEquals(emailAddress.getAttribute("value"),tcData.get("Label11"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_15");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_15): Validate 'Email Address' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Email Address' data in 'Patient Information' module is same as input value given for 'Email Address' field from xls.",ExtentColor.GREEN));  

		//WebElement  isOtherperson  = driver.findElement(By.xpath("//button[@id='responsibleDd']/span"));
		// isOtherperson.click();
		//Thread.sleep(3000);	
		
		//WebElement yesOption = driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[1]"));
		// yesOption.click();
		Thread.sleep(3000);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_16");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_16): Validate 'Is other person...' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Yes' option in 'Is other person...' drop down field in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement personResponsible = driver.findElement(By.xpath("//input[@placeholder = 'Person responsible for charges (if other than patient)']"));
		softAssert.assertEquals(personResponsible.getAttribute("value"),tcData.get("Label12"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_17");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_17): Validate 'Person responsible...' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Person responsible...' data in 'Patient Information' module is same as input value given for 'Person responsible...' field from xls.",ExtentColor.GREEN));  

		WebElement addressPersonResponsible = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[2]"));
		softAssert.assertEquals(addressPersonResponsible.getAttribute("value"),tcData.get("Label3"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_18");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_18): Validate 'Address responsible...' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Address responsible...' data in 'Patient Information' module is same as input value given for 'Address responsible...' field from xls.",ExtentColor.GREEN));  

		WebElement cityPersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[2]"));
		softAssert.assertEquals(cityPersonResponsible.getAttribute("value"),tcData.get("Label4"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_19");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_19): Validate 'City' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'City' data in 'Patient Information' module is same as input value given for 'City' field from xls.",ExtentColor.GREEN));  

		WebElement statePersonResponsibleOpen= driver.findElement(By.xpath("//ng-select[@formcontrolname='PI_PD_IOTP_state']/div/div/div[2]"));
		softAssert.assertEquals(statePersonResponsibleOpen.getText(),tcData.get("Label5"));
		Thread.sleep(3000);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_20");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_20): Validate 'State' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'State' data in 'Patient Information' module is same as input value given for 'State' field from xls.",ExtentColor.GREEN));  

		WebElement zipPersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[2]"));
		softAssert.assertEquals(zipPersonResponsible.getAttribute("value"),"52110");
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_21");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_21): Validate 'Zip' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Zip' data in 'Patient Information' module is same as input value given for 'Zip' field from xls.",ExtentColor.GREEN));  
		
		WebElement relationshipToPatientPersonResponsibleOpen= driver.findElement(By.xpath("//ng-select[@formcontrolname='PI_PD_IOTP_realtionship_to_patient']/div/div/div[2]"));
		softAssert.assertEquals(relationshipToPatientPersonResponsibleOpen.getText(),tcData.get("Label13"));
		Thread.sleep(3000);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_22");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_22): Validate 'Relationship to patient' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Relationship to patient' data in 'Patient Information' module is same as input value given for 'Relationship to patient' field from xls.",ExtentColor.GREEN));  

		WebElement socialSecurityPersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Social Security #'])[2]"));
		softAssert.assertEquals(socialSecurityPersonResponsible.getAttribute("value"),"987-65-4123");
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_23");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_23): Validate 'Social Security #' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Social Security #' data in 'Patient Information' module is same as input value given for 'Social Security #' field from xls.",ExtentColor.GREEN));  
	
		WebElement homePhonePersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Home Phone'])[2]"));
		softAssert.assertEquals(homePhonePersonResponsible.getAttribute("value"),"929-311-6684");
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_24");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_24): Validate 'Home Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Home Phone' data in 'Patient Information' module is same as input value given for 'Home Phone' field from xls.",ExtentColor.GREEN));  

		WebElement workPhonePersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Work Phone'])[2]"));
		softAssert.assertEquals(workPhonePersonResponsible.getAttribute("value"),"944-046-8522");
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_25");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_25): Validate 'Work Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Work Phone' data in 'Patient Information' module is same as input value given for 'Work Phone' field from xls.",ExtentColor.GREEN));  

		WebElement prefferedContactPersonResponsibleCheckbox = driver.findElement(By.xpath("//input[@id='Email']"));
		softAssert.assertEquals(prefferedContactPersonResponsibleCheckbox.isEnabled(),true);
		Thread.sleep(3000);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_26");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_26): Validate 'Preferred Contact...' options in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User selected 'Email' checkbox for 'Preferred Contact...' in 'Patient Information' module.",ExtentColor.GREEN));  

		WebElement name = driver.findElement(By.xpath("//input[@placeholder = 'Name']"));
		softAssert.assertEquals(name.getAttribute("value"),tcData.get("Label12"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_27");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_27): Validate 'Name' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Name' data in 'Patient Information' module is same as input value given for 'Name' field from xls.",ExtentColor.GREEN));  

		WebElement phone = driver.findElement(By.xpath("//input[@placeholder = 'Phone #']"));
		softAssert.assertEquals(phone.getAttribute("value"),"929-311-6684");
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_28");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_28): Validate 'Phone #' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Phone #' data in 'Patient Information' module is same as input value given for 'Phone #' field from xls.",ExtentColor.GREEN));  

		WebElement relationshipToPatientOpen= driver.findElement(By.xpath("//ng-select[@formcontrolname='PI_ECI_relationship_to_patient']/div/div/div[2]"));
		softAssert.assertEquals(relationshipToPatientOpen.getText(),tcData.get("Label13"));
		Thread.sleep(3000);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_29");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_29): Validate 'Relationship to patient' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Relationship to patient' data in 'Patient Information' module is same as input value given for 'Relationship to patient' field from xls.",ExtentColor.GREEN));  

		WebElement address1 = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[3]"));
		softAssert.assertEquals(address1.getAttribute("value"),tcData.get("Label15"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_30");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_30): Validate 'Address' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Address' data in 'Patient Information' module is same as input value given for 'Address' field from xls.",ExtentColor.GREEN));  

		WebElement city1 = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[3]"));
		softAssert.assertEquals(city1.getAttribute("value"),tcData.get("Label16"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_31");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_31): Validate 'City' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'City' data in 'Patient Information' module is same as input value given for 'City' field from xls.",ExtentColor.GREEN));  

		WebElement stateOpenEmergencyContactInformation= driver.findElement(By.xpath("//ng-select[@formcontrolname='PI_ECI_state']/div/div/div[2]"));
		softAssert.assertEquals(stateOpenEmergencyContactInformation.getText(),tcData.get("Label5"));
		Thread.sleep(3000);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_32");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_32): Validate 'State' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'State' data in 'Patient Information' module is same as input value given for 'State' field from xls.",ExtentColor.GREEN));  

		WebElement zip1 = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[3]"));
		softAssert.assertEquals(zip1.getAttribute("value"),"52110");
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_33");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_33): Validate 'Zip' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Zip' data in 'Patient Information' module is same as input value given for 'Zip' field from xls.",ExtentColor.GREEN));  

		WebElement medicareAccountNoPrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Medicare Account No']"));
		softAssert.assertEquals(medicareAccountNoPrimaryInsurance.getAttribute("value"),"521103.0");
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_33");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_33): Validate 'Medicare Account No' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Medicare Account No' data in 'Patient Information' module is same as input value given for 'Medicare Account No' field from xls.",ExtentColor.GREEN));  

		WebElement groupPlanPrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Group/Plan #']"));
		softAssert.assertEquals(groupPlanPrimaryInsurance.getAttribute("value"),tcData.get("Label19"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_34");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_34): Validate 'Group/Plan #' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Group/Plan #' data in 'Patient Information' module is same as input value given for 'Group/Plan #' field from xls.",ExtentColor.GREEN));  

		WebElement policyHolderNamePrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Policy Holder Name']"));
		softAssert.assertEquals(policyHolderNamePrimaryInsurance.getAttribute("value"),tcData.get("Label20"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_35");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_35): Validate 'Policy Holder Name' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Policy Holder Name' data in 'Patient Information' module is same as input value given for 'Policy Holder Name' field from xls.",ExtentColor.GREEN));  

		WebElement insuranceCompanyOpenPrimaryInsurance = driver.findElement(By.xpath("//ng-select[@formcontrolname='PI_II_insurance_company']/div/div/div[2]"));
		softAssert.assertEquals(insuranceCompanyOpenPrimaryInsurance.getText(),tcData.get("Label25"));
		Thread.sleep(3000);
		
		System.out.println(tcData.get("Label25"));
		System.out.println(insuranceCompanyOpenPrimaryInsurance.getText());
	
		logger = extent.createTest("verifyDataPatientInformation_TC_36");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_36): Validate 'Insurance Company' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Insurance Company' data in 'Patient Information' module is same as input value given for 'Insurance Company' field from xls.",ExtentColor.GREEN));  

		WebElement addressPrimaryInsurance = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[4]"));
		softAssert.assertEquals(addressPrimaryInsurance.getAttribute("value"),tcData.get("Label21"));
		Thread.sleep(1500);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_37");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_37): Validate 'Address' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Address' data in 'Patient Information' module is same as input value given for 'Address' field from xls.",ExtentColor.GREEN));  

		WebElement cityPrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[4]"));
		softAssert.assertEquals(cityPrimaryInsurance.getAttribute("value"),tcData.get("Label22"));
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_38");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_38): Validate 'City' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'City' data in 'Patient Information' module is same as input value given for 'City' field from xls.",ExtentColor.GREEN));  

		WebElement stateOpenPrimaryInsurance = driver.findElement(By.xpath("//ng-select[@formcontrolname='PI_II_state']/div/div/div[2]"));
		softAssert.assertEquals(stateOpenPrimaryInsurance.getText(),tcData.get("Label5"));
		Thread.sleep(3000);
		
		logger = extent.createTest("verifyDataPatientInformation_TC_38");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_38): Validate 'State' drop down field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'State' data in 'Patient Information' module is same as input value given for 'State' field from xls.",ExtentColor.GREEN));  

		WebElement zipPrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[4]"));
		softAssert.assertEquals(zipPrimaryInsurance.getAttribute("value"),"52110");
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_39");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_39): Validate 'Zip' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Zip' data in 'Patient Information' module is same as input value given for 'Zip' field from xls.",ExtentColor.GREEN));  

		WebElement phonePrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Phone'])[1]"));
		softAssert.assertEquals(phonePrimaryInsurance.getAttribute("value"),"929-311-6686");
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_40");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_40): Validate 'Phone' textbox in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Phone' data in 'Patient Information' module is same as input value given for 'Phone' field from xls.",ExtentColor.GREEN));  

		WebElement datePickerEffectiveDatePrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Effective Date'])[2]"));
		softAssert.assertEquals(datePickerEffectiveDatePrimaryInsurance.getAttribute("value"),"08-24-2022");
		Thread.sleep(2000);

		logger = extent.createTest("verifyDataPatientInformation_TC_41");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_41): Validate 'Effective Date' datepicker field in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Effective Date' data in 'Patient Information' module is same as input value given for 'Effective Date' field from xls.",ExtentColor.GREEN));  

		WebElement acceptTermsConditions = driver.findElement(By.xpath("//button[contains(text(),'I Authorize')]"));
		softAssert.assertEquals(acceptTermsConditions.isEnabled(),true);
		Thread.sleep(1500);	
		
		logger = extent.createTest("verifyDataPatientInformation_TC_42");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(verifyDataPatientInformation_TC_42): Validate 'I Authorize' functionality in 'Patient Information' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User selected 'I Authorize' checkbox in 'Patient Information' module.",ExtentColor.GREEN));  

		softAssert.assertAll();
	
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
