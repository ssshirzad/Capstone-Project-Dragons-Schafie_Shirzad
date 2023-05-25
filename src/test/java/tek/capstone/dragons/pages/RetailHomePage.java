package tek.capstone.dragons.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.dragons.base.BaseSetup;

public class RetailHomePage extends BaseSetup {
	
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css = "button#hamburgerBtn")
	public WebElement sideBarAllDropdown;
	
	@FindBy(css = "div[data-id='1']")
	public WebElement sideBarElectronics;
	
	@FindBy(css = "div[data-id='2']")
	public WebElement sideBarComputers;
	
	@FindBy(css = "div[data-id='3']")
	public WebElement sideBarSmartHome;
	
	@FindBy(css = "div[data-id='4']")
	public WebElement sideBarSports;
	
	@FindBy(css = "div[data-id='5']")
	public WebElement sideBarAutomotive;
	
	@FindBy(css = "button[id='submenuBtn']")
	public WebElement sideBarMainMenu;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(2) > span")
	public WebElement tvAndVideoLink;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(3)")
	public WebElement videoGamesLink;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(2)")
	public WebElement accessoriesLink;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(3)")
	public WebElement networkingLink;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(2) > span")
	public WebElement smartHomeLightningLink;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(3)")
	public WebElement plugsAndOutletsLink;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(2)")
	public WebElement athleticClothingLink;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(3)")
	public WebElement exerciseAndFitnessLink;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(2) > span")
	public WebElement autoPartsAndAccessLink;
	
	@FindBy(css = "div.sidebar_content-item:nth-child(3)")
	public WebElement cycleAndPowerSportsLink;
	
	

}
