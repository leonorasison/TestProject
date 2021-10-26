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

public class Q2A_11_CashCycleAnalysis extends TestBase{
	
	@Test
	public void Q2A_CashCycleAnalysis () throws Exception {
		ReportLog.setTestName("Q2A - Cash Cycle Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_107");
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
	
}


