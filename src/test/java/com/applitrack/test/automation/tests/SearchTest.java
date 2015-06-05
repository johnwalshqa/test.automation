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

public class SearchTest extends BaseActions {
	@DataProvider(name="dataProvider")
	public Object[][] dataProvider(){
		ReadCSV obj = new ReadCSV("data\\sampledata.csv");
		List<HashMap<String, String>> mapList = obj.run();
		return MiscellaneousFunctions.listHashMapToObject(mapList);
	}
	@Test(dataProvider="dataProvider")
	public void searchTest(HashMap<String, String> map){
		LoginPage.enterUserID(log, driver, map.get("username"));
		LoginPage.enterPassword(log, driver, map.get("password"));
		LoginPage.clickLoginButton(log, driver);
		AdminDashboard.assertSearchApplicants(log, driver);
		AdminDashboard.clickSearchTextbox(log, driver);
		String searchBy = map.get("searchby");
		if(searchBy.equals("Applicants")){
			AdminDashboard.clickApplications(log, driver);
		}
		if(searchBy.equals("Employees")){
			AdminDashboard.clickEmployees(log, driver);
		}
		if(searchBy.equals("Vacancies")){
			AdminDashboard.clickVacancies(log, driver);
		}
		if(searchBy.equals("Users")){
			AdminDashboard.clickUsers(log, driver);
		}
		AdminDashboard.enterTextIntoSearchPopover(log, driver, map.get("searchquery"));
		AdminDashboard.clickSearchButton(log, driver);
		AdminDashboard.assertSearchApplicants(log, driver);
		AdminDashboard.clickLogout(log, driver);
		LoginPage.assertLoginButton(log, driver);
	}

}
