package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@When("user enters valid credentials and clicks Login button")
	public void user_enters_valid_credentials_and_clicks_login_button(DataTable dataTable) {
	   
	    List<Map<String,String>> credList = dataTable.asMaps();
	    String email = credList.get(0).get("username");
	    String pwd   = credList.get(0).get("password");
	    accountsPage = loginPage.doEnterCredsAndLogin(email, pwd);
	}

	@Given("user in on Accounts page")
	public void user_in_on_accounts_page() {
		String title = accountsPage.getAccountPageTitle();
		System.out.println("Accounts Page Title is : "+ title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable dataTableExpList) {
		List<String> expAccSectionList = dataTableExpList.asList();
		System.out.println("Expected Accounts Section List : "+expAccSectionList);
	   List<String> actualAccSectionList = accountsPage.getAccountsSectionList();
	   System.out.println("Actual Accounts Section List : "+actualAccSectionList);
	   Assert.assertTrue(expAccSectionList.containsAll(actualAccSectionList));
	    
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer count) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == count);
	}

}
