package scenarios.Q2A;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

public class Q2A_All extends TestBase{
	
	@Test(priority=1)
	public void Q2A_Common () throws Exception {
		ReportLog.setTestName("Financials - Common");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_001_to_003");
		VIP_Common.LogInPage(testDataHandler);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.EBITMarginValue.waitForExist(true, 60);
		Thread.sleep(2000);
		String RBB = "";
		String RBG = "";
		if (VIPOverviewPage.contents.RBBPieChart.isDisplayed()) {
			RBB = "1";
		}
		if (VIPOverviewPage.contents.RBGPieChart.isDisplayed()) {
			RBG = "1";
		}
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
		if (RBB.equals("1")) {
			VIPFinancialsPage.contents.SelectDropDown11.verifyText("Business Segment Analysis");
		}
		else {
			VIPFinancialsPage.contents.SelectDropDown11.verifyDisplayed(false);
		}
		if (RBG.equals("1")) {
			VIPFinancialsPage.contents.SelectDropDown12.verifyText("Geographic Segment Analysis");
		}
		else {
			VIPFinancialsPage.contents.SelectDropDown12.verifyDisplayed(false);
		}
		VIPFinancialsPage.contents.DropDownMainHeader6.verifyText("Appendix");
		VIPFinancialsPage.contents.SelectDropDown13.verifyText("Glossary");
		VIPFinancialsPage.contents.SelectDropDown14.verifyText("Methodology");
		VIPFinancialsPage.contents.SelectDropDown15.verifyText("Reference Calculations");
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
		VIPLandingPage.contents.HelpIcon.hover();
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
		VIPFinancialsPage.contents.SelectDropDown1.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown2.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown3.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown4.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown5.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown6.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown7.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown8.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown9.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown10.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown11.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown12.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown13.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown14.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown15.verifyDisplayed(true);
		WebControl.takeScreenshot("Q2A_Reg_Auto_004");
		
//		ReportLog.setTestCase("Q2A_Reg_Auto_005_IsPrivateCompany");
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.BackToSearchButton.hover();
//		VIPOverviewPage.contents.BackToSearchButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Huawei Investment");
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
//		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
//		Thread.sleep(1000);
//		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
//		VIPFinancialsPage.contents.IsPrivateCompany.verifyText("No Results. Add competitors or refine search criteria to display results.");
//		WebControl.takeScreenshot("Q2A_Reg_Auto_005_IsPrivateCompany");
		
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
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
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
		
//		ReportLog.setTestCase("Q2A_Reg_Auto_020_TARGET");
//		String KPI1 = VIPFinancialsPage.contents.KPI1.getText();
//		if (KPI1 != "N/A") {
//		String[] KPI1_2 = KPI1.split("\\.");
//		String KPI1_3 = KPI1_2[0];
//		String KPI1_4 = KPI1.substring(KPI1.length() - 2);
//		VIPFinancialsPage.contents.KPI1.verifyText(KPI1_3 + "." + KPI1_4);}
//		else {VIPFinancialsPage.contents.KPI1.verifyText(KPI1);}
//		String KPI2 = VIPFinancialsPage.contents.KPI2.getText();
//		if (KPI2 != "N/A") {
//		String[] KPI2_2 = KPI2.split("\\.");
//		String KPI2_3 = KPI2_2[0];
//		String KPI2_4 = KPI2.substring(KPI2.length() - 2);
//		VIPFinancialsPage.contents.KPI2.verifyText(KPI2_3 + "." + KPI2_4);}
//		else {VIPFinancialsPage.contents.KPI2.verifyText(KPI2);}
//		String KPI3 = VIPFinancialsPage.contents.KPI3.getText();
//		if (KPI3 != "N/A") {
//		String[] KPI3_2 = KPI3.split("\\.");
//		String KPI3_3 = KPI3_2[0];
//		String KPI3_4 = KPI3.substring(KPI3.length() - 2);
//		VIPFinancialsPage.contents.KPI3.verifyText(KPI3_3 + "." + KPI3_4);}
//		else {VIPFinancialsPage.contents.KPI3.verifyText(KPI3);}
//		String KPI4 = VIPFinancialsPage.contents.KPI4.getText();
//		if (KPI4 != "N/A") {
//		String[] KPI4_2 = KPI4.split("\\.");
//		String KPI4_3 = KPI4_2[0];
//		String KPI4_4 = KPI4.substring(KPI4.length() - 2);
//		VIPFinancialsPage.contents.KPI4.verifyText(KPI4_3 + "." + KPI4_4);}
//		else {VIPFinancialsPage.contents.KPI4.verifyText(KPI4);}
//		String KPI5 = VIPFinancialsPage.contents.KPI5.getText();
//		if (KPI5 != "N/A") {
//		String[] KPI5_2 = KPI5.split("\\.");
//		String KPI5_3 = KPI5_2[0];
//		String KPI5_4 = KPI5.substring(KPI5.length() - 2);
//		VIPFinancialsPage.contents.KPI5.verifyText(KPI5_3 + "." + KPI5_4);}
//		else {VIPFinancialsPage.contents.KPI5.verifyText(KPI5);}
//		String KPI6 = VIPFinancialsPage.contents.KPI6.getText();
//		if (KPI6 != "N/A") {
//		String[] KPI6_2 = KPI6.split("\\.");
//		String KPI6_3 = KPI6_2[0];
//		String KPI6_4 = KPI6.substring(KPI6.length() - 2);
//		VIPFinancialsPage.contents.KPI6.verifyText(KPI6_3 + "." + KPI6_4);}
//		else {VIPFinancialsPage.contents.KPI6.verifyText(KPI6);}
//		String KPI7 = VIPFinancialsPage.contents.KPI7.getText();
//		if (KPI7 != "N/A") {
//		String[] KPI7_2 = KPI7.split("\\.");
//		String KPI7_3 = KPI7_2[0];
//		String KPI7_4 = KPI7.substring(KPI7.length() - 2);
//		VIPFinancialsPage.contents.KPI7.verifyText(KPI7_3 + "." + KPI7_4);}
//		else {VIPFinancialsPage.contents.KPI7.verifyText(KPI7);}
//		String KPI8 = VIPFinancialsPage.contents.KPI8.getText();
//		if (KPI8 != "N/A") {
//		String[] KPI8_2 = KPI8.split("\\.");
//		String KPI8_3 = KPI8_2[0];
//		String KPI8_4 = KPI8.substring(KPI8.length() - 1);
//		VIPFinancialsPage.contents.KPI8.verifyText(KPI8_3 + "." + KPI8_4);}
//		else {VIPFinancialsPage.contents.KPI8.verifyText(KPI8);}
//		String KPI9 = VIPFinancialsPage.contents.KPI9.getText();
//		if (KPI9 != "N/A") {
//		String[] KPI9_2 = KPI9.split("\\.");
//		String KPI9_3 = KPI9_2[0];
//		String KPI9_4 = KPI9.substring(KPI9.length() - 1);
//		VIPFinancialsPage.contents.KPI9.verifyText(KPI9_3 + "." + KPI9_4);}
//		else {VIPFinancialsPage.contents.KPI9.verifyText(KPI9);}
//		String KPI10 = VIPFinancialsPage.contents.KPI10.getText();
//		if (KPI10 != "N/A") {
//		String[] KPI10_2 = KPI10.split("\\.");
//		String KPI10_3 = KPI10_2[0];
//		String KPI10_4 = KPI10.substring(KPI10.length() - 2);
//		VIPFinancialsPage.contents.KPI10.verifyText(KPI10_3 + "." + KPI10_4);}
//		else {VIPFinancialsPage.contents.KPI10.verifyText(KPI10);}
//		String KPI11 = VIPFinancialsPage.contents.KPI11.getText();
//		if (KPI11 != "N/A") {
//		String[] KPI11_2 = KPI11.split("\\.");
//		String KPI11_3 = KPI11_2[0];
//		String KPI11_4 = KPI11.substring(KPI11.length() - 2);
//		VIPFinancialsPage.contents.KPI11.verifyText(KPI11_3 + "." + KPI11_4);}
//		else {VIPFinancialsPage.contents.KPI11.verifyText(KPI11);}
//		String KPI12 = VIPFinancialsPage.contents.KPI12.getText();
//		if (KPI12 != "N/A") {
//		String[] KPI12_2 = KPI12.split("\\.");
//		String KPI12_3 = KPI12_2[0];
//		String KPI12_4 = KPI12.substring(KPI12.length() - 2);
//		VIPFinancialsPage.contents.KPI12.verifyText(KPI12_3 + "." + KPI12_4);}
//		else {VIPFinancialsPage.contents.KPI12.verifyText(KPI12);}
//		String KPI13 = VIPFinancialsPage.contents.KPI13.getText();
//		if (KPI13 != "N/A") {
//		String[] KPI13_2 = KPI13.split("\\.");
//		String KPI13_3 = KPI13_2[0];
//		String KPI13_4 = KPI13.substring(KPI13.length() - 2);
//		VIPFinancialsPage.contents.KPI13.verifyText(KPI13_3 + "." + KPI13_4);}
//		else {VIPFinancialsPage.contents.KPI13.verifyText(KPI13);}
//		String KPI14 = VIPFinancialsPage.contents.KPI14.getText();
//		if (KPI14 != "N/A") {
//		String[] KPI14_2 = KPI14.split("\\.");
//		String KPI14_3 = KPI14_2[0];
//		String KPI14_4 = KPI14.substring(KPI14.length() - 2);
//		VIPFinancialsPage.contents.KPI14.verifyText(KPI14_3 + "." + KPI14_4);}
//		else {VIPFinancialsPage.contents.KPI14.verifyText(KPI14);}
//		String KPI15 = VIPFinancialsPage.contents.KPI15.getText();
//		if (KPI15 != "N/A") {
//		String[] KPI15_2 = KPI15.split("\\.");
//		String KPI15_3 = KPI15_2[0];
//		String KPI15_4 = KPI15.substring(KPI15.length() - 1);
//		VIPFinancialsPage.contents.KPI15.verifyText(KPI15_3 + "." + KPI15_4);}
//		else {VIPFinancialsPage.contents.KPI15.verifyText(KPI15);}
//		String KPI16 = VIPFinancialsPage.contents.KPI16.getText();
//		if (KPI16 != "N/A") {
//		String[] KPI16_2 = KPI16.split("\\.");
//		String KPI16_3 = KPI16_2[0];
//		String KPI16_4 = KPI16.substring(KPI16.length() - 2);
//		VIPFinancialsPage.contents.KPI16.verifyText(KPI16_3 + "." + KPI16_4);}
//		else {VIPFinancialsPage.contents.KPI16.verifyText(KPI16);}
//		String KPI17 = VIPFinancialsPage.contents.KPI17.getText();
//		if (KPI17 != "N/A") {
//		String[] KPI17_2 = KPI17.split("\\.");
//		String KPI17_3 = KPI17_2[0];
//		String KPI17_4 = KPI17.substring(KPI17.length() - 2);
//		VIPFinancialsPage.contents.KPI17.verifyText(KPI17_3 + "." + KPI17_4);}
//		else {VIPFinancialsPage.contents.KPI17.verifyText(KPI17);}
//		String KPI18 = VIPFinancialsPage.contents.KPI18.getText();
//		if (KPI18 != "N/A") {
//		String[] KPI18_2 = KPI18.split("\\.");
//		String KPI18_3 = KPI18_2[0];
//		String KPI18_4 = KPI18.substring(KPI18.length() - 2);
//		VIPFinancialsPage.contents.KPI18.verifyText(KPI18_3 + "." + KPI18_4);}
//		else {VIPFinancialsPage.contents.KPI18.verifyText(KPI18);}
//		String KPI19 = VIPFinancialsPage.contents.KPI19.getText();
//		if (KPI19 != "N/A") {
//		String[] KPI19_2 = KPI19.split("\\.");
//		String KPI19_3 = KPI19_2[0];
//		String KPI19_4 = KPI19.substring(KPI19.length() - 2);
//		VIPFinancialsPage.contents.KPI19.verifyText(KPI19_3 + "." + KPI19_4);}
//		else {VIPFinancialsPage.contents.KPI19.verifyText(KPI19);}
//		String KPI20 = VIPFinancialsPage.contents.KPI20.getText();
//		if (KPI20 != "N/A") {
//		String[] KPI20_2 = KPI20.split("\\.");
//		String KPI20_3 = KPI20_2[0];
//		String KPI20_4 = KPI20.substring(KPI20.length() - 2);
//		VIPFinancialsPage.contents.KPI20.verifyText(KPI20_3 + "." + KPI20_4);}
//		else {VIPFinancialsPage.contents.KPI20.verifyText(KPI20);}
//		String KPI21 = VIPFinancialsPage.contents.KPI21.getText();
//		if (KPI21 != "N/A") {
//		String[] KPI21_2 = KPI21.split("\\.");
//		String KPI21_3 = KPI21_2[0];
//		String KPI21_4 = KPI21.substring(KPI21.length() - 2);
//		VIPFinancialsPage.contents.KPI21.verifyText(KPI21_3 + "." + KPI21_4);}
//		else {VIPFinancialsPage.contents.KPI21.verifyText(KPI21);}
//		String KPI22 = VIPFinancialsPage.contents.KPI22.getText();
//		if (KPI22 != "N/A") {
//		String[] KPI22_2 = KPI22.split("\\.");
//		String KPI22_3 = KPI22_2[0];
//		String KPI22_4 = KPI22.substring(KPI22.length() - 2);
//		VIPFinancialsPage.contents.KPI22.verifyText(KPI22_3 + "." + KPI22_4);}
//		else {VIPFinancialsPage.contents.KPI22.verifyText(KPI22);}
//		String KPI23 = VIPFinancialsPage.contents.KPI23.getText();
//		if (KPI23 != "N/A") {
//		String[] KPI23_2 = KPI23.split("\\.");
//		String KPI23_3 = KPI23_2[0];
//		String KPI23_4 = KPI23.substring(KPI23.length() - 2);
//		VIPFinancialsPage.contents.KPI23.verifyText(KPI23_3 + "." + KPI23_4);}
//		else {VIPFinancialsPage.contents.KPI23.verifyText(KPI23);}
//		WebControl.takeScreenshot("Q2A_Reg_Auto_020_TARGET");
//		
//		ReportLog.setTestCase("Q2A_Reg_Auto_020_PEER");
//		String KPIP1 = VIPFinancialsPage.contents.KPIP1.getText();
//		if (KPIP1 != "N/A") {
//		String[] KPIP1_2 = KPIP1.split("\\.");
//		String KPIP1_3 = KPIP1_2[0];
//		String KPIP1_4 = KPIP1.substring(KPIP1.length() - 2);
//		VIPFinancialsPage.contents.KPIP1.verifyText(KPIP1_3 + "." + KPIP1_4);}
//		else {VIPFinancialsPage.contents.KPIP1.verifyText(KPIP1);}
//		String KPIP2 = VIPFinancialsPage.contents.KPIP2.getText();
//		if (KPIP2 != "N/A") {
//		String[] KPIP2_2 = KPIP2.split("\\.");
//		String KPIP2_3 = KPIP2_2[0];
//		String KPIP2_4 = KPIP2.substring(KPIP2.length() - 2);
//		VIPFinancialsPage.contents.KPIP2.verifyText(KPIP2_3 + "." + KPIP2_4);}
//		else {VIPFinancialsPage.contents.KPIP2.verifyText(KPIP2);}
//		String KPIP3 = VIPFinancialsPage.contents.KPIP3.getText();
//		if (KPIP3 != "N/A") {
//		String[] KPIP3_2 = KPIP3.split("\\.");
//		String KPIP3_3 = KPIP3_2[0];
//		String KPIP3_4 = KPIP3.substring(KPIP3.length() - 2);
//		VIPFinancialsPage.contents.KPIP3.verifyText(KPIP3_3 + "." + KPIP3_4);}
//		else {VIPFinancialsPage.contents.KPIP3.verifyText(KPIP3);}
//		String KPIP4 = VIPFinancialsPage.contents.KPIP4.getText();
//		if (KPIP4 != "N/A") {
//		String[] KPIP4_2 = KPIP4.split("\\.");
//		String KPIP4_3 = KPIP4_2[0];
//		String KPIP4_4 = KPIP4.substring(KPIP4.length() - 2);
//		VIPFinancialsPage.contents.KPIP4.verifyText(KPIP4_3 + "." + KPIP4_4);}
//		else {VIPFinancialsPage.contents.KPIP4.verifyText(KPIP4);}
//		String KPIP5 = VIPFinancialsPage.contents.KPIP5.getText();
//		if (KPIP5 != "N/A") {
//		String[] KPIP5_2 = KPIP5.split("\\.");
//		String KPIP5_3 = KPIP5_2[0];
//		String KPIP5_4 = KPIP5.substring(KPIP5.length() - 2);
//		VIPFinancialsPage.contents.KPIP5.verifyText(KPIP5_3 + "." + KPIP5_4);}
//		else {VIPFinancialsPage.contents.KPIP5.verifyText(KPIP5);}
//		String KPIP6 = VIPFinancialsPage.contents.KPIP6.getText();
//		if (KPIP6 != "N/A") {
//		String[] KPIP6_2 = KPIP6.split("\\.");
//		String KPIP6_3 = KPIP6_2[0];
//		String KPIP6_4 = KPIP6.substring(KPIP6.length() - 2);
//		VIPFinancialsPage.contents.KPIP6.verifyText(KPIP6_3 + "." + KPIP6_4);}
//		else {VIPFinancialsPage.contents.KPIP6.verifyText(KPIP6);}
//		String KPIP7 = VIPFinancialsPage.contents.KPIP7.getText();
//		if (KPIP7 != "N/A") {
//		String[] KPIP7_2 = KPIP7.split("\\.");
//		String KPIP7_3 = KPIP7_2[0];
//		String KPIP7_4 = KPIP7.substring(KPIP7.length() - 2);
//		VIPFinancialsPage.contents.KPIP7.verifyText(KPIP7_3 + "." + KPIP7_4);}
//		else {VIPFinancialsPage.contents.KPIP7.verifyText(KPIP7);}
//		String KPIP8 = VIPFinancialsPage.contents.KPIP8.getText();
//		if (KPIP8 != "N/A") {
//		String[] KPIP8_2 = KPIP8.split("\\.");
//		String KPIP8_3 = KPIP8_2[0];
//		String KPIP8_4 = KPIP8.substring(KPIP8.length() - 1);
//		VIPFinancialsPage.contents.KPIP8.verifyText(KPIP8_3 + "." + KPIP8_4);}
//		else {VIPFinancialsPage.contents.KPIP8.verifyText(KPIP8);}
//		String KPIP9 = VIPFinancialsPage.contents.KPIP9.getText();
//		if (KPIP9 != "N/A") {
//		String[] KPIP9_2 = KPIP9.split("\\.");
//		String KPIP9_3 = KPIP9_2[0];
//		String KPIP9_4 = KPIP9.substring(KPIP9.length() - 1);
//		VIPFinancialsPage.contents.KPIP9.verifyText(KPIP9_3 + "." + KPIP9_4);}
//		else {VIPFinancialsPage.contents.KPIP9.verifyText(KPIP9);}
//		String KPIP10 = VIPFinancialsPage.contents.KPIP10.getText();
//		if (KPIP10 != "N/A") {
//		String[] KPIP10_2 = KPIP10.split("\\.");
//		String KPIP10_3 = KPIP10_2[0];
//		String KPIP10_4 = KPIP10.substring(KPIP10.length() - 2);
//		VIPFinancialsPage.contents.KPIP10.verifyText(KPIP10_3 + "." + KPIP10_4);}
//		else {VIPFinancialsPage.contents.KPIP10.verifyText(KPIP10);}
//		String KPIP11 = VIPFinancialsPage.contents.KPIP11.getText();
//		if (KPIP11 != "N/A") {
//		String[] KPIP11_2 = KPIP11.split("\\.");
//		String KPIP11_3 = KPIP11_2[0];
//		String KPIP11_4 = KPIP11.substring(KPIP11.length() - 2);
//		VIPFinancialsPage.contents.KPIP11.verifyText(KPIP11_3 + "." + KPIP11_4);}
//		else {VIPFinancialsPage.contents.KPIP11.verifyText(KPIP11);}
//		String KPIP12 = VIPFinancialsPage.contents.KPIP12.getText();
//		if (KPIP12 != "N/A") {
//		String[] KPIP12_2 = KPIP12.split("\\.");
//		String KPIP12_3 = KPIP12_2[0];
//		String KPIP12_4 = KPIP12.substring(KPIP12.length() - 2);
//		VIPFinancialsPage.contents.KPIP12.verifyText(KPIP12_3 + "." + KPIP12_4);}
//		else {VIPFinancialsPage.contents.KPIP12.verifyText(KPIP12);}
//		String KPIP13 = VIPFinancialsPage.contents.KPIP13.getText();
//		if (KPIP13 != "N/A") {
//		String[] KPIP13_2 = KPIP13.split("\\.");
//		String KPIP13_3 = KPIP13_2[0];
//		String KPIP13_4 = KPIP13.substring(KPIP13.length() - 2);
//		VIPFinancialsPage.contents.KPIP13.verifyText(KPIP13_3 + "." + KPIP13_4);}
//		else {VIPFinancialsPage.contents.KPIP13.verifyText(KPIP13);}
//		String KPIP14 = VIPFinancialsPage.contents.KPIP14.getText();
//		if (KPIP14 != "N/A") {
//		String[] KPIP14_2 = KPIP14.split("\\.");
//		String KPIP14_3 = KPIP14_2[0];
//		String KPIP14_4 = KPIP14.substring(KPIP14.length() - 2);
//		VIPFinancialsPage.contents.KPIP14.verifyText(KPIP14_3 + "." + KPIP14_4);}
//		else {VIPFinancialsPage.contents.KPIP14.verifyText(KPIP14);}
//		String KPIP15 = VIPFinancialsPage.contents.KPIP15.getText();
//		if (KPIP15 != "N/A") {
//		String[] KPIP15_2 = KPIP15.split("\\.");
//		String KPIP15_3 = KPIP15_2[0];
//		String KPIP15_4 = KPIP15.substring(KPIP15.length() - 1);
//		VIPFinancialsPage.contents.KPIP15.verifyText(KPIP15_3 + "." + KPIP15_4);}
//		else {VIPFinancialsPage.contents.KPIP15.verifyText(KPIP15);}
//		String KPIP16 = VIPFinancialsPage.contents.KPIP16.getText();
//		if (KPIP16 != "N/A") {
//		String[] KPIP16_2 = KPIP16.split("\\.");
//		String KPIP16_3 = KPIP16_2[0];
//		String KPIP16_4 = KPIP16.substring(KPIP16.length() - 2);
//		VIPFinancialsPage.contents.KPIP16.verifyText(KPIP16_3 + "." + KPIP16_4);}
//		else {VIPFinancialsPage.contents.KPIP16.verifyText(KPIP16);}
//		String KPIP17 = VIPFinancialsPage.contents.KPIP17.getText();
//		if (KPIP17 != "N/A") {
//		String[] KPIP17_2 = KPIP17.split("\\.");
//		String KPIP17_3 = KPIP17_2[0];
//		String KPIP17_4 = KPIP17.substring(KPIP17.length() - 2);
//		VIPFinancialsPage.contents.KPIP17.verifyText(KPIP17_3 + "." + KPIP17_4);}
//		else {VIPFinancialsPage.contents.KPIP17.verifyText(KPIP17);}
//		String KPIP18 = VIPFinancialsPage.contents.KPIP18.getText();
//		if (KPIP18 != "N/A") {
//		String[] KPIP18_2 = KPIP18.split("\\.");
//		String KPIP18_3 = KPIP18_2[0];
//		String KPIP18_4 = KPIP18.substring(KPIP18.length() - 2);
//		VIPFinancialsPage.contents.KPIP18.verifyText(KPIP18_3 + "." + KPIP18_4);}
//		else {VIPFinancialsPage.contents.KPIP18.verifyText(KPIP18);}
//		String KPIP19 = VIPFinancialsPage.contents.KPIP19.getText();
//		if (KPIP19 != "N/A") {
//		String[] KPIP19_2 = KPIP19.split("\\.");
//		String KPIP19_3 = KPIP19_2[0];
//		String KPIP19_4 = KPIP19.substring(KPIP19.length() - 2);
//		VIPFinancialsPage.contents.KPIP19.verifyText(KPIP19_3 + "." + KPIP19_4);}
//		else {VIPFinancialsPage.contents.KPIP19.verifyText(KPIP19);}
//		String KPIP20 = VIPFinancialsPage.contents.KPIP20.getText();
//		if (KPIP20 != "N/A") {
//		String[] KPIP20_2 = KPIP20.split("\\.");
//		String KPIP20_3 = KPIP20_2[0];
//		String KPIP20_4 = KPIP20.substring(KPIP20.length() - 2);
//		VIPFinancialsPage.contents.KPIP20.verifyText(KPIP20_3 + "." + KPIP20_4);}
//		else {VIPFinancialsPage.contents.KPIP20.verifyText(KPIP20);}
//		String KPIP21 = VIPFinancialsPage.contents.KPIP21.getText();
//		if (KPIP21 != "N/A") {
//		String[] KPIP21_2 = KPIP21.split("\\.");
//		String KPIP21_3 = KPIP21_2[0];
//		String KPIP21_4 = KPIP21.substring(KPIP21.length() - 2);
//		VIPFinancialsPage.contents.KPIP21.verifyText(KPIP21_3 + "." + KPIP21_4);}
//		else {VIPFinancialsPage.contents.KPIP21.verifyText(KPIP21);}
//		String KPIP22 = VIPFinancialsPage.contents.KPIP22.getText();
//		if (KPIP22 != "N/A") {
//		String[] KPIP22_2 = KPIP22.split("\\.");
//		String KPIP22_3 = KPIP22_2[0];
//		String KPIP22_4 = KPIP22.substring(KPIP22.length() - 2);
//		VIPFinancialsPage.contents.KPIP22.verifyText(KPIP22_3 + "." + KPIP22_4);}
//		else {VIPFinancialsPage.contents.KPIP22.verifyText(KPIP22);}
//		String KPIP23 = VIPFinancialsPage.contents.KPIP23.getText();
//		if (KPIP23 != "N/A") {
//		String[] KPIP23_2 = KPIP23.split("\\.");
//		String KPIP23_3 = KPIP23_2[0];
//		String KPIP23_4 = KPIP23.substring(KPIP23.length() - 2);
//		VIPFinancialsPage.contents.KPIP23.verifyText(KPIP23_3 + "." + KPIP23_4);}
//		else {VIPFinancialsPage.contents.KPIP23.verifyText(KPIP23);}
//		WebControl.takeScreenshot("Q2A_Reg_Auto_020_PEER");
//		
//		ReportLog.setTestCase("Q2A_Reg_Auto_020_BEST");
//		String KPIB1 = VIPFinancialsPage.contents.KPIB1.getText();
//		if (KPIB1 != "N/A") {
//		String[] KPIB1_2 = KPIB1.split("\\.");
//		String KPIB1_3 = KPIB1_2[0];
//		String KPIB1_4 = KPIB1.substring(KPIB1.length() - 2);
//		VIPFinancialsPage.contents.KPIB1.verifyText(KPIB1_3 + "." + KPIB1_4);}
//		else {VIPFinancialsPage.contents.KPIB1.verifyText(KPIB1);}
//		String KPIB2 = VIPFinancialsPage.contents.KPIB2.getText();
//		if (KPIB2 != "N/A") {
//		String[] KPIB2_2 = KPIB2.split("\\.");
//		String KPIB2_3 = KPIB2_2[0];
//		String KPIB2_4 = KPIB2.substring(KPIB2.length() - 2);
//		VIPFinancialsPage.contents.KPIB2.verifyText(KPIB2_3 + "." + KPIB2_4);}
//		else {VIPFinancialsPage.contents.KPIB2.verifyText(KPIB2);}
//		String KPIB3 = VIPFinancialsPage.contents.KPIB3.getText();
//		if (KPIB3 != "N/A") {
//		String[] KPIB3_2 = KPIB3.split("\\.");
//		String KPIB3_3 = KPIB3_2[0];
//		String KPIB3_4 = KPIB3.substring(KPIB3.length() - 2);
//		VIPFinancialsPage.contents.KPIB3.verifyText(KPIB3_3 + "." + KPIB3_4);}
//		else {VIPFinancialsPage.contents.KPIB3.verifyText(KPIB3);}
//		String KPIB4 = VIPFinancialsPage.contents.KPIB4.getText();
//		if (KPIB4 != "N/A") {
//		String[] KPIB4_2 = KPIB4.split("\\.");
//		String KPIB4_3 = KPIB4_2[0];
//		String KPIB4_4 = KPIB4.substring(KPIB4.length() - 2);
//		VIPFinancialsPage.contents.KPIB4.verifyText(KPIB4_3 + "." + KPIB4_4);}
//		else {VIPFinancialsPage.contents.KPIB4.verifyText(KPIB4);}
//		String KPIB5 = VIPFinancialsPage.contents.KPIB5.getText();
//		if (KPIB5 != "N/A") {
//		String[] KPIB5_2 = KPIB5.split("\\.");
//		String KPIB5_3 = KPIB5_2[0];
//		String KPIB5_4 = KPIB5.substring(KPIB5.length() - 2);
//		VIPFinancialsPage.contents.KPIB5.verifyText(KPIB5_3 + "." + KPIB5_4);}
//		else {VIPFinancialsPage.contents.KPIB5.verifyText(KPIB5);}
//		String KPIB6 = VIPFinancialsPage.contents.KPIB6.getText();
//		if (KPIB6 != "N/A") {
//		String[] KPIB6_2 = KPIB6.split("\\.");
//		String KPIB6_3 = KPIB6_2[0];
//		String KPIB6_4 = KPIB6.substring(KPIB6.length() - 2);
//		VIPFinancialsPage.contents.KPIB6.verifyText(KPIB6_3 + "." + KPIB6_4);}
//		else {VIPFinancialsPage.contents.KPIB6.verifyText(KPIB6);}
//		String KPIB7 = VIPFinancialsPage.contents.KPIB7.getText();
//		if (KPIB7 != "N/A") {
//		String[] KPIB7_2 = KPIB7.split("\\.");
//		String KPIB7_3 = KPIB7_2[0];
//		String KPIB7_4 = KPIB7.substring(KPIB7.length() - 2);
//		VIPFinancialsPage.contents.KPIB7.verifyText(KPIB7_3 + "." + KPIB7_4);}
//		else {VIPFinancialsPage.contents.KPIB7.verifyText(KPIB7);}
//		String KPIB8 = VIPFinancialsPage.contents.KPIB8.getText();
//		if (KPIB8 != "N/A") {
//		String[] KPIB8_2 = KPIB8.split("\\.");
//		String KPIB8_3 = KPIB8_2[0];
//		String KPIB8_4 = KPIB8.substring(KPIB8.length() - 1);
//		VIPFinancialsPage.contents.KPIB8.verifyText(KPIB8_3 + "." + KPIB8_4);}
//		else {VIPFinancialsPage.contents.KPIB8.verifyText(KPIB8);}
//		String KPIB9 = VIPFinancialsPage.contents.KPIB9.getText();
//		if (KPIB9 != "N/A") {
//		String[] KPIB9_2 = KPIB9.split("\\.");
//		String KPIB9_3 = KPIB9_2[0];
//		String KPIB9_4 = KPIB9.substring(KPIB9.length() - 1);
//		VIPFinancialsPage.contents.KPIB9.verifyText(KPIB9_3 + "." + KPIB9_4);}
//		else {VIPFinancialsPage.contents.KPIB9.verifyText(KPIB9);}
//		String KPIB10 = VIPFinancialsPage.contents.KPIB10.getText();
//		if (KPIB10 != "N/A") {
//		String[] KPIB10_2 = KPIB10.split("\\.");
//		String KPIB10_3 = KPIB10_2[0];
//		String KPIB10_4 = KPIB10.substring(KPIB10.length() - 2);
//		VIPFinancialsPage.contents.KPIB10.verifyText(KPIB10_3 + "." + KPIB10_4);}
//		else {VIPFinancialsPage.contents.KPIB10.verifyText(KPIB10);}
//		String KPIB11 = VIPFinancialsPage.contents.KPIB11.getText();
//		if (KPIB11 != "N/A") {
//		String[] KPIB11_2 = KPIB11.split("\\.");
//		String KPIB11_3 = KPIB11_2[0];
//		String KPIB11_4 = KPIB11.substring(KPIB11.length() - 2);
//		VIPFinancialsPage.contents.KPIB11.verifyText(KPIB11_3 + "." + KPIB11_4);}
//		else {VIPFinancialsPage.contents.KPIB11.verifyText(KPIB11);}
//		String KPIB12 = VIPFinancialsPage.contents.KPIB12.getText();
//		if (KPIB12 != "N/A") {
//		String[] KPIB12_2 = KPIB12.split("\\.");
//		String KPIB12_3 = KPIB12_2[0];
//		String KPIB12_4 = KPIB12.substring(KPIB12.length() - 2);
//		VIPFinancialsPage.contents.KPIB12.verifyText(KPIB12_3 + "." + KPIB12_4);}
//		else {VIPFinancialsPage.contents.KPIB12.verifyText(KPIB12);}
//		String KPIB13 = VIPFinancialsPage.contents.KPIB13.getText();
//		if (KPIB13 != "N/A") {
//		String[] KPIB13_2 = KPIB13.split("\\.");
//		String KPIB13_3 = KPIB13_2[0];
//		String KPIB13_4 = KPIB13.substring(KPIB13.length() - 2);
//		VIPFinancialsPage.contents.KPIB13.verifyText(KPIB13_3 + "." + KPIB13_4);}
//		else {VIPFinancialsPage.contents.KPIB13.verifyText(KPIB13);}
//		String KPIB14 = VIPFinancialsPage.contents.KPIB14.getText();
//		if (KPIB14 != "N/A") {
//		String[] KPIB14_2 = KPIB14.split("\\.");
//		String KPIB14_3 = KPIB14_2[0];
//		String KPIB14_4 = KPIB14.substring(KPIB14.length() - 2);
//		VIPFinancialsPage.contents.KPIB14.verifyText(KPIB14_3 + "." + KPIB14_4);}
//		else {VIPFinancialsPage.contents.KPIB14.verifyText(KPIB14);}
//		String KPIB15 = VIPFinancialsPage.contents.KPIB15.getText();
//		if (KPIB15 != "N/A") {
//		String[] KPIB15_2 = KPIB15.split("\\.");
//		String KPIB15_3 = KPIB15_2[0];
//		String KPIB15_4 = KPIB15.substring(KPIB15.length() - 1);
//		VIPFinancialsPage.contents.KPIB15.verifyText(KPIB15_3 + "." + KPIB15_4);}
//		else {VIPFinancialsPage.contents.KPIB15.verifyText(KPIB15);}
//		String KPIB16 = VIPFinancialsPage.contents.KPIB16.getText();
//		if (KPIB16 != "N/A") {
//		String[] KPIB16_2 = KPIB16.split("\\.");
//		String KPIB16_3 = KPIB16_2[0];
//		String KPIB16_4 = KPIB16.substring(KPIB16.length() - 2);
//		VIPFinancialsPage.contents.KPIB16.verifyText(KPIB16_3 + "." + KPIB16_4);}
//		else {VIPFinancialsPage.contents.KPIB16.verifyText(KPIB16);}
//		String KPIB17 = VIPFinancialsPage.contents.KPIB17.getText();
//		if (KPIB17 != "N/A") {
//		String[] KPIB17_2 = KPIB17.split("\\.");
//		String KPIB17_3 = KPIB17_2[0];
//		String KPIB17_4 = KPIB17.substring(KPIB17.length() - 2);
//		VIPFinancialsPage.contents.KPIB17.verifyText(KPIB17_3 + "." + KPIB17_4);}
//		else {VIPFinancialsPage.contents.KPIB17.verifyText(KPIB17);}
//		String KPIB18 = VIPFinancialsPage.contents.KPIB18.getText();
//		if (KPIB18 != "N/A") {
//		String[] KPIB18_2 = KPIB18.split("\\.");
//		String KPIB18_3 = KPIB18_2[0];
//		String KPIB18_4 = KPIB18.substring(KPIB18.length() - 2);
//		VIPFinancialsPage.contents.KPIB18.verifyText(KPIB18_3 + "." + KPIB18_4);}
//		else {VIPFinancialsPage.contents.KPIB18.verifyText(KPIB18);}
//		String KPIB19 = VIPFinancialsPage.contents.KPIB19.getText();
//		if (KPIB19 != "N/A") {
//		String[] KPIB19_2 = KPIB19.split("\\.");
//		String KPIB19_3 = KPIB19_2[0];
//		String KPIB19_4 = KPIB19.substring(KPIB19.length() - 2);
//		VIPFinancialsPage.contents.KPIB19.verifyText(KPIB19_3 + "." + KPIB19_4);}
//		else {VIPFinancialsPage.contents.KPIB19.verifyText(KPIB19);}
//		String KPIB20 = VIPFinancialsPage.contents.KPIB20.getText();
//		if (KPIB20 != "N/A") {
//		String[] KPIB20_2 = KPIB20.split("\\.");
//		String KPIB20_3 = KPIB20_2[0];
//		String KPIB20_4 = KPIB20.substring(KPIB20.length() - 2);
//		VIPFinancialsPage.contents.KPIB20.verifyText(KPIB20_3 + "." + KPIB20_4);}
//		else {VIPFinancialsPage.contents.KPIB20.verifyText(KPIB20);}
//		String KPIB21 = VIPFinancialsPage.contents.KPIB21.getText();
//		if (KPIB21 != "N/A") {
//		String[] KPIB21_2 = KPIB21.split("\\.");
//		String KPIB21_3 = KPIB21_2[0];
//		String KPIB21_4 = KPIB21.substring(KPIB21.length() - 2);
//		VIPFinancialsPage.contents.KPIB21.verifyText(KPIB21_3 + "." + KPIB21_4);}
//		else {VIPFinancialsPage.contents.KPIB21.verifyText(KPIB21);}
//		String KPIB22 = VIPFinancialsPage.contents.KPIB22.getText();
//		if (KPIB22 != "N/A") {
//		String[] KPIB22_2 = KPIB22.split("\\.");
//		String KPIB22_3 = KPIB22_2[0];
//		String KPIB22_4 = KPIB22.substring(KPIB22.length() - 2);
//		VIPFinancialsPage.contents.KPIB22.verifyText(KPIB22_3 + "." + KPIB22_4);}
//		else {VIPFinancialsPage.contents.KPIB22.verifyText(KPIB22);}
//		String KPIB23 = VIPFinancialsPage.contents.KPIB23.getText();
//		if (KPIB23 != "N/A") {
//		String[] KPIB23_2 = KPIB23.split("\\.");
//		String KPIB23_3 = KPIB23_2[0];
//		String KPIB23_4 = KPIB23.substring(KPIB23.length() - 2);
//		VIPFinancialsPage.contents.KPIB23.verifyText(KPIB23_3 + "." + KPIB23_4);}
//		else {VIPFinancialsPage.contents.KPIB23.verifyText(KPIB23);}
//		WebControl.takeScreenshot("Q2A_Reg_Auto_020_BEST");
		
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		VIPLandingPage.contents.HelpIcon.hover();
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
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
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
		
//		if (VIPFinancialsPage.contents.TRSFootNoteCompanies.isDisplayed()) {
//		ReportLog.setTestCase("Q2A_Reg_Auto_030_TRSFootnote");
//		VIPFinancialsPage.contents.TRSFootNoteCompanies.verifyDisplayed(true, 10);
//		String TRSCP1 = VIPFinancialsPage.contents.TRSCompetitivePosition1.getText();
//		String TRSCP2 = VIPFinancialsPage.contents.TRSCompetitivePosition2.getText();
//		String TRSFootNoteCompanies = VIPFinancialsPage.contents.TRSFootNoteCompanies.getText();
//		WebControl.takeScreenshot("Q2A_Reg_Auto_030_TRSFootnote");
//		
//		ReportLog.setTestCase("Q2A_Reg_Auto_032");
//		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
//		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
//		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
//		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
//		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
//		Thread.sleep(2000);
//		VIPLandingPage.contents.StartNowButton.click();
//		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
//		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
//		VIPLandingPage.contents.DisclaimerProceedButton.click();
//		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
//		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
//		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
//		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
//		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
//		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
//		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
//		VIPLandingPage.contents.DisclaimerProceedButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
//		else { VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
//		Thread.sleep(2000);
//		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
//		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
//		Thread.sleep(1500);
//		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
//		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
//		Thread.sleep(3000);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
//		VIPOverviewPage.contents.FinancialsTitle.hover();
//		Thread.sleep(3000);
//		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
//		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
//		VIPFinancialsPage.contents.SelectDropDown2.click();
//		VIPFinancialsPage.contents.TRSCompetitivePosition1.verifyText(TRSCP1);
//		VIPFinancialsPage.contents.TRSCompetitivePosition2.verifyText(TRSCP2);
//		VIPFinancialsPage.contents.TRSFootNoteCompanies.verifyText(TRSFootNoteCompanies);
//		WebControl.takeScreenshot("Q2A_Reg_Auto_032");
//		WebControl.close();
//		WebControl.switchWithUrl(testDataHandler.site);}}
//		
//		else {
//		ReportLog.setTestCase("Q2A_Reg_Auto_030_TRSFootnote");
//		VIPFinancialsPage.contents.TRSFootNoteCompanies.verifyDisplayed(false);
//		String TRSCP1 = VIPFinancialsPage.contents.TRSCompetitivePosition1.getText();
//		String TRSCP2 = VIPFinancialsPage.contents.TRSCompetitivePosition2.getText();
//		WebControl.takeScreenshot("Q2A_Reg_Auto_030_TRSFootnote");
//		
//		ReportLog.setTestCase("Q2A_Reg_Auto_032");
//		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
//		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
//		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
//		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
//		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
//		Thread.sleep(2000);
//		VIPLandingPage.contents.StartNowButton.click();
//		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
//		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
//		VIPLandingPage.contents.DisclaimerProceedButton.click();
//		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
//		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
//		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
//		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
//		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
//		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
//		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
//		VIPLandingPage.contents.DisclaimerProceedButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
//		else { VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
//		Thread.sleep(2000);
//		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
//		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
//		Thread.sleep(1500);
//		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
//		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
//		Thread.sleep(3000);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
//		VIPOverviewPage.contents.FinancialsTitle.hover();
//		Thread.sleep(3000);
//		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
//		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
//		VIPFinancialsPage.contents.SelectDropDown2.click();
//		VIPFinancialsPage.contents.TRSCompetitivePosition1.verifyText(TRSCP1);
//		VIPFinancialsPage.contents.TRSCompetitivePosition2.verifyText(TRSCP2);
//		WebControl.takeScreenshot("Q2A_Reg_Auto_032");
//		WebControl.close();
//		WebControl.switchWithUrl(testDataHandler.site);}}
		
	}
	
	@Test(priority=4)
	public void Q2A_EVICDecomposition () throws Exception {
		ReportLog.setTestName("Financials - EVIC Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
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
		VIPFinancialsPage.contents.EvicFootNoteCompanies.verifyText("Note: EBIT / IC uses invested capital value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
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
		String[] RPEFootNote1_1 = VIPFinancialsPage.contents.RPEFootNoteForecast.getText().split("\\s");
		int RPEFootNote1 = Integer.parseInt(RPEFootNote1_1[8].replace(".and", ""));
		VIPFinancialsPage.contents.RPELeftChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPELeftChartDate.verifyText("[" + RPEFootNote1 + "E - " + (RPEFootNote1 + 2) + "E]" );
		VIPFinancialsPage.contents.RPERightChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPERightChartDate.verifyText("[" + RPEFootNote1 + "E - " + (RPEFootNote1 + 2) + "E]" );
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
		String[] RPEFootNote2_1 = VIPFinancialsPage.contents.RPEFootNoteForecast.getText().split("\\s");
		int RPEFootNote2 = Integer.parseInt(RPEFootNote2_1[8].replace(".and", ""));
		VIPFinancialsPage.contents.RPELeftChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPELeftChartDate.verifyText("[" + RPEFootNote2 + "E - " + (RPEFootNote2 + 2) + "E]" );
		VIPFinancialsPage.contents.RPERightChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPERightChartDate.verifyText("[" + RPEFootNote2 + "E - " + (RPEFootNote2 + 2) + "E]" );
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
		String[] RPEFootNote3_1 = VIPFinancialsPage.contents.RPEFootNoteForecast.getText().split("\\s");
		int RPEFootNote3 = Integer.parseInt(RPEFootNote3_1[8].replace(".and", ""));
		VIPFinancialsPage.contents.RPELeftChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPELeftChartDate.verifyText("[" + RPEFootNote3 + "E - " + (RPEFootNote3 + 2) + "E]" );
		VIPFinancialsPage.contents.RPERightChartDate.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.RPERightChartDate.verifyText("[" + RPEFootNote3 + "E - " + (RPEFootNote3 + 2) + "E]" );
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_059");	
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		//Period
		VIPFinancialsPage.contents.ScoreCardDate.waitForExist(true, 20);
		String[] Period1 = VIPFinancialsPage.contents.ScoreCardDate.getText().split("\\s");
		String Period = Period1[0].replace("[", ""); // TTM or FY
		String PeriodYrMon = Period1[2].replace("]", ""); // 12/2020
		String[] PeriodYr1 = PeriodYrMon.split("\\/");
		int PeriodYr = Integer.parseInt(PeriodYr1[1]); // 2020
		String PeriodMon = PeriodYr1[0]; // 12
		
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
		String RG5YrRevCAGR_1 = RG5YrRevCAGR.substring(4, 6);
		String RG3YrRevCAGR = VIPFinancialsPage.contents.RG3YrRevCAGRPeriod.getText();
		String RG3YrRevCAGR_1 = RG3YrRevCAGR.substring(4, 6);
		String RG1YrRevCAGR = VIPFinancialsPage.contents.RG1YrRevCAGRPeriod.getText();
		String RG1YrRevCAGR_1 = RG1YrRevCAGR.substring(4, 6);
		
		VIPFinancialsPage.contents.RG5YrRevCAGRPeriod.verifyText("[FY-" + RG5YrRevCAGR_1 + "/" + (PeriodYr - 5) + " - " + Period + "-" + PeriodYrMon + "]");
		VIPFinancialsPage.contents.RG3YrRevCAGRPeriod.verifyText("[FY-" + RG3YrRevCAGR_1 + "/" + (PeriodYr - 3) + " - " + Period + "-" + PeriodYrMon + "]");
		VIPFinancialsPage.contents.RG1YrRevCAGRPeriod.verifyText("[FY-" + RG1YrRevCAGR_1 + "/" + (PeriodYr - 1) + " - " + Period + "-" + PeriodYrMon + "]");
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
		if (CAGR1YrKPI < 0) {
			if (CAGR1YrKPI < CAGR1YrKPIP) {
				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("In the last 1 year, the company’s revenue shrunk by " + CAGR1YrKPIAbs + "%" + " (trailing the peer median of " + CAGR1YrKPIP + "%)");
				VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);
			}
			else {
				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("In the last 1 year, the company’s revenue shrunk by " + CAGR1YrKPIAbs + "%" + " (exceeding the peer median of " + CAGR1YrKPIP + "%)");
				VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);
			}
		}
		else {
			if (CAGR1YrKPI < CAGR1YrKPIP) {
				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("In the last 1 year, the company’s revenue grew by " + CAGR1YrKPIAbs + "%" + " (trailing the peer median of " + CAGR1YrKPIP + "%)");
				VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);
			}
			else {
				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("In the last 1 year, the company’s revenue grew by " + CAGR1YrKPIAbs + "%" + " (exceeding the peer median of " + CAGR1YrKPIP + "%)");
				VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);
			}
		}
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
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
		VIPLandingPage.contents.HelpIcon.hover();
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
		//Period
		VIPFinancialsPage.contents.ScoreCardDate.waitForExist(true, 20);
		String[] Period1 = VIPFinancialsPage.contents.ScoreCardDate.getText().split("\\s");
		String Period = Period1[0].replace("[", ""); // TTM or FY
		String PeriodYrMon = Period1[2].replace("]", ""); // 12/2020
		String[] PeriodYr1 = PeriodYrMon.split("\\/");
		int PeriodYr = Integer.parseInt(PeriodYr1[1]); // 2020
		int Period_1 = PeriodYr - 1;
		int Period_2 = PeriodYr - 2;
		String Period_yr = Integer.toString(PeriodYr);
		String Period_1yr = Integer.toString(Period_1);
		String Period_2yr = Integer.toString(Period_2);
		//ROICKPI & ROICKPIP
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
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.FirstPeriodHeader.verifyText(Period_2yr);
		VIPFinancialsPage.contents.SecondPeriodHeader.verifyText(Period_1yr);
		if (Period.equals("TTM")) {
		VIPFinancialsPage.contents.ThirdPeriodHeader.verifyText("TTM");}
		if (Period.equals("FY")) {
		VIPFinancialsPage.contents.ThirdPeriodHeader.verifyText(Period_yr);}
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
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_Test Data Prep");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		//VIPFinancialsPage.contents.BestandRankCheckbox.click();
		//--Test Data Creation Part--
		//Year Period
		String CurrentYear_1 = VIPFinancialsPage.contents.ScoreCardDate.getText();
		String CurrentYear_2[] = CurrentYear_1.split("\\/");
		String CurrentYear_3 = CurrentYear_2[1].replace("]", "");
		int CurrentYear = Integer.parseInt(CurrentYear_3);
		int LastYear = CurrentYear - 1;
		int Last2Year = CurrentYear - 2;
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
		Double ROICRank3_3 = (ROICRank3_1/ROICRank3_2);
		BigDecimal ROICRank3_4 = new BigDecimal(ROICRank3_3);
		BigDecimal ROICRank3_5 = ROICRank3_4.setScale(2, BigDecimal.ROUND_HALF_UP);
		Double ROICRank3  = ROICRank3_5.doubleValue();
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
		Double EBITMarginRank3_3 = (EBITMarginRank3_1/EBITMarginRank3_2);
		BigDecimal EBITMarginRank3_4 = new BigDecimal(EBITMarginRank3_3);
		BigDecimal EBITMarginRank3_5 = EBITMarginRank3_4.setScale(2, BigDecimal.ROUND_HALF_UP);
		Double EBITMarginRank3  = EBITMarginRank3_5.doubleValue();
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
		Double CapitalEfficiencyRank3_3 = (CapitalEfficiencyRank3_1/CapitalEfficiencyRank3_2);
		BigDecimal CapitalEfficiencyRank3_4 = new BigDecimal(CapitalEfficiencyRank3_3);
		BigDecimal CapitalEfficiencyRank3_5 = CapitalEfficiencyRank3_4.setScale(2, BigDecimal.ROUND_HALF_UP);
		Double CapitalEfficiencyRank3  = CapitalEfficiencyRank3_5.doubleValue();
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
		Double COGSRank3_3 = (COGSRank3_1/COGSRank3_2);
		BigDecimal COGSRank3_4 = new BigDecimal(COGSRank3_3);
		BigDecimal COGSRank3_5 = COGSRank3_4.setScale(2, BigDecimal.ROUND_HALF_UP);
		Double COGSRank3  = COGSRank3_5.doubleValue();
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
		Double SGARank3_3 = (SGARank3_1/SGARank3_2);
		BigDecimal SGARank3_4 = new BigDecimal(SGARank3_3);
		BigDecimal SGARank3_5 = SGARank3_4.setScale(2, BigDecimal.ROUND_HALF_UP);
		Double SGARank3  = SGARank3_5.doubleValue();
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
		Double OpeWorCapRank3_3 = (OpeWorCapRank3_1/OpeWorCapRank3_2);
		BigDecimal OpeWorCapRank3_4 = new BigDecimal(OpeWorCapRank3_3);
		BigDecimal OpeWorCapRank3_5 = OpeWorCapRank3_4.setScale(2, BigDecimal.ROUND_HALF_UP);
		Double OpeWorCapRank3  = OpeWorCapRank3_5.doubleValue();
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
		Double NetPPERank3_3 = (NetPPERank3_1/NetPPERank3_2);
		BigDecimal NetPPERank3_4 = new BigDecimal(NetPPERank3_3);
		BigDecimal NetPPERank3_5 = NetPPERank3_4.setScale(2, BigDecimal.ROUND_HALF_UP);
		Double NetPPERank3  = NetPPERank3_5.doubleValue();
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
		Double GoodWillIntRank3_3 = (GoodWillIntRank3_1/GoodWillIntRank3_2);
		BigDecimal GoodWillIntRank3_4 = new BigDecimal(GoodWillIntRank3_3);
		BigDecimal GoodWillIntRank3_5 = GoodWillIntRank3_4.setScale(2, BigDecimal.ROUND_HALF_UP);
		Double GoodWillIntRank3  = GoodWillIntRank3_5.doubleValue();
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
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_Test Data Prep");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_ROIC");
		//ROIC
		VIPFinancialsPage.contents.ROICBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (ROIC2YrChange6 < 0) {	
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC decreased by " + ROIC2YrChange5 + " pps over the last 2 years from " + ROICKPIP_2YrChange_2 + "% in " + Last2Year + " to " + ROICKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC decreased by " + ROIC2YrChange5 + " pps over the last 2 years from " + ROICKPIP_2YrChange_2 + "% in " + Last2Year + " to " + ROICKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (ROIC2YrChange6 > 0) {		
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC increased by " + ROIC2YrChange5 + " pps over the last 2 years from " + ROICKPIP_2YrChange_4 + "% in " + Last2Year + " to " + ROICKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC increased by " + ROIC2YrChange5 + " pps over the last 2 years from " + ROICKPIP_2YrChange_4 + "% in " + Last2Year + " to " + ROICKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC remained constant at " + ROICKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (ROICKPI2_3 > ROICKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s ROIC in TTM is higher than the peer median of " + ROICKPIP2_3 + "%" + " by " + ROICKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s ROIC in " + PeriodYr + " is higher than the peer median of " + ROICKPIP2_3 + "%" + " by " + ROICKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else if (ROICKPI2_3 < ROICKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s ROIC in TTM is lower than the peer median of " + ROICKPIP2_3 + "%" + " by " + ROICKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s ROIC in " + PeriodYr + " is lower than the peer median of " + ROICKPIP2_3 + "%" + " by " + ROICKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s ROIC in TTM is " + ROICKPIP2_3 + "%" + ", same as the peer median");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s ROIC in " + PeriodYr + " is " + ROICKPIP2_3 + "%" + ", same as the peer median");}
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
		if (Period.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(ROICBest1_3 + " (" + ROICBest3 + "%) " + "ranked the best in terms of ROIC in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(ROICBest1_3 + " (" + ROICBest3 + "%) " + "ranked the best in terms of ROIC in " + PeriodYr);}
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote3.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: EBIT / IC uses invested capital value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + " EBIT / IC uses invested capital value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String ROICSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String ROICCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String ROICCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String ROICBest = VIPFinancialsPage.contents.BestInClass.getText();
		String ROICFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_ROIC");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_EBIT Margin");
		//EBITMargin
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (EBITMargin2YrChange6 < 0) {		
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin decreased by " + EBITMargin2YrChange5 + " pps over the last 2 years from " + EBITMarginKPIP_2YrChange_2 + "% in " + Last2Year + " to " + EBITMarginKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin decreased by " + EBITMargin2YrChange5 + " pps over the last 2 years from " + EBITMarginKPIP_2YrChange_2 + "% in " + Last2Year + " to " + EBITMarginKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (EBITMargin2YrChange6 > 0) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin increased by " + EBITMargin2YrChange5 + " pps over the last 2 years from " + EBITMarginKPIP_2YrChange_4 + "% in " + Last2Year + " to " + EBITMarginKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin increased by " + EBITMargin2YrChange5 + " pps over the last 2 years from " + EBITMarginKPIP_2YrChange_4 + "% in " + Last2Year + " to " + EBITMarginKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin remained constant at " + EBITMarginKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (EBITMarginKPI2_3 > EBITMarginKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s operating margin in TTM is higher than the peer median of " + EBITMarginKPIP2_3 + "%" + " by " + EBITMarginKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s operating margin in " + PeriodYr + " is higher than the peer median of " + EBITMarginKPIP2_3 + "%" + " by " + EBITMarginKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else if (EBITMarginKPI2_3 < EBITMarginKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s operating margin in TTM is lower than the peer median of " + EBITMarginKPIP2_3 + "%" + " by " + EBITMarginKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s operating margin in " + PeriodYr + " is lower than the peer median of " + EBITMarginKPIP2_3 + "%" + " by " + EBITMarginKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s operating margin in TTM is " + EBITMarginKPIP2_3 + "%" + ", same as the peer median");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s operating margin in " + PeriodYr + " is " + EBITMarginKPIP2_3 + "%" + ", same as the peer median");}
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
		if (Period.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(EBITMarginBest1_3 + " (" + EBITMarginBest3 + "%) " + "ranked the best in terms of operating margin in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(EBITMarginBest1_3 + " (" + EBITMarginBest3 + "%) " + "ranked the best in terms of operating margin in " + PeriodYr);}
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote2.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String EBITSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String EBITCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String EBITCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String EBITBest = VIPFinancialsPage.contents.BestInClass.getText();
		String EBITFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_EBIT Margin");
		
//		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_Capital Efficiency");
//		//CapitalEfficiency
//		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.click();
//		//Stand Alone
//		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
//		String[] CEStandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText().split("\\s");
//		Double CEStandalonePerf1 = Double.parseDouble(CEStandalonePerf[CEStandalonePerf.length - 14]);
//		Double CEStandalonePerf2 = Double.parseDouble(CEStandalonePerf[CEStandalonePerf.length - 7]);
//		Double CEStandalonePerf3 = Double.parseDouble(CEStandalonePerf[CEStandalonePerf.length - 3]);
//		DecimalFormat df = new DecimalFormat("#.#");
//		String SP1_1 = df.format(CEStandalonePerf1);
//		BigDecimal SP2_1 = new BigDecimal(CEStandalonePerf2);
//		BigDecimal SP2_2 = SP2_1.setScale(1, BigDecimal.ROUND_HALF_UP);
//		String SP3_1 = df.format(CEStandalonePerf3);
//		if (CapitalEfficiency2YrChange6 < 0) {		
//			if (CapitalEfficiency2YrChange5.equals(Double.parseDouble(SP1_1)) & CapitalEfficiencyKPIP_2YrChange_2.equals(SP2_2) & CapitalEfficiencyKPI2_3.equals(Double.parseDouble(SP3_1))) {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency decreased by " + CEStandalonePerf1 + " over the last 2 years from " + CEStandalonePerf2 + " in " + Last2Year + " to " + CEStandalonePerf3 + " in TTM");}
//				else {
//				VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency decreased by " + CEStandalonePerf1 + " over the last 2 years from " + CEStandalonePerf2 + " in " + Last2Year + " to " + CEStandalonePerf3 + " in " + PeriodYr);}
//			VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
//			else {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency decreased by " + CapitalEfficiency2YrChange5 + " over the last 2 years from " + CapitalEfficiencyKPIP_2YrChange_2 + " in " + Last2Year + " to " + CapitalEfficiencyKPI2_3 + " in TTM");}
//				else {
//				VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency decreased by " + CapitalEfficiency2YrChange5 + " over the last 2 years from " + CapitalEfficiencyKPIP_2YrChange_2 + " in " + Last2Year + " to " + CapitalEfficiencyKPI2_3 + " in " + PeriodYr);}
//			VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
//		}
//		else if (CapitalEfficiency2YrChange6 > 0) {	
//			if (CapitalEfficiency2YrChange5.equals(Double.parseDouble(SP1_1)) & CapitalEfficiencyKPIP_2YrChange_2.equals(SP2_2) & CapitalEfficiencyKPI2_3.equals(Double.parseDouble(SP3_1))) {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency increased by " + CEStandalonePerf1 + " over the last 2 years from " + CEStandalonePerf2 + " in " + Last2Year + " to " + CEStandalonePerf3 + " in TTM");}
//				else {
//				VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency increased by " + CEStandalonePerf1 + " over the last 2 years from " + CEStandalonePerf2 + " in " + Last2Year + " to " + CEStandalonePerf3 + " in " + PeriodYr);}
//			VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
//			else {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency increased by " + CapitalEfficiency2YrChange5 + " over the last 2 years from " + CapitalEfficiencyKPIP_2YrChange_4 + " in " + Last2Year + " to " + CapitalEfficiencyKPI2_3 + " in TTM");}
//				else {
//				VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency increased by " + CapitalEfficiency2YrChange5 + " over the last 2 years from " + CapitalEfficiencyKPIP_2YrChange_4 + " in " + Last2Year + " to " + CapitalEfficiencyKPI2_3 + " in " + PeriodYr);}
//			VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
//		}
//		else {
//			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency remained the same");
//			VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);
//		}
//		//Competitive Position 1st Bullet
//		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(true, 5);
//		String[] CECompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText().split("\\s");
//		Double CECompetitivePosition1_1 = Double.parseDouble(CECompetitivePosition1[CECompetitivePosition1.length - 3]);
//		Double CECompetitivePosition1_2 = Double.parseDouble(CECompetitivePosition1[CECompetitivePosition1.length - 1]);
//		String CP1_1 = df.format(CECompetitivePosition1_1);
//		BigDecimal CP2_1 = new BigDecimal(CECompetitivePosition1_2);
//		BigDecimal CP2_2 = CP2_1.setScale(1, BigDecimal.ROUND_HALF_UP);
//		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
//		if (CapitalEfficiencyKPI2_3 > CapitalEfficiencyKPIP2_3) {
//			if (CapitalEfficiencyKPIP2_3.equals(Double.parseDouble(CP1_1)) & CapitalEfficiencyKPI_KPIP_2.equals(CP2_2)) {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is higher than the peer median of " + CECompetitivePosition1_1 + " by " + CECompetitivePosition1_2);}
//				else {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in " + PeriodYr + " is higher than the peer median of " + CECompetitivePosition1_1 + " by " + CECompetitivePosition1_2);}
//			VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
//			else {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is higher than the peer median of " + CapitalEfficiencyKPIP2_3 + " by " + CapitalEfficiencyKPI_KPIP_2);}
//				else {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in " + PeriodYr + " is higher than the peer median of " + CapitalEfficiencyKPIP2_3 + " by " + CapitalEfficiencyKPI_KPIP_2);}
//			VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
//		}
//		else if (CapitalEfficiencyKPI2_3 < CapitalEfficiencyKPIP2_3) {
//			if (CapitalEfficiencyKPIP2_3.equals(Double.parseDouble(CP1_1)) & CapitalEfficiencyKPI_KPIP_2.equals(CP2_2)) {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is lower than the peer median of " + CECompetitivePosition1_1 + " by " + CECompetitivePosition1_2);}
//				else {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in " + PeriodYr + " is lower than the peer median of " + CECompetitivePosition1_1 + " by " + CECompetitivePosition1_2);}
//			VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
//			else {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is lower than the peer median of " + CapitalEfficiencyKPIP2_3 + " by " + CapitalEfficiencyKPIP_KPI_2);}
//				else {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in " + PeriodYr + " is lower than the peer median of " + CapitalEfficiencyKPIP2_3 + " by " + CapitalEfficiencyKPIP_KPI_2);}
//			VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
//		}
//		else {
//			if (CapitalEfficiencyKPIP2_3.equals(Double.parseDouble(CP1_1)) & CapitalEfficiencyKPI_KPIP_2.equals(CP2_2)) {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is " + CECompetitivePosition1_1  + ", same as the peer median");}
//				else {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in " + PeriodYr + " is " + CECompetitivePosition1_1  + ", same as the peer median");}
//			VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
//			else {
//				if (Period.equals("TTM")) {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is " + CapitalEfficiencyKPIP2_3  + ", same as the peer median");}
//				else {
//				VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in " + PeriodYr + " is " + CapitalEfficiencyKPIP2_3  + ", same as the peer median");}
//			VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
//		}
//		//Competitive Position 2nd Bullet
//		if ((CapitalEfficiencyRank3 > 0) & (CapitalEfficiencyRank3 <= 0.25)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Capital Efficiency performance placed it in the top quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((CapitalEfficiencyRank3 > 0.25) & (CapitalEfficiencyRank3 <= 0.5)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Capital Efficiency performance placed it in the 2nd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
//		else if ((CapitalEfficiencyRank3 > 0.5) & (CapitalEfficiencyRank3 <= 0.75)) {
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Capital Efficiency performance placed it in the 3rd quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
//		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.company + "'s Capital Efficiency performance placed it in the bottom quartile of the peer group");
//		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
//		//Best in Class
//		String[] CEBestInClass = VIPFinancialsPage.contents.BestInClass.getText().split("\\s");
//		String CEBestInClass_2 = CEBestInClass[CEBestInClass.length - 11].replace("(", "").replace(")", "");
//		Double CEBestInClass_1 = Double.parseDouble(CEBestInClass_2);
//		String BC1_1 = df.format(CEBestInClass_1);
//		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
//		if (CapitalEfficiencyBest3.equals(Double.parseDouble(BC1_1))) {
//			if (Period.equals("TTM")) {
//			VIPFinancialsPage.contents.BestInClass.verifyText(CapitalEfficiencyBest1_3 + " (" + CEBestInClass_2 + ") " + "ranked the best in terms of Capital Efficiency in TTM");}
//			else {
//			VIPFinancialsPage.contents.BestInClass.verifyText(CapitalEfficiencyBest1_3 + " (" + CEBestInClass_2 + ") " + "ranked the best in terms of Capital Efficiency in " + PeriodYr);}
//		}
//		else {
//			if (Period.equals("TTM")) {
//			VIPFinancialsPage.contents.BestInClass.verifyText(CapitalEfficiencyBest1_3 + " (" + CapitalEfficiencyBest3 + ") " + "ranked the best in terms of Capital Efficiency in TTM");}
//			else {
//			VIPFinancialsPage.contents.BestInClass.verifyText(CapitalEfficiencyBest1_3 + " (" + CapitalEfficiencyBest3 + ") " + "ranked the best in terms of Capital Efficiency in " + PeriodYr);}
//		}
//		//Footnote
//		if (!VIPFinancialsPage.contents.FootNote3.isDisplayed()) {
//		VIPFinancialsPage.contents.FootNote.verifyText("Note: Capital Efficiency uses invested capital value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
//		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
//		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + " Capital Efficiency uses invested capital value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
//		//TestData
//		String CESP = VIPFinancialsPage.contents.StandalonePerf.getText();
//		String CECP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
//		String CECP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
//		String CEBest = VIPFinancialsPage.contents.BestInClass.getText();
//		String CEFootnote = VIPFinancialsPage.contents.FootNote.getText();
//		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_Capital Efficiency");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_COGS Revenue");
		//COGS
		VIPFinancialsPage.contents.COGSRevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (COGS2YrChange6 < 0) {																					
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue decreased by " + COGS2YrChange5 + " pps over the last 2 years from " + COGSKPIP_2YrChange_2 + "% in " + Last2Year + " to " + COGSKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue decreased by " + COGS2YrChange5 + " pps over the last 2 years from " + COGSKPIP_2YrChange_2 + "% in " + Last2Year + " to " + COGSKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (COGS2YrChange6 > 0) {																					
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue increased by " + COGS2YrChange5 + " pps over the last 2 years from " + COGSKPIP_2YrChange_4 + "% in " + Last2Year + " to " + COGSKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue increased by " + COGS2YrChange5 + " pps over the last 2 years from " + COGSKPIP_2YrChange_4 + "% in " + Last2Year + " to " + COGSKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (COGSKPI2_3 > COGSKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s COGS/Revenue in TTM is higher than the peer median of " + COGSKPIP2_3 + "%" + " by " + COGSKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s COGS/Revenue in " + PeriodYr + " is higher than the peer median of " + COGSKPIP2_3 + "%" + " by " + COGSKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (COGSKPI2_3 < COGSKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s COGS/Revenue in TTM is lower than the peer median of " + COGSKPIP2_3 + "%" + " by " + COGSKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s COGS/Revenue in " + PeriodYr + " is lower than the peer median of " + COGSKPIP2_3 + "%" + " by " + COGSKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s COGS/Revenue in TTM is " + COGSKPIP2_3 + "%" + ", same as the peer median");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s COGS/Revenue in " + PeriodYr + " is " + COGSKPIP2_3 + "%" + ", same as the peer median");}
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
		if (Period.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(COGSBest1_3 + " (" + COGSBest3 + "%) " + "ranked the best in terms of COGS/Revenue in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(COGSBest1_3 + " (" + COGSBest3 + "%) " + "ranked the best in terms of COGS/Revenue in " + PeriodYr);}
		//Footnote
		if (VIPFinancialsPage.contents.FootNote2.isDisplayed()) {
		String FootNote0 = VIPFinancialsPage.contents.FootNote0.getText();
		String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote0 + " " + FootNote1 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else if (VIPFinancialsPage.contents.FootNote1.isDisplayed()) { 
		String FootNote0 = VIPFinancialsPage.contents.FootNote0.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote0 + " Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		
		//TestData
		String COGSSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String COGSCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String COGSCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String COGSBest = VIPFinancialsPage.contents.BestInClass.getText();
		String COGSFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_COGS Revenue");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_SGA Revenue");
		//SGA
		VIPFinancialsPage.contents.SGARevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (SGA2YrChange6 < 0) {																					
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue decreased by " + SGA2YrChange5 + " pps over the last 2 years from " + SGAKPIP_2YrChange_2 + "% in " + Last2Year + " to " + SGAKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue decreased by " + SGA2YrChange5 + " pps over the last 2 years from " + SGAKPIP_2YrChange_2 + "% in " + Last2Year + " to " + SGAKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (SGA2YrChange6 > 0) {																					
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue increased by " + SGA2YrChange5 + " pps over the last 2 years from " + SGAKPIP_2YrChange_4 + "% in " + Last2Year + " to " + SGAKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue increased by " + SGA2YrChange5 + " pps over the last 2 years from " + SGAKPIP_2YrChange_4 + "% in " + Last2Year + " to " + SGAKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (SGAKPI2_3 > SGAKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s SG&A/Revenue in TTM is higher than the peer median of " + SGAKPIP2_3 + "%" + " by " + SGAKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s SG&A/Revenue in " + PeriodYr + " is higher than the peer median of " + SGAKPIP2_3 + "%" + " by " + SGAKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (SGAKPI2_3 < SGAKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s SG&A/Revenue in TTM is lower than the peer median of " + SGAKPIP2_3 + "%" + " by " + SGAKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s SG&A/Revenue in " + PeriodYr + " is lower than the peer median of " + SGAKPIP2_3 + "%" + " by " + SGAKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s SG&A/Revenue in TTM is " + SGAKPIP2_3 + "%" + ", same as the peer median");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s SG&A/Revenue in " + PeriodYr + " is " + SGAKPIP2_3 + "%" + ", same as the peer median");}
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
		if (Period.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(SGABest1_3 + " (" + SGABest3 + "%) " + "ranked the best in terms of SG&A/Revenue in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(SGABest1_3 + " (" + SGABest3 + "%) " + "ranked the best in terms of SG&A/Revenue in " + PeriodYr);}
		//Footnote
		if (VIPFinancialsPage.contents.FootNote2.isDisplayed()) {
		String FootNote0 = VIPFinancialsPage.contents.FootNote0.getText();
		String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote0 + " " + FootNote1 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else if (VIPFinancialsPage.contents.FootNote1.isDisplayed()) { 
		String FootNote0 = VIPFinancialsPage.contents.FootNote0.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote0 + " Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String SGASP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String SGACP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String SGACP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String SGABest = VIPFinancialsPage.contents.BestInClass.getText();
		String SGAFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_SGA Revenue");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_Working Capital Revenue");
		//OpeWorCap
		VIPFinancialsPage.contents.WorkingCapitalRevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (OpeWorCap2YrChange6 < 0) {																					
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue decreased by " + OpeWorCap2YrChange5 + " pps over the last 2 years from " + OpeWorCapKPIP_2YrChange_2 + "% in " + Last2Year + " to " + OpeWorCapKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue decreased by " + OpeWorCap2YrChange5 + " pps over the last 2 years from " + OpeWorCapKPIP_2YrChange_2 + "% in " + Last2Year + " to " + OpeWorCapKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (OpeWorCap2YrChange6 > 0) {																					
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue increased by " + OpeWorCap2YrChange5 + " pps over the last 2 years from " + OpeWorCapKPIP_2YrChange_4 + "% in " + Last2Year + " to " + OpeWorCapKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue increased by " + OpeWorCap2YrChange5 + " pps over the last 2 years from " + OpeWorCapKPIP_2YrChange_4 + "% in " + Last2Year + " to " + OpeWorCapKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (OpeWorCapKPI2_3 > OpeWorCapKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is higher than the peer median of " + OpeWorCapKPIP2_3 + "%" + " by " + OpeWorCapKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in " + PeriodYr + " is higher than the peer median of " + OpeWorCapKPIP2_3 + "%" + " by " + OpeWorCapKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (OpeWorCapKPI2_3 < OpeWorCapKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is lower than the peer median of " + OpeWorCapKPIP2_3 + "%" + " by " + OpeWorCapKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in " + PeriodYr + " is lower than the peer median of " + OpeWorCapKPIP2_3 + "%" + " by " + OpeWorCapKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is " + OpeWorCapKPIP2_3 + "%" + ", same as the peer median");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in " + PeriodYr + " is " + OpeWorCapKPIP2_3 + "%" + ", same as the peer median");}
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
		if (Period.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(OpeWorCapBest1_3 + " (" + OpeWorCapBest3 + "%) " + "ranked the best in terms of Working Capital/Revenue in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(OpeWorCapBest1_3 + " (" + OpeWorCapBest3 + "%) " + "ranked the best in terms of Working Capital/Revenue in " + PeriodYr);}
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote3.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Working Capital / Revenue uses working capital value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + " Working Capital / Revenue uses working capital value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String OWCSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String OWCCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String OWCBest = VIPFinancialsPage.contents.BestInClass.getText();
		String OWCFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_Working Capital Revenue");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_Net PPE Revenue");
		//NetPPE
		VIPFinancialsPage.contents.NetPPERevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (NetPPE2YrChange6 < 0) {			
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue decreased by " + NetPPE2YrChange5 + " pps over the last 2 years from " + NetPPEKPIP_2YrChange_2 + "% in " + Last2Year + " to " + NetPPEKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue decreased by " + NetPPE2YrChange5 + " pps over the last 2 years from " + NetPPEKPIP_2YrChange_2 + "% in " + Last2Year + " to " + NetPPEKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (NetPPE2YrChange6 > 0) {																					
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue increased by " + NetPPE2YrChange5 + " pps over the last 2 years from " + NetPPEKPIP_2YrChange_4 + "% in " + Last2Year + " to " + NetPPEKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue increased by " + NetPPE2YrChange5 + " pps over the last 2 years from " + NetPPEKPIP_2YrChange_4 + "% in " + Last2Year + " to " + NetPPEKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (NetPPEKPI2_3 > NetPPEKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net PPE/Revenue in TTM is higher than the peer median of " + NetPPEKPIP2_3 + "%" + " by " + NetPPEKPIP_KPI_2.abs() + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net PPE/Revenue in " + PeriodYr + " is higher than the peer median of " + NetPPEKPIP2_3 + "%" + " by " + NetPPEKPIP_KPI_2.abs() + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (NetPPEKPI2_3 < NetPPEKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net PPE/Revenue in TTM is lower than the peer median of " + NetPPEKPIP2_3 + "%" + " by " + NetPPEKPI_KPIP_2.abs() + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net PPE/Revenue in " + PeriodYr + " is lower than the peer median of " + NetPPEKPIP2_3 + "%" + " by " + NetPPEKPI_KPIP_2.abs() + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net PPE/Revenue in TTM is " + NetPPEKPIP2_3 + "%" + ", same as the peer median");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net PPE/Revenue in " + PeriodYr + " is " + NetPPEKPIP2_3 + "%" + ", same as the peer median");}
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
		if (Period.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(NetPPEBest1_3 + " (" + NetPPEBest3 + "%) " + "ranked the best in terms of Net PPE/Revenue in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(NetPPEBest1_3 + " (" + NetPPEBest3 + "%) " + "ranked the best in terms of Net PPE/Revenue in " + PeriodYr);}
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote3.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Net PPE / Revenue uses net ppe value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + " Net PPE / Revenue uses net ppe value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String PPESP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String PPECP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String PPECP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String PPEBest = VIPFinancialsPage.contents.BestInClass.getText();
		String PPEFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_Net PPE Revenue");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_Goodwill Intangibles Revenue");
		//GoodWillInt
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (GoodWillInt2YrChange6 < 0) {																					
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue decreased by " + GoodWillInt2YrChange5 + " pps over the last 2 years from " + GoodWillIntKPIP_2YrChange_2 + "% in " + Last2Year + " to " + GoodWillIntKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue decreased by " + GoodWillInt2YrChange5 + " pps over the last 2 years from " + GoodWillIntKPIP_2YrChange_2 + "% in " + Last2Year + " to " + GoodWillIntKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (GoodWillInt2YrChange6 > 0) {																					
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue increased by " + GoodWillInt2YrChange5 + " pps over the last 2 years from " + GoodWillIntKPIP_2YrChange_4 + "% in " + Last2Year + " to " + GoodWillIntKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue increased by " + GoodWillInt2YrChange5 + " pps over the last 2 years from " + GoodWillIntKPIP_2YrChange_4 + "% in " + Last2Year + " to " + GoodWillIntKPI2_3 + "% in " + PeriodYr);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (GoodWillIntKPI2_3 > GoodWillIntKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Goodwill & Int./Revenue in TTM is higher than the peer median of " + GoodWillIntKPIP2_3 + "%" + " by " + GoodWillIntKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Goodwill & Int./Revenue in " + PeriodYr + " is higher than the peer median of " + GoodWillIntKPIP2_3 + "%" + " by " + GoodWillIntKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (GoodWillIntKPI2_3 < GoodWillIntKPIP2_3) {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Goodwill & Int./Revenue in TTM is lower than the peer median of " + GoodWillIntKPIP2_3 + "%" + " by " + GoodWillIntKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Goodwill & Int./Revenue in " + PeriodYr + " is lower than the peer median of " + GoodWillIntKPIP2_3 + "%" + " by " + GoodWillIntKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {
			if (Period.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Goodwill & Int./Revenue in TTM is " + GoodWillIntKPIP2_3 + "%" + ", same as the peer median");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Goodwill & Int./Revenue in " + PeriodYr + " is " + GoodWillIntKPIP2_3 + "%" + ", same as the peer median");}
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
		if (Period.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(GoodWillIntBest1_3 + " (" + GoodWillIntBest3 + "%) " + "ranked the best in terms of Goodwill & Int./Revenue in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(GoodWillIntBest1_3 + " (" + GoodWillIntBest3 + "%) " + "ranked the best in terms of Goodwill & Int./Revenue in " + PeriodYr);}
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote3.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Goodwill & Intangibles / Revenue uses goodwill & intangibles value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + " Goodwill & Intangibles / Revenue uses goodwill & intangibles value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String GWISP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String GWICP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String GWICP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String GWIBest = VIPFinancialsPage.contents.BestInClass.getText();
		String GWFootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_Goodwill Intangibles Revenue");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_EBITDA Margin");
		VIPLandingPage.contents.HelpIcon.hover();
		//EBITDAMargin
		VIPFinancialsPage.contents.EBITDAMarginBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true);
		//Competitive Position 2nd Bullet
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompPosIcon2.verifyDisplayed(true);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true);
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote2.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String EBITDAMarginSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String EBITDAMarginCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String EBITDAMarginCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String EBITDAMarginBest = VIPFinancialsPage.contents.BestInClass.getText();
		String EBITDAMarginFootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_EBITDA Margin");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_D&A/Revenue");
		VIPLandingPage.contents.HelpIcon.hover();
		//D&A/Revenue
		VIPFinancialsPage.contents.DARevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true);
		//Competitive Position 2nd Bullet
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompPosIcon2.verifyDisplayed(true);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true);
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote2.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String DARSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String DARCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String DARCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String DARBest = VIPFinancialsPage.contents.BestInClass.getText();
		String DARFootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_D&A/Revenue");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_Net Other Assets Revenue");
		VIPLandingPage.contents.HelpIcon.hover();
		//Net Other Assets Revenue
		VIPFinancialsPage.contents.NetOtherAssetsRevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true);
		//Competitive Position 2nd Bullet
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompPosIcon2.verifyDisplayed(true);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true);
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote3.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Net Other Assets / Revenue uses net other assets value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + " Net Other Assets / Revenue uses net other assets value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String NOARSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String NOARCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String NOARCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String NOARBest = VIPFinancialsPage.contents.BestInClass.getText();
		String NOARFootNote = VIPFinancialsPage.contents.FootNote.getText();
		VIPFinancialsPage.contents.FootNoteMethodologyLink.click();
		VIPFinancialsPage.contents.MethodologyTitle.waitForExist(true, 10);
		VIPFinancialsPage.contents.MethodologyTitle.verifyText("METHODOLOGY");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.PreTaxROICMenu.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_Net Other Assets Revenue");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_Other Expenses Revenue");
		VIPLandingPage.contents.HelpIcon.hover();
		//Other Expenses Revenue
		VIPFinancialsPage.contents.OtherExpensesRevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true);
		//Competitive Position 2nd Bullet
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompPosIcon2.verifyDisplayed(true);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true);
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote2.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String OERSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String OERCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String OERCP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String OERBest = VIPFinancialsPage.contents.BestInClass.getText();
		String OERFootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_Other Expenses Revenue");
			
		ReportLog.setTestCase("Q2A_Reg_Auto_090");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		String StandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CompetitivePosition2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String BestInClass = VIPFinancialsPage.contents.BestInClass.getText();
		String RightHandChartHeader = VIPFinancialsPage.contents.RightHandChartHeader.getText();
		String FootNotes = VIPFinancialsPage.contents.FootNote.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CompetitivePosition2);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNotes);
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText(RightHandChartHeader);
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CompetitivePosition2);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNotes);
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText(RightHandChartHeader);
		WebControl.takeScreenshot("Q2A_Reg_Auto_090");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_091");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		VIPFinancialsPage.contents.FootNote.verifyText(ROICFootnote);
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(EBITSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(EBITCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(EBITCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(EBITBest);
		VIPFinancialsPage.contents.FootNote.verifyText(EBITFootnote);
		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.click();
//		VIPFinancialsPage.contents.StandalonePerf.verifyText(CESP);
//		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CECP1);
//		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CECP2);
//		VIPFinancialsPage.contents.BestInClass.verifyText(CEBest);
//		VIPFinancialsPage.contents.FootNote.verifyText(CEFootnote);
		VIPFinancialsPage.contents.COGSRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(COGSSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(COGSCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(COGSCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(COGSBest);
		VIPFinancialsPage.contents.FootNote.verifyText(COGSFootnote);
		VIPFinancialsPage.contents.SGARevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(SGASP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(SGACP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(SGACP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(SGABest);
		VIPFinancialsPage.contents.FootNote.verifyText(SGAFootnote);
		VIPFinancialsPage.contents.WorkingCapitalRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OWCSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OWCCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(OWCBest);
		VIPFinancialsPage.contents.FootNote.verifyText(OWCFootnote);
		VIPFinancialsPage.contents.NetPPERevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(PPESP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(PPECP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(PPECP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(PPEBest);
		VIPFinancialsPage.contents.FootNote.verifyText(PPEFootnote);
		VIPFinancialsPage.contents.GoodwillIntangiblesRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(GWISP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(GWICP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(GWICP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(GWIBest);
		VIPFinancialsPage.contents.FootNote.verifyText(GWFootNote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.EBITDAMarginBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(EBITDAMarginSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(EBITDAMarginCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(EBITDAMarginCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(EBITDAMarginBest);
		VIPFinancialsPage.contents.FootNote.verifyText(EBITDAMarginFootNote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.DARevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(DARSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(DARCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(DARCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(DARBest);
		VIPFinancialsPage.contents.FootNote.verifyText(DARFootNote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.NetOtherAssetsRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(NOARSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(NOARCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(NOARCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(NOARBest);
		VIPFinancialsPage.contents.FootNote.verifyText(NOARFootNote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OtherExpensesRevenueBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OERSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OERCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(OERCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(OERBest);
		VIPFinancialsPage.contents.FootNote.verifyText(OERFootNote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_091");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
	@Test(priority=10)
	public void Q2A_OperatingWorkingCapital () throws Exception {
		ReportLog.setTestName("Q2A - Operating Working Capital Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
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
		//Year Period
		String[] Periods1 = VIPFinancialsPage.contents.ScoreCardDate.getText().split("\\s");
		String Periods = Periods1[0].replace("[", ""); // TTM or FY
		String PeriodYrMon = Periods1[2].replace("]", ""); // 12/2020
		String[] PeriodYr1 = PeriodYrMon.split("\\/");
		int CurrentYear1 = Integer.parseInt(PeriodYr1[1]); // 2020
		String CurrentYear = Integer.toString(CurrentYear1);
		String LastYear = Integer.toString(CurrentYear1 - 1);
		String Last2Year = Integer.toString(CurrentYear1 - 2);
		
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
		String[] Period1 = VIPFinancialsPage.contents.ScoreCardDate.getText().split("\\/");
		String Period2 = Period1[1].replace("]", "");
		int Period = Integer.parseInt(Period2);
		int Period_1 = Period - 1;
		int Period_2 = Period - 2;
		String Period_1yr = Integer.toString(Period_1);
		String Period_2yr = Integer.toString(Period_2);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
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
		VIPFinancialsPage.contents.FirstPeriodHeader.verifyText(Last2Year);
		VIPFinancialsPage.contents.SecondPeriodHeader.verifyText(LastYear);
		if (Periods.equals("TTM")) {
		VIPFinancialsPage.contents.ThirdPeriodHeader.verifyText("TTM");}
		if (Periods.equals("FY")) {
		VIPFinancialsPage.contents.ThirdPeriodHeader.verifyText(CurrentYear);}
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
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_WorCapRev");
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		//WorCapRev
		VIPFinancialsPage.contents.WorkCapRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);    
		if (WorCapRev2YrChange6 < 0) {																					
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue decreased by " + WorCapRev2YrChange5 + " pps over the last 2 years from " + (WorCapRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + WorCapRevKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue decreased by " + WorCapRev2YrChange5 + " pps over the last 2 years from " + (WorCapRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + WorCapRevKPI2_3 + "% in " + CurrentYear);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (WorCapRev2YrChange6 > 0) {																					
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue increased by " + WorCapRev2YrChange5 + " pps over the last 2 years from " + (WorCapRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + WorCapRevKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue increased by " + WorCapRev2YrChange5 + " pps over the last 2 years from " + (WorCapRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + WorCapRevKPI2_3 + "% in " + CurrentYear);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue remained constant at " + WorCapRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (WorCapRevKPI2_3 > WorCapRevKPIP2_3) {
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is higher than the peer median of " + WorCapRevKPIP2_3 + "%" + " by " + WorCapRevKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in " + CurrentYear + " is higher than the peer median of " + WorCapRevKPIP2_3 + "%" + " by " + WorCapRevKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is lower than the peer median of " + WorCapRevKPIP2_3 + "%" + " by " + WorCapRevKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in " + CurrentYear + " is lower than the peer median of " + WorCapRevKPIP2_3 + "%" + " by " + WorCapRevKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		if (Periods.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(WorCapRevBest1_3 + " (" + WorCapRevBest3 + "%) " + "ranked the best in terms of Working Capital/Revenue in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(WorCapRevBest1_3 + " (" + WorCapRevBest3 + "%) " + "ranked the best in terms of Working Capital/Revenue in " + CurrentYear);}
		//Footnote
		String FootNote00_1 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_1.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_1 + " Working Capital / Revenue uses working capital value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Working Capital / Revenue uses working capital value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String WCRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String WCRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String WCRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String WCRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_WorCapRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_NetRecRev");
		//NetRecRev
		VIPFinancialsPage.contents.NetRecRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (NetRecRev2YrChange6 < 0) {																					
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue decreased by " + NetRecRev2YrChange5 + " pps over the last 2 years from " + (NetRecRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + NetRecRevKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue decreased by " + NetRecRev2YrChange5 + " pps over the last 2 years from " + (NetRecRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + NetRecRevKPI2_3 + "% in " + CurrentYear);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (NetRecRev2YrChange6 > 0) {																					
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue increased by " + NetRecRev2YrChange5 + " pps over the last 2 years from " + (NetRecRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + NetRecRevKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue increased by " + NetRecRev2YrChange5 + " pps over the last 2 years from " + (NetRecRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + NetRecRevKPI2_3 + "% in " + CurrentYear);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue remained constant at " + NetRecRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (NetRecRevKPI2_3 > NetRecRevKPIP2_3) {
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net Receivables/Revenue in TTM is higher than the peer median of " + NetRecRevKPIP2_3 + "%" + " by " + NetRecRevKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net Receivables/Revenue in " + CurrentYear + " is higher than the peer median of " + NetRecRevKPIP2_3 + "%" + " by " + NetRecRevKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net Receivables/Revenue in TTM is lower than the peer median of " + NetRecRevKPIP2_3 + "%" + " by " + NetRecRevKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net Receivables/Revenue in " + CurrentYear + " is lower than the peer median of " + NetRecRevKPIP2_3 + "%" + " by " + NetRecRevKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		if (Periods.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(NetRecRevBest1_3 + " (" + NetRecRevBest3 + "%) " + "ranked the best in terms of Net Receivables/Revenue in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(NetRecRevBest1_3 + " (" + NetRecRevBest3 + "%) " + "ranked the best in terms of Net Receivables/Revenue in " + CurrentYear);}
		//Footnote
		String FootNote00_2 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_2.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_2 + " Net Receivables / Revenue uses net receivables value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Net Receivables / Revenue uses net receivables value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String NRRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String NRRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String NRRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String NRRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_NetRecRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_InvRev");
		//InvRev
		VIPFinancialsPage.contents.InventoryRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (InvRev2YrChange6 < 0) {																					
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue decreased by " + InvRev2YrChange5 + " pps over the last 2 years from " + (InvRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + InvRevKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue decreased by " + InvRev2YrChange5 + " pps over the last 2 years from " + (InvRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + InvRevKPI2_3 + "% in " + CurrentYear);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (InvRev2YrChange6 > 0) {																					
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue increased by " + InvRev2YrChange5 + " pps over the last 2 years from " + (InvRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + InvRevKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue increased by " + InvRev2YrChange5 + " pps over the last 2 years from " + (InvRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + InvRevKPI2_3 + "% in " + CurrentYear);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue remained constant at " + InvRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (InvRevKPI2_3 > InvRevKPIP2_3) {
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory/Revenue in TTM is higher than the peer median of " + InvRevKPIP2_3 + "%" + " by " + InvRevKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory/Revenue in " + CurrentYear + " is higher than the peer median of " + InvRevKPIP2_3 + "%" + " by " + InvRevKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory/Revenue in TTM is lower than the peer median of " + InvRevKPIP2_3 + "%" + " by " + InvRevKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory/Revenue in " + CurrentYear + " is lower than the peer median of " + InvRevKPIP2_3 + "%" + " by " + InvRevKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		if (Periods.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(InvRevBest1_3 + " (" + InvRevBest3 + "%) " + "ranked the best in terms of Inventory/Revenue in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(InvRevBest1_3 + " (" + InvRevBest3 + "%) " + "ranked the best in terms of Inventory/Revenue in " + CurrentYear);}
		//Footnote
		String FootNote00_3 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_3.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_3 + " Inventory / Revenue uses inventory value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Inventory / Revenue uses inventory value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String IRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String IRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String IRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String IRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_InvRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_AccPayRev");
		//AccPayRev
		VIPFinancialsPage.contents.AccPayRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (AccPayRev2YrChange6 < 0) {																					
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue decreased by " + AccPayRev2YrChange5 + " pps over the last 2 years from " + (AccPayRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + AccPayRevKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue decreased by " + AccPayRev2YrChange5 + " pps over the last 2 years from " + (AccPayRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + AccPayRevKPI2_3 + "% in " + CurrentYear);}
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (AccPayRev2YrChange6 > 0) {																					
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue increased by " + AccPayRev2YrChange5 + " pps over the last 2 years from " + (AccPayRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + AccPayRevKPI2_3 + "% in TTM");}
			else {
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue increased by " + AccPayRev2YrChange5 + " pps over the last 2 years from " + (AccPayRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + AccPayRevKPI2_3 + "% in " + CurrentYear);}
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue remained constant at " + AccPayRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (AccPayRevKPI2_3 > AccPayRevKPIP2_3) {
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Accounts Payable/Revenue in TTM is higher than the peer median of " + AccPayRevKPIP2_3 + "%" + " by " + AccPayRevKPI_KPIP_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Accounts Payable/Revenue in " + CurrentYear + " is higher than the peer median of " + AccPayRevKPIP2_3 + "%" + " by " + AccPayRevKPI_KPIP_2 + " pps");}
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {
			if (Periods.equals("TTM")) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Accounts Payable/Revenue in TTM is lower than the peer median of " + AccPayRevKPIP2_3 + "%" + " by " + AccPayRevKPIP_KPI_2 + " pps");}
			else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Accounts Payable/Revenue in " + CurrentYear + " is lower than the peer median of " + AccPayRevKPIP2_3 + "%" + " by " + AccPayRevKPIP_KPI_2 + " pps");}
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		if (Periods.equals("TTM")) {
		VIPFinancialsPage.contents.BestInClass.verifyText(AccPayRevBest1_3 + " (" + AccPayRevBest3 + "%) " + "ranked the best in terms of Accounts Payable/Revenue in TTM");}
		else {
		VIPFinancialsPage.contents.BestInClass.verifyText(AccPayRevBest1_3 + " (" + AccPayRevBest3 + "%) " + "ranked the best in terms of Accounts Payable/Revenue in " + CurrentYear);}
		//Footnote
		String FootNote00_4 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_4.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_4 + " Accounts Payable / Revenue uses accounts payable value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Accounts Payable / Revenue uses accounts payable value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String APRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String APRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String APRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String APRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_AccPayRev");	
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_OpeCurAssRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//OpeCurAssRev
		VIPFinancialsPage.contents.OpeCurAssRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_5 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_5.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_5 + " Operating Current Assets / Revenue uses operating current assets value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Operating Current Assets / Revenue uses operating current assets value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String OCARSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String OCARCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String OCARBest = VIPFinancialsPage.contents.BestInClass.getText();
		String OCARFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_OpeCurAssRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_NonIntBeaLiaRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//NonIntBeaLiaRev
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_6 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_6.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_6 + " Non-Interest Bearing Liabilities / Revenue uses non-interest bearing liabilities value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Non-Interest Bearing Liabilities / Revenue uses non-interest bearing liabilities value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String NIBLRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String NIBLRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String NIBLRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String NIBLRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_NonIntBeaLiaRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_CashRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//CashRev
		VIPFinancialsPage.contents.CashRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_7 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_7.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_7 + " Cash / Revenue uses cash value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Cash / Revenue uses cash value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String CRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String CRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_CashRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_OthCurAssRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//OthCurAssRev
		VIPFinancialsPage.contents.OtherCurAssRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_8 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_8.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_8 + " Other Current Assets / Revenue uses other cur. assets value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Other Current Assets / Revenue uses other cur. assets value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String OCAR1SP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String OCAR1CP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String OCAR1Best = VIPFinancialsPage.contents.BestInClass.getText();
		String OCAR1Footnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_OthCurAssRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_IncTaxPayRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//IncTaxPayRev
		VIPFinancialsPage.contents.IncTaxPayRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_9 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_9.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_9 + " Income Taxes Payable / Revenue uses income taxes payable value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Income Taxes Payable / Revenue uses income taxes payable value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String ITPRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String ITPRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String ITPRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String ITPRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_IncTaxPayRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_OtherCurLiaRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//OtherCurLiaRev
		VIPFinancialsPage.contents.OtherCurLiaRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_10 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_10.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_10 + " Other Current Liabilities / Revenue uses other current liabilities value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Other Current Liabilities / Revenue uses other current liabilities value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String OCLRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String OCLRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String OCLRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String OCLRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		VIPFinancialsPage.contents.FootNoteMethodologyLink.click();
		VIPFinancialsPage.contents.MethodologyTitle.waitForExist(true, 10);
		VIPFinancialsPage.contents.MethodologyTitle.verifyText("METHODOLOGY");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.OpeWorCapDecMenu.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_OtherCurLiaRev");
			
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		VIPFinancialsPage.contents.FootNote.verifyText(WCRFootnote);
		VIPFinancialsPage.contents.NetRecRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(NRRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(NRRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(NRRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(NRRFootnote);
		VIPFinancialsPage.contents.InventoryRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(IRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(IRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(IRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(IRFootnote);
		VIPFinancialsPage.contents.AccPayRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(APRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(APRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(APRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(APRFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OpeCurAssRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OCARSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OCARCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(OCARBest);
		VIPFinancialsPage.contents.FootNote.verifyText(OCARFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(NIBLRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(NIBLRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(NIBLRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(NIBLRFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.CashRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(CRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(CRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(CRFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OtherCurAssRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OCAR1SP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OCAR1CP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(OCAR1Best);
		VIPFinancialsPage.contents.FootNote.verifyText(OCAR1Footnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.IncTaxPayRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(ITPRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(ITPRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(ITPRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(ITPRFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OtherCurLiaRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OCLRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OCLRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(OCLRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(OCLRFootnote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_106");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}

	}
	
	@Test(priority=11)
	public void Q2A_CashCycleAnalysis () throws Exception {
		ReportLog.setTestName("Q2A - Cash Cycle Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
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
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true);    																				
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(true);
		//Competitive Position 2nd Bullet
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(true);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(true);
		
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(true);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(true);
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		VIPFinancialsPage.contents.StandalonePerf.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(true);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyDisplayed(true);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(true);
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
		
		String Menu1KeyInsights1 = "";
		String Menu1KeyInsights2 = "";
		if (VIPFinancialsPage.contents.BSAKeyInsights1.isDisplayed()) {
		Menu1KeyInsights1 = VIPFinancialsPage.contents.BSAKeyInsights1.getText();}
		if (VIPFinancialsPage.contents.BSAKeyInsights2.isDisplayed()) {
		Menu1KeyInsights2 = VIPFinancialsPage.contents.BSAKeyInsights2.getText();}
		
		String Menu2KeyInsights1 = "";
		String Menu2KeyInsights2 = "";
		VIPFinancialsPage.contents.SegmentDropdown.click();
		if (VIPFinancialsPage.contents.SegmentDropdownMenu2.isDisplayed()) {
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		if (VIPFinancialsPage.contents.BSAKeyInsights1.isDisplayed()) {
		Menu2KeyInsights1 = VIPFinancialsPage.contents.BSAKeyInsights1.getText();}
		if (VIPFinancialsPage.contents.BSAKeyInsights2.isDisplayed()) {
		Menu2KeyInsights2 = VIPFinancialsPage.contents.BSAKeyInsights2.getText();}}
		WebControl.takeScreenshot("Q2A_Regression_128_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_128_Validation");
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		
		if (!Menu1KeyInsights1.equals("")) {
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyText(Menu1KeyInsights1);}
		if (!Menu1KeyInsights2.equals("")) {
		VIPFinancialsPage.contents.BSAKeyInsights2.verifyText(Menu1KeyInsights2);}
		if (!Menu2KeyInsights1.equals("")) {
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.BSAKeyInsights1.verifyText(Menu2KeyInsights1);}
		if (!Menu2KeyInsights2.equals("")) {
		VIPFinancialsPage.contents.BSAKeyInsights2.verifyText(Menu2KeyInsights2);}
		VIPFinancialsPage.contents.BSAFootnote.verifyText(BSAFootnote);
		WebControl.takeScreenshot("Q2A_Regression_128_Validation");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		else {
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();}
		
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
		String[] RBSPieChartTimePeriod1 = VIPFinancialsPage.contents.RBSPieChartTimePeriod.getText().split("\\s");
		//String RBSPieChartTimePeriod = RBSPieChartTimePeriod1.substring(7, 14);
		VIPFinancialsPage.contents.RBSPieChart2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RBSPieChartTitle.verifyText("REVENUE BY SEGMENT");
		VIPFinancialsPage.contents.RBSPieChartTimePeriod.verifyText(RBSPieChartTimePeriod1[0] + " – " + RBSPieChartTimePeriod1[2].replace(",", "") + ", % by Revenue]");
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
		if (VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ATBarChartTitle.verifyText("ASSET TURNOVER");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(true, 5);}
		else if (VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & !VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		else if (!VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ATBarChartTitle.verifyText("ASSET TURNOVER");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		else {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu3.click();
		if (VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ATBarChartTitle.verifyText("ASSET TURNOVER");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(true, 5);}
		else if (VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & !VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RGYBarChartTitle.verifyText("REVENUE GROWTH YOY");
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		else if (!VIPFinancialsPage.contents.RGYBarChart.isDisplayed() & VIPFinancialsPage.contents.ATBarChart.isDisplayed()) {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ATBarChartTitle.verifyText("ASSET TURNOVER");
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
		else {
		VIPFinancialsPage.contents.RGYBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.ATBarChart.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsTitle.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsRGY.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsAT.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon1.verifyDisplayed(false);
		VIPFinancialsPage.contents.GSAKeyInsightsGaugeIcon2.verifyDisplayed(false);}
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
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		
		if (VIPFinancialsPage.contents.GSAKeyInsights1.isDisplayed() & VIPFinancialsPage.contents.GSAKeyInsights2.isDisplayed()) {
		String Menu1KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		String Menu2KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		String Menu2KeyInsights2 = VIPFinancialsPage.contents.GSAKeyInsights2.getText();
		WebControl.takeScreenshot("Q2A_Regression_140_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_140_Validation");
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyText(Menu1KeyInsights1);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyText(Menu2KeyInsights1);
		VIPFinancialsPage.contents.GSAKeyInsights2.verifyText(Menu2KeyInsights2);
		VIPFinancialsPage.contents.GSAFootnote.verifyText(GSAFootnote);}
		
		else if (VIPFinancialsPage.contents.GSAKeyInsights1.isDisplayed() & !VIPFinancialsPage.contents.GSAKeyInsights2.isDisplayed()) {
		String Menu1KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		String Menu2KeyInsights1 = VIPFinancialsPage.contents.GSAKeyInsights1.getText();
		WebControl.takeScreenshot("Q2A_Regression_140_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_140_Validation");
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyText(Menu1KeyInsights1);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.GSAKeyInsights1.verifyText(Menu2KeyInsights1);
		VIPFinancialsPage.contents.GSAFootnote.verifyText(GSAFootnote);}
		
		else {
		WebControl.takeScreenshot("Q2A_Regression_140_Prep");
		
		ReportLog.setTestCase("Q2A_Regression_140_Validation");
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
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
		VIPFinancialsPage.contents.SelectDropDown12.click();
		VIPFinancialsPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SegmentDropdown.click();
		VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
		VIPFinancialsPage.contents.GSAFootnote.verifyText(GSAFootnote);}
		WebControl.takeScreenshot("Q2A_Regression_140_Validation");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
		else {VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);}
		
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
		VIPLandingPage.contents.HelpIcon.hover();
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
	
	@Test(priority=16)
	public void Q2A_ReferenceCalculation () throws Exception {
		ReportLog.setTestName("Q2A - Reference Calculation");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_148");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		if (VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.isDisplayed() & VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.isDisplayed()) {
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyText("Reference Calculations");} 
		else if (!VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.isDisplayed() | !VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.isDisplayed()) {
		VIPFinancialsPage.contents.ReferenceCalculationsMenu1.verifyText("Reference Calculations");}
		else {VIPFinancialsPage.contents.ReferenceCalculationsMenu2.verifyText("Reference Calculations");}
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("text-align", "left");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("font-size", "14px");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("letter-spacing", "normal");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("line-height", "20px");
		WebControl.takeScreenshot("Q2A_Regression_148");
		
		ReportLog.setTestCase("Q2A_Regression_149_&_157");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompanyNameHeader.hover();
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.TopFilterDropdown.click();
		VIPCompetitorPage.contents.TopFilterChoice25.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 10);
		String TargetCompName_1 = VIPCompetitorPage.contents.TargetCompName.getText();
		String[] TargetCompName_2 = TargetCompName_1.split("\\n");
		String TargetCompName = TargetCompName_2[0];
		String Competitors1stPeers_1 = VIPCompetitorPage.contents.Competitors1stPeers.getText();
		String[] Competitors1stPeers_2 = Competitors1stPeers_1.split("\\n");
		String Competitors1stPeers = Competitors1stPeers_2[0];
		String Competitors2ndPeers_1 = VIPCompetitorPage.contents.Competitors2ndPeers.getText();
		String[] Competitors2ndPeers_2 = Competitors2ndPeers_1.split("\\n");
		String Competitors2ndPeers = Competitors2ndPeers_2[0];
		String Competitors3rdPeers_1 = VIPCompetitorPage.contents.Competitors3rdPeers.getText();
		String[] Competitors3rdPeers_2 = Competitors3rdPeers_1.split("\\n");
		String Competitors3rdPeers = Competitors3rdPeers_2[0];
		String Competitors4thPeers_1 = VIPCompetitorPage.contents.Competitors4thPeers.getText();
		String[] Competitors4thPeers_2 = Competitors4thPeers_1.split("\\n");
		String Competitors4thPeers = Competitors4thPeers_2[0];
		String Competitors5thPeers_1 = VIPCompetitorPage.contents.Competitors5thPeers.getText();
		String[] Competitors5thPeers_2 = Competitors5thPeers_1.split("\\n");
		String Competitors5thPeers = Competitors5thPeers_2[0];
		String Competitors6thPeers_1 = VIPCompetitorPage.contents.Competitors6thPeers.getText();
		String[] Competitors6thPeers_2 = Competitors6thPeers_1.split("\\n");
		String Competitors6thPeers = Competitors6thPeers_2[0];
		String Competitors7thPeers_1 = VIPCompetitorPage.contents.Competitors7thPeers.getText();
		String[] Competitors7thPeers_2 = Competitors7thPeers_1.split("\\n");
		String Competitors7thPeers = Competitors7thPeers_2[0];
		String Competitors8thPeers_1 = VIPCompetitorPage.contents.Competitors8thPeers.getText();
		String[] Competitors8thPeers_2 = Competitors8thPeers_1.split("\\n");
		String Competitors8thPeers = Competitors8thPeers_2[0];
		String Competitors9thPeers_1 = VIPCompetitorPage.contents.Competitors9thPeers.getText();
		String[] Competitors9thPeers_2 = Competitors9thPeers_1.split("\\n");
		String Competitors9thPeers = Competitors9thPeers_2[0];
		String Competitors10thPeers_1 = VIPCompetitorPage.contents.Competitors10thPeers.getText();
		String[] Competitors10thPeers_2 = Competitors10thPeers_1.split("\\n");
		String Competitors10thPeers = Competitors10thPeers_2[0];
		String Competitors11thPeers_1 = VIPCompetitorPage.contents.Competitors11thPeers.getText();
		String[] Competitors11thPeers_2 = Competitors11thPeers_1.split("\\n");
		String Competitors11thPeers = Competitors11thPeers_2[0];
		String Competitors12thPeers_1 = VIPCompetitorPage.contents.Competitors12thPeers.getText();
		String[] Competitors12thPeers_2 = Competitors12thPeers_1.split("\\n");
		String Competitors12thPeers = Competitors12thPeers_2[0];
		String Competitors13thPeers_1 = VIPCompetitorPage.contents.Competitors13thPeers.getText();
		String[] Competitors13thPeers_2 = Competitors13thPeers_1.split("\\n");
		String Competitors13thPeers = Competitors13thPeers_2[0];
		String Competitors14thPeers_1 = VIPCompetitorPage.contents.Competitors14thPeers.getText();
		String[] Competitors14thPeers_2 = Competitors14thPeers_1.split("\\n");
		String Competitors14thPeers = Competitors14thPeers_2[0];
		String Competitors15thPeers_1 = VIPCompetitorPage.contents.Competitors15thPeers.getText();
		String[] Competitors15thPeers_2 = Competitors15thPeers_1.split("\\n");
		String Competitors15thPeers = Competitors15thPeers_2[0];
		String Competitors16thPeers_1 = VIPCompetitorPage.contents.Competitors16thPeers.getText();
		String[] Competitors16thPeers_2 = Competitors16thPeers_1.split("\\n");
		String Competitors16thPeers = Competitors16thPeers_2[0];
		String Competitors17thPeers_1 = VIPCompetitorPage.contents.Competitors17thPeers.getText();
		String[] Competitors17thPeers_2 = Competitors17thPeers_1.split("\\n");
		String Competitors17thPeers = Competitors17thPeers_2[0];
		String Competitors18thPeers_1 = VIPCompetitorPage.contents.Competitors18thPeers.getText();
		String[] Competitors18thPeers_2 = Competitors18thPeers_1.split("\\n");
		String Competitors18thPeers = Competitors18thPeers_2[0];
		String Competitors19thPeers_1 = VIPCompetitorPage.contents.Competitors19thPeers.getText();
		String[] Competitors19thPeers_2 = Competitors19thPeers_1.split("\\n");
		String Competitors19thPeers = Competitors19thPeers_2[0];
		String Competitors20thPeers_1 = VIPCompetitorPage.contents.Competitors20thPeers.getText();
		String[] Competitors20thPeers_2 = Competitors20thPeers_1.split("\\n");
		String Competitors20thPeers = Competitors20thPeers_2[0];
		String Competitors21thPeers_1 = VIPCompetitorPage.contents.Competitors21thPeers.getText();
		String[] Competitors21thPeers_2 = Competitors21thPeers_1.split("\\n");
		String Competitors21thPeers = Competitors21thPeers_2[0];
		String Competitors22thPeers_1 = VIPCompetitorPage.contents.Competitors22thPeers.getText();
		String[] Competitors22thPeers_2 = Competitors22thPeers_1.split("\\n");
		String Competitors22thPeers = Competitors22thPeers_2[0];
		String Competitors23thPeers_1 = VIPCompetitorPage.contents.Competitors23thPeers.getText();
		String[] Competitors23thPeers_2 = Competitors23thPeers_1.split("\\n");
		String Competitors23thPeers = Competitors23thPeers_2[0];
		String Competitors24thPeers_1 = VIPCompetitorPage.contents.Competitors24thPeers.getText();
		String[] Competitors24thPeers_2 = Competitors24thPeers_1.split("\\n");
		String Competitors24thPeers = Competitors24thPeers_2[0];
		String Competitors25thPeers_1 = VIPCompetitorPage.contents.Competitors25thPeers.getText();
		String[] Competitors25thPeers_2 = Competitors25thPeers_1.split("\\n");
		String Competitors25thPeers = Competitors25thPeers_2[0];
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboard.waitForExist(true, 10);
		VIPFinancialsPage.contents.SelectDashboard.click();
		VIPFinancialsPage.contents.ReferenceCalculationMenu.click();
		VIPFinancialsPage.contents.SelectDashboard.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDashboardLabel.verifyText("Select Dashboard");
		VIPFinancialsPage.contents.SelectCompany.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCompanyLabel.verifyText("Select Company");
		VIPFinancialsPage.contents.SelectCurrency.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCurrencyLabel.verifyText("Select Currency");
		VIPFinancialsPage.contents.SelectCompany.click();
		VIPFinancialsPage.contents.SelectCompanyMenu1.verifyText(TargetCompName);
		VIPFinancialsPage.contents.SelectCompanyMenu2.verifyText(Competitors1stPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu3.verifyText(Competitors2ndPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu4.verifyText(Competitors3rdPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu5.verifyText(Competitors4thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu6.verifyText(Competitors5thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu7.verifyText(Competitors6thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu8.verifyText(Competitors7thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu9.verifyText(Competitors8thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu10.verifyText(Competitors9thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu11.verifyText(Competitors10thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu12.verifyText(Competitors11thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu13.verifyText(Competitors12thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu14.verifyText(Competitors13thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu15.verifyText(Competitors14thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu16.verifyText(Competitors15thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu17.verifyText(Competitors16thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu18.verifyText(Competitors17thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu19.verifyText(Competitors18thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu20.verifyText(Competitors19thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu21.verifyText(Competitors20thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu22.verifyText(Competitors21thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu23.verifyText(Competitors22thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu24.verifyText(Competitors23thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu25.verifyText(Competitors24thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu26.verifyText(Competitors25thPeers);
		VIPFinancialsPage.contents.SelectCurrency.click();
		VIPFinancialsPage.contents.SelectCurrencyMenu1.verifyText("Target Company Currency");
		WebControl.takeScreenshot("Q2A_Regression_149_&_157");
		
		ReportLog.setTestCase("Q2A_Regression_150");
		VIPFinancialsPage.contents.SelectCompanyDefault.verifyText(TargetCompName);
		VIPFinancialsPage.contents.SelectCompany.click();
		VIPFinancialsPage.contents.SelectCurrencyDefault.verifyText("Target Company Currency");
		WebControl.takeScreenshot("Q2A_Regression_150");
		
		ReportLog.setTestCase("Q2A_Regression_151");
		VIPFinancialsPage.contents.SelectCurrency.click();
		VIPFinancialsPage.contents.SelectCurrencyMenu1.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCurrencyMenu2.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectCompany.click();
		VIPFinancialsPage.contents.SelectCompanyMenu2.click();
		VIPFinancialsPage.contents.SelectCurrency.click();
		VIPFinancialsPage.contents.SelectCurrencyMenu1.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCurrencyMenu2.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCurrencyMenu2.verifyText("Local Currency");
		WebControl.takeScreenshot("Q2A_Regression_151");
		
		ReportLog.setTestCase("Q2A_Regression_152");
		VIPFinancialsPage.contents.ReferenceTitle1.verifyText("EBIT Calculations");
		VIPFinancialsPage.contents.ReferenceTitle2.verifyText("Invested Capital Calculations");
		VIPFinancialsPage.contents.ReferenceTitle3.verifyText("Cash Cycle Calculations");
		WebControl.takeScreenshot("Q2A_Regression_152");
		
		ReportLog.setTestCase("Q2A_Regression_153_Header");
		//EBIT
		VIPFinancialsPage.contents.EBITColumnHeader0.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader0.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader0.verifyCssValue("font-family", "graphik-bold");
		if (VIPFinancialsPage.contents.EBITColumnHeader1.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnHeader1.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader1.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader1.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.EBITColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnHeader2.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader2.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader2.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.EBITColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnHeader3.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader3.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader3.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.EBITColumnHeader4.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnHeader4.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader4.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader4.verifyCssValue("font-family", "graphik-bold");}
		//IC
		VIPFinancialsPage.contents.ICColumnHeader0.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader0.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader0.verifyCssValue("font-family", "graphik-bold");
		if (VIPFinancialsPage.contents.ICColumnHeader1.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader1.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader1.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader1.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.ICColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader2.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader2.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader2.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.ICColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader3.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader3.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader3.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader4.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader4.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader4.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader5.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader5.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader5.verifyCssValue("font-family", "graphik-bold");}
		//CC
		VIPFinancialsPage.contents.CCColumnHeader0.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.CCColumnHeader0.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCColumnHeader0.verifyCssValue("font-family", "graphik-bold");
		if (VIPFinancialsPage.contents.CCColumnHeader1.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnHeader1.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.CCColumnHeader1.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCColumnHeader1.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.CCColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnHeader2.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.CCColumnHeader2.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCColumnHeader2.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.CCColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnHeader3.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.CCColumnHeader3.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCColumnHeader3.verifyCssValue("font-family", "graphik-bold");}
		WebControl.takeScreenshot("Q2A_Regression_153_Header");
		
		ReportLog.setTestCase("Q2A_Regression_153_SubHeader");
		//EBIT
		if (VIPFinancialsPage.contents.EBITColumnHeader4.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.EBITColumnSubHeader4.verifyDisplayed(false);}
		else if (!VIPFinancialsPage.contents.EBITColumnHeader4.isDisplayed() & VIPFinancialsPage.contents.EBITColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.EBITColumnSubHeader3.verifyDisplayed(false);}
		else if (!VIPFinancialsPage.contents.EBITColumnHeader3.isDisplayed() & VIPFinancialsPage.contents.EBITColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.EBITColumnSubHeader2.verifyDisplayed(false);}
		//IC
		if (VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.ICColumnSubHeader5.verifyText("");}
		else if (!VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.ICColumnSubHeader4.verifyText("");}
		else if (!VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.ICColumnSubHeader3.verifyText("");}
		else if (!VIPFinancialsPage.contents.ICColumnHeader3.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.ICColumnSubHeader2.verifyText("");}
		//CC
		VIPFinancialsPage.contents.CCColumnSubHeader0.verifyText("");
		if (VIPFinancialsPage.contents.CCColumnSubHeader1.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnSubHeader1.verifyCssValue("font-style", "italic");}
		if (VIPFinancialsPage.contents.CCColumnSubHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnSubHeader2.verifyCssValue("font-style", "italic");}
		if (VIPFinancialsPage.contents.CCColumnSubHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnSubHeader3.verifyCssValue("font-style", "italic");}
		WebControl.takeScreenshot("Q2A_Regression_153_SubHeader");
		
		ReportLog.setTestCase("Q2A_Regression_153_Body");
		//EBIT
		VIPFinancialsPage.contents.EBITColumn1Data1.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data1.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data2.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data2.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data3.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data3.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data4.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data4.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data5.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data5.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data6.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data6.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data7.verifyCssValue("font-family", "Graphik-Bold");
		VIPFinancialsPage.contents.EBITColumn1Data7.verifyCssValue("color", "rgba(255, 255, 255, 1)");
		//IC
		VIPFinancialsPage.contents.ICColumn1Data1.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data1.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data2.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data2.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data3.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data3.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data4.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data4.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data5.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data5.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data6.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data6.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data7.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data7.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		WebControl.takeScreenshot("Q2A_Regression_153_Body");
		
		ReportLog.setTestCase("Q2A_Regression_153_Total");
		VIPFinancialsPage.contents.EBITTotalData.verifyText("= Adjusted EBIT");
		VIPFinancialsPage.contents.EBITTotalData.verifyCssValue("font-family", "Graphik-Bold");
		VIPFinancialsPage.contents.EBITTotalData.verifyCssValue("color", "rgba(255, 255, 255, 1)");
		VIPFinancialsPage.contents.EBITTotalData.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICTotalData.verifyText("= Invested Capital");
		VIPFinancialsPage.contents.ICTotalData.verifyCssValue("font-family", "Graphik-Bold");
		VIPFinancialsPage.contents.ICTotalData.verifyCssValue("color", "rgba(255, 255, 255, 1)");
		VIPFinancialsPage.contents.ICTotalData.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCTotalData.verifyText("= Cash Cycle");
		VIPFinancialsPage.contents.CCTotalData.verifyCssValue("font-family", "Graphik-Bold");
		VIPFinancialsPage.contents.CCTotalData.verifyCssValue("color", "rgba(255, 255, 255, 1)");
		VIPFinancialsPage.contents.CCTotalData.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		WebControl.takeScreenshot("Q2A_Regression_153_Total");
		
		ReportLog.setTestCase("Q2A_Regression_153_Scroll");
		VIPFinancialsPage.contents.ScrollUp.verifyDisplayed(true);
		//VIPFinancialsPage.contents.ScrollDown.verifyDisplayed(true);
		WebControl.takeScreenshot("Q2A_Regression_153_Scroll");
		
		ReportLog.setTestCase("Q2A_Regression_155_&_156_CAGR of EBIT Table and 153_Data Format");
		//************************   Period 1 to 3 is available   *****************************
		if (VIPFinancialsPage.contents.EBITColumnHeader4.isDisplayed()) {
		//Getting the Exponent
		String EBITColumnHeader1 = VIPFinancialsPage.contents.EBITColumnHeader1.getText();
		String[] EBITColumnHeader1_1 = EBITColumnHeader1.split("\\-");
		String EBITColumnHeader1_2 = EBITColumnHeader1_1[1];
		String EBITColumnHeader2 = VIPFinancialsPage.contents.EBITColumnHeader3.getText();
		String[] EBITColumnHeader2_1 = EBITColumnHeader2.split("\\-");
		String EBITColumnHeader2_2 = EBITColumnHeader2_1[1];
		String Date1 = "01/" + EBITColumnHeader1_2;
		String Date2 = "01/" + EBITColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String EBITColumn1Data1_1 = VIPFinancialsPage.contents.EBITColumn1Data1.getText();
		String EBITColumn2Data1_1 = VIPFinancialsPage.contents.EBITColumn2Data1.getText();
		String EBITColumn3Data1_1_1 = VIPFinancialsPage.contents.EBITColumn3Data1.getText();
		if (EBITColumn1Data1_1.contains("-") | EBITColumn2Data1_1.contains("-") | EBITColumn3Data1_1_1.contains("-") |
		EBITColumn1Data1_1.equals("0") | EBITColumn3Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data1.verifyText("N/M");}
		else {
		String EBITColumn1Data1_2 = EBITColumn1Data1_1.replace(",", "");
		double EBITColumn1Data1 = Double.parseDouble(EBITColumn1Data1_2);
		//Ending Data1
		String EBITColumn3Data1_1 = VIPFinancialsPage.contents.EBITColumn3Data1.getText();
		String EBITColumn3Data1_2 = EBITColumn3Data1_1.replace(",", "");
		double EBITColumn3Data1 = Double.parseDouble(EBITColumn3Data1_2);
		double Base1 = EBITColumn3Data1/EBITColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (EBITColumn1Data1_1.length() > 4) {
		String EBITColumn1Data1_1_a = EBITColumn1Data1_1.substring(0, EBITColumn1Data1_1.length() - 4);
		String EBITColumn1Data1_1_b = EBITColumn1Data1_1.substring(EBITColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data1.verifyText(EBITColumn1Data1_1_a + "," + EBITColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data1.verifyText(EBITColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (EBITColumn2Data1_1.length() > 4) {
		String EBITColumn2Data1_1_a = EBITColumn2Data1_1.substring(0, EBITColumn2Data1_1.length() - 4);
		String EBITColumn2Data1_1_b = EBITColumn2Data1_1.substring(EBITColumn2Data1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data1.verifyText(EBITColumn2Data1_1_a + "," + EBITColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data1.verifyText(EBITColumn2Data1_1);}
		//Validating the Data Format of Column3Data1  
		if (EBITColumn3Data1_1_1.length() > 4) {
		String EBITColumn3Data1_1_a = EBITColumn3Data1_1_1.substring(0, EBITColumn3Data1_1_1.length() - 4);
		String EBITColumn3Data1_1_b = EBITColumn3Data1_1_1.substring(EBITColumn3Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data1.verifyText(EBITColumn3Data1_1_a + "," + EBITColumn3Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data1.verifyText(EBITColumn3Data1_1_1);}
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String EBITColumn1Data2_1 = VIPFinancialsPage.contents.EBITColumn1Data2.getText();
		String EBITColumn2Data2_1 = VIPFinancialsPage.contents.EBITColumn2Data2.getText();
		String EBITColumn3Data2_1_1 = VIPFinancialsPage.contents.EBITColumn3Data2.getText();
		if (EBITColumn1Data2_1.contains("-") | EBITColumn2Data2_1.contains("-") | EBITColumn3Data2_1_1.contains("-") |
		EBITColumn1Data2_1.equals("0") | EBITColumn3Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data2.verifyText("N/M");}
		else {
		String EBITColumn1Data2_2 = EBITColumn1Data2_1.replace(",", "");
		double EBITColumn1Data2 = Double.parseDouble(EBITColumn1Data2_2);
		//Ending Data2
		String EBITColumn3Data2_1 = VIPFinancialsPage.contents.EBITColumn3Data2.getText();
		String EBITColumn3Data2_2 = EBITColumn3Data2_1.replace(",", "");
		double EBITColumn3Data2 = Double.parseDouble(EBITColumn3Data2_2);
		double Base1 = EBITColumn3Data2/EBITColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (EBITColumn1Data2_1.length() > 4) {
		String EBITColumn1Data2_1_a = EBITColumn1Data2_1.substring(0, EBITColumn1Data2_1.length() - 4);
		String EBITColumn1Data2_1_b = EBITColumn1Data2_1.substring(EBITColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data2.verifyText(EBITColumn1Data2_1_a + "," + EBITColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data2.verifyText(EBITColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (EBITColumn2Data2_1.length() > 4) {
		String EBITColumn2Data2_1_a = EBITColumn2Data2_1.substring(0, EBITColumn2Data2_1.length() - 4);
		String EBITColumn2Data2_1_b = EBITColumn2Data2_1.substring(EBITColumn2Data2_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data2.verifyText(EBITColumn2Data2_1_a + "," + EBITColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data2.verifyText(EBITColumn2Data2_1);}
		//Validating the Data Format of Column3Data2  
		if (EBITColumn3Data2_1_1.length() > 4) {
		String EBITColumn3Data2_1_a = EBITColumn3Data2_1_1.substring(0, EBITColumn3Data2_1_1.length() - 4);
		String EBITColumn3Data2_1_b = EBITColumn3Data2_1_1.substring(EBITColumn3Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data2.verifyText(EBITColumn3Data2_1_a + "," + EBITColumn3Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data2.verifyText(EBITColumn3Data2_1_1);}
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String EBITColumn1Data3_1 = VIPFinancialsPage.contents.EBITColumn1Data3.getText();
		String EBITColumn2Data3_1 = VIPFinancialsPage.contents.EBITColumn2Data3.getText();
		String EBITColumn3Data3_1_1 = VIPFinancialsPage.contents.EBITColumn3Data3.getText();
		if (EBITColumn1Data3_1.contains("-") | EBITColumn2Data3_1.contains("-") | EBITColumn3Data3_1_1.contains("-") |
		EBITColumn1Data3_1.equals("0") | EBITColumn3Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data3.verifyText("N/M");}
		else {
		String EBITColumn1Data3_2 = EBITColumn1Data3_1.replace(",", "");
		double EBITColumn1Data3 = Double.parseDouble(EBITColumn1Data3_2);
		//Ending Data3
		String EBITColumn3Data3_1 = VIPFinancialsPage.contents.EBITColumn3Data3.getText();
		String EBITColumn3Data3_2 = EBITColumn3Data3_1.replace(",", "");
		double EBITColumn3Data3 = Double.parseDouble(EBITColumn3Data3_2);
		double Base1 = EBITColumn3Data3/EBITColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (EBITColumn1Data3_1.length() > 4) {
		String EBITColumn1Data3_1_a = EBITColumn1Data3_1.substring(0, EBITColumn1Data3_1.length() - 4);
		String EBITColumn1Data3_1_b = EBITColumn1Data3_1.substring(EBITColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data3.verifyText(EBITColumn1Data3_1_a + "," + EBITColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data3.verifyText(EBITColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (EBITColumn2Data3_1.length() > 4) {
		String EBITColumn2Data3_1_a = EBITColumn2Data3_1.substring(0, EBITColumn2Data3_1.length() - 4);
		String EBITColumn2Data3_1_b = EBITColumn2Data3_1.substring(EBITColumn2Data3_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data3.verifyText(EBITColumn2Data3_1_a + "," + EBITColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data3.verifyText(EBITColumn2Data3_1);}
		//Validating the Data Format of Column3Data3  
		if (EBITColumn3Data3_1_1.length() > 4) {
		String EBITColumn3Data3_1_a = EBITColumn3Data3_1_1.substring(0, EBITColumn3Data3_1_1.length() - 4);
		String EBITColumn3Data3_1_b = EBITColumn3Data3_1_1.substring(EBITColumn3Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data3.verifyText(EBITColumn3Data3_1_a + "," + EBITColumn3Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data3.verifyText(EBITColumn3Data3_1_1);}
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String EBITColumn1Data4_1 = VIPFinancialsPage.contents.EBITColumn1Data4.getText();
		String EBITColumn2Data4_1 = VIPFinancialsPage.contents.EBITColumn2Data4.getText();
		String EBITColumn3Data4_1_1 = VIPFinancialsPage.contents.EBITColumn3Data4.getText();
		if (EBITColumn1Data4_1.contains("-") | EBITColumn2Data4_1.contains("-") | EBITColumn3Data4_1_1.contains("-") |
		EBITColumn1Data4_1.equals("0") | EBITColumn3Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data4.verifyText("N/M");}
		else {
		String EBITColumn1Data4_2 = EBITColumn1Data4_1.replace(",", "");
		double EBITColumn1Data4 = Double.parseDouble(EBITColumn1Data4_2);
		//Ending Data4
		String EBITColumn3Data4_1 = VIPFinancialsPage.contents.EBITColumn3Data4.getText();
		String EBITColumn3Data4_2 = EBITColumn3Data4_1.replace(",", "");
		double EBITColumn3Data4 = Double.parseDouble(EBITColumn3Data4_2);
		double Base1 = EBITColumn3Data4/EBITColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (EBITColumn1Data4_1.length() > 4) {
		String EBITColumn1Data4_1_a = EBITColumn1Data4_1.substring(0, EBITColumn1Data4_1.length() - 4);
		String EBITColumn1Data4_1_b = EBITColumn1Data4_1.substring(EBITColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data4.verifyText(EBITColumn1Data4_1_a + "," + EBITColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data4.verifyText(EBITColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (EBITColumn2Data4_1.length() > 4) {
		String EBITColumn2Data4_1_a = EBITColumn2Data4_1.substring(0, EBITColumn2Data4_1.length() - 4);
		String EBITColumn2Data4_1_b = EBITColumn2Data4_1.substring(EBITColumn2Data4_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data4.verifyText(EBITColumn2Data4_1_a + "," + EBITColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data4.verifyText(EBITColumn2Data4_1);}
		//Validating the Data Format of Column3Data4  
		if (EBITColumn3Data4_1_1.length() > 4) {
		String EBITColumn3Data4_1_a = EBITColumn3Data4_1_1.substring(0, EBITColumn3Data4_1_1.length() - 4);
		String EBITColumn3Data4_1_b = EBITColumn3Data4_1_1.substring(EBITColumn3Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data4.verifyText(EBITColumn3Data4_1_a + "," + EBITColumn3Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data4.verifyText(EBITColumn3Data4_1_1);}
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String EBITColumn1Data5_1 = VIPFinancialsPage.contents.EBITColumn1Data5.getText();
		String EBITColumn2Data5_1 = VIPFinancialsPage.contents.EBITColumn2Data5.getText();
		String EBITColumn3Data5_1_1 = VIPFinancialsPage.contents.EBITColumn3Data5.getText();
		if (EBITColumn1Data5_1.contains("-") | EBITColumn2Data5_1.contains("-") | EBITColumn3Data5_1_1.contains("-") |
		EBITColumn1Data5_1.equals("0") | EBITColumn3Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data5.verifyText("N/M");}
		else {
		String EBITColumn1Data5_2 = EBITColumn1Data5_1.replace(",", "");
		double EBITColumn1Data5 = Double.parseDouble(EBITColumn1Data5_2);
		//Ending Data5
		String EBITColumn3Data5_1 = VIPFinancialsPage.contents.EBITColumn3Data5.getText();
		String EBITColumn3Data5_2 = EBITColumn3Data5_1.replace(",", "");
		double EBITColumn3Data5 = Double.parseDouble(EBITColumn3Data5_2);
		double Base1 = EBITColumn3Data5/EBITColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (EBITColumn1Data5_1.length() > 4) {
		String EBITColumn1Data5_1_a = EBITColumn1Data5_1.substring(0, EBITColumn1Data5_1.length() - 4);
		String EBITColumn1Data5_1_b = EBITColumn1Data5_1.substring(EBITColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data5.verifyText(EBITColumn1Data5_1_a + "," + EBITColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data5.verifyText(EBITColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (EBITColumn2Data5_1.length() > 4) {
		String EBITColumn2Data5_1_a = EBITColumn2Data5_1.substring(0, EBITColumn2Data5_1.length() - 4);
		String EBITColumn2Data5_1_b = EBITColumn2Data5_1.substring(EBITColumn2Data5_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data5.verifyText(EBITColumn2Data5_1_a + "," + EBITColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data5.verifyText(EBITColumn2Data5_1);}
		//Validating the Data Format of Column3Data5  
		if (EBITColumn3Data5_1_1.length() > 4) {
		String EBITColumn3Data5_1_a = EBITColumn3Data5_1_1.substring(0, EBITColumn3Data5_1_1.length() - 4);
		String EBITColumn3Data5_1_b = EBITColumn3Data5_1_1.substring(EBITColumn3Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data5.verifyText(EBITColumn3Data5_1_a + "," + EBITColumn3Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data5.verifyText(EBITColumn3Data5_1_1);}
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String EBITColumn1Data6_1 = VIPFinancialsPage.contents.EBITColumn1Data6.getText();
		String EBITColumn2Data6_1 = VIPFinancialsPage.contents.EBITColumn2Data6.getText();
		String EBITColumn3Data6_1_1 = VIPFinancialsPage.contents.EBITColumn3Data6.getText();
		if (EBITColumn1Data6_1.contains("-") | EBITColumn2Data6_1.contains("-") | EBITColumn3Data6_1_1.contains("-") |
		EBITColumn1Data6_1.equals("0") | EBITColumn3Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data6.verifyText("N/M");}
		else {
		String EBITColumn1Data6_2 = EBITColumn1Data6_1.replace(",", "");
		double EBITColumn1Data6 = Double.parseDouble(EBITColumn1Data6_2);
		//Ending Data6
		String EBITColumn3Data6_1 = VIPFinancialsPage.contents.EBITColumn3Data6.getText();
		String EBITColumn3Data6_2 = EBITColumn3Data6_1.replace(",", "");
		double EBITColumn3Data6 = Double.parseDouble(EBITColumn3Data6_2);
		double Base1 = EBITColumn3Data6/EBITColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (EBITColumn1Data6_1.length() > 4) {
		String EBITColumn1Data6_1_a = EBITColumn1Data6_1.substring(0, EBITColumn1Data6_1.length() - 4);
		String EBITColumn1Data6_1_b = EBITColumn1Data6_1.substring(EBITColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data6.verifyText(EBITColumn1Data6_1_a + "," + EBITColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data6.verifyText(EBITColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (EBITColumn2Data6_1.length() > 4) {
		String EBITColumn2Data6_1_a = EBITColumn2Data6_1.substring(0, EBITColumn2Data6_1.length() - 4);
		String EBITColumn2Data6_1_b = EBITColumn2Data6_1.substring(EBITColumn2Data6_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data6.verifyText(EBITColumn2Data6_1_a + "," + EBITColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data6.verifyText(EBITColumn2Data6_1);}
		//Validating the Data Format of Column3Data6  
		if (EBITColumn3Data6_1_1.length() > 4) {
		String EBITColumn3Data6_1_a = EBITColumn3Data6_1_1.substring(0, EBITColumn3Data6_1_1.length() - 4);
		String EBITColumn3Data6_1_b = EBITColumn3Data6_1_1.substring(EBITColumn3Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data6.verifyText(EBITColumn3Data6_1_a + "," + EBITColumn3Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data6.verifyText(EBITColumn3Data6_1_1);}
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String EBITColumn1Data7_1 = VIPFinancialsPage.contents.EBITColumn1Data7.getText();
		String EBITColumn2Data7_1 = VIPFinancialsPage.contents.EBITColumn2Data7.getText();
		String EBITColumn3Data7_1_1 = VIPFinancialsPage.contents.EBITColumn3Data7.getText();
		if (EBITColumn1Data7_1.contains("-") | EBITColumn2Data7_1.contains("-") | EBITColumn3Data7_1_1.contains("-") |
		EBITColumn1Data7_1.equals("0") | EBITColumn3Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data7.verifyText("N/M");}
		else {
		String EBITColumn1Data7_2 = EBITColumn1Data7_1.replace(",", "");
		double EBITColumn1Data7 = Double.parseDouble(EBITColumn1Data7_2);
		//Ending Data7
		String EBITColumn3Data7_1 = VIPFinancialsPage.contents.EBITColumn3Data7.getText();
		String EBITColumn3Data7_2 = EBITColumn3Data7_1.replace(",", "");
		double EBITColumn3Data7 = Double.parseDouble(EBITColumn3Data7_2);
		double Base1 = EBITColumn3Data7/EBITColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (EBITColumn1Data7_1.length() > 4) {
		String EBITColumn1Data7_1_a = EBITColumn1Data7_1.substring(0, EBITColumn1Data7_1.length() - 4);
		String EBITColumn1Data7_1_b = EBITColumn1Data7_1.substring(EBITColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data7.verifyText(EBITColumn1Data7_1_a + "," + EBITColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data7.verifyText(EBITColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (EBITColumn2Data7_1.length() > 4) {
		String EBITColumn2Data7_1_a = EBITColumn2Data7_1.substring(0, EBITColumn2Data7_1.length() - 4);
		String EBITColumn2Data7_1_b = EBITColumn2Data7_1.substring(EBITColumn2Data7_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data7.verifyText(EBITColumn2Data7_1_a + "," + EBITColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data7.verifyText(EBITColumn2Data7_1);}
		//Validating the Data Format of Column3Data7  
		if (EBITColumn3Data7_1_1.length() > 4) {
		String EBITColumn3Data7_1_a = EBITColumn3Data7_1_1.substring(0, EBITColumn3Data7_1_1.length() - 4);
		String EBITColumn3Data7_1_b = EBITColumn3Data7_1_1.substring(EBITColumn3Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data7.verifyText(EBITColumn3Data7_1_a + "," + EBITColumn3Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data7.verifyText(EBITColumn3Data7_1_1);}}
		
		//************************   Period 1 to 2 is available   ******************************
		else if (VIPFinancialsPage.contents.EBITColumnHeader3.isDisplayed()) {
		//Getting the Exponent
		String EBITColumnHeader1 = VIPFinancialsPage.contents.EBITColumnHeader1.getText();
		String[] EBITColumnHeader1_1 = EBITColumnHeader1.split("\\-");
		String EBITColumnHeader1_2 = EBITColumnHeader1_1[1];
		String EBITColumnHeader2 = VIPFinancialsPage.contents.EBITColumnHeader2.getText();
		String[] EBITColumnHeader2_1 = EBITColumnHeader2.split("\\-");
		String EBITColumnHeader2_2 = EBITColumnHeader2_1[1];
		String Date1 = "01/" + EBITColumnHeader1_2;
		String Date2 = "01/" + EBITColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String EBITColumn1Data1_1 = VIPFinancialsPage.contents.EBITColumn1Data1.getText();
		String EBITColumn2Data1_1_1 = VIPFinancialsPage.contents.EBITColumn2Data1.getText();
		if (EBITColumn1Data1_1.contains("-") | EBITColumn2Data1_1_1.contains("-") |
		EBITColumn1Data1_1.equals("0") | EBITColumn2Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data1.verifyText("N/M");}
		else {
		String EBITColumn1Data1_2 = EBITColumn1Data1_1.replace(",", "");
		double EBITColumn1Data1 = Double.parseDouble(EBITColumn1Data1_2);
		//Ending Data1
		String EBITColumn2Data1_1 = VIPFinancialsPage.contents.EBITColumn2Data1.getText();
		String EBITColumn2Data1_2 = EBITColumn2Data1_1.replace(",", "");
		double EBITColumn2Data1 = Double.parseDouble(EBITColumn2Data1_2);
		double Base1 = EBITColumn2Data1/EBITColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (EBITColumn1Data1_1.length() > 4) {
		String EBITColumn1Data1_1_a = EBITColumn1Data1_1.substring(0, EBITColumn1Data1_1.length() - 4);
		String EBITColumn1Data1_1_b = EBITColumn1Data1_1.substring(EBITColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data1.verifyText(EBITColumn1Data1_1_a + "," + EBITColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data1.verifyText(EBITColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (EBITColumn2Data1_1_1.length() > 4) {
		String EBITColumn2Data1_1_a = EBITColumn2Data1_1_1.substring(0, EBITColumn2Data1_1_1.length() - 4);
		String EBITColumn2Data1_1_b = EBITColumn2Data1_1_1.substring(EBITColumn2Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data1.verifyText(EBITColumn2Data1_1_a + "," + EBITColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data1.verifyText(EBITColumn2Data1_1_1);}
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String EBITColumn1Data2_1 = VIPFinancialsPage.contents.EBITColumn1Data2.getText();
		String EBITColumn2Data2_1_1 = VIPFinancialsPage.contents.EBITColumn2Data2.getText();
		if (EBITColumn1Data2_1.contains("-") | EBITColumn2Data2_1_1.contains("-") |
		EBITColumn1Data2_1.equals("0") | EBITColumn2Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data2.verifyText("N/M");}
		else {
		String EBITColumn1Data2_2 = EBITColumn1Data2_1.replace(",", "");
		double EBITColumn1Data2 = Double.parseDouble(EBITColumn1Data2_2);
		//Ending Data2
		String EBITColumn2Data2_1 = VIPFinancialsPage.contents.EBITColumn2Data2.getText();
		String EBITColumn2Data2_2 = EBITColumn2Data2_1.replace(",", "");
		double EBITColumn2Data2 = Double.parseDouble(EBITColumn2Data2_2);
		double Base1 = EBITColumn2Data2/EBITColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (EBITColumn1Data2_1.length() > 4) {
		String EBITColumn1Data2_1_a = EBITColumn1Data2_1.substring(0, EBITColumn1Data2_1.length() - 4);
		String EBITColumn1Data2_1_b = EBITColumn1Data2_1.substring(EBITColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data2.verifyText(EBITColumn1Data2_1_a + "," + EBITColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data2.verifyText(EBITColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (EBITColumn2Data2_1_1.length() > 4) {
		String EBITColumn2Data2_1_a = EBITColumn2Data2_1_1.substring(0, EBITColumn2Data2_1_1.length() - 4);
		String EBITColumn2Data2_1_b = EBITColumn2Data2_1_1.substring(EBITColumn2Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data2.verifyText(EBITColumn2Data2_1_a + "," + EBITColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data2.verifyText(EBITColumn2Data2_1_1);}
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String EBITColumn1Data3_1 = VIPFinancialsPage.contents.EBITColumn1Data3.getText();
		String EBITColumn2Data3_1_1 = VIPFinancialsPage.contents.EBITColumn2Data3.getText();
		if (EBITColumn1Data3_1.contains("-") | EBITColumn2Data3_1_1.contains("-") |
		EBITColumn1Data3_1.equals("0") | EBITColumn2Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data3.verifyText("N/M");}
		else {
		String EBITColumn1Data3_2 = EBITColumn1Data3_1.replace(",", "");
		double EBITColumn1Data3 = Double.parseDouble(EBITColumn1Data3_2);
		//Ending Data3
		String EBITColumn2Data3_1 = VIPFinancialsPage.contents.EBITColumn2Data3.getText();
		String EBITColumn2Data3_2 = EBITColumn2Data3_1.replace(",", "");
		double EBITColumn2Data3 = Double.parseDouble(EBITColumn2Data3_2);
		double Base1 = EBITColumn2Data3/EBITColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (EBITColumn1Data3_1.length() > 4) {
		String EBITColumn1Data3_1_a = EBITColumn1Data3_1.substring(0, EBITColumn1Data3_1.length() - 4);
		String EBITColumn1Data3_1_b = EBITColumn1Data3_1.substring(EBITColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data3.verifyText(EBITColumn1Data3_1_a + "," + EBITColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data3.verifyText(EBITColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (EBITColumn2Data3_1_1.length() > 4) {
		String EBITColumn2Data3_1_a = EBITColumn2Data3_1_1.substring(0, EBITColumn2Data3_1_1.length() - 4);
		String EBITColumn2Data3_1_b = EBITColumn2Data3_1_1.substring(EBITColumn2Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data3.verifyText(EBITColumn2Data3_1_a + "," + EBITColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data3.verifyText(EBITColumn2Data3_1_1);}
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String EBITColumn1Data4_1 = VIPFinancialsPage.contents.EBITColumn1Data4.getText();
		String EBITColumn2Data4_1_1 = VIPFinancialsPage.contents.EBITColumn2Data4.getText();
		if (EBITColumn1Data4_1.contains("-") | EBITColumn2Data4_1_1.contains("-") |
		EBITColumn1Data4_1.equals("0") | EBITColumn2Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data4.verifyText("N/M");}
		else {
		String EBITColumn1Data4_2 = EBITColumn1Data4_1.replace(",", "");
		double EBITColumn1Data4 = Double.parseDouble(EBITColumn1Data4_2);
		//Ending Data4
		String EBITColumn2Data4_1 = VIPFinancialsPage.contents.EBITColumn2Data4.getText();
		String EBITColumn2Data4_2 = EBITColumn2Data4_1.replace(",", "");
		double EBITColumn2Data4 = Double.parseDouble(EBITColumn2Data4_2);
		double Base1 = EBITColumn2Data4/EBITColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (EBITColumn1Data4_1.length() > 4) {
		String EBITColumn1Data4_1_a = EBITColumn1Data4_1.substring(0, EBITColumn1Data4_1.length() - 4);
		String EBITColumn1Data4_1_b = EBITColumn1Data4_1.substring(EBITColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data4.verifyText(EBITColumn1Data4_1_a + "," + EBITColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data4.verifyText(EBITColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (EBITColumn2Data4_1_1.length() > 4) {
		String EBITColumn2Data4_1_a = EBITColumn2Data4_1_1.substring(0, EBITColumn2Data4_1_1.length() - 4);
		String EBITColumn2Data4_1_b = EBITColumn2Data4_1_1.substring(EBITColumn2Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data4.verifyText(EBITColumn2Data4_1_a + "," + EBITColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data4.verifyText(EBITColumn2Data4_1_1);}
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String EBITColumn1Data5_1 = VIPFinancialsPage.contents.EBITColumn1Data5.getText();
		String EBITColumn2Data5_1_1 = VIPFinancialsPage.contents.EBITColumn2Data5.getText();
		if (EBITColumn1Data5_1.contains("-") | EBITColumn2Data5_1_1.contains("-") |
		EBITColumn1Data5_1.equals("0") | EBITColumn2Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data5.verifyText("N/M");}
		else {
		String EBITColumn1Data5_2 = EBITColumn1Data5_1.replace(",", "");
		double EBITColumn1Data5 = Double.parseDouble(EBITColumn1Data5_2);
		//Ending Data5
		String EBITColumn2Data5_1 = VIPFinancialsPage.contents.EBITColumn2Data5.getText();
		String EBITColumn2Data5_2 = EBITColumn2Data5_1.replace(",", "");
		double EBITColumn2Data5 = Double.parseDouble(EBITColumn2Data5_2);
		double Base1 = EBITColumn2Data5/EBITColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (EBITColumn1Data5_1.length() > 4) {
		String EBITColumn1Data5_1_a = EBITColumn1Data5_1.substring(0, EBITColumn1Data5_1.length() - 4);
		String EBITColumn1Data5_1_b = EBITColumn1Data5_1.substring(EBITColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data5.verifyText(EBITColumn1Data5_1_a + "," + EBITColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data5.verifyText(EBITColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (EBITColumn2Data5_1_1.length() > 4) {
		String EBITColumn2Data5_1_a = EBITColumn2Data5_1_1.substring(0, EBITColumn2Data5_1_1.length() - 4);
		String EBITColumn2Data5_1_b = EBITColumn2Data5_1_1.substring(EBITColumn2Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data5.verifyText(EBITColumn2Data5_1_a + "," + EBITColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data5.verifyText(EBITColumn2Data5_1_1);}
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String EBITColumn1Data6_1 = VIPFinancialsPage.contents.EBITColumn1Data6.getText();
		String EBITColumn2Data6_1_1 = VIPFinancialsPage.contents.EBITColumn2Data6.getText();
		if (EBITColumn1Data6_1.contains("-") | EBITColumn2Data6_1_1.contains("-") |
		EBITColumn1Data6_1.equals("0") | EBITColumn2Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data6.verifyText("N/M");}
		else {
		String EBITColumn1Data6_2 = EBITColumn1Data6_1.replace(",", "");
		double EBITColumn1Data6 = Double.parseDouble(EBITColumn1Data6_2);
		//Ending Data6
		String EBITColumn2Data6_1 = VIPFinancialsPage.contents.EBITColumn2Data6.getText();
		String EBITColumn2Data6_2 = EBITColumn2Data6_1.replace(",", "");
		double EBITColumn2Data6 = Double.parseDouble(EBITColumn2Data6_2);
		double Base1 = EBITColumn2Data6/EBITColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (EBITColumn1Data6_1.length() > 4) {
		String EBITColumn1Data6_1_a = EBITColumn1Data6_1.substring(0, EBITColumn1Data6_1.length() - 4);
		String EBITColumn1Data6_1_b = EBITColumn1Data6_1.substring(EBITColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data6.verifyText(EBITColumn1Data6_1_a + "," + EBITColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data6.verifyText(EBITColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (EBITColumn2Data6_1_1.length() > 4) {
		String EBITColumn2Data6_1_a = EBITColumn2Data6_1_1.substring(0, EBITColumn2Data6_1_1.length() - 4);
		String EBITColumn2Data6_1_b = EBITColumn2Data6_1_1.substring(EBITColumn2Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data6.verifyText(EBITColumn2Data6_1_a + "," + EBITColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data6.verifyText(EBITColumn2Data6_1_1);}
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String EBITColumn1Data7_1 = VIPFinancialsPage.contents.EBITColumn1Data7.getText();
		String EBITColumn2Data7_1_1 = VIPFinancialsPage.contents.EBITColumn2Data7.getText();
		if (EBITColumn1Data7_1.contains("-") | EBITColumn2Data7_1_1.contains("-") |
		EBITColumn1Data7_1.equals("0") | EBITColumn2Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data7.verifyText("N/M");}
		else {
		String EBITColumn1Data7_2 = EBITColumn1Data7_1.replace(",", "");
		double EBITColumn1Data7 = Double.parseDouble(EBITColumn1Data7_2);
		//Ending Data7
		String EBITColumn2Data7_1 = VIPFinancialsPage.contents.EBITColumn2Data7.getText();
		String EBITColumn2Data7_2 = EBITColumn2Data7_1.replace(",", "");
		double EBITColumn2Data7 = Double.parseDouble(EBITColumn2Data7_2);
		double Base1 = EBITColumn2Data7/EBITColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (EBITColumn1Data7_1.length() > 4) {
		String EBITColumn1Data7_1_a = EBITColumn1Data7_1.substring(0, EBITColumn1Data7_1.length() - 4);
		String EBITColumn1Data7_1_b = EBITColumn1Data7_1.substring(EBITColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data7.verifyText(EBITColumn1Data7_1_a + "," + EBITColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data7.verifyText(EBITColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (EBITColumn2Data7_1_1.length() > 4) {
		String EBITColumn2Data7_1_a = EBITColumn2Data7_1_1.substring(0, EBITColumn2Data7_1_1.length() - 4);
		String EBITColumn2Data7_1_b = EBITColumn2Data7_1_1.substring(EBITColumn2Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data7.verifyText(EBITColumn2Data7_1_a + "," + EBITColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data7.verifyText(EBITColumn2Data7_1_1);}}
		
		//*************************   Period 1 is available   *******************************
		else {
		VIPFinancialsPage.contents.EBITColumn2Data1.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data2.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data3.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data4.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data5.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data6.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data7.verifyText("N/M");}
		WebControl.takeScreenshot("Q2A_Regression_155_&_156_CAGR of EBIT Table");
		
		ReportLog.setTestCase("Q2A_Regression_155_&_156_CAGR of IC Table and 153_Data Format");
		//************************   Period 1 to 4 is available   *****************************
		if (VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed()) {
		//Getting the Exponent
		String ICColumnHeader1 = VIPFinancialsPage.contents.ICColumnHeader1.getText();
		String[] ICColumnHeader1_1 = ICColumnHeader1.split("\\-");
		String ICColumnHeader1_2 = ICColumnHeader1_1[1];
		String ICColumnHeader2 = VIPFinancialsPage.contents.ICColumnHeader4.getText();
		String[] ICColumnHeader2_1 = ICColumnHeader2.split("\\-");
		String ICColumnHeader2_2 = ICColumnHeader2_1[1];
		String Date1 = "01/" + ICColumnHeader1_2;
		String Date2 = "01/" + ICColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String ICColumn1Data1_1 = VIPFinancialsPage.contents.ICColumn1Data1.getText();
		String ICColumn2Data1_1 = VIPFinancialsPage.contents.ICColumn2Data1.getText();
		String ICColumn3Data1_1 = VIPFinancialsPage.contents.ICColumn3Data1.getText();
		String ICColumn4Data1_1_1 = VIPFinancialsPage.contents.ICColumn4Data1.getText();
		if (ICColumn1Data1_1.contains("-") | ICColumn2Data1_1.contains("-") | ICColumn3Data1_1.contains("-") | ICColumn4Data1_1_1.contains("-") |
		ICColumn1Data1_1.equals("0") | ICColumn4Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data1.verifyText("N/M");}
		else {
		String ICColumn1Data1_2 = ICColumn1Data1_1.replace(",", "");
		double ICColumn1Data1 = Double.parseDouble(ICColumn1Data1_2);
		//Ending Data1
		String ICColumn4Data1_1 = VIPFinancialsPage.contents.ICColumn4Data1.getText();
		String ICColumn4Data1_2 = ICColumn4Data1_1.replace(",", "");
		double ICColumn4Data1 = Double.parseDouble(ICColumn4Data1_2);
		double Base1 = ICColumn4Data1/ICColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (ICColumn1Data1_1.length() > 4) {
		String ICColumn1Data1_1_a = ICColumn1Data1_1.substring(0, ICColumn1Data1_1.length() - 4);
		String ICColumn1Data1_1_b = ICColumn1Data1_1.substring(ICColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1_a + "," + ICColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (ICColumn2Data1_1.length() > 4) {
		String ICColumn2Data1_1_a = ICColumn2Data1_1.substring(0, ICColumn2Data1_1.length() - 4);
		String ICColumn2Data1_1_b = ICColumn2Data1_1.substring(ICColumn2Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1_a + "," + ICColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1);}
		//Validating the Data Format of Column3Data1  
		if (ICColumn3Data1_1.length() > 4) {
		String ICColumn3Data1_1_a = ICColumn3Data1_1.substring(0, ICColumn3Data1_1.length() - 4);
		String ICColumn3Data1_1_b = ICColumn3Data1_1.substring(ICColumn3Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data1.verifyText(ICColumn3Data1_1_a + "," + ICColumn3Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data1.verifyText(ICColumn3Data1_1);}
		//Validating the Data Format of Column4Data1  
		if (ICColumn4Data1_1_1.length() > 4) {
		String ICColumn4Data1_1_a = ICColumn4Data1_1_1.substring(0, ICColumn4Data1_1_1.length() - 4);
		String ICColumn4Data1_1_b = ICColumn4Data1_1_1.substring(ICColumn4Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data1.verifyText(ICColumn4Data1_1_a + "," + ICColumn4Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data1.verifyText(ICColumn4Data1_1_1);}
		
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String ICColumn1Data2_1 = VIPFinancialsPage.contents.ICColumn1Data2.getText();
		String ICColumn2Data2_1 = VIPFinancialsPage.contents.ICColumn2Data2.getText();
		String ICColumn3Data2_1 = VIPFinancialsPage.contents.ICColumn3Data2.getText();
		String ICColumn4Data2_1_1 = VIPFinancialsPage.contents.ICColumn4Data2.getText();
		if (ICColumn1Data2_1.contains("-") | ICColumn2Data2_1.contains("-") | ICColumn3Data2_1.contains("-") | ICColumn4Data2_1_1.contains("-") |
		ICColumn1Data2_1.equals("0") | ICColumn4Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data2.verifyText("N/M");}
		else {
		String ICColumn1Data2_2 = ICColumn1Data2_1.replace(",", "");
		double ICColumn1Data2 = Double.parseDouble(ICColumn1Data2_2);
		//Ending Data2
		String ICColumn4Data2_1 = VIPFinancialsPage.contents.ICColumn4Data2.getText();
		String ICColumn4Data2_2 = ICColumn4Data2_1.replace(",", "");
		double ICColumn4Data2 = Double.parseDouble(ICColumn4Data2_2);
		double Base1 = ICColumn4Data2/ICColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (ICColumn1Data2_1.length() > 4) {
		String ICColumn1Data2_1_a = ICColumn1Data2_1.substring(0, ICColumn1Data2_1.length() - 4);
		String ICColumn1Data2_1_b = ICColumn1Data2_1.substring(ICColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1_a + "," + ICColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (ICColumn2Data2_1.length() > 4) {
		String ICColumn2Data2_1_a = ICColumn2Data2_1.substring(0, ICColumn2Data2_1.length() - 4);
		String ICColumn2Data2_1_b = ICColumn2Data2_1.substring(ICColumn2Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1_a + "," + ICColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1);}
		//Validating the Data Format of Column3Data2  
		if (ICColumn3Data2_1.length() > 4) {
		String ICColumn3Data2_1_a = ICColumn3Data2_1.substring(0, ICColumn3Data2_1.length() - 4);
		String ICColumn3Data2_1_b = ICColumn3Data2_1.substring(ICColumn3Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data2.verifyText(ICColumn3Data2_1_a + "," + ICColumn3Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data2.verifyText(ICColumn3Data2_1);}
		//Validating the Data Format of Column4Data2  
		if (ICColumn4Data2_1_1.length() > 4) {
		String ICColumn4Data2_1_a = ICColumn4Data2_1_1.substring(0, ICColumn4Data2_1_1.length() - 4);
		String ICColumn4Data2_1_b = ICColumn4Data2_1_1.substring(ICColumn4Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data2.verifyText(ICColumn4Data2_1_a + "," + ICColumn4Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data2.verifyText(ICColumn4Data2_1_1);}
		
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String ICColumn1Data3_1 = VIPFinancialsPage.contents.ICColumn1Data3.getText();
		String ICColumn2Data3_1 = VIPFinancialsPage.contents.ICColumn2Data3.getText();
		String ICColumn3Data3_1 = VIPFinancialsPage.contents.ICColumn3Data3.getText();
		String ICColumn4Data3_1_1 = VIPFinancialsPage.contents.ICColumn4Data3.getText();
		if (ICColumn1Data3_1.contains("-") | ICColumn2Data3_1.contains("-") | ICColumn3Data3_1.contains("-") | ICColumn4Data3_1_1.contains("-") |
		ICColumn1Data3_1.equals("0") | ICColumn4Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data3.verifyText("N/M");}
		else {
		String ICColumn1Data3_2 = ICColumn1Data3_1.replace(",", "");
		double ICColumn1Data3 = Double.parseDouble(ICColumn1Data3_2);
		//Ending Data3
		String ICColumn4Data3_1 = VIPFinancialsPage.contents.ICColumn4Data3.getText();
		String ICColumn4Data3_2 = ICColumn4Data3_1.replace(",", "");
		double ICColumn4Data3 = Double.parseDouble(ICColumn4Data3_2);
		double Base1 = ICColumn4Data3/ICColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (ICColumn1Data3_1.length() > 4) {
		String ICColumn1Data3_1_a = ICColumn1Data3_1.substring(0, ICColumn1Data3_1.length() - 4);
		String ICColumn1Data3_1_b = ICColumn1Data3_1.substring(ICColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1_a + "," + ICColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (ICColumn2Data3_1.length() > 4) {
		String ICColumn2Data3_1_a = ICColumn2Data3_1.substring(0, ICColumn2Data3_1.length() - 4);
		String ICColumn2Data3_1_b = ICColumn2Data3_1.substring(ICColumn2Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1_a + "," + ICColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1);}
		//Validating the Data Format of Column3Data3  
		if (ICColumn3Data3_1.length() > 4) {
		String ICColumn3Data3_1_a = ICColumn3Data3_1.substring(0, ICColumn3Data3_1.length() - 4);
		String ICColumn3Data3_1_b = ICColumn3Data3_1.substring(ICColumn3Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data3.verifyText(ICColumn3Data3_1_a + "," + ICColumn3Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data3.verifyText(ICColumn3Data3_1);}
		//Validating the Data Format of Column4Data3  
		if (ICColumn4Data3_1_1.length() > 4) {
		String ICColumn4Data3_1_a = ICColumn4Data3_1_1.substring(0, ICColumn4Data3_1_1.length() - 4);
		String ICColumn4Data3_1_b = ICColumn4Data3_1_1.substring(ICColumn4Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data3.verifyText(ICColumn4Data3_1_a + "," + ICColumn4Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data3.verifyText(ICColumn4Data3_1_1);}
		
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String ICColumn1Data4_1 = VIPFinancialsPage.contents.ICColumn1Data4.getText();
		String ICColumn2Data4_1 = VIPFinancialsPage.contents.ICColumn2Data4.getText();
		String ICColumn3Data4_1 = VIPFinancialsPage.contents.ICColumn3Data4.getText();
		String ICColumn4Data4_1_1 = VIPFinancialsPage.contents.ICColumn4Data4.getText();
		if (ICColumn1Data4_1.contains("-") | ICColumn2Data4_1.contains("-") | ICColumn3Data4_1.contains("-") | ICColumn4Data4_1_1.contains("-") |
		ICColumn1Data4_1.equals("0") | ICColumn4Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data4.verifyText("N/M");}
		else {
		String ICColumn1Data4_2 = ICColumn1Data4_1.replace(",", "");
		double ICColumn1Data4 = Double.parseDouble(ICColumn1Data4_2);
		//Ending Data4
		String ICColumn4Data4_1 = VIPFinancialsPage.contents.ICColumn4Data4.getText();
		String ICColumn4Data4_2 = ICColumn4Data4_1.replace(",", "");
		double ICColumn4Data4 = Double.parseDouble(ICColumn4Data4_2);
		double Base1 = ICColumn4Data4/ICColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (ICColumn1Data4_1.length() > 4) {
		String ICColumn1Data4_1_a = ICColumn1Data4_1.substring(0, ICColumn1Data4_1.length() - 4);
		String ICColumn1Data4_1_b = ICColumn1Data4_1.substring(ICColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1_a + "," + ICColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (ICColumn2Data4_1.length() > 4) {
		String ICColumn2Data4_1_a = ICColumn2Data4_1.substring(0, ICColumn2Data4_1.length() - 4);
		String ICColumn2Data4_1_b = ICColumn2Data4_1.substring(ICColumn2Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1_a + "," + ICColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1);}
		//Validating the Data Format of Column3Data4  
		if (ICColumn3Data4_1.length() > 4) {
		String ICColumn3Data4_1_a = ICColumn3Data4_1.substring(0, ICColumn3Data4_1.length() - 4);
		String ICColumn3Data4_1_b = ICColumn3Data4_1.substring(ICColumn3Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data4.verifyText(ICColumn3Data4_1_a + "," + ICColumn3Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data4.verifyText(ICColumn3Data4_1);}
		//Validating the Data Format of Column4Data4  
		if (ICColumn4Data4_1_1.length() > 4) {
		String ICColumn4Data4_1_a = ICColumn4Data4_1_1.substring(0, ICColumn4Data4_1_1.length() - 4);
		String ICColumn4Data4_1_b = ICColumn4Data4_1_1.substring(ICColumn4Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data4.verifyText(ICColumn4Data4_1_a + "," + ICColumn4Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data4.verifyText(ICColumn4Data4_1_1);}
		
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String ICColumn1Data5_1 = VIPFinancialsPage.contents.ICColumn1Data5.getText();
		String ICColumn2Data5_1 = VIPFinancialsPage.contents.ICColumn2Data5.getText();
		String ICColumn3Data5_1 = VIPFinancialsPage.contents.ICColumn3Data5.getText();
		String ICColumn4Data5_1_1 = VIPFinancialsPage.contents.ICColumn4Data5.getText();
		if (ICColumn1Data5_1.contains("-") | ICColumn2Data5_1.contains("-") | ICColumn3Data5_1.contains("-") | ICColumn4Data5_1_1.contains("-") |
		ICColumn1Data5_1.equals("0") | ICColumn4Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data5.verifyText("N/M");}
		else {
		String ICColumn1Data5_2 = ICColumn1Data5_1.replace(",", "");
		double ICColumn1Data5 = Double.parseDouble(ICColumn1Data5_2);
		//Ending Data5
		String ICColumn4Data5_1 = VIPFinancialsPage.contents.ICColumn4Data5.getText();
		String ICColumn4Data5_2 = ICColumn4Data5_1.replace(",", "");
		double ICColumn4Data5 = Double.parseDouble(ICColumn4Data5_2);
		double Base1 = ICColumn4Data5/ICColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (ICColumn1Data5_1.length() > 4) {
		String ICColumn1Data5_1_a = ICColumn1Data5_1.substring(0, ICColumn1Data5_1.length() - 4);
		String ICColumn1Data5_1_b = ICColumn1Data5_1.substring(ICColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1_a + "," + ICColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (ICColumn2Data5_1.length() > 4) {
		String ICColumn2Data5_1_a = ICColumn2Data5_1.substring(0, ICColumn2Data5_1.length() - 4);
		String ICColumn2Data5_1_b = ICColumn2Data5_1.substring(ICColumn2Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1_a + "," + ICColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1);}
		//Validating the Data Format of Column3Data5  
		if (ICColumn3Data5_1.length() > 4) {
		String ICColumn3Data5_1_a = ICColumn3Data5_1.substring(0, ICColumn3Data5_1.length() - 4);
		String ICColumn3Data5_1_b = ICColumn3Data5_1.substring(ICColumn3Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data5.verifyText(ICColumn3Data5_1_a + "," + ICColumn3Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data5.verifyText(ICColumn3Data5_1);}
		//Validating the Data Format of Column4Data5  
		if (ICColumn4Data5_1_1.length() > 4) {
		String ICColumn4Data5_1_a = ICColumn4Data5_1_1.substring(0, ICColumn4Data5_1_1.length() - 4);
		String ICColumn4Data5_1_b = ICColumn4Data5_1_1.substring(ICColumn4Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data5.verifyText(ICColumn4Data5_1_a + "," + ICColumn4Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data5.verifyText(ICColumn4Data5_1_1);}
		
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String ICColumn1Data6_1 = VIPFinancialsPage.contents.ICColumn1Data6.getText();
		String ICColumn2Data6_1 = VIPFinancialsPage.contents.ICColumn2Data6.getText();
		String ICColumn3Data6_1 = VIPFinancialsPage.contents.ICColumn3Data6.getText();
		String ICColumn4Data6_1_1 = VIPFinancialsPage.contents.ICColumn4Data6.getText();
		if (ICColumn1Data6_1.contains("-") | ICColumn2Data6_1.contains("-") | ICColumn3Data6_1.contains("-") | ICColumn4Data6_1_1.contains("-") |
		ICColumn1Data6_1.equals("0") | ICColumn4Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data6.verifyText("N/M");}
		else {
		String ICColumn1Data6_2 = ICColumn1Data6_1.replace(",", "");
		double ICColumn1Data6 = Double.parseDouble(ICColumn1Data6_2);
		//Ending Data6
		String ICColumn4Data6_1 = VIPFinancialsPage.contents.ICColumn4Data6.getText();
		String ICColumn4Data6_2 = ICColumn4Data6_1.replace(",", "");
		double ICColumn4Data6 = Double.parseDouble(ICColumn4Data6_2);
		double Base1 = ICColumn4Data6/ICColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (ICColumn1Data6_1.length() > 4) {
		String ICColumn1Data6_1_a = ICColumn1Data6_1.substring(0, ICColumn1Data6_1.length() - 4);
		String ICColumn1Data6_1_b = ICColumn1Data6_1.substring(ICColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1_a + "," + ICColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (ICColumn2Data6_1.length() > 4) {
		String ICColumn2Data6_1_a = ICColumn2Data6_1.substring(0, ICColumn2Data6_1.length() - 4);
		String ICColumn2Data6_1_b = ICColumn2Data6_1.substring(ICColumn2Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1_a + "," + ICColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1);}
		//Validating the Data Format of Column3Data6  
		if (ICColumn3Data6_1.length() > 4) {
		String ICColumn3Data6_1_a = ICColumn3Data6_1.substring(0, ICColumn3Data6_1.length() - 4);
		String ICColumn3Data6_1_b = ICColumn3Data6_1.substring(ICColumn3Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data6.verifyText(ICColumn3Data6_1_a + "," + ICColumn3Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data6.verifyText(ICColumn3Data6_1);}
		//Validating the Data Format of Column4Data6  
		if (ICColumn4Data6_1_1.length() > 4) {
		String ICColumn4Data6_1_a = ICColumn4Data6_1_1.substring(0, ICColumn4Data6_1_1.length() - 4);
		String ICColumn4Data6_1_b = ICColumn4Data6_1_1.substring(ICColumn4Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data6.verifyText(ICColumn4Data6_1_a + "," + ICColumn4Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data6.verifyText(ICColumn4Data6_1_1);}
		
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String ICColumn1Data7_1 = VIPFinancialsPage.contents.ICColumn1Data7.getText();
		String ICColumn2Data7_1 = VIPFinancialsPage.contents.ICColumn2Data7.getText();
		String ICColumn3Data7_1 = VIPFinancialsPage.contents.ICColumn3Data7.getText();
		String ICColumn4Data7_1_1 = VIPFinancialsPage.contents.ICColumn4Data7.getText();
		if (ICColumn1Data7_1.contains("-") | ICColumn2Data7_1.contains("-") | ICColumn3Data7_1.contains("-") | ICColumn4Data7_1_1.contains("-") |
		ICColumn1Data7_1.equals("0") | ICColumn4Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data7.verifyText("N/M");}
		else {
		String ICColumn1Data7_2 = ICColumn1Data7_1.replace(",", "");
		double ICColumn1Data7 = Double.parseDouble(ICColumn1Data7_2);
		//Ending Data7
		String ICColumn4Data7_1 = VIPFinancialsPage.contents.ICColumn4Data7.getText();
		String ICColumn4Data7_2 = ICColumn4Data7_1.replace(",", "");
		double ICColumn4Data7 = Double.parseDouble(ICColumn4Data7_2);
		double Base1 = ICColumn4Data7/ICColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (ICColumn1Data7_1.length() > 4) {
		String ICColumn1Data7_1_a = ICColumn1Data7_1.substring(0, ICColumn1Data7_1.length() - 4);
		String ICColumn1Data7_1_b = ICColumn1Data7_1.substring(ICColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1_a + "," + ICColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (ICColumn2Data7_1.length() > 4) {
		String ICColumn2Data7_1_a = ICColumn2Data7_1.substring(0, ICColumn2Data7_1.length() - 4);
		String ICColumn2Data7_1_b = ICColumn2Data7_1.substring(ICColumn2Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1_a + "," + ICColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1);}
		//Validating the Data Format of Column3Data7  
		if (ICColumn3Data7_1.length() > 4) {
		String ICColumn3Data7_1_a = ICColumn3Data7_1.substring(0, ICColumn3Data7_1.length() - 4);
		String ICColumn3Data7_1_b = ICColumn3Data7_1.substring(ICColumn3Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data7.verifyText(ICColumn3Data7_1_a + "," + ICColumn3Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data7.verifyText(ICColumn3Data7_1);}
		//Validating the Data Format of Column4Data7  
		if (ICColumn4Data7_1_1.length() > 4) {
		String ICColumn4Data7_1_a = ICColumn4Data7_1_1.substring(0, ICColumn4Data7_1_1.length() - 4);
		String ICColumn4Data7_1_b = ICColumn4Data7_1_1.substring(ICColumn4Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data7.verifyText(ICColumn4Data7_1_a + "," + ICColumn4Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data7.verifyText(ICColumn4Data7_1_1);}
		
		//*******************************   CAGR8   *************************************
		//Beginning Data8
		String ICColumn1Data8_1 = VIPFinancialsPage.contents.ICColumn1Data8.getText();
		String ICColumn2Data8_1 = VIPFinancialsPage.contents.ICColumn2Data8.getText();
		String ICColumn3Data8_1 = VIPFinancialsPage.contents.ICColumn3Data8.getText();
		String ICColumn4Data8_1_1 = VIPFinancialsPage.contents.ICColumn4Data8.getText();
		if (ICColumn1Data8_1.contains("-") | ICColumn2Data8_1.contains("-") | ICColumn3Data8_1.contains("-") | ICColumn4Data8_1_1.contains("-") |
		ICColumn1Data8_1.equals("0") | ICColumn4Data8_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data8.verifyText("N/M");}
		else {
		String ICColumn1Data8_2 = ICColumn1Data8_1.replace(",", "");
		double ICColumn1Data8 = Double.parseDouble(ICColumn1Data8_2);
		//Ending Data8
		String ICColumn4Data8_1 = VIPFinancialsPage.contents.ICColumn4Data8.getText();
		String ICColumn4Data8_2 = ICColumn4Data8_1.replace(",", "");
		double ICColumn4Data8 = Double.parseDouble(ICColumn4Data8_2);
		double Base1 = ICColumn4Data8/ICColumn1Data8;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data8.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data8  
		if (ICColumn1Data8_1.length() > 4) {
		String ICColumn1Data8_1_a = ICColumn1Data8_1.substring(0, ICColumn1Data8_1.length() - 4);
		String ICColumn1Data8_1_b = ICColumn1Data8_1.substring(ICColumn1Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1_a + "," + ICColumn1Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1);}
		//Validating the Data Format of Column2Data8  
		if (ICColumn2Data8_1.length() > 4) {
		String ICColumn2Data8_1_a = ICColumn2Data8_1.substring(0, ICColumn2Data8_1.length() - 4);
		String ICColumn2Data8_1_b = ICColumn2Data8_1.substring(ICColumn2Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1_a + "," + ICColumn2Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1);}
		//Validating the Data Format of Column3Data8  
		if (ICColumn3Data8_1.length() > 4) {
		String ICColumn3Data8_1_a = ICColumn3Data8_1.substring(0, ICColumn3Data8_1.length() - 4);
		String ICColumn3Data8_1_b = ICColumn3Data8_1.substring(ICColumn3Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data8.verifyText(ICColumn3Data8_1_a + "," + ICColumn3Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data8.verifyText(ICColumn3Data8_1);}
		//Validating the Data Format of Column4Data8  
		if (ICColumn4Data8_1_1.length() > 4) {
		String ICColumn4Data8_1_a = ICColumn4Data8_1_1.substring(0, ICColumn4Data8_1_1.length() - 4);
		String ICColumn4Data8_1_b = ICColumn4Data8_1_1.substring(ICColumn4Data8_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data8.verifyText(ICColumn4Data8_1_a + "," + ICColumn4Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data8.verifyText(ICColumn4Data8_1_1);}
		
		//*******************************   CAGR9   *************************************
		//Beginning Data9
		String ICColumn1Data9_1 = VIPFinancialsPage.contents.ICColumn1Data9.getText();
		String ICColumn2Data9_1 = VIPFinancialsPage.contents.ICColumn2Data9.getText();
		String ICColumn3Data9_1 = VIPFinancialsPage.contents.ICColumn3Data9.getText();
		String ICColumn4Data9_1_1 = VIPFinancialsPage.contents.ICColumn4Data9.getText();
		if (ICColumn1Data9_1.contains("-") | ICColumn2Data9_1.contains("-") | ICColumn3Data9_1.contains("-") | ICColumn4Data9_1_1.contains("-") |
		ICColumn1Data9_1.equals("0") | ICColumn4Data9_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data9.verifyText("N/M");}
		else {
		String ICColumn1Data9_2 = ICColumn1Data9_1.replace(",", "");
		double ICColumn1Data9 = Double.parseDouble(ICColumn1Data9_2);
		//Ending Data9
		String ICColumn4Data9_1 = VIPFinancialsPage.contents.ICColumn4Data9.getText();
		String ICColumn4Data9_2 = ICColumn4Data9_1.replace(",", "");
		double ICColumn4Data9 = Double.parseDouble(ICColumn4Data9_2);
		double Base1 = ICColumn4Data9/ICColumn1Data9;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data9.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data9  
		if (ICColumn1Data9_1.length() > 4) {
		String ICColumn1Data9_1_a = ICColumn1Data9_1.substring(0, ICColumn1Data9_1.length() - 4);
		String ICColumn1Data9_1_b = ICColumn1Data9_1.substring(ICColumn1Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1_a + "," + ICColumn1Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1);}
		//Validating the Data Format of Column2Data9  
		if (ICColumn2Data9_1.length() > 4) {
		String ICColumn2Data9_1_a = ICColumn2Data9_1.substring(0, ICColumn2Data9_1.length() - 4);
		String ICColumn2Data9_1_b = ICColumn2Data9_1.substring(ICColumn2Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1_a + "," + ICColumn2Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1);}
		//Validating the Data Format of Column3Data9  
		if (ICColumn3Data9_1.length() > 4) {
		String ICColumn3Data9_1_a = ICColumn3Data9_1.substring(0, ICColumn3Data9_1.length() - 4);
		String ICColumn3Data9_1_b = ICColumn3Data9_1.substring(ICColumn3Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data9.verifyText(ICColumn3Data9_1_a + "," + ICColumn3Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data9.verifyText(ICColumn3Data9_1);}
		//Validating the Data Format of Column4Data9  
		if (ICColumn4Data9_1_1.length() > 4) {
		String ICColumn4Data9_1_a = ICColumn4Data9_1_1.substring(0, ICColumn4Data9_1_1.length() - 4);
		String ICColumn4Data9_1_b = ICColumn4Data9_1_1.substring(ICColumn4Data9_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data9.verifyText(ICColumn4Data9_1_a + "," + ICColumn4Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data9.verifyText(ICColumn4Data9_1_1);}
		
		//*******************************   CAGR10   *************************************
		//Beginning Data10
		String ICColumn1Data10_1 = VIPFinancialsPage.contents.ICColumn1Data10.getText();
		String ICColumn2Data10_1 = VIPFinancialsPage.contents.ICColumn2Data10.getText();
		String ICColumn3Data10_1 = VIPFinancialsPage.contents.ICColumn3Data10.getText();
		String ICColumn4Data10_1_1 = VIPFinancialsPage.contents.ICColumn4Data10.getText();
		if (ICColumn1Data10_1.contains("-") | ICColumn2Data10_1.contains("-") | ICColumn3Data10_1.contains("-") | ICColumn4Data10_1_1.contains("-") |
		ICColumn1Data10_1.equals("0") | ICColumn4Data10_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data10.verifyText("N/M");}
		else {
		String ICColumn1Data10_2 = ICColumn1Data10_1.replace(",", "");
		double ICColumn1Data10 = Double.parseDouble(ICColumn1Data10_2);
		//Ending Data10
		String ICColumn4Data10_1 = VIPFinancialsPage.contents.ICColumn4Data10.getText();
		String ICColumn4Data10_2 = ICColumn4Data10_1.replace(",", "");
		double ICColumn4Data10 = Double.parseDouble(ICColumn4Data10_2);
		double Base1 = ICColumn4Data10/ICColumn1Data10;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data10.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data10  
		if (ICColumn1Data10_1.length() > 4) {
		String ICColumn1Data10_1_a = ICColumn1Data10_1.substring(0, ICColumn1Data10_1.length() - 4);
		String ICColumn1Data10_1_b = ICColumn1Data10_1.substring(ICColumn1Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1_a + "," + ICColumn1Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1);}
		//Validating the Data Format of Column2Data10  
		if (ICColumn2Data10_1.length() > 4) {
		String ICColumn2Data10_1_a = ICColumn2Data10_1.substring(0, ICColumn2Data10_1.length() - 4);
		String ICColumn2Data10_1_b = ICColumn2Data10_1.substring(ICColumn2Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1_a + "," + ICColumn2Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1);}
		//Validating the Data Format of Column3Data10  
		if (ICColumn3Data10_1.length() > 4) {
		String ICColumn3Data10_1_a = ICColumn3Data10_1.substring(0, ICColumn3Data10_1.length() - 4);
		String ICColumn3Data10_1_b = ICColumn3Data10_1.substring(ICColumn3Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data10.verifyText(ICColumn3Data10_1_a + "," + ICColumn3Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data10.verifyText(ICColumn3Data10_1);}
		//Validating the Data Format of Column4Data10  
		if (ICColumn4Data10_1_1.length() > 4) {
		String ICColumn4Data10_1_a = ICColumn4Data10_1_1.substring(0, ICColumn4Data10_1_1.length() - 4);
		String ICColumn4Data10_1_b = ICColumn4Data10_1_1.substring(ICColumn4Data10_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data10.verifyText(ICColumn4Data10_1_a + "," + ICColumn4Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data10.verifyText(ICColumn4Data10_1_1);}
		
		}
		
		//************************   Period 1 to 3 is available   *****************************
		else if (!VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed()) {
		//Getting the Exponent
		String ICColumnHeader1 = VIPFinancialsPage.contents.ICColumnHeader1.getText();
		String[] ICColumnHeader1_1 = ICColumnHeader1.split("\\-");
		String ICColumnHeader1_2 = ICColumnHeader1_1[1];
		String ICColumnHeader2 = VIPFinancialsPage.contents.ICColumnHeader3.getText();
		String[] ICColumnHeader2_1 = ICColumnHeader2.split("\\-");
		String ICColumnHeader2_2 = ICColumnHeader2_1[1];
		String Date1 = "01/" + ICColumnHeader1_2;
		String Date2 = "01/" + ICColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String ICColumn1Data1_1 = VIPFinancialsPage.contents.ICColumn1Data1.getText();
		String ICColumn2Data1_1 = VIPFinancialsPage.contents.ICColumn2Data1.getText();
		String ICColumn3Data1_1_1 = VIPFinancialsPage.contents.ICColumn3Data1.getText();
		if (ICColumn1Data1_1.contains("-") | ICColumn2Data1_1.contains("-") | ICColumn3Data1_1_1.contains("-") |
		ICColumn1Data1_1.equals("0") | ICColumn3Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data1.verifyText("N/M");}
		else {
		String ICColumn1Data1_2 = ICColumn1Data1_1.replace(",", "");
		double ICColumn1Data1 = Double.parseDouble(ICColumn1Data1_2);
		//Ending Data1
		String ICColumn3Data1_1 = VIPFinancialsPage.contents.ICColumn3Data1.getText();
		String ICColumn3Data1_2 = ICColumn3Data1_1.replace(",", "");
		double ICColumn3Data1 = Double.parseDouble(ICColumn3Data1_2);
		double Base1 = ICColumn3Data1/ICColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (ICColumn1Data1_1.length() > 4) {
		String ICColumn1Data1_1_a = ICColumn1Data1_1.substring(0, ICColumn1Data1_1.length() - 4);
		String ICColumn1Data1_1_b = ICColumn1Data1_1.substring(ICColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1_a + "," + ICColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (ICColumn2Data1_1.length() > 4) {
		String ICColumn2Data1_1_a = ICColumn2Data1_1.substring(0, ICColumn2Data1_1.length() - 4);
		String ICColumn2Data1_1_b = ICColumn2Data1_1.substring(ICColumn2Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1_a + "," + ICColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1);}
		//Validating the Data Format of Column3Data1  
		if (ICColumn3Data1_1_1.length() > 4) {
		String ICColumn3Data1_1_a = ICColumn3Data1_1_1.substring(0, ICColumn3Data1_1_1.length() - 4);
		String ICColumn3Data1_1_b = ICColumn3Data1_1_1.substring(ICColumn3Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data1.verifyText(ICColumn3Data1_1_a + "," + ICColumn3Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data1.verifyText(ICColumn3Data1_1_1);}
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String ICColumn1Data2_1 = VIPFinancialsPage.contents.ICColumn1Data2.getText();
		String ICColumn2Data2_1 = VIPFinancialsPage.contents.ICColumn2Data2.getText();
		String ICColumn3Data2_1_1 = VIPFinancialsPage.contents.ICColumn3Data2.getText();
		if (ICColumn1Data2_1.contains("-") | ICColumn2Data2_1.contains("-") | ICColumn3Data2_1_1.contains("-") |
		ICColumn1Data2_1.equals("0") | ICColumn3Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data2.verifyText("N/M");}
		else {
		String ICColumn1Data2_2 = ICColumn1Data2_1.replace(",", "");
		double ICColumn1Data2 = Double.parseDouble(ICColumn1Data2_2);
		//Ending Data2
		String ICColumn3Data2_1 = VIPFinancialsPage.contents.ICColumn3Data2.getText();
		String ICColumn3Data2_2 = ICColumn3Data2_1.replace(",", "");
		double ICColumn3Data2 = Double.parseDouble(ICColumn3Data2_2);
		double Base1 = ICColumn3Data2/ICColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (ICColumn1Data2_1.length() > 4) {
		String ICColumn1Data2_1_a = ICColumn1Data2_1.substring(0, ICColumn1Data2_1.length() - 4);
		String ICColumn1Data2_1_b = ICColumn1Data2_1.substring(ICColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1_a + "," + ICColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (ICColumn2Data2_1.length() > 4) {
		String ICColumn2Data2_1_a = ICColumn2Data2_1.substring(0, ICColumn2Data2_1.length() - 4);
		String ICColumn2Data2_1_b = ICColumn2Data2_1.substring(ICColumn2Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1_a + "," + ICColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1);}
		//Validating the Data Format of Column3Data2  
		if (ICColumn3Data2_1_1.length() > 4) {
		String ICColumn3Data2_1_a = ICColumn3Data2_1_1.substring(0, ICColumn3Data2_1_1.length() - 4);
		String ICColumn3Data2_1_b = ICColumn3Data2_1_1.substring(ICColumn3Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data2.verifyText(ICColumn3Data2_1_a + "," + ICColumn3Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data2.verifyText(ICColumn3Data2_1_1);}
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String ICColumn1Data3_1 = VIPFinancialsPage.contents.ICColumn1Data3.getText();
		String ICColumn2Data3_1 = VIPFinancialsPage.contents.ICColumn2Data3.getText();
		String ICColumn3Data3_1_1 = VIPFinancialsPage.contents.ICColumn3Data3.getText();
		if (ICColumn1Data3_1.contains("-") | ICColumn2Data3_1.contains("-") | ICColumn3Data3_1_1.contains("-") |
		ICColumn1Data3_1.equals("0") | ICColumn3Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data3.verifyText("N/M");}
		else {
		String ICColumn1Data3_2 = ICColumn1Data3_1.replace(",", "");
		double ICColumn1Data3 = Double.parseDouble(ICColumn1Data3_2);
		//Ending Data3
		String ICColumn3Data3_1 = VIPFinancialsPage.contents.ICColumn3Data3.getText();
		String ICColumn3Data3_2 = ICColumn3Data3_1.replace(",", "");
		double ICColumn3Data3 = Double.parseDouble(ICColumn3Data3_2);
		double Base1 = ICColumn3Data3/ICColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (ICColumn1Data3_1.length() > 4) {
		String ICColumn1Data3_1_a = ICColumn1Data3_1.substring(0, ICColumn1Data3_1.length() - 4);
		String ICColumn1Data3_1_b = ICColumn1Data3_1.substring(ICColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1_a + "," + ICColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (ICColumn2Data3_1.length() > 4) {
		String ICColumn2Data3_1_a = ICColumn2Data3_1.substring(0, ICColumn2Data3_1.length() - 4);
		String ICColumn2Data3_1_b = ICColumn2Data3_1.substring(ICColumn2Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1_a + "," + ICColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1);}
		//Validating the Data Format of Column3Data3  
		if (ICColumn3Data3_1_1.length() > 4) {
		String ICColumn3Data3_1_a = ICColumn3Data3_1_1.substring(0, ICColumn3Data3_1_1.length() - 4);
		String ICColumn3Data3_1_b = ICColumn3Data3_1_1.substring(ICColumn3Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data3.verifyText(ICColumn3Data3_1_a + "," + ICColumn3Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data3.verifyText(ICColumn3Data3_1_1);}
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String ICColumn1Data4_1 = VIPFinancialsPage.contents.ICColumn1Data4.getText();
		String ICColumn2Data4_1 = VIPFinancialsPage.contents.ICColumn2Data4.getText();
		String ICColumn3Data4_1_1 = VIPFinancialsPage.contents.ICColumn3Data4.getText();
		if (ICColumn1Data4_1.contains("-") | ICColumn2Data4_1.contains("-") | ICColumn3Data4_1_1.contains("-") |
		ICColumn1Data4_1.equals("0") | ICColumn3Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data4.verifyText("N/M");}
		else {
		String ICColumn1Data4_2 = ICColumn1Data4_1.replace(",", "");
		double ICColumn1Data4 = Double.parseDouble(ICColumn1Data4_2);
		//Ending Data4
		String ICColumn3Data4_1 = VIPFinancialsPage.contents.ICColumn3Data4.getText();
		String ICColumn3Data4_2 = ICColumn3Data4_1.replace(",", "");
		double ICColumn3Data4 = Double.parseDouble(ICColumn3Data4_2);
		double Base1 = ICColumn3Data4/ICColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (ICColumn1Data4_1.length() > 4) {
		String ICColumn1Data4_1_a = ICColumn1Data4_1.substring(0, ICColumn1Data4_1.length() - 4);
		String ICColumn1Data4_1_b = ICColumn1Data4_1.substring(ICColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1_a + "," + ICColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (ICColumn2Data4_1.length() > 4) {
		String ICColumn2Data4_1_a = ICColumn2Data4_1.substring(0, ICColumn2Data4_1.length() - 4);
		String ICColumn2Data4_1_b = ICColumn2Data4_1.substring(ICColumn2Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1_a + "," + ICColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1);}
		//Validating the Data Format of Column3Data4  
		if (ICColumn3Data4_1_1.length() > 4) {
		String ICColumn3Data4_1_a = ICColumn3Data4_1_1.substring(0, ICColumn3Data4_1_1.length() - 4);
		String ICColumn3Data4_1_b = ICColumn3Data4_1_1.substring(ICColumn3Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data4.verifyText(ICColumn3Data4_1_a + "," + ICColumn3Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data4.verifyText(ICColumn3Data4_1_1);}
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String ICColumn1Data5_1 = VIPFinancialsPage.contents.ICColumn1Data5.getText();
		String ICColumn2Data5_1 = VIPFinancialsPage.contents.ICColumn2Data5.getText();
		String ICColumn3Data5_1_1 = VIPFinancialsPage.contents.ICColumn3Data5.getText();
		if (ICColumn1Data5_1.contains("-") | ICColumn2Data5_1.contains("-") | ICColumn3Data5_1_1.contains("-") |
		ICColumn1Data5_1.equals("0") | ICColumn3Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data5.verifyText("N/M");}
		else {
		String ICColumn1Data5_2 = ICColumn1Data5_1.replace(",", "");
		double ICColumn1Data5 = Double.parseDouble(ICColumn1Data5_2);
		//Ending Data5
		String ICColumn3Data5_1 = VIPFinancialsPage.contents.ICColumn3Data5.getText();
		String ICColumn3Data5_2 = ICColumn3Data5_1.replace(",", "");
		double ICColumn3Data5 = Double.parseDouble(ICColumn3Data5_2);
		double Base1 = ICColumn3Data5/ICColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (ICColumn1Data5_1.length() > 4) {
		String ICColumn1Data5_1_a = ICColumn1Data5_1.substring(0, ICColumn1Data5_1.length() - 4);
		String ICColumn1Data5_1_b = ICColumn1Data5_1.substring(ICColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1_a + "," + ICColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (ICColumn2Data5_1.length() > 4) {
		String ICColumn2Data5_1_a = ICColumn2Data5_1.substring(0, ICColumn2Data5_1.length() - 4);
		String ICColumn2Data5_1_b = ICColumn2Data5_1.substring(ICColumn2Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1_a + "," + ICColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1);}
		//Validating the Data Format of Column3Data5  
		if (ICColumn3Data5_1_1.length() > 4) {
		String ICColumn3Data5_1_a = ICColumn3Data5_1_1.substring(0, ICColumn3Data5_1_1.length() - 4);
		String ICColumn3Data5_1_b = ICColumn3Data5_1_1.substring(ICColumn3Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data5.verifyText(ICColumn3Data5_1_a + "," + ICColumn3Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data5.verifyText(ICColumn3Data5_1_1);}
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String ICColumn1Data6_1 = VIPFinancialsPage.contents.ICColumn1Data6.getText();
		String ICColumn2Data6_1 = VIPFinancialsPage.contents.ICColumn2Data6.getText();
		String ICColumn3Data6_1_1 = VIPFinancialsPage.contents.ICColumn3Data6.getText();
		if (ICColumn1Data6_1.contains("-") | ICColumn2Data6_1.contains("-") | ICColumn3Data6_1_1.contains("-") |
		ICColumn1Data6_1.equals("0") | ICColumn3Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data6.verifyText("N/M");}
		else {
		String ICColumn1Data6_2 = ICColumn1Data6_1.replace(",", "");
		double ICColumn1Data6 = Double.parseDouble(ICColumn1Data6_2);
		//Ending Data6
		String ICColumn3Data6_1 = VIPFinancialsPage.contents.ICColumn3Data6.getText();
		String ICColumn3Data6_2 = ICColumn3Data6_1.replace(",", "");
		double ICColumn3Data6 = Double.parseDouble(ICColumn3Data6_2);
		double Base1 = ICColumn3Data6/ICColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (ICColumn1Data6_1.length() > 4) {
		String ICColumn1Data6_1_a = ICColumn1Data6_1.substring(0, ICColumn1Data6_1.length() - 4);
		String ICColumn1Data6_1_b = ICColumn1Data6_1.substring(ICColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1_a + "," + ICColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (ICColumn2Data6_1.length() > 4) {
		String ICColumn2Data6_1_a = ICColumn2Data6_1.substring(0, ICColumn2Data6_1.length() - 4);
		String ICColumn2Data6_1_b = ICColumn2Data6_1.substring(ICColumn2Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1_a + "," + ICColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1);}
		//Validating the Data Format of Column3Data6  
		if (ICColumn3Data6_1_1.length() > 4) {
		String ICColumn3Data6_1_a = ICColumn3Data6_1_1.substring(0, ICColumn3Data6_1_1.length() - 4);
		String ICColumn3Data6_1_b = ICColumn3Data6_1_1.substring(ICColumn3Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data6.verifyText(ICColumn3Data6_1_a + "," + ICColumn3Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data6.verifyText(ICColumn3Data6_1_1);}
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String ICColumn1Data7_1 = VIPFinancialsPage.contents.ICColumn1Data7.getText();
		String ICColumn2Data7_1 = VIPFinancialsPage.contents.ICColumn2Data7.getText();
		String ICColumn3Data7_1_1 = VIPFinancialsPage.contents.ICColumn3Data7.getText();
		if (ICColumn1Data7_1.contains("-") | ICColumn2Data7_1.contains("-") | ICColumn3Data7_1_1.contains("-") |
		ICColumn1Data7_1.equals("0") | ICColumn3Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data7.verifyText("N/M");}
		else {
		String ICColumn1Data7_2 = ICColumn1Data7_1.replace(",", "");
		double ICColumn1Data7 = Double.parseDouble(ICColumn1Data7_2);
		//Ending Data7
		String ICColumn3Data7_1 = VIPFinancialsPage.contents.ICColumn3Data7.getText();
		String ICColumn3Data7_2 = ICColumn3Data7_1.replace(",", "");
		double ICColumn3Data7 = Double.parseDouble(ICColumn3Data7_2);
		double Base1 = ICColumn3Data7/ICColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (ICColumn1Data7_1.length() > 4) {
		String ICColumn1Data7_1_a = ICColumn1Data7_1.substring(0, ICColumn1Data7_1.length() - 4);
		String ICColumn1Data7_1_b = ICColumn1Data7_1.substring(ICColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1_a + "," + ICColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (ICColumn2Data7_1.length() > 4) {
		String ICColumn2Data7_1_a = ICColumn2Data7_1.substring(0, ICColumn2Data7_1.length() - 4);
		String ICColumn2Data7_1_b = ICColumn2Data7_1.substring(ICColumn2Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1_a + "," + ICColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1);}
		//Validating the Data Format of Column3Data7  
		if (ICColumn3Data7_1_1.length() > 4) {
		String ICColumn3Data7_1_a = ICColumn3Data7_1_1.substring(0, ICColumn3Data7_1_1.length() - 4);
		String ICColumn3Data7_1_b = ICColumn3Data7_1_1.substring(ICColumn3Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data7.verifyText(ICColumn3Data7_1_a + "," + ICColumn3Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data7.verifyText(ICColumn3Data7_1_1);}
		
		//*******************************   CAGR8   *************************************
		//Beginning Data8
		String ICColumn1Data8_1 = VIPFinancialsPage.contents.ICColumn1Data8.getText();
		String ICColumn2Data8_1 = VIPFinancialsPage.contents.ICColumn2Data8.getText();
		String ICColumn3Data8_1_1 = VIPFinancialsPage.contents.ICColumn3Data8.getText();
		if (ICColumn1Data8_1.contains("-") | ICColumn2Data8_1.contains("-") | ICColumn3Data8_1_1.contains("-") |
		ICColumn1Data8_1.equals("0") | ICColumn3Data8_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data8.verifyText("N/M");}
		else {
		String ICColumn1Data8_2 = ICColumn1Data8_1.replace(",", "");
		double ICColumn1Data8 = Double.parseDouble(ICColumn1Data8_2);
		//Ending Data8
		String ICColumn3Data8_1 = VIPFinancialsPage.contents.ICColumn3Data8.getText();
		String ICColumn3Data8_2 = ICColumn3Data8_1.replace(",", "");
		double ICColumn3Data8 = Double.parseDouble(ICColumn3Data8_2);
		double Base1 = ICColumn3Data8/ICColumn1Data8;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data8.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data8  
		if (ICColumn1Data8_1.length() > 4) {
		String ICColumn1Data8_1_a = ICColumn1Data8_1.substring(0, ICColumn1Data8_1.length() - 4);
		String ICColumn1Data8_1_b = ICColumn1Data8_1.substring(ICColumn1Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1_a + "," + ICColumn1Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1);}
		//Validating the Data Format of Column2Data8  
		if (ICColumn2Data8_1.length() > 4) {
		String ICColumn2Data8_1_a = ICColumn2Data8_1.substring(0, ICColumn2Data8_1.length() - 4);
		String ICColumn2Data8_1_b = ICColumn2Data8_1.substring(ICColumn2Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1_a + "," + ICColumn2Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1);}
		//Validating the Data Format of Column3Data8  
		if (ICColumn3Data8_1_1.length() > 4) {
		String ICColumn3Data8_1_a = ICColumn3Data8_1_1.substring(0, ICColumn3Data8_1_1.length() - 4);
		String ICColumn3Data8_1_b = ICColumn3Data8_1_1.substring(ICColumn3Data8_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data8.verifyText(ICColumn3Data8_1_a + "," + ICColumn3Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data8.verifyText(ICColumn3Data8_1_1);}
		
		//*******************************   CAGR9   *************************************
		//Beginning Data9
		String ICColumn1Data9_1 = VIPFinancialsPage.contents.ICColumn1Data9.getText();
		String ICColumn2Data9_1 = VIPFinancialsPage.contents.ICColumn2Data9.getText();
		String ICColumn3Data9_1_1 = VIPFinancialsPage.contents.ICColumn3Data9.getText();
		if (ICColumn1Data9_1.contains("-") | ICColumn2Data9_1.contains("-") | ICColumn3Data9_1_1.contains("-") |
		ICColumn1Data9_1.equals("0") | ICColumn3Data9_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data9.verifyText("N/M");}
		else {
		String ICColumn1Data9_2 = ICColumn1Data9_1.replace(",", "");
		double ICColumn1Data9 = Double.parseDouble(ICColumn1Data9_2);
		//Ending Data9
		String ICColumn3Data9_1 = VIPFinancialsPage.contents.ICColumn3Data9.getText();
		String ICColumn3Data9_2 = ICColumn3Data9_1.replace(",", "");
		double ICColumn3Data9 = Double.parseDouble(ICColumn3Data9_2);
		double Base1 = ICColumn3Data9/ICColumn1Data9;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data9.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data9  
		if (ICColumn1Data9_1.length() > 4) {
		String ICColumn1Data9_1_a = ICColumn1Data9_1.substring(0, ICColumn1Data9_1.length() - 4);
		String ICColumn1Data9_1_b = ICColumn1Data9_1.substring(ICColumn1Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1_a + "," + ICColumn1Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1);}
		//Validating the Data Format of Column2Data9  
		if (ICColumn2Data9_1.length() > 4) {
		String ICColumn2Data9_1_a = ICColumn2Data9_1.substring(0, ICColumn2Data9_1.length() - 4);
		String ICColumn2Data9_1_b = ICColumn2Data9_1.substring(ICColumn2Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1_a + "," + ICColumn2Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1);}
		//Validating the Data Format of Column3Data9  
		if (ICColumn3Data9_1_1.length() > 4) {
		String ICColumn3Data9_1_a = ICColumn3Data9_1_1.substring(0, ICColumn3Data9_1_1.length() - 4);
		String ICColumn3Data9_1_b = ICColumn3Data9_1_1.substring(ICColumn3Data9_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data9.verifyText(ICColumn3Data9_1_a + "," + ICColumn3Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data9.verifyText(ICColumn3Data9_1_1);}
		
		//*******************************   CAGR10   *************************************
		//Beginning Data10
		String ICColumn1Data10_1 = VIPFinancialsPage.contents.ICColumn1Data10.getText();
		String ICColumn2Data10_1 = VIPFinancialsPage.contents.ICColumn2Data10.getText();
		String ICColumn3Data10_1_1 = VIPFinancialsPage.contents.ICColumn3Data10.getText();
		if (ICColumn1Data10_1.contains("-") | ICColumn2Data10_1.contains("-") | ICColumn3Data10_1_1.contains("-") |
		ICColumn1Data10_1.equals("0") | ICColumn3Data10_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data10.verifyText("N/M");}
		else {
		String ICColumn1Data10_2 = ICColumn1Data10_1.replace(",", "");
		double ICColumn1Data10 = Double.parseDouble(ICColumn1Data10_2);
		//Ending Data10
		String ICColumn3Data10_1 = VIPFinancialsPage.contents.ICColumn3Data10.getText();
		String ICColumn3Data10_2 = ICColumn3Data10_1.replace(",", "");
		double ICColumn3Data10 = Double.parseDouble(ICColumn3Data10_2);
		double Base1 = ICColumn3Data10/ICColumn1Data10;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data10.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data10  
		if (ICColumn1Data10_1.length() > 4) {
		String ICColumn1Data10_1_a = ICColumn1Data10_1.substring(0, ICColumn1Data10_1.length() - 4);
		String ICColumn1Data10_1_b = ICColumn1Data10_1.substring(ICColumn1Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1_a + "," + ICColumn1Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1);}
		//Validating the Data Format of Column2Data10  
		if (ICColumn2Data10_1.length() > 4) {
		String ICColumn2Data10_1_a = ICColumn2Data10_1.substring(0, ICColumn2Data10_1.length() - 4);
		String ICColumn2Data10_1_b = ICColumn2Data10_1.substring(ICColumn2Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1_a + "," + ICColumn2Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1);}
		//Validating the Data Format of Column3Data10  
		if (ICColumn3Data10_1_1.length() > 4) {
		String ICColumn3Data10_1_a = ICColumn3Data10_1_1.substring(0, ICColumn3Data10_1_1.length() - 4);
		String ICColumn3Data10_1_b = ICColumn3Data10_1_1.substring(ICColumn3Data10_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data10.verifyText(ICColumn3Data10_1_a + "," + ICColumn3Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data10.verifyText(ICColumn3Data10_1_1);}}
		
		//************************   Period 1 to 2 is available   ******************************
		else if (!VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader3.isDisplayed()) {
		//Getting the Exponent
		String ICColumnHeader1 = VIPFinancialsPage.contents.ICColumnHeader1.getText();
		String[] ICColumnHeader1_1 = ICColumnHeader1.split("\\-");
		String ICColumnHeader1_2 = ICColumnHeader1_1[1];
		String ICColumnHeader2 = VIPFinancialsPage.contents.ICColumnHeader2.getText();
		String[] ICColumnHeader2_1 = ICColumnHeader2.split("\\-");
		String ICColumnHeader2_2 = ICColumnHeader2_1[1];
		String Date1 = "01/" + ICColumnHeader1_2;
		String Date2 = "01/" + ICColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String ICColumn1Data1_1 = VIPFinancialsPage.contents.ICColumn1Data1.getText();
		String ICColumn2Data1_1_1 = VIPFinancialsPage.contents.ICColumn2Data1.getText();
		if (ICColumn1Data1_1.contains("-") | ICColumn2Data1_1_1.contains("-") |
		ICColumn1Data1_1.equals("0") | ICColumn2Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data1.verifyText("N/M");}
		else {
		String ICColumn1Data1_2 = ICColumn1Data1_1.replace(",", "");
		double ICColumn1Data1 = Double.parseDouble(ICColumn1Data1_2);
		//Ending Data1
		String ICColumn2Data1_1 = VIPFinancialsPage.contents.ICColumn2Data1.getText();
		String ICColumn2Data1_2 = ICColumn2Data1_1.replace(",", "");
		double ICColumn2Data1 = Double.parseDouble(ICColumn2Data1_2);
		double Base1 = ICColumn2Data1/ICColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (ICColumn1Data1_1.length() > 4) {
		String ICColumn1Data1_1_a = ICColumn1Data1_1.substring(0, ICColumn1Data1_1.length() - 4);
		String ICColumn1Data1_1_b = ICColumn1Data1_1.substring(ICColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1_a + "," + ICColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (ICColumn2Data1_1_1.length() > 4) {
		String ICColumn2Data1_1_a = ICColumn2Data1_1_1.substring(0, ICColumn2Data1_1_1.length() - 4);
		String ICColumn2Data1_1_b = ICColumn2Data1_1_1.substring(ICColumn2Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1_a + "," + ICColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1_1);}
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String ICColumn1Data2_1 = VIPFinancialsPage.contents.ICColumn1Data2.getText();
		String ICColumn2Data2_1_1 = VIPFinancialsPage.contents.ICColumn2Data2.getText();
		if (ICColumn1Data2_1.contains("-") | ICColumn2Data2_1_1.contains("-") |
		ICColumn1Data2_1.equals("0") | ICColumn2Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data2.verifyText("N/M");}
		else {
		String ICColumn1Data2_2 = ICColumn1Data2_1.replace(",", "");
		double ICColumn1Data2 = Double.parseDouble(ICColumn1Data2_2);
		//Ending Data2
		String ICColumn2Data2_1 = VIPFinancialsPage.contents.ICColumn2Data2.getText();
		String ICColumn2Data2_2 = ICColumn2Data2_1.replace(",", "");
		double ICColumn2Data2 = Double.parseDouble(ICColumn2Data2_2);
		double Base1 = ICColumn2Data2/ICColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (ICColumn1Data2_1.length() > 4) {
		String ICColumn1Data2_1_a = ICColumn1Data2_1.substring(0, ICColumn1Data2_1.length() - 4);
		String ICColumn1Data2_1_b = ICColumn1Data2_1.substring(ICColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1_a + "," + ICColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (ICColumn2Data2_1_1.length() > 4) {
		String ICColumn2Data2_1_a = ICColumn2Data2_1_1.substring(0, ICColumn2Data2_1_1.length() - 4);
		String ICColumn2Data2_1_b = ICColumn2Data2_1_1.substring(ICColumn2Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1_a + "," + ICColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1_1);}
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String ICColumn1Data3_1 = VIPFinancialsPage.contents.ICColumn1Data3.getText();
		String ICColumn2Data3_1_1 = VIPFinancialsPage.contents.ICColumn2Data3.getText();
		if (ICColumn1Data3_1.contains("-") | ICColumn2Data3_1_1.contains("-") |
		ICColumn1Data3_1.equals("0") | ICColumn2Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data3.verifyText("N/M");}
		else {
		String ICColumn1Data3_2 = ICColumn1Data3_1.replace(",", "");
		double ICColumn1Data3 = Double.parseDouble(ICColumn1Data3_2);
		//Ending Data3
		String ICColumn2Data3_1 = VIPFinancialsPage.contents.ICColumn2Data3.getText();
		String ICColumn2Data3_2 = ICColumn2Data3_1.replace(",", "");
		double ICColumn2Data3 = Double.parseDouble(ICColumn2Data3_2);
		double Base1 = ICColumn2Data3/ICColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (ICColumn1Data3_1.length() > 4) {
		String ICColumn1Data3_1_a = ICColumn1Data3_1.substring(0, ICColumn1Data3_1.length() - 4);
		String ICColumn1Data3_1_b = ICColumn1Data3_1.substring(ICColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1_a + "," + ICColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (ICColumn2Data3_1_1.length() > 4) {
		String ICColumn2Data3_1_a = ICColumn2Data3_1_1.substring(0, ICColumn2Data3_1_1.length() - 4);
		String ICColumn2Data3_1_b = ICColumn2Data3_1_1.substring(ICColumn2Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1_a + "," + ICColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1_1);}
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String ICColumn1Data4_1 = VIPFinancialsPage.contents.ICColumn1Data4.getText();
		String ICColumn2Data4_1_1 = VIPFinancialsPage.contents.ICColumn2Data4.getText();
		if (ICColumn1Data4_1.contains("-") | ICColumn2Data4_1_1.contains("-") |
		ICColumn1Data4_1.equals("0") | ICColumn2Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data4.verifyText("N/M");}
		else {
		String ICColumn1Data4_2 = ICColumn1Data4_1.replace(",", "");
		double ICColumn1Data4 = Double.parseDouble(ICColumn1Data4_2);
		//Ending Data4
		String ICColumn2Data4_1 = VIPFinancialsPage.contents.ICColumn2Data4.getText();
		String ICColumn2Data4_2 = ICColumn2Data4_1.replace(",", "");
		double ICColumn2Data4 = Double.parseDouble(ICColumn2Data4_2);
		double Base1 = ICColumn2Data4/ICColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (ICColumn1Data4_1.length() > 4) {
		String ICColumn1Data4_1_a = ICColumn1Data4_1.substring(0, ICColumn1Data4_1.length() - 4);
		String ICColumn1Data4_1_b = ICColumn1Data4_1.substring(ICColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1_a + "," + ICColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (ICColumn2Data4_1_1.length() > 4) {
		String ICColumn2Data4_1_a = ICColumn2Data4_1_1.substring(0, ICColumn2Data4_1_1.length() - 4);
		String ICColumn2Data4_1_b = ICColumn2Data4_1_1.substring(ICColumn2Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1_a + "," + ICColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1_1);}
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String ICColumn1Data5_1 = VIPFinancialsPage.contents.ICColumn1Data5.getText();
		String ICColumn2Data5_1_1 = VIPFinancialsPage.contents.ICColumn2Data5.getText();
		if (ICColumn1Data5_1.contains("-") | ICColumn2Data5_1_1.contains("-") |
		ICColumn1Data5_1.equals("0") | ICColumn2Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data5.verifyText("N/M");}
		else {
		String ICColumn1Data5_2 = ICColumn1Data5_1.replace(",", "");
		double ICColumn1Data5 = Double.parseDouble(ICColumn1Data5_2);
		//Ending Data5
		String ICColumn2Data5_1 = VIPFinancialsPage.contents.ICColumn2Data5.getText();
		String ICColumn2Data5_2 = ICColumn2Data5_1.replace(",", "");
		double ICColumn2Data5 = Double.parseDouble(ICColumn2Data5_2);
		double Base1 = ICColumn2Data5/ICColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (ICColumn1Data5_1.length() > 4) {
		String ICColumn1Data5_1_a = ICColumn1Data5_1.substring(0, ICColumn1Data5_1.length() - 4);
		String ICColumn1Data5_1_b = ICColumn1Data5_1.substring(ICColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1_a + "," + ICColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (ICColumn2Data5_1_1.length() > 4) {
		String ICColumn2Data5_1_a = ICColumn2Data5_1_1.substring(0, ICColumn2Data5_1_1.length() - 4);
		String ICColumn2Data5_1_b = ICColumn2Data5_1_1.substring(ICColumn2Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1_a + "," + ICColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1_1);}
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String ICColumn1Data6_1 = VIPFinancialsPage.contents.ICColumn1Data6.getText();
		String ICColumn2Data6_1_1 = VIPFinancialsPage.contents.ICColumn2Data6.getText();
		if (ICColumn1Data6_1.contains("-") | ICColumn2Data6_1_1.contains("-") |
		ICColumn1Data6_1.equals("0") | ICColumn2Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data6.verifyText("N/M");}
		else {
		String ICColumn1Data6_2 = ICColumn1Data6_1.replace(",", "");
		double ICColumn1Data6 = Double.parseDouble(ICColumn1Data6_2);
		//Ending Data6
		String ICColumn2Data6_1 = VIPFinancialsPage.contents.ICColumn2Data6.getText();
		String ICColumn2Data6_2 = ICColumn2Data6_1.replace(",", "");
		double ICColumn2Data6 = Double.parseDouble(ICColumn2Data6_2);
		double Base1 = ICColumn2Data6/ICColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (ICColumn1Data6_1.length() > 4) {
		String ICColumn1Data6_1_a = ICColumn1Data6_1.substring(0, ICColumn1Data6_1.length() - 4);
		String ICColumn1Data6_1_b = ICColumn1Data6_1.substring(ICColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1_a + "," + ICColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (ICColumn2Data6_1_1.length() > 4) {
		String ICColumn2Data6_1_a = ICColumn2Data6_1_1.substring(0, ICColumn2Data6_1_1.length() - 4);
		String ICColumn2Data6_1_b = ICColumn2Data6_1_1.substring(ICColumn2Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1_a + "," + ICColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1_1);}
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String ICColumn1Data7_1 = VIPFinancialsPage.contents.ICColumn1Data7.getText();
		String ICColumn2Data7_1_1 = VIPFinancialsPage.contents.ICColumn2Data7.getText();
		if (ICColumn1Data7_1.contains("-") | ICColumn2Data7_1_1.contains("-") |
		ICColumn1Data7_1.equals("0") | ICColumn2Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data7.verifyText("N/M");}
		else {
		String ICColumn1Data7_2 = ICColumn1Data7_1.replace(",", "");
		double ICColumn1Data7 = Double.parseDouble(ICColumn1Data7_2);
		//Ending Data7
		String ICColumn2Data7_1 = VIPFinancialsPage.contents.ICColumn2Data7.getText();
		String ICColumn2Data7_2 = ICColumn2Data7_1.replace(",", "");
		double ICColumn2Data7 = Double.parseDouble(ICColumn2Data7_2);
		double Base1 = ICColumn2Data7/ICColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (ICColumn1Data7_1.length() > 4) {
		String ICColumn1Data7_1_a = ICColumn1Data7_1.substring(0, ICColumn1Data7_1.length() - 4);
		String ICColumn1Data7_1_b = ICColumn1Data7_1.substring(ICColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1_a + "," + ICColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (ICColumn2Data7_1_1.length() > 4) {
		String ICColumn2Data7_1_a = ICColumn2Data7_1_1.substring(0, ICColumn2Data7_1_1.length() - 4);
		String ICColumn2Data7_1_b = ICColumn2Data7_1_1.substring(ICColumn2Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1_a + "," + ICColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1_1);}
		//*******************************   CAGR8   *************************************		
		//Beginning Data8
		String ICColumn1Data8_1 = VIPFinancialsPage.contents.ICColumn1Data8.getText();
		String ICColumn2Data8_1_1 = VIPFinancialsPage.contents.ICColumn2Data8.getText();
		if (ICColumn1Data8_1.contains("-") | ICColumn2Data8_1_1.contains("-") |
		ICColumn1Data8_1.equals("0") | ICColumn2Data8_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data8.verifyText("N/M");}
		else {
		String ICColumn1Data8_2 = ICColumn1Data8_1.replace(",", "");
		double ICColumn1Data8 = Double.parseDouble(ICColumn1Data8_2);
		//Ending Data8
		String ICColumn2Data8_1 = VIPFinancialsPage.contents.ICColumn2Data8.getText();
		String ICColumn2Data8_2 = ICColumn2Data8_1.replace(",", "");
		double ICColumn2Data8 = Double.parseDouble(ICColumn2Data8_2);
		double Base1 = ICColumn2Data8/ICColumn1Data8;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data8.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data8  
		if (ICColumn1Data8_1.length() > 4) {
		String ICColumn1Data8_1_a = ICColumn1Data8_1.substring(0, ICColumn1Data8_1.length() - 4);
		String ICColumn1Data8_1_b = ICColumn1Data8_1.substring(ICColumn1Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1_a + "," + ICColumn1Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1);}
		//Validating the Data Format of Column2Data8  
		if (ICColumn2Data8_1_1.length() > 4) {
		String ICColumn2Data8_1_a = ICColumn2Data8_1_1.substring(0, ICColumn2Data8_1_1.length() - 4);
		String ICColumn2Data8_1_b = ICColumn2Data8_1_1.substring(ICColumn2Data8_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1_a + "," + ICColumn2Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1_1);}
		//*******************************   CAGR9   *************************************		
		//Beginning Data9
		String ICColumn1Data9_1 = VIPFinancialsPage.contents.ICColumn1Data9.getText();
		String ICColumn2Data9_1_1 = VIPFinancialsPage.contents.ICColumn2Data9.getText();
		if (ICColumn1Data9_1.contains("-") | ICColumn2Data9_1_1.contains("-") |
		ICColumn1Data9_1.equals("0") | ICColumn2Data9_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data9.verifyText("N/M");}
		else {
		String ICColumn1Data9_2 = ICColumn1Data9_1.replace(",", "");
		double ICColumn1Data9 = Double.parseDouble(ICColumn1Data9_2);
		//Ending Data9
		String ICColumn2Data9_1 = VIPFinancialsPage.contents.ICColumn2Data9.getText();
		String ICColumn2Data9_2 = ICColumn2Data9_1.replace(",", "");
		double ICColumn2Data9 = Double.parseDouble(ICColumn2Data9_2);
		double Base1 = ICColumn2Data9/ICColumn1Data9;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data9.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data9  
		if (ICColumn1Data9_1.length() > 4) {
		String ICColumn1Data9_1_a = ICColumn1Data9_1.substring(0, ICColumn1Data9_1.length() - 4);
		String ICColumn1Data9_1_b = ICColumn1Data9_1.substring(ICColumn1Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1_a + "," + ICColumn1Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1);}
		//Validating the Data Format of Column2Data9  
		if (ICColumn2Data9_1_1.length() > 4) {
		String ICColumn2Data9_1_a = ICColumn2Data9_1_1.substring(0, ICColumn2Data9_1_1.length() - 4);
		String ICColumn2Data9_1_b = ICColumn2Data9_1_1.substring(ICColumn2Data9_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1_a + "," + ICColumn2Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1_1);}
		//*******************************   CAGR10   *************************************		
		//Beginning Data10
		String ICColumn1Data10_1 = VIPFinancialsPage.contents.ICColumn1Data10.getText();
		String ICColumn2Data10_1_1 = VIPFinancialsPage.contents.ICColumn2Data10.getText();
		if (ICColumn1Data10_1.contains("-") | ICColumn2Data10_1_1.contains("-") |
		ICColumn1Data10_1.equals("0") | ICColumn2Data10_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data10.verifyText("N/M");}
		else {
		String ICColumn1Data10_2 = ICColumn1Data10_1.replace(",", "");
		double ICColumn1Data10 = Double.parseDouble(ICColumn1Data10_2);
		//Ending Data10
		String ICColumn2Data10_1 = VIPFinancialsPage.contents.ICColumn2Data10.getText();
		String ICColumn2Data10_2 = ICColumn2Data10_1.replace(",", "");
		double ICColumn2Data10 = Double.parseDouble(ICColumn2Data10_2);
		double Base1 = ICColumn2Data10/ICColumn1Data10;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data10.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data10  
		if (ICColumn1Data10_1.length() > 4) {
		String ICColumn1Data10_1_a = ICColumn1Data10_1.substring(0, ICColumn1Data10_1.length() - 4);
		String ICColumn1Data10_1_b = ICColumn1Data10_1.substring(ICColumn1Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1_a + "," + ICColumn1Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1);}
		//Validating the Data Format of Column2Data10  
		if (ICColumn2Data10_1_1.length() > 4) {
		String ICColumn2Data10_1_a = ICColumn2Data10_1_1.substring(0, ICColumn2Data10_1_1.length() - 4);
		String ICColumn2Data10_1_b = ICColumn2Data10_1_1.substring(ICColumn2Data10_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1_a + "," + ICColumn2Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1_1);}}
		
		//*************************   Period 1 is available   *******************************
		else {
		VIPFinancialsPage.contents.ICColumn2Data1.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data2.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data3.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data4.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data5.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data6.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data7.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data8.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data9.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data10.verifyText("N/M");}
		WebControl.takeScreenshot("Q2A_Regression_155_&_156_CAGR of IC Table");
		
		ReportLog.setTestCase("Q2A_Regression_158");
		VIPFinancialsPage.contents.RefCalcFootnote.verifyText("Note: The balance sheet assets and liabilities may not add up to the total Invested Capital value in TTM period due to adjustments. Please refer to the Methodology for details on TTM Adjustments.");
		WebControl.takeScreenshot("Q2A_Regression_158");
		
		ReportLog.setTestCase("Q2A_Regression_159");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 10);
		VIPCompetitorPage.contents.Competitors1stPeers.click();
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.waitForExist(true, 10);
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Essendant Inc");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.customJavaClick();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboard.waitForExist(true, 10);
		VIPFinancialsPage.contents.SelectDashboard.click();
		VIPFinancialsPage.contents.ReferenceCalculationMenu.click();
		VIPFinancialsPage.contents.SelectCompany.click();
		VIPFinancialsPage.contents.SelectCompanyMenu.click();
		VIPFinancialsPage.contents.EBITColumnHeader1.verifyDisplayed(true);
		VIPFinancialsPage.contents.EBITColumnHeader2.verifyDisplayed(true);
		VIPFinancialsPage.contents.EBITColumnHeader3.verifyDisplayed(false);
		VIPFinancialsPage.contents.EBITColumnHeader4.verifyDisplayed(false);
		VIPFinancialsPage.contents.ICColumnHeader1.verifyDisplayed(true);
		VIPFinancialsPage.contents.ICColumnHeader2.verifyDisplayed(true);
		VIPFinancialsPage.contents.ICColumnHeader3.verifyDisplayed(true);
		VIPFinancialsPage.contents.ICColumnHeader4.verifyDisplayed(false);
		VIPFinancialsPage.contents.ICColumnHeader5.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Regression_159");
		
	}
	
	@Test(priority=17)
	public void Q2A_HotelsIndustry () throws Exception {
		ReportLog.setTestName("Q2A - Hotels Industry");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_161");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.hotelCompany);
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
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.RG5YrRevCAGRHeader.waitForExist(true, 45);
		VIPFinancialsPage.contents.AdjRevAsRepToggleButton.verifyDisplayed(true);
		VIPFinancialsPage.contents.AdjustedRevenueLabel.verifyText("Adjusted revenues");
		VIPFinancialsPage.contents.AdjustedRevenueLabel.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.AdjustedRevenueLabel.verifyCssValue("font-weight", "900");
		VIPFinancialsPage.contents.AsReportedLabel.verifyText("As reported");
		VIPFinancialsPage.contents.AsReportedLabel.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.AsReportedLabel.verifyCssValue("font-weight", "500");
		WebControl.takeScreenshot("Q2A_Regression_161_1");
		VIPFinancialsPage.contents.AdjRevAsRepToggleButton.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.AdjustedRevenueLabel.verifyText("Adjusted revenues");
		VIPFinancialsPage.contents.AdjustedRevenueLabel.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.AdjustedRevenueLabel.verifyCssValue("font-weight", "500");
		VIPFinancialsPage.contents.AsReportedLabel.verifyText("As reported");
		VIPFinancialsPage.contents.AsReportedLabel.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.AsReportedLabel.verifyCssValue("font-weight", "900");
		WebControl.takeScreenshot("Q2A_Regression_161_2");
		VIPFinancialsPage.contents.AdjRevAsRepToggleButton.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.AdjustedRevenueLabel.verifyText("Adjusted revenues");
		VIPFinancialsPage.contents.AdjustedRevenueLabel.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.AdjustedRevenueLabel.verifyCssValue("font-weight", "900");
		VIPFinancialsPage.contents.AsReportedLabel.verifyText("As reported");
		VIPFinancialsPage.contents.AsReportedLabel.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.AsReportedLabel.verifyCssValue("font-weight", "500");
		WebControl.takeScreenshot("Q2A_Regression_161_3");
		
		ReportLog.setTestCase("Q2A_Regression_163");
		VIPFinancialsPage.contents.RGFootNote.verifyText("Note: Adjusted revenues excludes cost reimbursement revenues (that are recovered from the customers) for a standard like-for-like comparison\n"
				+ "Source: S&P Capital IQ; Accenture Client Value Services.");
		WebControl.takeScreenshot("Q2A_Regression_163_1");
		VIPFinancialsPage.contents.AdjRevAsRepToggleButton.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.RGFootNote.verifyText("Note: Reported revenues are the revenue numbers as reported by the company in its filings.\n" + 
				"Source: S&P Capital IQ; Accenture Client Value Services.");
		WebControl.takeScreenshot("Q2A_Regression_163_2");
		
		ReportLog.setTestCase("Q2A_Regression_164");
		VIPFinancialsPage.contents.AdjRevAsRepToggleButton.click();
		Thread.sleep(1000);
		String AdjRevStandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText();
		String AdjRevCompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String AdjRevCompetitivePosition2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String AdjRevBestInClass = VIPFinancialsPage.contents.BestInClass.getText();
		VIPFinancialsPage.contents.AdjRevAsRepToggleButton.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.StandalonePerf.verifyText(AdjRevStandalonePerf, false);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(AdjRevCompetitivePosition1, false);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(AdjRevCompetitivePosition2, false);
		VIPFinancialsPage.contents.BestInClass.verifyText(AdjRevBestInClass, false);
		String AsRepStandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText();
		String AsRepCompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String AsRepCompetitivePosition2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String AsRepBestInClass = VIPFinancialsPage.contents.BestInClass.getText();
		VIPFinancialsPage.contents.AdjRevAsRepToggleButton.click();
		Thread.sleep(1000);
		VIPFinancialsPage.contents.StandalonePerf.verifyText(AsRepStandalonePerf, false);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(AsRepCompetitivePosition1, false);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(AsRepCompetitivePosition2, false);
		VIPFinancialsPage.contents.BestInClass.verifyText(AsRepBestInClass, false);
		WebControl.takeScreenshot("Q2A_Regression_164");
		
		ReportLog.setTestCase("Q2A_Regression_166");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		VIPOverviewPage.contents.RevenueValue.waitForExist(true, 25);
		VIPOverviewPage.contents.RevenueTitle.verifyText("REVENUE (AS REPORTED)");
		VIPOverviewPage.contents.RevenueiIcon.verifyDisplayed(true);
		WebControl.takeScreenshot("Q2A_Regression_166");
		
		ReportLog.setTestCase("Q2A_Regression_167");
		VIPOverviewPage.contents.RevenueiIcon.hover();
		VIPOverviewPage.contents.TooltipText.verifyText("Click here to view definition");
		VIPOverviewPage.contents.RevenueiIcon.click();
		VIPOverviewPage.contents.TooltipTextClick.verifyText("Reported revenues are the numbers as reported by the company in its filings.");
		WebControl.takeScreenshot("Q2A_Regression_167");
		
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		ReportLog.setTestCase("Q2A_Regression_162_Test Data Prep");
		//Overview Data
		String RevenueValue = VIPOverviewPage.contents.RevenueValue.getText();
		String EBITMarginValue = VIPOverviewPage.contents.EBITMarginValue.getText();
		String EnterpriseValue = VIPOverviewPage.contents.EnterpriseValue.getText();
		String EmployeesValue = VIPOverviewPage.contents.EmployeesValue.getText();
		//Financials Data - Adjusted Revenue
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.RG5YrRevCAGRHeader.waitForExist(true, 45);
		String RG5YrRevCAGRPeerMedian_AdRev = VIPFinancialsPage.contents.RG5YrRevCAGRPeerMedian.getText();
		String RG3YrRevCAGRPeerMedian_AdRev = VIPFinancialsPage.contents.RG3YrRevCAGRPeerMedian.getText();
		String RG1YrRevCAGRPeerMedian_AdRev = VIPFinancialsPage.contents.RG1YrRevCAGRPeerMedian.getText();
		String RGFootNote_AdRev = VIPFinancialsPage.contents.RGFootNote.getText();
		String StandalonePerf_AdRev = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CompetitivePosition1_AdRev = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CompetitivePosition2_AdRev = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String BestInClass_AdRev = VIPFinancialsPage.contents.BestInClass.getText();
		//Financials Data - As Reported
		String RG5YrRevCAGRPeerMedian_AsRep = "";
		String RG3YrRevCAGRPeerMedian_AsRep = "";
		String RG1YrRevCAGRPeerMedian_AsRep = "";
		String RGFootNote_AsRep = "";
		String StandalonePerf_AsRep = "";
		String CompetitivePosition1_AsRep = "";
		String CompetitivePosition2_AsRep = "";
		String BestInClass_AsRep = "";
		if (VIPFinancialsPage.contents.AdjRevAsRepToggleButton.isDisplayed()) {
			VIPFinancialsPage.contents.AdjRevAsRepToggleButton.click();
			Thread.sleep(1000);
			RG5YrRevCAGRPeerMedian_AsRep = VIPFinancialsPage.contents.RG5YrRevCAGRPeerMedian.getText();
			RG3YrRevCAGRPeerMedian_AsRep = VIPFinancialsPage.contents.RG3YrRevCAGRPeerMedian.getText();
			RG1YrRevCAGRPeerMedian_AsRep = VIPFinancialsPage.contents.RG1YrRevCAGRPeerMedian.getText();
			RGFootNote_AsRep = VIPFinancialsPage.contents.RGFootNote.getText();
			StandalonePerf_AsRep = VIPFinancialsPage.contents.StandalonePerf.getText();
			CompetitivePosition1_AsRep = VIPFinancialsPage.contents.CompetitivePosition1.getText();
			CompetitivePosition2_AsRep = VIPFinancialsPage.contents.CompetitivePosition2.getText();
			BestInClass_AsRep = VIPFinancialsPage.contents.BestInClass.getText();
		}
		WebControl.takeScreenshot("Q2A_Regression_162_Test Data Prep");
		
		ReportLog.setTestCase("Q2A_Regression_162_Data Validation");
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.hotelCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.RevenueValue.waitForExist(true, 60);
		//Overview Data
		VIPOverviewPage.contents.RevenueValue.verifyText(RevenueValue);
		VIPOverviewPage.contents.EBITMarginValue.verifyText(EBITMarginValue);
		VIPOverviewPage.contents.EnterpriseValue.verifyText(EnterpriseValue);
		VIPOverviewPage.contents.EmployeesValue.verifyText(EmployeesValue);
		//Financials Data - Adjusted Revenue
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.RG5YrRevCAGRHeader.waitForExist(true, 45);
		VIPFinancialsPage.contents.RG5YrRevCAGRPeerMedian.verifyText(RG5YrRevCAGRPeerMedian_AdRev);
		VIPFinancialsPage.contents.RG3YrRevCAGRPeerMedian.verifyText(RG3YrRevCAGRPeerMedian_AdRev);
		VIPFinancialsPage.contents.RG1YrRevCAGRPeerMedian.verifyText(RG1YrRevCAGRPeerMedian_AdRev);
		VIPFinancialsPage.contents.RGFootNote.verifyText(RGFootNote_AdRev);
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf_AdRev);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1_AdRev);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CompetitivePosition2_AdRev);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass_AdRev);
		//Financials Data - As Reported
		if (!RG5YrRevCAGRPeerMedian_AsRep.equals("")) {
			if (VIPFinancialsPage.contents.AdjRevAsRepToggleButton.isDisplayed()) {
				VIPFinancialsPage.contents.AdjRevAsRepToggleButton.click();
				Thread.sleep(1000);
				VIPFinancialsPage.contents.RG5YrRevCAGRPeerMedian.verifyText(RG5YrRevCAGRPeerMedian_AsRep);
				VIPFinancialsPage.contents.RG3YrRevCAGRPeerMedian.verifyText(RG3YrRevCAGRPeerMedian_AsRep);
				VIPFinancialsPage.contents.RG1YrRevCAGRPeerMedian.verifyText(RG1YrRevCAGRPeerMedian_AsRep);
				VIPFinancialsPage.contents.RGFootNote.verifyText(RGFootNote_AsRep);
				VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf_AsRep);
				VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1_AsRep);
				VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CompetitivePosition2_AsRep);
				VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass_AsRep);
			}
			else {
				VIPFinancialsPage.contents.AdjRevAsRepToggleButton.verifyDisplayed(true);
			}
		}
		WebControl.takeScreenshot("Q2A_Regression_162_Data Validation");}
	}
	
	@Test(priority=18)
	public void Q2A_OpexView () throws Exception {
		ReportLog.setTestName("Q2A - Opex View");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_168");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.opexCompany);
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
		VIPFinancialsPage.contents.PreTaxROICMenu.click();
		VIPFinancialsPage.contents.LeftHandChartHeader.waitForExist(true, 15);
		VIPFinancialsPage.contents.COGSRevenueBox.verifyDisplayed(false);
		VIPFinancialsPage.contents.SGARevenueBox.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Regression_168");
		
		ReportLog.setTestCase("Q2A_Regression_169");
		VIPFinancialsPage.contents.OperatingExpensesRevenueBox.verifyDisplayed(true);
		VIPFinancialsPage.contents.OperatingExpensesRevenueBoxPos.verifyDisplayed(true);
		WebControl.takeScreenshot("Q2A_Regression_169");
		
		ReportLog.setTestCase("Q2A_Regression_170");
		VIPFinancialsPage.contents.OperatingExpensesRevenueBox.hover();
		VIPFinancialsPage.contents.OperatingExpensesRevenueBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("OPERATING EXPENSE / REVENUE");
		WebControl.takeScreenshot("Q2A_Regression_170");
		
		ReportLog.setTestCase("Q2A_Regression_171");
		VIPFinancialsPage.contents.OpexRevenueiIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.OpexRevenueiIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText("Operating Expense / Revenue is the sum of COGS / Revenue and SG&A / Revenue.\n"
				+ "COGS / Revenue indicates COGS as a percentage of sales, where Cost of goods sold (COGS) refers to the direct costs of producing the goods or services sold by a company. This amount includes the cost of the production and labor directly used to manufacture the goods or deliver the services.\n"
				+ "SG&A / Revenue indicates SG&A as a percentage of sales, where SG&A refers to the sum of all sales, marketing, general, administrative and other overhead expenses of a company.");
		VIPFinancialsPage.contents.OpexRevenueiIcon.click();
		WebControl.takeScreenshot("Q2A_Regression_171");
		
		ReportLog.setTestCase("Q2A_Regression_173");
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("OPERATING EXPENSE / REVENUE");
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndOpeExpRevMenu.verifyText("Operating Expense / Revenue");
		VIPFinancialsPage.contents.IndOpeExpRevMenuSelected.verifyText("Operating Expense / Revenue");
		WebControl.takeScreenshot("Q2A_Regression_173");
		
		ReportLog.setTestCase("Q2A_Regression_174");
		VIPFinancialsPage.contents.IndCOGSRevenueMenuText.verifyDisplayed(false);
		VIPFinancialsPage.contents.IndSGARevenueMenuText.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Regression_174");
		
		ReportLog.setTestCase("Q2A_Regression_177");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.OpexKPI.waitForExist(true, 10);
		//Opex KPI
		String OpexKPI2_1 = VIPFinancialsPage.contents.OpexKPI.getText();
		String OpexKPI2_2 = OpexKPI2_1.replace("%", "");
		Double OpexKPI2_3 = Double.parseDouble(OpexKPI2_2);
		//Opex Peer Median
		String OpexKPIP2_1 = VIPFinancialsPage.contents.OpexKPIP.getText();
		String OpexKPIP2_2 = OpexKPIP2_1.replace("%", "");
		Double OpexKPIP2_3 = Double.parseDouble(OpexKPIP2_2);
		BigDecimal OpexKPI_KPIP_1 = new BigDecimal(OpexKPI2_3 - OpexKPIP2_3);
		BigDecimal OpexKPIP_KPI_1 = new BigDecimal(OpexKPIP2_3 - OpexKPI2_3);
		BigDecimal OpexKPI_KPIP_2 = OpexKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal OpexKPIP_KPI_2 = OpexKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//Opex Best
		String OpexBest1 = VIPFinancialsPage.contents.OpexBest.getText();
		String OpexBest2 = OpexBest1.replace("%", "");
		Double OpexBest3 = Double.parseDouble(OpexBest2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OpexBest.hover();
		String OpexBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String OpexBest1_2 = OpexBest1_1.replace(OpexBest1, "");
		String OpexBest1_3 = OpexBest1_2.replace(" : ", "");
		//Opex Rank
		String OpexRank1 = VIPFinancialsPage.contents.OpexRank.getText();
		String[] OpexRank2 = OpexRank1.split("\\/");
		String OpexRank2_1 = OpexRank2[0];
		String OpexRank2_2 = OpexRank2[1];
		String OpexRank2_3 = OpexRank2_1.replace(" ", "");
		String OpexRank2_4 = OpexRank2_2.replace(" ", "");
		Double OpexRank3_1 = Double.parseDouble(OpexRank2_3);
		Double OpexRank3_2 = Double.parseDouble(OpexRank2_4);
		Double OpexRank3_3 = (OpexRank3_1/OpexRank3_2);
		BigDecimal OpexRank3_4 = new BigDecimal(OpexRank3_3);
		BigDecimal OpexRank3_5 = OpexRank3_4.setScale(2, BigDecimal.ROUND_HALF_UP);
		Double OpexRank3  = OpexRank3_5.doubleValue();
		//Opex 2 year Change
		String Opex2YrChange1 = VIPFinancialsPage.contents.Opex2YrChange.getText();
		String Opex2YrChange2 = Opex2YrChange1.replace("pps", "");
		String Opex2YrChange3 = Opex2YrChange2.replace("+", "");
		String Opex2YrChange4 = Opex2YrChange3.replace("-", "");
		Double Opex2YrChange5 = Double.parseDouble(Opex2YrChange4);
		Double Opex2YrChange6 = Double.parseDouble(Opex2YrChange3);
		//OpexKPI2_3 + Opex2YrChange5
		BigDecimal OpexKPI_2YrChange_1 = new BigDecimal(OpexKPI2_3 + Opex2YrChange5);
		BigDecimal OpexKPIP_2YrChange_2 = OpexKPI_2YrChange_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//OpexKPI2_3 - Opex2YrChange5
		BigDecimal OpexKPI_2YrChange_3 = new BigDecimal(OpexKPI2_3 - Opex2YrChange5);
		BigDecimal OpexKPIP_2YrChange_4 = OpexKPI_2YrChange_3.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.PreTaxROICMenu.click();
		VIPFinancialsPage.contents.LeftHandChartHeader.waitForExist(true, 15);
		VIPFinancialsPage.contents.OperatingExpensesRevenueBox.hover();
		VIPFinancialsPage.contents.OperatingExpensesRevenueBox.click();
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		String Period1 = VIPFinancialsPage.contents.FirstPeriodHeader.getText();
		String Period3 = VIPFinancialsPage.contents.ThirdPeriodHeader.getText();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (Opex2YrChange6 < 0) {	
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.opexCompany + "’s Operating Expense/Revenue decreased by " + Opex2YrChange5 + " pps over the last 2 years from " + OpexKPIP_2YrChange_2 + "% in " + Period1 + " to " + OpexKPI2_3 + "% in " + Period3);
			VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (Opex2YrChange6 > 0) {		
			VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.opexCompany + "’s Operating Expense/Revenue increased by " + Opex2YrChange5 + " pps over the last 2 years from " + OpexKPIP_2YrChange_4 + "% in " + Period1 + " to " + OpexKPI2_3 + "% in " + Period3);
			VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.opexCompany + "’s Operating Expense/Revenue remained constant at " + OpexKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		WebControl.takeScreenshot("Q2A_Regression_177");
		
		ReportLog.setTestCase("Q2A_Regression_178");
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (OpexKPI2_3 > OpexKPIP2_3) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Operating Expense/Revenue in " + Period3 + " is higher than the peer median of " + OpexKPIP2_3 + "%" + " by " + OpexKPI_KPIP_2 + " pps");
			VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else if (OpexKPI2_3 < OpexKPIP2_3) {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Operating Expense/Revenue in " + Period3 + " is lower than the peer median of " + OpexKPIP2_3 + "%" + " by " + OpexKPIP_KPI_2 + " pps");
			VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {
			VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Operating Expense/Revenue in " + Period3 + " is " + OpexKPIP2_3 + "%" + ", same as the peer median");
			VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((OpexRank3 > 0) & (OpexRank3 <= 0.25)) {
			VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.opexCompany + "'s Operating Expense/Revenue performance placed it in the top quartile of the peer group");
			VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((OpexRank3 > 0.25) & (OpexRank3 <= 0.50)) {
			VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.opexCompany + "'s Operating Expense/Revenue performance placed it in the 2nd quartile of the peer group");
			VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((OpexRank3 > 0.5) & (OpexRank3 <= 0.75)) {
			VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.opexCompany + "'s Operating Expense/Revenue performance placed it in the 3rd quartile of the peer group");
			VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText(testDataHandler.opexCompany + "'s Operating Expense/Revenue performance placed it in the bottom quartile of the peer group");
			VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		WebControl.takeScreenshot("Q2A_Regression_178");
		
		ReportLog.setTestCase("Q2A_Regression_179");
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(OpexBest1_3 + " (" + OpexBest3 + "%) " + "ranked the best in terms of Operating Expense/Revenue in " + Period3);
		WebControl.takeScreenshot("Q2A_Regression_179");
		
		ReportLog.setTestCase("Q2A_Regression_180");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.BenchmarkButton.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BenchmarkButton.verifyText("Accenture Proprietary EVT Benchmarks");
		VIPFinancialsPage.contents.BenchmarkButton.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("This is EVT team's database which includes FTE and Cost benchmarks per SG&A function (Finance, HR, Procurement etc.)");
		VIPFinancialsPage.contents.BenchmarkLink.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Regression_180");
		
		ReportLog.setTestCase("Q2A_Regression_181");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.OpexKPI.waitForExist(true, 10);
		VIPFinancialsPage.contents.COGSMetricTitle.verifyDisplayed(false);
		VIPFinancialsPage.contents.SGAMetricTitle.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Regression_181");
		
		ReportLog.setTestCase("Q2A_Regression_182");
		VIPFinancialsPage.contents.OPEXMetricTitle.verifyDisplayed(true);
		VIPFinancialsPage.contents.EBITMarginDecomSubMetric1.verifyText("Operating Expense");
		VIPFinancialsPage.contents.EBITMarginDecomSubMetric2.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Regression_182");
		
		ReportLog.setTestCase("Q2A_Regression_184");
		VIPFinancialsPage.contents.ScorecardSubMetric6aInfoIcon2.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.ScorecardSubMetric6aInfoIcon2.click();
		VIPFinancialsPage.contents.TooltipText3.verifyText("Operating Expense / Revenue is the sum of COGS / Revenue and SG&A / Revenue.\n"
				+ "COGS / Revenue indicates COGS as a percentage of sales, where Cost of goods sold (COGS) refers to the direct costs of producing the goods or services sold by a company. This amount includes the cost of the production and labor directly used to manufacture the goods or deliver the services.\n"
				+ "SG&A / Revenue indicates SG&A as a percentage of sales, where SG&A refers to the sum of all sales, marketing, general, administrative and other overhead expenses of a company.");
		VIPFinancialsPage.contents.ScorecardSubMetric6aInfoIcon2.click();
		WebControl.takeScreenshot("Q2A_Regression_184");
		
		ReportLog.setTestCase("Q2A_Regression_185");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.GlossaryMenu.click();
		VIPFinancialsPage.contents.GlossaryTitle.waitForExist(true, 10);
		VIPFinancialsPage.contents.Indicator11.verifyText("Operating Expense / Revenue");
		VIPFinancialsPage.contents.Dashboard11.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Indicator12.verifyText("COGS / Revenue");
		WebControl.takeScreenshot("Q2A_Regression_185");
		
		ReportLog.setTestCase("Q2A_Regression_186");
		VIPFinancialsPage.contents.Definition11.verifyText("Operating Expense / Revenue is the sum of COGS / Revenue and SG&A / Revenue.");
		WebControl.takeScreenshot("Q2A_Regression_186");
		
		ReportLog.setTestCase("Q2A_Regression_188_&_190");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.opex1PeriodCompany);
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
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.KPI16.waitForExist(true, 10);
		if (VIPFinancialsPage.contents.EBITMarginDecomSubMetric1.getText().equals("Operating Expense") && VIPFinancialsPage.contents.KPI16.getText().equals("N/M") || VIPFinancialsPage.contents.KPI17.getText().equals("N/M")) {
			ReportLog.passed("Target Company doesn't have value in either COGS or SGA which satisfy the TC");
			VIPLandingPage.contents.HelpIcon.hover();
			VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
			VIPFinancialsPage.contents.SelectDashboardDropdown.click();
			VIPFinancialsPage.contents.PreTaxROICMenu.click();
			VIPFinancialsPage.contents.LeftHandChartHeader.waitForExist(true, 15);
			VIPFinancialsPage.contents.COGSRevenueBox.verifyDisplayed(true);
			VIPFinancialsPage.contents.SGARevenueBox.verifyDisplayed(true);
			VIPFinancialsPage.contents.OperatingExpensesRevenueBox.verifyDisplayed(false);
			VIPFinancialsPage.contents.COGSRevenueBox.click();
			VIPFinancialsPage.contents.StandalonePerfLine.verifyDisplayed(false);
			VIPFinancialsPage.contents.CompetitivePositionLine1.verifyDisplayed(false);
			VIPFinancialsPage.contents.CompetitivePositionLine2.verifyDisplayed(false);
			VIPFinancialsPage.contents.SGARevenueBox.click();
			VIPFinancialsPage.contents.StandalonePerfLine.verifyDisplayed(false);
			VIPFinancialsPage.contents.CompetitivePositionLine1.verifyDisplayed(false);
			VIPFinancialsPage.contents.CompetitivePositionLine2.verifyDisplayed(false);
			WebControl.takeScreenshot("Q2A_Regression_188_&_190");
		}
		else {
			ReportLog.failed("Target Company have values in both COGS and SGA which doesn't satisfy the TC");
		}
		
		ReportLog.setTestCase("Q2A_Regression_191");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.KPI16.waitForExist(true, 10);
		VIPFinancialsPage.contents.ScorecardSubMetric6a.verifyText("Cost of Goods Sold");
		VIPFinancialsPage.contents.ScorecardSubMetric6b.verifyText("Selling, General & Administrative Expenses");
		VIPFinancialsPage.contents.KPI16.verifyText("N/M");
		VIPFinancialsPage.contents.KPI17.verifyText("N/M");
		VIPFinancialsPage.contents.COGSRank.verifyText("N/M");
		VIPFinancialsPage.contents.SGARank.verifyText("N/M");
		VIPFinancialsPage.contents.COGS2YrChange.verifyText("N/M");
		VIPFinancialsPage.contents.SGA2YrChange.verifyText("N/M");
		WebControl.takeScreenshot("Q2A_Regression_191");
		
		ReportLog.setTestCase("Q2A_Regression_192");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.GlossaryMenu.click();
		VIPFinancialsPage.contents.GlossaryTitle.waitForExist(true, 10);
		VIPFinancialsPage.contents.Indicator11.verifyText("COGS / Revenue");
		VIPFinancialsPage.contents.Dashboard11.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Indicator12.verifyText("SG&A / Revenue");
		VIPFinancialsPage.contents.Dashboard12.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Negative11.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Regression_192");
		
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


