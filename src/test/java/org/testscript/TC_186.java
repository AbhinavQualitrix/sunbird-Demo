package org.testscript;

import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.QuestionSetPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class TC_186 extends BaseTest {
  @Test
  public void questionSetPlugin() throws Exception {
	  
	  List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
	  objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
	  
	  // Login as creator
	  SignUpPageObj creatorLogin = new SignUpPageObj();
	  creatorLogin.userLogin(CREATOR);
	  
	  // Navigate to workspace and select resource under create section
	  CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
	  CreatorUserPageObj.navigateToWorkspace(RESOURCE);
	  
	  // Select different questions
	  QuestionSetPageObj questionsetpage = new QuestionSetPageObj();
	  questionsetpage.createresource(objListOFTestDataForSunbird);
	 
	  
  }
}
