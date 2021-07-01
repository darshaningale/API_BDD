package AutomationTest.BrightTalkTest;

import org.json.JSONArray;
import org.json.JSONObject;
import static AutomationTest.BrightTalkTest.LoadProp.getproperty;

import static io.restassured.RestAssured.*;

import java.util.Iterator;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserPageOne_bk extends BasePage {
	public static String endpoint1 = getproperty("pageName1");
	public static RequestSpecification httpRequest;
	public static Response response;

	public UserPageOne_bk() {
		PageFactory.initElements(driver, this);
	}

	public static Response doGetRequest(String endpoint1) {

		RestAssured.defaultParser = Parser.JSON;
		System.out.println("endpoint 1st page :" + endpoint1);

		return given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().get(endpoint1).then().contentType(ContentType.JSON).statusCode(200).extract().response();
	}
	
	public static void BindInitEndPoint() {
		
	}

	public static void firstPage() {

		driver.get(endpoint1);
		String actualTitle = driver.getTitle();
		String title = "";
		Assert.assertEquals(actualTitle, title, "Title is not matched - endpoint11 URI is not as per the Requirement!");
	}

	public static void parseObject(JSONObject json, String key) {
		System.out.println("---Status:" + json.has(key));
		System.out.println("---value : " + json.get(key));// getting the value of key

	}

	public static void getKye(JSONObject json, String key) {

		boolean exist = json.has(key);
		Iterator<?> kyes;
		String nextKyes;
		
		if (!exist) {
			
			kyes=json.keys();
			while(kyes.hasNext()) {
				nextKyes=(String) kyes.next();
				try {
					
					if(json.keys() instanceof JSONObject) {
						
						if(exist == false)
							getKye(json.getJSONObject(nextKyes), key);
						
						
					}else if(json.get(nextKyes) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKyes);
						for(int i=0;i<jsonarray.length();i++) {
							String jsonArrayString =jsonarray.get(i).toString();
							JSONObject innerJSON = new JSONObject(jsonArrayString);
							
							if(exist == false)
								getKye(innerJSON, key);
						}
						
					}
					
				}catch(Exception e) {
					System.out.println(e.getStackTrace());
				}
			}
			

		} else {
			parseObject(json, key);
		}
	}

	public static void getAllUsers(String key) {

		response = doGetRequest(endpoint1);
		String userDetails = response.getBody().asString();

		System.out.println("Response Body :" + userDetails);

		// convert string to json
		JSONObject jsonObject = new JSONObject(userDetails);
		getKye(jsonObject, key);

		/*
		 * JsonArray jsonArray = new JsonArray(); //Get the response as jsonArray.
		 * jsonArray = given().baseUri(endpoint1) .get().as(JsonArray.class);
		 * 
		 * 
		 * //Loop through the array and get each element. for (int i = 0; i
		 * <jsonArray.size(); i++) { JsonObject jsonObject =
		 * jsonArray.get(i).getAsJsonObject();
		 * System.out.println("Users ID :"+jsonObject.get("id").getAsString());
		 * System.out.println("Users Name :"+jsonObject.get("first_name").getAsString())
		 * ; }
		 */

	}

	public static int getuserID() {
		response = doGetRequest(endpoint1);
		int userID = response.path("id");

		return userID;

	}
	/*
	 * public static Map<Object, Object> getUserDetails() {
	 * 
	 * response = doGetRequest(endpoint11);
	 * 
	 * 
	 * Map<Object, Object> dataList = response.jsonPath().getMap("data"); for(int i
	 * =0; i<=dataList.size();i++) { System.out.println(dataList.get("id")); }
	 * return dataList;
	 * 
	 * }
	 */

	public static int getUserCount() {

		response = doGetRequest(endpoint1);

		// List<String> jsonResponse = response.jsonPath().getList("$");

		int userCount = response.jsonPath().getInt("total");
		// System.out.println(usernames);

		System.out.println("Total Users Count :" + userCount);
		return userCount;

	}

	/**
	 * You can use this class to add page objects and methods.
	 */
}
