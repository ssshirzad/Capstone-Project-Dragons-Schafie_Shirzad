package tek.capstone.dragons.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.dragons.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {
	
	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "logoutBtn")
	public WebElement logoutButton;
	
	@FindBy(id = "signinLink")
	public WebElement signInButton;
	 
	@FindBy(linkText = "TEKSCHOOL")
	public WebElement tekschoolLogo;
	
	@FindBy(id = "emailInput")
	public WebElement emailInputBoxSignUp;
	
	@FindBy(id = "passwordInput")
	public WebElement passwordInputBoxSignUp;
	
	@FindBy(id = "loginBtn")
	public WebElement loginButton;
	
	@FindBy(id = "newAccountBtn")
	public WebElement newAccountButton;
	
	@FindBy(id = "nameInput")
	public WebElement nameInputBox;
	
	@FindBy(id = "confirmPasswordInput")
	public WebElement passwordConfirmBox;
	
	@FindBy(id = "signupBtn")
	public WebElement SignUpButton;
	
	@FindBy(id = "email")
	public WebElement emailInputBoxSignIn;
	
	@FindBy(id = "password")
	public WebElement passwordInputBoxSignIn;
	
	@FindBy(xpath = "//*[@id=\"accountLink\"]")
	public WebElement accountOption;
	
	@FindBy(id = "orderLink")
	public WebElement orderOption;
	
	@FindBy(id = "logoutBtn")
	public WebElement logoutOption;
	
	@FindBy(css = ".account__personal-title")
	public WebElement yourAccountProfile;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[3]/div/div[1]/div/div[1]/div/h1[1]")
	public WebElement userNameDisplay;
	
	
	
	

}
