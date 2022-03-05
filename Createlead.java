package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createlead {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
				
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		driver.findElement(By.xpath("CRM/SFA")).click();
		driver.findElement(By.xpath("Leads")).click();	
		
		driver.findElement(By.xpath("Create Lead")).click();	
        driver.findElement(By.id("createLeadForm_description")).sendKeys("To create Leads");

		WebElement sourceId = driver.findElement(By.id("createLeadForm_dataSourceId"));
        Select choose=new Select(sourceId);
        choose.selectByIndex(3);
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Lokesh");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
        driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Nani");
        driver.findElement(By.className("inputBox")).sendKeys("SitusAMC");
        driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("TrueConcept");
        driver.findElement(By.id("createLeadForm_description")).sendKeys("Process Associate");
        driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("lokeshnani43@gmail.com");
        WebElement StateId = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
        Select state=new Select(StateId);
        state.selectByVisibleText("Florida");
        driver.findElement(By.className("smallSubmit")).click();
        String title2 = driver.getTitle();
        System.out.println(title2);
        driver.wait();
		Thread.sleep(30);
	}
}
