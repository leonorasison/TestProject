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
import pageobjects.VIPSalesPage;
import pageobjects.VIPFinancialsPage;


public class Q2A_05_AnalystRecommendation extends TestBase{
	
	@Test
	public void Q2A_AnalystRecommendation () throws Exception {
		ReportLog.setTestName("Financials - Analyst Recommendation");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_043_ARCharts");		
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
		VIPFinancialsPage.contents.SelectDashboardDropDown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		//AnalystRecommendations
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown4.click();
		VIPFinancialsPage.contents.AnalystLeftChartTitle.verifyText("ANALYST RATINGS");
		VIPFinancialsPage.contents.AnalystLeftChartContainer.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.AnalystRightChartTitle.verifyText("EXPECTED 1-YEAR SHARE PRICE GROWTH");
		VIPFinancialsPage.contents.AnalystRightChartContainer.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("Q2A_Reg_Auto_043_ARCharts");
		
		ReportLog.setTestCase("Q2A_Regression_044");
		VIPFinancialsPage.contents.AnalystLeftChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.AnalystRightChartDate.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_044");
		
		ReportLog.setTestCase("Q2A_Regression_045");
		VIPFinancialsPage.contents.AnalystLeftChartInfoIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.AnalystRightChartInfoIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.AnalystLeftChartInfoIcon.hover();
		VIPFinancialsPage.contents.AnalystLeftChartInfoIcon.click();
		VIPFinancialsPage.contents.AnalystInfoIconText.verifyText("Analyst consensus rating is the average of analysts' rating about a stock's share price performance over the next one year.");
		VIPFinancialsPage.contents.AnalystRightChartInfoIcon.hover();
		VIPFinancialsPage.contents.AnalystRightChartInfoIcon.click();
		VIPFinancialsPage.contents.AnalystInfoIconText.verifyText("Analysts' estimated share price change in next 1 year compared to current price level.");
		WebControl.takeScreenshot("Q2A_Regression_045");
		
		ReportLog.setTestCase("Q2A_Regression_049");
		VIPFinancialsPage.contents.AnalystKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.AnalystKeyInsightsSPIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.AnalystKeyInsightsCPIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.AnalystKeyInsightsBestIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.AnalystKeyInsightsSP.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.AnalystKeyInsightsCP.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.AnalystKeyInsightsBest.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_049");
		
		if (VIPFinancialsPage.contents.AnalystFootnote.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Reg_Auto_048");
		VIPFinancialsPage.contents.AnalystFootnote.verifyDisplayed(true, 5);
		String SP = VIPFinancialsPage.contents.AnalystKeyInsightsSP.getText();
		String CP = VIPFinancialsPage.contents.AnalystKeyInsightsCP.getText();
		String Best = VIPFinancialsPage.contents.AnalystKeyInsightsBest.getText();
		String AnalystFootnote = VIPFinancialsPage.contents.AnalystFootnote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_048");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_050");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
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
		VIPFinancialsPage.contents.SelectDropDown4.click();
		VIPFinancialsPage.contents.AnalystKeyInsightsSP.verifyText(SP);
		VIPFinancialsPage.contents.AnalystKeyInsightsCP.verifyText(CP);
		VIPFinancialsPage.contents.AnalystKeyInsightsBest.verifyText(Best);
		VIPFinancialsPage.contents.AnalystFootnote.verifyText(AnalystFootnote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_050");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Reg_Auto_048");
		VIPFinancialsPage.contents.AnalystFootnote.verifyDisplayed(false);
		String SP = VIPFinancialsPage.contents.AnalystKeyInsightsSP.getText();
		String CP = VIPFinancialsPage.contents.AnalystKeyInsightsCP.getText();
		String Best = VIPFinancialsPage.contents.AnalystKeyInsightsBest.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_048");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_050");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
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
		VIPFinancialsPage.contents.SelectDropDown4.click();
		VIPFinancialsPage.contents.AnalystKeyInsightsSP.verifyText(SP);
		VIPFinancialsPage.contents.AnalystKeyInsightsCP.verifyText(CP);
		VIPFinancialsPage.contents.AnalystKeyInsightsBest.verifyText(Best);
		VIPFinancialsPage.contents.AnalystFootnote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_050");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
				
	}
	
}
	
