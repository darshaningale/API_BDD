package AutomationTest.BrightTalkTest;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static AutomationTest.BrightTalkTest.HomePage.homePage;
import static AutomationTest.BrightTalkTest.LoadProp.getproperty;
import static AutomationTest.BrightTalkTest.UserPageOne.*;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import AutomationTest.BrightTalkTestPOJO.DataPojo;


public class StepDefinition {
	
	SoftAssert softAssert = new SoftAssert();

	@Given("^I am on the home page$")
	public void iAmOnTheHomePage() throws InterruptedException {
		homePage();
	}
	// sc1

	@Given("^I get the default list of users for on 1st page$")
	public void i_get_the_default_list_of_users_for_on_1st_page() throws Throwable {
		firstPage();
	}

	@When("^I get the list of all users$")
	public void i_get_the_list_of_all_users() throws Throwable {
		getAllUsers();
		//UserPageTwo.getAllUsers2();

		System.out.println("Users are printed !");

	}

	@Then("^I should see total users count equals to number of user ids$")
	public void i_should_see_total_users_count_equals_to_number_of_user_ids() throws Throwable {
		String usersCount = getUserCount();
		String usersIDCOunt = getUsersID();
		
		//Assert.assertEquals(usersCount,12,"UserCount is not matched !");
		//Assert.assertEquals(usersIDCOunt,12,"usersIDs is not matched !");
		System.out.println("User Count :" + usersCount);
		System.out.println("Users IDs  :" + usersIDCOunt);
	}

	// sc2
	@Given("^I make a search for user 3$")
	public void i_make_a_search_for_user_3() throws Throwable {
		String param ="?id=3";
		String expectedValue = "3";
		String actualValue =findUser(param);
		 softAssert.assertEquals(actualValue, expectedValue,"sc2 (I make a search for user 3) is not match !!");
	}
	 @Then("^I should see following user data$")
	    public void i_should_see_following_user_data_and(DataTable table) throws Throwable {
		String firstname = null;
		String email = null;
		//Initialize data table 
	      List<List<String>> data = table.raw();
	      firstname = data.get(1).get(1);
	      email = data.get(2).get(1);
		
	 	System.out.println("Test firstname and email for sc2"+firstname+email);
		SearchUser(firstname,email);
		
	}

	// sc3
	@Given("^I make a search for user 55$")
	public void i_make_a_search_for_user_55() throws Throwable {
		String status = "Error 404";
		String id ="?id=55";
		getResponseStatusCode(status,id);
	}

	@Then("^I receive error code (.+) in response$")
	public void i_receive_error_code_in_response(String status) throws Throwable {
		status = "Error 404";
		String id ="?id=55";
		int statusCode = getResponseStatusCode(status,id);
		System.out.println("User id=55 checking :"+statusCode);
	}

	// sc4
	@Given("^I create user with following (.+) (.+)$")
	public void i_create_user_with_following(String name, String job) throws Throwable {
		createUser(name,job);
	}

	@Then("^response should contain folowing data$")
	public void response_should_contain_folowing_data(DataTable table) throws Throwable {
//		String name = null;
//		String email = null;
//		//Initialize data table name, job, id, createdAt
//	      List<List<String>> data = table.raw();
//	      name = data.get(1).get(1);
//	      email = data.get(2).get(1);
	}

	// sc5
	@Given("^I login succesfully with following data$") 
	public void i_login_succesfully_with_following_data(DataTable table) throws Throwable { 
		//Initialize data table name, job, id, createdAt
	      List<List<String>> data = table.raw();
	     String email = data.get(1).get(0);
	     String password = data.get(1).get(1);
	     
	     sucessfullLogin(email, password);
		
	}

	// sc6
	@Given("^I login unsuccesfully with following data$")
	public void i_login_unsuccesfully_with_following_data(DataTable table) throws Throwable {
		//Initialize data table name, job, id, createdAt
	      List<List<String>> data = table.raw();
	     String email = data.get(1).get(0);
	     String password = data.get(1).get(1);
	     
	     unsucessfullLogin(email, password);
	}

	// sc7
	@Given("^I wait for user list to load$")
	public void i_wait_for_user_list_to_load() throws Throwable {
		getDelyAllUsers();
	}

	@Then("^I should see that every user has a unique id$")
	public void i_should_see_that_every_user_has_a_unique_id() throws Throwable {
		getUsersID();
	}

	/*
	 * @Given("^I get the default list of users for on (\\d+)st page$") public void
	 * i_get_the_default_list_of_users_for_on_st_page(int arg1) throws Throwable {
	 * // Write code here that turns the phrase above into concrete actions
	 * samplePage();
	 * 
	 * 
	 * }
	 * 
	 * @When("^I get the list of all users$") public void
	 * i_get_the_list_of_all_users() throws Throwable { // Write code here that
	 * turns the phrase above into concrete actions throw new PendingException(); }
	 * 
	 * @Then("^I should see total users count equals to number of user ids$") public
	 * void i_should_see_total_users_count_equals_to_number_of_user_ids() throws
	 * Throwable { // Write code here that turns the phrase above into concrete
	 * actions throw new PendingException(); }
	 * 
	 * @Given("^I make a search for user (\\d+)$") public void
	 * i_make_a_search_for_user(int arg1) throws Throwable { // Write code here that
	 * turns the phrase above into concrete actions throw new PendingException(); }
	 * 
	 * @Then("^I should see following user data$") public void
	 * i_should_see_following_user_data(DataTable arg1) throws Throwable { // Write
	 * code here that turns the phrase above into concrete actions // For automatic
	 * transformation, change DataTable to one of // List<YourType>, List<List<E>>,
	 * List<Map<K,V>> or Map<K,V>. // E,K,V must be a scalar (String, Integer, Date,
	 * enum etc) throw new PendingException(); }
	 * 
	 * @Then("^I receive error code <enter value> in response$") public void
	 * i_receive_error_code_enter_value_in_response() throws Throwable { // Write
	 * code here that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 * 
	 * @Given("^I create user with following Peter Manager$") public void
	 * i_create_user_with_following_Peter_Manager() throws Throwable { // Write code
	 * here that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 * 
	 * @Then("^response should contain folowing data$") public void
	 * response_should_contain_folowing_data(DataTable arg1) throws Throwable { //
	 * Write code here that turns the phrase above into concrete actions // For
	 * automatic transformation, change DataTable to one of // List<YourType>,
	 * List<List<E>>, List<Map<K,V>> or Map<K,V>. // E,K,V must be a scalar (String,
	 * Integer, Date, enum etc) throw new PendingException(); }
	 * 
	 * @Given("^I create user with following Liza Sales$") public void
	 * i_create_user_with_following_Liza_Sales() throws Throwable { // Write code
	 * here that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 * 
	 * @Given("^I login succesfully with following data$") public void
	 * i_login_succesfully_with_following_data(DataTable arg1) throws Throwable { //
	 * Write code here that turns the phrase above into concrete actions // For
	 * automatic transformation, change DataTable to one of // List<YourType>,
	 * List<List<E>>, List<Map<K,V>> or Map<K,V>. // E,K,V must be a scalar (String,
	 * Integer, Date, enum etc) throw new PendingException(); }
	 * 
	 * @Given("^I login unsuccesfully with following data$") public void
	 * i_login_unsuccesfully_with_following_data(DataTable arg1) throws Throwable {
	 * // Write code here that turns the phrase above into concrete actions // For
	 * automatic transformation, change DataTable to one of // List<YourType>,
	 * List<List<E>>, List<Map<K,V>> or Map<K,V>. // E,K,V must be a scalar (String,
	 * Integer, Date, enum etc) throw new PendingException(); }
	 * 
	 * @Given("^I wait for user list to load$") public void
	 * i_wait_for_user_list_to_load() throws Throwable { // Write code here that
	 * turns the phrase above into concrete actions throw new PendingException(); }
	 * 
	 * @Then("^I should see that every user has a unique id$") public void
	 * i_should_see_that_every_user_has_a_unique_id() throws Throwable { // Write
	 * code here that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 */
}
