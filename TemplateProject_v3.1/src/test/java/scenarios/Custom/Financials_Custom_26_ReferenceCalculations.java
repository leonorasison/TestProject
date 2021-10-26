package scenarios.Custom;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCustomPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class Financials_Custom_26_ReferenceCalculations extends TestBase{

    @Test(priority=1)
	public void CUSTOM_ReferenceCalculations () throws Exception {
		ReportLog.setTestName("CUSTOM - Reference Calculations");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

        /* Reference Calculations Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_221");
		VIP_Common.LogInPage(testDataHandler);
		WebControl.waitForPageToLoad(45);
		VIPCustomPage.contents.ModalCloseButton.click();
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		VIPLandingPage.contents.OverviewButton.hover();
		VIPLandingPage.contents.OverviewButtonTooltip.verifyText("Overview");
		VIPLandingPage.contents.OverviewButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
		//Navigate to Financials Tab		
		//VIPCustomPage.contents.FinancialsTabIcon.hover();
		//VIPCustomPage.contents.FinancialsTabIcon.verifyDisplayed(true, 10);
		VIPCustomPage.contents.FinancialsTab.hover();
		VIPCustomPage.contents.FinancialsTab.verifyDisplayed(true, 10);
		VIPCustomPage.contents.FinancialsTab.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Reference Calculations Dashboard
		VIPCustomPage.contents.ReferenceCalculationsMenu.click();
        VIPCustomPage.contents.SelectCompany.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_Reg_Auto_221");

        ReportLog.setTestCase("CUSTOM_Reg_Auto_222");
        VIPCustomPage.contents.SelectCurrency.verifyDisplayed(true, 5);
        VIPCustomPage.contents.SelectCurrencyDefault.verifyText("Target company currency");
        VIPCustomPage.contents.SelectCurrency.click();
        VIPCustomPage.contents.TargetCurrency.verifyText("Target company currency");
        VIPCustomPage.contents.LocalCurrency.verifyText("Local currency");
		VIPCustomPage.contents.SelectCurrency.click();
        WebControl.takeScreenshot("Custom_Reg_Auto_222");

		//NOPAT Calculations
		ReportLog.setTestCase("CUSTOM_Reg_Auto_223");
		//Column Headers
        VIPCustomPage.contents.NOPATCalcTitle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATCalcTitle.verifyText("NOPAT Calculations");
		VIPCustomPage.contents.NOPATCol1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATCol1.verifyText("Key Income Statement Items");
		VIPCustomPage.contents.NOPATYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NOPATYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NOPATTTM.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NOPATCAGR.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NOPATCAGR.verifyText("CAGR");
		//KPIs
		VIPCustomPage.contents.NOPATCurrencyRow.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATCurrencyRow.verifyText("Currency");
		VIPCustomPage.contents.NOPATRevenue.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATRevenue.verifyText("Revenue");
		VIPCustomPage.contents.NOPATCOGS.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATCOGS.verifyText("(-) Cost of Goods Sold");
		VIPCustomPage.contents.NOPATSGA.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATSGA.verifyText("(-) Selling, General and Admin Expenses");
		VIPCustomPage.contents.NOPATAdjEBIDTA.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATAdjEBIDTA.verifyText("= Adjusted EBITDA");
		VIPCustomPage.contents.NOPATDA.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATDA.verifyText("(-) Depreciation & Amortization");
		VIPCustomPage.contents.NOPATAdjEBIT.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATAdjEBIT.verifyText("= Adjusted EBIT");
		VIPCustomPage.contents.NOPATMarginalTaxes.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATMarginalTaxes.verifyText("(-) Marginal Taxes");
		VIPCustomPage.contents.NOPATKPI.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATKPI.verifyText("= NOPAT");
        WebControl.takeScreenshot("Custom_Reg_Auto_223");

		//Working Capital Calculations
		ReportLog.setTestCase("CUSTOM_Reg_Auto_224");
		//Column Headers
        VIPCustomPage.contents.WCCalcTitle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCalcTitle.verifyText("Working Capital Calculations");
		VIPCustomPage.contents.WCCol1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCol1.verifyText("Key Balance Sheet Items");
		VIPCustomPage.contents.WCYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCTTM.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCCAGR.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCCAGR.verifyText("CAGR");
		//KPIs
		VIPCustomPage.contents.WCCurrencyRow.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCurrencyRow.verifyText("Currency");
		VIPCustomPage.contents.WCCash.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCash.verifyText("Cash");
		VIPCustomPage.contents.WCNetReceivables.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCNetReceivables.verifyText("(+) Net Receivables");
		VIPCustomPage.contents.WCInventory.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCInventory.verifyText("(+) Inventory");
		VIPCustomPage.contents.WCOtherCurrAssets.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCOtherCurrAssets.verifyText("(+) Other Current Assets");
		VIPCustomPage.contents.WCOpCurrAssets.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCOpCurrAssets.verifyText("= Operating Current Assets (A)");
		VIPCustomPage.contents.WCAccPayable.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCAccPayable.verifyText("Accounts Payable");
		VIPCustomPage.contents.WCIncTaxPayable.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCIncTaxPayable.verifyText("(+) Income Tax Payable");
		VIPCustomPage.contents.WCOtherCurrLiab.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCOtherCurrLiab.verifyText("(+) Other Current Liabilities");
		VIPCustomPage.contents.WCNonIntBearLiab.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCNonIntBearLiab.verifyText("= Non-Interest-Bearing Liabilities (B)");
		VIPCustomPage.contents.WCWorkingCapital.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCWorkingCapital.verifyText("= Working Capital (A - B)");
		VIPCustomPage.contents.WCNetPPE.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCNetPPE.verifyText("(+) Net PPE");
		VIPCustomPage.contents.WCCapValOpLease.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCapValOpLease.verifyText("(+) Capitalized Value of Operating Lease");
		VIPCustomPage.contents.WCUnfundedRetLiab.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCUnfundedRetLiab.verifyText("(+) Unfunded Retirement Liabilities");
		VIPCustomPage.contents.WCGoodwillIntagibles.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCGoodwillIntagibles.verifyText("(+) Goodwill & Intangibles");
		VIPCustomPage.contents.WCNetOtherOpAssets.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCNetOtherOpAssets.verifyText("(+) Net Other Operating Assets");
		VIPCustomPage.contents.WCInvCapital.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCInvCapital.verifyText("= Invested Capital");
        WebControl.takeScreenshot("Custom_Reg_Auto_224");

		//Current and Future Value Calculations
		ReportLog.setTestCase("CUSTOM_Reg_Auto_225");
		//Column Headers
        VIPCustomPage.contents.CurrentFutureValueCalcTitle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureValueCalcTitle.verifyText("Current and Future Value Calculations");
		VIPCustomPage.contents.CurrentFutureValeCol1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureValeCol1.verifyText("Key Capital Markets Data");
		VIPCustomPage.contents.CurrentFutureYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureTTM.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureCurrentYear.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureCAGR.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureCAGR.verifyText("CAGR");
		//KPIs
		VIPCustomPage.contents.CurrentFutureCurrencyRow.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureCurrencyRow.verifyText("Currency");
		VIPCustomPage.contents.CurrentFutureNOPAT.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureNOPAT.verifyText("NOPAT (A)");
		VIPCustomPage.contents.CurrentFutureOpEntVal.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureOpEntVal.verifyText("Operating Enterprise Value (B)");
		VIPCustomPage.contents.CurrentFutureNetDebt.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureNetDebt.verifyText("Net Debt (C)");
		VIPCustomPage.contents.CurrentFutureWACC.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureWACC.verifyText("WACC (D)");
		VIPCustomPage.contents.CurrentFutureValCurrOp.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureValCurrOp.verifyText("Value of Current Operations (E = A / D)");
		VIPCustomPage.contents.CurrentFutureCurrValWeight.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureCurrValWeight.verifyText("Current Value weight (F = E / B)");
		VIPCustomPage.contents.CurrentFutureValFutureOp.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureValFutureOp.verifyText("Value of Future Operations (G = B - E)");
		VIPCustomPage.contents.CurrentFutureFutureValWeight.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureFutureValWeight.verifyText("Future Value weight (H = G / B)");
        WebControl.takeScreenshot("Custom_Reg_Auto_225");

		//Cash Cycle Calculations
		ReportLog.setTestCase("CUSTOM_Reg_Auto_226");
		//Column Headers
        VIPCustomPage.contents.CashCycleCalcTitle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleCalcTitle.verifyText("Cash Cycle Calculations");
		VIPCustomPage.contents.CashCycleCol1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleCol1.verifyText("Key Cash Cycle Data");
		VIPCustomPage.contents.CashCycleYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CashCycleYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CashCycleTTM.verifyDisplayed(true, 5);
		//KPIs
		VIPCustomPage.contents.CashCycleDSO.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleDSO.verifyText("Days Sales Outstanding");
		VIPCustomPage.contents.CashCycleDIO.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleDIO.verifyText("(+) Days Inventory Outstanding");
		VIPCustomPage.contents.CashCycleDPO.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleDPO.verifyText("(-) Days Payables Outstanding");
		VIPCustomPage.contents.CashCycleKPI.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleKPI.verifyText("= Cash Cycle");
		WebControl.takeScreenshot("CUSTOM_Reg_Auto_226");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String RefCalcTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String RefCalcFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((RefCalcTagline.equals("Reference Calculations")) & (RefCalcFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
			VIPCustomPage.contents.DefaultTagline.hover();
			VIPCustomPage.contents.TooltipText.verifyDisplayed(true, 5);
			VIPCustomPage.contents.TooltipText.verifyText("Click to edit tagline");
			VIPCustomPage.contents.DefaultFootnote.hover();
			VIPCustomPage.contents.TooltipText.verifyDisplayed(true, 5);
			VIPCustomPage.contents.TooltipText.verifyText("Click to edit footnote");
			VIPCustomPage.contents.DefaultFootnote.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineFootnoteModalTitle.verifyText("Add Tagline and Footnote:");
			VIPCustomPage.contents.ModalTaglineHeader.verifyText("Tagline:");
			VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("253 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Reference Calculations_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		else {
			VIPCustomPage.contents.DefaultTagline.hover();
			VIPCustomPage.contents.TooltipText.verifyDisplayed(true, 5);
			VIPCustomPage.contents.TooltipText.verifyText("Click to edit tagline");
			VIPCustomPage.contents.DefaultFootnote.hover();
			VIPCustomPage.contents.TooltipText.verifyDisplayed(true, 5);
			VIPCustomPage.contents.TooltipText.verifyText("Click to edit footnote");
			VIPCustomPage.contents.DefaultFootnote.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineFootnoteModalTitle.verifyText("Add Tagline and Footnote:");
			VIPCustomPage.contents.ModalTaglineHeader.verifyText("Tagline:");
			VIPCustomPage.contents.TaglineTextBox.clear();
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Reference Calculations_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("253 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Reference Calculations_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Reference Calculations_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		
    }   
}
