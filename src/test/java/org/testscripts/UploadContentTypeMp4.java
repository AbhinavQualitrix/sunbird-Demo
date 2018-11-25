package org.testscripts;

import org.testng.annotations.Test;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadContentTypeMp4 extends BaseTest{
	
		@Test
		public void uploadContentMP4() throws Exception
		{
			SignUpPageObj signupObj = new SignUpPageObj();
			CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
			
			//Step1:Login as content creator
			
			signupObj.userLogin(CREATOR);
			
			//Step2:Navigate to workspace and upload content-MP4
			
			creatorUserPageObj.uploadContentMp4(MP4);
			
			//Step3:Logout as creator
			
			signupObj.userLogout();
			
			//Step4:Login as Reviewer
			
			signupObj.userLogin(REVIEWER);
			
			//Step5:Go to workspace and publish content Mp4
			
			creatorUserPageObj.goToWorkspace("content");
			
			//Step6:Logout as reviewer
			
			signupObj.userLogout();
			
			//Step7:Login as Public user
			
			signupObj.userLogin(PUBLICUSER1);	
					
			//Step8:Go to workspace and publish content Mp4
					
			creatorUserPageObj.navigateToLibraryAndSearchContent("content");
			
			//Step9:Logout as Public user
			
			signupObj.userLogout();
			
		}
	}


