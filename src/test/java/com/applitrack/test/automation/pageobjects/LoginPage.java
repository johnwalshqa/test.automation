package com.applitrack.test.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kagrana.base.BasePageObjects;
import com.kagrana.util.Log;

public class LoginPage extends BasePageObjects {
	private static By UserID = By.id("UserID");
	private static By Password = By.id("Password");
	private static By Login = By.id("Login");
	private static By LoginErr = By.id("LoginErr");
	
	public static void enterUserID(Log log,WebDriver driver, String userId){
		enterValueIntoTextBox(log, driver.findElement(UserID), userId, true);
	}
	public static void enterPassword(Log log,WebDriver driver, String passwd){
		enterValueIntoTextBox(log, driver.findElement(Password), passwd, true);
	}
	public static void clickLoginButton(Log log,WebDriver driver){
		clickElement(log, driver, Login);
	}
	public static void assertLoginButton(Log log, WebDriver driver){
		waitForElementVisible(log, driver, Login, 10);
		assertExists(log, driver, Login);
	}
	public static void assertLoginErrorMessage(Log log, WebDriver driver,String message){
		waitForElementVisible(log, driver, LoginErr, 25);
		assertText(log, driver, LoginErr, message, false);
	}
}
