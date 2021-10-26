package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.web.Element;

public class VIPExecutivesPage extends PageBase{
	
	public static final Contents contents = new Contents();
	
	public static class Contents extends Element{
		
		public final Element SideMenuExecutives;
		public final Element ExecutivesTitle;
		public final Element ExecutivesDropdown;
		public final Element AllExecutivesMenu;
		public final Element TopExecutivesMenu;
		public final Element BoardMembersMenu;
		public final Element FirstExecutiveNameMenu;
		public final Element SecondExecutiveNameMenu;
		public final Element ThirdExecutiveNameMenu;
		public final Element FourthExecutiveNameMenu;
		public final Element ACBChartTitle;
		public final Element ACBPieChart;
		public final Element TSAChartTitle;
		public final Element TSABarChart;
		public final Element ACBChartLegend1;
		public final Element ACBChartLegend2;
		public final Element ACBChartYear;
		public final Element MoreLink;
		public final Element ExecutiveBio;
		
		public Contents() {
			super("Container", By.className("mainContainer"));
			
			//SideMenuExecutives = new Element("Side Menu Executives", By.xpath("//*[@class='header-sidemenu']//*[@class='sidemenuexpanded isShow']/div[8]"), this);
			SideMenuExecutives = new Element("Side Menu Executives", By.xpath("//*[@src='../../assets/images/briefcase-b.svg' or @src='../../assets/images/briefcase-p.svg']"), this);
			ExecutivesTitle = new Element("Executives Header Title", By.xpath("//*[@class='executives-title']"), this);
			ExecutivesDropdown = new Element("Executives Dropdown", By.xpath("//*[@id='button-basic']/*[@class='btntext fromExecutivesText']"), this);
			AllExecutivesMenu = new Element("All Executives Menu", By.xpath("(//*[@role='menu']//*[@role='menuitem'])[1]"), this);
			TopExecutivesMenu = new Element("Top Executives Menu", By.xpath("(//*[@role='menu']//*[@role='menuitem'])[2]"), this);
			BoardMembersMenu = new Element("Board Members Menu", By.xpath("(//*[@role='menu']//*[@role='menuitem'])[3]"), this);
			FirstExecutiveNameMenu = new Element("First Executive Name Menu", By.xpath("//app-executives-item[1]/*[@class='executive']/div[1]"), this);
			SecondExecutiveNameMenu = new Element("Second Executive Name Menu", By.xpath("//app-executives-item[2]/*[@class='executive']/div[1]"), this);
			ThirdExecutiveNameMenu = new Element("Third Executive Name Menu", By.xpath("//app-executives-item[3]/*[@class='executive']/div[1]"), this);
			FourthExecutiveNameMenu = new Element("Fourth Executive Name Menu", By.xpath("//app-executives-item[4]/*[@class='executive']/div[1]"), this);
			ACBChartTitle = new Element("Annual Compensation Breakup Chart Title", By.xpath("//*[@class='chart-container-left ng-star-inserted']/*[@class='chart-title']"), this);
			ACBPieChart = new Element("Annual Compensation Breakup Pie Chart", By.xpath("//*[@class='chart-container-left ng-star-inserted']//*[@ng-reflect-chart-type='doughnut']"), this);
			TSAChartTitle = new Element("Total Stock Awards Chart Title", By.xpath("//*[@class='chart-container-right ng-star-inserted']//*[@class='chart-title']"), this);
			TSABarChart = new Element("Total Stock Awards Bar Chart", By.xpath("//*[@class='chart-container-right ng-star-inserted']//*[@ng-reflect-chart-type='bar']"), this);
			ACBChartLegend1 = new Element("Annual Compensation Breakup Chart Legend 1", By.xpath("//*[@class='chart-container-left ng-star-inserted']//*[@class='chart-legend-text'][1]"), this);
			ACBChartLegend2 = new Element("Annual Compensation Breakup Chart Legend 2", By.xpath("//*[@class='chart-container-left ng-star-inserted']//*[@class='chart-legend-text'][2]"), this);
			ACBChartYear = new Element("Annual Compensation Breakup Chart Year", By.xpath("//*[@class='chart-container-left ng-star-inserted']//*[@class='chart-subtitle']"), this);
			MoreLink = new Element("More Link", By.xpath("//*[@class='executive-detail executive-detail-bio ng-star-inserted']/span"), this);
			ExecutiveBio = new Element("Executive Bio", By.xpath("//*[@class='executive-detail executive-detail-bio ng-star-inserted']"), this);
			
		}
	}
}