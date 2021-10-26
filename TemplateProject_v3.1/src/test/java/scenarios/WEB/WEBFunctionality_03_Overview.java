package scenarios.WEB;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

public class WEBFunctionality_03_Overview extends TestBase{
	
		
	@Test
	public void WEBFunctionality_Overview () throws Exception {
		ReportLog.setTestName("WEB Functionality - Overview");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_099");
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
	
}


