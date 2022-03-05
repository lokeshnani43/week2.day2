package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentUpi {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		String dashboard = driver.getTitle();
		System.out.println(dashboard);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		 driver.wait(300);
		 driver.close();
	}
	}
