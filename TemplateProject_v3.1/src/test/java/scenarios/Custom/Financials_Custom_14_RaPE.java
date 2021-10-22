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


public class Financials_Custom_14_RaPE extends TestBase{

	@Test(priority=1)
	public void Financials_RaPE () throws Exception {
		ReportLog.setTestName("CUSTOM - Revenue and Profitability Estimates");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Competitiveness Revenue and Profitability Estimates Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_130");
		VIP_Common.LogInPage(testDataHandler);
		VIPCustomPage.contents.ModalCloseButton.click();
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		VIPLandingPage.contents.OverviewButton.hover();
		VIPLandingPage.contents.OverviewButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
		//NavigatetoFinancialsTab		
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.RaPEMenu.click();
		VIPCustomPage.contents.RaPESITitle.verifyText("Select Indicator");
		VIPCustomPage.contents.RaPESIButton.verifyText("Revenue Growth Estimates");
		VIPCustomPage.contents.RaPEChart1Title.verifyText("REVENUE YOY GROWTH ESTIMATES");
		VIPCustomPage.contents.RaPEChart2Title.verifyText("REVENUE CAGR");
		VIPCustomPage.contents.RaPEChart1LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart1LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPERevGrowth.verifyText("Revenue Growth Estimates");
		VIPCustomPage.contents.RaPEEBITMargin.verifyText("EBIT Margin Estimates");
		VIPCustomPage.contents.RaPEEBITDAMargin.verifyText("EBITDA Margin Estimates");
		VIPCustomPage.contents.RaPEEBITMargin.click();
		VIPCustomPage.contents.RaPEChart1Title.verifyText("EBIT MARGIN ESTIMATES");
		VIPCustomPage.contents.RaPEChart2Title.verifyText("CHANGE IN EBIT MARGIN (pps)");
		VIPCustomPage.contents.RaPEChart1LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart1LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITDAMargin.click();
		VIPCustomPage.contents.RaPEChart1Title.verifyText("EBITDA MARGIN ESTIMATES");
		VIPCustomPage.contents.RaPEChart2Title.verifyText("CHANGE IN EBITDA MARGIN (pps)");
		VIPCustomPage.contents.RaPEChart1LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart1LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.RaPEMenu.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_130");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_131");
		Thread.sleep(2000);
		//VIPCustomPage.contents.RaPESIButton.click();
		//VIPCustomPage.contents.RaPERevGrowth.click();
		VIPCustomPage.contents.RaPEChart1InfoIcon.hover();
		VIPCustomPage.contents.RaPETooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.RaPETooltipText.verifyText(testDataHandler.RGCAGRTooltip);
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITMargin.click();
		VIPCustomPage.contents.RaPEChart1InfoIcon.hover();
		VIPCustomPage.contents.RaPETooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.RaPETooltipText.verifyText(testDataHandler.EBITMDTooltip);
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITDAMargin.click();
		VIPCustomPage.contents.RaPEChart1InfoIcon.hover();
		VIPCustomPage.contents.RaPETooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		//VIPCustomPage.contents.RaPETooltipText.verifyText(testDataHandler.RaPETooltip);
		VIPCustomPage.contents.RaPETooltipText.verifyText("EBITDA margin is a measure of a company's operating profit from core operations, calculated as its earnings before interest, taxes, depreciation, and amortization as a percentage of revenues. EBITDA Margin Estimates are based on the average analyst consensus EBITDA margin forecast for a given period.");
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.RaPEMenu.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_131");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_132");
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPERevGrowth.click();
		VIPCustomPage.contents.RaPEChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITMargin.click();
		VIPCustomPage.contents.RaPEChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITDAMargin.click();
		VIPCustomPage.contents.RaPEChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.RaPEMenu.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_132");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String RaPETagline = VIPCustomPage.contents.DefaultTagline.getText();
		String RaPEFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((RaPETagline.equals("Analyst Estimates")) & (RaPEFootnote.equals("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("258 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("645 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Estimates_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Analyst Estimates_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("258 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("645 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Estimates_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Estimates_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
}
