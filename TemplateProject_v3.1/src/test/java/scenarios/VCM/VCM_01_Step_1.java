package scenarios.VCM;

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
import pageobjects.VIPVCMPage;

public class VCM_01_Step_1 extends TestBase{
	
	@Test
	public void VCM_Step_1 () throws Exception {
		ReportLog.setTestName("VCM - Step 1");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("VCM_Reg_Auto_001");
		VIP_Common.LogInPage(testDataHandler);
		Thread.sleep(3000);
		//VIPLandingPage.contents.NewQVWarningCloseButton.click();
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		//VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
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
		//VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		VIPLandingPage.contents.CompanyNameTextbox.type(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(4000);
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
		VIPVCMPage.contents.SideMenuVCM.verifyDisplayed(true, 60);
		Thread.sleep(3000);
		WebControl.takeScreenshot("VCM_Reg_Auto_001");
		
		ReportLog.setTestCase("VCM_Reg_Auto_002_to_007");
		VIPLandingPage.contents.HelpIcon.hover();
        Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(5000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
		//VCM_Reg_Auto_002_&_003
		VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 40);
		WebControl.takeScreenshot("VCM_Reg_Auto_002_&_003");
		//VCM_Reg_Auto_004
		VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModalTitle.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModalTitle.verifyText("What is Value Case Modeler?");
		VIPVCMPage.contents.VCMModalHeader.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModalHeader.verifyText("A customizable business case tool that measures the value impact of initiatives on an organization’s key financials and helps prioritize initiatives for clients.");
		VIPVCMPage.contents.VCMModal1stStepTitle.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModal1stStepTitle.verifyText("How to use?");
		VIPVCMPage.contents.VCMModal1stStepDescription.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModal1stStepDescription.verifyText("Select from pre-defined or define custom Value Creation Opportunities (VCO) Based upon company performance");
		VIPVCMPage.contents.VCMModal2ndStepDescription.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModal2ndStepDescription.verifyText("Input key assumptions across growth, profitability and capex levers");
		VIPVCMPage.contents.VCMModal3rdStepDescription.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModal3rdStepDescription.verifyText("Analyze VCO Impact on company's financials (such as enterprise value, revenue and EBIT margin) and prioritize initiatives");
		VIPVCMPage.contents.VCMModalDownloadUserGuideButton.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModalDownloadUserGuideButton.verifyText("DOWNLOAD USER GUIDE");
		VIPVCMPage.contents.VCMModalDoNotShowCheckbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModalDoNotShowText.verifyText("Do not show this message again");
		WebControl.takeScreenshot("VCM_Reg_Auto_004");
		//VCM_Reg_Auto_005
		VIPVCMPage.contents.VCMModalDoNotShowCheckbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModalDoNotShowText.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("VCM_Reg_Auto_005");
		//VCM_Reg_Auto_006
		VIPVCMPage.contents.VCMModalDownloadUserGuideButton.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		WebControl.takeScreenshot("VCM_Reg_Auto_006");
		//VCM_Reg_Auto_007
		WebControl.switchWithTitle("Home - Value Insights Platform");
		VIPVCMPage.contents.VCMModalCloseButton.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModalCloseButton.click();
		VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 2); //Lsison, 20211020, change to true
		VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 5);}
		VIPVCMPage.contents.VCMModal.verifyDisplayed(false, 2); 
		VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 25);
		WebControl.takeScreenshot("VCM_Reg_Auto_007");
		
		ReportLog.setTestCase("VCM_Reg_Auto_008");
		VIPVCMPage.contents.NextButtonDisabled.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyText("Select atleast one VCO");
		VIPVCMPage.contents.CRVCOCOGS.click();
		VIPVCMPage.contents.NextButtonEnabled.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonDisabled.verifyDisplayed(false, 2);
		VIPVCMPage.contents.NextButtonNote.verifyDisplayed(false, 2);
		VIPVCMPage.contents.CRVCOCOGS.click();
		VIPVCMPage.contents.NextButtonEnabled.verifyDisplayed(false, 2);
		VIPVCMPage.contents.NextButtonDisabled.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyText("Select atleast one VCO");
		WebControl.takeScreenshot("VCM_Reg_Auto_008");
		
		ReportLog.setTestCase("VCM_Reg_Auto_009");
		VIPVCMPage.contents.SelectedProgressBar.verifyDisplayed(true, 5);
		VIPVCMPage.contents.UnselectedProgressBar1.verifyDisplayed(false, 2);
		VIPVCMPage.contents.UnselectedProgressBar2.verifyDisplayed(false, 2);
		VIPVCMPage.contents.ProgressBarStep1.verifyDisplayed(true, 5);
		VIPVCMPage.contents.ProgressBarStep1.verifyText("STEP 1");
		VIPVCMPage.contents.ProgressBarStep2.verifyDisplayed(true, 5);
		VIPVCMPage.contents.ProgressBarStep2.verifyText("STEP 2");
		VIPVCMPage.contents.ProgressBarStep3.verifyDisplayed(true, 5);
		VIPVCMPage.contents.ProgressBarStep3.verifyText("STEP 3");
		WebControl.takeScreenshot("VCM_Reg_Auto_009");
		
		ReportLog.setTestCase("VCM_Reg_Auto_010");
		VIPVCMPage.contents.SegmentHeader1.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SegmentHeader1.verifyText("Cost Reduction");
		VIPVCMPage.contents.SegmentHeader2.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SegmentHeader2.verifyText("Revenue Growth");
		VIPVCMPage.contents.SegmentHeader3.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SegmentHeader3.verifyText("Asset Efficiency");
		VIPVCMPage.contents.SegmentHeader4.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SegmentHeader4.verifyText("Add Custom VCO");
		WebControl.takeScreenshot("VCM_Reg_Auto_010");
		
		ReportLog.setTestCase("VCM_Reg_Auto_011");
		VIPVCMPage.contents.SectionHeader1.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SectionHeader1.verifyText("COMPANY PERFORMANCE");
		VIPVCMPage.contents.SectionHeader2.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SectionHeader2.verifyText("VALUE CREATION OPPORTUNITIES (VCO)");
		VIPVCMPage.contents.SectionHeader3.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SectionHeader3.verifyText("COMPANY PERFORMANCE");
		VIPVCMPage.contents.SectionHeader4.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SectionHeader4.verifyText("VALUE CREATION OPPORTUNITIES (VCO)");
		VIPVCMPage.contents.SectionHeader5.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SectionHeader5.verifyText("COMPANY PERFORMANCE");
		VIPVCMPage.contents.SectionHeader6.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SectionHeader6.verifyText("VALUE CREATION OPPORTUNITIES (VCO)");
		WebControl.takeScreenshot("VCM_Reg_Auto_011");
		
		ReportLog.setTestCase("VCM_Reg_Auto_012");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.CAGR5YrKPI.hover();
		
		String COGSKPIT1 = VIPFinancialsPage.contents.COGSKPI.getText();
		String COGSKPIT2 = COGSKPIT1.replace("%", "");
		double COGSKPIT = Double.parseDouble(COGSKPIT2);
		String COGSKPIP1 = VIPFinancialsPage.contents.COGSKPIP.getText();
		String COGSKPIP2 = COGSKPIP1.replace("%", "");
		double COGSKPIP = Double.parseDouble(COGSKPIP2);
		
		String SGAKPIT1 = VIPFinancialsPage.contents.SGAKPI.getText();
		String SGAKPIT2 = SGAKPIT1.replace("%", "");
		double SGAKPIT = Double.parseDouble(SGAKPIT2);
		String SGAKPIP1 = VIPFinancialsPage.contents.SGAKPIP.getText();
		String SGAKPIP2 = SGAKPIP1.replace("%", "");
		double SGAKPIP = Double.parseDouble(SGAKPIP2);
		
		String CAGR3YrKPIT1 = VIPFinancialsPage.contents.CAGR3YrKPI.getText();
		String CAGR3YrKPIT2 = CAGR3YrKPIT1.replace("%", "");
		double CAGR3YrKPIT = Double.parseDouble(CAGR3YrKPIT2);
		String CAGR3YrKPIP1 = VIPFinancialsPage.contents.CAGR3YrKPIP.getText();
		String CAGR3YrKPIP2 = CAGR3YrKPIP1.replace("%", "");
		double CAGR3YrKPIP = Double.parseDouble(CAGR3YrKPIP2);
		
		String CAGR2YrKPIT1 = VIPFinancialsPage.contents.CAGR2YrKPI.getText();
		String CAGR2YrKPIT2 = CAGR2YrKPIT1.replace("%", "");
		double CAGR2YrKPIT = Double.parseDouble(CAGR2YrKPIT2);
		String CAGR2YrKPIP1 = VIPFinancialsPage.contents.CAGR2YrKPIP.getText();
		String CAGR2YrKPIP2 = CAGR2YrKPIP1.replace("%", "");
		double CAGR2YrKPIP = Double.parseDouble(CAGR2YrKPIP2);
		
		String NetPPEKPIT1 = VIPFinancialsPage.contents.NetPPEKPI.getText();
		String NetPPEKPIT2 = NetPPEKPIT1.replace("%", "");
		double NetPPEKPIT = Double.parseDouble(NetPPEKPIT2);
		String NetPPEKPIP1 = VIPFinancialsPage.contents.NetPPEKPIP.getText();
		String NetPPEKPIP2 = NetPPEKPIP1.replace("%", "");
		double NetPPEKPIP = Double.parseDouble(NetPPEKPIP2);
		
		String AccPayRevKPIT1 = VIPFinancialsPage.contents.AccPayRevKPI.getText();
		String AccPayRevKPIT2 = AccPayRevKPIT1.replace("%", "");
		double AccPayRevKPIT = Double.parseDouble(AccPayRevKPIT2);
		String AccPayRevKPIP1 = VIPFinancialsPage.contents.AccPayRevKPIP.getText();
		String AccPayRevKPIP2 = AccPayRevKPIP1.replace("%", "");
		double AccPayRevKPIP = Double.parseDouble(AccPayRevKPIP2);
		
		String NetRecRevKPIT1 = VIPFinancialsPage.contents.NetRecRevKPI.getText();
		String NetRecRevKPIT2 = NetRecRevKPIT1.replace("%", "");
		double NetRecRevKPIT = Double.parseDouble(NetRecRevKPIT2);
		String NetRecRevKPIP1 = VIPFinancialsPage.contents.NetRecRevKPIP.getText();
		String NetRecRevKPIP2 = NetRecRevKPIP1.replace("%", "");
		double NetRecRevKPIP = Double.parseDouble(NetRecRevKPIP2);
		
		String InvRevKPIT1 = VIPFinancialsPage.contents.InvRevKPI.getText();
		String InvRevKPIT2 = InvRevKPIT1.replace("%", "");
		double InvRevKPIT = Double.parseDouble(InvRevKPIT2);
		String InvRevKPIP1 = VIPFinancialsPage.contents.InvRevKPIP.getText();
		String InvRevKPIP2 = InvRevKPIP1.replace("%", "");
		double InvRevKPIP = Double.parseDouble(InvRevKPIP2);
		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.SideMenuVCM.click();
		VIPLandingPage.contents.HelpIcon.hover();
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
		VIPVCMPage.contents.VCMModalCloseButton.click();}
		VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 25);
		//COGS / Revenue
		VIPVCMPage.contents.KPINameCOGS.waitForExist(true, 25);
		VIPVCMPage.contents.KPINameCOGS.hover();
		VIPVCMPage.contents.KPINameCOGS.verifyText("COGS / Revenue");
		VIPVCMPage.contents.KPICOGS.verifyText(COGSKPIT1);
		if (COGSKPIP >= COGSKPIT) {
		VIPVCMPage.contents.CircleGreenCOGS.verifyDisplayed(true, 3);}
		else {VIPVCMPage.contents.CircleRedCOGS.verifyDisplayed(true, 3);}
		//SG&A / Revenue
		VIPVCMPage.contents.KPINameSGA.verifyText("SG&A / Revenue");
		VIPVCMPage.contents.KPISGA.verifyText(SGAKPIT1);
		if (SGAKPIP >= SGAKPIT) {
		VIPVCMPage.contents.CircleGreenSGA.verifyDisplayed(true, 3);}
		else {VIPVCMPage.contents.CircleRedSGA.verifyDisplayed(true, 3);}
		//Legend
		VIPVCMPage.contents.BetterLegendText1.verifyDisplayed(true, 3);
		VIPVCMPage.contents.BetterLegendText1.verifyText("Better than Peer Median");
		VIPVCMPage.contents.BetterLegendCircle1.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText1.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText1.verifyText("Worse than Peer Median");
		VIPVCMPage.contents.WorstLegendCircle1.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_012");
		
		ReportLog.setTestCase("VCM_Reg_Auto_013");
		//COGS
		VIPVCMPage.contents.CRVCOCOGS.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOCOGS.verifyText("ZBSC (COGS)");
		VIPVCMPage.contents.CRVCOCOGSCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOCOGSTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOCOGSTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOCOGSTooltip.click();
		//SGA
		VIPVCMPage.contents.CRVCOSGA.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOSGA.verifyText("ZBS (SG&A)");
		VIPVCMPage.contents.CRVCOSGACheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOSGATooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOSGATooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOSGATooltip.click();
		//Front Office
		VIPVCMPage.contents.CRVCOFO.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOFO.verifyText("ZBFO (front office)");
		VIPVCMPage.contents.CRVCOFOCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOFOTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOFOTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOFOTooltip.click();
		//Organization
		VIPVCMPage.contents.CRVCOOrg.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOOrg.verifyText("ZBO (organization)");
		VIPVCMPage.contents.CRVCOOrgCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOOrgTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOOrgTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOOrgTooltip.click();
		VIPVCMPage.contents.CRVCOCOGS.click();
		VIPVCMPage.contents.CRVCOCOGSCheckboxU.verifyDisplayed(false, 2);
		VIPVCMPage.contents.CRVCOCOGSCheckboxT.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_013");
		
		ReportLog.setTestCase("VCM_Reg_Auto_014");
		//3-yr Revenue CAGR (historical)
		VIPVCMPage.contents.KPIName3YrCAGR.verifyText("3-yr Revenue CAGR (historical)");
		VIPVCMPage.contents.KPI3YrCAGR.verifyText(CAGR3YrKPIT1);
		if (CAGR3YrKPIT >= CAGR3YrKPIP) {
		VIPVCMPage.contents.CircleGreen3YrCAGR.verifyDisplayed(true, 3);}
		else {VIPVCMPage.contents.CircleRed3YrCAGR.verifyDisplayed(true, 3);}
		//2-yr Revenue CAGR (forecast)
		VIPVCMPage.contents.KPIName2YrCAGR.verifyText("2-yr Revenue CAGR (forecast)");
		VIPVCMPage.contents.KPI2YrCAGR.verifyText(CAGR2YrKPIT1);
		if (CAGR2YrKPIT >= CAGR2YrKPIP) {
		VIPVCMPage.contents.CircleGreen2YrCAGR.verifyDisplayed(true, 3);}
		else {VIPVCMPage.contents.CircleRed2YrCAGR.verifyDisplayed(true, 3);}
		//Legend
		VIPVCMPage.contents.BetterLegendText2.verifyDisplayed(true, 3);
		VIPVCMPage.contents.BetterLegendText2.verifyText("Better than Peer Median");
		VIPVCMPage.contents.BetterLegendCircle2.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText2.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText2.verifyText("Worse than Peer Median");
		VIPVCMPage.contents.WorstLegendCircle2.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_014");
		
		ReportLog.setTestCase("VCM_Reg_Auto_015");
		//PO
		VIPVCMPage.contents.RGVCOPO.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOPO.verifyText("Price Optimization");
		VIPVCMPage.contents.RGVCOPOCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOPOTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOPOTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOPOTooltip.click();
		//IBD
		VIPVCMPage.contents.RGVCOIBD.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOIBD.verifyText("Increase Brand Distinction");
		VIPVCMPage.contents.RGVCOIBDCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOIBDTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOIBDTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOIBDTooltip.click();
		//CCR
		VIPVCMPage.contents.RGVCOCCR.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCCR.verifyText("Customer Churn Reduction");
		VIPVCMPage.contents.RGVCOCCRCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCCRTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCCRTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCCRTooltip.click();
		//SE
		VIPVCMPage.contents.RGVCOSE.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSE.verifyText("Salesforce Effectiveness");
		VIPVCMPage.contents.RGVCOSECheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSETooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSETooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSETooltip.click();
		//RDPE
		VIPVCMPage.contents.RGVCORDPE.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCORDPE.verifyText("R&D Productivity Enhancement");
		VIPVCMPage.contents.RGVCORDPECheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCORDPETooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCORDPETooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCORDPETooltip.click();
		//NBM
		VIPVCMPage.contents.RGVCONBM.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCONBM.verifyText("New Business Models");
		VIPVCMPage.contents.RGVCONBMCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCONBMTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCONBMTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCONBMTooltip.click();
		//OP
		VIPVCMPage.contents.RGVCOOP.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOOP.verifyText("Omnichannel Presence");
		VIPVCMPage.contents.RGVCOOPCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOOPTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOOPTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOOPTooltip.click();
		//CDM
		VIPVCMPage.contents.RGVCOCDM.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCDM.verifyText("Customer Data Monetization");
		VIPVCMPage.contents.RGVCOCDMCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCDMTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCDMTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCDMTooltip.click();
		//SNA
		VIPVCMPage.contents.RGVCOSNA.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSNA.verifyText("Synergy from New Acquisitions");
		VIPVCMPage.contents.RGVCOSNACheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSNATooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSNATooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSNATooltip.click();
		//SPA
		VIPVCMPage.contents.RGVCOSPA.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSPA.verifyText("Synergy from Past Acquisitions");
		VIPVCMPage.contents.RGVCOSPACheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSPATooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSPATooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSPATooltip.click();
		VIPVCMPage.contents.RGVCOPO.click();
		VIPVCMPage.contents.RGVCOPOCheckboxU.verifyDisplayed(false, 2);
		VIPVCMPage.contents.RGVCOPOCheckboxT.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_015");
		
		ReportLog.setTestCase("VCM_Reg_Auto_016");
		//Net PP&E / Revenue
		VIPVCMPage.contents.KPINameNetPPE.verifyText("Net PP&E / Revenue");
		VIPVCMPage.contents.KPINetPPE.verifyText(NetPPEKPIT1);
		if (NetPPEKPIP >= NetPPEKPIT) {
		VIPVCMPage.contents.CircleGreenNetPPE.verifyDisplayed(true, 3);}
		else {VIPVCMPage.contents.CircleRedNetPPE.verifyDisplayed(true, 3);}
		//Payables / Revenue
		VIPVCMPage.contents.KPINamePayRev.verifyText("Payables / Revenue");
		VIPVCMPage.contents.KPIPayRev.verifyText(AccPayRevKPIT1);
		if (AccPayRevKPIT >= AccPayRevKPIP) {
		VIPVCMPage.contents.CircleGreenPayRev.verifyDisplayed(true, 3);}
		else {VIPVCMPage.contents.CircleRedPayRev.verifyDisplayed(true, 3);}
		//Receivables / Revenue
		VIPVCMPage.contents.KPINameRecRev.verifyText("Receivables / Revenue");
		VIPVCMPage.contents.KPIRecRev.verifyText(NetRecRevKPIT1);
		if (NetRecRevKPIP >= NetRecRevKPIT) {
		VIPVCMPage.contents.CircleGreenRecRev.verifyDisplayed(true, 3);}
		else {VIPVCMPage.contents.CircleRedRecRev.verifyDisplayed(true, 3);}
		//Inventory / Revenue
		VIPVCMPage.contents.KPINameInvRev.verifyText("Inventory / Revenue");
		VIPVCMPage.contents.KPIInvRev.verifyText(InvRevKPIT1);
		/* Lsison, 20211020, Comment old code will add new code with CircleOrangeInvRev
		 * if (InvRevKPIP >= InvRevKPIT) {
		 * VIPVCMPage.contents.CircleGreenInvRev.verifyDisplayed(true, 3);} else
		 * {VIPVCMPage.contents.CircleRedInvRev.verifyDisplayed(true, 3);}
		 */
		
		//Lsison, 20211020, Add condition for CircleOrange
		if (InvRevKPIP > InvRevKPIT) {
			VIPVCMPage.contents.CircleGreenInvRev.verifyDisplayed(true, 3);
		} else if (InvRevKPIP == InvRevKPIT) {
			VIPVCMPage.contents.CircleOrangeInvRev.verifyDisplayed(true, 3);
		} else {VIPVCMPage.contents.CircleRedInvRev.verifyDisplayed(true, 3);
		}
		
		//Legend
		VIPVCMPage.contents.BetterLegendText3.verifyDisplayed(true, 3);
		VIPVCMPage.contents.BetterLegendText3.verifyText("Better than Peer Median");
		VIPVCMPage.contents.BetterLegendCircle3.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText3.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText3.verifyText("Worse than Peer Median");
		VIPVCMPage.contents.WorstLegendCircle3.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_016");
		
		ReportLog.setTestCase("VCM_Reg_Auto_017");
		//NPR
		VIPVCMPage.contents.AEVCONPR.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPR.verifyText("Net PP&E Rationalization");
		VIPVCMPage.contents.AEVCONPRCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPRTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPRTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPRTooltip.click();
		//NPUI
		VIPVCMPage.contents.AEVCONPUI.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPUI.verifyText("Net PP&E Utilization Improvement");
		VIPVCMPage.contents.AEVCONPUICheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPUITooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPUITooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPUITooltip.click();
		//CM
		VIPVCMPage.contents.AEVCOCM.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOCM.verifyText("Contract Manufacturing");
		VIPVCMPage.contents.AEVCOCMCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOCMTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOCMTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOCMTooltip.click();
		//DF
		VIPVCMPage.contents.AEVCODF.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCODF.verifyText("Digital Factory");
		VIPVCMPage.contents.AEVCODFCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCODFTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCODFTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCODFTooltip.click();
		//FRC
		VIPVCMPage.contents.AEVCOFRC.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOFRC.verifyText("Faster Receivables Collection");
		VIPVCMPage.contents.AEVCOFRCCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOFRCTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOFRCTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOFRCTooltip.click();
		//RF
		VIPVCMPage.contents.AEVCORF.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCORF.verifyText("Receivables Factorization");
		VIPVCMPage.contents.AEVCORFCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCORFTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCORFTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCORFTooltip.click();
		//VR
		VIPVCMPage.contents.AEVCOVR.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOVR.verifyText("Vendor Rationalization");
		VIPVCMPage.contents.AEVCOVRCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOVRTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOVRTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOVRTooltip.click();
		//IR
		VIPVCMPage.contents.AEVCOIR.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOIR.verifyText("Inventory Rationalization");
		VIPVCMPage.contents.AEVCOIRCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOIRTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOIRTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOIRTooltip.click();
		VIPVCMPage.contents.AEVCONPR.click();
		VIPVCMPage.contents.AEVCONPRCheckboxU.verifyDisplayed(false, 2);
		VIPVCMPage.contents.AEVCONPRCheckboxT.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_017");
		
		ReportLog.setTestCase("VCM_Reg_Auto_018");
		VIPVCMPage.contents.VCOName.verifyDisplayed(true, 3);
		VIPVCMPage.contents.VCOCategory.verifyDisplayed(true, 3);
		VIPVCMPage.contents.VCODescription.verifyDisplayed(true, 3);
		VIPVCMPage.contents.VCOAddDisabled.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_018");
		
		ReportLog.setTestCase("VCM_Reg_Auto_019");
		VIPVCMPage.contents.VCOCategory.click();
		VIPVCMPage.contents.VCOCategory1.verifyText("Cost Reduction");
		VIPVCMPage.contents.VCOCategory2.verifyText("Revenue Growth");
		VIPVCMPage.contents.VCOCategory3.verifyText("Asset Efficiency");
		WebControl.takeScreenshot("VCM_Reg_Auto_019");
		
		ReportLog.setTestCase("VCM_Reg_Auto_020");
		VIPVCMPage.contents.VCOCategory1.click();
		VIPVCMPage.contents.VCOName.sendKeys("Test");
		VIPVCMPage.contents.VCODescription.sendKeys("Testing");
		VIPVCMPage.contents.VCOAddEnabled.click();
		VIPVCMPage.contents.AddedVCOListHeader1.verifyText("VCO Name");
		VIPVCMPage.contents.AddedVCOListHeader2.verifyText("VCO Category");
		VIPVCMPage.contents.AddedVCOListHeader3.verifyText("VCO Description");
		VIPVCMPage.contents.AddedVCOName1.verifyText("Test");
		VIPVCMPage.contents.AddedVCOCategory1.verifyText("Cost Reduction");
		VIPVCMPage.contents.AddedVCODescription1.verifyText("Testing");
		VIPVCMPage.contents.AddedVCOEditButton1.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AddedVCODeleteButton1.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_020");
		
		ReportLog.setTestCase("VCM_Reg_Auto_021");
		VIPVCMPage.contents.AddedVCOEditButton1.click();
		VIPVCMPage.contents.VCOName.clear();
		VIPVCMPage.contents.VCOName.sendKeys("Test 1");
		VIPVCMPage.contents.VCOCategory.click();
		VIPVCMPage.contents.VCOCategory2.click();
		VIPVCMPage.contents.VCODescription.clear();
		VIPVCMPage.contents.VCODescription.sendKeys("Testing 1");
		VIPVCMPage.contents.VCOEdit.click();
		VIPVCMPage.contents.AddedVCOName1.verifyText("Test 1");
		VIPVCMPage.contents.AddedVCOCategory1.verifyText("Revenue Growth");
		VIPVCMPage.contents.AddedVCODescription1.verifyText("Testing 1");
		WebControl.takeScreenshot("VCM_Reg_Auto_021_1");
		VIPVCMPage.contents.AddedVCODeleteButton1.click();
		VIPVCMPage.contents.AddedVCOName1.verifyDisplayed(false, 1);
		VIPVCMPage.contents.AddedVCOCategory1.verifyDisplayed(false, 1);
		VIPVCMPage.contents.AddedVCODescription1.verifyDisplayed(false, 1);
		VIPVCMPage.contents.AddedVCOEditButton1.verifyDisplayed(false, 1);
		VIPVCMPage.contents.AddedVCODeleteButton1.verifyDisplayed(false, 1);
		WebControl.takeScreenshot("VCM_Reg_Auto_021_2");
		
		ReportLog.setTestCase("VCM_Reg_Auto_022");
		VIPVCMPage.contents.VCOName.sendKeys("Test");
		VIPVCMPage.contents.VCOCategory.click();
		VIPVCMPage.contents.VCOCategory2.click();
		VIPVCMPage.contents.VCOAddEnabled.click();
		VIPVCMPage.contents.AddedVCOName1.verifyText("Test");
		VIPVCMPage.contents.AddedVCOCategory1.verifyText("Revenue Growth");
		VIPVCMPage.contents.AddedVCODescription1.verifyText("");
		WebControl.takeScreenshot("VCM_Reg_Auto_022");
		
		ReportLog.setTestCase("VCM_Reg_Auto_023");
		VIPLandingPage.contents.HelpIcon.hover();
		//COGS
		VIPVCMPage.contents.CircleCOGS.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(COGSKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(COGSKPIP1);
		//SGA
		VIPVCMPage.contents.CircleSGA.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(SGAKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(SGAKPIP1);
		//3YrCAGR
		VIPVCMPage.contents.Circle3YrCAGR.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(CAGR3YrKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(CAGR3YrKPIP1);
		//2YrCAGR
		VIPVCMPage.contents.Circle2YrCAGR.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(CAGR2YrKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(CAGR2YrKPIP1);
		//NetPPE
		VIPVCMPage.contents.CircleNetPPE.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(NetPPEKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(NetPPEKPIP1);
		//PayRev
		VIPVCMPage.contents.CirclePayRev.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(AccPayRevKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(AccPayRevKPIP1);
		//RecRev
		VIPVCMPage.contents.CircleRecRev.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(NetRecRevKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(NetRecRevKPIP1);
		//InvRev
		VIPVCMPage.contents.CircleInvRev.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(InvRevKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(InvRevKPIP1);
		WebControl.takeScreenshot("VCM_Reg_Auto_023");
		
		ReportLog.setTestCase("VCM_Reg_Auto_024");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		
		//LSison 20211015 add report saving confirmation message before searching again
		VIPOverviewPage.contents.ExitSavePopup.verifyDisplayed(true, 20);
		VIPOverviewPage.contents.ExitSavePopupText.verifyText("Are you sure you want to leave before saving the report?");
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();
		Thread.sleep(2000);
		
		VIPLandingPage.contents.CompanyNameTextbox.type(testDataHandler.privCompany);
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
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
		VIPVCMPage.contents.VCMModalCloseButton.click();}
		VIPVCMPage.contents.VCMBodyTitle.waitForExist(true, 25);
		VIPVCMPage.contents.VCMPrivateCompMessage.verifyDisplayed(true, 25);
		VIPVCMPage.contents.VCMPrivateCompMessage.verifyText("The Value Case Modeler is available for publicly listed companies only.");
		WebControl.takeScreenshot("VCM_Reg_Auto_024");
		
		ReportLog.setTestCase("VCM_Reg_Auto_025");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		
		//LSison 20211015 add report saving confirmation message before searching again
		VIPOverviewPage.contents.ExitSavePopup.verifyDisplayed(true, 20);
		VIPOverviewPage.contents.ExitSavePopupText.verifyText("Are you sure you want to leave before saving the report?");
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();
		Thread.sleep(2000);
		
		VIPLandingPage.contents.CompanyNameTextbox.type("Deutsche Telekom AG");
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
		VIPVCMPage.contents.SideMenuVCM.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(4000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
		VIPVCMPage.contents.VCMModalCloseButton.click();}
		VIPVCMPage.contents.VCMBodyTitle.waitForExist(true, 25);
		VIPVCMPage.contents.KPINameCOGS.verifyText("Operating Expense / Revenue");
		VIPVCMPage.contents.KPICOGS.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_025");

	}
	
}


