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
import pageobjects.VIPTranscriptPage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class WEBFunctionality_Financials_Old extends TestBase{
	
	@Test
	public void WEBFunctionality_Financials () throws Exception {
		ReportLog.setTestName("WEB Functionality - Financials");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
			
		ReportLog.setTestCase("Reg_Auto_81");
		VIP_Common.LogInPage(testDataHandler);
		Thread.sleep(3000);
		//VIPLandingPage.contents.NewQVWarningCloseButton.click();
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		Thread.sleep(1000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(1000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false, 2);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false, 2);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(false, 2);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Uber");
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		//VIPFinancialsPage.contents.SideMenuFinancialsHover.click();
		VIPOverviewPage.contents.EBITMarginTitle.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.EBITMarginValue.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Reg_Auto_81");
		
		ReportLog.setTestCase("Reg_Auto_82");
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("HC2 Holdings");
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(3000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		VIPOverviewPage.contents.EnterpriseValueTitle.verifyDisplayed(true, 10);
		VIPOverviewPage.contents.EnterpriseValueTitle.hover();
		VIPOverviewPage.contents.EnterpriseValue.verifyText("-");
		WebControl.takeScreenshot("Reg_Auto_82");
		
		ReportLog.setTestCase("Reg_Auto_83");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.waitForExist(true, 10);
		VIPFinancialsPage.contents.FinancialsMetricsTitle.hover();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("TOTAL RETURN TO SHAREHOLDERS");
		VIPFinancialsPage.contents.RevenueGrowth.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("REVENUE GROWTH");
		VIPFinancialsPage.contents.COGSRevenue.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("COGS / REVENUE");
		VIPFinancialsPage.contents.SGARevenue.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("SG&A / REVENUE");
		VIPFinancialsPage.contents.EBITMargin.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("EBIT MARGIN");
		VIPFinancialsPage.contents.EBITDAMargin.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("EBITDA MARGIN");
		VIPFinancialsPage.contents.PTRInvestedCapital.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("PRE-TAX RETURN ON INVESTED CAPITAL");
		VIPFinancialsPage.contents.CapitalEfficiency.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("CAPITAL EFFICIENCY");
		VIPFinancialsPage.contents.DIO.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("DAYS INVENTORY OUTSTANDING");
		VIPFinancialsPage.contents.DPO.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("DAYS PAYABLE OUTSTANDING");
		VIPFinancialsPage.contents.DSO.click();
		VIPFinancialsPage.contents.FinancialsMetricsTitle.verifyText("DAYS SALES OUTSTANDING");
		WebControl.takeScreenshot("Reg_Auto_83");
		
		ReportLog.setTestCase("Reg_Auto_84");
		VIPFinancialsPage.contents.RefineCriteriaLink.click();
		Thread.sleep(1000);
		VIPCompetitorPage.contents.CompetitorTitle.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Reg_Auto_84");
			
		ReportLog.setTestCase("Reg_Auto_85");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.privCompany);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPFinancialsPage.contents.IsPrivIncStatementRatios.verifyText("INCOME STATEMENT RATIOS");
		VIPFinancialsPage.contents.IsPrivBalanceSheetRatios.verifyText("BALANCE SHEET RATIOS");
		WebControl.takeScreenshot("Reg_Auto_85");
			
		ReportLog.setTestCase("Reg_Auto_86");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPFinancialsPage.contents.IsMarketMetrics.verifyText("MARKET METRICS");
		VIPFinancialsPage.contents.IsIncStatementRatios.verifyText("INCOME STATEMENT RATIOS");
		VIPFinancialsPage.contents.IsBalanceSheetRatios.verifyText("BALANCE SHEET RATIOS");
		VIPFinancialsPage.contents.IsMetricsAnalystOutlook.verifyText("ANALYST OUTLOOK");
		WebControl.takeScreenshot("Reg_Auto_86");
		
		ReportLog.setTestCase("Reg_Auto_87");
		VIPFinancialsPage.contents.IsMarketMetrics.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.TotalReturnToShareHolders.verifyText("Total Return to Shareholders");
		WebControl.takeScreenshot("Reg_Auto_87");
		
		ReportLog.setTestCase("Reg_Auto_88");
		VIPFinancialsPage.contents.IsIncStatementRatios.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.NavigateToRevGrowth.verifyText("Revenue Growth");
		VIPFinancialsPage.contents.NavigateToCOGS.verifyText("COGS / Revenue");
		VIPFinancialsPage.contents.NavigateToSGA.verifyText("SG&A / Revenue");
		VIPFinancialsPage.contents.NavigateToEBIT.verifyText("EBIT Margin");
		VIPFinancialsPage.contents.NavigateToEBITDA.verifyText("EBITDA Margin");
		WebControl.takeScreenshot("Reg_Auto_88");
		
		ReportLog.setTestCase("Reg_Auto_89");
		VIPFinancialsPage.contents.IsBalanceSheetRatios.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.NavigateToROIC.verifyText("Pre-Tax Return on Invested Capital");
		VIPFinancialsPage.contents.NavigateToCapEfficiency.verifyText("Capital Efficiency");
		VIPFinancialsPage.contents.NavigateToDIO.verifyText("Days Inventory Outstanding");
		VIPFinancialsPage.contents.NavigateToDPO.verifyText("Days Payable Outstanding");
		VIPFinancialsPage.contents.NavigateToDSO.verifyText("Days Sales Outstanding");
		WebControl.takeScreenshot("Reg_Auto_89");
		
		ReportLog.setTestCase("Reg_Auto_90");
		VIPFinancialsPage.contents.IsMetricsAnalystOutlook.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.NavigateToRevForecast.verifyText("Revenue Growth Forecast");
		VIPFinancialsPage.contents.NavigateToEBITForecast.verifyText("EBIT Margin Forecast");
		VIPFinancialsPage.contents.NavigateToEBITDAForecast.verifyText("EBITDA Margin Forecast");
		WebControl.takeScreenshot("Reg_Auto_90");
		
		ReportLog.setTestCase("Reg_Auto_91");
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.NavigateToRevGrowth.hover();
		VIPFinancialsPage.contents.NavigateToRevGrowth.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.ToggleRevGrowthDetailed.click();
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Reg_Auto_91");
		
		ReportLog.setTestCase("Reg_Auto_92");
		int OneYrAgo = get1YearAgo();
		String OneYear = String.valueOf(OneYrAgo);
		int TwoYrsAgo = get2YearsAgo();
		String TwoYears = String.valueOf(TwoYrsAgo);
		VIPFinancialsPage.contents.NavigateToCOGS.click();
		Thread.sleep(1000);
		//VIPFinancialsPage.contents.ToggleSGADetailed.click();
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyText("TTM");
		WebControl.takeScreenshot("Reg_Auto_92");
		
		ReportLog.setTestCase("Reg_Auto_93");
		VIPFinancialsPage.contents.NavigateToSGA.click();
		Thread.sleep(1000);
		//VIPFinancialsPage.contents.ToggleSGADetailed.click();
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyText("TTM");
		WebControl.takeScreenshot("Reg_Auto_93");
		
		ReportLog.setTestCase("Reg_Auto_94");
		VIPFinancialsPage.contents.NavigateToEBIT.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyText("TTM");
		WebControl.takeScreenshot("Reg_Auto_94");
		
		ReportLog.setTestCase("Reg_Auto_95");
		VIPFinancialsPage.contents.NavigateToEBITDA.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyText("TTM");
		WebControl.takeScreenshot("Reg_Auto_95");
		
		ReportLog.setTestCase("Reg_Auto_96");
		VIPFinancialsPage.contents.NavigateToROIC.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyText("TTM");
		WebControl.takeScreenshot("Reg_Auto_96");
		
		ReportLog.setTestCase("Reg_Auto_97");
		VIPFinancialsPage.contents.NavigateToCapEfficiency.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyText("TTM");
		WebControl.takeScreenshot("Reg_Auto_97");
		
		ReportLog.setTestCase("Reg_Auto_98");
		VIPFinancialsPage.contents.NavigateToDIO.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyText("TTM");
		WebControl.takeScreenshot("Reg_Auto_98");
		
		ReportLog.setTestCase("Reg_Auto_99");
		VIPFinancialsPage.contents.NavigateToDPO.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyText("TTM");
		WebControl.takeScreenshot("Reg_Auto_99");
		
		ReportLog.setTestCase("Reg_Auto_100");
		VIPFinancialsPage.contents.NavigateToDSO.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.FirstPeriodTitle.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodTitle.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodTitle.verifyText("TTM");
		WebControl.takeScreenshot("Reg_Auto_100");
		
		ReportLog.setTestCase("Reg_Auto_101");
		VIPFinancialsPage.contents.NavigateToRevForecast.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.RevenueCAGRTitle.verifyText("Revenue CAGR");
		VIPFinancialsPage.contents.RevForecastNegTest1.verifyDisplayed(false, 3);
		WebControl.takeScreenshot("Reg_Auto_101");
		
		ReportLog.setTestCase("Reg_Auto_102");
		int CurrentYr = currentYear();
		String CurrentYear = String.valueOf(CurrentYr);
		VIPFinancialsPage.contents.NavigateToEBITForecast.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.FirstEBITTitle.verifyText(CurrentYear + " EBIT Margin (%)");
		VIPFinancialsPage.contents.SecondEBITTitle.verifyText("Change in EBIT Margin (pps)");
		VIPFinancialsPage.contents.EBITForecastNegTest1.verifyDisplayed(false, 3);
		WebControl.takeScreenshot("Reg_Auto_102");
		
		ReportLog.setTestCase("Reg_Auto_103");
		VIPFinancialsPage.contents.NavigateToEBITDAForecast.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.FirstEBITDATitle.verifyText(CurrentYear + " EBITDA Margin (%)");
		VIPFinancialsPage.contents.SecondEBITDATitle.verifyText("Change in EBITDA Margin (pps)");
		VIPFinancialsPage.contents.EBITDAForecastNegTest1.verifyDisplayed(false, 3);
		WebControl.takeScreenshot("Reg_Auto_103");
		
		ReportLog.setTestCase("Reg_Auto_104");
		VIPFinancialsPage.contents.ToggleRevGrowthDetailed.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.NavigateToRevForecast.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.RevForecastHeader.verifyText("REVENUE GROWTH FORECAST");
		WebControl.takeScreenshot("Reg_Auto_104");
		
		ReportLog.setTestCase("Reg_Auto_105");
		VIPFinancialsPage.contents.IsMetricsAnalystOutlook.verifyText("ANALYST OUTLOOK");
		WebControl.takeScreenshot("Reg_Auto_105");
		
		ReportLog.setTestCase("Reg_Auto_106");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.privCompany);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPFinancialsPage.contents.IsPrivateCompany.verifyText("No Results. Add competitors or refine search criteria to display results.");
		WebControl.takeScreenshot("Reg_Auto_106");
		
	}
	
	private static int get1YearAgo() {
	    Calendar prevYear = Calendar.getInstance();
	    prevYear.add(Calendar.YEAR, -1);
	    return prevYear.get(Calendar.YEAR);
	}
	
	private static int get2YearsAgo() {
	    Calendar prevYear = Calendar.getInstance();
	    prevYear.add(Calendar.YEAR, -2);
	    return prevYear.get(Calendar.YEAR);
	}
	
	private static int currentYear() {
	    Calendar prevYear = Calendar.getInstance();
	    prevYear.add(Calendar.YEAR, 0);
	    return prevYear.get(Calendar.YEAR);
	}
}




