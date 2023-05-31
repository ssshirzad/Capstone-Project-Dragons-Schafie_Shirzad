package tek.capstone.dragons.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;

public class RetailSignInSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	// Scenario: Verify user can sign in into Retail Application
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String expectedTitle = "React App";
		String actualTitle = getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		logger.info("Retail website opened and verified");
	}

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.retailSignInPage().signInButton);
		logger.info("Sign In button was clicked");
	}

	@Then("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.retailSignInPage().emailInputBoxSignIn, email);
		sendText(factory.retailSignInPage().passwordInputBoxSignIn, password);
		logger.info(email + ": and password was entered");

	}

	@Then("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.retailSignInPage().loginButton);
		logger.info("login button was clicked");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		waitTillPresence(factory.retailSignInPage().accountOption);
//		Assert.assertTrue(isElementDisplayed(factory.retailSignInPage().accountOption));
		Assert.assertTrue(isElementDisplayed(factory.retailSignInPage().logoutButton));
		Assert.assertTrue(isElementDisplayed(factory.retailSignInPage().orderOption));
		logger.info("Account options verified and user has been logged in");

	}

	// Scenario: Verify user can create an account into Retail Website
	@Then("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.retailSignInPage().newAccountButton);
		logger.info("New account button was clicked");

	}

	@Then("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.retailSignInPage().nameInputBox, row.get("name"));
			sendText(factory.retailSignInPage().emailInputBoxSignUp, row.get("email"));
			sendText(factory.retailSignInPage().passwordInputBoxSignUp, row.get("password"));
			sendText(factory.retailSignInPage().passwordConfirmBox, row.get("confirmPassword"));
			logger.info("Registration info entered");

		}
	}

	@Then("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.retailSignInPage().SignUpButton);
		logger.info("Sign up button was clicked");

	}

	@Then("User profile page should be displayed")
	public void userProfilePageShouldBeDisplayed() {
		waitTillPresence(factory.retailSignInPage().yourAccountProfile);
		Assert.assertTrue(isElementDisplayed(factory.retailSignInPage().yourAccountProfile));
		logger.info("User profile page was displayed");
	}
}
