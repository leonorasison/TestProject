package scenarios.WEB;

import org.testng.annotations.Test;
import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPExecutivesPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPLogInPage;
import pageobjects.VIPNewsPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPTranscriptPage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class WEBFunctionality_All_Old extends TestBase{
	
	@Test(priority=1)
	public void WEBFunctionality_Landing () throws Exception {
		ReportLog.setTestName("WEB Functionality - Landing");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_001");
		VIP_Common.LogInPage(testDataHandler);
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_001");
		
		ReportLog.setTestCase("WEB_Reg_Auto_002");
		VIPLandingPage.contents.OldWebsiteButton.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_002");
		
		ReportLog.setTestCase("WEB_Reg_Auto_003");
		VIPLandingPage.contents.HelpText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.HelpText.verifyText("Help");
		WebControl.takeScreenshot("WEB_Reg_Auto_003");
		
		ReportLog.setTestCase("WEB_Reg_Auto_004");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.HelpTooltip.verifyDisplayed(true, 5);
		VIPLandingPage.contents.HelpTooltip.verifyText("Get VIP tutorials and support contact");
		WebControl.takeScreenshot("WEB_Reg_Auto_004");
		
		ReportLog.setTestCase("WEB_Reg_Auto_005");
		VIPLandingPage.contents.HelpIcon.click();
		VIPLandingPage.contents.HelpMenu.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_005");
		
		ReportLog.setTestCase("WEB_Reg_Auto_006");
		VIPLandingPage.contents.EmailUsHeader.verifyDisplayed(true, 5);
		VIPLandingPage.contents.EmailUsHeader.verifyText("Email us");
		WebControl.takeScreenshot("WEB_Reg_Auto_006");
		
		ReportLog.setTestCase("WEB_Reg_Auto_007");
		VIPLandingPage.contents.FAQHeader.click();
		Thread.sleep(2500);
		WebControl.switchWithUrl(testDataHandler.faqKXSite);
		WebControl.takeScreenshot("WEB_Reg_Auto_007");
		
		ReportLog.setTestCase("WEB_Reg_Auto_008");
		WebControl.switchWithTitle("Value Insights Platform");
		VIPLandingPage.contents.GiveUsFeedback.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		WebControl.switchWithTitle("Quick Survey - Value Insights Platform User Feedback");
		WebControl.takeScreenshot("WEB_Reg_Auto_008");
		
		ReportLog.setTestCase("WEB_Reg_Auto_009");
		WebControl.openNew(testDataHandler.site);
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		WebControl.switchWithTitle("Value Insights Platform");
		VIPLandingPage.contents.UserPhoto.verifyDisplayed(true, 10);
		VIPLandingPage.contents.UserEID.verifyDisplayed(true, 10);
		VIPLandingPage.contents.UserEID.verifyText(testDataHandler.eid);
		WebControl.takeScreenshot("WEB_Reg_Auto_009");
		
		ReportLog.setTestCase("WEB_Reg_Auto_010");
		VIPLandingPage.contents.WhatIsVIP.verifyText(testDataHandler.description);
		WebControl.takeScreenshot("WEB_Reg_Auto_010");
		
		ReportLog.setTestCase("WEB_Reg_Auto_011");
		if (testDataHandler.SignedInUser.equals("Yes")) {
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ContactCVSTeamButton.verifyDisplayed(true, 10);}
		if (testDataHandler.SignedInUser.equals("No")) {
		VIPLandingPage.contents.RequestAccessButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ContactCVSTeamButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.MyLastReports.verifyDisplayed(false);
		VIPLandingPage.contents.SavedCompaniesHeader.verifyDisplayed(false);
		VIPLandingPage.contents.LatestNewsHeader.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_011");
		
		ReportLog.setTestCase("WEB_Reg_Auto_012");
		VIPLandingPage.contents.MyLastReports.hover();
		VIPLandingPage.contents.MyLastReports.verifyText("My Last Reports");
		WebControl.takeScreenshot("WEB_Reg_Auto_012");
		
		ReportLog.setTestCase("WEB_Reg_Auto_013");
		VIPLandingPage.contents.DisclaimerIcon.verifyDisplayed(true, 10);
		Thread.sleep(1500);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.DisclaimerIcon.hover();
		VIPLandingPage.contents.DisclaimerTooltip.verifyText(testDataHandler.disclaimerTooltip);
		WebControl.takeScreenshot("WEB_Reg_Auto_013");
		
		ReportLog.setTestCase("WEB_Reg_Auto_014");
		VIPLandingPage.contents.SelfServiceSubTitle.verifyDisplayed(true, 10);
		VIPLandingPage.contents.SelfServiceSubTitle.verifyText("Targeted for internal discussions");
		VIPLandingPage.contents.SelfServiceBullet1.verifyDisplayed(true, 10);
		VIPLandingPage.contents.SelfServiceBullet1.verifyText("75+ Financial KPIs");
		VIPLandingPage.contents.SelfServiceBullet2.verifyDisplayed(true, 10);
		VIPLandingPage.contents.SelfServiceBullet2.verifyText("25+ Dashboards");
		VIPLandingPage.contents.SelfServiceBullet3.verifyDisplayed(true, 10);
		VIPLandingPage.contents.SelfServiceBullet3.verifyText("Data sourced from Capital IQ and Factiva");
		WebControl.takeScreenshot("WEB_Reg_Auto_014");
		
		ReportLog.setTestCase("WEB_Reg_Auto_015");
		VIPLandingPage.contents.CustomTitle.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CustomTitle.verifyText("Custom");
		VIPLandingPage.contents.CustomSubTitle.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CustomSubTitle.verifyText("Suitable for client meetings");
		VIPLandingPage.contents.CustomBullet1.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CustomBullet1.verifyText("100+ Financial KPIs");
		VIPLandingPage.contents.CustomBullet2.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CustomBullet2.verifyText("35+ Dashboards");
		VIPLandingPage.contents.CustomBullet3.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CustomBullet3.verifyText("Data gathered from multiple sources\n" + "(Company Filings, Capital IQ, Bloomberg, Analyst reports, Glassdoor and Factiva)");
		WebControl.takeScreenshot("WEB_Reg_Auto_015");
		
		ReportLog.setTestCase("WEB_Reg_Auto_016_&_017");
		VIPLandingPage.contents.ClientFocusAccordionTitle.verifyText("CLIENT FOCUS");
		VIPLandingPage.contents.ClientFocusAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.ClientFocus1.verifyText("Suitable for internal meetings");
		VIPLandingPage.contents.ClientFocus2.verifyText("Suitable for client meetings");
		VIPLandingPage.contents.ClientFocus3.verifyText("Value creation ideas for client");
		VIPLandingPage.contents.ClientFocus1SS.verifyDisplayed(true);
		VIPLandingPage.contents.ClientFocus2SS.verifyDisplayed(true);
		VIPLandingPage.contents.ClientFocus3SS.verifyDisplayed(true);
		VIPLandingPage.contents.ClientFocus1CS.verifyDisplayed(true);
		VIPLandingPage.contents.ClientFocus2CS.verifyDisplayed(true);
		VIPLandingPage.contents.ClientFocus3CS.verifyDisplayed(true);
		WebControl.takeScreenshot("WEB_Reg_Auto_016_1");
		VIPLandingPage.contents.ClientFocusAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.AttributesAccordionTitle.verifyText("ATTRIBUTES");
		VIPLandingPage.contents.AttributesAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.Attributes1.verifyText("No. of dashboards");
		VIPLandingPage.contents.Attributes2.verifyText("No. of peers");
		VIPLandingPage.contents.Attributes3.verifyText("Period of analysis");
		VIPLandingPage.contents.Attributes4.verifyText("Standard analysis (e.g. Total Return to Shareholders, Analyst Estimates, ROIC)");
		VIPLandingPage.contents.Attributes5.verifyText("Advanced analysis (e.g. Value Creation Areas, Current and Future Value, Strategy Control Maps)");
		VIPLandingPage.contents.Attributes6.verifyText("Industry operating metrics");
		VIPLandingPage.contents.Attributes1SS.verifyText("25+");
		VIPLandingPage.contents.Attributes1CS.verifyText("35+");
		VIPLandingPage.contents.Attributes2SS.verifyText("Up to 25");
		VIPLandingPage.contents.Attributes2CS.verifyText("Up to 25");
		VIPLandingPage.contents.Attributes3SS.verifyText("Up to 3 Years");
		VIPLandingPage.contents.Attributes3CS.verifyText("Up to 5 Years");
		VIPLandingPage.contents.Attributes4SS.verifyDisplayed(true);
		VIPLandingPage.contents.Attributes4CS.verifyDisplayed(true);
		VIPLandingPage.contents.Attributes5SS.verifyDisplayed(true);
		VIPLandingPage.contents.Attributes5CS.verifyDisplayed(true);
		WebControl.takeScreenshot("WEB_Reg_Auto_016_2");
		VIPLandingPage.contents.Attributes6SS.verifyText("Available for Telecom, CG&S and Retail Industries");
		VIPLandingPage.contents.Attributes6CS.verifyText("Available for All Industries");
		WebControl.takeScreenshot("WEB_Reg_Auto_017");
		
		ReportLog.setTestCase("WEB_Reg_Auto_018_to_20");
		VIPLandingPage.contents.AttributesAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.FinancialAnalysisAccordionTitle.verifyText("FINANCIAL ANALYSIS");
		VIPLandingPage.contents.FinancialAnalysisAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.FinancialAnalysisSubAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.FinancialAnalysis1.verifyText("Operating Lease adjustment");
		VIPLandingPage.contents.FinancialAnalysis2.verifyText("Pension adjustment");
		VIPLandingPage.contents.FinancialAnalysis3.verifyText("Normalization of Financials");
		VIPLandingPage.contents.FinancialAnalysis4.verifyText("Restatements");
		VIPLandingPage.contents.FinancialAnalysis5.verifyText("Adjusted for Finance Division");
		VIPLandingPage.contents.FinancialAnalysis1SS.verifyText("All Industries");
		VIPLandingPage.contents.FinancialAnalysis1CS.verifyText("Customizable");
		VIPLandingPage.contents.FinancialAnalysis2SS.verifyText("All Industries");
		VIPLandingPage.contents.FinancialAnalysis2CS.verifyText("Customizable");
		VIPLandingPage.contents.FinancialAnalysis4SS.verifyDisplayed(true);
		VIPLandingPage.contents.FinancialAnalysis4CS.verifyDisplayed(true);
		VIPLandingPage.contents.FinancialAnalysis5SS.verifyDisplayed(true);
		VIPLandingPage.contents.FinancialAnalysis5CS.verifyDisplayed(true);
		VIPLandingPage.contents.OperatingLeaseAdjustmentIcon.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_018");
		VIPLandingPage.contents.RestatementsIcon.verifyDisplayed(true, 10);
		VIPLandingPage.contents.RestatementsIcon.hover();
		VIPLandingPage.contents.RestatementsTooltip.verifyText(testDataHandler.restatementTooltip);
		WebControl.takeScreenshot("WEB_Reg_Auto_019");
		VIPLandingPage.contents.AdjustedForFinanceDivisionIcon.verifyDisplayed(true, 10);
		VIPLandingPage.contents.AdjustedForFinanceDivisionIcon.hover();
		VIPLandingPage.contents.AdjustedForFinanceDivisionTooltip.verifyText(testDataHandler.affdTooltip);
		WebControl.takeScreenshot("WEB_Reg_Auto_020_1");
		VIPLandingPage.contents.FinancialAnalysisAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.TechnicalFeaturesAccordionTitle.verifyText("TECHNICAL FEATURES");
		VIPLandingPage.contents.TechnicalFeaturesAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.TechnicalFeatures1.verifyText("Interactivity in dashboards");
		VIPLandingPage.contents.TechnicalFeatures2.verifyText("Report Shareability");
		VIPLandingPage.contents.TechnicalFeatures3.verifyText("Custom dashboard preparation");
		VIPLandingPage.contents.TechnicalFeatures1SS.verifyDisplayed(true);
		VIPLandingPage.contents.TechnicalFeatures1CS.verifyDisplayed(true);
		VIPLandingPage.contents.TechnicalFeatures2SS.verifyDisplayed(true);
		VIPLandingPage.contents.TechnicalFeatures2CS.verifyDisplayed(true);
		VIPLandingPage.contents.TechnicalFeatures3SS.verifyDisplayed(true);
		VIPLandingPage.contents.TechnicalFeatures3CS.verifyDisplayed(true);
		WebControl.takeScreenshot("WEB_Reg_Auto_020_2");
		
		ReportLog.setTestCase("WEB_Reg_Auto_021_to_025");
		VIPLandingPage.contents.TechnicalFeaturesAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.AccessibilityAccordionTitle.verifyText("ACCESSIBILITY");
		VIPLandingPage.contents.AccessibilityAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.AccessibilitySubAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.Accessibility1.verifyText("Desktop Browser");
		VIPLandingPage.contents.Accessibility2.verifyText("Downloadable Content");
		VIPLandingPage.contents.Accessibility3.verifyText("PowerPoint");
		VIPLandingPage.contents.Accessibility4.verifyText("Excel");
		VIPLandingPage.contents.Accessibility5.verifyDisplayed(false);
		VIPLandingPage.contents.Accessibility1SS.verifyDisplayed(true);
		VIPLandingPage.contents.Accessibility1CS.verifyDisplayed(true);
		VIPLandingPage.contents.Accessibility3SS.verifyDisplayed(true);
		VIPLandingPage.contents.Accessibility3CS.verifyDisplayed(true);
		VIPLandingPage.contents.Accessibility4SS.verifyDisplayed(true);
		VIPLandingPage.contents.Accessibility4CS.verifyDisplayed(true);
		VIPLandingPage.contents.Accessibility5SS.verifyDisplayed(false);
		VIPLandingPage.contents.Accessibility5CS.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_021_1");
		VIPLandingPage.contents.AccessibilityIcon.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_021_2");
		VIPLandingPage.contents.AccessibilityMobileBrowser.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_022");
		VIPLandingPage.contents.AccessibilityQlikWorkbook.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_023");
		VIPLandingPage.contents.AccessibilityMobileApplication.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_024");
		VIPLandingPage.contents.Accessibility4SS.verifyDisplayed(true);
		WebControl.takeScreenshot("WEB_Reg_Auto_025");
		
		ReportLog.setTestCase("WEB_Reg_Auto_026_&_027");
		VIPLandingPage.contents.AccessibilityAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.DataSourceAccordionTitle.verifyText("DATA SOURCE");
		VIPLandingPage.contents.DataSourceAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.DataSource1.verifyText("S&P Capital IQ");
		VIPLandingPage.contents.DataSource2.verifyText("Dow Jones Factiva");
		VIPLandingPage.contents.DataSource3.verifyText("Bloomberg");
		VIPLandingPage.contents.DataSource4.verifyText("Annual/Quarterly Reports");
		VIPLandingPage.contents.DataSource5.verifyText("Glassdoor");
		VIPLandingPage.contents.DataSource6.verifyText("Equity research");
		VIPLandingPage.contents.DataSource7.verifyText("Analysys Mason");
		VIPLandingPage.contents.DataSource8.verifyText("Global Data");
		VIPLandingPage.contents.DataSource1C1.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource1C2.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource2C1.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource2C2.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource3C1.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource3C2.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource4C1.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource4C2.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource5C1.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource5C2.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource6C1.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource6C2.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource7C1.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource7C2.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource8C1.verifyDisplayed(true);
		VIPLandingPage.contents.DataSource8C2.verifyDisplayed(true);
		WebControl.takeScreenshot("WEB_Reg_Auto_026_&_027");
		
		ReportLog.setTestCase("WEB_Reg_Auto_028");
		VIPLandingPage.contents.DataSourceAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.SupportAccordionTitle.verifyText("SUPPORT");
		VIPLandingPage.contents.SupportAccordion.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.Support1.verifyText("Client Value Services Team");
		VIPLandingPage.contents.Support2.verifyText("Technical Team");
		VIPLandingPage.contents.Support1C1.verifyDisplayed(true);
		VIPLandingPage.contents.Support1C2.verifyDisplayed(true);
		VIPLandingPage.contents.Support2C1.verifyDisplayed(true);
		VIPLandingPage.contents.Support2C2.verifyDisplayed(true);
		VIPLandingPage.contents.ViewSampleText.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_028");
		
		ReportLog.setTestCase("WEB_Reg_Auto_029");
		VIPLandingPage.contents.MyLastReportsTag.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_029");
		
		ReportLog.setTestCase("WEB_Reg_Auto_030");
		VIPLandingPage.contents.CVSContactsLabel.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CVSContactsLabel.verifyText("Client Value Services Contacts");
		VIPLandingPage.contents.CVSContact1.verifyText("David Pugmire");
		VIPLandingPage.contents.CVSContact2.verifyText("Wolfgang Popp");
		VIPLandingPage.contents.CVSContact3.verifyText("Rhett Brokenshire");
		VIPLandingPage.contents.CVSContact4.verifyText("Rachael Ulizio");
		VIPLandingPage.contents.CVSContact5.verifyText("Rohit Malhotra");
		WebControl.takeScreenshot("WEB_Reg_Auto_030");
		
		ReportLog.setTestCase("WEB_Reg_Auto_031");
		VIPLandingPage.contents.CVSContact4Position.verifyText("Value Program Director");
		WebControl.takeScreenshot("WEB_Reg_Auto_031");
		
		ReportLog.setTestCase("WEB_Reg_Auto_032");
		VIPLandingPage.contents.HelpIcon.hover();
		if (VIPLandingPage.contents.RefreshButton.isDisplayed()) {
		VIPLandingPage.contents.RefreshButton.hover();
		VIPLandingPage.contents.RefreshButtonTooltip.verifyText("Refresh");}
		else {VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		else { VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.EnterpriseValue.waitForExist(true, 60);
		VIPOverviewPage.contents.RBBPieChartTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.GenerateFinancialReportButton.verifyDisplayed(true, 15);
		VIPOverviewPage.contents.GenerateFinancialReportButton.hover();
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		WebControl.navigateTo(testDataHandler.site);
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 100);
		VIPLandingPage.contents.RefreshButton.hover();
		VIPLandingPage.contents.RefreshButtonTooltip.verifyText("Refresh");}
		WebControl.takeScreenshot("WEB_Reg_Auto_032");
		
		ReportLog.setTestCase("WEB_Reg_Auto_033");
		VIPLandingPage.contents.ViewReportButton.hover();
		VIPLandingPage.contents.ViewReportButtonTooltip.verifyText("Download PPT");
		WebControl.takeScreenshot("WEB_Reg_Auto_033");
		
		ReportLog.setTestCase("WEB_Reg_Auto_034_to_036");
		VIPLandingPage.contents.ShareButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ShareButton.hover();
		VIPLandingPage.contents.ShareButtonTooltip.verifyText("Share");
		WebControl.takeScreenshot("WEB_Reg_Auto_034_to_036");
		
		ReportLog.setTestCase("WEB_Reg_Auto_037");
		VIPLandingPage.contents.SavedCompaniesEditIcon.hover();
		VIPLandingPage.contents.OverviewButton.hover();
		VIPLandingPage.contents.OverviewButtonTooltip.verifyText("Overview");
		WebControl.takeScreenshot("WEB_Reg_Auto_037");
		
		ReportLog.setTestCase("WEB_Reg_Auto_038");
		String CompanyName = VIPLandingPage.contents.CompanyCardName.getText();
		VIPLandingPage.contents.SavedCompaniesEditIcon.hover();
		VIPLandingPage.contents.OverviewButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
		VIPOverviewPage.contents.CompanyName.verifyText(CompanyName);
		WebControl.takeScreenshot("WEB_Reg_Auto_038");
		
		ReportLog.setTestCase("WEB_Reg_Auto_039");
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyCardName.waitForExist(true, 60);
		String CompanyName_CR = VIPLandingPage.contents.CompanyCardName.getText();
		String RequestDate1 = VIPLandingPage.contents.CompanyCardDate.getText();
		DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy"); 
		Date RequestDate2 = (Date)formatter.parse(RequestDate1);
		SimpleDateFormat newFormat = new SimpleDateFormat("dd MMM yyyy");
		String RequestDate = newFormat.format(RequestDate2);
		String s1 = VIPLandingPage.contents.ReportsTotal.getText();
		String s2 = s1.replace("/ ", "");
		int s3 = Integer.parseInt(s2);
		int s4 = s3 + 1;
		String s5 = Integer.toString(s4);
		String s6 = "/ " + s5;
		VIPLandingPage.contents.ShareButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.ShareModalHeader.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ShareModalHeader.verifyText("Share Report");
		VIPLandingPage.contents.ShareModalCompany.verifyText(CompanyName_CR);
		VIPLandingPage.contents.ShareModalDate.verifyText("Request Date:");
		VIPLandingPage.contents.ShareModalDateValue.verifyText(RequestDate);
		VIPLandingPage.contents.ShareModalEmail.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ShareModalShareButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ShareModalCancelButton.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_039");
		
		ReportLog.setTestCase("WEB_Reg_Auto_043");
		VIPLandingPage.contents.ShareModalEmail.sendKeys(testDataHandler.email);
		VIPLandingPage.contents.ShareModalShareButton.click();
		Thread.sleep(2000);
		WebControl.navigateTo(testDataHandler.site);
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);
		Thread.sleep(3000);
		if (!VIPLandingPage.contents.ReportsTotal.equals(s6)) {
		WebControl.navigateTo(testDataHandler.site);
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);
		Thread.sleep(3000);}
		VIPLandingPage.contents.ReportsTotal.verifyText(s6);
		VIPLandingPage.contents.CompanyCardName.verifyText(CompanyName_CR);
		VIPLandingPage.contents.CompanyCardDate.verifyText(RequestDate1);
		WebControl.takeScreenshot("WEB_Reg_Auto_043");
		
		ReportLog.setTestCase("WEB_Reg_Auto_044");
		VIPLandingPage.contents.NextButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.PrevButton.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_044");
		
		ReportLog.setTestCase("WEB_Reg_Auto_045");
		String Total1 = VIPLandingPage.contents.ReportsTotal.getText();
		String Total2 = Total1.replace("/ ", "");
		int Total = Integer.parseInt(Total2);
		if (Total > 4) {
		VIPLandingPage.contents.CompanyCard1.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyCard2.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyCard3.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyCard4.verifyDisplayed(true, 10);
		String current1 = VIPLandingPage.contents.ReportsCurrent.getText();
		int current2 = Integer.parseInt(current1);
		int current3 = current2 + 4;
		String current = Integer.toString(current3);
		VIPLandingPage.contents.NextButton.click();
		VIPLandingPage.contents.ReportsCurrent.verifyText(current);
		VIPLandingPage.contents.PrevButton.click();}
		else { String current = VIPLandingPage.contents.ReportsCurrent.getText();
		VIPLandingPage.contents.NextButton.click();
		VIPLandingPage.contents.ReportsCurrent.verifyText(current);}
		WebControl.takeScreenshot("WEB_Reg_Auto_045");
		
		ReportLog.setTestCase("WEB_Reg_Auto_048");
		String oldReportDate1 = "Aug 24, 2020";
		DateFormat formatter3 = new SimpleDateFormat("MMM dd, yyyy"); 
		Date oldReportDate = (Date)formatter3.parse(oldReportDate1);
		String Dates1 = VIPLandingPage.contents.CompanyCardDate1.getText();
		Date Date1 = (Date)formatter3.parse(Dates1);
		
		if (Date1.after(oldReportDate)) 
		{
			VIPLandingPage.contents.ShareButton.verifyDisplayed(true);
			VIPLandingPage.contents.DownloadPPTButton.verifyDisplayed(true);
			VIPLandingPage.contents.RefreshButton.verifyDisplayed(true);
		}
		else
		{
			VIPLandingPage.contents.ShareButton.verifyDisplayed(false);
			VIPLandingPage.contents.DownloadPPTButton.verifyDisplayed(false);
			VIPLandingPage.contents.RefreshButton.verifyDisplayed(true);
		}
		
		WebControl.takeScreenshot("WEB_Reg_Auto_048");
		
		ReportLog.setTestCase("WEB_Reg_Auto_049");
		String CompanyName_023 = VIPLandingPage.contents.CompanyCardName.getText();
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat DateFor2 = new SimpleDateFormat("MMM dd, yyyy");
		String DateToday = DateFor.format(date);
		String DateToday2 = DateFor2.format(date);
		VIPLandingPage.contents.RefreshButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.RefreshModalHeader.verifyDisplayed();
		VIPLandingPage.contents.RefreshModalHeader.verifyText("Refresh this Report?");
		VIPLandingPage.contents.RefreshModalCompany.verifyText(CompanyName_023);
		VIPLandingPage.contents.RefreshModalDate.verifyText("Request Date");
		VIPLandingPage.contents.RefreshModalDateValue.verifyText(DateToday);
		WebControl.takeScreenshot("WEB_Reg_Auto_049");
		
		ReportLog.setTestCase("WEB_Reg_Auto_050");
		VIPLandingPage.contents.RefreshModalClose.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.RefreshModalHeader.verifyDisplayed(false);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_050");
		
//		ReportLog.setTestCase("WEB_Reg_Auto_051_052");
//		String CompanyName_025_026 = VIPLandingPage.contents.CompanyCardName.getText();
//		String ReportsTotal = VIPLandingPage.contents.ReportsTotal.getText();
//		VIPLandingPage.contents.RefreshButton.click();
//		Thread.sleep(2000);
//		VIPLandingPage.contents.RefreshCloseButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
//		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
//		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
//		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 60);
//		VIPOverviewPage.contents.CompanyName.verifyText(CompanyName_025_026);
//		WebControl.takeScreenshot("WEB_Reg_Auto_050");
//		VIPOverviewPage.contents.BackToSearchButton.click();
//		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
//		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
//		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
//		VIPLandingPage.contents.ReportsTotal.verifyDisplayed(true, 60);
//		VIPLandingPage.contents.ReportsTotal.verifyText(ReportsTotal,false);
//		VIPLandingPage.contents.CompanyCardName.verifyText(CompanyName_025_026);
//		VIPLandingPage.contents.CompanyCardDate.verifyText(DateToday2);
//		WebControl.takeScreenshot("WEB_Reg_Auto_051_052");
		
		ReportLog.setTestCase("WEB_Reg_Auto_053");
		VIPLandingPage.contents.DownloadPPTButton.click();
		Thread.sleep(7000);
		VIP_Common.isFileDownloaded2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
		VIP_Common.isFileDeleted2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
		WebControl.takeScreenshot("WEB_Reg_Auto_053");
		
//		ReportLog.setTestCase("WEB_Reg_Auto_062");
//		String CompanyCardName2 = VIPLandingPage.contents.CompanyCardName2.getText();
//		String ReportsTotal_062_1 = VIPLandingPage.contents.ReportsTotal.getText();
//		String ReportsTotal_062_2 = ReportsTotal_062_1.replace("/ ", "");
//		int ReportsTotal_062_3 = Integer.parseInt(ReportsTotal_062_2);
//		int ReportsTotal_062_4 = ReportsTotal_062_3 + 1;
//		String ReportsTotal_062_5 = Integer.toString(ReportsTotal_062_4);
//		String ReportsTotal_062 = "/ " + ReportsTotal_062_5;
//		VIPLandingPage.contents.OverviewButton.click();
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.SideMenuCompetitor.click();
//		VIPCompetitorPage.contents.RefineCriteriaButton.click();
//		VIPCompetitorPage.contents.TopFilterDropdown.click();
//		VIPCompetitorPage.contents.TopFilterChoice25.click();
//		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
//		VIPLandingPage.contents.HelpIcon.waitForExist(true, 45);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 45);
//		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.DownloadReportSaveButton.waitForExist(true, 5);
//		VIPOverviewPage.contents.DownloadReportSaveButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
//		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
//		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
//		Thread.sleep(5000);
//		VIP_Common.isFileDownloaded2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
//		VIP_Common.isFileDeleted2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
//		WebControl.navigateTo(testDataHandler.site);
//		Thread.sleep(2500);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2500);
//		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);
//		if (!VIPLandingPage.contents.ReportsTotal.equals(ReportsTotal_062));{
//		WebControl.navigateTo(testDataHandler.site);
//		Thread.sleep(2500);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2500);
//		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);}
//		if (!VIPLandingPage.contents.ReportsTotal.equals(ReportsTotal_062));{
//		WebControl.navigateTo(testDataHandler.site);
//		Thread.sleep(2500);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2500);
//		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);}
//		VIPLandingPage.contents.ReportsTotal.verifyText(ReportsTotal_062);
//		VIPLandingPage.contents.CompanyCardName.verifyText(CompanyCardName2);
//		VIPLandingPage.contents.CompanyCardDate.verifyText(DateToday2);
//		WebControl.takeScreenshot("WEB_Reg_Auto_062");
//		
//		ReportLog.setTestCase("WEB_Reg_Auto_063");
//		String CompanyCardName = VIPLandingPage.contents.CompanyCardName.getText();
//		String ReportsTotal_063_1 = VIPLandingPage.contents.ReportsTotal.getText();
//		String ReportsTotal_063_2 = ReportsTotal_063_1.replace("/ ", "");
//		int ReportsTotal_063_3 = Integer.parseInt(ReportsTotal_063_2);
//		int ReportsTotal_063_4 = ReportsTotal_063_3 + 1;
//		String ReportsTotal_063_5 = Integer.toString(ReportsTotal_063_4);
//		String ReportsTotal_063 = "/ " + ReportsTotal_063_5;
//		VIPLandingPage.contents.OverviewButton.click();
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.SideMenuCompetitor.click();
//		VIPCompetitorPage.contents.RefineCriteriaButton.click();
//		VIPCompetitorPage.contents.TopFilterDropdown.click();
//		VIPCompetitorPage.contents.TopFilterChoice25.click();
//		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
//		VIPLandingPage.contents.HelpIcon.waitForExist(true, 45);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 45);
//		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.DownloadReportSaveButton.waitForExist(true, 5);
//		VIPOverviewPage.contents.DownloadReportSaveButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
//		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
//		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
//		Thread.sleep(5000);
//		VIP_Common.isFileDownloaded2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
//		VIP_Common.isFileDeleted2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
//		WebControl.navigateTo(testDataHandler.site);
//		Thread.sleep(2500);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2500);
//		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);
//		if (!VIPLandingPage.contents.ReportsTotal.equals(ReportsTotal_063));{
//		WebControl.navigateTo(testDataHandler.site);
//		Thread.sleep(2500);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2500);
//		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);}
//		if (!VIPLandingPage.contents.ReportsTotal.equals(ReportsTotal_063));{
//		WebControl.navigateTo(testDataHandler.site);
//		Thread.sleep(2500);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2500);
//		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);}
//		VIPLandingPage.contents.ReportsTotal.verifyText(ReportsTotal_063);
//		VIPLandingPage.contents.CompanyCardName.verifyText(CompanyCardName);
//		VIPLandingPage.contents.CompanyCardDate.verifyText(DateToday2);
//		WebControl.takeScreenshot("WEB_Reg_Auto_063");
		
		ReportLog.setTestCase("WEB_Reg_Auto_064");
		if (VIPLandingPage.contents.FirstSavedComp.isDisplayed()) {
		do { VIPLandingPage.contents.SavedCompaniesEditIcon.click();
			 Thread.sleep(2000);
			if (VIPLandingPage.contents.DeleteButton.isDisplayed()) {
				VIPLandingPage.contents.DeleteButton.click();}
			else {VIPLandingPage.contents.DeleteButton1.click();}
		} while (VIPLandingPage.contents.FirstSavedComp.isDisplayed());}
		VIPLandingPage.contents.SavedCompaniesEditIcon.click();
		VIPLandingPage.contents.SavedCompaniesSearchBox.click();
		VIPLandingPage.contents.SavedCompaniesSearchBox.sendKeys("Pfi");
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_064");
		
		ReportLog.setTestCase("WEB_Reg_Auto_065");
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(2500);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2500);
		if (VIPLandingPage.contents.AddButton.isDisplayed()) {
		VIPLandingPage.contents.AddButton.click();}
		else {VIPLandingPage.contents.AddButton1.click();}
		Thread.sleep(3000);
		VIPLandingPage.contents.NewsList.verifyDisplayed(true, 30);
		WebControl.takeScreenshot("WEB_Reg_Auto_065");
		
		ReportLog.setTestCase("WEB_Reg_Auto_066");
		VIPLandingPage.contents.CompanyNameColumn.verifyDisplayed();
		VIPLandingPage.contents.CompanyNameColumn.verifyText("COMPANY NAME");
		VIPLandingPage.contents.IndustryColumn.verifyDisplayed();
		VIPLandingPage.contents.IndustryColumn.verifyText("INDUSTRY");
		VIPLandingPage.contents.LocationColumn.verifyDisplayed();
		VIPLandingPage.contents.LocationColumn.verifyText("LOCATION");
		WebControl.takeScreenshot("WEB_Reg_Auto_066");
		
		ReportLog.setTestCase("WEB_Reg_Auto_067");
		VIPLandingPage.contents.SavedCompaniesEditIcon.click(); 
		Thread.sleep(1500);
		if (VIPLandingPage.contents.DeleteButton.isDisplayed()) {
		VIPLandingPage.contents.DeleteButton.verifyDisplayed(true, 3);}
		else {VIPLandingPage.contents.DeleteButton1.verifyDisplayed(true, 3);}
		WebControl.takeScreenshot("WEB_Reg_Auto_067");
		
		ReportLog.setTestCase("WEB_Reg_Auto_068");
		if (VIPLandingPage.contents.DeleteButton.isDisplayed()) {
		VIPLandingPage.contents.DeleteButton.click();}
		else {VIPLandingPage.contents.DeleteButton1.click();}
		Thread.sleep(2000);
		VIPLandingPage.contents.FirstSavedComp.verifyDisplayed(false);
		VIPLandingPage.contents.NewsList.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_068");
		
		ReportLog.setTestCase("WEB_Reg_Auto_072_&_073");
		if (VIPLandingPage.contents.FirstSavedComp.isDisplayed()) {
		do { VIPLandingPage.contents.SavedCompaniesEditIcon.click();
		VIPLandingPage.contents.DeleteButton.click();	
		} while (VIPLandingPage.contents.FirstSavedComp.isDisplayed());}
		VIPLandingPage.contents.SavedCompaniesEditIcon.click();
		VIPLandingPage.contents.SavedCompaniesSearchBox.click();
		VIPLandingPage.contents.SavedCompaniesSearchBox.sendKeys("Pfizer");
		Thread.sleep(4000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(3000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		if (VIPLandingPage.contents.AddButton.isDisplayed()) {
		VIPLandingPage.contents.AddButton.click();}
		else {VIPLandingPage.contents.AddButton1.click();}
		Thread.sleep(3000);
		VIPLandingPage.contents.NewsList.verifyDisplayed(true, 60);
		//String company = testDataHandler.company.replace(".", "");
		VIPLandingPage.contents.NewsListCompanyName.verifyText("Pfizer Inc");
		WebControl.takeScreenshot("WEB_Reg_Auto_072_&_073");
		
		ReportLog.setTestCase("WEB_Reg_Auto_076");
		Thread.sleep(2000);
		VIPLandingPage.contents.StartNowButton.click();
		Thread.sleep(2000);
		if (testDataHandler.ShowCVS.equals("Yes")) {
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);}
		else {VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_076");
		
		ReportLog.setTestCase("WEB_Reg_Auto_077");
		if (testDataHandler.ShowCVS.equals("Yes")) {
		VIPLandingPage.contents.DisclaimerText.verifyText(testDataHandler.CVSDisclaimer);}
		else {VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_077");
		
		ReportLog.setTestCase("WEB_Reg_Auto_078");
		if (testDataHandler.ShowCVS.equals("Yes")) {
		VIPLandingPage.contents.DontShowThisCheckbox.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DontShowThisText.verifyText("Don’t show this message again");}
		else {VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_078");
		
		ReportLog.setTestCase("WEB_Reg_Auto_079");
		if (testDataHandler.ShowCVS.equals("Yes")) {
		VIPLandingPage.contents.DisclaimerModalCloseButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(true, 5);}
		else {VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_079");
	
		ReportLog.setTestCase("WEB_Reg_Auto_080_&_081");
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		VIPLandingPage.contents.StartNowButton.click();
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false);}
		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		VIPLandingPage.contents.StartNowButton.click();
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDontShowThisText.verifyText("Do not show this message again");
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		VIPLandingPage.contents.StartNowButton.click();
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("No"))) {
		VIPLandingPage.contents.StartNowButton.click();
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(false);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_080_&_081");
	
	}
	
	@Test(priority=2)
	public void WEBFunctionality_Search () throws Exception {
		ReportLog.setTestName("WEB Functionality - Search");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_082");	
		VIPLandingPage.contents.CompanyAnalysisTab.verifyDisplayed(false);
		VIPLandingPage.contents.VCMTab.verifyDisplayed(false);
		VIPLandingPage.contents.SearchButton1.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_082");
		
		ReportLog.setTestCase("WEB_Reg_Auto_083");
		if (VIPLandingPage.contents.MyLastReports2.isDisplayed()) {
		VIPLandingPage.contents.MyLastReports2.verifyDisplayed(true, 10);
		VIPLandingPage.contents.MyLastReports2.verifyText("My Last Reports");}
		else {VIPLandingPage.contents.MyLastReports.verifyDisplayed(true, 10);
		VIPLandingPage.contents.MyLastReports.verifyText("My Last Reports");}
		WebControl.takeScreenshot("WEB_Reg_Auto_083");
		
		ReportLog.setTestCase("WEB_Reg_Auto_084");
//		WebControl.switchWithTitle("Value Insights Platform");
		Thread.sleep(1000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Nestlé");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		WebControl.takeScreenshot("WEB_Reg_Auto_084");
		
		ReportLog.setTestCase("WEB_Reg_Auto_085");
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("NYSE:PFE");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 15);
		Thread.sleep(1000);
		WebControl.takeScreenshot("WEB_Reg_Auto_085");
		
		ReportLog.setTestCase("WEB_Reg_Auto_086");
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfi");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 5);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		WebControl.takeScreenshot("WEB_Reg_Auto_086");
		
		ReportLog.setTestCase("WEB_Reg_Auto_087");
		String Rev1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String[] Rev2 = Rev1.split("\\|");
		String Rev = Rev2[Rev2.length - 1];
		VIPLandingPage.contents.CompanyTypeAhead.verifyText("Pfizer Inc. | Ticker: NYSE:PFE |" + Rev);
		Thread.sleep(1000);
		WebControl.takeScreenshot("WEB_Reg_Auto_087");
		
		ReportLog.setTestCase("WEB_Reg_Auto_088");
		String ReportsTotal_042 = VIPLandingPage.contents.ReportsTotal.getText();
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 5);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(5000);
		if (VIPOverviewPage.contents.DownloadReportModalHeader.isDisplayed()) {
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.click();
		Thread.sleep(3000);}
		else {VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.click();
		Thread.sleep(3000);}
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyCardName.waitForExist(true, 45);
		VIPLandingPage.contents.CompanyCardName.verifyText(testDataHandler.company);
		VIPLandingPage.contents.ReportsTotal.verifyText(ReportsTotal_042,false);
		WebControl.takeScreenshot("WEB_Reg_Auto_088");
		
		ReportLog.setTestCase("WEB_Reg_Auto_089");
		String CompanyName_043 = VIPLandingPage.contents.CompanyCardName.getText();
		VIPLandingPage.contents.OverviewButton.verifyDisplayed(true, 40);
		VIPLandingPage.contents.OverviewButton.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 10);
		VIPOverviewPage.contents.CompanyName.verifyText(CompanyName_043);
		WebControl.takeScreenshot("WEB_Reg_Auto_089");
		
		ReportLog.setTestCase("WEB_Reg_Auto_090");
		VIPOverviewPage.contents.BackToSearchButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyCardName.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyCardName.hover();
		String CompanyName_044 = VIPLandingPage.contents.CompanyCardName.getText();
		VIPLandingPage.contents.RefreshButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.RefreshModalHeader.verifyDisplayed();
		VIPLandingPage.contents.RefreshModalHeader.verifyText("Refresh this Report?");
		VIPLandingPage.contents.RefreshModalCompany.verifyText(CompanyName_044);
		VIPLandingPage.contents.RefreshModalDate.verifyText("Request Date");
		WebControl.takeScreenshot("WEB_Reg_Auto_090");
		
		ReportLog.setTestCase("WEB_Reg_Auto_091");
		VIPLandingPage.contents.RefreshModalClose.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.RefreshModalHeader.verifyDisplayed(false);
		//VIPLandingPage.contents.StartNowButton.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_091");
		
//		ReportLog.setTestCase("WEB_Reg_Auto_092_&_093");
//		String CompanyName_046_047 = VIPLandingPage.contents.CompanyCardName.getText();
//		String ReportsTotal_046_047 = VIPLandingPage.contents.ReportsTotal.getText();
//		VIPLandingPage.contents.RefreshButton.click();
//		Thread.sleep(2000);
//		VIPLandingPage.contents.RefreshCloseButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
//		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
//		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
//		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 60);
//		VIPOverviewPage.contents.CompanyName.verifyText(CompanyName_046_047);
//		WebControl.takeScreenshot("WEB_Reg_Auto_092");
//		VIPOverviewPage.contents.BackToSearchButton.click();
//		Thread.sleep(2000);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyCardName.waitForExist(true, 15);
//		//VIPLandingPage.contents.NewDisclaimerProceedButton.click();
//		VIPLandingPage.contents.ReportsTotal.verifyText(ReportsTotal_046_047, false);
//		VIPLandingPage.contents.CompanyCardName.verifyText(CompanyName_046_047);
//		WebControl.takeScreenshot("WEB_Reg_Auto_093");
		
		ReportLog.setTestCase("WEB_Reg_Auto_094");
		if (VIPLandingPage.contents.FirstSavedComp.isDisplayed()) {
		do { VIPLandingPage.contents.SavedCompaniesEditIcon.click();
		VIPLandingPage.contents.DeleteButton.click();} 
		while (VIPLandingPage.contents.FirstSavedComp.isDisplayed());}
		
		VIPLandingPage.contents.SavedCompaniesEditIcon.click();
		VIPLandingPage.contents.SavedCompaniesSearchBox.click();
		VIPLandingPage.contents.SavedCompaniesSearchBox.sendKeys("Pfi");
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		WebControl.takeScreenshot("WEB_Reg_Auto_094");
		
		ReportLog.setTestCase("WEB_Reg_Auto_095");
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(3000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.AddButton.waitForExist(true, 5);
		VIPLandingPage.contents.AddButton.click();
		Thread.sleep(2500);
		VIPLandingPage.contents.NewsList.verifyDisplayed(true, 20);
		WebControl.takeScreenshot("WEB_Reg_Auto_095");
		
		ReportLog.setTestCase("WEB_Reg_Auto_096");
		VIPLandingPage.contents.CompanyNameColumn.verifyDisplayed();
		VIPLandingPage.contents.CompanyNameColumn.verifyText("COMPANY NAME");
		VIPLandingPage.contents.IndustryColumn.verifyDisplayed();
		VIPLandingPage.contents.IndustryColumn.verifyText("INDUSTRY");
		VIPLandingPage.contents.LocationColumn.verifyDisplayed();
		VIPLandingPage.contents.LocationColumn.verifyText("LOCATION");
		WebControl.takeScreenshot("WEB_Reg_Auto_096");
		
		ReportLog.setTestCase("WEB_Reg_Auto_097");
		VIPLandingPage.contents.SavedCompaniesEditIcon.click(); 
		Thread.sleep(1500);
		VIPLandingPage.contents.DeleteButton.verifyDisplayed();
		WebControl.takeScreenshot("WEB_Reg_Auto_097");
		
		ReportLog.setTestCase("WEB_Reg_Auto_098");
		//String FirstCompany = VIPLandingPage.contents.FirstSavedComp.getText();
		VIPLandingPage.contents.DeleteButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.FirstSavedComp.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_098");
		
	}

	@Test(priority=3)
	public void WEBFunctionality_Overview () throws Exception {
		ReportLog.setTestName("WEB Functionality - Overview");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_099");		
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.CompanyName.verifyText(testDataHandler.company);
		WebControl.takeScreenshot("WEB_Reg_Auto_099");
		
		ReportLog.setTestCase("WEB_Reg_Auto_100");
		VIPOverviewPage.contents.SearchType.verifyText("Company Analysis");
		WebControl.takeScreenshot("WEB_Reg_Auto_100");
		
		ReportLog.setTestCase("WEB_Reg_Auto_101");
		VIPOverviewPage.contents.BackToSearchButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_101");
		
		ReportLog.setTestCase("WEB_Reg_Auto_102");
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.FinancialSummaryNote.hover();
		VIPOverviewPage.contents.FinancialSummaryNote.verifyDisplayed(true, 8);
		VIPOverviewPage.contents.FinancialSummaryNote.verifyText(testDataHandler.fsNote);
		WebControl.takeScreenshot("WEB_Reg_Auto_102");
		
		ReportLog.setTestCase("WEB_Reg_Auto_103");
		VIPOverviewPage.contents.FinancialsLink.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.verifyDisplayed(true, 8);
		VIPOverviewPage.contents.FinancialsTitle.verifyText("Financials");
		VIPFinancialsPage.contents.SelectDashboardDropdown.verifyDisplayed(true, 3);
		Thread.sleep(1500);
		WebControl.takeScreenshot("WEB_Reg_Auto_103");
		
		ReportLog.setTestCase("WEB_Reg_Auto_104");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		Thread.sleep(1500);
		if (VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.isDisplayed() & 
		VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.isDisplayed()) {
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.OverviewTitle.hover();
		VIPOverviewPage.contents.RBBPieChart.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBGPieChart.verifyDisplayed(true, 5);}
		else if (!VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.isDisplayed() & 
		!VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.isDisplayed()) {
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.OverviewTitle.hover();
		VIPOverviewPage.contents.RBBPieChart.verifyDisplayed(false);
		VIPOverviewPage.contents.RBGPieChart.verifyDisplayed(false);}
		else if (VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.isDisplayed() & 
		!VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.isDisplayed()) {
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.OverviewTitle.hover();
		VIPOverviewPage.contents.RBBPieChart.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBGPieChart.verifyDisplayed(false);}
		else if (!VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.isDisplayed() & 
		VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.isDisplayed()) {
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.OverviewTitle.hover();
		VIPOverviewPage.contents.RBBPieChart.verifyDisplayed(false);
		VIPOverviewPage.contents.RBGPieChart.verifyDisplayed(true, 5);}
		WebControl.takeScreenshot("WEB_Reg_Auto_104");
		
		ReportLog.setTestCase("WEB_Reg_Auto_105");
		VIPOverviewPage.contents.TRSTrend.verifyDisplayed(true, 8);
		VIPOverviewPage.contents.TRSTrend.verifyText("YOY TREND");
		VIPOverviewPage.contents.RGTrend.verifyDisplayed(true, 8);
		VIPOverviewPage.contents.RGTrend.verifyText("YOY TREND");
		VIPOverviewPage.contents.ROICTrend.verifyDisplayed(true, 8);
		VIPOverviewPage.contents.ROICTrend.verifyText("YOY TREND");
		VIPOverviewPage.contents.EBITMarginTrend.verifyDisplayed(true, 8);
		VIPOverviewPage.contents.EBITMarginTrend.verifyText("YOY TREND");
		VIPOverviewPage.contents.CapEffTrend.verifyDisplayed(true, 8);
		VIPOverviewPage.contents.CapEffTrend.verifyText("YOY TREND");
		WebControl.takeScreenshot("WEB_Reg_Auto_105");
		
		ReportLog.setTestCase("WEB_Reg_Auto_106");
		VIPOverviewPage.contents.ROICTitle.verifyDisplayed(true, 8);
		VIPOverviewPage.contents.ROICTitle.verifyText("PRE-TAX RETURN ON INVESTED CAPITAL (ROIC)");
		WebControl.takeScreenshot("WEB_Reg_Auto_106");
		
		ReportLog.setTestCase("WEB_Reg_Auto_118_KeyInsights1_Validation");
		String TRSValue = VIPOverviewPage.contents.TRSValue.getText();
		VIPOverviewPage.contents.KeyInsights1.verifyText("The company’s total return to shareholders is at " + TRSValue + " for the last one year");
		WebControl.takeScreenshot("WEB_Reg_Auto_118_KeyInsights1_Validation");
		
		ReportLog.setTestCase("WEB_Reg_Auto_118_KeyInsights2_Validation");
		String RGValue = VIPOverviewPage.contents.RGValue.getText();
		String RGTrendValue = VIPOverviewPage.contents.RGTrendValue.getText();
		if (RGTrendValue.substring(0, 1).equals("-")) {
		VIPOverviewPage.contents.KeyInsights2.verifyText("Revenue growth for the last one year stands at " + RGValue + ", declining by " + RGTrendValue.replace("-", "") + " year-on-year");}
		else {VIPOverviewPage.contents.KeyInsights2.verifyText("Revenue growth for the last one year stands at " + RGValue + ", increasing by " + RGTrendValue.replace("-", "") + " year-on-year");}
		WebControl.takeScreenshot("WEB_Reg_Auto_118_KeyInsights2_Validation");
		
		ReportLog.setTestCase("WEB_Reg_Auto_118_KeyInsights3_Validation");
		String ROICValue = VIPOverviewPage.contents.ROICValue.getText();
		String ROICTrendValue = VIPOverviewPage.contents.ROICTrendValue.getText();
		if (ROICTrendValue.substring(0, 1).equals("-")) {
		VIPOverviewPage.contents.KeyInsights3.verifyText("Return on Invested Capital decreased by " + ROICTrendValue.replace("-", "") + " year-on-year and is at " + ROICValue + " for the trailing 12-month period (TTM)");}
		else {VIPOverviewPage.contents.KeyInsights3.verifyText("Return on Invested Capital increased by " + ROICTrendValue.replace("-", "") + " year-on-year and is at " + ROICValue + " for the trailing 12-month period (TTM)");}
		WebControl.takeScreenshot("WEB_Reg_Auto_118_KeyInsights3_Validation");
		
		ReportLog.setTestCase("WEB_Reg_Auto_118_KeyInsights4_Validation");
		String EBITValue = VIPOverviewPage.contents.EBITValue.getText();
		String EBITTrendValue = VIPOverviewPage.contents.EBITTrendValue.getText();
		if (EBITTrendValue.substring(0, 1).equals("-")) {
		VIPOverviewPage.contents.KeyInsights4.verifyText("Company’s EBIT margin declined by " + EBITTrendValue.replace("-", "") + " year-on-year to " + EBITValue + " for the trailing 12-month period");}
		else {VIPOverviewPage.contents.KeyInsights4.verifyText("Company’s EBIT margin improved by " + EBITTrendValue.replace("-", "") + " year-on-year to " + EBITValue + " for the trailing 12-month period");}
		WebControl.takeScreenshot("WEB_Reg_Auto_118_KeyInsights4_Validation");
		
		ReportLog.setTestCase("WEB_Reg_Auto_118_KeyInsights5_Validation");
		String CEValue = VIPOverviewPage.contents.CEValue.getText();
		String CETrendValue = VIPOverviewPage.contents.CETrendValue.getText();
		if (CETrendValue.substring(0, 1).equals("-")) {
		VIPOverviewPage.contents.KeyInsights5.verifyText("Company’s capital efficiency declined by " + CETrendValue.replace("-", "") + " in the last one year to " + CEValue + " for the trailing 12-month period");}
		else {VIPOverviewPage.contents.KeyInsights4.verifyText("Company’s capital efficiency improved by " + CETrendValue.replace("-", "") + " in the last one year to " + CEValue + " for the trailing 12-month period");}
		WebControl.takeScreenshot("WEB_Reg_Auto_118_KeyInsights5_Validation");
		
		ReportLog.setTestCase("WEB_Reg_Auto_118_KeyInsights5_Format");
		String KeyInsights5_1 = VIPOverviewPage.contents.KeyInsights5.getText();
		String[] words = KeyInsights5_1.split("\\s");
		String x = words[5];
		String y = words[12];
		String x1 = x.substring(0, 1);
		String x2 = x.substring(2);
		String y1 = y.substring(0, 1);
		String y2 = y.substring(2);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.EnterpriseValue.waitForExist(true, 60);
		VIPOverviewPage.contents.KeyInsights5.verifyText("Company’s capital efficiency " + words[3] + " by " + x1 + "." + x2 + " in the last one year to " + y1 + "." + y2 + " for the trailing 12-month period");
		WebControl.takeScreenshot("WEB_Reg_Auto_118_KeyInsights5_Format");
		
		ReportLog.setTestCase("WEB_Reg_Auto_108");
		String[] RV = VIPOverviewPage.contents.RevenueValue.getText().split("\\s");
		if (RV[0].equals("USD")) {
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.TargetCompRevenue.hover();
		String Revenue = VIPCompetitorPage.contents.TargetCompRevenue.getText();
		String rev = Revenue.replace(",", "");
		double rev1 = Integer.parseInt(rev);
		double convertedRev1 = (rev1/1000);
		BigDecimal convertedRev2 = new BigDecimal(convertedRev1).setScale(1, RoundingMode.HALF_UP);
		double convertedRev = convertedRev2.doubleValue();
		VIPOverviewPage.contents.SideMenuOverview.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.RevenueValue.hover();
		VIPOverviewPage.contents.RevenueValue.verifyDisplayed();
		VIPOverviewPage.contents.RevenueValue.verifyText("USD " + convertedRev + " B");}
		else { String[] RV1 = RV[1].split("\\."); 
		VIPOverviewPage.contents.RevenueValue.verifyText(RV[0] + " " + RV1[0] + "." + RV1[1].substring(0, 1) + " B");}
		WebControl.takeScreenshot("WEB_Reg_Auto_108");
		
		ReportLog.setTestCase("WEB_Reg_Auto_115");
		//REVENUE = 0/Null 
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Windtree Thera");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) 
		{
			VIPLandingPage.contents.CompanyNameTextbox.clear();
			VIPLandingPage.contents.CompanyNameTextbox.sendKeys("pfi");
			VIPLandingPage.contents.CompanyNameTextbox.clear();
			VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Windtree Thera");
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
			Thread.sleep(3000);
		}
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.FinancialsSummaryContainer.waitForExist(true, 60);
		VIPOverviewPage.contents.RevenueValue.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPOverviewPage.contents.RevenueValue.verifyText("-");
		//Comment Out Temp
		//ENTERPRISE VALUE = 0/Null 
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.BackToSearchButton.hover();
//		VIPOverviewPage.contents.BackToSearchButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Sony Corporation");
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
//		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
//		Thread.sleep(1000);
//		VIPOverviewPage.contents.FinancialsSummaryContainer.waitForExist(true, 60);
//		VIPOverviewPage.contents.EnterpriseValue.waitForExist(true, 60);
//		Thread.sleep(3000);
//		VIPOverviewPage.contents.EnterpriseValue.verifyText("-");
		//EMPLOYEES VALUE = 0/Null 
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Avalon Advanced");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.FinancialsSummaryContainer.waitForExist(true, 60);
		VIPOverviewPage.contents.EmployeesValue.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPOverviewPage.contents.EmployeesValue.verifyText("-");
		WebControl.takeScreenshot("WEB_Reg_Auto_115");
		
		ReportLog.setTestCase("WEB_Reg_Auto_116");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Uber Technologies, Inc.");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.FinancialsSummaryContainer.waitForExist(true, 60);
		VIPOverviewPage.contents.EBITMarginValue.waitForExist(true, 60);
		Thread.sleep(3000);
		String EBITMarginValue1 = VIPOverviewPage.contents.EBITMarginValue.getText();
		String EBITMarginValue = EBITMarginValue1.substring(1);
		VIPOverviewPage.contents.EBITMarginValue.verifyText("-" + EBITMarginValue);
		WebControl.takeScreenshot("WEB_Reg_Auto_116");
		
		ReportLog.setTestCase("WEB_Reg_Auto_117");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("HC2 Holdings, Inc.");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.FinancialsSummaryContainer.waitForExist(true, 60);
		VIPOverviewPage.contents.EnterpriseValue.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPOverviewPage.contents.EnterpriseValue.verifyText("-");
		WebControl.takeScreenshot("WEB_Reg_Auto_117");
		
		ReportLog.setTestCase("WEB_Reg_Auto_119");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.privCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.PrivateCompReminder.verifyDisplayed();
		VIPOverviewPage.contents.PrivateCompReminder.verifyText("This is a private company, go to Competitors to add other companies and see results");
		WebControl.takeScreenshot("WEB_Reg_Auto_119");
		
		ReportLog.setTestCase("WEB_Reg_Auto_120");
		VIPOverviewPage.contents.TRSValue.verifyDisplayed(true, 8);
		VIPOverviewPage.contents.TRSValue.verifyText("-");
		WebControl.takeScreenshot("WEB_Reg_Auto_120");
		
		ReportLog.setTestCase("WEB_Reg_Auto_121");
		String Website = VIPOverviewPage.contents.Website.getText();
		VIPOverviewPage.contents.Website.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		WebControl.takeScreenshot("WEB_Reg_Auto_121");
		
	}

	@Test(priority=4)
	public void WEBFunctionality_Competitors () throws Exception {
		ReportLog.setTestName("WEB Functionality - Competitors");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_122");
		WebControl.switchWithTitle("Value Insights Platform");
		String CompanyName = VIPOverviewPage.contents.CompanyName.getText();
		String Industry = VIPOverviewPage.contents.Industry.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		if (Industry.equals("-")) {
		VIPCompetitorPage.contents.CompetitorNoResults.waitForExist(true, 10);
		VIPCompetitorPage.contents.CompetitorNoResults.verifyText("No results. Add competitors or refine search criteria.");}
		else {VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_122");
		
		ReportLog.setTestCase("WEB_Reg_Auto_123");
		VIPCompetitorPage.contents.TargetCompName.waitForExist(true, 10);
		VIPCompetitorPage.contents.TargetCompName.verifyText(CompanyName);
		WebControl.takeScreenshot("WEB_Reg_Auto_123");	
		
		ReportLog.setTestCase("WEB_Reg_Auto_124");
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Procter");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		WebControl.takeScreenshot("WEB_Reg_Auto_124");
		
		ReportLog.setTestCase("WEB_Reg_Auto_125");
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.customJavaClick();
		Thread.sleep(3000);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 10);
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
			if (Industry.equals("-")) {
				VIPCompetitorPage.contents.Competitors1stPeers.verifyText("The Procter & Gamble Company\n" + "NYSE:PG");
				VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 1 PEERS");}
			else {VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 16 PEERS");}}
		WebControl.takeScreenshot("WEB_Reg_Auto_125");
		
		ReportLog.setTestCase("WEB_Reg_Auto_126");
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
		VIPCompetitorPage.contents.Competitors1stPeers.click();}
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.verifyDisplayed(true, 8);
		WebControl.takeScreenshot("WEB_Reg_Auto_126_1");
		if (VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.isDisplayed()) {
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.click();
		VIPCompetitorPage.contents.CompetitorsPeersDeleteLoadingIcon.waitForExist(false, 10);}
		Thread.sleep(1500);
		if (Industry.equals("-")) {
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 0 PEERS");}
		else {VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 15 PEERS");}
		WebControl.takeScreenshot("WEB_Reg_Auto_126_2");
		
		ReportLog.setTestCase("WEB_Reg_Auto_127");
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.RefineCriteriaModal.verifyDisplayed();
		WebControl.takeScreenshot("WEB_Reg_Auto_127");
		
		ReportLog.setTestCase("WEB_Reg_Auto_128");
		VIPCompetitorPage.contents.RefineCriteriaCloseButton.click();
		VIPCompetitorPage.contents.RefineCriteriaModal.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_128");
		
		ReportLog.setTestCase("WEB_Reg_Auto_129");
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.RefineCriteriaModal.verifyDisplayed();
		VIPCompetitorPage.contents.SelectRegionAccordionCollapsed.click();
		VIPCompetitorPage.contents.SelectRegionDropdown.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.SelectCountryDropdown.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_129");
		
		ReportLog.setTestCase("WEB_Reg_Auto_130");
		VIPCompetitorPage.contents.SelectRegionAccordionExpanded.click();
		VIPCompetitorPage.contents.SetRevenueAccordionCollapsed.click();
		VIPCompetitorPage.contents.RevenueMin.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.RevenueMax.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.MarketCapMin.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.MarketCapMax.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_130");
		
		ReportLog.setTestCase("WEB_Reg_Auto_131");
		VIPCompetitorPage.contents.RefineCriteriaCloseButton.click();
		Thread.sleep(1500);
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.SaveCriteriaButton.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_131_1");
		VIPCompetitorPage.contents.SetRevenueAccordionCollapsed.click();
		VIPCompetitorPage.contents.RevenueMin.sendKeys("100");
		VIPCompetitorPage.contents.RevenueMax.sendKeys("1000");
		VIPCompetitorPage.contents.MarketCapMin.sendKeys("100");
		VIPCompetitorPage.contents.MarketCapMax.sendKeys("1000");
		VIPCompetitorPage.contents.SetRevenueAccordionExpanded.click();
		VIPCompetitorPage.contents.SaveCriteriaButton.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_131_2");
		
		ReportLog.setTestCase("WEB_Reg_Auto_132");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.SaveCriteriaButton.click();
		Thread.sleep(1500);
		VIPCompetitorPage.contents.NameCriteriaTextBox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_132");
		
		ReportLog.setTestCase("WEB_Reg_Auto_133");
		VIPCompetitorPage.contents.NameCriteriaTextBox.sendKeys("Test");
		VIPCompetitorPage.contents.NameCriteriaCloseButton.click();
		VIPCompetitorPage.contents.NameCriteriaTextBox.verifyDisplayed(false);
		VIPCompetitorPage.contents.SaveCriteriaButton.click();
		VIPCompetitorPage.contents.NameCriteriaTextBox.sendKeys("Test");
		VIPCompetitorPage.contents.DoneCriteriaButton.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_133");
		
		ReportLog.setTestCase("WEB_Reg_Auto_134");
		VIPCompetitorPage.contents.PreSavedCriteriaAccordionCollapsed.click();
		VIPCompetitorPage.contents.PreSavedCriteriaDropdown.click();
		VIPCompetitorPage.contents.PreSavedCriteriaDropdownMenu.verifyText("Test");
		WebControl.takeScreenshot("WEB_Reg_Auto_134");
		
		ReportLog.setTestCase("WEB_Reg_Auto_135");
		VIPCompetitorPage.contents.PreSavedCriteriaDropdownMenu.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_135");
		
		ReportLog.setTestCase("WEB_Reg_Auto_136");
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		if (Industry.equals("-")) {
		VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed(true, 20);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		else {VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 20);
		VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_136");
		
		ReportLog.setTestCase("WEB_Reg_Auto_137");
		if (Industry.equals("-")) {
		VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		else {
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors15thPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_137_BeforeFilter");
		VIPLandingPage.contents.HelpIcon.hover();
		//VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.PreSavedCriteriaAccordionCollapsed.click();
		VIPCompetitorPage.contents.PreSavedCriteriaDropdown.hover();
		VIPCompetitorPage.contents.PreSavedCriteriaDropdown.click();
		//Comment out temporarily
		//VIPCompetitorPage.contents.PreSavedCriteriaDropdownMenu.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_137_VerifySavedCriteria");
		VIPCompetitorPage.contents.TopFilterDropdown.click();
		VIPCompetitorPage.contents.TopFilterChoice25.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		if (Industry.equals("-")) {
		VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		else {
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors15thPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(true, 5);}
		WebControl.takeScreenshot("WEB_Reg_Auto_137_AfterFilter");
		
		ReportLog.setTestCase("WEB_Reg_Auto_138");
		String TargetCompName = VIPCompetitorPage.contents.TargetCompName.getText();
		if (TargetCompName.length() > 18) {
		String NewTargetCompName1 = TargetCompName.split("\n")[0];
		String NewTargetCompName = NewTargetCompName1.substring(0, 18);
		VIPCompetitorPage.contents.NewTargetCompAlias.verifyValue(NewTargetCompName);}
		else {VIPCompetitorPage.contents.NewTargetCompAlias.verifyValue(TargetCompName);}
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
		String FirstPeerCompName = VIPCompetitorPage.contents.Competitors1stPeers.getText();
		if (FirstPeerCompName.length() > 18) {
		String NewFirstPeerCompName1 = FirstPeerCompName.split("\n")[0];
		String NewFirstPeerCompName = NewFirstPeerCompName1.substring(0, 18);
		VIPCompetitorPage.contents.NewFirstPeerAlias.verifyValue(NewFirstPeerCompName);}
		else {VIPCompetitorPage.contents.NewFirstPeerAlias.verifyValue(FirstPeerCompName);}}
		WebControl.takeScreenshot("WEB_Reg_Auto_138");
		
		ReportLog.setTestCase("WEB_Reg_Auto_139");
		String Digits19 = "1234567890123456789";
		String Digits18 = "123456789012345678";
		VIPCompetitorPage.contents.NewTargetCompAlias.clear();
		VIPCompetitorPage.contents.NewTargetCompAlias.type(Digits19);
		VIPCompetitorPage.contents.NewTargetCompAlias.verifyValue(Digits18);
		if (VIPCompetitorPage.contents.NewFirstPeerAlias.isDisplayed()) {
		VIPCompetitorPage.contents.NewFirstPeerAlias.clear();
		VIPCompetitorPage.contents.NewFirstPeerAlias.type(Digits19);
		VIPCompetitorPage.contents.NewFirstPeerAlias.verifyValue(Digits18);}
		WebControl.takeScreenshot("WEB_Reg_Auto_139");
		
		ReportLog.setTestCase("WEB_Reg_Auto_140");
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
		String Revenue1_1 = VIPCompetitorPage.contents.Revenue1.getText();
		String Revenue1_2 = Revenue1_1.replace(",", "");
		int Revenue1 = Integer.parseInt(Revenue1_2);
		
		String Revenue2_1 = VIPCompetitorPage.contents.Revenue2.getText();
		String Revenue2_2 = Revenue2_1.replace(",", "");
		int Revenue2 = Integer.parseInt(Revenue2_2);
		
		String Revenue3_1 = VIPCompetitorPage.contents.Revenue3.getText();
		String Revenue3_2 = Revenue3_1.replace(",", "");
		int Revenue3 = Integer.parseInt(Revenue3_2);
		
		String Revenue4_1 = VIPCompetitorPage.contents.Revenue4.getText();
		String Revenue4_2 = Revenue4_1.replace(",", "");
		int Revenue4 = Integer.parseInt(Revenue4_2);
		
		String Revenue5_1 = VIPCompetitorPage.contents.Revenue5.getText();
		String Revenue5_2 = Revenue5_1.replace(",", "");
		int Revenue5 = Integer.parseInt(Revenue5_2);
		
		String Revenue6_1 = VIPCompetitorPage.contents.Revenue6.getText();
		String Revenue6_2 = Revenue6_1.replace(",", "");
		int Revenue6 = Integer.parseInt(Revenue6_2);
		
		String Revenue7_1 = VIPCompetitorPage.contents.Revenue7.getText();
		String Revenue7_2 = Revenue7_1.replace(",", "");
		int Revenue7 = Integer.parseInt(Revenue7_2);
		
		String Revenue8_1 = VIPCompetitorPage.contents.Revenue8.getText();
		String Revenue8_2 = Revenue8_1.replace(",", "");
		int Revenue8 = Integer.parseInt(Revenue8_2);
		
		String Revenue9_1 = VIPCompetitorPage.contents.Revenue9.getText();
		String Revenue9_2 = Revenue9_1.replace(",", "");
		int Revenue9 = Integer.parseInt(Revenue9_2);
		
		String Revenue10_1 = VIPCompetitorPage.contents.Revenue10.getText();
		String Revenue10_2 = Revenue10_1.replace(",", "");
		int Revenue10 = Integer.parseInt(Revenue10_2);
		
		String Revenue11_1 = VIPCompetitorPage.contents.Revenue11.getText();
		String Revenue11_2 = Revenue11_1.replace(",", "");
		int Revenue11 = Integer.parseInt(Revenue11_2);
		
		String Revenue12_1 = VIPCompetitorPage.contents.Revenue12.getText();
		String Revenue12_2 = Revenue12_1.replace(",", "");
		int Revenue12 = Integer.parseInt(Revenue12_2);
		
		String Revenue13_1 = VIPCompetitorPage.contents.Revenue13.getText();
		String Revenue13_2 = Revenue13_1.replace(",", "");
		int Revenue13 = Integer.parseInt(Revenue13_2);
		
		String Revenue14_1 = VIPCompetitorPage.contents.Revenue14.getText();
		String Revenue14_2 = Revenue14_1.replace(",", "");
		int Revenue14 = Integer.parseInt(Revenue14_2);
		
		String Revenue15_1 = VIPCompetitorPage.contents.Revenue15.getText();
		String Revenue15_2 = Revenue15_1.replace(",", "");
		int Revenue15 = Integer.parseInt(Revenue15_2);
		
		List<Integer> lList = new ArrayList<Integer>();
        lList.add(Revenue1);       
        lList.add(Revenue2);
        lList.add(Revenue3);
        lList.add(Revenue4);
        lList.add(Revenue5);
        lList.add(Revenue6);
        lList.add(Revenue7);
        lList.add(Revenue8);
        lList.add(Revenue9);
        lList.add(Revenue10);
        lList.add(Revenue11);
        lList.add(Revenue12);
        lList.add(Revenue13);
        lList.add(Revenue14);
        lList.add(Revenue15);
        
        Collections.sort(lList);
        Integer a1 = lList.get(0);
        Integer a2 = lList.get(1);
        Integer a3 = lList.get(2);
        Integer a4 = lList.get(3);
        Integer a5 = lList.get(4);
        Integer a6 = lList.get(5);
        Integer a7 = lList.get(6);
        Integer a8 = lList.get(7);
        Integer a9 = lList.get(8);
        Integer a10 = lList.get(9);
        Integer a11 = lList.get(10);
        Integer a12 = lList.get(11);
        Integer a13 = lList.get(12);
        Integer a14 = lList.get(13);
        Integer a15 = lList.get(14);
        
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
        String b1 = myFormat.format(a1);
        String b2 = myFormat.format(a2);
        String b3 = myFormat.format(a3);
        String b4 = myFormat.format(a4);
        String b5 = myFormat.format(a5);
        String b6 = myFormat.format(a6);
        String b7 = myFormat.format(a7);
        String b8 = myFormat.format(a8);
        String b9 = myFormat.format(a9);
        String b10 = myFormat.format(a10);
        String b11 = myFormat.format(a11);
        String b12 = myFormat.format(a12);
        String b13 = myFormat.format(a13);
        String b14 = myFormat.format(a14);
        String b15 = myFormat.format(a15);
		
		VIPCompetitorPage.contents.Revenue1.verifyText(b15);
		VIPCompetitorPage.contents.Revenue2.verifyText(b14);
		VIPCompetitorPage.contents.Revenue3.verifyText(b13);
		VIPCompetitorPage.contents.Revenue4.verifyText(b12);
		VIPCompetitorPage.contents.Revenue5.verifyText(b11);
		VIPCompetitorPage.contents.Revenue6.verifyText(b10);
		VIPCompetitorPage.contents.Revenue7.verifyText(b9);
		VIPCompetitorPage.contents.Revenue8.verifyText(b8);
		VIPCompetitorPage.contents.Revenue9.verifyText(b7);
		VIPCompetitorPage.contents.Revenue10.verifyText(b6);
		VIPCompetitorPage.contents.Revenue11.verifyText(b5);
		VIPCompetitorPage.contents.Revenue12.verifyText(b4);
		VIPCompetitorPage.contents.Revenue13.verifyText(b3);
		VIPCompetitorPage.contents.Revenue14.verifyText(b2);
		VIPCompetitorPage.contents.Revenue15.verifyText(b1);}
		else {VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_140");
		
		ReportLog.setTestCase("WEB_Reg_Auto_141");
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
		VIPCompetitorPage.contents.Symbol1.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol2.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol3.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol4.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol5.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol6.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol7.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol8.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol9.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol10.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol11.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol12.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol13.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol14.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol15.verifyDisplayed(true, 5);}
		else {VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_141");
		
	}

	@Test(priority=5)
	public void WEBFunctionality_Transcripts () throws Exception {
		ReportLog.setTestName("WEB Functionality - Transcripts");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_142_to_144");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPTranscriptPage.contents.SideMenuTranscript.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.SideMenuTranscript.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.TranscriptTitle.verifyDisplayed(true, 20);
		VIPTranscriptPage.contents.TranscriptTitle.verifyText("Transcripts");
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 25);
		if (!VIPTranscriptPage.contents.FirstTranscriptTitle.isDisplayed()) { //Workaround if Target company has no Transcripts
			VIPLandingPage.contents.HelpIcon.hover();
			VIPOverviewPage.contents.BackToSearchButton.hover();
			VIPOverviewPage.contents.BackToSearchButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Uber");
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
			VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
			Thread.sleep(1000);
			VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
			VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
			Thread.sleep(2000);
			VIPTranscriptPage.contents.SideMenuTranscript.waitForExist(true, 10);
			VIPLandingPage.contents.HelpIcon.hover();
			VIPTranscriptPage.contents.SideMenuTranscript.click();
			VIPTranscriptPage.contents.TranscriptTitle.verifyDisplayed(true, 20);
			VIPTranscriptPage.contents.TranscriptTitle.verifyText("Transcripts");
			VIPTranscriptPage.contents.FirstTranscriptTitle.waitForExist(true, 20);
		}
		VIPTranscriptPage.contents.EventType1.hover();
		VIPTranscriptPage.contents.EventType1.verifyDisplayed(true, 5);
		VIPTranscriptPage.contents.EventType2.hover();
		VIPTranscriptPage.contents.EventType2.verifyDisplayed(true, 5);
		VIPTranscriptPage.contents.EventType3.hover();
		VIPTranscriptPage.contents.EventType3.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_142");
		VIPTranscriptPage.contents.FirstTranscriptTitle.hover();
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_143");
		VIPTranscriptPage.contents.EventType2.click();
		String FirstTranscript_1 = VIPTranscriptPage.contents.FirstTranscriptTitle.getText();
		VIPTranscriptPage.contents.EventType3.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyText(FirstTranscript_1, false);
		VIPTranscriptPage.contents.EventType4.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyText(FirstTranscript_1, false);
		WebControl.takeScreenshot("WEB_Reg_Auto_144");
		
		ReportLog.setTestCase("WEB_Reg_Auto_145");
		VIPLandingPage.contents.HelpIcon.hover();
		String FirstTranscript = VIPTranscriptPage.contents.FirstTranscriptTitle.getText();
		VIPTranscriptPage.contents.FirstTranscriptTitle.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyText(FirstTranscript);
		WebControl.takeScreenshot("WEB_Reg_Auto_145");
		
		ReportLog.setTestCase("WEB_Reg_Auto_146");
		VIPTranscriptPage.contents.ClearSelection.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.ClearSelection.verifyText("Clear Selection");
		WebControl.takeScreenshot("WEB_Reg_Auto_146");
		
		ReportLog.setTestCase("WEB_Reg_Auto_147");
		VIPTranscriptPage.contents.TranscriptSpeechName.verifyDisplayed(true, 10);
		VIPTranscriptPage.contents.TranscriptSpeechPosition.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.TranscriptSpeech.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_147");
		
		ReportLog.setTestCase("WEB_Reg_Auto_148");
//		String SpeechBody1 = VIPTranscriptPage.contents.TranscriptSpeech.getText();
//		String[] SpeechBody2 = SpeechBody1.split("\\s");
//		String Speech = SpeechBody2[1];
		VIPTranscriptPage.contents.SearchTextbox.sendKeys("a");
		VIPTranscriptPage.contents.Executives.click();
		VIPTranscriptPage.contents.Executives1.click();
		VIPTranscriptPage.contents.Selected.verifyText("a");
		VIPTranscriptPage.contents.Analysts.click();
		VIPTranscriptPage.contents.Analysts1.click();
		VIPTranscriptPage.contents.Selected.verifyText("a");
		WebControl.takeScreenshot("WEB_Reg_Auto_148");
		
		ReportLog.setTestCase("WEB_Reg_Auto_149");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.waitForExist(true, 10);
		VIPTranscriptPage.contents.FirstTranscriptTitle.click();
		VIPTranscriptPage.contents.TranscriptSpeech.waitForExist(true, 20);
		VIPTranscriptPage.contents.Executives.click();
		VIPTranscriptPage.contents.Executives1.click();
		String Speech1 = VIPTranscriptPage.contents.TranscriptSpeech.getText();
		String Speech2 = VIPTranscriptPage.contents.TranscriptSpeech2.getText();
		String Speech3 = VIPTranscriptPage.contents.TranscriptSpeech3.getText();
		String newSpeech1 = new String(Speech1);
		String newSpeech2 = new String(Speech2);
		String newSpeech3 = new String(Speech3);
		

		int count1 = Speech1.length();
	    if (count1 >= 750) {
	    	VIPTranscriptPage.contents.FirstMoreLink.verifyDisplayed(true);
	    }
	    else {VIPTranscriptPage.contents.FirstMoreLink.verifyDisplayed(false);}
	    

	    int count2 = Speech2.length();
	    if (count2 >= 750) {
	    	VIPTranscriptPage.contents.SecondMoreLink.verifyDisplayed(true);
	    }
	    else {VIPTranscriptPage.contents.SecondMoreLink.verifyDisplayed(false);}
	    

	    int count3 = Speech3.length();
	    if (count3 >= 750) {
	    	VIPTranscriptPage.contents.ThirdMoreLink.verifyDisplayed(true);
	    }
	    else {VIPTranscriptPage.contents.ThirdMoreLink.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_149");
		
		ReportLog.setTestCase("WEB_Reg_Auto_150");
		if (VIPTranscriptPage.contents.FirstMoreLink.isDisplayed()) {
		String TranscriptSpeechName = VIPTranscriptPage.contents.TranscriptSpeechName.getText();
		VIPTranscriptPage.contents.FirstMoreLink.hover();
		VIPTranscriptPage.contents.FirstMoreLink.click();
		VIPTranscriptPage.contents.SpeechModal.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.SpeechModalName.verifyText(TranscriptSpeechName);
		VIPTranscriptPage.contents.SpeechModalCloseButton.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_150");
		
		ReportLog.setTestCase("WEB_Reg_Auto_151");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(false);
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_151");}
		
		else if (VIPTranscriptPage.contents.SecondMoreLink.isDisplayed()) {
		String TranscriptSpeechName2 = VIPTranscriptPage.contents.TranscriptSpeechName2.getText();
		VIPTranscriptPage.contents.SecondMoreLink.hover();
		VIPTranscriptPage.contents.SecondMoreLink.click();
		VIPTranscriptPage.contents.SpeechModal.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.SpeechModalName.verifyText(TranscriptSpeechName2);
		VIPTranscriptPage.contents.SpeechModalCloseButton.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_150");
		
		ReportLog.setTestCase("WEB_Reg_Auto_151");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(false);
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_151");}
		
		else if (VIPTranscriptPage.contents.ThirdMoreLink.isDisplayed()) {
		String TranscriptSpeechName3 = VIPTranscriptPage.contents.TranscriptSpeechName3.getText();
		VIPTranscriptPage.contents.ThirdMoreLink.hover();
		VIPTranscriptPage.contents.ThirdMoreLink.click();
		VIPTranscriptPage.contents.SpeechModal.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.SpeechModalName.verifyText(TranscriptSpeechName3);
		VIPTranscriptPage.contents.SpeechModalCloseButton.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_150");
		
		ReportLog.setTestCase("WEB_Reg_Auto_151");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(false);
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_151");}
		
		else {VIPTranscriptPage.contents.FirstMoreLink.verifyDisplayed(false);
		VIPTranscriptPage.contents.SecondMoreLink.verifyDisplayed(false);
		VIPTranscriptPage.contents.ThirdMoreLink.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_150");
		
		ReportLog.setTestCase("WEB_Reg_Auto_151");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(false);
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_151");}
		
		ReportLog.setTestCase("WEB_Reg_Auto_152");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.noTransCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPTranscriptPage.contents.SideMenuTranscript.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.SideMenuTranscript.click();
		VIPTranscriptPage.contents.TranscriptNoData.verifyDisplayed(true, 10);
		VIPTranscriptPage.contents.TranscriptNoData.verifyText("Sorry! Data not available for this company");
		WebControl.takeScreenshot("WEB_Reg_Auto_152");

	}

	@Test(priority=6)
	public void WEBFunctionality_Executives () throws Exception {
		ReportLog.setTestName("WEB Functionality - Executives");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_153");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPExecutivesPage.contents.SideMenuExecutives.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPExecutivesPage.contents.ExecutivesTitle.verifyDisplayed(true, 25);
		VIPExecutivesPage.contents.ExecutivesTitle.verifyText("Executives");
		VIPExecutivesPage.contents.ExecutivesTitle.hover();
		VIPExecutivesPage.contents.ExecutivesDropdown.verifyText("All Executives");
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.TopExecutivesMenu.hover();
		VIPExecutivesPage.contents.TopExecutivesMenu.verifyDisplayed(true, 5);
		VIPExecutivesPage.contents.BoardMembersMenu.hover();
		VIPExecutivesPage.contents.BoardMembersMenu.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_153");
		
		ReportLog.setTestCase("WEB_Reg_Auto_154");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPFinancialsPage.contents.ScoreCardDate.waitForExist(true, 20);
		String[] Period = VIPFinancialsPage.contents.ScoreCardDate.getText().split("\\/");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPExecutivesPage.contents.SideMenuExecutives.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPExecutivesPage.contents.ExecutivesTitle.verifyDisplayed(true, 25);
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.TopExecutivesMenu.click();
		String KeyExecutiveName1 = VIPExecutivesPage.contents.FirstExecutiveNameMenu.getText();
		String KeyExecutiveName2 = VIPExecutivesPage.contents.SecondExecutiveNameMenu.getText();
		String KeyExecutiveName3 = VIPExecutivesPage.contents.ThirdExecutiveNameMenu.getText();
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.BoardMembersMenu.click();
		String BoardMemberName1 = VIPExecutivesPage.contents.SecondExecutiveNameMenu.getText();
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.AllExecutivesMenu.click();
		VIPExecutivesPage.contents.FirstExecutiveNameMenu.verifyText(KeyExecutiveName1, true);
		VIPExecutivesPage.contents.SecondExecutiveNameMenu.verifyText(KeyExecutiveName2, true);
		VIPExecutivesPage.contents.ThirdExecutiveNameMenu.verifyText(KeyExecutiveName3, true);
		VIPExecutivesPage.contents.FourthExecutiveNameMenu.verifyDisplayed();
		VIPExecutivesPage.contents.FourthExecutiveNameMenu.verifyText(BoardMemberName1, false);
		WebControl.takeScreenshot("WEB_Reg_Auto_154");
		
		ReportLog.setTestCase("WEB_Reg_Auto_160");
		String ExecutiveName1 = VIPExecutivesPage.contents.FirstExecutiveNameMenu.getText();
		String ExecutiveName2 = VIPExecutivesPage.contents.SecondExecutiveNameMenu.getText();
		String ExecutiveName3 = VIPExecutivesPage.contents.ThirdExecutiveNameMenu.getText();
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.TopExecutivesMenu.click();
		VIPExecutivesPage.contents.FirstExecutiveNameMenu.verifyText(ExecutiveName1, true);
		VIPExecutivesPage.contents.SecondExecutiveNameMenu.verifyText(ExecutiveName2, true);
		VIPExecutivesPage.contents.ThirdExecutiveNameMenu.verifyText(ExecutiveName3, true);
		VIPExecutivesPage.contents.FourthExecutiveNameMenu.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_160");
		
		ReportLog.setTestCase("WEB_Reg_Auto_161");
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.BoardMembersMenu.click();
		VIPExecutivesPage.contents.SecondExecutiveNameMenu.verifyText(ExecutiveName2, false);
		VIPExecutivesPage.contents.ThirdExecutiveNameMenu.verifyText(ExecutiveName3, false);
		WebControl.takeScreenshot("WEB_Reg_Auto_161");
		
		ReportLog.setTestCase("WEB_Reg_Auto_162");
		if (VIPExecutivesPage.contents.ACBChartTitle.isDisplayed()) {
		VIPExecutivesPage.contents.ACBChartTitle.verifyText("ANNUAL COMPENSATION BREAKUP");}
		VIPExecutivesPage.contents.ACBChartTitle.verifyDisplayed(true, 4);
		if (VIPExecutivesPage.contents.TSAChartTitle.isDisplayed()) {
		VIPExecutivesPage.contents.TSAChartTitle.verifyText("TOTAL STOCK AWARDS (USD MN)");}
		VIPExecutivesPage.contents.TSAChartTitle.verifyDisplayed(true, 4);
		WebControl.takeScreenshot("WEB_Reg_Auto_162");
		
		ReportLog.setTestCase("WEB_Reg_Auto_163");
		if (VIPExecutivesPage.contents.ACBChartTitle.isDisplayed()) {
		VIPExecutivesPage.contents.ACBChartTitle.verifyText("ANNUAL COMPENSATION BREAKUP");}
		VIPExecutivesPage.contents.ACBChartTitle.verifyDisplayed(true, 4);
		WebControl.takeScreenshot("WEB_Reg_Auto_163");
		
		ReportLog.setTestCase("WEB_Reg_Auto_164");
		if (VIPExecutivesPage.contents.ACBChartTitle.isDisplayed()) {
		DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
		LocalDate datetoday = LocalDate.now();
		String currentYear = year.format(datetoday);
		VIPExecutivesPage.contents.ACBChartYear.verifyText("[ " + Period[1].replace("]", "") + " ]");}
		VIPExecutivesPage.contents.ACBChartTitle.verifyDisplayed(true, 4);
		WebControl.takeScreenshot("WEB_Reg_Auto_164");
		
		ReportLog.setTestCase("WEB_Reg_Auto_165");
		if (VIPExecutivesPage.contents.ACBChartTitle.isDisplayed()) {
		VIPExecutivesPage.contents.ACBChartLegend1.verifyText("Cash");
		VIPExecutivesPage.contents.ACBChartLegend2.verifyText("Non-Cash");}
		VIPExecutivesPage.contents.ACBChartTitle.verifyDisplayed(true, 4);
		WebControl.takeScreenshot("WEB_Reg_Auto_165");
		
		ReportLog.setTestCase("WEB_Reg_Auto_166");
		String bio = VIPExecutivesPage.contents.ExecutiveBio.getText();
		String newBio = new String(bio);
	      int count = 0;
	      for(int i = 0; i<newBio.length(); i++) {
	         count++;}
	    if (count >= 353) {
	    VIPExecutivesPage.contents.MoreLink.verifyDisplayed(true);
	    }
	    else {VIPExecutivesPage.contents.MoreLink.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_166");
	
	}

	@Test(priority=7)
	public void WEBFunctionality_News () throws Exception {
		ReportLog.setTestName("WEB Functionality - News");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_167_to_169");	
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPNewsPage.contents.SideMenuNews.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPNewsPage.contents.NewsEvents1.verifyDisplayed(true, 15);
		WebControl.takeScreenshot("WEB_Reg_Auto_167_1");
		if (VIPNewsPage.contents.NoNewsMessage.isDisplayed()) { //Work around if Target Company has no news
			VIPLandingPage.contents.HelpIcon.hover();
			VIPOverviewPage.contents.BackToSearchButton.hover();
			VIPOverviewPage.contents.BackToSearchButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
			VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
			Thread.sleep(1000);
			VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
			VIPLandingPage.contents.HelpIcon.hover();
			VIPNewsPage.contents.SideMenuNews.click();
			Thread.sleep(3000);
			VIPLandingPage.contents.HelpIcon.hover();
			VIPNewsPage.contents.SelectTimePeriod1.waitForExist(true, 15);
			VIPNewsPage.contents.SelectTimePeriod1.click();
			VIPNewsPage.contents.NewsEvents1.waitForExist(true, 15);
		}
		VIPNewsPage.contents.NewsEvents1.hover();
		VIPNewsPage.contents.NewsEvents1.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_167");
		VIPNewsPage.contents.NewsType1.hover();
		VIPNewsPage.contents.NewsType1.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_168");
		VIPNewsPage.contents.NewsTitle.verifyDisplayed();
		VIPNewsPage.contents.NewsTitle.verifyText("News");
		VIPNewsPage.contents.NewsType.verifyDisplayed(true, 5);
		VIPNewsPage.contents.NewsTypeHeader.verifyText("NEWS TYPE");
		VIPNewsPage.contents.NewsType1.verifyDisplayed();
		VIPNewsPage.contents.NewsType2.verifyDisplayed();
		WebControl.takeScreenshot("WEB_Reg_Auto_169");
		
		ReportLog.setTestCase("WEB_Reg_Auto_170");
		VIPNewsPage.contents.NewsEvents1.waitForExist(true, 25);
		String NewsEvents1 = VIPNewsPage.contents.NewsEvents1.getText();
		String NewsEvents2 = VIPNewsPage.contents.NewsEvents2.getText();
		String NewsEvents3 = VIPNewsPage.contents.NewsEvents3.getText();
		String NewsEvents4 = VIPNewsPage.contents.NewsEvents4.getText();
		String NewsEvents5 = VIPNewsPage.contents.NewsEvents5.getText();
		String NewsEvents6 = VIPNewsPage.contents.NewsEvents6.getText();
		String NewsEvents7 = VIPNewsPage.contents.NewsEvents7.getText();
		String NewsEvents8 = VIPNewsPage.contents.NewsEvents8.getText();
		String NewsEvents9 = VIPNewsPage.contents.NewsEvents9.getText();
		String NewsEvents10 = VIPNewsPage.contents.NewsEvents10.getText();
		
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents1);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents1);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents2);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents2);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents3);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents3);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents4);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents4);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents5);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents5);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents6);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents6);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents7);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents7);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents8);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents8);
		//VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents9);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents9);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents10);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents10);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_170");
		
//		ReportLog.setTestCase("WEB_Reg_Auto_171");
//		String AllNews1 = VIPNewsPage.contents.NewsType1Title.getText();
//		String AllNews2 = AllNews1.replace("ALL NEWS (", "");
//		String AllNews1Count = AllNews2.replace(")", "");
//		String AllNews1_1 = VIPNewsPage.contents.NewsType2Title.getText();
//		String AllNews2_1 = AllNews1_1.replace("LEGAL (", "");
//		String AllNews2Count = AllNews2_1.replace(")", "");
//		VIPNewsPage.contents.LastNewsEvents1.verifyDisplayed(true, 3);
//		VIPNewsPage.contents.NewsType2.click();
//		VIPNewsPage.contents.LastNewsEvents2.verifyDisplayed(true, 3);
//		WebControl.takeScreenshot("WEB_Reg_Auto_171");
		
		ReportLog.setTestCase("WEB_Reg_Auto_172");
		VIPNewsPage.contents.TimePeriod1.verifyDisplayed(true, 3);
		VIPNewsPage.contents.TimePeriod1Title.verifyText("LAST ONE MONTH");
		VIPNewsPage.contents.TimePeriod2.verifyDisplayed(true, 3);
		VIPNewsPage.contents.TimePeriod2Title.verifyText("LAST 3 MONTHS");
		VIPNewsPage.contents.TimePeriod3.verifyDisplayed(true, 3);
		VIPNewsPage.contents.TimePeriod3Title.verifyText("LAST 6 MONTHS");
		VIPNewsPage.contents.TimePeriod4.verifyDisplayed(true, 3);
		VIPNewsPage.contents.TimePeriod4Title.verifyText("CUSTOM");
		WebControl.takeScreenshot("WEB_Reg_Auto_172");
		
		ReportLog.setTestCase("WEB_Reg_Auto_173");
		VIPNewsPage.contents.NewsSearchBox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_173");
		
		ReportLog.setTestCase("WEB_Reg_Auto_174");
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents1);
		Thread.sleep(2000);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents1);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		VIPNewsPage.contents.NewsType1Title.verifyText("ALL NEWS (1)");
		WebControl.takeScreenshot("WEB_Reg_Auto_174");
		
		ReportLog.setTestCase("WEB_Reg_Auto_175");
		VIPNewsPage.contents.NewsEvents1.click();
		Thread.sleep(2000);
		VIPNewsPage.contents.NewsDetailsTitle.waitForExist(true, 10);
		VIPNewsPage.contents.NewsDetailsTitle.verifyText(NewsEvents1);
		WebControl.takeScreenshot("WEB_Reg_Auto_175");
		
		ReportLog.setTestCase("WEB_Reg_Auto_176");
		String NewsDetailsBody = VIPNewsPage.contents.NewsDetailsBody.getText();
		String[] NewsBody = NewsDetailsBody.split("\\s");
		String News = NewsBody[1];
		VIPNewsPage.contents.NewsSearchBox.sendKeys(News);
		VIPNewsPage.contents.SearchedWord.verifyText(News);
		WebControl.takeScreenshot("WEB_Reg_Auto_176");
		
		ReportLog.setTestCase("WEB_Reg_Auto_177");
		VIPNewsPage.contents.NewsDetailsBody.verifyDisplayed(true);
		WebControl.takeScreenshot("WEB_Reg_Auto_177");
		
		ReportLog.setTestCase("WEB_Reg_Auto_178");
		VIPNewsPage.contents.NewsSearchBox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_178");
		
		ReportLog.setTestCase("WEB_Reg_Auto_179");
		VIPNewsPage.contents.GoBackToListButton.verifyDisplayed(true, 3);
		VIPNewsPage.contents.GoBackToListButton.click();
		VIPNewsPage.contents.NewsEvents1.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_179");
		
//		ReportLog.setTestCase("WEB_Reg_Auto_180");
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.BackToSearchButton.hover();
//		VIPOverviewPage.contents.BackToSearchButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("publix");
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
//		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
//		Thread.sleep(1000);
//		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPNewsPage.contents.SideMenuNews.click();
//		Thread.sleep(3000);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPNewsPage.contents.NewsEvents1.waitForExist(true, 10);
//		if (VIPNewsPage.contents.SelectedTimePeriod.isDisplayed()) {
//		VIPNewsPage.contents.SelectedTimePeriod.verifyText("LAST 6 MONTHS");}
//		else {VIPNewsPage.contents.SelectedTimePeriod2.verifyText("LAST 6 MONTHS");}
//		WebControl.takeScreenshot("WEB_Reg_Auto_180");
		
	}

	@Test(priority=8)
	public void WEBFunctionality_Architecture () throws Exception {
		ReportLog.setTestName("WEB Functionality - Architecture");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_181");				
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 20);
		String ReportsTotal = VIPLandingPage.contents.ReportsTotal.getText();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(3000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		Thread.sleep(2000);
		VIPLandingPage.contents.UserPhoto.verifyDisplayed(true, 10);
		VIPLandingPage.contents.UserEID.verifyDisplayed(true, 10);
		VIPLandingPage.contents.UserEID.verifyText(testDataHandler.eid);
		WebControl.takeScreenshot("WEB_Reg_Auto_181");
		
		ReportLog.setTestCase("WEB_Reg_Auto_183");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.HelpIcon.click();
		VIPLandingPage.contents.HelpFAQ.hover();
		VIPLandingPage.contents.HelpFAQ.verifyDisplayed(true, 10);
		VIPLandingPage.contents.HelpDUG.hover();
		VIPLandingPage.contents.HelpDUG.verifyDisplayed(true, 10);
		VIPLandingPage.contents.HelpEU.hover();
		VIPLandingPage.contents.HelpEU.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_183");
		
		ReportLog.setTestCase("WEB_Reg_Auto_184");
		VIPLandingPage.contents.HelpES.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_184");
		
		ReportLog.setTestCase("WEB_Reg_Auto_185");
		VIPLandingPage.contents.HelpES.hover();
		VIPLandingPage.contents.HelpES1.verifyText("VIP 2.0 Recorded Enablement Session");
		VIPLandingPage.contents.HelpES2.verifyText("VIP 3.0 Recorded Enablement Session");
		VIPLandingPage.contents.HelpES3.verifyText("VIP COVID-19 Recorded Enablement Session");
		VIPLandingPage.contents.HelpES4.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_185");
		
		ReportLog.setTestCase("WEB_Reg_Auto_186");
		VIPLandingPage.contents.FooterAU.hover();
		VIPLandingPage.contents.FooterAU.verifyDisplayed(true, 5);
		VIPLandingPage.contents.FooterFAQ.hover();
		VIPLandingPage.contents.FooterFAQ.verifyDisplayed(true, 5);
		VIPLandingPage.contents.FooterCU.hover();
		VIPLandingPage.contents.FooterCU.verifyDisplayed(true, 5);
		VIPLandingPage.contents.FooterDUG.hover();
		VIPLandingPage.contents.FooterDUG.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_186");
		
		ReportLog.setTestCase("WEB_Reg_Auto_187");
		DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
		LocalDate datetoday = LocalDate.now();
		String currentYear = year.format(datetoday);
		VIPLandingPage.contents.Copyright1.verifyText("Copyright 2001-" + currentYear + " Value Insights Platform");
		VIPLandingPage.contents.Copyright2.verifyText("Accenture. All rights reserved. Accenture");
		VIPLandingPage.contents.Copyright3.verifyText("confidential. For internal use only.");
		WebControl.takeScreenshot("WEB_Reg_Auto_187");
		
		ReportLog.setTestCase("WEB_Reg_Auto_188");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.HelpIcon.click();
		VIPLandingPage.contents.HelpIcon.click();
		VIPLandingPage.contents.HelpDUG.click();
		Thread.sleep(5000);
		WebControl.switchWithUrl(testDataHandler.userGuideKXSite);
		WebControl.switchWithUrl(testDataHandler.userGuideKXSite);
		Thread.sleep(5000);
		WebControl.takeScreenshot("WEB_Reg_Auto_188");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		WebControl.switchWithTitle("Value Insights Platform");
		
		ReportLog.setTestCase("WEB_Reg_Auto_189");
		VIPLandingPage.contents.FooterDUG.hover();
		VIPLandingPage.contents.FooterDUG.click();
		Thread.sleep(5000);
		WebControl.switchWithUrl(testDataHandler.userGuideKXSite);
		WebControl.switchWithUrl(testDataHandler.userGuideKXSite);
		Thread.sleep(5000);
		WebControl.takeScreenshot("WEB_Reg_Auto_189");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		WebControl.switchWithTitle("Value Insights Platform");
		
		ReportLog.setTestCase("WEB_Reg_Auto_190");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.HelpIcon.click();
		VIPLandingPage.contents.HelpFAQ.click();
		Thread.sleep(5000);
		WebControl.switchWithUrl(testDataHandler.faqKXSite);
		WebControl.switchWithUrl(testDataHandler.faqKXSite);
		Thread.sleep(5000);
		WebControl.takeScreenshot("WEB_Reg_Auto_190");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		WebControl.switchWithTitle("Value Insights Platform");
		
		ReportLog.setTestCase("WEB_Reg_Auto_191");
		VIPLandingPage.contents.FooterFAQ.hover();
		VIPLandingPage.contents.FooterFAQ.click();
		Thread.sleep(5000);
		WebControl.switchWithUrl(testDataHandler.faqKXSite);
		WebControl.switchWithUrl(testDataHandler.faqKXSite);
		Thread.sleep(5000);
		WebControl.takeScreenshot("WEB_Reg_Auto_191");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		WebControl.switchWithTitle("Value Insights Platform");
		
		ReportLog.setTestCase("WEB_Reg_Auto_192");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(2000);
		VIPOverviewPage.contents.GenerateFinancialReportButton.hover();
		VIPOverviewPage.contents.GenerateFinancialReportButton.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_192");
		
		ReportLog.setTestCase("WEB_Reg_Auto_193");
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyText("Download Report");
		VIPOverviewPage.contents.DownloadReportModalBody.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportDownloadButton.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.NotificationCloseButton.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_193");
		
		ReportLog.setTestCase("WEB_Reg_Auto_194");
		VIPOverviewPage.contents.NotificationCloseButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_194");
		
		ReportLog.setTestCase("WEB_Reg_Auto_195_&_196");
		VIPOverviewPage.contents.GenerateFinancialReportButton.hover();
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(5000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.click();
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.ReportsTotal.verifyDisplayed(true, 60);
		VIPLandingPage.contents.ReportsTotal.hover();
		VIPLandingPage.contents.ReportsTotal.verifyText(ReportsTotal, false);
		WebControl.takeScreenshot("WEB_Reg_Auto_195_&_196");
		
		ReportLog.setTestCase("WEB_Reg_Auto_197");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.CompanyNameTextbox.hover();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Huawei");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(3000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.EnterpriseValue.waitForExist(true, 60);
		VIPOverviewPage.contents.RBBPieChartTitle.waitForExist(true, 10);
		Thread.sleep(1500);
		VIPOverviewPage.contents.GenerateFinancialReportButton.hover();
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(2500);
		VIPOverviewPage.contents.DownloadReportModalHeader2.verifyText("Add Peers");
		WebControl.takeScreenshot("WEB_Reg_Auto_197");
		

		
	}

}


