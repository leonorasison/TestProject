package scenarios.SALES;

import org.testng.annotations.Test;
import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import auto.framework.web.WebControl1;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPExecutivesPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPLogInPage;
import pageobjects.VIPNewsPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPTranscriptPage;
import pageobjects.VIPFinancialsPage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalesLeadership_07_IndustryXOKPIs extends TestBase{
	
	@Test
	public void Sales_IndustryXOKPIs () throws Exception {
		ReportLog.setTestName("Sales Leadership - Industry XO KPIs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_152");	
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(true);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(true);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(true);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(false);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(false);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(true);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true);
		VIPSalesPage.contents.IndustryXOText.verifyDisplayed(true);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(false);
		VIPSalesPage.contents.ZeroBasedApproachText.verifyDisplayed(false);
		VIPSalesPage.contents.DigitalOutreachText.verifyDisplayed(true);
		VIPSalesPage.contents.CommercialExcellenceText.verifyDisplayed(true);
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
		Thread.sleep(3000);
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
		Thread.sleep(3000);
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
		Thread.sleep(3000);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true);
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
		Thread.sleep(3000);
		VIPSalesPage.contents.ITAndBackOfficeText.verifyDisplayed(true);
		VIPSalesPage.contents.IntelligentSourcingText.verifyDisplayed(false);
		VIPSalesPage.contents.IntelligentSupplyChainText.verifyDisplayed(true);
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
		
}


