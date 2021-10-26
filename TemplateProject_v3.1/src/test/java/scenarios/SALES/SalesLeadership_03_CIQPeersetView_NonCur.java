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

public class SalesLeadership_03_CIQPeersetView_NonCur extends TestBase{
	
	@Test
	public void Sales_CIQPeersetView_NonCurated () throws Exception {
		ReportLog.setTestName("Sales Leadership - CIQ Peerset View Non Curated");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_076_078_079");	
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.nonCurrComp);
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
		VIPCompetitorPage.contents.CurratedNote.verifyText("Note: The default peer-set has been sourced from Capital IQ.");
		WebControl.takeScreenshot("Sales_Reg_Auto_076");
		VIPOverviewPage.contents.SearchType.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_078");
		VIPCompetitorPage.contents.CompetitorTitle.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_079");
		
		ReportLog.setTestCase("WEB_Reg_Auto_091");
		String PeersCounter1 = VIPCompetitorPage.contents.PeersCounter.getText();
		String[] PeersCounter2 = PeersCounter1.split("\\s");
		String PeersCounter = PeersCounter2[PeersCounter2.length - 1];
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING TOP 15 OF " + PeersCounter);
		WebControl.takeScreenshot("WEB_Reg_Auto_091");
		
		ReportLog.setTestCase("WEB_Reg_Auto_092");
		VIPCompetitorPage.contents.VerticalLine.verifyText("|");
		VIPCompetitorPage.contents.RefineCriteriaText.verifyText("REFINE CRITERIA");
		VIPCompetitorPage.contents.RefineCriteriaButton.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_092");
		
		ReportLog.setTestCase("Sales_Reg_Auto_087");		
		VIPCompetitorPage.contents.Competitors15thPeers.verifyDisplayed(true, 10);
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(false);
		String PeerCounter1 = VIPCompetitorPage.contents.PeersCounter.getText();
		String[] PeerCounter2 = PeerCounter1.split("\\s");
		String PeerCounter = PeerCounter2[PeerCounter2.length - 1];
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING TOP 15 OF " + PeerCounter);
		WebControl.takeScreenshot("Sales_Reg_Auto_087_1");
		String TargetIndustry1 = VIPCompetitorPage.contents.TargetIndustry.getText();
		String[] TargetIndustry2 = TargetIndustry1.split("\\n");
		String TargetIndustry = TargetIndustry2[0];
		//PeerIndustry1
		String PeerIndustry1_1 = VIPCompetitorPage.contents.PeerIndustry1.getText();
		String[] PeerIndustry1_2 = PeerIndustry1_1.split("\\n");
		String PeerIndustry1 = PeerIndustry1_2[1];
		VIPCompetitorPage.contents.PeerIndustry1.verifyText(TargetIndustry + "\n" + PeerIndustry1);
		//PeerIndustry2
		String PeerIndustry2_1 = VIPCompetitorPage.contents.PeerIndustry2.getText();
		String[] PeerIndustry2_2 = PeerIndustry2_1.split("\\n");
		String PeerIndustry2 = PeerIndustry2_2[1];
		VIPCompetitorPage.contents.PeerIndustry2.verifyText(TargetIndustry + "\n" + PeerIndustry2);
		//PeerIndustry3
		String PeerIndustry3_1 = VIPCompetitorPage.contents.PeerIndustry3.getText();
		String[] PeerIndustry3_2 = PeerIndustry3_1.split("\\n");
		String PeerIndustry3 = PeerIndustry3_2[1];
		VIPCompetitorPage.contents.PeerIndustry3.verifyText(TargetIndustry + "\n" + PeerIndustry3);
		//PeerIndustry4
		String PeerIndustry4_1 = VIPCompetitorPage.contents.PeerIndustry4.getText();
		String[] PeerIndustry4_2 = PeerIndustry4_1.split("\\n");
		String PeerIndustry4 = PeerIndustry4_2[1];
		VIPCompetitorPage.contents.PeerIndustry4.verifyText(TargetIndustry + "\n" + PeerIndustry4);
		//PeerIndustry5
		String PeerIndustry5_1 = VIPCompetitorPage.contents.PeerIndustry5.getText();
		String[] PeerIndustry5_2 = PeerIndustry5_1.split("\\n");
		String PeerIndustry5 = PeerIndustry5_2[1];
		VIPCompetitorPage.contents.PeerIndustry5.verifyText(TargetIndustry + "\n" + PeerIndustry5);
		//PeerIndustry6
		String PeerIndustry6_1 = VIPCompetitorPage.contents.PeerIndustry6.getText();
		String[] PeerIndustry6_2 = PeerIndustry6_1.split("\\n");
		String PeerIndustry6 = PeerIndustry6_2[1];
		VIPCompetitorPage.contents.PeerIndustry6.verifyText(TargetIndustry + "\n" + PeerIndustry6);
		//PeerIndustry7
		String PeerIndustry7_1 = VIPCompetitorPage.contents.PeerIndustry7.getText();
		String[] PeerIndustry7_2 = PeerIndustry7_1.split("\\n");
		String PeerIndustry7 = PeerIndustry7_2[1];
		VIPCompetitorPage.contents.PeerIndustry7.verifyText(TargetIndustry + "\n" + PeerIndustry7);
		//PeerIndustry8
		String PeerIndustry8_1 = VIPCompetitorPage.contents.PeerIndustry8.getText();
		String[] PeerIndustry8_2 = PeerIndustry8_1.split("\\n");
		String PeerIndustry8 = PeerIndustry8_2[1];
		VIPCompetitorPage.contents.PeerIndustry8.verifyText(TargetIndustry + "\n" + PeerIndustry8);
		//PeerIndustry9
		String PeerIndustry9_1 = VIPCompetitorPage.contents.PeerIndustry9.getText();
		String[] PeerIndustry9_2 = PeerIndustry9_1.split("\\n");
		String PeerIndustry9 = PeerIndustry9_2[1];
		VIPCompetitorPage.contents.PeerIndustry9.verifyText(TargetIndustry + "\n" + PeerIndustry9);
		//PeerIndustry10
		String PeerIndustry10_1 = VIPCompetitorPage.contents.PeerIndustry10.getText();
		String[] PeerIndustry10_2 = PeerIndustry10_1.split("\\n");
		String PeerIndustry10 = PeerIndustry10_2[1];
		VIPCompetitorPage.contents.PeerIndustry10.verifyText(TargetIndustry + "\n" + PeerIndustry10);
		//PeerIndustry11
		String PeerIndustry11_1 = VIPCompetitorPage.contents.PeerIndustry11.getText();
		String[] PeerIndustry11_2 = PeerIndustry11_1.split("\\n");
		String PeerIndustry11 = PeerIndustry11_2[1];
		VIPCompetitorPage.contents.PeerIndustry11.verifyText(TargetIndustry + "\n" + PeerIndustry11);
		//PeerIndustry12
		String PeerIndustry12_1 = VIPCompetitorPage.contents.PeerIndustry12.getText();
		String[] PeerIndustry12_2 = PeerIndustry12_1.split("\\n");
		String PeerIndustry12 = PeerIndustry12_2[1];
		VIPCompetitorPage.contents.PeerIndustry12.verifyText(TargetIndustry + "\n" + PeerIndustry12);
		//PeerIndustry13
		String PeerIndustry13_1 = VIPCompetitorPage.contents.PeerIndustry13.getText();
		String[] PeerIndustry13_2 = PeerIndustry13_1.split("\\n");
		String PeerIndustry13 = PeerIndustry13_2[1];
		VIPCompetitorPage.contents.PeerIndustry13.verifyText(TargetIndustry + "\n" + PeerIndustry13);
		//PeerIndustry14
		String PeerIndustry14_1 = VIPCompetitorPage.contents.PeerIndustry14.getText();
		String[] PeerIndustry14_2 = PeerIndustry14_1.split("\\n");
		String PeerIndustry14 = PeerIndustry14_2[1];
		VIPCompetitorPage.contents.PeerIndustry14.verifyText(TargetIndustry + "\n" + PeerIndustry14);
		//PeerIndustry15
		String PeerIndustry15_1 = VIPCompetitorPage.contents.PeerIndustry15.getText();
		String[] PeerIndustry15_2 = PeerIndustry15_1.split("\\n");
		String PeerIndustry15 = PeerIndustry15_2[1];
		VIPCompetitorPage.contents.PeerIndustry15.verifyText(TargetIndustry + "\n" + PeerIndustry15);
		WebControl.takeScreenshot("Sales_Reg_Auto_087_2");
		
		ReportLog.setTestCase("Sales_Reg_Auto_081");		
		VIPCompetitorPage.contents.CompetitorSearchbox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_081");
		
		ReportLog.setTestCase("WEB_Reg_Auto_082_&_093");
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Roku, Inc.");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 16 PEERS");
		
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
		
		VIPCompetitorPage.contents.Revenue1.verifyText(b16);
		VIPCompetitorPage.contents.Revenue2.verifyText(b15);
		VIPCompetitorPage.contents.Revenue3.verifyText(b14);
		VIPCompetitorPage.contents.Revenue4.verifyText(b13);
		VIPCompetitorPage.contents.Revenue5.verifyText(b12);
		VIPCompetitorPage.contents.Revenue6.verifyText(b11);
		VIPCompetitorPage.contents.Revenue7.verifyText(b10);
		VIPCompetitorPage.contents.Revenue8.verifyText(b9);
		VIPCompetitorPage.contents.Revenue9.verifyText(b8);
		VIPCompetitorPage.contents.Revenue10.verifyText(b7);
		VIPCompetitorPage.contents.Revenue11.verifyText(b6);
		VIPCompetitorPage.contents.Revenue12.verifyText(b5);
		VIPCompetitorPage.contents.Revenue13.verifyText(b4);
		VIPCompetitorPage.contents.Revenue14.verifyText(b3);
		VIPCompetitorPage.contents.Revenue15.verifyText(b2);
		VIPCompetitorPage.contents.Revenue16.verifyText(b1);
		WebControl.takeScreenshot("WEB_Reg_Auto_082_&_093");
		
		ReportLog.setTestCase("WEB_Reg_Auto_083");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.TopFilterDropdown.waitForExist(true, 10);
		VIPCompetitorPage.contents.TopFilterDropdown.click();
		VIPCompetitorPage.contents.TopFilterChoice25.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(true, 20);
		Thread.sleep(1500);
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Faith, Inc.");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.click();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors26thPeers.verifyDisplayed(false);
		String Counter1 = VIPCompetitorPage.contents.PeersCounter.getText();
		String[] Counter2 = Counter1.split("\\s");
		String Counter = Counter2[Counter2.length - 1];
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING TOP 25 OF " + Counter);
		WebControl.takeScreenshot("WEB_Reg_Auto_083");
		
		ReportLog.setTestCase("WEB_Reg_Auto_085");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.nonCurrComp);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		String[] TargetName = VIPLandingPage.contents.CompanyTypeAhead.getText().split("\\|");
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.CompanyNameHeader.waitForExist(true, 10);
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
		VIPCompetitorPage.contents.TargetCompName.verifyText(TargetName[0].replace(" ", "") + "\n" + TargetName[1].replace(" Ticker: ", ""));
		WebControl.takeScreenshot("WEB_Reg_Auto_088");
		
		ReportLog.setTestCase("WEB_Reg_Auto_089_&_093");
		VIPCompetitorPage.contents.Competitors1stPeers.click();
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.verifyDisplayed(true, 10);
		if (VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.isDisplayed()) {
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.click();}
		Thread.sleep(2000);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 14 PEERS");
		WebControl.takeScreenshot("WEB_Reg_Auto_089_&_093");
		
		ReportLog.setTestCase("WEB_Reg_Auto_090");
		String Revenues1_1 = VIPCompetitorPage.contents.Revenue1.getText();
		String Revenues1_2 = Revenues1_1.replace(",", "");
		int Revenues1 = Integer.parseInt(Revenues1_2);
		
		String Revenues2_1 = VIPCompetitorPage.contents.Revenue2.getText();
		String Revenues2_2 = Revenues2_1.replace(",", "");
		int Revenues2 = Integer.parseInt(Revenues2_2);
		
		String Revenues3_1 = VIPCompetitorPage.contents.Revenue3.getText();
		String Revenues3_2 = Revenues3_1.replace(",", "");
		int Revenues3 = Integer.parseInt(Revenues3_2);
		
		String Revenues4_1 = VIPCompetitorPage.contents.Revenue4.getText();
		String Revenues4_2 = Revenues4_1.replace(",", "");
		int Revenues4 = Integer.parseInt(Revenues4_2);
		
		String Revenues5_1 = VIPCompetitorPage.contents.Revenue5.getText();
		String Revenues5_2 = Revenues5_1.replace(",", "");
		int Revenues5 = Integer.parseInt(Revenues5_2);
		
		String Revenues6_1 = VIPCompetitorPage.contents.Revenue6.getText();
		String Revenues6_2 = Revenues6_1.replace(",", "");
		int Revenues6 = Integer.parseInt(Revenues6_2);
		
		String Revenues7_1 = VIPCompetitorPage.contents.Revenue7.getText();
		String Revenues7_2 = Revenues7_1.replace(",", "");
		int Revenues7 = Integer.parseInt(Revenues7_2);
		
		String Revenues8_1 = VIPCompetitorPage.contents.Revenue8.getText();
		String Revenues8_2 = Revenues8_1.replace(",", "");
		int Revenues8 = Integer.parseInt(Revenues8_2);
		
		String Revenues9_1 = VIPCompetitorPage.contents.Revenue9.getText();
		String Revenues9_2 = Revenues9_1.replace(",", "");
		int Revenues9 = Integer.parseInt(Revenues9_2);
		
		String Revenues10_1 = VIPCompetitorPage.contents.Revenue10.getText();
		String Revenues10_2 = Revenues10_1.replace(",", "");
		int Revenues10 = Integer.parseInt(Revenues10_2);
		
		String Revenues11_1 = VIPCompetitorPage.contents.Revenue11.getText();
		String Revenues11_2 = Revenues11_1.replace(",", "");
		int Revenues11 = Integer.parseInt(Revenues11_2);
		
		String Revenues12_1 = VIPCompetitorPage.contents.Revenue12.getText();
		String Revenues12_2 = Revenues12_1.replace(",", "");
		int Revenues12 = Integer.parseInt(Revenues12_2);
		
		String Revenues13_1 = VIPCompetitorPage.contents.Revenue13.getText();
		String Revenues13_2 = Revenues13_1.replace(",", "");
		int Revenues13 = Integer.parseInt(Revenues13_2);
		
		String Revenues14_1 = VIPCompetitorPage.contents.Revenue14.getText();
		String Revenues14_2 = Revenues14_1.replace(",", "");
		int Revenues14 = Integer.parseInt(Revenues14_2);
		
//		String Revenues15_1 = VIPCompetitorPage.contents.Revenue15.getText();
//		String Revenues15_2 = Revenues15_1.replace(",", "");
//		int Revenues15 = Integer.parseInt(Revenues15_2);
		
		List<Integer> lLists = new ArrayList<Integer>();
        lLists.add(Revenues1);       
        lLists.add(Revenues2);
        lLists.add(Revenues3);
        lLists.add(Revenues4);
        lLists.add(Revenues5);
        lLists.add(Revenues6);
        lLists.add(Revenues7);
        lLists.add(Revenues8);
        lLists.add(Revenues9);
        lLists.add(Revenues10);
        lLists.add(Revenues11);
        lLists.add(Revenues12);
        lLists.add(Revenues13);
        lLists.add(Revenues14);
//      lLists.add(Revenues15);
        
        Collections.sort(lLists);
        Integer r1 = lLists.get(0);
        Integer r2 = lLists.get(1);
        Integer r3 = lLists.get(2);
        Integer r4 = lLists.get(3);
        Integer r5 = lLists.get(4);
        Integer r6 = lLists.get(5);
        Integer r7 = lLists.get(6);
        Integer r8 = lLists.get(7);
        Integer r9 = lLists.get(8);
        Integer r10 = lLists.get(9);
        Integer r11 = lLists.get(10);
        Integer r12 = lLists.get(11);
        Integer r13 = lLists.get(12);
        Integer r14 = lLists.get(13);
//      Integer r15 = lLists.get(14);
        
        NumberFormat myFormats = NumberFormat.getInstance();
        myFormats.setGroupingUsed(true);
        String c1 = myFormats.format(r1);
        String c2 = myFormats.format(r2);
        String c3 = myFormats.format(r3);
        String c4 = myFormats.format(r4);
        String c5 = myFormats.format(r5);
        String c6 = myFormats.format(r6);
        String c7 = myFormats.format(r7);
        String c8 = myFormats.format(r8);
        String c9 = myFormats.format(r9);
        String c10 = myFormats.format(r10);
        String c11 = myFormats.format(r11);
        String c12 = myFormats.format(r12);
        String c13 = myFormats.format(r13);
        String c14 = myFormats.format(r14);
//      String c15 = myFormats.format(r15);
		
		VIPCompetitorPage.contents.Revenue1.verifyText(c14);
		VIPCompetitorPage.contents.Revenue2.verifyText(c13);
		VIPCompetitorPage.contents.Revenue3.verifyText(c12);
		VIPCompetitorPage.contents.Revenue4.verifyText(c11);
		VIPCompetitorPage.contents.Revenue5.verifyText(c10);
		VIPCompetitorPage.contents.Revenue6.verifyText(c9);
		VIPCompetitorPage.contents.Revenue7.verifyText(c8);
		VIPCompetitorPage.contents.Revenue8.verifyText(c7);
		VIPCompetitorPage.contents.Revenue9.verifyText(c6);
		VIPCompetitorPage.contents.Revenue10.verifyText(c5);
		VIPCompetitorPage.contents.Revenue11.verifyText(c4);
		VIPCompetitorPage.contents.Revenue12.verifyText(c3);
		VIPCompetitorPage.contents.Revenue13.verifyText(c2);
		VIPCompetitorPage.contents.Revenue14.verifyText(c1);
		//VIPCompetitorPage.contents.Revenue15.verifyText(c1);
		WebControl.takeScreenshot("WEB_Reg_Auto_090");
		
		ReportLog.setTestCase("WEB_Reg_Auto_094");
		VIPCompetitorPage.contents.CompanyNameHeader.verifyText("Company Name");
		VIPCompetitorPage.contents.IndustryLocationHeader.verifyText("Industry\n" + "Region / Country");
		VIPCompetitorPage.contents.LatestFinancialsHeader.verifyText("Latest\n" + "Financials");
		VIPCompetitorPage.contents.RevenueHeader.verifyText("Revenue\n" + "($MN)");
		VIPCompetitorPage.contents.MarketCapHeader.verifyText("Market Cap\n" + "($MN)");
		VIPCompetitorPage.contents.AliasHeader.verifyText("Edit Alias\n" + "Type a shorter name to be shown in the Financial Report instead of the longer standard company name.");
		VIPCompetitorPage.contents.TargetCompName.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetIndustry.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetFinancials.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetRevenue.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetMarketCap.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.TargetAlias.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.PeerIndustry1.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Peer1Financials.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Revenue1.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Peer1MarketCap.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.Peer1Alias.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_094");
		
		ReportLog.setTestCase("WEB_Reg_Auto_096");
		VIPCompetitorPage.contents.DisclaimerHeader.verifyText("DISCLAIMER");
		VIPCompetitorPage.contents.Disclaimer1.verifyText("(1) The peer set has been selected based on largest companies by revenue in same industry as target company and sourced from Capital IQ.");
		VIPCompetitorPage.contents.Disclaimer2.verifyText("(2) Dual-listed companies (e.g. Rio Tinto, Unilever, BHP Billiton) may appear more than once (while selecting target company or as a peer). Please choose the relevant company.");
		VIPCompetitorPage.contents.Disclaimer3.verifyText("(3) All KPIs may not be captured for private companies given limited reporting.");
		VIPCompetitorPage.contents.Disclaimer4.verifyText("(4) For special financial situations such as M&A, divestments, accounting standard changes and presence of financial services arm, Custom Report is recommended for more accurate analysis.");
		//VIPCompetitorPage.contents.Disclaimer5.verifyText("(5) Some Japanese and South Korean companies from the peer group (Toho Co., Ltd., Toei Company, Ltd., Daiichikosho Co., Ltd.) may have limited disclosure for operating leases and hence these may not have a similar lease adjustments as the rest of the peers");
		WebControl.takeScreenshot("WEB_Reg_Auto_096");
		
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
			//String TargetIndustry1 = VIPCompetitorPage.contents.TargetIndustry.getText();
			String TargetFinancials = VIPCompetitorPage.contents.TargetFinancials.getText();
			String TargetRevenue = VIPCompetitorPage.contents.TargetRevenue.getText();
			String TargetMarketCap = VIPCompetitorPage.contents.TargetMarketCap.getText();
			String Competitors1stPeers = VIPCompetitorPage.contents.Competitors1stPeers.getText();
			//String PeerIndustry1 = VIPCompetitorPage.contents.PeerIndustry1.getText();
			String Peer1Financials = VIPCompetitorPage.contents.Peer1Financials.getText();
			String PeerRevenue1 = VIPCompetitorPage.contents.Revenue1.getText();
			String Peer1MarketCap = VIPCompetitorPage.contents.Peer1MarketCap.getText();
			String Competitors2ndPeers = VIPCompetitorPage.contents.Competitors2ndPeers.getText();
			//String PeerIndustry2 = VIPCompetitorPage.contents.PeerIndustry2.getText();
			String Peer2Financials = VIPCompetitorPage.contents.Peer2Financials.getText();
			String PeerRevenue2 = VIPCompetitorPage.contents.Revenue2.getText();
			String Peer2MarketCap = VIPCompetitorPage.contents.Peer2MarketCap.getText();			
			String Competitors3rdPeers = VIPCompetitorPage.contents.Competitors3rdPeers.getText();
			//String PeerIndustry3 = VIPCompetitorPage.contents.PeerIndustry3.getText();
			String Peer3Financials = VIPCompetitorPage.contents.Peer3Financials.getText();
			String PeerRevenue3 = VIPCompetitorPage.contents.Revenue3.getText();
			String Peer3MarketCap = VIPCompetitorPage.contents.Peer3MarketCap.getText();
			String Competitors4thPeers = VIPCompetitorPage.contents.Competitors4thPeers.getText();
			//String PeerIndustry4 = VIPCompetitorPage.contents.PeerIndustry4.getText();
			String Peer4Financials = VIPCompetitorPage.contents.Peer4Financials.getText();
			String PeerRevenue4 = VIPCompetitorPage.contents.Revenue4.getText();
			String Peer4MarketCap = VIPCompetitorPage.contents.Peer4MarketCap.getText();			
			String Competitors5thPeers = VIPCompetitorPage.contents.Competitors5thPeers.getText();
			//String PeerIndustry5 = VIPCompetitorPage.contents.PeerIndustry5.getText();
			String Peer5Financials = VIPCompetitorPage.contents.Peer5Financials.getText();
			String PeerRevenue5 = VIPCompetitorPage.contents.Revenue5.getText();
			String Peer5MarketCap = VIPCompetitorPage.contents.Peer5MarketCap.getText();			
			String Competitors6thPeers = VIPCompetitorPage.contents.Competitors6thPeers.getText();
			//String PeerIndustry6 = VIPCompetitorPage.contents.PeerIndustry6.getText();
			String Peer6Financials = VIPCompetitorPage.contents.Peer6Financials.getText();
			String PeerRevenue6 = VIPCompetitorPage.contents.Revenue6.getText();
			String Peer6MarketCap = VIPCompetitorPage.contents.Peer6MarketCap.getText();			
			String Competitors7thPeers = VIPCompetitorPage.contents.Competitors7thPeers.getText();
			//String PeerIndustry7 = VIPCompetitorPage.contents.PeerIndustry7.getText();
			String Peer7Financials = VIPCompetitorPage.contents.Peer7Financials.getText();
			String PeerRevenue7 = VIPCompetitorPage.contents.Revenue7.getText();
			String Peer7MarketCap = VIPCompetitorPage.contents.Peer7MarketCap.getText();			
			String Competitors8thPeers = VIPCompetitorPage.contents.Competitors8thPeers.getText();
			//String PeerIndustry8 = VIPCompetitorPage.contents.PeerIndustry8.getText();
			String Peer8Financials = VIPCompetitorPage.contents.Peer8Financials.getText();
			String PeerRevenue8 = VIPCompetitorPage.contents.Revenue8.getText();
			String Peer8MarketCap = VIPCompetitorPage.contents.Peer8MarketCap.getText();			
			String Competitors9thPeers = VIPCompetitorPage.contents.Competitors9thPeers.getText();
			//String PeerIndustry9 = VIPCompetitorPage.contents.PeerIndustry9.getText();
			String Peer9Financials = VIPCompetitorPage.contents.Peer9Financials.getText();
			String PeerRevenue9 = VIPCompetitorPage.contents.Revenue9.getText();
			String Peer9MarketCap = VIPCompetitorPage.contents.Peer9MarketCap.getText();			
			String Competitors10thPeers = VIPCompetitorPage.contents.Competitors10thPeers.getText();
			//String PeerIndustry10 = VIPCompetitorPage.contents.PeerIndustry10.getText();
			String Peer10Financials = VIPCompetitorPage.contents.Peer10Financials.getText();
			String PeerRevenue10 = VIPCompetitorPage.contents.Revenue10.getText();
			String Peer10MarketCap = VIPCompetitorPage.contents.Peer10MarketCap.getText();			
			String Competitors11thPeers = VIPCompetitorPage.contents.Competitors11thPeers.getText();
			//String PeerIndustry11 = VIPCompetitorPage.contents.PeerIndustry11.getText();
			String Peer11Financials = VIPCompetitorPage.contents.Peer11Financials.getText();
			String PeerRevenue11 = VIPCompetitorPage.contents.Revenue11.getText();
			String Peer11MarketCap = VIPCompetitorPage.contents.Peer11MarketCap.getText();			
			String Competitors12thPeers = VIPCompetitorPage.contents.Competitors12thPeers.getText();
			//String PeerIndustry12 = VIPCompetitorPage.contents.PeerIndustry12.getText();
			String Peer12Financials = VIPCompetitorPage.contents.Peer12Financials.getText();
			String PeerRevenue12 = VIPCompetitorPage.contents.Revenue12.getText();
			String Peer12MarketCap = VIPCompetitorPage.contents.Peer12MarketCap.getText();			
			String Competitors13thPeers = VIPCompetitorPage.contents.Competitors13thPeers.getText();
			//String PeerIndustry13 = VIPCompetitorPage.contents.PeerIndustry13.getText();
			String Peer13Financials = VIPCompetitorPage.contents.Peer13Financials.getText();
			String PeerRevenue13 = VIPCompetitorPage.contents.Revenue13.getText();
			String Peer13MarketCap = VIPCompetitorPage.contents.Peer13MarketCap.getText();
			String Competitors14thPeers = VIPCompetitorPage.contents.Competitors14thPeers.getText();
			//String PeerIndustry14 = VIPCompetitorPage.contents.PeerIndustry14.getText();
			String Peer14Financials = VIPCompetitorPage.contents.Peer14Financials.getText();
			String PeerRevenue14 = VIPCompetitorPage.contents.Revenue14.getText();
			String Peer14MarketCap = VIPCompetitorPage.contents.Peer14MarketCap.getText();
//			String Competitors15thPeers = VIPCompetitorPage.contents.Competitors15thPeers.getText();
//			//String PeerIndustry15 = VIPCompetitorPage.contents.PeerIndustry15.getText();
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
		VIPCompetitorPage.contents.PeerIndustry1.verifyText(PeerIndustry1_1);
		VIPCompetitorPage.contents.Peer1Financials.verifyText(Peer1Financials);
		VIPCompetitorPage.contents.Revenue1.verifyText(PeerRevenue1);
		VIPCompetitorPage.contents.Peer1MarketCap.verifyText(Peer1MarketCap);		
		VIPCompetitorPage.contents.Competitors2ndPeers.verifyText(Competitors2ndPeers);
		VIPCompetitorPage.contents.PeerIndustry2.verifyText(PeerIndustry2_1);
		VIPCompetitorPage.contents.Peer2Financials.verifyText(Peer2Financials);
		VIPCompetitorPage.contents.Revenue2.verifyText(PeerRevenue2);
		VIPCompetitorPage.contents.Peer2MarketCap.verifyText(Peer2MarketCap);		
		VIPCompetitorPage.contents.Competitors3rdPeers.verifyText(Competitors3rdPeers);
		VIPCompetitorPage.contents.PeerIndustry3.verifyText(PeerIndustry3_1);
		VIPCompetitorPage.contents.Peer3Financials.verifyText(Peer3Financials);
		VIPCompetitorPage.contents.Revenue3.verifyText(PeerRevenue3);
		VIPCompetitorPage.contents.Peer3MarketCap.verifyText(Peer3MarketCap);		
		VIPCompetitorPage.contents.Competitors4thPeers.verifyText(Competitors4thPeers);
		VIPCompetitorPage.contents.PeerIndustry4.verifyText(PeerIndustry4_1);
		VIPCompetitorPage.contents.Peer4Financials.verifyText(Peer4Financials);
		VIPCompetitorPage.contents.Revenue4.verifyText(PeerRevenue4);
		VIPCompetitorPage.contents.Peer4MarketCap.verifyText(Peer4MarketCap);		
		VIPCompetitorPage.contents.Competitors5thPeers.verifyText(Competitors5thPeers);
		VIPCompetitorPage.contents.PeerIndustry5.verifyText(PeerIndustry5_1);
		VIPCompetitorPage.contents.Peer5Financials.verifyText(Peer5Financials);
		VIPCompetitorPage.contents.Revenue5.verifyText(PeerRevenue5);
		VIPCompetitorPage.contents.Peer5MarketCap.verifyText(Peer5MarketCap);		
		VIPCompetitorPage.contents.Competitors6thPeers.verifyText(Competitors6thPeers);
		VIPCompetitorPage.contents.PeerIndustry6.verifyText(PeerIndustry6_1);
		VIPCompetitorPage.contents.Peer6Financials.verifyText(Peer6Financials);
		VIPCompetitorPage.contents.Revenue6.verifyText(PeerRevenue6);
		VIPCompetitorPage.contents.Peer6MarketCap.verifyText(Peer6MarketCap);		
		VIPCompetitorPage.contents.Competitors7thPeers.verifyText(Competitors7thPeers);
		VIPCompetitorPage.contents.PeerIndustry7.verifyText(PeerIndustry7_1);
		VIPCompetitorPage.contents.Peer7Financials.verifyText(Peer7Financials);
		VIPCompetitorPage.contents.Revenue7.verifyText(PeerRevenue7);
		VIPCompetitorPage.contents.Peer7MarketCap.verifyText(Peer7MarketCap);		
		VIPCompetitorPage.contents.Competitors8thPeers.verifyText(Competitors8thPeers);
		VIPCompetitorPage.contents.PeerIndustry8.verifyText(PeerIndustry8_1);
		VIPCompetitorPage.contents.Peer8Financials.verifyText(Peer8Financials);
		VIPCompetitorPage.contents.Revenue8.verifyText(PeerRevenue8);
		VIPCompetitorPage.contents.Peer8MarketCap.verifyText(Peer8MarketCap);		
		VIPCompetitorPage.contents.Competitors9thPeers.verifyText(Competitors9thPeers);
		VIPCompetitorPage.contents.PeerIndustry9.verifyText(PeerIndustry9_1);
		VIPCompetitorPage.contents.Peer9Financials.verifyText(Peer9Financials);
		VIPCompetitorPage.contents.Revenue9.verifyText(PeerRevenue9);
		VIPCompetitorPage.contents.Peer9MarketCap.verifyText(Peer9MarketCap);		
		VIPCompetitorPage.contents.Competitors10thPeers.verifyText(Competitors10thPeers);
		VIPCompetitorPage.contents.PeerIndustry10.verifyText(PeerIndustry10_1);
		VIPCompetitorPage.contents.Peer10Financials.verifyText(Peer10Financials);
		VIPCompetitorPage.contents.Revenue10.verifyText(PeerRevenue10);
		VIPCompetitorPage.contents.Peer10MarketCap.verifyText(Peer10MarketCap);		
		VIPCompetitorPage.contents.Competitors11thPeers.verifyText(Competitors11thPeers);
		VIPCompetitorPage.contents.PeerIndustry11.verifyText(PeerIndustry11_1);
		VIPCompetitorPage.contents.Peer11Financials.verifyText(Peer11Financials);
		VIPCompetitorPage.contents.Revenue11.verifyText(PeerRevenue11);
		VIPCompetitorPage.contents.Peer11MarketCap.verifyText(Peer11MarketCap);		
		VIPCompetitorPage.contents.Competitors12thPeers.verifyText(Competitors12thPeers);
		VIPCompetitorPage.contents.PeerIndustry12.verifyText(PeerIndustry12_1);
		VIPCompetitorPage.contents.Peer12Financials.verifyText(Peer12Financials);
		VIPCompetitorPage.contents.Revenue12.verifyText(PeerRevenue12);
		VIPCompetitorPage.contents.Peer12MarketCap.verifyText(Peer12MarketCap);		
		VIPCompetitorPage.contents.Competitors13thPeers.verifyText(Competitors13thPeers);
		VIPCompetitorPage.contents.PeerIndustry13.verifyText(PeerIndustry13_1);
		VIPCompetitorPage.contents.Peer13Financials.verifyText(Peer13Financials);
		VIPCompetitorPage.contents.Revenue13.verifyText(PeerRevenue13);
		VIPCompetitorPage.contents.Peer13MarketCap.verifyText(Peer13MarketCap);		
		VIPCompetitorPage.contents.Competitors14thPeers.verifyText(Competitors14thPeers);
		VIPCompetitorPage.contents.PeerIndustry14.verifyText(PeerIndustry14_1);
		VIPCompetitorPage.contents.Peer14Financials.verifyText(Peer14Financials);
		VIPCompetitorPage.contents.Revenue14.verifyText(PeerRevenue14);
		VIPCompetitorPage.contents.Peer14MarketCap.verifyText(Peer14MarketCap);		
//		VIPCompetitorPage.contents.Competitors15thPeers.verifyText(Competitors15thPeers);
//		VIPCompetitorPage.contents.PeerIndustry15.verifyText(PeerIndustry15_1);
//		VIPCompetitorPage.contents.Peer15Financials.verifyText(Peer15Financials);
//		VIPCompetitorPage.contents.Revenue15.verifyText(PeerRevenue15);
//		VIPCompetitorPage.contents.Peer15MarketCap.verifyText(Peer15MarketCap);
		WebControl.takeScreenshot("Q2A_Regression_095");	
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
}


