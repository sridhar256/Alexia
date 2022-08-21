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

import io.github.bonigarcia.wdm.WebDriverManager;



public class ExtentReports {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		com.aventstack.extentreports.ExtentReports extentReports = new com.aventstack.extentreports.ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://52.188.114.225/alexia/login");
		
		String path = captureScreenShot("Alexia.jpg");
		
		extentReports
		.createTest("Text based Test")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "<b>info2</b>")
		.log(Status.INFO, "<i>info3</i>")
		.log(Status.INFO, "<i><b>info3</i></b>");
		
		// Fail,Ski, Warning,Pass,Info
		
		extentReports
		.createTest("Highlight log Test")
		.info("This is not a highlighted message")
		.info(MarkupHelper.createLabel("This is highlighted message", ExtentColor.GREEN))
		.info(MarkupHelper.createLabel("This is highlighted message", ExtentColor.RED))
		.info(MarkupHelper.createLabel("This is highlighted message", ExtentColor.PINK));
		
		try {
			int i = 5/0;
		} catch (Exception e) {
			extentReports
			.createTest("Exception Test1")
			.fail(e);
		}
		
		Throwable t = new RuntimeException("This is custom exception");
		extentReports
		.createTest("Exception Test2")
		.fail(t);
		
		extentReports
		.createTest("Screenshot Test1", "This is for attaching the screenshot to the test at test level")
		.info("This is info message")
		.addScreenCaptureFromPath(path);
		
		extentReports
		.createTest("Screenshot Test2", "This is for attaching the screenshot to the test at test level")
		.info("This is info message")
		.addScreenCaptureFromPath(path,"Alexia Home Page");
		
		extentReports
		.createTest("Screenshot Test2", "This is for attaching the screenshot to the test at test level")
		.info("This is info message")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"Alexia Home Page").build());
		
		extentReports
		.createTest("Screenshot Test2", "This is for attaching the screenshot to the test at test level")
		.info("This is info message")
		.fail("This is info message",MediaEntityBuilder.createScreenCaptureFromPath(path,"Alexia Home Page").build());
		
		Throwable t1 = new Throwable("This is throwable message");
		extentReports
		.createTest("Screenshot Test2", "This is for attaching the screenshot to the test at test level")
		.info("This is info message")
		.fail(t1,MediaEntityBuilder.createScreenCaptureFromPath(path,"Alexia Home Page").build());
		
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
	
	public static String captureScreenShot(String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}

}
