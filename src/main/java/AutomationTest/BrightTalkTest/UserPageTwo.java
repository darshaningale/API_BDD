package AutomationTest.BrightTalkTest;


import static AutomationTest.BrightTalkTest.LoadProp.getproperty;

import static io.restassured.RestAssured.*;


import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import AutomationTest.BrightTalkTestPOJO.DataPojo2;

import AutomationTest.BrightTalkTestPOJO.UserListPojo2;
import io.restassured.RestAssured;


public class UserPageTwo extends BasePage {
	public static String endpoint2 = getproperty("pageName2");
	
	
	public static UserListPojo2 userListPojo2;
	

	public UserPageTwo() {
		PageFactory.initElements(driver, this);
	}

	
	public static UserListPojo2 doGetRequest2() {
		RestAssured.baseURI = endpoint2;
		 userListPojo2 = RestAssured.given().when().get().as(UserListPojo2.class);
		System.out.println(userListPojo2.toString());

		return userListPojo2;

	}

	public static void firstPage() {

		driver.get(endpoint2);
		String actualTitle = driver.getTitle();
		String title = "";
		Assert.assertEquals(actualTitle, title, "Title is not matched - endpoint11 URI is not as per the Requirement!");
	}

	
	public static List<DataPojo2> getAllUsers2() {

		userListPojo2 = doGetRequest2();
		
		List<DataPojo2> dataList2 = userListPojo2.getData2();
		for (int i = 0; i < dataList2.size(); i++) {
			System.out.println("User Name : "+dataList2.get(i).getFirst_name2());
		}
		return dataList2;

	}

	public static int getUsersID2() {
		userListPojo2 = doGetRequest2();
		List<DataPojo2> usersIDList2 = userListPojo2.getData2();
		int usersIdCOunt2 = usersIDList2.size();
		for (int i = 0; i < usersIDList2.size(); i++) {
			System.out.println("User ID : "+ usersIDList2.get(i).getId2());
		}
		return usersIdCOunt2;
	}

	public static int getUserCount2() {

		userListPojo2 = doGetRequest2();
		List<DataPojo2> dataList2 = userListPojo2.getData2();
		
		int UsersCount2 = dataList2.size();
		return UsersCount2;
		

	}

	/**
	 * You can use this class to add page objects and methods.
	 */
}
