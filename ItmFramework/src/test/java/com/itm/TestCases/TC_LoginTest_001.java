package com.itm.TestCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.itm.PageObjects.LoginPage;

//Login email and password Data read from properties file

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		lp.setPassword(password);
		Thread.sleep(1000);
		lp.clickSubmit();
		Thread.sleep(2000);
		String expectedUrl = "http://itm.dev.itmagnet.biz/v4.2/home.aspx";
		if (driver.getCurrentUrl().equals(expectedUrl)) {
			Assert.assertTrue(true);
			System.out.println("pass");
			captureScreen(driver, "PassedLoginTest"); 
		} else {
			Assert.assertTrue(false);
			System.out.println("fail");
			captureScreen(driver, "FailedLoginTest");
		}
	}

}
