package scenarios.Custom;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCustomPage;

public class Financials_Custom_00_DataUpload extends TestBase {

	@Test(priority = 1)
	public void CUSTOM_DataUploadPage() throws Exception {
		ReportLog.setTestName("CUSTOM - Data Upload Page");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

		ReportLog.setTestCase("CUSTOM_RT_TC_001");
		VIP_Common.LogInPage(testDataHandler);
		VIPCustomPage.contents.ModalCloseButton.click();
		Thread.sleep(2000);
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.VIPCustomHeader.verifyDisplayed(true, 15);
		WebControl.takeScreenshot("CUSTOM_RT_TC_001");

		ReportLog.setTestCase("CUSTOM_RT_TC_002");
		VIPCustomPage.contents.LoginButton.verifyDisplayed(true);
		VIPCustomPage.contents.LoginButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.eid + "asa");
		VIPCustomPage.contents.ModalLoginButton.click();
		Thread.sleep(5000);
		VIPCustomPage.contents.LoginFailedMessage.verifyText("Login failed, Please try again.");
		Thread.sleep(2000);
		VIPCustomPage.contents.EIDTextBox.clear();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.eid);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.UserEIDHeader.verifyText(testDataHandler.eid);
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.VIPCustomHeader.waitForExist(true, 25);
		VIPCustomPage.contents.LoginButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.email);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.UserEIDHeader.verifyText(testDataHandler.eid);
		WebControl.takeScreenshot("CUSTOM_RT_TC_002");

		ReportLog.setTestCase("CUSTOM_RT_TC_003"); 
		//Logged In
		VIPCustomPage.contents.ViewSampleText.verifyText("View Sample");
		VIPCustomPage.contents.ViewSampleIcon.verifyDisplayed(true);
		VIPCustomPage.contents.ViewSampleText.click(); 
		WebControl.waitForPageToLoad(50); 
		Thread.sleep(2000);
		WebControl.switchWithTitle("VIP Sample Custom Report");
		Thread.sleep(5000);
		WebControl.verifyURL(
		"https://kxdocuments.accenture.com/contribution/3febcb50-c6ea-4294-93b9-4dff8cb786a6");
		WebControl.takeScreenshot("CUSTOM_RT_TC_003_ViewSampleLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		Thread.sleep(2000);
	
		//Not Logged In 
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.VIPCustomHeader.waitForExist(true, 25);
		VIPCustomPage.contents.ViewSampleText.verifyText("View Sample");
		VIPCustomPage.contents.ViewSampleIcon.verifyDisplayed(true);
		VIPCustomPage.contents.ViewSampleText.click(); 
		WebControl.waitForPageToLoad(50); 
		Thread.sleep(2000);
		WebControl.switchWithTitle("VIP Sample Custom Report");
		Thread.sleep(5000);
		WebControl.verifyURL(
		"https://kxdocuments.accenture.com/contribution/3febcb50-c6ea-4294-93b9-4dff8cb786a6");
		WebControl.takeScreenshot("CUSTOM_RT_TC_003_ViewSampleLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		Thread.sleep(2000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_003");
		 

		ReportLog.setTestCase("CUSTOM_RT_TC_004");
		// Not Logged In
		VIPCustomPage.contents.PrepareHeader.verifyText("Prepare");
		VIPCustomPage.contents.PrepareNumber.verifyText("1");
		VIPCustomPage.contents.PrepareText.verifyText("Prepare a cleansed Cap IQ model (L1)");
		VIPCustomPage.contents.PrepareIcon.verifyDisplayed(true);
		VIPCustomPage.contents.PrepareChecklist.verifyText("View checklist");
		// Logged In
		VIPCustomPage.contents.LoginButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.email);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.UserEIDHeader.verifyText(testDataHandler.eid);
		VIPCustomPage.contents.PrepareHeader.verifyText("Prepare");
		VIPCustomPage.contents.PrepareNumber.verifyText("1");
		VIPCustomPage.contents.PrepareText.verifyText("Prepare a cleansed Cap IQ model (L1)");
		VIPCustomPage.contents.PrepareIcon.verifyDisplayed(true);
		VIPCustomPage.contents.PrepareChecklist.verifyText("View checklist");
		WebControl.takeScreenshot("CUSTOM_RT_TC_004");

		
		ReportLog.setTestCase("CUSTOM_RT_TC_005");
		// Logged In
		VIPCustomPage.contents.PrepareChecklist.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalTitle.verifyText("Checklist for Cleansed Data Model (L1)");
		VIPCustomPage.contents.ModalSubTitle.verifyText(
				"The following checks need to be kept in mind before converting the model into VIP compatible file (L2)");
		VIPCustomPage.contents.ModalBodyNo1.verifyText("1.");
		VIPCustomPage.contents.ModalBodyTitle1.verifyText("Check summary sheet:");
		VIPCustomPage.contents.ModalBodyDesc1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo2.verifyText("2.");
		VIPCustomPage.contents.ModalBodyTitle2.verifyText("Avoid deleting/adding cells:");
		VIPCustomPage.contents.ModalBodyDesc2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo3.verifyText("3.");
		VIPCustomPage.contents.ModalBodyTitle3.verifyText("Keep minimal manual modifications:");
		VIPCustomPage.contents.ModalBodyDesc3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo4.verifyText("4.");
		VIPCustomPage.contents.ModalBodyTitle4.verifyText("Capital IQ tickers should be available for all companies, even in case of a pvt. company:");
		VIPCustomPage.contents.ModalBodyDesc4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalOKButton.verifyText("OK");
		VIPCustomPage.contents.ModalOKButton.click();
		VIPCustomPage.contents.VIPCustomHeader.verifyDisplayed(true);
		VIPCustomPage.contents.PrepareChecklist.verifyDisplayed(true);
		Thread.sleep(3000);
		VIPCustomPage.contents.PrepareChecklist.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalXButton.verifyDisplayed(true);
		VIPCustomPage.contents.ModalXButton.click();
		VIPCustomPage.contents.VIPCustomHeader.verifyDisplayed(true);
		Thread.sleep(3000);
		// Not Logged In
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.VIPCustomHeader.waitForExist(true, 25);
		VIPCustomPage.contents.PrepareChecklist.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalTitle.verifyText("Checklist for Cleansed Data Model (L1)");
		VIPCustomPage.contents.ModalSubTitle.verifyText(
				"The following checks need to be kept in mind before converting the model into VIP compatible file (L2)");
		VIPCustomPage.contents.ModalBodyNo1.verifyText("1.");
		VIPCustomPage.contents.ModalBodyTitle1.verifyText("Check summary sheet:");
		VIPCustomPage.contents.ModalBodyDesc1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo2.verifyText("2.");
		VIPCustomPage.contents.ModalBodyTitle2.verifyText("Avoid deleting/adding cells:");
		VIPCustomPage.contents.ModalBodyDesc2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo3.verifyText("3.");
		VIPCustomPage.contents.ModalBodyTitle3.verifyText("Keep minimal manual modifications:");
		VIPCustomPage.contents.ModalBodyDesc3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo4.verifyText("4.");
		VIPCustomPage.contents.ModalBodyTitle4.verifyText("Capital IQ tickers should be available for all companies, even in case of a pvt. company:");
		VIPCustomPage.contents.ModalBodyDesc4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalOKButton.verifyText("OK");
		VIPCustomPage.contents.ModalOKButton.click();
		VIPCustomPage.contents.VIPCustomHeader.verifyDisplayed(true);
		VIPCustomPage.contents.PrepareChecklist.verifyDisplayed(true);
		Thread.sleep(3000);
		VIPCustomPage.contents.PrepareChecklist.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalXButton.verifyDisplayed(true);
		VIPCustomPage.contents.ModalXButton.click();
		VIPCustomPage.contents.VIPCustomHeader.verifyDisplayed(true);
		Thread.sleep(3000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_005");

		
		ReportLog.setTestCase("CUSTOM_RT_TC_006");
		// Not Logged In
		VIPCustomPage.contents.ConvertHeader.verifyText("Convert");
		VIPCustomPage.contents.ConvertNumber.verifyText("2");
		VIPCustomPage.contents.ConvertText.verifyText("Convert L1 into VIP compatible format (L2) using VIP Converter");
		VIPCustomPage.contents.ConvertVIPConverter.verifyText("VIP Converter");
		VIPCustomPage.contents.ConvertVIPConverter.click();
		WebControl.waitForPageToLoad(50); 
		Thread.sleep(2000);
		WebControl.switchWithTitle("VIP converter macro file for Custom");
	    Thread.sleep(5000);
	    WebControl.verifyURL("https://kxdocuments.accenture.com/contribution/401a3a98-17c3-4952-9881-dc83705b5722");
		WebControl.takeScreenshot("CUSTOM_RT_TC_006_ViewLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		Thread.sleep(2000);	
		VIPCustomPage.contents.ConvertNumber.verifyText("2");
		VIPCustomPage.contents.ConvertIcon.verifyDisplayed(true);
		VIPCustomPage.contents.ConvertChecklist.verifyText("View checklist");
		// Logged In
		VIPCustomPage.contents.LoginButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.email);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.UserEIDHeader.verifyText(testDataHandler.eid);
		VIPCustomPage.contents.ConvertHeader.verifyText("Convert");
		VIPCustomPage.contents.ConvertNumber.verifyText("2");
		VIPCustomPage.contents.ConvertText.verifyText("Convert L1 into VIP compatible format (L2) using VIP Converter");
		VIPCustomPage.contents.ConvertVIPConverter.verifyText("VIP Converter");
		VIPCustomPage.contents.ConvertVIPConverter.click();
		WebControl.waitForPageToLoad(50); 
		Thread.sleep(2000);
		WebControl.switchWithTitle("VIP converter macro file for Custom");
	    Thread.sleep(5000);
	    WebControl.verifyURL("https://kxdocuments.accenture.com/contribution/401a3a98-17c3-4952-9881-dc83705b5722");
		WebControl.takeScreenshot("CUSTOM_RT_TC_006_ViewLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		Thread.sleep(2000);	
		VIPCustomPage.contents.ConvertIcon.verifyDisplayed(true);
		VIPCustomPage.contents.ConvertChecklist.verifyText("View checklist");
		WebControl.takeScreenshot("CUSTOM_RT_TC_006");

		
		ReportLog.setTestCase("CUSTOM_RT_TC_007");
		// Logged In
		VIPCustomPage.contents.ConvertChecklist.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalTitle.verifyText("Checklist for VIP Compatible Excel (L2)");
		VIPCustomPage.contents.ModalSubTitle.verifyText(
				"The following checks need to be kept in mind before uploading the Final excel file (L2) on VIP");
		VIPCustomPage.contents.ModalBodyNo1.verifyText("1.");
		VIPCustomPage.contents.ModalBodyTitle1.verifyText("Year alignment:");
		VIPCustomPage.contents.ModalBodyDesc1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo2.verifyText("2.");
		VIPCustomPage.contents.ModalBodyTitle2.verifyText("No formulas allowed:");
		VIPCustomPage.contents.ModalBodyDesc2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo3.verifyText("3.");
		VIPCustomPage.contents.ModalBodyTitle3.verifyText("Manually add data to Glassdoor Rating and Segment Benchmarking tabs:");
		VIPCustomPage.contents.ModalBodyDesc3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ConvertNote.verifyText("Find more detailed checks here");
		VIPCustomPage.contents.ConvertNoteLink.click();
		WebControl.waitForPageToLoad(50); 
		Thread.sleep(2000);
        WebControl.switchWithTitle("Checklist for generating custom report");
	    Thread.sleep(5000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_007_ViewLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		Thread.sleep(2000);	
		VIPCustomPage.contents.ModalOKButton.verifyText("OK");
		VIPCustomPage.contents.ModalOKButton.click();
		VIPCustomPage.contents.VIPCustomHeader.verifyDisplayed(true);
		VIPCustomPage.contents.ConvertChecklist.verifyDisplayed(true);
		Thread.sleep(3000);
		VIPCustomPage.contents.ConvertChecklist.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalXButton.verifyDisplayed(true);
		VIPCustomPage.contents.ModalXButton.click();
		VIPCustomPage.contents.VIPCustomHeader.verifyDisplayed(true);
		Thread.sleep(3000);
		// Not Logged In
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.VIPCustomHeader.waitForExist(true, 25);
		VIPCustomPage.contents.ConvertChecklist.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalTitle.verifyText("Checklist for VIP Compatible Excel (L2)");
		VIPCustomPage.contents.ModalSubTitle.verifyText(
				"The following checks need to be kept in mind before uploading the Final excel file (L2) on VIP");
		VIPCustomPage.contents.ModalBodyNo1.verifyText("1.");
		VIPCustomPage.contents.ModalBodyTitle1.verifyText("Year alignment:");
		VIPCustomPage.contents.ModalBodyDesc1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo2.verifyText("2.");
		VIPCustomPage.contents.ModalBodyTitle2.verifyText("No formulas allowed:");
		VIPCustomPage.contents.ModalBodyDesc2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ModalBodyNo3.verifyText("3.");
		VIPCustomPage.contents.ModalBodyTitle3.verifyText("Manually add data to Glassdoor Rating and Segment Benchmarking tabs:");
		VIPCustomPage.contents.ModalBodyDesc3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ConvertNote.verifyText("Find more detailed checks here");
		VIPCustomPage.contents.ConvertNoteLink.click();
		WebControl.waitForPageToLoad(50); 
		Thread.sleep(2000);
        WebControl.switchWithTitle("Checklist for generating custom report");
	    Thread.sleep(5000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_007_ViewLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		Thread.sleep(2000);	
		VIPCustomPage.contents.ModalOKButton.verifyText("OK");
		VIPCustomPage.contents.ModalOKButton.click();
		VIPCustomPage.contents.VIPCustomHeader.verifyDisplayed(true);
		VIPCustomPage.contents.ConvertChecklist.verifyDisplayed(true);
		Thread.sleep(3000);
		VIPCustomPage.contents.ConvertChecklist.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalXButton.verifyDisplayed(true);
		VIPCustomPage.contents.ModalXButton.click();
		VIPCustomPage.contents.VIPCustomHeader.verifyDisplayed(true);
		Thread.sleep(3000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_007");

		
		ReportLog.setTestCase("CUSTOM_RT_TC_008");
		// Not Logged In
		VIPCustomPage.contents.UploadHeader.verifyText("Upload!");
		VIPCustomPage.contents.UploadNumber.verifyText("3");
		VIPCustomPage.contents.UploadText.verifyText("Upload converted Data Model (L2)");
		VIPCustomPage.contents.UploadXLSIcon.verifyDisplayed(true);
		VIPCustomPage.contents.DataModelUploadButton.verifyText("DataModel Upload");
		// Logged In
		VIPCustomPage.contents.LoginButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.email);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.UserEIDHeader.verifyText(testDataHandler.eid);
		VIPCustomPage.contents.UploadHeader.verifyText("Upload!");
		VIPCustomPage.contents.UploadNumber.verifyText("3");
		VIPCustomPage.contents.UploadText.verifyText("Upload converted Data Model (L2)");
		VIPCustomPage.contents.UploadXLSIcon.verifyDisplayed(true);
		VIPCustomPage.contents.DataModelUploadButton.verifyText("DataModel Upload");
		WebControl.takeScreenshot("CUSTOM_RT_TC_008");

		
		ReportLog.setTestCase("CUSTOM_RT_TC_013 to 017");
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.VIPCustomHeader.waitForExist(true, 25);
		VIPCustomPage.contents.DataModelUploadButton.waitForExist(true, 15);
		VIPCustomPage.contents.DataModelUploadButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.email);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.UserEIDHeader.verifyText(testDataHandler.eid);
		//Public //14
		VIPCustomPage.contents.ReportTypeDropdown.verifyDisplayed(true);
		VIPCustomPage.contents.ReportTypeDropdown.click();
		VIPCustomPage.contents.PremiumIndustrialMenu.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.CompanyTypeDropdown.verifyDisplayed(true);
		VIPCustomPage.contents.CompanyTypeDropdown.click();
		VIPCustomPage.contents.PublicMenu.click();
		VIPCustomPage.contents.SelectDashboardButton.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalTitle.verifyDisplayed(true);
		VIPCustomPage.contents.ModalTitle.verifyText("Select Dashboards:");
		VIPCustomPage.contents.SelectDashboardAll.verifyText("Select All");
		VIPCustomPage.contents.SelectDashboardScorecard.verifyText("Competitiveness Scorecard");
		VIPCustomPage.contents.SelectDashboardVCA.verifyText("Value Creation Areas");
		VIPCustomPage.contents.SelectDashboardGlassdoor.verifyText("HR Analysis - Glassdoor Benchmarking");
		VIPCustomPage.contents.SelectDashboardTRS.verifyText("Total Return to Shareholders (1, 3, 5 years Trend)");
		VIPCustomPage.contents.SelectDashboardTRSSummary.verifyText("3 Year TRS Decomposition – Summary");
		VIPCustomPage.contents.SelectDashboardTRSLevers.verifyText("3 Year TRS Decomposition – Levers");
		VIPCustomPage.contents.SelectDashboardSCM.verifyText("Strategic Control Map (EV to IC)");
		VIPCustomPage.contents.SelectDashboardEVICDecom.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPCustomPage.contents.SelectDashboardEVDissection.verifyText("Enterprise Value Dissection - FV vs. CV");
		VIPCustomPage.contents.SelectDashboardAnalystReco.verifyText("Analyst Recommendations");
		VIPCustomPage.contents.SelectDashboardCommentary.verifyText("Analyst Commentary");
		VIPCustomPage.contents.SelectDashboardEstimates.verifyText("Revenue and EBIT Margin Estimates");
		VIPCustomPage.contents.SelectDashboardRGvsAS.verifyText("Revenue Growth vs. Average Spread");
		VIPCustomPage.contents.SelectDashboardRG.verifyText("Revenue Growth (1, 3, 5 years Trend)");
		VIPCustomPage.contents.SelectDashboardEPA.verifyText("Employee Productivity Analysis");
		VIPCustomPage.contents.SelectDashboardEMvsCE.verifyText("Pre-Tax ROIC Drivers - EBIT Margin vs. Capital Efficiency");
		VIPCustomPage.contents.SelectDashboardROIC.verifyText("Pre-Tax ROIC Decomposition");
		VIPCustomPage.contents.SelectDashboardOWC.verifyText("Operating Working Capital Decomposition");
		VIPCustomPage.contents.SelectDashboardCashCycle.verifyText("Cash Cycle");
		VIPCustomPage.contents.SelectDashboardBusiness.verifyText("Business Segment Analysis");
		VIPCustomPage.contents.SelectDashboardGeo.verifyText("Geographic Segment Analysis");
		VIPCustomPage.contents.SelectDashboardGlossary.verifyText("Glossary");
		VIPCustomPage.contents.SelectDashboardMeth.verifyText("Methodology");
		VIPCustomPage.contents.SelectDashboardRefCalc.verifyText("Reference Calculations");
		//UpdateSelectModules
		VIPCustomPage.contents.SelectModuleTitle.verifyText("Select Modules (optional):");
		VIPCustomPage.contents.SelectModuleAll.verifyText("Select All");
		VIPCustomPage.contents.SelectModuleCIA.verifyText("COVID-19 Impact Analysis");
		VIPCustomPage.contents.SelectModuleExecutives.verifyText("Executives");
		VIPCustomPage.contents.SelectModuleNews.verifyText("News");
		VIPCustomPage.contents.SelectModuleTranscripts.verifyText("Transcripts");
		VIPCustomPage.contents.ApplyButton.click();
		//Private //15
		Thread.sleep(3000);
		VIPCustomPage.contents.CompanyTypeDropdown.verifyDisplayed(true);
		VIPCustomPage.contents.CompanyTypeDropdown.click();
		VIPCustomPage.contents.PrivateMenu.click();
		VIPCustomPage.contents.SelectDashboardButton.click();
		Thread.sleep(3000);
		VIPCustomPage.contents.ModalTitle.verifyDisplayed(true);
		VIPCustomPage.contents.ModalTitle.verifyDisplayed(true);
		VIPCustomPage.contents.ModalTitle.verifyText("Select Dashboards:");
		VIPCustomPage.contents.SelectDashboardAll.verifyText("Select All");
		VIPCustomPage.contents.SelectDashboardScorecard.verifyText("Competitiveness Scorecard");
		VIPCustomPage.contents.SelectDashboardVCA.verifyText("Value Creation Areas");
		VIPCustomPage.contents.SelectDashboardGlassdoor.verifyText("HR Analysis - Glassdoor Benchmarking");
		VIPCustomPage.contents.SelectDashboardCommentary.verifyText("Analyst Commentary");
		VIPCustomPage.contents.SelectDashboardRGvsAS.verifyText("Revenue Growth vs. Average Spread");
		VIPCustomPage.contents.SelectDashboardRG.verifyText("Revenue Growth (1, 3, 5 years Trend)");
		VIPCustomPage.contents.SelectDashboardEPA.verifyText("Employee Productivity Analysis");
		VIPCustomPage.contents.SelectDashboardEMvsCE.verifyText("Pre-Tax ROIC Drivers - EBIT Margin vs. Capital Efficiency");
		VIPCustomPage.contents.SelectDashboardROIC.verifyText("Pre-Tax ROIC Decomposition");
		VIPCustomPage.contents.SelectDashboardOWC.verifyText("Operating Working Capital Decomposition");
		VIPCustomPage.contents.SelectDashboardCashCycle.verifyText("Cash Cycle");
		VIPCustomPage.contents.SelectDashboardBusiness.verifyText("Business Segment Analysis");
		VIPCustomPage.contents.SelectDashboardGeo.verifyText("Geographic Segment Analysis");
		VIPCustomPage.contents.SelectDashboardGlossary.verifyText("Glossary");
		VIPCustomPage.contents.SelectDashboardMeth.verifyText("Methodology");
		VIPCustomPage.contents.SelectDashboardRefCalc.verifyText("Reference Calculations");
		//UpdateSelectModules
		VIPCustomPage.contents.SelectModuleTitle.verifyText("Select Modules (optional):");
		VIPCustomPage.contents.SelectModuleAll.verifyText("Select All");
		VIPCustomPage.contents.SelectModuleCIA.verifyText("COVID-19 Impact Analysis");
		VIPCustomPage.contents.SelectModuleExecutives.verifyText("Executives");
		VIPCustomPage.contents.SelectModuleNews.verifyText("News");
		VIPCustomPage.contents.SelectModuleTranscripts.verifyText("Transcripts");
		VIPCustomPage.contents.ApplyButton.click();
		//16
		Thread.sleep(3000);
		VIPCustomPage.contents.InstructionTitle.verifyText("Upload Instructions");
		VIPCustomPage.contents.InstructionContent.verifyText("The data model filename format should be “Company name_quarter_mmm_yyyy.xlsm” e.g. Merck_Q1_Mar_2019.xlsm (Company name should match the one inside the model)");
		//17
		VIPCustomPage.contents.BackToHomeButton.verifyDisplayed(true);
		VIPCustomPage.contents.BackToHomeButton.verifyText("Back to Home");
		VIPCustomPage.contents.BackToHomeButton.click();
		VIPCustomPage.contents.DataModelUploadButton.waitForExist(true, 15);
		WebControl.takeScreenshot("CUSTOM_RT_TC_013 to 017");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_020");
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.VIPCustomHeader.waitForExist(true, 25);
		VIPCustomPage.contents.TriangleArrow.verifyDisplayed(true);
		VIPCustomPage.contents.TriangleArrowContent.verifyDisplayed(true);
		VIPCustomPage.contents.VIPLink.click();
		WebControl.waitForPageToLoad(50); 
		Thread.sleep(2000);
		WebControl.switchWithTitle("What's New!");
		WebControl.takeScreenshot("CUSTOM_RT_TC_020_ViewLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		Thread.sleep(2000);	
		WebControl.takeScreenshot("CUSTOM_RT_TC_020");

	}

	
	@Test(priority=3)
	public void CUSTOM_DataUploadPagePublic () throws Exception {
		ReportLog.setTestName("CUSTOM - Upload Data model");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_009-012,018,019");
		// Not Logged In
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.VIPCustomHeader.waitForExist(true, 25);
		VIPCustomPage.contents.DataModelUploadButton.waitForExist(true, 15);
		VIPCustomPage.contents.DataModelUploadButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.email);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.UserEIDHeader.verifyText(testDataHandler.eid);
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(false);
		Thread.sleep(5000);
		VIPCustomPage.contents.ChooseFileButton.click();
		Thread.sleep(2000);
		StringSelection ss = new StringSelection(testDataHandler.filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		VIPCustomPage.contents.UploadedFile.waitForExist(false, 10);
		String[] String = testDataHandler.filePath.split("\\\\");
		String FileName = String[String.length - 1];
		Thread.sleep(2000);
		VIPCustomPage.contents.UploadedFile.verifyText(FileName);
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(false);
		VIPCustomPage.contents.ReportTypeDropdown.verifyDisplayed(true);
		VIPCustomPage.contents.ReportTypeDropdown.click();
		VIPCustomPage.contents.CompanyTypeDropdown.verifyDisplayed(true);
		VIPCustomPage.contents.PremiumIndustrialMenu.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(false);
		VIPCustomPage.contents.CompanyTypeDropdown.click();
		VIPCustomPage.contents.PublicMenu.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(false);
		VIPCustomPage.contents.SelectDashboardButton.click();
		VIPCustomPage.contents.DashboardsCheckbox1.click();
		VIPCustomPage.contents.ApplyButton.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(true);
		VIPCustomPage.contents.SubmitButton.click();
		
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButtonModal.verifyDisplayed(true);
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButtonModalContent.verifyText("“My Last Reports”");
		VIPCustomPage.contents.SubmitButtonModalGreat.verifyText("Great!");
		VIPCustomPage.contents.SubmitButtonModalVIPLink.click();
		WebControl.waitForPageToLoad(50); 
		Thread.sleep(2000);
		WebControl.switchWithTitle("What's New!");
		WebControl.takeScreenshot("CUSTOM_RT_TC_019_ViewLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("It's done!");
		Thread.sleep(2000);	
		VIPCustomPage.contents.SubmitButtonModalGreat.click();
		VIPCustomPage.contents.ViewSampleText.verifyText("View Sample");
		
		WebControl.takeScreenshot("CUSTOM_RT_TC_009-012,018,019");

				
	}
	
	@Test(priority=2)
	public void CUSTOM_DataUploadPagePrivate () throws Exception {
		ReportLog.setTestName("CUSTOM - Upload Data model");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_009-012,018,019");
		// Not Logged In
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.VIPCustomHeader.waitForExist(true, 25);
		VIPCustomPage.contents.DataModelUploadButton.waitForExist(true, 15);
		VIPCustomPage.contents.DataModelUploadButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.email);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.UserEIDHeader.verifyText(testDataHandler.eid);
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(false);
		Thread.sleep(5000);
		VIPCustomPage.contents.ChooseFileButton.click();
		Thread.sleep(2000);
		StringSelection ss = new StringSelection(testDataHandler.filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		VIPCustomPage.contents.UploadedFile.waitForExist(false, 10);
		String[] String = testDataHandler.filePath.split("\\\\");
		String FileName = String[String.length - 1];
		Thread.sleep(2000);
		VIPCustomPage.contents.UploadedFile.verifyText(FileName);
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(false);
		VIPCustomPage.contents.ReportTypeDropdown.verifyDisplayed(true);
		VIPCustomPage.contents.ReportTypeDropdown.click();
		VIPCustomPage.contents.CompanyTypeDropdown.verifyDisplayed(true);
		VIPCustomPage.contents.PremiumIndustrialMenu.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(false);
		VIPCustomPage.contents.CompanyTypeDropdown.click();
		VIPCustomPage.contents.PrivateMenu.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(false);
		VIPCustomPage.contents.SelectDashboardButton.click();
		VIPCustomPage.contents.DashboardsCheckbox1.click();
		VIPCustomPage.contents.ApplyButton.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.verifyDisplayed(true);
		VIPCustomPage.contents.SubmitButton.click();
		
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButtonModal.verifyDisplayed(true);
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButtonModalContent.verifyDisplayed(true);
		VIPCustomPage.contents.SubmitButtonModalGreat.verifyDisplayed(true);
		Thread.sleep(2000);	
		VIPCustomPage.contents.SubmitButtonModalGreat.click();
		VIPCustomPage.contents.ViewSampleText.verifyText("View Sample");
		
		WebControl.takeScreenshot("CUSTOM_RT_TC_009-012,018,019");

				
	}

}
