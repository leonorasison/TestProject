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

public class Financials_Custom_22_SegmentAnalysis extends TestBase{
    
    @Test(priority=1)
	public void CUSTOM_SegmentAnalysis () throws Exception {
		ReportLog.setTestName("CUSTOM - Segment Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

        /* Business Segment Analysis Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_185");
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
		//Navigate to Business Segment Analysis Dashboard
		VIPCustomPage.contents.BSAMenu.click();
		VIPCustomPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SegmentDropdownText.verifyText("All Segments");
        WebControl.takeScreenshot("Custom_Reg_Auto_185");
        
        ReportLog.setTestCase("Custom_Reg_Auto_186");
		VIPCustomPage.contents.SALeftHandChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SARighttHandChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_186");

		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String BusinessTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String BusinessFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((BusinessTagline.equals("Segment Analysis")) & (BusinessFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("259 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Segment Analysis_test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Segment Analysis_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("259 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Segment Analysis_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Segment Analysis_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");


		/* Geographic Segment Analysis Dashboard
		 * Author: alyssa.kay.n.mababa*/

		//Navigate to Geographic Segment Analysis Dashboard
		ReportLog.setTestCase("Custom_Reg_Auto_200");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		VIPCustomPage.contents.GSAMenu.click();
		VIPCustomPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SegmentDropdownText.verifyText("All Segments");
        WebControl.takeScreenshot("Custom_Reg_Auto_199");
        
        ReportLog.setTestCase("Custom_Reg_Auto_200");
		VIPCustomPage.contents.SALeftHandChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SARighttHandChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_200");
		
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String GeoTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String GeoFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((GeoTagline.equals("Geographic Analysis")) & (GeoFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Geographic Analysis_test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Geographic Analysis_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("256 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Geographic Analysis_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Geographic Analysis_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}

}
