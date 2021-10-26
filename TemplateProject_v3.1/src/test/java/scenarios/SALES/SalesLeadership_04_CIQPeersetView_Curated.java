package scenarios.SALES;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class SalesLeadership_04_CIQPeersetView_Curated extends TestBase{
	
	@Test
	public void Sales_CIQPeersetView_Curated () throws Exception {
		ReportLog.setTestName("Sales Leadership - CIQ Peerset View Curated");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_077_078_079");
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.currComp);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("Sales_Reg_Auto_077");
		VIPOverviewPage.contents.SearchType.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_078");
		VIPCompetitorPage.contents.CompetitorTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_079");
		
		ReportLog.setTestCase("Sales_Reg_Auto_080");
		VIPCompetitorPage.contents.CurratedNote.verifyText("Note: The proposed peer-set has been customized by the Client Value Services and the account team.\n" + 
				"See the complete list of clients with customized peer-set here.");
		VIPCompetitorPage.contents.CurratedNoteHighlight.verifyText("proposed peer-set");
		WebControl.takeScreenshot("Sales_Reg_Auto_080");
		
		ReportLog.setTestCase("Sales_Reg_Auto_081");		
		VIPCompetitorPage.contents.CompetitorSearchbox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_081");
		
		ReportLog.setTestCase("WEB_Reg_Auto_097");
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 18 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_097");
		
		ReportLog.setTestCase("WEB_Reg_Auto_098");
		VIPCompetitorPage.contents.VerticalLine.verifyText("|");
		VIPCompetitorPage.contents.RefineCriteriaText.verifyText("REFINE CRITERIA");
		VIPCompetitorPage.contents.RefineCriteriaButton.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_098");
		
		ReportLog.setTestCase("WEB_Reg_Auto_082_to_084_&_100");
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("JBS S.A.");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CurratedNote.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Disclaimer1.verifyText("(1) The peer set has been prepared by Accenture Client Value Services Team.");
		WebControl.takeScreenshot("WEB_Reg_Auto_100");
		VIPCompetitorPage.contents.Competitors19thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 19 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_084");
		//20th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Tyson Foods, Inc.");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors20thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 20 PEERS");
		//21th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Yihai Kerry");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors21thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 21 PEERS");
		//22th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("WH Group Limited");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors22thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 22 PEERS");
		//23th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Associated British Foods");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors23thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 23 PEERS");
		//24th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("CJ Cheiljedang");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors24thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 24 PEERS");
		//25th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Charoen Pokphand Foods");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 25 PEERS");
		//26th Peers
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Uni-President Enterprises");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors26thPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 25 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_083");
		
		String Revenue1_1 = VIPCompetitorPage.contents.Revenue1.getText();
		String Revenue1_2 = Revenue1_1.replace(",", "");
		int Revenue1 = Integer.parseInt(Revenue1_2);
		
		String Revenue2_1 = VIPCompetitorPage.contents.Revenue2.getText();
		String Revenue2_2 = Revenue2_1.replace(",", "");
		int Revenue2 = Integer.parseInt(Revenue2_2);
		
		String Revenue3_1 = VIPCompetitorPage.contents.Revenue3.getText();
		String Revenue3_2 = Revenue3_1.replace(",", "");
		int Revenue3 = Integer.parseInt(Revenue3_2);
		
		String Revenue4_1 = VIPCompetitorPage.contents.Revenue4.getText();
		String Revenue4_2 = Revenue4_1.replace(",", "");
		int Revenue4 = Integer.parseInt(Revenue4_2);
		
		String Revenue5_1 = VIPCompetitorPage.contents.Revenue5.getText();
		String Revenue5_2 = Revenue5_1.replace(",", "");
		int Revenue5 = Integer.parseInt(Revenue5_2);
		
		String Revenue6_1 = VIPCompetitorPage.contents.Revenue6.getText();
		String Revenue6_2 = Revenue6_1.replace(",", "");
		int Revenue6 = Integer.parseInt(Revenue6_2);
		
		String Revenue7_1 = VIPCompetitorPage.contents.Revenue7.getText();
		String Revenue7_2 = Revenue7_1.replace(",", "");
		int Revenue7 = Integer.parseInt(Revenue7_2);
		
		String Revenue8_1 = VIPCompetitorPage.contents.Revenue8.getText();
		String Revenue8_2 = Revenue8_1.replace(",", "");
		int Revenue8 = Integer.parseInt(Revenue8_2);
		
		String Revenue9_1 = VIPCompetitorPage.contents.Revenue9.getText();
		String Revenue9_2 = Revenue9_1.replace(",", "");
		int Revenue9 = Integer.parseInt(Revenue9_2);
		
		String Revenue10_1 = VIPCompetitorPage.contents.Revenue10.getText();
		String Revenue10_2 = Revenue10_1.replace(",", "");
		int Revenue10 = Integer.parseInt(Revenue10_2);
		
		String Revenue11_1 = VIPCompetitorPage.contents.Revenue11.getText();
		String Revenue11_2 = Revenue11_1.replace(",", "");
		int Revenue11 = Integer.parseInt(Revenue11_2);
		
		String Revenue12_1 = VIPCompetitorPage.contents.Revenue12.getText();
		String Revenue12_2 = Revenue12_1.replace(",", "");
		int Revenue12 = Integer.parseInt(Revenue12_2);
		
		String Revenue13_1 = VIPCompetitorPage.contents.Revenue13.getText();
		String Revenue13_2 = Revenue13_1.replace(",", "");
		int Revenue13 = Integer.parseInt(Revenue13_2);
		
		String Revenue14_1 = VIPCompetitorPage.contents.Revenue14.getText();
		String Revenue14_2 = Revenue14_1.replace(",", "");
		int Revenue14 = Integer.parseInt(Revenue14_2);
		
		String Revenue15_1 = VIPCompetitorPage.contents.Revenue15.getText();
		String Revenue15_2 = Revenue15_1.replace(",", "");
		int Revenue15 = Integer.parseInt(Revenue15_2);
		
		String Revenue16_1 = VIPCompetitorPage.contents.Revenue16.getText();
		String Revenue16_2 = Revenue16_1.replace(",", "");
		int Revenue16 = Integer.parseInt(Revenue16_2);
		
		String Revenue17_1 = VIPCompetitorPage.contents.Revenue17.getText();
		String Revenue17_2 = Revenue17_1.replace(",", "");
		int Revenue17 = Integer.parseInt(Revenue17_2);
		
		String Revenue18_1 = VIPCompetitorPage.contents.Revenue18.getText();
		String Revenue18_2 = Revenue18_1.replace(",", "");
		int Revenue18 = Integer.parseInt(Revenue18_2);
		
		String Revenue19_1 = VIPCompetitorPage.contents.Revenue19.getText();
		String Revenue19_2 = Revenue19_1.replace(",", "");
		int Revenue19 = Integer.parseInt(Revenue19_2);
		
		String Revenue20_1 = VIPCompetitorPage.contents.Revenue20.getText();
		String Revenue20_2 = Revenue20_1.replace(",", "");
		int Revenue20 = Integer.parseInt(Revenue20_2);
		
		String Revenue21_1 = VIPCompetitorPage.contents.Revenue21.getText();
		String Revenue21_2 = Revenue21_1.replace(",", "");
		int Revenue21 = Integer.parseInt(Revenue21_2);
		
		String Revenue22_1 = VIPCompetitorPage.contents.Revenue22.getText();
		String Revenue22_2 = Revenue22_1.replace(",", "");
		int Revenue22 = Integer.parseInt(Revenue22_2);
		
		String Revenue23_1 = VIPCompetitorPage.contents.Revenue23.getText();
		String Revenue23_2 = Revenue23_1.replace(",", "");
		int Revenue23 = Integer.parseInt(Revenue23_2);
		
		String Revenue24_1 = VIPCompetitorPage.contents.Revenue24.getText();
		String Revenue24_2 = Revenue24_1.replace(",", "");
		int Revenue24 = Integer.parseInt(Revenue24_2);
		
		String Revenue25_1 = VIPCompetitorPage.contents.Revenue25.getText();
		String Revenue25_2 = Revenue25_1.replace(",", "");
		int Revenue25 = Integer.parseInt(Revenue25_2);
		
		List<Integer> lList = new ArrayList<Integer>();
        lList.add(Revenue1);       
        lList.add(Revenue2);
        lList.add(Revenue3);
        lList.add(Revenue4);
        lList.add(Revenue5);
        lList.add(Revenue6);
        lList.add(Revenue7);
        lList.add(Revenue8);
        lList.add(Revenue9);
        lList.add(Revenue10);
        lList.add(Revenue11);
        lList.add(Revenue12);
        lList.add(Revenue13);
        lList.add(Revenue14);
        lList.add(Revenue15);
        lList.add(Revenue16);
        lList.add(Revenue17);
        lList.add(Revenue18);
        lList.add(Revenue19);
        lList.add(Revenue20);
        lList.add(Revenue21);
        lList.add(Revenue22);
        lList.add(Revenue23);
        lList.add(Revenue24);
        lList.add(Revenue25);
        
        Collections.sort(lList);
        Integer a1 = lList.get(0);
        Integer a2 = lList.get(1);
        Integer a3 = lList.get(2);
        Integer a4 = lList.get(3);
        Integer a5 = lList.get(4);
        Integer a6 = lList.get(5);
        Integer a7 = lList.get(6);
        Integer a8 = lList.get(7);
        Integer a9 = lList.get(8);
        Integer a10 = lList.get(9);
        Integer a11 = lList.get(10);
        Integer a12 = lList.get(11);
        Integer a13 = lList.get(12);
        Integer a14 = lList.get(13);
        Integer a15 = lList.get(14);
        Integer a16 = lList.get(15);
        Integer a17 = lList.get(16);
        Integer a18 = lList.get(17);
        Integer a19 = lList.get(18);
        Integer a20 = lList.get(19);
        Integer a21 = lList.get(20);
        Integer a22 = lList.get(21);
        Integer a23 = lList.get(22);
        Integer a24 = lList.get(23);
        Integer a25 = lList.get(24);
        
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
        String b1 = myFormat.format(a1);
        String b2 = myFormat.format(a2);
        String b3 = myFormat.format(a3);
        String b4 = myFormat.format(a4);
        String b5 = myFormat.format(a5);
        String b6 = myFormat.format(a6);
        String b7 = myFormat.format(a7);
        String b8 = myFormat.format(a8);
        String b9 = myFormat.format(a9);
        String b10 = myFormat.format(a10);
        String b11 = myFormat.format(a11);
        String b12 = myFormat.format(a12);
        String b13 = myFormat.format(a13);
        String b14 = myFormat.format(a14);
        String b15 = myFormat.format(a15);
        String b16 = myFormat.format(a16);
        String b17 = myFormat.format(a17);
        String b18 = myFormat.format(a18);
        String b19 = myFormat.format(a19);
        String b20 = myFormat.format(a20);
        String b21 = myFormat.format(a21);
        String b22 = myFormat.format(a22);
        String b23 = myFormat.format(a23);
        String b24 = myFormat.format(a24);
        String b25 = myFormat.format(a25);
		
		VIPCompetitorPage.contents.Revenue1.verifyText(b25);
		VIPCompetitorPage.contents.Revenue2.verifyText(b24);
		VIPCompetitorPage.contents.Revenue3.verifyText(b23);
		VIPCompetitorPage.contents.Revenue4.verifyText(b22);
		VIPCompetitorPage.contents.Revenue5.verifyText(b21);
		VIPCompetitorPage.contents.Revenue6.verifyText(b20);
		VIPCompetitorPage.contents.Revenue7.verifyText(b19);
		VIPCompetitorPage.contents.Revenue8.verifyText(b18);
		VIPCompetitorPage.contents.Revenue9.verifyText(b17);
		VIPCompetitorPage.contents.Revenue10.verifyText(b16);
		VIPCompetitorPage.contents.Revenue11.verifyText(b15);
		VIPCompetitorPage.contents.Revenue12.verifyText(b14);
		VIPCompetitorPage.contents.Revenue13.verifyText(b13);
		VIPCompetitorPage.contents.Revenue14.verifyText(b12);
		VIPCompetitorPage.contents.Revenue15.verifyText(b11);
		VIPCompetitorPage.contents.Revenue16.verifyText(b10);
		VIPCompetitorPage.contents.Revenue17.verifyText(b9);
		VIPCompetitorPage.contents.Revenue18.verifyText(b8);
		VIPCompetitorPage.contents.Revenue19.verifyText(b7);
		VIPCompetitorPage.contents.Revenue20.verifyText(b6);
		VIPCompetitorPage.contents.Revenue21.verifyText(b5);
		VIPCompetitorPage.contents.Revenue22.verifyText(b4);
		VIPCompetitorPage.contents.Revenue23.verifyText(b3);
		VIPCompetitorPage.contents.Revenue24.verifyText(b2);
		VIPCompetitorPage.contents.Revenue25.verifyText(b1);
		WebControl.takeScreenshot("WEB_Reg_Auto_082");	
		
		ReportLog.setTestCase("WEB_Reg_Auto_085");
		VIPCompetitorPage.contents.CompanyNameHeader.verifyText("Company Name");
		VIPCompetitorPage.contents.IndustryLocationHeader.verifyText("Industry\n" + "Region / Country");
		VIPCompetitorPage.contents.LatestFinancialsHeader.verifyText("Latest\n" + "Financials");
		VIPCompetitorPage.contents.RevenueHeader.verifyText("Revenue\n" + "($MN)");
		VIPCompetitorPage.contents.MarketCapHeader.verifyText("Market Cap\n" + "($MN)");
		VIPCompetitorPage.contents.AliasHeader.verifyText("Edit Alias");
		WebControl.takeScreenshot("WEB_Reg_Auto_085");
		
		ReportLog.setTestCase("WEB_Reg_Auto_086");
		VIPCompetitorPage.contents.AliasIcon.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.AliasIcon.click();
		VIPCompetitorPage.contents.TooltipText.verifyText("Type a shorter name to be shown in the Financial Report instead of the longer standard company name.");
		WebControl.takeScreenshot("WEB_Reg_Auto_086");
		
		ReportLog.setTestCase("WEB_Reg_Auto_088");
		VIPCompetitorPage.contents.TargetCompName.verifyText("General Mills, Inc.\n" + "NYSE:GIS");
		WebControl.takeScreenshot("WEB_Reg_Auto_088");
		
		ReportLog.setTestCase("WEB_Reg_Auto_089");
		VIPCompetitorPage.contents.Competitors1stPeers.click();
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.verifyDisplayed(true, 10);
		if (VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.isDisplayed()) {
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.click();}
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 24 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_089");
		
		ReportLog.setTestCase("WEB_Reg_Auto_099");
		VIPCompetitorPage.contents.DisclaimerHeader.verifyText("DISCLAIMER");
		VIPCompetitorPage.contents.Disclaimer1.verifyText("(1) The peer set has been prepared by Accenture Client Value Services Team.");
		VIPCompetitorPage.contents.Disclaimer2.verifyText("(2) Dual-listed companies (e.g. Rio Tinto, Unilever, BHP Billiton) may appear more than once (while selecting target company or as a peer). Please choose the relevant company.");
		VIPCompetitorPage.contents.Disclaimer3.verifyText("(3) All KPIs may not be captured for private companies given limited reporting.");
		VIPCompetitorPage.contents.Disclaimer4.verifyText("(4) For special financial situations such as M&A, divestments, accounting standard changes and presence of financial services arm, Custom Report is recommended for more accurate analysis.");
		//VIPCompetitorPage.contents.Disclaimer5.verifyText("(5) Some Japanese and South Korean companies from the peer group (Toho Co., Ltd., Toei Company, Ltd., Daiichikosho Co., Ltd.) may have limited disclosure for operating leases and hence these may not have a similar lease adjustments as the rest of the peers");
		WebControl.takeScreenshot("WEB_Reg_Auto_099");
		
		ReportLog.setTestCase("WEB_Reg_Auto_100");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.TopFilterDropdown.waitForExist(true, 10);
		VIPCompetitorPage.contents.TopFilterDropdown.click();
		VIPCompetitorPage.contents.TopFilterChoice25.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(true, 20);
		Thread.sleep(1500);
		VIPCompetitorPage.contents.CurratedNote.verifyText("Note: The default peer-set has been sourced from Capital IQ.");
		VIPCompetitorPage.contents.DisclaimerHeader.verifyText("DISCLAIMER");
		VIPCompetitorPage.contents.Disclaimer1.verifyText("(1) The peer set has been modified based on Refine Criteria and sourced from Capital IQ.");
		VIPCompetitorPage.contents.Disclaimer2.verifyText("(2) Dual-listed companies (e.g. Rio Tinto, Unilever, BHP Billiton) may appear more than once (while selecting target company or as a peer). Please choose the relevant company.");
		VIPCompetitorPage.contents.Disclaimer3.verifyText("(3) All KPIs may not be captured for private companies given limited reporting.");
		VIPCompetitorPage.contents.Disclaimer4.verifyText("(4) For special financial situations such as M&A, divestments, accounting standard changes and presence of financial services arm, Custom Report is recommended for more accurate analysis.");
		//VIPCompetitorPage.contents.Disclaimer5.verifyText("(5) Some Japanese and South Korean companies from the peer group (Toho Co., Ltd., Toei Company, Ltd., Daiichikosho Co., Ltd.) may have limited disclosure for operating leases and hence these may not have a similar lease adjustments as the rest of the peers");
		WebControl.takeScreenshot("WEB_Reg_Auto_100");
		
		ReportLog.setTestCase("Q2A_Regression_095");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
			VIPLandingPage.contents.HelpIcon.hover();
			VIPOverviewPage.contents.BackToSearchButton.hover();
			VIPOverviewPage.contents.BackToSearchButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
			Thread.sleep(3000);
			VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
			VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
			Thread.sleep(1000);
			VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
			VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
			VIPOverviewPage.contents.SideMenuCompetitor.click();	
			VIPCompetitorPage.contents.TargetCompName.waitForExist(true, 15);
			String TargetCompName = VIPCompetitorPage.contents.TargetCompName.getText();
			String TargetIndustry1 = VIPCompetitorPage.contents.TargetIndustry.getText();
			String TargetFinancials = VIPCompetitorPage.contents.TargetFinancials.getText();
			String TargetRevenue = VIPCompetitorPage.contents.TargetRevenue.getText();
			String TargetMarketCap = VIPCompetitorPage.contents.TargetMarketCap.getText();
			String Competitors1stPeers = VIPCompetitorPage.contents.Competitors1stPeers.getText();
			String PeerIndustry1 = VIPCompetitorPage.contents.PeerIndustry1.getText();
			String Peer1Financials = VIPCompetitorPage.contents.Peer1Financials.getText();
			String PeerRevenue1 = VIPCompetitorPage.contents.Revenue1.getText();
			String Peer1MarketCap = VIPCompetitorPage.contents.Peer1MarketCap.getText();
			String Competitors2ndPeers = VIPCompetitorPage.contents.Competitors2ndPeers.getText();
			String PeerIndustry2 = VIPCompetitorPage.contents.PeerIndustry2.getText();
			String Peer2Financials = VIPCompetitorPage.contents.Peer2Financials.getText();
			String PeerRevenue2 = VIPCompetitorPage.contents.Revenue2.getText();
			String Peer2MarketCap = VIPCompetitorPage.contents.Peer2MarketCap.getText();			
			String Competitors3rdPeers = VIPCompetitorPage.contents.Competitors3rdPeers.getText();
			String PeerIndustry3 = VIPCompetitorPage.contents.PeerIndustry3.getText();
			String Peer3Financials = VIPCompetitorPage.contents.Peer3Financials.getText();
			String PeerRevenue3 = VIPCompetitorPage.contents.Revenue3.getText();
			String Peer3MarketCap = VIPCompetitorPage.contents.Peer3MarketCap.getText();
			String Competitors4thPeers = VIPCompetitorPage.contents.Competitors4thPeers.getText();
			String PeerIndustry4 = VIPCompetitorPage.contents.PeerIndustry4.getText();
			String Peer4Financials = VIPCompetitorPage.contents.Peer4Financials.getText();
			String PeerRevenue4 = VIPCompetitorPage.contents.Revenue4.getText();
			String Peer4MarketCap = VIPCompetitorPage.contents.Peer4MarketCap.getText();			
			String Competitors5thPeers = VIPCompetitorPage.contents.Competitors5thPeers.getText();
			String PeerIndustry5 = VIPCompetitorPage.contents.PeerIndustry5.getText();
			String Peer5Financials = VIPCompetitorPage.contents.Peer5Financials.getText();
			String PeerRevenue5 = VIPCompetitorPage.contents.Revenue5.getText();
			String Peer5MarketCap = VIPCompetitorPage.contents.Peer5MarketCap.getText();			
			String Competitors6thPeers = VIPCompetitorPage.contents.Competitors6thPeers.getText();
			String PeerIndustry6 = VIPCompetitorPage.contents.PeerIndustry6.getText();
			String Peer6Financials = VIPCompetitorPage.contents.Peer6Financials.getText();
			String PeerRevenue6 = VIPCompetitorPage.contents.Revenue6.getText();
			String Peer6MarketCap = VIPCompetitorPage.contents.Peer6MarketCap.getText();			
			String Competitors7thPeers = VIPCompetitorPage.contents.Competitors7thPeers.getText();
			String PeerIndustry7 = VIPCompetitorPage.contents.PeerIndustry7.getText();
			String Peer7Financials = VIPCompetitorPage.contents.Peer7Financials.getText();
			String PeerRevenue7 = VIPCompetitorPage.contents.Revenue7.getText();
			String Peer7MarketCap = VIPCompetitorPage.contents.Peer7MarketCap.getText();			
			String Competitors8thPeers = VIPCompetitorPage.contents.Competitors8thPeers.getText();
			String PeerIndustry8 = VIPCompetitorPage.contents.PeerIndustry8.getText();
			String Peer8Financials = VIPCompetitorPage.contents.Peer8Financials.getText();
			String PeerRevenue8 = VIPCompetitorPage.contents.Revenue8.getText();
			String Peer8MarketCap = VIPCompetitorPage.contents.Peer8MarketCap.getText();			
			String Competitors9thPeers = VIPCompetitorPage.contents.Competitors9thPeers.getText();
			String PeerIndustry9 = VIPCompetitorPage.contents.PeerIndustry9.getText();
			String Peer9Financials = VIPCompetitorPage.contents.Peer9Financials.getText();
			String PeerRevenue9 = VIPCompetitorPage.contents.Revenue9.getText();
			String Peer9MarketCap = VIPCompetitorPage.contents.Peer9MarketCap.getText();			
			String Competitors10thPeers = VIPCompetitorPage.contents.Competitors10thPeers.getText();
			String PeerIndustry10 = VIPCompetitorPage.contents.PeerIndustry10.getText();
			String Peer10Financials = VIPCompetitorPage.contents.Peer10Financials.getText();
			String PeerRevenue10 = VIPCompetitorPage.contents.Revenue10.getText();
			String Peer10MarketCap = VIPCompetitorPage.contents.Peer10MarketCap.getText();			
			String Competitors11thPeers = VIPCompetitorPage.contents.Competitors11thPeers.getText();
			String PeerIndustry11 = VIPCompetitorPage.contents.PeerIndustry11.getText();
			String Peer11Financials = VIPCompetitorPage.contents.Peer11Financials.getText();
			String PeerRevenue11 = VIPCompetitorPage.contents.Revenue11.getText();
			String Peer11MarketCap = VIPCompetitorPage.contents.Peer11MarketCap.getText();			
//			String Competitors12thPeers = VIPCompetitorPage.contents.Competitors12thPeers.getText();
//			String PeerIndustry12 = VIPCompetitorPage.contents.PeerIndustry12.getText();
//			String Peer12Financials = VIPCompetitorPage.contents.Peer12Financials.getText();
//			String PeerRevenue12 = VIPCompetitorPage.contents.Revenue12.getText();
//			String Peer12MarketCap = VIPCompetitorPage.contents.Peer12MarketCap.getText();			
//			String Competitors13thPeers = VIPCompetitorPage.contents.Competitors13thPeers.getText();
//			String PeerIndustry13 = VIPCompetitorPage.contents.PeerIndustry13.getText();
//			String Peer13Financials = VIPCompetitorPage.contents.Peer13Financials.getText();
//			String PeerRevenue13 = VIPCompetitorPage.contents.Revenue13.getText();
//			String Peer13MarketCap = VIPCompetitorPage.contents.Peer13MarketCap.getText();
//			String Competitors14thPeers = VIPCompetitorPage.contents.Competitors14thPeers.getText();
//			String PeerIndustry14 = VIPCompetitorPage.contents.PeerIndustry14.getText();
//			String Peer14Financials = VIPCompetitorPage.contents.Peer14Financials.getText();
//			String PeerRevenue14 = VIPCompetitorPage.contents.Revenue14.getText();
//			String Peer14MarketCap = VIPCompetitorPage.contents.Peer14MarketCap.getText();
//			String Competitors15thPeers = VIPCompetitorPage.contents.Competitors15thPeers.getText();
//			String PeerIndustry15 = VIPCompetitorPage.contents.PeerIndustry15.getText();
//			String Peer15Financials = VIPCompetitorPage.contents.Peer15Financials.getText();
//			String PeerRevenue15 = VIPCompetitorPage.contents.Revenue15.getText();
//			String Peer15MarketCap = VIPCompetitorPage.contents.Peer15MarketCap.getText();
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
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
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompetitorTitle.waitForExist(true, 10);
		VIPCompetitorPage.contents.TargetCompName.waitForExist(true, 15);
		VIPCompetitorPage.contents.TargetCompName.verifyText(TargetCompName);
		VIPCompetitorPage.contents.TargetIndustry.verifyText(TargetIndustry1);
		VIPCompetitorPage.contents.TargetFinancials.verifyText(TargetFinancials);
		VIPCompetitorPage.contents.TargetRevenue.verifyText(TargetRevenue);
		VIPCompetitorPage.contents.TargetMarketCap.verifyText(TargetMarketCap);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyText(Competitors1stPeers);
		VIPCompetitorPage.contents.PeerIndustry1.verifyText(PeerIndustry1);
		VIPCompetitorPage.contents.Peer1Financials.verifyText(Peer1Financials);
		VIPCompetitorPage.contents.Revenue1.verifyText(PeerRevenue1);
		VIPCompetitorPage.contents.Peer1MarketCap.verifyText(Peer1MarketCap);		
		VIPCompetitorPage.contents.Competitors2ndPeers.verifyText(Competitors2ndPeers);
		VIPCompetitorPage.contents.PeerIndustry2.verifyText(PeerIndustry2);
		VIPCompetitorPage.contents.Peer2Financials.verifyText(Peer2Financials);
		VIPCompetitorPage.contents.Revenue2.verifyText(PeerRevenue2);
		VIPCompetitorPage.contents.Peer2MarketCap.verifyText(Peer2MarketCap);		
		VIPCompetitorPage.contents.Competitors3rdPeers.verifyText(Competitors3rdPeers);
		VIPCompetitorPage.contents.PeerIndustry3.verifyText(PeerIndustry3);
		VIPCompetitorPage.contents.Peer3Financials.verifyText(Peer3Financials);
		VIPCompetitorPage.contents.Revenue3.verifyText(PeerRevenue3);
		VIPCompetitorPage.contents.Peer3MarketCap.verifyText(Peer3MarketCap);		
		VIPCompetitorPage.contents.Competitors4thPeers.verifyText(Competitors4thPeers);
		VIPCompetitorPage.contents.PeerIndustry4.verifyText(PeerIndustry4);
		VIPCompetitorPage.contents.Peer4Financials.verifyText(Peer4Financials);
		VIPCompetitorPage.contents.Revenue4.verifyText(PeerRevenue4);
		VIPCompetitorPage.contents.Peer4MarketCap.verifyText(Peer4MarketCap);		
		VIPCompetitorPage.contents.Competitors5thPeers.verifyText(Competitors5thPeers);
		VIPCompetitorPage.contents.PeerIndustry5.verifyText(PeerIndustry5);
		VIPCompetitorPage.contents.Peer5Financials.verifyText(Peer5Financials);
		VIPCompetitorPage.contents.Revenue5.verifyText(PeerRevenue5);
		VIPCompetitorPage.contents.Peer5MarketCap.verifyText(Peer5MarketCap);		
		VIPCompetitorPage.contents.Competitors6thPeers.verifyText(Competitors6thPeers);
		VIPCompetitorPage.contents.PeerIndustry6.verifyText(PeerIndustry6);
		VIPCompetitorPage.contents.Peer6Financials.verifyText(Peer6Financials);
		VIPCompetitorPage.contents.Revenue6.verifyText(PeerRevenue6);
		VIPCompetitorPage.contents.Peer6MarketCap.verifyText(Peer6MarketCap);		
		VIPCompetitorPage.contents.Competitors7thPeers.verifyText(Competitors7thPeers);
		VIPCompetitorPage.contents.PeerIndustry7.verifyText(PeerIndustry7);
		VIPCompetitorPage.contents.Peer7Financials.verifyText(Peer7Financials);
		VIPCompetitorPage.contents.Revenue7.verifyText(PeerRevenue7);
		VIPCompetitorPage.contents.Peer7MarketCap.verifyText(Peer7MarketCap);		
		VIPCompetitorPage.contents.Competitors8thPeers.verifyText(Competitors8thPeers);
		VIPCompetitorPage.contents.PeerIndustry8.verifyText(PeerIndustry8);
		VIPCompetitorPage.contents.Peer8Financials.verifyText(Peer8Financials);
		VIPCompetitorPage.contents.Revenue8.verifyText(PeerRevenue8);
		VIPCompetitorPage.contents.Peer8MarketCap.verifyText(Peer8MarketCap);		
		VIPCompetitorPage.contents.Competitors9thPeers.verifyText(Competitors9thPeers);
		VIPCompetitorPage.contents.PeerIndustry9.verifyText(PeerIndustry9);
		VIPCompetitorPage.contents.Peer9Financials.verifyText(Peer9Financials);
		VIPCompetitorPage.contents.Revenue9.verifyText(PeerRevenue9);
		VIPCompetitorPage.contents.Peer9MarketCap.verifyText(Peer9MarketCap);		
		VIPCompetitorPage.contents.Competitors10thPeers.verifyText(Competitors10thPeers);
		VIPCompetitorPage.contents.PeerIndustry10.verifyText(PeerIndustry10);
		VIPCompetitorPage.contents.Peer10Financials.verifyText(Peer10Financials);
		VIPCompetitorPage.contents.Revenue10.verifyText(PeerRevenue10);
		VIPCompetitorPage.contents.Peer10MarketCap.verifyText(Peer10MarketCap);		
		VIPCompetitorPage.contents.Competitors11thPeers.verifyText(Competitors11thPeers);
		VIPCompetitorPage.contents.PeerIndustry11.verifyText(PeerIndustry11);
		VIPCompetitorPage.contents.Peer11Financials.verifyText(Peer11Financials);
		VIPCompetitorPage.contents.Revenue11.verifyText(PeerRevenue11);
		VIPCompetitorPage.contents.Peer11MarketCap.verifyText(Peer11MarketCap);		
//		VIPCompetitorPage.contents.Competitors12thPeers.verifyText(Competitors12thPeers);
//		VIPCompetitorPage.contents.PeerIndustry12.verifyText(PeerIndustry12);
//		VIPCompetitorPage.contents.Peer12Financials.verifyText(Peer12Financials);
//		VIPCompetitorPage.contents.Revenue12.verifyText(PeerRevenue12);
//		VIPCompetitorPage.contents.Peer12MarketCap.verifyText(Peer12MarketCap);		
//		VIPCompetitorPage.contents.Competitors13thPeers.verifyText(Competitors13thPeers);
//		VIPCompetitorPage.contents.PeerIndustry13.verifyText(PeerIndustry13);
//		VIPCompetitorPage.contents.Peer13Financials.verifyText(Peer13Financials);
//		VIPCompetitorPage.contents.Revenue13.verifyText(PeerRevenue13);
//		VIPCompetitorPage.contents.Peer13MarketCap.verifyText(Peer13MarketCap);		
//		VIPCompetitorPage.contents.Competitors14thPeers.verifyText(Competitors14thPeers);
//		VIPCompetitorPage.contents.PeerIndustry14.verifyText(PeerIndustry14);
//		VIPCompetitorPage.contents.Peer14Financials.verifyText(Peer14Financials);
//		VIPCompetitorPage.contents.Revenue14.verifyText(PeerRevenue14);
//		VIPCompetitorPage.contents.Peer14MarketCap.verifyText(Peer14MarketCap);		
//		VIPCompetitorPage.contents.Competitors15thPeers.verifyText(Competitors15thPeers);
//		VIPCompetitorPage.contents.PeerIndustry15.verifyText(PeerIndustry15);
//		VIPCompetitorPage.contents.Peer15Financials.verifyText(Peer15Financials);
//		VIPCompetitorPage.contents.Revenue15.verifyText(PeerRevenue15);
//		VIPCompetitorPage.contents.Peer15MarketCap.verifyText(Peer15MarketCap);
		WebControl.takeScreenshot("Q2A_Regression_095");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
}


