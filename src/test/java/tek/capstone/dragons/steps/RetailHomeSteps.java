package tek.capstone.dragons.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;

public class RetailHomeSteps  extends CommonUtility{
	
	POMFactory factory = new POMFactory();
	
	@When("User click on All section")
	public void userClickOnAllSection() {
	   click(factory.retailHomePage().sideBarAllDropdown);
	   logger.info("AllDepartment clicked");
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> data = dataTable.asLists(String.class);
	    for(List<String> row : data) {
	    	data.equals(row.get(0));
	    	data.equals(row.get(1));
	    	data.equals(row.get(2));
	    	data.equals(row.get(3));
	    	data.equals(row.get(4));
	    	logger.info("Sections verified");
	    }
	
	}

	@When("User can see below options are present in department")
	public void userCanSeeBelowOptionsArePresentInDepartment(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for(Map<String, String> row : data) {
			Assert.assertEquals(factory.retailHomePage(), row.get("department"));
			Assert.assertEquals(factory.retailHomePage(), row.get("optionOne"));
			Assert.assertEquals(factory.retailHomePage(), row.get("optionTwo"));
			logger.info("Options clicked and verified");
		}
	}
}
