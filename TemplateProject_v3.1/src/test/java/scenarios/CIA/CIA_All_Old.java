package scenarios.CIA;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPCIAPage;
import pageobjects.VIPCompetitorPage;

public class CIA_All_Old extends TestBase{
	

	@Test
	public void CIA_All () throws Exception {
		ReportLog.setTestName("CIA");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("CIA_Reg_Auto_27_Login");
		VIP_Common.LogInPage(testDataHandler);
		Thread.sleep(3000);
		VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
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
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
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
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false, 2);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(false, 2);
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer Inc.");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		WebControl.takeScreenshot("CIA_Reg_Auto_27_Login");
		
		//CIAOverview
		ReportLog.setTestCase("CIA_Reg_Auto_001_OverviewTab");
		VIPCIAPage.contents.BurgerMenu.verifyDisplayed(true, 10);
		VIPCIAPage.contents.BurgerMenu.click();
		VIPCIAPage.contents.SideMenuCIAClick.verifyDisplayed(true, 5);
		VIPCIAPage.contents.SideMenuCIAClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.CIATitle.verifyText("COVID-19 Impact Analysis");
		VIPCIAPage.contents.OverviewTab.verifyText("Overview");
		WebControl.takeScreenshot("CIA_Reg_Auto_001_OverviewTab");
		
		ReportLog.setTestCase("CIA_Reg_Auto_002_OverviewInfoIcon");
		VIPCIAPage.contents.OverviewInfoIcon.waitForExist(true, 60);
		VIPCIAPage.contents.OverviewInfoIcon.verifyDisplayed(true, 10);
		VIPCIAPage.contents.OverviewInfoIcon.hover();
		VIPCIAPage.contents.OverviewInfoIcon.click();
		WebControl.takeScreenshot("CIA_Reg_Auto_002_OverviewInfoIcon");
		
		ReportLog.setTestCase("CIA_Reg_Auto_003_OverviewInfoText");
		VIPCIAPage.contents.OverviewInfoIconText.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_003_OverviewInfoText");
		
		ReportLog.setTestCase("CIA_Reg_Auto_004_CVSTeamLink");
		VIPCIAPage.contents.CVSTeamLink.verifyDisplayed(true, 3);
		VIPCIAPage.contents.CVSTeamLink.verifyText("CVS Team.");
		WebControl.takeScreenshot("CIA_Reg_Auto_004_CVSTeamLink");
		
		ReportLog.setTestCase("CIA_Reg_Auto_005_SampleAnalysisLink");
		VIPCIAPage.contents.SampleLink.verifyDisplayed(true, 3);
		VIPCIAPage.contents.SampleLink.verifyText("here.");
		VIPCIAPage.contents.SampleLink.click();
		WebControl.waitForPageToLoad(80);
		Thread.sleep(2000);
		WebControl.switchWithTitle("COVID-19 Impact Analysis: Marriott");
		Thread.sleep(5000);
		WebControl.takeScreenshot("CIA_Reg_Auto_003_SampleAnalysisLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		WebControl.takeScreenshot("CIA_Reg_Auto_005_SampleAnalysisLink");
		
		//DetailedAnalysisTRSwithReg_079
		ReportLog.setTestCase("CIA_Reg_Auto_006_DetailedAnalysisTab");
		VIPCIAPage.contents.DetailedAnalysisTab.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.click();
		WebControl.waitForPageToLoad(30);
		VIPCIAPage.contents.DetailedAnalysisTab.verifyText("Detailed Analysis");
		VIPCIAPage.contents.DetailedAnalysisNote.verifyDisplayed(true, 5);
		VIPCIAPage.contents.RefineCriteriaNote.verifyDisplayed(true, 3);
		VIPCIAPage.contents.RefineCriteriaNote.verifyText("Refine Criteria");
		WebControl.takeScreenshot("CIA_Reg_Auto_006_DetailedAnalysisTab");
		
		ReportLog.setTestCase("CIA_Reg_Auto_007_DetailedAnalysisTRS");
		VIPCIAPage.contents.ForecastArrowUp.verifyDisplayed(true, 5);
		VIPCIAPage.contents.ForecastArrowDown.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_007_DetailedAnalysisTRS");
		
		ReportLog.setTestCase("CIA_Reg_Auto_008_TRSChangeFormat");
		VIPCIAPage.contents.TRSChange.verifyDisplayed(true, 5);
		String change = VIPCIAPage.contents.TRSChange.getText();
		String x = change.substring(0,1);
		String y = change.substring(2,3);		
		VIPCIAPage.contents.TRSChange.verifyText(x + "." + y + "%");
		WebControl.takeScreenshot("CIA_Reg_Auto_008_TRSChangeFormat");
		
		ReportLog.setTestCase("CIA_Reg_Auto_009_TRSKeyFormat");
		VIPCIAPage.contents.TRSKeyInsightsText.verifyDisplayed(true, 5);
		String TRSKeyInsightsText_1 = VIPCIAPage.contents.TRSKeyInsightsText.getText();
		String[] words = TRSKeyInsightsText_1.split("\\s");
        String a = words[5];
        String b = words[17];
        String a1 = a.substring(0, 1);
        String a2 = a.substring(2);
        String b1 = b.substring(0, 1);
        String b2 = b.substring(2);
        VIPCIAPage.contents.TRSKeyInsightsText.verifyText("Pfizer Inc.'s TRS declined by " + a1 + "." + a2 + " since Dec’19 which is better than the peer median decline of " + b1 + "." + b2);
		WebControl.takeScreenshot("CIA_Reg_Auto_009_TRSKeyFormat");
		
		ReportLog.setTestCase("CIA_Reg_Auto_010_TRSInfoIcon");
		VIPCIAPage.contents.TRSInfoIcon.verifyDisplayed(true, 3);
		VIPCIAPage.contents.TRSInfoIcon.hover();
		VIPCIAPage.contents.TRSInfoIcon.click();
		VIPCIAPage.contents.TRSInfoIconText.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_010_TRSInfoIcon");
		
		ReportLog.setTestCase("CIA_Reg_Auto_011_TRSKeyInsights");
		VIPCIAPage.contents.TRSKeyInsightsTitle.verifyDisplayed(true, 5);
		VIPCIAPage.contents.TRSCircle.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_011_TRSKeyInsights");
		
		//EBITForecast
		ReportLog.setTestCase("CIA_Reg_Auto_012_EBITForecast");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer Inc.");
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
		VIPCIAPage.contents.BurgerMenu.verifyDisplayed(true, 10);
		VIPCIAPage.contents.BurgerMenu.click();
		VIPCIAPage.contents.SideMenuCIAClick.verifyDisplayed(true, 5);
		VIPCIAPage.contents.SideMenuCIAClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.click();
		WebControl.waitForPageToLoad(20);
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(2000);
		VIPCIAPage.contents.TRSTitle.waitForExist(true, 60);
		VIPCIAPage.contents.EBITSideMenuClick.click();
		VIPCIAPage.contents.EBITTitle.verifyDisplayed(true, 10);
		VIPCIAPage.contents.EBITTimeframe.verifyText("2020E");
		VIPCIAPage.contents.TimeframeDropdown.verifyDisplayed(true, 2);
		VIPCIAPage.contents.ForecastSource.verifyDisplayed(true, 5);
		VIPCIAPage.contents.ForecastSource.verifyText("Source: Based on consensus analyst estimates from S&P Capital IQ; Accenture Client Value Services.");
		WebControl.takeScreenshot("CIA_Reg_Auto_012_EBITForecast");
		
		ReportLog.setTestCase("CIA_Reg_Auto_013_EBITKeyInsights");
		VIPCIAPage.contents.EBITKeyInsightsTitle.verifyDisplayed(true, 3);
		VIPCIAPage.contents.EBITKeyInsightsDot.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("CIA_Reg_Auto_013_EBITKeyInsights");
		
		//EPSForecast
		ReportLog.setTestCase("CIA_Reg_Auto_014_EPSForecast");
		VIPCIAPage.contents.EPSSideMenuClick.click();
		VIPCIAPage.contents.EPSTitle.verifyDisplayed(true, 3);
		VIPCIAPage.contents.EPSTimeframe.verifyText("2020E");
		VIPCIAPage.contents.TimeframeDropdown.verifyDisplayed(true, 2);
		VIPCIAPage.contents.ForecastSource.verifyDisplayed(true, 5);
		VIPCIAPage.contents.ForecastSource.verifyText("Source: Based on consensus analyst estimates from S&P Capital IQ; Accenture Client Value Services.");
		WebControl.takeScreenshot("CIA_Reg_Auto_014_EPSForecast");
		
		ReportLog.setTestCase("CIA_Reg_Auto_015_EPSKeyInsights");
		VIPCIAPage.contents.EPSKeyInsightsTitle.verifyDisplayed(true, 3);
		VIPCIAPage.contents.EPSKeyInsightsDot.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("CIA_Reg_Auto_015_EPSKeyInsights");
		
		//FCFForecast
		ReportLog.setTestCase("CIA_Reg_Auto_16_FCFForecast");
		VIPCIAPage.contents.FCFSideMenuClick.click();
		VIPCIAPage.contents.FCFTitle.verifyDisplayed(true, 3);
		VIPCIAPage.contents.FCFTimeframe.verifyText("2020E");
		VIPCIAPage.contents.TimeframeDropdown.verifyDisplayed(true, 2);
		VIPCIAPage.contents.ForecastSource.verifyDisplayed(true, 5);
		VIPCIAPage.contents.ForecastSource.verifyText("Source: Based on consensus analyst estimates from S&P Capital IQ; Accenture Client Value Services.");
		WebControl.takeScreenshot("CIA_Reg_Auto_016_FCFForecast");
		
		ReportLog.setTestCase("CIA_Reg_Auto_017_FCFKeyInsights");
		VIPCIAPage.contents.FCFKeyInsightsTitle.verifyDisplayed(true, 3);
		VIPCIAPage.contents.FCFKeyInsightsDot.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("CIA_Reg_Auto_017_FCFKeyInsights");
		
		//CapexForecast
		ReportLog.setTestCase("CIA_Reg_Auto_018_CapexForecast");
		VIPCIAPage.contents.CapexSideMenuClick.click();
		VIPCIAPage.contents.CapexTitle.verifyDisplayed(true, 3);
		VIPCIAPage.contents.CapexTimeframe.verifyText("2020E");
		VIPCIAPage.contents.TimeframeDropdown.verifyDisplayed(true, 2);
		VIPCIAPage.contents.ForecastSource.verifyDisplayed(true, 5);
		VIPCIAPage.contents.ForecastSource.verifyText("Source: Based on consensus analyst estimates from S&P Capital IQ; Accenture Client Value Services.");
		WebControl.takeScreenshot("CIA_Reg_Auto_018_CapexForecast");
				
		ReportLog.setTestCase("CIA_Reg_Auto_019_CapexKeyInsights");
		VIPCIAPage.contents.CapexKeyInsightsTitle.verifyDisplayed(true, 3);
		VIPCIAPage.contents.CapexKeyInsightsDot.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("CIA_Reg_Auto_019_CapexKeyInsights");
		
		//ForecastChange
		ReportLog.setTestCase("CIA_Reg_Auto_020_ForecastColumn");
		VIPCIAPage.contents.FCHorizontalBar.verifyDisplayed(true, 5);
		VIPCIAPage.contents.FCValueColumn.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_020_ForecastColumn");
		
		ReportLog.setTestCase("CIA_Reg_Auto_021_ForecastLegend");
		VIPCIAPage.contents.ForecastLegend.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_021_ForecastLegend");
		
		ReportLog.setTestCase("CIA_Reg_Auto_022_ForecastArrow");
		VIPCIAPage.contents.ForecastArrowUp.verifyDisplayed(true, 5);
		VIPCIAPage.contents.ForecastArrowDown.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_022_ForecastArrow");
		
		ReportLog.setTestCase("CIA_Reg_Auto_023_ForecastFootnote");
		VIPCIAPage.contents.ForecastFootnote.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_023_ForecastFootnote");
		
		
		//RevenueForecast
		ReportLog.setTestCase("CIA_Reg_Auto_024_RevenueForecast");
		VIPCIAPage.contents.RevenueSideMenuClick.click();
		VIPCIAPage.contents.RevenueTitle.verifyDisplayed(true, 3);
		VIPCIAPage.contents.RevenueTimeframe.verifyText("2020E");
		VIPCIAPage.contents.TimeframeDropdown.verifyDisplayed(true, 2);
		VIPCIAPage.contents.ForecastSource.verifyDisplayed(true, 5);
		VIPCIAPage.contents.ForecastSource.verifyText("Source: Based on consensus analyst estimates from S&P Capital IQ; Accenture Client Value Services.");
		WebControl.takeScreenshot("CIA_Reg_Auto_024_RevenueForecast");
						
		ReportLog.setTestCase("CIA_Reg_Auto_025_RevenueKeyInsights");
		VIPCIAPage.contents.RevenueKeyInsightsTitle.verifyDisplayed(true, 3);
		VIPCIAPage.contents.RevenueKeyInsightsDot.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("CIA_Reg_Auto_025_RevenueKeyInsights");
	
		
		//LiquidityandSolvency
		ReportLog.setTestCase("CIA_Reg_Auto_026_LiquidityandSolvency");
		VIPCIAPage.contents.LiquiditySideMenuClick.click();
		VIPCIAPage.contents.RatioTitle.verifyText("LIQUIDITY RATIOS");
		VIPCIAPage.contents.RatioTimePeriod.verifyDisplayed(true, 5);
		VIPCIAPage.contents.PeerMedianTitle.verifyDisplayed(true, 5);
		VIPCIAPage.contents.PeerMedianTitle.verifyText("Peer Median");
		
		
		ReportLog.setTestCase("CIA_Reg_Auto_027_LiquidityRatioInfoIcon");
		VIPCIAPage.contents.LiquidityInfoIcon1.hover();
		VIPCIAPage.contents.LiquidityInfoIcon1.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.LiquidityInfoIcon1.click();
		VIPCIAPage.contents.LiquidityInfoIcon2.hover();
		VIPCIAPage.contents.LiquidityInfoIcon2.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.LiquidityInfoIcon2.click();
		VIPCIAPage.contents.LiquidityInfoIcon3.hover();
		VIPCIAPage.contents.LiquidityInfoIcon3.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.LiquidityInfoIcon3.click();
		VIPCIAPage.contents.LiquidityInfoIcon4.hover();
		VIPCIAPage.contents.LiquidityInfoIcon4.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.LiquidityInfoIcon4.click();
		VIPCIAPage.contents.LiquidityInfoIcon5.hover();
		VIPCIAPage.contents.LiquidityInfoIcon5.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.LiquidityInfoIcon5.click();
		VIPCIAPage.contents.LiquidityInfoIcon6.hover();
		VIPCIAPage.contents.LiquidityInfoIcon6.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.LiquidityInfoIcon6.click();
		WebControl.takeScreenshot("CIA_Reg_Auto_027_LiquidityRatioInfoIcon");	
		
		
		VIPCIAPage.contents.SolvencySideMenuClick.click();
		VIPCIAPage.contents.RatioTitle.verifyDisplayed(true, 5);
		VIPCIAPage.contents.RatioTitle.verifyText("SOLVENCY RATIOS");
		VIPCIAPage.contents.RatioTimePeriod.verifyDisplayed(true, 5);
		VIPCIAPage.contents.PeerMedianTitle.verifyDisplayed(true, 5);
		VIPCIAPage.contents.PeerMedianTitle.verifyText("Peer Median");
		WebControl.takeScreenshot("CIA_Reg_Auto_026_LiquidityandSolvency");
		
		ReportLog.setTestCase("CIA_Reg_Auto_028_SolvencyPercentile");
		VIPCIAPage.contents.PercentileBar.hover();
		VIPCIAPage.contents.PercentileBar.click();
		WebControl.takeScreenshot("CIA_Reg_Auto_028_SolvencyPercentile");
		
		ReportLog.setTestCase("CIA_Reg_Auto_029_SolvencyInfoIcon");
		VIPCIAPage.contents.SolvencyInfoIcon1.hover();
		VIPCIAPage.contents.SolvencyInfoIcon1.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.SolvencyInfoIcon1.click();
		VIPCIAPage.contents.SolvencyInfoIcon2.hover();
		VIPCIAPage.contents.SolvencyInfoIcon2.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.SolvencyInfoIcon2.click();
		VIPCIAPage.contents.SolvencyInfoIcon3.hover();
		VIPCIAPage.contents.SolvencyInfoIcon3.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.SolvencyInfoIcon3.click();
		VIPCIAPage.contents.SolvencyInfoIcon4.hover();
		VIPCIAPage.contents.SolvencyInfoIcon4.click();
		VIPCIAPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPCIAPage.contents.SolvencyInfoIcon4.click();
		WebControl.takeScreenshot("CIA_Reg_Auto_029_SolvencyInfoIcon");
		
		//IsPrivateCompany
		ReportLog.setTestCase("CIA_Reg_Auto_030_IsPrivateCompany");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Panalpina Welttransport");
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(2000);
		//VIPCIAPage.contents.DisclaimerClose.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.BurgerMenu.verifyDisplayed(true, 10);
		VIPCIAPage.contents.BurgerMenu.click();
		VIPCIAPage.contents.SideMenuCIAClick.verifyDisplayed(true, 5);
		VIPCIAPage.contents.SideMenuCIAClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.IsPrivateCompany.verifyDisplayed(true, 5);
		VIPCIAPage.contents.InsightsSummaryTitle.verifyDisplayed(false, 5);
		VIPCIAPage.contents.InsightsSummaryBody.verifyDisplayed(false, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_030_IsPrivateCompany");
		
		//PrivateCompanyNoResultsMessage53to56
		ReportLog.setTestCase("CIA_Reg_Auto_031_NoResults");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.click();
		WebControl.waitForPageToLoad(30);
		VIPCIAPage.contents.NoResults.verifyText("No Results. Add competitors or refine search criteria to display results.");
		VIPCIAPage.contents.PeerLegend.verifyDisplayed(false, 5);
		VIPCIAPage.contents.KeyInsightsTitle.verifyDisplayed(false, 5);
		VIPCIAPage.contents.KeyInsightsBody.verifyDisplayed(false, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_031_NoResults");		
		
		//DashboardChecksTRS
		ReportLog.setTestCase("CIA_Reg_Auto_032_TRSFootnote");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Nokia Corporation");
		Thread.sleep(4000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.SideMenuCIAClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.click();
		VIPCIAPage.contents.PrivatePeer1.verifyDisplayed(false, 2);
		VIPCIAPage.contents.PrivatePeer2.verifyDisplayed(false, 2);
		VIPCIAPage.contents.FootNote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services.");
		WebControl.takeScreenshot("CIA_Reg_Auto_032_TRSFootnote");
		
		ReportLog.setTestCase("CIA_Reg_Auto_033_TRSnotAvailable");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("BUL:HTV");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.SideMenuCIAClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.click();
		//VIPCIAPage.contents.NoTRSComp.verifyDisplayed(false, 2);
		//VIPCIAPage.contents.FootNote.verifyText("Note: Companies with TRS not available (Herti AD,RPC Group Limited) are removed from the analysis.");
		VIPCIAPage.contents.KeyInsight.verifyDisplayed(false, 2);
		WebControl.takeScreenshot("CIA_Reg_Auto_033_TRSnotAvailable");
		
		ReportLog.setTestCase("CIA_Reg_Auto_034_NoTRSPeer");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Daiho Corporation");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompetitorSearchbox.waitForExist(true, 5);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("BUL:HTV");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors16thPeers.waitForExist(true, 5);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.SideMenuCIAClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.click();
		VIPCIAPage.contents.NoTRSPeer.verifyDisplayed(false, 2);
		VIPCIAPage.contents.FootNote.verifyText("Note: Companies with TRS not available (Herti AD) are removed from the analysis.");
		VIPCIAPage.contents.KeyInsight.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_034_NoTRSPeer");
		
		ReportLog.setTestCase("CIA_Reg_Auto_035_PartialTRSCompany");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("OTCPK:CSTI");//Costar Technologies, Inc.
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.BurgerMenu.verifyDisplayed(true, 10);
		VIPCIAPage.contents.BurgerMenu.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.SideMenuCIAClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.click();
		VIPCIAPage.contents.PartialTRSComp.verifyDisplayed(false, 2);
		VIPCIAPage.contents.FootNote.verifyText("Note: Companies with TRS not available (Costar Technologies, Inc.,AVIC International Holdings Limited,Hitachi High-Tech Corporation,Ingenico Group - GCS) are removed from the analysis.");
		VIPCIAPage.contents.KeyInsight.verifyDisplayed(false, 2);
		WebControl.takeScreenshot("CIA_Reg_Auto_035_PartialTRSCompany");
		
		ReportLog.setTestCase("CIA_Reg_Auto_036_PartialTRSPeer");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		//VIPCIAPage.contents.UpgradeInProgressClose.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Daiho Corporation");
        Thread.sleep(3000);
        VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
        Thread.sleep(3000);
        VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
        VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompetitorSearchbox.waitForExist(true, 10);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Costar Technologies, Inc.");//OTCPK:CSTI
        Thread.sleep(3000);
        VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
        Thread.sleep(3000);
        VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
        VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors16thPeers.waitForExist(true, 5);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.SideMenuCIAClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.click();
		VIPCIAPage.contents.PartialTRSPeer.verifyDisplayed(false, 2);
		//VIPCIAPage.contents.FootNote.verifyText("Note: Companies with TRS not available (Costar Technologies, Inc.) are removed from the analysis.");
		VIPCIAPage.contents.KeyInsight.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CIA_Reg_Auto_036_PartialTRSPeer");
				
	}

}
