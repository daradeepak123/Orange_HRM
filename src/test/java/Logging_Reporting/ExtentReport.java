package Logging_Reporting;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	private ExtentReports extent;
	private ExtentSparkReporter spark;
	
	public ExtentReport(String reportName) {
		String dt = LocalDateTime.now().toString().substring(0, 19).replace(':', '-');
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(".//ExtentReports//" + reportName + "-" + dt + ".html");
		extent.attachReporter(spark);
	}
	
	public ExtentTest createTest(String testName) {
		ExtentTest report = extent.createTest(testName);
		return report;
	}
	
	public ExtentTest createTest(String testName, String testDescription) {
		ExtentTest report = extent.createTest(testName, testDescription);
		return report;
	}
	
	public void testPass(ExtentTest report, String details) {
		report.pass(details);
	}
	
	public void testPassScreenshot(WebDriver eDriver, ExtentTest report, String imgName, String details) throws Exception {
		String dt = LocalDateTime.now().toString().replace('.', ':').replace(':', '-');
		TakesScreenshot ts = (TakesScreenshot) eDriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(".//Screenshots//" + dt + "-" + imgName + ".png");
		FileUtils.copyFile(source, destination);
		
//		report.pass(details, MediaEntityBuilder.createScreenCaptureFromPath(".//Screenshots//" + imgName + "-" + dt + ".png").build());
		FileInputStream fi = new FileInputStream(destination);
		byte[] bytes = new byte[(int)destination.length()];
		fi.read(bytes);
		String screenshot = new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
		report.pass(details, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
	}
	
	public String testfail(ExtentTest report, String details) {
		report.fail(details);
		return details;
	}
	
	public String testfailScreenshot(WebDriver eDriver, ExtentTest report, String imgName, String details) throws Exception {
		String dt = LocalDateTime.now().toString().replace('.', ':').replace(':', '-');
		TakesScreenshot ts = (TakesScreenshot) eDriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(".//Screenshots//" + dt + "-" + imgName + ".png");
		FileUtils.copyFile(source, destination);
		
		FileInputStream fi = new FileInputStream(destination);
		byte[] bytes = new byte[(int)destination.length()];
		fi.read(bytes);
		String screenshot = new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
		report.fail(details, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		
		return details;
	}
	
	public void testInfo(ExtentTest report, String details) {
		report.info(details);
	}
	
	public void testSkip(ExtentTest report, String details) {
		report.skip(details);
	}
	
	public void testWarning(ExtentTest report, String details) {
		report.warning(details);
	}
	
	public void flush() {
		extent.flush();
	}
	
	public void logResults(boolean result, WebDriver eDriver, ExtentTest report, String failImgName, String passMessage, String failMessage) throws Exception {
		if(result) {
			testPass(report, passMessage);
		}else {
			testfailScreenshot(eDriver, report, failImgName, failMessage);
		}
		assertTrue(result, failMessage + "\t");
		System.out.println(passMessage);
	}
	
}
