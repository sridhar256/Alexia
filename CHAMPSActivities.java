package com.alexiageriatrics.testcases;


import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
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

public class CHAMPSActivities extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PatientAcknowledgementPage patientAcknowledgementPage;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	HashMap<String, String> tcData;

	public CHAMPSActivities() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
	}


	@Test(priority=1,enabled=true)
	public void updateDataCHAMPSActivities() throws Exception {

		tcData = TestUtil.readDataFromTC("ChampsActivities");		
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_1");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_1): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_2");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_2): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_3");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_3): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement champsActivities = driver.findElement(By.xpath("//div[@id='champs']/div/h4"));
		champsActivities.click();
		Thread.sleep(3000);	

		WebElement visitWithFriends = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[1]"));
		if (!visitWithFriends.isSelected()){
			System.out.println("VisitWithFriends Yes option is selected");  
			js.executeScript("arguments[0].click();", visitWithFriends);
		}
		else {
			System.out.println("VisitWithFriends Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement visitWithFriendsTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[1]"));
		visitWithFriendsTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		visitWithFriendsTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		//WebElement visitWithFriendsHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[1]"));
		//Select visitWithFriendsHoursWeekValue = new Select(visitWithFriendsHoursWeekOpen);
		//visitWithFriendsHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);
		
		
		WebElement visitWithFriendsHoursWeekOpen= driver.findElement(By.xpath("(//ng-select[@formcontrolname='duration_id'])[1]"));
		visitWithFriendsHoursWeekOpen.click();
		Thread.sleep(1500);
		WebElement visitWithFriendsHoursWeekValue= driver.findElement(By.xpath("(//div[contains(text(),'7 to 9 hours')])[1]"));
		js.executeScript("arguments[0].click();", visitWithFriendsHoursWeekValue);
		Thread.sleep(3000);
		
		

		WebElement goToTheSeniorCenter = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[3]"));
		if (!goToTheSeniorCenter.isSelected()){
			System.out.println("GoToTheSeniorCenter Yes option is selected");  
			js.executeScript("arguments[0].click();", goToTheSeniorCenter);
		}
		else {
			System.out.println("GoToTheSeniorCenter Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement goToTheSeniorCenterTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[2]"));
		goToTheSeniorCenterTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		goToTheSeniorCenterTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement goToTheSeniorCenterHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[2]"));
		Select goToTheSeniorCenterHoursWeekValue = new Select(goToTheSeniorCenterHoursWeekOpen);
		goToTheSeniorCenterHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement doVolunteerWork = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[5]"));
		if (!doVolunteerWork.isSelected()){
			System.out.println("DoVolunteerWork Yes option is selected");  
			js.executeScript("arguments[0].click();", doVolunteerWork);
		}
		else {
			System.out.println("DoVolunteerWork Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement doVolunteerWorkTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[3]"));
		doVolunteerWorkTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doVolunteerWorkTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement doVolunteerWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[3]"));
		Select doVolunteerWorkHoursWeekValue = new Select(doVolunteerWorkHoursWeekOpen);
		doVolunteerWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement attendChurch = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[7]"));
		if (!attendChurch.isSelected()){
			System.out.println("AttendChurch Yes option is selected");  
			js.executeScript("arguments[0].click();", attendChurch);
		}
		else {
			System.out.println("AttendChurch Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement attendChurchTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[4]"));
		attendChurchTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		attendChurchTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement attendChurchWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[4]"));
		Select attendChurchWorkHoursWeekValue = new Select(attendChurchWorkHoursWeekOpen);
		attendChurchWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement attendClub = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[9]"));
		if (!attendClub.isSelected()){
			System.out.println("AttendClub Yes option is selected");  
			js.executeScript("arguments[0].click();", attendClub);
		}
		else {
			System.out.println("AttendClub Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement attendClubTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[5]"));
		attendClubTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		attendClubTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement attendClubTimesWeekWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[5]"));
		Select attendClubTimesWeekWorkHoursWeekValue = new Select(attendClubTimesWeekWorkHoursWeekOpen);
		attendClubTimesWeekWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement useComputer = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[11]"));
		if (!useComputer.isSelected()){
			System.out.println("UseComputer Yes option is selected");  
			js.executeScript("arguments[0].click();", useComputer);
		}
		else {
			System.out.println("UseComputer Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement UseComputerTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[6]"));
		UseComputerTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		UseComputerTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement useComputerWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[6]"));
		Select useComputerWorkHoursWeekValue = new Select(useComputerWorkHoursWeekOpen);
		useComputerWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement dance = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[13]"));
		if (!dance.isSelected()){
			System.out.println("Dance Yes option is selected");  
			js.executeScript("arguments[0].click();", dance);
		}
		else {
			System.out.println("Dance Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement danceTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[7]"));
		danceTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		danceTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement danceWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[7]"));
		Select danceWorkHoursWeekOpenValue = new Select(danceWorkHoursWeekOpen);
		danceWorkHoursWeekOpenValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement doWoodWorking = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[15]"));
		if (!doWoodWorking.isSelected()){
			System.out.println("DoWoodWorking Yes option is selected");  
			js.executeScript("arguments[0].click();", doWoodWorking);
		}
		else {
			System.out.println("DoWoodWorking Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement doWoodWorkingTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[8]"));
		doWoodWorkingTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doWoodWorkingTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement doWoodWorkingWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[8]"));
		Select doWoodWorkingWorkHoursWeekValue = new Select(doWoodWorkingWorkHoursWeekOpen);
		doWoodWorkingWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement playGolf = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[17]"));
		if (!playGolf.isSelected()){
			System.out.println("PlayGolf Yes option is selected");  
			js.executeScript("arguments[0].click();", playGolf);
		}
		else {
			System.out.println("PlayGolf Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement playGolfTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[9]"));
		playGolfTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		playGolfTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement playGolfWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[9]"));
		Select playGolfWorkHoursWeekValue = new Select(playGolfWorkHoursWeekOpen);
		playGolfWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement playGolfRidingACart = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[19]"));
		if (!playGolfRidingACart.isSelected()){
			System.out.println("PlayGolfRidingACart Yes option is selected");  
			js.executeScript("arguments[0].click();", playGolfRidingACart);
		}
		else {
			System.out.println("PlayGolfRidingACart Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement playGolfRidingACartTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[10]"));
		playGolfRidingACartTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		playGolfRidingACartTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement playGolfRidingACartWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[10]"));
		Select playGolfRidingACartWorkHoursWeekValue = new Select(playGolfRidingACartWorkHoursWeekOpen);
		playGolfRidingACartWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement attendMovie = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[21]"));
		if (!attendMovie.isSelected()){
			System.out.println("AttendMovie Yes option is selected");  
			js.executeScript("arguments[0].click();", attendMovie);
		}
		else {
			System.out.println("AttendMovie Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement attendMovieTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[11]"));
		attendMovieTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		attendMovieTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement attendMovieWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[11]"));
		Select attendMovieWorkHoursWeekValue = new Select(attendMovieWorkHoursWeekOpen);
		attendMovieWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement playCards = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[23]"));
		if (!playCards.isSelected()){
			System.out.println("PlayCards Yes option is selected");  
			js.executeScript("arguments[0].click();", playCards);
		}
		else {
			System.out.println("PlayCards Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement playCardsTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[12]"));
		playCardsTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		playCardsTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement playCardsWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[12]"));
		Select playCardsWorkHoursWeekValue = new Select(playCardsWorkHoursWeekOpen);
		playCardsWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement shootPool = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[25]"));
		if (!shootPool.isSelected()){
			System.out.println("ShootPool Yes option is selected");  
			js.executeScript("arguments[0].click();", shootPool);
		}
		else {
			System.out.println("ShootPool Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement shootPoolTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[13]"));
		shootPoolTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		shootPoolTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement shootPoolWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[13]"));
		Select shootPoolWorkHoursWeekValue = new Select(shootPoolWorkHoursWeekOpen);
		shootPoolWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement playSinglesTennis  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[27]"));
		if (!playSinglesTennis.isSelected()){
			System.out.println("PlaySinglesTennis Yes option is selected");  
			js.executeScript("arguments[0].click();", playSinglesTennis);
		}
		else {
			System.out.println("PlaySinglesTennis Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement playSinglesTennisTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[14]"));
		playSinglesTennisTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		playSinglesTennisTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement playSinglesTennisWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[14]"));
		Select playSinglesTennisWorkHoursWeekValue = new Select(playSinglesTennisWorkHoursWeekOpen);
		playSinglesTennisWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement playdoublesTennis  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[29]"));
		if (!playdoublesTennis.isSelected()){
			System.out.println("PlaydoublesTennis Yes option is selected");  
			js.executeScript("arguments[0].click();", playdoublesTennis);
		}
		else {
			System.out.println("PlaydoublesTennis Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement playdoublesTennisTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[15]"));
		playdoublesTennisTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		playdoublesTennisTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement playdoublesTennisWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[15]"));
		Select playdoublesTennisWorkHoursWeekValue = new Select(playdoublesTennisWorkHoursWeekOpen);
		playdoublesTennisWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement skate  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[31]"));
		if (!skate.isSelected()){
			System.out.println("skate Yes option is selected");  
			js.executeScript("arguments[0].click();", skate);
		}
		else {
			System.out.println("skate Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement skateTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[16]"));
		skateTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		skateTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement skateWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[16]"));
		Select skateWorkHoursWeekValue = new Select(skateWorkHoursWeekOpen);
		skateWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement playMusicalInstrument  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[33]"));
		if (!playMusicalInstrument.isSelected()){
			System.out.println("playMusicalInstrument Yes option is selected");  
			js.executeScript("arguments[0].click();", playMusicalInstrument);
		}
		else {
			System.out.println("playMusicalInstrument Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement playMusicalInstrumentTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[17]"));
		playMusicalInstrumentTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		playMusicalInstrumentTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement playMusicalInstrumentWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[17]"));
		Select playMusicalInstrumentWorkHoursWeekValue = new Select(playMusicalInstrumentWorkHoursWeekOpen);
		playMusicalInstrumentWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement read  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[35]"));
		if (!read.isSelected()){
			System.out.println("read Yes option is selected");  
			js.executeScript("arguments[0].click();", read);
		}
		else {
			System.out.println("read Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement readTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[18]"));
		readTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		readTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement readWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[18]"));
		Select readWorkHoursWeekValue = new Select(readWorkHoursWeekOpen);
		readWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement doHeavyWork  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[37]"));
		if (!doHeavyWork.isSelected()){
			System.out.println("doHeavyWork Yes option is selected");  
			js.executeScript("arguments[0].click();", doHeavyWork);
		}
		else {
			System.out.println("doHeavyWork Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement doHeavyWorkTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[19]"));
		doHeavyWorkTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doHeavyWorkTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement doHeavyWorkWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[19]"));
		Select doHeavyWorkWorkHoursWeekValue = new Select(doHeavyWorkWorkHoursWeekOpen);
		doHeavyWorkWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement doLightWork  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[39]"));
		if (!doLightWork.isSelected()){
			System.out.println("doLightWork Yes option is selected");  
			js.executeScript("arguments[0].click();", doLightWork);
		}
		else {
			System.out.println("doLightWork Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement doLightWorkTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[20]"));
		doLightWorkTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doLightWorkTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement doLightWorkWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[20]"));
		Select doLightWorkWorkHoursWeekValue = new Select(doLightWorkWorkHoursWeekOpen);
		doLightWorkWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement doHeavyGardening  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[41]"));
		if (!doHeavyGardening.isSelected()){
			System.out.println("doHeavyGardening Yes option is selected");  
			js.executeScript("arguments[0].click();", doHeavyGardening);
		}
		else {
			System.out.println("doHeavyGardening Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement doHeavyGardeningTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[21]"));
		doHeavyGardeningTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doHeavyGardeningTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement doHeavyGardeningWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[21]"));
		Select doHeavyGardeningWorkHoursWeekValue = new Select(doHeavyGardeningWorkHoursWeekOpen);
		doHeavyGardeningWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement doLightGardening  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[43]"));
		if (!doLightGardening.isSelected()){
			System.out.println("doLightGardening Yes option is selected");  
			js.executeScript("arguments[0].click();", doLightGardening);
		}
		else {
			System.out.println("doLightGardening Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement doLightGardeningTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[22]"));
		doLightGardeningTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doLightGardeningTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement doLightGardeningWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[22]"));
		Select doLightGardeningWorkHoursWeekValue = new Select(doLightGardeningWorkHoursWeekOpen);
		doLightGardeningWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement workOnYourCar  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[45]"));
		if (!workOnYourCar.isSelected()){
			System.out.println("workOnYourCar Yes option is selected");  
			js.executeScript("arguments[0].click();", workOnYourCar);
		}
		else {
			System.out.println("workOnYourCar Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement workOnYourCarTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[23]"));
		workOnYourCarTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		workOnYourCarTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement workOnYourCarWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[23]"));
		Select workOnYourCarWorkHoursWeekValue = new Select(workOnYourCarWorkHoursWeekOpen);
		workOnYourCarWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement jogOrRun  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[47]"));
		if (!jogOrRun.isSelected()){
			System.out.println("jogOrRun Yes option is selected");  
			js.executeScript("arguments[0].click();", jogOrRun);
		}
		else {
			System.out.println("jogOrRun Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement jogOrRunTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[24]"));
		jogOrRunTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		jogOrRunTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement jogOrRunWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[24]"));
		Select jogOrRunWorkHoursWeekValue = new Select(jogOrRunWorkHoursWeekOpen);
		jogOrRunWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement walkUphill  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[49]"));
		if (!walkUphill.isSelected()){
			System.out.println("walkUphill Yes option is selected");  
			js.executeScript("arguments[0].click();", walkUphill);
		}
		else {
			System.out.println("walkUphill Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement walkUphillTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[25]"));
		walkUphillTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		walkUphillTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement walkUphillWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[25]"));
		Select walkUphillWorkHoursWeekValue = new Select(walkUphillWorkHoursWeekOpen);
		walkUphillWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement walkFast  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[51]"));
		if (!walkFast.isSelected()){
			System.out.println("walkFast Yes option is selected");  
			js.executeScript("arguments[0].click();", walkFast);
		}
		else {
			System.out.println("walkFast Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement walkFastTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[26]"));
		walkFastTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		walkFastTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement walkFastWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[26]"));
		Select walkFastWorkHoursWeekValue = new Select(walkFastWorkHoursWeekOpen);
		walkFastWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement walkToDoErrands  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[53]"));
		if (!walkToDoErrands.isSelected()){
			System.out.println("walkToDoErrands Yes option is selected");  
			js.executeScript("arguments[0].click();", walkToDoErrands);
		}
		else {
			System.out.println("walkToDoErrands Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement walkToDoErrandsTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[27]"));
		walkToDoErrandsTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		walkToDoErrandsTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement walkToDoErrandsWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[27]"));
		Select walkToDoErrandsWorkHoursWeekValue = new Select(walkToDoErrandsWorkHoursWeekOpen);
		walkToDoErrandsWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement walkLeisurely  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[55]"));
		if (!walkLeisurely.isSelected()){
			System.out.println("walkLeisurely Yes option is selected");  
			js.executeScript("arguments[0].click();", walkLeisurely);
		}
		else {
			System.out.println("walkLeisurely Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement walkLeisurelyTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[28]"));
		walkLeisurelyTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		walkLeisurelyTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement walkLeisurelyWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[28]"));
		Select walkLeisurelyWorkHoursWeekValue = new Select(walkLeisurelyWorkHoursWeekOpen);
		walkLeisurelyWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement rideABicycle  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[57]"));
		if (!rideABicycle.isSelected()){
			System.out.println("rideABicycle Yes option is selected");  
			js.executeScript("arguments[0].click();", rideABicycle);
		}
		else {
			System.out.println("rideABicycle Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement rideABicycleTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[29]"));
		rideABicycleTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		rideABicycleTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement rideABicycleWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[29]"));
		Select rideABicycleWorkHoursWeekValue = new Select(rideABicycleWorkHoursWeekOpen);
		rideABicycleWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement doOtherAerobicMachines  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[59]"));
		if (!doOtherAerobicMachines.isSelected()){
			System.out.println("doOtherAerobicMachines Yes option is selected");  
			js.executeScript("arguments[0].click();", doOtherAerobicMachines);
		}
		else {
			System.out.println("doOtherAerobicMachines Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement doOtherAerobicMachinesTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[30]"));
		doOtherAerobicMachinesTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doOtherAerobicMachinesTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement doOtherAerobicMachinesWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[30]"));
		Select doOtherAerobicMachinesWorkHoursWeekValue = new Select(doOtherAerobicMachinesWorkHoursWeekOpen);
		doOtherAerobicMachinesWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement doWaterExercises  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[61]"));
		if (!doWaterExercises.isSelected()){
			System.out.println("doWaterExercises Yes option is selected");  
			js.executeScript("arguments[0].click();", doWaterExercises);
		}
		else {
			System.out.println("doWaterExercises Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement doWaterExercisesTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[31]"));
		doWaterExercisesTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doWaterExercisesTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement doWaterExercisesWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[31]"));
		Select doWaterExercisesWorkHoursWeekValue = new Select(doWaterExercisesWorkHoursWeekOpen);
		doWaterExercisesWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement  swimModerately  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[63]"));
		if (! swimModerately.isSelected()){
			System.out.println(" swimModerately Yes option is selected");  
			js.executeScript("arguments[0].click();",  swimModerately);
		}
		else {
			System.out.println(" swimModerately Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  swimModeratelyTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[32]"));
		swimModeratelyTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		swimModeratelyTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  swimModeratelyWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[32]"));
		Select  swimModeratelyWorkHoursWeekValue = new Select( swimModeratelyWorkHoursWeekOpen);
		swimModeratelyWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement  swimGently  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[65]"));
		if (! swimGently.isSelected()){
			System.out.println(" swimGently Yes option is selected");  
			js.executeScript("arguments[0].click();",  swimGently);
		}
		else {
			System.out.println(" swimGently Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  swimGentlyTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[33]"));
		swimGentlyTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		swimGentlyTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  swimGentlyWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[33]"));
		Select  swimGentlyWorkHoursWeekValue = new Select( swimGentlyWorkHoursWeekOpen);
		swimGentlyWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement  doStretching  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[67]"));
		if (! doStretching.isSelected()){
			System.out.println(" doStretching Yes option is selected");  
			js.executeScript("arguments[0].click();",  doStretching);
		}
		else {
			System.out.println(" doStretching Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  doStretchingTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[34]"));
		doStretchingTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doStretchingTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  doStretchingWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[34]"));
		Select  doStretchingWorkHoursWeekValue = new Select( doStretchingWorkHoursWeekOpen);
		doStretchingWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement  doYoga  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[69]"));
		if (! doYoga.isSelected()){
			System.out.println(" doYoga Yes option is selected");  
			js.executeScript("arguments[0].click();",  doYoga);
		}
		else {
			System.out.println(" doYoga Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  doYogaTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[35]"));
		doYogaTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doYogaTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  doYogaWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[35]"));
		Select  doYogaWorkHoursWeekValue = new Select( doYogaWorkHoursWeekOpen);
		doYogaWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement  doAerobics  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[71]"));
		if (! doAerobics.isSelected()){
			System.out.println(" doAerobics Yes option is selected");  
			js.executeScript("arguments[0].click();",  doAerobics);
		}
		else {
			System.out.println(" doAerobics Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  doAerobicsTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[36]"));
		doAerobicsTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doAerobicsTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  doAerobicsWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[36]"));
		Select  doAerobicsWorkHoursWeekValue = new Select( doAerobicsWorkHoursWeekOpen);
		doAerobicsWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);


		WebElement  doModerateTraining  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[73]"));
		if (! doModerateTraining.isSelected()){
			System.out.println(" doModerateTraining Yes option is selected");  
			js.executeScript("arguments[0].click();",  doModerateTraining);
		}
		else {
			System.out.println(" doModerateTraining Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  doModerateTrainingTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[37]"));
		doModerateTrainingTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doModerateTrainingTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  doModerateTrainingWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[37]"));
		Select  doModerateTrainingWorkHoursWeekValue = new Select( doModerateTrainingWorkHoursWeekOpen);
		doModerateTrainingWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement  doLightTraining  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[75]"));
		if (! doLightTraining.isSelected()){
			System.out.println(" doLightTraining Yes option is selected");  
			js.executeScript("arguments[0].click();",  doLightTraining);
		}
		else {
			System.out.println(" doLightTraining Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  doLightTrainingTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[38]"));
		doLightTrainingTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doLightTrainingTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  doLightTrainingWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[38]"));
		Select  doLightTrainingWorkHoursWeekValue = new Select( doLightTrainingWorkHoursWeekOpen);
		doLightTrainingWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement  doConditioningExercises  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[77]"));
		if (! doConditioningExercises.isSelected()){
			System.out.println(" doConditioningExercises Yes option is selected");  
			js.executeScript("arguments[0].click();",  doConditioningExercises);
		}
		else {
			System.out.println(" doConditioningExercises Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  doConditioningExercisesTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[39]"));
		doConditioningExercisesTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		doConditioningExercisesTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  doConditioningExercisesWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[39]"));
		Select  doConditioningExercisesWorkHoursWeekValue = new Select( doConditioningExercisesWorkHoursWeekOpen);
		doConditioningExercisesWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement  playBasketball  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[79]"));
		if (! playBasketball.isSelected()){
			System.out.println(" playBasketball Yes option is selected");  
			js.executeScript("arguments[0].click();",  playBasketball);
		}
		else {
			System.out.println(" playBasketball Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  playBasketballTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[40]"));
		playBasketballTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		playBasketballTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  playBasketballWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[40]"));
		Select  playBasketballWorkHoursWeekValue = new Select( playBasketballWorkHoursWeekOpen);
		playBasketballWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement  otherTypesPhysicalActivity  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[81]"));
		if (! otherTypesPhysicalActivity.isSelected()){
			System.out.println(" otherTypesPhysicalActivity Yes option is selected");  
			js.executeScript("arguments[0].click();",  otherTypesPhysicalActivity);
		}
		else {
			System.out.println(" otherTypesPhysicalActivity Yes option is not selected");
		}
		Thread.sleep(3000);

		WebElement  otherTypesPhysicalActivityTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[41]"));
		otherTypesPhysicalActivityTimesWeek.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		otherTypesPhysicalActivityTimesWeek.sendKeys(tcData.get("Label3"));
		Thread.sleep(1500);	

		WebElement  otherTypesPhysicalActivityWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[41]"));
		Select  otherTypesPhysicalActivityWorkHoursWeekValue = new Select( otherTypesPhysicalActivityWorkHoursWeekOpen);
		otherTypesPhysicalActivityWorkHoursWeekValue.selectByValue("6");
		Thread.sleep(3000);

		WebElement update = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		update.click();
		Thread.sleep(3000);	

		WebElement closeUpdatePopup = driver.findElement(By.xpath("(//button[@aria-label='Close'])[4]/span"));
		closeUpdatePopup.click();
		Thread.sleep(3000);	

	}
	
	
	
	@Test(priority=2, enabled = false)
	public void verifySaveDataCHAMPSActivities() throws Exception {

		tcData = TestUtil.readDataFromTC("ChampsActivities");		
		extent = ExtentReportManager.getReports();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		SoftAssert softAssert = new SoftAssert();


		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		email.sendKeys(tcData.get("Label1"));
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_01");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_01): Validate Email textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'jastisatyanarayana256@gmail.com' in email field in Signin page.",ExtentColor.GREEN));  

		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
		password.sendKeys(tcData.get("Label2"));
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_02");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_02): Validate Password textbox in Signin page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'Teamwork@1' in password field in Signin page.",ExtentColor.GREEN));  

		WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_03): Validate 'Sign in' button in 'Sign in' page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign in' button in 'Sign in' page.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement champsActivities = driver.findElement(By.xpath("//div[@id='champs']/div/h4"));
		champsActivities.click();
		Thread.sleep(3000);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_04): Validate 'CHAMPS Activities Questionnaire for Older Adults' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'CHAMPS Activities Questionnaire for Older Adults' module.",ExtentColor.GREEN));  

		Thread.sleep(5000);	

		WebElement visitWithFriends = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[1]"));
		softAssert.assertEquals(visitWithFriends.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement visitWithFriendsTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[1]"));
		softAssert.assertEquals(visitWithFriendsTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement visitWithFriendsHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[1]"));
		softAssert.assertEquals(visitWithFriendsHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(3000);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_05): Validate 'visitWithFriends' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'visitWithFriends', '5 times a week/9 or more hours a week' which is same as input value given for 'visitWithFriends' field from xls.",ExtentColor.GREEN));  

		
		WebElement goToTheSeniorCenter = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[3]"));
		softAssert.assertEquals(goToTheSeniorCenter.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement goToTheSeniorCenterTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[2]"));
		softAssert.assertEquals(goToTheSeniorCenterTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement goToTheSeniorCenterHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[2]"));
		softAssert.assertEquals(goToTheSeniorCenterHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	

		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_06): Validate 'goToTheSeniorCenter' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'goToTheSeniorCenter', '5 times a week/9 or more hours a week' which is same as input value given for 'goToTheSeniorCenter' field from xls.",ExtentColor.GREEN));  

		
		WebElement doVolunteerWork = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[5]"));
		softAssert.assertEquals(goToTheSeniorCenter.isEnabled(),true);
		Thread.sleep(1500);	


		WebElement doVolunteerWorkTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[3]"));
		softAssert.assertEquals(goToTheSeniorCenterTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement doVolunteerWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[3]"));
		softAssert.assertEquals(goToTheSeniorCenterHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
	
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_07): Validate 'doVolunteerWork' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doVolunteerWork', '5 times a week/9 or more hours a week' which is same as input value given for 'doVolunteerWork' field from xls.",ExtentColor.GREEN));  

		WebElement attendChurch = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[7]"));
		softAssert.assertEquals(attendChurch.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement attendChurchTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[4]"));
		softAssert.assertEquals(attendChurchTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement attendChurchWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[4]"));
		softAssert.assertEquals(attendChurchWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_08): Validate 'attendChurch' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'attendChurch', '5 times a week/9 or more hours a week' which is same as input value given for 'attendChurch' field from xls.",ExtentColor.GREEN));  

		WebElement attendClub = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[9]"));
		softAssert.assertEquals(attendClub.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement attendClubTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[5]"));
		softAssert.assertEquals(attendClubTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement attendClubTimesWeekWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[5]"));
		softAssert.assertEquals(attendClubTimesWeekWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_09): Validate 'attendClub' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'attendClub', '5 times a week/9 or more hours a week' which is same as input value given for 'attendClub' field from xls.",ExtentColor.GREEN));  

		WebElement useComputer = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[11]"));
		softAssert.assertEquals(useComputer.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement UseComputerTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[6]"));
		softAssert.assertEquals(UseComputerTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement useComputerWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[6]"));
		softAssert.assertEquals(useComputerWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_10): Validate 'useComputer' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'useComputer', '5 times a week/9 or more hours a week' which is same as input value given for 'useComputer' field from xls.",ExtentColor.GREEN));  

		WebElement dance = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[13]"));
		softAssert.assertEquals(dance.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement danceTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[7]"));
		softAssert.assertEquals(danceTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement danceWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[7]"));
		softAssert.assertEquals(danceWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_11");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_11): Validate 'dance' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'dance', '5 times a week/9 or more hours a week' which is same as input value given for 'dance' field from xls.",ExtentColor.GREEN));  

		WebElement doWoodWorking = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[15]"));
		softAssert.assertEquals(doWoodWorking.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement doWoodWorkingTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[8]"));
		softAssert.assertEquals(doWoodWorkingTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement doWoodWorkingWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[8]"));
		softAssert.assertEquals(doWoodWorkingWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_12");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_12): Validate 'doWoodWorking' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doWoodWorking', '5 times a week/9 or more hours a week' which is same as input value given for 'doWoodWorking' field from xls.",ExtentColor.GREEN));  

		WebElement playGolf = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[17]"));
		softAssert.assertEquals(playGolf.isEnabled(),true);
		Thread.sleep(1500);	
		
		WebElement playGolfTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[9]"));
		softAssert.assertEquals(playGolfTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement playGolfWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[9]"));
		softAssert.assertEquals(playGolfWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_13");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_13): Validate 'playGolf' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'playGolf', '5 times a week/9 or more hours a week' which is same as input value given for 'playGolf' field from xls.",ExtentColor.GREEN));  

		WebElement playGolfRidingACart = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[19]"));
		softAssert.assertEquals(playGolfRidingACart.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement playGolfRidingACartTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[10]"));
		softAssert.assertEquals(playGolfRidingACartTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement playGolfRidingACartWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[10]"));
		softAssert.assertEquals(playGolfRidingACartWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_14");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_14): Validate 'playGolfRidingACart' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'playGolfRidingACart', '5 times a week/9 or more hours a week' which is same as input value given for 'playGolfRidingACart' field from xls.",ExtentColor.GREEN));  

		
		WebElement attendMovie = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[21]"));
		softAssert.assertEquals(attendMovie.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement attendMovieTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[11]"));
		softAssert.assertEquals(attendMovieTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement attendMovieWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[11]"));
		softAssert.assertEquals(attendMovieWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_15");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_15): Validate 'attendMovie' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'attendMovie', '5 times a week/9 or more hours a week' which is same as input value given for 'attendMovie' field from xls.",ExtentColor.GREEN));  

		WebElement playCards = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[23]"));
		softAssert.assertEquals(playCards.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement playCardsTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[12]"));
		softAssert.assertEquals(playCardsTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement playCardsWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[12]"));
		softAssert.assertEquals(playCardsWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_16");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_16): Validate 'playCards' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'playCards', '5 times a week/9 or more hours a week' which is same as input value given for 'playCards' field from xls.",ExtentColor.GREEN));  

		WebElement shootPool = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[25]"));
		softAssert.assertEquals(shootPool.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement shootPoolTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[13]"));
		softAssert.assertEquals(shootPoolTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement shootPoolWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[13]"));
		softAssert.assertEquals(shootPoolWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_17");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_17): Validate 'shootPool' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'shootPool', '5 times a week/9 or more hours a week' which is same as input value given for 'shootPool' field from xls.",ExtentColor.GREEN));  

		WebElement playSinglesTennis  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[27]"));
		softAssert.assertEquals(playSinglesTennis.isEnabled(),true);
		Thread.sleep(1500);	

		WebElement playSinglesTennisTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[14]"));
		softAssert.assertEquals(playSinglesTennisTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement playSinglesTennisWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[14]"));
		softAssert.assertEquals(playSinglesTennisWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);	
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_18");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_18): Validate 'playSinglesTennis' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'playSinglesTennis', '5 times a week/9 or more hours a week' which is same as input value given for 'playSinglesTennis' field from xls.",ExtentColor.GREEN));  

		WebElement playdoublesTennis  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[29]"));
		softAssert.assertEquals(playdoublesTennis.isEnabled(),true);
		Thread.sleep(1500);

		WebElement playdoublesTennisTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[15]"));
		softAssert.assertEquals(playdoublesTennisTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement playdoublesTennisWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[15]"));
		softAssert.assertEquals(playdoublesTennisWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_19");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_19): Validate 'playdoublesTennis' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'playdoublesTennis', '5 times a week/9 or more hours a week' which is same as input value given for 'playdoublesTennis' field from xls.",ExtentColor.GREEN));  

		
		WebElement skate  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[31]"));
		softAssert.assertEquals(skate.isEnabled(),true);
		Thread.sleep(1500);

		WebElement skateTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[16]"));
		softAssert.assertEquals(skateTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement skateWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[16]"));
		softAssert.assertEquals(skateWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_20");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_20): Validate 'skate' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'skate', '5 times a week/9 or more hours a week' which is same as input value given for 'skate' field from xls.",ExtentColor.GREEN));  

		
		WebElement playMusicalInstrument  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[33]"));
		softAssert.assertEquals(playMusicalInstrument.isEnabled(),true);
		Thread.sleep(1500);

		WebElement playMusicalInstrumentTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[17]"));
		softAssert.assertEquals(playMusicalInstrumentTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement playMusicalInstrumentWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[17]"));
		softAssert.assertEquals(playMusicalInstrumentWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_21");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_21): Validate 'playMusicalInstrument' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'playMusicalInstrument', '5 times a week/9 or more hours a week' which is same as input value given for 'playMusicalInstrument' field from xls.",ExtentColor.GREEN));  

		WebElement read  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[35]"));
		softAssert.assertEquals(read.isEnabled(),true);
		Thread.sleep(1500);
		
		WebElement readTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[18]"));
		softAssert.assertEquals(readTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement readWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[18]"));
		softAssert.assertEquals(readWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_22");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_22): Validate 'read' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'read', '5 times a week/9 or more hours a week' which is same as input value given for 'read' field from xls.",ExtentColor.GREEN));  

		WebElement doHeavyWork  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[37]"));
		softAssert.assertEquals(doHeavyWork.isEnabled(),true);
		Thread.sleep(1500);

		WebElement doHeavyWorkTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[19]"));
		softAssert.assertEquals(doHeavyWorkTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement doHeavyWorkWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[19]"));
		softAssert.assertEquals(doHeavyWorkWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);

		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_23");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_23): Validate 'doHeavyWork' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doHeavyWork', '5 times a week/9 or more hours a week' which is same as input value given for 'doHeavyWork' field from xls.",ExtentColor.GREEN));  

		WebElement doLightWork  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[39]"));
		softAssert.assertEquals(doLightWork.isEnabled(),true);
		Thread.sleep(1500);

		WebElement doLightWorkTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[20]"));
		softAssert.assertEquals(doLightWorkTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement doLightWorkWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[20]"));
		softAssert.assertEquals(doLightWorkWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);

		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_24");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_24): Validate 'doLightWork' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doLightWork', '5 times a week/9 or more hours a week' which is same as input value given for 'doLightWork' field from xls.",ExtentColor.GREEN));  

		WebElement doHeavyGardening  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[41]"));
		softAssert.assertEquals(doHeavyGardening.isEnabled(),true);
		Thread.sleep(1500);

		WebElement doHeavyGardeningTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[21]"));
		softAssert.assertEquals(doHeavyGardeningTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement doHeavyGardeningWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[21]"));
		softAssert.assertEquals(doHeavyGardeningWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_25");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_25): Validate 'doHeavyGardening' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doHeavyGardening', '5 times a week/9 or more hours a week' which is same as input value given for 'doHeavyGardening' field from xls.",ExtentColor.GREEN));  

		WebElement doLightGardening  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[43]"));
		softAssert.assertEquals(doLightGardening.isEnabled(),true);
		Thread.sleep(1500);

		WebElement doLightGardeningTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[22]"));
		softAssert.assertEquals(doLightGardeningTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement doLightGardeningWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[22]"));
		softAssert.assertEquals(doLightGardeningWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_26");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_26): Validate 'doLightGardening' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doLightGardening', '5 times a week/9 or more hours a week' which is same as input value given for 'doLightGardening' field from xls.",ExtentColor.GREEN));  

		
		WebElement workOnYourCar  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[45]"));
		softAssert.assertEquals(workOnYourCar.isEnabled(),true);
		Thread.sleep(1500);

		WebElement workOnYourCarTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[23]"));
		softAssert.assertEquals(workOnYourCarTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement workOnYourCarWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[23]"));
		softAssert.assertEquals(workOnYourCarWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_27");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_27): Validate 'workOnYourCar' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'workOnYourCar', '5 times a week/9 or more hours a week' which is same as input value given for 'workOnYourCar' field from xls.",ExtentColor.GREEN));  

		WebElement jogOrRun  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[47]"));
		softAssert.assertEquals(jogOrRun.isEnabled(),true);
		Thread.sleep(1500);

		WebElement jogOrRunTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[24]"));
		softAssert.assertEquals(jogOrRunTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement jogOrRunWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[24]"));
		softAssert.assertEquals(jogOrRunWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_28");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_28): Validate 'jogOrRun' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'jogOrRun', '5 times a week/9 or more hours a week' which is same as input value given for 'jogOrRun' field from xls.",ExtentColor.GREEN));  


		WebElement walkUphill  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[49]"));
		softAssert.assertEquals(walkUphill.isEnabled(),true);
		Thread.sleep(1500);

		WebElement walkUphillTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[25]"));
		softAssert.assertEquals(walkUphillTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement walkUphillWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[25]"));
		softAssert.assertEquals(walkUphillWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_29");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_29): Validate 'walkUphill' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'walkUphill', '5 times a week/9 or more hours a week' which is same as input value given for 'walkUphill' field from xls.",ExtentColor.GREEN));  


		WebElement walkFast  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[51]"));
		softAssert.assertEquals(walkFast.isEnabled(),true);
		Thread.sleep(1500);

		WebElement walkFastTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[26]"));
		softAssert.assertEquals(walkFastTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement walkFastWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[26]"));
		softAssert.assertEquals(walkFastWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_30");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_30): Validate 'walkFast' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'walkFast', '5 times a week/9 or more hours a week' which is same as input value given for 'walkFast' field from xls.",ExtentColor.GREEN));  


		WebElement walkToDoErrands  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[53]"));
		softAssert.assertEquals(walkToDoErrands.isEnabled(),true);
		Thread.sleep(1500);

		WebElement walkToDoErrandsTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[27]"));
		softAssert.assertEquals(walkToDoErrandsTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement walkToDoErrandsWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[27]"));
		softAssert.assertEquals(walkToDoErrandsWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_31");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_31): Validate 'walkToDoErrands' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'walkToDoErrands', '5 times a week/9 or more hours a week' which is same as input value given for 'walkToDoErrands' field from xls.",ExtentColor.GREEN));  

		
		WebElement walkLeisurely  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[55]"));
		softAssert.assertEquals(walkLeisurely.isEnabled(),true);
		Thread.sleep(1500);

		WebElement walkLeisurelyTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[28]"));
		softAssert.assertEquals(walkLeisurelyTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement walkLeisurelyWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[28]"));
		softAssert.assertEquals(walkLeisurelyWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_32");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_32): Validate 'walkLeisurely' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'walkLeisurely', '5 times a week/9 or more hours a week' which is same as input value given for 'walkLeisurely' field from xls.",ExtentColor.GREEN));  


		WebElement rideABicycle  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[57]"));
		softAssert.assertEquals(rideABicycle.isEnabled(),true);
		Thread.sleep(1500);

		WebElement rideABicycleTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[29]"));
		softAssert.assertEquals(rideABicycleTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement rideABicycleWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[29]"));
		softAssert.assertEquals(rideABicycleWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_33");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_33): Validate 'rideABicycle' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'rideABicycle', '5 times a week/9 or more hours a week' which is same as input value given for 'rideABicycle' field from xls.",ExtentColor.GREEN));  


		WebElement doOtherAerobicMachines  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[59]"));
		softAssert.assertEquals(doOtherAerobicMachines.isEnabled(),true);
		Thread.sleep(1500);

		WebElement doOtherAerobicMachinesTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[30]"));
		softAssert.assertEquals(doOtherAerobicMachinesTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement doOtherAerobicMachinesWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[30]"));
		softAssert.assertEquals(doOtherAerobicMachinesWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_34");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_34): Validate 'doOtherAerobicMachines' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doOtherAerobicMachines', '5 times a week/9 or more hours a week' which is same as input value given for 'doOtherAerobicMachines' field from xls.",ExtentColor.GREEN));  


		WebElement doWaterExercises  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[61]"));
		softAssert.assertEquals(doWaterExercises.isEnabled(),true);
		Thread.sleep(1500);

		WebElement doWaterExercisesTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[31]"));
		softAssert.assertEquals(doWaterExercisesTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement doWaterExercisesWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[31]"));
		softAssert.assertEquals(doWaterExercisesWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_35");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_35): Validate 'doWaterExercises' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doWaterExercises', '5 times a week/9 or more hours a week' which is same as input value given for 'doWaterExercises' field from xls.",ExtentColor.GREEN));  



		WebElement  swimModerately  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[63]"));
		softAssert.assertEquals(swimModerately.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  swimModeratelyTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[32]"));
		softAssert.assertEquals(swimModeratelyTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		
		WebElement  swimModeratelyWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[32]"));
		softAssert.assertEquals(swimModeratelyWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_36");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_36): Validate 'swimModerately' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'swimModerately', '5 times a week/9 or more hours a week' which is same as input value given for 'swimModerately' field from xls.",ExtentColor.GREEN));  

		
		
		WebElement  swimGently  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[65]"));
		softAssert.assertEquals(swimGently.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  swimGentlyTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[33]"));
		softAssert.assertEquals(swimGentlyTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement  swimGentlyWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[33]"));
		softAssert.assertEquals(swimGentlyWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_37");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_37): Validate 'swimGently' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'swimGently', '5 times a week/9 or more hours a week' which is same as input value given for 'swimGently' field from xls.",ExtentColor.GREEN));  


		WebElement  doStretching  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[67]"));
		softAssert.assertEquals(doStretching.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  doStretchingTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[34]"));
		softAssert.assertEquals(doStretchingTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement  doStretchingWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[34]"));
		softAssert.assertEquals(doStretchingWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_38");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_38): Validate 'doStretching' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doStretching', '5 times a week/9 or more hours a week' which is same as input value given for 'doStretching' field from xls.",ExtentColor.GREEN));  


		WebElement  doYoga  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[69]"));
		softAssert.assertEquals(doYoga.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  doYogaTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[35]"));
		softAssert.assertEquals(doYogaTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement  doYogaWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[35]"));
		softAssert.assertEquals(doYogaWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_39");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_39): Validate 'doYoga' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doYoga', '5 times a week/9 or more hours a week' which is same as input value given for 'doYoga' field from xls.",ExtentColor.GREEN));  

		
		WebElement  doAerobics  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[71]"));
		softAssert.assertEquals(doAerobics.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  doAerobicsTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[36]"));
		softAssert.assertEquals(doAerobicsTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement  doAerobicsWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[36]"));
		softAssert.assertEquals(doAerobicsWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_40");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_40): Validate 'doAerobics' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doAerobics', '5 times a week/9 or more hours a week' which is same as input value given for 'doAerobics' field from xls.",ExtentColor.GREEN));  

		
		WebElement  doModerateTraining  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[73]"));
		softAssert.assertEquals(doAerobics.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  doModerateTrainingTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[37]"));
		softAssert.assertEquals(doAerobicsTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement  doModerateTrainingWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[37]"));
		softAssert.assertEquals(doAerobicsWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_40");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_40): Validate 'doAerobics' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doAerobics', '5 times a week/9 or more hours a week' which is same as input value given for 'doAerobics' field from xls.",ExtentColor.GREEN));  


		WebElement  doLightTraining  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[75]"));
		softAssert.assertEquals(doLightTraining.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  doLightTrainingTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[38]"));
		softAssert.assertEquals(doLightTrainingTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement  doLightTrainingWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[38]"));
		softAssert.assertEquals(doLightTrainingWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_41");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_41): Validate 'doLightTraining' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doLightTraining', '5 times a week/9 or more hours a week' "
				+ "which is same as input value given for 'doLightTraining' field from xls.",ExtentColor.GREEN));  


		WebElement  doConditioningExercises  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[77]"));
		softAssert.assertEquals(doConditioningExercises.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  doConditioningExercisesTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[39]"));
		softAssert.assertEquals(doConditioningExercisesTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement  doConditioningExercisesWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[39]"));
		softAssert.assertEquals(doConditioningExercisesWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_42");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_42): Validate 'doConditioningExercises' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'doConditioningExercises', '5 times a week/9 or more hours a week' "
				+ "which is same as input value given for 'doConditioningExercises' field from xls.",ExtentColor.GREEN));  


		WebElement  playBasketball  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[79]"));
		softAssert.assertEquals(playBasketball.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  playBasketballTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[40]"));
		softAssert.assertEquals(playBasketballTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	

		WebElement  playBasketballWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[40]"));
		softAssert.assertEquals(playBasketballWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_43");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_43): Validate 'playBasketball' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'playBasketball', '5 times a week/9 or more hours a week' "
				+ "which is same as input value given for 'playBasketball' field from xls.",ExtentColor.GREEN));  

		WebElement  otherTypesPhysicalActivity  = driver.findElement(By.xpath("(//input[@formcontrolname='yes_no_id'])[81]"));
		softAssert.assertEquals(otherTypesPhysicalActivity.isEnabled(),true);
		Thread.sleep(1500);

		WebElement  otherTypesPhysicalActivityTimesWeek = driver.findElement(By.xpath("(//input[@formcontrolname='week_textbox'])[41]"));
		softAssert.assertEquals(otherTypesPhysicalActivityTimesWeek.getAttribute("value"),"5");
		Thread.sleep(1500);	
		
		WebElement  otherTypesPhysicalActivityWorkHoursWeekOpen= driver.findElement(By.xpath("(//select[@formcontrolname='duration_id'])[41]"));
		softAssert.assertEquals(otherTypesPhysicalActivityWorkHoursWeekOpen.getAttribute("value"),"6");
		Thread.sleep(1500);
		
		logger = extent.createTest("VerifySaveDataCHAMPSActivities_TC_44");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(VerifySaveDataCHAMPSActivities_TC_44): Validate 'otherTypesPhysicalActivity' field in 'CHAMPS Activities ...' module.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("'Yes' option is selected for 'otherTypesPhysicalActivity', '5 times a week/9 or "
				+ "more hours a week' which is same as input value given for 'otherTypesPhysicalActivity' field from xls.",ExtentColor.GREEN));  
		
		softAssert.assertAll();
		
	}



	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}


}
