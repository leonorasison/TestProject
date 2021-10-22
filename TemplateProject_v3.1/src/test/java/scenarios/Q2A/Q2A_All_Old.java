package scenarios.Q2A;

import org.testng.annotations.Test;
import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import auto.framework.web.WebControl.WebFile;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Q2A_All_Old extends TestBase{
	
	@Test(priority=1)
	public void Q2A_Common () throws Exception {
		ReportLog.setTestName("Financials - Common");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_001_to_003");
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer Inc.");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();				
		//FinancialsCommon
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.verifyDisplayed(true, 45);
		WebControl.takeScreenshot("Q2A_Reg_Auto_001_SelectDashboard");
		VIPFinancialsPage.contents.FinancialsSubTitle1.verifyText("NOTE:");
		VIPFinancialsPage.contents.FinancialsSubTitle2.verifyText("The information displayed here depends on the current Competitors List, please go to Refine Criteria settings under Competitors tab to adjust if needed.");
		WebControl.takeScreenshot("Q2A_Reg_Auto_002_SelectDashboard");
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.DropDownMainHeader1.verifyText("Executive Summary");
		VIPFinancialsPage.contents.SelectDropDown1.verifyText("Competitiveness Scorecard");
		VIPFinancialsPage.contents.DropDownMainHeader2.verifyText("Investor Expectations");
		VIPFinancialsPage.contents.SelectDropDown2.verifyText("Total Return to Shareholders");
		VIPFinancialsPage.contents.SelectDropDown3.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPFinancialsPage.contents.SelectDropDown4.verifyText("Analyst Recommendations");
		VIPFinancialsPage.contents.SelectDropDown5.verifyText("Revenue and Profitability Estimates");
		VIPFinancialsPage.contents.DropDownMainHeader3.verifyText("Growth Indicators");
		VIPFinancialsPage.contents.SelectDropDown6.verifyText("Revenue Growth");
		VIPFinancialsPage.contents.SelectDropDown7.verifyText("Employee Productivity");
		VIPFinancialsPage.contents.DropDownMainHeader4.verifyText("Operating Performance");
		VIPFinancialsPage.contents.SelectDropDown8.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.SelectDropDown9.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.SelectDropDown10.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.DropDownMainHeader5.verifyText("Segment Trend Analysis");
		VIPFinancialsPage.contents.SelectDropDown11.verifyText("Business Segment Analysis");
		VIPFinancialsPage.contents.SelectDropDown12.verifyText("Geographic Segment Analysis");
		VIPFinancialsPage.contents.DropDownMainHeader6.verifyText("Appendix");
		VIPFinancialsPage.contents.SelectDropDown13.verifyText("Glossary");
		VIPFinancialsPage.contents.SelectDropDown14.verifyText("Methodology");
		WebControl.takeScreenshot("Q2A_Reg_Auto_003_SelectDashboard");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_004");
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
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.RefineCriteriaButton.waitForExist(true, 10);
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown2.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown3.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown4.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown5.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_004");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_005_IsPrivateCompany");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Huawei Investment");
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
		VIPFinancialsPage.contents.IsPrivateCompany.verifyText("No Results. Add competitors or refine search criteria to display results.");
		WebControl.takeScreenshot("Q2A_Reg_Auto_005_IsPrivateCompany");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_006_SegmentAnalysis");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("vodafone");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.EBITMarginValue.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPOverviewPage.contents.KeyInsights5.waitForExist(true, 60);
		Thread.sleep(2000);
		VIPOverviewPage.contents.RBBPieChart.waitForExist(true, 20);
		VIPOverviewPage.contents.RBBPieChart.hover();
		VIPOverviewPage.contents.RBBPieChart.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBGPieChart.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_005_SegmentAnalysis_1");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_006_SegmentAnalysis");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_007");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
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
		Thread.sleep(1500);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown2.click();
		VIPFinancialsPage.contents.TRSTitle.verifyText("3-YEAR TRS DEVELOPMENT");
		VIPFinancialsPage.contents.TRSTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.TRSPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_TRS");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown3.click();
		VIPFinancialsPage.contents.EVICTitle.verifyText("PREMIUM ON INVESTED CAPITAL (EV/IC)");
		VIPFinancialsPage.contents.EVICTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EVICTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.EVICPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EVICPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_EVIC");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown4.click();
		VIPFinancialsPage.contents.ANARECTitle.verifyText("EXPECTED 1-YEAR SHARE PRICE GROWTH");
		VIPFinancialsPage.contents.ANARECTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.ANARECTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.ANARECPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.ANARECPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_ANAREC");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown5.click();
		VIPFinancialsPage.contents.RPETitle1.verifyText("REVENUE YOY GROWTH ESTIMATES");
		VIPFinancialsPage.contents.RPETitle2.verifyText("REVENUE CAGR");
		VIPFinancialsPage.contents.RPETargetLegend1.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPETargetLegend2.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPETargetLegendText1.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.RPETargetLegendText2.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.RPEPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPEPeerMedianLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPEPeerMedianText1.verifyText("Peer Median");
		VIPFinancialsPage.contents.RPEPeerMedianText2.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_RPE");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown6.click();
		VIPFinancialsPage.contents.RGTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RGTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.RGPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RGPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_RG");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown7.click();
		VIPFinancialsPage.contents.EPTitle.verifyText("REVENUE PER EMPLOYEE");
		VIPFinancialsPage.contents.EPTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EPTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.EPPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EPPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_EP");
		
	}	
	
	@Test(priority=2)
	public void Q2A_CompetitivenessScorecard () throws Exception {
		ReportLog.setTestName("Q2A - Competitiveness Scorecard");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_008");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.BestandRankCheckbox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardBestTitle.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardRankTitle.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_008");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_009");
		VIPFinancialsPage.contents.ScorecardMetricTitle.verifyText("METRIC");
		VIPFinancialsPage.contents.ScorecardPercentileTitle.verifyText("PERCENTILE");
		if (testDataHandler.company.length() > 18) {
		String Header = testDataHandler.company.substring(0, 18).toUpperCase();
		VIPFinancialsPage.contents.ScorecardCompanyTitle.verifyText(Header);}
		else {VIPFinancialsPage.contents.ScorecardCompanyTitle.verifyText(testDataHandler.company.toUpperCase());}
		VIPFinancialsPage.contents.ScorecardPeerMedianTitle.verifyText("PEER MEDIAN");
		VIPFinancialsPage.contents.ScorecardBestTitle.verifyText("BEST");
		VIPFinancialsPage.contents.ScorecardRankTitle.verifyText("RANK");
		VIPFinancialsPage.contents.Scorecard2YrChangeTitle.verifyText("2 YEAR CHANGE");
		WebControl.takeScreenshot("Q2A_Reg_Auto_009");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_10_to_14");
		VIPFinancialsPage.contents.PercentileHeaderTooltip.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardCompanyTitle.verifyAttribute("title", testDataHandler.company);
		VIPFinancialsPage.contents.BestHeaderTooltip.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RankHeaderTooltip.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.TwoYrChangeHeaderTooltip.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_10_to_14");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_015");
		VIPFinancialsPage.contents.ScoreCardDate.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_015");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_016");
		VIPFinancialsPage.contents.ScorecardMetric1.verifyText("TRS DEVELOPMENT");
		VIPFinancialsPage.contents.ScorecardMetric1InfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric1a.verifyText("5-year Total Return to Shareholders");
		VIPFinancialsPage.contents.ScorecardSubMetric1b.verifyText("3-year Total Return to Shareholders");
		VIPFinancialsPage.contents.ScorecardSubMetric1c.verifyText("1-year Total Return to Shareholders");
		VIPFinancialsPage.contents.ScorecardMetric2.verifyText("ANALYST OUTLOOK");
		VIPFinancialsPage.contents.ScorecardSubMetric2a.verifyText("Buy %");
		VIPFinancialsPage.contents.ScorecardSubMetric2aInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric2b.verifyText("1-year Share Price Growth");
		VIPFinancialsPage.contents.ScorecardSubMetric2bInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric2c.verifyText("2-year Revenue Growth CAGR");
		VIPFinancialsPage.contents.ScorecardSubMetric2cInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric2d.verifyText("2-year EBIT Margin Delta");
		VIPFinancialsPage.contents.ScorecardSubMetric2dInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardMetric3.verifyText("INVESTOR EXPECTATIONS");
		VIPFinancialsPage.contents.ScorecardSubMetric3a.verifyText("Invested Capital Premium (EV/IC)");
		VIPFinancialsPage.contents.ScorecardSubMetric3aInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric3b.verifyText("EV/EBIT");
		VIPFinancialsPage.contents.ScorecardSubMetric3bInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardMetric4.verifyText("REVENUE GROWTH");
		VIPFinancialsPage.contents.ScorecardSubMetric4a.verifyText("5-year Revenue CAGR");
		VIPFinancialsPage.contents.ScorecardSubMetric4b.verifyText("3-year Revenue CAGR");
		VIPFinancialsPage.contents.ScorecardSubMetric4c.verifyText("1-year Revenue Growth");
		VIPFinancialsPage.contents.ScorecardMetric5.verifyText("PRE-TAX ROIC DECOMPOSITION");
		VIPFinancialsPage.contents.ScorecardSubMetric5a.verifyText("ROIC (Pre-Tax)");
		VIPFinancialsPage.contents.ScorecardSubMetric5aInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric5b.verifyText("EBIT Margin");
		VIPFinancialsPage.contents.ScorecardSubMetric5bInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric5c.verifyText("Capital Efficiency");
		VIPFinancialsPage.contents.ScorecardSubMetric5cInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardMetric6.verifyText("EBIT MARGIN DECOMPOSITION");
		VIPFinancialsPage.contents.ScorecardSubMetric6a.verifyText("Cost of Goods Sold");
		VIPFinancialsPage.contents.ScorecardSubMetric6aInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric6b.verifyText("Selling, General & Administrative Expenses");
		VIPFinancialsPage.contents.ScorecardSubMetric6bInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardMetric7.verifyText("INVESTED CAPITAL DECOMPOSITION");
		VIPFinancialsPage.contents.ScorecardSubMetric7a.verifyText("Operating Working Capital");
		VIPFinancialsPage.contents.ScorecardSubMetric7aInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric7b.verifyText("Property, Plant & Equipment");
		VIPFinancialsPage.contents.ScorecardSubMetric7bInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric7c.verifyText("Goodwill & Intangibles");
		VIPFinancialsPage.contents.ScorecardSubMetric7cInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardMetric8.verifyText("WORKING CAPITAL DECOMPOSITION");
		VIPFinancialsPage.contents.ScorecardSubMetric8a.verifyText("Net Receivables");
		VIPFinancialsPage.contents.ScorecardSubMetric8aInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric8b.verifyText("Inventory");
		VIPFinancialsPage.contents.ScorecardSubMetric8bInfoIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardSubMetric8c.verifyText("Accounts Payable");
		VIPFinancialsPage.contents.ScorecardSubMetric8cInfoIcon.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_016");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_017");
		//TRSTooltip
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.ScorecardMetric1InfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardMetric1InfoIcon.click();
		//VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.TRSTooltip);
		VIPFinancialsPage.contents.TooltipText3.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.ScorecardMetric1InfoIcon.click();
		//BuyTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric2aInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric2aInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.BuyTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric2aInfoIcon.click();
		//SPGTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric2bInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric2bInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.SPGTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric2bInfoIcon.click();
		//RGCAGRTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric2cInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric2cInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.RGCAGRTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric2cInfoIcon.click();
		//EBITMDTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric2dInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric2dInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.EBITMDTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric2dInfoIcon.click();
		//ICPTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric3aInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric3aInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.ICPTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric3aInfoIcon.click();
		//FEVEBITTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric3bInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric3bInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.FEVEBITTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric3bInfoIcon.click();
		//ROICTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric5aInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric5aInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.ROICTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric5aInfoIcon.click();
		//EBITMTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric5bInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric5bInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.EBITMTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric5bInfoIcon.click();
		//CAPEFFTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric5cInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric5cInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.CAPEFFTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric5cInfoIcon.click();
		//COGSTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric6aInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric6aInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.COGSTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric6aInfoIcon.click();
		//SGATooltip
		VIPFinancialsPage.contents.ScorecardSubMetric6bInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric6bInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.SGATooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric6bInfoIcon.click();
		//WCRTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric7aInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric7aInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.WCRTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric7aInfoIcon.click();
		//NPPETooltip
		VIPFinancialsPage.contents.ScorecardSubMetric7bInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric7bInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.NPPETooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric7bInfoIcon.click();
		//GITooltip
		VIPFinancialsPage.contents.ScorecardSubMetric7cInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric7cInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.GITooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric7cInfoIcon.click();
		//NRTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric8aInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric8aInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.NRTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric8aInfoIcon.click();
		//IRTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric8bInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric8bInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.IRTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric8bInfoIcon.click();
		//APRTooltip
		VIPFinancialsPage.contents.ScorecardSubMetric8cInfoIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric8cInfoIcon.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText(testDataHandler.APRTooltip);
		VIPFinancialsPage.contents.ScorecardSubMetric8cInfoIcon.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_017");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_019");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.Best1.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best2.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best3.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best4.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best5.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best6.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best7.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best8.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best9.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best10.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best11.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best12.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best13.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best14.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best15.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best16.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best17.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best18.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best19.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best20.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best21.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best22.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Best23.hover();
		VIPFinancialsPage.contents.BestTooltip.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Reg_Auto_019");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_020_TARGET");
		String KPI1 = VIPFinancialsPage.contents.KPI1.getText();
		String[] KPI1_2 = KPI1.split("\\.");
		String KPI1_3 = KPI1_2[0];
		String KPI1_4 = KPI1.substring(KPI1.length() - 2);
		VIPFinancialsPage.contents.KPI1.verifyText(KPI1_3 + "." + KPI1_4);
		String KPI2 = VIPFinancialsPage.contents.KPI2.getText();
		String[] KPI2_2 = KPI2.split("\\.");
		String KPI2_3 = KPI2_2[0];
		String KPI2_4 = KPI2.substring(KPI2.length() - 2);
		VIPFinancialsPage.contents.KPI2.verifyText(KPI2_3 + "." + KPI2_4);
		String KPI3 = VIPFinancialsPage.contents.KPI3.getText();
		String[] KPI3_2 = KPI3.split("\\.");
		String KPI3_3 = KPI3_2[0];
		String KPI3_4 = KPI3.substring(KPI3.length() - 2);
		VIPFinancialsPage.contents.KPI3.verifyText(KPI3_3 + "." + KPI3_4);
		String KPI4 = VIPFinancialsPage.contents.KPI4.getText();
		String[] KPI4_2 = KPI4.split("\\.");
		String KPI4_3 = KPI4_2[0];
		String KPI4_4 = KPI4.substring(KPI4.length() - 2);
		VIPFinancialsPage.contents.KPI4.verifyText(KPI4_3 + "." + KPI4_4);
		String KPI5 = VIPFinancialsPage.contents.KPI5.getText();
		String[] KPI5_2 = KPI5.split("\\.");
		String KPI5_3 = KPI5_2[0];
		String KPI5_4 = KPI5.substring(KPI5.length() - 2);
		VIPFinancialsPage.contents.KPI5.verifyText(KPI5_3 + "." + KPI5_4);
		String KPI6 = VIPFinancialsPage.contents.KPI6.getText();
		String[] KPI6_2 = KPI6.split("\\.");
		String KPI6_3 = KPI6_2[0];
		String KPI6_4 = KPI6.substring(KPI6.length() - 2);
		VIPFinancialsPage.contents.KPI6.verifyText(KPI6_3 + "." + KPI6_4);
		String KPI7 = VIPFinancialsPage.contents.KPI7.getText();
		String[] KPI7_2 = KPI7.split("\\.");
		String KPI7_3 = KPI7_2[0];
		String KPI7_4 = KPI7.substring(KPI7.length() - 2);
		VIPFinancialsPage.contents.KPI7.verifyText(KPI7_3 + "." + KPI7_4);
		String KPI8 = VIPFinancialsPage.contents.KPI8.getText();
		String[] KPI8_2 = KPI8.split("\\.");
		String KPI8_3 = KPI8_2[0];
		String KPI8_4 = KPI8.substring(KPI8.length() - 1);
		VIPFinancialsPage.contents.KPI8.verifyText(KPI8_3 + "." + KPI8_4);
		String KPI9 = VIPFinancialsPage.contents.KPI9.getText();
		String[] KPI9_2 = KPI9.split("\\.");
		String KPI9_3 = KPI9_2[0];
		String KPI9_4 = KPI9.substring(KPI9.length() - 1);
		VIPFinancialsPage.contents.KPI9.verifyText(KPI9_3 + "." + KPI9_4);
		String KPI10 = VIPFinancialsPage.contents.KPI10.getText();
		String[] KPI10_2 = KPI10.split("\\.");
		String KPI10_3 = KPI10_2[0];
		String KPI10_4 = KPI10.substring(KPI10.length() - 2);
		VIPFinancialsPage.contents.KPI10.verifyText(KPI10_3 + "." + KPI10_4);
		String KPI11 = VIPFinancialsPage.contents.KPI11.getText();
		String[] KPI11_2 = KPI11.split("\\.");
		String KPI11_3 = KPI11_2[0];
		String KPI11_4 = KPI11.substring(KPI11.length() - 2);
		VIPFinancialsPage.contents.KPI11.verifyText(KPI11_3 + "." + KPI11_4);
		String KPI12 = VIPFinancialsPage.contents.KPI12.getText();
		String[] KPI12_2 = KPI12.split("\\.");
		String KPI12_3 = KPI12_2[0];
		String KPI12_4 = KPI12.substring(KPI12.length() - 2);
		VIPFinancialsPage.contents.KPI12.verifyText(KPI12_3 + "." + KPI12_4);
		String KPI13 = VIPFinancialsPage.contents.KPI13.getText();
		String[] KPI13_2 = KPI13.split("\\.");
		String KPI13_3 = KPI13_2[0];
		String KPI13_4 = KPI13.substring(KPI13.length() - 2);
		VIPFinancialsPage.contents.KPI13.verifyText(KPI13_3 + "." + KPI13_4);
		String KPI14 = VIPFinancialsPage.contents.KPI14.getText();
		String[] KPI14_2 = KPI14.split("\\.");
		String KPI14_3 = KPI14_2[0];
		String KPI14_4 = KPI14.substring(KPI14.length() - 2);
		VIPFinancialsPage.contents.KPI14.verifyText(KPI14_3 + "." + KPI14_4);
		String KPI15 = VIPFinancialsPage.contents.KPI15.getText();
		String[] KPI15_2 = KPI15.split("\\.");
		String KPI15_3 = KPI15_2[0];
		String KPI15_4 = KPI15.substring(KPI15.length() - 1);
		VIPFinancialsPage.contents.KPI15.verifyText(KPI15_3 + "." + KPI15_4);
		String KPI16 = VIPFinancialsPage.contents.KPI16.getText();
		String[] KPI16_2 = KPI16.split("\\.");
		String KPI16_3 = KPI16_2[0];
		String KPI16_4 = KPI16.substring(KPI16.length() - 2);
		VIPFinancialsPage.contents.KPI16.verifyText(KPI16_3 + "." + KPI16_4);
		String KPI17 = VIPFinancialsPage.contents.KPI17.getText();
		String[] KPI17_2 = KPI17.split("\\.");
		String KPI17_3 = KPI17_2[0];
		String KPI17_4 = KPI17.substring(KPI17.length() - 2);
		VIPFinancialsPage.contents.KPI17.verifyText(KPI17_3 + "." + KPI17_4);
		String KPI18 = VIPFinancialsPage.contents.KPI18.getText();
		String[] KPI18_2 = KPI18.split("\\.");
		String KPI18_3 = KPI18_2[0];
		String KPI18_4 = KPI18.substring(KPI18.length() - 2);
		VIPFinancialsPage.contents.KPI18.verifyText(KPI18_3 + "." + KPI18_4);
		String KPI19 = VIPFinancialsPage.contents.KPI19.getText();
		String[] KPI19_2 = KPI19.split("\\.");
		String KPI19_3 = KPI19_2[0];
		String KPI19_4 = KPI19.substring(KPI19.length() - 2);
		VIPFinancialsPage.contents.KPI19.verifyText(KPI19_3 + "." + KPI19_4);
		String KPI20 = VIPFinancialsPage.contents.KPI20.getText();
		String[] KPI20_2 = KPI20.split("\\.");
		String KPI20_3 = KPI20_2[0];
		String KPI20_4 = KPI20.substring(KPI20.length() - 2);
		VIPFinancialsPage.contents.KPI20.verifyText(KPI20_3 + "." + KPI20_4);
		String KPI21 = VIPFinancialsPage.contents.KPI21.getText();
		String[] KPI21_2 = KPI21.split("\\.");
		String KPI21_3 = KPI21_2[0];
		String KPI21_4 = KPI21.substring(KPI21.length() - 2);
		VIPFinancialsPage.contents.KPI21.verifyText(KPI21_3 + "." + KPI21_4);
		String KPI22 = VIPFinancialsPage.contents.KPI22.getText();
		String[] KPI22_2 = KPI22.split("\\.");
		String KPI22_3 = KPI22_2[0];
		String KPI22_4 = KPI22.substring(KPI22.length() - 2);
		VIPFinancialsPage.contents.KPI22.verifyText(KPI22_3 + "." + KPI22_4);
		String KPI23 = VIPFinancialsPage.contents.KPI23.getText();
		String[] KPI23_2 = KPI23.split("\\.");
		String KPI23_3 = KPI23_2[0];
		String KPI23_4 = KPI23.substring(KPI23.length() - 2);
		VIPFinancialsPage.contents.KPI23.verifyText(KPI23_3 + "." + KPI23_4);
		WebControl.takeScreenshot("Q2A_Reg_Auto_020_TARGET");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_020_PEER");
		String KPIP1 = VIPFinancialsPage.contents.KPIP1.getText();
		String[] KPIP1_2 = KPIP1.split("\\.");
		String KPIP1_3 = KPIP1_2[0];
		String KPIP1_4 = KPIP1.substring(KPIP1.length() - 2);
		VIPFinancialsPage.contents.KPIP1.verifyText(KPIP1_3 + "." + KPIP1_4);
		String KPIP2 = VIPFinancialsPage.contents.KPIP2.getText();
		String[] KPIP2_2 = KPIP2.split("\\.");
		String KPIP2_3 = KPIP2_2[0];
		String KPIP2_4 = KPIP2.substring(KPIP2.length() - 2);
		VIPFinancialsPage.contents.KPIP2.verifyText(KPIP2_3 + "." + KPIP2_4);
		String KPIP3 = VIPFinancialsPage.contents.KPIP3.getText();
		String[] KPIP3_2 = KPIP3.split("\\.");
		String KPIP3_3 = KPIP3_2[0];
		String KPIP3_4 = KPIP3.substring(KPIP3.length() - 2);
		VIPFinancialsPage.contents.KPIP3.verifyText(KPIP3_3 + "." + KPIP3_4);
		String KPIP4 = VIPFinancialsPage.contents.KPIP4.getText();
		String[] KPIP4_2 = KPIP4.split("\\.");
		String KPIP4_3 = KPIP4_2[0];
		String KPIP4_4 = KPIP4.substring(KPIP4.length() - 2);
		VIPFinancialsPage.contents.KPIP4.verifyText(KPIP4_3 + "." + KPIP4_4);
		String KPIP5 = VIPFinancialsPage.contents.KPIP5.getText();
		String[] KPIP5_2 = KPIP5.split("\\.");
		String KPIP5_3 = KPIP5_2[0];
		String KPIP5_4 = KPIP5.substring(KPIP5.length() - 2);
		VIPFinancialsPage.contents.KPIP5.verifyText(KPIP5_3 + "." + KPIP5_4);
		String KPIP6 = VIPFinancialsPage.contents.KPIP6.getText();
		String[] KPIP6_2 = KPIP6.split("\\.");
		String KPIP6_3 = KPIP6_2[0];
		String KPIP6_4 = KPIP6.substring(KPIP6.length() - 2);
		VIPFinancialsPage.contents.KPIP6.verifyText(KPIP6_3 + "." + KPIP6_4);
		String KPIP7 = VIPFinancialsPage.contents.KPIP7.getText();
		String[] KPIP7_2 = KPIP7.split("\\.");
		String KPIP7_3 = KPIP7_2[0];
		String KPIP7_4 = KPIP7.substring(KPIP7.length() - 2);
		VIPFinancialsPage.contents.KPIP7.verifyText(KPIP7_3 + "." + KPIP7_4);
		String KPIP8 = VIPFinancialsPage.contents.KPIP8.getText();
		String[] KPIP8_2 = KPIP8.split("\\.");
		String KPIP8_3 = KPIP8_2[0];
		String KPIP8_4 = KPIP8.substring(KPIP8.length() - 1);
		VIPFinancialsPage.contents.KPIP8.verifyText(KPIP8_3 + "." + KPIP8_4);
		String KPIP9 = VIPFinancialsPage.contents.KPIP9.getText();
		String[] KPIP9_2 = KPIP9.split("\\.");
		String KPIP9_3 = KPIP9_2[0];
		String KPIP9_4 = KPIP9.substring(KPIP9.length() - 1);
		VIPFinancialsPage.contents.KPIP9.verifyText(KPIP9_3 + "." + KPIP9_4);
		String KPIP10 = VIPFinancialsPage.contents.KPIP10.getText();
		String[] KPIP10_2 = KPIP10.split("\\.");
		String KPIP10_3 = KPIP10_2[0];
		String KPIP10_4 = KPIP10.substring(KPIP10.length() - 2);
		VIPFinancialsPage.contents.KPIP10.verifyText(KPIP10_3 + "." + KPIP10_4);
		String KPIP11 = VIPFinancialsPage.contents.KPIP11.getText();
		String[] KPIP11_2 = KPIP11.split("\\.");
		String KPIP11_3 = KPIP11_2[0];
		String KPIP11_4 = KPIP11.substring(KPIP11.length() - 2);
		VIPFinancialsPage.contents.KPIP11.verifyText(KPIP11_3 + "." + KPIP11_4);
		String KPIP12 = VIPFinancialsPage.contents.KPIP12.getText();
		String[] KPIP12_2 = KPIP12.split("\\.");
		String KPIP12_3 = KPIP12_2[0];
		String KPIP12_4 = KPIP12.substring(KPIP12.length() - 2);
		VIPFinancialsPage.contents.KPIP12.verifyText(KPIP12_3 + "." + KPIP12_4);
		String KPIP13 = VIPFinancialsPage.contents.KPIP13.getText();
		String[] KPIP13_2 = KPIP13.split("\\.");
		String KPIP13_3 = KPIP13_2[0];
		String KPIP13_4 = KPIP13.substring(KPIP13.length() - 2);
		VIPFinancialsPage.contents.KPIP13.verifyText(KPIP13_3 + "." + KPIP13_4);
		String KPIP14 = VIPFinancialsPage.contents.KPIP14.getText();
		String[] KPIP14_2 = KPIP14.split("\\.");
		String KPIP14_3 = KPIP14_2[0];
		String KPIP14_4 = KPIP14.substring(KPIP14.length() - 2);
		VIPFinancialsPage.contents.KPIP14.verifyText(KPIP14_3 + "." + KPIP14_4);
		String KPIP15 = VIPFinancialsPage.contents.KPIP15.getText();
		String[] KPIP15_2 = KPIP15.split("\\.");
		String KPIP15_3 = KPIP15_2[0];
		String KPIP15_4 = KPIP15.substring(KPIP15.length() - 1);
		VIPFinancialsPage.contents.KPIP15.verifyText(KPIP15_3 + "." + KPIP15_4);
		String KPIP16 = VIPFinancialsPage.contents.KPIP16.getText();
		String[] KPIP16_2 = KPIP16.split("\\.");
		String KPIP16_3 = KPIP16_2[0];
		String KPIP16_4 = KPIP16.substring(KPIP16.length() - 2);
		VIPFinancialsPage.contents.KPIP16.verifyText(KPIP16_3 + "." + KPIP16_4);
		String KPIP17 = VIPFinancialsPage.contents.KPIP17.getText();
		String[] KPIP17_2 = KPIP17.split("\\.");
		String KPIP17_3 = KPIP17_2[0];
		String KPIP17_4 = KPIP17.substring(KPIP17.length() - 2);
		VIPFinancialsPage.contents.KPIP17.verifyText(KPIP17_3 + "." + KPIP17_4);
		String KPIP18 = VIPFinancialsPage.contents.KPIP18.getText();
		String[] KPIP18_2 = KPIP18.split("\\.");
		String KPIP18_3 = KPIP18_2[0];
		String KPIP18_4 = KPIP18.substring(KPIP18.length() - 2);
		VIPFinancialsPage.contents.KPIP18.verifyText(KPIP18_3 + "." + KPIP18_4);
		String KPIP19 = VIPFinancialsPage.contents.KPIP19.getText();
		String[] KPIP19_2 = KPIP19.split("\\.");
		String KPIP19_3 = KPIP19_2[0];
		String KPIP19_4 = KPIP19.substring(KPIP19.length() - 2);
		VIPFinancialsPage.contents.KPIP19.verifyText(KPIP19_3 + "." + KPIP19_4);
		String KPIP20 = VIPFinancialsPage.contents.KPIP20.getText();
		String[] KPIP20_2 = KPIP20.split("\\.");
		String KPIP20_3 = KPIP20_2[0];
		String KPIP20_4 = KPIP20.substring(KPIP20.length() - 2);
		VIPFinancialsPage.contents.KPIP20.verifyText(KPIP20_3 + "." + KPIP20_4);
		String KPIP21 = VIPFinancialsPage.contents.KPIP21.getText();
		String[] KPIP21_2 = KPIP21.split("\\.");
		String KPIP21_3 = KPIP21_2[0];
		String KPIP21_4 = KPIP21.substring(KPIP21.length() - 2);
		VIPFinancialsPage.contents.KPIP21.verifyText(KPIP21_3 + "." + KPIP21_4);
		String KPIP22 = VIPFinancialsPage.contents.KPIP22.getText();
		String[] KPIP22_2 = KPIP22.split("\\.");
		String KPIP22_3 = KPIP22_2[0];
		String KPIP22_4 = KPIP22.substring(KPIP22.length() - 2);
		VIPFinancialsPage.contents.KPIP22.verifyText(KPIP22_3 + "." + KPIP22_4);
		String KPIP23 = VIPFinancialsPage.contents.KPIP23.getText();
		String[] KPIP23_2 = KPIP23.split("\\.");
		String KPIP23_3 = KPIP23_2[0];
		String KPIP23_4 = KPIP23.substring(KPIP23.length() - 2);
		VIPFinancialsPage.contents.KPIP23.verifyText(KPIP23_3 + "." + KPIP23_4);
		WebControl.takeScreenshot("Q2A_Reg_Auto_020_PEER");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_020_BEST");
		String KPIB1 = VIPFinancialsPage.contents.KPIB1.getText();
		String[] KPIB1_2 = KPIB1.split("\\.");
		String KPIB1_3 = KPIB1_2[0];
		String KPIB1_4 = KPIB1.substring(KPIB1.length() - 2);
		VIPFinancialsPage.contents.KPIB1.verifyText(KPIB1_3 + "." + KPIB1_4);
		String KPIB2 = VIPFinancialsPage.contents.KPIB2.getText();
		String[] KPIB2_2 = KPIB2.split("\\.");
		String KPIB2_3 = KPIB2_2[0];
		String KPIB2_4 = KPIB2.substring(KPIB2.length() - 2);
		VIPFinancialsPage.contents.KPIB2.verifyText(KPIB2_3 + "." + KPIB2_4);
		String KPIB3 = VIPFinancialsPage.contents.KPIB3.getText();
		String[] KPIB3_2 = KPIB3.split("\\.");
		String KPIB3_3 = KPIB3_2[0];
		String KPIB3_4 = KPIB3.substring(KPIB3.length() - 2);
		VIPFinancialsPage.contents.KPIB3.verifyText(KPIB3_3 + "." + KPIB3_4);
		String KPIB4 = VIPFinancialsPage.contents.KPIB4.getText();
		String[] KPIB4_2 = KPIB4.split("\\.");
		String KPIB4_3 = KPIB4_2[0];
		String KPIB4_4 = KPIB4.substring(KPIB4.length() - 2);
		VIPFinancialsPage.contents.KPIB4.verifyText(KPIB4_3 + "." + KPIB4_4);
		String KPIB5 = VIPFinancialsPage.contents.KPIB5.getText();
		String[] KPIB5_2 = KPIB5.split("\\.");
		String KPIB5_3 = KPIB5_2[0];
		String KPIB5_4 = KPIB5.substring(KPIB5.length() - 2);
		VIPFinancialsPage.contents.KPIB5.verifyText(KPIB5_3 + "." + KPIB5_4);
		String KPIB6 = VIPFinancialsPage.contents.KPIB6.getText();
		String[] KPIB6_2 = KPIB6.split("\\.");
		String KPIB6_3 = KPIB6_2[0];
		String KPIB6_4 = KPIB6.substring(KPIB6.length() - 2);
		VIPFinancialsPage.contents.KPIB6.verifyText(KPIB6_3 + "." + KPIB6_4);
		String KPIB7 = VIPFinancialsPage.contents.KPIB7.getText();
		String[] KPIB7_2 = KPIB7.split("\\.");
		String KPIB7_3 = KPIB7_2[0];
		String KPIB7_4 = KPIB7.substring(KPIB7.length() - 2);
		VIPFinancialsPage.contents.KPIB7.verifyText(KPIB7_3 + "." + KPIB7_4);
		String KPIB8 = VIPFinancialsPage.contents.KPIB8.getText();
		String[] KPIB8_2 = KPIB8.split("\\.");
		String KPIB8_3 = KPIB8_2[0];
		String KPIB8_4 = KPIB8.substring(KPIB8.length() - 1);
		VIPFinancialsPage.contents.KPIB8.verifyText(KPIB8_3 + "." + KPIB8_4);
		String KPIB9 = VIPFinancialsPage.contents.KPIB9.getText();
		String[] KPIB9_2 = KPIB9.split("\\.");
		String KPIB9_3 = KPIB9_2[0];
		String KPIB9_4 = KPIB9.substring(KPIB9.length() - 1);
		VIPFinancialsPage.contents.KPIB9.verifyText(KPIB9_3 + "." + KPIB9_4);
		String KPIB10 = VIPFinancialsPage.contents.KPIB10.getText();
		String[] KPIB10_2 = KPIB10.split("\\.");
		String KPIB10_3 = KPIB10_2[0];
		String KPIB10_4 = KPIB10.substring(KPIB10.length() - 2);
		VIPFinancialsPage.contents.KPIB10.verifyText(KPIB10_3 + "." + KPIB10_4);
		String KPIB11 = VIPFinancialsPage.contents.KPIB11.getText();
		String[] KPIB11_2 = KPIB11.split("\\.");
		String KPIB11_3 = KPIB11_2[0];
		String KPIB11_4 = KPIB11.substring(KPIB11.length() - 2);
		VIPFinancialsPage.contents.KPIB11.verifyText(KPIB11_3 + "." + KPIB11_4);
		String KPIB12 = VIPFinancialsPage.contents.KPIB12.getText();
		String[] KPIB12_2 = KPIB12.split("\\.");
		String KPIB12_3 = KPIB12_2[0];
		String KPIB12_4 = KPIB12.substring(KPIB12.length() - 2);
		VIPFinancialsPage.contents.KPIB12.verifyText(KPIB12_3 + "." + KPIB12_4);
		String KPIB13 = VIPFinancialsPage.contents.KPIB13.getText();
		String[] KPIB13_2 = KPIB13.split("\\.");
		String KPIB13_3 = KPIB13_2[0];
		String KPIB13_4 = KPIB13.substring(KPIB13.length() - 2);
		VIPFinancialsPage.contents.KPIB13.verifyText(KPIB13_3 + "." + KPIB13_4);
		String KPIB14 = VIPFinancialsPage.contents.KPIB14.getText();
		String[] KPIB14_2 = KPIB14.split("\\.");
		String KPIB14_3 = KPIB14_2[0];
		String KPIB14_4 = KPIB14.substring(KPIB14.length() - 2);
		VIPFinancialsPage.contents.KPIB14.verifyText(KPIB14_3 + "." + KPIB14_4);
		String KPIB15 = VIPFinancialsPage.contents.KPIB15.getText();
		String[] KPIB15_2 = KPIB15.split("\\.");
		String KPIB15_3 = KPIB15_2[0];
		String KPIB15_4 = KPIB15.substring(KPIB15.length() - 1);
		VIPFinancialsPage.contents.KPIB15.verifyText(KPIB15_3 + "." + KPIB15_4);
		String KPIB16 = VIPFinancialsPage.contents.KPIB16.getText();
		String[] KPIB16_2 = KPIB16.split("\\.");
		String KPIB16_3 = KPIB16_2[0];
		String KPIB16_4 = KPIB16.substring(KPIB16.length() - 2);
		VIPFinancialsPage.contents.KPIB16.verifyText(KPIB16_3 + "." + KPIB16_4);
		String KPIB17 = VIPFinancialsPage.contents.KPIB17.getText();
		String[] KPIB17_2 = KPIB17.split("\\.");
		String KPIB17_3 = KPIB17_2[0];
		String KPIB17_4 = KPIB17.substring(KPIB17.length() - 2);
		VIPFinancialsPage.contents.KPIB17.verifyText(KPIB17_3 + "." + KPIB17_4);
		String KPIB18 = VIPFinancialsPage.contents.KPIB18.getText();
		String[] KPIB18_2 = KPIB18.split("\\.");
		String KPIB18_3 = KPIB18_2[0];
		String KPIB18_4 = KPIB18.substring(KPIB18.length() - 2);
		VIPFinancialsPage.contents.KPIB18.verifyText(KPIB18_3 + "." + KPIB18_4);
		String KPIB19 = VIPFinancialsPage.contents.KPIB19.getText();
		String[] KPIB19_2 = KPIB19.split("\\.");
		String KPIB19_3 = KPIB19_2[0];
		String KPIB19_4 = KPIB19.substring(KPIB19.length() - 2);
		VIPFinancialsPage.contents.KPIB19.verifyText(KPIB19_3 + "." + KPIB19_4);
		String KPIB20 = VIPFinancialsPage.contents.KPIB20.getText();
		String[] KPIB20_2 = KPIB20.split("\\.");
		String KPIB20_3 = KPIB20_2[0];
		String KPIB20_4 = KPIB20.substring(KPIB20.length() - 2);
		VIPFinancialsPage.contents.KPIB20.verifyText(KPIB20_3 + "." + KPIB20_4);
		String KPIB21 = VIPFinancialsPage.contents.KPIB21.getText();
		String[] KPIB21_2 = KPIB21.split("\\.");
		String KPIB21_3 = KPIB21_2[0];
		String KPIB21_4 = KPIB21.substring(KPIB21.length() - 2);
		VIPFinancialsPage.contents.KPIB21.verifyText(KPIB21_3 + "." + KPIB21_4);
		String KPIB22 = VIPFinancialsPage.contents.KPIB22.getText();
		String[] KPIB22_2 = KPIB22.split("\\.");
		String KPIB22_3 = KPIB22_2[0];
		String KPIB22_4 = KPIB22.substring(KPIB22.length() - 2);
		VIPFinancialsPage.contents.KPIB22.verifyText(KPIB22_3 + "." + KPIB22_4);
		VIPFinancialsPage.contents.KPI23.hover();
		String KPIB23 = VIPFinancialsPage.contents.KPIB23.getText();
		String[] KPIB23_2 = KPIB23.split("\\.");
		String KPIB23_3 = KPIB23_2[0];
		String KPIB23_4 = KPIB23.substring(KPIB23.length() - 2);
		VIPFinancialsPage.contents.KPI23.hover();
		VIPFinancialsPage.contents.KPIB23.verifyText(KPIB23_3 + "." + KPIB23_4);
		WebControl.takeScreenshot("Q2A_Reg_Auto_020_BEST");
		
//		ReportLog.setTestCase("Q2A_Reg_Auto_021");
//		//String noTRSCompany = "China Resources Pharmaceutical Group Limited";
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.BackToSearchButton.hover();
//		VIPOverviewPage.contents.BackToSearchButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.noTRSCompany);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
//		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
//		Thread.sleep(1000);
//		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
//		Thread.sleep(3000);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
//		VIPOverviewPage.contents.FinancialsTitle.hover();
//		Thread.sleep(3000);
//		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
//		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
//		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
//		VIPFinancialsPage.contents.TRS5YrKPI.verifyText("N/A");
//		//VIPFinancialsPage.contents.ScorecardFootNote.verifyText("Note: Companies with 5-year TRS not available (" + noTRSCompany + ") are removed from TRS development.");
//		VIPFinancialsPage.contents.ScorecardFootNote.verifyDisplayed(true, 3);
//		WebControl.takeScreenshot("Q2A_Reg_Auto_021");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_022");
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
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		Thread.sleep(3000);
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.KPI1.waitForExist(true, 45);
		VIPFinancialsPage.contents.KPI1.verifyText(KPI1);
		VIPFinancialsPage.contents.KPI2.verifyText(KPI2);
		VIPFinancialsPage.contents.KPI3.verifyText(KPI3);
		VIPFinancialsPage.contents.KPI4.verifyText(KPI4);
		VIPFinancialsPage.contents.KPI5.verifyText(KPI5);
		VIPFinancialsPage.contents.KPI6.verifyText(KPI6);
		VIPFinancialsPage.contents.KPI7.verifyText(KPI7);
		VIPFinancialsPage.contents.KPI8.verifyText(KPI8);
		VIPFinancialsPage.contents.KPI9.verifyText(KPI9);
		VIPFinancialsPage.contents.KPI10.verifyText(KPI10);
		VIPFinancialsPage.contents.KPI11.verifyText(KPI11);
		VIPFinancialsPage.contents.KPI12.verifyText(KPI12);
		VIPFinancialsPage.contents.KPI13.verifyText(KPI13);
		VIPFinancialsPage.contents.KPI14.verifyText(KPI14);
		VIPFinancialsPage.contents.KPI15.verifyText(KPI15);
		VIPFinancialsPage.contents.KPI16.verifyText(KPI16);
		VIPFinancialsPage.contents.KPI17.verifyText(KPI17);
		VIPFinancialsPage.contents.KPI18.verifyText(KPI18);
		VIPFinancialsPage.contents.KPI19.verifyText(KPI19);
		VIPFinancialsPage.contents.KPI20.verifyText(KPI20);
		VIPFinancialsPage.contents.KPI21.verifyText(KPI21);
		VIPFinancialsPage.contents.KPI22.verifyText(KPI22);
		VIPFinancialsPage.contents.KPI23.verifyText(KPI23);
		
		VIPFinancialsPage.contents.KPIP1.verifyText(KPIP1);
		VIPFinancialsPage.contents.KPIP2.verifyText(KPIP2);
		VIPFinancialsPage.contents.KPIP3.verifyText(KPIP3);
		VIPFinancialsPage.contents.KPIP4.verifyText(KPIP4);
		VIPFinancialsPage.contents.KPIP5.verifyText(KPIP5);
		VIPFinancialsPage.contents.KPIP6.verifyText(KPIP6);
		VIPFinancialsPage.contents.KPIP7.verifyText(KPIP7);
		VIPFinancialsPage.contents.KPIP8.verifyText(KPIP8);
		VIPFinancialsPage.contents.KPIP9.verifyText(KPIP9);
		VIPFinancialsPage.contents.KPIP10.verifyText(KPIP10);
		VIPFinancialsPage.contents.KPIP11.verifyText(KPIP11);
		VIPFinancialsPage.contents.KPIP12.verifyText(KPIP12);
		VIPFinancialsPage.contents.KPIP13.verifyText(KPIP13);
		VIPFinancialsPage.contents.KPIP14.verifyText(KPIP14);
		VIPFinancialsPage.contents.KPIP15.verifyText(KPIP15);
		VIPFinancialsPage.contents.KPIP16.verifyText(KPIP16);
		VIPFinancialsPage.contents.KPIP17.verifyText(KPIP17);
		VIPFinancialsPage.contents.KPIP18.verifyText(KPIP18);
		VIPFinancialsPage.contents.KPIP19.verifyText(KPIP19);
		VIPFinancialsPage.contents.KPIP20.verifyText(KPIP20);
		VIPFinancialsPage.contents.KPIP21.verifyText(KPIP21);
		VIPFinancialsPage.contents.KPIP22.verifyText(KPIP22);
		VIPFinancialsPage.contents.KPIP23.verifyText(KPIP23);
		
		VIPFinancialsPage.contents.KPIB1.verifyText(KPIB1);
		VIPFinancialsPage.contents.KPIB2.verifyText(KPIB2);
		VIPFinancialsPage.contents.KPIB3.verifyText(KPIB3);
		VIPFinancialsPage.contents.KPIB4.verifyText(KPIB4);
		VIPFinancialsPage.contents.KPIB5.verifyText(KPIB5);
		VIPFinancialsPage.contents.KPIB6.verifyText(KPIB6);
		VIPFinancialsPage.contents.KPIB7.verifyText(KPIB7);
		VIPFinancialsPage.contents.KPIB8.verifyText(KPIB8);
		VIPFinancialsPage.contents.KPIB9.verifyText(KPIB9);
		VIPFinancialsPage.contents.KPIB10.verifyText(KPIB10);
		VIPFinancialsPage.contents.KPIB11.verifyText(KPIB11);
		VIPFinancialsPage.contents.KPIB12.verifyText(KPIB12);
		VIPFinancialsPage.contents.KPIB13.verifyText(KPIB13);
		VIPFinancialsPage.contents.KPIB14.verifyText(KPIB14);
		VIPFinancialsPage.contents.KPIB15.verifyText(KPIB15);
		VIPFinancialsPage.contents.KPIB16.verifyText(KPIB16);
		VIPFinancialsPage.contents.KPIB17.verifyText(KPIB17);
		VIPFinancialsPage.contents.KPIB18.verifyText(KPIB18);
		VIPFinancialsPage.contents.KPIB19.verifyText(KPIB19);
		VIPFinancialsPage.contents.KPIB20.verifyText(KPIB20);
		VIPFinancialsPage.contents.KPIB21.verifyText(KPIB21);
		VIPFinancialsPage.contents.KPIB22.verifyText(KPIB22);
		VIPFinancialsPage.contents.KPIB23.verifyText(KPIB23);
		WebControl.takeScreenshot("Q2A_Reg_Auto_022");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
		ReportLog.setTestCase("Q2A_Reg_Auto_023");
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
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.RefineCriteriaButton.waitForExist(true, 25);
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.TopFilterDropdown.click();
		VIPCompetitorPage.contents.TopFilterChoice25.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 25);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.waitForExist(true, 20);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.SelectDropDown1.click();
		VIPFinancialsPage.contents.MetricTitle1.verifyText("REVENUE GROWTH");
		VIPFinancialsPage.contents.SubMetricTitle1.verifyText("5-year Revenue CAGR");
		VIPFinancialsPage.contents.SubMetricTitle2.verifyText("3-year Revenue CAGR");
		VIPFinancialsPage.contents.SubMetricTitle3.verifyText("1-year Revenue Growth");
		VIPFinancialsPage.contents.MetricTitle2.verifyText("PRE-TAX ROIC DECOMPOSITION");
		VIPFinancialsPage.contents.SubMetricTitle4.verifyText("ROIC (Pre-Tax)");
		VIPFinancialsPage.contents.ROICTooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SubMetricTitle5.verifyText("EBIT Margin");
		VIPFinancialsPage.contents.EBITTooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SubMetricTitle6.verifyText("Capital Efficiency");
		VIPFinancialsPage.contents.CETooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.MetricTitle3.verifyText("OPERATING MARGIN DECOMPOSITION");
		VIPFinancialsPage.contents.SubMetricTitle7.verifyText("Cost of Goods Sold");
		VIPFinancialsPage.contents.COGSTooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SubMetricTitle8.verifyText("Selling, General & Administrative Expenses");
		VIPFinancialsPage.contents.SGATooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.MetricTitle4.verifyText("INVESTED CAPITAL DECOMPOSITION");
		VIPFinancialsPage.contents.SubMetricTitle9.verifyText("Operating Working Capital");
		VIPFinancialsPage.contents.OWCTooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SubMetricTitle10.verifyText("Property, Plant & Equipment");
		VIPFinancialsPage.contents.PPETooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SubMetricTitle11.verifyText("Goodwill & Intangibles");
		VIPFinancialsPage.contents.GITooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.MetricTitle5.verifyText("WORKING CAPITAL DECOMPOSITION");
		VIPFinancialsPage.contents.SubMetricTitle12.verifyText("Net Receivables");
		VIPFinancialsPage.contents.NRTooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SubMetricTitle13.verifyText("Inventory");
		VIPFinancialsPage.contents.INVTooltipIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SubMetricTitle14.verifyText("Accounts Payable");
		VIPFinancialsPage.contents.APTooltipIcon.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_023");
		
	}	
	
	@Test(priority=3)
	public void Q2A_TRS () throws Exception {
		ReportLog.setTestName("Financials - TRS");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		//FinancialsTRS		
		ReportLog.setTestCase("Q2A_Reg_Auto_024_TRSDefault");
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
	
	@Test(priority=4)
	public void Q2A_EVICDecomposition () throws Exception {
		ReportLog.setTestName("Financials - EVIC Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Regression_033");
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
		VIPFinancialsPage.contents.EvicFootNoteCompanies.verifyDisplayed(true, 3);
		String CP1 = VIPFinancialsPage.contents.EvicKeyInsightsCP1.getText();
		String CP2 = VIPFinancialsPage.contents.EvicKeyInsightsCP2.getText();
		String CP3 = VIPFinancialsPage.contents.EvicKeyInsightsCP3.getText();
		String Best1 = VIPFinancialsPage.contents.EvicKeyInsightsBest1.getText();
		String Best2 = VIPFinancialsPage.contents.EvicKeyInsightsBest2.getText();
		String Best3 = VIPFinancialsPage.contents.EvicKeyInsightsBest3.getText();
		String EvicFootNoteCompanies = VIPFinancialsPage.contents.EvicFootNoteCompanies.getText();
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

	@Test(priority=5)
	public void Q2A_AnalystRecommendation () throws Exception {
		ReportLog.setTestName("Financials - Analyst Recommendation");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_043_ARCharts");		
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
	
	@Test(priority=6)
	public void Q2A_RevenueProfitEstimates () throws Exception {
		ReportLog.setTestName("Financials - Revenue Profit Estimates");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_051_to_053_RPECharts");			
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

	@Test(priority=7)
	public void Q2A_RevenueGrowth () throws Exception {
		ReportLog.setTestName("Q2A - Revenue Growth");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_059");		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.RG5YrRevCAGRHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG5YrRevCAGRHeader.verifyText("5 year Revenue CAGR");
		VIPFinancialsPage.contents.RG3YrRevCAGRHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG3YrRevCAGRHeader.verifyText("3 year Revenue CAGR");
		VIPFinancialsPage.contents.RG1YrRevCAGRHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG1YrRevCAGRHeader.verifyText("1 year Revenue Growth");
		WebControl.takeScreenshot("Q2A_Reg_Auto_059");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_060");
		String RG5YrRevCAGR = VIPFinancialsPage.contents.RG5YrRevCAGRPeriod.getText();
		String RG5YrRevCAGR_1 = RG5YrRevCAGR.substring(4, 11);
		String RG5YrRevCAGR_2 = RG5YrRevCAGR.substring(18, 25);
		String RG3YrRevCAGR = VIPFinancialsPage.contents.RG3YrRevCAGRPeriod.getText();
		String RG3YrRevCAGR_1 = RG3YrRevCAGR.substring(4, 11);
		String RG3YrRevCAGR_2 = RG3YrRevCAGR.substring(18, 25);
		String RG1YrRevCAGR = VIPFinancialsPage.contents.RG1YrRevCAGRPeriod.getText();
		String RG1YrRevCAGR_1 = RG1YrRevCAGR.substring(4, 11);
		String RG1YrRevCAGR_2 = RG1YrRevCAGR.substring(18, 25);
		VIPFinancialsPage.contents.RG5YrRevCAGRPeriod.verifyText("[FY-" + RG5YrRevCAGR_1 + " - TTM-" + RG5YrRevCAGR_2 + "]");
		VIPFinancialsPage.contents.RG3YrRevCAGRPeriod.verifyText("[FY-" + RG3YrRevCAGR_1 + " - TTM-" + RG3YrRevCAGR_2 + "]");
		VIPFinancialsPage.contents.RG1YrRevCAGRPeriod.verifyText("[FY-" + RG1YrRevCAGR_1 + " - TTM-" + RG1YrRevCAGR_2 + "]");
		WebControl.takeScreenshot("Q2A_Reg_Auto_060");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_061");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.CAGR5YrKPI.waitForExist(true, 15);
		String CAGR5YrKPI1 = VIPFinancialsPage.contents.CAGR5YrKPI.getText();
		String CAGR5YrKPI2 = CAGR5YrKPI1.replace("%", "");
		Double CAGR5YrKPI = Double.parseDouble(CAGR5YrKPI2);
		Double CAGR5YrKPIAbs = Math.abs(CAGR5YrKPI);
		String CAGR3YrKPI = VIPFinancialsPage.contents.CAGR3YrKPI.getText();
		String CAGR1YrKPI1 = VIPFinancialsPage.contents.CAGR1YrKPI.getText();
		String CAGR1YrKPI2 = CAGR1YrKPI1.replace("%", "");
		Double CAGR1YrKPI = Double.parseDouble(CAGR1YrKPI2);
		Double CAGR1YrKPIAbs = Math.abs(CAGR1YrKPI);
		String CAGR5YrKPIP = VIPFinancialsPage.contents.CAGR5YrKPIP.getText();
		String CAGR3YrKPIP = VIPFinancialsPage.contents.CAGR3YrKPIP.getText();
		String CAGR1YrKPIP1 = VIPFinancialsPage.contents.CAGR1YrKPIP.getText();
		String CAGR1YrKPIP2 = CAGR1YrKPIP1.replace("%", "");
		Double CAGR1YrKPIP = Double.parseDouble(CAGR1YrKPIP2);
		Double CAGR1YrKPIPAbs = Math.abs(CAGR1YrKPIP);
		String CAGR5YrRank2_1 = VIPFinancialsPage.contents.CAGR5YrRank.getText();
		String[] CAGR5YrRank2_2 = CAGR5YrRank2_1.split("\\/");
		String CAGR5YrRank2_3 = CAGR5YrRank2_2[0];
		String CAGR5YrRank2_4 = CAGR5YrRank2_2[1];
		String CAGR5YrRank2_5 = CAGR5YrRank2_3.replace(" ", "");
		String CAGR5YrRank2_6 = CAGR5YrRank2_4.replace(" ", "");
		Double CAGR5YrRank3_1 = Double.parseDouble(CAGR5YrRank2_5);
		Double CAGR5YrRank3_2 = Double.parseDouble(CAGR5YrRank2_6);
		Double CAGR5YrRank = (CAGR5YrRank3_1/CAGR5YrRank3_2);
		String CAGR3YrRank2_1 = VIPFinancialsPage.contents.CAGR3YrRank.getText();
		String[] CAGR3YrRank2_2 = CAGR3YrRank2_1.split("\\/");
		String CAGR3YrRank2_3 = CAGR3YrRank2_2[0];
		String CAGR3YrRank2_4 = CAGR3YrRank2_2[1];
		String CAGR3YrRank2_5 = CAGR3YrRank2_3.replace(" ", "");
		String CAGR3YrRank2_6 = CAGR3YrRank2_4.replace(" ", "");
		Double CAGR3YrRank3_1 = Double.parseDouble(CAGR3YrRank2_5);
		Double CAGR3YrRank3_2 = Double.parseDouble(CAGR3YrRank2_6);
		Double CAGR3YrRank = (CAGR3YrRank3_1/CAGR3YrRank3_2);
		String CAGR1YrRank2_1 = VIPFinancialsPage.contents.CAGR1YrRank.getText();
		String[] CAGR1YrRank2_2 = CAGR1YrRank2_1.split("\\/");
		String CAGR1YrRank2_3 = CAGR1YrRank2_2[0];
		String CAGR1YrRank2_4 = CAGR1YrRank2_2[1];
		String CAGR1YrRank2_5 = CAGR1YrRank2_3.replace(" ", "");
		String CAGR1YrRank2_6 = CAGR1YrRank2_4.replace(" ", "");
		Double CAGR1YrRank3_1 = Double.parseDouble(CAGR1YrRank2_5);
		Double CAGR1YrRank3_2 = Double.parseDouble(CAGR1YrRank2_6);
		Double CAGR1YrRank = (CAGR1YrRank3_1/CAGR1YrRank3_2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.RG5YrRevCAGRPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG5YrRevCAGRPeerMedian.verifyText("Peer Median: " + CAGR5YrKPIP);
		VIPFinancialsPage.contents.RG3YrRevCAGRPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG3YrRevCAGRPeerMedian.verifyText("Peer Median: " + CAGR3YrKPIP);
		VIPFinancialsPage.contents.RG1YrRevCAGRPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG1YrRevCAGRPeerMedian.verifyText("Peer Median: " + CAGR1YrKPIP1);
		WebControl.takeScreenshot("Q2A_Reg_Auto_061");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_063");
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (CAGR5YrKPI < 0) {
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s revenue shrunk at a CAGR of " + CAGR5YrKPIAbs + "% over the last 5 years");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s revenue grew at a CAGR of " + CAGR5YrKPIAbs + "% over the last 5 years");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if ((CAGR1YrKPI < 0) & (CAGR1YrKPI < CAGR1YrKPIP)) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("In the last 1 year, the company’s revenue shrunk by " + CAGR1YrKPIAbs + "%" + " (trailing the peer median of " + CAGR1YrKPIP + "%)");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("In the last 1 year, the company’s revenue grew by " + CAGR1YrKPIAbs + "%" + " (exceeding the peer median of " + CAGR1YrKPIP + "%)");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((CAGR1YrRank > 0) & (CAGR1YrRank <= 0.25)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText("The company’s 1 year revenue growth performance was at the top quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((CAGR1YrRank > 0.25) & (CAGR1YrRank <= 0.5)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText("The company’s 1 year revenue growth performance was at the 2nd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((CAGR1YrRank > 0.5) & (CAGR1YrRank <= 0.75)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText("The company’s 1 year revenue growth performance was at the 3rd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText("The company’s 1 year revenue growth performance was at the bottom quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_063");
		
		if (VIPFinancialsPage.contents.FootNote.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Reg_Auto_064");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(true, 5);
		String SP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String Best = VIPFinancialsPage.contents.BestInClass.getText();
		String FootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_064");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_065");
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
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(SP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(Best);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_065");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Reg_Auto_064");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		String SP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String Best = VIPFinancialsPage.contents.BestInClass.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_064");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_065");
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
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(SP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(Best);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_065");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
	}
	
	@Test(priority=8)
	public void Q2A_EmployeeProductivity () throws Exception {
		ReportLog.setTestName("Financials - Employee Productivity");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_066_EmpProdCharts");	
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

	@Test(priority=9)
	public void Q2A_PreTaxROIC () throws Exception {
		ReportLog.setTestName("Q2A - Pre-Tax ROIC Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_074");		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.PreTaxROICMenu.click();
		VIPFinancialsPage.contents.LeftHandChartHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.LeftHandChartHeader.verifyText("RETURN ON INVESTED CAPITAL (ROIC) DECOMPOSITION");
		VIPFinancialsPage.contents.LeftHandChartNote.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.LeftHandChartNote.verifyText("Click on the KPI box to view peer comparison");
		VIPFinancialsPage.contents.RightHandChartHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("PRE-TAX RETURN ON INVESTED CAPITAL");
		WebControl.takeScreenshot("Q2A_Reg_Auto_074");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_075");
		VIPFinancialsPage.contents.PeerComparisonToggle.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.PeerComparisonToggleLabel.verifyText("Detailed Peer Comparison");
		WebControl.takeScreenshot("Q2A_Reg_Auto_075");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_076");
		VIPFinancialsPage.contents.ROICBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.EBITMARGINBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.EBITDAMarginBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DARevenueBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WorkingCapitalRevenueBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.NetPPERevenueBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.NetOtherAssetsRevenueBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.COGSRevenueBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SGARevenueBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.OtherExpensesRevenueBox.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_076");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_077");
		VIPFinancialsPage.contents.EBITMARGINBox.hover();
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("EBIT MARGIN");
		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.hover();
		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("CAPITAL EFFICIENCY");
		VIPFinancialsPage.contents.EBITDAMarginBox.hover();
		VIPFinancialsPage.contents.EBITDAMarginBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("EBITDA MARGIN");
		VIPFinancialsPage.contents.DARevenueBox.hover();
		VIPFinancialsPage.contents.DARevenueBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("D&A / REVENUE");
		VIPFinancialsPage.contents.WorkingCapitalRevenueBox.hover();
		VIPFinancialsPage.contents.WorkingCapitalRevenueBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		VIPFinancialsPage.contents.NetPPERevenueBox.hover();
		VIPFinancialsPage.contents.NetPPERevenueBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("NET PPE / REVENUE");
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueBox.hover();
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("GOODWILL & INTANGIBLES / REVENUE");
		VIPFinancialsPage.contents.NetOtherAssetsRevenueBox.hover();
		VIPFinancialsPage.contents.NetOtherAssetsRevenueBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("NET OTHER ASSETS / REVENUE");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.COGSRevenueBox.hover();
		VIPFinancialsPage.contents.COGSRevenueBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("COGS / REVENUE");
		VIPFinancialsPage.contents.SGARevenueBox.hover();
		VIPFinancialsPage.contents.SGARevenueBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("SG&A / REVENUE");
		VIPFinancialsPage.contents.OtherExpensesRevenueBox.hover();
		VIPFinancialsPage.contents.OtherExpensesRevenueBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("OTHER EXPENSES / REVENUE");
		VIPFinancialsPage.contents.ROICBox.hover();
		VIPFinancialsPage.contents.ROICBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("PRE-TAX RETURN ON INVESTED CAPITAL");
		WebControl.takeScreenshot("Q2A_Reg_Auto_077");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_078");
		VIPFinancialsPage.contents.EBITMARGINiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.EBITMARGINiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.EBITMTooltip);
		VIPFinancialsPage.contents.EBITMARGINiIcon.click();
		VIPFinancialsPage.contents.CAPITALEFFICIENCYiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.CAPITALEFFICIENCYiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.CAPEFFTooltip);
		VIPFinancialsPage.contents.CAPITALEFFICIENCYiIcon.click();
		VIPFinancialsPage.contents.EBITDAMarginiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.EBITDAMarginiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.EBITDATooltip);
		VIPFinancialsPage.contents.EBITDAMarginiIcon.click();
		VIPFinancialsPage.contents.DARevenueiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.DARevenueiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.DATooltip);
		VIPFinancialsPage.contents.DARevenueiIcon.click();
		VIPFinancialsPage.contents.WorkingCapitalRevenueiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.WorkingCapitalRevenueiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.WCRTooltip);
		VIPFinancialsPage.contents.WorkingCapitalRevenueiIcon.click();
		VIPFinancialsPage.contents.NetPPERevenueiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.NetPPERevenueiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.NPPETooltip);
		VIPFinancialsPage.contents.NetPPERevenueiIcon.click();
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.GITooltip);
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueiIcon.click();
		VIPFinancialsPage.contents.COGSRevenueiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.COGSRevenueiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.COGSTooltip);
		VIPFinancialsPage.contents.COGSRevenueiIcon.click();
		VIPFinancialsPage.contents.SGARevenueiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.SGARevenueiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.SGATooltip);
		VIPFinancialsPage.contents.SGARevenueiIcon.click();
		VIPFinancialsPage.contents.ROICiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ROICiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.ROICTooltip);
		VIPFinancialsPage.contents.ROICiIcon.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_078");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_079");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		//ROICKPI & ROICKPIP
		VIPFinancialsPage.contents.ROICKPI.waitForExist(true, 20);
		String ROICKPI1 = VIPFinancialsPage.contents.ROICKPI.getText();
		String ROICKPI2 = ROICKPI1.replace("%", "");
		Double ROICKPI = Double.parseDouble(ROICKPI2);
		String ROICKPIP1 = VIPFinancialsPage.contents.ROICKPIP.getText();
		String ROICKPIP2 = ROICKPIP1.replace("%", "");
		Double ROICKPIP = Double.parseDouble(ROICKPIP2);
		//EBITMarginKPI & EBITMarginKPIP
		String EBITMarginKPI1 = VIPFinancialsPage.contents.EBITMarginKPI.getText();
		String EBITMarginKPI2 = EBITMarginKPI1.replace("%", "");
		Double EBITMarginKPI = Double.parseDouble(EBITMarginKPI2);
		String EBITMarginKPIP1 = VIPFinancialsPage.contents.EBITMarginKPIP.getText();
		String EBITMarginKPIP2 = EBITMarginKPIP1.replace("%", "");
		Double EBITMarginKPIP = Double.parseDouble(EBITMarginKPIP2);
		//NetPPEKPI & NetPPEKPIP
		String NetPPEKPI1 = VIPFinancialsPage.contents.NetPPEKPI.getText();
		String NetPPEKPI2 = NetPPEKPI1.replace("%", "");
		Double NetPPEKPI = Double.parseDouble(NetPPEKPI2);
		String NetPPEKPIP1 = VIPFinancialsPage.contents.NetPPEKPIP.getText();
		String NetPPEKPIP2 = NetPPEKPIP1.replace("%", "");
		Double NetPPEKPIP = Double.parseDouble(NetPPEKPIP2);
		//COGSRevenueKPI & COGSRevenueKPIP
		String COGSRevenueKPI1 = VIPFinancialsPage.contents.COGSKPI.getText();
		String COGSRevenueKPI2 = COGSRevenueKPI1.replace("%", "");
		Double COGSRevenueKPI = Double.parseDouble(COGSRevenueKPI2);
		String COGSRevenueKPIP1 = VIPFinancialsPage.contents.COGSKPIP.getText();
		String COGSRevenueKPIP2 = COGSRevenueKPIP1.replace("%", "");
		Double COGSRevenueKPIP = Double.parseDouble(COGSRevenueKPIP2);
		//SGARevenueKPI & SGARevenueKPIP
		String SGARevenueKPI1 = VIPFinancialsPage.contents.SGAKPI.getText();
		String SGARevenueKPI2 = SGARevenueKPI1.replace("%", "");
		Double SGARevenueKPI = Double.parseDouble(SGARevenueKPI2);
		String SGARevenueKPIP1 = VIPFinancialsPage.contents.SGAKPIP.getText();
		String SGARevenueKPIP2 = SGARevenueKPIP1.replace("%", "");
		Double SGARevenueKPIP = Double.parseDouble(SGARevenueKPIP2);
		//ROIC
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.PreTaxROICMenu.click();
		if (ROICKPI > ROICKPIP) {
		VIPFinancialsPage.contents.ROICGreenIcon.verifyDisplayed(true, 5);}
		else if (ROICKPI < ROICKPIP) {
		VIPFinancialsPage.contents.ROICRedIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.ROICYellowIcon.verifyDisplayed(true, 5);}
		//EBITMargin
		if (EBITMarginKPI > EBITMarginKPIP) {
		VIPFinancialsPage.contents.EBITMARGINGreenIcon.verifyDisplayed(true, 5);}
		else if (EBITMarginKPI < EBITMarginKPIP) {
		VIPFinancialsPage.contents.EBITMARGINRedIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.EBITMARGINYellowIcon.verifyDisplayed(true, 5);}
		//CAPEFF, EBITDAMargin, DARevenue, WorkingCapRev
		VIPFinancialsPage.contents.CAPEFFGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.EBITDAMarginGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DARevenueGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WorkingCapRevGaugeIcon.verifyDisplayed(true, 5);
		//NetPPERevenue
		if (NetPPEKPIP > NetPPEKPI) {
		VIPFinancialsPage.contents.NetPPERevenueGreenIcon.verifyDisplayed(true, 5);}
		else if (NetPPEKPIP < NetPPEKPI) {
		VIPFinancialsPage.contents.NetPPERevenueRedIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.NetPPERevenueYellowIcon.verifyDisplayed(true, 5);}
		//GoodIntRev, NetOtherAssRev
		VIPFinancialsPage.contents.GoodIntRevGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.NetOtherAssRevGaugeIcon.verifyDisplayed(true, 5);
		//COGSRevenue
		if (COGSRevenueKPIP > COGSRevenueKPI) {
		VIPFinancialsPage.contents.COGSRevenueGreenIcon.verifyDisplayed(true, 5);}
		else if (COGSRevenueKPIP < COGSRevenueKPI) {
		VIPFinancialsPage.contents.COGSRevenueRedIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.COGSRevenueYellowIcon.verifyDisplayed(true, 5);}
		//SGARevenue
		if (SGARevenueKPIP > SGARevenueKPI) {
		VIPFinancialsPage.contents.SGARevenueGreenIcon.verifyDisplayed(true, 5);}
		else if (SGARevenueKPIP < SGARevenueKPI) {
		VIPFinancialsPage.contents.SGARevenueRedIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.SGARevenueYellowIcon.verifyDisplayed(true, 5);}
		//OtherExpRev
		VIPFinancialsPage.contents.OtherExpRevGaugeIcon.verifyDisplayed(true, 5);
		//Legend
		VIPFinancialsPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ROICTargetCompLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPFinancialsPage.contents.ROICBetterLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ROICBetterLegendText.verifyText("Better than peer median");
		VIPFinancialsPage.contents.ROICWorseLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ROICWorseLegendText.verifyText("Worse than peer median");
		VIPFinancialsPage.contents.ROICInlineLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ROICInlineLegendText.verifyText("In-line with peer median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_079");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_080");
		int OneYrAgo = get1YearAgo();
		String OneYear = String.valueOf(OneYrAgo);
		int TwoYrsAgo = get2YearsAgo();
		String TwoYears = String.valueOf(TwoYrsAgo);
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.FirstPeriodHeader.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodHeader.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodHeader.verifyText("TTM");
		VIPFinancialsPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_080");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_082_&_083");
		VIPFinancialsPage.contents.SelectIndicatorDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndPreTaxROICMMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndEBITMarginMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndEBITDAMarginMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndCOGSRevenueMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndSGARevenueMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndOtherExpRevenueMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndDARevenueMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndCapitlEfficiencyMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndWorkingCapitalMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndNetPPERevenueMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndGWIntanRevMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndNetOtherAssRevMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndEBITMarginMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("EBIT MARGIN");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + EBITMarginKPIP1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndEBITDAMarginMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("EBITDA MARGIN");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndCOGSRevenueMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("COGS / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + COGSRevenueKPIP1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndSGARevenueMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("SG&A / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + SGARevenueKPIP1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndOtherExpRevenueMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("OTHER EXPENSES / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndDARevenueMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("D&A / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndCapitlEfficiencyMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("CAPITAL EFFICIENCY");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndWorkingCapitalMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndNetPPERevenueMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("NET PPE / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + NetPPEKPIP1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndGWIntanRevMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("GOODWILL & INTANGIBLES / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndNetOtherAssRevMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("NET OTHER ASSETS / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndPreTaxROICMMenu.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("PRE-TAX RETURN ON INVESTED CAPITAL");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_082_&_083");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_084_1");
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BenchmarkButton.verifyText("Accenture Proprietary EVT Benchmarks");
		VIPFinancialsPage.contents.BenchmarkButton.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("This is EVT team's database which includes FTE and Cost benchmarks per SG&A function (Finance, HR, Procurement etc.)");
		WebControl.takeScreenshot("Q2A_Reg_Auto_084_1");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_084_2");
		VIPFinancialsPage.contents.BenchmarkLink.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_084_2");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_085");
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndEBITMarginMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndEBITDAMarginMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndDARevenueMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndCOGSRevenueMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndSGARevenueMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndOtherExpRevenueMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_085");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_086");
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndCapitlEfficiencyMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndWorkingCapitalMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndNetPPERevenueMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndGWIntanRevMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndNetOtherAssRevMenu.click();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_086");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		//VIPFinancialsPage.contents.BestandRankCheckbox.click();
		//--Test Data Creation Part--
		//ROIC KPI
		String ROICKPI2_1 = VIPFinancialsPage.contents.ROICKPI2.getText();
		String ROICKPI2_2 = ROICKPI2_1.replace("%", "");
		Double ROICKPI2_3 = Double.parseDouble(ROICKPI2_2);
		//ROIC Peer Median
		String ROICKPIP2_1 = VIPFinancialsPage.contents.ROICKPIP2.getText();
		String ROICKPIP2_2 = ROICKPIP2_1.replace("%", "");
		Double ROICKPIP2_3 = Double.parseDouble(ROICKPIP2_2);
		BigDecimal ROICKPI_KPIP_1 = new BigDecimal(ROICKPI2_3 - ROICKPIP2_3);
		BigDecimal ROICKPIP_KPI_1 = new BigDecimal(ROICKPIP2_3 - ROICKPI2_3);
		BigDecimal ROICKPI_KPIP_2 = ROICKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal ROICKPIP_KPI_2 = ROICKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//ROIC Best
		String ROICBest1 = VIPFinancialsPage.contents.ROICBest.getText();
		String ROICBest2 = ROICBest1.replace("%", "");
		Double ROICBest3 = Double.parseDouble(ROICBest2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.ROICBest.hover();
		String ROICBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String ROICBest1_2 = ROICBest1_1.replace(ROICBest1, "");
		String ROICBest1_3 = ROICBest1_2.replace(" : ", "");
		//ROIC Rank
		String ROICRank1 = VIPFinancialsPage.contents.ROICRank.getText();
		String[] ROICRank2 = ROICRank1.split("\\/");
		String ROICRank2_1 = ROICRank2[0];
		String ROICRank2_2 = ROICRank2[1];
		String ROICRank2_3 = ROICRank2_1.replace(" ", "");
		String ROICRank2_4 = ROICRank2_2.replace(" ", "");
		Double ROICRank3_1 = Double.parseDouble(ROICRank2_3);
		Double ROICRank3_2 = Double.parseDouble(ROICRank2_4);
		Double ROICRank3 = (ROICRank3_1/ROICRank3_2);
		//ROIC 2 year Change
		String ROIC2YrChange1 = VIPFinancialsPage.contents.ROIC2YrChange.getText();
		String ROIC2YrChange2 = ROIC2YrChange1.replace("pps", "");
		String ROIC2YrChange3 = ROIC2YrChange2.replace("+", "");
		String ROIC2YrChange4 = ROIC2YrChange3.replace("-", "");
		Double ROIC2YrChange5 = Double.parseDouble(ROIC2YrChange4);
		Double ROIC2YrChange6 = Double.parseDouble(ROIC2YrChange3);
		//ROICKPI2_3 + ROIC2YrChange5
		BigDecimal ROICKPI_2YrChange_1 = new BigDecimal(ROICKPI2_3 + ROIC2YrChange5);
		BigDecimal ROICKPIP_2YrChange_2 = ROICKPI_2YrChange_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//ROICKPI2_3 - ROIC2YrChange5
		BigDecimal ROICKPI_2YrChange_3 = new BigDecimal(ROICKPI2_3 - ROIC2YrChange5);
		BigDecimal ROICKPIP_2YrChange_4 = ROICKPI_2YrChange_3.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//EBITMargin KPI
		String EBITMarginKPI2_1 = VIPFinancialsPage.contents.EBITMarginKPI2.getText();
		String EBITMarginKPI2_2 = EBITMarginKPI2_1.replace("%", "");
		Double EBITMarginKPI2_3 = Double.parseDouble(EBITMarginKPI2_2);
		//EBITMargin Peer Median
		String EBITMarginKPIP2_1 = VIPFinancialsPage.contents.EBITMarginKPIP2.getText();
		String EBITMarginKPIP2_2 = EBITMarginKPIP2_1.replace("%", "");
		Double EBITMarginKPIP2_3 = Double.parseDouble(EBITMarginKPIP2_2);
		BigDecimal EBITMarginKPI_KPIP_1 = new BigDecimal(EBITMarginKPI2_3 - EBITMarginKPIP2_3);
		BigDecimal EBITMarginKPIP_KPI_1 = new BigDecimal(EBITMarginKPIP2_3 - EBITMarginKPI2_3);
		BigDecimal EBITMarginKPI_KPIP_2 = EBITMarginKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal EBITMarginKPIP_KPI_2 = EBITMarginKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//EBITMargin Best
		String EBITMarginBest1 = VIPFinancialsPage.contents.EBITMarginBest.getText();
		String EBITMarginBest2 = EBITMarginBest1.replace("%", "");
		Double EBITMarginBest3 = Double.parseDouble(EBITMarginBest2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.EBITMarginBest.hover();
		String EBITMarginBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String EBITMarginBest1_2 = EBITMarginBest1_1.replace(EBITMarginBest1, "");
		String EBITMarginBest1_3 = EBITMarginBest1_2.replace(" : ", "");
		//EBITMargin Rank
		String EBITMarginRank1 = VIPFinancialsPage.contents.EBITMarginRank.getText();
		String[] EBITMarginRank2 = EBITMarginRank1.split("\\/");
		String EBITMarginRank2_1 = EBITMarginRank2[0];
		String EBITMarginRank2_2 = EBITMarginRank2[1];
		String EBITMarginRank2_3 = EBITMarginRank2_1.replace(" ", "");
		String EBITMarginRank2_4 = EBITMarginRank2_2.replace(" ", "");
		Double EBITMarginRank3_1 = Double.parseDouble(EBITMarginRank2_3);
		Double EBITMarginRank3_2 = Double.parseDouble(EBITMarginRank2_4);
		Double EBITMarginRank3 = (EBITMarginRank3_1/EBITMarginRank3_2);
		//EBITMargin 2 year Change
		String EBITMargin2YrChange1 = VIPFinancialsPage.contents.EBITMargin2YrChange.getText();
		String EBITMargin2YrChange2 = EBITMargin2YrChange1.replace("pps", "");
		String EBITMargin2YrChange3 = EBITMargin2YrChange2.replace("+", "");
		String EBITMargin2YrChange4 = EBITMargin2YrChange3.replace("-", "");
		Double EBITMargin2YrChange5 = Double.parseDouble(EBITMargin2YrChange4);
		Double EBITMargin2YrChange6 = Double.parseDouble(EBITMargin2YrChange3);
		//EBITMarginKPI2_3 + EBITMargin2YrChange5
		BigDecimal EBITMarginKPI_2YrChange_1 = new BigDecimal(EBITMarginKPI2_3 + EBITMargin2YrChange5);
		BigDecimal EBITMarginKPIP_2YrChange_2 = EBITMarginKPI_2YrChange_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//EBITMarginKPI2_3 - EBITMargin2YrChange5
		BigDecimal EBITMarginKPI_2YrChange_3 = new BigDecimal(EBITMarginKPI2_3 - EBITMargin2YrChange5);
		BigDecimal EBITMarginKPIP_2YrChange_4 = EBITMarginKPI_2YrChange_3.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//CapitalEfficiency KPI
		String CapitalEfficiencyKPI2_1 = VIPFinancialsPage.contents.CapitalEfficiencyKPI2.getText();
		String CapitalEfficiencyKPI2_2 = CapitalEfficiencyKPI2_1.replace("%", "");
		Double CapitalEfficiencyKPI2_3 = Double.parseDouble(CapitalEfficiencyKPI2_2);
		//CapitalEfficiency Peer Median
		String CapitalEfficiencyKPIP2_1 = VIPFinancialsPage.contents.CapitalEfficiencyKPIP2.getText();
		String CapitalEfficiencyKPIP2_2 = CapitalEfficiencyKPIP2_1.replace("%", "");
		Double CapitalEfficiencyKPIP2_3 = Double.parseDouble(CapitalEfficiencyKPIP2_2);
		BigDecimal CapitalEfficiencyKPI_KPIP_1 = new BigDecimal(CapitalEfficiencyKPI2_3 - CapitalEfficiencyKPIP2_3);
		BigDecimal CapitalEfficiencyKPIP_KPI_1 = new BigDecimal(CapitalEfficiencyKPIP2_3 - CapitalEfficiencyKPI2_3);
		BigDecimal CapitalEfficiencyKPI_KPIP_2 = CapitalEfficiencyKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal CapitalEfficiencyKPIP_KPI_2 = CapitalEfficiencyKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//CapitalEfficiency Best
		String CapitalEfficiencyBest1 = VIPFinancialsPage.contents.CapitalEfficiencyBest.getText();
		String CapitalEfficiencyBest2 = CapitalEfficiencyBest1.replace("%", "");
		Double CapitalEfficiencyBest3 = Double.parseDouble(CapitalEfficiencyBest2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.CapitalEfficiencyBest.hover();
		String CapitalEfficiencyBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String CapitalEfficiencyBest1_2 = CapitalEfficiencyBest1_1.replace(CapitalEfficiencyBest1, "");
		String CapitalEfficiencyBest1_3 = CapitalEfficiencyBest1_2.replace(" : ", "");
		//CapitalEfficiency Rank
		String CapitalEfficiencyRank1 = VIPFinancialsPage.contents.CapitalEfficiencyRank.getText();
		String[] CapitalEfficiencyRank2 = CapitalEfficiencyRank1.split("\\/");
		String CapitalEfficiencyRank2_1 = CapitalEfficiencyRank2[0];
		String CapitalEfficiencyRank2_2 = CapitalEfficiencyRank2[1];
		String CapitalEfficiencyRank2_3 = CapitalEfficiencyRank2_1.replace(" ", "");
		String CapitalEfficiencyRank2_4 = CapitalEfficiencyRank2_2.replace(" ", "");
		Double CapitalEfficiencyRank3_1 = Double.parseDouble(CapitalEfficiencyRank2_3);
		Double CapitalEfficiencyRank3_2 = Double.parseDouble(CapitalEfficiencyRank2_4);
		Double CapitalEfficiencyRank3 = (CapitalEfficiencyRank3_1/CapitalEfficiencyRank3_2);
		//CapitalEfficiency 2 year Change
		String CapitalEfficiency2YrChange1 = VIPFinancialsPage.contents.CapitalEfficiency2YrChange.getText();
		String CapitalEfficiency2YrChange2 = CapitalEfficiency2YrChange1.replace("pps", "");
		String CapitalEfficiency2YrChange3 = CapitalEfficiency2YrChange2.replace("+", "");
		String CapitalEfficiency2YrChange4 = CapitalEfficiency2YrChange3.replace("-", "");
		Double CapitalEfficiency2YrChange5 = Double.parseDouble(CapitalEfficiency2YrChange4);
		Double CapitalEfficiency2YrChange6 = Double.parseDouble(CapitalEfficiency2YrChange3);
		//CapitalEfficiencyKPI2_3 + CapitalEfficiency2YrChange5
		BigDecimal CapitalEfficiencyKPI_2YrChange_1 = new BigDecimal(CapitalEfficiencyKPI2_3 + CapitalEfficiency2YrChange5);
		BigDecimal CapitalEfficiencyKPIP_2YrChange_2 = CapitalEfficiencyKPI_2YrChange_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//CapitalEfficiencyKPI2_3 - CapitalEfficiency2YrChange5
		BigDecimal CapitalEfficiencyKPI_2YrChange_3 = new BigDecimal(CapitalEfficiencyKPI2_3 - CapitalEfficiency2YrChange5);
		BigDecimal CapitalEfficiencyKPIP_2YrChange_4 = CapitalEfficiencyKPI_2YrChange_3.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//COGS KPI
		String COGSKPI2_1 = VIPFinancialsPage.contents.COGSKPI2.getText();
		String COGSKPI2_2 = COGSKPI2_1.replace("%", "");
		Double COGSKPI2_3 = Double.parseDouble(COGSKPI2_2);
		//COGS Peer Median
		String COGSKPIP2_1 = VIPFinancialsPage.contents.COGSKPIP2.getText();
		String COGSKPIP2_2 = COGSKPIP2_1.replace("%", "");
		Double COGSKPIP2_3 = Double.parseDouble(COGSKPIP2_2);
		BigDecimal COGSKPI_KPIP_1 = new BigDecimal(COGSKPI2_3 - COGSKPIP2_3);
		BigDecimal COGSKPIP_KPI_1 = new BigDecimal(COGSKPIP2_3 - COGSKPI2_3);
		BigDecimal COGSKPI_KPIP_2 = COGSKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal COGSKPIP_KPI_2 = COGSKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//COGS Best
		String COGSBest1 = VIPFinancialsPage.contents.COGSBest.getText();
		String COGSBest2 = COGSBest1.replace("%", "");
		Double COGSBest3 = Double.parseDouble(COGSBest2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.COGSBest.hover();
		String COGSBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String COGSBest1_2 = COGSBest1_1.replace(COGSBest1, "");
		String COGSBest1_3 = COGSBest1_2.replace(" : ", "");
		//COGS Rank
		String COGSRank1 = VIPFinancialsPage.contents.COGSRank.getText();
		String[] COGSRank2 = COGSRank1.split("\\/");
		String COGSRank2_1 = COGSRank2[0];
		String COGSRank2_2 = COGSRank2[1];
		String COGSRank2_3 = COGSRank2_1.replace(" ", "");
		String COGSRank2_4 = COGSRank2_2.replace(" ", "");
		Double COGSRank3_1 = Double.parseDouble(COGSRank2_3);
		Double COGSRank3_2 = Double.parseDouble(COGSRank2_4);
		Double COGSRank3 = (COGSRank3_1/COGSRank3_2);
		//COGS 2 year Change
		String COGS2YrChange1 = VIPFinancialsPage.contents.COGS2YrChange.getText();
		String COGS2YrChange2 = COGS2YrChange1.replace("pps", "");
		String COGS2YrChange3 = COGS2YrChange2.replace("+", "");
		String COGS2YrChange4 = COGS2YrChange3.replace("-", "");
		Double COGS2YrChange5 = Double.parseDouble(COGS2YrChange4);
		Double COGS2YrChange6 = Double.parseDouble(COGS2YrChange3);
		//COGSKPI2_3 + COGS2YrChange5
		BigDecimal COGSKPI_2YrChange_1 = new BigDecimal(COGSKPI2_3 + COGS2YrChange5);
		BigDecimal COGSKPIP_2YrChange_2 = COGSKPI_2YrChange_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//COGSKPI2_3 - COGS2YrChange5
		BigDecimal COGSKPI_2YrChange_3 = new BigDecimal(COGSKPI2_3 - COGS2YrChange5);
		BigDecimal COGSKPIP_2YrChange_4 = COGSKPI_2YrChange_3.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//SGA KPI
		String SGAKPI2_1 = VIPFinancialsPage.contents.SGAKPI2.getText();
		String SGAKPI2_2 = SGAKPI2_1.replace("%", "");
		Double SGAKPI2_3 = Double.parseDouble(SGAKPI2_2);
		//SGA Peer Median
		String SGAKPIP2_1 = VIPFinancialsPage.contents.SGAKPIP2.getText();
		String SGAKPIP2_2 = SGAKPIP2_1.replace("%", "");
		Double SGAKPIP2_3 = Double.parseDouble(SGAKPIP2_2);
		BigDecimal SGAKPI_KPIP_1 = new BigDecimal(SGAKPI2_3 - SGAKPIP2_3);
		BigDecimal SGAKPIP_KPI_1 = new BigDecimal(SGAKPIP2_3 - SGAKPI2_3);
		BigDecimal SGAKPI_KPIP_2 = SGAKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal SGAKPIP_KPI_2 = SGAKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//SGA Best
		String SGABest1 = VIPFinancialsPage.contents.SGABest.getText();
		String SGABest2 = SGABest1.replace("%", "");
		Double SGABest3 = Double.parseDouble(SGABest2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SGABest.hover();
		String SGABest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String SGABest1_2 = SGABest1_1.replace(SGABest1, "");
		String SGABest1_3 = SGABest1_2.replace(" : ", "");
		//SGA Rank
		String SGARank1 = VIPFinancialsPage.contents.SGARank.getText();
		String[] SGARank2 = SGARank1.split("\\/");
		String SGARank2_1 = SGARank2[0];
		String SGARank2_2 = SGARank2[1];
		String SGARank2_3 = SGARank2_1.replace(" ", "");
		String SGARank2_4 = SGARank2_2.replace(" ", "");
		Double SGARank3_1 = Double.parseDouble(SGARank2_3);
		Double SGARank3_2 = Double.parseDouble(SGARank2_4);
		Double SGARank3 = (SGARank3_1/SGARank3_2);
		//SGA 2 year Change
		String SGA2YrChange1 = VIPFinancialsPage.contents.SGA2YrChange.getText();
		String SGA2YrChange2 = SGA2YrChange1.replace("pps", "");
		String SGA2YrChange3 = SGA2YrChange2.replace("+", "");
		String SGA2YrChange4 = SGA2YrChange3.replace("-", "");
		Double SGA2YrChange5 = Double.parseDouble(SGA2YrChange4);
		Double SGA2YrChange6 = Double.parseDouble(SGA2YrChange3);
		//SGAKPI2_3 + SGA2YrChange5
		BigDecimal SGAKPI_2YrChange_1 = new BigDecimal(SGAKPI2_3 + SGA2YrChange5);
		BigDecimal SGAKPIP_2YrChange_2 = SGAKPI_2YrChange_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//SGAKPI2_3 - SGA2YrChange5
		BigDecimal SGAKPI_2YrChange_3 = new BigDecimal(SGAKPI2_3 - SGA2YrChange5);
		BigDecimal SGAKPIP_2YrChange_4 = SGAKPI_2YrChange_3.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//OpeWorCap KPI
		String OpeWorCapKPI2_1 = VIPFinancialsPage.contents.OpeWorCapKPI2.getText();
		String OpeWorCapKPI2_2 = OpeWorCapKPI2_1.replace("%", "");
		Double OpeWorCapKPI2_3 = Double.parseDouble(OpeWorCapKPI2_2);
		//OpeWorCap Peer Median
		String OpeWorCapKPIP2_1 = VIPFinancialsPage.contents.OpeWorCapKPIP2.getText();
		String OpeWorCapKPIP2_2 = OpeWorCapKPIP2_1.replace("%", "");
		Double OpeWorCapKPIP2_3 = Double.parseDouble(OpeWorCapKPIP2_2);
		BigDecimal OpeWorCapKPI_KPIP_1 = new BigDecimal(OpeWorCapKPI2_3 - OpeWorCapKPIP2_3);
		BigDecimal OpeWorCapKPIP_KPI_1 = new BigDecimal(OpeWorCapKPIP2_3 - OpeWorCapKPI2_3);
		BigDecimal OpeWorCapKPI_KPIP_2 = OpeWorCapKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal OpeWorCapKPIP_KPI_2 = OpeWorCapKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//OpeWorCap Best
		String OpeWorCapBest1 = VIPFinancialsPage.contents.OpeWorCapBest.getText();
		String OpeWorCapBest2 = OpeWorCapBest1.replace("%", "");
		Double OpeWorCapBest3 = Double.parseDouble(OpeWorCapBest2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OpeWorCapBest.hover();
		String OpeWorCapBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String OpeWorCapBest1_2 = OpeWorCapBest1_1.replace(OpeWorCapBest1, "");
		String OpeWorCapBest1_3 = OpeWorCapBest1_2.replace(" : ", "");
		//OpeWorCap Rank
		String OpeWorCapRank1 = VIPFinancialsPage.contents.OpeWorCapRank.getText();
		String[] OpeWorCapRank2 = OpeWorCapRank1.split("\\/");
		String OpeWorCapRank2_1 = OpeWorCapRank2[0];
		String OpeWorCapRank2_2 = OpeWorCapRank2[1];
		String OpeWorCapRank2_3 = OpeWorCapRank2_1.replace(" ", "");
		String OpeWorCapRank2_4 = OpeWorCapRank2_2.replace(" ", "");
		Double OpeWorCapRank3_1 = Double.parseDouble(OpeWorCapRank2_3);
		Double OpeWorCapRank3_2 = Double.parseDouble(OpeWorCapRank2_4);
		Double OpeWorCapRank3 = (OpeWorCapRank3_1/OpeWorCapRank3_2);
		//OpeWorCap 2 year Change
		String OpeWorCap2YrChange1 = VIPFinancialsPage.contents.OpeWorCap2YrChange.getText();
		String OpeWorCap2YrChange2 = OpeWorCap2YrChange1.replace("pps", "");
		String OpeWorCap2YrChange3 = OpeWorCap2YrChange2.replace("+", "");
		String OpeWorCap2YrChange4 = OpeWorCap2YrChange3.replace("-", "");
		Double OpeWorCap2YrChange5 = Double.parseDouble(OpeWorCap2YrChange4);
		Double OpeWorCap2YrChange6 = Double.parseDouble(OpeWorCap2YrChange3);
		//OpeWorCapKPI2_3 + OpeWorCap2YrChange5
		BigDecimal OpeWorCapKPI_2YrChange_1 = new BigDecimal(OpeWorCapKPI2_3 + OpeWorCap2YrChange5);
		BigDecimal OpeWorCapKPIP_2YrChange_2 = OpeWorCapKPI_2YrChange_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//OpeWorCapKPI2_3 - OpeWorCap2YrChange5
		BigDecimal OpeWorCapKPI_2YrChange_3 = new BigDecimal(OpeWorCapKPI2_3 - OpeWorCap2YrChange5);
		BigDecimal OpeWorCapKPIP_2YrChange_4 = OpeWorCapKPI_2YrChange_3.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//NetPPE KPI
		String NetPPEKPI2_1 = VIPFinancialsPage.contents.NetPPEKPI2.getText();
		String NetPPEKPI2_2 = NetPPEKPI2_1.replace("%", "");
		Double NetPPEKPI2_3 = Double.parseDouble(NetPPEKPI2_2);
		//NetPPE Peer Median
		String NetPPEKPIP2_1 = VIPFinancialsPage.contents.NetPPEKPIP2.getText();
		String NetPPEKPIP2_2 = NetPPEKPIP2_1.replace("%", "");
		Double NetPPEKPIP2_3 = Double.parseDouble(NetPPEKPIP2_2);
		BigDecimal NetPPEKPI_KPIP_1 = new BigDecimal(NetPPEKPI2_3 - NetPPEKPIP2_3);
		BigDecimal NetPPEKPIP_KPI_1 = new BigDecimal(NetPPEKPIP2_3 - NetPPEKPI2_3);
		BigDecimal NetPPEKPI_KPIP_2 = NetPPEKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal NetPPEKPIP_KPI_2 = NetPPEKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//NetPPE Best
		String NetPPEBest1 = VIPFinancialsPage.contents.NetPPEBest.getText();
		String NetPPEBest2 = NetPPEBest1.replace("%", "");
		Double NetPPEBest3 = Double.parseDouble(NetPPEBest2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.NetPPEBest.hover();
		String NetPPEBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String NetPPEBest1_2 = NetPPEBest1_1.replace(NetPPEBest1, "");
		String NetPPEBest1_3 = NetPPEBest1_2.replace(" : ", "");
		//NetPPE Rank
		String NetPPERank1 = VIPFinancialsPage.contents.NetPPERank.getText();
		String[] NetPPERank2 = NetPPERank1.split("\\/");
		String NetPPERank2_1 = NetPPERank2[0];
		String NetPPERank2_2 = NetPPERank2[1];
		String NetPPERank2_3 = NetPPERank2_1.replace(" ", "");
		String NetPPERank2_4 = NetPPERank2_2.replace(" ", "");
		Double NetPPERank3_1 = Double.parseDouble(NetPPERank2_3);
		Double NetPPERank3_2 = Double.parseDouble(NetPPERank2_4);
		Double NetPPERank3 = (NetPPERank3_1/NetPPERank3_2);
		//NetPPE 2 year Change
		String NetPPE2YrChange1 = VIPFinancialsPage.contents.NetPPE2YrChange.getText();
		String NetPPE2YrChange2 = NetPPE2YrChange1.replace("pps", "");
		String NetPPE2YrChange3 = NetPPE2YrChange2.replace("+", "");
		String NetPPE2YrChange4 = NetPPE2YrChange3.replace("-", "");
		Double NetPPE2YrChange5 = Double.parseDouble(NetPPE2YrChange4);
		Double NetPPE2YrChange6 = Double.parseDouble(NetPPE2YrChange3);
		//NetPPEKPI2_3 + NetPPE2YrChange5
		BigDecimal NetPPEKPI_2YrChange_1 = new BigDecimal(NetPPEKPI2_3 + NetPPE2YrChange5);
		BigDecimal NetPPEKPIP_2YrChange_2 = NetPPEKPI_2YrChange_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//NetPPEKPI2_3 - NetPPE2YrChange5
		BigDecimal NetPPEKPI_2YrChange_3 = new BigDecimal(NetPPEKPI2_3 - NetPPE2YrChange5);
		BigDecimal NetPPEKPIP_2YrChange_4 = NetPPEKPI_2YrChange_3.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//GoodWillInt KPI
		String GoodWillIntKPI2_1 = VIPFinancialsPage.contents.GoodWillIntKPI2.getText();
		String GoodWillIntKPI2_2 = GoodWillIntKPI2_1.replace("%", "");
		Double GoodWillIntKPI2_3 = Double.parseDouble(GoodWillIntKPI2_2);
		//GoodWillInt Peer Median
		String GoodWillIntKPIP2_1 = VIPFinancialsPage.contents.GoodWillIntKPIP2.getText();
		String GoodWillIntKPIP2_2 = GoodWillIntKPIP2_1.replace("%", "");
		Double GoodWillIntKPIP2_3 = Double.parseDouble(GoodWillIntKPIP2_2);
		BigDecimal GoodWillIntKPI_KPIP_1 = new BigDecimal(GoodWillIntKPI2_3 - GoodWillIntKPIP2_3);
		BigDecimal GoodWillIntKPIP_KPI_1 = new BigDecimal(GoodWillIntKPIP2_3 - GoodWillIntKPI2_3);
		BigDecimal GoodWillIntKPI_KPIP_2 = GoodWillIntKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal GoodWillIntKPIP_KPI_2 = GoodWillIntKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//GoodWillInt Best
		String GoodWillIntBest1 = VIPFinancialsPage.contents.GoodWillIntBest.getText();
		String GoodWillIntBest2 = GoodWillIntBest1.replace("%", "");
		Double GoodWillIntBest3 = Double.parseDouble(GoodWillIntBest2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.GoodWillIntBest.hover();
		String GoodWillIntBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String GoodWillIntBest1_2 = GoodWillIntBest1_1.replace(GoodWillIntBest1, "");
		String GoodWillIntBest1_3 = GoodWillIntBest1_2.replace(" : ", "");
		//GoodWillInt Rank
		String GoodWillIntRank1 = VIPFinancialsPage.contents.GoodWillIntRank.getText();
		String[] GoodWillIntRank2 = GoodWillIntRank1.split("\\/");
		String GoodWillIntRank2_1 = GoodWillIntRank2[0];
		String GoodWillIntRank2_2 = GoodWillIntRank2[1];
		String GoodWillIntRank2_3 = GoodWillIntRank2_1.replace(" ", "");
		String GoodWillIntRank2_4 = GoodWillIntRank2_2.replace(" ", "");
		Double GoodWillIntRank3_1 = Double.parseDouble(GoodWillIntRank2_3);
		Double GoodWillIntRank3_2 = Double.parseDouble(GoodWillIntRank2_4);
		Double GoodWillIntRank3 = (GoodWillIntRank3_1/GoodWillIntRank3_2);
		//GoodWillInt 2 year Change
		String GoodWillInt2YrChange1 = VIPFinancialsPage.contents.GoodWillInt2YrChange.getText();
		String GoodWillInt2YrChange2 = GoodWillInt2YrChange1.replace("pps", "");
		String GoodWillInt2YrChange3 = GoodWillInt2YrChange2.replace("+", "");
		String GoodWillInt2YrChange4 = GoodWillInt2YrChange3.replace("-", "");
		Double GoodWillInt2YrChange5 = Double.parseDouble(GoodWillInt2YrChange4);
		Double GoodWillInt2YrChange6 = Double.parseDouble(GoodWillInt2YrChange3);
		//GoodWillIntKPI2_3 + GoodWillInt2YrChange5
		BigDecimal GoodWillIntKPI_2YrChange_1 = new BigDecimal(GoodWillIntKPI2_3 + GoodWillInt2YrChange5);
		BigDecimal GoodWillIntKPIP_2YrChange_2 = GoodWillIntKPI_2YrChange_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//GoodWillIntKPI2_3 - GoodWillInt2YrChange5
		BigDecimal GoodWillIntKPI_2YrChange_3 = new BigDecimal(GoodWillIntKPI2_3 - GoodWillInt2YrChange5);
		BigDecimal GoodWillIntKPIP_2YrChange_4 = GoodWillIntKPI_2YrChange_3.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.PreTaxROICMenu.click();
		
		//-------Validation Part-------
		//ROIC
		VIPFinancialsPage.contents.ROICBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (ROIC2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC decreased by " + ROIC2YrChange5 + " pps over the last 2 years from " + ROICKPIP_2YrChange_2 + "% in " + TwoYears + " to " + ROICKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (ROIC2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC increased by " + ROIC2YrChange5 + " pps over the last 2 years from " + ROICKPIP_2YrChange_4 + "% in " + TwoYears + " to " + ROICKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (ROICKPI2_3 > ROICKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s ROIC in TTM is higher than the peer median of " + ROICKPIP2_3 + "%" + " by " + ROICKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else if (ROICKPI2_3 < ROICKPIP2_3)
		{VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s ROIC in TTM is lower than the peer median of " + ROICKPIP2_3 + "%" + " by " + ROICKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s ROIC in TTM is " + ROICKPIP2_3 + "%" + ", same as the peer median");
		VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((ROICRank3 > 0) & (ROICRank3 <= 0.25)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s ROIC performance placed it in the top quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((ROICRank3 > 0.25) & (ROICRank3 <= 0.50)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s ROIC performance placed it in the 2nd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((ROICRank3 > 0.5) & (ROICRank3 <= 0.75)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s ROIC performance placed it in the 3rd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s ROIC performance placed it in the bottom quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(ROICBest1_3 + " (" + ROICBest3 + "%) " + "ranked the best in terms of ROIC in TTM");
		String ROICSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String ROICCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String ROICCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String ROICBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//EBITMargin
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (EBITMargin2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin decreased by " + EBITMargin2YrChange5 + " pps over the last 2 years from " + EBITMarginKPIP_2YrChange_2 + "% in " + TwoYears + " to " + EBITMarginKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (EBITMargin2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin increased by " + EBITMargin2YrChange5 + " pps over the last 2 years from " + EBITMarginKPIP_2YrChange_4 + "% in " + TwoYears + " to " + EBITMarginKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (EBITMarginKPI2_3 > EBITMarginKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s operating margin in TTM is higher than the peer median of " + EBITMarginKPIP2_3 + "%" + " by " + EBITMarginKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else if (EBITMarginKPI2_3 < EBITMarginKPIP2_3)
		{VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s operating margin in TTM is lower than the peer median of " + EBITMarginKPIP2_3 + "%" + " by " + EBITMarginKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s operating margin in TTM is " + EBITMarginKPIP2_3 + "%" + ", same as the peer median");
		VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((EBITMarginRank3 > 0) & (EBITMarginRank3 <= 0.25)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s operating margin performance placed it in the top quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((EBITMarginRank3 > 0.25) & (EBITMarginRank3 <= 0.5)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s operating margin performance placed it in the 2nd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((EBITMarginRank3 > 0.5) & (EBITMarginRank3 < 0.75)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s operating margin performance placed it in the 3rd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s operating margin performance placed it in the bottom quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(EBITMarginBest1_3 + " (" + EBITMarginBest3 + "%) " + "ranked the best in terms of operating margin in TTM");
		String EBITSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String EBITCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String EBITCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String EBITBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//CapitalEfficiency
		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (CapitalEfficiency2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency decreased by " + CapitalEfficiency2YrChange5 + " pps over the last 2 years from " + CapitalEfficiencyKPIP_2YrChange_2 + "% in " + TwoYears + " to " + CapitalEfficiencyKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (CapitalEfficiency2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency increased by " + CapitalEfficiency2YrChange5 + " pps over the last 2 years from " + CapitalEfficiencyKPIP_2YrChange_4 + "% in " + TwoYears + " to " + CapitalEfficiencyKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (CapitalEfficiencyKPI2_3 > CapitalEfficiencyKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is higher than the peer median of " + CapitalEfficiencyKPIP2_3 + " by " + CapitalEfficiencyKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else if (CapitalEfficiencyKPI2_3 < CapitalEfficiencyKPIP2_3)
		{VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is lower than the peer median of " + CapitalEfficiencyKPIP2_3 + " by " + CapitalEfficiencyKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is " + CapitalEfficiencyKPIP2_3  + ", same as the peer median");
		VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((CapitalEfficiencyRank3 > 0) & (CapitalEfficiencyRank3 <= 0.25)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Capital Efficiency performance placed it in the top quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((CapitalEfficiencyRank3 > 0.25) & (CapitalEfficiencyRank3 <= 0.5)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Capital Efficiency performance placed it in the 2nd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((CapitalEfficiencyRank3 > 0.5) & (CapitalEfficiencyRank3 <= 0.75)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Capital Efficiency performance placed it in the 3rd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Capital Efficiency performance placed it in the bottom quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(CapitalEfficiencyBest1_3 + " (" + CapitalEfficiencyBest3 + ") " + "ranked the best in terms of Capital Efficiency in TTM");
		String CESP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CECP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CECP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String CEBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//COGS
		VIPFinancialsPage.contents.COGSRevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (COGS2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue decreased by " + COGS2YrChange5 + " pps over the last 2 years from " + COGSKPIP_2YrChange_2 + "% in " + TwoYears + " to " + COGSKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (COGS2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue increased by " + COGS2YrChange5 + " pps over the last 2 years from " + COGSKPIP_2YrChange_4 + "% in " + TwoYears + " to " + COGSKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (COGSKPI2_3 > COGSKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s COGS/Revenue in TTM is higher than the peer median of " + COGSKPIP2_3 + "%" + " by " + COGSKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (COGSKPI2_3 < COGSKPIP2_3)
		{VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s COGS/Revenue in TTM is lower than the peer median of " + COGSKPIP2_3 + "%" + " by " + COGSKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s COGS/Revenue in TTM is " + COGSKPIP2_3 + "%" + ", same as the peer median");
		VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((COGSRank3 > 0) & (COGSRank3 <= 0.25)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s COGS/Revenue performance placed it in the top quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((COGSRank3 > 0.25) & (COGSRank3 <= 0.5)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s COGS/Revenue performance placed it in the 2nd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((COGSRank3 > 0.5) & (COGSRank3 <= 0.75)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s COGS/Revenue performance placed it in the 3rd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s COGS/Revenue performance placed it in the bottom quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(COGSBest1_3 + " (" + COGSBest3 + "%) " + "ranked the best in terms of COGS/Revenue in TTM");
		String COGSSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String COGSCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String COGSCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String COGSBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//SGA
		VIPFinancialsPage.contents.SGARevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (SGA2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue decreased by " + SGA2YrChange5 + " pps over the last 2 years from " + SGAKPIP_2YrChange_2 + "% in " + TwoYears + " to " + SGAKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (SGA2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue increased by " + SGA2YrChange5 + " pps over the last 2 years from " + SGAKPIP_2YrChange_4 + "% in " + TwoYears + " to " + SGAKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (SGAKPI2_3 > SGAKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s SG&A/Revenue in TTM is higher than the peer median of " + SGAKPIP2_3 + "%" + " by " + SGAKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (SGAKPI2_3 < SGAKPIP2_3)
		{VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s SG&A/Revenue in TTM is lower than the peer median of " + SGAKPIP2_3 + "%" + " by " + SGAKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s SG&A/Revenue in TTM is " + SGAKPIP2_3 + "%" + ", same as the peer median");
		VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((SGARank3 > 0) & (SGARank3 <= 0.25)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s SG&A/Revenue performance placed it in the top quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((SGARank3 > 0.25) & (SGARank3 <= 0.5)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s SG&A/Revenue performance placed it in the 2nd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((SGARank3 > 0.5) & (SGARank3 <= 0.75)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s SG&A/Revenue performance placed it in the 3rd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s SG&A/Revenue performance placed it in the bottom quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(SGABest1_3 + " (" + SGABest3 + "%) " + "ranked the best in terms of SG&A/Revenue in TTM");
		String SGASP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String SGACP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String SGACP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String SGABest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//OpeWorCap
		VIPFinancialsPage.contents.WorkingCapitalRevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (OpeWorCap2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue decreased by " + OpeWorCap2YrChange5 + " pps over the last 2 years from " + OpeWorCapKPIP_2YrChange_2 + "% in " + TwoYears + " to " + OpeWorCapKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (OpeWorCap2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue increased by " + OpeWorCap2YrChange5 + " pps over the last 2 years from " + OpeWorCapKPIP_2YrChange_4 + "% in " + TwoYears + " to " + OpeWorCapKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (OpeWorCapKPI2_3 > OpeWorCapKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is higher than the peer median of " + OpeWorCapKPIP2_3 + "%" + " by " + OpeWorCapKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (OpeWorCapKPI2_3 < OpeWorCapKPIP2_3)
		{VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is lower than the peer median of " + OpeWorCapKPIP2_3 + "%" + " by " + OpeWorCapKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is " + OpeWorCapKPIP2_3 + "%" + ", same as the peer median");
		VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
//		if ((OpeWorCapRank3 > 0) & (OpeWorCapRank3 < 5)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Working Capital/Revenue performance placed it in the top quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((OpeWorCapRank3 > 4) & (OpeWorCapRank3 < 9)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Working Capital/Revenue performance placed it in the 2nd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((OpeWorCapRank3 > 8) & (OpeWorCapRank3 < 13)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Working Capital/Revenue performance placed it in the 3rd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Working Capital/Revenue performance placed it in the bottom quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(OpeWorCapBest1_3 + " (" + OpeWorCapBest3 + "%) " + "ranked the best in terms of Working Capital/Revenue in TTM");
		String OWCSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String OWCCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String OWCBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//NetPPE
		VIPFinancialsPage.contents.NetPPERevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (NetPPE2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue decreased by " + NetPPE2YrChange5 + " pps over the last 2 years from " + NetPPEKPIP_2YrChange_2 + "% in " + TwoYears + " to " + NetPPEKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (NetPPE2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue increased by " + NetPPE2YrChange5 + " pps over the last 2 years from " + NetPPEKPIP_2YrChange_4 + "% in " + TwoYears + " to " + NetPPEKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (NetPPEKPI2_3 > NetPPEKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net PPE/Revenue in TTM is higher than the peer median of " + NetPPEKPIP2_3 + "%" + " by " + NetPPEKPIP_KPI_2.abs() + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (NetPPEKPI2_3 < NetPPEKPIP2_3)
		{VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net PPE/Revenue in TTM is lower than the peer median of " + NetPPEKPIP2_3 + "%" + " by " + NetPPEKPI_KPIP_2.abs() + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net PPE/Revenue in TTM is " + NetPPEKPIP2_3 + "%" + ", same as the peer median");
		VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((NetPPERank3 > 0) & (NetPPERank3 <= 0.25)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Net PPE/Revenue performance placed it in the top quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((NetPPERank3 > 0.25) & (NetPPERank3 <= 0.5)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Net PPE/Revenue performance placed it in the 2nd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((NetPPERank3 > 0.5) & (NetPPERank3 <= 0.75)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Net PPE/Revenue performance placed it in the 3rd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Net PPE/Revenue performance placed it in the bottom quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(NetPPEBest1_3 + " (" + NetPPEBest3 + "%) " + "ranked the best in terms of Net PPE/Revenue in TTM");
		String PPESP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String PPECP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String PPECP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String PPEBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//GoodWillInt
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (GoodWillInt2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue decreased by " + GoodWillInt2YrChange5 + " pps over the last 2 years from " + GoodWillIntKPIP_2YrChange_2 + "% in " + TwoYears + " to " + GoodWillIntKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (GoodWillInt2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue increased by " + GoodWillInt2YrChange5 + " pps over the last 2 years from " + GoodWillIntKPIP_2YrChange_4 + "% in " + TwoYears + " to " + GoodWillIntKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (GoodWillIntKPI2_3 > GoodWillIntKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Goodwill & Int./Revenue in TTM is higher than the peer median of " + GoodWillIntKPIP2_3 + "%" + " by " + GoodWillIntKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (GoodWillIntKPI2_3 < GoodWillIntKPIP2_3)
		{VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Goodwill & Int./Revenue in TTM is lower than the peer median of " + GoodWillIntKPIP2_3 + "%" + " by " + GoodWillIntKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Goodwill & Int./Revenue in TTM is " + GoodWillIntKPIP2_3 + "%" + ", same as the peer median");
		VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((GoodWillIntRank3 > 0) & (GoodWillIntRank3 <= 0.25)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Goodwill & Int./Revenue performance placed it in the top quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((GoodWillIntRank3 > 0.25) & (GoodWillIntRank3 <= 0.5)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Goodwill & Int./Revenue performance placed it in the 2nd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((GoodWillIntRank3 > 0.5) & (GoodWillIntRank3 <= 0.75)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Goodwill & Int./Revenue performance placed it in the 3rd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Goodwill & Int./Revenue performance placed it in the bottom quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(GoodWillIntBest1_3 + " (" + GoodWillIntBest3 + "%) " + "ranked the best in terms of Goodwill & Int./Revenue in TTM");
		String GWISP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String GWICP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String GWICP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String GWIBest = VIPFinancialsPage.contents.BestInClass.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088");
		
		if (VIPFinancialsPage.contents.FootNote.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Reg_Auto_089");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(true, 5);
		String FootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_089");
			
		ReportLog.setTestCase("Q2A_Reg_Auto_090");
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		String StandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CompetitivePosition2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String BestInClass = VIPFinancialsPage.contents.BestInClass.getText();
		String RightHandChartHeader = VIPFinancialsPage.contents.RightHandChartHeader.getText();
		String FootNote2 = VIPFinancialsPage.contents.FootNote.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CompetitivePosition2);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote2);
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText(RightHandChartHeader);
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CompetitivePosition2);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote2);
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText(RightHandChartHeader);
		WebControl.takeScreenshot("Q2A_Reg_Auto_090");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_091");
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
		VIPFinancialsPage.contents.PreTaxROICMenu.click();
		VIPFinancialsPage.contents.ROICBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(ROICSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(ROICCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(ROICCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(ROICBest);
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(EBITSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(EBITCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(EBITCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(EBITBest);
		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(CESP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CECP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CECP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(CEBest);
		VIPFinancialsPage.contents.COGSRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(COGSSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(COGSCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(COGSCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(COGSBest);
		VIPFinancialsPage.contents.SGARevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(SGASP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(SGACP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(SGACP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(SGABest);
		VIPFinancialsPage.contents.WorkingCapitalRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OWCSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OWCCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(OWCBest);
		VIPFinancialsPage.contents.NetPPERevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(PPESP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(PPECP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(PPECP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(PPEBest);
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(GWISP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(GWICP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(GWICP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(GWIBest);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_091");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Reg_Auto_089");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_089");
			
		ReportLog.setTestCase("Q2A_Reg_Auto_090");
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		String StandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CompetitivePosition2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String BestInClass = VIPFinancialsPage.contents.BestInClass.getText();
		String RightHandChartHeader = VIPFinancialsPage.contents.RightHandChartHeader.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CompetitivePosition2);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText(RightHandChartHeader);
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CompetitivePosition2);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText(RightHandChartHeader);
		WebControl.takeScreenshot("Q2A_Reg_Auto_090");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_091");
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
		VIPFinancialsPage.contents.PreTaxROICMenu.click();
		VIPFinancialsPage.contents.ROICBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(ROICSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(ROICCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(ROICCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(ROICBest);
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(EBITSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(EBITCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(EBITCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(EBITBest);
		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(CESP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CECP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CECP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(CEBest);
		VIPFinancialsPage.contents.COGSRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(COGSSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(COGSCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(COGSCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(COGSBest);
		VIPFinancialsPage.contents.SGARevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(SGASP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(SGACP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(SGACP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(SGABest);
		VIPFinancialsPage.contents.WorkingCapitalRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OWCSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OWCCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(OWCBest);
		VIPFinancialsPage.contents.NetPPERevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(PPESP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(PPECP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(PPECP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(PPEBest);
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(GWISP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(GWICP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(GWICP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(GWIBest);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_091");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
	}
	
	@Test(priority=10)
	public void Q2A_OperatingWorkingCapital () throws Exception {
		ReportLog.setTestName("Q2A - Operating Working Capital Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		int OneYrAgo = Q2A_09_PreTaxROIC.get1YearAgo();
		String OneYear = String.valueOf(OneYrAgo);
		int TwoYrsAgo = Q2A_09_PreTaxROIC.get2YearsAgo();
		String TwoYears = String.valueOf(TwoYrsAgo);
		
		ReportLog.setTestCase("Q2A_Reg_Auto_092");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.OpeWorCapDecMenu.click();
		VIPFinancialsPage.contents.LeftHandChartHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.LeftHandChartHeader.verifyText("OPERATING WORKING CAPITAL DECOMPOSITION");
		VIPFinancialsPage.contents.LeftHandChartNote.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.LeftHandChartNote.verifyText("Click on the KPI box to view peer comparison");
		VIPFinancialsPage.contents.RightHandChartHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		WebControl.takeScreenshot("Q2A_Reg_Auto_092");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_093");
		VIPFinancialsPage.contents.PeerComparisonToggle.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.PeerComparisonToggleLabel.verifyText("Detailed Peer Comparison");
		WebControl.takeScreenshot("Q2A_Reg_Auto_093");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_094");
		VIPFinancialsPage.contents.WorkCapRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.OpeCurAssRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CashRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.NetRecRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.InventoryRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.OtherCurAssRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.AccPayRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IncTaxPayRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.OtherCurLiaRevBox.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_094");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_095");
		VIPFinancialsPage.contents.OpeCurAssRevBox.hover();
		VIPFinancialsPage.contents.OpeCurAssRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("OPERATING CURRENT ASSETS / REVENUE");
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.hover();
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("NON-INTEREST BEARING LIABILITIES / REVENUE");
		VIPFinancialsPage.contents.CashRevBox.hover();
		VIPFinancialsPage.contents.CashRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("CASH / REVENUE");
		VIPFinancialsPage.contents.NetRecRevBox.hover();
		VIPFinancialsPage.contents.NetRecRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("NET RECEIVABLES / REVENUE");
		VIPFinancialsPage.contents.InventoryRevBox.hover();
		VIPFinancialsPage.contents.InventoryRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("INVENTORY / REVENUE");
		VIPFinancialsPage.contents.OtherCurAssRevBox.hover();
		VIPFinancialsPage.contents.OtherCurAssRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("OTHER CUR. ASSETS / REVENUE");
		VIPFinancialsPage.contents.AccPayRevBox.hover();
		VIPFinancialsPage.contents.AccPayRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("ACCOUNTS PAYABLE / REVENUE");
		VIPFinancialsPage.contents.IncTaxPayRevBox.hover();
		VIPFinancialsPage.contents.IncTaxPayRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("INCOME TAX PAYABLE / REVENUE");
		//VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OtherCurLiaRevBox.hover();
		VIPFinancialsPage.contents.OtherCurLiaRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("OTHER CURRENT LIABILITIES / REVENUE");
		VIPFinancialsPage.contents.WorkCapRevBox.hover();
		VIPFinancialsPage.contents.WorkCapRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		WebControl.takeScreenshot("Q2A_Reg_Auto_095");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_096");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.WorkCapReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.WorkCapReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.WCRTooltip);
		VIPFinancialsPage.contents.WorkCapReviIcon.click();
		VIPFinancialsPage.contents.CashReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.CashReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.CRTooltip);
		VIPFinancialsPage.contents.CashReviIcon.click();
		VIPFinancialsPage.contents.NetRecReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.NetRecReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.NRTooltip);
		VIPFinancialsPage.contents.NetRecReviIcon.click();
		VIPFinancialsPage.contents.InventoryReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.InventoryReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.IRTooltip);
		VIPFinancialsPage.contents.InventoryReviIcon.click();
		VIPFinancialsPage.contents.AccPayReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.AccPayReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.APRTooltip);
		VIPFinancialsPage.contents.AccPayReviIcon.click();
		VIPFinancialsPage.contents.IncTaxPayReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.IncTaxPayReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.ITPRTooltip);
		VIPFinancialsPage.contents.IncTaxPayReviIcon.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_096");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_097");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		//VIPFinancialsPage.contents.BestandRankCheckbox.click();
		//WorCapRev KPI
		String WorCapRevKPI2_1 = VIPFinancialsPage.contents.WorCapRevKPI2.getText();
		String WorCapRevKPI2_2 = WorCapRevKPI2_1.replace("%", "");
		Double WorCapRevKPI2_3 = Double.parseDouble(WorCapRevKPI2_2);
		//WorCapRev Peer Median
		String WorCapRevKPIP2_1 = VIPFinancialsPage.contents.WorCapRevKPIP2.getText();
		String WorCapRevKPIP2_2 = WorCapRevKPIP2_1.replace("%", "");
		Double WorCapRevKPIP2_3 = Double.parseDouble(WorCapRevKPIP2_2);
		//WorCapRev Best
		String WorCapRevBest1 = VIPFinancialsPage.contents.WorCapRevBest.getText();
		String WorCapRevBest2 = WorCapRevBest1.replace("%", "");
		Double WorCapRevBest3 = Double.parseDouble(WorCapRevBest2);
		VIPFinancialsPage.contents.WorCapRevBest.hover();
		String WorCapRevBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String WorCapRevBest1_2 = WorCapRevBest1_1.replace(WorCapRevBest1, "");
		String WorCapRevBest1_3 = WorCapRevBest1_2.replace(" : ", "");
		//WorCapRev Rank
		String WorCapRevRank1 = VIPFinancialsPage.contents.WorCapRevRank.getText();
		String[] WorCapRevRank2 = WorCapRevRank1.split("\\/");
		String WorCapRevRank2_1 = WorCapRevRank2[0];
		String WorCapRevRank2_2 = WorCapRevRank2[1];
		String WorCapRevRank2_3 = WorCapRevRank2_1.replace(" ", "");
		String WorCapRevRank2_4 = WorCapRevRank2_2.replace(" ", "");
		Double WorCapRevRank3_1 = Double.parseDouble(WorCapRevRank2_3);
		Double WorCapRevRank3_2 = Double.parseDouble(WorCapRevRank2_4);
		Double WorCapRevRank3 = (WorCapRevRank3_1/WorCapRevRank3_2);
		//WorCapRev 2 year Change
		String WorCapRev2YrChange1 = VIPFinancialsPage.contents.WorCapRev2YrChange.getText();
		String WorCapRev2YrChange2 = WorCapRev2YrChange1.replace("pps", "");
		String WorCapRev2YrChange3 = WorCapRev2YrChange2.replace("+", "");
		String WorCapRev2YrChange4 = WorCapRev2YrChange3.replace("-", "");
		Double WorCapRev2YrChange5 = Double.parseDouble(WorCapRev2YrChange4);
		Double WorCapRev2YrChange6 = Double.parseDouble(WorCapRev2YrChange3);
		//WorCapRev BigDecimal
		BigDecimal WorCapRevKPI_KPIP_1 = new BigDecimal(WorCapRevKPI2_3 - WorCapRevKPIP2_3);
		BigDecimal WorCapRevKPIP_KPI_1 = new BigDecimal(WorCapRevKPIP2_3 - WorCapRevKPI2_3);
		BigDecimal WorCapRevKPI_KPIP_2 = WorCapRevKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal WorCapRevKPIP_KPI_2 = WorCapRevKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal WorCapRevKPI_2YrCM_1 = new BigDecimal(WorCapRevKPI2_3 - WorCapRev2YrChange5);
		BigDecimal WorCapRevKPI_2YrCP_1 = new BigDecimal(WorCapRevKPI2_3 + WorCapRev2YrChange5);
		BigDecimal WorCapRevKPI_2YrCM_2 = WorCapRevKPI_2YrCM_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal WorCapRevKPI_2YrCP_2 = WorCapRevKPI_2YrCP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//NetRecRev KPI
		String NetRecRevKPI2_1 = VIPFinancialsPage.contents.NetRecRevKPI2.getText();
		String NetRecRevKPI2_2 = NetRecRevKPI2_1.replace("%", "");
		Double NetRecRevKPI2_3 = Double.parseDouble(NetRecRevKPI2_2);
		//NetRecRev Peer Median
		String NetRecRevKPIP2_1 = VIPFinancialsPage.contents.NetRecRevKPIP2.getText();
		String NetRecRevKPIP2_2 = NetRecRevKPIP2_1.replace("%", "");
		Double NetRecRevKPIP2_3 = Double.parseDouble(NetRecRevKPIP2_2);
		//NetRecRev Best
		String NetRecRevBest1 = VIPFinancialsPage.contents.NetRecRevBest.getText();
		String NetRecRevBest2 = NetRecRevBest1.replace("%", "");
		Double NetRecRevBest3 = Double.parseDouble(NetRecRevBest2);
		VIPFinancialsPage.contents.NetRecRevBest.hover();
		String NetRecRevBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String NetRecRevBest1_2 = NetRecRevBest1_1.replace(NetRecRevBest1, "");
		String NetRecRevBest1_3 = NetRecRevBest1_2.replace(" : ", "");
		//NetRecRev Rank
		String NetRecRevRank1 = VIPFinancialsPage.contents.NetRecRevRank.getText();
		String[] NetRecRevRank2 = NetRecRevRank1.split("\\/");
		String NetRecRevRank2_1 = NetRecRevRank2[0];
		String NetRecRevRank2_2 = NetRecRevRank2[1];
		String NetRecRevRank2_3 = NetRecRevRank2_1.replace(" ", "");
		String NetRecRevRank2_4 = NetRecRevRank2_2.replace(" ", "");
		Double NetRecRevRank3_1 = Double.parseDouble(NetRecRevRank2_3);
		Double NetRecRevRank3_2 = Double.parseDouble(NetRecRevRank2_4);
		Double NetRecRevRank3 = (NetRecRevRank3_1/NetRecRevRank3_2);
		//NetRecRev 2 year Change
		String NetRecRev2YrChange1 = VIPFinancialsPage.contents.NetRecRev2YrChange.getText();
		String NetRecRev2YrChange2 = NetRecRev2YrChange1.replace("pps", "");
		String NetRecRev2YrChange3 = NetRecRev2YrChange2.replace("+", "");
		String NetRecRev2YrChange4 = NetRecRev2YrChange3.replace("-", "");
		Double NetRecRev2YrChange5 = Double.parseDouble(NetRecRev2YrChange4);
		Double NetRecRev2YrChange6 = Double.parseDouble(NetRecRev2YrChange3);
		//NetRecRev BigDecimal
		BigDecimal NetRecRevKPI_KPIP_1 = new BigDecimal(NetRecRevKPI2_3 - NetRecRevKPIP2_3);
		BigDecimal NetRecRevKPIP_KPI_1 = new BigDecimal(NetRecRevKPIP2_3 - NetRecRevKPI2_3);
		BigDecimal NetRecRevKPI_KPIP_2 = NetRecRevKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal NetRecRevKPIP_KPI_2 = NetRecRevKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal NetRecRevKPI_2YrCM_1 = new BigDecimal(NetRecRevKPI2_3 - NetRecRev2YrChange5);
		BigDecimal NetRecRevKPI_2YrCP_1 = new BigDecimal(NetRecRevKPI2_3 + NetRecRev2YrChange5);
		BigDecimal NetRecRevKPI_2YrCM_2 = NetRecRevKPI_2YrCM_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal NetRecRevKPI_2YrCP_2 = NetRecRevKPI_2YrCP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//InvRev KPI
		String InvRevKPI2_1 = VIPFinancialsPage.contents.InvRevKPI2.getText();
		String InvRevKPI2_2 = InvRevKPI2_1.replace("%", "");
		Double InvRevKPI2_3 = Double.parseDouble(InvRevKPI2_2);
		//InvRev Peer Median
		String InvRevKPIP2_1 = VIPFinancialsPage.contents.InvRevKPIP2.getText();
		String InvRevKPIP2_2 = InvRevKPIP2_1.replace("%", "");
		Double InvRevKPIP2_3 = Double.parseDouble(InvRevKPIP2_2);
		//InvRev Best
		String InvRevBest1 = VIPFinancialsPage.contents.InvRevBest.getText();
		String InvRevBest2 = InvRevBest1.replace("%", "");
		Double InvRevBest3 = Double.parseDouble(InvRevBest2);
		VIPFinancialsPage.contents.InvRevBest.hover();
		String InvRevBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String InvRevBest1_2 = InvRevBest1_1.replace(InvRevBest1, "");
		String InvRevBest1_3 = InvRevBest1_2.replace(" : ", "");
		//InvRev Rank
//		String InvRevRank1 = VIPFinancialsPage.contents.InvRevRank.getText();
//		String[] InvRevRank2 = InvRevRank1.split("\\/");
//		String InvRevRank2_1 = InvRevRank2[0];
//		String InvRevRank2_2 = InvRevRank2[1];
//		String InvRevRank2_3 = InvRevRank2_1.replace(" ", "");
//		String InvRevRank2_4 = InvRevRank2_2.replace(" ", "");
//		Double InvRevRank3_1 = Double.parseDouble(InvRevRank2_3);
//		Double InvRevRank3_2 = Double.parseDouble(InvRevRank2_4);
//		Double InvRevRank3 = (InvRevRank3_1/InvRevRank3_2);
		//InvRev 2 year Change
		String InvRev2YrChange1 = VIPFinancialsPage.contents.InvRev2YrChange.getText();
		String InvRev2YrChange2 = InvRev2YrChange1.replace("pps", "");
		String InvRev2YrChange3 = InvRev2YrChange2.replace("+", "");
		String InvRev2YrChange4 = InvRev2YrChange3.replace("-", "");
		Double InvRev2YrChange5 = Double.parseDouble(InvRev2YrChange4);
		Double InvRev2YrChange6 = Double.parseDouble(InvRev2YrChange3);
		//InvRev BigDecimal
		BigDecimal InvRevKPI_KPIP_1 = new BigDecimal(InvRevKPI2_3 - InvRevKPIP2_3);
		BigDecimal InvRevKPIP_KPI_1 = new BigDecimal(InvRevKPIP2_3 - InvRevKPI2_3);
		BigDecimal InvRevKPI_KPIP_2 = InvRevKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal InvRevKPIP_KPI_2 = InvRevKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal InvRevKPI_2YrCM_1 = new BigDecimal(InvRevKPI2_3 - InvRev2YrChange5);
		BigDecimal InvRevKPI_2YrCP_1 = new BigDecimal(InvRevKPI2_3 + InvRev2YrChange5);
		BigDecimal InvRevKPI_2YrCM_2 = InvRevKPI_2YrCM_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal InvRevKPI_2YrCP_2 = InvRevKPI_2YrCP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//AccPayRev KPI
		String AccPayRevKPI2_1 = VIPFinancialsPage.contents.AccPayRevKPI2.getText();
		String AccPayRevKPI2_2 = AccPayRevKPI2_1.replace("%", "");
		Double AccPayRevKPI2_3 = Double.parseDouble(AccPayRevKPI2_2);
		//AccPayRev Peer Median
		String AccPayRevKPIP2_1 = VIPFinancialsPage.contents.AccPayRevKPIP2.getText();
		String AccPayRevKPIP2_2 = AccPayRevKPIP2_1.replace("%", "");
		Double AccPayRevKPIP2_3 = Double.parseDouble(AccPayRevKPIP2_2);
		//AccPayRev Best
		String AccPayRevBest1 = VIPFinancialsPage.contents.AccPayRevBest.getText();
		String AccPayRevBest2 = AccPayRevBest1.replace("%", "");
		Double AccPayRevBest3 = Double.parseDouble(AccPayRevBest2);
		VIPFinancialsPage.contents.AccPayRevBest.hover();
		String AccPayRevBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String AccPayRevBest1_2 = AccPayRevBest1_1.replace(AccPayRevBest1, "");
		String AccPayRevBest1_3 = AccPayRevBest1_2.replace(" : ", "");
		//AccPayRev Rank
		String AccPayRevRank1 = VIPFinancialsPage.contents.AccPayRevRank.getText();
		String[] AccPayRevRank2 = AccPayRevRank1.split("\\/");
		String AccPayRevRank2_1 = AccPayRevRank2[0];
		String AccPayRevRank2_2 = AccPayRevRank2[1];
		String AccPayRevRank2_3 = AccPayRevRank2_1.replace(" ", "");
		String AccPayRevRank2_4 = AccPayRevRank2_2.replace(" ", "");
		Double AccPayRevRank3_1 = Double.parseDouble(AccPayRevRank2_3);
		Double AccPayRevRank3_2 = Double.parseDouble(AccPayRevRank2_4);
		Double AccPayRevRank3 = (AccPayRevRank3_1/AccPayRevRank3_2);
		//AccPayRev 2 year Change
		String AccPayRev2YrChange1 = VIPFinancialsPage.contents.AccPayRev2YrChange.getText();
		String AccPayRev2YrChange2 = AccPayRev2YrChange1.replace("pps", "");
		String AccPayRev2YrChange3 = AccPayRev2YrChange2.replace("+", "");
		String AccPayRev2YrChange4 = AccPayRev2YrChange3.replace("-", "");
		Double AccPayRev2YrChange5 = Double.parseDouble(AccPayRev2YrChange4);
		Double AccPayRev2YrChange6 = Double.parseDouble(AccPayRev2YrChange3);
		//AccPayRev BigDecimal
		BigDecimal AccPayRevKPI_KPIP_1 = new BigDecimal(AccPayRevKPI2_3 - AccPayRevKPIP2_3);
		BigDecimal AccPayRevKPIP_KPI_1 = new BigDecimal(AccPayRevKPIP2_3 - AccPayRevKPI2_3);
		BigDecimal AccPayRevKPI_KPIP_2 = AccPayRevKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal AccPayRevKPIP_KPI_2 = AccPayRevKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal AccPayRevKPI_2YrCM_1 = new BigDecimal(AccPayRevKPI2_3 - AccPayRev2YrChange5);
		BigDecimal AccPayRevKPI_2YrCP_1 = new BigDecimal(AccPayRevKPI2_3 + AccPayRev2YrChange5);
		BigDecimal AccPayRevKPI_2YrCM_2 = AccPayRevKPI_2YrCM_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal AccPayRevKPI_2YrCP_2 = AccPayRevKPI_2YrCP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//WorCapRev
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(2000);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.OpeWorCapDecMenu.click();
		if (WorCapRevKPI2_3 > WorCapRevKPIP2_3) {
		VIPFinancialsPage.contents.WorkCapRevRedIcon.verifyDisplayed(true, 5);}
		else if (WorCapRevKPI2_3 < WorCapRevKPIP2_3) {
		VIPFinancialsPage.contents.WorkCapRevGreenIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.WorkCapRevYellowIcon.verifyDisplayed(true, 5);}
		//OpeCurAssRev, NonIntBearLiabRev, CashRev
		VIPFinancialsPage.contents.OpeCurAssRevGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.NonIntBearLiabRevGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CashRevGaugeIcon.verifyDisplayed(true, 5);
		//NetRecRev
		if (NetRecRevKPI2_3 > NetRecRevKPIP2_3) {
		VIPFinancialsPage.contents.NetRecRevRedIcon.verifyDisplayed(true, 5);}
		else if (NetRecRevKPI2_3 < NetRecRevKPIP2_3) {
		VIPFinancialsPage.contents.NetRecRevGreenIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.NetRecRevYellowIcon.verifyDisplayed(true, 5);}
		//InvRev
		if (InvRevKPI2_3 > InvRevKPIP2_3) {
		VIPFinancialsPage.contents.InvRevRedIcon.verifyDisplayed(true, 5);}
		else if (InvRevKPI2_3 < InvRevKPIP2_3) {
		VIPFinancialsPage.contents.InvRevGreenIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.InvRevYellowIcon.verifyDisplayed(true, 5);}
		//OtherCurAssRev
		VIPFinancialsPage.contents.OtherCurAssRevGaugeIcon.verifyDisplayed(true, 5);
		//AccPayRev
		if (AccPayRevKPI2_3 > AccPayRevKPIP2_3) {
		VIPFinancialsPage.contents.AccPayRevGreenIcon.verifyDisplayed(true, 5);}
		else if (AccPayRevKPI2_3 < AccPayRevKPIP2_3) {
		VIPFinancialsPage.contents.AccPayRevRedIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.AccPayRevYellowIcon.verifyDisplayed(true, 5);}
		//IncTaxPayRev, OtherCurLiaRev
		VIPFinancialsPage.contents.IncTaxPayRevGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.OtherCurLiaRevGaugeIcon.verifyDisplayed(true, 5);
		//Legend
		VIPFinancialsPage.contents.WCRTargetCompLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRTargetCompLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.WCRPeerMedianLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRPeerMedianLegendText.verifyText("Peer Median");
		VIPFinancialsPage.contents.WCRBetterLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRBetterLegendText.verifyText("Better than peer median");
		VIPFinancialsPage.contents.WCRWorseLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRWorseLegendText.verifyText("Worse than peer median");
		VIPFinancialsPage.contents.WCRInlineLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRInlineLegendText.verifyText("In-line with peer median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_097");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_100");
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.FirstPeriodHeader.verifyText(TwoYears);
		VIPFinancialsPage.contents.SecondPeriodHeader.verifyText(OneYear);
		VIPFinancialsPage.contents.ThirdPeriodHeader.verifyText("TTM");
		VIPFinancialsPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_100");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_101");
		VIPFinancialsPage.contents.SelectIndicatorDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndWorkCapRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndOpeCurAssRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndNonIntBearLiabRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndCashRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndNetRecRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndInventoryRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndOtherCurAssRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndAccPayRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndIncTaxPayRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndOtherCurLiaRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndWorkCapRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + WorCapRevKPIP2_1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndOpeCurAssRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("OPERATING CURRENT ASSETS / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndCashRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("CASH / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndNetRecRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("NET RECEIVABLES / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + NetRecRevKPIP2_1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndInventoryRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("INVENTORY / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + InvRevKPIP2_1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndOtherCurAssRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("OTHER CUR. ASSETS / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndNonIntBearLiabRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("NON-INTEREST BEARING LIABILITIES / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndAccPayRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("ACCOUNTS PAYABLE / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + AccPayRevKPIP2_1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndIncTaxPayRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("INCOME TAX PAYABLE / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndOtherCurLiaRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("OTHER CURRENT LIABILITIES / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_101");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103");
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		//WorCapRev
		VIPFinancialsPage.contents.WorkCapRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);    
		if (WorCapRev2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue decreased by " + WorCapRev2YrChange5 + " pps over the last 2 years from " + (WorCapRevKPI_2YrCP_2) + "% in " + TwoYears + " to " + WorCapRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (WorCapRev2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue increased by " + WorCapRev2YrChange5 + " pps over the last 2 years from " + (WorCapRevKPI_2YrCM_2) + "% in " + TwoYears + " to " + WorCapRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue remained constant at " + WorCapRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (WorCapRevKPI2_3 > WorCapRevKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is higher than the peer median of " + WorCapRevKPIP2_3 + "%" + " by " + WorCapRevKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is lower than the peer median of " + WorCapRevKPIP2_3 + "%" + " by " + WorCapRevKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(WorCapRevBest1_3 + " (" + WorCapRevBest3 + "%) " + "ranked the best in terms of Working Capital/Revenue in TTM");
		String WCRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String WCRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String WCRBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//NetRecRev
		VIPFinancialsPage.contents.NetRecRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (NetRecRev2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue decreased by " + NetRecRev2YrChange5 + " pps over the last 2 years from " + (NetRecRevKPI_2YrCP_2) + "% in " + TwoYears + " to " + NetRecRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (NetRecRev2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue increased by " + NetRecRev2YrChange5 + " pps over the last 2 years from " + (NetRecRevKPI_2YrCM_2) + "% in " + TwoYears + " to " + NetRecRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue remained constant at " + NetRecRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (NetRecRevKPI2_3 > NetRecRevKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net Receivables/Revenue in TTM is higher than the peer median of " + NetRecRevKPIP2_3 + "%" + " by " + NetRecRevKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net Receivables/Revenue in TTM is lower than the peer median of " + NetRecRevKPIP2_3 + "%" + " by " + NetRecRevKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(NetRecRevBest1_3 + " (" + NetRecRevBest3 + "%) " + "ranked the best in terms of Net Receivables/Revenue in TTM");
		String NRRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String NRRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String NRRBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//InvRev
		VIPFinancialsPage.contents.InventoryRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (InvRev2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue decreased by " + InvRev2YrChange5 + " pps over the last 2 years from " + (InvRevKPI_2YrCP_2) + "% in " + TwoYears + " to " + InvRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (InvRev2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue increased by " + InvRev2YrChange5 + " pps over the last 2 years from " + (InvRevKPI_2YrCM_2) + "% in " + TwoYears + " to " + InvRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue remained constant at " + InvRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (InvRevKPI2_3 > InvRevKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory/Revenue in TTM is higher than the peer median of " + InvRevKPIP2_3 + "%" + " by " + InvRevKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory/Revenue in TTM is lower than the peer median of " + InvRevKPIP2_3 + "%" + " by " + InvRevKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(InvRevBest1_3 + " (" + InvRevBest3 + "%) " + "ranked the best in terms of Inventory/Revenue in TTM");
		String IRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String IRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String IRBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//AccPayRev
		VIPFinancialsPage.contents.AccPayRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (AccPayRev2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue decreased by " + AccPayRev2YrChange5 + " pps over the last 2 years from " + (AccPayRevKPI_2YrCP_2) + "% in " + TwoYears + " to " + AccPayRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (AccPayRev2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue increased by " + AccPayRev2YrChange5 + " pps over the last 2 years from " + (AccPayRevKPI_2YrCM_2) + "% in " + TwoYears + " to " + AccPayRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue remained constant at " + AccPayRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (AccPayRevKPI2_3 > AccPayRevKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Accounts Payable/Revenue in TTM is higher than the peer median of " + AccPayRevKPIP2_3 + "%" + " by " + AccPayRevKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Accounts Payable/Revenue in TTM is lower than the peer median of " + AccPayRevKPIP2_3 + "%" + " by " + AccPayRevKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(AccPayRevBest1_3 + " (" + AccPayRevBest3 + "%) " + "ranked the best in terms of Accounts Payable/Revenue in TTM");
		String APRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String APRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String APRBest = VIPFinancialsPage.contents.BestInClass.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103");	
		
		if (VIPFinancialsPage.contents.FootNote.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Reg_Auto_104");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(true, 5);
		String FootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_104");
			
		ReportLog.setTestCase("Q2A_Reg_Auto_105");
		VIPFinancialsPage.contents.CashRevBox.click();
		String StandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String BestInClass = VIPFinancialsPage.contents.BestInClass.getText();
		String RightHandChartHeader = VIPFinancialsPage.contents.RightHandChartHeader.getText();
		String FootNote2 = VIPFinancialsPage.contents.FootNote.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote2);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText(RightHandChartHeader);
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote2);
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText(RightHandChartHeader);
		WebControl.takeScreenshot("Q2A_Reg_Auto_105");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_106");
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
		VIPFinancialsPage.contents.OpeWorCapDecMenu.click();
		VIPFinancialsPage.contents.WorkCapRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(WCRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(WCRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(WCRBest);
		VIPFinancialsPage.contents.NetRecRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(NRRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(NRRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(NRRBest);
		VIPFinancialsPage.contents.InventoryRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(IRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(IRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(IRBest);
		VIPFinancialsPage.contents.AccPayRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(APRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(APRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(APRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_106");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Reg_Auto_104");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_104");
			
		ReportLog.setTestCase("Q2A_Reg_Auto_105");
		VIPFinancialsPage.contents.CashRevBox.click();
		String StandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String BestInClass = VIPFinancialsPage.contents.BestInClass.getText();
		String RightHandChartHeader = VIPFinancialsPage.contents.RightHandChartHeader.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText(RightHandChartHeader);
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText(RightHandChartHeader);
		WebControl.takeScreenshot("Q2A_Reg_Auto_105");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_106");
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
		VIPFinancialsPage.contents.OpeWorCapDecMenu.click();
		VIPFinancialsPage.contents.WorkCapRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(WCRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(WCRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(WCRBest);
		VIPFinancialsPage.contents.NetRecRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(NRRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(NRRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(NRRBest);
		VIPFinancialsPage.contents.InventoryRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(IRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(IRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(IRBest);
		VIPFinancialsPage.contents.AccPayRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(APRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(APRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(APRBest);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_106");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
			
	}
	
	@Test(priority=11)
	public void Q2A_CashCycleAnalysis () throws Exception {
		ReportLog.setTestName("Q2A - Cash Cycle Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_107");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CashCycleAnalysisMenu.click();
		VIPFinancialsPage.contents.ChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCALeftHandChartNote.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCALeftHandChartNote.verifyText("Click on the KPI box to view peer comparison");
		VIPFinancialsPage.contents.CCARightHandChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Cash Cycle Days");
		WebControl.takeScreenshot("Q2A_Reg_Auto_107");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_108");
		VIPFinancialsPage.contents.CashCycleChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CashCycleChartHeader.verifyText("Cash Cycle");
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DaysSalesOutstandingChartHeader.verifyText("Days Sales Outstanding");
		VIPFinancialsPage.contents.InventoryDaysChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.InventoryDaysChartHeader.verifyText("Inventory Days");
		VIPFinancialsPage.contents.DaysPayableChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DaysPayableChartHeader.verifyText("Days Payable");
		WebControl.takeScreenshot("Q2A_Reg_Auto_108");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_110");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.CashCycleChartTooltip.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.CashCycleChartTooltip.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.FCCDTooltip);
		VIPFinancialsPage.contents.CashCycleChartTooltip.click();
		VIPFinancialsPage.contents.InventoryDaysChartTooltip.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.InventoryDaysChartTooltip.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.FDIOTooltip);
		VIPFinancialsPage.contents.InventoryDaysChartTooltip.click();
		VIPFinancialsPage.contents.DaysSalesOutstandingChartTooltip.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.DaysSalesOutstandingChartTooltip.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.FDSOTooltip);
		VIPFinancialsPage.contents.DaysSalesOutstandingChartTooltip.click();
		VIPFinancialsPage.contents.DaysPayableChartTooltip.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.DaysPayableChartTooltip.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.FDPOTooltip);
		VIPFinancialsPage.contents.DaysPayableChartTooltip.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_110");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_111_1");
		VIPFinancialsPage.contents.EqualsSymbol.verifyText("=");
		VIPFinancialsPage.contents.PlusSymbol.verifyText("+");
		VIPFinancialsPage.contents.MinusSymbol.verifyText("-");
		WebControl.takeScreenshot("Q2A_Reg_Auto_111_1");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_111_2");
		VIPLandingPage.contents.HelpIcon.hover();
//		VIPSalesPage.contents.SideMenuSales.click();
//		Thread.sleep(1500);
//		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
//		VIPSalesPage.contents.OppNavModalCloseButton.click();}
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPSalesPage.contents.FinancialKPIs.hover();
//		VIPSalesPage.contents.FinancialKPIs.click();
//		//CCD KPI and Peer Median
//		String CCDKPI1 = VIPSalesPage.contents.CCDKPI.getText();
//		int CCDKPI = Integer.parseInt(CCDKPI1);
//		String CCDKPIP1 = VIPSalesPage.contents.CCDKPIP.getText();
//		int CCDKPIP = Integer.parseInt(CCDKPIP1);
//		//CCD BigDecimal
//		int CCDKPI_KPIP_1 = (CCDKPI - CCDKPIP);
//		int CCDKPIP_KPI_1 = (CCDKPIP - CCDKPI);
//		//DSO KPI and Peer Median
//		String DSOKPI1 = VIPSalesPage.contents.DSOKPI.getText();
//		int DSOKPI = Integer.parseInt(DSOKPI1);
//		String DSOKPIP1 = VIPSalesPage.contents.DSOKPIP.getText();
//		int DSOKPIP = Integer.parseInt(DSOKPIP1);
//		//DSO BigDecimal
//		int DSOKPI_KPIP_1 = (DSOKPI - DSOKPIP);
//		int DSOKPIP_KPI_1 = (DSOKPIP - DSOKPI);
//		//DIO KPI and Peer Median
//		String DIOKPI1 = VIPSalesPage.contents.DIOKPI.getText();
//		int DIOKPI = Integer.parseInt(DIOKPI1);
//		String DIOKPIP1 = VIPSalesPage.contents.DIOKPIP.getText();
//		int DIOKPIP = Integer.parseInt(DIOKPIP1);
//		//DIO BigDecimal
//		int DIOKPI_KPIP_1 = (DIOKPI - DIOKPIP);
//		int DIOKPIP_KPI_1 = (DIOKPIP - DIOKPI);
//		//DPO KPI and Peer Median
//		String DPOKPI1 = VIPSalesPage.contents.DPOKPI.getText();
//		int DPOKPI = Integer.parseInt(DPOKPI1);
//		String DPOKPIP1 = VIPSalesPage.contents.DPOKPIP.getText();
//		int DPOKPIP = Integer.parseInt(DPOKPIP1);
//		//DPO BigDecimal
//		int DPOKPI_KPIP_1 = (DPOKPI - DPOKPIP);
//		int DPOKPIP_KPI_1 = (DPOKPIP - DPOKPI);
//		//CCD Rank
//		VIPSalesPage.contents.CCDPercentile.hover();
//		String CCDRank1 = VIPSalesPage.contents.TooltipText.getText();
//		String[] CCDRank2 = CCDRank1.split("\\n");
//		String CCDRank2_1 = CCDRank2[1];
//		String[] CCDRank2_2 = CCDRank2_1.split("\\/");
//		String CCDRank2_3 = CCDRank2_2[0];
//		String CCDRank2_4 = CCDRank2_2[1];
//		String CCDRank2_5 = CCDRank2_3.replace(" ", "");
//		String CCDRank2_6 = CCDRank2_4.replace(" ", "");
//		Double CCDRank3_1 = Double.parseDouble(CCDRank2_5);
//		Double CCDRank3_2 = Double.parseDouble(CCDRank2_6);
//		Double CCDRank = (CCDRank3_1/CCDRank3_2);
//		//DSO Rank
//		VIPSalesPage.contents.DSOPercentile.hover();
//		String DSORank1 = VIPSalesPage.contents.TooltipText.getText();
//		String[] DSORank2 = DSORank1.split("\\n");
//		String DSORank2_1 = DSORank2[1];
//		String[] DSORank2_2 = DSORank2_1.split("\\/");
//		String DSORank2_3 = DSORank2_2[0];
//		String DSORank2_4 = DSORank2_2[1];
//		String DSORank2_5 = DSORank2_3.replace(" ", "");
//		String DSORank2_6 = DSORank2_4.replace(" ", "");
//		Double DSORank3_1 = Double.parseDouble(DSORank2_5);
//		Double DSORank3_2 = Double.parseDouble(DSORank2_6);
//		Double DSORank = (DSORank3_1/DSORank3_2);
//		//DIO Rank
////		VIPSalesPage.contents.DIOPercentile.hover();
////		String DIORank1 = VIPSalesPage.contents.TooltipText.getText();
////		String[] DIORank2 = DIORank1.split("\\n");
////		String DIORank2_1 = DIORank2[1];
////		String[] DIORank2_2 = DIORank2_1.split("\\/");
////		String DIORank2_3 = DIORank2_2[0];
////		String DIORank2_4 = DIORank2_2[1];
////		String DIORank2_5 = DIORank2_3.replace(" ", "");
////		String DIORank2_6 = DIORank2_4.replace(" ", "");
////		Double DIORank3_1 = Double.parseDouble(DIORank2_5);
////		Double DIORank3_2 = Double.parseDouble(DIORank2_6);
////		Double DIORank = (DIORank3_1/DIORank3_2);
//		//DPO Rank
//		VIPSalesPage.contents.DPOPercentile.hover();
//		String DPORank1 = VIPSalesPage.contents.TooltipText.getText();
//		String[] DPORank2 = DPORank1.split("\\n");
//		String DPORank2_1 = DPORank2[1];
//		String[] DPORank2_2 = DPORank2_1.split("\\/");
//		String DPORank2_3 = DPORank2_2[0];
//		String DPORank2_4 = DPORank2_2[1];
//		String DPORank2_5 = DPORank2_3.replace(" ", "");
//		String DPORank2_6 = DPORank2_4.replace(" ", "");
//		Double DPORank3_1 = Double.parseDouble(DPORank2_5);
//		Double DPORank3_2 = Double.parseDouble(DPORank2_6);
//		Double DPORank = (DPORank3_1/DPORank3_2);
		//CCD
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CashCycleAnalysisMenu.click();
//		if (CCDKPI > CCDKPIP) {
//		VIPFinancialsPage.contents.CCDRedIcon.verifyDisplayed(true, 5);}
//		else if (CCDKPI < CCDKPIP & CCDKPI != 0) {
//		VIPFinancialsPage.contents.CCDGreenIcon.verifyDisplayed(true, 5);}
//		else if (CCDKPI == CCDKPIP & CCDKPI != 0)	{
//		VIPFinancialsPage.contents.CCDYellowIcon.verifyDisplayed(true, 5);}
//		else {VIPFinancialsPage.contents.CCDTransparentIcon.verifyDisplayed(true, 3);}
//		//DSO
//		if (DSOKPI > DSOKPIP) {
//		VIPFinancialsPage.contents.DSORedIcon.verifyDisplayed(true, 5);}
//		else if (DSOKPI < DSOKPIP & DSOKPI != 0) {
//		VIPFinancialsPage.contents.DSOGreenIcon.verifyDisplayed(true, 5);}
//		else if (DSOKPI == DSOKPIP & DSOKPI != 0)	{
//		VIPFinancialsPage.contents.DSOYellowIcon.verifyDisplayed(true, 5);}
//		else {VIPFinancialsPage.contents.DSOTransparentIcon.verifyDisplayed(true, 3);}
//		//DPO
//		if (DPOKPI > DPOKPIP) {
//		VIPFinancialsPage.contents.DPOGreenIcon.verifyDisplayed(true, 5);}
//		else if (DPOKPI < DPOKPIP & DPOKPI != 0) {
//		VIPFinancialsPage.contents.DPORedIcon.verifyDisplayed(true, 5);}
//		else if (DPOKPI == DPOKPIP & DPOKPI != 0)	{
//		VIPFinancialsPage.contents.DPOYellowIcon.verifyDisplayed(true, 5);}
//		else {VIPFinancialsPage.contents.DPOTransparentIcon.verifyDisplayed(true, 3);}
//		//DIO
//		if (DIOKPI > DIOKPIP) {
//		VIPFinancialsPage.contents.DIORedIcon.verifyDisplayed(true, 5);}
//		else if (DIOKPI < DIOKPIP & DIOKPI != 0) {
//		VIPFinancialsPage.contents.DIOGreenIcon.verifyDisplayed(true, 5);}
//		else if (DIOKPI == DIOKPIP & DIOKPI != 0)	{
//		VIPFinancialsPage.contents.DIOYellowIcon.verifyDisplayed(true, 5);}
//		else {VIPFinancialsPage.contents.DIOTransparentIcon.verifyDisplayed(true, 3);}
		//Legend
		VIPFinancialsPage.contents.CCDTargetCompLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCDTargetCompLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.CCDPeerMedianLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCDPeerMedianLegendText.verifyText("Peer Median");
		VIPFinancialsPage.contents.CCDBetterLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCDBetterLegendText.verifyText("Better than peer median");
		VIPFinancialsPage.contents.CCDWorseLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCDWorseLegendText.verifyText("Worse than peer median");
		VIPFinancialsPage.contents.CCDInlineLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCDInlineLegendText.verifyText("In-line with peer median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_111_2");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_113");
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.hover();
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Days Sales Outstanding");
//		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyText("Peer Median: " + DSOKPIP1);
		VIPFinancialsPage.contents.InventoryDaysChart.hover();
		VIPFinancialsPage.contents.InventoryDaysChart.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Inventory Days");
//		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyText("Peer Median: " + DIOKPIP1);
		VIPFinancialsPage.contents.DaysPayableChart.hover();
		VIPFinancialsPage.contents.DaysPayableChart.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Days Payable");
//		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyText("Peer Median: " + DPOKPIP1);
		VIPFinancialsPage.contents.CashCycleChart2.hover();
		VIPFinancialsPage.contents.CashCycleChart2.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Cash Cycle Days");
//		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyText("Peer Median: " + CCDKPIP1);
		WebControl.takeScreenshot("Q2A_Reg_Auto_113");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_114");
		//CCD
		VIPFinancialsPage.contents.CashCycleChart.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);    																				
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true, 5);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
//		if (CCDKPI > CCDKPIP) {
//		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Cash Cycle Days in TTM is higher than the peer median of " + CCDKPIP + " days" + " by " + CCDKPI_KPIP_1 + " days");
//		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Cash Cycle Days in TTM is lower than the peer median of " + CCDKPIP + " days" + " by " + CCDKPIP_KPI_1 + " days");
//		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
//		//Competitive Position 2nd Bullet
//		if ((CCDRank > 0) & (CCDRank <= 0.25)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s Cash Cycle management in terms of Cash Cycle Days placed it in the top quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((CCDRank > 0.25) & (CCDRank <= 0.5)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s Cash Cycle management in terms of Cash Cycle Days placed it in the 2nd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((CCDRank > 0.5) & (CCDRank <= 0.75)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s Cash Cycle management in terms of Cash Cycle Days placed it in the 3rd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s Cash Cycle management in terms of Cash Cycle Days placed it in the bottom quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(true, 5);
		String CCDSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CCDCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CCDCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String CCDBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//DIO
		VIPFinancialsPage.contents.InventoryDaysChart.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(false);    																				
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(false);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(false);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(false);
		//Competitive Position 2nd Bullet
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(false);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(false);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(false);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(false);
		
//		//DIO
//		VIPFinancialsPage.contents.InventoryDaysChart.click();
//		//Stand Alone
//		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);    																				
//		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true, 5);
//		//Competitive Position 1st Bullet
//		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
//		if (DIOKPI > DIOKPIP) {
//		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory Days in TTM is higher than the peer median of " + DIOKPIP + " days" + " by " + DIOKPI_KPIP_1 + " days");
//		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory Days in TTM is lower than the peer median of " + DIOKPIP + " days" + " by " + DIOKPIP_KPI_1 + " days");
//		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
//		//Competitive Position 2nd Bullet
//		if ((DIORank > 0) & (DIORank <= 0.25)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s inventory management placed it in the top quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((DIORank > 0.25) & (DIORank <= 0.5)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s inventory management placed it in the 2nd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((DIORank > 0.5) & (DIORank <= 0.75)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s inventory management placed it in the 3rd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s inventory management placed it in the bottom quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
//		//Best in Class
//		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(true, 5);
//		String DIOSP = VIPFinancialsPage.contents.StandalonePerf.getText();
//		String DIOCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
//		String DIOCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
//		String DIOBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//DSO
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);    																				
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true, 5);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
//		if (DSOKPI > DSOKPIP) {
//		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Days Sales Outstanding in TTM is higher than the peer median of " + DSOKPIP + " days" + " by " + DSOKPI_KPIP_1 + " days");
//		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Days Sales Outstanding in TTM is lower than the peer median of " + DSOKPIP + " days" + " by " + DSOKPIP_KPI_1 + " days");
//		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
//		//Competitive Position 2nd Bullet
//		if ((DSORank > 0) & (DSORank <= 0.25)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s credit management in terms of DSO placed it in the top quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((DSORank > 0.25) & (DSORank <= 0.5)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s credit management in terms of DSO placed it in the 2nd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((DSORank > 0.5) & (DSORank <= 0.75)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s credit management in terms of DSO placed it in the 3rd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s credit management in terms of DSO placed it in the bottom quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(true, 5);
		String DSOSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String DSOCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String DSOCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String DSOBest = VIPFinancialsPage.contents.BestInClass.getText();
		
		//DPO
		VIPFinancialsPage.contents.DaysPayableChart.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);    																				
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true, 5);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
//		if (DPOKPI > DPOKPIP) {
//		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Days Payable in TTM is higher than the peer median of " + DPOKPIP + " days" + " by " + DPOKPI_KPIP_1 + " days");
//		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Days Payable in TTM is lower than the peer median of " + DPOKPIP + " days" + " by " + DPOKPIP_KPI_1 + " days");
//		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
//		//Competitive Position 2nd Bullet
//		if ((DPORank > 0) & (DPORank <= 0.25)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s vendor management in terms of Days Payable placed it in the top quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((DPORank > 0.25) & (DPORank <= 0.5)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s vendor management in terms of Days Payable placed it in the 2nd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((DPORank > 0.5) & (DPORank <= 0.75)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s vendor management in terms of Days Payable placed it in the 3rd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "’s vendor management in terms of Days Payable placed it in the bottom quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_114");	
		
		if (VIPFinancialsPage.contents.FootNote.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Reg_Auto_115");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(true, 5);
		String DPOSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String DPOCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String DPOCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String DPOBest = VIPFinancialsPage.contents.BestInClass.getText();
		String FootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_115");

		ReportLog.setTestCase("Q2A_Reg_Auto_116");
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
		VIPFinancialsPage.contents.CashCycleAnalysisMenu.click();
		VIPFinancialsPage.contents.CashCycleChart.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(CCDSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CCDCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CCDCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(CCDBest);
		VIPFinancialsPage.contents.InventoryDaysChart.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(false);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(false);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(false);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(false);
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(DSOSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(DSOCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(DSOCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(DSOBest);
		VIPFinancialsPage.contents.DaysPayableChart.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(DPOSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(DPOCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(DPOCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(DPOBest);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_116");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Reg_Auto_115");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		String DPOSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String DPOCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String DPOCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String DPOBest = VIPFinancialsPage.contents.BestInClass.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_115");

		ReportLog.setTestCase("Q2A_Reg_Auto_116");
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
		VIPFinancialsPage.contents.CashCycleAnalysisMenu.click();
		VIPFinancialsPage.contents.CashCycleChart.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(CCDSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CCDCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CCDCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(CCDBest);
		VIPFinancialsPage.contents.InventoryDaysChart.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(false);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(false);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(false);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(false);
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(DSOSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(DSOCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(DSOCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(DSOBest);
		VIPFinancialsPage.contents.DaysPayableChart.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(DPOSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(DPOCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(DPOCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(DPOBest);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_116");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
	}
	
	@Test(priority=12)
	public void Q2A_BusinessSegmentAnalysis () throws Exception {
		ReportLog.setTestName("Q2A - Business Segment Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_117");			
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
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
		String RBSPieChartTimePeriod1 = VIPFinancialsPage.contents.RBSPieChartTimePeriod.getText();
		String RBSPieChartTimePeriod = RBSPieChartTimePeriod1.substring(7, 14);
		VIPFinancialsPage.contents.RBSPieChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RBSPieChartTitle.verifyText("REVENUE BY SEGMENT");
		VIPFinancialsPage.contents.RBSPieChartTimePeriod.verifyText("[TTM – " + RBSPieChartTimePeriod + ", % by Revenue]");
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
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
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
		String Menu1KeyInsights1 = VIPFinancialsPage.contents.BSAKeyInsights1.getText();
		String Menu1KeyInsights2 = VIPFinancialsPage.contents.BSAKeyInsights2.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		String Menu2KeyInsights1 = VIPFinancialsPage.contents.BSAKeyInsights1.getText();
		String Menu2KeyInsights2 = VIPFinancialsPage.contents.BSAKeyInsights2.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu3.click();
		String Menu3KeyInsights1 = VIPFinancialsPage.contents.BSAKeyInsights1.getText();
		String Menu3KeyInsights2 = VIPFinancialsPage.contents.BSAKeyInsights2.getText();
		WebControl.takeScreenshot("Q2A_Regression_128_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_128_Validation");
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
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
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu3.click();
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyText(Menu3KeyInsights1);
		VIPFinancialsPage.contents.BSAKeyInsights2.verifyText(Menu3KeyInsights2);
		VIPFinancialsPage.contents.BSAFootnote.verifyText(BSAFootnote);
		WebControl.takeScreenshot("Q2A_Regression_128_Validation");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
	@Test(priority=13)
	public void Q2A_GeographicSegmentAnalysis () throws Exception {
		ReportLog.setTestName("Q2A - Geographic Segment Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_129");
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
		String RBSPieChartTimePeriod1 = VIPFinancialsPage.contents.RBSPieChartTimePeriod.getText();
		String RBSPieChartTimePeriod = RBSPieChartTimePeriod1.substring(7, 14);
		VIPFinancialsPage.contents.RBSPieChart2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RBSPieChartTitle.verifyText("REVENUE BY SEGMENT");
		VIPFinancialsPage.contents.RBSPieChartTimePeriod.verifyText("[TTM – " + RBSPieChartTimePeriod + ", % by Revenue]");
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
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsights2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu3.click();
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsights2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(true, 5);
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
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		String Menu1KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		String Menu2KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		String Menu2KeyInsights2 = VIPFinancialsPage.contents.GSAKeyInsights2.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu3.click();
		String Menu3KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		String Menu3KeyInsights2 = VIPFinancialsPage.contents.GSAKeyInsights2.getText();
		WebControl.takeScreenshot("Q2A_Regression_140_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_140_Validation");
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
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
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu3.click();
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyText(Menu3KeyInsights1);
		VIPFinancialsPage.contents.GSAKeyInsights2.verifyText(Menu3KeyInsights2);
		VIPFinancialsPage.contents.GSAFootnote.verifyText(GSAFootnote);
		WebControl.takeScreenshot("Q2A_Regression_140_Validation");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}	
	
	@Test(priority=14)
	public void Q2A_Glossary () throws Exception {
		ReportLog.setTestName("Q2A - Glossary");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_141");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown13.click();
		VIPFinancialsPage.contents.GlossaryTitle.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GlossaryTitle.verifyText("GLOSSARY");
		VIPFinancialsPage.contents.DashboardHeader.verifyText("DASHBOARD");
		VIPFinancialsPage.contents.KeyIndicatorHeader.verifyText("KEY INDICATOR");
		VIPFinancialsPage.contents.DescriptionHeader.verifyText("DESCRIPTION");
		WebControl.takeScreenshot("Q2A_Regression_141");
		
		ReportLog.setTestCase("Q2A_Regression_142_1");
		VIPFinancialsPage.contents.Dashboard1.verifyText("Total Return to Shareholders");
		VIPFinancialsPage.contents.Dashboard2.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard3.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard4.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard5.verifyText("Analyst Recommendations");
		VIPFinancialsPage.contents.Dashboard6.verifyText("Analyst Recommendations");
		VIPFinancialsPage.contents.Dashboard7.verifyText("Scorecard");
		VIPFinancialsPage.contents.Dashboard8.verifyText("Revenue and Profitability Estimates");
		VIPFinancialsPage.contents.Dashboard9.verifyText("Revenue and Profitability Estimates");
		VIPFinancialsPage.contents.Dashboard10.verifyText("Revenue and Profitability Estimates");
		VIPFinancialsPage.contents.Dashboard11.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard12.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard13.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard14.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard15.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard16.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard17.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard18.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard19.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard20.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard21.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard22.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard23.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.Dashboard24.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.Dashboard25.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.Dashboard26.verifyText("Cash Cycle Analysis");
		//VIPFinancialsPage.contents.Dashboard27.verifyText("Cash Cycle Analysis");
		//VIPFinancialsPage.contents.Dashboard28.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.Indicator1.verifyText("Total Return to Shareholders");
		VIPFinancialsPage.contents.Indicator2.verifyText("Premium on Invested Capital (EV / IC)");
		VIPFinancialsPage.contents.Indicator3.verifyText("EV / EBIT");
		VIPFinancialsPage.contents.Indicator4.verifyText("Pre-Tax ROIC (EBIT / IC)");
		VIPFinancialsPage.contents.Indicator5.verifyText("Analyst Ratings");
		VIPFinancialsPage.contents.Indicator6.verifyText("Expected 1-Year Share Price Growth");
		VIPFinancialsPage.contents.Indicator7.verifyText("Buy %");
		VIPFinancialsPage.contents.Indicator8.verifyText("Revenue Growth Estimates");
		VIPFinancialsPage.contents.Indicator9.verifyText("EBIT Margin Estimates");
		VIPFinancialsPage.contents.Indicator10.verifyText("EBITDA Margin Estimates");
		VIPFinancialsPage.contents.Indicator11.verifyText("COGS / Revenue");
		VIPFinancialsPage.contents.Indicator12.verifyText("SG&A / Revenue");
		VIPFinancialsPage.contents.Indicator13.verifyText("Depreciation & Amortization / Revenue");
		VIPFinancialsPage.contents.Indicator14.verifyText("Capital Efficiency");
		VIPFinancialsPage.contents.Indicator15.verifyText("Working Capital / Revenue");
		VIPFinancialsPage.contents.Indicator16.verifyText("Net PPE / Revenue");
		VIPFinancialsPage.contents.Indicator17.verifyText("Goodwill & Intangibles / Revenue");
		VIPFinancialsPage.contents.Indicator18.verifyText("Operating cash / Revenue");
		VIPFinancialsPage.contents.Indicator19.verifyText("Inventory / Revenue");
		VIPFinancialsPage.contents.Indicator20.verifyText("Accounts Payable / Revenue");
		VIPFinancialsPage.contents.Indicator21.verifyText("Net Receivables / Revenue");
		VIPFinancialsPage.contents.Indicator22.verifyText("Inc Tax Payable / Revenue");
		VIPFinancialsPage.contents.Indicator23.verifyText("Cash Cycle");
		VIPFinancialsPage.contents.Indicator24.verifyText("Days Sales Outstanding");
		VIPFinancialsPage.contents.Indicator25.verifyText("Inventory Days");
		VIPFinancialsPage.contents.Indicator26.verifyText("Days Payable");
//		VIPFinancialsPage.contents.Indicator27.verifyText("Inventory Days");
//		VIPFinancialsPage.contents.Indicator28.verifyText("Days Payable");
		VIPFinancialsPage.contents.Definition1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition3.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition4.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition5.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition6.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition7.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition8.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition9.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition10.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition11.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition12.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition13.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition14.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition15.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition16.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition17.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition18.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition19.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition20.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition21.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition22.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition23.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition24.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition25.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition26.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.Definition27.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.Definition28.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Positive1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Positive2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Positive3.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_142_1");
		
		ReportLog.setTestCase("Q2A_Regression_142_2");
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
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.RefineCriteriaButton.waitForExist(true, 10);
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 10);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown13.click();
		VIPFinancialsPage.contents.GlossaryTitle.waitForExist(true, 10);
		VIPFinancialsPage.contents.Negative1.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative2.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative3.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative4.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative5.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative6.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative7.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative8.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative9.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative10.verifyDisplayed(false);
		VIPFinancialsPage.contents.Positive1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Positive2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Positive3.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_142_2");
		
		ReportLog.setTestCase("Q2A_Regression_144");
		VIPFinancialsPage.contents.GlossaryFootnote.verifyText("Note: Please refer to Methodology for impact of Capitalized Value of Operating Lease & Unfunded Retirement Liability adjustments");
		WebControl.takeScreenshot("Q2A_Regression_144");
		
	}
	
	@Test(priority=15)
	public void Q2A_Methodology () throws Exception {
		ReportLog.setTestName("Q2A - Methodology");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_145");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
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
		VIPFinancialsPage.contents.SelectDropDown14.click();
		VIPFinancialsPage.contents.MethodologyTitle.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.MethodologyTitle.verifyText("METHODOLOGY");
		VIPFinancialsPage.contents.KeyItemsHeader.verifyText("KEY ITEMS");
		VIPFinancialsPage.contents.MethodologyDescriptionHeader.verifyText("DESCRIPTION");
		WebControl.takeScreenshot("Q2A_Regression_145");
		
		ReportLog.setTestCase("Q2A_Regression_146");
		VIPFinancialsPage.contents.KeyItems1.verifyText("Financial Reporting");
		VIPFinancialsPage.contents.KeyItems2.verifyText("Year Alignment");
		VIPFinancialsPage.contents.KeyItems3.verifyText("Peer Median");
		VIPFinancialsPage.contents.KeyItems4.verifyText("Capital Efficiency Ratios");
		VIPFinancialsPage.contents.KeyItems5.verifyText("Trailing Twelve Months (TTM) Calculations");
		VIPFinancialsPage.contents.KeyItems6.verifyText("Unfunded Retirement Liabilities Adjustments");
		VIPFinancialsPage.contents.KeyItems7.verifyText("Operating Leases Adjustments");
		VIPFinancialsPage.contents.KeyItems8.verifyText("Data Release");
		VIPFinancialsPage.contents.Description1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description3.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description4.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description5.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description6.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description7.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description8.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Regression_146");
		
		ReportLog.setTestCase("Q2A_Regression_147");
		VIPFinancialsPage.contents.MethodologyFootnote.verifyText("Note: For special financial situations such as M&A, divestments, accounting standard changes and presence of financial services arm, Custom Analysis is recommended for more accurate analysis.");
		WebControl.takeScreenshot("Q2A_Regression_147");
		
	}
	
	
	static int currentYear() {
	    Calendar prevYear = Calendar.getInstance();
	    prevYear.add(Calendar.YEAR, 0);
	    return prevYear.get(Calendar.YEAR);
	}
	
	static int get1YearAgo() {
	    Calendar prevYear = Calendar.getInstance();
	    prevYear.add(Calendar.YEAR, -1);
	    return prevYear.get(Calendar.YEAR);
	}
	
	static int get2YearsAgo() {
	    Calendar prevYear = Calendar.getInstance();
	    prevYear.add(Calendar.YEAR, -2);
	    return prevYear.get(Calendar.YEAR);
	}
	
	static int get3YearsAgo() {
	    Calendar prevYear = Calendar.getInstance();
	    prevYear.add(Calendar.YEAR, -3);
	    return prevYear.get(Calendar.YEAR);
	}
	
	static String getPreviousMonthDate(Date date){
	    final SimpleDateFormat format = new SimpleDateFormat("MMM");

	    Calendar cal = Calendar.getInstance();  
	    cal.setTime(date);  
	    cal.set(Calendar.DAY_OF_MONTH, 1);  
	    cal.add(Calendar.DATE, -1);

	    Date preMonthDate = cal.getTime();  
	    return format.format(preMonthDate);
	}

	static int getLastDayOfPrevMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return (cal.get(Calendar.DAY_OF_MONTH));
	}

}


