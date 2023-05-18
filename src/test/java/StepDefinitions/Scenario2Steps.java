package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Scenario2Steps {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Given("we are on ecommerse application")
	public void we_are_on_ecommerse_application() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	@When("we click on add to cart button")
	public void we_click_on_add_to_cart_button() {
	    driver.findElement(By.xpath("//div[@class='cart-area']")).click();
	}

	@Then("user should be  navigate to summary page")
	public void user_should_be_navigate_to_summary_page() {
	    WebElement summary = driver.findElement(By.xpath("//div[@class='cart-amount-summary']"));
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.visibilityOf(summary));
	    
	}

	@Then("user able to click on the Checkout button")
	public void user_able_to_click_on_the_checkout_button() {
	    driver.findElement(By.xpath("//a[text()='check out']")).click();
	}

	@Then("user is able to add all required details in the Billing Address page")
	public void user_is_able_to_add_all_required_details_in_the_billing_address_page() {
		String url = driver.getCurrentUrl();
		url.contains("checkout");
		driver.findElement(By.id("first_name")).sendKeys("testabc");
		driver.findElement(By.id("last_name")).sendKeys("adgdfht");
		driver.findElement(By.id("company")).sendKeys("adgdfht");
		driver.findElement(By.cssSelector("div.nice-select.w-100")).click();
		List<WebElement> countryList = driver.findElements(By.xpath("//ul[@class='list']/li"));
		for(int i=0;i<countryList.size();i++)
		{
			WebElement Country = countryList.get(i);
			if(Country.getText().equals("India"))
			{
				Country.click();
			}
		}
		
		driver.findElement(By.id("street_address")).sendKeys("thdffyf jhgvyuftydy ftuf thdtfuy jfyufuf thdtuf tdfurfutfg7ytgtg tydfutf");
		driver.findElement(By.id("street_address2")).sendKeys("thdffyf jhgvyuftydy ftuf thdtfuy jfyufuf thdtuf tdfurfutfg7ytgtg tydfutf");
		driver.findElement(By.id("postcode")).sendKeys("Tr21 0JJ");
		driver.findElement(By.id("city")).sendKeys("pune");
		driver.findElement(By.id("state")).sendKeys("Maharashtra");
		driver.findElement(By.id("phone_number")).sendKeys("0832343541");
		driver.findElement(By.id("email_address")).sendKeys("abc123@gmail.com");
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[2]")).click();
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[3]")).click();
		driver.findElement(By.xpath("(//h6[@class='mb-0'])[2]")).click();
		
		
		
		
		
	}

	@Then("user is able to click on the Place Order button")
	public void user_is_able_to_click_on_the_place_order_button() {
	    driver.findElement(By.xpath("//a[text()='Place Order']")).click();
	}
}
