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


public class Q2A_08_EmployeeProductivity extends TestBase{
	
	@Test
	public void Q2A_EmployeeProductivity () throws Exception {
		ReportLog.setTestName("Financials - Employee Productivity");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_066_EmpProdCharts");	
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
		VIPFinancialsPage.contents.SelectDashboardDropDown.verifyDisplayed(true, 15);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		//EmployeeProductivity
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown7.click();
		VIPFinancialsPage.contents.EmpProdBarChart1.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EmpProdBarChart2.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EmpProdBarChart3.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EmpProdIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndRPEMenu.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.IndAOEMenu.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.IndEPEMenu.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EmpProdIndicatorDropdown.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_066_EmpProdCharts");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_067_EmpProdCurrency");
		VIPFinancialsPage.contents.EmpProdCurrency1.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EmpProdCurrency2.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EmpProdCurrencyTTM.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("Q2A_Reg_Auto_067_EmpProdCurrency");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_070_EmpProdKeyInsights");
		VIPFinancialsPage.contents.EmpProdKeyInsightsTitle.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsSP.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsCP.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsBest.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsSPIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsCPIcon.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsBestIcon.verifyDisplayed(true, 3);
		String SP = VIPFinancialsPage.contents.EmpProdEKeyInsightsSP.getText();
		String CP = VIPFinancialsPage.contents.EmpProdEKeyInsightsCP.getText();
		String Best = VIPFinancialsPage.contents.EmpProdEKeyInsightsBest.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_070_EmpProdKeyInsights");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_071_1");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BenchmarkButton.verifyText("Accenture Proprietary EVT Benchmarks");
		VIPFinancialsPage.contents.BenchmarkButton.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("This is EVT team's database which includes FTE and Cost benchmarks per SG&A function (Finance, HR, Procurement etc.)");
		VIPFinancialsPage.contents.BenchmarkLink.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_071_1");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_071_2");
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndRPEMenu.click();
		VIPFinancialsPage.contents.ChartHeader.verifyText("REVENUE PER EMPLOYEE");
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndAOEMenu.click();
		VIPFinancialsPage.contents.ChartHeader.verifyText("AVERAGE # OF EMPLOYEES");
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndEPEMenu.click();
		VIPFinancialsPage.contents.ChartHeader.verifyText("EBIT PER EMPLOYEE");
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndRPEMenu.click();
		Thread.sleep(2000);
		WebControl.takeScreenshot("Q2A_Reg_Auto_071_2");
		
		if (VIPFinancialsPage.contents.FootNote.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Reg_Auto_072");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(true, 5);
		String FootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_072");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_073");
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
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown7.click();
		VIPFinancialsPage.contents.EmpProdEKeyInsightsSP.verifyText(SP);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsCP.verifyText(CP);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsBest.verifyText(Best);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_073");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Reg_Auto_072");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_072");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_073");
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
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown7.click();
		VIPFinancialsPage.contents.EmpProdEKeyInsightsSP.verifyText(SP);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsCP.verifyText(CP);
		VIPFinancialsPage.contents.EmpProdEKeyInsightsBest.verifyText(Best);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_073");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
				
	}
	
}
	
