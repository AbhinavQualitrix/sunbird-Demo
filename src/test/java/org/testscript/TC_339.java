package org.testscript;

import org.pageobjects.AnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_339 extends BaseTest{
 @Test
 public void TC_339_announcement_feature() throws Exception{
      SignUpPageObj orgAdminLogin = new SignUpPageObj();
      
      
      // Step1: Log in as Admin
      orgAdminLogin.userLogin(ADMIN);
      
      // Go to announcement Page
      AnnouncementPageObj announcementPageObj = new AnnouncementPageObj();
      announcementPageObj.navigateToAnnouncementInDropDownMenu();
      
      // Edit and resend the announcement   
      announcementPageObj.verifyDataStorage();

    
 }
}