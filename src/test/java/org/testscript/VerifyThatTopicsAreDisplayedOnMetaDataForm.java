/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Richa Prakash
* Date: 25/09/2018
* Purpose:  Verify that the topics are displayed on the meta data page.
*/


package org.testscript;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.TopicTreePageObject;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class VerifyThatTopicsAreDisplayedOnMetaDataForm extends BaseTest {
	@Test
	
	public void verifyThatTopicsAreDisplayedOnMetaDataForm() throws Exception{
	{
		
			SignUpPageObj signupobj = new SignUpPageObj();
			CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
			TopicTreePageObject topicslist =new TopicTreePageObject();
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			
			
			//Steps no.:Login as a creator
			signupobj.userLogin(CREATOR);
			
			//Steps no 2.: Navigate to worksapce and click on book
			createuserpageobj.navigateToWorkspace(BOOK);

			//Steps no 3.:Create Book
			topicslist.createBook_verifyTopicTreePopup(objListOFTestDataForSunbird);
			
			//Steps no.4:Logout as a creator
			signupobj.userLogout();
			
			
		     
			
	}

}
}