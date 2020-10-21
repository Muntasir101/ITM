package com.itm.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"roundPanelLogin_itmLoginControl_txtUsername_I\"]")
	@CacheLookup
	WebElement txtusername;

//	@FindBy(how = How.CSS, using = "input#roundPanelLogin_itmLoginControl_txtPassword_I")
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(how = How.XPATH, using = "//*[@id=\"roundPanelLogin_itmLoginControl_btnLogin_CD\"]/span")
	@CacheLookup
	WebElement btnlogin;

//	@FindBy(how = How.XPATH, using = "//*[@id=\"roundPanelLogin_itmLoginControl_chkRememberMe_S_D\"]")
//	@CacheLookup
//	WebElement chkbox;
//
//	@FindBy(how = How.LINK_TEXT, using = "Can't access your account?")
//	@CacheLookup
//	WebElement lnktext;

	@FindBy(how = How.XPATH, using = "//*[@id=\"LayoutSplitter_HomeLinksMenu_DXI6i1_T\"]/span")
	@CacheLookup
	WebElement btnlogout;
	
	public void setUserName(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		btnlogin.click();
	}

//	public void clickchkbox() {
//		chkbox.click();
//	}
//
//	public void clicklnktxt() {
//		lnktext.click();
//	}

	public void clickLogout() {
		btnlogout.click();
	}

}
