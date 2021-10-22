package scenarios.Q2A;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Q2A_13_GeographicSegmentAnalysis extends TestBase{
	
	@Test
	public void Q2A_GeographicSegmentAnalysis () throws Exception {
		ReportLog.setTestName("Q2A - Geographic Segment Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_129");
		VIP_Common.LogInPage(testDataHandler);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.StartNowButton.click();
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdownText.verifyText("All Segments");
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdownMenu2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdownMenu3.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdownMenu4.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdownMenu5.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Regression_129");
		
		ReportLog.setTestCase("Q2A_Regression_130");
		VIPFinancialsPage.contents.SegmentDropdown.click();
		String[] RBSPieChartTimePeriod1 = VIPFinancialsPage.contents.RBSPieChartTimePeriod.getText().split("\\s");
		//String RBSPieChartTimePeriod = RBSPieChartTimePeriod1.substring(7, 14);
		VIPFinancialsPage.contents.RBSPieChart2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RBSPieChartTitle.verifyText("REVENUE BY SEGMENT");
		VIPFinancialsPage.contents.RBSPieChartTimePeriod.verifyText(RBSPieChartTimePeriod1[0] + " – " + RBSPieChartTimePeriod1[2].replace(",", "") + ", % by Revenue]");
		WebControl.takeScreenshot("Q2A_Regression_130");
		
		ReportLog.setTestCase("Q2A_Regression_135");
		VIPFinancialsPage.contents.GSAFootnote.verifyDisplayed(true, 5);
		String GSAFootnote = VIPFinancialsPage.contents.GSAFootnote.getText();
		WebControl.takeScreenshot("Q2A_Regression_135");
		
		ReportLog.setTestCase("Q2A_Regression_136");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsIcon1.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Regression_136");
		
		ReportLog.setTestCase("Q2A_Regression_137_&_138");
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		if (VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ATBarChartTitle.verifyText("ASSET TURNOVER");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(true, 5);}
		else if (VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & !VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		else if (!VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ATBarChartTitle.verifyText("ASSET TURNOVER");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		else {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu3.click();
		if (VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ATBarChartTitle.verifyText("ASSET TURNOVER");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(true, 5);}
		else if (VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & !VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		else if (!VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ATBarChartTitle.verifyText("ASSET TURNOVER");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		else {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		WebControl.takeScreenshot("Q2A_Regression_137_&_138");

		ReportLog.setTestCase("Q2A_Regression_139");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		Thread.sleep(1500);
//		String Legend1 = VIPOverviewPage.contents.RBGPieChartLegendText1.getText();
//		String Legend2 = VIPOverviewPage.contents.RBGPieChartLegendText2.getText();
		VIPOverviewPage.contents.RBGPieChart.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBGPieChartTitle.verifyText("Revenue by Geography");
		VIPOverviewPage.contents.RBGPieChartTimePeriod.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBGPieChartLegendIcon1.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBGPieChartLegendIcon2.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBGPieChartLegendText1.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBGPieChartLegendText2.verifyDisplayed(true, 5);
//		VIPOverviewPage.contents.RBGPieChartLegendText1.hover();
//		Thread.sleep(1500);
//		VIPOverviewPage.contents.RBGPieChartLegendTooltip.verifyText(Legend1);
//		VIPOverviewPage.contents.RBGPieChartLegendText2.hover();
//		Thread.sleep(1500);
//		VIPOverviewPage.contents.RBGPieChartLegendTooltip.verifyText(Legend2);
		WebControl.takeScreenshot("Q2A_Regression_139");
		
		ReportLog.setTestCase("Q2A_Regression_140_Prep");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		
		if (VIPFinancialsPage.contents.GSAKeyInsights1.isDisplayed() & VIPFinancialsPage.contents.GSAKeyInsights2.isDisplayed()) {
		String Menu1KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		String Menu2KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		String Menu2KeyInsights2 = VIPFinancialsPage.contents.GSAKeyInsights2.getText();
		WebControl.takeScreenshot("Q2A_Regression_140_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_140_Validation");
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.StartNowButton.click();
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
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyText(Menu1KeyInsights1);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyText(Menu2KeyInsights1);
		VIPFinancialsPage.contents.GSAKeyInsights2.verifyText(Menu2KeyInsights2);
		VIPFinancialsPage.contents.GSAFootnote.verifyText(GSAFootnote);}
		
		else if (VIPFinancialsPage.contents.GSAKeyInsights1.isDisplayed() & !VIPFinancialsPage.contents.GSAKeyInsights2.isDisplayed()) {
		String Menu1KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		String Menu2KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		WebControl.takeScreenshot("Q2A_Regression_140_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_140_Validation");
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.StartNowButton.click();
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
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyText(Menu1KeyInsights1);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyText(Menu2KeyInsights1);
		VIPFinancialsPage.contents.GSAFootnote.verifyText(GSAFootnote);}
		
		else {
		WebControl.takeScreenshot("Q2A_Regression_140_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_140_Validation");
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.StartNowButton.click();
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
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.GSAFootnote.verifyText(GSAFootnote);}
		WebControl.takeScreenshot("Q2A_Regression_140_Validation");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
}


