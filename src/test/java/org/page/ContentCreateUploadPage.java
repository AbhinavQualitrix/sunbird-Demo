package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentCreateUploadPage 
{
	WebDriver driver;

	public  ContentCreateUploadPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	@FindBy(xpath="//*[@id=\"url-upload\"]/div/input")
	public WebElement enterUrl;

	@FindBy(xpath="//button[contains(text(),'Close Editor')]")
	public WebElement closeEditor;

	@FindBy(xpath="//div[.='Browse']")
	public WebElement browseButton;

	@FindBy(xpath="//i[@class='ui large blue clone outline icon blue-text-color-sunbird ']")
	public WebElement copy;

	@FindBy(xpath="//div[@class=\"icon-box popup-item\"]")
	public WebElement uploadContent;

	@FindBy(id="saveButton")
	public WebElement saveUploadContent;

	@FindBy(id="defaultTemplate-concept")
	public WebElement concept;

	@FindBy(xpath="//strong[.='Functions']")
	public WebElement selectFunction;

	@FindBy(xpath="//*[@id=\"upload-content-div\"]/div")
	public   WebElement frame;

	@FindBy(xpath="//*[@id=\"commonHeader\"]/div/div[2]/div[2]/a/span/i")
	public WebElement editDetailsLink;

	@FindBy(xpath="//i[@class=\"edit icon\"]")
	public WebElement editDetailsHeading;

	@FindBy(xpath="//*[@id=\"name\"]/label")
	public WebElement title;

	@FindBy(id="icon_appIcon")
	public WebElement checkAppIcon;

	@FindBy(xpath="//*[@id=\"defaultTemplate-concept\"]")
	public WebElement selectConcept;

	@FindBy(xpath="//*[@id=\"conceptSelector_defaultTemplate-concept\"]//input[@placeholder='Search']")
	public WebElement searchConcept1;

	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkContentIcon;

	@FindBy(xpath="//button[.='Select']")
	public WebElement selectAppIcon;

	@FindBy(xpath="//*[@id=\"ngdialog5\"]/div[2]/div/div[3]/div/div[2]/div/button[2]")
	public WebElement selectButton;

	@FindBy(xpath="//*[@id=\"defaultTemplate-topic\"]")
	public WebElement selectTopic;

	@FindBy(xpath="//*[@id=\"topicSelector_defaultTemplate-topic\"]/div[4]/a[5]")
	public WebElement doneButton1;

	@FindBy(xpath="//input[@id=\"name\"]")
	public WebElement uploadContentName;

	@FindBy(xpath="//*[@id='closeButton']")
	public WebElement closeEditorButton;


	@FindBy(xpath="//i[@class=\"linkify large icon float-ContentLeft limitedPublishingLinkIcon\"]")
	public WebElement clickOnShare;

	@FindBy(xpath="//div[2]/app-workspacesidebar/div/a[10]")
	public WebElement clickonLimitedPublishing;

	@FindBy(xpath="//button[@class=\"ui basic primary button\"]")
	public WebElement copyLink;

	@FindBy(xpath="//i[@class=\"ui remove icon\"]")
	public WebElement closeShareLink;

	@FindBy(id="copyLinkData")
	public WebElement linkData;


	@FindBy(xpath="//div[2]/app-workspacesidebar/div/a[4]")
	public WebElement reviewSubmission;

	@FindBy(xpath="//span[@class=\"sliderCardHeading text-cencapitalize\"]")
	public WebElement reviewCardView;

	@FindBy(xpath="//img[@class=\"ui circular image logged-in-user\"]")
	public WebElement profileIcon;

	@FindBy(xpath="//*[@id=\"dropdown-menu-list-header\"]/div/a[2]")
	public WebElement workspace;

	@FindBy(xpath="//*[@id=\"dropdown-menu-list-header\"]/div/a[3]")
	public WebElement workspace1;

	@FindBy(xpath="//div/div[2]/app-workspacesidebar/div/a[7]")
	public WebElement upForReview;

	@FindBy(xpath="//div[@class='UpReviewHeader']")
	public WebElement contentUpload;

	@FindBy(xpath="//input[@placeholder='Search content']")
	public WebElement searchBox;

	@FindBy(xpath="//*[@id=\"sortByDropDown\"]")
	public WebElement sortBy;

	@FindBy(xpath="//*[@id=\"sortByDropDown\"]//span[2]")
	public WebElement updatedOn;

	@FindBy(xpath="//*[@id=\"sortByDropDown\"]//sui-select-option[2]/span[2]")
	public WebElement createdOn;

	@FindBy(xpath="//*[@id=\"sortByDropDown\"]//sui-select-option[3]/span[2]")
	public WebElement nameAZ;

	@FindBy(xpath="//div[.=\"Pending since: a day ago \"]")
	public WebElement date;

	@FindBy(xpath="//*[@id=\"showFilterButton\"]")
	public WebElement showFilter;

	@FindBy(xpath="//*[@id=\"board\"]")
	public WebElement selectBoard;

	@FindBy(xpath="//*[@id=\"board\"]//span[2]")
	public WebElement selectBoardRajasthan;

	@FindBy(xpath="//*[@id=\"gradeLevel\"]")
	public WebElement gradeLevel;

	@FindBy(xpath="//*[@id=\"gradeLevel\"]//span[2]")
	public WebElement selectClass9;

	@FindBy(id="subject")
	public WebElement selectSubject;

	@FindBy(xpath="//*[@id=\"subject\"]//span[2]")
	public WebElement selectMathematics;

	@FindBy(id="medium")
	public WebElement selectMedium;

	@FindBy(xpath="//*[@id=\"medium\"]//span[2]")
	public WebElement selectHindi;

	@FindBy(id="contentType")
	public WebElement selectContentType;

	@FindBy(xpath="//*[@id=\"contentType\"]//span[2]")
	public WebElement selectCollection;

	@FindBy(xpath="//a[@class='searchfilterbutton ui blue tiny  button']")
	public WebElement clickOnApplyButton;

	@FindBy(xpath="//div[@class='UpReviewHeader']")
	public WebElement contentFiltered;

	@FindBy(xpath="//th[@class='two wide UpReviewTableHeader']")
	public WebElement status;

	@FindBy(xpath="//button[@class='ui right floated primary button mouse-pointer']")
	public WebElement publishButton;

	@FindBy(xpath="//input[@class='listItem']")
	public List<WebElement> checkbox;

	@FindBy(xpath="//button[@class='ui blue button ']")
	public WebElement publishButton1;

	@FindBy(xpath="//div/div[2]/app-workspacesidebar/div/a[5]")
	public WebElement published;

	@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public WebElement contentPublished;

	@FindBy(xpath="//button[2][@class=\"ui right floated primary button mouse-pointer\"]")
	public WebElement requestChanges;

	@FindBy(xpath="//textarea[@class=\"ng-untouched ng-pristine ng-valid\"]")
	public WebElement requestChangesComment;

	@FindBy(xpath="//button[@class=\"ui blue button \"]")
	public WebElement requestChangesBlueButton;

	@FindBy(xpath="//div/div[2]/app-workspacesidebar/div/a[6]")
	public WebElement allUploads;

	@FindBy(xpath="//*[@id=\"commonHeader\"]/div/div[4]/div/div/div/div[6]/span")
	public WebElement reviewerSuggestion;

	@FindBy(xpath="//span[@class=\"ng-binding\"]")
	public WebElement reviewerSuggestionTitle;

	@FindBy(xpath="//input[@type='file']")
	public WebElement browseButton1;

}
