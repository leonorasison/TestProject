package scenarios.Custom;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPCustomPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPLogInPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPFinancialsPage;
import java.util.Calendar;
import java.util.Date;

public class Financials_Custom_21_CashCycleAnalysis extends TestBase{

    @Test(priority=1)
	public void CUSTOM_CashCycleAnalysis () throws Exception {
		ReportLog.setTestName("CUSTOM - Cash Cycle Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

        /* Cash Cycle Analysis Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_180");
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
		//Navigate to Cash Cycle Analysis Dashboard
		VIPFinancialsPage.contents.CashCycleAnalysisMenu.click();
		VIPCustomPage.contents.ChartTimePeriod.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CCALeftHandChartNote.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CCALeftHandChartNote.verifyText("Click on the KPI box to view peer comparison");
		VIPFinancialsPage.contents.CCARightHandChart.verifyDisplayed(true, 5);
        VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Cash Cycle Days");
        VIPFinancialsPage.contents.CashCycleChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CashCycleChartHeader.verifyText("Cash Cycle");
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DaysSalesOutstandingChartHeader.verifyText("Days Sales Outstanding");
		VIPFinancialsPage.contents.InventoryDaysChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.InventoryDaysChartHeader.verifyText("Inventory Days");
		VIPFinancialsPage.contents.DaysPayableChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DaysPayableChartHeader.verifyText("Days Payable");
        WebControl.takeScreenshot("Custom_Reg_Auto_180");
        

        ReportLog.setTestCase("Custom_Reg_Auto_181");
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
        WebControl.takeScreenshot("Custom_Reg_Auto_181");
        

        ReportLog.setTestCase("Custom_Reg_Auto_183");
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.hover();
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Days Sales Outstanding");
		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.InventoryDaysChart.hover();
		VIPFinancialsPage.contents.InventoryDaysChart.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Inventory Days");
		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DaysPayableChart.hover();
		VIPFinancialsPage.contents.DaysPayableChart.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Days Payable");
		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CashCycleChart2.hover();
		VIPFinancialsPage.contents.CashCycleChart2.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Cash Cycle Days");
		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_183");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String CCATagline = VIPCustomPage.contents.DefaultTagline.getText();
		String CCAFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((CCATagline.equals("Cash Cycle")) & (CCAFootnote.equals("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("265 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Cash Cycle_test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Cash Cycle_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("265 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Cash Cycle_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Cash Cycle_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}

    
}
