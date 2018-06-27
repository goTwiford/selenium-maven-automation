package WebElements;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
		@Test
		public void WebElement() {
			driver.get("https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");
		WebElement email = driver.findElement(By.name("Email")); 
		
		String value  = email.getAttribute("value");
		String maxLength = email.getAttribute("maxLength");
		String type = email.getAttribute("type");
		String tag = email.getTagName();
		
		String b = null;
		System.out.println("value: "+value +"\n"+
				"maxLength:"+maxLength +"\n"+
				"type: "+type+"\n"+
				"IsEnabled: "+b);
		assertEquals(value, "youremail@mail.com");
		email.clear();
		email.sendKeys("another@mail.com");
		WebElement country =driver.findElement(By.id("Address_Country"));	
		Select selectCountry = new Select(country);
		//Select selectCountry2 = new Select(driver.findElement(By.id("Address_Country")))
		String d = selectCountry.getFirstSelectedOption().getText();
		System.out.println(d);
		selectCountry.selectByIndex(67);
		
		//lets to generat staleElementExpeption
		WebElement cSalary = driver.findElement(By.name("Number"));
		assertEquals(cSalary.isDisplayed(),true);
		driver.get("https://google.com");
		//driver.findElement(By.xpath("//em[.=' Next ']")).click();
		cSalary.sendKeys("123456");
		
		
		
		}			
		

}
