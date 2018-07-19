package runProgram;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.amazonFirstPage;
import pages.amazonLoginPage;
import utility.LoadFile;

public class AmazonGift extends TestBase{
	amazonLoginPage amazonlogin;
	amazonFirstPage amazonfirstpage;

	
	@Test
	public void amazonGift() throws InterruptedException {
		
		driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin&switch_account=");
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(LoadFile.getProperties("username"), Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(LoadFile.getProperties("password"), Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(LoadFile.getProperties("giveaway"), Keys.ENTER);
		
		
		String w = driver.findElement(By.xpath("//*[@id=\"giveawayListingPagination\"]/ul/li[6]")).getAttribute("id");
		System.out.println(w);
		w=w.substring(5);
		System.out.println(w);
		
		for (int i = 1; i <= w.length(); i++) {
			driver.findElement(By.xpath("//*[@id=\"giveawayListingPagination\"]/ul/li[7]")).click();

			int cnt = 0;
			test(cnt);
		}
		
	}//for
		
	
	
	public void test(int count) throws InterruptedException {
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='giveaway-grid-container']/div/div"));
		
		String s = "";
		String v = "";

		for (int i = 1; i < list.size(); i++) {
				
				driver.findElement(By.xpath("//div[@id='giveaway-item-"+i+"']//div[2]/div[2]/span")).click();
				
				boolean c= driver.findElements(By.xpath("//span[.='Enter for a chance to win!']")).isEmpty();
				boolean enter = driver.findElements(By.xpath("//input[@name='enter']")).isEmpty();
				boolean c3 = driver.findElements(By.xpath("//p[@id='giveaway-ended-header']")).isEmpty();
				
				System.out.println(c);
				if (c==true ) {
					driver.navigate().back();
				}else {
					Thread.sleep(8000);
					boolean enter2 = driver.findElements(By.xpath("//div[@id='box_click_target']")).isEmpty();
					
					if(enter == true &  enter2 == true) {
						System.out.println("c3 "+c3);
					
						if(c3 == false) continue; 
				    
						Thread.sleep(35000);
						driver.findElement(By.xpath("//input[@name='continue' and @type='submit']")).click();
						Thread.sleep(8000);
						driver.navigate().back();
				    
					}else {
						if(enter == true) {
							Thread.sleep(8000);
							driver.findElement(By.xpath("//div[@id='box_click_target']")).click();
							Thread.sleep(5000);
							driver.navigate().back();
						}else {
							driver.findElement(By.xpath("//input[@name='enter']")).click();
							driver.navigate().back();
						}
					}
				}
		}
	}
}


//for (int i = 1; i < list.size(); i++) {
//	s = driver.findElement(By.xpath("//div[@id='giveaway-item-"+i+"']//div[2]/div[2]/span")).getText();
//	System.out.println(s);
//	if(s.equals("No entry requirement")){
//		System.out.println("test1");
//		driver.findElement(By.xpath("//div[@id='giveaway-item-"+i+"']//div[2]/div[2]/span")).click();
//		
//		boolean c= driver.findElements(By.xpath("//span[.='Enter for a chance to win!']")).isEmpty();
//		
//		System.out.println(c);
//		if (c==true ) {
//			driver.navigate().back();
//		}else {
//			boolean enter = driver.findElements(By.xpath("//input[@name='enter']")).isEmpty();
//			if(enter == true) {
//				Thread.sleep(8000);
//				driver.findElement(By.xpath("//div[@id='box_click_target']")).click();
//				Thread.sleep(5000);
//				driver.navigate().back();
//			}else {
//				driver.findElement(By.xpath("//input[@name='enter']")).click();
//				driver.navigate().back();
//			}
//		}
//	}	
//	if(s.equals("Watch a short video")) {
//		driver.findElement(By.xpath("//div[@id='giveaway-item-"+i+"']//div[2]/div[2]/span")).click();
//		Thread.sleep(2000);
//		
//		boolean c2= driver.findElements(By.xpath("//span[.='Enter for a chance to win!']")).isEmpty();
//		System.out.println("c2 "+c2);
//		
//		if (c2==true ) {
//			driver.navigate().back();
//		}else {
//			count++;
//			System.out.println("count = "+count);
//			//if(count == 1) 
//			//	driver.findElement(By.xpath("//*[@id='airy-container']/div/div[12]/div")).click();
//		
//			boolean c3 = driver.findElements(By.xpath("//p[@id='giveaway-ended-header']")).isEmpty();
//			System.out.println("c3 "+c3);
//			
//			if(c3 == false) continue; 
//		    
//			Thread.sleep(35000);
//		    driver.findElement(By.xpath("//input[@name='continue' and @type='submit']")).click();
//		    Thread.sleep(8000);
//		    driver.navigate().back();
//		}
//	}
//}
