package com.alexiageriatrics.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alexiageriatrics.base.*;
import com.alexiageriatrics.util.TestUtil;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//span[contains(text(),'Patient Acknowledgement')]")
	WebElement patientAcknowledgement;

	public void clickOnPatientAcknowledgement() {
		patientAcknowledgement.click();
	}

	@FindBy(xpath="//span[contains(text(),'Patient Information')]")
	WebElement patientInformation;

	public void clickOnPatientInformation() {
		patientInformation.click();
	}

	public boolean verifyPatientInformation(){
		return patientInformation.isDisplayed();
	}
	
	@FindBy(xpath="//span[contains(text(),'Medical Records Release Form')]")
	WebElement medicalRecordsReleaseForm;

	public void clickOnMedicalRecordsReleaseForm() {
		medicalRecordsReleaseForm.click();
	}

	public boolean verifyMedicalRecordsReleaseForm(){
		return medicalRecordsReleaseForm.isDisplayed();
	}
	
	@FindBy(xpath="//span[contains(text(),'Geriatrics')]")
	WebElement geriatrics;

	public void clickOnGeriatrics() {
		geriatrics.click();
	}

	public boolean verifyGeriatrics(){
		return geriatrics.isDisplayed();
	}
	
	@FindBy(xpath="//span[contains(text(),'Health Questionnaire')]")
	WebElement healthQuestionnaire;

	public void clickOnHealthQuestionnaire() {
		healthQuestionnaire.click();
	}

	public boolean verifyHealthQuestionnaire(){
		return healthQuestionnaire.isDisplayed();
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Patient Health Questionnaire')]")
	WebElement patientHealthQuestionnaire;

	public void clickOnPatientHealthQuestionnaire() {
		patientHealthQuestionnaire.click();
	}

	public boolean verifyPatientHealthQuestionnaire(){
		return patientHealthQuestionnaire.isDisplayed();
	}
	
	@FindBy(xpath="//span[contains(text(),'Morse Fall Scale')]")
	WebElement morseFallScale;

	public void clickOnMorseFallScale() {
		morseFallScale.click();
	}

	public boolean verifyMorseFallScale(){
		return morseFallScale.isDisplayed();
	}
	
	@FindBy(xpath="//span[contains(text(),'CHAMPS Activities')]")
	WebElement cHAMPSActivities;

	public void clickCHAMPSActivities() {
		cHAMPSActivities.click();
	}

	public boolean verifyCHAMPSActivities(){
		return cHAMPSActivities.isDisplayed();
	}
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void waitForClickOnPatientInformation(){
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(patientInformation));   
	}

	public void waitForClickOnMedicalRecordsReleaseForm(){
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(medicalRecordsReleaseForm));   
	}

	public void waitForClickOnGeriatrics(){
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(geriatrics));   
	}

	public void waitForClickOnHealthQuestionnaire(){
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(healthQuestionnaire));   
	}
	
	public void waitForClickOnPatientHealthQuestionnaire(){
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(patientHealthQuestionnaire));   
	}


	public void waitForClickOnMorseFallScale(){
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(morseFallScale));   
	}

	public void waitForClickOnCHAMPSActivities(){
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(cHAMPSActivities));   
	}

	
}
