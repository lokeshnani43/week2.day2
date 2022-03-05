package week2.day2;


import java.time.Duration;

import java.util.List;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class LeafGround {

		public static void main (String[] args) {
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement username =  driver.findElement(By.xpath("//input[@id='username']"));
			username.sendKeys("demoSalesManager");
			driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
			driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
			WebElement companyname = driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']"));
			companyname.sendKeys("Situs");
			WebElement firstname = driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']"));
			firstname.sendKeys("AMC");
			WebElement lastname = driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']"));
			lastname.sendKeys("India");
			WebElement industryname = driver.findElement(By.id("createLeadForm_industryEnumId"));
			Select objchoosest = new Select(industryname);
			objchoosest.selectByVisibleText("Aerospace");
			List<WebElement> options = objchoosest.getOptions();
			int size = options.size();
			System.out.println("insustry size of :" +size);
			objchoosest.selectByIndex(size-2);
			for(int i=0;i<size;i++) {
				String text = options.get(i).getText();
				System.out.println("options in the Dropdown"+i+":" + text);
			}
			boolean multiple = objchoosest.isMultiple();
			System.out.println(multiple);
			driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
			String crtleadtitle = driver.getTitle();
			System.out.println(crtleadtitle);
			driver.findElement(By.xpath("//ul[@class='shortcuts']/li[3]/a")).click();
			driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Lokesh");
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("//td[@class='x-btn-center']//button")).click();
			driver.close();
		}
		

	}