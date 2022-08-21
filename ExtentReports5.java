package com.alexiageriatrics.extentreports;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ExtentReports5 {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		com.aventstack.extentreports.ExtentReports extentReports = new com.aventstack.extentreports.ExtentReports();
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		
		ExtentSparkReporter sparkReporter_fail = new ExtentSparkReporter("FailedTests.html");
		sparkReporter_fail.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		ExtentSparkReporter sparkReporter_skipandwarning = new ExtentSparkReporter("SkippedWarningTests.html");
		sparkReporter_skipandwarning.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
				}).apply();

		extentReports.attachReporter(sparkReporter_all,sparkReporter_fail,sparkReporter_skipandwarning);
		
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
		
		
		extentReports
		.createTest("Test7","Test desc")
		.assignAuthor(new String[] {"Sreedhar","Jasti","Rama"})
		.assignCategory(new String[] {"Sanity","Regression","Smoke"})
		.assignDevice(new String[] {"Chrome 99","Edge","Firefox"})
		.skip("This is a skiped test");
		
		extentReports
		.createTest("Test8","Test desc")
		.assignAuthor(new String[] {"Sreedhar","Jasti","Rama"})
		.assignCategory(new String[] {"Sanity","Regression","Smoke"})
		.assignDevice(new String[] {"Chrome 99","Edge","Firefox"})
		.warning("This is a warning test");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("SkippedWarningTests.html").toURI());

	}

}
