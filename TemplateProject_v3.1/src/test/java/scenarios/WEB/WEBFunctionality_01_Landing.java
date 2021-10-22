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

public class WEBFunctionality_01_Landing extends TestBase{
	
	@Test	
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
		VIPOverviewPage.contents.GenerateFinancialReportButton.verifyDisplayed(true, 10);
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
	
}


