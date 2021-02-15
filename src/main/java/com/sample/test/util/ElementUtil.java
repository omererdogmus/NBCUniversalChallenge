package com.sample.test.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	public static void clickOn(WebElement element) {
		element.click();
	}

	public static void sendKeys(WebElement element, CharSequence... text) {
		element.sendKeys(text);
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	public static void selectByValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}
	
	public static String getText(WebElement element) {
		return element.getText();
	}

}
