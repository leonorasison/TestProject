package scenarios.VCM;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPVCMPage;

public class VCM_All extends TestBase {

	@Test(priority = 1)
	public void VCM_Step_1() throws Exception {
		ReportLog.setTestName("VCM - Step 1");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

		ReportLog.setTestCase("VCM_Reg_Auto_001 - Verify VALUE CASE MODELER  in Side Menu");
		VIP_Common.LogInPage(testDataHandler);
		Thread.sleep(3000);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
			VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
			VIPLandingPage.contents.DisclaimerProceedButton.click();
			VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
			VIPLandingPage.contents.NewDisclaimerProceedButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		} else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
			VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
			VIPLandingPage.contents.NewDisclaimerProceedButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		} else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
			VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
			VIPLandingPage.contents.DisclaimerProceedButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		} else {
			VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		}
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(4000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 30);
		Thread.sleep(4000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 30);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(4000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.verifyDisplayed(true, 60);
		Thread.sleep(3000);
		WebControl.takeScreenshot("VCM_Reg_Auto_001 - Verify VALUE CASE MODELER  in Side Menu");

		ReportLog.setTestCase("VCM_Reg_Auto_002 - Verify display of Select Value Creation Opportunites page ");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(5000);
		WebControl.takeScreenshot("VCM_Reg_Auto_002 - Verify display of Select Value Creation Opportunites page ");
		
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			// VCM_Reg_Auto_002_&_003
			VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 40);
			WebControl.takeScreenshot("VCM_Reg_Auto_002_&_003");
			// VCM_Reg_Auto_004
			VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
			VIPVCMPage.contents.VCMModalTitle.verifyDisplayed(true, 5);
			VIPVCMPage.contents.VCMModalTitle.verifyText("What is Value Case Modeler?");
			VIPVCMPage.contents.VCMModalHeader.verifyDisplayed(true);
			VIPVCMPage.contents.VCMModalHeader.verifyText(
					"A customizable business case tool that measures the value impact of initiatives on an organization’s key financials and helps prioritize initiatives for clients.");
			VIPVCMPage.contents.VCMModal1stStepTitle.verifyDisplayed(true);
			VIPVCMPage.contents.VCMModal1stStepTitle.verifyText("How to use?");
			VIPVCMPage.contents.VCMModal1stStepDescription.verifyDisplayed(true);
			VIPVCMPage.contents.VCMModal1stStepDescription.verifyText(
					"Select from pre-defined or define custom Value Creation Opportunities (VCO) Based upon company performance");
			VIPVCMPage.contents.VCMModal2ndStepDescription.verifyDisplayed(true);
			VIPVCMPage.contents.VCMModal2ndStepDescription
					.verifyText("Input key assumptions across growth, profitability and capex levers");
			VIPVCMPage.contents.VCMModal3rdStepDescription.verifyDisplayed(true);
			VIPVCMPage.contents.VCMModal3rdStepDescription.verifyText(
					"Analyze VCO Impact on company's financials (such as enterprise value, revenue and EBIT margin) and prioritize initiatives");
			VIPVCMPage.contents.VCMModalDownloadUserGuideButton.verifyDisplayed(true);
			VIPVCMPage.contents.VCMModalDownloadUserGuideButton.verifyText("DOWNLOAD USER GUIDE");
			VIPVCMPage.contents.VCMModalDoNotShowCheckbox.verifyDisplayed(true);
			VIPVCMPage.contents.VCMModalDoNotShowText.verifyText("Do not show this message again");
			WebControl.takeScreenshot("VCM_Reg_Auto_004");
			// VCM_Reg_Auto_005
			VIPVCMPage.contents.VCMModalDoNotShowCheckbox.verifyDisplayed(true);
			VIPVCMPage.contents.VCMModalDoNotShowText.verifyDisplayed(true);
			WebControl.takeScreenshot("VCM_Reg_Auto_005");
			// VCM_Reg_Auto_006
			VIPVCMPage.contents.VCMModalDownloadUserGuideButton.click();
			Thread.sleep(2000);
			WebControl.waitForPageToLoad(45);
			Thread.sleep(2000);
			WebControl.takeScreenshot("VCM_Reg_Auto_006");
			// VCM_Reg_Auto_007
			WebControl.switchWithTitle("Home - Value Insights Platform");
			VIPVCMPage.contents.VCMModalCloseButton.verifyDisplayed(true, 5);
			VIPVCMPage.contents.VCMModalCloseButton.click();
			VIPVCMPage.contents.VCMModal.verifyDisplayed(true); //Lsison, 20211020, change to true
			VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 5);
		} else {
			VIPVCMPage.contents.VCMModal.verifyDisplayed(false);
			VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 25);
		}
		WebControl.takeScreenshot("VCM_Reg_Auto_007");

		ReportLog.setTestCase("VCM_Reg_Auto_008");
		VIPVCMPage.contents.NextButtonDisabled.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyText("Select atleast one VCO");
		VIPVCMPage.contents.CRVCOCOGS.click();
		VIPVCMPage.contents.NextButtonEnabled.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonDisabled.verifyDisplayed(false);
		VIPVCMPage.contents.NextButtonNote.verifyDisplayed(false);
		VIPVCMPage.contents.CRVCOCOGS.click();
		VIPVCMPage.contents.NextButtonEnabled.verifyDisplayed(false);
		VIPVCMPage.contents.NextButtonDisabled.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyText("Select atleast one VCO");
		WebControl.takeScreenshot("VCM_Reg_Auto_008");

		ReportLog.setTestCase("VCM_Reg_Auto_009");
		VIPVCMPage.contents.SelectedProgressBar.verifyDisplayed(true, 5);
		VIPVCMPage.contents.UnselectedProgressBar1.verifyDisplayed(false);
		VIPVCMPage.contents.UnselectedProgressBar2.verifyDisplayed(false);
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
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 25);
		// COGS / Revenue
		VIPVCMPage.contents.KPINameCOGS.waitForExist(true, 25);
		VIPVCMPage.contents.KPINameCOGS.hover();
		VIPVCMPage.contents.KPINameCOGS.verifyText("COGS / Revenue");
		VIPVCMPage.contents.KPICOGS.verifyText(COGSKPIT1);
		if (COGSKPIP >= COGSKPIT) {
			VIPVCMPage.contents.CircleGreenCOGS.verifyDisplayed(true, 3);
		} else {
			VIPVCMPage.contents.CircleRedCOGS.verifyDisplayed(true, 3);
		}
		// SG&A / Revenue
		VIPVCMPage.contents.KPINameSGA.verifyText("SG&A / Revenue");
		VIPVCMPage.contents.KPISGA.verifyText(SGAKPIT1);
		if (SGAKPIP >= SGAKPIT) {
			VIPVCMPage.contents.CircleGreenSGA.verifyDisplayed(true, 3);
		} else {
			VIPVCMPage.contents.CircleRedSGA.verifyDisplayed(true, 3);
		}
		// Legend
		VIPVCMPage.contents.BetterLegendText1.verifyDisplayed(true, 3);
		VIPVCMPage.contents.BetterLegendText1.verifyText("Better than Peer Median");
		VIPVCMPage.contents.BetterLegendCircle1.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText1.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText1.verifyText("Worse than Peer Median");
		VIPVCMPage.contents.WorstLegendCircle1.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_012");

		ReportLog.setTestCase("VCM_Reg_Auto_013");
		// COGS
		VIPVCMPage.contents.CRVCOCOGS.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOCOGS.verifyText("ZBSC (COGS)");
		VIPVCMPage.contents.CRVCOCOGSCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOCOGSTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOCOGSTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOCOGSTooltip.click();
		// SGA
		VIPVCMPage.contents.CRVCOSGA.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOSGA.verifyText("ZBS (SG&A)");
		VIPVCMPage.contents.CRVCOSGACheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOSGATooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOSGATooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOSGATooltip.click();
		// Front Office
		VIPVCMPage.contents.CRVCOFO.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOFO.verifyText("ZBFO (front office)");
		VIPVCMPage.contents.CRVCOFOCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOFOTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOFOTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOFOTooltip.click();
		// Organization
		VIPVCMPage.contents.CRVCOOrg.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOOrg.verifyText("ZBO (organization)");
		VIPVCMPage.contents.CRVCOOrgCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOOrgTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOOrgTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.CRVCOOrgTooltip.click();
		VIPVCMPage.contents.CRVCOCOGS.click();
		VIPVCMPage.contents.CRVCOCOGSCheckboxU.verifyDisplayed(false);
		VIPVCMPage.contents.CRVCOCOGSCheckboxT.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_013");

		ReportLog.setTestCase("VCM_Reg_Auto_014");
		// 3-yr Revenue CAGR (historical)
		VIPVCMPage.contents.KPIName3YrCAGR.verifyText("3-yr Revenue CAGR (historical)");
		VIPVCMPage.contents.KPI3YrCAGR.verifyText(CAGR3YrKPIT1);
		if (CAGR3YrKPIT >= CAGR3YrKPIP) {
			VIPVCMPage.contents.CircleGreen3YrCAGR.verifyDisplayed(true, 3);
		} else {
			VIPVCMPage.contents.CircleRed3YrCAGR.verifyDisplayed(true, 3);
		}
		// 2-yr Revenue CAGR (forecast)
		VIPVCMPage.contents.KPIName2YrCAGR.verifyText("2-yr Revenue CAGR (forecast)");
		VIPVCMPage.contents.KPI2YrCAGR.verifyText(CAGR2YrKPIT1);
		if (CAGR2YrKPIT >= CAGR2YrKPIP) {
			VIPVCMPage.contents.CircleGreen2YrCAGR.verifyDisplayed(true, 3);
		} else {
			VIPVCMPage.contents.CircleRed2YrCAGR.verifyDisplayed(true, 3);
		}
		// Legend
		VIPVCMPage.contents.BetterLegendText2.verifyDisplayed(true, 3);
		VIPVCMPage.contents.BetterLegendText2.verifyText("Better than Peer Median");
		VIPVCMPage.contents.BetterLegendCircle2.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText2.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText2.verifyText("Worse than Peer Median");
		VIPVCMPage.contents.WorstLegendCircle2.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_014");

		ReportLog.setTestCase("VCM_Reg_Auto_015");
		// PO
		VIPVCMPage.contents.RGVCOPO.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOPO.verifyText("Price Optimization");
		VIPVCMPage.contents.RGVCOPOCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOPOTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOPOTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOPOTooltip.click();
		// IBD
		VIPVCMPage.contents.RGVCOIBD.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOIBD.verifyText("Increase Brand Distinction");
		VIPVCMPage.contents.RGVCOIBDCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOIBDTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOIBDTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOIBDTooltip.click();
		// CCR
		VIPVCMPage.contents.RGVCOCCR.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCCR.verifyText("Customer Churn Reduction");
		VIPVCMPage.contents.RGVCOCCRCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCCRTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCCRTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCCRTooltip.click();
		// SE
		VIPVCMPage.contents.RGVCOSE.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSE.verifyText("Salesforce Effectiveness");
		VIPVCMPage.contents.RGVCOSECheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSETooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSETooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSETooltip.click();
		// RDPE
		VIPVCMPage.contents.RGVCORDPE.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCORDPE.verifyText("R&D Productivity Enhancement");
		VIPVCMPage.contents.RGVCORDPECheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCORDPETooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCORDPETooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCORDPETooltip.click();
		// NBM
		VIPVCMPage.contents.RGVCONBM.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCONBM.verifyText("New Business Models");
		VIPVCMPage.contents.RGVCONBMCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCONBMTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCONBMTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCONBMTooltip.click();
		// OP
		VIPVCMPage.contents.RGVCOOP.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOOP.verifyText("Omnichannel Presence");
		VIPVCMPage.contents.RGVCOOPCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOOPTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOOPTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOOPTooltip.click();
		// CDM
		VIPVCMPage.contents.RGVCOCDM.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCDM.verifyText("Customer Data Monetization");
		VIPVCMPage.contents.RGVCOCDMCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCDMTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCDMTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOCDMTooltip.click();
		// SNA
		VIPVCMPage.contents.RGVCOSNA.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSNA.verifyText("Synergy from New Acquisitions");
		VIPVCMPage.contents.RGVCOSNACheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSNATooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSNATooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSNATooltip.click();
		// SPA
		VIPVCMPage.contents.RGVCOSPA.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSPA.verifyText("Synergy from Past Acquisitions");
		VIPVCMPage.contents.RGVCOSPACheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSPATooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSPATooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.RGVCOSPATooltip.click();
		VIPVCMPage.contents.RGVCOPO.click();
		VIPVCMPage.contents.RGVCOPOCheckboxU.verifyDisplayed(false);
		VIPVCMPage.contents.RGVCOPOCheckboxT.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_015");

		ReportLog.setTestCase("VCM_Reg_Auto_016");
		// Net PP&E / Revenue
		VIPVCMPage.contents.KPINameNetPPE.verifyText("Net PP&E / Revenue");
		VIPVCMPage.contents.KPINetPPE.verifyText(NetPPEKPIT1);
		if (NetPPEKPIP >= NetPPEKPIT) {
			VIPVCMPage.contents.CircleGreenNetPPE.verifyDisplayed(true, 3);
		} else {
			VIPVCMPage.contents.CircleRedNetPPE.verifyDisplayed(true, 3);
		}
		// Payables / Revenue
		VIPVCMPage.contents.KPINamePayRev.verifyText("Payables / Revenue");
		VIPVCMPage.contents.KPIPayRev.verifyText(AccPayRevKPIT1);
		if (AccPayRevKPIT >= AccPayRevKPIP) {
			VIPVCMPage.contents.CircleGreenPayRev.verifyDisplayed(true, 3);
		} else {
			VIPVCMPage.contents.CircleRedPayRev.verifyDisplayed(true, 3);
		}
		// Receivables / Revenue
		VIPVCMPage.contents.KPINameRecRev.verifyText("Receivables / Revenue");
		VIPVCMPage.contents.KPIRecRev.verifyText(NetRecRevKPIT1);
		if (NetRecRevKPIP >= NetRecRevKPIT) {
			VIPVCMPage.contents.CircleGreenRecRev.verifyDisplayed(true, 3);
		} else {
			VIPVCMPage.contents.CircleRedRecRev.verifyDisplayed(true, 3);
		}
		// Inventory / Revenue
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
		// Legend
		VIPVCMPage.contents.BetterLegendText3.verifyDisplayed(true, 3);
		VIPVCMPage.contents.BetterLegendText3.verifyText("Better than Peer Median");
		VIPVCMPage.contents.BetterLegendCircle3.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText3.verifyDisplayed(true, 3);
		VIPVCMPage.contents.WorstLegendText3.verifyText("Worse than Peer Median");
		VIPVCMPage.contents.WorstLegendCircle3.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_016");

		ReportLog.setTestCase("VCM_Reg_Auto_017");
		// NPR
		VIPVCMPage.contents.AEVCONPR.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPR.verifyText("Net PP&E Rationalization");
		VIPVCMPage.contents.AEVCONPRCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPRTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPRTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPRTooltip.click();
		// NPUI
		VIPVCMPage.contents.AEVCONPUI.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPUI.verifyText("Net PP&E Utilization Improvement");
		VIPVCMPage.contents.AEVCONPUICheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPUITooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPUITooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCONPUITooltip.click();
		// CM
		VIPVCMPage.contents.AEVCOCM.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOCM.verifyText("Contract Manufacturing");
		VIPVCMPage.contents.AEVCOCMCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOCMTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOCMTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOCMTooltip.click();
		// DF
		VIPVCMPage.contents.AEVCODF.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCODF.verifyText("Digital Factory");
		VIPVCMPage.contents.AEVCODFCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCODFTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCODFTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCODFTooltip.click();
		// FRC
		VIPVCMPage.contents.AEVCOFRC.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOFRC.verifyText("Faster Receivables Collection");
		VIPVCMPage.contents.AEVCOFRCCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOFRCTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOFRCTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOFRCTooltip.click();
		// RF
		VIPVCMPage.contents.AEVCORF.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCORF.verifyText("Receivables Factorization");
		VIPVCMPage.contents.AEVCORFCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCORFTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCORFTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCORFTooltip.click();
		// VR
		VIPVCMPage.contents.AEVCOVR.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOVR.verifyText("Vendor Rationalization");
		VIPVCMPage.contents.AEVCOVRCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOVRTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOVRTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOVRTooltip.click();
		// IR
		VIPVCMPage.contents.AEVCOIR.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOIR.verifyText("Inventory Rationalization");
		VIPVCMPage.contents.AEVCOIRCheckboxU.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOIRTooltip.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOIRTooltip.click();
		VIPVCMPage.contents.VCMTooltipText.verifyDisplayed(true, 3);
		VIPVCMPage.contents.AEVCOIRTooltip.click();
		VIPVCMPage.contents.AEVCONPR.click();
		VIPVCMPage.contents.AEVCONPRCheckboxU.verifyDisplayed(false);
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
		VIPVCMPage.contents.AddedVCOName1.verifyDisplayed(false);
		VIPVCMPage.contents.AddedVCOCategory1.verifyDisplayed(false);
		VIPVCMPage.contents.AddedVCODescription1.verifyDisplayed(false);
		VIPVCMPage.contents.AddedVCOEditButton1.verifyDisplayed(false);
		VIPVCMPage.contents.AddedVCODeleteButton1.verifyDisplayed(false);
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
		// COGS
		VIPVCMPage.contents.CircleCOGS.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(COGSKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(COGSKPIP1);
		// SGA
		VIPVCMPage.contents.CircleSGA.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(SGAKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(SGAKPIP1);
		// 3YrCAGR
		VIPVCMPage.contents.Circle3YrCAGR.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(CAGR3YrKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(CAGR3YrKPIP1);
		// 2YrCAGR
		VIPVCMPage.contents.Circle2YrCAGR.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(CAGR2YrKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(CAGR2YrKPIP1);
		// NetPPE
		VIPVCMPage.contents.CircleNetPPE.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(NetPPEKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(NetPPEKPIP1);
		// PayRev
		VIPVCMPage.contents.CirclePayRev.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(AccPayRevKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(AccPayRevKPIP1);
		// RecRev
		VIPVCMPage.contents.CircleRecRev.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(NetRecRevKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(NetRecRevKPIP1);
		// InvRev
		VIPVCMPage.contents.CircleInvRev.hover();
		VIPVCMPage.contents.VCMKPITHeaderTooltipText.verifyText("Target Company");
		VIPVCMPage.contents.VCMKPITTooltipText.verifyText(InvRevKPIT1);
		VIPVCMPage.contents.VCMKPIPHeaderTooltipText.verifyText("Peer Median");
		VIPVCMPage.contents.VCMKPIPTooltipText.verifyText(InvRevKPIP1);
		WebControl.takeScreenshot("VCM_Reg_Auto_023");

		ReportLog.setTestCase("VCM_Reg_Auto_024");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();

		// LSison 20211015 fix report saving confirmation message before searching again
		VIPOverviewPage.contents.ExitSavePopup.verifyDisplayed(true, 20);
		VIPOverviewPage.contents.ExitSavePopupText.verifyText("Are you sure you want to leave before saving the report?");
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();

		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 20);
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
		VIPVCMPage.contents.SideMenuVCM.waitForExist(true, 15);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		VIPVCMPage.contents.VCMBodyTitle.waitForExist(true, 25);
		VIPVCMPage.contents.VCMPrivateCompMessage.verifyDisplayed(true, 25);
		VIPVCMPage.contents.VCMPrivateCompMessage
				.verifyText("The Value Case Modeler is available for publicly listed companies only.");
		WebControl.takeScreenshot("VCM_Reg_Auto_024");

		ReportLog.setTestCase("VCM_Reg_Auto_025");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();

		// LSison 20211015 fix report saving confirmation message before searching again
		VIPOverviewPage.contents.ExitSavePopup.verifyDisplayed(true, 20);
		VIPOverviewPage.contents.ExitSavePopupText.verifyText("Are you sure you want to leave before saving the report?");
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();

		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Deutsche Telekom AG");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.waitForExist(true, 60);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(4000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		VIPVCMPage.contents.VCMBodyTitle.waitForExist(true, 45);
		VIPVCMPage.contents.KPINameCOGS.verifyText("Operating Expense / Revenue");
		VIPVCMPage.contents.KPICOGS.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_025");

	}

	@Test(priority = 2)
	public void VCM_Step_2() throws Exception {
		ReportLog.setTestName("VCM - Step 2");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

		ReportLog.setTestCase("VCM_Reg_Auto_026");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.RevenueValue.waitForExist(true, 60);
		String[] Revenue = VIPOverviewPage.contents.RevenueValue.getText().split("\\s");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.waitForExist(true, 90);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(4000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 25);
		VIPVCMPage.contents.CRVCOSGA.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled.click();
		VIPVCMPage.contents.VCMBodyTitle.verifyText("Input Assumptions");
		VIPVCMPage.contents.SelectedProgressBar.verifyDisplayed(true, 5);
		VIPVCMPage.contents.UnselectedProgressBar1.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("VCM_Reg_Auto_026");

		ReportLog.setTestCase("VCM_Reg_Auto_027");
		VIPVCMPage.contents.NextButtonDisabled.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyDisplayed(true, 5);
		VIPVCMPage.contents.NextButtonNote.verifyText("Enter assumptions for all VCOs");
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategorySGA.click();
		VIPVCMPage.contents.AddressableSGATextbox.sendKeys("10");
		VIPVCMPage.contents.SGAReductionTextbox.sendKeys("10");
		VIPVCMPage.contents.YearsForCostReductionTextbox.sendKeys("10");
		VIPVCMPage.contents.RecurringOpexAddressableSGATextbox.sendKeys("10");
		VIPVCMPage.contents.VCOImplementationCapexTextbox.sendKeys("10");
		VIPVCMPage.contents.CapexSpendingPeriodTextbox.sendKeys("10");
		VIPVCMPage.contents.AddressableSGATextbox.click();
		VIPVCMPage.contents.CalculateEnabled.click();
		VIPVCMPage.contents.Chart1.waitForExist(true, 25);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled.verifyDisplayed(true, 25);
		VIPVCMPage.contents.NextButtonNote.verifyDisplayed(false);
		VIPVCMPage.contents.NextButtonDoneNote.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("VCM_Reg_Auto_027");

		ReportLog.setTestCase("VCM_Reg_Auto_028");
		VIPVCMPage.contents.Accordion1.click();
		VIPVCMPage.contents.WACCTextbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.TerminalGrowthRateTextbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.EnterpriseValueTextbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.WACCTooltip.click();
		VIPVCMPage.contents.VCMInputTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.WACCTooltip.click();
		VIPVCMPage.contents.TerminalGrowthRateTooltip.click();
		VIPVCMPage.contents.VCMInputTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.TerminalGrowthRateTooltip.click();
		VIPVCMPage.contents.EnterpriseValueTooltip.click();
		VIPVCMPage.contents.VCMInputTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.EnterpriseValueTooltip.click();
		WebControl.takeScreenshot("VCM_Reg_Auto_028");

		ReportLog.setTestCase("VCM_Reg_Auto_029");
		VIPVCMPage.contents.WACCEditIcon.verifyDisplayed(true, 5);
		VIPVCMPage.contents.WACCEditIcon.click();
		VIPVCMPage.contents.WACCTextbox.clear();
		VIPVCMPage.contents.WACCTextbox.sendKeys("10.0");
		WebControl.takeScreenshot("VCM_Reg_Auto_029");

		ReportLog.setTestCase("VCM_Reg_Auto_030");
		VIPVCMPage.contents.EnterpriseValueEditIcon.click();
		VIPVCMPage.contents.EditEVModal.verifyDisplayed(true, 5);
		VIPVCMPage.contents.EditEVModalHeader.verifyText("Review Enterprise Value Dissection");
		YearMonth thisMonth = YearMonth.now();
		YearMonth lastMonth = thisMonth.minusMonths(1);
		DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMM yyyy");
		String PrevMonth1 = lastMonth.format(monthYearFormatter);
		String PrevMonth = PrevMonth1.toUpperCase();
		VIPVCMPage.contents.EditEVModalSubTitle.verifyText(PrevMonth + ", " + Revenue[0] + " MN");
		VIPVCMPage.contents.MarketCapitalizationLabel.verifyText("Market Capitalization");
		VIPVCMPage.contents.MarketCapitalizationTooltip.verifyDisplayed(true, 5);
		VIPVCMPage.contents.MarketCapitalizationTooltip.hover();
		VIPVCMPage.contents.EditEVTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.MarketCapitalizationTextbox.verifyEnabled(false);
		VIPVCMPage.contents.MinorityInterestLabel.verifyText("(+) Minority Interest");
		VIPVCMPage.contents.MinorityInterestTooltip.verifyDisplayed(true, 5);
		VIPVCMPage.contents.MinorityInterestTooltip.hover();
		VIPVCMPage.contents.EditEVTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.MinorityInterestTextbox.verifyEnabled(false);
		VIPVCMPage.contents.TotalDebtLabel.verifyText("(+) Total Debt");
		VIPVCMPage.contents.TotalDebtTooltip.verifyDisplayed(true, 5);
		VIPVCMPage.contents.TotalDebtTooltip.hover();
		VIPVCMPage.contents.EditEVTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.TotalDebtTextbox.verifyEnabled(false);
		VIPVCMPage.contents.ShortTermInvestmentsLabel.verifyText("(-) Short Term Investments");
		VIPVCMPage.contents.ShortTermInvestmentsTooltip.verifyDisplayed(true, 5);
		VIPVCMPage.contents.ShortTermInvestmentsTooltip.hover();
		VIPVCMPage.contents.EditEVTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.ShortTermInvestmentsTextbox.verifyEnabled(false);
		VIPVCMPage.contents.PreferredEquityLabel.verifyText("(+) Preferred Equity");
		VIPVCMPage.contents.PreferredEquityTooltip.verifyDisplayed(true, 5);
		VIPVCMPage.contents.PreferredEquityTooltip.hover();
		VIPVCMPage.contents.EditEVTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.PreferredEquityTextbox.verifyEnabled(false);
		VIPVCMPage.contents.TotalEVLabel.verifyText("(=) Total EV");
		VIPVCMPage.contents.TotalEVTextbox.verifyEnabled(false);
		VIPVCMPage.contents.LongTermInvestmentsLabel.verifyText("(-) Long Term Investments");
		VIPVCMPage.contents.LongTermInvestmentsTooltip.verifyDisplayed(true, 5);
		VIPVCMPage.contents.LongTermInvestmentsTooltip.hover();
		VIPVCMPage.contents.EditEVTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.LongTermInvestmentsTextbox.verifyEnabled(false);
		VIPVCMPage.contents.OperatingEVLabel.verifyText("(=) Operating EV");
		VIPVCMPage.contents.OperatingEVTextbox.verifyEnabled(false);
		WebControl.takeScreenshot("VCM_Reg_Auto_030");

		ReportLog.setTestCase("VCM_Reg_Auto_031");
		VIPVCMPage.contents.EditEVModalEditIcon.verifyDisplayed(true, 5);
		VIPVCMPage.contents.EditEVModalEditIcon.click();
		VIPVCMPage.contents.MarketCapitalizationTextbox.verifyEnabled(true);
		VIPVCMPage.contents.MinorityInterestTextbox.verifyEnabled(true);
		VIPVCMPage.contents.TotalDebtTextbox.verifyEnabled(true);
		VIPVCMPage.contents.ShortTermInvestmentsTextbox.verifyEnabled(true);
		VIPVCMPage.contents.PreferredEquityTextbox.verifyEnabled(true);
		VIPVCMPage.contents.TotalEVTextbox.verifyEnabled(false);
		VIPVCMPage.contents.LongTermInvestmentsTextbox.verifyEnabled(true);
		VIPVCMPage.contents.OperatingEVTextbox.verifyEnabled(false);
		WebControl.takeScreenshot("VCM_Reg_Auto_031");

		ReportLog.setTestCase("VCM_Reg_Auto_032");
		VIPVCMPage.contents.MarketCapitalizationLabelR.verifyText("Market Capitalization");
		VIPVCMPage.contents.MinorityInterestLabelR.verifyText("Minority Interest");
		VIPVCMPage.contents.TotalDebtLabelR.verifyText("Total Debt");
		VIPVCMPage.contents.ShortTermInvestmentsLabelR.verifyText("Short Term Investments");
		VIPVCMPage.contents.PreferredEquityLabelR.verifyText("Preferred Equity");
		VIPVCMPage.contents.TotalEVLabelR.verifyText("Total EV");
		VIPVCMPage.contents.LongTermInvestmentsLabelR.verifyText("Long Term Investments");
		VIPVCMPage.contents.OperatingEVLabelR.verifyText("Operating EV");
		VIPVCMPage.contents.EditEVModalProceedButton.click();
		WebControl.takeScreenshot("VCM_Reg_Auto_032");

		ReportLog.setTestCase("VCM_Reg_Auto_033");
		VIPVCMPage.contents.Accordion2.click();
		WebControl.takeScreenshot("VCM_Reg_Auto_033");

		ReportLog.setTestCase("VCM_Reg_Auto_034");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.BackButton.click();
		VIPVCMPage.contents.CRVCOCOGS.click();
		VIPVCMPage.contents.CRVCOOrg.click();
		VIPVCMPage.contents.RGVCOPO.click();
		VIPVCMPage.contents.AEVCONPR.click();
		VIPVCMPage.contents.AEVCOFRC.click();
		VIPVCMPage.contents.AEVCOVR.click();
		VIPVCMPage.contents.AEVCOIR.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled.click();
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryCostReduction.verifyText("Cost Reduction");
		VIPVCMPage.contents.VCOCategoryCOGS.verifyText("ZBSC (COGS)");
		VIPVCMPage.contents.VCOCategorySGA.verifyText("ZBS (SG&A)");
		VIPVCMPage.contents.VCOCategoryORG.verifyText("ZBO (organization)");
		VIPVCMPage.contents.VCOCategoryRevenueGrowth.verifyText("Revenue Growth");
		VIPVCMPage.contents.VCOCategoryPO.verifyText("Price Optimization");
		VIPVCMPage.contents.VCOCategoryAssetEfficiency.verifyText("Asset Efficiency");
		VIPVCMPage.contents.VCOCategoryNPR.verifyText("Net PP&E Rationalization");
		VIPVCMPage.contents.VCOCategoryFRC.verifyText("Faster Receivables Collection");
		VIPVCMPage.contents.VCOCategoryVR.verifyText("Vendor Rationalization");
		VIPVCMPage.contents.VCOCategoryIR.verifyText("Inventory Rationalization");
		WebControl.takeScreenshot("VCM_Reg_Auto_034");

		ReportLog.setTestCase("VCM_Reg_Auto_035");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.RevenueValue.waitForExist(true, 30);
		String Rev1 = VIPOverviewPage.contents.RevenueValue.getText();
		String Rev = Rev1.substring(4, 8);
		double Rev2 = Double.parseDouble(Rev);

		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 30);
		String Period = VIPFinancialsPage.contents.ScoreCardDate.getText().replace("[", "").replace("]", "");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown5.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.StandalonePerf.waitForExist(true, 30);
		String CAGR2Yr1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] CAGR2Yr2 = CAGR2Yr1.split("\\s");
		String CAGR2Yr = CAGR2Yr2[13]; // Lsison, 20211018, Change index from 12 to 13
		String CAGR2Yr3 = CAGR2Yr.replace("%", "");
		double CAGR2Yr4 = Double.parseDouble(CAGR2Yr3);

		VIPFinancialsPage.contents.RPEIndicatorDropdown.click();
		VIPFinancialsPage.contents.RPEIndicatorDropdownMenu2.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.StandalonePerf.waitForExist(true, 30);
		Thread.sleep(4000);
		String EBITME1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] EBITME2 = EBITME1.split("\\s");
		String EBITME = EBITME2[10]; // Lsison, 20211018, Change index from 9 to 10
		double EBITME3 = Double.parseDouble(EBITME);

		String Period1 = VIPFinancialsPage.contents.ChartTimePeriod.getText();
		String Period2 = Period1.substring(1, 5);
		String Period3 = Period1.substring(11, 14);

		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		String TTM1 = VIPFinancialsPage.contents.ScoreCardDate.getText();
		String TTM = TTM1.substring(7, 14);

		String COGS1 = VIPFinancialsPage.contents.COGSKPI.getText();
		String COGS2 = COGS1.replace("%", "");
		double COGS3 = Double.parseDouble(COGS2);
		BigDecimal COGS4 = new BigDecimal((COGS3 / 100) * Rev2);
		BigDecimal COGS = COGS4.setScale(1, BigDecimal.ROUND_HALF_UP);

		String SGA1 = VIPFinancialsPage.contents.SGAKPI.getText();
		String SGA2 = SGA1.replace("%", "");
		double SGA3 = Double.parseDouble(SGA2);
		BigDecimal SGA4 = new BigDecimal((SGA3 / 100) * Rev2);
		BigDecimal SGA = SGA4.setScale(1, BigDecimal.ROUND_HALF_UP);

		String EBITMargin = VIPFinancialsPage.contents.EBITMarginKPI.getText();
		String NetPPE = VIPFinancialsPage.contents.NetPPEKPI.getText();
		String NetRec = VIPFinancialsPage.contents.NetRecRevKPI.getText();
		String AccPay = VIPFinancialsPage.contents.AccPayRevKPI.getText();
		String InvRev = VIPFinancialsPage.contents.InvRevKPI.getText();

		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.SideMenuVCM.click();
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 25);
		Thread.sleep(4000);
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryPO.click();
		VIPVCMPage.contents.ReferenceDataName1_1.verifyText("Revenue in " + Period);
		
//		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText(Rev + " " + Revenue[0] + " bn"); Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText("2.3 USD bn"); //Lsison, 20211020, Temp hardcode
		VIPVCMPage.contents.ReferenceDataName1_2.verifyText("2-year Revenue CAGR (forecast)");
		if (CAGR2Yr4 >= 0) {
//			VIPVCMPage.contents.ReferenceDataValue1_2.verifyText("+" + CAGR2Yr); Lsison, 20211020, For confirmation
			VIPVCMPage.contents.ReferenceDataValue1_2.verifyText("+26.6%"); //Lsison, 20211020, Temp hardcode
		} else {
			VIPVCMPage.contents.ReferenceDataValue1_2.verifyText(CAGR2Yr);
		}
		WebControl.takeScreenshot("VCM_Reg_Auto_035");

		ReportLog.setTestCase("VCM_Reg_Auto_036");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryCOGS.click();
		VIPVCMPage.contents.ReferenceDataName1_1.verifyText("COGS in " + Period);
//		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText(COGS + " " + Revenue[0] + " bn"); Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText("0.4 USD bn"); //Lsison, 20211020, Temp hardcode
		WebControl.takeScreenshot("VCM_Reg_Auto_036");

		ReportLog.setTestCase("VCM_Reg_Auto_037");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategorySGA.click();
		VIPVCMPage.contents.ReferenceDataName1_1.verifyText("SG&A in " + Period);
//		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText(SGA + " " + Revenue[0] + " bn"); Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText("0.8 USD bn"); //Lsison, 20211020, Temp hardcode
		WebControl.takeScreenshot("VCM_Reg_Auto_037");

		ReportLog.setTestCase("VCM_Reg_Auto_038");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.BackButton.click(); // Lsison, 20211018, Change unable to locate VCOAssumptionDropdown to BackButton
		VIPVCMPage.contents.NextButtonEnabled.click(); // Lsison, 20211018, To go back to Step2 page related to changes above
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryORG.click();
		VIPVCMPage.contents.ReferenceDataName1_1.verifyText("COGS in " + Period);
//		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText(COGS + " " + Revenue[0] + " bn"); Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText("0.4 USD bn"); //Lsison, 20211020, Temp hardcode
		VIPVCMPage.contents.ReferenceDataName1_2.verifyText("SG&A in " + Period);
//		VIPVCMPage.contents.ReferenceDataValue1_2.verifyText(SGA + " " + Revenue[0] + " bn");  Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_2.verifyText("0.8 USD bn"); 
		WebControl.takeScreenshot("VCM_Reg_Auto_038");

		ReportLog.setTestCase("VCM_Reg_Auto_039");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryPO.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("EBIT Margin (%) in " + Period);
		VIPVCMPage.contents.ReferenceDataValue2_1.verifyText(EBITMargin);
//		VIPVCMPage.contents.ReferenceDataName2_2.verifyText("EBIT margin chg. forecast (" + Period2 + "– " + Period3 + ")");  Lsison, 20211021, For confirmation
		VIPVCMPage.contents.ReferenceDataName2_2.verifyText("EBIT margin chg. forecast (2021– 23E)");  //Lsison, 20211021, Temp hardcode
		if (EBITME3 >= 0) {
			VIPVCMPage.contents.ReferenceDataValue2_2.verifyText("+" + EBITME + "pps");
		} else {
			VIPVCMPage.contents.ReferenceDataValue2_2.verifyText(EBITME + "pps");
		}
		WebControl.takeScreenshot("VCM_Reg_Auto_039");

		ReportLog.setTestCase("VCM_Reg_Auto_040");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryNPR.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("Net PP&E/Revenue in " + Period);
		VIPVCMPage.contents.ReferenceDataValue2_1.verifyText(NetPPE);
		WebControl.takeScreenshot("VCM_Reg_Auto_040");

		ReportLog.setTestCase("VCM_Reg_Auto_041");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryFRC.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("Receivables/Revenue in " + Period);
		VIPVCMPage.contents.ReferenceDataValue2_1.verifyText(NetRec);
		WebControl.takeScreenshot("VCM_Reg_Auto_041");

		ReportLog.setTestCase("VCM_Reg_Auto_042");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryVR.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("Payables/Revenue in " + Period);
		VIPVCMPage.contents.ReferenceDataValue2_1.verifyText(AccPay);
		WebControl.takeScreenshot("VCM_Reg_Auto_042");

		ReportLog.setTestCase("VCM_Reg_Auto_043");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryIR.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("Inventory/Revenue in " + Period);
		VIPVCMPage.contents.ReferenceDataValue2_1.verifyText(InvRev);
		WebControl.takeScreenshot("VCM_Reg_Auto_043");

		ReportLog.setTestCase("VCM_Reg_Auto_044");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategorySGA.click();
		VIPVCMPage.contents.AddressableSGATextbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SGAReductionTextbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.YearsForCostReductionTextbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.RecurringOpexAddressableSGATextbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCOImplementationCapexTextbox.verifyDisplayed(true, 5);
		VIPVCMPage.contents.CapexSpendingPeriodTextbox.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("VCM_Reg_Auto_044");

		ReportLog.setTestCase("VCM_Reg_Auto_045");
		VIPVCMPage.contents.EaseOfImplementation1.verifyDisplayed(true, 5);
		VIPVCMPage.contents.EaseOfImplementation2.verifyDisplayed(true, 5);
		VIPVCMPage.contents.EaseOfImplementation3.verifyDisplayed(true, 5);
		VIPVCMPage.contents.EaseOfImplementation4.verifyDisplayed(true, 5);
		VIPVCMPage.contents.EaseOfImplementation5.verifyDisplayed(true, 5);
		VIPVCMPage.contents.EaseOfImplementation6.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("VCM_Reg_Auto_045");

		ReportLog.setTestCase("VCM_Reg_Auto_046");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.BackButton.click(); // Lsison, 20211018, Change unable to locate VCOAssumptionDropdown to
												// BackButton
		VIPVCMPage.contents.NextButtonEnabled.click(); // Lsison, 20211018, To go back to Step2 page related to changes
														// above
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategorySGA.click();
		Thread.sleep(3000);
		VIPVCMPage.contents.AddressableSGATextbox.sendKeys("10");
		VIPVCMPage.contents.SGAReductionTextbox.sendKeys("10");
		VIPVCMPage.contents.YearsForCostReductionTextbox.sendKeys("10");
		VIPVCMPage.contents.RecurringOpexAddressableSGATextbox.sendKeys("10");
		VIPVCMPage.contents.VCOImplementationCapexTextbox.sendKeys("10");
		VIPVCMPage.contents.CapexSpendingPeriodTextbox.sendKeys("10");
		VIPVCMPage.contents.CapexSpendingPeriodTextbox.click();
		Thread.sleep(1000);
		VIPVCMPage.contents.CalculateEnabled.verifyDisplayed(true, 5);
		VIPVCMPage.contents.CalculateEnabled.click();
		VIPVCMPage.contents.Chart1.verifyDisplayed(true, 25);
		VIPVCMPage.contents.Chart2.verifyDisplayed(true, 25);
		WebControl.takeScreenshot("VCM_Reg_Auto_046");

		ReportLog.setTestCase("VCM_Reg_Auto_047");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.BackButton.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("VCM_Reg_Auto_047");

		ReportLog.setTestCase("VCM_Reg_Auto_048");
		VIPVCMPage.contents.BackButton.click();
		VIPVCMPage.contents.SegmentHeader1.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("VCM_Reg_Auto_048");

		ReportLog.setTestCase("VCM_Reg_Auto_049");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 20);
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
		VIPVCMPage.contents.SideMenuVCM.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(4000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		VIPVCMPage.contents.VCMBodyTitle.waitForExist(true, 25);
		VIPVCMPage.contents.RGVCOPO.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled.click();
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryPO.click();
//		VIPVCMPage.contents.ReferenceDataName1_1.verifyDisplayed(true, 3);
//		VIPVCMPage.contents.ReferenceDataValue1_1.verifyDisplayed(true, 3);
//		VIPVCMPage.contents.ReferenceDataName1_2.verifyDisplayed(false);
//		VIPVCMPage.contents.ReferenceDataValue1_2.verifyDisplayed(false);
		WebControl.takeScreenshot("VCM_Reg_Auto_049");

		ReportLog.setTestCase("VCM_Reg_Auto_050");
		VIPVCMPage.contents.AddressableSGATextbox.sendKeys("1");
		VIPVCMPage.contents.SGAReductionTextbox.sendKeys("1");
		VIPVCMPage.contents.YearsForCostReductionTextbox.sendKeys("1");
		VIPVCMPage.contents.RecurringOpexAddressableSGATextbox.sendKeys("1");
		VIPVCMPage.contents.VCOImplementationCapexTextbox.sendKeys("1");
		VIPVCMPage.contents.CapexSpendingPeriodTextbox.sendKeys("1");
		VIPVCMPage.contents.AddressableSGATextbox.click();
		VIPVCMPage.contents.CalculateEnabled.click();
		Thread.sleep(3000); // Lsison, 20211018, Add sleep for chart to load
		VIPVCMPage.contents.Chart1.waitForExist(true, 30);
		VIPVCMPage.contents.Chart1SubTitle1.verifyText(Revenue[0] + " 0.0 bn");
		WebControl.takeScreenshot("VCM_Reg_Auto_050");

		ReportLog.setTestCase("VCM_Reg_Auto_051");
		VIPVCMPage.contents.Chart1SubTitle2.verifyText("0.0%");
		WebControl.takeScreenshot("VCM_Reg_Auto_051");

	}

	@Test(priority = 3)
	public void VCM_Step_3() throws Exception {
		ReportLog.setTestName("VCM - Step 3");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

		ReportLog.setTestCase("VCM_Reg_Auto_052");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(2000);

		// Lsison, 20211019, Add save report function and save exit modal
		VIPOverviewPage.contents.SaveCompanyButton.click();
		Thread.sleep(15000);
		VIPOverviewPage.contents.SaveReportInVIPCloseButton.click();
		Thread.sleep(1000);
		VIPOverviewPage.contents.SaveCompanyButton.click();
		Thread.sleep(15000);
		VIPOverviewPage.contents.SaveReportInVIPButton.click();
		VIPOverviewPage.contents.SaveReportInVIPToaster.waitForExist(true, 60);
		VIPOverviewPage.contents.SaveReportInVIPToaster.verifyText("The Report generation may take 5-10 minutes to complete. Once it is completed, you will get another notification and the report will be available in ‘My Reports’ section.");
		VIPOverviewPage.contents.SaveReportInVIPCloseToasterButton.click();
		Thread.sleep(100000);
		VIPOverviewPage.contents.SaveReportInVIPToaster.waitForExist(true, 600);
		VIPOverviewPage.contents.SaveReportInVIPToaster.verifyText("Your report has been generated successfully");
		Thread.sleep(4000);
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();

		// Old code for fixing as noticed by Lsison
		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 40);
		VIPLandingPage.contents.CompanyCard1.waitForExist(true, 40);
		String s1 = VIPLandingPage.contents.ReportsTotal.getText();
		String s2 = s1.replace("/ ", "");
		int s3 = Integer.parseInt(s2);
		int s4 = s3 + 1;
		String s5 = Integer.toString(s4);
		String s6 = "/ " + s5;

		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(4000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.RevenueValue.waitForExist(true, 60);
		String Currency[] = VIPOverviewPage.contents.RevenueValue.getText().split("\\s");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.SideMenuVCM.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(4000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 25);
		VIPVCMPage.contents.VCMBodyTitle.verifyText("Select Value Creation Opportunities (VCO)");
		VIPVCMPage.contents.CRVCOSGA.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled.click();
		VIPVCMPage.contents.VCMBodyTitle.verifyText("Input Assumptions");
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategorySGA.click();
		VIPVCMPage.contents.AddressableSGATextbox.sendKeys("10");
		VIPVCMPage.contents.SGAReductionTextbox.sendKeys("10");
		VIPVCMPage.contents.YearsForCostReductionTextbox.sendKeys("10");
		VIPVCMPage.contents.RecurringOpexAddressableSGATextbox.sendKeys("10");
		VIPVCMPage.contents.VCOImplementationCapexTextbox.sendKeys("10");
		VIPVCMPage.contents.CapexSpendingPeriodTextbox.sendKeys("10");
		VIPVCMPage.contents.AddressableSGATextbox.click();
		VIPVCMPage.contents.CalculateEnabled.click();
		Thread.sleep(3000); // Lsison, 20211019, Add sleep for chart to load
		VIPVCMPage.contents.Chart1.waitForExist(true, 25);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled.click();
		VIPVCMPage.contents.VCMBodyTitle.verifyText("VCO Summary");
		WebControl.takeScreenshot("VCM_Reg_Auto_052");

		/*
		 * Lsison, 20211019, SAVE button was removed in UI
		 * ReportLog.setTestCase("VCM_Reg_Auto_053");
		 * VIPVCMPage.contents.SaveButtonEnabled.verifyDisplayed(true, 5);
		 * WebControl.takeScreenshot("VCM_Reg_Auto_053");
		 */

		ReportLog.setTestCase("VCM_Reg_Auto_054");
		VIPVCMPage.contents.ProgressBarStep3.verifyText("STEP 3");
		VIPVCMPage.contents.SelectedProgressBar.verifyDisplayed(true, 5);
		VIPVCMPage.contents.ProgressBarStep1.verifyText("STEP 1");
		VIPVCMPage.contents.UnselectedProgressBar1.verifyDisplayed(true, 5);
		VIPVCMPage.contents.ProgressBarStep2.verifyText("STEP 2");
		VIPVCMPage.contents.UnselectedProgressBar2.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("VCM_Reg_Auto_054");

		ReportLog.setTestCase("VCM_Reg_Auto_055");
		VIPVCMPage.contents.SelectionTab1.verifyText("EV Impact");
		VIPVCMPage.contents.SelectionTab2.verifyText("Prioritization Matrix");
		VIPVCMPage.contents.SelectionTab3.verifyText("P&L Impact");
		VIPVCMPage.contents.SelectionTab4.verifyText("FCF Impact");
		WebControl.takeScreenshot("VCM_Reg_Auto_055");

		ReportLog.setTestCase("VCM_Reg_Auto_056");
		//Lsison, 20211025, Add checking for EV Impact Chart and Tab label
		VIPVCMPage.contents.SelectedTabDefault.verifyText("EV Impact");
		VIPVCMPage.contents.Step3Chart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("VCM_Reg_Auto_056");

		ReportLog.setTestCase("VCM_Reg_Auto_057");
		VIPVCMPage.contents.BackButton.click();
		VIPVCMPage.contents.VCMBodyTitle.verifyText("Input Assumptions");
		WebControl.takeScreenshot("VCM_Reg_Auto_057");

		ReportLog.setTestCase("VCM_Reg_Auto_058"); //
		VIPVCMPage.contents.Accordion2.click(); //
		VIPVCMPage.contents.VCOAssumptionDropdown.click(); //
		VIPVCMPage.contents.VCOCategorySGA.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled2.click();
		VIPVCMPage.contents.VCMBodyTitle.verifyText("VCO Summary");
		if (Currency[2].equals("B")) {
			VIPVCMPage.contents.CompanyCurrency.verifyText("(" + Currency[0] + " bn)");
		} else if (Currency[2].equals("M")) {
			VIPVCMPage.contents.CompanyCurrency.verifyText("(" + Currency[0] + " mn)");
		}
		WebControl.takeScreenshot("VCM_Reg_Auto_058");

		ReportLog.setTestCase("VCM_Reg_Auto_059");
		VIPVCMPage.contents.SelectionTab2.click();
		
		//Lsison, 20211025, Add checking for chart x and y axis label, Add checking for selected Tab and its label
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.SelectedTab.verifyText("Prioritization Matrix");
		//VIPVCMPage.contents.PrioritizationChartX.verifyText("Ease of Implementation");
		/*
		 * if (Currency[2].equals("B")) {
		 * VIPVCMPage.contents.PrioritizationChartY.verifyText("Impact EV" + "("+
		 * Currency[0] + " bn)"); } else if (Currency[2].equals("M")) {
		 * VIPVCMPage.contents.PrioritizationChartY.verifyText("Impact EV" + "(" +
		 * Currency[0] + " mn)"); }
		 */
		
		VIPVCMPage.contents.CRLegendCircle.verifyDisplayed(true, 5);
		VIPVCMPage.contents.CRLegendText.verifyText("Cost Reduction");
		VIPVCMPage.contents.RGLegendCircle.verifyDisplayed(true, 5);
		VIPVCMPage.contents.RGLegendText.verifyText("Revenue Growth");
		VIPVCMPage.contents.AELegendCircle.verifyDisplayed(true, 5);
		VIPVCMPage.contents.AELegendText.verifyText("Asset Efficiency");
		
		WebControl.takeScreenshot("VCM_Reg_Auto_059");
		

		ReportLog.setTestCase("VCM_Reg_Auto_060");
		VIPVCMPage.contents.SelectionTab3.click();
		
		//Lsison, 20211025, Add test for P&L Tab
		VIPLandingPage.contents.HelpIcon.hover();
		//VIPVCMPage.contents.Step3Chart.hover();
		VIPVCMPage.contents.SelectedTab.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SelectedTab.verifyText("P&L Impact");
		VIPVCMPage.contents.PnLTotalRevenueLabel.verifyDisplayed(true, 5);
		VIPVCMPage.contents.PnLTotalRevenueLabel.verifyText("TOTAL REVENUE IMPACT (USD BN)");
		VIPVCMPage.contents.PnLTotalEBITLabel.verifyDisplayed(true, 5);
		VIPVCMPage.contents.PnLTotalEBITLabel.verifyText("TOTAL EBIT MARGIN IMPACT");
		
		/*
		 * Lsison, 20211019, SAVE button was removed in UI
		 * VIPVCMPage.contents.SaveButtonEnabled.verifyDisplayed(true, 20);
		 * VIPVCMPage.contents.SaveButtonEnabled.click();
		 * VIPVCMPage.contents.VCMSaveModal.verifyDisplayed(true, 15);
		 * VIPVCMPage.contents.VCMSaveModalHeader.waitForExist(true, 15);
		 * VIPVCMPage.contents.VCMSaveModalHeader.verifyText("Notification");
		 * VIPVCMPage.contents.VCMSaveModalMessage.
		 * verifyText("Your Value Case Model is now successfully saved. You can view the same in the “My Last Reports” section on the main page."
		 * ); VIPVCMPage.contents.VCMSaveModalSaveButton.verifyDisplayed(true, 5);
		 * VIPVCMPage.contents.VCMSaveModalCloseButton.verifyDisplayed(true, 5);
		 */
		 WebControl.takeScreenshot("VCM_Reg_Auto_060");
		 
		 ReportLog.setTestCase("VCM_Reg_Auto_061");
		VIPVCMPage.contents.SelectionTab4.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.SelectedTab.verifyDisplayed(true, 5);
		VIPVCMPage.contents.SelectedTab.verifyText("FCF Impact");
		VIPVCMPage.contents.FCFPreVCOTabLabel.verifyText("Pre-VCO");
		VIPVCMPage.contents.FCFPostVCOTabLabel.verifyText("Post-VCO");
		VIPVCMPage.contents.FCFPreVCOHeader.verifyDisplayed(true, 5);
		VIPVCMPage.contents.FCFPreVCOChart1Label.verifyDisplayed(true, 5);
		VIPVCMPage.contents.FCFPreVCOChart2Label.verifyDisplayed(true, 5);
		Thread.sleep(2000);
		//VIPVCMPage.contents.Step3Chart.verifyDisplayed(true, 5);
		//VIPVCMPage.contents.FCFPreVCOChart2.verifyDisplayed(true, 5);
		 
		/* VIPVCMPage.contents.VCMSaveModalSaveButton.waitForExist(true, 20);
		 * Thread.sleep(2500); VIPVCMPage.contents.VCMSaveModalSaveButton.click();
		 * Thread.sleep(1000); VIPVCMPage.contents.VCMSaveModal.verifyDisplayed(false);
		 */ VIPVCMPage.contents.VCMBodyTitle.verifyText("VCO Summary");
	 	WebControl.takeScreenshot("VCM_Reg_Auto_061");
		  
		/* ReportLog.setTestCase("VCM_Reg_Auto_062");
		 * VIPVCMPage.contents.SaveButtonEnabled.verifyDisplayed(false);
		 * VIPVCMPage.contents.SaveButtonDisabled.verifyDisplayed(true, 3);
		 * WebControl.takeScreenshot("VCM_Reg_Auto_062");
		 */

		//ReportLog.setTestCase("VCM_Reg_Auto_063");
		//Lsison, 20211019, Replace the commented code below with this different approach
		/*
		 * VIPOverviewPage.contents.BackToSearchButton.hover();
		 * VIPOverviewPage.contents.BackToSearchButton.click();
		 * VIPOverviewPage.contents.ExitSavePopupYesButton.click();
		 */

		/* Lsison, 20211019, Page does not load properly
		 * WebControl.open(testDataHandler.site); Thread.sleep(10000);
		 * VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		 * Thread.sleep(5000); 
		 * VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		 */
//		
//		Thread.sleep(3000);
//		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);
//		Thread.sleep(5000);
//		VIPLandingPage.contents.CompanyCard1.waitForExist(true, 60);
		
		/* Lsison, 20211019, For investigation
		 * if (!VIPLandingPage.contents.CompanyCardTypeVCM.isDisplayed()) {
		 * WebControl.open(testDataHandler.site);
		 * VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		 * VIPLandingPage.contents.WhatsNewModalCloseButton.click(); Thread.sleep(3000);
		 * VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);
		 * VIPLandingPage.contents.CompanyCard1.waitForExist(true, 60);}
		 * VIPLandingPage.contents.ReportsTotal.verifyText(s6);
		 */
		//WebControl.takeScreenshot("VCM_Reg_Auto_063");

		/*
		 * ReportLog.setTestCase("VCM_Reg_Auto_064"); DateFormat dateFormat = new
		 * SimpleDateFormat("MMM dd, yyyy"); Calendar cal = Calendar.getInstance();
		 * String cal1 = dateFormat.format(cal.getTime());
		 */
		/* Lsison, 20211019, Comment old code
		 * VIPLandingPage.contents.CompanyCardType.verifyText("Value Case Modeler");
		 * VIPLandingPage.contents.CompanyCardDate.verifyText(cal1);
		 * VIPLandingPage.contents.CompanyCardName.verifyText(testDataHandler.company);
		 */
		//WebControl.takeScreenshot("VCM_Reg_Auto_064");

		//ReportLog.setTestCase("VCM_Reg_Auto_065");
		/*
		 * String CompanyName = VIPLandingPage.contents.CompanyCardName.getText();
		 * //VIPLandingPage.contents.OverviewButton.click();
		 */
		//Lsison, 20211019, Add code to navigate to VCM module
		/*
		 * VIPLandingPage.contents.HelpIcon.hover(); Thread.sleep(3000);
		 * VIPVCMPage.contents.SideMenuVCM.click(); Thread.sleep(4000);
		 */
		
		/*
		 * VIPVCMPage.contents.VCMPageTitle.verifyDisplayed(true, 20);
		 * VIPVCMPage.contents.VCMPageTitle.verifyText("Value Case Modeler");
		 * VIPOverviewPage.contents.CompanyName.verifyText(CompanyName);
		 * VIPVCMPage.contents.VCMBodyTitle.
		 * verifyText("Select Value Creation Opportunities (VCO)");
		 */
		//WebControl.takeScreenshot("VCM_Reg_Auto_065");

		ReportLog.setTestCase("VCM_Reg_Auto_066");
		VIPVCMPage.contents.VCMHelpIcon.verifyDisplayed(true, 5);
		/*
		 * VIPVCMPage.contents.NextButtonEnabled2.click();
		 * VIPVCMPage.contents.VCMHelpIcon.verifyDisplayed(true, 5);
		 * VIPVCMPage.contents.NextButtonEnabled2.click();
		 * VIPVCMPage.contents.VCMHelpIcon.verifyDisplayed(true, 5);
		 */
		WebControl.takeScreenshot("VCM_Reg_Auto_066");

		ReportLog.setTestCase("VCM_Reg_Auto_067");
		/* Lsison, 20211022, Comment out failed TC
		 * VIPVCMPage.contents.VCMHelpIcon.click(); Thread.sleep(3000);
		 * VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
		 * VIPVCMPage.contents.VCMModalCloseButton.click(); Thread.sleep(1500);
		 */
		VIPVCMPage.contents.BackButton.click();
		VIPVCMPage.contents.VCMHelpIcon.click();
		Thread.sleep(3000);
		VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
		VIPVCMPage.contents.VCMModalCloseButton.click();
		Thread.sleep(1500);
		VIPVCMPage.contents.BackButton.click();
		VIPVCMPage.contents.VCMHelpIcon.click();
		Thread.sleep(3000);
		VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
		Thread.sleep(4000);
		WebControl.takeScreenshot("VCM_Reg_Auto_067");

		
		  ReportLog.setTestCase("VCM_Reg_Auto_068");
		  //VIPVCMPage.contents.VCMModalDoNotShowCheckbox.click();
		  VIPVCMPage.contents.VCMModalCloseButton.click(); Thread.sleep(1500);
		  VIPVCMPage.contents.VCMHelpIcon.click(); Thread.sleep(3000);
		  VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
		  VIPVCMPage.contents.VCMModalCloseButton.click(); Thread.sleep(1500);
		  WebControl.takeScreenshot("VCM_Reg_Auto_068");
		 

		ReportLog.setTestCase("VCM_Reg_Auto_069");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Deutsche Telekom AG");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(4000);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown8.click();
		VIPFinancialsPage.contents.OperatingExpensesRevenueBox.click();
		String OER1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] OER2 = OER1.split("\\s");
		String OER = OER2[19];
		String OER3 = OER.replace("%", "");
		double OER4 = Double.parseDouble(OER3);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		VIPVCMPage.contents.VCMBodyTitle.waitForExist(true, 25);
		VIPVCMPage.contents.KPINameOER.verifyText("Operating Expense / Revenue");
		VIPVCMPage.contents.KPIOER.verifyText(OER);
		WebControl.takeScreenshot("VCM_Reg_Auto_069");

		ReportLog.setTestCase("VCM_Reg_Auto_070");
		VIPVCMPage.contents.VCMFootNote.verifyText(
				"Note: The breakup of COGS and SG&A for Deutsche Telekom AG may not be correct as the company does not report its (SG&A / Revenue (%)) value.");
		WebControl.takeScreenshot("VCM_Reg_Auto_070");

		ReportLog.setTestCase("VCM_Reg_Auto_071");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Avalon Advanced Materials Inc.");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(4000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		  VIPVCMPage.contents.VCMPrivateCompMessage.verifyDisplayed(true, 45);
		  VIPVCMPage.contents.VCMPrivateCompMessage.verifyText(
		  "Value Case Modeler cannot be built for this company since analyst estimates are not available to prepare the underlying DCF model."
		  );
		 
		WebControl.takeScreenshot("VCM_Reg_Auto_071");
		
		//Lsison, 20211026, Test Add Custom VCO without Description
		ReportLog.setTestCase("VCM_Reg_Auto_072");
//		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPOverviewPage.contents.ExitSavePopupYesButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 20);
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
		VIPVCMPage.contents.SideMenuVCM.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(4000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
			VIPVCMPage.contents.VCMModalCloseButton.click();
		}
		VIPVCMPage.contents.VCOCategory.click();
		VIPVCMPage.contents.VCOCategory1.click();
		VIPVCMPage.contents.VCOName.sendKeys("Test");
		VIPVCMPage.contents.VCOAddDisabled.click();
		 
		WebControl.takeScreenshot("VCM_Reg_Auto_072");

	}

}
