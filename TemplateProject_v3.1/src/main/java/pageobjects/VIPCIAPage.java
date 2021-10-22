package pageobjects;

import org.openqa.selenium.By;

import auto.framework.TestBase;
import auto.framework.web.Element;


public class VIPCIAPage extends TestBase {
	

	public static final Contents contents = new Contents();
	
	public static class Contents extends Element{
		
		//Common
		public final Element BurgerMenu;
		public final Element SideMenuCIAClick;
		public final Element CIATitle;
		public final Element OverviewTab;
		public final Element CVSTeamLink;
		public final Element SampleLink;
		public final Element DetailedAnalysisTab;
		public final Element DetailedAnalysisNote;
		public final Element RefineCriteriaNote;
		public final Element TRSKeyInsightsTitle;
		public final Element TRSCircle;
		public final Element IsPrivateCompany;
		public final Element InsightsSummaryTitle;
		public final Element InsightsSummaryBody;
		public final Element EBITSideMenuClick;
		public final Element EBITTitle;
		public final Element EBITTimeframe;
		public final Element EBITKeyInsightsTitle;
		public final Element EBITKeyInsightsDot;
		public final Element EPSSideMenuClick;
		public final Element EPSTitle;
		public final Element EPSTimeframe;
		public final Element EPSKeyInsightsTitle;
		public final Element EPSKeyInsightsDot;
		public final Element FCFSideMenuClick;
		public final Element FCFTitle;
		public final Element FCFTimeframe;
		public final Element FCFKeyInsightsTitle;
		public final Element FCFKeyInsightsDot;
		public final Element CapexSideMenuClick;
		public final Element CapexTitle;
		public final Element CapexTimeframe;
		public final Element CapexKeyInsightsTitle;
		public final Element CapexKeyInsightsDot;
		public final Element FCHorizontalBar;
		public final Element FCValueColumn;
		public final Element ForecastLegend;
		public final Element ForecastArrowUp;
		public final Element ForecastArrowDown;
		public final Element ForecastFootnote;
		public final Element RevenueSideMenuClick;
		public final Element RevenueTitle;
		public final Element RevenueTimeframe;
		public final Element RevenueKeyInsightsTitle;
		public final Element RevenueKeyInsightsDot;
		public final Element DisclaimerClose;
		public final Element NoResults;
		public final Element TRSTitle;
		public final Element PeerLegend;
		public final Element KeyInsightsTitle;
		public final Element KeyInsightsBody;
		public final Element LiquiditySideMenuClick;
		public final Element SolvencySideMenuClick;
		public final Element RatioTitle;
		public final Element RatioTimePeriod;
		public final Element NoResultsMessage;
		public final Element KeyInsight;
		public final Element PrivatePeer1;
		public final Element PrivatePeer2;
		public final Element NoTRSComp;
		public final Element NoTRSPeer;
		public final Element PartialTRSComp;
		public final Element PartialTRSPeer;
		public final Element FootNote;
		public final Element PeerMedianTitle;
		public final Element ForecastSource;
		public final Element PercentileBar;
		public final Element OverviewInfoIcon;
	    public final Element OverviewInfoIconText;
	    public final Element TRSInfoIcon;
	    public final Element TRSInfoIconText;
	    public final Element LiquidityInfoIcon1;
	    public final Element LiquidityInfoIcon2;
	    public final Element LiquidityInfoIcon3;
	    public final Element LiquidityInfoIcon4;
	    public final Element LiquidityInfoIcon5;
	    public final Element LiquidityInfoIcon6;
	    public final Element TooltipText;
		public final Element SolvencyInfoIcon1;
		public final Element SolvencyInfoIcon2;
		public final Element SolvencyInfoIcon3;
		public final Element SolvencyInfoIcon4;
		public final Element DisclaimerOkClick;
		public final Element TRSChange;
		public final Element TRSKeyInsightsText;
		public final Element TimeframeDropdown;
		public final Element SideMenuCompetitorClick;
		public final Element UpgradeInProgressClose;
		//New - Arjay
		public final Element SelectDashboardDropdown;
		public final Element DashboardDropdownMenu1;
		public final Element DashboardDropdownMenu2;
		public final Element SelectViewDropdown;
		public final Element ViewDropdownMenu1;
		public final Element ViewDropdownMenu2;
		public final Element ViewDropdownMenu3;
		public final Element ViewDropdownMenu4;
		public final Element ViewDropdownMenu5;
		public final Element ViewDropdownMenu6;
		public final Element ViewDropdownMenu7;
		public final Element ViewDropdownMenu8;
		public final Element ViewDropdownMenu9;
		public final Element SelectPeriodDropdown;
		public final Element PeriodDropdownMenu1;
		public final Element PeriodDropdownMenu2;
		public final Element DetailedAnalysisToggle;
		
		
		
public Contents() {
		super("Container", By.className("mainContainer"));
			
		//CIAOverview
		BurgerMenu = new Element("Burger Menu", By.xpath("//*[@class='sidemenuexpanded-companalysis isShow']"), this);
		SideMenuCIAClick = new Element("CIA Side Menu", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[4]"), this);
		CIATitle = new Element("CIA Title", By.xpath("//*[@class='cia-title']"), this);
		OverviewTab = new Element("Overview tab", By.xpath("(//*[@class='cia-tabs-item'])[1]"), this);
		CVSTeamLink = new Element("CVS Team hyperlink", By.xpath("(//*[@class='overview-hyperlinks-links'])[1]"), this); 
		SampleLink = new Element("Sample Company Analysis hyperlink", By.xpath("(//*[@class='overview-hyperlinks-links'])[2]"), this);
		InsightsSummaryTitle = new Element("INSIGHTS SUMMARY Title", By.xpath("//*[@class='col-md-12 insights-title ng-star-inserted']"), this); 
		InsightsSummaryBody = new Element("INSIGHTS SUMMARY Body", By.xpath("//*[@class='insights-body' or @class='insights-body ng-star-inserted']"), this); 
		TRSTitle = new Element("TRS Title", By.xpath("//*[@class='ciatrs-header-title']"), this); 
		OverviewInfoIcon = new Element("Overview Info Icon", By.xpath("//img[@class='info-icon ng-star-inserted']"), this); 
		OverviewInfoIconText = new Element("Overview Info Text", By.xpath("//*[@class='tooltip-text']"), this); 
		SideMenuCompetitorClick = new Element("Competitor Side Menu", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[2]"), this); 
		
		//Common
		TimeframeDropdown = new Element("Select Timefarame Dropdown", By.xpath("//*[@class='glyphicon btnicon glyphicon-chevron-down']"), this); 
		UpgradeInProgressClose = new Element("Upgrade In Progress", By.xpath("//*[@class='close-xbtn add-cls']"), this);

		//DetailedAnalysisTabTRS
		DetailedAnalysisTab = new Element("Detailed Analysis tab", By.xpath("(//*[@class='cia-tabs-item'])[2]"), this);
		DetailedAnalysisNote = new Element("Detailed Analysis tab Note", By.xpath("//*[@class='cia-subheader-item']"), this); 
		RefineCriteriaNote = new Element("Refine Criteria link", By.xpath("//*[@class='cia-subheader-item-link']"), this);  
		TRSKeyInsightsTitle = new Element("TRS Key Insights", By.xpath("//*[@class='cia-keyinsights-title ng-star-inserted']"), this);  
		TRSCircle = new Element("Key Insights Dot", By.xpath("//*[@class='cia-subheader-item-link']"), this); 
		TRSInfoIcon  = new Element("TRS Info Icon", By.xpath("//img[@class='info-icon ng-star-inserted']"), this); 
		TRSInfoIconText = new Element("TRS Info Text", By.xpath("//*[@class='tooltip-text']"), this); 
		TRSChange = new Element("TRS Change Percentage", By.xpath("(//*[@class='peerlist-main-col-val-upv2'])[2]"), this);
		TRSKeyInsightsText = new Element("TRS Key Insights Text", By.xpath("//*[@class='cia-keyinsights-list-item']"), this);
		
		//IsPrivateCompany
		IsPrivateCompany = new Element("Validate if Private Company", By.xpath("//*[@class='relevant-news-title']"), this);
		DisclaimerClose = new Element("Disclaimer Ok", By.xpath("//*[@class='button-close']"), this);  
		NoResults = new Element("No Results Message", By.xpath("//*[@class='cia-message ng-star-inserted']"), this);
		
		
		//EBITForecast
		EBITSideMenuClick = new Element("EBIT Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[4]"), this);
		EBITTitle = new Element("EBIT Forecast Title", By.xpath("//*[@class='cia-forecast-header-title ng-star-inserted']"), this);
		EBITTimeframe = new Element("EBIT Timeframe Default", By.xpath("//*[@class='btn-group fromCIABtn']"), this);
		EBITKeyInsightsTitle = new Element("Key Insights Title", By.xpath("//*[@class='cia-keyinsights-title ng-star-inserted']"), this);
		EBITKeyInsightsDot = new Element("Key Insights", By.xpath("//*[@class='cia-keyinsights-list ng-star-inserted']"), this);
		
		//EPSForecast
		EPSSideMenuClick = new Element("EPS Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[5]"), this);
		EPSTitle = new Element("EPS Forecast Title", By.xpath("//*[@class='cia-forecast-header-title ng-star-inserted']"), this);
		EPSTimeframe = new Element("EPS Timeframe Default", By.xpath("//*[@class='btntext']"), this);
		EPSKeyInsightsTitle = new Element("Key Insights Title", By.xpath("//*[@class='cia-keyinsights-title ng-star-inserted']"), this);
		EPSKeyInsightsDot = new Element("Key Insights", By.xpath("//*[@class='cia-keyinsights-list ng-star-inserted']"), this);
		
		//FCFForecast
		FCFSideMenuClick = new Element("FCF Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[6]"), this);
		FCFTitle = new Element("FCF Forecast Title", By.xpath("//*[@class='cia-forecast-header-title ng-star-inserted']"), this);
		FCFTimeframe = new Element("FCF Timeframe Default", By.xpath("//*[@class='btntext']"), this);
		FCFKeyInsightsTitle = new Element("Key Insights Title", By.xpath("//*[@class='cia-keyinsights-title ng-star-inserted']"), this);
		FCFKeyInsightsDot = new Element("Key Insights", By.xpath("//*[@class='cia-keyinsights-list ng-star-inserted']"), this);
				
		//CapexForecast
		CapexSideMenuClick = new Element("Capex Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[7]"), this);
		CapexTitle = new Element("Capex Forecast Title", By.xpath("//*[@class='cia-forecast-header-title ng-star-inserted']"), this);
		CapexTimeframe = new Element("Capex Timeframe Default", By.xpath("//*[@class='btntext']"), this);
		CapexKeyInsightsTitle = new Element("Key Insights Title", By.xpath("//*[@class='cia-keyinsights-title ng-star-inserted']"), this);
		CapexKeyInsightsDot = new Element("Key Insights", By.xpath("//*[@class='cia-keyinsights-list ng-star-inserted']"), this);
		
		//RevenueForecast
		RevenueSideMenuClick = new Element("Revenue Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[4]"), this);
		RevenueTitle = new Element("Revenue Forecast Title", By.xpath("//*[@class='cia-forecast-header-title ng-star-inserted']"), this);
		RevenueTimeframe = new Element("Revenue Timeframe Default", By.xpath("//*[@class='btntext']"), this);
		RevenueKeyInsightsTitle = new Element("Key Insights Title", By.xpath("//*[@class='cia-keyinsights-title ng-star-inserted']"), this);
		RevenueKeyInsightsDot = new Element("Key Insights", By.xpath("//*[@class='cia-keyinsights-list ng-star-inserted']"), this);
		
		//ForecastChange
		FCHorizontalBar = new Element("Forecast Bar Chart", By.xpath("//*[@class='peerlist-main-col-chart']"), this);
		FCValueColumn = new Element("Forecast Data Table", By.xpath("(//*[@class='peerlist-main-col-val-upv2'])[1]"), this);
		ForecastLegend = new Element("Forecast Legend", By.xpath("(//*[@class='cia-forecast-legend ng-star-inserted'])[1]"), this);
		ForecastArrowUp = new Element("Forecast Arrow Up", By.xpath("(//*[@class='triangle-up-green ng-star-inserted'])[1]"), this);
		ForecastArrowDown = new Element("Forecast Arrow Down", By.xpath("(//*[@class='triangle-down-red ng-star-inserted'])[1]"), this);
		ForecastFootnote = new Element("Forecast Footnote", By.xpath("(//*[@class='cia-footnote ng-star-inserted'])[1]"), this);
		ForecastSource = new Element("Forecast Source", By.xpath("(//*[@class='cia-footnote ng-star-inserted'])[2]"), this);
						
		//ForecastDashboardChecks
		PeerLegend = new Element("Detailed Analysis Peer Legend", By.xpath("(//*[@class='cia-forecast-legend ng-star-inserted'])[3]"), this); 
		KeyInsightsTitle = new Element("Detailed Analysis KeyInsights Title", By.xpath("//*[@class='cia-keyinsights-title ng-star-inserted']"), this); 
		KeyInsightsBody = new Element("Detailed Analysis KeyInsights Body", By.xpath("//*[@class='cia-keyinsights-list ng-star-inserted']"), this); 
		
		//LiquidityandSolvency
		LiquiditySideMenuClick = new Element("Liquidity Ratio", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[2]"), this);
		SolvencySideMenuClick = new Element("Solvency Ratio", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[2]"), this);
		RatioTitle = new Element("Ratio Title", By.xpath("//*[@class='cia-ratio-header-title']"), this); 
		RatioTimePeriod = new Element("Ratio Timeframe", By.xpath("//*[@class='cia-ratio-header-subtitle']"), this);
		PeerMedianTitle = new Element("Peer Median", By.xpath("//*[@class='ratios-title-col-peer']"), this);  
		PercentileBar = new Element("Percentile Bar", By.xpath("//*[@class='ratios-main-col-chart']"), this); 
		LiquidityInfoIcon1 = new Element("Gross Burn Rate Runway InfoIcon", By.xpath("(//*[@class='score-container-info'])[1]"), this); 
		LiquidityInfoIcon2 = new Element("Cash & Short-term Investments / Revenue InfoIcon", By.xpath("(//*[@class='score-container-info'])[2]"), this); 
		LiquidityInfoIcon3 = new Element("Quick Ratio InfoIcon", By.xpath("(//*[@class='score-container-info'])[3]"), this); 
		LiquidityInfoIcon4 = new Element("Inventory / Revenue InfoIcon", By.xpath("(//*[@class='score-container-info'])[4]"), this); 
		LiquidityInfoIcon5 = new Element("Accounts Payable / Revenue InfoIcon", By.xpath("(//*[@class='score-container-info'])[5]"), this); 
		LiquidityInfoIcon6 = new Element("Net Receivables / Revenue InfoIcon", By.xpath("(//*[@class='score-container-info'])[6]"), this); 
		TooltipText  = new Element("Info Icon Tooltip Text", By.xpath("//*[@class='tooltip-text']"), this); 
		SolvencyInfoIcon1 = new Element("Altman Z score InfoIcon", By.xpath("(//*[@class='score-container-info'])[1]"), this); 
		SolvencyInfoIcon2 = new Element("Net Debt / EBITDA InfoIcon", By.xpath("(//*[@class='score-container-info'])[2]"), this); 
		SolvencyInfoIcon3 = new Element("Total Debt / Equity InfoIcon", By.xpath("(//*[@class='score-container-info'])[3]"), this); 
		SolvencyInfoIcon4 = new Element("Interest Coverage InfoIcon", By.xpath("(//*[@class='score-container-info'])[4]"), this); 
		
		//DashboardChecks - TRS
		NoResultsMessage = new Element("No Results Message", By.xpath("//*[@class='cia-message ng-star-inserted']"), this);
		KeyInsight = new Element("Key Insight", By.xpath("//*[@class='cia-keyinsights-list-item']"), this);
		PrivatePeer1 = new Element("Private Peer 1", By.xpath("//*[@class='peerlist-main-cont']//*[normalize-space(text())='ARRIS International Limited']"), this);
		PrivatePeer2 = new Element("Private Peer 2", By.xpath("//*[@class='peerlist-main-cont']//*[normalize-space(text())='Brocade Communications Systems LLC']"), this);
		FootNote = new Element("FootNote", By.xpath("(//*[@class='cia-footnote ng-star-inserted'])[1]"), this);
		NoTRSComp = new Element("Company without TRS", By.xpath("//*[@class='peerlist-main-cont']//*[normalize-space(text())='Herti AD']"), this);
		NoTRSPeer = new Element("Peer without TRS", By.xpath("//*[@class='peerlist-main-cont']//*[normalize-space(text())='Herti AD']"), this);
		PartialTRSComp = new Element("Company with Partial TRS", By.xpath("//*[@class='peerlist-main-cont']//*[normalize-space(text())='Costar Technologies, Inc.']"), this);
		PartialTRSPeer = new Element("Peer with Partial TRS", By.xpath("//*[@class='peerlist-main-cont']//*[normalize-space(text())='Costar Technologies, Inc.']"), this);
		DisclaimerOkClick = new Element("Disclaimer Ok", By.xpath("//*[@class='button-close']"), this);		
		
		//New - Arjay
		SelectDashboardDropdown = new Element("Select Dashboard Dropdown", By.xpath("(//*[@id='dropdownBasic1'])[1]"), this);
		DashboardDropdownMenu1 = new Element("Dashboard Dropdown Menu 1", By.xpath("//*[@class='menu-container']/div[@class='ng-star-inserted'][1]"), this);
		DashboardDropdownMenu2 = new Element("Dashboard Dropdown Menu 2", By.xpath("//*[@class='menu-container']/div[@class='ng-star-inserted'][2]"), this);
		SelectViewDropdown = new Element("Select View Dropdown", By.xpath("(//*[@id='dropdownBasic1'])[2]"), this);
		ViewDropdownMenu1 = new Element("View Dropdown Menu 1", By.xpath("(//*[@class='menu-container'])[2]/div[@class='ng-star-inserted'][1]/button"), this);
		ViewDropdownMenu2 = new Element("View Dropdown Menu 2", By.xpath("(//*[@class='menu-container'])[2]/div[@class='ng-star-inserted'][2]/button"), this);
		ViewDropdownMenu3 = new Element("View Dropdown Menu 3", By.xpath("(//*[@class='menu-container'])[2]/div[@class='ng-star-inserted'][3]/button"), this);
		ViewDropdownMenu4 = new Element("View Dropdown Menu 4", By.xpath("(//*[@class='menu-container'])[2]/div[@class='ng-star-inserted'][4]/button"), this);
		ViewDropdownMenu5 = new Element("View Dropdown Menu 5", By.xpath("(//*[@class='menu-container'])[2]/div[@class='ng-star-inserted'][5]/button"), this);
		ViewDropdownMenu6 = new Element("View Dropdown Menu 6", By.xpath("(//*[@class='menu-container'])[2]/div[@class='ng-star-inserted'][6]/button"), this);
		ViewDropdownMenu7 = new Element("View Dropdown Menu 7", By.xpath("(//*[@class='menu-container'])[2]/div[@class='ng-star-inserted'][7]/button"), this);
		ViewDropdownMenu8 = new Element("View Dropdown Menu 8", By.xpath("(//*[@class='menu-container'])[2]/div[@class='ng-star-inserted'][8]/button"), this);
		ViewDropdownMenu9 = new Element("View Dropdown Menu 9", By.xpath("(//*[@class='menu-container'])[2]/div[@class='ng-star-inserted'][9]/button"), this);
		SelectPeriodDropdown = new Element("Select Period Dropdown", By.xpath("(//*[@id='dropdownBasic1'])[3]"), this);
		PeriodDropdownMenu1 = new Element("Period Dropdown Menu 1", By.xpath("(//*[@class='menu-container'])[3]/div[@class='ng-star-inserted'][1]/button"), this);
		PeriodDropdownMenu2 = new Element("Period Dropdown Menu 2", By.xpath("(//*[@class='menu-container'])[3]/div[@class='ng-star-inserted'][2]/button"), this);
		
		DetailedAnalysisToggle = new Element("Detailed Analysis Toggle Button", By.xpath("//*[@class='switch-toggle']"), this);
		
		
	}
  }
}
