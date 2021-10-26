package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.web.Element;
import auto.framework.web.TextBox;

public class VIPNewsPage extends PageBase{
	
	public static final Contents contents = new Contents();
	
	public static class Contents extends Element{
		
		public final Element SideMenuNews;
		public final Element NewsTitle;
		public final Element NewsTypeHeader;
		public final Element NewsType;
		public final Element NewsType1;
		public final Element NewsType1Title;
		public final Element NewsType2;
		public final Element NewsType2Title;
		//public final Element LastNewsEvents1;
		//public final Element LastNewsEvents2;
		public final Element TimePeriodHeader;
		public final Element TimePeriod1;
		public final Element TimePeriod1Title;
		public final Element TimePeriod2;
		public final Element TimePeriod2Title;
		public final Element TimePeriod3;
		public final Element TimePeriod3Title;
		public final Element TimePeriod4;
		public final Element TimePeriod4Title;
		public final Element SelectTimePeriod1;
		public final Element SelectedTimePeriod;
		public final Element SelectedTimePeriod2;
		public final TextBox NewsSearchBox;
		public final Element NoNewsMessage;
		public final Element NewsEvents1;
		public final Element NewsEvents2;
		public final Element NewsEvents3;
		public final Element NewsEvents4;
		public final Element NewsEvents5;
		public final Element NewsEvents6;
		public final Element NewsEvents7;
		public final Element NewsEvents8;
		public final Element NewsEvents9;
		public final Element NewsEvents10;
		public final Element NewsEvents11;
		public final Element NewsEvents12;
		public final Element NewsEvents13;
		public final Element NewsEvents14;
		public final Element NewsEvents15;
		public final Element NewsEvents16;
		public final Element NewsEvents17;
		public final Element NewsEvents18;
		public final Element NewsEvents19;
		public final Element NewsEvents20;
		public final Element NewsDetailsTitle;
		public final Element NewsDetailsBody;
		public final Element GoBackToListButton;
		public final Element SearchedWord;
		public final Element SearchButton;
		
		
		public Contents() {
			super("Container", By.className("mainContainer"));
			
			//SideMenuNews = new Element("Side Menu News", By.xpath("//*[@class='header-sidemenu']//*[@class='sidemenuexpanded isShow']/div[11]"), this);
			SideMenuNews = new Element("Side Menu News", By.xpath("//*[@src='../../assets/images/grid-b.svg' or @src='../../assets/images/grid-p.svg']"), this);
			NewsTitle = new Element("News Header Title", By.xpath("//*[@class='news-title']"), this);
			NewsTypeHeader = new Element("News Type Header", By.xpath("//*[@class='side-menu-title ng-star-inserted']"), this);
			NewsType = new Element("News Type", By.xpath("//*[@class='side-menu-con']"), this);
			NewsType1 = new Element("News Type 1", By.xpath("//*[@class='side-menu-con']/div[1]"), this);
			NewsType1Title = new Element("News Type 1 Title", By.xpath("//*[@class='side-menu-con']/div[1]/div[1]"), this);
			NewsType2 = new Element("News Type 2", By.xpath("//*[@class='side-menu-con']/div[2]"), this);
			NewsType2Title = new Element("News Type 2 Title", By.xpath("//*[@class='side-menu-con']/div[2]/div[1]"), this);			
			//LastNewsEvents1 = new Element("Last News Events", By.xpath("//*[@class='news-details-list ng-star-inserted']/div["+AllNews1Count+"]"), this);			
			//LastNewsEvents2 = new Element("Last News Events", By.xpath("//*[@class='news-details-list ng-star-inserted']/div["+AllNews2Count+"]"), this);
			TimePeriodHeader = new Element("Time Period Header", By.xpath("//*[@class='side-menu-title']"), this);
			TimePeriod1 = new Element("Time Period 1", By.xpath("//*[@class='news-side-menu']/app-news-events-side-menu/div[2]"), this);
			TimePeriod1Title = new Element("Time Period 1 Title", By.xpath("//*[@class='news-side-menu']/app-news-events-side-menu/div[2]/div[1]"), this);
			TimePeriod2 = new Element("Time Period 2", By.xpath("//*[@class='news-side-menu']/app-news-events-side-menu/div[3]"), this);
			TimePeriod2Title = new Element("Time Period 2 Title", By.xpath("//*[@class='news-side-menu']/app-news-events-side-menu/div[3]/div[1]"), this);
			TimePeriod3 = new Element("Time Period 3", By.xpath("//*[@class='news-side-menu']/app-news-events-side-menu/div[4]"), this);
			TimePeriod3Title = new Element("Time Period 3 Title", By.xpath("//*[@class='news-side-menu']/app-news-events-side-menu/div[4]/div[1]"), this);
			TimePeriod4 = new Element("Time Period 4", By.xpath("//*[@class='news-side-menu']/app-news-events-side-menu/div[5]"), this);
			TimePeriod4Title = new Element("Time Period 4 Title", By.xpath("//*[@class='news-side-menu']/app-news-events-side-menu/div[5]/div[1]"), this);
			//SelectedTimePeriod = new Element("Selected Time Period", By.xpath("(//*[@class='side-menu-item onhover side-menu-item-selected ng-star-inserted'])[1]"), this);
			SelectTimePeriod1 = new Element("Time Period 1", By.xpath("//*[@class='news-side-menu']//*[normalize-space(text())='LAST ONE MONTH']"), this);
			SelectedTimePeriod = new Element("Selected Time Period", By.xpath("(//*[@class='side-menu-item onhover ng-star-inserted side-menu-item-selected'])[1]"), this);
			SelectedTimePeriod2 = new Element("Selected Time Period", By.xpath("(//*[@class='side-menu-item onhover side-menu-item-selected ng-star-inserted'])[1]"), this);
			NewsSearchBox = new TextBox("News Search box", By.xpath("//*[@class='news-search-wrapper']//*[@type='text']"), this);
			NoNewsMessage = new Element("No News Message", By.xpath("//*[@class='news-details-message']"), this);
			NewsEvents1 = new Element("News Events 1", By.xpath("(//*[@class='news-details-list-item-title'])[1]"), this);
			NewsEvents2 = new Element("News Events 2", By.xpath("(//*[@class='news-details-list-item-title'])[2]"), this);
			NewsEvents3 = new Element("News Events 3", By.xpath("(//*[@class='news-details-list-item-title'])[3]"), this);
			NewsEvents4 = new Element("News Events 4", By.xpath("(//*[@class='news-details-list-item-title'])[4]"), this);
			NewsEvents5 = new Element("News Events 5", By.xpath("(//*[@class='news-details-list-item-title'])[5]"), this);
			NewsEvents6 = new Element("News Events 6", By.xpath("(//*[@class='news-details-list-item-title'])[6]"), this);
			NewsEvents7 = new Element("News Events 7", By.xpath("(//*[@class='news-details-list-item-title'])[7]"), this);
			NewsEvents8 = new Element("News Events 8", By.xpath("(//*[@class='news-details-list-item-title'])[8]"), this);
			NewsEvents9 = new Element("News Events 9", By.xpath("(//*[@class='news-details-list-item-title'])[9]"), this);
			NewsEvents10 = new Element("News Events 10", By.xpath("(//*[@class='news-details-list-item-title'])[10]"), this);
			NewsEvents11 = new Element("News Events 11", By.xpath("(//*[@class='news-details-list-item-title'])[11]"), this);
			NewsEvents12 = new Element("News Events 12", By.xpath("(//*[@class='news-details-list-item-title'])[12]"), this);
			NewsEvents13 = new Element("News Events 13", By.xpath("(//*[@class='news-details-list-item-title'])[13]"), this);
			NewsEvents14 = new Element("News Events 14", By.xpath("(//*[@class='news-details-list-item-title'])[14]"), this);
			NewsEvents15 = new Element("News Events 15", By.xpath("(//*[@class='news-details-list-item-title'])[15]"), this);
			NewsEvents16 = new Element("News Events 16", By.xpath("(//*[@class='news-details-list-item-title'])[16]"), this);
			NewsEvents17 = new Element("News Events 17", By.xpath("(//*[@class='news-details-list-item-title'])[17]"), this);
			NewsEvents18 = new Element("News Events 18", By.xpath("(//*[@class='news-details-list-item-title'])[18]"), this);
			NewsEvents19 = new Element("News Events 19", By.xpath("(//*[@class='news-details-list-item-title'])[19]"), this);
			NewsEvents20 = new Element("News Events 20", By.xpath("(//*[@class='news-details-list-item-title'])[20]"), this);
			NewsDetailsTitle = new Element("News Details Title", By.xpath("//*[@class='news-details-title']"), this);
			NewsDetailsBody = new Element("News Details Body", By.xpath("//*[@class='news-details-body']"), this);
			GoBackToListButton = new Element("Go Back To List Button", By.xpath("//*[@class='goBacktoList']"), this);
			SearchedWord = new Element("Searched Word", By.xpath("//*[@class='news-details-body']/mark[1]"), this);
			SearchButton = new Element("Search Button", By.xpath("(//*[@class='news-search-img'])[1]"), this);
			
		}
	}
}