package tek.capstone.dragons.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.dragons.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// -------------------------Update Profile Locators---------------------------
	@FindBy(xpath = "//*[@id=\"accountLink\"]")
	public WebElement accountOption;

	@FindBy(xpath = "//input[@id='nameInput']")
	public WebElement nameInputUpdate;

	@FindBy(xpath = "//input[@id='personalPhoneInput']")
	public WebElement phoneInputUpdate;

	@FindBy(xpath = "//*[@id=\"personalUpdateBtn\"]")
	public WebElement nameUpdateButton;

	@FindBy(xpath = "//h1[@class='account__information-username']")
	public WebElement newNameAfterUpdate;

	// -----------------Add/Edit/Remove Payment
	// Locators-----------------------------
	@FindBy(xpath = "//div[@class='w-8/12']//child::p")
	public WebElement addPaymentMethodButton;

	@FindBy(xpath = "//input[@id='cardNumberInput']")
	public WebElement addCardNumberBox;

	@FindBy(xpath = "//input[@id='nameOnCardInput']")
	public WebElement nameOnCardBox;

	@FindBy(xpath = "//select[@id='expirationMonthInput']")
	public WebElement monthOnCardSelect;

	@FindBy(xpath = "//select[@id='expirationYearInput']")
	public WebElement yearOnCardSelect;

	@FindBy(xpath = "//input[@id='securityCodeInput']")
	public WebElement cardSecurityCodeBox;

	@FindBy(xpath = "//button[@id='paymentSubmitBtn']")
	public WebElement addCardButton;

	@FindBy(xpath = "//div[@class='flex gap-2 py-2']//child::button[1]")
	public WebElement cardEditOption;

	@FindBy(xpath = "//button[@id='paymentSubmitBtn']")
	public WebElement updateCardButton;

	@FindBy(xpath = "//div[@class='flex gap-2 py-2']//child::button[2]")
	public WebElement removeCardButton;

	@FindBy(xpath = "//h1[@class='account__payment-new-title']")
	public WebElement addDebitOrCreditCardText;

	@FindBy(xpath = "//h1[@class ='account__payments-title']")
	public WebElement cardAndAccountText;

	@FindBy(xpath = "//div[@class='account__payment-image-wrapper']//child::img")
	public WebElement savedCardImage;

	// --------------------Add/Edit/Remove Address Locators---------------------
	@FindBy(xpath = "//select[@id='countryDropdown']")
	public WebElement countryAddressSelectBox;

	@FindBy(xpath = "//input[@id='fullNameInput']")
	public WebElement fullNameAddressInputBox;

	@FindBy(xpath = "//input[@id='phoneNumberInput']")
	public WebElement phoneInputAddressBox;

	@FindBy(xpath = "//input[@id='streetInput']")
	public WebElement streetInputAddressBox;

	@FindBy(xpath = "//input[@id='apartmentInput']")
	public WebElement apptInputAddressBox;

	@FindBy(xpath = "//input[@id='cityInput']")
	public WebElement cityInputAddressBox;

	@FindBy(xpath = "//select[@name='state']")
	public WebElement stateSelectAddressBox;

	@FindBy(xpath = "//input[@id='zipCodeInput']")
	public WebElement zipCodeInputAddressBox;

	@FindBy(xpath = "//button[@id='addressBtn']")
	public WebElement addYourAddressButton;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[2]/button[1]")
	public WebElement editAddressOption;

	@FindBy(xpath = "//button[@class='account__address-btn'][2]")
	public WebElement removeAddressOption;

	@FindBy(xpath = "//div[@class='account__address-new-wrapper']")
	public WebElement addAddressOption;

	@FindBy(xpath = "//button[@id='addressBtn']")
	public WebElement updateAddressButton;

	// ----------------------Password Update Locators
	@FindBy(id = "previousPasswordInput")
	public WebElement previousPasswordBox;

	@FindBy(id = "newPasswordInput")
	public WebElement newPasswordBox;

	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmNewPasswordBox;

	@FindBy(xpath = "//*[@id=\"credentialsSubmitBtn\"]")
	public WebElement changePasswordButton;

	// Account Page Success Messages Locators
	@FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/div[2]")
	public WebElement profileUpdateSuccessMessage;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/div[2]")
	public WebElement PaymentMethodAddSuccessMessage;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/div[2]")
	public WebElement paymentUpdateSuccessMessage;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/div[2]")
	public WebElement addAddressSuccessMessage;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/div[2]")
	public WebElement updateAddressSuccessMessage;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/div[2]")
	public WebElement passwordChangeSuccessMessage;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/div[2]")
	public WebElement nameUpdateSuccessMessage;

//	   
//	@FindBy(xpath = "//div[@class='order']//descendant::button[@id='cancelBtn']")
//	    public List<WebElement> cancelBttn;
//
//	[2:28 PM]
//	Emal Ramin
//
//	   
//	@FindBy(xpath = "//div[@class='order']//descendant::p[7]")
//
//	    public List<WebElement> listOfOrder;

	

	// Clear Fields Methods
	public void clearProfileUpdateBoxes() {
		nameInputUpdate.clear();
		phoneInputUpdate.clear();
	}

	public void ClearCreditCardFields() {
		addCardNumberBox.clear();
		nameOnCardBox.clear();
		cardSecurityCodeBox.clear();
	}

	public void clearAddressUpdateFields() {
		fullNameAddressInputBox.clear();
		phoneInputAddressBox.clear();
		streetInputAddressBox.clear();
		apptInputAddressBox.clear();
		cityInputAddressBox.clear();
		zipCodeInputAddressBox.clear();
	}

}
