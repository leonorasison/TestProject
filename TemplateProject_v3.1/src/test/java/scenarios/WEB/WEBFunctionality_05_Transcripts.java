package scenarios.WEB;

import org.testng.annotations.Test;
import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPExecutivesPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPLogInPage;
import pageobjects.VIPNewsPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPTranscriptPage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WEBFunctionality_05_Transcripts extends TestBase{
	
	
	@Test
	public void WEBFunctionality_Transcripts () throws Exception {
		ReportLog.setTestName("WEB Functionality - Transcripts");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_142_to_144");		
		VIP_Common.LogInPage(testDataHandler);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		else { VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPTranscriptPage.contents.SideMenuTranscript.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.SideMenuTranscript.click();
		VIPTranscriptPage.contents.TranscriptTitle.verifyDisplayed(true, 20);
		VIPTranscriptPage.contents.TranscriptTitle.verifyText("Transcripts");
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 25);
		if (!VIPTranscriptPage.contents.FirstTranscriptTitle.isDisplayed()) { //Workaround if Target company has no Transcripts
			VIPLandingPage.contents.HelpIcon.hover();
			VIPOverviewPage.contents.BackToSearchButton.hover();
			VIPOverviewPage.contents.BackToSearchButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Uber");
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
			VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
			Thread.sleep(1000);
			VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
			VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
			Thread.sleep(2000);
			VIPTranscriptPage.contents.SideMenuTranscript.waitForExist(true, 10);
			VIPLandingPage.contents.HelpIcon.hover();
			VIPTranscriptPage.contents.SideMenuTranscript.click();
			VIPTranscriptPage.contents.TranscriptTitle.verifyDisplayed(true, 20);
			VIPTranscriptPage.contents.TranscriptTitle.verifyText("Transcripts");
			VIPTranscriptPage.contents.FirstTranscriptTitle.waitForExist(true, 20);
		}
		VIPTranscriptPage.contents.EventType1.hover();
		VIPTranscriptPage.contents.EventType1.verifyDisplayed(true, 5);
		VIPTranscriptPage.contents.EventType2.hover();
		VIPTranscriptPage.contents.EventType2.verifyDisplayed(true, 5);
		VIPTranscriptPage.contents.EventType3.hover();
		VIPTranscriptPage.contents.EventType3.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_142");
		VIPTranscriptPage.contents.FirstTranscriptTitle.hover();
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_143");
		VIPTranscriptPage.contents.EventType2.click();
		String FirstTranscript_1 = VIPTranscriptPage.contents.FirstTranscriptTitle.getText();
		VIPTranscriptPage.contents.EventType3.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyText(FirstTranscript_1, false);
		VIPTranscriptPage.contents.EventType4.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyText(FirstTranscript_1, false);
		WebControl.takeScreenshot("WEB_Reg_Auto_144");
		
		ReportLog.setTestCase("WEB_Reg_Auto_145");
		VIPLandingPage.contents.HelpIcon.hover();
		String FirstTranscript = VIPTranscriptPage.contents.FirstTranscriptTitle.getText();
		VIPTranscriptPage.contents.FirstTranscriptTitle.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyText(FirstTranscript);
		WebControl.takeScreenshot("WEB_Reg_Auto_145");
		
		ReportLog.setTestCase("WEB_Reg_Auto_146");
		VIPTranscriptPage.contents.ClearSelection.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.ClearSelection.verifyText("Clear Selection");
		WebControl.takeScreenshot("WEB_Reg_Auto_146");
		
		ReportLog.setTestCase("WEB_Reg_Auto_147");
		VIPTranscriptPage.contents.TranscriptSpeechName.verifyDisplayed(true, 10);
		VIPTranscriptPage.contents.TranscriptSpeechPosition.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.TranscriptSpeech.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_147");
		
		ReportLog.setTestCase("WEB_Reg_Auto_148");
//		String SpeechBody1 = VIPTranscriptPage.contents.TranscriptSpeech.getText();
//		String[] SpeechBody2 = SpeechBody1.split("\\s");
//		String Speech = SpeechBody2[1];
		VIPTranscriptPage.contents.SearchTextbox.sendKeys("a");
		VIPTranscriptPage.contents.Executives.click();
		VIPTranscriptPage.contents.Executives1.click();
		VIPTranscriptPage.contents.Selected.verifyText("a");
		VIPTranscriptPage.contents.Analysts.click();
		VIPTranscriptPage.contents.Analysts1.click();
		VIPTranscriptPage.contents.Selected.verifyText("a");
		WebControl.takeScreenshot("WEB_Reg_Auto_148");
		
		ReportLog.setTestCase("WEB_Reg_Auto_149");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.waitForExist(true, 10);
		VIPTranscriptPage.contents.FirstTranscriptTitle.click();
		VIPTranscriptPage.contents.TranscriptSpeech.waitForExist(true, 20);
		VIPTranscriptPage.contents.Executives.click();
		VIPTranscriptPage.contents.Executives1.click();
		String Speech1 = VIPTranscriptPage.contents.TranscriptSpeech.getText();
		String Speech2 = VIPTranscriptPage.contents.TranscriptSpeech2.getText();
		String Speech3 = VIPTranscriptPage.contents.TranscriptSpeech3.getText();
		String newSpeech1 = new String(Speech1);
		String newSpeech2 = new String(Speech2);
		String newSpeech3 = new String(Speech3);
		

		int count1 = Speech1.length();
	    if (count1 >= 750) {
	    	VIPTranscriptPage.contents.FirstMoreLink.verifyDisplayed(true);
	    }
	    else {VIPTranscriptPage.contents.FirstMoreLink.verifyDisplayed(false);}
	    

	    int count2 = Speech2.length();
	    if (count2 >= 750) {
	    	VIPTranscriptPage.contents.SecondMoreLink.verifyDisplayed(true);
	    }
	    else {VIPTranscriptPage.contents.SecondMoreLink.verifyDisplayed(false);}
	    

	    int count3 = Speech3.length();
	    if (count3 >= 750) {
	    	VIPTranscriptPage.contents.ThirdMoreLink.verifyDisplayed(true);
	    }
	    else {VIPTranscriptPage.contents.ThirdMoreLink.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_149");
		
		ReportLog.setTestCase("WEB_Reg_Auto_150");
		if (VIPTranscriptPage.contents.FirstMoreLink.isDisplayed()) {
		String TranscriptSpeechName = VIPTranscriptPage.contents.TranscriptSpeechName.getText();
		VIPTranscriptPage.contents.FirstMoreLink.hover();
		VIPTranscriptPage.contents.FirstMoreLink.click();
		VIPTranscriptPage.contents.SpeechModal.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.SpeechModalName.verifyText(TranscriptSpeechName);
		VIPTranscriptPage.contents.SpeechModalCloseButton.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_150");
		
		ReportLog.setTestCase("WEB_Reg_Auto_151");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(false);
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_151");}
		
		else if (VIPTranscriptPage.contents.SecondMoreLink.isDisplayed()) {
		String TranscriptSpeechName2 = VIPTranscriptPage.contents.TranscriptSpeechName2.getText();
		VIPTranscriptPage.contents.SecondMoreLink.hover();
		VIPTranscriptPage.contents.SecondMoreLink.click();
		VIPTranscriptPage.contents.SpeechModal.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.SpeechModalName.verifyText(TranscriptSpeechName2);
		VIPTranscriptPage.contents.SpeechModalCloseButton.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_150");
		
		ReportLog.setTestCase("WEB_Reg_Auto_151");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(false);
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_151");}
		
		else if (VIPTranscriptPage.contents.ThirdMoreLink.isDisplayed()) {
		String TranscriptSpeechName3 = VIPTranscriptPage.contents.TranscriptSpeechName3.getText();
		VIPTranscriptPage.contents.ThirdMoreLink.hover();
		VIPTranscriptPage.contents.ThirdMoreLink.click();
		VIPTranscriptPage.contents.SpeechModal.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.SpeechModalName.verifyText(TranscriptSpeechName3);
		VIPTranscriptPage.contents.SpeechModalCloseButton.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_150");
		
		ReportLog.setTestCase("WEB_Reg_Auto_151");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(false);
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_151");}
		
		else {VIPTranscriptPage.contents.FirstMoreLink.verifyDisplayed(false);
		VIPTranscriptPage.contents.SecondMoreLink.verifyDisplayed(false);
		VIPTranscriptPage.contents.ThirdMoreLink.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_150");
		
		ReportLog.setTestCase("WEB_Reg_Auto_151");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.BackToListButton.verifyDisplayed(true, 3);
		VIPTranscriptPage.contents.BackToListButton.click();
		VIPTranscriptPage.contents.SelectedTranscriptTitle.verifyDisplayed(false);
		VIPTranscriptPage.contents.FirstTranscriptTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_151");}
		
		ReportLog.setTestCase("WEB_Reg_Auto_152");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.noTransCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPTranscriptPage.contents.SideMenuTranscript.click();
		VIPTranscriptPage.contents.TranscriptNoData.verifyDisplayed(true, 10);
		VIPTranscriptPage.contents.TranscriptNoData.verifyText("Sorry! Data not available for this company");
		WebControl.takeScreenshot("WEB_Reg_Auto_152");

	}
	
}


