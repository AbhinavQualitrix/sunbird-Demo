package org.testscript;

import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_281 extends BaseTest {
CreatorUserPage createUserPage= PageFactory.initElements(driver, CreatorUserPage.class);
  @Test
  public void TC_281_allMyContent() throws Exception {
	  
	  SignUpPageObj creator = new SignUpPageObj();
	  creator.userLogin(CREATOR);
	  
		// Click on workspace
	  AllMyContentPageObj AllMyContentPageObj = new AllMyContentPageObj();
	  AllMyContentPageObj.clickWorkspace();
			
		// Click on allMyContent and select sortBy dropdown options
	  AllMyContentPageObj.allMyContentSortByDropdown();
  
  }
}
