package scenarios.Q2A;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class Q2A_12_BusinessSegmentAnalysis extends TestBase{
	
	@Test
	public void Q2A_BusinessSegmentAnalysis () throws Exception {
		ReportLog.setTestName("Q2A - Business Segment Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_117");			
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
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown11.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdownText.verifyText("All Segments");
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdownMenu2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdownMenu3.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Regression_117");
		
		ReportLog.setTestCase("Q2A_Regression_118");
		String[] RBSPieChartTimePeriod1 = VIPFinancialsPage.contents.RBSPieChartTimePeriod.getText().split("\\s");
		//String RBSPieChartTimePeriod = RBSPieChartTimePeriod1.substring(7, 14);
		VIPFinancialsPage.contents.RBSPieChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RBSPieChartTitle.verifyText("REVENUE BY SEGMENT");
		VIPFinancialsPage.contents.RBSPieChartTimePeriod.verifyText(RBSPieChartTimePeriod1[0] + " – " + RBSPieChartTimePeriod1[2].replace(",", "") + ", % by Revenue]");
		WebControl.takeScreenshot("Q2A_Regression_118");
		
		ReportLog.setTestCase("Q2A_Regression_123");
		VIPFinancialsPage.contents.BSAFootnote.verifyDisplayed(true, 5);
		String BSAFootnote = VIPFinancialsPage.contents.BSAFootnote.getText();
		WebControl.takeScreenshot("Q2A_Regression_123");
		
		ReportLog.setTestCase("Q2A_Regression_124_1");
		VIPFinancialsPage.contents.BSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsights2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsightsIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsightsIcon2.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Regression_124_1");
		
		ReportLog.setTestCase("Q2A_Regression_124_2");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Spotify");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown11.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsights2.verifyDisplayed(false);
		VIPFinancialsPage.contents.BSAKeyInsightsIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsightsIcon2.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Regression_124_2");
		
		ReportLog.setTestCase("Q2A_Regression_125_&_126");
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.BSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu3.click();
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.BSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Regression_125_&_126");

		ReportLog.setTestCase("Q2A_Regression_127");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		Thread.sleep(1500);
		String Legend1 = VIPOverviewPage.contents.RBBPieChartLegendText1.getText();
		String Legend2 = VIPOverviewPage.contents.RBBPieChartLegendText2.getText();
		VIPOverviewPage.contents.RBBPieChart.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBBPieChartTitle.verifyText("Revenue by Business");
		VIPOverviewPage.contents.RBBPieChartTimePeriod.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBBPieChartLegendIcon1.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBBPieChartLegendIcon2.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBBPieChartLegendText1.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBBPieChartLegendText2.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBBPieChartLegendText1.hover();
		VIPOverviewPage.contents.RBBPieChartLegendTooltip.verifyText(Legend1);
		VIPOverviewPage.contents.RBBPieChartLegendText2.hover();
		VIPOverviewPage.contents.RBBPieChartLegendTooltip.verifyText(Legend2);
		WebControl.takeScreenshot("Q2A_Regression_127");
		
		ReportLog.setTestCase("Q2A_Regression_128_Prep");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown11.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		
		if (VIPFinancialsPage.contents.BSAKeyInsights1.isDisplayed() & VIPFinancialsPage.contents.BSAKeyInsights2.isDisplayed()) {
		String Menu1KeyInsights1 = VIPFinancialsPage.contents.BSAKeyInsights1.getText();
		String Menu1KeyInsights2 = VIPFinancialsPage.contents.BSAKeyInsights2.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		String Menu2KeyInsights1 = VIPFinancialsPage.contents.BSAKeyInsights1.getText();
		String Menu2KeyInsights2 = VIPFinancialsPage.contents.BSAKeyInsights2.getText();
		WebControl.takeScreenshot("Q2A_Regression_128_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_128_Validation");
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown11.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyText(Menu1KeyInsights1);
		VIPFinancialsPage.contents.BSAKeyInsights2.verifyText(Menu1KeyInsights2);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyText(Menu2KeyInsights1);
		VIPFinancialsPage.contents.BSAKeyInsights2.verifyText(Menu2KeyInsights2);
		VIPFinancialsPage.contents.BSAFootnote.verifyText(BSAFootnote);}
		
		else if (VIPFinancialsPage.contents.BSAKeyInsights1.isDisplayed() & !VIPFinancialsPage.contents.BSAKeyInsights2.isDisplayed()) {
		String Menu1KeyInsights1 = VIPFinancialsPage.contents.BSAKeyInsights1.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		String Menu2KeyInsights1 = VIPFinancialsPage.contents.BSAKeyInsights1.getText();
		WebControl.takeScreenshot("Q2A_Regression_128_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_128_Validation");
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown11.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyText(Menu1KeyInsights1);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyText(Menu2KeyInsights1);
		VIPFinancialsPage.contents.BSAFootnote.verifyText(BSAFootnote);}
		
		else {
		WebControl.takeScreenshot("Q2A_Regression_128_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_128_Validation");
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown11.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.BSAFootnote.verifyText(BSAFootnote);}
		WebControl.takeScreenshot("Q2A_Regression_128_Validation");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
}


