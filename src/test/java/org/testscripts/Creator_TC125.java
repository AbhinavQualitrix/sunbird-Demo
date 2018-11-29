/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Richa Prakash
* Date: 28/08/2018
* Purpose:  Verify that the uploaded content pop up is displaying 
* when clicking on the upload content 
*/

package org.testscripts;

import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class Creator_TC125 extends BaseTest

{
	@Test
	public void library_copyContent() throws Exception
	{
	 SignUpPageObj signupobj = new SignUpPageObj();
	 CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
	 ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 
	 List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
	objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
	 
	 // Step no.1:Login as a content creator
	 signupobj.userLogin(CREATOR);
	 
	
	 //Step no.2:Go to library
	 contentcreateuploadpageobj.navigateToLibraryAndSearchContent(objListOFTestDataForSunbird1);
	 
	 
	}
}
	 