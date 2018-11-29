package org.testscripts.regression;

import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyPropertySection_PreviewSlidesAndFromBegining extends BaseTest
{
	@Test
	public void propertySection_And_PreviewSlides_CreatorTC119_120_121() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//Login as Content creator
		userLogin.userLogin(CREATOR);

		//Navigate to workspace to create Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Enter a unique resource name
		contentReourcePageObj.resourceName();
		
		//Add text or images
		contentReourcePageObj.addSlides_Image_Text(2,119);
		
		//Add 10 slides and preview all from the beginning
		contentReourcePageObj.previewSlides_AndFromBegining();
	
		//ContentCreationResourcePage.clickAUdio("Telugu");
		
		//Logout as Content Creator
		userLogin.userLogout();
	}
}
