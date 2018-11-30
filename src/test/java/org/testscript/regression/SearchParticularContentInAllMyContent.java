/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Raju S
 * Date: 03/10/2018
 * Purpose:  verify user is able to Search Content.
 */

package org.testscript.regression;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class SearchParticularContentInAllMyContent extends BaseTest
{
	//Maintenance Done - 9th Nov
	@Test(priority=1, groups={"Creator Group"})
	public void VerifySortFeatureOptions() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird1= null ;
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

		ContentCreationResourcePageObj contentCreatoinResourcePage=new ContentCreationResourcePageObj();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step2: Go to Workspace and access All my content bucket
		contentCreatoinResourcePage.goToWorkspaceAndClick("All My Content");

		//Step 3: Search the content and validate
		contentCreatoinResourcePage.SearchContentAndValidate(objListOFTestDataForSunbird1.get(2).getCourseName());

	}
}