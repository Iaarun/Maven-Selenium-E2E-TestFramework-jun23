package stepdefinition;

import com.baseDriver.BaseDriver;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginStepDef {
	LoginPage loginPage = new LoginPage(BaseDriver.getDriver());

	@Given("user is at the login page")
	public void user_is_at_the_login_page() {
	   BaseDriver.getDriver().get("http://live.techpanda.org/index.php/customer/account/login/");
	}

	@When("user provide invalid {string} and {string}")
	public void user_provide_invalid_and(String username, String password) {
	    loginPage.sendEmailId(username);
	    loginPage.sendPassword(password);
	    
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	    loginPage.clickOnLoginBtn();
	}

	@Then("verify the {string} is displayed")
	public void verify_the_is_displayed(String errorMessage) {
	  String error=  loginPage.getloginError();
	  Assert.assertEquals(error, errorMessage);
	}
}
