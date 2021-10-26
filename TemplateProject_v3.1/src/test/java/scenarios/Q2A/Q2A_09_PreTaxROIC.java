package scenarios.Q2A;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class Q2A_09_PreTaxROIC extends TestBase{
	
	@Test
	public void Q2A_PreTaxROIC () throws Exception {
		ReportLog.setTestName("Q2A - Pre-Tax ROIC Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_074");	
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
		String[] Period1 = VIPFinancialsPage.contents.ScoreCardDate.getText().split("\\/");
		String Period2 = Period1[1].replace("]", "");
		int Period = Integer.parseInt(Period2);
		int Period_1 = Period - 1;
		int Period_2 = Period - 2;
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
		int OneYrAgo = get1YearAgo();
		String OneYear = String.valueOf(OneYrAgo);
		int TwoYrsAgo = get2YearsAgo();
		String TwoYears = String.valueOf(TwoYrsAgo);
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.FirstPeriodHeader.verifyText(Period_2yr);
		VIPFinancialsPage.contents.SecondPeriodHeader.verifyText(Period_1yr);
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
		//Final Best Values - ROIC
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(ROICBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) {
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(ROICBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);}
		String ROICBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String ROICBestFinal_2[] = ROICBestFinal_1.split("\\|");
		String ROICBestFinal_3 = ROICBestFinal_2[0];
		String ROICBestFinal = ROICBestFinal_3.substring(0, ROICBestFinal_3.length() - 1);
		//Final Best Values - EBIT Margin
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(EBITMarginBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) {
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(EBITMarginBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);}
		String EBITMarginBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String EBITMarginBestFinal_2[] = EBITMarginBestFinal_1.split("\\|");
		String EBITMarginBestFinal_3 = EBITMarginBestFinal_2[0];
		String EBITMarginBestFinal = EBITMarginBestFinal_3.substring(0, EBITMarginBestFinal_3.length() - 1);
		//Final Best Values - Capital Efficiency
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(CapitalEfficiencyBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) {
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(CapitalEfficiencyBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);}
		String CapitalEfficiencyBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String CapitalEfficiencyBestFinal_2[] = CapitalEfficiencyBestFinal_1.split("\\|");
		String CapitalEfficiencyBestFinal_3 = CapitalEfficiencyBestFinal_2[0];
		String CapitalEfficiencyBestFinal = CapitalEfficiencyBestFinal_3.substring(0, CapitalEfficiencyBestFinal_3.length() - 1);
		//Final Best Values - COGS
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(COGSBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) {
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(COGSBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);}
		String COGSBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String COGSBestFinal_2[] = COGSBestFinal_1.split("\\|");
		String COGSBestFinal_3 = COGSBestFinal_2[0];
		String COGSBestFinal = COGSBestFinal_3.substring(0, COGSBestFinal_3.length() - 1);
		//Final Best Values - SGA
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(SGABest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) {
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(SGABest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);}
		String SGABestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String SGABestFinal_2[] = SGABestFinal_1.split("\\|");
		String SGABestFinal_3 = SGABestFinal_2[0];
		String SGABestFinal = SGABestFinal_3.substring(0, SGABestFinal_3.length() - 1);
		//Final Best Values - Working Capital
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(OpeWorCapBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) {
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(OpeWorCapBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);}
		String OpeWorCapBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String OpeWorCapBestFinal_2[] = OpeWorCapBestFinal_1.split("\\|");
		String OpeWorCapBestFinal_3 = OpeWorCapBestFinal_2[0];
		String OpeWorCapBestFinal = OpeWorCapBestFinal_3.substring(0, OpeWorCapBestFinal_3.length() - 1);
		//Final Best Values - Net PPE
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(NetPPEBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) {
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(NetPPEBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);}
		String NetPPEBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String NetPPEBestFinal_2[] = NetPPEBestFinal_1.split("\\|");
		String NetPPEBestFinal_3 = NetPPEBestFinal_2[0];
		String NetPPEBestFinal = NetPPEBestFinal_3.substring(0, NetPPEBestFinal_3.length() - 1);
		//Final Best Values - Goodwill Intangibles
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(GoodWillIntBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) {
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(GoodWillIntBest1_3);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);}
		String GoodWillIntBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String GoodWillIntBestFinal_2[] = GoodWillIntBestFinal_1.split("\\|");
		String GoodWillIntBestFinal_3 = GoodWillIntBestFinal_2[0];
		String GoodWillIntBestFinal = GoodWillIntBestFinal_3.substring(0, GoodWillIntBestFinal_3.length() - 1);
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		if (!VIPLandingPage.contents.CompanyTypeAhead.isDisplayed()) {
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);}
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 20);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 20);
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
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC decreased by " + ROIC2YrChange5 + " pps over the last 2 years from " + ROICKPIP_2YrChange_2 + "% in " + Last2Year + " to " + ROICKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (ROIC2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s ROIC increased by " + ROIC2YrChange5 + " pps over the last 2 years from " + ROICKPIP_2YrChange_4 + "% in " + Last2Year + " to " + ROICKPI2_3 + "% in TTM");
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
		VIPFinancialsPage.contents.BestInClass.verifyText(ROICBestFinal + " (" + ROICBest3 + "%) " + "ranked the best in terms of ROIC in TTM");
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
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin decreased by " + EBITMargin2YrChange5 + " pps over the last 2 years from " + EBITMarginKPIP_2YrChange_2 + "% in " + Last2Year + " to " + EBITMarginKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (EBITMargin2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s operating margin increased by " + EBITMargin2YrChange5 + " pps over the last 2 years from " + EBITMarginKPIP_2YrChange_4 + "% in " + Last2Year + " to " + EBITMarginKPI2_3 + "% in TTM");
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
		VIPFinancialsPage.contents.BestInClass.verifyText(EBITMarginBestFinal + " (" + EBITMarginBest3 + "%) " + "ranked the best in terms of operating margin in TTM");
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
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_Capital Efficiency");
		//CapitalEfficiency
		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		String[] CEStandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText().split("\\s");
		Double CEStandalonePerf1 = Double.parseDouble(CEStandalonePerf[CEStandalonePerf.length - 14]);
		Double CEStandalonePerf2 = Double.parseDouble(CEStandalonePerf[CEStandalonePerf.length - 7]);
		Double CEStandalonePerf3 = Double.parseDouble(CEStandalonePerf[CEStandalonePerf.length - 3]);
		DecimalFormat df = new DecimalFormat("#.#");
		String SP1_1 = df.format(CEStandalonePerf1);
		BigDecimal SP2_1 = new BigDecimal(CEStandalonePerf2);
		BigDecimal SP2_2 = SP2_1.setScale(1, BigDecimal.ROUND_HALF_UP);
		String SP3_1 = df.format(CEStandalonePerf3);
		if (CapitalEfficiency2YrChange6 < 0) {		
			if (CapitalEfficiency2YrChange5.equals(Double.parseDouble(SP1_1)) & CapitalEfficiencyKPIP_2YrChange_2.equals(SP2_2) & CapitalEfficiencyKPI2_3.equals(Double.parseDouble(SP3_1))) {
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency decreased by " + CEStandalonePerf1 + " over the last 2 years from " + CEStandalonePerf2 + " in " + Last2Year + " to " + CEStandalonePerf3 + " in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
			else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency decreased by " + CapitalEfficiency2YrChange5 + " over the last 2 years from " + CapitalEfficiencyKPIP_2YrChange_2 + " in " + Last2Year + " to " + CapitalEfficiencyKPI2_3 + " in TTM");
			VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}}
		else if (CapitalEfficiency2YrChange6 > 0) {	
			if (CapitalEfficiency2YrChange5.equals(Double.parseDouble(SP1_1)) & CapitalEfficiencyKPIP_2YrChange_2.equals(SP2_2) & CapitalEfficiencyKPI2_3.equals(Double.parseDouble(SP3_1))) {
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency increased by " + CEStandalonePerf1 + " over the last 2 years from " + CEStandalonePerf2 + " in " + Last2Year + " to " + CEStandalonePerf3 + " in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
			else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency increased by " + CapitalEfficiency2YrChange5 + " over the last 2 years from " + CapitalEfficiencyKPIP_2YrChange_4 + " in " + Last2Year + " to " + CapitalEfficiencyKPI2_3 + " in TTM");
			VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Capital Efficiency remained the same");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePosition1.verifyDisplayed(true, 5);
		String[] CECompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText().split("\\s");
		Double CECompetitivePosition1_1 = Double.parseDouble(CECompetitivePosition1[CECompetitivePosition1.length - 3]);
		Double CECompetitivePosition1_2 = Double.parseDouble(CECompetitivePosition1[CECompetitivePosition1.length - 1]);
		String CP1_1 = df.format(CECompetitivePosition1_1);
		BigDecimal CP2_1 = new BigDecimal(CECompetitivePosition1_2);
		BigDecimal CP2_2 = CP2_1.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (CapitalEfficiencyKPI2_3 > CapitalEfficiencyKPIP2_3) {
			if (CapitalEfficiencyKPIP2_3.equals(Double.parseDouble(CP1_1)) & CapitalEfficiencyKPI_KPIP_2.equals(CP2_2)) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is higher than the peer median of " + CECompetitivePosition1_1 + " by " + CECompetitivePosition1_2);
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
			else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is higher than the peer median of " + CapitalEfficiencyKPIP2_3 + " by " + CapitalEfficiencyKPI_KPIP_2);
			VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}}
		else if (CapitalEfficiencyKPI2_3 < CapitalEfficiencyKPIP2_3) {
			if (CapitalEfficiencyKPIP2_3.equals(Double.parseDouble(CP1_1)) & CapitalEfficiencyKPI_KPIP_2.equals(CP2_2)) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is lower than the peer median of " + CECompetitivePosition1_1 + " by " + CECompetitivePosition1_2);
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
			else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is lower than the peer median of " + CapitalEfficiencyKPIP2_3 + " by " + CapitalEfficiencyKPIP_KPI_2);
			VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}}
		else {
			if (CapitalEfficiencyKPIP2_3.equals(Double.parseDouble(CP1_1)) & CapitalEfficiencyKPI_KPIP_2.equals(CP2_2)) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is " + CECompetitivePosition1_1  + ", same as the peer median");
		VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}
			else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Capital Efficiency in TTM is " + CapitalEfficiencyKPIP2_3  + ", same as the peer median");
			VIPFinancialsPage.contents.CompPosYellowIcon1.verifyDisplayed(true, 3);}}
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
		String[] CEBestInClass = VIPFinancialsPage.contents.BestInClass.getText().split("\\s");
		String CEBestInClass_2 = CEBestInClass[CEBestInClass.length - 11].replace("(", "").replace(")", "");
		Double CEBestInClass_1 = Double.parseDouble(CEBestInClass_2);
		String BC1_1 = df.format(CEBestInClass_1);
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		if (CapitalEfficiencyBest3.equals(Double.parseDouble(BC1_1))) {
		VIPFinancialsPage.contents.BestInClass.verifyText(CapitalEfficiencyBestFinal + " (" + CEBestInClass_2 + ") " + "ranked the best in terms of Capital Efficiency in TTM");}
		else {VIPFinancialsPage.contents.BestInClass.verifyText(CapitalEfficiencyBestFinal + " (" + CapitalEfficiencyBest3 + ") " + "ranked the best in terms of Capital Efficiency in TTM");}
		//Footnote
		if (!VIPFinancialsPage.contents.FootNote3.isDisplayed()) {
		VIPFinancialsPage.contents.FootNote.verifyText("Note: Capital Efficiency uses invested capital value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else { String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote1 + " Capital Efficiency uses invested capital value averaged over two periods for KPI calculation.  For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		//TestData
		String CESP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CECP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CECP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String CEBest = VIPFinancialsPage.contents.BestInClass.getText();
		String CEFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_088_&_089_Capital Efficiency");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_088_&_089_COGS Revenue");
		//COGS
		VIPFinancialsPage.contents.COGSRevenueBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (COGS2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue decreased by " + COGS2YrChange5 + " pps over the last 2 years from " + COGSKPIP_2YrChange_2 + "% in " + Last2Year + " to " + COGSKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (COGS2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s COGS/Revenue increased by " + COGS2YrChange5 + " pps over the last 2 years from " + COGSKPIP_2YrChange_4 + "% in " + Last2Year + " to " + COGSKPI2_3 + "% in TTM");
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
		VIPFinancialsPage.contents.BestInClass.verifyText(COGSBestFinal + " (" + COGSBest3 + "%) " + "ranked the best in terms of COGS/Revenue in TTM");
		//Footnote
		if (VIPFinancialsPage.contents.FootNote2.isDisplayed()) {
		String FootNote0 = VIPFinancialsPage.contents.FootNote0.getText();
		String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote0 + FootNote1 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else if (VIPFinancialsPage.contents.FootNote1.isDisplayed()) { 
		String FootNote0 = VIPFinancialsPage.contents.FootNote0.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote0 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
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
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue decreased by " + SGA2YrChange5 + " pps over the last 2 years from " + SGAKPIP_2YrChange_2 + "% in " + Last2Year + " to " + SGAKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (SGA2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s SG&A/Revenue increased by " + SGA2YrChange5 + " pps over the last 2 years from " + SGAKPIP_2YrChange_4 + "% in " + Last2Year + " to " + SGAKPI2_3 + "% in TTM");
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
		VIPFinancialsPage.contents.BestInClass.verifyText(SGABestFinal + " (" + SGABest3 + "%) " + "ranked the best in terms of SG&A/Revenue in TTM");
		//Footnote
		if (VIPFinancialsPage.contents.FootNote2.isDisplayed()) {
		String FootNote0 = VIPFinancialsPage.contents.FootNote0.getText();
		String FootNote1 = VIPFinancialsPage.contents.FootNote1.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote0 + FootNote1 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
		else if (VIPFinancialsPage.contents.FootNote1.isDisplayed()) { 
		String FootNote0 = VIPFinancialsPage.contents.FootNote0.getText();
		VIPFinancialsPage.contents.FootNote.verifyText("Note: " + FootNote0 + ". Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global.");}
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
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue decreased by " + OpeWorCap2YrChange5 + " pps over the last 2 years from " + OpeWorCapKPIP_2YrChange_2 + "% in " + Last2Year + " to " + OpeWorCapKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (OpeWorCap2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue increased by " + OpeWorCap2YrChange5 + " pps over the last 2 years from " + OpeWorCapKPIP_2YrChange_4 + "% in " + Last2Year + " to " + OpeWorCapKPI2_3 + "% in TTM");
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
		VIPFinancialsPage.contents.BestInClass.verifyText(OpeWorCapBestFinal + " (" + OpeWorCapBest3 + "%) " + "ranked the best in terms of Working Capital/Revenue in TTM");
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
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue decreased by " + NetPPE2YrChange5 + " pps over the last 2 years from " + NetPPEKPIP_2YrChange_2 + "% in " + Last2Year + " to " + NetPPEKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (NetPPE2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net PPE/Revenue increased by " + NetPPE2YrChange5 + " pps over the last 2 years from " + NetPPEKPIP_2YrChange_4 + "% in " + Last2Year + " to " + NetPPEKPI2_3 + "% in TTM");
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
		VIPFinancialsPage.contents.BestInClass.verifyText(NetPPEBestFinal + " (" + NetPPEBest3 + "%) " + "ranked the best in terms of Net PPE/Revenue in TTM");
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
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue decreased by " + GoodWillInt2YrChange5 + " pps over the last 2 years from " + GoodWillIntKPIP_2YrChange_2 + "% in " + Last2Year + " to " + GoodWillIntKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (GoodWillInt2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Goodwill & Int./Revenue increased by " + GoodWillInt2YrChange5 + " pps over the last 2 years from " + GoodWillIntKPIP_2YrChange_4 + "% in " + Last2Year + " to " + GoodWillIntKPI2_3 + "% in TTM");
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
		VIPFinancialsPage.contents.BestInClass.verifyText(GoodWillIntBestFinal + " (" + GoodWillIntBest3 + "%) " + "ranked the best in terms of Goodwill & Int./Revenue in TTM");
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
		VIPFinancialsPage.contents.FootNote.verifyText(ROICFootnote);
		VIPFinancialsPage.contents.EBITMARGINBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(EBITSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(EBITCP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(EBITCP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(EBITBest);
		VIPFinancialsPage.contents.FootNote.verifyText(EBITFootnote);
		VIPFinancialsPage.contents.CAPITALEFFICIENCYBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(CESP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CECP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CECP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(CEBest);
		VIPFinancialsPage.contents.FootNote.verifyText(CEFootnote);
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


