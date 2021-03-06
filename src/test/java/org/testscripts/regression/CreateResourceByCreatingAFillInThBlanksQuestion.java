package org.testscripts.regression;

import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CreateResourceByCreatingAFillInThBlanksQuestion extends BaseTest
{
	//Test case Not taken MT, scripting yet to complete 
	@Test
	public void createResourceByCreatingFillInTheBlanksQuestion() throws Exception
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
		
		//Verify that the user is able to create resource by adding question sets
		//contentReourcePageObj.applyFiltersForQuestionSet();
		
		//Verify that the user is able create resource by creating a new question(MCQ as Question template)
		contentReourcePageObj.createQuestion();
	}

}
