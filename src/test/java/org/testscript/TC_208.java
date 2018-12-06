package org.testscript;

import org.pageobjects.SignUpPageObj;
import org.pageobjects.UpForReviewPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_208 extends BaseTest{
  @Test
  public void TC_208_upForReview() throws Exception{
	  
	  // Login as reviewer
	  SignUpPageObj reviewerLogin = new SignUpPageObj();
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Go to Workspace < click on upForReview < Search content
	  UpForReviewPageObj UpForReviewPageObj = new UpForReviewPageObj();
	  UpForReviewPageObj.UpForReviewSortBy();
	  
	    
  }
}
