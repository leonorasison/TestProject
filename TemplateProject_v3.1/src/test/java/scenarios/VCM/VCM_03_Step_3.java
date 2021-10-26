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

public class VCM_03_Step_3 extends TestBase{
	
	@Test
	public void VCM_Step_3 () throws Exception {
		ReportLog.setTestName("VCM - Step 3");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("VCM_Reg_Auto_052");
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
		//VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		String Total = VIPLandingPage.contents.ReportsTotal.getText();		
		VIPLandingPage.contents.CompanyNameTextbox.type(testDataHandler.company);
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
		Thread.sleep(3000);
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(4000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
		VIPVCMPage.contents.VCMModalCloseButton.click();}
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
		VIPVCMPage.contents.Chart1.waitForExist(true, 25);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled.click();
		VIPVCMPage.contents.VCMBodyTitle.verifyText("VCO Summary");
		WebControl.takeScreenshot("VCM_Reg_Auto_052");
		
		/* Lsison, 20211019, SAVE button was removed in UI
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
		//Lsison, 20211025, Add checking for EV Impact Chart
		VIPVCMPage.contents.Step3Chart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("VCM_Reg_Auto_056");
		
		ReportLog.setTestCase("VCM_Reg_Auto_057");
		VIPVCMPage.contents.BackButton.click();
		VIPVCMPage.contents.VCMBodyTitle.verifyText("Input Assumptions");
		WebControl.takeScreenshot("VCM_Reg_Auto_057");
		
		ReportLog.setTestCase("VCM_Reg_Auto_058");
//		VIPVCMPage.contents.Accordion2.click();
//		VIPVCMPage.contents.VCOAssumptionDropdown.click();
//		VIPVCMPage.contents.VCOCategorySGA.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled2.click();
		VIPVCMPage.contents.VCMBodyTitle.verifyText("VCO Summary");
		VIPVCMPage.contents.CompanyCurrency.verifyText("(USD bn)");
		WebControl.takeScreenshot("VCM_Reg_Auto_058");
		
		ReportLog.setTestCase("VCM_Reg_Auto_059");
		VIPVCMPage.contents.SelectionTab2.click();
		
		//Lsison, 20211025, Add checking for chart x and y axis label
		VIPVCMPage.contents.PrioritizationChartX.verifyDisplayed(true, 5);
		VIPVCMPage.contents.PrioritizationChartY.verifyDisplayed(true, 5);
		
		VIPVCMPage.contents.CRLegendCircle.verifyDisplayed(true, 5);
		VIPVCMPage.contents.CRLegendText.verifyText("Cost Reduction");
		VIPVCMPage.contents.RGLegendCircle.verifyDisplayed(true, 5);
		VIPVCMPage.contents.RGLegendText.verifyText("Revenue Growth");
		VIPVCMPage.contents.AELegendCircle.verifyDisplayed(true, 5);
		VIPVCMPage.contents.AELegendText.verifyText("Asset Efficiency");
		WebControl.takeScreenshot("VCM_Reg_Auto_059");
		
		ReportLog.setTestCase("VCM_Reg_Auto_060");
		/* Lsison, 20211019, SAVE button was removed in UI
		 * VIPVCMPage.contents.SaveButtonEnabled.verifyDisplayed(true, 20);
		 * VIPVCMPage.contents.SaveButtonEnabled.click(); Thread.sleep(2000);
		 * WebControl.waitForPageToLoad(60); Thread.sleep(2000);
		 * VIPVCMPage.contents.VCMSaveModal.verifyDisplayed(true, 5);
		 * VIPVCMPage.contents.VCMSaveModalHeader.verifyText("Notification");
		 * VIPVCMPage.contents.VCMSaveModalMessage.
		 * verifyText("Your Value Case Model is now successfully saved. You can view the same in the “My Last Reports” section on the main page."
		 * ); VIPVCMPage.contents.VCMSaveModalSaveButton.verifyDisplayed(true, 5);
		 * VIPVCMPage.contents.VCMSaveModalCloseButton.verifyDisplayed(true, 5);
		 * WebControl.takeScreenshot("VCM_Reg_Auto_060");
		 * 
		 * ReportLog.setTestCase("VCM_Reg_Auto_061");
		 * VIPVCMPage.contents.VCMSaveModalSaveButton.click();
		 * VIPVCMPage.contents.VCMSaveModal.verifyDisplayed(false, 1);
		 * VIPVCMPage.contents.VCMBodyTitle.verifyText("VCO Summary");
		 * WebControl.takeScreenshot("VCM_Reg_Auto_061");
		 */
		
		/* Lsison, 20211019, SAVE button was removed in UI
		 * ReportLog.setTestCase("VCM_Reg_Auto_062");
		 * VIPVCMPage.contents.SaveButtonEnabled.verifyDisplayed(false, 1);
		 * VIPVCMPage.contents.SaveButtonDisabled.verifyDisplayed(true, 3);
		 * WebControl.takeScreenshot("VCM_Reg_Auto_062");
		 */
		
//		ReportLog.setTestCase("VCM_Reg_Auto_063");
//		WebControl.open(testDataHandler.site);
//		Thread.sleep(2500);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2500);
//		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);
//		VIPLandingPage.contents.ReportsTotal.verifyText(Total, false);
//		WebControl.takeScreenshot("VCM_Reg_Auto_063");
//		
//		ReportLog.setTestCase("VCM_Reg_Auto_064");
//		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
//		Calendar cal = Calendar.getInstance();
//		String cal1 = dateFormat.format(cal.getTime());
//		VIPLandingPage.contents.CompanyCardType.verifyText("Value Case Modeler");
//		VIPLandingPage.contents.CompanyCardDate.verifyText(cal1);
//		VIPLandingPage.contents.CompanyCardName.verifyText(testDataHandler.company);
//		WebControl.takeScreenshot("VCM_Reg_Auto_064");
//		
//		ReportLog.setTestCase("VCM_Reg_Auto_065");
//		String CompanyName = VIPLandingPage.contents.CompanyCardName.getText();
//		VIPLandingPage.contents.OverviewButton.click();
//		Thread.sleep(1000);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2000);
//		VIPVCMPage.contents.VCMPageTitle.verifyDisplayed(true, 20);
//		VIPVCMPage.contents.VCMPageTitle.verifyText("Value Case Modeler");
//		VIPOverviewPage.contents.CompanyName.verifyText(CompanyName);
//		VIPVCMPage.contents.VCMBodyTitle.verifyText("Select Value Creation Opportunities (VCO)");
//		WebControl.takeScreenshot("VCM_Reg_Auto_065");
//		
//		ReportLog.setTestCase("VCM_Reg_Auto_066");
//		VIPVCMPage.contents.VCMHelpIcon.verifyDisplayed(true, 5);
//		VIPVCMPage.contents.NextButtonEnabled2.click();
//		VIPVCMPage.contents.VCMHelpIcon.verifyDisplayed(true, 5);
//		VIPVCMPage.contents.NextButtonEnabled2.click();
//		VIPVCMPage.contents.VCMHelpIcon.verifyDisplayed(true, 5);
//		WebControl.takeScreenshot("VCM_Reg_Auto_066");
//		
//		ReportLog.setTestCase("VCM_Reg_Auto_067");
//		VIPVCMPage.contents.VCMHelpIcon.click();
//		VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
//		VIPVCMPage.contents.VCMModalCloseButton.click();
//		Thread.sleep(1500);
//		VIPVCMPage.contents.BackButton.click();
//		VIPVCMPage.contents.VCMHelpIcon.click();
//		VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
//		VIPVCMPage.contents.VCMModalCloseButton.click();
//		Thread.sleep(1500);
//		VIPVCMPage.contents.BackButton.click();
//		VIPVCMPage.contents.VCMHelpIcon.click();
//		VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
//		WebControl.takeScreenshot("VCM_Reg_Auto_067");
//		
//		ReportLog.setTestCase("VCM_Reg_Auto_068");
//		//VIPVCMPage.contents.VCMModalDoNotShowCheckbox.click();
//		VIPVCMPage.contents.VCMModalCloseButton.click();
//		Thread.sleep(1500);
//		VIPVCMPage.contents.VCMHelpIcon.click();
//		VIPVCMPage.contents.VCMModal.verifyDisplayed(true, 5);
//		VIPVCMPage.contents.VCMModalCloseButton.click();
//		Thread.sleep(1500);
//		WebControl.takeScreenshot("VCM_Reg_Auto_068");
		
		ReportLog.setTestCase("VCM_Reg_Auto_069");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown8.click();
		VIPFinancialsPage.contents.OtherExpensesRevenueBox.click();
		String OER1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] OER2 = OER1.split("\\s");
		String OER = OER2[19];
		String OER3 = OER.replace("%", "");
		double OER4 = Double.parseDouble(OER3);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.SideMenuVCM.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
		VIPVCMPage.contents.VCMModalCloseButton.click();}
		VIPVCMPage.contents.VCMBodyTitle.waitForExist(true, 25);
		VIPVCMPage.contents.KPINameOER.verifyText("Operating Expense / Revenue");
		VIPVCMPage.contents.KPIOER.verifyText(OER);
		WebControl.takeScreenshot("VCM_Reg_Auto_069");
		
		ReportLog.setTestCase("VCM_Reg_Auto_070");
		VIPVCMPage.contents.VCMFootNote.verifyText("Note: The breakup of COGS and SG&A for Deutsche Telekom AG may not be correct as the company does not report its (SG&A / Revenue (%)) value.");
		WebControl.takeScreenshot("VCM_Reg_Auto_070");
		
		ReportLog.setTestCase("VCM_Reg_Auto_071");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.type("Avalon Advanced Materials Inc.");
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
		VIPVCMPage.contents.VCMPrivateCompMessage.verifyDisplayed(true, 45);
		VIPVCMPage.contents.VCMPrivateCompMessage.verifyText("Value Case Modeler cannot be built for this company since analyst estimates are not available to prepare the underlying DCF model.");
		WebControl.takeScreenshot("VCM_Reg_Auto_071");
		
	}
	
}


