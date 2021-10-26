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


public class Q2A_04_EVICDecomposition extends TestBase{
	
	@Test
	public void Q2A_EVICDecomposition () throws Exception {
		ReportLog.setTestName("Financials - EVIC Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Regression_033");
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
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown3.click();
		VIPFinancialsPage.contents.EvicChartTitle.verifyText("PREMIUM ON INVESTED CAPITAL (EV/IC)");
		VIPFinancialsPage.contents.EVEbitTitle.verifyText("EV/EBIT");
		VIPFinancialsPage.contents.EbitICTitle.verifyText("PRE-TAX ROIC (EBIT/IC)");
		WebControl.takeScreenshot("Q2A_Regression_033");
		
		ReportLog.setTestCase("Q2A_Regression_034");
		VIPFinancialsPage.contents.FChartIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.XChartIcon.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_034");
		
		ReportLog.setTestCase("Q2A_Regression_035");
		VIPFinancialsPage.contents.EvicInfoIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EVEbitInfoIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EbitICInfoIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicInfoIcon.hover();
		VIPFinancialsPage.contents.EvicInfoIcon.click();
		VIPFinancialsPage.contents.EvicInfoIconText.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.EVEbitInfoIcon.hover();
		VIPFinancialsPage.contents.EVEbitInfoIcon.click();
		VIPFinancialsPage.contents.EvicInfoIconText.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.EbitICInfoIcon.hover();
		VIPFinancialsPage.contents.EbitICInfoIcon.click();
		VIPFinancialsPage.contents.EvicInfoIconText.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Regression_035");
		
		ReportLog.setTestCase("Q2A_Regression_036");
		VIPFinancialsPage.contents.EvicDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EVEbitDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EbitICDate.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_036");
		
		ReportLog.setTestCase("Q2A_Regression_037");
		VIPFinancialsPage.contents.EVEbitICContainer.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_037");
		
		ReportLog.setTestCase("Q2A_Regression_041");
		VIPFinancialsPage.contents.EvicKeyInsightsHeader.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.EvicKeyInsightsTitle1.verifyText("Premium on Invested Capital");
		VIPFinancialsPage.contents.EvicKeyInsightsTitle2.verifyText("Future Expectations - EV/EBIT");
		VIPFinancialsPage.contents.EvicKeyInsightsTitle3.verifyText("Operating Performance – Pre-Tax ROIC (EBIT/IC)");
		VIPFinancialsPage.contents.EvicKeyInsightsGaugeIcon1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsGaugeIcon2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsGaugeIcon3.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsStarIcon1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsStarIcon2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsStarIcon3.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsCP1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsCP2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsCP3.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsBest1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsBest2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EvicKeyInsightsBest3.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_041");
		
		if (VIPFinancialsPage.contents.EvicFootNoteCompanies.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Regression_040");
		VIPFinancialsPage.contents.EvicFootNoteCompanies.verifyText("Note: EBIT / IC uses invested capital value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global .");
		String CP1 = VIPFinancialsPage.contents.EvicKeyInsightsCP1.getText();
		String CP2 = VIPFinancialsPage.contents.EvicKeyInsightsCP2.getText();
		String CP3 = VIPFinancialsPage.contents.EvicKeyInsightsCP3.getText();
		String Best1 = VIPFinancialsPage.contents.EvicKeyInsightsBest1.getText();
		String Best2 = VIPFinancialsPage.contents.EvicKeyInsightsBest2.getText();
		String Best3 = VIPFinancialsPage.contents.EvicKeyInsightsBest3.getText();
		String EvicFootNoteCompanies = VIPFinancialsPage.contents.EvicFootNoteCompanies.getText();
		VIPFinancialsPage.contents.FootNoteMethodologyLink.click();
		VIPFinancialsPage.contents.MethodologyTitle.waitForExist(true, 10);
		VIPFinancialsPage.contents.MethodologyTitle.verifyText("METHODOLOGY");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown3.click();
		WebControl.takeScreenshot("Q2A_Regression_040");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_042");
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
		VIPFinancialsPage.contents.SelectDropDown3.click();
		VIPFinancialsPage.contents.EvicKeyInsightsCP1.verifyText(CP1);
		VIPFinancialsPage.contents.EvicKeyInsightsCP2.verifyText(CP2);
		VIPFinancialsPage.contents.EvicKeyInsightsCP3.verifyText(CP3);
		VIPFinancialsPage.contents.EvicKeyInsightsBest1.verifyText(Best1);
		VIPFinancialsPage.contents.EvicKeyInsightsBest2.verifyText(Best2);
		VIPFinancialsPage.contents.EvicKeyInsightsBest3.verifyText(Best3);
		VIPFinancialsPage.contents.EvicFootNoteCompanies.verifyText(EvicFootNoteCompanies);
		WebControl.takeScreenshot("Q2A_Reg_Auto_042");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Regression_040");
		VIPFinancialsPage.contents.EvicFootNoteCompanies.verifyDisplayed(false);
		String CP1 = VIPFinancialsPage.contents.EvicKeyInsightsCP1.getText();
		String CP2 = VIPFinancialsPage.contents.EvicKeyInsightsCP2.getText();
		String CP3 = VIPFinancialsPage.contents.EvicKeyInsightsCP3.getText();
		String Best1 = VIPFinancialsPage.contents.EvicKeyInsightsBest1.getText();
		String Best2 = VIPFinancialsPage.contents.EvicKeyInsightsBest2.getText();
		String Best3 = VIPFinancialsPage.contents.EvicKeyInsightsBest3.getText();
		WebControl.takeScreenshot("Q2A_Regression_040");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_042");
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
		VIPFinancialsPage.contents.SelectDropDown3.click();
		VIPFinancialsPage.contents.EvicKeyInsightsCP1.verifyText(CP1);
		VIPFinancialsPage.contents.EvicKeyInsightsCP2.verifyText(CP2);
		VIPFinancialsPage.contents.EvicKeyInsightsCP3.verifyText(CP3);
		VIPFinancialsPage.contents.EvicKeyInsightsBest1.verifyText(Best1);
		VIPFinancialsPage.contents.EvicKeyInsightsBest2.verifyText(Best2);
		VIPFinancialsPage.contents.EvicKeyInsightsBest3.verifyText(Best3);
		VIPFinancialsPage.contents.EvicFootNoteCompanies.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_042");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
				
	}
	
}
	
