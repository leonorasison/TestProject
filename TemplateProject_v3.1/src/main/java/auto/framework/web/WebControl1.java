package auto.framework.web;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import auto.framework.WebManager;

public class WebControl1 {
	
	static WebDriver driver = WebManager.getDriver();
	static Actions action = new Actions(driver);
	
	public static void keyboardPress(String Key) {
		
		action.sendKeys("Keys." + Key.toUpperCase()).build().perform();
	}
	
	public static void ClickByCoordinates(int x, int y, String xpath) {
		
		action.moveToElement(driver.findElement(By.xpath(xpath)), 0, 0)
		.moveByOffset(x, y)
		.click().build().perform();
	}
	
	public static void ClickByCoordinates_VerticalChart(int width, int height, int chartNumber, String xpath) {
		
		action.moveToElement(driver.findElement(By.xpath(xpath)), 0, 0)
		.moveByOffset(((width/3)/2)*chartNumber,height/3)
		.click().build().perform();
	}
	
	public static void ClickByCoordinates_HorizontalChart(int width, int height, int compNumber, int chartNumber, String xpath) {
		
		action.moveToElement(driver.findElement(By.xpath(xpath)), 0, 0)
		.moveByOffset(((width/2) + 20),((height/compNumber) - 10)*chartNumber)
		.click().build().perform();
	}
	
	public static void escape() {
		
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public static void altTab() throws AWTException {
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_ALT);
		
	}
	
	public static void backToDesktop() throws AWTException {
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		
	}
	
	
}
