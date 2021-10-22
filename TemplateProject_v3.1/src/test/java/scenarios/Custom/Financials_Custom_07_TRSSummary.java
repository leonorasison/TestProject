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


public class Financials_Custom_07_TRSSummary extends TestBase{

	@Test(priority=1)
	public void Financials_TRSSummary () throws Exception {
		ReportLog.setTestName("CUSTOM - TRS Summary");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Competitiveness TRS Summary
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_085,086,088");
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
		VIPCustomPage.contents.TRSSummaryMenu.click();
		VIPCustomPage.contents.TRSSToggleQuartiles.verifyText("Quartiles");
		VIPCustomPage.contents.TRSS3year.verifyText("3-year TRS CAGR");
		VIPCustomPage.contents.TRSSRevGrowth.verifyText("Revenue growth");
		//VIPCustomPage.contents.TRSSExcessMargin.verifyText("Excess change in margin");
		VIPCustomPage.contents.TRSSExcessMargin.verifyDisplayed(true, 5);
		//VIPCustomPage.contents.TRSSExcessEVEBIT.verifyText("Excess change in EV/EBIT");
		VIPCustomPage.contents.TRSSExcessEVEBIT.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSFundaValue.verifyText("Fundamental Value");
		VIPCustomPage.contents.TRSSInvExpectation.verifyText("Investor Expectation");
		VIPCustomPage.contents.TRSSDividendYield.verifyText("Dividend Yield");
		//VIPCustomPage.contents.TRSSCapitalStructure.verifyText("Capital Structure Impact");
		VIPCustomPage.contents.TRSSCapitalStructure.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSTimePeriod.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSCorrelation.verifyText("Correlation with TRS");
		VIPCustomPage.contents.TRSSToggleButton.click();
		VIPCustomPage.contents.TRSSToggleAllPeers.verifyText("All peers");
		VIPCustomPage.contents.TRSS3year.verifyText("3-year TRS CAGR");
		VIPCustomPage.contents.TRSSRevGrowth.verifyText("Revenue growth");
		//VIPCustomPage.contents.TRSSExcessMarginPeer.verifyText("Excess change in margin");
		VIPCustomPage.contents.TRSSExcessMarginPeer.verifyDisplayed(true, 5);
		//VIPCustomPage.contents.TRSSExcessEVEBITPeer.verifyText("Excess change in EV/EBIT");
		VIPCustomPage.contents.TRSSExcessEVEBITPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSFundaValue.verifyText("Fundamental Value");
		VIPCustomPage.contents.TRSSInvExpectation.verifyText("Investor Expectation");
		VIPCustomPage.contents.TRSSDividendYield.verifyText("Dividend Yield");
		//VIPCustomPage.contents.TRSSCapitalStructure.verifyText("Capital Structure Impact");
		VIPCustomPage.contents.TRSSCapitalStructure.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSTimePeriod.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSCorrelation.verifyText("Correlation with TRS");
		WebControl.takeScreenshot("CUSTOM_RT_TC_085,086,088");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String TRSSummaryTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String TRSSummaryFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((TRSSummaryTagline.equals("TRS Decom: All Peers")) & (TRSSummaryFootnote.equals("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.FootnoteCount.verifyText("426 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("TRS Decom: All Peers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("TRS Decom: All Peers_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("255 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("426 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("TRS Decom: All Peers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("TRS Decom: All Peers_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		
	}
}
