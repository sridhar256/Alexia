package com.alexiageriatrics.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alexiageriatrics.base.TestBase;
import com.alexiageriatrics.util.TestUtil;

public class PatientAcknowledgementPage extends TestBase {
	
	@FindBy(xpath="//div[@id='patient-acknowledgement']/div/h4")
	WebElement patientAcknowledgement;

	public void clickPatientAcknowledgement() {
		patientAcknowledgement.click();
	}
	
	
	
	
	@FindBy(xpath="//input[@placeholder = 'First Name']")
	WebElement firstName;

	public void clearfirstName() {
		firstName.clear();
	}
	
	public void enterFirstName(String FirstName) {
		firstName.sendKeys(FirstName);
	}
	
	@FindBy(xpath="//input[@placeholder = 'Last Name']")
	WebElement lastName;

	public void clearlastName() {
		lastName.clear();
	}
	
	public void enterLastName(String LastName) {
		lastName.sendKeys(LastName);
	}
	
	@FindBy(xpath="//input[@placeholder = 'Date of Birth']")
	WebElement dateOfBirth;

	public void clickDateOfBirth() {
		dateOfBirth.click();
	}

	public PatientAcknowledgementPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	
}
