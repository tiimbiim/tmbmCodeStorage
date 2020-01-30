package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Scanner;

public class main {

	
	public static void main (String []args) throws InterruptedException
	{
		
		String href = "https://palosverdes.asp.aeries.net/Student/";
		
		Scanner bim = new Scanner(System.in);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\timbi\\Desktop\\tmbm\\progJunk\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
	    //options.addExtensions(new File("path/to/extensions.crx"));
		options.addArguments("--start-fullscreen");
				
		//WebDriver driver1 = new ChromeDriver();
		
	    WebDriver driver = new ChromeDriver();
	    //driver.manage().window().maximize();
		
	    driver.get("https://palosverdes.asp.aeries.net/Student/LoginParent.aspx?page=default.aspx");
		
	    Thread.sleep(5000);
		
		WebElement acctName = driver.findElement(By.name("portalAccountUsername"));		
		acctName.sendKeys("timbim8996@gmail.com");												
		
		System.out.println("Press \"Next\" when ready");								//bypass aeries stupid next button thing
		bim.nextLine();
		
		WebElement password = driver.findElement(By.name("portalAccountPassword"));
		password.sendKeys("976axbTT");											
		
		Thread.sleep(2500);
		
		WebElement login = driver.findElement(By.name("submit"));
		login.submit();																	//auto-click "sign in"
		
		Thread.sleep(7500);
		
		driver.get(href + "/GradebookSummary.aspx");
		
		Thread.sleep(2000);
		
		WebElement grade1 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr[3]/td[7]"));
		WebElement class1 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr[3]/td[3]"));
		System.out.println(class1.getText() + ": " + grade1.getText() + "%");
		
		Thread.sleep(2000);
		
		WebElement grade2 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td[7]"));
		System.out.println(grade2.getText() + "%");
	}
}
