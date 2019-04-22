package test.Hello;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.sun.tools.javac.util.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Registration {
	WebDriver driver = null;
	String name="";

	@Given("^User opens the web application$")
	public void user_opens_the_web_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//  throw new PendingException();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Reddy\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.get("http://www.newtours.demoaut.com/mercurywelcome.php");
		Assert.check(driver.getTitle().contains("Welcome"));
	}  


	@When("^User click on Register button$")
	public void user_click_on_Register_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		driver.findElement(By.xpath(".//a[text()='REGISTER']")).click();;

	}

	@Given("^fill the new registration form with username \"([^\"]*)\", \"([^\"]*)\"$")
	public void registrationForm(String username,String fn) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		name=username;
		driver.findElement(By.name("firstName")).sendKeys(fn);
		driver.findElement(By.name("lastName")).sendKeys("Reddy");
		driver.findElement(By.name("phone")).sendKeys("4443334444");
		WebElement countrydrop=driver.findElement(By.name("country"));
		Select dropDown=new Select(countrydrop);
		dropDown.selectByVisibleText("INDIA");
		driver.findElement(By.id("email")).sendKeys(username);

	}

	@When("^click on the submit button$")
	public void click_on_the_submit_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//throw new PendingException();
		driver.findElement(By.name("register")).click();
	}

	@Then("^New account is created$")
	public void new_account_is_created() throws Throwable {
		//Write code here that turns the phrase above into concrete actions
		// throw new PendingException();

		String regstatus = driver.findElement(By.xpath(".//font[contains(text(),\"Thank you for\")]")).getText();
		System.out.println(regstatus);
		Assert.check(regstatus.contains("Thank you for registering"));

	}


	@Then("^Verify if the User is created$")
	public void verify_if_the_User_is_created() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		String confirmtxt = driver.findElement(By.xpath(".//b[contains(text(),\"Note\")]")).getText();
		System.out.println(confirmtxt);
		Assert.check(confirmtxt.contains(name));

	}

	@Then("^Close the web application$")
	public void close_the_web_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		driver.close();
	}

}


