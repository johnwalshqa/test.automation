package com.applitrack.test.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kagrana.base.BasePageObjects;
import com.kagrana.util.Log;

public class AdminDashboard extends BasePageObjects{
	private static By SearchApplicants = By.id("SearchApplicants");
	private static By LIApplicants = By.id("LIApplicants");
	private static By LIEmployees = By.id("LIEmployees");
	private static By LIVacancies = By.id("LIVacancies");
	private static By LIUsers = By.id("LIUsers");
	private static By TextBoxSearchPopover = By.id("TextBoxSearchPopover");
	private static By searchButton = By.cssSelector("#Search > div.form-search > div > button");
	private static By searchTab = By.xpath("//*[@id=\"Tabs\"]/table/tbody/tr/td[7]/a/font");
	private static By aLogout = By.id("aLogout");
	
	public static void assertSearchedTab(Log log, WebDriver driver){
		assertExists(log, driver, searchTab);
	}
	public static void assertSearchApplicants(Log log, WebDriver driver){
		waitForClickable(log, driver, SearchApplicants, 10);
		assertExists(log, driver, SearchApplicants);
	}
	public static void clickSearchTextbox(Log log, WebDriver driver){
		waitForClickable(log, driver, SearchApplicants, 10);
		clickElement(log, driver, SearchApplicants);
	}
	public static void clickApplications(Log log, WebDriver driver){
		waitForClickable(log,driver, driver.findElement(LIApplicants).findElement(By.tagName("a")), 10);
		clickElement(log, driver, driver.findElement(LIApplicants).findElement(By.tagName("a")));
	}
	public static void clickEmployees(Log log, WebDriver driver){
		WebElement element = driver.findElement(LIEmployees).findElement(By.tagName("a"));
		waitForClickable(log,driver, element, 10);
		clickElement(log, driver, element);
	}
	public static void clickVacancies(Log log, WebDriver driver){
		WebElement element = driver.findElement(LIVacancies).findElement(By.tagName("a"));
		waitForClickable(log,driver, element, 10);
		clickElement(log, driver, element);
	}
	public static void clickUsers(Log log, WebDriver driver){
		WebElement element = driver.findElement(LIUsers).findElement(By.tagName("a"));
		waitForClickable(log,driver, element, 10);
		clickElement(log, driver, element);
	}
	public static void enterTextIntoSearchPopover(Log log, WebDriver driver, String searchQuery){
		enterValueIntoTextBox(log, driver, TextBoxSearchPopover, searchQuery, true);
	}
	public static void clickSearchButton(Log log, WebDriver driver){
		clickElement(log, driver, searchButton);
	}
	public static void clickLogout(Log log, WebDriver driver){
		clickElement(log, driver, aLogout);
	}
}
