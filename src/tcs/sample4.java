package tcs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample4 {
	
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Selenium\\New folder\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("samsung tv");
	Thread.sleep(5000);
	String ext = "samsung tv 55 inch";
	
	
	List<WebElement> alloptions = driver.findElements(By.xpath("//div[@class='s-suggestion']"));
for (WebElement option : alloptions) {
	String act=option.getText();
	
	
	if(act.equals(ext)) {
		option.click();
		break;
		
	}
	
}

Thread.sleep(5000);

driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[3]")).click();
Thread.sleep(5000);


JavascriptExecutor js = (JavascriptExecutor) driver;

//Find element by link text and store in variable "Element"        		
WebElement Element = driver.findElement(By.xpath("//span[text()='Add to Cart']"));

//This will scroll the page till the element is found		
js.executeScript("arguments[0].scrollIntoView();", Element);


driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
Thread.sleep(3000);
//driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
driver.close();
}
}
