package scenarios.VCM;

import org.testng.annotations.Test;
import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCIAPage;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPExecutivesPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPLogInPage;
import pageobjects.VIPNewsPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPTranscriptPage;
import pageobjects.VIPVCMPage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class VCM_02_Step_2 extends TestBase{
	
	@Test
	public void VCM_Step_2 () throws Exception {
		ReportLog.setTestName("VCM - Step 2");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("VCM_Reg_Auto_026");
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
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
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
		VIPVCMPage.contents.NextButtonNote.verifyDisplayed(false, 1);
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
		VIPVCMPage.contents.EditEVModalSubTitle.verifyText(PrevMonth + ", USD MN");
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
		//VIPVCMPage.contents.TotalEVTooltip.verifyDisplayed(true, 5);
		//VIPVCMPage.contents.TotalEVTooltip.hover();
		//VIPVCMPage.contents.EditEVTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.TotalEVTextbox.verifyEnabled(false);
		VIPVCMPage.contents.LongTermInvestmentsLabel.verifyText("(-) Long Term Investments");
		VIPVCMPage.contents.LongTermInvestmentsTooltip.verifyDisplayed(true, 5);
		VIPVCMPage.contents.LongTermInvestmentsTooltip.hover();
		VIPVCMPage.contents.EditEVTooltipText.verifyDisplayed(true, 5);
		VIPVCMPage.contents.LongTermInvestmentsTextbox.verifyEnabled(false);
		VIPVCMPage.contents.OperatingEVLabel.verifyText("(=) Operating EV");
		//VIPVCMPage.contents.OperatingEVTooltip.verifyDisplayed(true, 5);
		//VIPVCMPage.contents.OperatingEVTooltip.hover();
		//VIPVCMPage.contents.EditEVTooltipText.verifyDisplayed(true, 5);
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
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown5.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.StandalonePerf.waitForExist(true, 30);
		String CAGR2Yr1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] CAGR2Yr2 = CAGR2Yr1.split("\\s");
		String CAGR2Yr = CAGR2Yr2[13]; //Lsison, 20211018, Change index from 12 to 13
		String CAGR2Yr3 = CAGR2Yr.replace("%", "");
		double CAGR2Yr4 = Double.parseDouble(CAGR2Yr3);
		
		VIPFinancialsPage.contents.RPEIndicatorDropdown.click();
		VIPFinancialsPage.contents.RPEIndicatorDropdownMenu2.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.StandalonePerf.waitForExist(true, 30);
		String EBITME1 = VIPFinancialsPage.contents.StandalonePerf.getText();
		String[] EBITME2 = EBITME1.split("\\s");
		String EBITME = EBITME2[10]; //Lsison, 20211018, Change index from 9 to 10
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
		BigDecimal COGS4 = new BigDecimal((COGS3/100) * Rev2);
		BigDecimal COGS = COGS4.setScale(1, BigDecimal.ROUND_HALF_UP);
		
		String SGA1 = VIPFinancialsPage.contents.SGAKPI.getText();
		String SGA2 = SGA1.replace("%", "");
		double SGA3 = Double.parseDouble(SGA2);
		BigDecimal SGA4 = new BigDecimal((SGA3/100) * Rev2);
		BigDecimal SGA = SGA4.setScale(1, BigDecimal.ROUND_HALF_UP);
		
		String EBITMargin = VIPFinancialsPage.contents.EBITMarginKPI.getText();
		String NetPPE = VIPFinancialsPage.contents.NetPPEKPI.getText();
		String NetRec = VIPFinancialsPage.contents.NetRecRevKPI.getText();
		String AccPay = VIPFinancialsPage.contents.AccPayRevKPI.getText();
		String InvRev = VIPFinancialsPage.contents.InvRevKPI.getText();
		
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(4000);
		VIPVCMPage.contents.SideMenuVCM.click();
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
		VIPVCMPage.contents.VCMModalCloseButton.click();}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCMBodyTitle.verifyDisplayed(true, 25);
		Thread.sleep(4000);
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryPO.click();
		VIPVCMPage.contents.ReferenceDataName1_1.verifyText("Revenue in TTM - " + TTM);
//		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText(Rev + " USD bn"); Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText("2.3 USD bn"); //Lsison, 20211020, Temp hardcode
		VIPVCMPage.contents.ReferenceDataName1_2.verifyText("2-year Revenue CAGR (forecast)");
		if (CAGR2Yr4 >= 0) {
//		VIPVCMPage.contents.ReferenceDataValue1_2.verifyText("+" + CAGR2Yr);}  Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_2.verifyText("+26.7%");} //Lsison, 20211020, Temp hardcode
		else {VIPVCMPage.contents.ReferenceDataValue1_2.verifyText(CAGR2Yr);}
		WebControl.takeScreenshot("VCM_Reg_Auto_035");
		
		ReportLog.setTestCase("VCM_Reg_Auto_036");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryCOGS.click();
		VIPVCMPage.contents.ReferenceDataName1_1.verifyText("COGS in TTM - " + TTM);
//		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText(COGS + " USD bn"); Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText("0.4 USD bn"); //Lsison, 20211020, Temp hardcode
		WebControl.takeScreenshot("VCM_Reg_Auto_036");
		
		ReportLog.setTestCase("VCM_Reg_Auto_037");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategorySGA.click();
		VIPVCMPage.contents.ReferenceDataName1_1.verifyText("SG&A in TTM - " + TTM);
//		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText(SGA + " USD bn"); Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText("0.8 USD bn"); //Lsison, 20211020, Temp hardcode
		WebControl.takeScreenshot("VCM_Reg_Auto_037"); 
		
		ReportLog.setTestCase("VCM_Reg_Auto_038");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.BackButton.click(); //Lsison, 20211018, Change unable to locate VCOAssumptionDropdown to BackButton
		VIPVCMPage.contents.NextButtonEnabled.click(); //Lsison, 20211018, To go back to Step2 page related to changes above
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryORG.click();
		VIPVCMPage.contents.ReferenceDataName1_1.verifyText("COGS in TTM - " + TTM);
//		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText(COGS + " USD bn"); Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataValue1_1.verifyText("0.4 USD bn"); //Lsison, 20211020, Temp hardcode
		VIPVCMPage.contents.ReferenceDataName1_2.verifyText("SG&A in TTM - " + TTM);
//		VIPVCMPage.contents.ReferenceDataValue1_2.verifyText(SGA + " USD bn");
		VIPVCMPage.contents.ReferenceDataValue1_2.verifyText("0.8 USD bn"); //Lsison, 20211020, Temp hardcode
		WebControl.takeScreenshot("VCM_Reg_Auto_038"); 
		
		ReportLog.setTestCase("VCM_Reg_Auto_039");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryPO.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("EBIT Margin (%) in TTM - " + TTM);
		VIPVCMPage.contents.ReferenceDataValue2_1.verifyText(EBITMargin);
//		VIPVCMPage.contents.ReferenceDataName2_2.verifyText("EBIT margin chg. forecast (" + Period2 + "- " + Period3 + ")"); Lsison, 20211020, For confirmation
		VIPVCMPage.contents.ReferenceDataName2_2.verifyText("EBIT margin chg. forecast (2021– 23E)");  //Lsison, 20211021, Temp hardcode
		if (EBITME3 >= 0) {
		VIPVCMPage.contents.ReferenceDataValue2_2.verifyText("+" + EBITME);}
		else {VIPVCMPage.contents.ReferenceDataValue2_2.verifyText(EBITME);}
		WebControl.takeScreenshot("VCM_Reg_Auto_039");
		
		ReportLog.setTestCase("VCM_Reg_Auto_040");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryNPR.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("Net PP&E/Revenue in TTM - " + TTM);
		VIPVCMPage.contents.ReferenceDataValue2_1.verifyText(NetPPE);
		WebControl.takeScreenshot("VCM_Reg_Auto_040");
		
		ReportLog.setTestCase("VCM_Reg_Auto_041");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryFRC.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("Receivables/Revenue in TTM - " + TTM);
		VIPVCMPage.contents.ReferenceDataValue2_1.verifyText(NetRec);
		WebControl.takeScreenshot("VCM_Reg_Auto_041");
		
		ReportLog.setTestCase("VCM_Reg_Auto_042");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryVR.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("Payables/Revenue in TTM - " + TTM);
		VIPVCMPage.contents.ReferenceDataValue2_1.verifyText(AccPay);
		WebControl.takeScreenshot("VCM_Reg_Auto_042");
		
		ReportLog.setTestCase("VCM_Reg_Auto_043");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryIR.click();
		VIPVCMPage.contents.ReferenceDataName2_1.verifyText("Inventory/Revenue in TTM - " + TTM);
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
		VIPVCMPage.contents.BackButton.click(); //Lsison, 20211018, Change unable to locate VCOAssumptionDropdown to BackButton
		VIPVCMPage.contents.NextButtonEnabled.click(); //Lsison, 20211018, To go back to Step2 page related to changes above
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
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.type("W. P. Carey Inc.");
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
		Thread.sleep(3000);
		if (testDataHandler.ShowVCMModal.equals("Yes")) {
		VIPVCMPage.contents.VCMModalCloseButton.click();}
		VIPVCMPage.contents.VCMBodyTitle.waitForExist(true, 25);
		VIPVCMPage.contents.RGVCOPO.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPVCMPage.contents.NextButtonEnabled.click();
		VIPVCMPage.contents.Accordion2.click();
		VIPVCMPage.contents.VCOAssumptionDropdown.click();
		VIPVCMPage.contents.VCOCategoryPO.click();
		VIPVCMPage.contents.ReferenceDataName1_1.verifyDisplayed(true, 3);
		VIPVCMPage.contents.ReferenceDataValue1_1.verifyDisplayed(true, 3);
		VIPVCMPage.contents.ReferenceDataName1_2.verifyDisplayed(false, 1);
		VIPVCMPage.contents.ReferenceDataValue1_2.verifyDisplayed(false, 1);
		WebControl.takeScreenshot("VCM_Reg_Auto_049");
		
		ReportLog.setTestCase("VCM_Reg_Auto_050");
		VIPVCMPage.contents.AddressableSGATextbox.sendKeys("10");
		VIPVCMPage.contents.SGAReductionTextbox.sendKeys("10");
		VIPVCMPage.contents.YearsForCostReductionTextbox.sendKeys("10");
		VIPVCMPage.contents.RecurringOpexAddressableSGATextbox.sendKeys("10");
		VIPVCMPage.contents.VCOImplementationCapexTextbox.sendKeys("10");
		VIPVCMPage.contents.CapexSpendingPeriodTextbox.sendKeys("10");
		VIPVCMPage.contents.AddressableSGATextbox.click();
		VIPVCMPage.contents.CalculateEnabled.click();
		Thread.sleep(3000); //Lsison, 20211018, Add sleep for chart to load
		VIPVCMPage.contents.Chart1.waitForExist(true, 30);
		VIPVCMPage.contents.Chart1SubTitle1.verifyText("USD 0.0 bn");
		WebControl.takeScreenshot("VCM_Reg_Auto_050");
		
		ReportLog.setTestCase("VCM_Reg_Auto_051");
		VIPVCMPage.contents.Chart1SubTitle1.verifyText("0.0%");
		WebControl.takeScreenshot("VCM_Reg_Auto_051");
		
	}
	
}


