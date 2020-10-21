package com.itm.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewContactPage {

	WebDriver ldriver;

	public NewContactPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"mnuGroups_DXI4_T\"]/span")
	@CacheLookup
	WebElement lnkcrm;

	@FindBy(how = How.XPATH, using = "//*[@id=\"LayoutSplitter_navBarAppMenu_I4i3_T\"]/span")
	@CacheLookup
	WebElement lnknewcontact;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_cphSiteMaster_tabUserControl0_aspxSplitter_callbackPanel_aspxFormLayout_cboBusinessProfileLookup_I\"]")
	@CacheLookup
	WebElement businessProfile;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_cphSiteMaster_tabUserControl0_aspxSplitter_callbackPanel_aspxFormLayout_txtMembershipNumber_I\"]")
	@CacheLookup
	WebElement membership;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_cphSiteMaster_tabUserControl0_aspxSplitter_callbackPanel_aspxFormLayout_ContactGeneralInfo1_aspxFormLayoutContact_cboTitle_I\"]")
	@CacheLookup
	WebElement title;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html/body/form/div[3]/div/table/tbody/tr[1]/td/div/div[2]/div/div[1]/ul/li[1]/a/span")
	WebElement btnSubmit;

	public void clickAddNewCustomer() {
		lnkcrm.click();
	}

	public void custName() {
		lnknewcontact.click();
	}
	
	public void BProfile() {
		Select bp = new Select(businessProfile);
		bp.selectByVisibleText("Teas");
	}
	
	public void Membership() {
		Select bp = new Select(businessProfile);
		bp.selectByVisibleText("Member");
	}
	
	public void Title() {
		Select bp = new Select(businessProfile);
		bp.selectByVisibleText("Mr.");
	}
	
	public void custSubmit() {
		btnSubmit.click();
	}

}
