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


public class Q2A_06_RevenueProfitEstimates extends TestBase{
	
	@Test
	public void Q2A_RevenueProfitEstimates () throws Exception {
		ReportLog.setTestName("Financials - Revenue Profit Estimates");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_051_to_053_RPECharts");	
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
		//RevenueandProfitabilityEstimates
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown5.click();
		VIPFinancialsPage.contents.RPELeftChartTitle.verifyText("REVENUE YOY GROWTH ESTIMATES");
		VIPFinancialsPage.contents.RPELeftChartContainer.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPERightChartTitle.verifyText("REVENUE CAGR");
		VIPFinancialsPage.contents.RPERightChartContainer.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPELeftChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPERightChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.hover();
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.click();
		VIPFinancialsPage.contents.RPEInfoIconText.verifyText("Revenue Growth Estimates are based on the average analyst consensus revenue forecasts for a given period.");
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.click();
		VIPFinancialsPage.contents.RPEIndicatorDropdown.click();
		VIPFinancialsPage.contents.RPEIndicatorDropdownMenu2.click();
		VIPFinancialsPage.contents.RPELeftChartTitle.verifyText("EBIT MARGIN ESTIMATES");
		VIPFinancialsPage.contents.RPELeftChartContainer.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPERightChartTitle.verifyText("CHANGE IN EBIT MARGIN (PPS)");
		VIPFinancialsPage.contents.RPERightChartContainer.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPELeftChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPERightChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.hover();
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.click();
		VIPFinancialsPage.contents.RPEInfoIconText.verifyText("EBIT margin is a measure of a company's operating profit from core operations, calculated as its earnings before interest and taxes as a percentage of revenues. EBIT Margin Estimates are based on the average analyst consensus EBIT margin forecast for a given period.");
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.click();
		VIPFinancialsPage.contents.RPEIndicatorDropdown.click();
		VIPFinancialsPage.contents.RPEIndicatorDropdownMenu3.click();
		VIPFinancialsPage.contents.RPELeftChartTitle.verifyText("EBITDA MARGIN ESTIMATES");
		VIPFinancialsPage.contents.RPELeftChartContainer.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPERightChartTitle.verifyText("CHANGE IN EBITDA MARGIN (PPS)");
		VIPFinancialsPage.contents.RPERightChartContainer.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPELeftChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPERightChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.hover();
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.click();
		VIPFinancialsPage.contents.RPEInfoIconText.verifyText("EBITDA margin is a measure of a company's operating profit from core operations, calculated as its earnings before interest, taxes, depreciation, and amortization as a percentage of revenues. EBITDA Margin Estimates are based on the average analyst consensus EBITDA margin forecast for a given period.");
		VIPFinancialsPage.contents.RPELeftChartInfoIcon.click();
		VIPFinancialsPage.contents.RPEIndicatorDropdown.click();
		VIPFinancialsPage.contents.RPEIndicatorDropdownMenu1.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_051_to_053_RPECharts");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_057_RPEKeyInsights");
		VIPFinancialsPage.contents.RPEKeyInsightsTitle.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPEStandAloneGauge1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPECompetitivePositionGauge1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPECompetitivePositionGauge2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPEKeyInsightsStarIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPEStandAlone.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPECompetitivePosition1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPECompetitivePosition2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPEKeyInsightsBest.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Reg_Auto_057_RPEKeyInsights");
		
		if (VIPFinancialsPage.contents.RPEFootNoteForecast.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Reg_Auto_056_RPEFootnote");
		VIPFinancialsPage.contents.RPEFootNoteForecast.verifyDisplayed(true, 3);
		String SP = VIPFinancialsPage.contents.RPEStandAlone.getText();
		String CP1 = VIPFinancialsPage.contents.RPECompetitivePosition1.getText();
		String CP2 = VIPFinancialsPage.contents.RPECompetitivePosition2.getText();
		String Best = VIPFinancialsPage.contents.RPEKeyInsightsBest.getText();
		String RPEFootNoteForecast = VIPFinancialsPage.contents.RPEFootNoteForecast.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_056_RPEFootnote");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_058");
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
		VIPFinancialsPage.contents.SelectDropDown5.click();
		VIPFinancialsPage.contents.RPEStandAlone.verifyText(SP);
		VIPFinancialsPage.contents.RPECompetitivePosition1.verifyText(CP1);
		VIPFinancialsPage.contents.RPECompetitivePosition2.verifyText(CP2);
		VIPFinancialsPage.contents.RPEKeyInsightsBest.verifyText(Best);
		VIPFinancialsPage.contents.RPEFootNoteForecast.verifyText(RPEFootNoteForecast);
		WebControl.takeScreenshot("Q2A_Reg_Auto_058");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Reg_Auto_056_RPEFootnote");
		VIPFinancialsPage.contents.RPEFootNoteForecast.verifyDisplayed(false);
		String SP = VIPFinancialsPage.contents.RPEStandAlone.getText();
		String CP1 = VIPFinancialsPage.contents.RPECompetitivePosition1.getText();
		String CP2 = VIPFinancialsPage.contents.RPECompetitivePosition2.getText();
		String Best = VIPFinancialsPage.contents.RPEKeyInsightsBest.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_056_RPEFootnote");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_058");
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
		VIPFinancialsPage.contents.SelectDropDown5.click();
		VIPFinancialsPage.contents.RPEStandAlone.verifyText(SP);
		VIPFinancialsPage.contents.RPECompetitivePosition1.verifyText(CP1);
		VIPFinancialsPage.contents.RPECompetitivePosition2.verifyText(CP2);
		VIPFinancialsPage.contents.RPEKeyInsightsBest.verifyText(Best);
		VIPFinancialsPage.contents.RPEFootNoteForecast.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_058");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		
	}
	
}
	
