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


public class Financials_Custom_12_AnalystReco extends TestBase{

	@Test(priority=1)
	public void Financials_AnalystReco () throws Exception {
		ReportLog.setTestName("CUSTOM - Analyst Recommendations");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Competitiveness Analyst Recommendations Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_120");
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
		VIPCustomPage.contents.AnalystRecoMenu.click();
		VIPCustomPage.contents.AnalystRecoChart1Title.verifyText("ANALYST RATINGS");
		VIPCustomPage.contents.AnalystRecoChart2Title.verifyText("EXPECTED 1-YEAR SHARE PRICE GROWTH");
		VIPCustomPage.contents.AnalystRecoChart1Legend1.verifyText("Company - Rating");
		VIPCustomPage.contents.AnalystRecoChart1Legend2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart1Legend3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart1Legend4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart2Legend1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart2Legend2.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_120");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_121");
		VIPCustomPage.contents.AnalystRecoChart1InfoIcon.hover();
		VIPCustomPage.contents.AnalystRecoToolTip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.AnalystRecoChart1InfoIcon.click();
		Thread.sleep(2000);
		//VIPCustomPage.contents.AnalystRecoToolTipText.verifyText(testDataHandler.ARTooltip);
		VIPCustomPage.contents.AnalystRecoToolTipText.verifyText("Analyst consensus rating is the average of analysts' rating about a stock's share price performance over the next one year.");
		VIPCustomPage.contents.AnalystRecoChart1InfoIcon.click();
		VIPCustomPage.contents.AnalystRecoChart2InfoIcon.hover();
		VIPCustomPage.contents.AnalystRecoToolTip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.AnalystRecoChart2InfoIcon.click();
		VIPCustomPage.contents.AnalystRecoToolTipText.verifyText(testDataHandler.SPGTooltip);
		VIPCustomPage.contents.AnalystRecoChart2InfoIcon.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_121");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_122");
		VIPCustomPage.contents.AnalystRecoChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart2TP.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_122");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String AnalystRecoTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String AnalystRecoFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((AnalystRecoTagline.equals("Analyst Recommendations")) & (AnalystRecoFootnote.equals("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("252 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("627 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Recommendations_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Analyst Recommendations_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("252 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("627 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Recommendations_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Recommendations_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
}
