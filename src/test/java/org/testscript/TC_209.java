package org.testscript;

import org.pageobjects.FlagReviewerPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UpForReviewPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_209 extends BaseTest{
  @Test
  public void TC_209_upForReview() throws Exception{
	  	  
	  //  Login as Reviewer
	  SignUpPageObj reviewerLogin = new SignUpPageObj();
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Go to Workspace and click on upForReview
	  
	  UpForReviewPageObj UpForReviewPageObj = new UpForReviewPageObj();
	  UpForReviewPageObj.reviewerUpForReview();
	  
	  // Fill the filter options and click on apply button
	  UpForReviewPageObj.showFilters();
	  

  }
}