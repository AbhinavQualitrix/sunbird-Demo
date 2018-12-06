package org.testscript;

import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UpForReviewPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_206 extends BaseTest {
 @Test
  		public void TC_206_upForReview() throws Exception{
	  		  
	 		  // Step 1 : Login as reviewer
			  SignUpPageObj reviewerLogin = new SignUpPageObj();			  			 
			  reviewerLogin.userLogin(REVIEWER);
			  
			  GenericFunctions.waitWebDriver(2000);
			  
			  // Step 2 : Go to workspace and click on upForReview
			  UpForReviewPageObj UpForReviewPageObj = new UpForReviewPageObj();
			  UpForReviewPageObj.reviewerUpForReview();
	  	  
    }
}
