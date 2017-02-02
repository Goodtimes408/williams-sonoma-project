package com.sqa.bm;

import java.io.*;
import java.util.concurrent.*;

import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class CraigslistTest {

	static int testNum = 0;

	static WebDriver driver;

	static String baseUrl = "http://sfbay.craigslist.org";

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "quality assurance" },
				new Object[] { "java qa" }, new Object[] { "qa engineer" },
				new Object[] { "java junior" }, new Object[] { "test java" },
				new Object[] { "java tester" }, };
	}

	public boolean isElementPresent(By by) {
		try {
			WebElement element = driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@BeforeMethod
	public void setup() {
		baseUrl = "http://sfbay.craigslist.org";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}

	public void takeScreenshot(String name) {
		// Takes the screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Move to Folder structure
		try {
			FileUtils.copyFile(srcFile, new File("Screenshots/" + name + ".png"));
		} catch (IOException e) {
			System.out.println("Screenshot was not saved correctly:" + ".png");
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "dp")
	public void testCraigslist(String keywords) {
		this.testNum++;
		System.out.println("Craigslist Test" + this.testNum + ": \"" + keywords + "\"");
		// got to baseURL
		driver.get(baseUrl + "/");
		// driving the test...Collect item for jobs link text could use
		// WebElement jobsLink=
		driver.findElement(By.cssSelector("a.jjj > span.txt")).click();
		// click on the jobs link text could use "jobsLink.click();
		// clear the field that shows items to search in search bar.
		driver.findElement(By.id("query")).clear();
		// Type the keys into search field
		driver.findElement(By.id("query")).sendKeys(keywords);
		// Click on the submit button to search for results
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		if (isElementPresent(By.className("pagenum totalcount"))) {
			String output = driver.findElement(By.className("pagenum pagenum")).getText();
			System.out.println("Number of results (" + keywords + "):" + output);
		} else {
			// Locate WebElement for the text for total and set to STring
			// variable
			// button pagenum
			String resultsCount =
					driver.findElement(By.className("totalcount")).getText().trim();
			// Log the number of results to console
			System.out.println("Number of results (" + keywords + "):" + resultsCount);
			// Click on the first link to go to the page.
			driver.findElement(By.cssSelector("a.result-title.hdrlnk")).click();
			// take a screenshot of the current page
			// takeScreenshot(keywords);
			// Take a screenshot of the current page
			takeScreenshot(testNum + "-" + keywords);
		}
	}
}
