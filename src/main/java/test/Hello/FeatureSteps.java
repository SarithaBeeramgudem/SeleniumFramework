package test.Hello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeatureSteps {
	WebDriver driver=null;

@Given("^User have google url$")
public void user_have_google_url() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   // throw new PendingException();
	System.out.println("Google page launched");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Reddy\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();	
	driver.get("https://www.google.com");
}

@Given("^he search  somthing$")
public void he_search_somthing() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   // throw new PendingException();
	//sysout
	driver.findElement(By.name("q")).sendKeys("Hello");
}


@When("^he click on search button$")
public void he_click_on_search_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   // throw new PendingException();
	driver.findElement(By.name("q")).submit();
	//driver.findElement(By.className("btnK")).click();
}

@Then("^User should see search count$")
public void user_should_see_search_count() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   // throw new PendingException();
	String sr = driver.findElement(By.id("resultStats")).getText();
	System.out.println(sr);
}


}
