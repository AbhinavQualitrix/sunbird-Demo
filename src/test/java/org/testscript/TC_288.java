package org.testscript;

import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

@Test
public class TC_288 extends BaseTest {
	public void TC_288_allMyContent() throws Exception {

		SignUpPageObj creator = new SignUpPageObj();
		creator.userLogin(CREATOR);
		
		// Click on workspace
		//CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
		AllMyContentPageObj AllMyContentPageObj = new AllMyContentPageObj();
		AllMyContentPageObj.clickWorkspace();
		
		// Click filter icon
		AllMyContentPageObj.allMyContent();
		
		// Delete published UPLOADED CONTENT
		AllMyContentPageObj.deleteContent("UPLOADED CONTENT");
		
		// Test case done

	}
}