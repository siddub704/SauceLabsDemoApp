package com.qa.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import com.qa.pages.Base;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_steps {
	WebDriver driver;
	LoginPage lp;
	Properties p;
	

	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException {

		//driver.get(p.getProperty("url"));
		//driver.get("https://www.saucedemo.com");
	}

	//Reading data from feature file(invalid login)
	@When("user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) {

		lp=new LoginPage(Base.getDriver());
		lp.setUsernametxtfld(username);
		lp.setPasswordtxtfld(password);

	}

	//Reading data from properties file(valid login)
	@When("user enters username and password")
	public void user_enters_username_and_password() throws IOException {
		lp=new LoginPage(Base.getDriver());
		p=Base.getProperties();
		lp.setUsernametxtfld(p.getProperty("userName"));
		lp.setPasswordtxtfld(p.getProperty("password"));
	}

	@And("click on login button")
	public void click_on_login_button() {
		lp.setLoginbtn();
	}

	@Then("user is logedin successfully")
	public void user_is_logedin_successfully() {
		lp.ValidateSuccessfulLogin();
		
		//window handling
		String mtab = Base.getDriver().getWindowHandle();
		System.out.println(mtab);
		Base.getDriver().navigate().to("https://www.naukri.com/");
		System.out.println(Base.getDriver().getTitle());
		Base.getDriver().navigate().back();

		System.out.println(Base.getDriver().getCurrentUrl());

		Set<String> tabs = Base.getDriver().getWindowHandles();
		Base.getDriver().switchTo().newWindow(WindowType.TAB);
		Base.getDriver().switchTo().window(mtab);



	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		if(!Base.getDriver().getTitle().equals(title)) {
			throw new IllegalStateException("This is not page. the corrent page is"+ driver.getCurrentUrl());
		}

	}

	@Then("I verify the {string} based on the credentials")
	public void i_verify_the_based_on_the_credentials(String emsg) {

		String amsg = lp.ValidateErrorMessage();
		assertEquals(emsg, amsg);
	}

}
