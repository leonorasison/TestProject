package scenarios.SALES;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import auto.framework.web.WebControl1;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPTranscriptPage;

public class SalesLeadership_All extends TestBase{
	
	//@Test(priority=1)
	public void Sales_ValueProposition () throws Exception {
		ReportLog.setTestName("Sales Leadership - Value Proposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_046");	
		VIP_Common.LogInPage(testDataHandler);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(3000);
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
		if (VIPSalesPage.contents.RGShowMore.isDisplayed()) {
		VIPSalesPage.contents.RGShowMore.click();}
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
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.telcoCompany);
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
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CRShowMore.waitForExist(true, 25);
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
		VIPSalesPage.contents.RGShowMore.click();
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
		VIPSalesPage.contents.SBSIShowMore.click();
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
		VIPSalesPage.contents.VPSegment1.waitForExist(true, 60);
		VIPSalesPage.contents.FootNote.verifyDisplayed(true);
		String FootNote = "";
		if (VIPSalesPage.contents.FootNote.isDisplayed()) {
		FootNote = VIPSalesPage.contents.FootNote.getText();}
		WebControl.takeScreenshot("Sales_Reg_Auto_073");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_074");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(1500);
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
		VIPSalesPage.contents.VPSegment1.waitForExist(true, 60);
		if (FootNote != "") {
		VIPSalesPage.contents.FootNote.verifyText(FootNote);}
		else {VIPSalesPage.contents.FootNote.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_074");
		WebControl.close();	
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
	//@Test(priority=2)
	public void Sales_IndustryXOKPIs () throws Exception {
		ReportLog.setTestName("Sales Leadership - Industry X.O KPIs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_152");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.telcoCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_152");
		
		ReportLog.setTestCase("Sales_Reg_Auto_153");
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModal.verifyDisplayed(true, 5);
		VIPSalesPage.contents.OppNavModalHeader1.verifyText("What is Opportunity Navigator?");
		VIPSalesPage.contents.OppNavModalBody1.verifyText("An automated business case tool which identifies client priorities from Earnings Call Transcripts and links client performance (financial/operational KPIs) to Value Creation Opportunities (VCOs).");
		VIPSalesPage.contents.OppNavModalHeader2.verifyText("Who can use it?");
		VIPSalesPage.contents.OppNavModalBody2.verifyText("This tool can be used for creating the value proposition for large client opportunities. Primary audience for this dashboard includes: Sales Leads/ Sales Capture Leads, Market Makers, Transformation Directors, DCALs, CALs, Bid Managers. Please reach out to the CVS Team to get Value Architect support for further refinement of the business case before sharing with the client.");
		VIPSalesPage.contents.UserGuideButton.hover();
		VIPSalesPage.contents.UserGuideButton.verifyText("DOWNLOAD USER GUIDE");
		VIPSalesPage.contents.DoNotShowCheckBox.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DoNotShowLabel.verifyText("Do not show this message again");
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		else {VIPSalesPage.contents.OppNavModal.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_153");
		
		ReportLog.setTestCase("Sales_Reg_Auto_154");
		VIPSalesPage.contents.VPSegment1.verifyDisplayed(true, 30);
		VIPSalesPage.contents.VPSegment1.verifyText("Cost Reduction");
		VIPSalesPage.contents.VPSegment2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPSegment2.verifyText("Revenue Growth");
		VIPSalesPage.contents.VPSegment3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPSegment3.verifyText("Structural Balance Sheet Issues");
		WebControl.takeScreenshot("Sales_Reg_Auto_154");
		
		ReportLog.setTestCase("Sales_Reg_Auto_155");
		VIPSalesPage.contents.CRCompanyPerformance.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRCompanyPerformance.verifyText("COMPANY PERFORMANCE");
		VIPSalesPage.contents.CRProposeValCreatOpp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRKPIImprovement.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRKPIImprovement.verifyText("KPI IMPROVEMENT (OVER NEXT 5 YEARS)");
		VIPSalesPage.contents.RGCompanyPerformance.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGCompanyPerformance.verifyText("COMPANY PERFORMANCE");
		VIPSalesPage.contents.RGProposeValCreatOpp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGKPIImprovement.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGKPIImprovement.verifyText("KPI IMPROVEMENT (OVER NEXT 5 YEARS)");
		VIPSalesPage.contents.SBSICompanyPerformance.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSICompanyPerformance.verifyText("COMPANY PERFORMANCE");
		VIPSalesPage.contents.SBSIProposeValCreatOpp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIKPIImprovement.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIKPIImprovement.verifyText("KPI IMPROVEMENT (OVER NEXT 5 YEARS)");
		WebControl.takeScreenshot("Sales_Reg_Auto_155");
		
		ReportLog.setTestCase("Sales_Reg_Auto_156");
		VIPSalesPage.contents.CRCPEditIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRCPTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRCPTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.CRCPTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_156");
		VIPSalesPage.contents.CRCPTooltipIcon.click();
		
		ReportLog.setTestCase("Sales_Reg_Auto_157");
		VIPSalesPage.contents.CRCPEditIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RevGrowthEditIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.StructuralEditIcon.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_157");
		
		ReportLog.setTestCase("Sales_Reg_Auto_158");
		//Cost Reduction
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CRCPEditIcon.waitForExist(true, 3);
		VIPSalesPage.contents.CRCPEditIcon.click();
		VIPSalesPage.contents.EditBenchmarksPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.EditBenchmarksPopUpHeader.verifyText("Cost Reduction - Edit Benchmarks\n" + "✕");
		VIPSalesPage.contents.EditBenchmarksPopUpClose.click();
		//Revenue Growth
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RevGrowthEditIcon.waitForExist(true, 3);
		VIPSalesPage.contents.RevGrowthEditIcon.click();
		VIPSalesPage.contents.EditBenchmarksPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.EditBenchmarksPopUpHeader.verifyText("Revenue Growth - Edit Benchmarks\n" + "✕");
		VIPSalesPage.contents.EditBenchmarksPopUpClose.click();
		//Structural Balance
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.StructuralEditIcon.waitForExist(true, 3);
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.EditBenchmarksPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.EditBenchmarksPopUpHeader.verifyText("Structural Balance Sheet Issues - Edit Benchmarks\n" + "✕");
		VIPSalesPage.contents.EditBenchmarksPopUpClose.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_158");
		
		ReportLog.setTestCase("Sales_Reg_Auto_159");
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
		VIPSalesPage.contents.CRShowMore.click();
		VIPSalesPage.contents.VPICKPIHover.hover();
		String IC = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText();
		VIPSalesPage.contents.SBSIShowMore.click();
		VIPLandingPage.contents.HelpIcon.hover(); //tempo
		VIPSalesPage.contents.VPDIOKPIHover.hover();
		VIPSalesPage.contents.VPKPITooltipPeerMedian.verifyDisplayed(true); //tempo
		String DIO = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText();
		VIPLandingPage.contents.HelpIcon.hover(); //tempo
		VIPSalesPage.contents.VPDPOKPIHover.hover();
		VIPSalesPage.contents.VPKPITooltipPeerMedian.verifyDisplayed(true); //tempo
		String DPO = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText();
		VIPLandingPage.contents.HelpIcon.hover(); //tempo
		VIPSalesPage.contents.VPDSOKPIHover.hover();
		VIPSalesPage.contents.VPKPITooltipPeerMedian.verifyDisplayed(true); //tempo
		String DSO = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText();
		VIPLandingPage.contents.HelpIcon.hover(); //tempo
		VIPSalesPage.contents.VPNDFCFKPIHover.hover();
		VIPSalesPage.contents.VPKPITooltipPeerMedian.verifyDisplayed(true); //tempo
		String NDFCF = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText();
		VIPLandingPage.contents.HelpIcon.hover(); //tempo
		VIPSalesPage.contents.VPNDEBITDAKPIHover.hover();
		VIPSalesPage.contents.VPKPITooltipPeerMedian.verifyDisplayed(true); //tempo
		String NDEBITDA = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText();
		VIPLandingPage.contents.HelpIcon.hover(); //tempo
		VIPSalesPage.contents.VPTDEKPIHover.hover();
		VIPSalesPage.contents.VPKPITooltipPeerMedian.verifyDisplayed(true); //tempo
		String TDE = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CRCPEditIcon.hover();
		VIPSalesPage.contents.CRCPEditIcon.click();
		Thread.sleep(3000);
		VIPSalesPage.contents.EBITMarginBenchmarkDefault.verifyText(EBIT);
		VIPSalesPage.contents.ROICBenchmarkDefault.verifyText(ROIC);
		VIPSalesPage.contents.COGSBenchmarkDefault.verifyText(COGS);
		VIPSalesPage.contents.SGABenchmarkDefault.verifyText(SGA);
		VIPSalesPage.contents.ICBenchmarkDefault.verifyText(IC);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.RevGrowthEditIcon.click();
		Thread.sleep(3000);
		VIPSalesPage.contents.FiveYearRevCAGRDefault.verifyText(CAGRFIVE);
		VIPSalesPage.contents.RevPerEmployeeDefault.verifyText(RevenueEmp);
		VIPSalesPage.contents.NetPPEDefault.verifyText(NetPPE2);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.DIODefault.verifyText(DIO.replace(" Days", ""));
		VIPSalesPage.contents.DSODefault.verifyText(DSO.replace(" Days", ""));
		VIPSalesPage.contents.DPODefault.verifyText(DPO.replace(" Days", ""));
		VIPSalesPage.contents.NDEBITDADefault.verifyText(NDEBITDA);
		VIPSalesPage.contents.NDFCFDefault.verifyText(NDFCF);
		VIPSalesPage.contents.TDEDefault.verifyText(TDE);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_159");
		
		ReportLog.setTestCase("Sales_Reg_Auto_160");
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
		WebControl.takeScreenshot("Sales_Reg_Auto_160");
		
		ReportLog.setTestCase("Sales_Reg_Auto_161_&_165");
		VIPSalesPage.contents.GoUpArrow.click();
		VIPSalesPage.contents.EditBenchmarksCloseButton.hover();
		VIPSalesPage.contents.EditBenchmarksCloseButton.click();
		VIPSalesPage.contents.TargetKPIText1.verifyText(TargetKPIText1_1);
		VIPSalesPage.contents.TargetKPIText2.verifyText(TargetKPIText2_1);
		VIPSalesPage.contents.TargetKPIText3.verifyText(TargetKPIText3_1);
		VIPSalesPage.contents.TargetKPIText4.verifyText(TargetKPIText4_1);
		VIPSalesPage.contents.TargetKPIText5.verifyText(TargetKPIText5_1);
		VIPSalesPage.contents.TargetKPIText6.verifyText(TargetKPIText6_1);
		WebControl.takeScreenshot("Sales_Reg_Auto_161_1");
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
		WebControl.takeScreenshot("Sales_Reg_Auto_161_2");
		VIPSalesPage.contents.WorstCircle1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle4.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle5.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BetterCircle6.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_165");
		
		ReportLog.setTestCase("Sales_Reg_Auto_166");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CRShowLess.click();
		Thread.sleep(1500);
		VIPSalesPage.contents.CRShowMore.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRShowMore.click();
		Thread.sleep(1500);
		VIPSalesPage.contents.VPEBITMargin.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPROICPreTax.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPSGARevenue.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPInterestCoverage.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPCOGSRevenue.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_166");
		
		ReportLog.setTestCase("Sales_Reg_Auto_162_Existing KPI");
		//EBIT
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPEBITMarginKPIHover.hover();
		String EBITTarget1 = VIPSalesPage.contents.VPKPITooltipTarget.getText().replace("%", "");
		double EBITTarget = Double.parseDouble(EBITTarget1);
		String EBITPeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText().replace("%", "");
		double EBITPeer = Double.parseDouble(EBITPeer1);
		if (EBITTarget >= EBITPeer) {
		VIPSalesPage.contents.VPEBITKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPEBITKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		//ROIC
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPROICKPIHover.hover();
		String ROICTarget1 = VIPSalesPage.contents.VPKPITooltipTarget.getText().replace("%", "");
		double ROICTarget = Double.parseDouble(ROICTarget1);
		String ROICPeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText().replace("%", "");
		double ROICPeer = Double.parseDouble(ROICPeer1);
		if (ROICTarget >= ROICPeer) {
		VIPSalesPage.contents.VPROICKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPROICKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		//SGA
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPSGAKPIHover.hover();
		String SGATarget1 = VIPSalesPage.contents.VPKPITooltipTarget.getText().replace("%", "");
		double SGATarget = Double.parseDouble(SGATarget1);
		String SGAPeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText().replace("%", "");
		double SGAPeer = Double.parseDouble(SGAPeer1);
		if (SGATarget >= SGAPeer) {
		VIPSalesPage.contents.VPSGAKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		else {VIPSalesPage.contents.VPSGAKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		//COGS
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPCOGSKPIHover.hover();
		String COGSTarget1 = VIPSalesPage.contents.VPKPITooltipTarget.getText().replace("%", "");
		double COGSTarget = Double.parseDouble(COGSTarget1);
		String COGSPeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText().replace("%", "");
		double COGSPeer = Double.parseDouble(COGSPeer1);
		if (COGSTarget >= COGSPeer) {
		VIPSalesPage.contents.VPCOGSKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		else {VIPSalesPage.contents.VPCOGSKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		//IC
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPICKPIHover.hover();
		String ICTarget1 = VIPSalesPage.contents.VPKPITooltipTarget.getText().replace("%", "");
		double ICTarget = Double.parseDouble(ICTarget1);
		String ICPeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText().replace("%", "");
		double ICPeer = Double.parseDouble(ICPeer1);
		if (ICTarget >= ICPeer) {
		VIPSalesPage.contents.VPICKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPICKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		WebControl.takeScreenshot("Sales_Reg_Auto_162_Existing");
		
		ReportLog.setTestCase("Sales_Reg_Auto_162_Telco KPI");
		//TV
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPSegment1.hover();
		VIPSalesPage.contents.VPBroadbandKPIIcon.hover();
		String[] TVTarget1 = VIPSalesPage.contents.VPKPITooltipTargetCountry.getText().split("\\,");
		int TVTarget = TVTarget1.length;
		String[] TVPeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedianCountry.getText().split("\\,");
		int TVPeer = TVPeer1.length;
		if (TVTarget >= TVPeer) {
		VIPSalesPage.contents.VPPayTVKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPPayTVKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		//Broadband
		VIPSalesPage.contents.VPBroadbandKPIIcon.hover();
		String[] BroadbandTarget1 = VIPSalesPage.contents.VPKPITooltipTargetCountry.getText().split("\\,");
		int BroadbandTarget = BroadbandTarget1.length;
		String[] BroadbandPeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedianCountry.getText().split("\\,");
		int BroadbandPeer = BroadbandPeer1.length;
		if (BroadbandTarget >= BroadbandPeer) {
		VIPSalesPage.contents.VPBroadbandKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPBroadbandKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		//Mobile
		VIPSalesPage.contents.VPMobileKPIIcon.hover();
		String[] MobileTarget1 = VIPSalesPage.contents.VPKPITooltipTargetCountry.getText().split("\\,");
		int MobileTarget = MobileTarget1.length;
		String[] MobilePeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedianCountry.getText().split("\\,");
		int MobilePeer = MobilePeer1.length;
		if (MobileTarget >= MobilePeer) {
		VIPSalesPage.contents.VPMobileKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPMobileKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		//Churn
		VIPSalesPage.contents.VPSegment3.hover();
		VIPSalesPage.contents.VPChurnKPIIcon.hover();
		String[] ChurnTarget1 = VIPSalesPage.contents.VPKPITooltipTargetCountry.getText().split("\\,");
		int ChurnTarget = ChurnTarget1.length;
		String[] ChurnPeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedianCountry.getText().split("\\,");
		int ChurnPeer = ChurnPeer1.length;
		if (ChurnTarget >= ChurnPeer) {
		VIPSalesPage.contents.VPChurnKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPChurnKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		//ARPU
		VIPSalesPage.contents.VPARPUKPIIcon.hover();
		String[] ARPUTarget1 = VIPSalesPage.contents.VPKPITooltipTargetCountry.getText().split("\\,");
		int ARPUTarget = ARPUTarget1.length;
		String[] ARPUPeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedianCountry.getText().split("\\,");
		int ARPUPeer = ARPUPeer1.length;
		if (ARPUTarget >= ARPUPeer) {
		VIPSalesPage.contents.VPARPUKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPARPUKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		WebControl.takeScreenshot("Sales_Reg_Auto_162_Telco");
		
		ReportLog.setTestCase("Sales_Reg_Auto_163_Telco");
		VIPSalesPage.contents.VPCRLegendTextBetter.verifyText("Better than Peer Median");
		VIPSalesPage.contents.VPCRLegendIconBetter.verifyDisplayed(true);
		VIPSalesPage.contents.VPCRLegendTextWorst.verifyText("Worse than Peer Median");
		VIPSalesPage.contents.VPCRLegendIconWorst.verifyDisplayed(true);
		VIPSalesPage.contents.VPRGLegendTextBetter.verifyText("Better than Peer Median");
		VIPSalesPage.contents.VPRGLegendIconBetter.verifyDisplayed(true);
		VIPSalesPage.contents.VPRGLegendTextWorst.verifyText("Worse than Peer Median");
		VIPSalesPage.contents.VPRGLegendTextMarketShare.verifyDisplayed(false);
		VIPSalesPage.contents.VPRGLegendIconWorst.verifyDisplayed(true);
		VIPSalesPage.contents.VPSBSILegendTextBetter.verifyText("Better than Peer Median");
		VIPSalesPage.contents.VPSBSILegendIconBetter.verifyDisplayed(true);
		VIPSalesPage.contents.VPSBSILegendTextWorst.verifyText("Worse than Peer Median");
		VIPSalesPage.contents.VPSBSILegendIconWorst.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_163_Telco");
		
		ReportLog.setTestCase("Sales_Reg_Auto_164_Telco");
		VIPSalesPage.contents.VPRGLegendTextMarketShare.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_164_Telco");
		
		ReportLog.setTestCase("Sales_Reg_Auto_167_Telco");
//		VIPSalesPage.contents.RGShowLess.click();
//		Thread.sleep(1500);
		VIPSalesPage.contents.RGShowMore.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGShowMore.click();
		Thread.sleep(1500);
		VIPSalesPage.contents.VP5yearRevenueCAGR.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPRevenueperEmployee.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPNetPPERevenue.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPBroadbandConnectionsMarketShare.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPPayTVConnectionsMarketShare.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPMobileConnectionsMarketShare.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPChurnRate.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPARPU.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_167_Telco");
		
		ReportLog.setTestCase("Sales_Reg_Auto_162_CG&S KPI");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.cgsCompany);
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
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.VPCategoryKPIHover.waitForExist(true, 15);
		VIPSalesPage.contents.VPCategoryKPIHover.hover();
		//Category (Increase, Decline & No Change)
		if (VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) {
		String CGSAll[] = VIPSalesPage.contents.VPKPITooltipCGSAll.getText().split("\\n\n");
		int Increase = CGSAll[0].split("\\n").length;
		int Decrease = CGSAll[1].split("\\n").length;
		int NoChange = CGSAll[2].split("\\n").length;
		if ((Increase + NoChange) >= Decrease) {
		VIPSalesPage.contents.VPCategoryKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPCategoryKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}}
		//Category (Increase & Decline)
		else if (VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) {
		String CGSAll[] = VIPSalesPage.contents.VPKPITooltipCGSAll.getText().split("\\n\n");
		int Increase = CGSAll[0].split("\\n").length;
		int Decrease = CGSAll[1].split("\\n").length;
		if (Increase >= Decrease) {
		VIPSalesPage.contents.VPCategoryKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPCategoryKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}}
		//Category (Decline & No Change)
		else if (!VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) {
		String CGSAll[] = VIPSalesPage.contents.VPKPITooltipCGSAll.getText().split("\\n\n");
		int Decrease = CGSAll[0].split("\\n").length;
		int NoChange = CGSAll[1].split("\\n").length;
		if (NoChange >= Decrease) {
		VIPSalesPage.contents.VPCategoryKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPCategoryKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}}
		//Category (Increase & No Change) or (Increase Only) or (No Change Only)
		else if ((VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) |
		(VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) |
		(!VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed())) {
		VIPSalesPage.contents.VPCategoryKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		//Category (Decrease Only)
		else {VIPSalesPage.contents.VPCategoryKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		WebControl.takeScreenshot("Sales_Reg_Auto_162_CG&S");
		
		ReportLog.setTestCase("Sales_Reg_Auto_163_CG&S");
		VIPSalesPage.contents.VPCRLegendTextBetter.verifyText("Better than Peer Median");
		VIPSalesPage.contents.VPCRLegendIconBetter.verifyDisplayed(true);
		VIPSalesPage.contents.VPCRLegendTextWorst.verifyText("Worse than Peer Median");
		VIPSalesPage.contents.VPCRLegendIconWorst.verifyDisplayed(true);
		VIPSalesPage.contents.VPRGLegendTextBetter.verifyText("Better than Peer Median");
		VIPSalesPage.contents.VPRGLegendIconBetter.verifyDisplayed(true);
		VIPSalesPage.contents.VPRGLegendTextWorst.verifyText("Worse than Peer Median");
		VIPSalesPage.contents.VPRGLegendIconWorst.verifyDisplayed(true);
		VIPSalesPage.contents.VPSBSILegendTextBetter.verifyText("Better than Peer Median");
		VIPSalesPage.contents.VPSBSILegendIconBetter.verifyDisplayed(true);
		VIPSalesPage.contents.VPSBSILegendTextWorst.verifyText("Worse than Peer Median");
		VIPSalesPage.contents.VPSBSILegendIconWorst.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_163_CG&S");
		
		ReportLog.setTestCase("Sales_Reg_Auto_164_CG&S");
		VIPSalesPage.contents.VPRGLegendTextMarketShare.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_164_CG&S");
		
		ReportLog.setTestCase("Sales_Reg_Auto_167_CG&S");
		VIPSalesPage.contents.RGShowMore.verifyDisplayed(false);
		VIPSalesPage.contents.VP5yearRevenueCAGR.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPRevenueperEmployee.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPNetPPERevenue.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPMarketShareByCategory.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_167_CG&S");
		
		ReportLog.setTestCase("Sales_Reg_Auto_162_Retail KPI");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.retailCompany);
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
		Thread.sleep(2000);
		if (VIPSalesPage.contents.OppNavModal.isDisplayed()) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostReduction.waitForExist(true, 25);
		Thread.sleep(2000);
		VIPSalesPage.contents.RGShowMore.click();
		VIPSalesPage.contents.VPRegionKPIHover.hover();
		Thread.sleep(2000);
		//Region (Increase, Decline & No Change)
		if (VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) {
		String CGSAll[] = VIPSalesPage.contents.VPKPITooltipCGSAll.getText().split("\\n\n");
		int Increase = CGSAll[0].split("\\n").length;
		int Decrease = CGSAll[1].split("\\n").length;
		int NoChange = CGSAll[2].split("\\n").length;
		if ((Increase + NoChange) >= Decrease) {
		VIPSalesPage.contents.VPRegionKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPRegionKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}}
		//Region (Increase & Decline)
		else if (VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) {
		String CGSAll[] = VIPSalesPage.contents.VPKPITooltipCGSAll.getText().split("\\n\n");
		int Increase = CGSAll[0].split("\\n").length;
		int Decrease = CGSAll[1].split("\\n").length;
		if (Increase >= Decrease) {
		VIPSalesPage.contents.VPRegionKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPRegionKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}}
		//Region (Decline & No Change)
		else if (!VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) {
		String CGSAll[] = VIPSalesPage.contents.VPKPITooltipCGSAll.getText().split("\\n\n");
		int Decrease = CGSAll[0].split("\\n").length;
		int NoChange = CGSAll[1].split("\\n").length;
		if (NoChange >= Decrease) {
		VIPSalesPage.contents.VPRegionKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPRegionKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}}
		//Region (Increase & No Change) or (Increase Only) or (No Change Only)
		else if ((VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) |
		(VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) |
		(!VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed())) {
		VIPSalesPage.contents.VPRegionKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		//Region (Decrease Only)
		else {VIPSalesPage.contents.VPRegionKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		//Segment (Increase, Decline & No Change)
		VIPSalesPage.contents.VPSegmentKPIHover.hover();
		if (VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) {
		String CGSAll[] = VIPSalesPage.contents.VPKPITooltipCGSAll.getText().split("\\n\n");
		int Increase = CGSAll[0].split("\\n").length;
		int Decrease = CGSAll[1].split("\\n").length;
		int NoChange = CGSAll[2].split("\\n").length;
		if ((Increase + NoChange) >= Decrease) {
		VIPSalesPage.contents.VPSegmentKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPSegmentKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}}
		//Segment (Increase & Decline)
		else if (VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) {
		String CGSAll[] = VIPSalesPage.contents.VPKPITooltipCGSAll.getText().split("\\n\n");
		int Increase = CGSAll[0].split("\\n").length;
		int Decrease = CGSAll[1].split("\\n").length;
		if (Increase >= Decrease) {
		VIPSalesPage.contents.VPSegmentKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPSegmentKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}}
		//Segment (Decline & No Change)
		else if (!VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) {
		String CGSAll[] = VIPSalesPage.contents.VPKPITooltipCGSAll.getText().split("\\n\n");
		int NoChange = CGSAll[0].split("\\n").length;
		int Decrease = CGSAll[1].split("\\n").length;
		if (NoChange >= Decrease) {
		VIPSalesPage.contents.VPSegmentKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPSegmentKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}}
		//Segment (Increase & No Change) or (Increase Only) or (No Change Only)
		else if ((VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) |
		(VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed()) |
		(!VIPSalesPage.contents.VPKPITooltipIncrease.isDisplayed() & !VIPSalesPage.contents.VPKPITooltipDecrease.isDisplayed() & VIPSalesPage.contents.VPKPITooltipNoChange.isDisplayed())) {
		VIPSalesPage.contents.VPSegmentKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		//Segment (Decrease Only)
		else {VIPSalesPage.contents.VPSegmentKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		//SameStore
		VIPSalesPage.contents.VPSameStoreKPIHover.hover();
		Thread.sleep(1500);
		String SameStoreTarget1 = VIPSalesPage.contents.VPKPITooltipTarget.getText().replace("%", "");
		Double SameStoreTarget = Double.parseDouble(SameStoreTarget1);
		String SameStorePeer1 = VIPSalesPage.contents.VPKPITooltipPeerMedian.getText().replace("%", "");
		Double SameStorePeer = Double.parseDouble(SameStorePeer1);
		if (SameStoreTarget >= SameStorePeer) {
		VIPSalesPage.contents.VPSameStoreKPIIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");}
		else {VIPSalesPage.contents.VPSameStoreKPIIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");}
		WebControl.takeScreenshot("Sales_Reg_Auto_162_Retail");
		
		ReportLog.setTestCase("Sales_Reg_Auto_163_Retail");
		VIPSalesPage.contents.VPCRLegendTextBetter.verifyText("Better than Peer Median");
		VIPSalesPage.contents.VPCRLegendIconBetter.verifyDisplayed(true);
		VIPSalesPage.contents.VPCRLegendTextWorst.verifyText("Worse than Peer Median");
		VIPSalesPage.contents.VPCRLegendIconWorst.verifyDisplayed(true);
		VIPSalesPage.contents.VPRGLegendTextBetter.verifyText("Better than Peer Median");
		VIPSalesPage.contents.VPRGLegendIconBetter.verifyDisplayed(true);
		VIPSalesPage.contents.VPRGLegendTextWorst.verifyText("Worse than Peer Median");
		VIPSalesPage.contents.VPRGLegendIconWorst.verifyDisplayed(true);
		VIPSalesPage.contents.VPSBSILegendTextBetter.verifyText("Better than Peer Median");
		VIPSalesPage.contents.VPSBSILegendIconBetter.verifyDisplayed(true);
		VIPSalesPage.contents.VPSBSILegendTextWorst.verifyText("Worse than Peer Median");
		VIPSalesPage.contents.VPSBSILegendIconWorst.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_163_Retail");
		
		ReportLog.setTestCase("Sales_Reg_Auto_164_Retail");
		VIPSalesPage.contents.VPRGLegendTextMarketShare.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_164_Retail");
		
		ReportLog.setTestCase("Sales_Reg_Auto_168_Retail");
		VIPSalesPage.contents.RGShowLess.click();
		Thread.sleep(1500);
		VIPSalesPage.contents.RGShowMore.verifyDisplayed(true, 3);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RGShowMore.click();
		Thread.sleep(1500);
		VIPSalesPage.contents.VP5yearRevenueCAGR.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPRevenueperEmployee.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPNetPPERevenue.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPMarketShareByRegion.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPMarketShareBySegment.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPSameStoreSales.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_168_Retail");
		
		ReportLog.setTestCase("Sales_Reg_Auto_169");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SBSIShowMore.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIShowMore.click();
		Thread.sleep(1500);
		VIPSalesPage.contents.VPDaysSalesOutstanding.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPDaysInventoryOutstanding.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPDaysPayablesOutstanding.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPNetDebtFCF.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPNetDebtEBITDA.verifyDisplayed(true, 3);
		VIPSalesPage.contents.VPTotalDebtEquity.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_169");
		
		ReportLog.setTestCase("Sales_Reg_Auto_170");
		VIPLandingPage.contents.HelpIcon.hover();
		//VIPSalesPage.contents.CRShowLess.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGShowLess.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIShowLess.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_170");
		
		ReportLog.setTestCase("Sales_Reg_Auto_171");
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
		String ROICKPIT = VIPFinancialsPage.contents.ROICKPI.getText();
		String COGSKPIT = VIPFinancialsPage.contents.COGSKPI.getText();
		String SGAKPIT = VIPFinancialsPage.contents.SGAKPI.getText();
		String CAGR5YrKPIT = VIPFinancialsPage.contents.CAGR5YrKPI.getText();
		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown7.click();
		String RPEKPIT1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] RPEKPIT2 = RPEKPIT1.split("\\s");
		String RPEKPIT = RPEKPIT2[RPEKPIT2.length - 3];
		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown8.click();
		VIPFinancialsPage.contents.NetPPERevenueBox.click();
		String PPEKPIT1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] PPEKPIT2 = PPEKPIT1.split("\\s");
		String PPEKPIT = PPEKPIT2[PPEKPIT2.length - 3];
		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CashCycleAnalysisMenu.click();
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.waitForExist(true, 10);
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.hover();
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.click();
		String DSO1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] DSO2 = DSO1.split("\\s");
		String DSO3 = DSO2[DSO2.length - 4];
		
		VIPFinancialsPage.contents.InventoryDaysChart.hover();
		VIPFinancialsPage.contents.InventoryDaysChart.click();
		String DIO1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] DIO2 = DIO1.split("\\s");
		String DIO3 = DIO2[DIO2.length - 4];
		
		VIPFinancialsPage.contents.DaysPayableChart.hover();
		VIPFinancialsPage.contents.DaysPayableChart.click();
		String DPO1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] DPO2 = DPO1.split("\\s");
		String DPO3 = DPO2[DPO2.length - 4];
		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
		
		VIPSalesPage.contents.ValueProposition.hover();
		VIPSalesPage.contents.ValueProposition.click();
		if (VIPSalesPage.contents.CRShowMore.isDisplayed()) {
		VIPSalesPage.contents.CRShowMore.click();}
		Thread.sleep(3000);
		VIPSalesPage.contents.VPEBITMarginKPI.verifyText("EBIT margin\n" + EBITMarginKPIT);		
		VIPSalesPage.contents.VPROICKPI.verifyText("ROIC (Pre-Tax)\n" + ROICKPIT);
		VIPSalesPage.contents.VPCOGSKPI.verifyText("COGS / Revenue\n" + COGSKPIT);
		VIPSalesPage.contents.VPSGAKPI.verifyText("SG&A / Revenue\n" + SGAKPIT);
		WebControl.takeScreenshot("Sales_Reg_Auto_171");
		
		ReportLog.setTestCase("Sales_Reg_Auto_173");
		VIPSalesPage.contents.SBSIShowMore.click();
		VIPSalesPage.contents.VPDIOKPIHover.verifyText(DIO3 + " Days");		
		VIPSalesPage.contents.VPDPOKPIHover.verifyText(DPO3 + " Days");
		VIPSalesPage.contents.VPDSOKPIHover.verifyText(DSO3 + " Days");
		WebControl.takeScreenshot("Sales_Reg_Auto_173");
		
		ReportLog.setTestCase("Sales_Reg_Auto_176");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CRPVCOTooltipIcon.verifyDisplayed(true, 5);
		VIPSalesPage.contents.CRPVCOTooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyText("Proposed solutions based on company performance in terms of financial/operational KPIs and client priorities. You can choose to edit FTE cost and number assumptions to custom value.");
		VIPSalesPage.contents.CRPVCOTooltipIcon.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_176");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_CR"); //Updating the Median to check the Gauge (Better or Worst) and Text (Higher or Lower) of CR
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
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
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPSalesPage.contents.CRShowMore.waitForExist(true, 15);
		VIPSalesPage.contents.CRShowMore.click();
		
		String EBITKPI1 = VIPSalesPage.contents.VPEBITMarginKPIHover.getText().replace("%", "");
		Double EBITKPI2 = Double.parseDouble(EBITKPI1);
		Double EBITKPIMinus1 = EBITKPI2 - 1;
		String EBITKPIMinus = Double.toString(EBITKPIMinus1);
		Double EBITKPIPlus1 = EBITKPI2 + 1;
		String EBITKPIPlus = Double.toString(EBITKPIPlus1);
		
		String SGAKPI1 = VIPSalesPage.contents.VPSGAKPIHover.getText().replace("%", "");
		Double SGAKPI2 = Double.parseDouble(SGAKPI1);
		Double SGAKPIMinus1 = SGAKPI2 - 1;
		String SGAKPIMinus = Double.toString(SGAKPIMinus1);
		Double SGAKPIPlus1 = SGAKPI2 + 1;
		String SGAKPIPlus = Double.toString(SGAKPIPlus1);
		
		String COGSKPI1 = VIPSalesPage.contents.VPCOGSKPIHover.getText().replace("%", "");
		Double COGSKPI2 = Double.parseDouble(COGSKPI1);
		Double COGSKPIMinus1 = COGSKPI2 - 1;
		String COGSKPIMinus = Double.toString(COGSKPIMinus1);
		Double COGSKPIPlus1 = COGSKPI2 + 1;
		String COGSKPIPlus = Double.toString(COGSKPIPlus1);
		
		String ROICKPI1 = VIPSalesPage.contents.VPROICKPIHover.getText().replace("%", "");
		Double ROICKPI2 = Double.parseDouble(ROICKPI1);
		Double ROICKPIMinus1 = ROICKPI2 - 1;
		String ROICKPIMinus = Double.toString(ROICKPIMinus1);
		Double ROICKPIPlus1 = ROICKPI2 + 1;
		String ROICKPIPlus = Double.toString(ROICKPIPlus1);
		
		String ICKPI1 = VIPSalesPage.contents.VPICKPIHover.getText();
		Double ICKPI2 = Double.parseDouble(ICKPI1);
		Double ICKPIMinus1 = ICKPI2 - 1;
		String ICKPIMinus = Double.toString(ICKPIMinus1);
		Double ICKPIPlus1 = ICKPI2 + 1;
		String ICKPIPlus = Double.toString(ICKPIPlus1);
		
		if (VIPSalesPage.contents.RGShowMore.isDisplayed()) {
		VIPSalesPage.contents.RGShowMore.click();}
		String CAGRKPI1 = VIPSalesPage.contents.VP5YrCAGRKPIHover.getText().replace("%", "");
		Double CAGRKPI2 = Double.parseDouble(CAGRKPI1);
		Double CAGRKPIMinus1 = CAGRKPI2 - 1;
		String CAGRKPIMinus = Double.toString(CAGRKPIMinus1);
		Double CAGRKPIPlus1 = CAGRKPI2 + 1;
		String CAGRKPIPlus = Double.toString(CAGRKPIPlus1);
		
		String RPEKPI1 = VIPSalesPage.contents.VPRPEKPIHover.getText();
		Double RPEKPI2 = Double.parseDouble(RPEKPI1);
		Double RPEKPIMinus1 = RPEKPI2 - 1;
		String RPEKPIMinus = Double.toString(RPEKPIMinus1);
		Double RPEKPIPlus1 = RPEKPI2 + 1;
		String RPEKPIPlus = Double.toString(RPEKPIPlus1);
		
		String PPEKPI1 = VIPSalesPage.contents.VPNetPPEKPIHover.getText().replace("%", "");
		Double PPEKPI2 = Double.parseDouble(PPEKPI1);
		Double PPEKPIMinus1 = PPEKPI2 - 1;
		String PPEKPIMinus = Double.toString(PPEKPIMinus1);
		Double PPEKPIPlus1 = PPEKPI2 + 1;
		String PPEKPIPlus = Double.toString(PPEKPIPlus1);
		
		VIPSalesPage.contents.SBSIShowMore.click();
		String FCFKPI1 = VIPSalesPage.contents.VPNDFCFKPIHover.getText();
		Double FCFKPI2 = Double.parseDouble(FCFKPI1);
		Double FCFKPIMinus1 = FCFKPI2 - 1;
		String FCFKPIMinus = Double.toString(FCFKPIMinus1);
		Double FCFKPIPlus1 = FCFKPI2 + 1;
		String FCFKPIPlus = Double.toString(FCFKPIPlus1);
		
		String EBITDAKPI1 = VIPSalesPage.contents.VPNDEBITDAKPIHover.getText();
		Double EBITDAKPI2 = Double.parseDouble(EBITDAKPI1);
		Double EBITDAKPIMinus1 = EBITDAKPI2 - 1;
		String EBITDAKPIMinus = Double.toString(EBITDAKPIMinus1);
		Double EBITDAKPIPlus1 = EBITDAKPI2 + 1;
		String EBITDAKPIPlus = Double.toString(EBITDAKPIPlus1);
		
		String TDEKPI1 = VIPSalesPage.contents.VPTDEKPIHover.getText();
		Double TDEKPI2 = Double.parseDouble(TDEKPI1);
		Double TDEKPIMinus1 = TDEKPI2 - 1;
		String TDEKPIMinus = Double.toString(TDEKPIMinus1);
		Double TDEKPIPlus1 = TDEKPI2 + 1;
		String TDEKPIPlus = Double.toString(TDEKPIPlus1);
		
		String DIOKPI1 = VIPSalesPage.contents.VPDIOKPIHover.getText().replace(" Days", "");
		int DIOKPI2 = Integer.parseInt(DIOKPI1);
		int DIOKPIMinus1 = DIOKPI2 - 1;
		String DIOKPIMinus = Integer.toString(DIOKPIMinus1);
		int DIOKPIPlus1 = DIOKPI2 + 1;
		String DIOKPIPlus = Integer.toString(DIOKPIPlus1);
		
		String DPOKPI_1 = VIPSalesPage.contents.VPDPOKPIHover.getText().replace(" Days", "");
		int DPOKPI_2 = Integer.parseInt(DPOKPI_1);
		int DPOKPIMinus1 = DPOKPI_2 - 1;
		String DPOKPIMinus = Integer.toString(DPOKPIMinus1);
		int DPOKPIPlus1 = DPOKPI_2 + 1;
		String DPOKPIPlus = Integer.toString(DPOKPIPlus1);
		
		String DSOKPI1 = VIPSalesPage.contents.VPDSOKPIHover.getText().replace(" Days", "");
		int DSOKPI2 = Integer.parseInt(DSOKPI1);
		int DSOKPIMinus1 = DSOKPI2 - 1;
		String DSOKPIMinus = Integer.toString(DSOKPIMinus1);
		int DSOKPIPlus1 = DSOKPI2 + 1;
		String DSOKPIPlus = Integer.toString(DSOKPIPlus1);
		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedEditIcon.click();
		VIPSalesPage.contents.VPCREditBenchmarksEBITCheckbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksEBITCheckbox.click();
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.sendKeys(EBITKPIPlus);
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.sendKeys(EBITKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksEBITText.verifyText("EBIT MARGIN IS LOWER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksEBITIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.sendKeys(EBITKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksEBITText.verifyText("EBIT MARGIN IS HIGHER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksEBITIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPCREditBenchmarksROICCheckbox.click();
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.sendKeys(ROICKPIPlus);
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.sendKeys(ROICKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksROICText.verifyText("ROIC (PRE-TAX) IS LOWER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksROICIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.sendKeys(ROICKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksROICText.verifyText("ROIC (PRE-TAX) IS HIGHER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksROICIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPCREditBenchmarksSGACheckbox.click();
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.sendKeys(SGAKPIMinus);
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.sendKeys(SGAKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksSGAText.verifyText("SG&A / REVENUE IS HIGHER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksSGAIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.sendKeys(SGAKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksSGAText.verifyText("SG&A / REVENUE IS LOWER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksSGAIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPCREditBenchmarksCOGSCheckbox.click();
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.sendKeys(COGSKPIMinus);
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.sendKeys(COGSKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksCOGSText.verifyText("COGS / REVENUE IS HIGHER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksCOGSIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.sendKeys(COGSKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksCOGSText.verifyText("COGS / REVENUE IS LOWER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksCOGSIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPCREditBenchmarksICCheckbox.click();
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.sendKeys(ICKPIPlus);
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.sendKeys(ICKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksICText.verifyText("INTEREST COVERAGE IS LOWER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksICIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.sendKeys(ICKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPCREditBenchmarksICText.verifyText("INTEREST COVERAGE IS HIGHER THAN");
		VIPSalesPage.contents.VPCREditBenchmarksICIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_203_CR");
		
		ReportLog.setTestCase("Sales_Reg_Auto_203_RG"); //Updating the Median to check the Gauge (Better or Worst) and Text (Higher or Lower) of RG
		VIPSalesPage.contents.RevGrowthEditIcon.click();
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRCheckbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRCheckbox.click();
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.sendKeys(CAGRKPIPlus);
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.sendKeys(CAGRKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRText.verifyText("5-YEAR REVENUE CAGR IS LOWER THAN");
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.sendKeys(CAGRKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRText.verifyText("5-YEAR REVENUE CAGR IS HIGHER THAN");
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPRGEditBenchmarksRPECheckbox.click();
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.waitForExist(true, 15);
		String[] RPECurrency1 = VIPSalesPage.contents.VPRGEditBenchmarksRPEText.getText().split("\\s");
		String RPECurrency = RPECurrency1[4];
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.sendKeys(RPEKPIPlus);
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.sendKeys(RPEKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPRGEditBenchmarksRPEText.verifyText("REVENUE PER EMPLOYEE (‘000 " + RPECurrency + " IS LOWER THAN");
		VIPSalesPage.contents.VPRGEditBenchmarksRPEIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.sendKeys(RPEKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPRGEditBenchmarksRPEText.verifyText("REVENUE PER EMPLOYEE (‘000 " + RPECurrency + " IS HIGHER THAN");
		VIPSalesPage.contents.VPRGEditBenchmarksRPEIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPRGEditBenchmarksPPECheckbox.click();
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.sendKeys(PPEKPIMinus);
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.sendKeys(PPEKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPRGEditBenchmarksPPEText.verifyText("NET PPE / REVENUE IS HIGHER THAN");
		VIPSalesPage.contents.VPRGEditBenchmarksPPEIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.sendKeys(PPEKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPRGEditBenchmarksPPEText.verifyText("NET PPE / REVENUE IS LOWER THAN");
		VIPSalesPage.contents.VPRGEditBenchmarksPPEIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_177_RG");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_SBSI"); //Updating the Median to check the Gauge (Better or Worst) and Text (Higher or Lower) of SBSI
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFCheckbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFCheckbox.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.sendKeys(FCFKPIMinus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.sendKeys(FCFKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFText.verifyText("NET DEBT / FCF IS HIGHER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.sendKeys(FCFKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFText.verifyText("NET DEBT / FCF IS LOWER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDACheckbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDACheckbox.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.sendKeys(EBITDAKPIMinus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.sendKeys(EBITDAKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDAText.verifyText("NET DEBT / EBITDA IS HIGHER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDAIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.sendKeys(EBITDAKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDAText.verifyText("NET DEBT / EBITDA IS LOWER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDAIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDECheckbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDECheckbox.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.sendKeys(TDEKPIMinus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.sendKeys(TDEKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDEText.verifyText("TOTAL DEBT / EQUITY IS HIGHER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDEIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.sendKeys(TDEKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDEText.verifyText("TOTAL DEBT / EQUITY IS LOWER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDEIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOCheckbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOCheckbox.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.sendKeys(DIOKPIMinus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.sendKeys(DIOKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOText.verifyText("DAYS INVENTORY OUTSTANDING IS HIGHER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.sendKeys(DIOKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOText.verifyText("DAYS INVENTORY OUTSTANDING IS LOWER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOCheckbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOCheckbox.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOTextbox.sendKeys(DPOKPIPlus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOTextbox.sendKeys(DPOKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOText.verifyText("DAYS PAYABLES OUTSTANDING IS LOWER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOTextbox.sendKeys(DPOKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOText.verifyText("DAYS PAYABLES OUTSTANDING IS HIGHER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOCheckbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOCheckbox.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.sendKeys(DSOKPIMinus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.sendKeys(DSOKPIMinus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOText.verifyText("DAYS SALES OUTSTANDING IS HIGHER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOIcon.verifyCssValue("background-color", "rgba(227, 107, 95, 1)");
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.sendKeys(DSOKPIPlus);
		Thread.sleep(1500);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOText.verifyText("DAYS SALES OUTSTANDING IS LOWER THAN");
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOIcon.verifyCssValue("background-color", "rgba(154, 205, 50, 1)");
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		Thread.sleep(2000);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_SBSI");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_All KPI are Better"); //Checking the VCO based on the gauge of KPIs
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_All KPI are Better");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only EBIT is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedEditIcon.click();
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.sendKeys(EBITKPIPlus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only EBIT is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only SGA is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedEditIcon.click();
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.sendKeys(EBITKPIMinus);
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.sendKeys(SGAKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only SGA is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only COGS is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedEditIcon.click();
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksSGATextbox.sendKeys(SGAKPIPlus);
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.sendKeys(COGSKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only COGS is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only IC is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedEditIcon.click();
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksCOGSTextbox.sendKeys(COGSKPIPlus);
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.sendKeys(ICKPIPlus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only IC is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only ROIC is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedEditIcon.click();
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksICTextbox.sendKeys(ICKPIMinus);
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.sendKeys(ROICKPIPlus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only ROIC is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only RPE is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedEditIcon.click();
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksROICTextbox.sendKeys(ROICKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.RevGrowthEditIcon.click();
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.sendKeys(RPEKPIPlus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only RPE is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only PPE is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RevGrowthEditIcon.click();
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksRPETextbox.sendKeys(RPEKPIMinus);
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.sendKeys(PPEKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only PPE is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only CAGR is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RevGrowthEditIcon.click();
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksPPETextbox.sendKeys(PPEKPIPlus);
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.sendKeys(CAGRKPIPlus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only CAGR is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only FCF is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RevGrowthEditIcon.click();
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.clear();
		VIPSalesPage.contents.VPRGEditBenchmarksCAGRTextbox.sendKeys(CAGRKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.sendKeys(FCFKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only FCF is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only EBITDA is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksFCFTextbox.sendKeys(FCFKPIPlus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.sendKeys(EBITDAKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only EBITDA is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only TDE is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksEBITDATextbox.sendKeys(EBITDAKPIPlus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.sendKeys(TDEKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only TDE is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only DIO is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksTDETextbox.sendKeys(TDEKPIPlus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.sendKeys(DIOKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only DIO is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only DSO is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDIOTextbox.sendKeys(DIOKPIPlus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.sendKeys(DSOKPIMinus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only DSO is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_177_Only DPO is Worst"); //Checking the VCO based on the gauge of KPIs
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.StructuralEditIcon.click();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDSOTextbox.sendKeys(DSOKPIPlus);
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOTextbox.clear();
		VIPSalesPage.contents.VPSBSIEditBenchmarksDPOTextbox.sendKeys(DPOKPIPlus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_177_Only DPO is Worst");
		
		ReportLog.setTestCase("Sales_Reg_Auto_178");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CostRedEditIcon.click();
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.waitForExist(true, 15);
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.clear();
		VIPSalesPage.contents.VPCREditBenchmarksEBITTextbox.sendKeys(EBITKPIPlus);
		VIPSalesPage.contents.EditBenchmarksPopUpApply.click();
		Thread.sleep(3000);
		//Text
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(true);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true);
		//iIcon
		VIPSalesPage.contents.ITAndBackOfficeiIcon.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSourcingiIcon.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSupplyChainiIcon.verifyDisplayed(true);
		VIPSalesPage.contents.ZeroBasedApproachiIcon.verifyDisplayed(true);
		VIPSalesPage.contents.DigitalOutreachiIcon.verifyDisplayed(true);
		VIPSalesPage.contents.CommercialExcellenceiIcon.verifyDisplayed(true);
		VIPSalesPage.contents.IndustryXOiIcon.verifyDisplayed(true);
		//Message
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.ITAndBackOfficeiIcon.click();
		VIPSalesPage.contents.ITAndBackOfficeiIconMsg.verifyText("IT & Back Office: This constitutes Accenture's cost take out services in all or any of the service groups (Application Management, Application Development, Application Testing, Infrastructure Management) as well as Back office services (Finance & Accounting, HR, Procure to Pay and Customer services).\n" + 
				"Cloud Operations: Here Accenture provides a complete set of Cloud Services which help the client to manage their Service Transformation with Cloud technologies. It helps the client unlock the potential of Cloud along with maximising the value of their existing estate.");
		VIPSalesPage.contents.ITAndBackOfficeiIcon.click();
		VIPSalesPage.contents.IndustryXOiIcon.click();
		VIPSalesPage.contents.IndustryXOiIconMsg.verifyText("Digital Plant: This solution is a part of Accenture's Industry X.0 offering. It includes implementing pervasive WiFi at the entire manufacturing facility, employing sensors in all machines, digitizing the processes, establishing digital lake and setting up command and control center to analyze the data and real time corrective / preventive actions. It results in improving capacity utilization, reducing unplanned down time, reducing repairs and maintenance costs, economizing on workforce and improving safety.\n" + 
				"Connected Equipment: This solution is a part of Accenture's Industry X.0 offering. It involves transformation with living products at its core, which generate data, analyze it and provide continuous insights in real time. Its benefits include predictive insights that enable engineers to predict and prevent process control incidents and / or equipment failures that could result in production losses or health and safety issues. In addition, they enable new as-aservice business models.\n" + 
				"Connected worker: This solution is a part of Accenture's Industry X.0 offering. It helps in productivity improvement, cost reduction and enhanced safety. It involves the use of worker logs, smart sensors, digital assistant and various smart operating procedures in the system for workers.");
		VIPSalesPage.contents.IndustryXOiIcon.click();
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
		WebControl.takeScreenshot("Sales_Reg_Auto_178");
		
		ReportLog.setTestCase("Sales_Reg_Auto_179");
		String[] Cumulative1_1 = VIPSalesPage.contents.CumulativeKPIValue1.getText().split("\\s");
		Double Cumulative1 = Double.parseDouble(Cumulative1_1[2]);
		String[] Cumulative2_1 = VIPSalesPage.contents.CumulativeKPIValue2.getText().split("\\s");
		Double Cumulative2 = Double.parseDouble(Cumulative2_1[2]);
		String[] Cumulative3_1 = VIPSalesPage.contents.CumulativeKPIValue3.getText().split("\\s");
		Double Cumulative3 = Double.parseDouble(Cumulative3_1[2]);
		String[] Cumulative4_1 = VIPSalesPage.contents.CumulativeKPIValue4.getText().split("\\s");
		Double Cumulative4 = Double.parseDouble(Cumulative4_1[2]);
		String[] Cumulative5_1 = VIPSalesPage.contents.CumulativeKPIValue5.getText().split("\\s");
		Double Cumulative5 = Double.parseDouble(Cumulative5_1[2]);
		String[] Cumulative6_1 = VIPSalesPage.contents.CumulativeKPIValue6.getText().split("\\s");
		Double Cumulative6 = Double.parseDouble(Cumulative6_1[2]);
		String[] Cumulative7_1 = VIPSalesPage.contents.CumulativeKPIValue7.getText().split("\\s");
		Double Cumulative7 = Double.parseDouble(Cumulative7_1[2]);
		
		List<Double> lList = new ArrayList<Double>();
		lList.add(Cumulative1);
		lList.add(Cumulative2);
		lList.add(Cumulative3);
		lList.add(Cumulative4);
		lList.add(Cumulative5);
		Collections.sort(lList);
		Double a5 = lList.get(0);
		Double a4 = lList.get(1);
		Double a3 = lList.get(2);
		Double a2 = lList.get(3);
		Double a1 = lList.get(4);
		
		VIPSalesPage.contents.CumulativeKPIValue1.verifyText(Cumulative1_1[0] + " " + Cumulative1_1[1] + " " + a1);
		VIPSalesPage.contents.CumulativeKPIValue2.verifyText(Cumulative2_1[0] + " " + Cumulative2_1[1] + " " + a2);
		VIPSalesPage.contents.CumulativeKPIValue3.verifyText(Cumulative3_1[0] + " " + Cumulative3_1[1] + " " + a3);
		VIPSalesPage.contents.CumulativeKPIValue4.verifyText(Cumulative4_1[0] + " " + Cumulative4_1[1] + " " + a4);
		VIPSalesPage.contents.CumulativeKPIValue5.verifyText(Cumulative5_1[0] + " " + Cumulative5_1[1] + " " + a5);
		
		List<Double> lLists = new ArrayList<Double>();
		lLists.add(Cumulative6);
		lLists.add(Cumulative7);
		Collections.sort(lLists);
		Double a6 = lLists.get(0);
		Double a7 = lLists.get(1);
		VIPSalesPage.contents.CumulativeKPIValue6.verifyText(Cumulative6_1[0] + " " + Cumulative6_1[1] + " " + a6);
		VIPSalesPage.contents.CumulativeKPIValue7.verifyText(Cumulative7_1[0] + " " + Cumulative7_1[1] + " " + a7);
		WebControl.takeScreenshot("Sales_Reg_Auto_179");
		
		ReportLog.setTestCase("Sales_Reg_Auto_180_CR");
		VIPSalesPage.contents.CumulativeKPIHeaderCR.verifyText("Cumulative EBIT savings\n" + "(" + RPECurrency.replace(")", "") + " bn)");
		VIPSalesPage.contents.EPSKPIHeaderCR.verifyText("EPS Increase\n" + "(" + RPECurrency);
		VIPSalesPage.contents.CAGRKPIHeaderCR.verifyText("Revenue CAGR (%)");
		VIPSalesPage.contents.COGSKPIHeaderCR.verifyText("COGS/ Revenue (%)");
		VIPSalesPage.contents.SGAKPIHeaderCR.verifyText("SG&A/ Revenue (%)");
		VIPSalesPage.contents.CCDKPIHeaderCR.verifyText("Cash Cycle Days");
		WebControl.takeScreenshot("Sales_Reg_Auto_180_CR");
		
		ReportLog.setTestCase("Sales_Reg_Auto_180_RG");
		VIPSalesPage.contents.CumulativeKPIHeaderRG.verifyText("Cumulative EBIT savings\n" + "(" + RPECurrency.replace(")", "") + " bn)");
		VIPSalesPage.contents.EPSKPIHeaderRG.verifyText("EPS Increase\n" + "(" + RPECurrency);
		VIPSalesPage.contents.CAGRKPIHeaderRG.verifyText("Revenue CAGR (%)");
		VIPSalesPage.contents.COGSKPIHeaderRG.verifyText("COGS/ Revenue (%)");
		VIPSalesPage.contents.SGAKPIHeaderRG.verifyText("SG&A/ Revenue (%)");
		VIPSalesPage.contents.CCDKPIHeaderRG.verifyText("Cash Cycle Days");
		WebControl.takeScreenshot("Sales_Reg_Auto_180_RG");
		
		ReportLog.setTestCase("Sales_Reg_Auto_180_SBSI");
		VIPSalesPage.contents.CumulativeKPIHeaderSBSI.verifyText("Cumulative EBIT savings");
		VIPSalesPage.contents.EPSKPIHeaderSBSI.verifyText("EPS Increase");
		VIPSalesPage.contents.CAGRKPIHeaderSBSI.verifyText("Revenue CAGR (%)");
		VIPSalesPage.contents.COGSKPIHeaderSBSI.verifyText("COGS/ Revenue (%)");
		VIPSalesPage.contents.SGAKPIHeaderSBSI.verifyText("SG&A/ Revenue (%)");
		VIPSalesPage.contents.CCDKPIHeaderSBSI.verifyText("Cash Cycle Days");
		WebControl.takeScreenshot("Sales_Reg_Auto_180_SBSI");
		
		ReportLog.setTestCase("Sales_Reg_Auto_183_Row1");
		VIPLandingPage.contents.HelpIcon.hover();
		if (VIPSalesPage.contents.Row1Value1.isDisplayed()) {
		VIPSalesPage.contents.Row1Value1.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row1Dash1.isDisplayed()) {
		VIPSalesPage.contents.Row1Dash1.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row1Value2.isDisplayed()) {
		VIPSalesPage.contents.Row1Value2.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row1Dash2.isDisplayed()) {
		VIPSalesPage.contents.Row1Dash2.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row1Value3.isDisplayed()) {
		VIPSalesPage.contents.Row1Value3.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row1Dash3.isDisplayed()) {
		VIPSalesPage.contents.Row1Dash3.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row1Value4.isDisplayed()) {
		VIPSalesPage.contents.Row1Value4.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		else if (VIPSalesPage.contents.Row1Dash4.isDisplayed()) {
		VIPSalesPage.contents.Row1Dash4.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_183_Row1");
		
		ReportLog.setTestCase("Sales_Reg_Auto_183_Row2");
		if (VIPSalesPage.contents.Row2Value1.isDisplayed()) {
		VIPSalesPage.contents.Row2Value1.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row2Dash1.isDisplayed()) {
		VIPSalesPage.contents.Row2Dash1.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row2Value2.isDisplayed()) {
		VIPSalesPage.contents.Row2Value2.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row2Dash2.isDisplayed()) {
		VIPSalesPage.contents.Row2Dash2.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row2Value3.isDisplayed()) {
		VIPSalesPage.contents.Row2Value3.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row2Dash3.isDisplayed()) {
		VIPSalesPage.contents.Row2Dash3.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row2Value4.isDisplayed()) {
		VIPSalesPage.contents.Row2Value4.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		else if (VIPSalesPage.contents.Row2Dash4.isDisplayed()) {
		VIPSalesPage.contents.Row2Dash4.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_183_Row2");
		
		ReportLog.setTestCase("Sales_Reg_Auto_183_Row3");
		if (VIPSalesPage.contents.Row3Value1.isDisplayed()) {
		VIPSalesPage.contents.Row3Value1.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row3Dash1.isDisplayed()) {
		VIPSalesPage.contents.Row3Dash1.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row3Value2.isDisplayed()) {
		VIPSalesPage.contents.Row3Value2.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row3Dash2.isDisplayed()) {
		VIPSalesPage.contents.Row3Dash2.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row3Value3.isDisplayed()) {
		VIPSalesPage.contents.Row3Value3.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row3Dash3.isDisplayed()) {
		VIPSalesPage.contents.Row3Dash3.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row3Value4.isDisplayed()) {
		VIPSalesPage.contents.Row3Value4.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		else if (VIPSalesPage.contents.Row3Dash4.isDisplayed()) {
		VIPSalesPage.contents.Row3Dash4.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_183_Row3");
		
		ReportLog.setTestCase("Sales_Reg_Auto_183_Row4");
		if (VIPSalesPage.contents.Row4Value1.isDisplayed()) {
		VIPSalesPage.contents.Row4Value1.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row4Dash1.isDisplayed()) {
		VIPSalesPage.contents.Row4Dash1.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row4Value2.isDisplayed()) {
		VIPSalesPage.contents.Row4Value2.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row4Dash2.isDisplayed()) {
		VIPSalesPage.contents.Row4Dash2.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row4Value3.isDisplayed()) {
		VIPSalesPage.contents.Row4Value3.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row4Dash3.isDisplayed()) {
		VIPSalesPage.contents.Row4Dash3.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row4Value4.isDisplayed()) {
		VIPSalesPage.contents.Row4Value4.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		else if (VIPSalesPage.contents.Row4Dash4.isDisplayed()) {
		VIPSalesPage.contents.Row4Dash4.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_183_Row4");
		
		ReportLog.setTestCase("Sales_Reg_Auto_183_Row5");
		if (VIPSalesPage.contents.Row5Value1.isDisplayed()) {
		VIPSalesPage.contents.Row5Value1.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row5Dash1.isDisplayed()) {
		VIPSalesPage.contents.Row5Dash1.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row5Value2.isDisplayed()) {
		VIPSalesPage.contents.Row5Value2.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row5Dash2.isDisplayed()) {
		VIPSalesPage.contents.Row5Dash2.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row5Value3.isDisplayed()) {
		VIPSalesPage.contents.Row5Value3.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row5Dash3.isDisplayed()) {
		VIPSalesPage.contents.Row5Dash3.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row5Value4.isDisplayed()) {
		VIPSalesPage.contents.Row5Value4.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		else if (VIPSalesPage.contents.Row5Dash4.isDisplayed()) {
		VIPSalesPage.contents.Row5Dash4.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_183_Row5");
		
		ReportLog.setTestCase("Sales_Reg_Auto_183_Row7");
		if (VIPSalesPage.contents.Row7Value1.isDisplayed()) {
		VIPSalesPage.contents.Row7Value1.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row7Dash1.isDisplayed()) {
		VIPSalesPage.contents.Row7Dash1.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row7Value2.isDisplayed()) {
		VIPSalesPage.contents.Row7Value2.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row7Dash2.isDisplayed()) {
		VIPSalesPage.contents.Row7Dash2.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row7Value3.isDisplayed()) {
		VIPSalesPage.contents.Row7Value3.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row7Dash3.isDisplayed()) {
		VIPSalesPage.contents.Row7Dash3.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row7Value4.isDisplayed()) {
		VIPSalesPage.contents.Row7Value4.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		else if (VIPSalesPage.contents.Row7Dash4.isDisplayed()) {
		VIPSalesPage.contents.Row7Dash4.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_183_Row7");
		
		ReportLog.setTestCase("Sales_Reg_Auto_183_Row8");
		if (VIPSalesPage.contents.Row8Value1.isDisplayed()) {
		VIPSalesPage.contents.Row8Value1.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row8Dash1.isDisplayed()) {
		VIPSalesPage.contents.Row8Dash1.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row8Value2.isDisplayed()) {
		VIPSalesPage.contents.Row8Value2.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row8Dash2.isDisplayed()) {
		VIPSalesPage.contents.Row8Dash2.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row8Value3.isDisplayed()) {
		VIPSalesPage.contents.Row8Value3.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.Row8Dash3.isDisplayed()) {
		VIPSalesPage.contents.Row8Dash3.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		
		if (VIPSalesPage.contents.Row8Value4.isDisplayed()) {
		VIPSalesPage.contents.Row8Value4.hover();
		Thread.sleep(1500);
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		else if (VIPSalesPage.contents.Row8Dash4.isDisplayed()) {
		VIPSalesPage.contents.Row8Dash4.hover();
		VIPSalesPage.contents.KPIImprovementTooltip.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_183_Row8");
		
		ReportLog.setTestCase("Sales_Reg_Auto_184");
		VIPSalesPage.contents.CRCumulativeImpact.verifyDisplayed(true);
		VIPSalesPage.contents.RGCumulativeImpact.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_184");
		
		ReportLog.setTestCase("Sales_Reg_Auto_185");
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
		WebControl.takeScreenshot("Sales_Reg_Auto_185");
		
		ReportLog.setTestCase("Sales_Reg_Auto_187_&_188");
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
		WebControl.takeScreenshot("Sales_Reg_Auto_187");
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
		WebControl.takeScreenshot("Sales_Reg_Auto_188_1_1");
		VIPSalesPage.contents.RevGrowthKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxDisabled1.verifyText(Textbox1);
		VIPSalesPage.contents.TextboxDisabled2.verifyText(Textbox2);
		VIPSalesPage.contents.TextboxDisabled3.verifyText(Textbox3);
		VIPSalesPage.contents.TextboxDisabled4.verifyText(Textbox4);
		WebControl.takeScreenshot("Sales_Reg_Auto_188_2_1");
		VIPSalesPage.contents.StructuralKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxDisabled1.verifyText(Textbox1);
		VIPSalesPage.contents.TextboxDisabled2.verifyText(Textbox2);
		VIPSalesPage.contents.TextboxDisabled3.verifyText(Textbox3);
		VIPSalesPage.contents.TextboxDisabled4.verifyText(Textbox4);
		WebControl.takeScreenshot("Sales_Reg_Auto_188_3_1");
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
		WebControl.takeScreenshot("Sales_Reg_Auto_188_1_2");
		VIPSalesPage.contents.RevGrowthKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxEnabled1.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled2.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled3.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled4.verifyDisplayed();
		WebControl.takeScreenshot("Sales_Reg_Auto_188_2_2");
		VIPSalesPage.contents.StructuralKPIImprovementEditBtn.click();
		VIPSalesPage.contents.EditFTEAssumptionPopUp.verifyDisplayed(true, 3);
		VIPSalesPage.contents.TextboxEnabled1.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled2.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled3.verifyDisplayed();
		VIPSalesPage.contents.TextboxEnabled4.verifyDisplayed();
		WebControl.takeScreenshot("Sales_Reg_Auto_188_2_3");
		
		ReportLog.setTestCase("Sales_Reg_Auto_190");
		VIPSalesPage.contents.SourceNote.waitForExist(true, 15);
		VIPSalesPage.contents.SourceNote.verifyText("Source: Gartner; Analysys Mason; S&P Capital IQ and Accenture Client Value Services.\n" + 
		"Disclaimer: All Gartner information is copyright protected and our license is for Accenture business use only.\n" + 
		"If you use Gartner material, you are responsible for reading and complying with the usage terms including the terms in Gartner's Copyright and Quote Policy\n" + 
		"Usage terms at-a-glance:\n" + 
		"To post reports on internal sites (e.g., on the KX or SharePoint sites), you must first purchase the appropriate license. For pricing information, contact reprints@gartner.com\n" + 
		"For additional details regarding Terms of Use, please refer to Gartner's Copyright and Quote Policy, and Usage Policy: (https://www.gartner.com/en/about/policies/copyright).");
		WebControl.takeScreenshot("Sales_Reg_Auto_190");
	
	}
	
	@Test(priority=3)
	public void Sales_CIQPeersetView_NonCurrated () throws Exception {
		ReportLog.setTestName("Sales Leadership - CIQ Peerset View - Non Currated");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_076_078_079");
		
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
		
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.BackToSearchButton.hover();
//		VIPOverviewPage.contents.BackToSearchButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
//		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.nonCurrComp);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.CurratedNote.verifyText("Note: The default peer-set has been sourced from Capital IQ.");
		WebControl.takeScreenshot("Sales_Reg_Auto_076");
		VIPOverviewPage.contents.SearchType.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_078");
		VIPCompetitorPage.contents.CompetitorTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_079");
		
		ReportLog.setTestCase("WEB_Reg_Auto_091");
		String PeersCounter1 = VIPCompetitorPage.contents.PeersCounter.getText();
		String[] PeersCounter2 = PeersCounter1.split("\\s");
		String PeersCounter = PeersCounter2[PeersCounter2.length - 1];
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING TOP 15 OF " + PeersCounter);
		WebControl.takeScreenshot("WEB_Reg_Auto_091");
		
		ReportLog.setTestCase("WEB_Reg_Auto_092");
		VIPCompetitorPage.contents.VerticalLine.verifyText("|");
		VIPCompetitorPage.contents.RefineCriteriaText.verifyText("REFINE CRITERIA");
		VIPCompetitorPage.contents.RefineCriteriaButton.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_092");
		
		ReportLog.setTestCase("Sales_Reg_Auto_087");		
		VIPCompetitorPage.contents.Competitors15thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(false);
		String PeerCounter1 = VIPCompetitorPage.contents.PeersCounter.getText();
		String[] PeerCounter2 = PeerCounter1.split("\\s");
		String PeerCounter = PeerCounter2[PeerCounter2.length - 1];
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING TOP 15 OF " + PeerCounter);
		WebControl.takeScreenshot("Sales_Reg_Auto_087_1");
		String TargetIndustry1 = VIPCompetitorPage.contents.TargetIndustry.getText();
		String[] TargetIndustry2 = TargetIndustry1.split("\\n");
		String TargetIndustry = TargetIndustry2[0];
		//PeerIndustry1
		String PeerIndustry1_1 = VIPCompetitorPage.contents.PeerIndustry1.getText();
		String[] PeerIndustry1_2 = PeerIndustry1_1.split("\\n");
		String PeerIndustry1 = PeerIndustry1_2[1];
		VIPCompetitorPage.contents.PeerIndustry1.verifyText(TargetIndustry + "\n" + PeerIndustry1);
		//PeerIndustry2
		String PeerIndustry2_1 = VIPCompetitorPage.contents.PeerIndustry2.getText();
		String[] PeerIndustry2_2 = PeerIndustry2_1.split("\\n");
		String PeerIndustry2 = PeerIndustry2_2[1];
		VIPCompetitorPage.contents.PeerIndustry2.verifyText(TargetIndustry + "\n" + PeerIndustry2);
		//PeerIndustry3
		String PeerIndustry3_1 = VIPCompetitorPage.contents.PeerIndustry3.getText();
		String[] PeerIndustry3_2 = PeerIndustry3_1.split("\\n");
		String PeerIndustry3 = PeerIndustry3_2[1];
		VIPCompetitorPage.contents.PeerIndustry3.verifyText(TargetIndustry + "\n" + PeerIndustry3);
		//PeerIndustry4
		String PeerIndustry4_1 = VIPCompetitorPage.contents.PeerIndustry4.getText();
		String[] PeerIndustry4_2 = PeerIndustry4_1.split("\\n");
		String PeerIndustry4 = PeerIndustry4_2[1];
		VIPCompetitorPage.contents.PeerIndustry4.verifyText(TargetIndustry + "\n" + PeerIndustry4);
		//PeerIndustry5
		String PeerIndustry5_1 = VIPCompetitorPage.contents.PeerIndustry5.getText();
		String[] PeerIndustry5_2 = PeerIndustry5_1.split("\\n");
		String PeerIndustry5 = PeerIndustry5_2[1];
		VIPCompetitorPage.contents.PeerIndustry5.verifyText(TargetIndustry + "\n" + PeerIndustry5);
		//PeerIndustry6
		String PeerIndustry6_1 = VIPCompetitorPage.contents.PeerIndustry6.getText();
		String[] PeerIndustry6_2 = PeerIndustry6_1.split("\\n");
		String PeerIndustry6 = PeerIndustry6_2[1];
		VIPCompetitorPage.contents.PeerIndustry6.verifyText(TargetIndustry + "\n" + PeerIndustry6);
		//PeerIndustry7
		String PeerIndustry7_1 = VIPCompetitorPage.contents.PeerIndustry7.getText();
		String[] PeerIndustry7_2 = PeerIndustry7_1.split("\\n");
		String PeerIndustry7 = PeerIndustry7_2[1];
		VIPCompetitorPage.contents.PeerIndustry7.verifyText(TargetIndustry + "\n" + PeerIndustry7);
		//PeerIndustry8
		String PeerIndustry8_1 = VIPCompetitorPage.contents.PeerIndustry8.getText();
		String[] PeerIndustry8_2 = PeerIndustry8_1.split("\\n");
		String PeerIndustry8 = PeerIndustry8_2[1];
		VIPCompetitorPage.contents.PeerIndustry8.verifyText(TargetIndustry + "\n" + PeerIndustry8);
		//PeerIndustry9
		String PeerIndustry9_1 = VIPCompetitorPage.contents.PeerIndustry9.getText();
		String[] PeerIndustry9_2 = PeerIndustry9_1.split("\\n");
		String PeerIndustry9 = PeerIndustry9_2[1];
		VIPCompetitorPage.contents.PeerIndustry9.verifyText(TargetIndustry + "\n" + PeerIndustry9);
		//PeerIndustry10
		String PeerIndustry10_1 = VIPCompetitorPage.contents.PeerIndustry10.getText();
		String[] PeerIndustry10_2 = PeerIndustry10_1.split("\\n");
		String PeerIndustry10 = PeerIndustry10_2[1];
		VIPCompetitorPage.contents.PeerIndustry10.verifyText(TargetIndustry + "\n" + PeerIndustry10);
		//PeerIndustry11
		String PeerIndustry11_1 = VIPCompetitorPage.contents.PeerIndustry11.getText();
		String[] PeerIndustry11_2 = PeerIndustry11_1.split("\\n");
		String PeerIndustry11 = PeerIndustry11_2[1];
		VIPCompetitorPage.contents.PeerIndustry11.verifyText(TargetIndustry + "\n" + PeerIndustry11);
		//PeerIndustry12
		String PeerIndustry12_1 = VIPCompetitorPage.contents.PeerIndustry12.getText();
		String[] PeerIndustry12_2 = PeerIndustry12_1.split("\\n");
		String PeerIndustry12 = PeerIndustry12_2[1];
		VIPCompetitorPage.contents.PeerIndustry12.verifyText(TargetIndustry + "\n" + PeerIndustry12);
		//PeerIndustry13
		String PeerIndustry13_1 = VIPCompetitorPage.contents.PeerIndustry13.getText();
		String[] PeerIndustry13_2 = PeerIndustry13_1.split("\\n");
		String PeerIndustry13 = PeerIndustry13_2[1];
		VIPCompetitorPage.contents.PeerIndustry13.verifyText(TargetIndustry + "\n" + PeerIndustry13);
		//PeerIndustry14
		String PeerIndustry14_1 = VIPCompetitorPage.contents.PeerIndustry14.getText();
		String[] PeerIndustry14_2 = PeerIndustry14_1.split("\\n");
		String PeerIndustry14 = PeerIndustry14_2[1];
		VIPCompetitorPage.contents.PeerIndustry14.verifyText(TargetIndustry + "\n" + PeerIndustry14);
		//PeerIndustry15
		String PeerIndustry15_1 = VIPCompetitorPage.contents.PeerIndustry15.getText();
		String[] PeerIndustry15_2 = PeerIndustry15_1.split("\\n");
		String PeerIndustry15 = PeerIndustry15_2[1];
		VIPCompetitorPage.contents.PeerIndustry15.verifyText(TargetIndustry + "\n" + PeerIndustry15);
		WebControl.takeScreenshot("Sales_Reg_Auto_087_2");
		
		ReportLog.setTestCase("Sales_Reg_Auto_081");		
		VIPCompetitorPage.contents.CompetitorSearchbox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_081");
		
		ReportLog.setTestCase("WEB_Reg_Auto_082_&_093");
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Avex Inc.");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 16 PEERS");
		
		String Revenue1_1 = VIPCompetitorPage.contents.Revenue1.getText();
		String Revenue1_2 = Revenue1_1.replace(",", "");
		int Revenue1 = Integer.parseInt(Revenue1_2);
		
		String Revenue2_1 = VIPCompetitorPage.contents.Revenue2.getText();
		String Revenue2_2 = Revenue2_1.replace(",", "");
		int Revenue2 = Integer.parseInt(Revenue2_2);
		
		String Revenue3_1 = VIPCompetitorPage.contents.Revenue3.getText();
		String Revenue3_2 = Revenue3_1.replace(",", "");
		int Revenue3 = Integer.parseInt(Revenue3_2);
		
		String Revenue4_1 = VIPCompetitorPage.contents.Revenue4.getText();
		String Revenue4_2 = Revenue4_1.replace(",", "");
		int Revenue4 = Integer.parseInt(Revenue4_2);
		
		String Revenue5_1 = VIPCompetitorPage.contents.Revenue5.getText();
		String Revenue5_2 = Revenue5_1.replace(",", "");
		int Revenue5 = Integer.parseInt(Revenue5_2);
		
		String Revenue6_1 = VIPCompetitorPage.contents.Revenue6.getText();
		String Revenue6_2 = Revenue6_1.replace(",", "");
		int Revenue6 = Integer.parseInt(Revenue6_2);
		
		String Revenue7_1 = VIPCompetitorPage.contents.Revenue7.getText();
		String Revenue7_2 = Revenue7_1.replace(",", "");
		int Revenue7 = Integer.parseInt(Revenue7_2);
		
		String Revenue8_1 = VIPCompetitorPage.contents.Revenue8.getText();
		String Revenue8_2 = Revenue8_1.replace(",", "");
		int Revenue8 = Integer.parseInt(Revenue8_2);
		
		String Revenue9_1 = VIPCompetitorPage.contents.Revenue9.getText();
		String Revenue9_2 = Revenue9_1.replace(",", "");
		int Revenue9 = Integer.parseInt(Revenue9_2);
		
		String Revenue10_1 = VIPCompetitorPage.contents.Revenue10.getText();
		String Revenue10_2 = Revenue10_1.replace(",", "");
		int Revenue10 = Integer.parseInt(Revenue10_2);
		
		String Revenue11_1 = VIPCompetitorPage.contents.Revenue11.getText();
		String Revenue11_2 = Revenue11_1.replace(",", "");
		int Revenue11 = Integer.parseInt(Revenue11_2);
		
		String Revenue12_1 = VIPCompetitorPage.contents.Revenue12.getText();
		String Revenue12_2 = Revenue12_1.replace(",", "");
		int Revenue12 = Integer.parseInt(Revenue12_2);
		
		String Revenue13_1 = VIPCompetitorPage.contents.Revenue13.getText();
		String Revenue13_2 = Revenue13_1.replace(",", "");
		int Revenue13 = Integer.parseInt(Revenue13_2);
		
		String Revenue14_1 = VIPCompetitorPage.contents.Revenue14.getText();
		String Revenue14_2 = Revenue14_1.replace(",", "");
		int Revenue14 = Integer.parseInt(Revenue14_2);
		
		String Revenue15_1 = VIPCompetitorPage.contents.Revenue15.getText();
		String Revenue15_2 = Revenue15_1.replace(",", "");
		int Revenue15 = Integer.parseInt(Revenue15_2);
		
		String Revenue16_1 = VIPCompetitorPage.contents.Revenue16.getText();
		String Revenue16_2 = Revenue16_1.replace(",", "");
		int Revenue16 = Integer.parseInt(Revenue16_2);
		
		List<Integer> lList = new ArrayList<Integer>();
        lList.add(Revenue1);       
        lList.add(Revenue2);
        lList.add(Revenue3);
        lList.add(Revenue4);
        lList.add(Revenue5);
        lList.add(Revenue6);
        lList.add(Revenue7);
        lList.add(Revenue8);
        lList.add(Revenue9);
        lList.add(Revenue10);
        lList.add(Revenue11);
        lList.add(Revenue12);
        lList.add(Revenue13);
        lList.add(Revenue14);
        lList.add(Revenue15);
        lList.add(Revenue16);
        
        Collections.sort(lList);
        Integer a1 = lList.get(0);
        Integer a2 = lList.get(1);
        Integer a3 = lList.get(2);
        Integer a4 = lList.get(3);
        Integer a5 = lList.get(4);
        Integer a6 = lList.get(5);
        Integer a7 = lList.get(6);
        Integer a8 = lList.get(7);
        Integer a9 = lList.get(8);
        Integer a10 = lList.get(9);
        Integer a11 = lList.get(10);
        Integer a12 = lList.get(11);
        Integer a13 = lList.get(12);
        Integer a14 = lList.get(13);
        Integer a15 = lList.get(14);
        Integer a16 = lList.get(15);
        
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
        String b1 = myFormat.format(a1);
        String b2 = myFormat.format(a2);
        String b3 = myFormat.format(a3);
        String b4 = myFormat.format(a4);
        String b5 = myFormat.format(a5);
        String b6 = myFormat.format(a6);
        String b7 = myFormat.format(a7);
        String b8 = myFormat.format(a8);
        String b9 = myFormat.format(a9);
        String b10 = myFormat.format(a10);
        String b11 = myFormat.format(a11);
        String b12 = myFormat.format(a12);
        String b13 = myFormat.format(a13);
        String b14 = myFormat.format(a14);
        String b15 = myFormat.format(a15);
        String b16 = myFormat.format(a16);
		
		VIPCompetitorPage.contents.Revenue1.verifyText(b16);
		VIPCompetitorPage.contents.Revenue2.verifyText(b15);
		VIPCompetitorPage.contents.Revenue3.verifyText(b14);
		VIPCompetitorPage.contents.Revenue4.verifyText(b13);
		VIPCompetitorPage.contents.Revenue5.verifyText(b12);
		VIPCompetitorPage.contents.Revenue6.verifyText(b11);
		VIPCompetitorPage.contents.Revenue7.verifyText(b10);
		VIPCompetitorPage.contents.Revenue8.verifyText(b9);
		VIPCompetitorPage.contents.Revenue9.verifyText(b8);
		VIPCompetitorPage.contents.Revenue10.verifyText(b7);
		VIPCompetitorPage.contents.Revenue11.verifyText(b6);
		VIPCompetitorPage.contents.Revenue12.verifyText(b5);
		VIPCompetitorPage.contents.Revenue13.verifyText(b4);
		VIPCompetitorPage.contents.Revenue14.verifyText(b3);
		VIPCompetitorPage.contents.Revenue15.verifyText(b2);
		VIPCompetitorPage.contents.Revenue16.verifyText(b1);
		WebControl.takeScreenshot("WEB_Reg_Auto_082_&_093");
		
		ReportLog.setTestCase("WEB_Reg_Auto_083");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.Competitors1stPeers.hover();
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.TopFilterDropdown.waitForExist(true, 10);
		VIPCompetitorPage.contents.TopFilterDropdown.click();
		VIPCompetitorPage.contents.TopFilterChoice25.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(true, 20);
		Thread.sleep(1500);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Faith, Inc.");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors26thPeers.verifyDisplayed(false);
		String Counter1 = VIPCompetitorPage.contents.PeersCounter.getText();
		String[] Counter2 = Counter1.split("\\s");
		String Counter = Counter2[Counter2.length - 1];
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING TOP 25 OF " + Counter);
		WebControl.takeScreenshot("WEB_Reg_Auto_083");
		
		ReportLog.setTestCase("WEB_Reg_Auto_085");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.nonCurrComp);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		String[] TargetName = VIPLandingPage.contents.CompanyTypeAhead.getText().split("\\|");
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.CompanyNameHeader.waitForExist(true, 10);
		VIPCompetitorPage.contents.CompanyNameHeader.verifyText("Company Name");
		VIPCompetitorPage.contents.IndustryLocationHeader.verifyText("Industry\n" + "Region / Country");
		VIPCompetitorPage.contents.LatestFinancialsHeader.verifyText("Latest\n" + "Financials");
		VIPCompetitorPage.contents.RevenueHeader.verifyText("Revenue\n" + "($MN)");
		VIPCompetitorPage.contents.MarketCapHeader.verifyText("Market Cap\n" + "($MN)");
		VIPCompetitorPage.contents.AliasHeader.verifyText("Edit Alias");
		WebControl.takeScreenshot("WEB_Reg_Auto_085");
		
		ReportLog.setTestCase("WEB_Reg_Auto_086");
		VIPCompetitorPage.contents.AliasIcon.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.AliasIcon.click();
		VIPCompetitorPage.contents.TooltipText.verifyText("Type a shorter name to be shown in the Financial Report instead of the longer standard company name.");
		WebControl.takeScreenshot("WEB_Reg_Auto_086");
		
		ReportLog.setTestCase("WEB_Reg_Auto_088");
		VIPCompetitorPage.contents.TargetCompName.verifyText(TargetName[0].substring(0, TargetName[0].length() - 1) + "\n" + TargetName[1].substring(0, TargetName[1].length() - 1).replace(" Ticker: ", ""));
		WebControl.takeScreenshot("WEB_Reg_Auto_088");
		
		ReportLog.setTestCase("WEB_Reg_Auto_089_&_093");
		VIPCompetitorPage.contents.Competitors1stPeers.click();
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.verifyDisplayed(true, 10);
		if (VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.isDisplayed()) {
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.click();}
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 14 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_089_&_093");
		
		ReportLog.setTestCase("WEB_Reg_Auto_090");
		String Revenues1_1 = VIPCompetitorPage.contents.Revenue1.getText();
		String Revenues1_2 = Revenues1_1.replace(",", "");
		int Revenues1 = Integer.parseInt(Revenues1_2);
		
		String Revenues2_1 = VIPCompetitorPage.contents.Revenue2.getText();
		String Revenues2_2 = Revenues2_1.replace(",", "");
		int Revenues2 = Integer.parseInt(Revenues2_2);
		
		String Revenues3_1 = VIPCompetitorPage.contents.Revenue3.getText();
		String Revenues3_2 = Revenues3_1.replace(",", "");
		int Revenues3 = Integer.parseInt(Revenues3_2);
		
		String Revenues4_1 = VIPCompetitorPage.contents.Revenue4.getText();
		String Revenues4_2 = Revenues4_1.replace(",", "");
		int Revenues4 = Integer.parseInt(Revenues4_2);
		
		String Revenues5_1 = VIPCompetitorPage.contents.Revenue5.getText();
		String Revenues5_2 = Revenues5_1.replace(",", "");
		int Revenues5 = Integer.parseInt(Revenues5_2);
		
		String Revenues6_1 = VIPCompetitorPage.contents.Revenue6.getText();
		String Revenues6_2 = Revenues6_1.replace(",", "");
		int Revenues6 = Integer.parseInt(Revenues6_2);
		
		String Revenues7_1 = VIPCompetitorPage.contents.Revenue7.getText();
		String Revenues7_2 = Revenues7_1.replace(",", "");
		int Revenues7 = Integer.parseInt(Revenues7_2);
		
		String Revenues8_1 = VIPCompetitorPage.contents.Revenue8.getText();
		String Revenues8_2 = Revenues8_1.replace(",", "");
		int Revenues8 = Integer.parseInt(Revenues8_2);
		
		String Revenues9_1 = VIPCompetitorPage.contents.Revenue9.getText();
		String Revenues9_2 = Revenues9_1.replace(",", "");
		int Revenues9 = Integer.parseInt(Revenues9_2);
		
		String Revenues10_1 = VIPCompetitorPage.contents.Revenue10.getText();
		String Revenues10_2 = Revenues10_1.replace(",", "");
		int Revenues10 = Integer.parseInt(Revenues10_2);
		
		String Revenues11_1 = VIPCompetitorPage.contents.Revenue11.getText();
		String Revenues11_2 = Revenues11_1.replace(",", "");
		int Revenues11 = Integer.parseInt(Revenues11_2);
		
		String Revenues12_1 = VIPCompetitorPage.contents.Revenue12.getText();
		String Revenues12_2 = Revenues12_1.replace(",", "");
		int Revenues12 = Integer.parseInt(Revenues12_2);
		
		String Revenues13_1 = VIPCompetitorPage.contents.Revenue13.getText();
		String Revenues13_2 = Revenues13_1.replace(",", "");
		int Revenues13 = Integer.parseInt(Revenues13_2);
		
		String Revenues14_1 = VIPCompetitorPage.contents.Revenue14.getText();
		String Revenues14_2 = Revenues14_1.replace(",", "");
		int Revenues14 = Integer.parseInt(Revenues14_2);
		
//		String Revenues15_1 = VIPCompetitorPage.contents.Revenue15.getText();
//		String Revenues15_2 = Revenues15_1.replace(",", "");
//		int Revenues15 = Integer.parseInt(Revenues15_2);
		
		List<Integer> lLists = new ArrayList<Integer>();
        lLists.add(Revenues1);       
        lLists.add(Revenues2);
        lLists.add(Revenues3);
        lLists.add(Revenues4);
        lLists.add(Revenues5);
        lLists.add(Revenues6);
        lLists.add(Revenues7);
        lLists.add(Revenues8);
        lLists.add(Revenues9);
        lLists.add(Revenues10);
        lLists.add(Revenues11);
        lLists.add(Revenues12);
        lLists.add(Revenues13);
        lLists.add(Revenues14);
//      lLists.add(Revenues15);
        
        Collections.sort(lLists);
        Integer r1 = lLists.get(0);
        Integer r2 = lLists.get(1);
        Integer r3 = lLists.get(2);
        Integer r4 = lLists.get(3);
        Integer r5 = lLists.get(4);
        Integer r6 = lLists.get(5);
        Integer r7 = lLists.get(6);
        Integer r8 = lLists.get(7);
        Integer r9 = lLists.get(8);
        Integer r10 = lLists.get(9);
        Integer r11 = lLists.get(10);
        Integer r12 = lLists.get(11);
        Integer r13 = lLists.get(12);
        Integer r14 = lLists.get(13);
//      Integer r15 = lLists.get(14);
        
        NumberFormat myFormats = NumberFormat.getInstance();
        myFormats.setGroupingUsed(true);
        String c1 = myFormats.format(r1);
        String c2 = myFormats.format(r2);
        String c3 = myFormats.format(r3);
        String c4 = myFormats.format(r4);
        String c5 = myFormats.format(r5);
        String c6 = myFormats.format(r6);
        String c7 = myFormats.format(r7);
        String c8 = myFormats.format(r8);
        String c9 = myFormats.format(r9);
        String c10 = myFormats.format(r10);
        String c11 = myFormats.format(r11);
        String c12 = myFormats.format(r12);
        String c13 = myFormats.format(r13);
        String c14 = myFormats.format(r14);
//      String c15 = myFormats.format(r15);
		
		VIPCompetitorPage.contents.Revenue1.verifyText(c14);
		VIPCompetitorPage.contents.Revenue2.verifyText(c13);
		VIPCompetitorPage.contents.Revenue3.verifyText(c12);
		VIPCompetitorPage.contents.Revenue4.verifyText(c11);
		VIPCompetitorPage.contents.Revenue5.verifyText(c10);
		VIPCompetitorPage.contents.Revenue6.verifyText(c9);
		VIPCompetitorPage.contents.Revenue7.verifyText(c8);
		VIPCompetitorPage.contents.Revenue8.verifyText(c7);
		VIPCompetitorPage.contents.Revenue9.verifyText(c6);
		VIPCompetitorPage.contents.Revenue10.verifyText(c5);
		VIPCompetitorPage.contents.Revenue11.verifyText(c4);
		VIPCompetitorPage.contents.Revenue12.verifyText(c3);
		VIPCompetitorPage.contents.Revenue13.verifyText(c2);
		VIPCompetitorPage.contents.Revenue14.verifyText(c1);
		//VIPCompetitorPage.contents.Revenue15.verifyText(c1);
		WebControl.takeScreenshot("WEB_Reg_Auto_090");
		
		ReportLog.setTestCase("WEB_Reg_Auto_094");
		VIPCompetitorPage.contents.CompanyNameHeader.verifyText("Company Name");
		VIPCompetitorPage.contents.IndustryLocationHeader.verifyText("Industry\n" + "Region / Country");
		VIPCompetitorPage.contents.LatestFinancialsHeader.verifyText("Latest\n" + "Financials");
		VIPCompetitorPage.contents.RevenueHeader.verifyText("Revenue\n" + "($MN)");
		VIPCompetitorPage.contents.MarketCapHeader.verifyText("Market Cap\n" + "($MN)");
		VIPCompetitorPage.contents.AliasHeader.verifyText("Edit Alias\n" + "Type a shorter name to be shown in the Financial Report instead of the longer standard company name.");
		VIPCompetitorPage.contents.TargetCompName.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetIndustry.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetFinancials.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetRevenue.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetMarketCap.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetAlias.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.PeerIndustry1.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Peer1Financials.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Revenue1.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Peer1MarketCap.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Peer1Alias.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_094");
		
		ReportLog.setTestCase("WEB_Reg_Auto_096");
		VIPCompetitorPage.contents.DisclaimerHeader.verifyText("DISCLAIMER");
		VIPCompetitorPage.contents.Disclaimer1.verifyText("(1) The peer set has been selected based on largest companies by revenue in same industry as target company and sourced from Capital IQ.");
		VIPCompetitorPage.contents.Disclaimer2.verifyText("(2) Dual-listed companies (e.g. Rio Tinto, Unilever, BHP Billiton) may appear more than once (while selecting target company or as a peer). Please choose the relevant company.");
		VIPCompetitorPage.contents.Disclaimer3.verifyText("(3) All KPIs may not be captured for private companies given limited reporting.");
		VIPCompetitorPage.contents.Disclaimer4.verifyText("(4) For special financial situations such as M&A, divestments, accounting standard changes and presence of financial services arm, Custom Report is recommended for more accurate analysis.");
		//VIPCompetitorPage.contents.Disclaimer5.verifyText("(5) Some Japanese and South Korean companies from the peer group (Toho Co., Ltd., Toei Company, Ltd., Daiichikosho Co., Ltd.) may have limited disclosure for operating leases and hence these may not have a similar lease adjustments as the rest of the peers");
		WebControl.takeScreenshot("WEB_Reg_Auto_096");
		
		ReportLog.setTestCase("Q2A_Regression_095");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
			VIPLandingPage.contents.HelpIcon.hover();
			VIPOverviewPage.contents.BackToSearchButton.hover();
			VIPOverviewPage.contents.BackToSearchButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.nonCurrComp);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
			VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
			Thread.sleep(1000);
			VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
			VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
			VIPOverviewPage.contents.SideMenuCompetitor.click();	
			VIPCompetitorPage.contents.TargetCompName.waitForExist(true, 15);
			String TargetCompName = VIPCompetitorPage.contents.TargetCompName.getText();
			String TargetIndustry_1 = VIPCompetitorPage.contents.TargetIndustry.getText();
			String TargetFinancials = VIPCompetitorPage.contents.TargetFinancials.getText();
			String TargetRevenue = VIPCompetitorPage.contents.TargetRevenue.getText();
			String TargetMarketCap = VIPCompetitorPage.contents.TargetMarketCap.getText();
			
			String Competitors1stPeers = VIPCompetitorPage.contents.Competitors1stPeers.getText();
			String PeerIndustry_1 = VIPCompetitorPage.contents.PeerIndustry1.getText();
			String Peer1Financials = VIPCompetitorPage.contents.Peer1Financials.getText();
			String PeerRevenue1 = VIPCompetitorPage.contents.Revenue1.getText();
			String Peer1MarketCap = VIPCompetitorPage.contents.Peer1MarketCap.getText();
			
			String Competitors2ndPeers = VIPCompetitorPage.contents.Competitors2ndPeers.getText();
			String PeerIndustry_2 = VIPCompetitorPage.contents.PeerIndustry2.getText();
			String Peer2Financials = VIPCompetitorPage.contents.Peer2Financials.getText();
			String PeerRevenue2 = VIPCompetitorPage.contents.Revenue2.getText();
			String Peer2MarketCap = VIPCompetitorPage.contents.Peer2MarketCap.getText();
			
			String Competitors3rdPeers = VIPCompetitorPage.contents.Competitors3rdPeers.getText();
			String PeerIndustry_3 = VIPCompetitorPage.contents.PeerIndustry3.getText();
			String Peer3Financials = VIPCompetitorPage.contents.Peer3Financials.getText();
			String PeerRevenue3 = VIPCompetitorPage.contents.Revenue3.getText();
			String Peer3MarketCap = VIPCompetitorPage.contents.Peer3MarketCap.getText();
			
			String Competitors4thPeers = VIPCompetitorPage.contents.Competitors4thPeers.getText();
			String PeerIndustry_4 = VIPCompetitorPage.contents.PeerIndustry4.getText();
			String Peer4Financials = VIPCompetitorPage.contents.Peer4Financials.getText();
			String PeerRevenue4 = VIPCompetitorPage.contents.Revenue4.getText();
			String Peer4MarketCap = VIPCompetitorPage.contents.Peer4MarketCap.getText();
			
			String Competitors5thPeers = VIPCompetitorPage.contents.Competitors5thPeers.getText();
			String PeerIndustry_5 = VIPCompetitorPage.contents.PeerIndustry5.getText();
			String Peer5Financials = VIPCompetitorPage.contents.Peer5Financials.getText();
			String PeerRevenue5 = VIPCompetitorPage.contents.Revenue5.getText();
			String Peer5MarketCap = VIPCompetitorPage.contents.Peer5MarketCap.getText();
			
			String Competitors6thPeers = VIPCompetitorPage.contents.Competitors6thPeers.getText();
			String PeerIndustry_6 = VIPCompetitorPage.contents.PeerIndustry6.getText();
			String Peer6Financials = VIPCompetitorPage.contents.Peer6Financials.getText();
			String PeerRevenue6 = VIPCompetitorPage.contents.Revenue6.getText();
			String Peer6MarketCap = VIPCompetitorPage.contents.Peer6MarketCap.getText();
			
			String Competitors7thPeers = VIPCompetitorPage.contents.Competitors7thPeers.getText();
			String PeerIndustry_7 = VIPCompetitorPage.contents.PeerIndustry7.getText();
			String Peer7Financials = VIPCompetitorPage.contents.Peer7Financials.getText();
			String PeerRevenue7 = VIPCompetitorPage.contents.Revenue7.getText();
			String Peer7MarketCap = VIPCompetitorPage.contents.Peer7MarketCap.getText();
			
			String Competitors8thPeers = VIPCompetitorPage.contents.Competitors8thPeers.getText();
			String PeerIndustry_8 = VIPCompetitorPage.contents.PeerIndustry8.getText();
			String Peer8Financials = VIPCompetitorPage.contents.Peer8Financials.getText();
			String PeerRevenue8 = VIPCompetitorPage.contents.Revenue8.getText();
			String Peer8MarketCap = VIPCompetitorPage.contents.Peer8MarketCap.getText();
					
			String Competitors9thPeers = VIPCompetitorPage.contents.Competitors9thPeers.getText();
			String PeerIndustry_9 = VIPCompetitorPage.contents.PeerIndustry9.getText();
			String Peer9Financials = VIPCompetitorPage.contents.Peer9Financials.getText();
			String PeerRevenue9 = VIPCompetitorPage.contents.Revenue9.getText();
			String Peer9MarketCap = VIPCompetitorPage.contents.Peer9MarketCap.getText();
			
			String Competitors10thPeers = VIPCompetitorPage.contents.Competitors10thPeers.getText();
			String PeerIndustry_10 = VIPCompetitorPage.contents.PeerIndustry10.getText();
			String Peer10Financials = VIPCompetitorPage.contents.Peer10Financials.getText();
			String PeerRevenue10 = VIPCompetitorPage.contents.Revenue10.getText();
			String Peer10MarketCap = VIPCompetitorPage.contents.Peer10MarketCap.getText();
			
			String Competitors11thPeers = VIPCompetitorPage.contents.Competitors11thPeers.getText();
			String PeerIndustry_11 = VIPCompetitorPage.contents.PeerIndustry11.getText();
			String Peer11Financials = VIPCompetitorPage.contents.Peer11Financials.getText();
			String PeerRevenue11 = VIPCompetitorPage.contents.Revenue11.getText();
			String Peer11MarketCap = VIPCompetitorPage.contents.Peer11MarketCap.getText();
			
			String Competitors12thPeers = VIPCompetitorPage.contents.Competitors12thPeers.getText();
			String PeerIndustry_12 = VIPCompetitorPage.contents.PeerIndustry12.getText();
			String Peer12Financials = VIPCompetitorPage.contents.Peer12Financials.getText();
			String PeerRevenue12 = VIPCompetitorPage.contents.Revenue12.getText();
			String Peer12MarketCap = VIPCompetitorPage.contents.Peer12MarketCap.getText();
			
			String Competitors13thPeers = VIPCompetitorPage.contents.Competitors13thPeers.getText();
			String PeerIndustry_13 = VIPCompetitorPage.contents.PeerIndustry13.getText();
			String Peer13Financials = VIPCompetitorPage.contents.Peer13Financials.getText();
			String PeerRevenue13 = VIPCompetitorPage.contents.Revenue13.getText();
			String Peer13MarketCap = VIPCompetitorPage.contents.Peer13MarketCap.getText();
			
			String Competitors14thPeers = VIPCompetitorPage.contents.Competitors14thPeers.getText();
			String PeerIndustry_14 = VIPCompetitorPage.contents.PeerIndustry14.getText();
			String Peer14Financials = VIPCompetitorPage.contents.Peer14Financials.getText();
			String PeerRevenue14 = VIPCompetitorPage.contents.Revenue14.getText();
			String Peer14MarketCap = VIPCompetitorPage.contents.Peer14MarketCap.getText();
			
			String Competitors15thPeers = VIPCompetitorPage.contents.Competitors15thPeers.getText();
			String PeerIndustry_15 = VIPCompetitorPage.contents.PeerIndustry15.getText();
			String Peer15Financials = VIPCompetitorPage.contents.Peer15Financials.getText();
			String PeerRevenue15 = VIPCompetitorPage.contents.Revenue15.getText();
			String Peer15MarketCap = VIPCompetitorPage.contents.Peer15MarketCap.getText();
			
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(1500);
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.nonCurrComp);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompetitorTitle.waitForExist(true, 10);
		VIPCompetitorPage.contents.TargetCompName.waitForExist(true, 15);
		
			VIPCompetitorPage.contents.TargetCompName.verifyText(TargetCompName);
			VIPCompetitorPage.contents.TargetIndustry.verifyText(TargetIndustry_1);
			VIPCompetitorPage.contents.TargetFinancials.verifyText(TargetFinancials);
			VIPCompetitorPage.contents.TargetRevenue.verifyText(TargetRevenue);
			VIPCompetitorPage.contents.TargetMarketCap.verifyText(TargetMarketCap);
			
			VIPCompetitorPage.contents.Competitors1stPeers.verifyText(Competitors1stPeers);
			VIPCompetitorPage.contents.PeerIndustry1.verifyText(PeerIndustry_1);
			VIPCompetitorPage.contents.Peer1Financials.verifyText(Peer1Financials);
			VIPCompetitorPage.contents.Revenue1.verifyText(PeerRevenue1);
			VIPCompetitorPage.contents.Peer1MarketCap.verifyText(Peer1MarketCap);
			
			VIPCompetitorPage.contents.Competitors2ndPeers.verifyText(Competitors2ndPeers);
			VIPCompetitorPage.contents.PeerIndustry2.verifyText(PeerIndustry_2);
			VIPCompetitorPage.contents.Peer2Financials.verifyText(Peer2Financials);
			VIPCompetitorPage.contents.Revenue2.verifyText(PeerRevenue2);
			VIPCompetitorPage.contents.Peer2MarketCap.verifyText(Peer2MarketCap);
			
			VIPCompetitorPage.contents.Competitors3rdPeers.verifyText(Competitors3rdPeers);
			VIPCompetitorPage.contents.PeerIndustry3.verifyText(PeerIndustry_3);
			VIPCompetitorPage.contents.Peer3Financials.verifyText(Peer3Financials);
			VIPCompetitorPage.contents.Revenue3.verifyText(PeerRevenue3);
			VIPCompetitorPage.contents.Peer3MarketCap.verifyText(Peer3MarketCap);
			
			VIPCompetitorPage.contents.Competitors4thPeers.verifyText(Competitors4thPeers);
			VIPCompetitorPage.contents.PeerIndustry4.verifyText(PeerIndustry_4);
			VIPCompetitorPage.contents.Peer4Financials.verifyText(Peer4Financials);
			VIPCompetitorPage.contents.Revenue4.verifyText(PeerRevenue4);
			VIPCompetitorPage.contents.Peer4MarketCap.verifyText(Peer4MarketCap);
			
			VIPCompetitorPage.contents.Competitors5thPeers.verifyText(Competitors5thPeers);
			VIPCompetitorPage.contents.PeerIndustry5.verifyText(PeerIndustry_5);
			VIPCompetitorPage.contents.Peer5Financials.verifyText(Peer5Financials);
			VIPCompetitorPage.contents.Revenue5.verifyText(PeerRevenue5);
			VIPCompetitorPage.contents.Peer5MarketCap.verifyText(Peer5MarketCap);
			
			VIPCompetitorPage.contents.Competitors6thPeers.verifyText(Competitors6thPeers);
			VIPCompetitorPage.contents.PeerIndustry6.verifyText(PeerIndustry_6);
			VIPCompetitorPage.contents.Peer6Financials.verifyText(Peer6Financials);
			VIPCompetitorPage.contents.Revenue6.verifyText(PeerRevenue6);
			VIPCompetitorPage.contents.Peer6MarketCap.verifyText(Peer6MarketCap);
			
			VIPCompetitorPage.contents.Competitors7thPeers.verifyText(Competitors7thPeers);
			VIPCompetitorPage.contents.PeerIndustry7.verifyText(PeerIndustry_7);
			VIPCompetitorPage.contents.Peer7Financials.verifyText(Peer7Financials);
			VIPCompetitorPage.contents.Revenue7.verifyText(PeerRevenue7);
			VIPCompetitorPage.contents.Peer7MarketCap.verifyText(Peer7MarketCap);
			
			VIPCompetitorPage.contents.Competitors8thPeers.verifyText(Competitors8thPeers);
			VIPCompetitorPage.contents.PeerIndustry8.verifyText(PeerIndustry_8);
			VIPCompetitorPage.contents.Peer8Financials.verifyText(Peer8Financials);
			VIPCompetitorPage.contents.Revenue8.verifyText(PeerRevenue8);
			VIPCompetitorPage.contents.Peer8MarketCap.verifyText(Peer8MarketCap);
			
			VIPCompetitorPage.contents.Competitors9thPeers.verifyText(Competitors9thPeers);
			VIPCompetitorPage.contents.PeerIndustry9.verifyText(PeerIndustry_9);
			VIPCompetitorPage.contents.Peer9Financials.verifyText(Peer9Financials);
			VIPCompetitorPage.contents.Revenue9.verifyText(PeerRevenue9);
			VIPCompetitorPage.contents.Peer9MarketCap.verifyText(Peer9MarketCap);
			
			VIPCompetitorPage.contents.Competitors10thPeers.verifyText(Competitors10thPeers);
			VIPCompetitorPage.contents.PeerIndustry10.verifyText(PeerIndustry_10);
			VIPCompetitorPage.contents.Peer10Financials.verifyText(Peer10Financials);
			VIPCompetitorPage.contents.Revenue10.verifyText(PeerRevenue10);
			VIPCompetitorPage.contents.Peer10MarketCap.verifyText(Peer10MarketCap);
			
			VIPCompetitorPage.contents.Competitors11thPeers.verifyText(Competitors11thPeers);
			VIPCompetitorPage.contents.PeerIndustry11.verifyText(PeerIndustry_11);
			VIPCompetitorPage.contents.Peer11Financials.verifyText(Peer11Financials);
			VIPCompetitorPage.contents.Revenue11.verifyText(PeerRevenue11);
			VIPCompetitorPage.contents.Peer11MarketCap.verifyText(Peer11MarketCap);
			
			VIPCompetitorPage.contents.Competitors12thPeers.verifyText(Competitors12thPeers);
			VIPCompetitorPage.contents.PeerIndustry12.verifyText(PeerIndustry_12);
			VIPCompetitorPage.contents.Peer12Financials.verifyText(Peer12Financials);
			VIPCompetitorPage.contents.Revenue12.verifyText(PeerRevenue12);
			VIPCompetitorPage.contents.Peer12MarketCap.verifyText(Peer12MarketCap);
			
			VIPCompetitorPage.contents.Competitors13thPeers.verifyText(Competitors13thPeers);
			VIPCompetitorPage.contents.PeerIndustry13.verifyText(PeerIndustry_13);
			VIPCompetitorPage.contents.Peer13Financials.verifyText(Peer13Financials);
			VIPCompetitorPage.contents.Revenue13.verifyText(PeerRevenue13);
			VIPCompetitorPage.contents.Peer13MarketCap.verifyText(Peer13MarketCap);
			
			VIPCompetitorPage.contents.Competitors14thPeers.verifyText(Competitors14thPeers);
			VIPCompetitorPage.contents.PeerIndustry14.verifyText(PeerIndustry_14);
			VIPCompetitorPage.contents.Peer14Financials.verifyText(Peer14Financials);
			VIPCompetitorPage.contents.Revenue14.verifyText(PeerRevenue14);
			VIPCompetitorPage.contents.Peer14MarketCap.verifyText(Peer14MarketCap);
			
			VIPCompetitorPage.contents.Competitors15thPeers.verifyText(Competitors15thPeers);
			VIPCompetitorPage.contents.PeerIndustry15.verifyText(PeerIndustry_15);
			VIPCompetitorPage.contents.Peer15Financials.verifyText(Peer15Financials);
			VIPCompetitorPage.contents.Revenue15.verifyText(PeerRevenue15);
			VIPCompetitorPage.contents.Peer15MarketCap.verifyText(Peer15MarketCap);
			
		WebControl.takeScreenshot("Q2A_Regression_095");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
	@Test(priority=4)
	public void Sales_CIQPeersetView_Currated () throws Exception {
		ReportLog.setTestName("Sales Leadership - CIQ Peerset View - Currated");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_077_078_079");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.currComp);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("Sales_Reg_Auto_077");
		VIPOverviewPage.contents.SearchType.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_078");
		VIPCompetitorPage.contents.CompetitorTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_079");
		
		ReportLog.setTestCase("Sales_Reg_Auto_080");
		VIPCompetitorPage.contents.CurratedNote.verifyText("Note: The proposed peer-set has been customized by the Client Value Services and the account team.\n" + 
				"See the complete list of clients with customized peer-set here.");
		VIPCompetitorPage.contents.CurratedNoteHighlight.verifyText("proposed peer-set");
		WebControl.takeScreenshot("Sales_Reg_Auto_080");
		
		ReportLog.setTestCase("Sales_Reg_Auto_081");		
		VIPCompetitorPage.contents.CompetitorSearchbox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_081");
		
		ReportLog.setTestCase("WEB_Reg_Auto_097");
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 18 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_097");
		
		ReportLog.setTestCase("WEB_Reg_Auto_098");
		VIPCompetitorPage.contents.VerticalLine.verifyText("|");
		VIPCompetitorPage.contents.RefineCriteriaText.verifyText("REFINE CRITERIA");
		VIPCompetitorPage.contents.RefineCriteriaButton.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_098");
		
		ReportLog.setTestCase("WEB_Reg_Auto_082_to_084_&_100");
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("JBS S.A.");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CurratedNote.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Disclaimer1.verifyText("(1) The peer set has been prepared by Accenture Client Value Services Team.");
		WebControl.takeScreenshot("WEB_Reg_Auto_100");
		VIPCompetitorPage.contents.Competitors19thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 19 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_084");
		//20th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Tyson Foods, Inc.");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors20thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 20 PEERS");
		//21th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Yihai Kerry");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors21thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 21 PEERS");
		//22th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("WH Group Limited");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors22thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 22 PEERS");
		//23th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Associated British Foods");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors23thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 23 PEERS");
		//24th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("CJ Cheiljedang");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors24thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 24 PEERS");
		//25th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Charoen Pokphand Foods");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 25 PEERS");
		//26th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Uni-President Enterprises");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors26thPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 25 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_083");
		
		String Revenue1_1 = VIPCompetitorPage.contents.Revenue1.getText();
		String Revenue1_2 = Revenue1_1.replace(",", "");
		int Revenue1 = Integer.parseInt(Revenue1_2);
		
		String Revenue2_1 = VIPCompetitorPage.contents.Revenue2.getText();
		String Revenue2_2 = Revenue2_1.replace(",", "");
		int Revenue2 = Integer.parseInt(Revenue2_2);
		
		String Revenue3_1 = VIPCompetitorPage.contents.Revenue3.getText();
		String Revenue3_2 = Revenue3_1.replace(",", "");
		int Revenue3 = Integer.parseInt(Revenue3_2);
		
		String Revenue4_1 = VIPCompetitorPage.contents.Revenue4.getText();
		String Revenue4_2 = Revenue4_1.replace(",", "");
		int Revenue4 = Integer.parseInt(Revenue4_2);
		
		String Revenue5_1 = VIPCompetitorPage.contents.Revenue5.getText();
		String Revenue5_2 = Revenue5_1.replace(",", "");
		int Revenue5 = Integer.parseInt(Revenue5_2);
		
		String Revenue6_1 = VIPCompetitorPage.contents.Revenue6.getText();
		String Revenue6_2 = Revenue6_1.replace(",", "");
		int Revenue6 = Integer.parseInt(Revenue6_2);
		
		String Revenue7_1 = VIPCompetitorPage.contents.Revenue7.getText();
		String Revenue7_2 = Revenue7_1.replace(",", "");
		int Revenue7 = Integer.parseInt(Revenue7_2);
		
		String Revenue8_1 = VIPCompetitorPage.contents.Revenue8.getText();
		String Revenue8_2 = Revenue8_1.replace(",", "");
		int Revenue8 = Integer.parseInt(Revenue8_2);
		
		String Revenue9_1 = VIPCompetitorPage.contents.Revenue9.getText();
		String Revenue9_2 = Revenue9_1.replace(",", "");
		int Revenue9 = Integer.parseInt(Revenue9_2);
		
		String Revenue10_1 = VIPCompetitorPage.contents.Revenue10.getText();
		String Revenue10_2 = Revenue10_1.replace(",", "");
		int Revenue10 = Integer.parseInt(Revenue10_2);
		
		String Revenue11_1 = VIPCompetitorPage.contents.Revenue11.getText();
		String Revenue11_2 = Revenue11_1.replace(",", "");
		int Revenue11 = Integer.parseInt(Revenue11_2);
		
		String Revenue12_1 = VIPCompetitorPage.contents.Revenue12.getText();
		String Revenue12_2 = Revenue12_1.replace(",", "");
		int Revenue12 = Integer.parseInt(Revenue12_2);
		
		String Revenue13_1 = VIPCompetitorPage.contents.Revenue13.getText();
		String Revenue13_2 = Revenue13_1.replace(",", "");
		int Revenue13 = Integer.parseInt(Revenue13_2);
		
		String Revenue14_1 = VIPCompetitorPage.contents.Revenue14.getText();
		String Revenue14_2 = Revenue14_1.replace(",", "");
		int Revenue14 = Integer.parseInt(Revenue14_2);
		
		String Revenue15_1 = VIPCompetitorPage.contents.Revenue15.getText();
		String Revenue15_2 = Revenue15_1.replace(",", "");
		int Revenue15 = Integer.parseInt(Revenue15_2);
		
		String Revenue16_1 = VIPCompetitorPage.contents.Revenue16.getText();
		String Revenue16_2 = Revenue16_1.replace(",", "");
		int Revenue16 = Integer.parseInt(Revenue16_2);
		
		String Revenue17_1 = VIPCompetitorPage.contents.Revenue17.getText();
		String Revenue17_2 = Revenue17_1.replace(",", "");
		int Revenue17 = Integer.parseInt(Revenue17_2);
		
		String Revenue18_1 = VIPCompetitorPage.contents.Revenue18.getText();
		String Revenue18_2 = Revenue18_1.replace(",", "");
		int Revenue18 = Integer.parseInt(Revenue18_2);
		
		String Revenue19_1 = VIPCompetitorPage.contents.Revenue19.getText();
		String Revenue19_2 = Revenue19_1.replace(",", "");
		int Revenue19 = Integer.parseInt(Revenue19_2);
		
		String Revenue20_1 = VIPCompetitorPage.contents.Revenue20.getText();
		String Revenue20_2 = Revenue20_1.replace(",", "");
		int Revenue20 = Integer.parseInt(Revenue20_2);
		
		String Revenue21_1 = VIPCompetitorPage.contents.Revenue21.getText();
		String Revenue21_2 = Revenue21_1.replace(",", "");
		int Revenue21 = Integer.parseInt(Revenue21_2);
		
		String Revenue22_1 = VIPCompetitorPage.contents.Revenue22.getText();
		String Revenue22_2 = Revenue22_1.replace(",", "");
		int Revenue22 = Integer.parseInt(Revenue22_2);
		
		String Revenue23_1 = VIPCompetitorPage.contents.Revenue23.getText();
		String Revenue23_2 = Revenue23_1.replace(",", "");
		int Revenue23 = Integer.parseInt(Revenue23_2);
		
		String Revenue24_1 = VIPCompetitorPage.contents.Revenue24.getText();
		String Revenue24_2 = Revenue24_1.replace(",", "");
		int Revenue24 = Integer.parseInt(Revenue24_2);
		
		String Revenue25_1 = VIPCompetitorPage.contents.Revenue25.getText();
		String Revenue25_2 = Revenue25_1.replace(",", "");
		int Revenue25 = Integer.parseInt(Revenue25_2);
		
		List<Integer> lList = new ArrayList<Integer>();
        lList.add(Revenue1);       
        lList.add(Revenue2);
        lList.add(Revenue3);
        lList.add(Revenue4);
        lList.add(Revenue5);
        lList.add(Revenue6);
        lList.add(Revenue7);
        lList.add(Revenue8);
        lList.add(Revenue9);
        lList.add(Revenue10);
        lList.add(Revenue11);
        lList.add(Revenue12);
        lList.add(Revenue13);
        lList.add(Revenue14);
        lList.add(Revenue15);
        lList.add(Revenue16);
        lList.add(Revenue17);
        lList.add(Revenue18);
        lList.add(Revenue19);
        lList.add(Revenue20);
        lList.add(Revenue21);
        lList.add(Revenue22);
        lList.add(Revenue23);
        lList.add(Revenue24);
        lList.add(Revenue25);
        
        Collections.sort(lList);
        Integer a1 = lList.get(0);
        Integer a2 = lList.get(1);
        Integer a3 = lList.get(2);
        Integer a4 = lList.get(3);
        Integer a5 = lList.get(4);
        Integer a6 = lList.get(5);
        Integer a7 = lList.get(6);
        Integer a8 = lList.get(7);
        Integer a9 = lList.get(8);
        Integer a10 = lList.get(9);
        Integer a11 = lList.get(10);
        Integer a12 = lList.get(11);
        Integer a13 = lList.get(12);
        Integer a14 = lList.get(13);
        Integer a15 = lList.get(14);
        Integer a16 = lList.get(15);
        Integer a17 = lList.get(16);
        Integer a18 = lList.get(17);
        Integer a19 = lList.get(18);
        Integer a20 = lList.get(19);
        Integer a21 = lList.get(20);
        Integer a22 = lList.get(21);
        Integer a23 = lList.get(22);
        Integer a24 = lList.get(23);
        Integer a25 = lList.get(24);
        
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
        String b1 = myFormat.format(a1);
        String b2 = myFormat.format(a2);
        String b3 = myFormat.format(a3);
        String b4 = myFormat.format(a4);
        String b5 = myFormat.format(a5);
        String b6 = myFormat.format(a6);
        String b7 = myFormat.format(a7);
        String b8 = myFormat.format(a8);
        String b9 = myFormat.format(a9);
        String b10 = myFormat.format(a10);
        String b11 = myFormat.format(a11);
        String b12 = myFormat.format(a12);
        String b13 = myFormat.format(a13);
        String b14 = myFormat.format(a14);
        String b15 = myFormat.format(a15);
        String b16 = myFormat.format(a16);
        String b17 = myFormat.format(a17);
        String b18 = myFormat.format(a18);
        String b19 = myFormat.format(a19);
        String b20 = myFormat.format(a20);
        String b21 = myFormat.format(a21);
        String b22 = myFormat.format(a22);
        String b23 = myFormat.format(a23);
        String b24 = myFormat.format(a24);
        String b25 = myFormat.format(a25);
		
		VIPCompetitorPage.contents.Revenue1.verifyText(b25);
		VIPCompetitorPage.contents.Revenue2.verifyText(b24);
		VIPCompetitorPage.contents.Revenue3.verifyText(b23);
		VIPCompetitorPage.contents.Revenue4.verifyText(b22);
		VIPCompetitorPage.contents.Revenue5.verifyText(b21);
		VIPCompetitorPage.contents.Revenue6.verifyText(b20);
		VIPCompetitorPage.contents.Revenue7.verifyText(b19);
		VIPCompetitorPage.contents.Revenue8.verifyText(b18);
		VIPCompetitorPage.contents.Revenue9.verifyText(b17);
		VIPCompetitorPage.contents.Revenue10.verifyText(b16);
		VIPCompetitorPage.contents.Revenue11.verifyText(b15);
		VIPCompetitorPage.contents.Revenue12.verifyText(b14);
		VIPCompetitorPage.contents.Revenue13.verifyText(b13);
		VIPCompetitorPage.contents.Revenue14.verifyText(b12);
		VIPCompetitorPage.contents.Revenue15.verifyText(b11);
		VIPCompetitorPage.contents.Revenue16.verifyText(b10);
		VIPCompetitorPage.contents.Revenue17.verifyText(b9);
		VIPCompetitorPage.contents.Revenue18.verifyText(b8);
		VIPCompetitorPage.contents.Revenue19.verifyText(b7);
		VIPCompetitorPage.contents.Revenue20.verifyText(b6);
		VIPCompetitorPage.contents.Revenue21.verifyText(b5);
		VIPCompetitorPage.contents.Revenue22.verifyText(b4);
		VIPCompetitorPage.contents.Revenue23.verifyText(b3);
		VIPCompetitorPage.contents.Revenue24.verifyText(b2);
		VIPCompetitorPage.contents.Revenue25.verifyText(b1);
		WebControl.takeScreenshot("WEB_Reg_Auto_082");	
		
		ReportLog.setTestCase("WEB_Reg_Auto_085");
		VIPCompetitorPage.contents.CompanyNameHeader.verifyText("Company Name");
		VIPCompetitorPage.contents.IndustryLocationHeader.verifyText("Industry\n" + "Region / Country");
		VIPCompetitorPage.contents.LatestFinancialsHeader.verifyText("Latest\n" + "Financials");
		VIPCompetitorPage.contents.RevenueHeader.verifyText("Revenue\n" + "($MN)");
		VIPCompetitorPage.contents.MarketCapHeader.verifyText("Market Cap\n" + "($MN)");
		VIPCompetitorPage.contents.AliasHeader.verifyText("Edit Alias");
		WebControl.takeScreenshot("WEB_Reg_Auto_085");
		
		ReportLog.setTestCase("WEB_Reg_Auto_086");
		VIPCompetitorPage.contents.AliasIcon.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.AliasIcon.click();
		VIPCompetitorPage.contents.TooltipText.verifyText("Type a shorter name to be shown in the Financial Report instead of the longer standard company name.");
		WebControl.takeScreenshot("WEB_Reg_Auto_086");
		
		ReportLog.setTestCase("WEB_Reg_Auto_088");
		VIPCompetitorPage.contents.TargetCompName.verifyText("General Mills, Inc.\n" + "NYSE:GIS");
		WebControl.takeScreenshot("WEB_Reg_Auto_088");
		
		ReportLog.setTestCase("WEB_Reg_Auto_089");
		VIPCompetitorPage.contents.Competitors1stPeers.click();
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.verifyDisplayed(true, 10);
		if (VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.isDisplayed()) {
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.click();}
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 24 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_089");
		
		ReportLog.setTestCase("WEB_Reg_Auto_099");
		VIPCompetitorPage.contents.DisclaimerHeader.verifyText("DISCLAIMER");
		VIPCompetitorPage.contents.Disclaimer1.verifyText("(1) The peer set has been prepared by Accenture Client Value Services Team.");
		VIPCompetitorPage.contents.Disclaimer2.verifyText("(2) Dual-listed companies (e.g. Rio Tinto, Unilever, BHP Billiton) may appear more than once (while selecting target company or as a peer). Please choose the relevant company.");
		VIPCompetitorPage.contents.Disclaimer3.verifyText("(3) All KPIs may not be captured for private companies given limited reporting.");
		VIPCompetitorPage.contents.Disclaimer4.verifyText("(4) For special financial situations such as M&A, divestments, accounting standard changes and presence of financial services arm, Custom Report is recommended for more accurate analysis.");
		//VIPCompetitorPage.contents.Disclaimer5.verifyText("(5) Some Japanese and South Korean companies from the peer group (Toho Co., Ltd., Toei Company, Ltd., Daiichikosho Co., Ltd.) may have limited disclosure for operating leases and hence these may not have a similar lease adjustments as the rest of the peers");
		WebControl.takeScreenshot("WEB_Reg_Auto_099");
		
		ReportLog.setTestCase("WEB_Reg_Auto_100");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.TargetCompName.hover();
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.TopFilterDropdown.waitForExist(true, 10);
		VIPCompetitorPage.contents.TopFilterDropdown.click();
		VIPCompetitorPage.contents.TopFilterChoice25.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(true, 20);
		Thread.sleep(1500);
		VIPCompetitorPage.contents.CurratedNote.verifyText("Note: The default peer-set has been sourced from Capital IQ.");
		VIPCompetitorPage.contents.DisclaimerHeader.verifyText("DISCLAIMER");
		VIPCompetitorPage.contents.Disclaimer1.verifyText("(1) The peer set has been modified based on Refine Criteria and sourced from Capital IQ.");
		VIPCompetitorPage.contents.Disclaimer2.verifyText("(2) Dual-listed companies (e.g. Rio Tinto, Unilever, BHP Billiton) may appear more than once (while selecting target company or as a peer). Please choose the relevant company.");
		VIPCompetitorPage.contents.Disclaimer3.verifyText("(3) All KPIs may not be captured for private companies given limited reporting.");
		VIPCompetitorPage.contents.Disclaimer4.verifyText("(4) For special financial situations such as M&A, divestments, accounting standard changes and presence of financial services arm, Custom Report is recommended for more accurate analysis.");
		//VIPCompetitorPage.contents.Disclaimer5.verifyText("(5) Some Japanese and South Korean companies from the peer group (Toho Co., Ltd., Toei Company, Ltd., Daiichikosho Co., Ltd.) may have limited disclosure for operating leases and hence these may not have a similar lease adjustments as the rest of the peers");
		WebControl.takeScreenshot("WEB_Reg_Auto_100");
		
		ReportLog.setTestCase("Q2A_Regression_095");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
			VIPLandingPage.contents.HelpIcon.hover();
			VIPOverviewPage.contents.BackToSearchButton.hover();
			VIPOverviewPage.contents.BackToSearchButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.currComp);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
			VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
			Thread.sleep(1000);
			VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
			VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
			VIPOverviewPage.contents.SideMenuCompetitor.click();	
			VIPCompetitorPage.contents.TargetCompName.waitForExist(true, 15);
			String TargetCompName = VIPCompetitorPage.contents.TargetCompName.getText();
			String TargetIndustry_1 = VIPCompetitorPage.contents.TargetIndustry.getText();
			String TargetFinancials = VIPCompetitorPage.contents.TargetFinancials.getText();
			String TargetRevenue = VIPCompetitorPage.contents.TargetRevenue.getText();
			String TargetMarketCap = VIPCompetitorPage.contents.TargetMarketCap.getText();
			
			String Competitors1stPeers = "";
			String PeerIndustry_1 = "";
			String Peer1Financials = "";
			String PeerRevenue1 = "";
			String Peer1MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
			Competitors1stPeers = VIPCompetitorPage.contents.Competitors1stPeers.getText();
			PeerIndustry_1 = VIPCompetitorPage.contents.PeerIndustry1.getText();
			Peer1Financials = VIPCompetitorPage.contents.Peer1Financials.getText();
			PeerRevenue1 = VIPCompetitorPage.contents.Revenue1.getText();
			Peer1MarketCap = VIPCompetitorPage.contents.Peer1MarketCap.getText();}
			
			String Competitors2ndPeers = "";
			String PeerIndustry_2 = "";
			String Peer2Financials = "";
			String PeerRevenue2 = "";
			String Peer2MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors2ndPeers.isDisplayed()) {
			Competitors2ndPeers = VIPCompetitorPage.contents.Competitors2ndPeers.getText();
			PeerIndustry_2 = VIPCompetitorPage.contents.PeerIndustry2.getText();
			Peer2Financials = VIPCompetitorPage.contents.Peer2Financials.getText();
			PeerRevenue2 = VIPCompetitorPage.contents.Revenue2.getText();
			Peer2MarketCap = VIPCompetitorPage.contents.Peer2MarketCap.getText();}
			
			String Competitors3rdPeers = "";
			String PeerIndustry_3 = "";
			String Peer3Financials = "";
			String PeerRevenue3 = "";
			String Peer3MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors3rdPeers.isDisplayed()) {
			Competitors3rdPeers = VIPCompetitorPage.contents.Competitors3rdPeers.getText();
			PeerIndustry_3 = VIPCompetitorPage.contents.PeerIndustry3.getText();
			Peer3Financials = VIPCompetitorPage.contents.Peer3Financials.getText();
			PeerRevenue3 = VIPCompetitorPage.contents.Revenue3.getText();
			Peer3MarketCap = VIPCompetitorPage.contents.Peer3MarketCap.getText();}
			
			String Competitors4thPeers = "";
			String PeerIndustry_4 = "";
			String Peer4Financials = "";
			String PeerRevenue4 = "";
			String Peer4MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors4thPeers.isDisplayed()) {
			Competitors4thPeers = VIPCompetitorPage.contents.Competitors4thPeers.getText();
			PeerIndustry_4 = VIPCompetitorPage.contents.PeerIndustry4.getText();
			Peer4Financials = VIPCompetitorPage.contents.Peer4Financials.getText();
			PeerRevenue4 = VIPCompetitorPage.contents.Revenue4.getText();
			Peer4MarketCap = VIPCompetitorPage.contents.Peer4MarketCap.getText();}
			
			String Competitors5thPeers = "";
			String PeerIndustry_5 = "";
			String Peer5Financials = "";
			String PeerRevenue5 = "";
			String Peer5MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors5thPeers.isDisplayed()) {
			Competitors5thPeers = VIPCompetitorPage.contents.Competitors5thPeers.getText();
			PeerIndustry_5 = VIPCompetitorPage.contents.PeerIndustry5.getText();
			Peer5Financials = VIPCompetitorPage.contents.Peer5Financials.getText();
			PeerRevenue5 = VIPCompetitorPage.contents.Revenue5.getText();
			Peer5MarketCap = VIPCompetitorPage.contents.Peer5MarketCap.getText();}
			
			String Competitors6thPeers = "";
			String PeerIndustry_6 = "";
			String Peer6Financials = "";
			String PeerRevenue6 = "";
			String Peer6MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors6thPeers.isDisplayed()) {
			Competitors6thPeers = VIPCompetitorPage.contents.Competitors6thPeers.getText();
			PeerIndustry_6 = VIPCompetitorPage.contents.PeerIndustry6.getText();
			Peer6Financials = VIPCompetitorPage.contents.Peer6Financials.getText();
			PeerRevenue6 = VIPCompetitorPage.contents.Revenue6.getText();
			Peer6MarketCap = VIPCompetitorPage.contents.Peer6MarketCap.getText();}
			
			String Competitors7thPeers = "";
			String PeerIndustry_7 = "";
			String Peer7Financials = "";
			String PeerRevenue7 = "";
			String Peer7MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors7thPeers.isDisplayed()) {
			Competitors7thPeers = VIPCompetitorPage.contents.Competitors7thPeers.getText();
			PeerIndustry_7 = VIPCompetitorPage.contents.PeerIndustry7.getText();
			Peer7Financials = VIPCompetitorPage.contents.Peer7Financials.getText();
			PeerRevenue7 = VIPCompetitorPage.contents.Revenue7.getText();
			Peer7MarketCap = VIPCompetitorPage.contents.Peer7MarketCap.getText();}
			
			String Competitors8thPeers = "";
			String PeerIndustry_8 = "";
			String Peer8Financials = "";
			String PeerRevenue8 = "";
			String Peer8MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors8thPeers.isDisplayed()) {
			Competitors8thPeers = VIPCompetitorPage.contents.Competitors8thPeers.getText();
			PeerIndustry_8 = VIPCompetitorPage.contents.PeerIndustry8.getText();
			Peer8Financials = VIPCompetitorPage.contents.Peer8Financials.getText();
			PeerRevenue8 = VIPCompetitorPage.contents.Revenue8.getText();
			Peer8MarketCap = VIPCompetitorPage.contents.Peer8MarketCap.getText();}		
					
			String Competitors9thPeers = "";
			String PeerIndustry_9 = "";
			String Peer9Financials = "";
			String PeerRevenue9 = "";
			String Peer9MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors9thPeers.isDisplayed()) {
			Competitors9thPeers = VIPCompetitorPage.contents.Competitors9thPeers.getText();
			PeerIndustry_9 = VIPCompetitorPage.contents.PeerIndustry9.getText();
			Peer9Financials = VIPCompetitorPage.contents.Peer9Financials.getText();
			PeerRevenue9 = VIPCompetitorPage.contents.Revenue9.getText();
			Peer9MarketCap = VIPCompetitorPage.contents.Peer9MarketCap.getText();}	
			
			String Competitors10thPeers = "";
			String PeerIndustry_10 = "";
			String Peer10Financials = "";
			String PeerRevenue10 = "";
			String Peer10MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors10thPeers.isDisplayed()) {
			Competitors10thPeers = VIPCompetitorPage.contents.Competitors10thPeers.getText();
			PeerIndustry_10 = VIPCompetitorPage.contents.PeerIndustry10.getText();
			Peer10Financials = VIPCompetitorPage.contents.Peer10Financials.getText();
			PeerRevenue10 = VIPCompetitorPage.contents.Revenue10.getText();
			Peer10MarketCap = VIPCompetitorPage.contents.Peer10MarketCap.getText();}
			
			String Competitors11thPeers = "";
			String PeerIndustry_11 = "";
			String Peer11Financials = "";
			String PeerRevenue11 = "";
			String Peer11MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors11thPeers.isDisplayed()) {
			Competitors11thPeers = VIPCompetitorPage.contents.Competitors11thPeers.getText();
			PeerIndustry_11 = VIPCompetitorPage.contents.PeerIndustry11.getText();
			Peer11Financials = VIPCompetitorPage.contents.Peer11Financials.getText();
			PeerRevenue11 = VIPCompetitorPage.contents.Revenue11.getText();
			Peer11MarketCap = VIPCompetitorPage.contents.Peer11MarketCap.getText();}
			
			String Competitors12thPeers = "";
			String PeerIndustry_12 = "";
			String Peer12Financials = "";
			String PeerRevenue12 = "";
			String Peer12MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors12thPeers.isDisplayed()) {
			Competitors12thPeers = VIPCompetitorPage.contents.Competitors12thPeers.getText();
			PeerIndustry_12 = VIPCompetitorPage.contents.PeerIndustry12.getText();
			Peer12Financials = VIPCompetitorPage.contents.Peer12Financials.getText();
			PeerRevenue12 = VIPCompetitorPage.contents.Revenue12.getText();
			Peer12MarketCap = VIPCompetitorPage.contents.Peer12MarketCap.getText();}
			
			String Competitors13thPeers = "";
			String PeerIndustry_13 = "";
			String Peer13Financials = "";
			String PeerRevenue13 = "";
			String Peer13MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors13thPeers.isDisplayed()) {
			Competitors13thPeers = VIPCompetitorPage.contents.Competitors13thPeers.getText();
			PeerIndustry_13 = VIPCompetitorPage.contents.PeerIndustry13.getText();
			Peer13Financials = VIPCompetitorPage.contents.Peer13Financials.getText();
			PeerRevenue13 = VIPCompetitorPage.contents.Revenue13.getText();
			Peer13MarketCap = VIPCompetitorPage.contents.Peer13MarketCap.getText();}
			
			String Competitors14thPeers = "";
			String PeerIndustry_14 = "";
			String Peer14Financials = "";
			String PeerRevenue14 = "";
			String Peer14MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors14thPeers.isDisplayed()) {
			Competitors14thPeers = VIPCompetitorPage.contents.Competitors14thPeers.getText();
			PeerIndustry_14 = VIPCompetitorPage.contents.PeerIndustry14.getText();
			Peer14Financials = VIPCompetitorPage.contents.Peer14Financials.getText();
			PeerRevenue14 = VIPCompetitorPage.contents.Revenue14.getText();
			Peer14MarketCap = VIPCompetitorPage.contents.Peer14MarketCap.getText();}
			
			String Competitors15thPeers = "";
			String PeerIndustry_15 = "";
			String Peer15Financials = "";
			String PeerRevenue15 = "";
			String Peer15MarketCap = "";
			if (VIPCompetitorPage.contents.Competitors15thPeers.isDisplayed()) {
			Competitors15thPeers = VIPCompetitorPage.contents.Competitors15thPeers.getText();
			PeerIndustry_15 = VIPCompetitorPage.contents.PeerIndustry15.getText();
			Peer15Financials = VIPCompetitorPage.contents.Peer15Financials.getText();
			PeerRevenue15 = VIPCompetitorPage.contents.Revenue15.getText();
			Peer15MarketCap = VIPCompetitorPage.contents.Peer15MarketCap.getText();}
			
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(1500);
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.currComp);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompetitorTitle.waitForExist(true, 10);
		VIPCompetitorPage.contents.TargetCompName.waitForExist(true, 15);
		
			VIPCompetitorPage.contents.TargetCompName.verifyText(TargetCompName);
			VIPCompetitorPage.contents.TargetIndustry.verifyText(TargetIndustry_1);
			VIPCompetitorPage.contents.TargetFinancials.verifyText(TargetFinancials);
			VIPCompetitorPage.contents.TargetRevenue.verifyText(TargetRevenue);
			VIPCompetitorPage.contents.TargetMarketCap.verifyText(TargetMarketCap);
			
			if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors1stPeers.verifyText(Competitors1stPeers);
			VIPCompetitorPage.contents.PeerIndustry1.verifyText(PeerIndustry_1);
			VIPCompetitorPage.contents.Peer1Financials.verifyText(Peer1Financials);
			VIPCompetitorPage.contents.Revenue1.verifyText(PeerRevenue1);
			VIPCompetitorPage.contents.Peer1MarketCap.verifyText(Peer1MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors2ndPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors2ndPeers.verifyText(Competitors2ndPeers);
			VIPCompetitorPage.contents.PeerIndustry2.verifyText(PeerIndustry_2);
			VIPCompetitorPage.contents.Peer2Financials.verifyText(Peer2Financials);
			VIPCompetitorPage.contents.Revenue2.verifyText(PeerRevenue2);
			VIPCompetitorPage.contents.Peer2MarketCap.verifyText(Peer2MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors3rdPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors3rdPeers.verifyText(Competitors3rdPeers);
			VIPCompetitorPage.contents.PeerIndustry3.verifyText(PeerIndustry_3);
			VIPCompetitorPage.contents.Peer3Financials.verifyText(Peer3Financials);
			VIPCompetitorPage.contents.Revenue3.verifyText(PeerRevenue3);
			VIPCompetitorPage.contents.Peer3MarketCap.verifyText(Peer3MarketCap);}	
			
			if (VIPCompetitorPage.contents.Competitors4thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors4thPeers.verifyText(Competitors4thPeers);
			VIPCompetitorPage.contents.PeerIndustry4.verifyText(PeerIndustry_4);
			VIPCompetitorPage.contents.Peer4Financials.verifyText(Peer4Financials);
			VIPCompetitorPage.contents.Revenue4.verifyText(PeerRevenue4);
			VIPCompetitorPage.contents.Peer4MarketCap.verifyText(Peer4MarketCap);}	
			
			if (VIPCompetitorPage.contents.Competitors5thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors5thPeers.verifyText(Competitors5thPeers);
			VIPCompetitorPage.contents.PeerIndustry5.verifyText(PeerIndustry_5);
			VIPCompetitorPage.contents.Peer5Financials.verifyText(Peer5Financials);
			VIPCompetitorPage.contents.Revenue5.verifyText(PeerRevenue5);
			VIPCompetitorPage.contents.Peer5MarketCap.verifyText(Peer5MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors6thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors6thPeers.verifyText(Competitors6thPeers);
			VIPCompetitorPage.contents.PeerIndustry6.verifyText(PeerIndustry_6);
			VIPCompetitorPage.contents.Peer6Financials.verifyText(Peer6Financials);
			VIPCompetitorPage.contents.Revenue6.verifyText(PeerRevenue6);
			VIPCompetitorPage.contents.Peer6MarketCap.verifyText(Peer6MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors7thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors7thPeers.verifyText(Competitors7thPeers);
			VIPCompetitorPage.contents.PeerIndustry7.verifyText(PeerIndustry_7);
			VIPCompetitorPage.contents.Peer7Financials.verifyText(Peer7Financials);
			VIPCompetitorPage.contents.Revenue7.verifyText(PeerRevenue7);
			VIPCompetitorPage.contents.Peer7MarketCap.verifyText(Peer7MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors8thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors8thPeers.verifyText(Competitors8thPeers);
			VIPCompetitorPage.contents.PeerIndustry8.verifyText(PeerIndustry_8);
			VIPCompetitorPage.contents.Peer8Financials.verifyText(Peer8Financials);
			VIPCompetitorPage.contents.Revenue8.verifyText(PeerRevenue8);
			VIPCompetitorPage.contents.Peer8MarketCap.verifyText(Peer8MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors9thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors9thPeers.verifyText(Competitors9thPeers);
			VIPCompetitorPage.contents.PeerIndustry9.verifyText(PeerIndustry_9);
			VIPCompetitorPage.contents.Peer9Financials.verifyText(Peer9Financials);
			VIPCompetitorPage.contents.Revenue9.verifyText(PeerRevenue9);
			VIPCompetitorPage.contents.Peer9MarketCap.verifyText(Peer9MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors10thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors10thPeers.verifyText(Competitors10thPeers);
			VIPCompetitorPage.contents.PeerIndustry10.verifyText(PeerIndustry_10);
			VIPCompetitorPage.contents.Peer10Financials.verifyText(Peer10Financials);
			VIPCompetitorPage.contents.Revenue10.verifyText(PeerRevenue10);
			VIPCompetitorPage.contents.Peer10MarketCap.verifyText(Peer10MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors11thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors11thPeers.verifyText(Competitors11thPeers);
			VIPCompetitorPage.contents.PeerIndustry11.verifyText(PeerIndustry_11);
			VIPCompetitorPage.contents.Peer11Financials.verifyText(Peer11Financials);
			VIPCompetitorPage.contents.Revenue11.verifyText(PeerRevenue11);
			VIPCompetitorPage.contents.Peer11MarketCap.verifyText(Peer11MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors12thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors12thPeers.verifyText(Competitors12thPeers);
			VIPCompetitorPage.contents.PeerIndustry12.verifyText(PeerIndustry_12);
			VIPCompetitorPage.contents.Peer12Financials.verifyText(Peer12Financials);
			VIPCompetitorPage.contents.Revenue12.verifyText(PeerRevenue12);
			VIPCompetitorPage.contents.Peer12MarketCap.verifyText(Peer12MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors13thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors13thPeers.verifyText(Competitors13thPeers);
			VIPCompetitorPage.contents.PeerIndustry13.verifyText(PeerIndustry_13);
			VIPCompetitorPage.contents.Peer13Financials.verifyText(Peer13Financials);
			VIPCompetitorPage.contents.Revenue13.verifyText(PeerRevenue13);
			VIPCompetitorPage.contents.Peer13MarketCap.verifyText(Peer13MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors14thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors14thPeers.verifyText(Competitors14thPeers);
			VIPCompetitorPage.contents.PeerIndustry14.verifyText(PeerIndustry_14);
			VIPCompetitorPage.contents.Peer14Financials.verifyText(Peer14Financials);
			VIPCompetitorPage.contents.Revenue14.verifyText(PeerRevenue14);
			VIPCompetitorPage.contents.Peer14MarketCap.verifyText(Peer14MarketCap);}
			
			if (VIPCompetitorPage.contents.Competitors15thPeers.isDisplayed()) {
			VIPCompetitorPage.contents.Competitors15thPeers.verifyText(Competitors15thPeers);
			VIPCompetitorPage.contents.PeerIndustry15.verifyText(PeerIndustry_15);
			VIPCompetitorPage.contents.Peer15Financials.verifyText(Peer15Financials);
			VIPCompetitorPage.contents.Revenue15.verifyText(PeerRevenue15);
			VIPCompetitorPage.contents.Peer15MarketCap.verifyText(Peer15MarketCap);}
			
		WebControl.takeScreenshot("Q2A_Regression_095");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
	@Test(priority=5)
	public void Sales_OperationalKPIs () throws Exception {
		ReportLog.setTestName("Sales Leadership - Operational KPIs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_018");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.telcoCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();		
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText.verifyText("INDUSTRY OPERATING METRICS\n" + "NEW");
		WebControl.takeScreenshot("Sales_Reg_Auto_018");
		
		ReportLog.setTestCase("Sales_Reg_Auto_019");
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.waitForExist(true, 10);
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyText("Industry Operating Metrics - Telecommunication");
		WebControl.takeScreenshot("Sales_Reg_Auto_019");		
		
		ReportLog.setTestCase("Sales_Reg_Auto_020");
		VIPSalesPage.contents.DoesMMYYYYExist.waitForExist(true, 25);
		VIPSalesPage.contents.SelectCountryDropdown.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SelectedCountry.verifyText("United Kingdom");
		WebControl.takeScreenshot("Sales_Reg_Auto_020");		
		
		ReportLog.setTestCase("Sales_Reg_Auto_021");
		VIPSalesPage.contents.ViewCompetitors.verifyDisplayed(true, 3);
		VIPSalesPage.contents.ViewCompetitors.verifyEnabled(true, 3);
		VIPSalesPage.contents.ViewCompetitors.verifyText("View Competitors");
		WebControl.takeScreenshot("Sales_Reg_Auto_021");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_022");
		VIPSalesPage.contents.DoesMetricExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesMetricExist.verifyText("METRIC");
		VIPSalesPage.contents.DoesRankExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesRankExist.verifyText("RANK");
		VIPSalesPage.contents.DoesCompanyNameExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesCompanyNameExist.verifyText("VODAFONE GROUP PLC");
		VIPSalesPage.contents.DoesPeerMedianExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesPeerMedianExist.verifyText("PEER MEDIAN");
		VIPSalesPage.contents.DoesBestExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesBestExist.verifyText("BEST");
		VIPSalesPage.contents.DoesMMYYYYExist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_022");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_023");
		VIPSalesPage.contents.DoesRankExist.hover();
		VIPSalesPage.contents.RankHeaderTooltip.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesCompanyNameExist.hover();
		VIPSalesPage.contents.CompanyNameHeaderTooltip.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesBestExist.hover();
		VIPSalesPage.contents.BestHeader2Tooltip.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_023");
		
		ReportLog.setTestCase("Sales_Reg_Auto_024");
		VIPSalesPage.contents.DoesMobileExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesFixedExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesPayTVExist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_024");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_025");
		VIPSalesPage.contents.DoesMobileSubMetric1Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesMobileSubMetric2Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesMobileSubMetric3Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesMobileSubMetric4Exist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_025");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_026");
		VIPSalesPage.contents.DoesFixedSubMetric1Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesFixedSubMetric2Exist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_026");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_027");
		VIPSalesPage.contents.DoesPayTVSubMetric1Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesPayTVSubMetric2Exist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_027");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_028");
		VIPSalesPage.contents.MobileSubMetric1iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MobileSubMetric1iIcon.click();
		VIPSalesPage.contents.MobileSubMetric1iIconToolTip.verifyText("Operator market share of total active mobile connections excluding M2M/IoT (handset and mobile broadband).\n" + 
				"Active connections: Active subscribers exclude customers who have not used their mobile account for more than 3 months. Connections metrics relate to the end-of-period figure.\n" + 
				"Operator attribution: Mobile subscribers are counted on a network or wholesale basis – that is, customers of service providers without their own network infrastructure are allocated to the network operator(s) that support their service.");	
		VIPSalesPage.contents.MobileSubMetric1iIcon.click();
		VIPSalesPage.contents.MobileSubMetric2iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MobileSubMetric2iIcon.click();
		VIPSalesPage.contents.MobileSubMetric2iIconToolTip.verifyText("Year on Year growth in total active mobile connections excluding M2M/IoT (handset and mobile broadband).");
		VIPSalesPage.contents.MobileSubMetric2iIcon.click();
		VIPSalesPage.contents.MobileSubMetric3iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MobileSubMetric3iIcon.click();
		VIPSalesPage.contents.MobileSubMetric3iIconToolTip.verifyText("Total mobile service revenue (including IoT (M2M)) divided by total average mobile connections (excluding IoT (M2M)) per month.\n" + 
				"Operator service revenue allocation: Total service revenue for mobile services generally from an operator's own and hosted MVNOs’ subscribers, including termination (interconnection and roaming-in) revenue.");
		VIPSalesPage.contents.MobileSubMetric3iIcon.click();
		VIPSalesPage.contents.MobileSubMetric4iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MobileSubMetric4iIcon.click();
		VIPSalesPage.contents.MobileSubMetric4iIconToolTip.verifyText("The number of disconnections from the operator's network during the period divided by the average number of subscribers during the period, expressed on a monthly basis.");
		VIPSalesPage.contents.MobileSubMetric4iIcon.click();
		VIPSalesPage.contents.FixedSubMetric1iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.FixedSubMetric1iIcon.click();
		VIPSalesPage.contents.FixedSubMetric1iIconToolTip.verifyText("Operator market share of fixed broadband connections, which are defined as all fixed broadband connections (xDSL, FTTP/B, cable modem, FWA and other fixed broadband).\n" + 
				"Note that satellite broadband connections are not measured. This metric excludes dedicated leased connections. Connections metrics relate to the end-of-period figure.");
		VIPSalesPage.contents.FixedSubMetric1iIcon.click();
		VIPSalesPage.contents.FixedSubMetric2iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.FixedSubMetric2iIcon.click();
		VIPSalesPage.contents.FixedSubMetric2iIconToolTip.verifyText("Year on Year growth in all fixed broadband connections (xDSL, FTTP/B, cable modem, FWA and other fixed broadband).");
		VIPSalesPage.contents.FixedSubMetric2iIcon.click();
		VIPSalesPage.contents.PayTVSubMetric1iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.PayTVSubMetric1iIcon.click();
		VIPSalesPage.contents.PayTVSubMetric1iIconToolTip.verifyText("Operator market share of total operator Pay-TV, which is defined as total number of traditional pay-tv connections, including cable, internet protocol television (iptv), pay–analogue terrestrial, pay–digital terrestrial television (pay-dtt), and satellite, plus the total number of users of paid-for 'over-the-top' (ott) video services that are sold independently of a traditional pay-tv service and are provided by a telecoms operator or a pay-tv provider that also offers traditional pay-tv services in the country. Multichannel multipoint distribution service (mmds), also known as wireless cable, is counted as part of the cable platform categories, split between analogue and digital.");
		VIPSalesPage.contents.PayTVSubMetric1iIcon.click();
		VIPSalesPage.contents.PayTVSubMetric2iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.PayTVSubMetric2iIcon.click();
		VIPSalesPage.contents.PayTVSubMetric2iIconToolTip.verifyText("Year on Year growth in total number of traditional Pay-TV connections (which include the categories defined in Pay-TV market share KPI).");
		VIPSalesPage.contents.PayTVSubMetric2iIcon.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_028");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_030");
		VIPSalesPage.contents.FootNote.verifyDisplayed(true, 5);	
		String FootNote = VIPSalesPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Sales_Reg_Auto_030");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_031_Target");
		//Mobile connections market share
		String MCMSKPI1 = VIPSalesPage.contents.MCMSKPI.getText();
		if (!MCMSKPI1.contains("N/A")) {
		String MCMSKPI2 = MCMSKPI1.substring(MCMSKPI1.length() - 2, MCMSKPI1.length() - 1);
		String MCMSKPI3 = MCMSKPI1.substring(0, MCMSKPI1.length() - 3);
		VIPSalesPage.contents.MCMSKPI.verifyText(MCMSKPI3 + "." + MCMSKPI2 + "%");}
		else {VIPSalesPage.contents.MCMSKPI.verifyText("N/A");}
		//Growth in mobile connections (YoY)
		String GIMCKPI1 = VIPSalesPage.contents.GIMCKPI.getText();
		if (!GIMCKPI1.contains("N/A")) {
		String GIMCKPI2 = GIMCKPI1.substring(GIMCKPI1.length() - 2, GIMCKPI1.length() - 1);
		String GIMCKPI3 = GIMCKPI1.substring(0, GIMCKPI1.length() - 3);
		VIPSalesPage.contents.GIMCKPI.verifyText(GIMCKPI3 + "." + GIMCKPI2 + "%");}
		else {VIPSalesPage.contents.GIMCKPI.verifyText("N/A");}
		//ARPU (GBP)
		String ARPUKPI1 = VIPSalesPage.contents.ARPUKPI.getText();
		if (!ARPUKPI1.contains("N/A")) {
		String ARPUKPI2 = ARPUKPI1.substring(ARPUKPI1.length() - 1, ARPUKPI1.length());
		String ARPUKPI3 = ARPUKPI1.substring(0, ARPUKPI1.length() - 2);
		VIPSalesPage.contents.ARPUKPI.verifyText(ARPUKPI3 + "." + ARPUKPI2);}
		else {VIPSalesPage.contents.ARPUKPI.verifyText("N/A");}
		//Churn rate
		String CRKPI1 = VIPSalesPage.contents.CRKPI.getText();
		if (!CRKPI1.contains("N/A")) {
		String CRKPI2 = CRKPI1.substring(CRKPI1.length() - 2, CRKPI1.length() - 1);
		String CRKPI3 = CRKPI1.substring(0, CRKPI1.length() - 3);
		VIPSalesPage.contents.CRKPI.verifyText(CRKPI3 + "." + CRKPI2 + "%");}
		else {VIPSalesPage.contents.CRKPI.verifyText("N/A");}
		//Broadband connections market share
		String BCMSKPI1 = VIPSalesPage.contents.BCMSKPI.getText();
		if (!BCMSKPI1.contains("N/A")) {
		String BCMSKPI2 = BCMSKPI1.substring(BCMSKPI1.length() - 2, BCMSKPI1.length() - 1);
		String BCMSKPI3 = BCMSKPI1.substring(0, BCMSKPI1.length() - 3);
		VIPSalesPage.contents.BCMSKPI.verifyText(BCMSKPI3 + "." + BCMSKPI2 + "%");}
		else {VIPSalesPage.contents.BCMSKPI.verifyText("N/A");}
		//Growth in broadband connections (YoY)​
		String GIBCKPI1 = VIPSalesPage.contents.GIBCKPI.getText();
		if (!GIBCKPI1.contains("N/A")) {
		String GIBCKPI2 = GIBCKPI1.substring(GIBCKPI1.length() - 2, GIBCKPI1.length() - 1);
		String GIBCKPI3 = GIBCKPI1.substring(0, GIBCKPI1.length() - 3);
		VIPSalesPage.contents.GIBCKPI.verifyText(GIBCKPI3 + "." + GIBCKPI2 + "%");}
		else {VIPSalesPage.contents.GIBCKPI.verifyText("N/A");}
		//Pay-TV connections market share​
		String PCMSKPI1 = VIPSalesPage.contents.PCMSKPI.getText();
		if (!PCMSKPI1.contains("N/A")) {
		String PCMSKPI2 = PCMSKPI1.substring(PCMSKPI1.length() - 2, PCMSKPI1.length() - 1);
		String PCMSKPI3 = PCMSKPI1.substring(0, PCMSKPI1.length() - 3);
		VIPSalesPage.contents.PCMSKPI.verifyText(PCMSKPI3 + "." + PCMSKPI2 + "%");}
		else {VIPSalesPage.contents.PCMSKPI.verifyText("N/A");}
		//Growth in Pay-TV connections (YoY)​​
		String GIPCKPI1 = VIPSalesPage.contents.GIPCKPI.getText();
		if (!GIPCKPI1.contains("N/A")) {
		String GIPCKPI2 = GIPCKPI1.substring(GIPCKPI1.length() - 2, GIPCKPI1.length() - 1);
		String GIPCKPI3 = GIPCKPI1.substring(0, GIPCKPI1.length() - 3);
		VIPSalesPage.contents.GIPCKPI.verifyText(GIPCKPI3 + "." + GIPCKPI2 + "%");}
		else {VIPSalesPage.contents.GIPCKPI.verifyText("N/A");}
		WebControl.takeScreenshot("Sales_Reg_Auto_031_Target");
		
		ReportLog.setTestCase("Sales_Reg_Auto_031_Peer");
		//Mobile connections market share
		String MCMSKPIP1 = VIPSalesPage.contents.MCMSKPIP.getText();
		if (MCMSKPIP1 != "N/A") {
		String MCMSKPIP2 = MCMSKPIP1.substring(MCMSKPIP1.length() - 2, MCMSKPIP1.length() - 1);
		String MCMSKPIP3 = MCMSKPIP1.substring(0, MCMSKPIP1.length() - 3);
		VIPSalesPage.contents.MCMSKPIP.verifyText(MCMSKPIP3 + "." + MCMSKPIP2 + "%");}
		else {VIPSalesPage.contents.MCMSKPIP.verifyText(MCMSKPIP1);}
		//Growth in mobile connections (YoY)
		String GIMCKPIP1 = VIPSalesPage.contents.GIMCKPIP.getText();
		if (GIMCKPIP1 != "N/A") {
		String GIMCKPIP2 = GIMCKPIP1.substring(GIMCKPIP1.length() - 2, GIMCKPIP1.length() - 1);
		String GIMCKPIP3 = GIMCKPIP1.substring(0, GIMCKPIP1.length() - 3);
		VIPSalesPage.contents.GIMCKPIP.verifyText(GIMCKPIP3 + "." + GIMCKPIP2 + "%");}
		else {VIPSalesPage.contents.GIMCKPIP.verifyText(GIMCKPIP1);}
		//ARPU (GBP)
		String ARPUKPIP1 = VIPSalesPage.contents.ARPUKPIP.getText();
		if (ARPUKPIP1 != "N/A") {
		String ARPUKPIP2 = ARPUKPIP1.substring(ARPUKPIP1.length() - 1, ARPUKPIP1.length());
		String ARPUKPIP3 = ARPUKPIP1.substring(0, ARPUKPIP1.length() - 2);
		VIPSalesPage.contents.ARPUKPIP.verifyText(ARPUKPIP3 + "." + ARPUKPIP2);}
		else {VIPSalesPage.contents.ARPUKPIP.verifyText(ARPUKPIP1);}
		//Churn rate
		String CRKPIP1 = VIPSalesPage.contents.CRKPIP.getText();
		if (CRKPIP1 != "N/A") {
		String CRKPIP2 = CRKPIP1.substring(CRKPIP1.length() - 2, CRKPIP1.length() - 1);
		String CRKPIP3 = CRKPIP1.substring(0, CRKPIP1.length() - 3);
		VIPSalesPage.contents.CRKPIP.verifyText(CRKPIP3 + "." + CRKPIP2 + "%");}
		else {VIPSalesPage.contents.CRKPIP.verifyText(CRKPIP1);}
		//Broadband connections market share
		String BCMSKPIP1 = VIPSalesPage.contents.BCMSKPIP.getText();
		if (BCMSKPIP1 != "N/A") {
		String BCMSKPIP2 = BCMSKPIP1.substring(BCMSKPIP1.length() - 2, BCMSKPIP1.length() - 1);
		String BCMSKPIP3 = BCMSKPIP1.substring(0, BCMSKPIP1.length() - 3);
		VIPSalesPage.contents.BCMSKPIP.verifyText(BCMSKPIP3 + "." + BCMSKPIP2 + "%");}
		else {VIPSalesPage.contents.BCMSKPIP.verifyText(BCMSKPIP1);}
		//Growth in broadband connections (YoY)​
		String GIBCKPIP1 = VIPSalesPage.contents.GIBCKPIP.getText();
		if (GIBCKPIP1 != "N/A") {
		String GIBCKPIP2 = GIBCKPIP1.substring(GIBCKPIP1.length() - 2, GIBCKPIP1.length() - 1);
		String GIBCKPIP3 = GIBCKPIP1.substring(0, GIBCKPIP1.length() - 3);
		VIPSalesPage.contents.GIBCKPIP.verifyText(GIBCKPIP3 + "." + GIBCKPIP2 + "%");}
		else {VIPSalesPage.contents.GIBCKPIP.verifyText(GIBCKPIP1);}
		//Pay-TV connections market share​
		String PCMSKPIP1 = VIPSalesPage.contents.PCMSKPIP.getText();
		if (PCMSKPIP1 != "N/A") {
		String PCMSKPIP2 = PCMSKPIP1.substring(PCMSKPIP1.length() - 2, PCMSKPIP1.length() - 1);
		String PCMSKPIP3 = PCMSKPIP1.substring(0, PCMSKPIP1.length() - 3);
		VIPSalesPage.contents.PCMSKPIP.verifyText(PCMSKPIP3 + "." + PCMSKPIP2 + "%");}
		else {VIPSalesPage.contents.PCMSKPIP.verifyText(PCMSKPIP1);}
		//Growth in Pay-TV connections (YoY)​​
		String GIPCKPIP1 = VIPSalesPage.contents.GIPCKPIP.getText();
		if (GIPCKPIP1 != "N/A") {
		String GIPCKPIP2 = GIPCKPIP1.substring(GIPCKPIP1.length() - 2, GIPCKPIP1.length() - 1);
		String GIPCKPIP3 = GIPCKPIP1.substring(0, GIPCKPIP1.length() - 3);
		VIPSalesPage.contents.GIPCKPIP.verifyText(GIPCKPIP3 + "." + GIPCKPIP2 + "%");}
		else {VIPSalesPage.contents.GIPCKPIP.verifyText(GIPCKPIP1);}
		WebControl.takeScreenshot("Sales_Reg_Auto_031_Peer");
		
		ReportLog.setTestCase("Sales_Reg_Auto_031_Best");
		//Mobile connections market share
		String MCMSKPIB1 = VIPSalesPage.contents.MCMSKPIB.getText();
		if (MCMSKPIB1 != "N/A") {
		String MCMSKPIB2 = MCMSKPIB1.substring(MCMSKPIB1.length() - 2, MCMSKPIB1.length() - 1);
		String MCMSKPIB3 = MCMSKPIB1.substring(0, MCMSKPIB1.length() - 3);
		VIPSalesPage.contents.MCMSKPIB.verifyText(MCMSKPIB3 + "." + MCMSKPIB2 + "%");}
		else {VIPSalesPage.contents.MCMSKPIB.verifyText(MCMSKPIB1);}
		//Growth in mobile connections (YoY)
		String GIMCKPIB1 = VIPSalesPage.contents.GIMCKPIB.getText();
		if (GIMCKPIB1 != "N/A") {
		String GIMCKPIB2 = GIMCKPIB1.substring(GIMCKPIB1.length() - 2, GIMCKPIB1.length() - 1);
		String GIMCKPIB3 = GIMCKPIB1.substring(0, GIMCKPIB1.length() - 3);
		VIPSalesPage.contents.GIMCKPIB.verifyText(GIMCKPIB3 + "." + GIMCKPIB2 + "%");}
		else {VIPSalesPage.contents.GIMCKPIB.verifyText(GIMCKPIB1);}
		//ARPU (GBP)
		String ARPUKPIB1 = VIPSalesPage.contents.ARPUKPIB.getText();
		if (ARPUKPIB1 != "N/A") {
		String ARPUKPIB2 = ARPUKPIB1.substring(ARPUKPIB1.length() - 1, ARPUKPIB1.length());
		String ARPUKPIB3 = ARPUKPIB1.substring(0, ARPUKPIB1.length() - 2);
		VIPSalesPage.contents.ARPUKPIB.verifyText(ARPUKPIB3 + "." + ARPUKPIB2);}
		else {VIPSalesPage.contents.ARPUKPIB.verifyText(ARPUKPIB1);}
		//Churn rate
		String CRKPIB1 = VIPSalesPage.contents.CRKPIB.getText();
		if (CRKPIB1 != "N/A") {
		String CRKPIB2 = CRKPIB1.substring(CRKPIB1.length() - 2, CRKPIB1.length() - 1);
		String CRKPIB3 = CRKPIB1.substring(0, CRKPIB1.length() - 3);
		VIPSalesPage.contents.CRKPIB.verifyText(CRKPIB3 + "." + CRKPIB2 + "%");}
		else {VIPSalesPage.contents.CRKPIB.verifyText(CRKPIB1);}
		//Broadband connections market share
		String BCMSKPIB1 = VIPSalesPage.contents.BCMSKPIB.getText();
		if (BCMSKPIB1 != "N/A") {
		String BCMSKPIB2 = BCMSKPIB1.substring(BCMSKPIB1.length() - 2, BCMSKPIB1.length() - 1);
		String BCMSKPIB3 = BCMSKPIB1.substring(0, BCMSKPIB1.length() - 3);
		VIPSalesPage.contents.BCMSKPIB.verifyText(BCMSKPIB3 + "." + BCMSKPIB2 + "%");}
		else {VIPSalesPage.contents.BCMSKPIB.verifyText(BCMSKPIB1);}
		//Growth in broadband connections (YoY)​
		String GIBCKPIB1 = VIPSalesPage.contents.GIBCKPIB.getText();
		if (GIBCKPIB1 != "N/A") {
		String GIBCKPIB2 = GIBCKPIB1.substring(GIBCKPIB1.length() - 2, GIBCKPIB1.length() - 1);
		String GIBCKPIB3 = GIBCKPIB1.substring(0, GIBCKPIB1.length() - 3);
		VIPSalesPage.contents.GIBCKPIB.verifyText(GIBCKPIB3 + "." + GIBCKPIB2 + "%");}
		else {VIPSalesPage.contents.GIBCKPIB.verifyText(GIBCKPIB1);}
		//Pay-TV connections market share​
		String PCMSKPIB1 = VIPSalesPage.contents.PCMSKPIB.getText();
		if (PCMSKPIB1 != "N/A") {
		String PCMSKPIB2 = PCMSKPIB1.substring(PCMSKPIB1.length() - 2, PCMSKPIB1.length() - 1);
		String PCMSKPIB3 = PCMSKPIB1.substring(0, PCMSKPIB1.length() - 3);
		VIPSalesPage.contents.PCMSKPIB.verifyText(PCMSKPIB3 + "." + PCMSKPIB2 + "%");}
		else {VIPSalesPage.contents.PCMSKPIB.verifyText(PCMSKPIB1);}
		//Growth in Pay-TV connections (YoY)​​
		String GIPCKPIB1 = VIPSalesPage.contents.GIPCKPIB.getText();
		if (GIPCKPIB1 != "N/A") {
		String GIPCKPIB2 = GIPCKPIB1.substring(GIPCKPIB1.length() - 2, GIPCKPIB1.length() - 1);
		String GIPCKPIB3 = GIPCKPIB1.substring(0, GIPCKPIB1.length() - 3);
		VIPSalesPage.contents.GIPCKPIB.verifyText(GIPCKPIB3 + "." + GIPCKPIB2 + "%");}
		else {VIPSalesPage.contents.GIPCKPIB.verifyText(GIPCKPIB1);}
		WebControl.takeScreenshot("Sales_Reg_Auto_031_Best");
		
		ReportLog.setTestCase("Sales_Reg_Auto_032");
		VIPSalesPage.contents.ViewCompetitors.click();
		VIPSalesPage.contents.CompetitorsPagePopUp.verifyDisplayed(true, 30);
		WebControl.takeScreenshot("Sales_Reg_Auto_032");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_033");
		VIPSalesPage.contents.CompetitorsPagePopUpTitle.verifyDisplayed(true, 30);
		WebControl.takeScreenshot("Sales_Reg_Auto_033");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_034");
		VIPSalesPage.contents.CompetitorsCompanyNameLbl.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsCompanyNameLbl.verifyText("Company Name");
		VIPSalesPage.contents.CompetitorsNoOfMobileLbl.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsNoOfMobileLbl.verifyText("Number of Mobile Connections ('000s)");
		VIPSalesPage.contents.CompetitorsNoOfBroadbandLbl.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsNoOfBroadbandLbl.verifyText("Number of Broadband Connections ('000s)");
		VIPSalesPage.contents.CompetitorsNoOfPayTVLbl.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsNoOfPayTVLbl.verifyText("Number of Pay-TV Connections ('000s)");
		WebControl.takeScreenshot("Sales_Reg_Auto_034");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_035");
		VIPSalesPage.contents.CompetitorsTarget.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsTargetName.verifyText("Vodafone Group Plc");
		VIPSalesPage.contents.CompetitorsTargetNMC.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsTargetNBC.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsTargetNPC.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeers.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeersName1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeersNMC1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeersNBC1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeersNPC1.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_035");
		
		ReportLog.setTestCase("Sales_Reg_Auto_033_Prep");
		String CompetitorsTargetName = VIPSalesPage.contents.CompetitorsTargetName.getText();
		String CompetitorsTargetNMC = VIPSalesPage.contents.CompetitorsTargetNMC.getText();
		String CompetitorsTargetNBC = VIPSalesPage.contents.CompetitorsTargetNBC.getText();
		String CompetitorsTargetNPC = VIPSalesPage.contents.CompetitorsTargetNPC.getText();
		String CompetitorsPeersName1 = VIPSalesPage.contents.CompetitorsPeersName1.getText();
		String CompetitorsPeersNMC1 = VIPSalesPage.contents.CompetitorsPeersNMC1.getText();
		String CompetitorsPeersNBC1 = VIPSalesPage.contents.CompetitorsPeersNBC1.getText();
		String CompetitorsPeersNPC1 = VIPSalesPage.contents.CompetitorsPeersNPC1.getText();
		String CompetitorsPeersName2 = VIPSalesPage.contents.CompetitorsPeersName2.getText();
		String CompetitorsPeersNMC2 = VIPSalesPage.contents.CompetitorsPeersNMC2.getText();
		String CompetitorsPeersNBC2 = VIPSalesPage.contents.CompetitorsPeersNBC2.getText();
		String CompetitorsPeersNPC2 = VIPSalesPage.contents.CompetitorsPeersNPC2.getText();
		String CompetitorsPeersName3 = VIPSalesPage.contents.CompetitorsPeersName3.getText();
		String CompetitorsPeersNMC3 = VIPSalesPage.contents.CompetitorsPeersNMC3.getText();
		String CompetitorsPeersNBC3 = VIPSalesPage.contents.CompetitorsPeersNBC3.getText();
		String CompetitorsPeersNPC3 = VIPSalesPage.contents.CompetitorsPeersNPC3.getText();
		String CompetitorsPeersName4 = VIPSalesPage.contents.CompetitorsPeersName4.getText();
		String CompetitorsPeersNMC4 = VIPSalesPage.contents.CompetitorsPeersNMC4.getText();
		String CompetitorsPeersNBC4 = VIPSalesPage.contents.CompetitorsPeersNBC4.getText();
		String CompetitorsPeersNPC4 = VIPSalesPage.contents.CompetitorsPeersNPC4.getText();
		String CompetitorsPeersName5 = VIPSalesPage.contents.CompetitorsPeersName5.getText();
		String CompetitorsPeersNMC5 = VIPSalesPage.contents.CompetitorsPeersNMC5.getText();
		String CompetitorsPeersNBC5 = VIPSalesPage.contents.CompetitorsPeersNBC5.getText();
		String CompetitorsPeersNPC5 = VIPSalesPage.contents.CompetitorsPeersNPC5.getText();
		String CompetitorsPeersName6 = VIPSalesPage.contents.CompetitorsPeersName6.getText();
		String CompetitorsPeersNMC6 = VIPSalesPage.contents.CompetitorsPeersNMC6.getText();
		String CompetitorsPeersNBC6 = VIPSalesPage.contents.CompetitorsPeersNBC6.getText();
		String CompetitorsPeersNPC6 = VIPSalesPage.contents.CompetitorsPeersNPC6.getText();
		String CompetitorsPeersName7 = VIPSalesPage.contents.CompetitorsPeersName7.getText();
		String CompetitorsPeersNMC7 = VIPSalesPage.contents.CompetitorsPeersNMC7.getText();
		String CompetitorsPeersNBC7 = VIPSalesPage.contents.CompetitorsPeersNBC7.getText();
		String CompetitorsPeersNPC7 = VIPSalesPage.contents.CompetitorsPeersNPC7.getText();
		VIPSalesPage.contents.CloseCompetitorsPagePopUp.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_033_Prep");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_036_to_042");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(1500);
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
		Thread.sleep(2500);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.telcoCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.MCMSKPI.waitForExist(true, 25);
		VIPSalesPage.contents.MCMSKPI.verifyText(MCMSKPI1);
		VIPSalesPage.contents.GIMCKPI.verifyText(GIMCKPI1);
		VIPSalesPage.contents.ARPUKPI.verifyText(ARPUKPI1);
		VIPSalesPage.contents.CRKPI.verifyText(CRKPI1);
		VIPSalesPage.contents.BCMSKPI.verifyText(BCMSKPI1);
		VIPSalesPage.contents.GIBCKPI.verifyText(GIBCKPI1);
		VIPSalesPage.contents.PCMSKPI.verifyText(PCMSKPI1);
		VIPSalesPage.contents.GIPCKPI.verifyText(GIPCKPI1);
		VIPSalesPage.contents.MCMSKPIP.verifyText(MCMSKPIP1);
		VIPSalesPage.contents.GIMCKPIP.verifyText(GIMCKPIP1);
		VIPSalesPage.contents.ARPUKPIP.verifyText(ARPUKPIP1);
		VIPSalesPage.contents.CRKPIP.verifyText(CRKPIP1);
		VIPSalesPage.contents.BCMSKPIP.verifyText(BCMSKPIP1);
		VIPSalesPage.contents.GIBCKPIP.verifyText(GIBCKPIP1);
		VIPSalesPage.contents.PCMSKPIP.verifyText(PCMSKPIP1);
		VIPSalesPage.contents.GIPCKPIP.verifyText(GIPCKPIP1);
		VIPSalesPage.contents.MCMSKPIB.verifyText(MCMSKPIB1);
		VIPSalesPage.contents.GIMCKPIB.verifyText(GIMCKPIB1);
		VIPSalesPage.contents.ARPUKPIB.verifyText(ARPUKPIB1);
		VIPSalesPage.contents.CRKPIB.verifyText(CRKPIB1);
		VIPSalesPage.contents.BCMSKPIB.verifyText(BCMSKPIB1);
		VIPSalesPage.contents.GIBCKPIB.verifyText(GIBCKPIB1);
		VIPSalesPage.contents.PCMSKPIB.verifyText(PCMSKPIB1);
		VIPSalesPage.contents.GIPCKPIB.verifyText(GIPCKPIB1);
		VIPSalesPage.contents.FootNote.verifyText(FootNote);
		WebControl.takeScreenshot("Sales_Reg_Auto_036_to_042");
		
		ReportLog.setTestCase("Sales_Reg_Auto_033_Validation");
		VIPSalesPage.contents.ViewCompetitors.click();
		VIPSalesPage.contents.CompetitorsPagePopUp.verifyDisplayed(true, 30);
		VIPSalesPage.contents.CompetitorsPagePopUpTitle.verifyDisplayed(true, 30);
		VIPSalesPage.contents.CompetitorsTargetName.waitForExist(true, 30);
		VIPSalesPage.contents.CompetitorsTargetName.verifyText(CompetitorsTargetName);
		VIPSalesPage.contents.CompetitorsTargetNMC.verifyText(CompetitorsTargetNMC);
		VIPSalesPage.contents.CompetitorsTargetNBC.verifyText(CompetitorsTargetNBC);
		VIPSalesPage.contents.CompetitorsTargetNPC.verifyText(CompetitorsTargetNPC);
		VIPSalesPage.contents.CompetitorsPeersName1.verifyText(CompetitorsPeersName1);
		VIPSalesPage.contents.CompetitorsPeersNMC1.verifyText(CompetitorsPeersNMC1);
		VIPSalesPage.contents.CompetitorsPeersNBC1.verifyText(CompetitorsPeersNBC1);
		VIPSalesPage.contents.CompetitorsPeersNPC1.verifyText(CompetitorsPeersNPC1);
		VIPSalesPage.contents.CompetitorsPeersName2.verifyText(CompetitorsPeersName2);
		VIPSalesPage.contents.CompetitorsPeersNMC2.verifyText(CompetitorsPeersNMC2);
		VIPSalesPage.contents.CompetitorsPeersNBC2.verifyText(CompetitorsPeersNBC2);
		VIPSalesPage.contents.CompetitorsPeersNPC2.verifyText(CompetitorsPeersNPC2);
		VIPSalesPage.contents.CompetitorsPeersName3.verifyText(CompetitorsPeersName3);
		VIPSalesPage.contents.CompetitorsPeersNMC3.verifyText(CompetitorsPeersNMC3);
		VIPSalesPage.contents.CompetitorsPeersNBC3.verifyText(CompetitorsPeersNBC3);
		VIPSalesPage.contents.CompetitorsPeersNPC3.verifyText(CompetitorsPeersNPC3);
		VIPSalesPage.contents.CompetitorsPeersName4.verifyText(CompetitorsPeersName4);
		VIPSalesPage.contents.CompetitorsPeersNMC4.verifyText(CompetitorsPeersNMC4);
		VIPSalesPage.contents.CompetitorsPeersNBC4.verifyText(CompetitorsPeersNBC4);
		VIPSalesPage.contents.CompetitorsPeersNPC4.verifyText(CompetitorsPeersNPC4);
		VIPSalesPage.contents.CompetitorsPeersName5.verifyText(CompetitorsPeersName5);
		VIPSalesPage.contents.CompetitorsPeersNMC5.verifyText(CompetitorsPeersNMC5);
		VIPSalesPage.contents.CompetitorsPeersNBC5.verifyText(CompetitorsPeersNBC5);
		VIPSalesPage.contents.CompetitorsPeersNPC5.verifyText(CompetitorsPeersNPC5);
		VIPSalesPage.contents.CompetitorsPeersName6.verifyText(CompetitorsPeersName6);
		VIPSalesPage.contents.CompetitorsPeersNMC6.verifyText(CompetitorsPeersNMC6);
		VIPSalesPage.contents.CompetitorsPeersNBC6.verifyText(CompetitorsPeersNBC6);
		VIPSalesPage.contents.CompetitorsPeersNPC6.verifyText(CompetitorsPeersNPC6);
		VIPSalesPage.contents.CompetitorsPeersName7.verifyText(CompetitorsPeersName7);
		VIPSalesPage.contents.CompetitorsPeersNMC7.verifyText(CompetitorsPeersNMC7);
		VIPSalesPage.contents.CompetitorsPeersNBC7.verifyText(CompetitorsPeersNBC7);
		VIPSalesPage.contents.CompetitorsPeersNPC7.verifyText(CompetitorsPeersNPC7);
		VIPSalesPage.contents.CloseCompetitorsPagePopUp.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_033_Validation");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
		ReportLog.setTestCase("Sales_Reg_Auto_043");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.ClickSelectCountryDropdown.click();
		VIPSalesPage.contents.SelectGermany.click();
		VIPSalesPage.contents.FootNote.waitForExist(true, 15);
		VIPSalesPage.contents.FootNote.verifyText("Source: Analysys Mason; Accenture Client Value Services.\n" + 
		"Disclaimer: Analysys Mason content is to be used for Accenture business purposes only. If you use this material, you are responsible for reading and complying with the posted contract terms and conditions.\n" + 
		"Use within Accenture: You may use, copy, distribute and display portions of the deliverables for internal business purposes only by and among Accenture's employees globally, including employees of its affiliates. Please note that full reports may not be shared. The following statement must be included with each quote or excerpt: © Analysys Mason. Insert report title and date.\n" + 
		"Use outside Accenture: The Analysys Mason deliverables are prepared for Accenture's internal use and cannot be distributed in whole or in part outside of the company without the prior written consent of Analysys Mason.");
		WebControl.takeScreenshot("Sales_Reg_Auto_043");
		
		ReportLog.setTestCase("Sales_Reg_Auto_044");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("NZSE:CNU");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.Message.verifyDisplayed(true, 15);
		VIPSalesPage.contents.Message.verifyText("No Information Available.");
		WebControl.takeScreenshot("Sales_Reg_Auto_044");
		
		ReportLog.setTestCase("Sales_Reg_Auto_045");
		VIPOverviewPage.contents.BackToSearchButton2.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.Message.verifyDisplayed(true, 15);
		VIPSalesPage.contents.Message.verifyText("Coming Soon – Industry Specific Operating KPIs.");
		WebControl.takeScreenshot("Sales_Reg_Auto_045");
			
	}
	
	@Test(priority=6)
	public void Sales_CGSKPIs () throws Exception {
		ReportLog.setTestName("Sales Leadership - CG&S KPIs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_101");	
		VIPOverviewPage.contents.BackToSearchButton2.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.cgsCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText.verifyText("INDUSTRY OPERATING METRICS\n" + "NEW");
		//VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText2.verifyText("NEW");
		//VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText2.verifyCssValue("color", "rgba(165, 0, 0, 1)");
		WebControl.takeScreenshot("Sales_Reg_Auto_101");
		
		ReportLog.setTestCase("Sales_Reg_Auto_102");
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CGSHeatMap.waitForExist(true, 15);
		WebControl.takeScreenshot("Sales_Reg_Auto_102");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_103");
		VIPSalesPage.contents.CGSToggleSlider.verifyDisplayed(true);
		VIPSalesPage.contents.CGSToggleLabel.verifyText("View Detailed Comparison");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSSelectIndustryDropdown.waitForExist(true, 15);
		WebControl.takeScreenshot("Sales_Reg_Auto_103");
		
		ReportLog.setTestCase("Sales_Reg_Auto_104");
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.waitForExist(true, 10);
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyText("Industry Operating Metrics - Consumer Goods and Services");
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyCssValue("font-weight", "900");
		WebControl.takeScreenshot("Sales_Reg_Auto_104");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_105");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 5);
		String TimeFrame1 = VIPSalesPage.contents.CGSMarketShareText.getText();
		String[] TimeFrame2 = TimeFrame1.split("\\s");
		String TimeFrame = TimeFrame2[TimeFrame2.length - 1];
		VIPSalesPage.contents.CGSMarketShareText.verifyText(testDataHandler.cgsCompany + "'s market share comparison summary, by value " + TimeFrame);
		WebControl.takeScreenshot("Sales_Reg_Auto_105");
		
		ReportLog.setTestCase("Sales_Reg_Auto_106");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Beijing Yanjing Brewery");
		Thread.sleep(1500);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Beijing Yanjing Brewery Co.,Ltd.'s market share comparison summary, by value [2018]");
		WebControl.takeScreenshot("Sales_Reg_Auto_106");
		
		ReportLog.setTestCase("Sales_Reg_Auto_144");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSPieChartHeader.waitForExist(true, 10);
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL ALCOHOLIC BEVERAGES MARKET SIZE BY REGION [2018]");
		WebControl.takeScreenshot("Sales_Reg_Auto_144");
		
		ReportLog.setTestCase("Sales_Reg_Auto_114");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSFootnoteH.waitForExist(true, 10);
		VIPSalesPage.contents.CGSFootnoteH.verifyText("Note: Alcoholic Beverages data is present as of 2018 and change represents 2018 vs 2017; Market size and share based on the retail price of product paid by consumer.");
		VIPOverviewPage.contents.BackToSearchButton2.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.cgsCompany);
		Thread.sleep(1500);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.CGSCategory1.waitForExist(true, 10);
		String CGSCategory1 = VIPSalesPage.contents.CGSCategory1.getText();
		String CGSCategory2 = VIPSalesPage.contents.CGSCategory2.getText();
		String CGSCategory3 = VIPSalesPage.contents.CGSCategory3.getText();
		String CGSCategory4 = VIPSalesPage.contents.CGSCategory4.getText();
		String CGSCategory5 = VIPSalesPage.contents.CGSCategory5.getText();
		String CGSCategory6 = VIPSalesPage.contents.CGSCategory6.getText();
		if (CGSCategory1.equals("ALCOHOLIC BEVERAGES") | CGSCategory2.equals("ALCOHOLIC BEVERAGES")
		  | CGSCategory3.equals("ALCOHOLIC BEVERAGES") | CGSCategory4.equals("ALCOHOLIC BEVERAGES")
		  | CGSCategory5.equals("ALCOHOLIC BEVERAGES") | CGSCategory6.equals("ALCOHOLIC BEVERAGES"))  {
		VIPSalesPage.contents.CGSFootnoteH.verifyText("Note: Alcoholic Beverages data is present as of 2018 and change represents 2018 vs 2017; Market size and share based on the retail price of product paid by consumer.");}
		else {VIPSalesPage.contents.CGSFootnoteH.verifyText("Note: Market size and share based on the retail price of product paid by consumer.");}
		WebControl.takeScreenshot("Sales_Reg_Auto_114");
		
		ReportLog.setTestCase("Sales_Reg_Auto_115");
		VIPSalesPage.contents.CGSSourceH.verifyText("Source: GlobalData; Accenture Client Value Services.");
		WebControl.takeScreenshot("Sales_Reg_Auto_115");
		
		ReportLog.setTestCase("Sales_Reg_Auto_110");
		VIPSalesPage.contents.CGSTop5LegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.CGSTop5LegendIcon.verifyCssValue("background-color", "rgba(70, 0, 115, 1)");
		VIPSalesPage.contents.CGSTop5LegendText.verifyText("Target is in Top 5");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.CGSTop10LegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.CGSTop10LegendIcon.verifyCssValue("background-color", "rgba(161, 0, 255, 1)");
		VIPSalesPage.contents.CGSTop10LegendText.verifyText("Target is in Top 10");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("font-size", "10px");
		WebControl.takeScreenshot("Sales_Reg_Auto_110");
		
		ReportLog.setTestCase("Sales_Reg_Auto_111");
		VIPSalesPage.contents.CGSIncreasedLegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.CGSIncreasedLegendIcon.verifyCssValue("border-bottom", "0px none rgb(92, 92, 92)");
		VIPSalesPage.contents.CGSIncreasedLegendText.verifyText("Increased vs 2017");
		VIPSalesPage.contents.CGSIncreasedLegendText.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CGSIncreasedLegendText.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CGSIncreasedLegendText.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.CGSDecreasedLegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.CGSDecreasedLegendIcon.verifyCssValue("border-top", "0px none rgb(92, 92, 92)");
		VIPSalesPage.contents.CGSDecreasedLegendText.verifyText("Decreased vs 2017");
		VIPSalesPage.contents.CGSDecreasedLegendText.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CGSDecreasedLegendText.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CGSDecreasedLegendText.verifyCssValue("font-size", "10px");
		WebControl.takeScreenshot("Sales_Reg_Auto_111");
		
		ReportLog.setTestCase("Sales_Reg_Auto_117");
		VIPSalesPage.contents.CGSToggleSlider.verifyDisplayed(true);
		VIPSalesPage.contents.CGSToggleLabel.verifyText("View Detailed Comparison");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSSelectIndustryDropdown.waitForExist(true, 15);
		WebControl.takeScreenshot("Sales_Reg_Auto_117");
		
		ReportLog.setTestCase("Sales_Reg_Auto_118");
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.waitForExist(true, 10);
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyText("Industry Operating Metrics - Consumer Goods and Services");
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyCssValue("font-weight", "900");
		WebControl.takeScreenshot("Sales_Reg_Auto_118");
		
		ReportLog.setTestCase("Sales_Reg_Auto_119");
		String CGSSelectedIndustry = VIPSalesPage.contents.CGSSelectedIndustry.getText();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Market share trend and peer comparison in " + CGSSelectedIndustry + " industry");
		VIPSalesPage.contents.CGSSelectSectorDropdown.click();
		VIPSalesPage.contents.CGSSectorMenu2.click();
		Thread.sleep(1000);
		String CGSSelectedSector = VIPSalesPage.contents.CGSSelectedSector.getText();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Market share trend and peer comparison in " + CGSSelectedSector + " sector");
		VIPSalesPage.contents.CGSSelectCategoryDropdown.click();
		VIPSalesPage.contents.CGSCategoryMenu2.click();
		Thread.sleep(1000);
		String CGSSelectedCategory = VIPSalesPage.contents.CGSSelectedCategory.getText();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Market share trend and peer comparison in " + CGSSelectedCategory + " category");
		VIPSalesPage.contents.CGSSelectRegionDropdown.click();
		VIPSalesPage.contents.CGSRegionMenu2.click();
		VIPSalesPage.contents.CGSSelectCountryDropdown.click();
		VIPSalesPage.contents.CGSCountryMenu2.click();
		Thread.sleep(1000);
		String CGSSelectedCountry = VIPSalesPage.contents.CGSSelectedCountry.getText();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Market share trend and peer comparison in " + CGSSelectedCategory + " category" + " in " + CGSSelectedCountry);
		WebControl.takeScreenshot("Sales_Reg_Auto_119");
		
		ReportLog.setTestCase("Sales_Reg_Auto_121");
		VIPSalesPage.contents.CGSSelectIndustryDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectIndustryDropdownLabel.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectSectorDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectSectorDropdownLabel.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectCategoryDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectCategoryDropdownLabel.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectRegionDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectRegionDropdownLabel.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectCountryDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectCountryDropdownLabel.verifyDisplayed(true);
		if (CGSSelectedIndustry.equals("Alcoholic Beverages") | CGSSelectedIndustry.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSSelectMeasureDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectMeasureDropdownLabel.verifyDisplayed(true);}
		WebControl.takeScreenshot("Sales_Reg_Auto_121");
		
		ReportLog.setTestCase("Sales_Reg_Auto_122");
		VIPSalesPage.contents.CGSSelectIndustryDropdown.click();
		if (VIPSalesPage.contents.CGSIndustryMenuAlcoholic.isDisplayed()) {
		VIPSalesPage.contents.CGSIndustryMenuAlcoholic.click();
		VIPSalesPage.contents.CGSSelectMeasureDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectMeasureDropdownLabel.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.CGSIndustryMenuNonAlcoholic.isDisplayed()) {
		VIPSalesPage.contents.CGSIndustryMenuNonAlcoholic.click();
		VIPSalesPage.contents.CGSSelectMeasureDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectMeasureDropdownLabel.verifyDisplayed(true);}
		else {VIPSalesPage.contents.CGSSelectMeasureDropdown.verifyDisplayed(false);
		VIPSalesPage.contents.CGSSelectMeasureDropdownLabel.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_122");
		
		ReportLog.setTestCase("Sales_Reg_Auto_124");
		//Industry
		VIPSalesPage.contents.CGSSelectIndustryDropdown.click();
		String CGSIndustryMenu1 = VIPSalesPage.contents.CGSIndustryMenu1.getText();
		VIPSalesPage.contents.CGSIndustryMenu1.click();
		VIPSalesPage.contents.CGSPieChart.verifyDisplayed(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSIndustryMenu1.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSIndustryMenu1.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		//Sector
		VIPSalesPage.contents.CGSSelectSectorDropdown.click();
		String CGSSectorMenu2 = VIPSalesPage.contents.CGSSectorMenu2.getText();
		VIPSalesPage.contents.CGSSectorMenu2.click();
		VIPSalesPage.contents.CGSPieChart.waitForExist(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSSectorMenu2.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSSectorMenu2.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		//Category
		VIPSalesPage.contents.CGSSelectCategoryDropdown.click();
		String CGSCategoryMenu2 = VIPSalesPage.contents.CGSCategoryMenu2.getText();
		VIPSalesPage.contents.CGSCategoryMenu2.click();
		VIPSalesPage.contents.CGSPieChart.waitForExist(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		//Region
		VIPSalesPage.contents.CGSSelectRegionDropdown.click();
		VIPSalesPage.contents.CGSRegionMenu2.click();
		VIPSalesPage.contents.CGSPieChart.waitForExist(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		//Country
		VIPSalesPage.contents.CGSSelectCountryDropdown.click();
		VIPSalesPage.contents.CGSCountryMenu2.click();
		VIPSalesPage.contents.CGSPieChart.waitForExist(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		WebControl.takeScreenshot("Sales_Reg_Auto_124");
		
		ReportLog.setTestCase("Sales_Reg_Auto_128");
		VIPSalesPage.contents.CGSSelectIndustryDropdown.click();
		VIPSalesPage.contents.CGSIndustryMenu1.click();
		VIPSalesPage.contents.CGSPieChartLegendColor1.verifyCssValue("background-color", "rgba(0, 0, 0, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText1.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue1.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor2.verifyCssValue("background-color", "rgba(117, 0, 192, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText2.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue2.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor3.verifyCssValue("background-color", "rgba(161, 0, 255, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText3.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue3.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor4.verifyCssValue("background-color", "rgba(182, 32, 224, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText4.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue4.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor5.verifyCssValue("background-color", "rgba(190, 130, 255, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText5.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue5.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor6.verifyCssValue("background-color", "rgba(220, 175, 255, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText6.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue6.verifyDisplayed(true); 
		if (VIPSalesPage.contents.CGSPieChartLegend7.isDisplayed()) {
		VIPSalesPage.contents.CGSPieChartLegendColor7.verifyCssValue("background-color", "rgba(170, 171, 173, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText7.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue7.verifyDisplayed(true);}
		else {VIPSalesPage.contents.CGSPieChartLegendColor7.verifyDisplayed(false);
		VIPSalesPage.contents.CGSPieChartLegendText7.verifyDisplayed(false);
		VIPSalesPage.contents.CGSPieChartLegendValue7.verifyDisplayed(false);}
		if (VIPSalesPage.contents.CGSPieChartLegend8.isDisplayed()) {
		VIPSalesPage.contents.CGSPieChartLegendColor8.verifyCssValue("background-color", "rgba(17, 209, 198, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText8.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue8.verifyDisplayed(true);}
		else {VIPSalesPage.contents.CGSPieChartLegendColor8.verifyDisplayed(false);
		VIPSalesPage.contents.CGSPieChartLegendText8.verifyDisplayed(false);
		VIPSalesPage.contents.CGSPieChartLegendValue8.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_128");
		
		ReportLog.setTestCase("Sales_Reg_Auto_129");
		VIPSalesPage.contents.CGSPieChart.verifyCssValue("background-color", "rgba(235, 235, 235, 1)");
		WebControl.takeScreenshot("Sales_Reg_Auto_129");
		
		ReportLog.setTestCase("Sales_Reg_Auto_130");
		VIPSalesPage.contents.CGSVerticalChart.verifyDisplayed(true, 10); 
		VIPSalesPage.contents.CGSVerticalChartHeader.verifyText("MARKET SHARE - GLOBAL");
		VIPSalesPage.contents.CGSSelectRegionDropdown.click();
		String CGSRegionMenu2 = VIPSalesPage.contents.CGSRegionMenu2.getText();
		VIPSalesPage.contents.CGSRegionMenu2.click();
		VIPSalesPage.contents.CGSVerticalChart.waitForExist(true, 10); 
		VIPSalesPage.contents.CGSVerticalChartHeader.verifyText("MARKET SHARE - " + CGSRegionMenu2.toUpperCase());
		VIPSalesPage.contents.CGSSelectCountryDropdown.click();
		String CGSCountryMenu2 = VIPSalesPage.contents.CGSCountryMenu2.getText();
		VIPSalesPage.contents.CGSCountryMenu2.click();
		VIPSalesPage.contents.CGSVerticalChart.waitForExist(true, 10); 
		VIPSalesPage.contents.CGSVerticalChartHeader.verifyText("MARKET SHARE - " + CGSCountryMenu2.toUpperCase());
		VIPSalesPage.contents.CGSSelectRegionDropdown.click();
		VIPSalesPage.contents.CGSRegionMenu1.click();
		VIPSalesPage.contents.CGSVerticalChart.waitForExist(true, 10); 
		VIPSalesPage.contents.CGSVerticalChartHeader.verifyText("MARKET SHARE - GLOBAL");
		WebControl.takeScreenshot("Sales_Reg_Auto_130");
		
		ReportLog.setTestCase("Sales_Reg_Auto_131");
		VIPSalesPage.contents.CGSVerticalChartSubHeader.verifyText("Click on the bars to view peer comparison for each year");
		WebControl.takeScreenshot("Sales_Reg_Auto_131");
		
		ReportLog.setTestCase("Sales_Reg_Auto_134");
		WebControl1.ClickByCoordinates_VerticalChart(424, 750, 1, "//*[@class='vertical-chart-div']//canvas");
		Thread.sleep(1500);
		VIPSalesPage.contents.CGSHorizontalChartHeader.verifyText("TOP 10 PLAYERS BY MARKET SHARE\n" + "[2017]");
		WebControl1.ClickByCoordinates_VerticalChart(424, 750, 2, "//*[@class='vertical-chart-div']//canvas");
		Thread.sleep(1500);
		VIPSalesPage.contents.CGSHorizontalChartHeader.verifyText("TOP 10 PLAYERS BY MARKET SHARE\n" + "[2018]");
		WebControl1.ClickByCoordinates_VerticalChart(424, 750, 3, "//*[@class='vertical-chart-div']//canvas");
		Thread.sleep(1500);
		VIPSalesPage.contents.CGSHorizontalChartHeader.verifyText("TOP 10 PLAYERS BY MARKET SHARE\n" + "[2019]");
		WebControl.takeScreenshot("Sales_Reg_Auto_134");
		
		ReportLog.setTestCase("Sales_Reg_Auto_139");
		VIPSalesPage.contents.CGSSourceD.verifyText("Source: GlobalData; Accenture Client Value Services.");
		WebControl.takeScreenshot("Sales_Reg_Auto_139");
		
		ReportLog.setTestCase("Sales_Reg_Auto_141_&_142");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.cgsCompany);
		Thread.sleep(1500);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.CGSCategory1.waitForExist(true, 10);
		List<String> lList = new ArrayList<String>();
		if (VIPSalesPage.contents.CGSCategory1.isDisplayed()) {
		String Industry1 = VIPSalesPage.contents.CGSCategory1.getText();
		lList.add(Industry1);}
		if (VIPSalesPage.contents.CGSCategory2.isDisplayed()) {
		String Industry2 = VIPSalesPage.contents.CGSCategory2.getText();
		lList.add(Industry2);}
		if (VIPSalesPage.contents.CGSCategory3.isDisplayed()) {
		String Industry3 = VIPSalesPage.contents.CGSCategory3.getText();
		lList.add(Industry3);}
		if (VIPSalesPage.contents.CGSCategory4.isDisplayed()) {
		String Industry4 = VIPSalesPage.contents.CGSCategory4.getText();
		lList.add(Industry4);}
		if (VIPSalesPage.contents.CGSCategory5.isDisplayed()) {
		String Industry5 = VIPSalesPage.contents.CGSCategory5.getText();
		lList.add(Industry5);}
		if (VIPSalesPage.contents.CGSCategory6.isDisplayed()) {
		String Industry6 = VIPSalesPage.contents.CGSCategory6.getText();
		lList.add(Industry6);}
		Collections.sort(lList);
        String a1 = lList.get(0).toLowerCase();
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSSelectIndustryDropdown.waitForExist(true, 10);
		String[] input1 = a1.split("\\s");
		String output = input1[0].substring(0, 1).toUpperCase() + input1[0].substring(1) +
		" " + input1[1].substring(0, 1).toUpperCase() + input1[1].substring(1);
		VIPSalesPage.contents.CGSSelectedIndustry.verifyText(output);
		VIPSalesPage.contents.CGSSelectedSector.verifyText("All");
		VIPSalesPage.contents.CGSSelectedCategory.verifyText("All");
		VIPSalesPage.contents.CGSSelectedRegion.verifyText("Global");
		VIPSalesPage.contents.CGSSelectedCountry.verifyText("All");
		WebControl.takeScreenshot("Sales_Reg_Auto_141_&_142");
		
		ReportLog.setTestCase("Sales_Reg_Auto_146");
		VIPSalesPage.contents.CGSSourceD.verifyText("Source: GlobalData; Accenture Client Value Services.");
		WebControl.takeScreenshot("Sales_Reg_Auto_146");
		
	}
	
	@Test(priority=7)
	public void Sales_RetailKPIs () throws Exception {
		ReportLog.setTestName("Sales Leadership - Retail KPIs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_191");	
		VIPOverviewPage.contents.BackToSearchButton2.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.retailCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText.verifyText("INDUSTRY OPERATING METRICS\n" + "NEW");
		//VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText2.verifyText("NEW");
		//VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText2.verifyCssValue("color", "rgba(165, 0, 0, 1)");
		WebControl.takeScreenshot("Sales_Reg_Auto_191");
		
		ReportLog.setTestCase("Sales_Reg_Auto_192");
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailHeatMap.waitForExist(true, 15);
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.waitForExist(true, 10);
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyText("Industry Operating Metrics - Retail");
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyCssValue("font-weight", "900");
		WebControl.takeScreenshot("Sales_Reg_Auto_192");
		
		ReportLog.setTestCase("Sales_Reg_Auto_193");
		VIPSalesPage.contents.RetailSelectDropdown1.verifyDisplayed(true, 10);
		VIPSalesPage.contents.RetailSelectDropdownLabel1.verifyText("Select Dashboard");
		VIPSalesPage.contents.RetailSelectDropdown2.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSelectDropdownLabel2.verifyText("Select Indicator");
		WebControl.takeScreenshot("Sales_Reg_Auto_193");
		
		ReportLog.setTestCase("Sales_Reg_Auto_194");
		VIPSalesPage.contents.RetailSelectedMenu1.verifyText("Market Share Heatmap");
		VIPSalesPage.contents.RetailSelectDropdown1.click();
		VIPSalesPage.contents.RetailSelectDashboardMenu1.verifyText("Market Share Heatmap");
		VIPSalesPage.contents.RetailSelectDashboardMenu2.verifyText("Market Share Analysis");
		VIPSalesPage.contents.RetailSelectDashboardMenu3.verifyText("Online vs. Offline Sales");
		VIPSalesPage.contents.RetailSelectDashboardMenu4.verifyText("Store Productivity");
		VIPSalesPage.contents.RetailSelectDashboardMenu5.verifyText("Same Store Sales Growth");
		WebControl.takeScreenshot("Sales_Reg_Auto_194");
		
		ReportLog.setTestCase("Sales_Reg_Auto_195");
		VIPSalesPage.contents.RetailSelectedMenu2.verifyText("Segment Sales");
		VIPSalesPage.contents.RetailSelectDropdown2.click();
		VIPSalesPage.contents.RetailSelectIndicatorMenu1.verifyText("Segment Sales");
		VIPSalesPage.contents.RetailSelectIndicatorMenu2.verifyText("Category Sales");
		WebControl.takeScreenshot("Sales_Reg_Auto_195");
		
		ReportLog.setTestCase("Sales_Reg_Auto_206_Segment Sales");
		VIPSalesPage.contents.CompetitivePositioningLegend.verifyText("Competitive Positioning");
		VIPSalesPage.contents.CompetitivePositioningLegend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CompetitivePositioningLegend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CompetitivePositioningLegend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.BottomQuartileLegend.verifyText("Bottom Quartile");
		VIPSalesPage.contents.BottomQuartileLegend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.BottomQuartileLegend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.BottomQuartileLegend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.TopQuartileLegend.verifyText("Top Quartile");
		VIPSalesPage.contents.TopQuartileLegend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.TopQuartileLegend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.TopQuartileLegend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.Quartile4Legend.verifyDisplayed(true);
		VIPSalesPage.contents.Quartile4Legend.verifyCssValue("background-color", "rgba(195, 96, 253, 1)");
		VIPSalesPage.contents.Quartile3Legend.verifyDisplayed(true);
		VIPSalesPage.contents.Quartile3Legend.verifyCssValue("background-color", "rgba(161, 0, 255, 1)");
		VIPSalesPage.contents.Quartile2Legend.verifyDisplayed(true);
		VIPSalesPage.contents.Quartile2Legend.verifyCssValue("background-color", "rgba(117, 0, 192, 1)");
		VIPSalesPage.contents.Quartile1Legend.verifyDisplayed(true);
		VIPSalesPage.contents.Quartile1Legend.verifyCssValue("background-color", "rgba(70, 0, 115, 1)");
		WebControl.takeScreenshot("Sales_Reg_Auto_206_Segment Sales");
		
		ReportLog.setTestCase("Sales_Reg_Auto_207_Segment Sales");
		VIPSalesPage.contents.Increasedvs2017Legend.verifyText("Increased vs 2017");
		VIPSalesPage.contents.Increasedvs2017Legend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.Increasedvs2017Legend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.Increasedvs2017Legend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.Increasedvs2017LegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.Increasedvs2017LegendIcon.verifyCssValue("border-bottom", "10px solid rgb(184, 222, 112)");
		VIPSalesPage.contents.Decreasedvs2017Legend.verifyText("Decreased vs 2017");
		VIPSalesPage.contents.Decreasedvs2017Legend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.Decreasedvs2017Legend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.Decreasedvs2017Legend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.Decreasedvs2017LegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.Decreasedvs2017LegendIcon.verifyCssValue("border-top", "10px solid rgb(227, 107, 95)");
		VIPSalesPage.contents.Constantvs2017Legend.verifyText("Constant vs 2017");
		VIPSalesPage.contents.Constantvs2017Legend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.Constantvs2017Legend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.Constantvs2017Legend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.Constantvs2017LegendIcon.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_207_Segment Sales");
		
		ReportLog.setTestCase("Sales_Reg_Auto_208_Segment Sales");
		VIPSalesPage.contents.RetailFootnote.verifyText("Note: Market size and share based on the retail price of product paid by consumer.");
		WebControl.takeScreenshot("Sales_Reg_Auto_208_Segment Sales");
		
		ReportLog.setTestCase("Sales_Reg_Auto_206_Category Sales");
		VIPSalesPage.contents.RetailSelectIndicatorMenu2.click();
		VIPSalesPage.contents.CompetitivePositioningLegend.waitForExist(true, 20);
		VIPSalesPage.contents.CompetitivePositioningLegend.verifyText("Competitive Positioning");
		VIPSalesPage.contents.CompetitivePositioningLegend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CompetitivePositioningLegend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CompetitivePositioningLegend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.BottomQuartileLegend.verifyText("Bottom Quartile");
		VIPSalesPage.contents.BottomQuartileLegend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.BottomQuartileLegend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.BottomQuartileLegend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.TopQuartileLegend.verifyText("Top Quartile");
		VIPSalesPage.contents.TopQuartileLegend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.TopQuartileLegend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.TopQuartileLegend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.Quartile4Legend.verifyDisplayed(true);
		VIPSalesPage.contents.Quartile4Legend.verifyCssValue("background-color", "rgba(195, 96, 253, 1)");
		VIPSalesPage.contents.Quartile3Legend.verifyDisplayed(true);
		VIPSalesPage.contents.Quartile3Legend.verifyCssValue("background-color", "rgba(161, 0, 255, 1)");
		VIPSalesPage.contents.Quartile2Legend.verifyDisplayed(true);
		VIPSalesPage.contents.Quartile2Legend.verifyCssValue("background-color", "rgba(117, 0, 192, 1)");
		VIPSalesPage.contents.Quartile1Legend.verifyDisplayed(true);
		VIPSalesPage.contents.Quartile1Legend.verifyCssValue("background-color", "rgba(70, 0, 115, 1)");
		WebControl.takeScreenshot("Sales_Reg_Auto_206_Category Sales");
		
		ReportLog.setTestCase("Sales_Reg_Auto_207_Category Sales");
		VIPSalesPage.contents.Increasedvs2017Legend.verifyText("Increased vs 2017");
		VIPSalesPage.contents.Increasedvs2017Legend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.Increasedvs2017Legend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.Increasedvs2017Legend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.Increasedvs2017LegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.Increasedvs2017LegendIcon.verifyCssValue("border-bottom", "10px solid rgb(184, 222, 112)");
		VIPSalesPage.contents.Decreasedvs2017Legend.verifyText("Decreased vs 2017");
		VIPSalesPage.contents.Decreasedvs2017Legend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.Decreasedvs2017Legend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.Decreasedvs2017Legend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.Decreasedvs2017LegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.Decreasedvs2017LegendIcon.verifyCssValue("border-top", "10px solid rgb(227, 107, 95)");
		VIPSalesPage.contents.Constantvs2017Legend.verifyText("Constant vs 2017");
		VIPSalesPage.contents.Constantvs2017Legend.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.Constantvs2017Legend.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.Constantvs2017Legend.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.Constantvs2017LegendIcon.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_207_Category Sales");
		
		ReportLog.setTestCase("Sales_Reg_Auto_208_Category Sales");
		VIPSalesPage.contents.RetailFootnote.verifyText("Note: Market size and share based on the retail price of product paid by consumer.");
		WebControl.takeScreenshot("Sales_Reg_Auto_208_Category Sales");
		
		ReportLog.setTestCase("Sales_Reg_Auto_209");
		VIPSalesPage.contents.RetailSelectDropdown1.click();
		VIPSalesPage.contents.RetailSelectDashboardMenu2.click();
		VIPSalesPage.contents.RetailSelectDropdown5.waitForExist(true, 15);
		VIPSalesPage.contents.RetailSelectDropdown2.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSelectDropdown3.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSelectDropdown4.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSelectDropdown5.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSelectDropdownLabel2.verifyText("Select Region");
		VIPSalesPage.contents.RetailSelectDropdownLabel3.verifyText("Select Country");
		VIPSalesPage.contents.RetailSelectDropdownLabel4.verifyText("Select Segment");
		VIPSalesPage.contents.RetailSelectDropdownLabel5.verifyText("Select Category");
		WebControl.takeScreenshot("Sales_Reg_Auto_209");
		
		ReportLog.setTestCase("Sales_Reg_Auto_213");
		VIPSalesPage.contents.RetailFirstChartSubHeader.waitForExist(true, 15);
		VIPSalesPage.contents.RetailFirstChartSubHeader.verifyText("Click on the bars to view peer data");
		WebControl.takeScreenshot("Sales_Reg_Auto_213");
		
		ReportLog.setTestCase("Sales_Reg_Auto_215");
		VIPSalesPage.contents.RetailSecondChartHeader.verifyText("MARKET SHARE TREND\n" + testDataHandler.retailCompany + "\n" + "[2017 - 2019]");
		VIPSalesPage.contents.RetailSecondChartCompany.verifyText(testDataHandler.retailCompany);
		VIPSalesPage.contents.RetailSecondChartYear.verifyText("[2017 - 2019]");
		WebControl1.ClickByCoordinates_HorizontalChart(472, 600, 11, 1, "//*[@class='vertical-chart-div']//canvas");
		VIPSalesPage.contents.RetailKIBestInClass.waitForExist(true, 10);
		String[] BestInClass = VIPSalesPage.contents.RetailKIBestInClass.getText().split("has");
		VIPSalesPage.contents.RetailSecondChartHeader.verifyText("MARKET SHARE TREND\n" + BestInClass[0].substring(0, BestInClass[0].length() - 1) + "\n" + "[2017 - 2019]");
		VIPSalesPage.contents.RetailSecondChartCompany.verifyText(BestInClass[0].substring(0, BestInClass[0].length() - 1));
		VIPSalesPage.contents.RetailSecondChartYear.verifyText("[2017 - 2019]");
		WebControl.takeScreenshot("Sales_Reg_Auto_215");
		
		ReportLog.setTestCase("Sales_Reg_Auto_218");
		VIPSalesPage.contents.RetailThirdChart.verifyDisplayed(true);
		VIPSalesPage.contents.RetailThirdChartSBCTab.verifyText("SALES BY CATEGORY");
		VIPSalesPage.contents.RetailThirdChartSBSTab.verifyText("SALES BY SEGMENT");
		VIPSalesPage.contents.RetailThirdChartBG.verifyCssValue("background-color", "rgba(235, 235, 235, 1)");
		WebControl.takeScreenshot("Sales_Reg_Auto_218");
		
		ReportLog.setTestCase("Sales_Reg_Auto_219");
		VIPSalesPage.contents.RetailThirdChartYear.verifyText("[2019]");
		WebControl.takeScreenshot("Sales_Reg_Auto_219");
		
		ReportLog.setTestCase("Sales_Reg_Auto_221");
		VIPSalesPage.contents.RetailSelectedMenu2.verifyText("Global");
		VIPSalesPage.contents.RetailSelectedMenu3.verifyText("All");
		VIPSalesPage.contents.RetailSelectedMenu4.verifyText("All");
		VIPSalesPage.contents.RetailSelectedMenu5.verifyText("All");
		WebControl.takeScreenshot("Sales_Reg_Auto_221");
		
		ReportLog.setTestCase("Sales_Reg_Auto_225");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailSelectDropdown1.click();
		VIPSalesPage.contents.RetailSelectDashboardMenu3.click();
		VIPSalesPage.contents.RetailSelectDropdown4.waitForExist(true, 15);
		VIPSalesPage.contents.RetailSelectDropdown2.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSelectDropdown3.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSelectDropdown4.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSelectDropdownLabel2.verifyText("Select Region");
		VIPSalesPage.contents.RetailSelectDropdownLabel3.verifyText("Select Country");
		VIPSalesPage.contents.RetailSelectDropdownLabel4.verifyText("Select Segment");
		WebControl.takeScreenshot("Sales_Reg_Auto_225");
		
		ReportLog.setTestCase("Sales_Reg_Auto_227");
		VIPSalesPage.contents.RetailOnlineOfflineVChartHeader.verifyText("ONLINE SALES AS OF % OF TOTAL SALES");
		VIPSalesPage.contents.RetailOnlineOfflineVChartTimePeriod.verifyText("[2019]");
		WebControl.takeScreenshot("Sales_Reg_Auto_227");
		
		ReportLog.setTestCase("Sales_Reg_Auto_231");
		VIPSalesPage.contents.RetailOnlineOfflineVChart.verifyCssValue("background-color", "rgba(255, 255, 255, 1)");
		VIPSalesPage.contents.RetailOnlineOfflineVChart.verifyCssValue("box-shadow", "rgba(198, 195, 195, 0.5) 2px 2px 8px 0px");
		WebControl.takeScreenshot("Sales_Reg_Auto_231");
		
		ReportLog.setTestCase("Sales_Reg_Auto_232");
		VIPSalesPage.contents.RetailOnlineOfflineHChartHeader.verifyText("TOP 10 PLAYERS BY ONLINE SALES %");
		VIPSalesPage.contents.RetailOnlineOfflineHChartTimePeriod.verifyText("[2019]");
		WebControl.takeScreenshot("Sales_Reg_Auto_232");
		
		ReportLog.setTestCase("Sales_Reg_Auto_235");
		VIPSalesPage.contents.RetailOnlineOfflineHChart.verifyCssValue("background-color", "rgba(255, 255, 255, 1)");
		VIPSalesPage.contents.RetailOnlineOfflineHChart.verifyCssValue("box-shadow", "rgba(198, 195, 195, 0.5) 2px 2px 8px 0px");
		WebControl.takeScreenshot("Sales_Reg_Auto_235");
		
		ReportLog.setTestCase("Sales_Reg_Auto_238");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailSelectDropdown1.click();
		VIPSalesPage.contents.RetailSelectDashboardMenu4.click();
		VIPSalesPage.contents.RetailStoreProductivityLChartHeader.waitForExist(true, 10);
		VIPSalesPage.contents.RetailStoreProductivityLChartHeader.verifyText("STORE AND SPACE PRODUCTIVITY\n" + "2017 - 2019");
		VIPSalesPage.contents.RetailStoreProductivityLChartHeader.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailStoreProductivityLChartHeader.verifyCssValue("color", "rgba(0, 0, 0, 1)");
		VIPSalesPage.contents.RetailStoreProductivityLChartHeader.verifyCssValue("font-size", "14px");
		VIPSalesPage.contents.RetailStoreProductivityLChartHeader.verifyCssValue("font-weight", "900");
		VIPSalesPage.contents.RetailStoreProductivityLChartHeader.verifyCssValue("text-align", "left");
		VIPSalesPage.contents.RetailStoreProductivityLChartSubHeader.verifyText("Click on the KPI box to view peer comparison");
		VIPSalesPage.contents.RetailStoreProductivityLChartSubHeader.verifyCssValue("color", "rgba(128, 128, 128, 1)");
		VIPSalesPage.contents.RetailStoreProductivityLChartSubHeader.verifyCssValue("font-size", "11.5px");
		WebControl.takeScreenshot("Sales_Reg_Auto_238");
		
		ReportLog.setTestCase("Sales_Reg_Auto_239_IN-STORE SALES");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		VIPOverviewPage.contents.RevenueValue.waitForExist(true, 15);
		String[] RevenueValue = VIPOverviewPage.contents.RevenueValue.getText().split("\\s");
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailSelectDropdown1.waitForExist(true, 15);
		VIPSalesPage.contents.RetailSelectDropdown1.click();
		VIPSalesPage.contents.RetailSelectDashboardMenu4.click();
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.waitForExist(true, 15);
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyText("IN-STORE SALES\n" + "[" + RevenueValue[0] + " mn]");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("font-size", "14px");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("font-weight", "900");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("text-align", "left");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("padding-top", "10px");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("padding-left", "10px");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("padding-right", "10px");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("display", "inline-block");
		VIPSalesPage.contents.RetailInStoreSalesChartHeader.verifyCssValue("position", "relative");
		WebControl.takeScreenshot("Sales_Reg_Auto_239_IN-STORE SALES");
		
		ReportLog.setTestCase("Sales_Reg_Auto_239_SALES PER STORE");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyText("SALES PER STORE [" + RevenueValue[0] + " mn]");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("font-size", "14px");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("font-weight", "900");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("text-align", "left");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("padding-top", "10px");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("padding-left", "10px");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("padding-right", "10px");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("display", "inline-block");
		VIPSalesPage.contents.RetailSalesPerStoreChartHeader.verifyCssValue("position", "relative");
		WebControl.takeScreenshot("Sales_Reg_Auto_239_SALES PER STORE");
		
		ReportLog.setTestCase("Sales_Reg_Auto_239_NUMBER OF STORES");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyText("NUMBER OF STORES");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("font-size", "14px");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("font-weight", "900");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("text-align", "left");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("padding-top", "10px");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("padding-left", "10px");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("padding-right", "10px");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("display", "inline-block");
		VIPSalesPage.contents.RetailNumberOfStoresChartHeader.verifyCssValue("position", "relative");
		WebControl.takeScreenshot("Sales_Reg_Auto_239_NUMBER OF STORES");
		
		ReportLog.setTestCase("Sales_Reg_Auto_239_SALES PER SELLING AREA");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyText("SALES PER SELLING AREA [" + RevenueValue[0] + "/Sq.Ft]");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("font-size", "14px");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("font-weight", "900");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("text-align", "left");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("padding-top", "10px");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("padding-left", "10px");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("padding-right", "10px");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("display", "inline-block");
		VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.verifyCssValue("position", "relative");
		WebControl.takeScreenshot("Sales_Reg_Auto_239_SALES PER SELLING AREA");
		
		ReportLog.setTestCase("Sales_Reg_Auto_239_AVERAGE STORE SIZE PER STORE");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyText("AVERAGE STORE SIZE PER STORE ['000 Sq.Ft]");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("font-size", "14px");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("font-weight", "900");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("text-align", "left");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("padding-top", "10px");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("padding-left", "10px");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("padding-right", "10px");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("display", "inline-block");
		VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.verifyCssValue("position", "relative");
		WebControl.takeScreenshot("Sales_Reg_Auto_239_AVERAGE STORE SIZE PER STORE");
		
		ReportLog.setTestCase("Sales_Reg_Auto_241_STORE PRODUCTIVITY");
		VIPSalesPage.contents.RetailStoreProductivityMainHeader.verifyText("STORE PRODUCTIVITY");
		VIPSalesPage.contents.RetailStoreProductivityMainHeader.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailStoreProductivityMainHeader.verifyCssValue("color", "rgba(117, 0, 192, 1)");
		VIPSalesPage.contents.RetailStoreProductivityMainHeader.verifyCssValue("font-size", "14px");
		VIPSalesPage.contents.RetailStoreProductivityMainHeader.verifyCssValue("font-weight", "900");
		VIPSalesPage.contents.RetailStoreProductivityMainHeader.verifyCssValue("top", "115px");
		VIPSalesPage.contents.RetailStoreProductivityMainHeader.verifyCssValue("position", "relative");
		VIPSalesPage.contents.RetailStoreProductivityMainHeader.verifyCssValue("left", "15px");
		VIPSalesPage.contents.RetailStoreProductivityMainHeader.verifyCssValue("letter-spacing", "0.5px");
		WebControl.takeScreenshot("Sales_Reg_Auto_241_STORE PRODUCTIVITY");
		
		ReportLog.setTestCase("Sales_Reg_Auto_241_SPACE PRODUCTIVITY");
		VIPSalesPage.contents.RetailSpaceProductivityMainHeader.verifyText("SPACE PRODUCTIVITY");
		VIPSalesPage.contents.RetailSpaceProductivityMainHeader.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailSpaceProductivityMainHeader.verifyCssValue("color", "rgba(117, 0, 192, 1)");
		VIPSalesPage.contents.RetailSpaceProductivityMainHeader.verifyCssValue("font-size", "14px");
		VIPSalesPage.contents.RetailSpaceProductivityMainHeader.verifyCssValue("font-weight", "900");
		VIPSalesPage.contents.RetailSpaceProductivityMainHeader.verifyCssValue("letter-spacing", "0.5px");
		WebControl.takeScreenshot("Sales_Reg_Auto_241_SPACE PRODUCTIVITY");
		
		ReportLog.setTestCase("Sales_Reg_Auto_241_STORE FORMAT");
		VIPSalesPage.contents.RetailStoreFormatMainHeader.verifyText("STORE FORMAT");
		VIPSalesPage.contents.RetailStoreFormatMainHeader.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailStoreFormatMainHeader.verifyCssValue("color", "rgba(117, 0, 192, 1)");
		VIPSalesPage.contents.RetailStoreFormatMainHeader.verifyCssValue("font-size", "14px");
		VIPSalesPage.contents.RetailStoreFormatMainHeader.verifyCssValue("font-weight", "900");
		VIPSalesPage.contents.RetailStoreFormatMainHeader.verifyCssValue("letter-spacing", "0.5px");
		WebControl.takeScreenshot("Sales_Reg_Auto_241_STORE FORMAT");
		
		ReportLog.setTestCase("Sales_Reg_Auto_242");
		VIPSalesPage.contents.RetailChartSymbolEquals1.verifyText("=");
		VIPSalesPage.contents.RetailChartSymbolEquals2.verifyText("=");
		VIPSalesPage.contents.RetailChartSymbolMultiply1.verifyText("x");
		VIPSalesPage.contents.RetailChartSymbolMultiply2.verifyText("x");
		WebControl.takeScreenshot("Sales_Reg_Auto_242");
		
		ReportLog.setTestCase("Sales_Reg_Auto_245_InStoreSales");
		String[] StoreProductivityLChartHeader1 = VIPSalesPage.contents.RetailStoreProductivityLChartHeader.getText().split("\\n");
		String[] StoreProductivityLChartHeader = StoreProductivityLChartHeader1[1].split("-");
		String[] InStoreSalesChartHeader = VIPSalesPage.contents.RetailInStoreSalesChartHeader.getText().split("\\n");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailInStoreSalesChart.click();
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.waitForExist(true, 10);
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.verifyText("TOP 10 PLAYERS BY " + InStoreSalesChartHeader[0].substring(0, InStoreSalesChartHeader[0].length()));
		VIPSalesPage.contents.RetailStoreProductivityRChart.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_245_InStoreSales");
		
		ReportLog.setTestCase("Sales_Reg_Auto_246_InStoreSales");
		VIPSalesPage.contents.RetailStoreProductivityRChartSubHeader.verifyText("[" + StoreProductivityLChartHeader[1].replace(" ", "") + ", " + InStoreSalesChartHeader[1].replace("[", ""));
		WebControl.takeScreenshot("Sales_Reg_Auto_246_InStoreSales");
		
		ReportLog.setTestCase("Sales_Reg_Auto_245_SalesPerStore");
		String[] SalesPerStoreChartHeader = VIPSalesPage.contents.RetailSalesPerStoreChartHeader.getText().split("\\[");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailSalesPerStoreChart.click();
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.waitForExist(true, 10);
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.verifyText("TOP 10 PLAYERS BY " + SalesPerStoreChartHeader[0].substring(0, SalesPerStoreChartHeader[0].length() - 1));
		VIPSalesPage.contents.RetailStoreProductivityRChart.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_245_SalesPerStore");
		
		ReportLog.setTestCase("Sales_Reg_Auto_246_SalesPerStore");
		VIPSalesPage.contents.RetailStoreProductivityRChartSubHeader.verifyText("[" + StoreProductivityLChartHeader[1].replace(" ", "") + ", " + SalesPerStoreChartHeader[1]);
		WebControl.takeScreenshot("Sales_Reg_Auto_246_SalesPerStore");
		
		ReportLog.setTestCase("Sales_Reg_Auto_245_NumberOfStores");
		String NumberOfStoresChartHeader = VIPSalesPage.contents.RetailNumberOfStoresChartHeader.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailNumberOfStoresChart.click();
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.waitForExist(true, 10);
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.verifyText("TOP 10 PLAYERS BY " + NumberOfStoresChartHeader);
		VIPSalesPage.contents.RetailStoreProductivityRChart.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_245_NumberOfStores");
		
		ReportLog.setTestCase("Sales_Reg_Auto_246_NumberOfStores");
		VIPSalesPage.contents.RetailStoreProductivityRChartSubHeader.verifyText("[" + StoreProductivityLChartHeader[1].replace(" ", "") + "]");
		WebControl.takeScreenshot("Sales_Reg_Auto_246_NumberOfStores");
		
		ReportLog.setTestCase("Sales_Reg_Auto_245_SalesPerSellingArea");
		String[] SalesPerSellingAreaChartHeader = VIPSalesPage.contents.RetailSalesPerSellingAreaChartHeader.getText().split("\\[");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailSalesPerSellingAreaChart.click();
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.waitForExist(true, 10);
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.verifyText("TOP 10 PLAYERS BY " + SalesPerSellingAreaChartHeader[0].substring(0, SalesPerSellingAreaChartHeader[0].length() - 1));
		VIPSalesPage.contents.RetailStoreProductivityRChart.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_245_SalesPerSellingArea");
		
		ReportLog.setTestCase("Sales_Reg_Auto_246_SalesPerSellingArea");
		VIPSalesPage.contents.RetailStoreProductivityRChartSubHeader.verifyText("[" + StoreProductivityLChartHeader[1].replace(" ", "") + ", " + SalesPerSellingAreaChartHeader[1]);
		WebControl.takeScreenshot("Sales_Reg_Auto_246_SalesPerSellingArea");
		
		ReportLog.setTestCase("Sales_Reg_Auto_245_AverageStoreSize");
		String[] AverageStoreSizeChartHeader = VIPSalesPage.contents.RetailAverageStoreSizeChartHeader.getText().split("\\[");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailAverageStoreSizeChart.click();
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.waitForExist(true, 10);
		VIPSalesPage.contents.RetailStoreProductivityRChartHeader.verifyText("TOP 10 PLAYERS BY " + AverageStoreSizeChartHeader[0].substring(0, AverageStoreSizeChartHeader[0].length() - 1));
		VIPSalesPage.contents.RetailStoreProductivityRChart.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_245_AverageStoreSize");
		
		ReportLog.setTestCase("Sales_Reg_Auto_246_AverageStoreSize");
		VIPSalesPage.contents.RetailStoreProductivityRChartSubHeader.verifyText("[" + StoreProductivityLChartHeader[1].replace(" ", "") + ", " + AverageStoreSizeChartHeader[1]);
		WebControl.takeScreenshot("Sales_Reg_Auto_246_AverageStoreSize");
		
		ReportLog.setTestCase("Sales_Reg_Auto_248_&_249");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.RetailSelectDropdown1.click();
		VIPSalesPage.contents.RetailSelectDashboardMenu5.click();
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartHeader.waitForExist(true, 10);
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartHeader.verifyText("SAME STORE SALES GROWTH");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartPeriod1.verifyText("2017");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChart1.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartPM1.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartPeriod2.verifyText("2018");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChart2.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartPM2.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartPeriod3.verifyText("2019");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChart3.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartPM3.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_248_&_249");
		
		ReportLog.setTestCase("Sales_Reg_Auto_250");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartLegendT.verifyText(testDataHandler.retailCompany);
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartLegendP.verifyText("Peer Median");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartLegendT.verifyCssValue("font-family", "Graphik");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartLegendT.verifyCssValue("font-size", "12px");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartLegendT.verifyCssValue("font-weight", "600");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartLegendT.verifyCssValue("color", "rgba(79, 79, 79, 1)");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartLegendIconT.verifyDisplayed(true);
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartLegendIconT.verifyCssValue("background-color", "rgba(161, 0, 255, 1)");
		VIPSalesPage.contents.RetailSameStoreSalesGrowthChartLegendIconP.verifyDisplayed(true);
		WebControl.takeScreenshot("Sales_Reg_Auto_250");
		
		ReportLog.setTestCase("Sales_Reg_Auto_254");
		VIPSalesPage.contents.RetailKeyInsightsHeader.verifyText("KEY INSIGHTS");
		VIPSalesPage.contents.RetailKeyInsightsHeader.verifyCssValue("color", "rgba(117, 0, 192, 1)");
		WebControl.takeScreenshot("Sales_Reg_Auto_254");
		
		ReportLog.setTestCase("Sales_Reg_Auto_255");
		VIPSalesPage.contents.RetailStandalonePerformanceHeader.verifyText("Standalone performance");
		VIPSalesPage.contents.RetailCompetitivePositionHeader.verifyText("Competitive position");
		VIPSalesPage.contents.RetailBestInClassHeader.verifyText("Best in class");
		WebControl.takeScreenshot("Sales_Reg_Auto_255");
		
		ReportLog.setTestCase("Sales_Reg_Auto_260_&_261");
		VIPSalesPage.contents.RetailFootnoteSource.verifyText("Note: Capital IQ data may not be strictly comparable with other dashboards;\n" + "Source: S&P Capital IQ; Accenture Client Value Services.");
		WebControl.takeScreenshot("Sales_Reg_Auto_260_&_261");
	
	}
	
	
	//@Test(priority=2)
	public void Sales_FinancialKPIs () throws Exception {
		ReportLog.setTestName("Sales Leadership - Financial KPIs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_018");		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Vodafone Group Plc");
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
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.FinancialKPIs.hover();
		VIPSalesPage.contents.FinancialKPIs.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_018");
		
//		ReportLog.setTestCase("Sales_Reg_Auto_019");
//		VIPSalesPage.contents.DEPSTooltipIcon.verifyDisplayed(true, 60);
//		VIPSalesPage.contents.DEPSTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.DEPSTooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_1");
//		VIPSalesPage.contents.DEPSTooltipIcon.click();
//		VIPSalesPage.contents.NPPERTooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.NPPERTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.NPPERTooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_2");
//		VIPSalesPage.contents.NPPERTooltipIcon.click();
//		VIPSalesPage.contents.DSOTooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.DSOTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.DSOTooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_3");
//		VIPSalesPage.contents.DSOTooltipIcon.click();
//		VIPSalesPage.contents.DIOTooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.DIOTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.DIOTooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_4");
//		VIPSalesPage.contents.DIOTooltipIcon.click();
//		VIPSalesPage.contents.DPOTooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.DPOTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.DPOTooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_5");
//		VIPSalesPage.contents.DPOTooltipIcon.click();
//		VIPSalesPage.contents.CCDTooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.CCDTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.CCDTooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_6");
//		VIPSalesPage.contents.CCDTooltipIcon.click();
//		VIPSalesPage.contents.NDFCFTooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.NDFCFTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText("Net Debt/FCF is a measurement of leverage and it measures how many years it would take a company to repay its debt if it devoted all its cashflows for it. It is calculated as = (Total Debt - Short Term Investments) / Free Cash Flow.");
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_7");
//		VIPSalesPage.contents.NDFCFTooltipIcon.click();
//		VIPSalesPage.contents.NDEBITDATooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.NDEBITDATooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.NDEBITDATooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_8");
//		VIPSalesPage.contents.NDEBITDATooltipIcon.click();
//		VIPSalesPage.contents.TDETooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.TDETooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.TDETooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_9");
//		VIPSalesPage.contents.TDETooltipIcon.click();
//		VIPSalesPage.contents.ICTooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.ICTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.ICTooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_10");
//		VIPSalesPage.contents.ICTooltipIcon.click();
//		VIPSalesPage.contents.EVREVTooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.EVREVTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText("EV/Revenue is a valuation that compares company’s Operating EV (Enterprise Value) to its annual sales. EV/Revenue is commonly used for early-stage or high-growth businesses that don’t have positive earnings yet. EV is calculated as = (Net Debt + Market Capitalization + Minority Interest + Preferred Equity - Long-Term Investments in JVs and Associates).");
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_11");
//		VIPSalesPage.contents.EVREVTooltipIcon.click();
//		VIPSalesPage.contents.EVEBITTooltipIcon.verifyDisplayed(true, 3);
//		VIPSalesPage.contents.EVEBITTooltipIcon.click();
//		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.EVEBITTooltip);
//		WebControl.takeScreenshot("Sales_Reg_Auto_019_12");
//		VIPSalesPage.contents.EVEBITTooltipIcon.click();
		
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
		
		ReportLog.setTestCase("Sales_Reg_Auto_020");
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
		WebControl.takeScreenshot("Sales_Reg_Auto_020");
		
		ReportLog.setTestCase("Sales_Reg_Auto_021");
		VIPSalesPage.contents.PercentileHeaderTooltip.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompanyHeaderTooltip.verifyDisplayed(true, 3);
		VIPSalesPage.contents.BestHeaderTooltip.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_021");
		
		ReportLog.setTestCase("Sales_Reg_Auto_023");
		VIPSalesPage.contents.RevenueCAGR5Yr.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RevenueCAGR5Yr.verifyText("5-year Revenue CAGR");
		VIPSalesPage.contents.RevenueCAGR3Yr.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RevenueCAGR3Yr.verifyText("3-year Revenue CAGR");
		VIPSalesPage.contents.RevenueCAGR1Yr.verifyDisplayed(true, 5);
		VIPSalesPage.contents.RevenueCAGR1Yr.verifyText("1-year Revenue CAGR");
		WebControl.takeScreenshot("Sales_Reg_Auto_023");
		
		ReportLog.setTestCase("Sales_Reg_Auto_024");
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
		WebControl.takeScreenshot("Sales_Reg_Auto_024");
		
		ReportLog.setTestCase("Sales_Reg_Auto_025");
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
		WebControl.takeScreenshot("Sales_Reg_Auto_025");
		
		ReportLog.setTestCase("Sales_Reg_Auto_026");
		VIPSalesPage.contents.NetDebtFCF.verifyDisplayed(true, 5);
		VIPSalesPage.contents.NetDebtFCF.verifyText("Net Debt / FCF");
		VIPSalesPage.contents.NetDebt.verifyDisplayed(true, 5);
		VIPSalesPage.contents.NetDebt.verifyText("Net Debt / EBITDA");
		VIPSalesPage.contents.TotalDebt.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TotalDebt.verifyText("Total Debt / Equity");
		VIPSalesPage.contents.InterestCoverage.verifyDisplayed(true, 5);
		VIPSalesPage.contents.InterestCoverage.verifyText("Interest Coverage");
		WebControl.takeScreenshot("Sales_Reg_Auto_026");
		
		ReportLog.setTestCase("Sales_Reg_Auto_027");
		VIPSalesPage.contents.EVREV.verifyDisplayed(true, 5);
		VIPSalesPage.contents.EVREV.verifyText("EV / Revenue");
		VIPSalesPage.contents.EVEBIT.verifyDisplayed(true, 5);
		VIPSalesPage.contents.EVEBIT.verifyText("EV / EBIT");
		WebControl.takeScreenshot("Sales_Reg_Auto_027");
		
		ReportLog.setTestCase("Sales_Reg_Auto_028");
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
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown7.click();
		String RPE1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] RPE2 = RPE1.split("\\s");
		String RPE = RPE2[RPE2.length - 3];
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown8.click();
		VIPFinancialsPage.contents.NetPPERevenueBox.click();
		String PPE1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] PPE2 = PPE1.split("\\s");
		String PPE = PPE2[PPE2.length - 3];
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CashCycleAnalysisMenu.click();
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.waitForExist(true, 10);
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.hover();
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.click();
		String DSO1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] DSO2 = DSO1.split("\\s");
		String DSO = DSO2[DSO2.length - 4];
		VIPFinancialsPage.contents.InventoryDaysChart.hover();
		VIPFinancialsPage.contents.InventoryDaysChart.click();
		String DIO1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] DIO2 = DIO1.split("\\s");
		String DIO = DIO2[DIO2.length - 4];
		VIPFinancialsPage.contents.DaysPayableChart.hover();
		VIPFinancialsPage.contents.DaysPayableChart.click();
		String DPO1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] DPO2 = DPO1.split("\\s");
		String DPO = DPO2[DPO2.length - 4];
		VIPFinancialsPage.contents.CashCycleChart2.hover();
		VIPFinancialsPage.contents.CashCycleChart2.click();
		String CCD1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] CCD2 = CCD1.split("\\s");
		String CCD = CCD2[CCD2.length - 4];
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		VIPOverviewPage.contents.RevenueValue.waitForExist(true, 20);
		String RevenueValue1 = VIPOverviewPage.contents.RevenueValue.getText();
		String[] RevenueValue2 = RevenueValue1.split("\\s");
		String Currency = RevenueValue2[0];
		String RevenueValue3 = RevenueValue2[1];
		Double RevenueValue4 = Double.parseDouble(RevenueValue3);
		VIPOverviewPage.contents.EnterpriseValue.waitForExist(true, 20);
		String EnterpriseValue1 = VIPOverviewPage.contents.EnterpriseValue.getText();
		String[] EnterpriseValue2 = EnterpriseValue1.split("\\s");
		String EnterpriseValue3 = EnterpriseValue2[1];
		Double EnterpriseValue4 = Double.parseDouble(EnterpriseValue3);
		BigDecimal EVR1 = new BigDecimal(EnterpriseValue4/RevenueValue4);
		BigDecimal EVR2 = EVR1.setScale(1, BigDecimal.ROUND_UP);
		String EVR = EVR2.toString();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.FinancialKPIs.hover();
		VIPSalesPage.contents.FinancialKPIs.click();
		VIPSalesPage.contents.RevenueCAGR5YrKPI.verifyText(CAGR5YrKPI);
		VIPSalesPage.contents.RevenueCAGR3YrKPI.verifyText(CAGR3YrKPI);
		VIPSalesPage.contents.RevenueCAGR1YrKPI.verifyText(CAGR1YrKPI);
		WebControl.takeScreenshot("Sales_Reg_Auto_028");
		
		ReportLog.setTestCase("Sales_Reg_Auto_029");
		VIPSalesPage.contents.COGSRevenueKPI.verifyText(COGSKPI);
		VIPSalesPage.contents.SGARevenueKPI.verifyText(SGAKPI);
		VIPSalesPage.contents.EBITMarginKPI.verifyText(EBITMarginKPI);
		VIPSalesPage.contents.ROICKPI.verifyText(ROICKPI);
		WebControl.takeScreenshot("Sales_Reg_Auto_029");
		
		ReportLog.setTestCase("Sales_Reg_Auto_030");
		VIPSalesPage.contents.RPEKPI.verifyText(RPE);
		VIPSalesPage.contents.NetPPEKPI.verifyText(PPE);
		VIPSalesPage.contents.DSOKPI.verifyText(DSO);
		VIPSalesPage.contents.DIOKPI.verifyText(DIO);
		VIPSalesPage.contents.DPOKPI.verifyText(DPO);
		VIPSalesPage.contents.CCDKPI.verifyText(CCD);
		WebControl.takeScreenshot("Sales_Reg_Auto_030");
		
		ReportLog.setTestCase("Sales_Reg_Auto_032");
		VIPSalesPage.contents.EVEBITKPI.verifyText(EVEBIT);
		VIPSalesPage.contents.EVREVKPI.verifyText(EVR);
		WebControl.takeScreenshot("Sales_Reg_Auto_032");
		
		ReportLog.setTestCase("Sales_Reg_Auto_033");
		String DSOKPI1 = VIPSalesPage.contents.DSOKPI.getText();
		String DSOKPI = DSOKPI1.replace(".", "");
		VIPSalesPage.contents.DSOKPI.verifyText(DSOKPI);
		String DIOKPI1 = VIPSalesPage.contents.DIOKPI.getText();
		String DIOKPI = DIOKPI1.replace(".", "");
		VIPSalesPage.contents.DIOKPI.verifyText(DIOKPI);
		String DPOKPI1 = VIPSalesPage.contents.DPOKPI.getText();
		String DPOKPI = DPOKPI1.replace(".", "");
		VIPSalesPage.contents.DPOKPI.verifyText(DPOKPI);
		String CCDKPI1 = VIPSalesPage.contents.CCDKPI.getText();
		String CCDKPI = CCDKPI1.replace(".", "");
		VIPSalesPage.contents.CCDKPI.verifyText(CCDKPI);
		WebControl.takeScreenshot("Sales_Reg_Auto_033");
		
		ReportLog.setTestCase("Sales_Reg_Auto_034");
		VIPSalesPage.contents.DilutedEPS.verifyText("Diluted EPS (" + Currency + ")");
		VIPSalesPage.contents.RPE.verifyText("Revenue per Employee (‘000 " + Currency + ")");
		WebControl.takeScreenshot("Sales_Reg_Auto_034");
		
		ReportLog.setTestCase("Sales_Reg_Auto_035_Target");
		//RevenueCAGR5YrKPI
		String RevenueCAGR5YrKPI1 = VIPSalesPage.contents.RevenueCAGR5YrKPI.getText();
		String RevenueCAGR5YrKPI2 = RevenueCAGR5YrKPI1.substring(RevenueCAGR5YrKPI1.length() - 2, RevenueCAGR5YrKPI1.length() - 1);
		String RevenueCAGR5YrKPI3 = RevenueCAGR5YrKPI1.substring(0, RevenueCAGR5YrKPI1.length() - 3);
		VIPSalesPage.contents.RevenueCAGR5YrKPI.verifyText(RevenueCAGR5YrKPI3 + "." + RevenueCAGR5YrKPI2 + "%");
		//RevenueCAGR3YrKPI
		String RevenueCAGR3YrKPI1 = VIPSalesPage.contents.RevenueCAGR3YrKPI.getText();
		String RevenueCAGR3YrKPI2 = RevenueCAGR3YrKPI1.substring(RevenueCAGR3YrKPI1.length() - 2, RevenueCAGR3YrKPI1.length() - 1);
		String RevenueCAGR3YrKPI3 = RevenueCAGR3YrKPI1.substring(0, RevenueCAGR3YrKPI1.length() - 3);
		VIPSalesPage.contents.RevenueCAGR3YrKPI.verifyText(RevenueCAGR3YrKPI3 + "." + RevenueCAGR3YrKPI2 + "%");
		//RevenueCAGR1YrKPI
		String RevenueCAGR1YrKPI1 = VIPSalesPage.contents.RevenueCAGR1YrKPI.getText();
		String RevenueCAGR1YrKPI2 = RevenueCAGR1YrKPI1.substring(RevenueCAGR1YrKPI1.length() - 2, RevenueCAGR1YrKPI1.length() - 1);
		String RevenueCAGR1YrKPI3 = RevenueCAGR1YrKPI1.substring(0, RevenueCAGR1YrKPI1.length() - 3);
		VIPSalesPage.contents.RevenueCAGR1YrKPI.verifyText(RevenueCAGR1YrKPI3 + "." + RevenueCAGR1YrKPI2 + "%");
		//COGSRevenueKPI
		String COGSRevenueKPI1 = VIPSalesPage.contents.COGSRevenueKPI.getText();
		String COGSRevenueKPI2 = COGSRevenueKPI1.substring(COGSRevenueKPI1.length() - 2, COGSRevenueKPI1.length() - 1);
		String COGSRevenueKPI3 = COGSRevenueKPI1.substring(0, COGSRevenueKPI1.length() - 3);
		VIPSalesPage.contents.COGSRevenueKPI.verifyText(COGSRevenueKPI3 + "." + COGSRevenueKPI2 + "%");
		//SGARevenueKPI
		String SGARevenueKPI1 = VIPSalesPage.contents.SGARevenueKPI.getText();
		String SGARevenueKPI2 = SGARevenueKPI1.substring(SGARevenueKPI1.length() - 2, SGARevenueKPI1.length() - 1);
		String SGARevenueKPI3 = SGARevenueKPI1.substring(0, SGARevenueKPI1.length() - 3);
		VIPSalesPage.contents.SGARevenueKPI.verifyText(SGARevenueKPI3 + "." + SGARevenueKPI2 + "%");
		//EBITMarginKPI
		String EBITMarginKPI1 = VIPSalesPage.contents.EBITMarginKPI.getText();
		String EBITMarginKPI2 = EBITMarginKPI1.substring(EBITMarginKPI1.length() - 2, EBITMarginKPI1.length() - 1);
		String EBITMarginKPI3 = EBITMarginKPI1.substring(0, EBITMarginKPI1.length() - 3);
		VIPSalesPage.contents.EBITMarginKPI.verifyText(EBITMarginKPI3 + "." + EBITMarginKPI2 + "%");
		//ROICKPI
		String ROICKPI1 = VIPSalesPage.contents.ROICKPI.getText();
		String ROICKPI2 = ROICKPI1.substring(ROICKPI1.length() - 2, ROICKPI1.length() - 1);
		String ROICKPI3 = ROICKPI1.substring(0, ROICKPI1.length() - 3);
		VIPSalesPage.contents.ROICKPI.verifyText(ROICKPI3 + "." + ROICKPI2 + "%");
		//DilutedEPSKPI
		String DilutedEPSKPI1 = VIPSalesPage.contents.DilutedEPSKPI.getText();
		String DilutedEPSKPI2 = DilutedEPSKPI1.substring(DilutedEPSKPI1.length() - 2, DilutedEPSKPI1.length());
		String DilutedEPSKPI3 = DilutedEPSKPI1.substring(0, DilutedEPSKPI1.length() - 3);
		VIPSalesPage.contents.DilutedEPSKPI.verifyText(DilutedEPSKPI3 + "." + DilutedEPSKPI2);
		//RPEKPI
		String RPEKPI1 = VIPSalesPage.contents.RPEKPI.getText();
		String RPEKPI2 = RPEKPI1.substring(RPEKPI1.length() - 1, RPEKPI1.length());
		String RPEKPI3 = RPEKPI1.substring(0, RPEKPI1.length() - 2);
		VIPSalesPage.contents.RPEKPI.verifyText(RPEKPI3 + "." + RPEKPI2);
		//NetPPEKPI
		String NetPPEKPI1 = VIPSalesPage.contents.NetPPEKPI.getText();
		String NetPPEKPI2 = NetPPEKPI1.substring(NetPPEKPI1.length() - 2, NetPPEKPI1.length() - 1);
		String NetPPEKPI3 = NetPPEKPI1.substring(0, NetPPEKPI1.length() - 3);
		VIPSalesPage.contents.NetPPEKPI.verifyText(NetPPEKPI3 + "." + NetPPEKPI2 + "%");
		//DSOKPI
		String DSOKPI1_1 = VIPSalesPage.contents.DSOKPI.getText();
		String DSOKPI2 = DSOKPI1_1.replace(".", "");
		VIPSalesPage.contents.DSOKPI.verifyText(DSOKPI2);
		//DIOKPI
		String DIOKPI1_1 = VIPSalesPage.contents.DIOKPI.getText();
		String DIOKPI2 = DIOKPI1_1.replace(".", "");
		VIPSalesPage.contents.DIOKPI.verifyText(DIOKPI2);
		//DPOKPI
		String DPOKPI1_1 = VIPSalesPage.contents.DPOKPI.getText();
		String DPOKPI2 = DPOKPI1_1.replace(".", "");
		VIPSalesPage.contents.DPOKPI.verifyText(DPOKPI2);
		//CCDKPI
		String CCDKPI1_1 = VIPSalesPage.contents.CCDKPI.getText();
		String CCDKPI2 = CCDKPI1_1.replace(".", "");
		VIPSalesPage.contents.CCDKPI.verifyText(CCDKPI2);
		//NetDebtFCFKPI
		String NetDebtFCFKPI1 = VIPSalesPage.contents.NetDebtFCFKPI.getText();
		String NetDebtFCFKPI2 = NetDebtFCFKPI1.substring(NetDebtFCFKPI1.length() - 1, NetDebtFCFKPI1.length());
		String NetDebtFCFKPI3 = NetDebtFCFKPI1.substring(0, NetDebtFCFKPI1.length() - 2);
		VIPSalesPage.contents.NetDebtFCFKPI.verifyText(NetDebtFCFKPI3 + "." + NetDebtFCFKPI2);
		//NetDebtKPI
		String NetDebtKPI1 = VIPSalesPage.contents.NetDebtKPI.getText();
		String NetDebtKPI2 = NetDebtKPI1.substring(NetDebtKPI1.length() - 1, NetDebtKPI1.length());
		String NetDebtKPI3 = NetDebtKPI1.substring(0, NetDebtKPI1.length() - 2);
		VIPSalesPage.contents.NetDebtKPI.verifyText(NetDebtKPI3 + "." + NetDebtKPI2);
		//TotalDebtKPI
		String TotalDebtKPI1 = VIPSalesPage.contents.TotalDebtKPI.getText();
		String TotalDebtKPI2 = TotalDebtKPI1.substring(TotalDebtKPI1.length() - 1, TotalDebtKPI1.length());
		String TotalDebtKPI3 = TotalDebtKPI1.substring(0, TotalDebtKPI1.length() - 2);
		VIPSalesPage.contents.TotalDebtKPI.verifyText(TotalDebtKPI3 + "." + TotalDebtKPI2);
		//ICKPI
		String ICKPI1 = VIPSalesPage.contents.ICKPI.getText();
		String ICKPI2 = ICKPI1.substring(ICKPI1.length() - 1, ICKPI1.length());
		String ICKPI3 = ICKPI1.substring(0, ICKPI1.length() - 2);
		VIPSalesPage.contents.ICKPI.verifyText(ICKPI3 + "." + ICKPI2);
		//EVREVKPI
		String EVREVKPI1 = VIPSalesPage.contents.EVREVKPI.getText();
		String EVREVKPI2 = EVREVKPI1.substring(EVREVKPI1.length() - 1, EVREVKPI1.length());
		String EVREVKPI3 = EVREVKPI1.substring(0, EVREVKPI1.length() - 2);
		VIPSalesPage.contents.EVREVKPI.verifyText(EVREVKPI3 + "." + EVREVKPI2);
		//EVEBITKPI
		String EVEBITKPI1 = VIPSalesPage.contents.EVEBITKPI.getText();
		String EVEBITKPI2 = EVEBITKPI1.substring(EVEBITKPI1.length() - 1, EVEBITKPI1.length());
		String EVEBITKPI3 = EVEBITKPI1.substring(0, EVEBITKPI1.length() - 2);
		VIPSalesPage.contents.EVEBITKPI.verifyText(EVEBITKPI3 + "." + EVEBITKPI2);
		WebControl.takeScreenshot("Sales_Reg_Auto_035_Target");
		
		ReportLog.setTestCase("Sales_Reg_Auto_035_Peer");
		//RevenueCAGR5YrKPIP
		String RevenueCAGR5YrKPIP1 = VIPSalesPage.contents.RevenueCAGR5YrKPIP.getText();
		String RevenueCAGR5YrKPIP2 = RevenueCAGR5YrKPIP1.substring(RevenueCAGR5YrKPIP1.length() - 2, RevenueCAGR5YrKPIP1.length() - 1);
		String RevenueCAGR5YrKPIP3 = RevenueCAGR5YrKPIP1.substring(0, RevenueCAGR5YrKPIP1.length() - 3);
		VIPSalesPage.contents.RevenueCAGR5YrKPIP.verifyText(RevenueCAGR5YrKPIP3 + "." + RevenueCAGR5YrKPIP2 + "%");
		//RevenueCAGR3YrKPIP
		String RevenueCAGR3YrKPIP1 = VIPSalesPage.contents.RevenueCAGR3YrKPIP.getText();
		String RevenueCAGR3YrKPIP2 = RevenueCAGR3YrKPIP1.substring(RevenueCAGR3YrKPIP1.length() - 2, RevenueCAGR3YrKPIP1.length() - 1);
		String RevenueCAGR3YrKPIP3 = RevenueCAGR3YrKPIP1.substring(0, RevenueCAGR3YrKPIP1.length() - 3);
		VIPSalesPage.contents.RevenueCAGR3YrKPIP.verifyText(RevenueCAGR3YrKPIP3 + "." + RevenueCAGR3YrKPIP2 + "%");
		//RevenueCAGR1YrKPIP
		String RevenueCAGR1YrKPIP1 = VIPSalesPage.contents.RevenueCAGR1YrKPIP.getText();
		String RevenueCAGR1YrKPIP2 = RevenueCAGR1YrKPIP1.substring(RevenueCAGR1YrKPIP1.length() - 2, RevenueCAGR1YrKPIP1.length() - 1);
		String RevenueCAGR1YrKPIP3 = RevenueCAGR1YrKPIP1.substring(0, RevenueCAGR1YrKPIP1.length() - 3);
		VIPSalesPage.contents.RevenueCAGR1YrKPIP.verifyText(RevenueCAGR1YrKPIP3 + "." + RevenueCAGR1YrKPIP2 + "%");
		//COGSRevenueKPIP
		String COGSRevenueKPIP1 = VIPSalesPage.contents.COGSRevenueKPIP.getText();
		String COGSRevenueKPIP2 = COGSRevenueKPIP1.substring(COGSRevenueKPIP1.length() - 2, COGSRevenueKPIP1.length() - 1);
		String COGSRevenueKPIP3 = COGSRevenueKPIP1.substring(0, COGSRevenueKPIP1.length() - 3);
		VIPSalesPage.contents.COGSRevenueKPIP.verifyText(COGSRevenueKPIP3 + "." + COGSRevenueKPIP2 + "%");
		//SGARevenueKPIP
		String SGARevenueKPIP1 = VIPSalesPage.contents.SGARevenueKPIP.getText();
		String SGARevenueKPIP2 = SGARevenueKPIP1.substring(SGARevenueKPIP1.length() - 2, SGARevenueKPIP1.length() - 1);
		String SGARevenueKPIP3 = SGARevenueKPIP1.substring(0, SGARevenueKPIP1.length() - 3);
		VIPSalesPage.contents.SGARevenueKPIP.verifyText(SGARevenueKPIP3 + "." + SGARevenueKPIP2 + "%");
		//EBITMarginKPIP
		String EBITMarginKPIP1 = VIPSalesPage.contents.EBITMarginKPIP.getText();
		String EBITMarginKPIP2 = EBITMarginKPIP1.substring(EBITMarginKPIP1.length() - 2, EBITMarginKPIP1.length() - 1);
		String EBITMarginKPIP3 = EBITMarginKPIP1.substring(0, EBITMarginKPIP1.length() - 3);
		VIPSalesPage.contents.EBITMarginKPIP.verifyText(EBITMarginKPIP3 + "." + EBITMarginKPIP2 + "%");
		//ROICKPIP
		String ROICKPIP1 = VIPSalesPage.contents.ROICKPIP.getText();
		String ROICKPIP2 = ROICKPIP1.substring(ROICKPIP1.length() - 2, ROICKPIP1.length() - 1);
		String ROICKPIP3 = ROICKPIP1.substring(0, ROICKPIP1.length() - 3);
		VIPSalesPage.contents.ROICKPIP.verifyText(ROICKPIP3 + "." + ROICKPIP2 + "%");
		//DilutedEPSKPIP
		String DilutedEPSKPIP1 = VIPSalesPage.contents.DilutedEPSKPIP.getText();
		String DilutedEPSKPIP2 = DilutedEPSKPIP1.substring(DilutedEPSKPIP1.length() - 2, DilutedEPSKPIP1.length());
		String DilutedEPSKPIP3 = DilutedEPSKPIP1.substring(0, DilutedEPSKPIP1.length() - 3);
		VIPSalesPage.contents.DilutedEPSKPIP.verifyText(DilutedEPSKPIP3 + "." + DilutedEPSKPIP2);
		//RPEKPIP
		String RPEKPIP1 = VIPSalesPage.contents.RPEKPIP.getText();
		String RPEKPIP2 = RPEKPIP1.substring(RPEKPIP1.length() - 1, RPEKPIP1.length());
		String RPEKPIP3 = RPEKPIP1.substring(0, RPEKPIP1.length() - 2);
		VIPSalesPage.contents.RPEKPIP.verifyText(RPEKPIP3 + "." + RPEKPIP2);
		//NetPPEKPIP
		String NetPPEKPIP1 = VIPSalesPage.contents.NetPPEKPIP.getText();
		String NetPPEKPIP2 = NetPPEKPIP1.substring(NetPPEKPIP1.length() - 2, NetPPEKPIP1.length() - 1);
		String NetPPEKPIP3 = NetPPEKPIP1.substring(0, NetPPEKPIP1.length() - 3);
		VIPSalesPage.contents.NetPPEKPIP.verifyText(NetPPEKPIP3 + "." + NetPPEKPIP2 + "%");
		//DSOKPIP
		String DSOKPIP1_1 = VIPSalesPage.contents.DSOKPIP.getText();
		String DSOKPIP2 = DSOKPIP1_1.replace(".", "");
		VIPSalesPage.contents.DSOKPIP.verifyText(DSOKPIP2);
		//DIOKPIP
		String DIOKPIP1_1 = VIPSalesPage.contents.DIOKPIP.getText();
		String DIOKPIP2 = DIOKPIP1_1.replace(".", "");
		VIPSalesPage.contents.DIOKPIP.verifyText(DIOKPIP2);
		//DPOKPIP
		String DPOKPIP1_1 = VIPSalesPage.contents.DPOKPIP.getText();
		String DPOKPIP2 = DPOKPIP1_1.replace(".", "");
		VIPSalesPage.contents.DPOKPIP.verifyText(DPOKPIP2);
		//CCDKPIP
		String CCDKPIP1_1 = VIPSalesPage.contents.CCDKPIP.getText();
		String CCDKPIP2 = CCDKPIP1_1.replace(".", "");
		VIPSalesPage.contents.CCDKPIP.verifyText(CCDKPIP2);
		//NetDebtFCFKPIP
		String NetDebtFCFKPIP1 = VIPSalesPage.contents.NetDebtFCFKPIP.getText();
		String NetDebtFCFKPIP2 = NetDebtFCFKPIP1.substring(NetDebtFCFKPIP1.length() - 1, NetDebtFCFKPIP1.length());
		String NetDebtFCFKPIP3 = NetDebtFCFKPIP1.substring(0, NetDebtFCFKPIP1.length() - 2);
		VIPSalesPage.contents.NetDebtFCFKPIP.verifyText(NetDebtFCFKPIP3 + "." + NetDebtFCFKPIP2);
		//NetDebtKPIP
		String NetDebtKPIP1 = VIPSalesPage.contents.NetDebtKPIP.getText();
		String NetDebtKPIP2 = NetDebtKPIP1.substring(NetDebtKPIP1.length() - 1, NetDebtKPIP1.length());
		String NetDebtKPIP3 = NetDebtKPIP1.substring(0, NetDebtKPIP1.length() - 2);
		VIPSalesPage.contents.NetDebtKPIP.verifyText(NetDebtKPIP3 + "." + NetDebtKPIP2);
		//TotalDebtKPIP
		String TotalDebtKPIP1 = VIPSalesPage.contents.TotalDebtKPIP.getText();
		String TotalDebtKPIP2 = TotalDebtKPIP1.substring(TotalDebtKPIP1.length() - 1, TotalDebtKPIP1.length());
		String TotalDebtKPIP3 = TotalDebtKPIP1.substring(0, TotalDebtKPIP1.length() - 2);
		VIPSalesPage.contents.TotalDebtKPIP.verifyText(TotalDebtKPIP3 + "." + TotalDebtKPIP2);
		//ICKPIP
		String ICKPIP1 = VIPSalesPage.contents.ICKPIP.getText();
		String ICKPIP2 = ICKPIP1.substring(ICKPIP1.length() - 1, ICKPIP1.length());
		String ICKPIP3 = ICKPIP1.substring(0, ICKPIP1.length() - 2);
		VIPSalesPage.contents.ICKPIP.verifyText(ICKPIP3 + "." + ICKPIP2);
		//EVREVKPIP
		String EVREVKPIP1 = VIPSalesPage.contents.EVREVKPIP.getText();
		String EVREVKPIP2 = EVREVKPIP1.substring(EVREVKPIP1.length() - 1, EVREVKPIP1.length());
		String EVREVKPIP3 = EVREVKPIP1.substring(0, EVREVKPIP1.length() - 2);
		VIPSalesPage.contents.EVREVKPIP.verifyText(EVREVKPIP3 + "." + EVREVKPIP2);
		//EVEBITKPIP
		String EVEBITKPIP1 = VIPSalesPage.contents.EVEBITKPIP.getText();
		String EVEBITKPIP2 = EVEBITKPIP1.substring(EVEBITKPIP1.length() - 1, EVEBITKPIP1.length());
		String EVEBITKPIP3 = EVEBITKPIP1.substring(0, EVEBITKPIP1.length() - 2);
		VIPSalesPage.contents.EVEBITKPIP.verifyText(EVEBITKPIP3 + "." + EVEBITKPIP2);
		WebControl.takeScreenshot("Sales_Reg_Auto_035_Peer");
		
		ReportLog.setTestCase("Sales_Reg_Auto_035_Best");
		//RevenueCAGR5YrBest
		String RevenueCAGR5YrBest1 = VIPSalesPage.contents.RevenueCAGR5YrBest.getText();
		String RevenueCAGR5YrBest2 = RevenueCAGR5YrBest1.substring(RevenueCAGR5YrBest1.length() - 2, RevenueCAGR5YrBest1.length() - 1);
		String RevenueCAGR5YrBest3 = RevenueCAGR5YrBest1.substring(0, RevenueCAGR5YrBest1.length() - 3);
		VIPSalesPage.contents.RevenueCAGR5YrBest.verifyText(RevenueCAGR5YrBest3 + "." + RevenueCAGR5YrBest2 + "%");
		//RevenueCAGR3YrBest
		String RevenueCAGR3YrBest1 = VIPSalesPage.contents.RevenueCAGR3YrBest.getText();
		String RevenueCAGR3YrBest2 = RevenueCAGR3YrBest1.substring(RevenueCAGR3YrBest1.length() - 2, RevenueCAGR3YrBest1.length() - 1);
		String RevenueCAGR3YrBest3 = RevenueCAGR3YrBest1.substring(0, RevenueCAGR3YrBest1.length() - 3);
		VIPSalesPage.contents.RevenueCAGR3YrBest.verifyText(RevenueCAGR3YrBest3 + "." + RevenueCAGR3YrBest2 + "%");
		//RevenueCAGR1YrBest
		String RevenueCAGR1YrBest1 = VIPSalesPage.contents.RevenueCAGR1YrBest.getText();
		String RevenueCAGR1YrBest2 = RevenueCAGR1YrBest1.substring(RevenueCAGR1YrBest1.length() - 2, RevenueCAGR1YrBest1.length() - 1);
		String RevenueCAGR1YrBest3 = RevenueCAGR1YrBest1.substring(0, RevenueCAGR1YrBest1.length() - 3);
		VIPSalesPage.contents.RevenueCAGR1YrBest.verifyText(RevenueCAGR1YrBest3 + "." + RevenueCAGR1YrBest2 + "%");
		//COGSRevenueBest
		String COGSRevenueBest1 = VIPSalesPage.contents.COGSRevenueBest.getText();
		String COGSRevenueBest2 = COGSRevenueBest1.substring(COGSRevenueBest1.length() - 2, COGSRevenueBest1.length() - 1);
		String COGSRevenueBest3 = COGSRevenueBest1.substring(0, COGSRevenueBest1.length() - 3);
		VIPSalesPage.contents.COGSRevenueBest.verifyText(COGSRevenueBest3 + "." + COGSRevenueBest2 + "%");
		//SGARevenueBest
		String SGARevenueBest1 = VIPSalesPage.contents.SGARevenueBest.getText();
		String SGARevenueBest2 = SGARevenueBest1.substring(SGARevenueBest1.length() - 2, SGARevenueBest1.length() - 1);
		String SGARevenueBest3 = SGARevenueBest1.substring(0, SGARevenueBest1.length() - 3);
		VIPSalesPage.contents.SGARevenueBest.verifyText(SGARevenueBest3 + "." + SGARevenueBest2 + "%");
		//EBITMarginBest
		String EBITMarginBest1 = VIPSalesPage.contents.EBITMarginBest.getText();
		String EBITMarginBest2 = EBITMarginBest1.substring(EBITMarginBest1.length() - 2, EBITMarginBest1.length() - 1);
		String EBITMarginBest3 = EBITMarginBest1.substring(0, EBITMarginBest1.length() - 3);
		VIPSalesPage.contents.EBITMarginBest.verifyText(EBITMarginBest3 + "." + EBITMarginBest2 + "%");
		//ROICBest
		String ROICBest1 = VIPSalesPage.contents.ROICBest.getText();
		String ROICBest2 = ROICBest1.substring(ROICBest1.length() - 2, ROICBest1.length() - 1);
		String ROICBest3 = ROICBest1.substring(0, ROICBest1.length() - 3);
		VIPSalesPage.contents.ROICBest.verifyText(ROICBest3 + "." + ROICBest2 + "%");
		//DilutedEPSBest
		String DilutedEPSBest1 = VIPSalesPage.contents.DilutedEPSBest.getText();
		String DilutedEPSBest2 = DilutedEPSBest1.substring(DilutedEPSBest1.length() - 2, DilutedEPSBest1.length());
		String DilutedEPSBest3 = DilutedEPSBest1.substring(0, DilutedEPSBest1.length() - 3);
		VIPSalesPage.contents.DilutedEPSBest.verifyText(DilutedEPSBest3 + "." + DilutedEPSBest2);
		//RPEBest
		String RPEBest1 = VIPSalesPage.contents.RPEBest.getText();
		String RPEBest2 = RPEBest1.substring(RPEBest1.length() - 1, RPEBest1.length());
		String RPEBest3 = RPEBest1.substring(0, RPEBest1.length() - 2);
		VIPSalesPage.contents.RPEBest.verifyText(RPEBest3 + "." + RPEBest2);
		//NetPPEBest
		String NetPPEBest1 = VIPSalesPage.contents.NetPPEBest.getText();
		String NetPPEBest2 = NetPPEBest1.substring(NetPPEBest1.length() - 2, NetPPEBest1.length() - 1);
		String NetPPEBest3 = NetPPEBest1.substring(0, NetPPEBest1.length() - 3);
		VIPSalesPage.contents.NetPPEBest.verifyText(NetPPEBest3 + "." + NetPPEBest2 + "%");
		//DSOBest
		String DSOBest1_1 = VIPSalesPage.contents.DSOBest.getText();
		String DSOBest2 = DSOBest1_1.replace(".", "");
		VIPSalesPage.contents.DSOBest.verifyText(DSOBest2);
		//DIOBest
		String DIOBest1_1 = VIPSalesPage.contents.DIOBest.getText();
		String DIOBest2 = DIOBest1_1.replace(".", "");
		VIPSalesPage.contents.DIOBest.verifyText(DIOBest2);
		//DPOBest
		String DPOBest1_1 = VIPSalesPage.contents.DPOBest.getText();
		String DPOBest2 = DPOBest1_1.replace(".", "");
		VIPSalesPage.contents.DPOBest.verifyText(DPOBest2);
		//CCDBest
		String CCDBest1_1 = VIPSalesPage.contents.CCDBest.getText();
		String CCDBest2 = CCDBest1_1.replace(".", "");
		VIPSalesPage.contents.CCDBest.verifyText(CCDBest2);
		//NetDebtFCFBest
		String NetDebtFCFBest1 = VIPSalesPage.contents.NetDebtFCFBest.getText();
		String NetDebtFCFBest2 = NetDebtFCFBest1.substring(NetDebtFCFBest1.length() - 1, NetDebtFCFBest1.length());
		String NetDebtFCFBest3 = NetDebtFCFBest1.substring(0, NetDebtFCFBest1.length() - 2);
		VIPSalesPage.contents.NetDebtFCFBest.verifyText(NetDebtFCFBest3 + "." + NetDebtFCFBest2);
		//NetDebtBest
		String NetDebtBest1 = VIPSalesPage.contents.NetDebtBest.getText();
		String NetDebtBest2 = NetDebtBest1.substring(NetDebtBest1.length() - 1, NetDebtBest1.length());
		String NetDebtBest3 = NetDebtBest1.substring(0, NetDebtBest1.length() - 2);
		VIPSalesPage.contents.NetDebtBest.verifyText(NetDebtBest3 + "." + NetDebtBest2);
		//TotalDebtBest
		String TotalDebtBest1 = VIPSalesPage.contents.TotalDebtBest.getText();
		String TotalDebtBest2 = TotalDebtBest1.substring(TotalDebtBest1.length() - 1, TotalDebtBest1.length());
		String TotalDebtBest3 = TotalDebtBest1.substring(0, TotalDebtBest1.length() - 2);
		VIPSalesPage.contents.TotalDebtBest.verifyText(TotalDebtBest3 + "." + TotalDebtBest2);
		//ICBest
		String ICBest1 = VIPSalesPage.contents.ICBest.getText();
		String ICBest2 = ICBest1.substring(ICBest1.length() - 1, ICBest1.length());
		String ICBest3 = ICBest1.substring(0, ICBest1.length() - 2);
		VIPSalesPage.contents.ICBest.verifyText(ICBest3 + "." + ICBest2);
		//EVREVBest
		String EVREVBest1 = VIPSalesPage.contents.EVREVBest.getText();
		String EVREVBest2 = EVREVBest1.substring(EVREVBest1.length() - 1, EVREVBest1.length());
		String EVREVBest3 = EVREVBest1.substring(0, EVREVBest1.length() - 2);
		VIPSalesPage.contents.EVREVBest.verifyText(EVREVBest3 + "." + EVREVBest2);
		//EVEBITBest
		String EVEBITBest1 = VIPSalesPage.contents.EVEBITBest.getText();
		String EVEBITBest2 = EVEBITBest1.substring(EVEBITBest1.length() - 1, EVEBITBest1.length());
		String EVEBITBest3 = EVEBITBest1.substring(0, EVEBITBest1.length() - 2);
		VIPSalesPage.contents.EVEBITBest.verifyText(EVEBITBest3 + "." + EVEBITBest2);
		WebControl.takeScreenshot("Sales_Reg_Auto_035_Best");
		
		ReportLog.setTestCase("Sales_Reg_Auto_040");
		VIPSalesPage.contents.Q4.verifyDisplayed(true, 5);
		VIPSalesPage.contents.Q4.verifyText("Q4");
		VIPSalesPage.contents.Q3.verifyDisplayed(true, 5);
		VIPSalesPage.contents.Q3.verifyText("Q3");
		VIPSalesPage.contents.Q2.verifyDisplayed(true, 5);
		VIPSalesPage.contents.Q2.verifyText("Q2");
		VIPSalesPage.contents.Q1.verifyDisplayed(true, 5);
		VIPSalesPage.contents.Q1.verifyText("Q1");
		WebControl.takeScreenshot("Sales_Reg_Auto_040");
		
		ReportLog.setTestCase("Sales_Reg_Auto_041");
		VIPSalesPage.contents.RevenueCAGR5YrPercentile.hover();
		String CAGR5YrRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] CAGR5YrRank2 = CAGR5YrRank1.split("\\n");
		String CAGR5YrRank3 = CAGR5YrRank2[0];
		String CAGR5YrRank4 = CAGR5YrRank2[1];
		String[] CAGR5YrRank5 = CAGR5YrRank4.split("\\/");
		String CAGR5YrRank6 = CAGR5YrRank5[0];
		String CAGR5YrRank7 = CAGR5YrRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(CAGR5YrRank3 + "\n" + CAGR5YrRank6 + "/" + CAGR5YrRank7);
		//RevenueCAGR3YrPercentile
		VIPSalesPage.contents.RevenueCAGR3YrPercentile.hover();
		String CAGR3YrRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] CAGR3YrRank2 = CAGR3YrRank1.split("\\n");
		String CAGR3YrRank3 = CAGR3YrRank2[0];
		String CAGR3YrRank4 = CAGR3YrRank2[1];
		String[] CAGR3YrRank5 = CAGR3YrRank4.split("\\/");
		String CAGR3YrRank6 = CAGR3YrRank5[0];
		String CAGR3YrRank7 = CAGR3YrRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(CAGR3YrRank3 + "\n" + CAGR3YrRank6 + "/" + CAGR3YrRank7);
		//RevenueCAGR1YrPercentile
		VIPSalesPage.contents.RevenueCAGR1YrPercentile.hover();
		String CAGR1YrRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] CAGR1YrRank2 = CAGR1YrRank1.split("\\n");
		String CAGR1YrRank3 = CAGR1YrRank2[0];
		String CAGR1YrRank4 = CAGR1YrRank2[1];
		String[] CAGR1YrRank5 = CAGR1YrRank4.split("\\/");
		String CAGR1YrRank6 = CAGR1YrRank5[0];
		String CAGR1YrRank7 = CAGR1YrRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(CAGR1YrRank3 + "\n" + CAGR1YrRank6 + "/" + CAGR1YrRank7);
		//COGSRevenuePercentile
		VIPSalesPage.contents.COGSRevenuePercentile.hover();
		String COGSRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] COGSRank2 = COGSRank1.split("\\n");
		String COGSRank3 = COGSRank2[0];
		String COGSRank4 = COGSRank2[1];
		String[] COGSRank5 = COGSRank4.split("\\/");
		String COGSRank6 = COGSRank5[0];
		String COGSRank7 = COGSRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(COGSRank3 + "\n" + COGSRank6 + "/" + COGSRank7);
		//SGARevenuePercentile
		VIPSalesPage.contents.SGARevenuePercentile.hover();
		String SGARank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] SGARank2 = SGARank1.split("\\n");
		String SGARank3 = SGARank2[0];
		String SGARank4 = SGARank2[1];
		String[] SGARank5 = SGARank4.split("\\/");
		String SGARank6 = SGARank5[0];
		String SGARank7 = SGARank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(SGARank3 + "\n" + SGARank6 + "/" + SGARank7);
		//ROICPercentile
		VIPSalesPage.contents.ROICPercentile.hover();
		String ROICRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] ROICRank2 = ROICRank1.split("\\n");
		String ROICRank3 = ROICRank2[0];
		String ROICRank4 = ROICRank2[1];
		String[] ROICRank5 = ROICRank4.split("\\/");
		String ROICRank6 = ROICRank5[0];
		String ROICRank7 = ROICRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(ROICRank3 + "\n" + ROICRank6 + "/" + ROICRank7);
		//EBITMarginPercentile
		VIPSalesPage.contents.EBITMarginPercentile.hover();
		String EBITMRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] EBITMRank2 = EBITMRank1.split("\\n");
		String EBITMRank3 = EBITMRank2[0];
		String EBITMRank4 = EBITMRank2[1];
		String[] EBITMRank5 = EBITMRank4.split("\\/");
		String EBITMRank6 = EBITMRank5[0];
		String EBITMRank7 = EBITMRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(EBITMRank3 + "\n" + EBITMRank6 + "/" + EBITMRank7);
		//DilutedEPSPercentile
		VIPSalesPage.contents.DilutedEPSPercentile.hover();
		String DEPSRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] DEPSRank2 = DEPSRank1.split("\\n");
		String DEPSRank3 = DEPSRank2[0];
		String DEPSRank4 = DEPSRank2[1];
		String[] DEPSRank5 = DEPSRank4.split("\\/");
		String DEPSRank6 = DEPSRank5[0];
		String DEPSRank7 = DEPSRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(DEPSRank3 + "\n" + DEPSRank6 + "/" + DEPSRank7);
		//RPEPercentile
		VIPSalesPage.contents.RPEPercentile.hover();
		String RPERank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] RPERank2 = RPERank1.split("\\n");
		String RPERank3 = RPERank2[0];
		String RPERank4 = RPERank2[1];
		String[] RPERank5 = RPERank4.split("\\/");
		String RPERank6 = RPERank5[0];
		String RPERank7 = RPERank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(RPERank3 + "\n" + RPERank6 + "/" + RPERank7);
		//NetPPEPercentile
		VIPSalesPage.contents.NetPPEPercentile.hover();
		String NPPERank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] NPPERank2 = NPPERank1.split("\\n");
		String NPPERank3 = NPPERank2[0];
		String NPPERank4 = NPPERank2[1];
		String[] NPPERank5 = NPPERank4.split("\\/");
		String NPPERank6 = NPPERank5[0];
		String NPPERank7 = NPPERank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(NPPERank3 + "\n" + NPPERank6 + "/" + NPPERank7);
		//DSOPercentile
		VIPSalesPage.contents.DSOPercentile.hover();
		String DSORank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] DSORank2 = DSORank1.split("\\n");
		String DSORank3 = DSORank2[0];
		String DSORank4 = DSORank2[1];
		String[] DSORank5 = DSORank4.split("\\/");
		String DSORank6 = DSORank5[0];
		String DSORank7 = DSORank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(DSORank3 + "\n" + DSORank6 + "/" + DSORank7);
		//DIOPercentile
		VIPSalesPage.contents.DIOPercentile.hover();
		String DIORank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] DIORank2 = DIORank1.split("\\n");
		String DIORank3 = DIORank2[0];
		String DIORank4 = DIORank2[1];
		String[] DIORank5 = DIORank4.split("\\/");
		String DIORank6 = DIORank5[0];
		String DIORank7 = DIORank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(DIORank3 + "\n" + DIORank6 + "/" + DIORank7);
		//DPOPercentile
		VIPSalesPage.contents.DPOPercentile.hover();
		String DPORank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] DPORank2 = DPORank1.split("\\n");
		String DPORank3 = DPORank2[0];
		String DPORank4 = DPORank2[1];
		String[] DPORank5 = DPORank4.split("\\/");
		String DPORank6 = DPORank5[0];
		String DPORank7 = DPORank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(DPORank3 + "\n" + DPORank6 + "/" + DPORank7);
		//CCDPercentile
		VIPSalesPage.contents.CCDPercentile.hover();
		String CCDRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] CCDRank2 = CCDRank1.split("\\n");
		String CCDRank3 = CCDRank2[0];
		String CCDRank4 = CCDRank2[1];
		String[] CCDRank5 = CCDRank4.split("\\/");
		String CCDRank6 = CCDRank5[0];
		String CCDRank7 = CCDRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(CCDRank3 + "\n" + CCDRank6 + "/" + CCDRank7);
		//NetDebtFCFPercentile
		VIPSalesPage.contents.NetDebtFCFPercentile.hover();
		String NDFCFRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] NDFCFRank2 = NDFCFRank1.split("\\n");
		String NDFCFRank3 = NDFCFRank2[0];
		String NDFCFRank4 = NDFCFRank2[1];
		String[] NDFCFRank5 = NDFCFRank4.split("\\/");
		String NDFCFRank6 = NDFCFRank5[0];
		String NDFCFRank7 = NDFCFRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(NDFCFRank3 + "\n" + NDFCFRank6 + "/" + NDFCFRank7);
		//NetDebtPercentile
		VIPSalesPage.contents.NetDebtPercentile.hover();
		String NDEBITDARank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] NDEBITDARank2 = NDEBITDARank1.split("\\n");
		String NDEBITDARank3 = NDEBITDARank2[0];
		String NDEBITDARank4 = NDEBITDARank2[1];
		String[] NDEBITDARank5 = NDEBITDARank4.split("\\/");
		String NDEBITDARank6 = NDEBITDARank5[0];
		String NDEBITDARank7 = NDEBITDARank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(NDEBITDARank3 + "\n" + NDEBITDARank6 + "/" + NDEBITDARank7);
		//TotalDebtPercentile
		VIPSalesPage.contents.TotalDebtPercentile.hover();
		String TDERank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] TDERank2 = TDERank1.split("\\n");
		String TDERank3 = TDERank2[0];
		String TDERank4 = TDERank2[1];
		String[] TDERank5 = TDERank4.split("\\/");
		String TDERank6 = TDERank5[0];
		String TDERank7 = TDERank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(TDERank3 + "\n" + TDERank6 + "/" + TDERank7);
		//ICPercentile
		VIPSalesPage.contents.ICPercentile.hover();
		String ICRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] ICRank2 = ICRank1.split("\\n");
		String ICRank3 = ICRank2[0];
		String ICRank4 = ICRank2[1];
		String[] ICRank5 = ICRank4.split("\\/");
		String ICRank6 = ICRank5[0];
		String ICRank7 = ICRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(ICRank3 + "\n" + ICRank6 + "/" + ICRank7);
		//EVREVPercentile
		VIPSalesPage.contents.EVREVPercentile.hover();
		String EVREVRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] EVREVRank2 = EVREVRank1.split("\\n");
		String EVREVRank3 = EVREVRank2[0];
		String EVREVRank4 = EVREVRank2[1];
		String[] EVREVRank5 = EVREVRank4.split("\\/");
		String EVREVRank6 = EVREVRank5[0];
		String EVREVRank7 = EVREVRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(EVREVRank3 + "\n" + EVREVRank6 + "/" + EVREVRank7);
		//EVEBITPercentile
		VIPSalesPage.contents.EVEBITPercentile.hover();
		String EVEBITRank1 = VIPSalesPage.contents.TooltipText.getText();
		String[] EVEBITRank2 = EVEBITRank1.split("\\n");
		String EVEBITRank3 = EVEBITRank2[0];
		String EVEBITRank4 = EVEBITRank2[1];
		String[] EVEBITRank5 = EVEBITRank4.split("\\/");
		String EVEBITRank6 = EVEBITRank5[0];
		String EVEBITRank7 = EVEBITRank5[1];
		VIPSalesPage.contents.TooltipText.verifyText(EVEBITRank3 + "\n" + EVEBITRank6 + "/" + EVEBITRank7);
		WebControl.takeScreenshot("Sales_Reg_Auto_041");
		
		ReportLog.setTestCase("Sales_Reg_Auto_042");
		VIPSalesPage.contents.ScorecardNote.verifyDisplayed(true, 5);
		VIPSalesPage.contents.ScorecardNote.verifyText(testDataHandler.ScorecardNote);
		WebControl.takeScreenshot("Sales_Reg_Auto_042");
		
		ReportLog.setTestCase("Sales_Reg_Auto_043");
		VIPSalesPage.contents.Source.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Sales_Reg_Auto_043");		
		
		
	}
	
	//@Test(priority=2)
	public void Sales_ClientPriorities () throws Exception {
		ReportLog.setTestName("Sales Leadership - Client Priorities");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_001");
		VIP_Common.LogInPage(testDataHandler);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(3000);
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
		VIPSalesPage.contents.SideMenuSales.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_001");
		
		ReportLog.setTestCase("Sales_Reg_Auto_002_&_003");
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModal.verifyDisplayed(true, 5);
		VIPSalesPage.contents.OppNavModalHeader1.verifyText("What is Opportunity Navigator?");
		VIPSalesPage.contents.OppNavModalBody1.verifyText("An automated business case tool which identifies client priorities from Earnings Call Transcripts and links client performance (financial/operational KPIs) to Value Creation Opportunities (VCOs).");
		VIPSalesPage.contents.OppNavModalHeader2.verifyText("Who can use it?");
		VIPSalesPage.contents.OppNavModalBody2.verifyText("This tool can be used for creating the value proposition for large client opportunities. Primary audience for this dashboard includes: Sales Leads/ Sales Capture Leads, Market Makers, Transformation Directors, DCALs, CALs, Bid Managers. Please reach out to the CVS Team to get Value Architect support for further refinement of the business case before sharing with the client.");
		VIPSalesPage.contents.UserGuideButton.hover();
		VIPSalesPage.contents.UserGuideButton.verifyText("DOWNLOAD USER GUIDE");
		VIPSalesPage.contents.DoNotShowCheckBox.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DoNotShowLabel.verifyText("Do not show this message again");
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		else {VIPSalesPage.contents.OppNavModal.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_002_&_003");
		
		ReportLog.setTestCase("Sales_Reg_Auto_004");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.ValueProposition.hover();
		VIPSalesPage.contents.ValueProposition.verifyDisplayed(true, 3);
		VIPSalesPage.contents.ValueProposition.verifyText("VALUE PROPOSITION");
		VIPSalesPage.contents.ClientPriorities.verifyDisplayed(true, 3);
		VIPSalesPage.contents.ClientPriorities.verifyText("CLIENT PRIORITIES\n" + "(Beta)");
		VIPSalesPage.contents.FinancialKPIs.verifyDisplayed(false);
		//VIPSalesPage.contents.FinancialKPIs.verifyText("FINANCIAL KPIs");
		VIPSalesPage.contents.OperationalKPIs.verifyDisplayed(false);
		//VIPSalesPage.contents.OperationalKPIs.verifyText("OPERATIONAL KPIs");
		WebControl.takeScreenshot("Sales_Reg_Auto_004");
		
		ReportLog.setTestCase("Sales_Reg_Auto_005");
		VIPSalesPage.contents.SalesTitle.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SalesTitle.verifyText("Opportunity Navigator");
		VIPSalesPage.contents.OppNaviTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.OppNaviTooltipIcon.click();
		VIPSalesPage.contents.OppNavModal.verifyDisplayed(true, 5);
		VIPSalesPage.contents.OppNavModalCloseButton.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_005");
		
		ReportLog.setTestCase("Sales_Reg_Auto_006");
		VIPSalesPage.contents.SideMenuSalesSelected.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_006");
		
		ReportLog.setTestCase("Sales_Reg_Auto_007");
		VIPSalesPage.contents.SalesSubTitle2.waitForExist(true, 25);
		VIPSalesPage.contents.SalesSubTitle2.verifyText("Note: Industry specific opportunities will be coming soon!");
		WebControl.takeScreenshot("Sales_Reg_Auto_007");
		
		ReportLog.setTestCase("Sales_Reg_Auto_008");
		VIPSalesPage.contents.ClientPriorities.click();
		Thread.sleep(1500);
		VIPSalesPage.contents.Segment1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.Segment1.verifyText("Cost Reduction");
		VIPSalesPage.contents.CRStrategicIntent.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent.verifyText("STRATEGIC INTENT");
		VIPSalesPage.contents.CRSupportingInsight.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRSupportingInsight.verifyText("SUPPORTING INSIGHTS");
		VIPSalesPage.contents.Segment2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.Segment2.verifyText("Revenue Growth");
		VIPSalesPage.contents.RGStrategicIntent.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent.verifyText("STRATEGIC INTENT");
		VIPSalesPage.contents.RGSupportingInsight.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGSupportingInsight.verifyText("SUPPORTING INSIGHTS");
		VIPSalesPage.contents.Segment3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.Segment3.verifyText("Structural Balance Sheet Issues");
		VIPSalesPage.contents.SBSIStrategicIntent.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent.verifyText("STRATEGIC INTENT");
		VIPSalesPage.contents.SBSISupportingInsight.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSISupportingInsight.verifyText("SUPPORTING INSIGHTS");
		WebControl.takeScreenshot("Sales_Reg_Auto_008");
		
		ReportLog.setTestCase("Sales_Reg_Auto_009");
		String SI1 = VIPSalesPage.contents.CRSupportingInsightText.getText();
		VIPSalesPage.contents.CRStrategicIntent2.click();
		VIPSalesPage.contents.CRSupportingInsightText.verifyText(SI1, false);
		String SI2 = VIPSalesPage.contents.CRSupportingInsightText.getText();
		VIPSalesPage.contents.CRStrategicIntent3.click();
		VIPSalesPage.contents.CRSupportingInsightText.verifyText(SI2, false);
		String SI3 = VIPSalesPage.contents.RGSupportingInsightText.getText();
		VIPSalesPage.contents.RGStrategicIntent2.click();
		VIPSalesPage.contents.RGSupportingInsightText.verifyText(SI3, false);
		String SI4 = VIPSalesPage.contents.RGSupportingInsightText.getText();
		VIPSalesPage.contents.RGStrategicIntent3.click();
		VIPSalesPage.contents.RGSupportingInsightText.verifyText(SI4, false);
		String SI5 = VIPSalesPage.contents.SBSISupportingInsightText.getText();
		VIPSalesPage.contents.SBSIStrategicIntent2.click();
		VIPSalesPage.contents.SBSISupportingInsightText.verifyText(SI5, false);
		String SI6 = VIPSalesPage.contents.SBSISupportingInsightText.getText();
		VIPSalesPage.contents.SBSIStrategicIntent3.click();
		VIPSalesPage.contents.SBSISupportingInsightText.verifyText(SI6, false);
		WebControl.takeScreenshot("Sales_Reg_Auto_009");
		
		ReportLog.setTestCase("Sales_Reg_Auto_010");
		VIPSalesPage.contents.GrayLine1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.GrayLine2.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_010");
		
		ReportLog.setTestCase("Sales_Reg_Auto_011");
		VIPSalesPage.contents.CRStrategicIntent1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent4.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent5.verifyDisplayed(false);
		VIPSalesPage.contents.RGStrategicIntent1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent4.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent5.verifyDisplayed(false);
		VIPSalesPage.contents.SBSIStrategicIntent1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent4.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent5.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_011");
		
		ReportLog.setTestCase("Sales_Reg_Auto_013");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.SideMenuTranscript.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.waitForExist(true, 200);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.EventTypeEarningsCall.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.waitForExist(true, 10);
		String EarningsCall = VIPTranscriptPage.contents.FirstTranscriptTitle.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPSalesPage.contents.ClientPriorities.click();
		VIPSalesPage.contents.FootNote.waitForExist(true, 10);
		VIPSalesPage.contents.FootNote.verifyText("Source: " + EarningsCall + "; Accenture Client Value Services.");
		WebControl.takeScreenshot("Sales_Reg_Auto_013");
		
		ReportLog.setTestCase("Sales_Reg_Auto_012");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.noTransCompany);
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
		VIPSalesPage.contents.VPSegment1.waitForExist(true, 60);
		VIPSalesPage.contents.ClientPriorities.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.CRNoData.verifyDisplayed(true, 10);
		VIPSalesPage.contents.CRNoData.verifyText("No Clear Guidance Available.");
		VIPSalesPage.contents.RGNoData.verifyDisplayed(true, 10);
		VIPSalesPage.contents.RGNoData.verifyText("No Clear Guidance Available.");
		VIPSalesPage.contents.SBSINoData.verifyDisplayed(true, 10);
		VIPSalesPage.contents.SBSINoData.verifyText("No Clear Guidance Available.");
		WebControl.takeScreenshot("Sales_Reg_Auto_012");
		
		ReportLog.setTestCase("Sales_Reg_Auto_014_1_&_017");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Facebook");
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
		VIPSalesPage.contents.ClientPriorities.click();
		Thread.sleep(3000);
		if (VIPSalesPage.contents.CRStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.CRSTITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRSUITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGSTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.RGSUITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.SBSISTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.SBSISUITooltipIcon.verifyDisplayed(false);}
		else if (VIPSalesPage.contents.RGStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.RGSTITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGSUITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRSTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.CRSUITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.SBSISTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.SBSISUITooltipIcon.verifyDisplayed(false);}
		else {VIPSalesPage.contents.SBSISTITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSISUITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRSTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.CRSUITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.RGSTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.RGSUITooltipIcon.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_014_1_&_017");
		
		ReportLog.setTestCase("Sales_Reg_Auto_014_2");
		if (VIPSalesPage.contents.CRStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.CRSTITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.stiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_2_1");
		VIPSalesPage.contents.CRSTITooltipIcon.click();}
		else if (VIPSalesPage.contents.RGStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.RGSTITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.stiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_2_2");
		VIPSalesPage.contents.RGSTITooltipIcon.click();}
		else if (VIPSalesPage.contents.SBSIStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.SBSISTITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.stiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_2_3");
		VIPSalesPage.contents.SBSISTITooltipIcon.click();}
		
		ReportLog.setTestCase("Sales_Reg_Auto_014_3");
		if (VIPSalesPage.contents.CRSupportingInsight.isDisplayed()) {
		VIPSalesPage.contents.CRSUITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.suiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_3_1");
		VIPSalesPage.contents.CRSUITooltipIcon.click();}
		else if (VIPSalesPage.contents.RGSupportingInsight.isDisplayed()) {
		VIPSalesPage.contents.RGSUITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.suiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_3_2");
		VIPSalesPage.contents.RGSUITooltipIcon.click();}
		else if (VIPSalesPage.contents.SBSISupportingInsight.isDisplayed()) {
		VIPSalesPage.contents.SBSISUITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.suiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_3_3");
		VIPSalesPage.contents.SBSISUITooltipIcon.click();}
		
		ReportLog.setTestCase("Sales_Reg_Auto_015");
		String RGStrategicIntentText1_1 = VIPSalesPage.contents.RGStrategicIntentText1.getText();
		int Length1 = RGStrategicIntentText1_1.length();
		String RGStrategicIntentText1_2 = RGStrategicIntentText1_1.substring(0, Length1 - 3);
		if (Length1 < 133) {
		VIPSalesPage.contents.RGStrategicIntentText1.verifyText(RGStrategicIntentText1_1);}
		else {VIPSalesPage.contents.RGStrategicIntentText1.verifyText(RGStrategicIntentText1_2 + "...");}
		
		String RGStrategicIntentText2_1 = VIPSalesPage.contents.RGStrategicIntentText2.getText();
		int Length2 = RGStrategicIntentText2_1.length();
		String RGStrategicIntentText2_2 = RGStrategicIntentText2_1.substring(0, Length2 - 3);
		if (Length1 < 133) {
		VIPSalesPage.contents.RGStrategicIntentText2.verifyText(RGStrategicIntentText2_1);}
		else {VIPSalesPage.contents.RGStrategicIntentText2.verifyText(RGStrategicIntentText2_2 + "...");}
		
		String RGStrategicIntentText3_1 = VIPSalesPage.contents.RGStrategicIntentText3.getText();
		int Length3 = RGStrategicIntentText3_1.length();
		String RGStrategicIntentText3_2 = RGStrategicIntentText3_1.substring(0, Length3 - 3);
		if (Length1 < 133) {
		VIPSalesPage.contents.RGStrategicIntentText3.verifyText(RGStrategicIntentText3_1);}
		else {VIPSalesPage.contents.RGStrategicIntentText3.verifyText(RGStrategicIntentText3_2 + "...");}
		
		String RGStrategicIntentText4_1 = VIPSalesPage.contents.RGStrategicIntentText4.getText();
		int Length4 = RGStrategicIntentText4_1.length();
		String RGStrategicIntentText4_2 = RGStrategicIntentText4_1.substring(0, Length4 - 3);
		if (Length1 < 133) {
		VIPSalesPage.contents.RGStrategicIntentText4.verifyText(RGStrategicIntentText4_1);}
		else {VIPSalesPage.contents.RGStrategicIntentText4.verifyText(RGStrategicIntentText4_2 + "...");}
		WebControl.takeScreenshot("Sales_Reg_Auto_015");
		
	}
	
}


