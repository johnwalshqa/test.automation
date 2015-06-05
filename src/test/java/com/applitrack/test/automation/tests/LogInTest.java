package com.applitrack.test.automation.tests;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.applitrack.test.automation.pageobjects.AdminDashboard;
import com.applitrack.test.automation.pageobjects.LoginPage;
import com.kagrana.base.BaseActions;
import com.kagrana.util.MiscellaneousFunctions;
import com.kagrana.util.ReadCSV;


public class LogInTest extends BaseActions  {
	@DataProvider(name="dataProvider")
	public Object[][] dataProvider(){
		ReadCSV obj = new ReadCSV("data\\sampledata.csv");
		List<HashMap<String, String>> mapList = obj.run();
		return MiscellaneousFunctions.listHashMapToObject(mapList);
	}
	@Test(dataProvider="dataProvider")
	public void sucessfullLoginTest(HashMap<String, String> map){
		LoginPage.enterUserID(log, driver, map.get("username"));
		LoginPage.enterPassword(log, driver, map.get("password"));
		LoginPage.clickLoginButton(log, driver);
		AdminDashboard.assertSearchApplicants(log, driver);
		AdminDashboard.clickLogout(log, driver);
		LoginPage.assertLoginButton(log, driver);
	}
	@Test(dataProvider="dataProvider")
	public void invalidLoginTest(HashMap<String, String> map){
		LoginPage.enterUserID(log, driver, map.get("username"));
		LoginPage.enterPassword(log, driver, "");
		LoginPage.clickLoginButton(log, driver);
		LoginPage.assertLoginErrorMessage(log, driver, "Login Failed");
	}
}
