package org.testscripts.regression;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class CreateReourceByAddingAudio extends BaseTest {
	
	//TC78
	@Test
	public void resource_VerifyAudioUpload() throws Exception
	{
		//Login as Content creator
		SignUpPageObj userLogin = new SignUpPageObj();
		userLogin.userLogin(CREATOR);
		
		//Navigate to workspace to create Resource
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentCreationResourcePageObj = new ContentCreationResourcePageObj();
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		//Creating Resource
		creatorUserPageObj.createResource(objListOFTestDataForSunbird);
		
		//Upload audio and save
		contentCreationResourcePageObj.uploadAudioForEveryone();
		
		GenericFunctions.waitWebDriver(3000);
		
		//Logout as content creator
		userLogin.userLogout();
				
	}

}
