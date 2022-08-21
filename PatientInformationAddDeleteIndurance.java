package com.alexiageriatrics.functionality;


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

public class PatientInformationAddDeleteIndurance extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public PatientInformationAddDeleteIndurance() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1,enabled =false)
	public void verifyAddDeleteInsurance() throws Exception {
		tcData = TestUtil.readDataFromTC("AddInsurance");
		
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifyAddDeleteInsurance_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddDeleteInsurance_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifyAddDeleteInsurance_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddDeleteInsurance_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifyAddDeleteInsurance_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddDeleteInsurance_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
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
		
		WebElement stateOpen= driver.findElement(By.xpath("//select[@formcontrolname='PI_PD_state']"));
		Select stateValue = new Select(stateOpen);
		stateValue.selectByValue("11");
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
		
		WebElement socialSecurity = driver.findElement(By.xpath("(//input[@placeholder = 'Social Security #'])[1]"));
		socialSecurity.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		socialSecurity.sendKeys(tcData.get("Label6"));
		Thread.sleep(1500);	
		
		WebElement employer = driver.findElement(By.xpath("//input[@placeholder = 'Employer']"));
		employer.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		employer.sendKeys(tcData.get("Label7"));
		Thread.sleep(1500);	
		
		WebElement homePhone = driver.findElement(By.xpath("(//input[@placeholder = 'Home Phone'])[1]"));
		homePhone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		homePhone.sendKeys(tcData.get("Label8"));
		Thread.sleep(1500);	
		
		WebElement workPhone = driver.findElement(By.xpath("(//input[@placeholder = 'Work Phone'])[1]"));
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
		
		WebElement yesOption = driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[1]"));
		yesOption.click();
		Thread.sleep(3000);	
		
		WebElement personResponsible = driver.findElement(By.xpath("//input[@placeholder = 'Person responsible for charges (if other than patient)']"));
		personResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		personResponsible.sendKeys(tcData.get("Label11"));
		Thread.sleep(1500);
		
		WebElement addressPersonResponsible = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[2]"));
		addressPersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		addressPersonResponsible.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);
		
		WebElement cityPersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[2]"));
		cityPersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		cityPersonResponsible.sendKeys(tcData.get("Label4"));
		Thread.sleep(1500);	
		
		WebElement statePersonResponsibleOpen= driver.findElement(By.xpath("//select[@formcontrolname='PI_PD_IOTP_state']"));
		Select statePersonResponsibleValue = new Select(statePersonResponsibleOpen);
		statePersonResponsibleValue.selectByValue("11");
		Thread.sleep(3000);
		
		WebElement zipPersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[2]"));
		zipPersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zipPersonResponsible.sendKeys(tcData.get("Label5"));
		Thread.sleep(1500);	
		
		WebElement relationshipToPatientPersonResponsibleOpen= driver.findElement(By.xpath("//select[@formcontrolname='PI_PD_IOTP_realtionship_to_patient']"));
		Select relationshipToPatientPersonResponsibleValue = new Select(relationshipToPatientPersonResponsibleOpen);
		relationshipToPatientPersonResponsibleValue.selectByValue("7");
		Thread.sleep(3000);
		
		WebElement socialSecurityPersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Social Security #'])[2]"));
		socialSecurityPersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		socialSecurityPersonResponsible.sendKeys(tcData.get("Label6"));
		Thread.sleep(1500);	
		
		WebElement homePhonePersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Home Phone'])[2]"));
		homePhonePersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		homePhonePersonResponsible.sendKeys(tcData.get("Label8"));
		Thread.sleep(1500);	
		
		WebElement workPhonePersonResponsible = driver.findElement(By.xpath("(//input[@placeholder = 'Work Phone'])[2]"));
		workPhonePersonResponsible.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		workPhonePersonResponsible.sendKeys(tcData.get("Label9"));
		Thread.sleep(1500);
		
		
		WebElement prefferedContactPersonResponsibleCheckbox = driver.findElement(By.xpath("//input[@id='Email']"));
		if (!prefferedContactPersonResponsibleCheckbox.isSelected()){
			System.out.println("PrefferedContactPersonResponsibleCheckbox is selected");  
			js.executeScript("arguments[0].click();", prefferedContactPersonResponsibleCheckbox);
		}
		else {
			System.out.println("PrefferedContactPersonResponsibleCheckbox is not selected");
		}
		Thread.sleep(3000);
		
		WebElement name = driver.findElement(By.xpath("//input[@placeholder = 'Name']"));
		name.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		name.sendKeys(tcData.get("Label11"));
		Thread.sleep(1500);
		
		WebElement phone = driver.findElement(By.xpath("//input[@placeholder = 'Phone #']"));
		phone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		phone.sendKeys(tcData.get("Label12"));
		Thread.sleep(1500);
		
		WebElement relationshipToPatientOpen= driver.findElement(By.xpath("//select[@formcontrolname='PI_ECI_relationship_to_patient']"));
		Select relationshipToPatientValue = new Select(relationshipToPatientOpen);
		relationshipToPatientValue.selectByValue("7");
		Thread.sleep(3000);
		
		WebElement address1 = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[3]"));
		address1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		address1.sendKeys(tcData.get("Label13"));
		Thread.sleep(1500);
		
		WebElement city1 = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[3]"));
		city1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		city1.sendKeys(tcData.get("Label14"));
		Thread.sleep(1500);	
		
		WebElement stateOpenEmergencyContactInformation= driver.findElement(By.xpath("//select[@formcontrolname='PI_ECI_state']"));
		Select stateValueEmergencyContactInformation = new Select(stateOpenEmergencyContactInformation);
		stateValueEmergencyContactInformation.selectByValue("11");
		Thread.sleep(3000);
		
		WebElement zip1 = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[3]"));
		zip1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zip1.sendKeys(tcData.get("Label15"));
		Thread.sleep(1500);	
		
		WebElement medicareAccountNoPrimaryInsurance = driver.findElement(By.xpath("//input[@placeholder = 'Medicare Account No']"));
		medicareAccountNoPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		medicareAccountNoPrimaryInsurance.sendKeys(tcData.get("Label16"));
		Thread.sleep(1500);
		
		WebElement groupPlanPrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Group/Plan #'])[1]"));
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
		
		WebElement addressPrimaryInsurance = driver.findElement(By.xpath("(//textarea[@placeholder = 'Address'])[4]"));
		addressPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		addressPrimaryInsurance.sendKeys(tcData.get("Label19"));
		Thread.sleep(1500);
		
		WebElement cityPrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'City'])[4]"));
		cityPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		cityPrimaryInsurance.sendKeys(tcData.get("Label20"));
		Thread.sleep(1500);	
		
		WebElement stateOpenPrimaryInsurance = driver.findElement(By.xpath("//select[@formcontrolname='PI_II_state']"));
		Select stateValuePrimaryInsurance = new Select(stateOpenPrimaryInsurance);
		stateValuePrimaryInsurance.selectByValue("11");
		Thread.sleep(3000);
		
		WebElement zipPrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Zip'])[4]"));
		zipPrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		zipPrimaryInsurance.sendKeys(tcData.get("Label21"));
		Thread.sleep(1500);	
		
		WebElement phonePrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Phone'])[1]"));
		phonePrimaryInsurance.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		phonePrimaryInsurance.sendKeys(tcData.get("Label22"));
		Thread.sleep(1500);	
		
		WebElement datePickerEffectiveDatePrimaryInsurance = driver.findElement(By.xpath("(//input[@placeholder = 'Effective Date'])[2]"));
		js.executeScript("arguments[0].click();", datePickerEffectiveDatePrimaryInsurance);
		Thread.sleep(2000);

		WebElement effectiveDatePrimaryInsurance  = driver.findElement(By.xpath("(//span[@aria-current='date'])[2]"));
		js.executeScript("arguments[0].click();", effectiveDatePrimaryInsurance);
		Thread.sleep(2000);
		
		WebElement addInsurance = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[1]"));
		addInsurance.click();
		Thread.sleep(3000);	
		
		WebElement iDContractInsurance2 = driver.findElement(By.xpath("//input[@placeholder = 'ID/Contract #']"));
		iDContractInsurance2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		iDContractInsurance2.sendKeys(tcData.get("Label16"));
		Thread.sleep(1500);
		
		WebElement groupPlanInsurance2 = driver.findElement(By.xpath("(//input[@placeholder = 'Group/Plan #'])[2]"));
		groupPlanInsurance2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		groupPlanInsurance2.sendKeys(tcData.get("Label17"));
		Thread.sleep(1500);
		
		WebElement datePickerEffectiveDateInsurance2 = driver.findElement(By.xpath("(//input[@placeholder = 'Effective Date'])[4]"));
		js.executeScript("arguments[0].click();", datePickerEffectiveDateInsurance2);
		Thread.sleep(2000);
		
		WebElement effectiveDateInsurance2 = driver.findElement(By.xpath("(//span[@aria-current='date'])[5]"));
		js.executeScript("arguments[0].click();", effectiveDateInsurance2);
		Thread.sleep(2000);

		WebElement deleteInsurance = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])"));
		deleteInsurance.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation.click();
		Thread.sleep(3000);	
		
		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	

	}


	@Test(priority=3,enabled =false)
	public void verifyAddDeleteInsurances() throws Exception {
		tcData = TestUtil.readDataFromTC("AddInsurance");
		
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifyAddDeleteInsurances_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddDeleteInsurances_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifyAddDeleteInsurances_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddDeleteInsurances_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifyAddDeleteInsurances_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddDeleteInsurances_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientInformation = driver.findElement(By.xpath("//div[@id='patient-information']/div/h4"));
		patientInformation.click();
		Thread.sleep(3000);	
		
		WebElement addInsurance = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[1]"));
		addInsurance.click();
		Thread.sleep(3000);	
		
		WebElement iDContractInsurance2 = driver.findElement(By.xpath("(//input[@placeholder = 'ID/Contract #'])[1]"));
		iDContractInsurance2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		iDContractInsurance2.sendKeys(tcData.get("Label16"));
		Thread.sleep(1500);
		
		WebElement groupPlanInsurance2 = driver.findElement(By.xpath("(//input[@placeholder = 'Group/Plan #'])[1]"));
		groupPlanInsurance2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		groupPlanInsurance2.sendKeys(tcData.get("Label17"));
		Thread.sleep(1500);
		
		addInsurance.click();
		Thread.sleep(3000);	
		
		WebElement iDContractInsurance3 = driver.findElement(By.xpath("(//input[@placeholder = 'ID/Contract #'])[2]"));
		iDContractInsurance3.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		iDContractInsurance3.sendKeys(tcData.get("Label16"));
		Thread.sleep(1500);
		
		WebElement groupPlanInsurance3 = driver.findElement(By.xpath("(//input[@placeholder = 'Group/Plan #'])[2]"));
		groupPlanInsurance3.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		groupPlanInsurance3.sendKeys(tcData.get("Label17"));
		Thread.sleep(1500);
		
		addInsurance.click();
		Thread.sleep(3000);	
		
		WebElement iDContractInsurance4 = driver.findElement(By.xpath("(//input[@placeholder = 'ID/Contract #'])[3]"));
		iDContractInsurance3.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		iDContractInsurance3.sendKeys(tcData.get("Label16"));
		Thread.sleep(1500);
		
		WebElement groupPlanInsurance4 = driver.findElement(By.xpath("(//input[@placeholder = 'Group/Plan #'])[3]"));
		groupPlanInsurance4.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		groupPlanInsurance4.sendKeys(tcData.get("Label17"));
		Thread.sleep(1500);
		
		addInsurance.click();
		Thread.sleep(3000);	
		
		WebElement iDContractInsurance5 = driver.findElement(By.xpath("(//input[@placeholder = 'ID/Contract #'])[4]"));
		iDContractInsurance5.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		iDContractInsurance5.sendKeys(tcData.get("Label16"));
		Thread.sleep(1500);
		
		WebElement groupPlanInsurance5 = driver.findElement(By.xpath("(//input[@placeholder = 'Group/Plan #'])[4]"));
		groupPlanInsurance5.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		groupPlanInsurance5.sendKeys(tcData.get("Label17"));
		Thread.sleep(1500);
		
		addInsurance.click();
		Thread.sleep(3000);	
		
		WebElement iDContractInsurance6 = driver.findElement(By.xpath("(//input[@placeholder = 'ID/Contract #'])[5]"));
		iDContractInsurance6.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		iDContractInsurance6.sendKeys(tcData.get("Label16"));
		Thread.sleep(1500);
		
		WebElement groupPlanInsurance6 = driver.findElement(By.xpath("(//input[@placeholder = 'Group/Plan #'])[5]"));
		groupPlanInsurance6.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		groupPlanInsurance6.sendKeys(tcData.get("Label17"));
		Thread.sleep(1500);
		
		WebElement deleteInsurance2 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance2.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation2 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation2.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsurance3 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance3.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation3 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation3.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsurance4 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance4.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation4 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation4.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsurance5 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance5.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation5 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation5.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsurance6 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance6.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation6 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation6.click();
		Thread.sleep(3000);	
		
		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	
		
	}
	
	
	
	@Test(priority=4,enabled =true)
	public void verifyAddAndDeleteInsurances() throws Exception {
		tcData = TestUtil.readDataFromTC("AddInsurance");
		
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifyAddAndDeleteInsurances_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddAndDeleteInsurances_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifyAddAndDeleteInsurances_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddAndDeleteInsurances_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifyAddAndDeleteInsurances_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddAndDeleteInsurances_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientInformation = driver.findElement(By.xpath("//div[@id='patient-information']/div/h4"));
		patientInformation.click();
		Thread.sleep(3000);	
		
		WebElement addInsurance = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[1]"));
		addInsurance.click();
		Thread.sleep(3000);	
		
		addInsurance.click();
		Thread.sleep(3000);	
		
		addInsurance.click();
		Thread.sleep(3000);	
		
		addInsurance.click();
		Thread.sleep(3000);	
		
		addInsurance.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsurance2 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance2.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation2 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation2.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsurance3 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance3.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation3 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation3.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsurance4 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance4.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation4 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation4.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsurance5 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance5.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation5 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation5.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsurance6 = driver.findElement(By.xpath("(//span[@class='bi bi-trash-fill text-danger cursor-pointer'])[1]"));
		deleteInsurance6.click();
		Thread.sleep(3000);	
		
		WebElement deleteInsuranceConfirmation6 = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteInsuranceConfirmation6.click();
		Thread.sleep(3000);	
		
		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	
		
	}
	
	
	@Test(priority=5,enabled =true)
	public void verifyAddAndDeleteInsurancesWorking() throws Exception {
		tcData = TestUtil.readDataFromTC("AddInsurance");
		
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifyAddAndDeleteInsurancesWorking_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddAndDeleteInsurancesWorking_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifyAddAndDeleteInsurancesWorking_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddAndDeleteInsurancesWorking_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifyAddAndDeleteInsurancesWorking_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifyAddAndDeleteInsurancesWorking_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement patientInformation = driver.findElement(By.xpath("//div[@id='patient-information']/div/h4"));
		patientInformation.click();
		Thread.sleep(3000);	
		
		WebElement addInsurance = driver.findElement(By.xpath("(//span[@class='bi bi-plus-circle-fill text-primary cursor-pointer'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", addInsurance);

		
	}
	
	

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
