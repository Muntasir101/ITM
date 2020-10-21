package com.itm.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itm.PageObjects.LoginPage;
import com.itm.Utilities.XLUtils;

//Login email and password Data dead from Excel file 

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "Dataset1")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		Thread.sleep(5000);
		String expectedUrl = "http://itm.dev.itmagnet.biz/v4.2/home.aspx";
		if (driver.getCurrentUrl().equals(expectedUrl)) {
			Assert.assertTrue(true);
			System.out.println("pass");
			captureScreen(driver, "PassedDdtLoginTest"); 
		} else {
			Assert.assertTrue(false);
			System.out.println("fail");
			captureScreen(driver, "FailedDdtLoginTest");
		}
		
		lp.clickLogout();
	}

	@DataProvider(name = "Dataset1")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\itm\\TestData\\Dataset1.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
