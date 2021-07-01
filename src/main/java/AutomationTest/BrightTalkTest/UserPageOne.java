package AutomationTest.BrightTalkTest;

import org.json.JSONArray;
import org.json.JSONObject;
import static AutomationTest.BrightTalkTest.LoadProp.getproperty;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AutomationTest.BrightTalkTestPOJO.DataPojo;

import AutomationTest.BrightTalkTestPOJO.UserListPojo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UserPageOne extends BasePage {
	public static String endpoint1 = getproperty("pageName1");
	public static String endpointLogin = getproperty("pageName3");
	public static RequestSpecification httpRequest;
	public static UserListPojo userListPojo;
	public static Response response;

	public UserPageOne() {
		PageFactory.initElements(driver, this);
	}

	public static String parseObject(JSONObject json, String key) {
		boolean Status = json.has(key);
		String value = json.get(key).toString();
		System.out.println("---Status:" + Status);
		System.out.println("---value : " + value);// getting the value of key
		return value;

	}

	public static String getKye(JSONObject json, String key) {

		boolean exist = json.has(key);
		Iterator<?> kyes;
		String nextKyes;
		String getValue = null;

		if (!exist) {

			kyes = json.keys();
			while (kyes.hasNext()) {
				nextKyes = (String) kyes.next();
				try {

					if (json.keys() instanceof JSONObject) {

						if (exist == false)
							getKye(json.getJSONObject(nextKyes), key);

					} else if (json.get(nextKyes) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKyes);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonArrayString = jsonarray.get(i).toString();
							JSONObject innerJSON = new JSONObject(jsonArrayString);

							if (exist == false)
								getKye(innerJSON, key);
						}

					}

				} catch (Exception e) {

				}
			}

		} else {
			getValue = parseObject(json, key);
		}
		return getValue;
	}

	public static UserListPojo doGetRequest() {
		RestAssured.baseURI = endpoint1;

		userListPojo = RestAssured.given().when().get().as(UserListPojo.class);
		// System.out.println(userListPojo.toString());

		return userListPojo;

	}

	public static void firstPage() {

		driver.get(endpoint1);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String title = "";
		Assert.assertEquals(actualTitle, title,
				"sc1 (I get the default list of users for on 1st page) Title is not matched !!");
	}

	public static List<DataPojo> getAllUsers() {

		userListPojo = doGetRequest();

		List<DataPojo> dataList = userListPojo.getData();
		for (int i = 0; i < dataList.size(); i++) {
			System.out.println("User Name : " + dataList.get(i).getFirst_name());
		}
		return dataList;

	}

	public static String getUsersID() {
		userListPojo = doGetRequest();
		List<DataPojo> usersIDList = userListPojo.getData();
		String usersIDCount = userListPojo.getTotal();
		for (int i = 0; i < usersIDList.size(); i++) {

			System.out.println("User ID : " + usersIDList.get(i).getId());
		}

		return usersIDCount;
	}

	public static String getUserCount() {

		userListPojo = doGetRequest();
		String usersCount = userListPojo.getTotal();

		System.out.println(usersCount);
		return usersCount;

	}

	public static String findUser(String param) {
		// userListPojo = doGetRequest();
		RestAssured.baseURI = endpoint1;

		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, param);
		String FindUser = response.getBody().asString();
		String key = "id";
		// get userID from json array and make actual and expected variables to check
		// assertion
		// convert string to json
		JSONObject jsonObject = new JSONObject(FindUser);
		String actualValue = getKye(jsonObject, key);
		System.out.println(actualValue);
		System.out.println("ID 3 user Details :" + FindUser);
		return actualValue;

	}

	public static void SearchUser(String firstname, String email) {
		String actualFirstName = null, actualEmail = null;
		userListPojo = doGetRequest();
		List<DataPojo> usersList = userListPojo.getData();
		System.out.println(usersList.toString());

		actualFirstName = usersList.get(0).getFirst_name();
		actualEmail = usersList.get(0).getEmail();

		System.out.println("SearchUser Method : " + actualFirstName + " | " + actualEmail);

		Assert.assertEquals(actualFirstName, firstname,
				"sc2 (should see following user data) First Name is not match !");
		Assert.assertEquals(actualEmail, email, "sc2 (should see following user data) Email is not match !");

	}

	public static int getResponseStatusCode(String status, String param) {

		RestAssured.baseURI = endpoint1;

		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, param);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 404, status);
		return statusCode;
	}

	public static void createUser(String name, String job) {
		RestAssured.baseURI = endpoint1;

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", name);
		requestParams.put("job", job);

		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParams.toString());
		System.out.println("input POST : " + requestParams.toString());

		// Post the request and check the response
		response = httpRequest.post();

		String checkResponseCreateUser = response.getBody().asString();
		System.out.println("Response for CREATE user :" + checkResponseCreateUser);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
	

	}

	public static void sucessfullLogin(String email, String password) {
		RestAssured.baseURI = endpointLogin;

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email);
		requestParams.put("password", password);

		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParams.toString());
		System.out.println("input POST : " + requestParams.toString());

		// Post the request and check the response
		response = httpRequest.post();

		String checkResponseCreateUser = response.getBody().asString();
		System.out.println("Response for login user :" + checkResponseCreateUser);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	public static void unsucessfullLogin(String email, String password) {
		RestAssured.baseURI = endpointLogin;

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email);
		requestParams.put("password", password);

		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParams.toString());
		System.out.println("input POST : " + requestParams.toString());

		// Post the request and check the response
		response = httpRequest.post();

		String checkResponseCreateUser = response.getBody().asString();
		System.out.println("Response for login user :" + checkResponseCreateUser);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 400);
		
	}

	public static List<DataPojo> getDelyAllUsers() {
		String param = "?delay=3";
		// userListPojo = doGetRequest();
		RestAssured.baseURI = endpoint1;

		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, param);

		userListPojo = response.getBody().as(UserListPojo.class);

		List<DataPojo> dataList = userListPojo.getData();
		for (int i = 0; i < dataList.size(); i++) {
			System.out.println("User Name : " + dataList.get(i).getFirst_name());
		}
		return dataList;

	}

	/**
	 * You can use this class to add page objects and methods.
	 */
}
