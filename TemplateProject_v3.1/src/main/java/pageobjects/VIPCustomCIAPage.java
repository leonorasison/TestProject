package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.web.Element;

public class VIPCustomCIAPage extends PageBase{
	
	public static final Contents contents = new Contents();
	
	public static class Contents extends Element{
		
		//CIA Common
		public final Element BurgerMenu;
		public final Element CIASideMenu;
		public final Element DetailedAnalysisTab;
		public final Element KPISelected;
		//Liquidity Ratios
		public final Element LiquiditySideMenu;
		public final Element RatioTitle;
		public final Element RatioTimePeriod;
		public final Element TrendAnalysisToggle;
		public final Element TrendAnalysisToggleLabel;
		public final Element PercentileHeader;
		public final Element PercentileColumn;
		public final Element TargetCompanyHeader;
		public final Element PeerMedianTitle;
		public final Element RankHeader;
		public final Element TwoYearChangeHeader;
		public final Element GrossBurnRateRunwayKPI;
		public final Element CashShortTermRevKPI;
		public final Element QuickRatioKPI;
		public final Element InventoryRevKPI;
		public final Element AccountsPayableRevKPI;
		public final Element NetReceivablesRevKPI;
		public final Element LiquidityInfoIcon1;
		public final Element LiquidityInfoIcon2;
		public final Element LiquidityInfoIcon3;
		public final Element LiquidityInfoIcon4;
		public final Element LiquidityInfoIcon5;
		public final Element LiquidityInfoIcon6;
		public final Element TooltipText;
		public final Element FirstPeriodHeader;
		public final Element SecondPeriodHeader;
		public final Element ThirdPeriodHeader;
		public final Element FirstPeriodChart;
		public final Element SecondPeriodChart;
		public final Element ThirdPeriodChart;
		public final Element SelectIndicatorDropdown;
		public final Element DefaultDropdownText;
		public final Element GrossBurnRateRunwayIndicator;
		public final Element CashShortTermRevIndicator;
		public final Element QuickRatioIndicator;
		public final Element InventoryRevIndicator;
		public final Element AccountsPayableRevIndicator;
		public final Element NetReceivablesRevIndicator;
		public final Element TrendCircleLegend;
		public final Element TrendTargetCompanyLegend;
		public final Element BrokenLineLegend;
		public final Element PeerMedianLegend;

		//Overview_Yeye
		public final Element SideMenuCIAClick;
		public final Element CIATitlte;
		public final Element CIAOverviewTabTitle;
		public final Element CIADetailedTabTitle;
		public final Element CIAOverviewInsightSummaryTitle;
		public final Element CIAOverviewRelevantNewsTitle;
		public final Element CIAOverviewAccenturePOVTitle;
		public final Element CIAOverviewIndustryLink;
		public final Element CIAOverviewScenarioLink;
		public final Element CIAOverviewInsightSummaryInfoIcon;
		public final Element CIAOverviewInsightSummaryInfoIconHoverMessage;
		public final Element CIAOverviewInsightSummaryEditTextHere;
		public final Element CIAOverviewInsightSummaryEditTextHereHover;
		public final Element CIAOverviewInsightSummaryEditTextHereModal;
		public final Element CIAOverviewInsightSummaryEditTextHereModalHeader;
		public final Element CIAOverviewInsightSummaryEditTextHereModalBoxTitle;
		public final Element CIAOverviewInsightSummaryEditTextHereModalCharacters;
		public final Element CIAOverviewInsightSummaryEditTextHereModalBox;
		public final Element CIAOverviewInsightSummaryEditTextHereApplyButton;
		public final Element CIAOverviewInsightSummaryEditTextHereXButton;
		
		//TRS_Yeye
		public final Element DetailedAnalysisDashboardPane;
		public final Element DashboardPaneCurrentScenario;
		public final Element DashboardPaneTRS;
		public final Element DashboardPaneLiquidityRatio;
		public final Element DashboardPaneSolvencyRatio;
		public final Element DashboardPaneChangeInAnalystOutlook;
		public final Element DashboardPaneRevenue;
		public final Element DashboardPaneEBIT;
		public final Element DashboardPaneEPS;
		public final Element DashboardPaneFCF;
		public final Element DashboardPaneCapex;
		public final Element TRSTitle;
		public final Element TRSInfoIcon;
		public final Element TRSInfoIconMessage;
		public final Element TRSLegendTarget;
		public final Element TRSLegentPeer;
		public final Element TRSLegentPeerMedian;
		public final Element TRSIfPrivate;
		
		//Solvency_Yeye
		public final Element SolvencyRatiosTitle;
		public final Element SolvencyRatiosTimePeriod;
		public final Element SolvencyRatiosToggleButton;
		public final Element SolvencyRatiosToggleTrendAnalysis;
		public final Element SolvencyRatiosPercentiles;
		public final Element SolvencyRatiosPercentiles0;
		public final Element SolvencyRatiosPercentiles25;
		public final Element SolvencyRatiosPercentiles50;
		public final Element SolvencyRatiosPercentiles75;
		public final Element SolvencyRatiosPercentiles100;
		public final Element SolvencyRatiosTargetCompany;
		public final Element SolvencyRatiosPeerMedian;
		public final Element SolvencyRatiosRank;
		public final Element SolvencyRatios2YearChange;
		public final Element SolvencyRatiosAltmanZScore;
		public final Element SolvencyRatiosNetDebtEBITDA;
		public final Element SolvencyRatiosNetDebtFCF;
		public final Element SolvencyRatiosTotalDebtEquity;
		public final Element SolvencyRatiosInterestCoverage;
		public final Element SolvencyRatiosAltmanZScoreInfoIcon;
		public final Element SolvencyRatiosNetDebtEBITDAInfoIcon;
		public final Element SolvencyRatiosNetDebtFCFInfoIcon;
		public final Element SolvencyRatiosTotalDebtEquityInfoIcon;
		public final Element SolvencyRatiosInterestCoverageInfoIcon;
		public final Element SolvencyRatiosKPITooltip;
		public final Element SolvencyRatiosTrendChartYear1;
		public final Element SolvencyRatiosTrendChartYear2;
		public final Element SolvencyRatiosTrendChartYear3;
		public final Element SolvencyRatiosTrendSelectIndicatorTitle;
		public final Element SolvencyRatiosTrendSelectIndicatorButton;
		public final Element SolvencyRatiosTrendSelectIndicatorDefaultKPI;
		public final Element SolvencyRatiosTrendSelectIndicatorAltman;
		public final Element SolvencyRatiosTrendSelectIndicatorNetDebtEBITDA;
		public final Element SolvencyRatiosTrendSelectIndicatorNetDebtFCF;
		public final Element SolvencyRatiosTrendSelectIndicatorTotalDebtEquity;
		public final Element SolvencyRatiosTrendSelectIndicatorInterestCoverage;
		public final Element SolvencyRatiosTrendLegendTarget;
		public final Element SolvencyRatiosTrendLegendPeerMedian;
		
		//Forecasts
		public final Element RevGrowthSideMenuClick;
	    public final Element EBITSideMenuClick;
	    public final Element EPSSideMenuClick;
	    public final Element FCFSideMenuClick;
	    public final Element CapexSideMenuClick;
	    public final Element ForecastDashboardTitle;
	    public final Element SelectTimeFrameHeader;
	    public final Element TimeFrameDropdown;
	    public final Element Timeframe1;
	    public final Element Timeframe2;
	    public final Element Timeframe3;
	    public final Element ForecastTable;
	    public final Element ForecastTargetCircleLegend;
	    public final Element ForecastTargetCompLegend;
	    public final Element ForecastPeerCircleLegend;
	    public final Element ForecastPeerCompLegend;
	    public final Element TimeFrameColumnHeader;
	    public final Element EstimateRevColumnHeader;
	    public final Element NoDataAvailableNote;
	    public final Element ForecastIfPrivate;

	    
		public Contents() {
			super("Container", By.className("mainContainer"));

								
			//CIA Common
			BurgerMenu = new Element("Burger Menu", By.xpath("//*[@class='sidemenuexpanded-companalysis isShow']"), this);
			CIASideMenu = new Element("CIA Side Menu", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[3]"), this);
			DetailedAnalysisTab = new Element("Detailed Analysis tab", By.xpath("(//*[@class='cia-tabs-item'])[2]"), this);
			KPISelected = new Element("SolvencyRatiosSelected", By.xpath("//*[@class='cia-body-sidemenu-kpi ng-star-inserted cia-body-sidemenu-kpi-selected']"), this);
			//Liquidity Ratios
			LiquiditySideMenu = new Element("Liquidity Ratios Side Menu", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[1]"), this);
			RatioTitle = new Element("Ratio Title", By.xpath("//*[@class='cia-ratio-header-title']"), this);
			RatioTimePeriod = new Element("Ratio Timeframe", By.xpath("//*[@class='cia-ratio-header-subtitle']"), this);
			TrendAnalysisToggle = new Element("Trend Analysis Toggle Button", By.xpath("//*[@class='switch-toggle']"), this);
			TrendAnalysisToggleLabel = new Element("Trend Analysis Toggle Label", By.xpath("//*[@class='switch-lbl switch-lbl-on']"), this);
			PercentileHeader = new Element("Percentiles", By.xpath("//*[@class='ratios-title-col-chart-title']"), this);
			PercentileColumn = new Element("Percentiles Percentage", By.xpath("//*[@class='ratios-title-col-chart']"), this);
			TargetCompanyHeader = new Element("Target Company", By.xpath("//*[@class='ratios-title-col-comp']"), this);
			PeerMedianTitle = new Element("Peer Median", By.xpath("//*[@class='ratios-title-col-peer']"), this);
			RankHeader = new Element("Rank", By.xpath("//*[@class='ratios-title-col-rank custom-rank']"), this);
			TwoYearChangeHeader = new Element("2 Year Change", By.xpath("//*[@class='ratios-title-col-yoy custom-ratios-yoy']"), this);
			GrossBurnRateRunwayKPI = new Element("Gross Burn Rate Runway", By.xpath("(//*[@class='ratios-main-col-field-item'])[1]"), this);
			CashShortTermRevKPI = new Element("Cash & Short Term Investments / Revenue", By.xpath("(//*[@class='ratios-main-col-field-item'])[2]"), this);
			QuickRatioKPI = new Element("Quick Ratio", By.xpath("(//*[@class='ratios-main-col-field-item'])[3]"), this);
			InventoryRevKPI = new Element("Inventory / Revenue", By.xpath("(//*[@class='ratios-main-col-field-item'])[4]"), this);
			AccountsPayableRevKPI = new Element("Accounts Payable / Revenue", By.xpath("(//*[@class='ratios-main-col-field-item'])[5]"), this);
			NetReceivablesRevKPI = new Element("Net Receivables / Revenue", By.xpath("(//*[@class='ratios-main-col-field-item'])[6]"), this);  
			LiquidityInfoIcon1 = new Element("Gross Burn Rate Runway InfoIcon", By.xpath("(//*[@class='score-container-info'])[1]"), this); 
			LiquidityInfoIcon2 = new Element("Cash & Short-term Investments / Revenue InfoIcon", By.xpath("(//*[@class='score-container-info'])[2]"), this); 
			LiquidityInfoIcon3 = new Element("Quick Ratio InfoIcon", By.xpath("(//*[@class='score-container-info'])[3]"), this); 
			LiquidityInfoIcon4 = new Element("Inventory / Revenue InfoIcon", By.xpath("(//*[@class='score-container-info'])[4]"), this); 
			LiquidityInfoIcon5 = new Element("Accounts Payable / Revenue InfoIcon", By.xpath("(//*[@class='score-container-info'])[5]"), this); 
			LiquidityInfoIcon6 = new Element("Net Receivables / Revenue InfoIcon", By.xpath("(//*[@class='score-container-info'])[6]"), this); 
			TooltipText  = new Element("Info Icon Tooltip Text", By.xpath("//*[@class='tooltip-text']"), this); 
			FirstPeriodHeader = new Element("Detailed First Period Header", By.xpath("//*[@class='peercomp-chart-barchart-container']//*[@class='peercomp-chart-barchartperyear ng-star-inserted'][1]//*[@class='peercomp-chart-year']"), this);
			SecondPeriodHeader = new Element("Detailed Second Period Header", By.xpath("//*[@class='peercomp-chart-barchart-container']//*[@class='peercomp-chart-barchartperyear ng-star-inserted'][2]//*[@class='peercomp-chart-year']"), this);
			ThirdPeriodHeader = new Element("Detailed Third Period Header", By.xpath("//*[@class='peercomp-chart-barchart-container']//*[@class='peercomp-chart-barchartperyear ng-star-inserted'][3]//*[@class='peercomp-chart-year']"), this);
			FirstPeriodChart = new Element("Detailed First Period Chart", By.xpath("//*[@class='peercomp-chart-barchart-container']//*[@class='peercomp-chart-barchartperyear ng-star-inserted'][1]//*[@class='peercomp-chart-horizontalbar-container']"), this);
			SecondPeriodChart = new Element("Detailed Second Period Chart", By.xpath("//*[@class='peercomp-chart-barchart-container']//*[@class='peercomp-chart-barchartperyear ng-star-inserted'][2]//*[@class='peercomp-chart-horizontalbar-container']"), this);
			ThirdPeriodChart = new Element("Detailed Third Period Chart", By.xpath("//*[@class='peercomp-chart-barchart-container']//*[@class='peercomp-chart-barchartperyear ng-star-inserted'][3]//*[@class='peercomp-chart-horizontalbar-container']"), this);
			SelectIndicatorDropdown = new Element("Select Indicator Dropdown", By.xpath("//*[@id='button-basic']"), this);
			DefaultDropdownText = new Element("Select Indicator Default KPI", By.xpath("//*[@class='btntext']"), this);
			GrossBurnRateRunwayIndicator = new Element("Gross Burn Rate Runway Indicator", By.xpath("//*[@id='dropdown-basic']//*[@role='menuitem'][1]"), this);
			CashShortTermRevIndicator = new Element("Cash & Short Term Investments / Revenue Indicator", By.xpath("//*[@id='dropdown-basic']//*[@role='menuitem'][2]"), this);
			QuickRatioIndicator = new Element("Quick Ratio Indicator", By.xpath("//*[@id='dropdown-basic']//*[@role='menuitem'][3]"), this);
			InventoryRevIndicator = new Element("Inventory / Revenue Indicator", By.xpath("//*[@id='dropdown-basic']//*[@role='menuitem'][4]"), this);
			AccountsPayableRevIndicator = new Element("Accounts Payable / Revenue Indicator", By.xpath("//*[@id='dropdown-basic']//*[@role='menuitem'][5]"), this);
			NetReceivablesRevIndicator = new Element("Net Receivables / Revenue Indicator", By.xpath("//*[@id='dropdown-basic']//*[@role='menuitem'][6]"), this);
			TrendCircleLegend = new Element("Circle Icon Legend", By.xpath("//*[@class='peercomp-legend-circle']"), this);
			TrendTargetCompanyLegend = new Element("Target Company Text Legend", By.xpath("(//*[@class='peercomp-legend-text'])[1]"), this);
			BrokenLineLegend = new Element("Broken Line Legend", By.xpath("//*[@class='peercomp-legend-brokenline']"), this);
			PeerMedianLegend = new Element("Peer Median Text Legend", By.xpath("(//*[@class='peercomp-legend-text'])[2]"), this);
				
			
			//Overview_Yeye
			SideMenuCIAClick = new Element("Financials Side Menu", By.xpath("//*[@src='../../assets/images/cia-icon-b.svg']"), this);
			CIATitlte = new Element("CIATitlte", By.xpath("//*[@class='cia-title']"), this);
			CIAOverviewTabTitle = new Element("CIAOverviewTabTitle", By.xpath("//*[@class='cia-tabs-selected']"), this);
			CIADetailedTabTitle = new Element("CIADetailedTabTitle", By.xpath("(//*[@class='cia-tabs-item'])[2]"), this);
			CIAOverviewInsightSummaryTitle = new Element("CIAOverviewInsightSummaryTitle", By.xpath("//*[@class='col-md-12 insights-title ng-star-inserted']"), this);
			CIAOverviewRelevantNewsTitle = new Element("CIAOverviewRelevantNewsTitle", By.xpath("//*[@class='relevant-news-title']"), this);
			CIAOverviewAccenturePOVTitle = new Element("CIAOverviewAccenturePOVTitle", By.xpath("//*[@class='overview-link-title']"), this);
			CIAOverviewIndustryLink = new Element("CIAOverviewIndustryLink", By.xpath("//*[@class='overview-link-nownext ng-star-inserted']"), this);
			CIAOverviewScenarioLink = new Element("CIAOverviewScenarioLink", By.xpath("//*[@class='overview-link-nownext']"), this);
			CIAOverviewInsightSummaryInfoIcon = new Element("CIAOverviewInsightSummaryInfoIcon", By.xpath("//*[@class='info-icon ng-star-inserted']"), this);
			CIAOverviewInsightSummaryInfoIconHoverMessage = new Element("CIAOverviewInsightSummaryInfoIconHoverMessage", By.xpath("//*[@class='tooltip-text']"), this);
			CIAOverviewInsightSummaryEditTextHere = new Element("CIAOverviewInsightSummaryEditTextHere", By.xpath("(//*[@class='insights-list ng-star-inserted']/span)[2]"), this);
			CIAOverviewInsightSummaryEditTextHereHover = new Element("CIAOverviewInsightSummaryEditTextHereHover", By.xpath("(//*[@class='custom-tagline-tooltip ng-star-inserted'])[2]"), this);
			CIAOverviewInsightSummaryEditTextHereModal = new Element("CIAOverviewInsightSummaryEditTextHereModal", By.xpath("//*[@class='modal-content forInsights']"), this);
			CIAOverviewInsightSummaryEditTextHereModalHeader = new Element("CIAOverviewInsightSummaryEditTextHereModalHeader", By.xpath("(//*[@id='exampleModalLongTitle'])[4]"), this);
			CIAOverviewInsightSummaryEditTextHereModalBoxTitle = new Element("CIAOverviewInsightSummaryEditTextHereModalBoxTitle", By.xpath("(//*[@class='modal-body-content-text-title'])[2]"), this);
			CIAOverviewInsightSummaryEditTextHereModalCharacters = new Element("CIAOverviewInsightSummaryEditTextHereModalCharacters", By.xpath("(//*[@class='modal-body-content-text-count'])[2]"), this);
			CIAOverviewInsightSummaryEditTextHereModalBox = new Element("CIAOverviewInsightSummaryEditTextHereModalBox", By.xpath("(//*[@type='text'])[3]"), this);
			CIAOverviewInsightSummaryEditTextHereApplyButton = new Element("CIAOverviewInsightSummaryEditTextHereApplyButton", By.xpath("(//*[@class='modal-footer-closebtn'])[3]"), this);
			CIAOverviewInsightSummaryEditTextHereXButton = new Element("CIAOverviewInsightSummaryEditTextHereXButton", By.xpath("(//*[@class='close-xbtn'])[4]"), this);

			//TRS_Yeye
			DetailedAnalysisDashboardPane = new Element("DetailedAnalysisDashboardPane", By.xpath("//*[@class='cia-body-sidemenu-cont']"), this);
			DashboardPaneCurrentScenario = new Element("DashboardPaneCurrentScenario", By.xpath("(//*[@class='cia-body-sidemenu-subheader ng-star-inserted'])[1]"), this);
			DashboardPaneTRS = new Element("DashboardPaneTRS", By.xpath("//*[@class='cia-body-sidemenu-kpi cia-body-sidemenu-kpi-selected ng-star-inserted']"), this);
			DashboardPaneLiquidityRatio = new Element("DashboardPaneLiquidityRatio", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[1]"), this);
			DashboardPaneSolvencyRatio = new Element("DashboardPaneSolvencyRatio", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[2]"), this);
			DashboardPaneChangeInAnalystOutlook = new Element("DashboardPaneChangeInAnalystOutlook", By.xpath("(//*[@class='cia-body-sidemenu-subheader ng-star-inserted'])[2]"), this);
			DashboardPaneRevenue = new Element("DashboardPaneRevenue", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[3]"), this);
			DashboardPaneEBIT = new Element("DashboardPaneEBIT", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[4]"), this);
			DashboardPaneEPS = new Element("DashboardPaneEPS", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[5]"), this);
			DashboardPaneFCF = new Element("DashboardPaneFCF", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[6]"), this);
			DashboardPaneCapex = new Element("DashboardPaneCapex", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[7]"), this);
			TRSTitle = new Element("TRSTitle", By.xpath("//*[@class='ciatrs-header-title']"), this);
			TRSInfoIcon = new Element("TRSInfoIcon", By.xpath("//*[@class='info-icon ng-star-inserted']"), this);
			TRSInfoIconMessage = new Element("TRSInfoIconMessage", By.xpath("//*[@class='tooltip-text']"), this);
			TRSLegendTarget = new Element("TRSLegendTarget", By.xpath("//*[@class='ciatrs-main-chart-rhs-legend-text-tc ng-star-inserted']"), this);
			TRSLegentPeer = new Element("TRSLegentPeer", By.xpath("(//*[@class='ciatrs-main-chart-rhs-legend-text'])[1]"), this);
			TRSLegentPeerMedian = new Element("TRSLegentPeerMedian", By.xpath("(//*[@class='ciatrs-main-chart-rhs-legend-text'])[2]"), this);
			TRSIfPrivate = new Element("TRSLegentPeerMedian", By.xpath("//*[@class='ciatrs-message ng-star-inserted']"), this);

			//Solvency_Yeye
			SolvencyRatiosTitle = new Element("SolvencyRatiosTitle", By.xpath("//*[@class='cia-ratio-header-title']"), this);
			SolvencyRatiosTimePeriod = new Element("SolvencyRatiosTimePeriod", By.xpath("//*[@class='cia-ratio-header-subtitle']"), this);
			SolvencyRatiosToggleButton = new Element("SolvencyRatiosToggleButton", By.xpath("//*[@class='switch-toggle']"), this);
			SolvencyRatiosToggleTrendAnalysis = new Element("SolvencyRatiosToggleTrendAnalysis", By.xpath("//*[@class='switch-lbl switch-lbl-on']"), this);
			SolvencyRatiosPercentiles = new Element("SolvencyRatiosPercentiles", By.xpath("//*[@class='ratios-title-col-chart-title']"), this);
			SolvencyRatiosPercentiles0 = new Element("SolvencyRatiosPercentiles0", By.xpath("(//*[@class='ratios-title-col-chart-con'])/div[1]"), this);
			SolvencyRatiosPercentiles25 = new Element("SolvencyRatiosPercentiles25", By.xpath("(//*[@class='ratios-title-col-chart-con'])/div[2]"), this);
			SolvencyRatiosPercentiles50 = new Element("SolvencyRatiosPercentiles50", By.xpath("(//*[@class='ratios-title-col-chart-con'])/div[3]"), this);
			SolvencyRatiosPercentiles75 = new Element("SolvencyRatiosPercentiles75", By.xpath("(//*[@class='ratios-title-col-chart-con'])/div[4]"), this);
			SolvencyRatiosPercentiles100 = new Element("SolvencyRatiosPercentiles100", By.xpath("(//*[@class='ratios-title-col-chart-con'])/div[5]"), this);
			SolvencyRatiosTargetCompany = new Element("SolvencyRatiosTargetCompany", By.xpath("//*[@class='ratios-title-col-comp']"), this);
			SolvencyRatiosPeerMedian = new Element("SolvencyRatiosPeerMedian", By.xpath("//*[@class='ratios-title-col-peer']"), this);
			SolvencyRatiosRank = new Element("SolvencyRatiosRank", By.xpath("//*[@class='ratios-title-col-rank custom-rank']"), this);
			SolvencyRatios2YearChange = new Element("SolvencyRatios2YearChange", By.xpath("//*[@class='ratios-title-col-yoy custom-ratios-yoy']"), this);
			SolvencyRatiosAltmanZScore = new Element("SolvencyRatiosAltmanZScore", By.xpath("(//*[@class='ratios-main-col-field-item'])[1]"), this);
			SolvencyRatiosNetDebtEBITDA = new Element("SolvencyRatiosNetDebtEBITDA", By.xpath("(//*[@class='ratios-main-col-field-item'])[2]"), this);
			SolvencyRatiosNetDebtFCF = new Element("SolvencyRatiosNetDebtFCF", By.xpath("(//*[@class='ratios-main-col-field-item'])[3]"), this);
			SolvencyRatiosTotalDebtEquity = new Element("SolvencyRatiosTotalDebtEquity", By.xpath("(//*[@class='ratios-main-col-field-item'])[4]"), this);
			SolvencyRatiosInterestCoverage = new Element("SolvencyRatiosInterestCoverage", By.xpath("(//*[@class='ratios-main-col-field-item'])[5]"), this);
			SolvencyRatiosAltmanZScoreInfoIcon = new Element("SolvencyRatiosAltmanZScoreInfoIcon", By.xpath("(//*[@class='score-container-info-icon'])[1]"), this);
			SolvencyRatiosNetDebtEBITDAInfoIcon = new Element("SolvencyRatiosNetDebtEBITDAInfoIcon", By.xpath("(//*[@class='score-container-info-icon'])[2]"), this);
			SolvencyRatiosNetDebtFCFInfoIcon = new Element("SolvencyRatiosNetDebtFCFInfoIcon", By.xpath("(//*[@class='score-container-info-icon'])[3]"), this);
			SolvencyRatiosTotalDebtEquityInfoIcon = new Element("SolvencyRatiosTotalDebtEquityInfoIcon", By.xpath("(//*[@class='score-container-info-icon'])[4]"), this);
			SolvencyRatiosInterestCoverageInfoIcon = new Element("SolvencyRatiosInterestCoverageInfoIcon", By.xpath("(//*[@class='score-container-info-icon'])[5]"), this);
			SolvencyRatiosKPITooltip = new Element("SolvencyRatiosKPITooltip", By.xpath("//*[@class='tooltip-text']"), this);
			SolvencyRatiosTrendChartYear1 = new Element("SolvencyRatiosTrendChartYear1", By.xpath("(//*[@class='peercomp-chart-year'])[1]"), this);
			SolvencyRatiosTrendChartYear2 = new Element("SolvencyRatiosTrendChartYear2", By.xpath("(//*[@class='peercomp-chart-year'])[2]"), this);
			SolvencyRatiosTrendChartYear3 = new Element("SolvencyRatiosTrendChartYear3", By.xpath("(//*[@class='peercomp-chart-year'])[3]"), this);
			SolvencyRatiosTrendSelectIndicatorTitle = new Element("SolvencyRatiosTrendSelectIndicatorTitle", By.xpath("//*[@class='d-block text-uppercase ng-star-inserted']"), this);
			SolvencyRatiosTrendSelectIndicatorButton = new Element("SolvencyRatiosTrendSelectIndicatorButton", By.xpath("//*[@id='button-basic']"), this);
			SolvencyRatiosTrendSelectIndicatorDefaultKPI = new Element("SolvencyRatiosTrendSelectIndicatorDefaultKPI", By.xpath("//*[@class='btntext']"), this);
			SolvencyRatiosTrendSelectIndicatorAltman = new Element("SolvencyRatiosTrendSelectIndicatorAltman", By.xpath("//*[@class='dropdown-list dropdown-list-selected ng-star-inserted']"), this);
			SolvencyRatiosTrendSelectIndicatorNetDebtEBITDA = new Element("SolvencyRatiosTrendSelectIndicatorNetDebtEBITDA", By.xpath("(//*[@class='dropdown-list ng-star-inserted'])[1]"), this);
			SolvencyRatiosTrendSelectIndicatorNetDebtFCF = new Element("SolvencyRatiosTrendSelectIndicatorNetDebtFCF", By.xpath("(//*[@class='dropdown-list ng-star-inserted'])[2]"), this);
			SolvencyRatiosTrendSelectIndicatorTotalDebtEquity = new Element("SolvencyRatiosTrendSelectIndicatorTotalDebtEquity", By.xpath("(//*[@class='dropdown-list ng-star-inserted'])[3]"), this);
			SolvencyRatiosTrendSelectIndicatorInterestCoverage = new Element("SolvencyRatiosTrendSelectIndicatorInterestCoverage", By.xpath("(//*[@class='dropdown-list ng-star-inserted'])[4]"), this);
			SolvencyRatiosTrendLegendTarget = new Element("SolvencyRatiosTrendLegendTarget", By.xpath("(//*[@class='peercomp-legend-text'])[1]"), this);
			SolvencyRatiosTrendLegendPeerMedian = new Element("SolvencyRatiosTrendLegendPeerMedian", By.xpath("(//*[@class='peercomp-legend-text'])[2]"), this);

			//Forecasts
			RevGrowthSideMenuClick = new Element("Revenue Growth", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[3]"), this);
	        EBITSideMenuClick = new Element("EBIT Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[4]"), this);
	        EPSSideMenuClick = new Element("EPS Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[5]"), this);
	        FCFSideMenuClick = new Element("FCF Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[6]"), this);
	        CapexSideMenuClick = new Element("Capex Forecast", By.xpath("(//*[@class='cia-body-sidemenu-kpi ng-star-inserted'])[7]"), this);
	        ForecastDashboardTitle = new Element("Forecast Dashboard Title", By.xpath("//*[@class='cia-forecast-header-title ng-star-inserted']"), this);
	        SelectTimeFrameHeader = new Element("Select Timeframe", By.xpath("//*[@class='cia-forecast-label ng-star-inserted']"), this);
	        TimeFrameDropdown = new Element("Timeframe Dropdown", By.xpath("//*[@id='button-basic']"), this);
	        Timeframe1 = new Element("Timeframe1 - YYYYE", By.xpath("(//*[@id='dropdown-basic']//*[@role='menuitem'][1])[1]"), this);
	        Timeframe2 = new Element("Timeframe2 - YYYYE", By.xpath("(//*[@id='dropdown-basic']//*[@role='menuitem'][1])[2]"), this);
	        Timeframe3 = new Element("Timeframe3 - YYYYE", By.xpath("(//*[@id='dropdown-basic']//*[@role='menuitem'][1])[3]"), this);
	        ForecastTable = new Element("Forecast Legends", By.xpath("//*[@class='peerlist']"), this);
	        ForecastTargetCircleLegend = new Element("Target Company Circle Legend", By.xpath("//*[@class='cia-forecast-legend-circle-tc']"), this);
	        ForecastTargetCompLegend = new Element("Target Company", By.xpath("//*[@class='cia-forecast-legend-text-tc']"), this);
	        ForecastPeerCircleLegend = new Element("Peer Company Circle Legend", By.xpath("//*[@class='cia-forecast-legend-circle-pc']"), this);
	        ForecastPeerCompLegend = new Element("Peer", By.xpath("//*[@class='cia-forecast-legend-text']"), this);
	        TimeFrameColumnHeader = new Element("Timeframe Column Header - YYYYE", By.xpath("//*[@class='peerlist-title-col-chart']"), this);
	        EstimateRevColumnHeader = new Element("Estimate Revision from Dec’19", By.xpath("//*[@class='peerlist-title-col-val custom-title']"), this);
	        NoDataAvailableNote = new Element("No Data Available Note", By.xpath("//*[@class='cia-forecast-message ng-star-inserted']"), this);
	        ForecastIfPrivate = new Element("ForecastIfPrivate", By.xpath("//*[@class='cia-forecast-message ng-star-inserted']"), this);
	        
		}
	}
}