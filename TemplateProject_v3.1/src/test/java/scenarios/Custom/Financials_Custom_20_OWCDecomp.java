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

public class Financials_Custom_20_OWCDecomp extends TestBase{

    @Test(priority=1)
	public void CUSTOM_OWCDecomp () throws Exception {
		ReportLog.setTestName("CUSTOM - Operating Working Capital Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

        /* Operating Working Capital Decomposition Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_173");
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
		//Navigate to Operating Working Capital Decomposition Dashboard
		VIPCustomPage.contents.OWCMenu.click();
		VIPCustomPage.contents.LeftHandChartHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.LeftHandChartHeader.verifyText("OPERATING WORKING CAPITAL DECOMPOSITION");
		VIPCustomPage.contents.LeftHandChartNote.verifyDisplayed(true, 5);
        VIPCustomPage.contents.LeftHandChartNote.verifyText("Click on the KPI box to view peer comparison");
        VIPCustomPage.contents.WorkCapRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OpeCurAssRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NonIntBearLiabRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CashRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NetRecRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.InventoryRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OtherCurAssRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AccPayRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IncTaxPayRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OtherCurLiaRevBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.OpeCurAssRevBox.hover();
		VIPCustomPage.contents.OpeCurAssRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("OPERATING CURRENT ASSETS / REVENUE");
		VIPCustomPage.contents.NonIntBearLiabRevBox.hover();
		VIPCustomPage.contents.NonIntBearLiabRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("NON-INTEREST BEARING LIABILITIES / REVENUE");
		VIPCustomPage.contents.CashRevBox.hover();
		VIPCustomPage.contents.CashRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("CASH / REVENUE");
		VIPCustomPage.contents.NetRecRevBox.hover();
		VIPCustomPage.contents.NetRecRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("NET RECEIVABLES / REVENUE");
		VIPCustomPage.contents.InventoryRevBox.hover();
		VIPCustomPage.contents.InventoryRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("INVENTORY / REVENUE");
		VIPCustomPage.contents.OtherCurAssRevBox.hover();
		VIPCustomPage.contents.OtherCurAssRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("OTHER CUR. ASSETS / REVENUE");
		VIPCustomPage.contents.AccPayRevBox.hover();
		VIPCustomPage.contents.AccPayRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("ACCOUNTS PAYABLE / REVENUE");
		VIPCustomPage.contents.IncTaxPayRevBox.hover();
		VIPCustomPage.contents.IncTaxPayRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("INCOME TAX PAYABLE / REVENUE");
		VIPCustomPage.contents.OtherCurLiaRevBox.hover();
		VIPCustomPage.contents.OtherCurLiaRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("OTHER CURRENT LIABILITIES / REVENUE");
		VIPCustomPage.contents.WorkCapRevBox.hover();
		VIPCustomPage.contents.WorkCapRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("WORKING CAPITAL / REVENUE");
        WebControl.takeScreenshot("Custom_Reg_Auto_173");
        

        ReportLog.setTestCase("Q2A_Reg_Auto_174");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.WorkCapReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.WorkCapReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.WCRTooltip);
		VIPCustomPage.contents.WorkCapReviIcon.click();
		VIPCustomPage.contents.CashReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.CashReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.CRTooltip);
		VIPCustomPage.contents.CashReviIcon.click();
		VIPCustomPage.contents.NetRecReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.NetRecReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.NRTooltip);
		VIPCustomPage.contents.NetRecReviIcon.click();
		VIPCustomPage.contents.InventoryReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.InventoryReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.IRTooltip);
		VIPCustomPage.contents.InventoryReviIcon.click();
		VIPCustomPage.contents.AccPayReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.AccPayReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.APRTooltip);
		VIPCustomPage.contents.AccPayReviIcon.click();
		VIPCustomPage.contents.IncTaxPayReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.IncTaxPayReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.ITPRTooltip);
		VIPCustomPage.contents.IncTaxPayReviIcon.click();
        WebControl.takeScreenshot("Q2A_Reg_Auto_174");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_175");
		VIPCustomPage.contents.WCRBetterLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCRBetterLegendText.verifyText("Better than peer median");
		VIPCustomPage.contents.WCRWorseLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCRWorseLegendText.verifyText("Worse than peer median");
		VIPCustomPage.contents.WCRInlineLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCRInlineLegendText.verifyText("In-line with peer median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_175");

        ReportLog.setTestCase("Q2A_Reg_Auto_176");
		VIPCustomPage.contents.OWCPeerComparisonToggle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.OWCPeerComparisonToggleLabel.verifyText("Detailed Peer Comparison");
        VIPCustomPage.contents.OWCPeerComparisonToggle.click();
		VIPCustomPage.contents.OWCFirstPeriodHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCSecondPeriodHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCThirdPeriodHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCFirstPeriodChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCSecondPeriodChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCThirdPeriodChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_176");

        ReportLog.setTestCase("Q2A_Reg_Auto_177");
		VIPCustomPage.contents.OWCSIDropdown.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndWorkCapRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndOpeCurAssRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndCashRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndNetRecRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndInventoryRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndOtherCurAssRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndNonIntBearLiabRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndAccPayRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndIncTaxPayRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndOtherCurLiaRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndWorkCapRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndOpeCurAssRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("OPERATING CURRENT ASSETS / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndCashRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("CASH / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndNetRecRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("NET RECEIVABLES / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndInventoryRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("INVENTORY / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndOtherCurAssRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("OTHER CUR. ASSETS / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndNonIntBearLiabRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("NON-INTEREST BEARING LIABILITIES / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndAccPayRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("ACCOUNTS PAYABLE / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndIncTaxPayRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("INCOME TAX PAYABLE / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndOtherCurLiaRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("OTHER CURRENT LIABILITIES / REVENUE");
		WebControl.takeScreenshot("Q2A_Reg_Auto_177");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String OWCTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String OWCFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((OWCTagline.equals("Working Capital Tree")) & (OWCFootnote.equals("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("255 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Working Capital Tree_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Working Capital Tree_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("255 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Working Capital Tree_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Working Capital Tree_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
    
}
