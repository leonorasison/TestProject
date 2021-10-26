package scenarios.SALES;

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

public class SalesLeadership_FinancialKPIs extends TestBase{
	
	@Test
	public void Sales_FinancialKPIs () throws Exception {
		ReportLog.setTestName("Sales Leadership - Financial KPIs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_13");
		VIP_Common.LogInPage(testDataHandler);
		Thread.sleep(3000);
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Vodafone Group Plc");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
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
		VIPSalesPage.contents.SideMenuSales.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(2000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.FinancialKPIs.hover();
		VIPSalesPage.contents.FinancialKPIs.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_13");
		
		ReportLog.setTestCase("Sales_Reg_Auto_14");
		VIPSalesPage.contents.DEPSTooltipIcon.verifyDisplayed(true, 60);
		VIPSalesPage.contents.DEPSTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.DEPSTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_1");
		VIPSalesPage.contents.DEPSTooltipIcon.click();
		VIPSalesPage.contents.NPPERTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.NPPERTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.NPPERTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_2");
		VIPSalesPage.contents.NPPERTooltipIcon.click();
		VIPSalesPage.contents.DSOTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DSOTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.DSOTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_3");
		VIPSalesPage.contents.DSOTooltipIcon.click();
		VIPSalesPage.contents.DIOTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DIOTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.DIOTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_4");
		VIPSalesPage.contents.DIOTooltipIcon.click();
		VIPSalesPage.contents.DPOTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DPOTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.DPOTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_5");
		VIPSalesPage.contents.DPOTooltipIcon.click();
		VIPSalesPage.contents.CCDTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CCDTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.CCDTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_6");
		VIPSalesPage.contents.CCDTooltipIcon.click();
		VIPSalesPage.contents.NDFCFTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.NDFCFTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText("Net Debt/FCF is a measurement of leverage and it measures how many years it would take a company to repay its debt if it devoted all its cashflows for it. It is calculated as = (Total Debt - Short Term Investments) / Free Cash Flow.");
		WebControl.takeScreenshot("Sales_Reg_Auto_14_7");
		VIPSalesPage.contents.NDFCFTooltipIcon.click();
		VIPSalesPage.contents.NDEBITDATooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.NDEBITDATooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.NDEBITDATooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_7");
		VIPSalesPage.contents.NDEBITDATooltipIcon.click();
		VIPSalesPage.contents.TDETooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TDETooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.TDETooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_8");
		VIPSalesPage.contents.TDETooltipIcon.click();
		VIPSalesPage.contents.ICTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.ICTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.ICTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_9");
		VIPSalesPage.contents.ICTooltipIcon.click();
		VIPSalesPage.contents.EVREVTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.EVREVTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText("EV/Revenue is a valuation that compares company’s Operating EV (Enterprise Value) to its annual sales. EV/Revenue is commonly used for early-stage or high-growth businesses that don’t have positive earnings yet. EV is calculated as = (Net Debt + Market Capitalization + Minority Interest + Preferred Equity - Long-Term Investments in JVs and Associates).");
		WebControl.takeScreenshot("Sales_Reg_Auto_14_10");
		VIPSalesPage.contents.EVREVTooltipIcon.click();
		VIPSalesPage.contents.EVEBITTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.EVEBITTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.EVEBITTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_14_10");
		VIPSalesPage.contents.EVEBITTooltipIcon.click();
		
//		ReportLog.setTestCase("Sales_Reg_Auto_15");
//		VIPSalesPage.contents.TimeFrame.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.MetricHeader.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.MetricHeader.verifyText("METRIC");
//		VIPSalesPage.contents.PercentileHeader.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.PercentileHeader.verifyText("PERCENTILE RANK");
//		VIPSalesPage.contents.CompanyHeader.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.CompanyHeader.verifyText("Vodafone Group Plc");
//		VIPSalesPage.contents.PeerMedianHeader.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.PeerMedianHeader.verifyText("PEER MEDIAN");
//		VIPSalesPage.contents.BestHeader.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.BestHeader.verifyText("BEST");
//		WebControl.takeScreenshot("Sales_Reg_Auto_15");
		
		ReportLog.setTestCase("Sales_Reg_Auto_15");
		VIPSalesPage.contents.TimeFrame.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MetricHeader.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MetricHeader.verifyText("METRIC");
		VIPSalesPage.contents.PercentileHeader.verifyDisplayed(true, 3);
		VIPSalesPage.contents.PercentileHeader.verifyText("PERCENTILE RANK");
		if (VIPSalesPage.contents.CompanyHeader.isDisplayed()) {
		VIPSalesPage.contents.CompanyHeader.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompanyHeader.verifyText("VODAFONE GROUP PLC");}
		else if (VIPSalesPage.contents.CompanyHeader2.isDisplayed()) {
		VIPSalesPage.contents.CompanyHeader2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompanyHeader2.verifyText("VODAFONE GROUP PLC");}
		else {VIPSalesPage.contents.CompanyHeader3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompanyHeader3.verifyText("VODAFONE GROUP PLC");}
		VIPSalesPage.contents.PeerMedianHeader.verifyDisplayed(true, 3);
		VIPSalesPage.contents.PeerMedianHeader.verifyText("PEER MEDIAN");
		VIPSalesPage.contents.BestHeader.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BestHeader.verifyText("BEST");
		WebControl.takeScreenshot("Sales_Reg_Auto_15");
		
		ReportLog.setTestCase("Sales_Reg_Auto_16");
		VIPSalesPage.contents.RevenueCAGR5Yr.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RevenueCAGR5Yr.verifyText("5-year Revenue CAGR");
		VIPSalesPage.contents.RevenueCAGR3Yr.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RevenueCAGR3Yr.verifyText("3-year Revenue CAGR");
		VIPSalesPage.contents.RevenueCAGR1Yr.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RevenueCAGR1Yr.verifyText("1-year Revenue CAGR");
		WebControl.takeScreenshot("Sales_Reg_Auto_16");
		
		ReportLog.setTestCase("Sales_Reg_Auto_17");
		VIPSalesPage.contents.COGSRevenue.verifyDisplayed(true, 5);
		VIPSalesPage.contents.COGSRevenue.verifyText("COGS / Revenue");
		VIPSalesPage.contents.SGARevenue.verifyDisplayed(true, 5);
		VIPSalesPage.contents.SGARevenue.verifyText("SG&A / Revenue");
		VIPSalesPage.contents.EBITMargin.verifyDisplayed(true, 5);
		VIPSalesPage.contents.EBITMargin.verifyText("EBIT margin");
		VIPSalesPage.contents.ROIC.verifyDisplayed(true, 5);
		VIPSalesPage.contents.ROIC.verifyText("ROIC (Pre-Tax)");
		VIPSalesPage.contents.DilutedEPS.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DilutedEPS.verifyText("Diluted EPS (EUR)");
		WebControl.takeScreenshot("Sales_Reg_Auto_17");
		
		ReportLog.setTestCase("Sales_Reg_Auto_18");
		VIPSalesPage.contents.RPE.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RPE.verifyText("Revenue per Employee (‘000 EUR)");
		VIPSalesPage.contents.NetPPE.verifyDisplayed(true, 5);
		VIPSalesPage.contents.NetPPE.verifyText("Net PPE / Revenue");
		VIPSalesPage.contents.DSO.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DSO.verifyText("Days Sales Outstanding");
		VIPSalesPage.contents.DIO.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DIO.verifyText("Days Inventory Outstanding");
		VIPSalesPage.contents.DPO.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DPO.verifyText("Days Payables Outstanding");
		VIPSalesPage.contents.CCD.verifyDisplayed(true, 5);
		VIPSalesPage.contents.CCD.verifyText("Cash Cycle Days");
		WebControl.takeScreenshot("Sales_Reg_Auto_18");
		
		ReportLog.setTestCase("Sales_Reg_Auto_19");
		VIPSalesPage.contents.NetDebtFCF.verifyDisplayed(true, 5);
		VIPSalesPage.contents.NetDebtFCF.verifyText("Net Debt / FCF");
		VIPSalesPage.contents.NetDebt.verifyDisplayed(true, 5);
		VIPSalesPage.contents.NetDebt.verifyText("Net Debt / EBITDA");
		VIPSalesPage.contents.TotalDebt.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TotalDebt.verifyText("Total Debt / Equity");
		VIPSalesPage.contents.InterestCoverage.verifyDisplayed(true, 5);
		VIPSalesPage.contents.InterestCoverage.verifyText("Interest Coverage");
		WebControl.takeScreenshot("Sales_Reg_Auto_19");
		
		ReportLog.setTestCase("Sales_Reg_Auto_20");
		VIPSalesPage.contents.EVREV.verifyDisplayed(true, 5);
		VIPSalesPage.contents.EVREV.verifyText("EV / Revenue");
		VIPSalesPage.contents.EVEBIT.verifyDisplayed(true, 5);
		VIPSalesPage.contents.EVEBIT.verifyText("EV / EBIT");
		WebControl.takeScreenshot("Sales_Reg_Auto_20");
		
		ReportLog.setTestCase("Sales_Reg_Auto_21");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.CAGR5YrKPI.hover();
		String CAGR5YrKPI = VIPFinancialsPage.contents.CAGR5YrKPI.getText();
		String CAGR3YrKPI = VIPFinancialsPage.contents.CAGR3YrKPI.getText();
		String CAGR1YrKPI = VIPFinancialsPage.contents.CAGR1YrKPI.getText();
		String EBITMarginKPI = VIPFinancialsPage.contents.EBITMarginKPI.getText();
		String ROICKPI = VIPFinancialsPage.contents.ROICKPI.getText();
		String SGAKPI = VIPFinancialsPage.contents.SGAKPI.getText();
		String COGSKPI = VIPFinancialsPage.contents.COGSKPI.getText();
		String EVEBIT = VIPFinancialsPage.contents.EVEBITKPI.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(2000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.FinancialKPIs.hover();
		VIPSalesPage.contents.FinancialKPIs.click();
		VIPSalesPage.contents.RevenueCAGR5YrKPI.verifyText(CAGR5YrKPI);
		VIPSalesPage.contents.RevenueCAGR3YrKPI.verifyText(CAGR3YrKPI);
		VIPSalesPage.contents.RevenueCAGR1YrKPI.verifyText(CAGR1YrKPI);
		WebControl.takeScreenshot("Sales_Reg_Auto_21");
		
		ReportLog.setTestCase("Sales_Reg_Auto_22");
		VIPSalesPage.contents.COGSRevenueKPI.verifyText(COGSKPI);
		VIPSalesPage.contents.SGARevenueKPI.verifyText(SGAKPI);
		VIPSalesPage.contents.EBITMarginKPI.verifyText(EBITMarginKPI);
		VIPSalesPage.contents.ROICKPI.verifyText(ROICKPI);
		WebControl.takeScreenshot("Sales_Reg_Auto_22");
		
		ReportLog.setTestCase("Sales_Reg_Auto_23");
		VIPSalesPage.contents.EVEBITKPI.verifyText(EVEBIT);
		WebControl.takeScreenshot("Sales_Reg_Auto_23");
		
		ReportLog.setTestCase("Sales_Reg_Auto_24");
		VIPSalesPage.contents.Q4.verifyDisplayed(true, 5);
		VIPSalesPage.contents.Q4.verifyText("Q4");
		VIPSalesPage.contents.Q3.verifyDisplayed(true, 5);
		VIPSalesPage.contents.Q3.verifyText("Q3");
		VIPSalesPage.contents.Q2.verifyDisplayed(true, 5);
		VIPSalesPage.contents.Q2.verifyText("Q2");
		VIPSalesPage.contents.Q1.verifyDisplayed(true, 5);
		VIPSalesPage.contents.Q1.verifyText("Q1");
		WebControl.takeScreenshot("Sales_Reg_Auto_24");
		
		ReportLog.setTestCase("Sales_Reg_Auto_25");
		VIPSalesPage.contents.ScorecardNote.verifyDisplayed(true, 5);
		VIPSalesPage.contents.ScorecardNote.verifyText(testDataHandler.ScorecardNote);
		WebControl.takeScreenshot("Sales_Reg_Auto_25");
		
		ReportLog.setTestCase("Sales_Reg_Auto_26");
		VIPSalesPage.contents.Source.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Sales_Reg_Auto_26");
		
		
	}
	
}


