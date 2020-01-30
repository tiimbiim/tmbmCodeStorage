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
		
		boolean viewing = false;
		String href = "https://palosverdes.asp.aeries.net/Student";
		
		Scanner bim = new Scanner(System.in);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\timbi\\Desktop\\tmbm\\prog\\chromedriver_win32\\chromedriver.exe");
		
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
		
	/*	
		WebElement grade0 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[7]"));
		WebElement class0 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[3]"));
		System.out.println(class0.getText() + ": " + grade0.getText() + "%");
	*/
		
		WebElement grade1 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[7]"));
		WebElement class1 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[3]"));
		WebElement letter1 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[9]"));
		System.out.println(class1.getText() + "\t" + grade1.getText() + "%\t" + letter1.getText());
		
		WebElement grade2 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[7]"));
		WebElement class2 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[3]"));
		WebElement letter2 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[9]"));
		System.out.println(class2.getText() + "\t" + grade2.getText() + "%\t" + letter2.getText());
	
		WebElement grade3 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td[7]"));
		WebElement class3 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td[3]"));
		WebElement letter3 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td[9]"));
		System.out.println(class3.getText() + "\t" + grade3.getText() + "%\t" + letter3.getText());
		
		WebElement grade4 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td[7]"));
		WebElement class4 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]"));
		WebElement letter4 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td[9]"));
		System.out.println(class4.getText() + "\t" + grade4.getText() + "%\t" + letter4.getText());
		
		WebElement grade5 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[7]/td[7]"));
		WebElement class5 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[7]/td[3]"));
		WebElement letter5 = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[7]/td[9]"));
		System.out.println(class5.getText() + "\t" + grade5.getText() + "%\t" + letter5.getText());
		
		Thread.sleep(1000);
		
													/* VIEWING CLASS DETAILS */

/*	while(viewing = true)
	{
		bim.hasNextLine();

			if(bim.nextLine().equals(class1.getText()))
			{
				WebElement details = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]"));
				//WebElement detButton = details.findElement(By.name("ctl00$MainContent$subGBS$DataDetails$ctl04$btnGradeDetails"));
				//detButton.submit();
			
				details.click();
				
			}
			
			if(bim.nextLine().equals(class2.getText()))
			{
				WebElement details = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]"));
				//WebElement detButton = details.findElement(By.name("ctl00$MainContent$subGBS$DataDetails$ctl04$btnGradeDetails"));
				//detButton.submit();
			
				details.click();

			}
			
			if(bim.nextLine().equals(class3.getText()))
			{
				WebElement details = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[5]/td[2]"));
				//WebElement detButton = details.findElement(By.name("ctl00$MainContent$subGBS$DataDetails$ctl04$btnGradeDetails"));
				//detButton.submit();
			
				details.click();

			}
			
			if(bim.nextLine().equals(class4.getText()))
			{
				WebElement details = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td[2]"));
				//WebElement detButton = details.findElement(By.name("ctl00$MainContent$subGBS$DataDetails$ctl04$btnGradeDetails"));
				//detButton.submit();
			
				details.click();
				
				Thread.sleep(5000);
				
				WebElement grdDtl = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/div[5]/table/tbody/tr/td/div/div/div[3]/table[2]/thead/tbody/tr"));
				
				System.out.println(grdDtl.getText());

			}
			
			if(bim.nextLine().equals(class5.getText()))
			{
				WebElement details = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[7]/td[2]"));
				//WebElement detButton = details.findElement(By.name("ctl00$MainContent$subGBS$DataDetails$ctl04$btnGradeDetails"));
				//detButton.submit();
			
				details.click();

			}
			
		}	*/
	}
	}

