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

public class SalesLeadership_02_ValueProposition extends TestBase{
	
	@Test
	public void Sales_ValueProposition () throws Exception {
		ReportLog.setTestName("Sales Leadership - Value Proposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_046");	
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
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (VIPSalesPage.contents.OppNavModal.isDisplayed()) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.ValueProposition.waitForExist(true, 15);
		VIPSalesPage.contents.ValueProposition.hover();
		VIPSalesPage.contents.ValueProposition.click();
		VIPSalesPage.contents.VPSegment1.verifyDisplayed(true, 30);
		VIPSalesPage.contents.VPSegment1.verifyText("Cost Reduction");
		VIPSalesPage.contents.VPSegment2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPSegment2.verifyText("Revenue Growth");
		VIPSalesPage.contents.VPSegment3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPSegment3.verifyText("Structural Balance Sheet Issues");
		WebControl.takeScreenshot("Sales_Reg_Auto_046");
		
		ReportLog.setTestCase("Sales_Reg_Auto_047");
		VIPSalesPage.contents.CRCompanyPerformance.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRCompanyPerformance.verifyText("COMPANY PERFORMANCE");
		VIPSalesPage.contents.CRProposeValCreatOpp.verifyDisplayed(true, 3);
		//VIPSalesPage.contents.CRProposeValCreatOpp.verifyText("PROPOSED VALUE CREATION OPPORTUNITIES");
		VIPSalesPage.contents.CRKPIImprovement.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRKPIImprovement.verifyText("KPI IMPROVEMENT (OVER NEXT 5 YEARS)");
		VIPSalesPage.contents.RGCompanyPerformance.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGCompanyPerformance.verifyText("COMPANY PERFORMANCE");
		VIPSalesPage.contents.RGProposeValCreatOpp.verifyDisplayed(true, 3);
		//VIPSalesPage.contents.RGProposeValCreatOpp.verifyText("PROPOSED VALUE CREATION OPPORTUNITIES");
		VIPSalesPage.contents.RGKPIImprovement.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGKPIImprovement.verifyText("KPI IMPROVEMENT (OVER NEXT 5 YEARS)");
		VIPSalesPage.contents.SBSICompanyPerformance.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSICompanyPerformance.verifyText("COMPANY PERFORMANCE");
		VIPSalesPage.contents.SBSIProposeValCreatOpp.verifyDisplayed(true, 3);
		//VIPSalesPage.contents.SBSIProposeValCreatOpp.verifyText("PROPOSED VALUE CREATION OPPORTUNITIES");
		VIPSalesPage.contents.SBSIKPIImprovement.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIKPIImprovement.verifyText("KPI IMPROVEMENT (OVER NEXT 5 YEARS)");
		WebControl.takeScreenshot("Sales_Reg_Auto_047");
		
		ReportLog.setTestCase("Sales_Reg_Auto_048");
		VIPSalesPage.contents.CRCPEditIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRCPTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRCPTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.CRCPTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_048");
		VIPSalesPage.contents.CRCPTooltipIcon.click();
		
		ReportLog.setTestCase("Sales_Reg_Auto_049");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.CAGR5YrKPI.hover();
		
		String TimeFrame1 = VIPFinancialsPage.contents.ScoreCardDate.getText();
		String TimeFrame = TimeFrame1.replace("]", "").replace("[", "");
		
		String EBITMarginKPIT = VIPFinancialsPage.contents.EBITMarginKPI.getText();
		String EBITMarginKPIT1 = EBITMarginKPIT.replace("%", "");
		double EBITMarginKPIT2 = Double.parseDouble(EBITMarginKPIT1);
		String EBITMarginKPIP = VIPFinancialsPage.contents.EBITMarginKPIP.getText();
		String EBITMarginKPIP1 = EBITMarginKPIP.replace("%", "");
		double EBITMarginKPIP2 = Double.parseDouble(EBITMarginKPIP1);
		
		String ROICKPIT = VIPFinancialsPage.contents.ROICKPI.getText();
		String ROICKPIT1 = ROICKPIT.replace("%", "");
		double ROICKPIT2 = Double.parseDouble(ROICKPIT1);
		String ROICKPIP = VIPFinancialsPage.contents.ROICKPIP.getText();
		String ROICKPIP1 = ROICKPIP.replace("%", "");
		double ROICKPIP2 = Double.parseDouble(ROICKPIP1);
		
		String COGSKPIT = VIPFinancialsPage.contents.COGSKPI.getText();
		String COGSKPIT1 = COGSKPIT.replace("%", "");
		double COGSKPIT2 = Double.parseDouble(COGSKPIT1);
		String COGSKPIP = VIPFinancialsPage.contents.COGSKPIP.getText();
		String COGSKPIP1 = COGSKPIP.replace("%", "");
		double COGSKPIP2 = Double.parseDouble(COGSKPIP1);
		
		String SGAKPIT = VIPFinancialsPage.contents.SGAKPI.getText();
		String SGAKPIT1 = SGAKPIT.replace("%", "");
		double SGAKPIT2 = Double.parseDouble(SGAKPIT1);
		String SGAKPIP = VIPFinancialsPage.contents.SGAKPIP.getText();
		String SGAKPIP1 = SGAKPIP.replace("%", "");
		double SGAKPIP2 = Double.parseDouble(SGAKPIP1);
		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
//		
//		VIPSalesPage.contents.FinancialKPIs.hover();
//		VIPSalesPage.contents.FinancialKPIs.click();
//		VIPSalesPage.contents.TimeFrame.waitForExist(true, 10);
//		String TimeFrame = VIPSalesPage.contents.TimeFrame.getText();
//		String ICKPI1 = VIPSalesPage.contents.ICKPI.getText();
//		double ICKPI = Double.parseDouble(ICKPI1);
//		String ICKPIP1 = VIPSalesPage.contents.ICKPIP.getText();
//		double ICKPIP = Double.parseDouble(ICKPIP1);
		
		VIPSalesPage.contents.ValueProposition.hover();
		VIPSalesPage.contents.ValueProposition.click();
		VIPSalesPage.contents.CRShowMore.click();
		
		VIPSalesPage.contents.VPEBITMarginKPI.verifyText("EBIT margin\n" + EBITMarginKPIT);
		if (EBITMarginKPIT2 >= EBITMarginKPIP2) {
		VIPSalesPage.contents.EBITMarginCircleGreen.verifyDisplayed(true, 3);}
		else {VIPSalesPage.contents.EBITMarginCircleRed.verifyDisplayed(true, 3);}
		
		VIPSalesPage.contents.VPROICKPI.verifyText("ROIC (Pre-Tax)\n" + ROICKPIT);
		if (ROICKPIT2 >= ROICKPIP2) {
		VIPSalesPage.contents.ROICCircleGreen.verifyDisplayed(true, 3);}
		else {VIPSalesPage.contents.ROICCircleRed.verifyDisplayed(true, 3);}
		
		VIPSalesPage.contents.VPCOGSKPI.verifyText("COGS / Revenue\n" + COGSKPIT);
		if (COGSKPIP2 >= COGSKPIT2) {
		VIPSalesPage.contents.COGSCircleGreen.verifyDisplayed(true, 3);}
		else {VIPSalesPage.contents.COGSCircleRed.verifyDisplayed(true, 3);}
		
		VIPSalesPage.contents.VPSGAKPI.verifyText("SG&A / Revenue\n" + SGAKPIT);
		if (SGAKPIP2 >= SGAKPIT2) {
		VIPSalesPage.contents.SGACircleGreen.verifyDisplayed(true, 3);}
		else {VIPSalesPage.contents.SGACircleRed.verifyDisplayed(true, 3);}
		
//		VIPSalesPage.contents.VPICKPI.verifyText("Interest Coverage\n" + ICKPI);
//		if (ICKPI >= ICKPIP) {
//		VIPSalesPage.contents.ICCircleGreen.verifyDisplayed(true, 3);}
//		else {VIPSalesPage.contents.ICCircleRed.verifyDisplayed(true, 3);}
		WebControl.takeScreenshot("Sales_Reg_Auto_049");
		
		ReportLog.setTestCase("Sales_Reg_Auto_051");
		VIPSalesPage.contents.VPEBITMarginKPI.verifyText("EBIT margin\n" + EBITMarginKPIT);
		VIPSalesPage.contents.VPROICKPI.verifyText("ROIC (Pre-Tax)\n" + ROICKPIT);
		VIPSalesPage.contents.VPCOGSKPI.verifyText("COGS / Revenue\n" + COGSKPIT);
		VIPSalesPage.contents.VPSGAKPI.verifyText("SG&A / Revenue\n" + SGAKPIT);
//		VIPSalesPage.contents.VPICKPI.verifyText("Interest Coverage\n" + ICKPI);
		WebControl.takeScreenshot("Sales_Reg_Auto_051");
		
		ReportLog.setTestCase("Sales_Reg_Auto_050");
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPEBITMarginKPIHover.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPITooltipText.verifyText("[" + TimeFrame + "]" + "\n" + "Target Company\n" + EBITMarginKPIT + "\n" + "Peer Median\n" + EBITMarginKPIP);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPROICKPIHover.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPITooltipText.verifyText("[" + TimeFrame + "]" + "\n" + "Target Company\n" + ROICKPIT + "\n" + "Peer Median\n" + ROICKPIP);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPCOGSKPIHover.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPITooltipText.verifyText("[" + TimeFrame + "]" + "\n" + "Target Company\n" + COGSKPIT + "\n" + "Peer Median\n" + COGSKPIP);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPSGAKPIHover.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPITooltipText.verifyText("[" + TimeFrame + "]" + "\n" + "Target Company\n" + SGAKPIT + "\n" + "Peer Median\n" + SGAKPIP);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPICKPIHover.hover();
		//Thread.sleep(1500);
		//VIPSalesPage.contents.KPITooltipText.verifyText(TimeFrame + "\n" + "Target Company\n" + ICKPI + "\n" + "Peer Median\n" + ICKPIP);
		WebControl.takeScreenshot("Sales_Reg_Auto_050");
		
		ReportLog.setTestCase("Sales_Reg_Auto_052");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CRPVCOTooltipIcon.verifyDisplayed(true, 5);
		VIPSalesPage.contents.CRPVCOTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText("Proposed solutions based on company performance in terms of financial/operational KPIs and client priorities. You can choose to edit FTE cost and number assumptions to custom value.");
		VIPSalesPage.contents.CRPVCOTooltipIcon.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_052");
		
		ReportLog.setTestCase("Sales_Reg_Auto_054");
		VIPSalesPage.contents.CRKPIImprovementColumn1.verifyDisplayed(true, 5);
		VIPSalesPage.contents.CRKPIImprovementColumn2.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RGKPIImprovementColumn1.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RGKPIImprovementColumn2.verifyDisplayed(true, 5);
		VIPSalesPage.contents.SBSIKPIImprovementColumn1.verifyDisplayed(true, 5);
		VIPSalesPage.contents.SBSIKPIImprovementColumn2.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Sales_Reg_Auto_054");
		
		ReportLog.setTestCase("Sales_Reg_Auto_058");
		VIPSalesPage.contents.CRCumulativeImpact.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RGCumulativeImpact.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Sales_Reg_Auto_058");
		
		ReportLog.setTestCase("Sales_Reg_Auto_059");
		VIPSalesPage.contents.CostRedEditIcon.click();
		VIPSalesPage.contents.EditBenchmarksPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RevGrowthEditIcon.click();
		VIPSalesPage.contents.EditBenchmarksPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.EditBenchmarksPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.EditBenchmarksPopUpClose.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_059");
		
		ReportLog.setTestCase("Sales_Reg_Auto_060");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.EBITMarginKPIP.waitForExist(true, 5);
		String EBIT = VIPFinancialsPage.contents.EBITMarginKPIP.getText();
		String ROIC = VIPFinancialsPage.contents.ROICKPIP.getText();
		String COGS = VIPFinancialsPage.contents.COGSKPIP.getText();
		String SGA = VIPFinancialsPage.contents.SGAKPIP.getText();	
		String CAGRFIVE = VIPFinancialsPage.contents.CAGR5YrKPIP.getText();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown7.click();
		String RevEmp = VIPFinancialsPage.contents.RevPerEmployee.getText();
		String RevenueEmp = RevEmp.replace("Peer Median: ", "");		
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.PreTaxROICMenu.click();
		VIPSalesPage.contents.ToggleDetailedPreTaxROIC.click();	
		VIPSalesPage.contents.DetailedPeerPreTaxROICSelectIndicator.click();
		VIPSalesPage.contents.DetailedPeerPreTaxROICNetPPE.click();
		String NetPPE1 = VIPFinancialsPage.contents.ThirdPeriodPeerMedian.getText();
		String NetPPE2 = NetPPE1.replace("Peer Median: ", "");
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CRCPEditIcon.hover();
		VIPSalesPage.contents.CRCPEditIcon.click();
		VIPSalesPage.contents.EBITMarginBenchmarkDefault.verifyText(EBIT);
		VIPSalesPage.contents.ROICBenchmarkDefault.verifyText(ROIC);
		VIPSalesPage.contents.COGSBenchmarkDefault.verifyText(COGS);
		VIPSalesPage.contents.SGABenchmarkDefault.verifyText(SGA);
		VIPSalesPage.contents.RevGrowthEditIcon.click();
		VIPSalesPage.contents.FiveYearRevCAGRDefault.verifyText(CAGRFIVE);
		VIPSalesPage.contents.RevPerEmployeeDefault.verifyText(RevenueEmp);
		VIPSalesPage.contents.NetPPEDefault.verifyText(NetPPE2);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_060");
		
//		ReportLog.setTestCase("Sales_Reg_Auto_086");
//		String compare1 = VIPSalesPage.contents.SampleKPITargetValue.getText();
//		String compare3 = compare1.replace(" Days", "");
//		double ccompare1 = Double.parseDouble(compare3);
//		VIPSalesPage.contents.StructuralEditIcon.click();
//		VIPSalesPage.contents.CustomCheckbox1.click();
//		Thread.sleep(2000);
//		//VIPSalesPage.contents.CustomTextbox2.click();
//		VIPSalesPage.contents.CustomTextbox2.verifyEditable();
//		VIPSalesPage.contents.CustomTextbox2.clear();
//		VIPSalesPage.contents.CustomTextbox2.sendKeys("20");
//		Object compare2 = VIPSalesPage.contents.CustomTextbox2.getValue();
//		String compares = compare2.toString();
//		double ccompare2 = Double.parseDouble(compares);
//		if (ccompare1 < ccompare2) {
//			VIPSalesPage.contents.CustomBetterCircle1.verifyDisplayed(true, 3);}
//			else
//				VIPSalesPage.contents.CustomWorstCircle1.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
//		WebControl.takeScreenshot("Sales_Reg_Auto_086");
		
		ReportLog.setTestCase("Sales_Reg_Auto_061");
		VIPSalesPage.contents.RGShowMore.click();
		VIPSalesPage.contents.SBSIShowMore.click();
		//TargetKPIValue1
		String TargetKPIValue1_1 = VIPSalesPage.contents.TargetKPIValue1.getText();
		String TargetKPIValue1_2 = TargetKPIValue1_1.replace(" Days", "");
		double TargetKPIValue1_3 = Double.parseDouble(TargetKPIValue1_2);
		double TargetKPIValue1_4 = TargetKPIValue1_3 - 20;
		double TargetKPIValue1_5 = TargetKPIValue1_3 + 20;
		String TargetKPIValue1_6 = Double.toString(TargetKPIValue1_4);
		String TargetKPIValue1_7 = Double.toString(TargetKPIValue1_5);
		//TargetKPIText1
		String TargetKPIText1_1 = VIPSalesPage.contents.TargetKPIText1.getText(); 
		String[] TargetKPIText1_2 = TargetKPIText1_1.split("\\n");
		String TargetKPIText1 = TargetKPIText1_2[0];
		//TargetKPIValue2
		String TargetKPIValue2_1 = VIPSalesPage.contents.TargetKPIValue2.getText();
		String TargetKPIValue2_2 = TargetKPIValue2_1.replace(" Days", "");
		double TargetKPIValue2_3 = Double.parseDouble(TargetKPIValue2_2);
		double TargetKPIValue2_4 = TargetKPIValue2_3 - 20;
		double TargetKPIValue2_5 = TargetKPIValue2_3 + 20;
		String TargetKPIValue2_6 = Double.toString(TargetKPIValue2_4);
		String TargetKPIValue2_7 = Double.toString(TargetKPIValue2_5);
		//TargetKPIText2
		String TargetKPIText2_1 = VIPSalesPage.contents.TargetKPIText2.getText(); 
		String[] TargetKPIText2_2 = TargetKPIText2_1.split("\\n");
		String TargetKPIText2 = TargetKPIText2_2[0];
		//TargetKPIValue3
		String TargetKPIValue3_1 = VIPSalesPage.contents.TargetKPIValue3.getText();
		String TargetKPIValue3_2 = TargetKPIValue3_1.replace(" Days", "");
		double TargetKPIValue3_3 = Double.parseDouble(TargetKPIValue3_2);
		double TargetKPIValue3_4 = TargetKPIValue3_3 - 20;
		double TargetKPIValue3_5 = TargetKPIValue3_3 + 20;
		String TargetKPIValue3_6 = Double.toString(TargetKPIValue3_4);
		String TargetKPIValue3_7 = Double.toString(TargetKPIValue3_5);
		//TargetKPIText3
		String TargetKPIText3_1 = VIPSalesPage.contents.TargetKPIText3.getText(); 
		String[] TargetKPIText3_2 = TargetKPIText3_1.split("\\n");
		String TargetKPIText3 = TargetKPIText3_2[0];
		//TargetKPIValue4
		String TargetKPIValue4_1 = VIPSalesPage.contents.TargetKPIValue4.getText();
		String TargetKPIValue4_2 = TargetKPIValue4_1.replace(" Days", "");
		double TargetKPIValue4_3 = Double.parseDouble(TargetKPIValue4_2);
		double TargetKPIValue4_4 = TargetKPIValue4_3 - 20;
		double TargetKPIValue4_5 = TargetKPIValue4_3 + 20;
		String TargetKPIValue4_6 = Double.toString(TargetKPIValue4_4);
		String TargetKPIValue4_7 = Double.toString(TargetKPIValue4_5);
		//TargetKPIText4
		String TargetKPIText4_1 = VIPSalesPage.contents.TargetKPIText4.getText(); 
		String[] TargetKPIText4_2 = TargetKPIText4_1.split("\\n");
		String TargetKPIText4 = TargetKPIText4_2[0];
		//TargetKPIValue5
		String TargetKPIValue5_1 = VIPSalesPage.contents.TargetKPIValue5.getText();
		String TargetKPIValue5_2 = TargetKPIValue5_1.replace(" Days", "");
		double TargetKPIValue5_3 = Double.parseDouble(TargetKPIValue5_2);
		double TargetKPIValue5_4 = TargetKPIValue5_3 - 20;
		double TargetKPIValue5_5 = TargetKPIValue5_3 + 20;
		String TargetKPIValue5_6 = Double.toString(TargetKPIValue5_4);
		String TargetKPIValue5_7 = Double.toString(TargetKPIValue5_5);
		//TargetKPIText5
		String TargetKPIText5_1 = VIPSalesPage.contents.TargetKPIText5.getText(); 
		String[] TargetKPIText5_2 = TargetKPIText5_1.split("\\n");
		String TargetKPIText5 = TargetKPIText5_2[0];
		//TargetKPIValue6
		String TargetKPIValue6_1 = VIPSalesPage.contents.TargetKPIValue6.getText();
		String TargetKPIValue6_2 = TargetKPIValue6_1.replace(" Days", "");
		double TargetKPIValue6_3 = Double.parseDouble(TargetKPIValue6_2);
		double TargetKPIValue6_4 = TargetKPIValue6_3 - 20;
		double TargetKPIValue6_5 = TargetKPIValue6_3 + 20;
		String TargetKPIValue6_6 = Double.toString(TargetKPIValue6_4);
		String TargetKPIValue6_7 = Double.toString(TargetKPIValue6_5);
		//TargetKPIText6
		String TargetKPIText6_1 = VIPSalesPage.contents.TargetKPIText6.getText(); 
		String[] TargetKPIText6_2 = TargetKPIText6_1.split("\\n");
		String TargetKPIText6 = TargetKPIText6_2[0];
		//TargetKPIValue1
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.Checkbox1.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox1.verifyEditable();
		VIPSalesPage.contents.Textbox1.clear();
		VIPSalesPage.contents.Textbox1.sendKeys(TargetKPIValue1_6);
		if (TargetKPIText1.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomBetterCircle1.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomWorstCircle1.verifyDisplayed(true, 3);}
		VIPSalesPage.contents.Textbox1.clear();
		VIPSalesPage.contents.Textbox1.sendKeys(TargetKPIValue1_7);
		if (TargetKPIText1.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomWorstCircle1.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomBetterCircle1.verifyDisplayed(true, 3);}
		//TargetKPIValue2
		VIPSalesPage.contents.Checkbox2.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox2.verifyEditable();
		VIPSalesPage.contents.Textbox2.clear();
		VIPSalesPage.contents.Textbox2.sendKeys(TargetKPIValue2_6);
		if (TargetKPIText2.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomBetterCircle2.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomWorstCircle2.verifyDisplayed(true, 3);}
		VIPSalesPage.contents.Textbox2.clear();
		VIPSalesPage.contents.Textbox2.sendKeys(TargetKPIValue2_7);
		if (TargetKPIText2.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomWorstCircle2.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomBetterCircle2.verifyDisplayed(true, 3);}
		//TargetKPIValue3
		VIPSalesPage.contents.Checkbox3.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox3.verifyEditable();
		VIPSalesPage.contents.Textbox3.clear();
		VIPSalesPage.contents.Textbox3.sendKeys(TargetKPIValue3_6);
		if (TargetKPIText3.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomBetterCircle3.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomWorstCircle3.verifyDisplayed(true, 3);}
		VIPSalesPage.contents.Textbox3.clear();
		VIPSalesPage.contents.Textbox3.sendKeys(TargetKPIValue3_7);
		if (TargetKPIText3.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomWorstCircle3.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomBetterCircle3.verifyDisplayed(true, 3);}
		//TargetKPIValue4
		VIPSalesPage.contents.Checkbox4.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox4.verifyEditable();
		VIPSalesPage.contents.Textbox4.clear();
		VIPSalesPage.contents.Textbox4.sendKeys(TargetKPIValue4_6);
		if (TargetKPIText4.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomBetterCircle4.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomWorstCircle4.verifyDisplayed(true, 3);}
		VIPSalesPage.contents.Textbox4.clear();
		VIPSalesPage.contents.Textbox4.sendKeys(TargetKPIValue4_7);
		if (TargetKPIText4.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomWorstCircle4.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomBetterCircle4.verifyDisplayed(true, 3);}
		//TargetKPIValue5
		VIPSalesPage.contents.Checkbox5.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox5.verifyEditable();
		VIPSalesPage.contents.Textbox5.clear();
		VIPSalesPage.contents.Textbox5.sendKeys(TargetKPIValue5_6);
		if (TargetKPIText5.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomBetterCircle5.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomWorstCircle5.verifyDisplayed(true, 3);}
		VIPSalesPage.contents.Textbox5.clear();
		VIPSalesPage.contents.Textbox5.sendKeys(TargetKPIValue5_7);
		if (TargetKPIText5.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomWorstCircle5.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomBetterCircle5.verifyDisplayed(true, 3);}
		//TargetKPIValue6
		VIPSalesPage.contents.Checkbox6.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox6.verifyEditable();
		VIPSalesPage.contents.Textbox6.clear();
		VIPSalesPage.contents.Textbox6.sendKeys(TargetKPIValue6_6);
		if (TargetKPIText6.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomBetterCircle6.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomWorstCircle6.verifyDisplayed(true, 3);}
		VIPSalesPage.contents.Textbox6.clear();
		VIPSalesPage.contents.Textbox6.sendKeys(TargetKPIValue6_7);
		if (TargetKPIText6.equals("Days Payables Outstanding")) {
			VIPSalesPage.contents.CustomWorstCircle6.verifyDisplayed(true, 3);}
		else {
			VIPSalesPage.contents.CustomBetterCircle6.verifyDisplayed(true, 3);}
		WebControl.takeScreenshot("Sales_Reg_Auto_061");
		
		ReportLog.setTestCase("Sales_Reg_Auto_062_&_063");
		VIPSalesPage.contents.GoUpArrow.click();
		VIPSalesPage.contents.EditBenchmarksCloseButton.hover();
		VIPSalesPage.contents.EditBenchmarksCloseButton.click();
		VIPSalesPage.contents.TargetKPIText1.verifyText(TargetKPIText1_1);
		VIPSalesPage.contents.TargetKPIText2.verifyText(TargetKPIText2_1);
		VIPSalesPage.contents.TargetKPIText3.verifyText(TargetKPIText3_1);
		VIPSalesPage.contents.TargetKPIText4.verifyText(TargetKPIText4_1);
		VIPSalesPage.contents.TargetKPIText5.verifyText(TargetKPIText5_1);
		VIPSalesPage.contents.TargetKPIText6.verifyText(TargetKPIText6_1);
		WebControl.takeScreenshot("Sales_Reg_Auto_062_1");
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.Checkbox1.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox1.verifyEditable();
		VIPSalesPage.contents.Textbox1.clear();
		VIPSalesPage.contents.Textbox1.sendKeys(TargetKPIValue1_7);
		VIPSalesPage.contents.Checkbox2.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox2.verifyEditable();
		VIPSalesPage.contents.Textbox2.clear();
		VIPSalesPage.contents.Textbox2.sendKeys(TargetKPIValue2_7);
		VIPSalesPage.contents.Checkbox3.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox3.verifyEditable();
		VIPSalesPage.contents.Textbox3.clear();
		VIPSalesPage.contents.Textbox3.sendKeys(TargetKPIValue3_7);
		VIPSalesPage.contents.Checkbox4.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox4.verifyEditable();
		VIPSalesPage.contents.Textbox4.clear();
		VIPSalesPage.contents.Textbox4.sendKeys(TargetKPIValue4_7);
		VIPSalesPage.contents.Checkbox5.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox5.verifyEditable();
		VIPSalesPage.contents.Textbox5.clear();
		VIPSalesPage.contents.Textbox5.sendKeys(TargetKPIValue5_7);
		VIPSalesPage.contents.Checkbox6.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.Textbox6.verifyEditable();
		VIPSalesPage.contents.Textbox6.clear();
		VIPSalesPage.contents.Textbox6.sendKeys(TargetKPIValue6_7);
		VIPSalesPage.contents.EditBenchmarksApplyButton.click();
		String DPOKPI1 = VIPSalesPage.contents.TargetKPIText1.getText();
		String[] DPOKPI2 = DPOKPI1.split("\\n");
		String DPOKPI = DPOKPI2[1];
		VIPSalesPage.contents.TargetKPIText1.verifyText("Days Payables Outstanding\n" + DPOKPI);
		WebControl.takeScreenshot("Sales_Reg_Auto_062_2");
		VIPSalesPage.contents.WorstCircle1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle4.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle5.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle6.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_063");

		ReportLog.setTestCase("Sales_Reg_Auto_064");
		VIPSalesPage.contents.CostRedKPIImprovementEditBtn.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RevGrowthKPIImprovementEditBtn.verifyDisplayed(true, 3);
		VIPSalesPage.contents.StructuralKPIImprovementEditBtn.verifyDisplayed(true, 3);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedKPIImprovementEditBtn.hover();
		VIPSalesPage.contents.CostRedKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RevGrowthKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.StructuralKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_064");
		
		ReportLog.setTestCase("Sales_Reg_Auto_066_&_067");
		String Textbox1 = VIPSalesPage.contents.TextboxDisabled1.getText();
		String Textbox2 = VIPSalesPage.contents.TextboxDisabled2.getText();
		String Textbox3 = VIPSalesPage.contents.TextboxDisabled3.getText();
		String Textbox4 = VIPSalesPage.contents.TextboxDisabled4.getText();
		VIPSalesPage.contents.Checkbox1.click();
		VIPSalesPage.contents.TextboxEnabled1.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TextboxEnabled1.clear();
		VIPSalesPage.contents.TextboxEnabled1.sendKeys("1000");
		VIPSalesPage.contents.Checkbox2.click();
		VIPSalesPage.contents.TextboxEnabled2.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TextboxEnabled2.clear();
		VIPSalesPage.contents.TextboxEnabled2.sendKeys("1000");
		VIPSalesPage.contents.Checkbox3.click();
		VIPSalesPage.contents.TextboxEnabled3.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TextboxEnabled3.clear();
		VIPSalesPage.contents.TextboxEnabled3.sendKeys("1000");
		VIPSalesPage.contents.Checkbox4.click();
		VIPSalesPage.contents.TextboxEnabled4.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TextboxEnabled4.clear();
		VIPSalesPage.contents.TextboxEnabled4.sendKeys("1000");
		WebControl.takeScreenshot("Sales_Reg_Auto_066");
		VIPSalesPage.contents.EditFTEAssumptionPopUpClose.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedKPIImprovementEditBtn.hover();
		VIPSalesPage.contents.CostRedKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxDisabled1.verifyText(Textbox1);
		VIPSalesPage.contents.TextboxDisabled2.verifyText(Textbox2);
		VIPSalesPage.contents.TextboxDisabled3.verifyText(Textbox3);
		VIPSalesPage.contents.TextboxDisabled4.verifyText(Textbox4);
		WebControl.takeScreenshot("Sales_Reg_Auto_067_1_1");
		VIPSalesPage.contents.RevGrowthKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxDisabled1.verifyText(Textbox1);
		VIPSalesPage.contents.TextboxDisabled2.verifyText(Textbox2);
		VIPSalesPage.contents.TextboxDisabled3.verifyText(Textbox3);
		VIPSalesPage.contents.TextboxDisabled4.verifyText(Textbox4);
		WebControl.takeScreenshot("Sales_Reg_Auto_067_2_1");
		VIPSalesPage.contents.StructuralKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxDisabled1.verifyText(Textbox1);
		VIPSalesPage.contents.TextboxDisabled2.verifyText(Textbox2);
		VIPSalesPage.contents.TextboxDisabled3.verifyText(Textbox3);
		VIPSalesPage.contents.TextboxDisabled4.verifyText(Textbox4);
		WebControl.takeScreenshot("Sales_Reg_Auto_067_3_1");
		VIPSalesPage.contents.Checkbox1.click();
		VIPSalesPage.contents.TextboxEnabled1.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TextboxEnabled1.clear();
		VIPSalesPage.contents.TextboxEnabled1.sendKeys("1000");
		VIPSalesPage.contents.Checkbox2.click();
		VIPSalesPage.contents.TextboxEnabled2.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TextboxEnabled2.clear();
		VIPSalesPage.contents.TextboxEnabled2.sendKeys("1000");
		VIPSalesPage.contents.Checkbox3.click();
		VIPSalesPage.contents.TextboxEnabled3.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TextboxEnabled3.clear();
		VIPSalesPage.contents.TextboxEnabled3.sendKeys("1000");
		VIPSalesPage.contents.Checkbox4.click();
		VIPSalesPage.contents.TextboxEnabled4.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TextboxEnabled4.clear();
		VIPSalesPage.contents.TextboxEnabled4.sendKeys("1000");
		VIPSalesPage.contents.EditFTEAssumptionPopUpApply.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedKPIImprovementEditBtn.hover();
		VIPSalesPage.contents.CostRedKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxEnabled1.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled2.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled3.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled4.verifyDisplayed();
		WebControl.takeScreenshot("Sales_Reg_Auto_067_1_2");
		VIPSalesPage.contents.RevGrowthKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxEnabled1.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled2.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled3.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled4.verifyDisplayed();
		WebControl.takeScreenshot("Sales_Reg_Auto_067_2_2");
		VIPSalesPage.contents.StructuralKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxEnabled1.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled2.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled3.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled4.verifyDisplayed();
		WebControl.takeScreenshot("Sales_Reg_Auto_067_2_3");
		
		ReportLog.setTestCase("Sales_Reg_Auto_068");
		VIPSalesPage.contents.Checkbox1.click();
		VIPSalesPage.contents.Checkbox2.click();
		VIPSalesPage.contents.Checkbox3.click();
		VIPSalesPage.contents.Checkbox4.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUpApply.click();
		Thread.sleep(7000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.ITAndBackOfficeiIcon.hover();
		VIPSalesPage.contents.ITAndBackOfficeiIcon.click();
		VIPSalesPage.contents.ITAndBackOfficeiIconMsg.verifyText("IT & Back Office: This constitutes Accenture's cost take out services in all or any of the service groups (Application Management, Application Development, Application Testing, Infrastructure Management) as well as Back office services (Finance & Accounting, HR, Procure to Pay and Customer services).\n" + "Cloud Operations: Here Accenture provides a complete set of Cloud Services which help the client to manage their Service Transformation with Cloud technologies. It helps the client unlock the potential of Cloud along with maximising the value of their existing estate.");
		VIPSalesPage.contents.ITAndBackOfficeiIcon.click();
		VIPSalesPage.contents.IntelligentSourcingiIcon.click();
		VIPSalesPage.contents.IntelligentSourcingiIconMsg.verifyText("Intelligent Sourcing: Here Accenture delivers cost savings in the areas of Spend Analysis & Diagnostic, Contract management, Strategic Sourcing, Workflow and Governance, Demand compliance, Audit and Recovery.");
		VIPSalesPage.contents.IntelligentSourcingiIcon.click();
		VIPSalesPage.contents.IntelligentSupplyChainiIcon.click();
		VIPSalesPage.contents.IntelligentSupplyChainiIconMsg.verifyText("Intelligent Supply Chain: Here Accenture delivers cost savings to clients in different areas of supply chain process model (design, plan, source, make/ build/ produce, fulfill/ deliver and service/ maintain) using its tools, processes and methodology.");
		VIPSalesPage.contents.IntelligentSupplyChainiIcon.click();
		VIPSalesPage.contents.ZeroBasedApproachiIcon.click();
		VIPSalesPage.contents.ZeroBasedApproachiIconMsg.verifyText("Zero Based Approach to cost and activities: This approach aims at identifying synergies between cost efficiency and sustainability with help of Accenture's holistic offerings. It delivers various benefits to the client like savings that are better received and last longer, creating a purpose and enhancing trust, accelerating delivery of sustainability targets and driving internal change & buy-in to capture savings");
		VIPSalesPage.contents.ZeroBasedApproachiIcon.click();
		VIPSalesPage.contents.DigitalOutreachiIcon.click();
		VIPSalesPage.contents.DigitalOutreachiIconMsg.verifyText("Digital outreach to Customers: Here Accenture helps the client boost its customer acquisition, conversion and retention with end-to-end marketing strategies and cross-functional organizations designed to deliver differentiated and personalized experiences.");
		VIPSalesPage.contents.DigitalOutreachiIcon.click();
		VIPSalesPage.contents.CommercialExcellenceiIcon.click();
		VIPSalesPage.contents.CommercialExcellenceiIconMsg.verifyText("Commercial Excellence: Here Accenture helps in uplifting EBIT by 1-3%, using pricing excellence, sales optimisation and commercial & marketing enablement.");
		VIPSalesPage.contents.CommercialExcellenceiIcon.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_068");
		
		ReportLog.setTestCase("Sales_Reg_Auto_069");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CRShowMore.click();
		VIPSalesPage.contents.CRShowMore.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPEBITMargin.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPROICPreTax.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPSGARevenue.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPInterestCoverage.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPCOGSRevenue.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_069");
		
		ReportLog.setTestCase("Sales_Reg_Auto_070");
		VIPSalesPage.contents.RGShowMore.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VP5yearRevenueCAGR.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPRevenueperEmployee.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPNetPPERevenue.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPBroadbandConnectionsMarketShare.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPPayTVConnectionsMarketShare.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPMobileConnectionsMarketShare.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPChurnRate.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPARPU.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_070");
		
		ReportLog.setTestCase("Sales_Reg_Auto_071");
		VIPSalesPage.contents.SBSIShowMore.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPDaysSalesOutstanding.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPNetDebtFCF.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPNetDebtEBITDA.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPTotalDebtEquity.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_071");
		
		ReportLog.setTestCase("Sales_Reg_Auto_072");
		VIPSalesPage.contents.CRShowLess.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGShowLess.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIShowLess.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_072");
		
		ReportLog.setTestCase("Sales_Reg_Auto_075");
		VIPSalesPage.contents.SourceNote.waitForExist(true, 15);
		VIPSalesPage.contents.SourceNote.verifyText("Source: Gartner; Analysys Mason; S&P Capital IQ and Accenture Client Value Services.\n" + 
		"Disclaimer: All Gartner information is copyright protected and our license is for Accenture business use only.\n" + 
		"If you use Gartner material, you are responsible for reading and complying with the usage terms including the terms in Gartner's Copyright and Quote Policy\n" + 
		"Usage terms at-a-glance:\n" + 
		"To post reports on internal sites (e.g., on the KX or SharePoint sites), you must first purchase the appropriate license. For pricing information, contact reprints@gartner.com\n" + 
		"For additional details regarding Terms of Use, please refer to Gartner's Copyright and Quote Policy, and Usage Policy: (https://www.gartner.com/en/about/policies/copyright).");
		WebControl.takeScreenshot("Sales_Reg_Auto_075");
		
		ReportLog.setTestCase("Sales_Reg_Auto_073");		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Samsung");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPSalesPage.contents.FootNote.verifyDisplayed(true, 60);	
		String FootNote = VIPSalesPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Sales_Reg_Auto_073");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_074");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();}
		else { WebControl.openNew("https://valueinsightsplatform-stage.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();}
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Samsung");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPSalesPage.contents.FootNote.waitForExist(true, 60);
		if (VIPSalesPage.contents.FootNote.isDisplayed()) {
		VIPSalesPage.contents.FootNote.verifyText(FootNote);}
		else { VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Samsung");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPSalesPage.contents.FootNote.waitForExist(true, 60);
		VIPSalesPage.contents.FootNote.verifyText(FootNote);}
		WebControl.takeScreenshot("Sales_Reg_Auto_074");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);
		
	}
	
}


