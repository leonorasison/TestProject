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



public class Financials_Custom_05_HRGlassdoor extends TestBase{

	@Test(priority=1)
	public void Financials_HRGlassdoor () throws Exception {
		ReportLog.setTestName("CUSTOM - HR Glassdoor Benchmarking");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* HR Glassdoor Benchmarking Dashboard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_076,077");
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
		VIPCustomPage.contents.HRAMenu.click();
		VIPCustomPage.contents.HRAOverall.verifyText("Overall\n" + "\n" + "Score");
		VIPCustomPage.contents.HRACulValues.verifyText("Culture\n"  + "\n" + "& Values");
		VIPCustomPage.contents.HRAWLBalance.verifyText("Work/Life\n"  + "\n" + "Balance");
		VIPCustomPage.contents.HRASrMgt.verifyText("Senior\n"  + "\n" +"Mgmt");
		VIPCustomPage.contents.HRAComBenefits.verifyText("Comp &\n"  + "\n" + "Benefits");
		VIPCustomPage.contents.HRACarOpp.verifyText("Career\n"  + "\n" + "Opportunities");
		VIPCustomPage.contents.HRARecoFriend.verifyText("Recommend\n"  + "\n" + "to Friend");
		VIPCustomPage.contents.HRACEOApproval.verifyText("CEO\n"  + "\n" +"Approval");
		VIPCustomPage.contents.HRAPosOutlook.verifyText("Positive\n"  + "\n" + "Outlook");
		VIPCustomPage.contents.HRAReviews.verifyText("# of\n"  + "\n" + "Reviews");
		VIPCustomPage.contents.HRAPMText.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue5.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue6.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue7.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue8.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue9.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_076,077");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String GlassdoorTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String GlassdoorFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((GlassdoorTagline.equals("HR Analysis – Glassdoor Benchmarking (Absolute Values)")) & (GlassdoorFootnote.equals("Source: Glassdoor; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("221 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("794 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("HR Analysis – Glassdoor Benchmarking (Absolute Values)_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Glassdoor; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("HR Analysis – Glassdoor Benchmarking (Absolute Values)_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: Glassdoor; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("221 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("794 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("HR Analysis – Glassdoor Benchmarking (Absolute Values)_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Glassdoor; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("HR Analysis – Glassdoor Benchmarking (Absolute Values)_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Glassdoor; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
			
	}
}
