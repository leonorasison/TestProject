package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.web.Element;
// import auto.framework.web.TextBox;

public class VIPBankingPage extends PageBase{
	
	public static final Contents contents = new Contents();
	
	public static class Contents extends Element{
        //for remove hover
        public final Element RemoveHoverHelptext;
        //for Modal
        public final Element ModalCloseButton;
        public final Element SheldonDisabled;
        public final Element SheldonCloseButton;
        //tabs
        public final Element SideMenuOverview;
        public final Element SideMenuBankingAnalysisClick;
        public final Element SideMenuCompetitors;
        public final Element SideMenuCOVID;
        public final Element SideMenuFinancials;
        public final Element SideMenuOpMetrics;
        public final Element SideMenuExecutives;
        public final Element SideMenuExecutivesQA;
        public final Element SideMenuGITQA;
        public final Element SideMenuNews;
        public final Element SideMenuNewsQA;
        public final Element SideMenuTranscripts;
        //Start of Banking Page
        public final Element Spinner;
		public final Element SideMenuBankingAnalysis;
        public final Element IndustryAnalysisHeader;
        public final Element IndustryAnalystText1;
        public final Element SideMenuBankingAnalysisText;
        public final Element SideMenuNewsIconBank;
        public final Element SideMenuNewsQAIconBank;
        public final Element SideMenuNewsIconNBank;
        public final Element SideMenuNewsQAIconNBank;
        public final Element SideMenuNewsLoaded;
        public final Element SideMenuExecutivesLoaded;
        public final Element Header;
        public final Element Footer;
        public final Element DownloadButton;
        public final Element FinancialsSummaryTitle;
        public final Element BankingObservatoryPlatformLink;
        public final Element BankingObservatoryPlatformPage;
        public final Element PoweredByACNResearchLogo;
        public final Element FinancialsTitle;
        public final Element BackToSearch;
        //CIA
		public final Element SearchDisclaimer;
		public final Element IASideMenu;
		public final Element BIASideMenu;
		public final Element OpIncForSideMenuClick;
		public final Element EBTForSideMenuClick;
		public final Element TRSSideMenuClick;
		public final Element KeyInsightsText;
		public final Element KeyInsightsTitle;
		public final Element LiquidityRatio;
		//public final Element InfoIcon;
		public final Element TooltipText;
		public final Element UserEIDHeader;
		//Competitors
		public final Element CompetitorsSideMenu;
		public final Element CompetitorsTitle;
		public final Element CompanyNameHeader;
		public final Element IndustryCountryHeader;
		public final Element FinancialsHeader;
		public final Element OperatingIncomeHeader;
		public final Element TotalAssetsHeader;
		public final Element MarketCapHeader;
		public final Element EditAliasHeader;
		public final Element RefineCriteriaText;
		public final Element RefineCriteriaIcon;
		public final Element PeerItem;
		public final Element DeleteButton;
		public final Element AddBank;
		public final Element SubTitle;
		public final Element RefineCriteriaItem1;
		public final Element RefineCriteriaItem2;
		public final Element RefineCriteriaItem3;
		public final Element RefineCriteriaItem4;
		public final Element LastPeerItem;
		public final Element OverviewTitle;
		public final Element FinancialTitle;
		public final Element FinancialHeader;
		public final Element FinancialContent;
		public final Element TRSValue;
		public final Element KeyInsights;
		
		 // Financial Page - Author: Mico
        public final Element FinancialBestRank;
        public final Element FinancialBestRankCheckbox;
        public final Element FinancialBestColumn;
        public final Element FinancialRankColumn;
        public final Element FinancialTimePeriod;
        public final Element FinancialTRSHeader;
        public final Element FinancialAOHeader;
        public final Element FinancialIEHeader;
        public final Element FinancialOIGHeader;
        public final Element FinancialEPHeader;
        public final Element FinancialRDHeader;
        public final Element FinancialAIHeader;
        public final Element FinancialAIAssetGrowth;
        public final Element FinancialAIDepositGrowth;
        public final Element FinancialPBVIcon;
        public final Element FinancialPBVHover;
        // Operational Page - Author: Mico
        public final Element OperationalBestRank;
        public final Element OperationalBestRankCheckbox;
        public final Element OperationalBestColumn;
        public final Element OperationalRankColumn;
        public final Element OperationalTimePeriod;
        public final Element OperationalSCRTimePeriod;
        public final Element OperationalBranchAnalyis;
        public final Element OperationalSCRatio;
		
		public Contents() {
            super("Container", By.className("mainContainer"));
            //for remove hover
            RemoveHoverHelptext = new Element("Remove Hover for Financials", By.xpath("//*[@class='helptext']"), this);
            //for Modal
            ModalCloseButton = new Element("Modal Close Button", By.xpath("//*[@class='close-xbtn add-cls']"), this);
            SheldonDisabled = new Element("Sheldon Disabled", By.xpath("(//*[@class='modal-content'])[4]"), this);
            SheldonCloseButton = new Element("Sheldon Close Button", By.xpath("(//*[@class='modal-content'])[4]//button"), this);
            //tabs
            SideMenuOverview = new Element("Side Menu Overview", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[1]"), this);
            SideMenuBankingAnalysisClick = new Element("Banking Industry Analysis Click", By.xpath("//*[@class='sidemenuexpanded-bankanalysis-text ng-star-inserted']"), this);
            SideMenuCompetitors = new Element("Side Menu Competitors", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[2]"), this);
            SideMenuCOVID = new Element("Side Menu COVID", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[3]"), this);
            SideMenuFinancials = new Element("Side Menu Financials", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[4]"), this);
            SideMenuOpMetrics = new Element("Side Menu Op. Metrics", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[5]"), this);
            SideMenuExecutives = new Element("Side Menu Executives", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[7]"), this);
            SideMenuExecutivesQA = new Element("Side Menu Executives QA", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[7]"), this);
            SideMenuGITQA = new Element("Side Menu GIT QA", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[6]"), this);
            SideMenuNews = new Element("Side Menu News", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[7]"), this);
            SideMenuNewsQA = new Element("Side Menu News QA", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[8]"), this);
            SideMenuTranscripts = new Element("Side Menu Transcript", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[8]"), this);
            //start here
            Spinner = new Element("Sheldon Close Button", By.xpath("//*[@class='spinner']"), this);
            SideMenuBankingAnalysis = new Element("Banking Industry Analysis Side Menu", By.xpath("//*[@class='sidemenuexpanded-burger ng-star-inserted']"), this);
            IndustryAnalysisHeader = new Element("Industry Analysis Header", By.xpath("//*[@class='overview-header']"), this);
            IndustryAnalystText1 = new Element("Industry Analyst Text 1", By.xpath("//*[@class='overview-content']//li"), this);
            SideMenuBankingAnalysisText = new Element("Side Menu Banking Analysis Text", By.xpath("//*[@class='sidemenuexpanded-bankanalysis ng-star-inserted isShow']//div//div"), this);
            SideMenuNewsIconBank = new Element("Side Menu News Icon for Banking Companies", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[8]//img"), this);
            SideMenuNewsQAIconBank = new Element("Side Menu News Icon for Banking Companies", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[8]//img"), this);
            SideMenuNewsIconNBank = new Element("Side Menu News Icon for Non Banking Companies", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[10]//img"), this);
            SideMenuNewsQAIconNBank = new Element("Side Menu News Icon for Non Banking Companies", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[9]//img"), this);
            SideMenuNewsLoaded = new Element("Side Menu News Loaded", By.xpath("//*[@class='news-details-list ng-star-inserted']"), this);
            SideMenuExecutivesLoaded = new Element("Side Menu Executives Loaded", By.xpath("//*[@class='executive-detail']"), this);
            Header = new Element("Header", By.xpath("//*[@class='header-shrink-left-company']"), this);
            Footer = new Element("Footer", By.xpath("//*[@class='footer']"), this);
            DownloadButton = new Element("Download Button", By.xpath("(//*[@class='header-button ng-tns-c30-2 ng-star-inserted'])"), this);
            FinancialsSummaryTitle = new Element("Financials Summary Title", By.xpath("(//*[@class='overview-info-left-title'])[4]"), this);
            BankingObservatoryPlatformLink = new Element("Banking Observatory Platform Link", By.xpath("//*[@href='https://go.accenture.com/BankingObsBackup']"), this);
            BankingObservatoryPlatformPage = new Element("Banking Observatory Platform Page", By.xpath("//*[@class='visualContainerHost']"), this);
            PoweredByACNResearchLogo = new Element("Powered By ACN Research Logo", By.xpath("//*[@class='banking-logo']"), this);
            FinancialsTitle = new Element("Financials Title", By.xpath("//*[@class='financials-title']"), this);
            BackToSearch = new Element("Back to Search", By.xpath("//*[@class='header-backsearch']//img[@class='header-backsearch-img']"), this);
            SearchDisclaimer = new Element("Search Box Disclaimer", By.xpath("//*[@class='searchDisclaimer']"), this);
            UserEIDHeader = new Element("User EID Header", By.xpath("//*[@class='header-user-eid']"), this);
            TooltipText = new Element("Tooltip Text", By.xpath("//*[@class='tooltip-text']"), this);
            
            //Overview
			OverviewTitle = new Element("Overview Title", By.xpath("//*[@class='overview-title']"), this);
			FinancialTitle = new Element("Financial Title", By.xpath("//*[@class='overview-financials-title']"),this);
			FinancialHeader = new Element("Financial Header", By.xpath("//*[@class='overview-financials-title-sub']"),this);
			FinancialContent = new Element("Financial Content", By.xpath("//*[@class='overview-financials-title-notetext']"),this);
			TRSValue = new Element("TRS Value", By.xpath("(//*[@class='financial-gauge-value'])[1]/span"), this);
			KeyInsights = new Element ("Key Insights Container", By.xpath("//*[@class='keyinsights-container']"), this);
			
            //CIA
    		IASideMenu = new Element("Industry Analysis", By.xpath("//*[@class='sidemenuexpanded-burger ng-star-inserted']"), this);
    		BIASideMenu = new Element("Banking Industry Analysis", By.xpath("//*[@class='sidemenuexpanded-bankanalysis-text ng-star-inserted']"), this); 
    		OpIncForSideMenuClick = new Element("Operating Income Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[1]"), this);
    		KeyInsightsText = new Element("Key Insights Text", By.xpath("//*[@class='cia-keyinsights-list-item']"), this);
    		KeyInsightsTitle = new Element("Key Insights Title", By.xpath("//*[@class='cia-keyinsights-title ng-star-inserted']"), this);
    		EBTForSideMenuClick = new Element("EBT Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[2]"), this);
    		TRSSideMenuClick = new Element("TRS", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[1]"), this);
    		LiquidityRatio = new Element("Liquidity Ratio", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[1]"), this);
    		    		
    		//Competitors
    		CompetitorsSideMenu = new Element("Competitors", By.xpath("(//img[@class='sidemenuexpanded-otheroptions-img'])[2]"), this);
    		CompetitorsTitle = new Element("Competitors Title", By.xpath("//*[@class='competitors-title']"), this); 
    		CompanyNameHeader = new Element("Company Name Header", By.xpath("//*[@class='competitors-peers-header-compname competitors-peers-header-compname-banking']"), this);
    		IndustryCountryHeader = new Element("Industry Country Header", By.xpath("//*[@class='competitors-peers-header-industryregion competitors-peers-header-industryregion-banking']"), this);
    		FinancialsHeader = new Element("Financials Header", By.xpath("//*[@class='competitors-peers-header-financials competitors-peers-header-financials-banking']"), this); 
    		OperatingIncomeHeader = new Element("Operating Income Header", By.xpath("//*[@class='competitors-peers-header-rev']"), this); 
    		TotalAssetsHeader = new Element("Total Assets Header", By.xpath("//*[@class='competitors-peers-header-rev ng-star-inserted']"), this); 
    		MarketCapHeader = new Element("Market Cap Header", By.xpath("//*[@class='competitors-peers-header-marcap']"), this); 
    		EditAliasHeader = new Element("Edit Alias Header", By.xpath("//*[@class='competitors-peers-header-alias']"), this);
    		RefineCriteriaText = new Element("Refine Criteria", By.xpath("//*[@class='competitors-criteria ng-star-inserted']"), this);
    		RefineCriteriaIcon = new Element("Refine Criteria Icon", By.xpath("//img[@class='competitors-options-img']"), this);
    		DeleteButton = new Element("Delete Button", By.xpath("//*[@class='competitors-peers-item-delete ng-star-inserted']"), this);
    		PeerItem = new Element("4th Peer Item", By.xpath("(//*[@class='competitors-peers-item ng-star-inserted'])[4]"), this);
    		LastPeerItem = new Element("Last Peer Item", By.xpath("(//*[@class='competitors-peers-item-compname competitors-peers-item-compname-banking'])[8]"), this);
    		AddBank = new Element("Add Bank Placeholder", By.xpath("//*[@class='tool-competitors-wrapper']//*[@placeholder='Add Bank']"), this);//*[@placeholder='Add Bank']
    		SubTitle = new Element("Competitors Subtitle", By.xpath("//*[@class='competitors-subtitle ng-star-inserted']"), this);
    		RefineCriteriaItem1 = new Element("SELECT PRE-SAVED CRITERIA", By.xpath("(//*[@class='features-item-text'])[1]"), this);
    		RefineCriteriaItem2 = new Element("SELECT INDUSTRY", By.xpath("(//*[@class='features-item-text'])[2]"), this);
    		RefineCriteriaItem3 = new Element("SELECT REGION", By.xpath("(//*[@class='features-item-text'])[3]"), this);
    		RefineCriteriaItem4 = new Element("SET OPERATING INCOME AND TOTAL ASSETS", By.xpath("(//*[@class='features-item-text'])[4]"), this);
    		
    		// Financial Page - Author: Mico
            FinancialBestRank = new Element("Financial Best Rank", By.xpath("//*[contains(@class, 'select-note-indicator-scorecards showBestRankBanking')]"), this);
            FinancialBestRankCheckbox = new Element("Financial Best Rank Checkbox ticked", By.xpath("(//input[@type='checkbox'])[1]"), this);
            FinancialBestColumn = new Element("Financial Best Column", By.xpath("//div[@class='scorecards-title-best ng-star-inserted'][contains(.,'BEST')]"), this);
            FinancialRankColumn = new Element("Financial Rank Column", By.xpath("//div[@class='scorecards-title-rank ng-star-inserted'][contains(.,'RANK')]"), this);
            FinancialTimePeriod = new Element("Financial Time Period", By.xpath("//div[@class='ttm ng-star-inserted']"), this);
            FinancialTRSHeader = new Element("Financial TRS Header", By.xpath("//div[@class='scorecards-kpi-title'][contains(.,'TRS DEVELOPMENT')]"), this);
            FinancialAOHeader = new Element("Financial Analyst Outlook Header", By.xpath("//div[@class='scorecards-kpi-title'][contains(.,'ANALYST OUTLOOK')]"), this);
            FinancialIEHeader = new Element("Financial Investor Expectations Header", By.xpath("//div[@class='scorecards-kpi-title'][contains(.,'INVESTOR EXPECTATIONS')]"), this);
            FinancialOIGHeader = new Element("Financial Operating Income Header", By.xpath("//div[@class='scorecards-kpi-title'][contains(.,'OPERATING INCOME GROWTH')]"), this);
            FinancialEPHeader = new Element("Financial Employee Productivity Header", By.xpath("//div[@class='scorecards-kpi-title'][contains(.,'EMPLOYEE PRODUCTIVITY')]"), this);
            FinancialRDHeader = new Element("Financial Roe Decomposition Header", By.xpath("//div[@class='scorecards-kpi-title'][contains(.,'ROE DECOMPOSITION')]"), this);
            FinancialAIHeader = new Element ("Financial Additional Indicators Header", By.xpath("//div[@class='scorecards-kpi-title'][contains(.,'ADDITIONAL INDICATORS')]"), this); 
            FinancialAIAssetGrowth = new Element ("Financial Additional Indicators Asset Growth", By.xpath("//div[@class='scorecards-kpi-metric'][contains(.,'1-year Assets Growth')]"), this);  
            FinancialAIDepositGrowth = new Element ("Financial Additional Indicators Deposit Growth", By.xpath("//div[@class='scorecards-kpi-metric'][contains(.,'1-year Deposits Growth')]"), this); 
            FinancialPBVIcon = new Element ("Financial Hover Icon", By.xpath("(//img[@class='score-container-info-icon ng-star-inserted'])[5]"), this);
            FinancialPBVHover = new Element ("Financial PBV Hover Message", By.xpath("//div[@class='tooltip-text ng-star-inserted']"), this);
            
            // Operational Page - Author: Mico
            OperationalBestRank = new Element ("Operational Best Rank", By.xpath("//label[@class='select-note-indicator-scorecards showBestRankBanking ng-star-inserted']"), this);
            OperationalBestRankCheckbox = new Element ("Operational Best Rank Checkbox", By.xpath("(//input[@type='checkbox'])[1]"), this);
            OperationalBestColumn = new Element ("Operational Best Column", By.xpath("//div[@class='scorecards-title-best ng-star-inserted'][contains(.,'BEST')]"), this);
            OperationalRankColumn = new Element ("Operational Rank Column", By.xpath("//div[@class='scorecards-title-rank ng-star-inserted'][contains(.,'RANK')]"), this);
            OperationalTimePeriod = new Element ("Operational Time Period", By.xpath("//div[@class='ttm ng-star-inserted']"), this);
            OperationalSCRTimePeriod = new Element ("Operational SCR Time Period", By.xpath("//span[@class='scorecards-kpi-title-statutoryTP ng-star-inserted']"), this);
            OperationalBranchAnalyis = new Element ("Operational Branch Analysis", By.xpath("//div[@class='scorecards-kpi-title'][contains(.,'BRANCH ANALYSIS')]"), this);
            OperationalSCRatio = new Element ("Operational Statutory Capital Ratio", By.xpath("(//div[@class='scorecards-kpi-title'])[2]"), this);
    		
    		
    		
		}
	}
}