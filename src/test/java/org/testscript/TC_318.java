package org.testscript;

import org.generic.GenericFunctions;
import org.pageobjects.AnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_318 extends BaseTest{
 @Test
 public void TC_318_announcement_feature() throws Exception{
      SignUpPageObj orgAdminLogin = new SignUpPageObj();
      
      
      // Step1: Log in as Admin
      orgAdminLogin.userLogin(ADMIN);
      
      // Step2: Go to announcements page and click on create announcement link.
     // CreatorAnnouncementPageObj announcementPage = new CreatorAnnouncementPageObj();
      AnnouncementPageObj announcementPageObj = new AnnouncementPageObj();

      announcementPageObj.navigateToAnnouncementInDropDownMenu();
    
      
      /* Step3:
       *  Click on the "announcement type" drop down.
          Select the organization that has sent the announcement.
          Give the description of the announcement.
          Try to add any web link or URL at the add web/URL field.*/
      	GenericFunctions.waitWebDriver(3000);
      	announcementPageObj.CreateAnnouncementPopUp();
      
    
     
     // Test case done
      

      
      
 }
}