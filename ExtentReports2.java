package com.alexiageriatrics.functionality;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ExtentReports2 {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		com.aventstack.extentreports.ExtentReports extentReports = new com.aventstack.extentreports.ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		
		ExtentSparkReporterConfig config = sparkReporter.config();
		//config.setTheme(Theme.DARK);
		config.setTheme(Theme.STANDARD);
		config.setReportName("Alexia Geriatrics");
		config.setDocumentTitle("Alexia");
		config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		config.setCss(".badge-primary{background-color:#dao0b2b");
		config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
		extentReports.attachReporter(sparkReporter);
		
		extentReports
		.createTest("Test1","Test desc")
		.assignAuthor("Jasti")
		.assignCategory("Smoke")
		.assignDevice("Edge")
		.pass("This is a passed test");
		
		extentReports
		.createTest("Test2","Test desc")
		.assignAuthor("Sreedhar")
		.assignCategory("Sanity")
		.assignDevice("Chrome")
		.fail("This is a failed test");
		
		extentReports
		.createTest("Test3","Test desc")
		.assignDevice("Chrome")
		.assignCategory("Sanity")
		.assignAuthor("Sreedhar")
		.fail("This is a failed test");
		
		extentReports
		.createTest("Test4","Test desc")
		.assignAuthor("Sreedhar")
		.assignAuthor("Jasti")
		.assignCategory("Sanity")
		.assignCategory("Regression")
		.assignDevice("Chrome 99")
		.assignDevice("Chrome 97")
		.pass("This is a passed test");
		
		extentReports
		.createTest("Test5","Test desc")
		.assignAuthor("Sreedhar","Jasti","Rama")
		.assignCategory("Sanity","Regression","Smoke")
		.assignDevice("Chrome 99","Edge","Firefox")
		.pass("This is a passed test");
		
		
		extentReports
		.createTest("Test6","Test desc")
		.assignAuthor(new String[] {"Sreedhar","Jasti","Rama"})
		.assignCategory(new String[] {"Sanity","Regression","Smoke"})
		.assignDevice(new String[] {"Chrome 99","Edge","Firefox"})
		.pass("This is a passed test");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
