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


public class Financials_Custom_04_VCA extends TestBase{

	@Test(priority=1)
	public void Financials_VCA () throws Exception {
		ReportLog.setTestName("CUSTOM - VCA");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Value Creation Areas Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_068");
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
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.VCATRS.verifyText("Total Return to Shareholders (TRS)");
		VIPCustomPage.contents.VCASpread.verifyText("Spread");
		VIPCustomPage.contents.VCAGrowth.verifyText("Growth");
		VIPCustomPage.contents.VCAROIC.verifyText("ROIC");
		VIPCustomPage.contents.VCAWACC.verifyText("WACC");
		VIPCustomPage.contents.VCAMA.verifyText("M&A");
		VIPCustomPage.contents.VCAOrganic.verifyText("Organic");
		VIPCustomPage.contents.VCAOM.verifyText("Operating Margin");
		VIPCustomPage.contents.VCACE.verifyText("Capital Efficiency");
		VIPCustomPage.contents.VCAOpexRev.verifyText("Opex / Revenue");
		VIPCustomPage.contents.VCADepRev.verifyText("Depreciation / Revenue");
		VIPCustomPage.contents.VCAWCRev.verifyText("Working Capital /Revenue");
		VIPCustomPage.contents.VCAPPERev.verifyText("Net PPE / Revenue");
		VIPCustomPage.contents.VCAGIRev.verifyText("Goodwill & Intangibles /Revenue");
		VIPCustomPage.contents.VCANOARev.verifyText("Net Other Assets / Revenue");
		VIPCustomPage.contents.VCACOGSRev.verifyText("COGS / Revenue");
		VIPCustomPage.contents.VCASGARev.verifyText("SG&A / Revenue");
		VIPCustomPage.contents.VCAOCARev.verifyText("Operating Current Assets /Revenue");
		VIPCustomPage.contents.VCANIBLRev.verifyText("Non -InterestBearing Liabilities / Revenue");
		VIPCustomPage.contents.VCACashRev.verifyText("Cash / Revenue");
		VIPCustomPage.contents.VCANRRev.verifyText("Net Receivables / Revenue");
		VIPCustomPage.contents.VCAInvRev.verifyText("Inventory / Revenue");
		VIPCustomPage.contents.VCAACARev.verifyText("Other Cur. Assets / Revenue");
		VIPCustomPage.contents.VCAAPRev.verifyText("Accounts Payables / Revenue");
		VIPCustomPage.contents.VCAITPRev.verifyText("Inc. Taxes Payables / Revenue");
		VIPCustomPage.contents.VCAOCLRev.verifyText("Other Current Liab . / Revenue ROIC DECOMPOSITIONWORKING CAPITAL DECOMPOSITION");
		WebControl.takeScreenshot("CUSTOM_RT_TC_068");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_073");
		VIPCustomPage.contents.VCAChart1Title.verifyText("VALUE CREATION AREAS");
		VIPCustomPage.contents.VCAChart1InfoIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.VCAChart1InfoIcon.click();
		VIPCustomPage.contents.TooltipText1.verifyText(testDataHandler.VCATooltip);
		VIPCustomPage.contents.VCAChart1InfoIcon.click();
		VIPCustomPage.contents.VCAChart2Title.verifyText("VALUE CREATION POTENTIAL");
		VIPCustomPage.contents.VCAChart2InfoIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.VCAChart2InfoIcon.click();
		VIPCustomPage.contents.TooltipText1.verifyText(testDataHandler.VCPTooltip);
		VIPCustomPage.contents.VCAChart2InfoIcon.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_073");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_074");
		VIPCustomPage.contents.VCAToggleTop.verifyText("VALUE CREATION POTENTIAL");
		VIPCustomPage.contents.VCAToggleTopArrow.verifyDisplayed(true, 5);
		VIPCustomPage.contents.VCAToggleTopArrow.click();
		VIPCustomPage.contents.VCAToggleBot.verifyText("VALUE CREATION AREAS");
		VIPCustomPage.contents.VCAToggleBotArrow.verifyDisplayed(true, 5);
		VIPCustomPage.contents.VCAToggleBotArrow.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_074");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String VCATagline = VIPCustomPage.contents.DefaultTagline.getText();
		String VCAFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((VCATagline.equals("Value Creation Potential")) & (VCAFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("251 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Value Creation Potential_test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Value Creation Potential_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("251 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Value Creation Potential_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Value Creation Potential_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
}
