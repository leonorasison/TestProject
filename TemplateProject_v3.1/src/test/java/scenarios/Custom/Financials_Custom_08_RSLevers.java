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


public class Financials_Custom_08_RSLevers extends TestBase{

	@Test(priority=1)
	public void Financials_TRSLevers () throws Exception {
		ReportLog.setTestName("CUSTOM - TRS Levers");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Competitiveness TRS Summary
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_093");
		VIP_Common.LogInPage(testDataHandler);
		VIPCustomPage.contents.ModalCloseButton.click();
		WebControl.waitForPageToLoad(30000);
		Thread.sleep(30000);
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
		VIPCustomPage.contents.TRSLeversMenu.click();
		VIPCustomPage.contents.TRSLeversSITitle.verifyText("Select Indicator");
		VIPCustomPage.contents.TRSLeversRevGrowth.verifyText("Revenue Growth");
		WebControl.takeScreenshot("CUSTOM_RT_TC_093");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_092");
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversRevGrowth.verifyText("Revenue Growth");
		VIPCustomPage.contents.TRSLeversEBITMargin.verifyText("Change in EBIT Margin");
		VIPCustomPage.contents.TRSLeversEVEBITMargin.verifyText("Change in EV/EBIT Multiple");
		VIPCustomPage.contents.TRSLeversDividendYield.verifyText("Dividend Yield");
		VIPCustomPage.contents.TRSLeversCapStructure.verifyText("Capital Structure Impact");
		VIPCustomPage.contents.TRSLeversSIButton.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_092");
		

		// [Updated 3/5/2021 by alyssa.kay.n.mababa]
		ReportLog.setTestCase("CUSTOM_RT_TC_096,097,098");
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("REVENUE GROWTH");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		String ObservationBoxText = VIPCustomPage.contents.ObservationsText.getText();
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}		
		Thread.sleep(2000);
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversEBITMargin.click();
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("CHANGE IN EBIT MARGIN");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}
		Thread.sleep(2000);
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversEVEBITMargin.click();
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("CHANGE IN EV/EBIT MULTIPLE");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}
		Thread.sleep(2000);
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversDividendYield.click();
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("DIVIDEND YIELD");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}
		Thread.sleep(2000);
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversCapStructure.click();
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("CAPITAL STRUCTURE IMPACT");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}
		WebControl.takeScreenshot("CUSTOM_RT_TC_096,097,098");		


		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String TRSLeversTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String TRSLeversFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((TRSLeversTagline.equals("3 Year TRS Decomposition - Levers")) & (TRSLeversFootnote.equals("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("242 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("533 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("3 Year TRS Decomposition - Levers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("3 Year TRS Decomposition - Levers_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("242 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("533 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("3 Year TRS Decomposition - Levers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("3 Year TRS Decomposition - Levers_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
}
