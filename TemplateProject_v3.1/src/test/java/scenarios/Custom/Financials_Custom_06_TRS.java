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


public class Financials_Custom_06_TRS extends TestBase{

	@Test(priority=1)
	public void Financials_TRS () throws Exception {
		ReportLog.setTestName("CUSTOM - TRS");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* TRS
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_080,081");
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
		VIPCustomPage.contents.TRSMenu.click();
		VIPCustomPage.contents.TRSSelectTFTitle.verifyText("Select Timeframe");
		VIPCustomPage.contents.TRSSelectTFDropdown.verifyText("3-year TRS");
		VIPCustomPage.contents.TRSSelectTFDropdown.click();
		VIPCustomPage.contents.TRS1Year.verifyText("1-year TRS");
		VIPCustomPage.contents.TRS3Year.verifyText("3-year TRS");
		VIPCustomPage.contents.TRS5Year.verifyText("5-year TRS");
		VIPCustomPage.contents.TRSSelectTFDropdown.click();
		VIPCustomPage.contents.TRSChart1Title.verifyText("3-YEAR TRS DEVELOPMENT");
		VIPCustomPage.contents.TRSChart2Title.verifyText("3-YEAR TRS CAGR");
		VIPCustomPage.contents.TRSChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSelectTFDropdown.click();
		VIPCustomPage.contents.TRS1Year.click();
		VIPCustomPage.contents.TRSChart1Title.verifyText("1-YEAR TRS DEVELOPMENT");
		VIPCustomPage.contents.TRSChart2Title.verifyText("1-YEAR TRS GROWTH");
		VIPCustomPage.contents.TRSChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSelectTFDropdown.click();
		VIPCustomPage.contents.TRS5Year.click();
		VIPCustomPage.contents.TRSChart1Title.verifyText("5-YEAR TRS DEVELOPMENT");
		VIPCustomPage.contents.TRSChart2Title.verifyText("5-YEAR TRS CAGR");
		VIPCustomPage.contents.TRSChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendPeer.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_080,081");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String TRSTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String TRSFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((TRSTagline.equals("Total Return to Shareholders (TRS)")) & (TRSFootnote.equals("Source: Bloomberg; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("241 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("794 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Total Return to Shareholders (TRS)_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Bloomberg; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Total Return to Shareholders (TRS)_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: Bloomberg; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("241 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("794 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Total Return to Shareholders (TRS)_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Bloomberg; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Total Return to Shareholders (TRS)_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Bloomberg; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
}
