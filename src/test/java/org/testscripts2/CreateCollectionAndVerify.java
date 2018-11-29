package org.testscripts2;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class CreateCollectionAndVerify  extends BaseTest {

	@Test
	public void createCollectionAndVerify() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		ContentCreationResourcePageObj contentResourcePageObj = new ContentCreationResourcePageObj();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step2: Navigate to WorkSpace
		//Step3: Create new Collection
		 creatorUserPageObj.createCollection();
		
		 //Extra Added
		 //contentResourcePageObj.verifyEditDetails_OfMetadataPage(metapageDetails);
		
		//Step4: Save and send resource for review
		//creatorUserPageObj.saveAndSendBookForReview(objListOFTestDataForSunbird);
		
		GenericFunctions.refreshWebPage();

		//Step5: Check for course in review submissions 
		//creatorUserPageObj.reviewInSubmissions(COLLECTION,objListOFTestDataForSunbird);
		
		
		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);

		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		//creatorUserPageObj.searchInUpForReview(COLLECTION,objListOFTestDataForSunbird);

		creatorUserPageObj.goToWorkspace("collection");
		//Step 9:publish the resource and search it
		//creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		//System.out.println("Created - "+objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./courseNumbers.txt"));

		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();		

		//Step11: Login as Public User
		creatorLogin.userLogin(PUBLICUSER1);

		//Step12: Search the course with Name
		GenericFunctions.waitWebDriver(2000);
		createMentorPageObj.navigateToLibraryAndSearchForCollection();

		//Step 13: Logout as Reviewer
		creatorLogin.userLogout();		

	}

}


