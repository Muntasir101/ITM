package com.itm.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.itm.PageObjects.LoginPage;
import com.itm.PageObjects.NewContactPage;

public class TC_NewContactPage_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver); 
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);

		NewContactPage ncp = new NewContactPage(driver);
		ncp.clickAddNewCustomer();
		Thread.sleep(1000);
		ncp.custName();
		Thread.sleep(1000);
		ncp.BProfile();
		Thread.sleep(1000);
		ncp.Membership();
		Thread.sleep(1000);
		ncp.Title();
		Thread.sleep(1000);
		ncp.custSubmit();
		Thread.sleep(3000);
	}
}
	

