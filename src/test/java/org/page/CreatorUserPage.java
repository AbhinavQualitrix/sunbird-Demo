package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


/**
 * @author TEJAS46
 *
 */
public class CreatorUserPage {
	WebDriver driver;

	public  CreatorUserPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	//OCT 11-v1.11.0
	@FindBy(xpath="(//*[@id='dropdown-menu-list-header'])[2]")
	public WebElement profileIconDropdown;


	@FindBy(xpath="//i[@class='close icon']")
	public WebElement closeIcon;


	//10 OCT
	//	@FindBy(xpath="//div//a[5][contains(text(),'Profile')]")
	//	@FindBy(xpath="//a[.='Profile']")
	//@FindBy(xpath="//div[@class='ui secondary pointing menu']//a[contains(text(),'Profile')]")
	@FindBy(xpath="(//a[@class='item mt-15 computer only' and contains(text(),'Profile')])[2]")
	public WebElement headerProfile;

	//Nov 20th

	//@FindBy(xpath="//a[.='Workspace']")
	//@FindBy(xpath="//a[contains(text(),'Workspace')]")
	//@FindBy(xpath="//div[@class='menu transition hidden']//a[contains(text(),'Workspace')]")
	//@FindBy(xpath="//span[.='View your workspace']")
	@FindBy(xpath="(//a[contains(.,'Workspace')])[2]")
	public WebElement workSpace;

	@FindBy(xpath="//input[@placeholder='Name']")
	//	@FindBy(xpath="//div[@class='ui modal ng-scope transition visible active']//input[@placeholder='Name']")
	//	@FindBy(xpath="//div[@class='ui modal scroll transition active visible normal']/..//input[@placeholder='Name']")
	//	@FindBy(xpath="//label[contains(text(),'Name')]/following-sibling::div/input")
	//	@FindBy(xpath="//form[@class='ui form ng-untouched ng-pristine ng-valid']//input")
	public WebElement courseName;

	@FindBy(xpath="//input[@placeholder='Description']")
	public WebElement courseDescription;

	@FindBy(xpath="//button[contains(text(),'START CREATING')]")
	public WebElement startCreating;

	@FindBy(tagName="iframe")
	public WebElement iFrame;

	//@FindBy(xpath="(//button//a//i)[2]")
	@FindBy(xpath="//button[@class='ui basic button text-transform-none'][2]//a[2]")
	public WebElement newChild;

	//	@FindBy(xpath="//input[@class='ng-pristine ng-valid-maxlength ng-not-empty ng-valid ng-valid-required ng-touched']")
	//	@FindBy(xpath="//input[@class='ng-valid-maxlength ng-dirty ng-touched ng-not-empty ng-valid ng-valid-required']")
	//	@FindBy(xpath="//form[@name='contentMetaForm']//input[@placeholder='Enter title for Book']")
	@FindBy(xpath="//label[.='Title']/following-sibling::div//following-sibling::input")
	public WebElement titleName;

	@FindBy(xpath="//textarea[@placeholder='Brief description about the course unit']")
	public WebElement titleDescription;

	@FindBy(xpath="//button[.='ADD RESOURCE']")
	public WebElement addResource;

	@FindBy(xpath="(//div[@class='facetList ng-scope'][1]//div/div[1])[3]")
	public WebElement selectResource;

	//Updated on 17th Aug 2018
	//@FindBy(xpath="//strong[contains(text(),'Find & Select Activities')]")
	@FindBy(xpath="//strong[contains(text(),'Find & Select Resources')]")
	public WebElement findSelectActivities;	

	//@FindBy(xpath="//button[@class='ui right floated primary tiny button btnAttribute']")
	//@FindBy(xpath="//button[@class='ui right floated primary tiny button proceed-btn']")
	@FindBy(xpath="//div[@class=' ui clearing segment']/..//button[contains(text(),'PROCEED')]")
	public WebElement proceedButton;

	@FindBy(xpath="//div[@class='ui appIconSelector']")
	public WebElement clickAppIcon;

	//	@FindBy(xpath="//img[@class='asset_thumbnail']")
	@FindBy(xpath="//div[@class='ui image']//img[@data_id='do_2125451247114403841452']")
	public WebElement checkAppIcon;

	@FindBy(xpath="//div[@class='ui image']//img[@data_id='do_2125450286821949441339']")
	public WebElement checkAppIcon1;


	@FindBy(xpath="//button[.='Select']")
	public WebElement selectAppIcon;

	@FindBy(xpath="//button[.='Save']")
	public WebElement saveButton;	

	//	@FindBy(xpath="//div[@class='ui search dropdown placeholder-padding ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required selection active visible']")
	@FindBy(xpath="//div[.='Select Curriculum']")
	public WebElement clickOnSelectCurriculum;

	@FindBy(xpath="//div[@class='item selected']")
	public WebElement selectCurriculum;

	@FindBy(xpath="//div[.='Select Class']")
	public WebElement clickOnSelectClass;

	@FindBy(xpath="//div[@class='menu transition visible']//following-sibling::div")
	public WebElement selectClass;

	@FindBy(xpath="//label[contains(text(),'SUBJECT')]")
	public WebElement clickOnHeaderSubject;

	@FindBy(xpath="//div[.='Select Subject']")
	public WebElement clickOnSelectSubject;

	//OCT 12 v1.11.0
	//@FindBy(xpath="//div[@data-value='Mathematics']")
	@FindBy(xpath="//div[.='Select Subject']/following::div[@class='item']")
	public WebElement selectSubject;

	@FindBy(xpath="//div[.='Select Medium']")
	public WebElement clickOnSelectMedium;

	//OCT 10
	//@FindBy(xpath="(//div[@data-value='English'])")
	@FindBy(xpath="//div[.='Select Medium']/following::div[@class='item selected']")
	public WebElement selectMedium;

	@FindBy(xpath="//div[@class='text']//span[.='All']")
	public WebElement headerDropdown;

	@FindBy(xpath="//div[@id='headerSearch']//span[.='Courses']")
	public WebElement headerCourseClick;

	//OCT 10
	@FindBy(xpath="(//input[@id='keyword'])[2]")
	//@FindBy(xpath="//input[@id='keyword']")
	public WebElement searchInput;


	//OCT 10
	@FindBy(xpath="(//input[@id='keyword'])[2]/following::i")
	//@FindBy(xpath="//i[@class='circular search link icon']")
	public WebElement searchIcon;

	//OCT 10 - v1.11.0
	@FindBy(xpath="//input[@placeholder='Search content']/following::i")
	public WebElement searchIconUpForReview;

	@FindBy(xpath="//a[contains(text(),'Review Submissions')]")
	public WebElement reviewSubmission;

	@FindBy(xpath="//div[@class='cardImageText center aligned ']/span")
	public WebElement reviewCourseName;

	@FindBy(xpath="//div[@class='cardImageText center aligned ']/span")
	public List<WebElement> reviewSubmittedCourse;

	//updated on June 13
	//@FindBy(xpath="(//div[@class='content']/..//span)[2]")
	@FindBy(xpath="//span[.='Course']")
	public WebElement createCourse;

	//@FindBy(xpath="(//div[@class='content']/..//span)[1]")
	//Updated on June 15
	@FindBy(xpath="//div[@class='content']/..//span[.='Book']")
	public WebElement createBook;

	//@FindBy(xpath="(//div[@class='content']/..//span)[3]")
	//Updated on June 15
	@FindBy(xpath="//div[@class='content']/..//span[.='Resource']")
	public WebElement createResource;


	//@FindBy(xpath="(//div[@class='content']/..//span)[4]")
	//Updated on 15 June
	@FindBy(xpath="//div[@class='content']/..//span[.='Collection']")
	public WebElement createCollection;


	//@FindBy(xpath="(//div[@class='content']/..//span)[5]")
	//Updated on 15 June
	@FindBy(xpath="//div[@class='content']/..//span[.='Lesson Plan']")
	public WebElement createLesson;

	//@FindBy(xpath="(//div[@class='content']/..//span)[6]")
	//Updated on 15 June
	@FindBy(xpath="//div[@class='content']/..//span[.='Upload Content']")
	public WebElement createUploadContent;

	//Updated on 06/09/2018
	//@FindBy(xpath="(//input[@type='text'])[3]")
	@FindBy(xpath="//input[@placeholder='Name']")
	public WebElement bookName;

	@FindBy(xpath="//sui-select[@id='board']")
	public WebElement clickBookBoard;

	// OCT 10 v 1.11.0
	//@FindBy(xpath="(//sui-select[@id='board']/..//sui-select-option[@class='item'])[1]")
	//@FindBy(xpath="//sui-select-option[@class='item']//span[.='CBSE']")
	@FindBy(xpath="//sui-select[@id='board']/..//sui-select-option[@class='item']")
	public WebElement selectBookBoard;

	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']")
	public List<WebElement> clickBookGrade;




	@FindBy(xpath="//sui-select[@id='subject']")
	public WebElement clickBookSubject;

	//OCT 10-v1.11.0
	@FindBy(xpath="//sui-select[@id='subject']/..//sui-select-option")
	public WebElement selectBookSubject;

	@FindBy(xpath="//sui-select[@id='medium']")
	public WebElement clickBookMedium;

	//OCT 11 -V1.11.0
	@FindBy(xpath="//sui-select[@id='medium']/..//sui-select-option")
	public WebElement selectBookMedium;

	@FindBy(xpath="//sui-select[@id='year']")
	public WebElement clickBookYear;

	@FindBy(xpath="//sui-select[@id='year']//span[contains(text(),'2010')]")
	public WebElement selectBookYear;

	@FindBy(xpath="//input[@placeholder='Publisher']")
	public WebElement bookPublisher;

	@FindBy(xpath="//p[.='TABLE OF CONTENTS']")
	public WebElement tableOfContents;

	//@FindBy(xpath="(//textarea[@placeholder='Brief description about the unit']")
	//@FindBy(xpath="//*[@id="contents-data-form"]/div/div/div[2]/div/textarea")
	//label[.='Description']/../div/textarea[@placeholder='Brief description about the unit']
	@FindBy(xpath="//label[.='Description']/../div/textarea[@placeholder='Brief description about the unit']")
	public WebElement bookDescription;

	//@FindBy(xpath="(//form[@id='contents-data-form'])[4]")
	@FindBy(xpath="(//label[.='Name'])[2]")
	public WebElement clickBookForm;

	//@FindBy(xpath="(//input[@placeholder='Enter title for Book'])[3]")
	@FindBy(xpath="//label[.='Name']/../div[@class='ui input']/..//input[@placeholder='Enter title for Book']")
	public WebElement bookTitle;

	@FindBy(xpath="//label[.='Keywords']/..//div[@class='tags']//input[@placeholder='Enter Keywords']")
	public WebElement bookKeywords;

	@FindBy(xpath="//input[@placeholder='Enter code here']")
	public WebElement bookDialcode;

	@FindBy(xpath="(//div[@class='ui image']//img[@data_id='do_2124646169195151361273'])[1]")
	public WebElement clickBookIcon;

	@FindBy(xpath="(//div[@class='ui image']//img[@data_id='do_212450905413713920137'])[1]")
	public WebElement selectBookIcon;

	@FindBy(xpath="(//img[@class='resourceMetaImage '])[2]")
	public WebElement selectBookResource;

	//@FindBy(xpath="//i[@class='large blue check circle icon']")
	@FindBy(xpath="//i[@class='large check circle icon']")
	public WebElement acceptDialcode;

	@FindBy(xpath="//a[contains(text(),'Up For Review')]")
	public WebElement upForReview;

	//--------------------------------------------------------------
	//Elements for Create A Lesson plan

	@FindBy(xpath="//input[@placeholder='Enter title for unit']")
	public WebElement lessonTitle;

	@FindBy(xpath="(//div//textarea[@placeholder='Brief description about the unit'])[2]")
	public WebElement lessonDescription;

	@FindBy(xpath="//input[@placeholder='Add Notes']")
	public WebElement lessonNotes;

	@FindBy(xpath="(//img[@class='resourceMetaImage '])[3]")
	public WebElement lessonResource;

	@FindBy(xpath="//div[@class='ui image']//img[@data_id='do_2124646193555292161285']")
	public WebElement selectLessonIcon;

	@FindBy(xpath="//input[@placeholder='Search content']")
	public WebElement searchForReview;

	@FindBy(xpath="//img[@class='ui tiny image UpReviewTinyImage']/..//div[@class='UpReviewHeader']")
	public WebElement searchedContentForPublish;

	@FindBy(xpath="//span[.='Publish']")
	public WebElement clickPublishIcon;

	@FindBy(xpath="//span[.='Request Changes']")
	public WebElement clickRequestChangesIcon;

	@FindBy(xpath="//input[@class='listItem']")
	public List<WebElement> selectAllCB; 

	//Nov 21
	//@FindBy(xpath="//button[@class='ui blue button ng-binding']")
	//@FindBy(xpath="//button[contains(text(),'PUBLISH')]")
	//@FindBy(xpath="//div[@class='row margin-top-10']//button[contains(text(),'PUBLISH')]")
	@FindBy(xpath="//body//button[contains(text(),'PUBLISH')]")
	public WebElement publishButton;


	@FindBy(xpath="//button[contains(text(),'Publish')]")
	public WebElement popupPublishButton;

	@FindBy(xpath="(//div[@class='UpReviewHeader'])[1]")
	public WebElement contentForReject;

	//@FindBy(xpath="//button[contains(text(),'REQUEST CHANGES')]")
	@FindBy(xpath="//body//button[contains(text(),'REQUEST CHANGES')]")
	public WebElement clickRequestChanges;

	@FindBy(xpath="//h5[.='Appropriateness']/..//input[@class='listItem']")
	public WebElement rejectReason1;

	@FindBy(xpath="//h5[.='Content details']/..//input[@class='listItem']")
	public WebElement rejectReason2;

	@FindBy(xpath="//h5[.='Usability']/..//input[@class='listItem']")
	public WebElement rejectReason3;

	@FindBy(xpath="//button[contains(text(),'Request Changes')]")
	public WebElement requestChangesButton;

	@FindBy(xpath="(//div[@id='review-footer']/..//button[.='Request changes'])[2]")
	public WebElement requestChangesButton1;


	//Added locator for fetching list of courses up for review
	@FindBy(xpath="//div[@class='UpReviewHeader']")
	public List<WebElement> searchCoursesUpForReview;

	@FindBy(xpath="//span[contains(text(),'Publish')]")
	public WebElement publishCourseButton;

	@FindBy(xpath="//input[@class='listItem']")
	public List<WebElement> checkbox;

	//Nov 9th
	@FindBy(xpath="//div[@class='sbCard mt-20 mr-30']/div[@class='sub-header']/h4")
	//@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	//@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public List<WebElement> searchPublishedCourses;



	//Elements for upload documents -

	@FindBy(xpath="//input[@type='file']")
	public WebElement browseButton;

	@FindBy(xpath="//div[@class='qq-uploader-selector qq-uploader custom-qq-uploader']")
	public WebElement clickUploadSection;

	@FindBy(xpath="//label[.='URL']/following-sibling::div//following-sibling::input")
	public WebElement enterUrl;

	@FindBy(xpath="//button[.='Upload']")
	public WebElement UploadButton;

	@FindBy(xpath="//input[@id='name']")
	public WebElement contentMp4Title;

	@FindBy(xpath="//textarea[@id='description']")
	public WebElement contentMp4Desc;

	@FindBy(xpath="//input[@placeholder='Add a tag']")
	public WebElement contentKeywords;

	@FindBy(xpath="//input[@id='searchMyImageAssets']")
	public WebElement searchUploadImage;

	@FindBy(xpath="//input[@id='searchMyImageAssets']/..//i[@class='circular search link icon inverted']")
	public WebElement clickImageSearch;

	//Updated on 06/09/2018
	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkContentIcon;

	@FindBy(xpath="//input[@name='concepts']")
	public WebElement clickConcepts;

	@FindBy(xpath="//a[.='Artificial_Intelligence']")
	public WebElement selectConcept1;

	@FindBy(xpath="//a[.='Deep_Learning']")
	public WebElement selectConcept2;

	@FindBy(xpath="//a[.='Perceptron']")
	public WebElement selectSubConcept1;

	@FindBy(xpath="//a[.='RELU']")
	public WebElement selectSubConcept2;

	@FindBy(xpath="//a[.='Softmax']")
	public WebElement selectSubConcept3;


	//div[@id='topicSelector_defaultTemplate-topic']/..//a[contains(.,'Done')]
	@FindBy(xpath="//div[.='no-results']")
	public WebElement noResults;

	//---------------------------------------------------------------
	//Elements for creating a Collection

	@FindBy(xpath="(//label[.='Name']/following-sibling::div//following-sibling::input)[2]")
	public WebElement collectionTitle;


	@FindBy(id="dropdown-menu-list-header")
	public WebElement menuListHeader;

	@FindBy(xpath="//a[.='Workspace']")
	public WebElement listHeaderProfile;

	@FindBy(xpath="//label[.='Keywords']/..//div[@class='tags']//input[@placeholder='Enter Keywords']")
	public WebElement collectionKeywords;

	//Updated on 23/08/2018
	//@FindBy(xpath="//div[contains(text(),'Latest Resource')]/..//span[.='View All']")
	@FindBy(xpath="(//span[.='View All'])[1]")
	public WebElement viewAllButton;

	@FindBy(xpath="//div[@id='lessonBrowser_lessonType']")
	public WebElement filterCategory;

	@FindBy(xpath="//div[@data-value='Collection']")
	public WebElement collectionFilter;

	@FindBy(xpath="//div[@data-value='Resource']")
	public WebElement resourceFilter;

	@FindBy(id="apply-lesson-filter-button")
	public WebElement applyFilter;

	@FindBy(xpath="(//img[@class='resourceMetaImage '])[4]")
	public WebElement selectCollection;

	//Updated on 06/09/2018
	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkCollectionIcon;

	@FindBy(xpath="//textarea")
	public List<WebElement> reviewComment;


	//Updated on 06/09/2018
	@FindBy(xpath="//h5[.='Comments']/..//textarea")
	public WebElement reviewComments;


	@FindBy(xpath="//div[@class='sbCard mt-20 mr-30']/div[@class='sub-header']/h4")
	//@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public WebElement getCourseName;

	@FindBy(xpath="//img[@class='resourceMetaImage ']")
	public WebElement selectExtraResource;

	//Elements for Test case 14
	@FindBy(xpath="//div[@data-content='Send for review']/..//div[@class='ui pointing dropdown icon button']")
	public WebElement limitedSharingArrow;

	@FindBy(xpath="//div[.=' Limited sharing']")
	public WebElement clickLimitedSharing;
	//---------------------------------------------

	//Updated on 06/09/2018
	//@FindBy(xpath="//input[@id='treePicker']")
	@FindBy(xpath="//input[@name='concepts']")
	public WebElement selectConcept;


	//Updated on 26/07/2018
	//@FindBy(xpath="//div[@id='conceptSelector_treePicker']//input[@placeholder='Search']")
	@FindBy(xpath="//div[@id='conceptSelector_defaultTemplate-concept']//input[@placeholder='Search']")
	public WebElement searchConcept;

	//Updated on 26/07/2018
	//@FindBy(xpath="//a[contains(text(),'Choose All')]")
	@FindBy(xpath="//div[@id='conceptSelector_defaultTemplate-concept']//a[contains(text(),'Choose All')]")
	public WebElement conceptChooseAll;

	//Updated on 26/07/2018
	//@FindBy(xpath="//a[contains(text(),'Done')]")
	@FindBy(xpath="//div[@id='conceptSelector_defaultTemplate-concept']//a[contains(text(),'Done')]")
	public WebElement conceptDoneButton;

	@FindBy(xpath="//sui-select[@id='resourceType']")
	public WebElement clickResourceType;

	@FindBy(xpath="//sui-select-option[@class='item']//span[.='Study material']")
	public WebElement selectResouceType;

	@FindBy(xpath="//div[@class='content-title-container row custom-row-1']/label")
	public WebElement untitledCollection;

	@FindBy(xpath="//i[@class='fa fa-picture-o custom-menu-icon']")
	public WebElement addImageIcon;

	//Element added on 02/07/2018

	@FindBy(xpath="//div[.='Uploading..']")
	public WebElement waitForUpload;

	@FindBy(xpath="//button[contains(text(),'Close')]")
	public WebElement closeButton;

	@FindBy(xpath="//button[contains(text(),'PUBLISH')]")
	public WebElement publishResource;

	@FindBy(xpath="(//a[@class='item' and contains(text(),'My Activity')])[2]")
	public WebElement myActivity;

	@FindBy(xpath="//div[contains(text(),'Select Course To See Dashboard')]")
	public WebElement searchCourseInActivity;

	//Elements for Test case 14

	@FindBy(xpath="//button[.='Close']")
	public WebElement closeContentPopup;

	//Adding elements for Test case 16



	//Adding elements for Test case 18
	@FindBy(xpath="//a[.='Edit']")
	public WebElement editDialCode;

	//Adding element for Reviewer test case 16

	@FindBy(xpath="//i[@class='remove icon custom-cursor']")
	public WebElement editorCloseIcon;



	//Adding elements for test case 14
	@FindBy(xpath="//span[@class='browse item cursor-pointer']")
	public WebElement filterIcon;

	@FindBy(xpath="//sui-multi-select[@id='subject']")
	public WebElement clickFilterSubject;

	@FindBy(xpath="//sui-multi-select[@id='subject']//span[.='English']")
	public WebElement selectFilterSubject;

	@FindBy(xpath="//sui-multi-select[@id='medium']")
	public WebElement clickFilterMedium;

	@FindBy(xpath="//sui-multi-select[@id='medium']//span[.='English']")
	public WebElement selectFilterMedium;

	@FindBy(xpath="//sui-multi-select[@id='contentType']")
	public WebElement clickContentType;

	@FindBy(xpath="//sui-multi-select[@id='contentType']//span[.='LessonPlan']")
	public WebElement selectContentType;

	@FindBy(xpath="//a[.='APPLY']")
	public WebElement applyButton;

	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement contentResourceIcon;

	//Adding for Maintainance of Test case 2
	@FindBy(xpath="//button[contains(text(),'Upload and use')]")
	public WebElement uploadAndUseButton;


	@FindBy(xpath="//input[@id='assetfile']")
	public WebElement chooseFileButton;

	@FindBy(xpath="//button[@class='ui blue button submit button']")
	public WebElement uploadAndUseButtonRight;

	@FindBy(xpath="//div[contains(text(),'Select Course')]")
	public WebElement clickDashboardCourse;

	@FindBy(xpath="//div[contains(text(),'Select Course')]/..//sui-select-option")
	public WebElement selectDashboardCourse;


	// Added for send course for review popup, OCT 10
	@FindBy(xpath="//label[contains(.,'OWNER')]/following::div")
	public WebElement clickOwner;

	@FindBy(xpath="//label[contains(.,'OWNER')]/following::div//div[@class='item selected']")
	public WebElement selectOwner;

	//Added on 11 OCT - v1.11.0

	@FindBy(xpath="//a[@data-content='Add Audio']")
	public WebElement addAudio;

	@FindBy(linkText="All audio")
	public WebElement clickAllAudio;

	@FindBy(xpath="(//audio[@id='audio-5'])[2]")
	public WebElement selectAudio_AllAudio;



	@FindBy(xpath="//i[@class='trash large icon']")
	public List<WebElement> deleteButtonAll ;

	@FindBy(xpath="//button[.='Yes']")
	public WebElement yesButtonPopup ;

	@FindBy(xpath="(//i[@class='trash large icon'])[1]")
	public WebElement deleteButton ;


	//Added on OCT 23 2018
	//@FindBy(xpath="(//*[@id='dropdown-menu-list-header'])[2]//following::a[@href='/profile']")
	@FindBy(xpath="(.//a[contains(text(),'Profile')])[2]")
	public WebElement profileIconProfile;

	@FindBy(xpath="//a[@href='/workspace/content/uploaded/1']")
	public WebElement allUploads;

	@FindBy(xpath="//a[@href='/workspace/content/limited-publish/1']")
	public WebElement limitedPublishing;

	//Nov 22
	@FindBy(xpath="//div[@class='cardImageText center aligned ']/span")
	public WebElement getContentInDrafts;

	//Nov 22
	@FindBy(xpath="//span[contains(text(),'View Details')]")
	public WebElement viewDetails;



	@FindBy(xpath="(//sui-select-option[@value='Organisations'])[2]")
	public WebElement organisationsInSearch;

	@FindBy(xpath="(//i[@class='dropdown icon'])[2]")
	public WebElement searchDropdown;

	@FindBy(xpath="(//input[@class='checkBox'])[1]")
	public WebElement selectResourceN;

	@FindBy(xpath="(//div[@class='UpReviewHeader'])[1]")
	public WebElement searchCoursesUpForReviewE;

	@FindBy(xpath="//div[@class='five wide column custom-5-wide']/div/div/div/div[5]")
	//@FindBy(xpath="//div[@data-content='Send for review']")
	public WebElement sendForReviewA;

	@FindBy(xpath="//span[@class='ng-scope']")
	public WebElement editdetailslink;

	@FindBy(xpath="//button[contains(text(),'Close')]")
	public WebElement closeButtonMsg ;


	//Nov 23rd
	@FindBy(xpath="//label[contains(.,'Topics')]/..//topic-selector/..//input")
	public WebElement clickTopic;

	//Nov 23rd
	@FindBy(xpath="//div[@id='topicSelector_defaultTemplate-topic']//input[@placeholder='Search']")
	public WebElement searchTopic;

	//Nov 23rd
	@FindBy(xpath="//div[@class='ui tree-picker tree']/..//i[@class='add circle icon']/..//a")
	public WebElement selectTopic;



	//Nov 24
	@FindBy(xpath="(//sui-multi-select[@id='board'])[2]")
	//@FindBy(xpath="//sui-multi-select[@id='board']")
	public WebElement clickFilterBoard;


	//Nov 24
	@FindBy(xpath="//div[contains(text(),'TextBook')]")
	public List<WebElement> contentType;

	@FindBy(xpath="(//div[@class='content'])[1]")
	public WebElement searchedContent;

	//Nov 26 - v1.11.0
	//@FindBy(xpath="(//sui-multi-select[@id='gradeLevel']/..//sui-select-option[@class='item selected'])[2]")
	//@FindBy(xpath="//sui-multi-select[@id='gradeLevel']/..//sui-select-option[@class='item selected']")
	@FindBy(xpath="(//sui-multi-select[@id='gradeLevel'])[1]/..//sui-select-option")
	public List<WebElement> selectBookGrade;

	//Nov 27-Added
	@FindBy(xpath="//label[contains(.,'Name')]/following::input[@type='text' or @placeholder='Name']")
	public WebElement resourceName;


	//span[contains(.,'Create')]/following::input[@type='text']
	//span[contains(.,'Create')]/following::input[@type='text' or @placeholder='Name']
	//label[contains(.,'Name')]/following::input[@type='text' or @placeholder='Name']
	//label[contains(.,'Name')]/following::input[@type='text' or @placeholder='Name']



	//Nov 28th
	@FindBy(xpath="//div[contains(@class,'ui text menu m-0 ')]/following::a[contains(text(),'Courses')]")
	//@FindBy(xpath="//div[@class='ui text menu m-0 jc-center flex']/following::a[contains(text(),'Courses')]")
	//@FindBy(xpath="//a[contains(text(),'Course')]")
	public WebElement headerCourse;

	//Nov 28th
	@FindBy(xpath="//div[contains(@class,'ui text menu m-0 ')]/following::a[contains(text(),'Library')]")
	//@FindBy(xpath="//div[@class='ui text menu m-0 jc-center flex']/following::a[contains(text(),'Library')]")
	//@FindBy(xpath="//a[contains(text(),'Library')]")
	public WebElement headerLibrary;

	//Nov 28th
	@FindBy(xpath="//div[@id='saveButton']//i")
	//@FindBy(xpath="//span[.='Save']")
	public WebElement saveCourse;
	
	//Nov 28
	@FindBy(xpath="//div[@class='no-result-text']")
	public WebElement noContentInUpForReview;
	
	//Nov 28
	@FindBy(xpath="//a[contains(text(),'Published')]")
	public WebElement published;
	
	//Nov 28
	@FindBy(xpath="//a[contains(text(),'Drafts')]")
	public WebElement drafts;
	
	//Nov 28
	//@FindBy(xpath="//a[.=' All My Content ']")
	@FindBy(xpath="//a[@href='/workspace/content/allcontent/1']")
	public WebElement allMyContent;
	
	//Nov 28
	//@FindBy(xpath="//a[.='Done']")
	@FindBy(xpath="(//a[.='Done'])[1]")
	public WebElement doneButton;
	
	//Merge of Nov 27
	
	@FindBy(xpath="//h4[contains(text(),'Course')]")
	public WebElement headerCourseTitles;
	
	//Nov 28
	@FindBy(xpath="//div[@class='ui button text-part popup-item']//i[@class='send icon']")
	//@FindBy(xpath="//div[@class='ui button text-part popup-item']")
	public WebElement sendForReview;
	
	
}


