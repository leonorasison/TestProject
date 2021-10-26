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

public class Financials_Custom_25_Methdology extends TestBase{
	
    @Test(priority=1)
	public void CUSTOM_Methodology () throws Exception {
		ReportLog.setTestName("CUSTOM - Methodology");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

        /* Methodology Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_217");
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
		//Navigate to Methodology Dashboard
		VIPCustomPage.contents.MethodologyMenu.click();
        VIPCustomPage.contents.MethodologyText.verifyDisplayed(true, 5);
        VIPCustomPage.contents.MethodologyText.verifyText("Analysis is based on Accenture’s Shareholder Value Analysis framework. Value is created by earning an economic return on invested capital and magnifying positive spread by profitably growing revenues");
        WebControl.takeScreenshot("Custom_Reg_Auto_217");

        ReportLog.setTestCase("CUSTOM_Reg_Auto_218");
        Thread.sleep(5000);
        VIPCustomPage.contents.TRSBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.TRSBox.verifyText("Total Return to Shareholders (TRS)");
        VIPCustomPage.contents.TRSICon.verifyDisplayed(true, 5);
        VIPCustomPage.contents.DiscountedCashFlowBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.DiscountedCashFlowBox.verifyText("Value of the discounted cash flow to shareholders");
        VIPCustomPage.contents.DiscountedCashFlowIcon.verifyDisplayed(true, 5);
        VIPCustomPage.contents.SpreadBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.SpreadBox.verifyText("Spread");
        VIPCustomPage.contents.GrowthBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.GrowthBox.verifyText("Growth");
        VIPCustomPage.contents.ROICBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.ROICBox.verifyText("ROIC");
        VIPCustomPage.contents.CostofCapitalBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CostofCapitalBox.verifyText("Cost of Capital");
        VIPCustomPage.contents.OrganicBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.OrganicBox.verifyText("Organic");
        VIPCustomPage.contents.MABox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.MABox.verifyText("M&A");
        WebControl.takeScreenshot("Custom_Reg_Auto_218");

        ReportLog.setTestCase("CUSTOM_Reg_Auto_219");
        VIPCustomPage.contents.Text1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.Text1.verifyText("Increasing spread, the difference between ROIC and WACC, creates value");
        VIPCustomPage.contents.Text2.verifyDisplayed(true, 5);
        VIPCustomPage.contents.Text2.verifyText("Magnifying positive spread by growing revenue creates value");
        VIPCustomPage.contents.Text3.verifyDisplayed(true, 5);
        VIPCustomPage.contents.Text3.verifyText("All values in target’s currency");
        WebControl.takeScreenshot("Custom_Reg_Auto_219");

        ReportLog.setTestCase("CUSTOM_Reg_Auto_220");
        VIPCustomPage.contents.MinusCircle.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_220");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String MethodologyTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String MethodologyFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((MethodologyTagline.equals("Methodology")) & (MethodologyFootnote.equals("Source: Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("264 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("805 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Methodology_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Methodology_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("264 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("805 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Methodology_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Methodology_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
    }
    
}
