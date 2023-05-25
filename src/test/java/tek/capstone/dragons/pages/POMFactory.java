package tek.capstone.dragons.pages;

public class POMFactory {
	private RetailHomePage retailHomePage;
	private RetailSignInPage retailSignInPage;
	private RetailAccountPage retailAccountPage;
	private RetailOrderPage retailOrderPage;
	
	public POMFactory() {
		this.retailAccountPage = new RetailAccountPage();
		this.retailHomePage = new RetailHomePage();
		this.retailOrderPage = new RetailOrderPage();
		this.retailSignInPage = new RetailSignInPage();
	}
	
	public RetailHomePage retailHomePage() {
		return this.retailHomePage;
	}
	
	public RetailSignInPage retailSignInPage() {
		return this.retailSignInPage;
	}
	
	public RetailAccountPage retailAccountPage() {
		return this.retailAccountPage;
	}
	
	public RetailOrderPage retailOrderPage() {
		return this.retailOrderPage;
	}
}
