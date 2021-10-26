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


public class Financials_Custom_18_PreTaxROICDrivers extends TestBase{

	@Test(priority=1)
	public void CUSTOM_PreTaxROICDrivers () throws Exception {
		ReportLog.setTestName("CUSTOM - Pre-Tax ROIC Drivers - Op.Margin vs. Cap. Eff.");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

        /* Pre-Tax ROIC Drivers - Op.Margin vs. Cap. Eff. Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_157");
		VIP_Common.LogInPage(testDataHandler);
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
		//Navigate to Pre-Tax ROIC Drivers - Op.Margin vs. Cap. Eff. Dashboard
		VIPCustomPage.contents.PreTaxROICDriversMenu.click();
        VIPCustomPage.contents.ROICBarChart.verifyDisplayed(true, 5);
        VIPCustomPage.contents.OpMagrinBarChart.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CapEffBarChart.verifyDisplayed(true, 5);
        VIPCustomPage.contents.ROICDriversChartTitle.verifyText("CHANGE IN PRE-TAX ROIC");
        VIPCustomPage.contents.OpMarginChartTitle.verifyText("CHANGE IN OPERATING MARGIN");
        VIPCustomPage.contents.CapEffChartTitle.verifyText("CHANGE IN CAPITAL EFFICIENCY");
        WebControl.takeScreenshot("Custom_Reg_Auto_157");
        
        ReportLog.setTestCase("CUSTOM_Reg_Auto_161");
        VIPCustomPage.contents.ROICInfoIcon.verifyDisplayed(true, 5);
        VIPCustomPage.contents.ROICInfoIcon.hover();
        VIPCustomPage.contents.ROICInfoIconTootltip.verifyText("Click here to view definitions");
        VIPCustomPage.contents.ROICInfoIcon.click();
        VIPCustomPage.contents.ROICInfoIconText.verifyText("Pre-tax ROIC represents a company's efficiency in generating profits from its core operations. It is calculated by dividing a company's Earnings Before Interest and Taxes (EBIT) by the average Invested Capital.");
		VIPCustomPage.contents.ROICInfoIcon.click();
		WebControl.takeScreenshot("Custom_Reg_Auto_161");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String ROICDriversTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String ROICDriversFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((ROICDriversTagline.equals("Scatter: ROIC Drivers")) & (ROICDriversFootnote.equals("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. "))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("254 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("667 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: ROIC Drivers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. _test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Scatter: ROIC Drivers_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. _test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("254 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("667 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: ROIC Drivers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. _test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: ROIC Drivers_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. _test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
}
