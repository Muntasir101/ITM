package com.itm.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.itm.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseUrl = readconfig.getApplicationUrl();
	public String username = readconfig.getusername();
	public String password = readconfig.getpassword();
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions opt = new FirefoxOptions();
			opt.setAcceptInsecureCerts(false);
			driver = new FirefoxDriver();
		} else if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(false);
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + name + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}
}
