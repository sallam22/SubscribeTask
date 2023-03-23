package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class steps {

	WebDriver driver;
	@BeforeTest
	@Given("User lanuch chorme browser")
	public void user_lanuch_chorme_browser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://subscribe.jawwy.tv/eg-en");
		driver.manage().window().maximize();
		

	}

	
	 @Test
	@When("choose your plan")
	public void choose_your_plan() {
		 // check select country
        driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/span[1]/img[1]")).click();
        // check click on selected country Egypt
        driver.findElement(By.xpath("//span[@id='eg-contry-lable']")).click();
        // check select the classic package
        driver.findElement(By.xpath("//a[contains(text(),'Select')]")).click();
        // check to select vodafone as payment methods
        driver.findElement(By.xpath("//img[@id='vodafone_egy-label']")).click();
       // check to click on next button
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='minisub-container']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")).click();
        // enter valid  phone number
        driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("1013468910");
        // click next after check the total summary
        driver.findElement(By.xpath("//button[@id='btnFinalStepSubscribe']")).click();
        //check the user able to see confirm pin page
        String ActualResults= driver.findElement(By.xpath("//h2[contains(text(),'PIN Confirmation')]")).getText();
		String ExpectedResults="PIN Confirmation";
		Assert.assertEquals(ExpectedResults, ActualResults);

	}
	 @AfterTest
	@Then("Subscribe Done")
	public void subscribe_done() {
		
		
		System.out.println("Subscribe Done");
		driver.close();
	}
	 

}
