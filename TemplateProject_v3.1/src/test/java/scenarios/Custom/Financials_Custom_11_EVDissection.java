package scenarios.Custom;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCustomPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;


public class Financials_Custom_11_EVDissection extends TestBase{

	@Test(priority=1)
	public void Financials_EVDissection () throws Exception {
		ReportLog.setTestName("CUSTOM - EV Dissection");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Competitiveness EV Dissection Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_116");
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
		VIPCustomPage.contents.EVDissectionMenu.click();
		VIPCustomPage.contents.EVDissectionChart1Title.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EVDissectionChart2Title.verifyText("CURRENT AND FUTURE VALUE SPLIT OF EV");
		VIPCustomPage.contents.EVDissectionChart2Legend1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EVDissectionChart2Legend2.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_116");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_117");
		VIPCustomPage.contents.EVDissectionChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EVDissectionChart2TP.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_117");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String EVDissecTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String EVDissecFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((EVDissecTagline.equals("Target Future Value")) & (EVDissecFootnote.equals("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("256 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("9 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Target Future Value_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Target Future Value_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("256 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("9 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Target Future Value_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Target Future Value_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
}
