
/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/12/2018

* Purpose: Search the organisations and download it and verify it.

*/package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.sunbird.generic.GenericFunctions;
import org.sunbird.page.CreatorUserPage;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchAndDownloadOrgFile extends BaseTest {
	
	CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
	String courseName;
	String startDate;
	String endDate;
	String fileName = "Organisations";
	
	
	@Test
	public void searchAndDownloadOrgFile() throws Exception
	{
		
		//Step1: Login as Creator
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		creatorLogin.userLogin(ADMIN);

		
		//Step2: Navigate to profile and search the org and download
		
		CreatorUserPageObj cretorUserPageObj =new CreatorUserPageObj();
		cretorUserPageObj.navigateToProfileAndSearchOrg();
		GenericFunctions.waitWebDriver(1000);
		System.out.println("Download is done");
		
		
		//Step3: check the download
		
		String downloadPath = "/home/" + System.getProperty("user.name") + "/Downloads/";
		GenericFunctions generics = new GenericFunctions();
		generics.isFileDownloaded_Ext(downloadPath, fileName);
		System.out.println("downloaded file exist");
		
		//Step4: Logout as mentor
		
		GenericFunctions.waitWebDriver(1000);
		creatorLogin.userLogout();
		
		
	}
}
