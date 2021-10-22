package scenarios.Q2A;

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
import pageobjects.VIPSalesPage;
import pageobjects.VIPTranscriptPage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Q2A_02_CompetitivenessScorecard extends TestBase{
	
	@Test
	public void Q2A_CompetitivenessScorecard () throws Exception {
		ReportLog.setTestName("Q2A - Competitiveness Scorecard");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_008");
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
	
}


