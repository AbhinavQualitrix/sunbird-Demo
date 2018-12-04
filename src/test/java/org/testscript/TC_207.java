package org.testscript;

import org.pageobjects.FlagReviewerPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UpForReviewPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_207 extends BaseTest{
  @Test
  public void TC_207_upForReview() throws Exception{
	  
	  // Step 1 : Login as reviewer
	  SignUpPageObj reviewerLogin = new SignUpPageObj();
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Step 2 : Go to Workspace < click on upForReview < Search content
	  UpForReviewPageObj UpForReviewPageObj = new UpForReviewPageObj();
	  UpForReviewPageObj.UpForReviewsearchContent();

  }
}
