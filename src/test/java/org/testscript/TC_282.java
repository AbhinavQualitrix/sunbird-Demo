package org.testscript;

import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

@Test
public class TC_282 extends BaseTest {
	public void TC_282_allMyContent() throws Exception {
		
		// Login as Creator
		SignUpPageObj creator = new SignUpPageObj();
		creator.userLogin(CREATOR);
		
		// Click on workspace
		//CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
		AllMyContentPageObj AllMyContentPageObj = new AllMyContentPageObj();
		AllMyContentPageObj.clickWorkspace();
		
		// Click on AllMyContent
		AllMyContentPageObj.clickAllMyContent();
		
		// Select DRAFT, delete and search		
		AllMyContentPageObj.deleteByStatus("DRAFT");
		
		// Select FLAGDRAFT, delete and search
		AllMyContentPageObj.deleteByStatus("FLAGDRAFT");
		
		// Select REVIEW, delete and search
		AllMyContentPageObj.deleteByStatus("REVIEW");
		
		// Select PROCESSING, delete and search
		AllMyContentPageObj.deleteByStatus("PROCESSING");
		
		// Select UNLISTED, delete and search
		AllMyContentPageObj.deleteByStatus("UNLISTED");
		
		// Select FLAGREVIEW, delete and search
		AllMyContentPageObj.deleteByStatus("FLAGREVIEW");
		
		// Select FLAGREVIEW, delete and search
		AllMyContentPageObj.deleteByStatus("LIVE");
		
		
	
		
	}

}