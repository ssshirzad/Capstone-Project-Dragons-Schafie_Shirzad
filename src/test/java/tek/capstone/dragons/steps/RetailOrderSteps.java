package tek.capstone.dragons.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {
	POMFactory factory = new POMFactory();
	private String orderPlacedConfirmation;

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String string) {
		selectByVisibleText(factory.retailOrderPage().allDeptDropdown, string);
		logger.info(string + " : was entered to be searched");
	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String string) {
		sendText(factory.retailOrderPage().searchTextBox, string);
		logger.info(string + " : was entered to be searched");
	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.retailOrderPage().searchButton);
		logger.info("Search icon was clicked");
	}

	@When("User click on searched item")
	public void userClickOnSearchedItem() {
		click(factory.retailOrderPage().clickOnSearchedItem);
		logger.info("Searched item was clicked");
	}

	@When("User select quantity adding '{int}’")
	public void userSelectQuantityAdding(Integer int1) {
		selectByValue(factory.retailOrderPage().quantitySelectDropdown, "2");
		logger.info(int1 + " number of item was selected");
	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.retailOrderPage().addToCardButton);
		logger.info("Add to cart button was clicked");
	}

	@Then("The cart icon quantity should change to '{int}’")
	public void theCartIconQuantityShouldChangeTo(Integer quantity) {
		int actuallQuantity = quantity;
		int expectedQuantity = 2;
		Assert.assertEquals(expectedQuantity, actuallQuantity);
		logger.info(quantity + " number of items was added to the cart");
		factory.retailOrderPage().clearCart();
		slowDown();
	}

	// -----------Scenario: Verify User can add an item to cart----------------

	@When("User select quantity {string}")
	public void userSelectQuantity(String quantity) {
		selectByVisibleText(factory.retailOrderPage().quantitySelectDropdown, quantity);
		logger.info(quantity + " was selected for quantity");
	}

	@Then("The cart icon quantity should change to ordering '{int}’")
	public void theCartIconQuantityShouldChangeToOrdering(Integer quantity) {
		int expectedQuantity = quantity;
		int actualQuantity = 5;
		Assert.assertEquals(expectedQuantity, actualQuantity);
	}

	@When("User click on cart option")
	public void userClickOnCartOption() {
		click(factory.retailOrderPage().cartOption);
		logger.info("Cart option was clicked");
	}


	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.retailOrderPage().proceedToCheckOut);
		logger.info("Procceed to checkout button was clicked");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.retailOrderPage().placeOrderButton);
		logger.info("Place your order button was clicked");
	}

	@Then("A message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.retailOrderPage().orderPlacedSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.retailOrderPage().orderPlacedSuccessMessage));
		logger.info(string + " ,message was displayed");
	}

	@Then("A confirmation page should be displayed {string}")
	public void aConfirmationPageShouldBeDisplayed(String string) {
		waitTillPresence(factory.retailOrderPage().orderPlacedConfirmation);
		Assert.assertTrue(isElementDisplayed(factory.retailOrderPage().orderPlacedConfirmation));
		logger.info(orderPlacedConfirmation + " was displayed");
	}


	// ----------Scenario: Verify User can cancel the order----------------------

	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.retailOrderPage().orderButtonLink);
		logger.info("Order section was clicked");
	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.retailOrderPage().cancelOrderButton);
		logger.info("Cancel order button was clicked");
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String cancelationReason) {
		selectByValue(factory.retailOrderPage().cancelReasonSelect, "wrong");
		logger.info(cancelationReason + " was selected as reason");
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.retailOrderPage().orderCancelButton2);
		logger.info("Cancel order button was clicked");
	}

	@Then("A cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String cancelationMessage) {
		Assert.assertTrue(isElementDisplayed(factory.retailOrderPage().orderCancelationMessage));
		logger.info(cancelationMessage + " , was displayed");
	}

	// ----------Scenario: Verify User can Return the order------------

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.retailOrderPage().returnItemButton);
		logger.info("Return item button was clicked");
	}

	@When("User select first item in list")
	public void userSelectFirstItemInList() {
		click(factory.retailOrderPage().firstItemCheckBox);
		logger.info("First item was selected");
	}

	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String returnReason) {
		selectByVisibleText(factory.retailOrderPage().returnReasonSelect, returnReason);
		logger.info(returnReason + " , was selected as reason");
	}

	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String dropOffService) {
		selectByVisibleText(factory.retailOrderPage().dropOffSelect, dropOffService);
		click(factory.retailOrderPage().firstItemCheckBox);
		logger.info(dropOffService + " was selected as dropoff service");

	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.retailOrderPage().returnOrderButton);
		logger.info("Return order button was clicked");
	}

	@Then("A return message should be displayed {string}")
	public void aReturnMessageShouldBeDisplayed(String returnMessage) {
		waitTillPresence(factory.retailOrderPage().returnSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.retailOrderPage().returnSuccessMessage));
		logger.info(returnMessage + " was displayed");
	}

	// -----Scenario: Verify User can write a review on order placed-------

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.retailOrderPage().reviewButton);
		logger.info("Review button was clicked");
	}

	@When("User write Review headline {string}")
	public void userWriteReviewHeadline(String reviewHeadline) {
		sendText(factory.retailOrderPage().reviewHeadlineBox, reviewHeadline);
		logger.info("Review headline entered");
	}

	@When("User write Review Body {string}")
	public void userWriteReviewBody(String reviewBody) {
		sendText(factory.retailOrderPage().reviewBody, reviewBody);
		logger.info(reviewBody + " was entered as review");
	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.retailOrderPage().addYourReviewButton);
		logger.info("Add your review button was clicked");
	}

	@Then("A review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String reviewSuccessMessage) {
		waitTillPresence(factory.retailOrderPage().reviewSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.retailOrderPage().reviewSuccessMessage));

	}

}
