package scenarios.Q2A;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPFinancialsPage;


public class Q2A_03_TRS extends TestBase{
	
	@Test
	public void Q2A_TRS () throws Exception {
		ReportLog.setTestName("Financials - TRS");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_024_TRSDefault");
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.verifyDisplayed(true, 20);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown2.click();
		VIPFinancialsPage.contents.TotalReturnToShareHolders.verifyText("Total Return to Shareholders");
		WebControl.takeScreenshot("Q2A_Reg_Auto_024_TRSDefault");

		ReportLog.setTestCase("Q2A_Reg_Auto_025_to_027");//withQ2A_Reg_Auto_009
		VIPFinancialsPage.contents.YearTRS.verifyText("3-year TRS");
		VIPFinancialsPage.contents.LeftChartTitle.verifyText("3-YEAR TRS DEVELOPMENT");
		VIPFinancialsPage.contents.RightChartTitle.verifyText("3-YEAR TRS CAGR");
		VIPFinancialsPage.contents.TimePeriodLineChart.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSInfoIcon.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSInfoIcon.hover();
		VIPFinancialsPage.contents.TRSInfoIcon.click();
		VIPFinancialsPage.contents.TRSInfoIconText.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.TimePeriodBarChart.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.SelectTimeframe.click();
		VIPFinancialsPage.contents.DropdownList1.click();
		VIPFinancialsPage.contents.LeftChartContainer.waitForExist(true, 20);
		VIPFinancialsPage.contents.RightChartContainer.waitForExist(true, 20);
		VIPFinancialsPage.contents.YearTRS.verifyText("1-year TRS");
		VIPFinancialsPage.contents.LeftChartTitle.verifyText("1-YEAR TRS DEVELOPMENT");
		VIPFinancialsPage.contents.RightChartTitle.verifyText("1-YEAR TRS GROWTH");
		VIPFinancialsPage.contents.TimePeriodLineChart.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSInfoIcon.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSInfoIcon.hover();
		VIPFinancialsPage.contents.TRSInfoIcon.click();
		VIPFinancialsPage.contents.TRSInfoIconText.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.TimePeriodBarChart.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.SelectTimeframe.click();
		VIPFinancialsPage.contents.DropdownList3.click();
		VIPFinancialsPage.contents.LeftChartContainer.waitForExist(true, 20);
		VIPFinancialsPage.contents.RightChartContainer.waitForExist(true, 20);
		VIPFinancialsPage.contents.YearTRS.verifyText("5-year TRS");
		VIPFinancialsPage.contents.LeftChartTitle.verifyText("5-YEAR TRS DEVELOPMENT");
		VIPFinancialsPage.contents.RightChartTitle.verifyText("5-YEAR TRS CAGR");
		VIPFinancialsPage.contents.TimePeriodLineChart.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSInfoIcon.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSInfoIcon.hover();
		VIPFinancialsPage.contents.TRSInfoIcon.click();
		VIPFinancialsPage.contents.TRSInfoIconText.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.TRSInfoIcon.click();
		VIPFinancialsPage.contents.TimePeriodBarChart.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("Q2A_Reg_Auto_025_to_027");//withQ2A_Reg_Auto_009
		
		ReportLog.setTestCase("Q2A_Reg_Auto_031_TRSKeyInsights");
		VIPFinancialsPage.contents.TRSKeyInsightsTitle.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSCompetitivePositionGauge1.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSCompetitivePositionGauge2.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSCompetitivePosition1.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSCompetitivePosition2.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("Q2A_Reg_Auto_031_TRSKeyInsights");
		
		if (VIPFinancialsPage.contents.TRSFootNoteCompanies.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Reg_Auto_030_TRSFootnote");
		VIPFinancialsPage.contents.TRSFootNoteCompanies.verifyDisplayed(true, 10);
		String TRSCP1 = VIPFinancialsPage.contents.TRSCompetitivePosition1.getText();
		String TRSCP2 = VIPFinancialsPage.contents.TRSCompetitivePosition2.getText();
		String TRSFootNoteCompanies = VIPFinancialsPage.contents.TRSFootNoteCompanies.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_030_TRSFootnote");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_032");
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		Thread.sleep(3000);
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown2.click();
		VIPFinancialsPage.contents.TRSCompetitivePosition1.verifyText(TRSCP1);
		VIPFinancialsPage.contents.TRSCompetitivePosition2.verifyText(TRSCP2);
		VIPFinancialsPage.contents.TRSFootNoteCompanies.verifyText(TRSFootNoteCompanies);
		WebControl.takeScreenshot("Q2A_Reg_Auto_032");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Reg_Auto_030_TRSFootnote");
		VIPFinancialsPage.contents.TRSFootNoteCompanies.verifyDisplayed(false);
		String TRSCP1 = VIPFinancialsPage.contents.TRSCompetitivePosition1.getText();
		String TRSCP2 = VIPFinancialsPage.contents.TRSCompetitivePosition2.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_030_TRSFootnote");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_032");
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		Thread.sleep(3000);
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown2.click();
		VIPFinancialsPage.contents.TRSCompetitivePosition1.verifyText(TRSCP1);
		VIPFinancialsPage.contents.TRSCompetitivePosition2.verifyText(TRSCP2);
		WebControl.takeScreenshot("Q2A_Reg_Auto_032");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
				
	}
	
}
	
