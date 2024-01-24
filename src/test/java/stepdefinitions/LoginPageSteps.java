package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String titleHomePage;
	private static String titleAccountPage;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on home page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	}

	@When("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
		titleHomePage = loginPage.getHomePageTitle();
		System.out.println("Home Page title is :" + titleHomePage);
	}

	@Then("user gets the title of the account page")
	public void user_gets_the_title_of_the_account_page() {
		titleAccountPage = loginPage.getAccountPageTitle();
		System.out.println("Account Page title is :" + titleAccountPage);
	}

	@Then("home page title should be {string}")
	public void home_page_title_should_be(String expectedHomePageTitle) {
		Assert.assertTrue(titleHomePage.contains(expectedHomePageTitle));
	}

	@Then("account page title should be {string}")
	public void account_page_title_should_be(String expectedAccountPageTitle) {
		Assert.assertTrue(titleAccountPage.contains(expectedAccountPageTitle));
	}

	@Then("user clicks My Account")
	public void user_clicks_my_account() {
		loginPage.clickOnMyAccountInHomePage();
	}

	@Then("user clicks Login")
	public void user_clicks_login() {
		loginPage.clickOnLoginInHomePage();
	}

	@Then("Forgotten Password link should be displayed")
	public void forgotten_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgottenPasswordLinkExists());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
		loginPage.enterEmail(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginButton();
	}

}
