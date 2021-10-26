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


public class Financials_Custom_13_AnalystComment extends TestBase{

	@Test(priority=1)
	public void Financials_AnalystComment () throws Exception {
		ReportLog.setTestName("CUSTOM - Analyst Commentary");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Competitiveness Analyst Commentary Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_127");
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
		VIPCustomPage.contents.AnalystCommentMenu.click();
		Thread.sleep(5000);
		VIPCustomPage.contents.AnalystCommentBox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox5.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox6.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_127");

		ReportLog.setTestCase("CUSTOM_RT_TC_128");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.AnalystCommentBox1.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox2.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox3.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox4.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox5.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox6.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalHeader1.verifyText("Commentary 1:");
		VIPCustomPage.contents.AnalystCommentModalHeader2.verifyText("Commentary 2:");
		VIPCustomPage.contents.AnalystCommentModalHeader3.verifyText("Commentary 3:");
		VIPCustomPage.contents.AnalystCommentModalHeader4.verifyText("Commentary 4:");
		VIPCustomPage.contents.AnalystCommentModalHeader5.verifyText("Commentary 5:");
		VIPCustomPage.contents.AnalystCommentModalHeader6.verifyText("Commentary 6:");
		VIPCustomPage.contents.AnalystCommentModalFormat1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat5.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat6.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount5.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount6.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextBox1.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox1.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox1.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount1.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox2.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox2.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox2.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount2.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox3.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox3.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox3.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount3.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox4.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox4.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox4.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount4.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox5.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox5.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox5.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount5.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox6.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox6.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox6.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount6.verifyText("545 characters remaining");
		VIPCustomPage.contents.ModalApplyButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox1.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox2.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox3.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox4.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox5.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox6.verifyText("test ");
			Thread.sleep(1000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_128");

		ReportLog.setTestCase("CUSTOM_RT_TC_129");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPCustomPage.contents.ModalCloseButton.click();
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 1);
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
		VIPCustomPage.contents.AnalystCommentMenu.click();
		Thread.sleep(5000);
		VIPCustomPage.contents.AnalystCommentBox1.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox2.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox3.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox4.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox5.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox6.verifyText("test ");
		WebControl.takeScreenshot("CUSTOM_RT_TC_129");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String AnalystCommentTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String AnalystCommentFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((AnalystCommentTagline.equals("Analyst Commentary")) & (AnalystCommentFootnote.equals("Source: Analyst Reports; Accenture Client Value services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("257 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("788 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Commentary_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Analyst Reports; Accenture Client Value services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Analyst Commentary_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: Analyst Reports; Accenture Client Value services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("257 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("788 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Commentary_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Analyst Reports; Accenture Client Value services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Commentary_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Analyst Reports; Accenture Client Value services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
}
