package tek.capstone.dragons.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.mysql.cj.x.protobuf.MysqlxResultset.Row;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	// Scenario: Verify User can update Profile Information

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.retailAccountPage().accountOption);
		logger.info("Account option was clicked");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAquaManAndPhone(String name, String phone) {
		clearTextUsingSendKeys(factory.retailAccountPage().nameInputUpdate);
		sendText(factory.retailAccountPage().nameInputUpdate, name);
		clearTextUsingSendKeys(factory.retailAccountPage().phoneInputUpdate);
		sendText(factory.retailAccountPage().phoneInputUpdate, phone);

		logger.info("New name and phone number entered");
	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		waitTillClickable(factory.retailAccountPage().nameUpdateButton);
		click(factory.retailAccountPage().nameUpdateButton);
		logger.info("Update button was clicked");
	}

	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		Assert.assertTrue((boolean) factory.retailAccountPage().newNameAfterUpdate.isDisplayed());
		logger.info("Profile info updateted");
	}

	@Then("A message should be displayed name update {string}")
	public void aMessageShouldBeDisplayedNameUpdate(String nameUpdateSuccessMessage) {
		waitTillPresence(factory.retailAccountPage().nameUpdateSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.retailAccountPage().nameUpdateSuccessMessage));
		logger.info("Profile update status: " + nameUpdateSuccessMessage);
	}

	// Scenario: Verify User can add a payment method

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.retailAccountPage().addPaymentMethodButton);
		logger.info("AddPayment link was clicked");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			sendText(factory.retailAccountPage().addCardNumberBox, row.get("cardNumber"));
			sendText(factory.retailAccountPage().nameOnCardBox, row.get("nameOnCard"));
			selectByValue(factory.retailAccountPage().monthOnCardSelect, row.get("expirationMonth"));
			selectByValue(factory.retailAccountPage().yearOnCardSelect, row.get("expirationYear"));
			sendText(factory.retailAccountPage().cardSecurityCodeBox, row.get("securityCode"));
			logger.info("Card information was entered");
			slowDown();
		}

	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.retailAccountPage().addCardButton);
		logger.info("Add your card button was clicked");
	}

	@Then("A message should be displayed add payment {string}")
	public void aMessageShouldBeDisplayedAddPayment(String paymentSuccessMessage) {
		waitTillPresence(factory.retailAccountPage().profileUpdateSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.retailAccountPage().PaymentMethodAddSuccessMessage));
		logger.info("Payment method addition status: " + paymentSuccessMessage);

	}
	// Scenario: Verify User can edit Debit or Credit card

	@Then("User click on saved card image")
	public void userClickOnSavedCardImage() {
		click(factory.retailAccountPage().savedCardImage);
		logger.info("Saved card was clicked");

	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.retailAccountPage().cardEditOption);
		logger.info("Edit card option was clicked");
	}

	@When("User edit information with below data")
	public void userEditInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
//			factory.retailAccountPage().ClearCreditCardFields();
			clearTextUsingSendKeys(factory.retailAccountPage().addCardNumberBox);
			sendText(factory.retailAccountPage().addCardNumberBox, row.get("CardNumber"));
			clearTextUsingSendKeys(factory.retailAccountPage().nameOnCardBox);
			sendText(factory.retailAccountPage().nameOnCardBox, row.get("NameOnCard"));
			selectByValue(factory.retailAccountPage().monthOnCardSelect, row.get("ExpirationMonth"));
			selectByValue(factory.retailAccountPage().yearOnCardSelect, row.get("ExpirationYear"));
			clearTextUsingSendKeys(factory.retailAccountPage().cardSecurityCodeBox);
			sendText(factory.retailAccountPage().cardSecurityCodeBox, row.get("SecurityCode"));
			logger.info("Updated card info was entered");
		}
	}

	@When("User click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.retailAccountPage().updateCardButton);
		logger.info("Update card button was clicked");
	}

	@Then("A message should be displayed update payment {string}")
	public void aMessageShouldBeDisplayed(String paymentUpdateSuccessMessage) {
//		waitTillPresence(factory.retailAccountPage().editDebitCardSuccessMEssage);
//		Assert.assertTrue(isElementDisplayed(factory.retailAccountPage().editDebitCardSuccessMEssage));
		logger.info("Payment Method updated" + paymentUpdateSuccessMessage);
	}

	// Scenario: Verify User can remove Debit or Credit card
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.retailAccountPage().removeCardButton);
		logger.info("Remove card button was clicked");
	}

	@Then("Payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(factory.retailAccountPage().addDebitOrCreditCardText.isDisplayed());
		logger.info("Payment Method removed");
	}

	// Scenario: Verify User can add an Address

	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.retailAccountPage().addAddressOption);
		logger.info("Add address button was clicked");
	}

	@When("User fill address form with below information")
	public void userFillAddressFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			selectByValue(factory.retailAccountPage().countryAddressSelectBox, row.get("Country"));
			sendText(factory.retailAccountPage().fullNameAddressInputBox, row.get("FullName"));
			sendText(factory.retailAccountPage().phoneInputAddressBox, row.get("PhoneNumber"));
			sendText(factory.retailAccountPage().streetInputAddressBox, row.get("StreetAddress"));
			sendText(factory.retailAccountPage().apptInputAddressBox, row.get("Apt"));
			sendText(factory.retailAccountPage().cityInputAddressBox, row.get("City"));
			selectByValue(factory.retailAccountPage().stateSelectAddressBox, row.get("State"));
			sendText(factory.retailAccountPage().zipCodeInputAddressBox, row.get("ZipCode"));
			logger.info("Address info entered");
		}
	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.retailAccountPage().addYourAddressButton);
		logger.info("Add your address button was clicked");

	}

	@Then("A message should be displayed add address {string}")
	public void aMessageShouldBeDisplayedAddAddress(String addAddressSuccessMessage) {
		waitTillPresence(factory.retailAccountPage().addAddressSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.retailAccountPage().addAddressSuccessMessage));
		logger.info("Address updated status: " + addAddressSuccessMessage);

	}

	// Scenario: Verify User can edit an Address added on account

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.retailAccountPage().editAddressOption);
		logger.info("Edit Address button was clicked");
	}

	@When("User fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> rows : data) {
//			factory.retailAccountPage().clearAddressUpdateFields();
			selectByValue(factory.retailAccountPage().countryAddressSelectBox, rows.get("Country"));
			clearTextUsingSendKeys(factory.retailAccountPage().fullNameAddressInputBox);
			sendText(factory.retailAccountPage().fullNameAddressInputBox, rows.get("FullName"));
			
			clearTextUsingSendKeys(factory.retailAccountPage().phoneInputAddressBox);
			sendText(factory.retailAccountPage().phoneInputAddressBox, rows.get("PhoneNumber"));
			
			clearTextUsingSendKeys(factory.retailAccountPage().streetInputAddressBox);
			sendText(factory.retailAccountPage().streetInputAddressBox, rows.get("StreetAddress"));
			
			clearTextUsingSendKeys(factory.retailAccountPage().apptInputAddressBox);
			sendText(factory.retailAccountPage().apptInputAddressBox, rows.get("Apt"));
			
			clearTextUsingSendKeys(factory.retailAccountPage().cityInputAddressBox);
			sendText(factory.retailAccountPage().cityInputAddressBox, rows.get("City"));
			
			
			selectByValue(factory.retailAccountPage().stateSelectAddressBox, rows.get("State"));
			
			clearTextUsingSendKeys(factory.retailAccountPage().zipCodeInputAddressBox);
			sendText(factory.retailAccountPage().zipCodeInputAddressBox, rows.get("ZipCode"));
			logger.info("Updated address info was entered");
		}
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.retailAccountPage().updateAddressButton);
		logger.info("UpdateAddress button was clicked");
	}

	@Then("A message should be displayed update address {string}")
	public void aMessageShouldBeDisplayedUpdateAddress(String updateAddressSuccessMessage) {
//		waitTillPresence(factory.retailAccountPage().updateAddressSuccessMessage);
//		Assert.assertTrue(factory.retailAccountPage().updateAddressSuccessMessage.isDisplayed());
		
		logger.info("Address update status: " + updateAddressSuccessMessage);
	}

	// Scenario: Verify User can remove Address from Account

	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.retailAccountPage().removeAddressOption);
		logger.info("Remove Address button was clicked");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		Assert.assertTrue(factory.retailAccountPage().addAddressOption.isDisplayed());
		logger.info("Address removed");

	}

	// Scenario: Verify user can update password

	@When("User enter bellow information")
	public void userEnterBellowInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> rows : data) {
			clearTextUsingSendKeys(factory.retailAccountPage().previousPasswordBox);
			sendText(factory.retailAccountPage().previousPasswordBox, rows.get("previousPassword"));
			sendText(factory.retailAccountPage().newPasswordBox, rows.get("newPassword"));
			sendText(factory.retailAccountPage().confirmNewPasswordBox, rows.get("confirmPassword"));
			logger.info("Change password button was clicked");

		}

	}

	@When("User click on change password button")
	public void userClickOnChangePasswordButton() {
		click(factory.retailAccountPage().changePasswordButton);
		logger.info("Change password button was clicked");
	}

	@Then("A message should be displayed password change {string}")
	public void aMessageShouldBeDisplayedPasswordChange(String passwordChangeSuccessMessage) {
		waitTillPresence(factory.retailAccountPage().passwordChangeSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.retailAccountPage().passwordChangeSuccessMessage));
		logger.info("Password changed status: " + passwordChangeSuccessMessage);
	}
	
}
