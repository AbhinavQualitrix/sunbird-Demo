package org.testscripts.regression;

import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class QuestionTemplateFillInTheBlankCustom extends BaseTest
{
	//Maintenance Done - 07  Nov
	@Test
	public void QuestionTemplateFibCustomKeyboard() throws Exception
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
		
		//To verify that user is able to see the "Select Keyboard" with select keyboard as 
		// 1. English
		// 2. Device
		// 3. Custom
		//Select keyboard type as Cusotm and add keys - Any and verify them
		contentReourcePageObj.fillInTheBlankQuestion();
		
		//Click and verify Keyboards types English and Device
		contentReourcePageObj.keyboardTypeEnglishAndDevice();
		
		//To verify Keyboard type-CUSTOM
		//contentReourcePageObj.selectCustomKBType("default");
		
		
		//Select keyboard type as custom and add keys from different language
		contentReourcePageObj.selectCustomKBType("characters");
		
		//Fill all the mandatory details and click on submit
		contentReourcePageObj.fillAllMandatory();
		
		//Provide a Title for Question Set
		contentReourcePageObj.createQuestionTitle();
	}

}
