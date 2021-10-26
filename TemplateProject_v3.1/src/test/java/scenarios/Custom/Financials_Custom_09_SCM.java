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


public class Financials_Custom_09_SCM extends TestBase{

	@Test(priority=1)
	public void Financials_SCM () throws Exception {
		ReportLog.setTestName("CUSTOM - Strategic Control Map");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Competitiveness Strategic Control Map Dashboard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_100");
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
		VIPCustomPage.contents.SCMMenu.click();
		VIPCustomPage.contents.SCMChart1Title.verifyText("INVESTED CAPITAL PREMIUM (EV/IC)");
		VIPCustomPage.contents.SCMChart2Title.verifyText("INVESTED CAPITAL PREMIUM (EV/IC)");
		VIPCustomPage.contents.SCMChart3Title.verifyText("INVESTED CAPITAL TREND");
		WebControl.takeScreenshot("CUSTOM_RT_TC_100");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_101");
		VIPCustomPage.contents.SCMChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart3TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMLegendPeer.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_101");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_102");
		VIPCustomPage.contents.SCMChart1InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1InfoIcon.hover();
		VIPCustomPage.contents.SCMChart1Tooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.SCMChart1InfoIcon.click();
		//VIPCustomPage.contents.SCMChart1Tooltip1.verifyText(testDataHandler.SCMICPTooltip);
		VIPCustomPage.contents.SCMChart1Tooltip1.verifyText("EV/IC indicates the premium investors are attributing to the company’s invested capital.");
		VIPCustomPage.contents.SCMChart1InfoIcon.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_102");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_103");
		VIPCustomPage.contents.SCMChart1PencilIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1PencilIcon.hover();
		VIPCustomPage.contents.SCMPencilIconTooltip.verifyText("Click here to remove outliers from scatter");
		WebControl.takeScreenshot("CUSTOM_RT_TC_103");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_104,105");
		//105
		VIPCustomPage.contents.SCMChart1PencilIcon.click();
		VIPCustomPage.contents.SCMChart1Modal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalHeader.verifyText("Select/Deselect companies to show/hide");
		VIPCustomPage.contents.SCMChart1ModalNote.verifyText("Uncheck the companies to remove outliers from the Invested Capital Premium scatter chart. Please note that the peer median will not be affected as it will include all companies");
		VIPCustomPage.contents.SCMChart1ModalCheckbox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalCheckbox2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalApplyButton.verifyText("Apply");
		VIPCustomPage.contents.SCMChart1ModalXButton.verifyDisplayed(true, 5);
		//104
		VIPCustomPage.contents.SCMChart1ModalCheckbox1.click();
		VIPCustomPage.contents.SCMChart1ModalCheckbox2.click();
		VIPCustomPage.contents.SCMChart1ModalCheckbox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalUnCheckbox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalXButton.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_104,105");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_108,109");
		VIPCustomPage.contents.SCMToggleButton.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMToggleButton.click();
		VIPCustomPage.contents.SCMDPCTitle.verifyText("Detailed Peer Comparison");
		VIPCustomPage.contents.SCMDPCSITitle.verifyText("Select Indicator");
		VIPCustomPage.contents.SCMDPCSIButton.verifyText("Invested Capital Premium (EV/IC)");
		VIPCustomPage.contents.SCMDPCChartTitle.verifyText("INVESTED CAPITAL PREMIUM (EV/IC)");
		VIPCustomPage.contents.SCMDPCChartInfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartInfoIcon.hover();
		VIPCustomPage.contents.SCMDPCChartTooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.SCMDPCChartInfoIcon.click();
		//VIPCustomPage.contents.SCMDPCChartTooltip1.verifyText(testDataHandler.SCMICPTooltip);
		VIPCustomPage.contents.SCMDPCChartTooltip1.verifyText("EV/IC indicates the premium investors are attributing to the company’s invested capital.");
		VIPCustomPage.contents.SCMDPCChartInfoIcon.click();
		VIPCustomPage.contents.SCMDPCChartYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCLegendPeer.verifyDisplayed(true, 5);
		
		VIPCustomPage.contents.SCMDPCSIButton.click();
		VIPCustomPage.contents.SCMDPCInvestedCapital.click();
		VIPCustomPage.contents.SCMDPCChartTitle.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCLegendPeer.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_108,109");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String SCMTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String SCMFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((SCMTagline.equals("Scatter: Enterprise Value to IC")) & (SCMFootnote.equals("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("244 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("370 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: Enterprise Value to IC_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Scatter: Enterprise Value to IC_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("244 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("370 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: Enterprise Value to IC_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: Enterprise Value to IC_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");	
	}
}
