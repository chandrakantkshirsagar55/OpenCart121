package testCaces;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC4_priceComparisonTest extends BaseClass{
	
	@Test
	public void mostChipestProduct() {
		System.out.println("in TC4_priceComparisonTest method");
		logger.info("in the mostChipestProduct method");
		
		List<WebElement> e=driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div"));
		logger.info("no of elements found"+e.size());
		System.out.println("no of elements found: "+e.size());
		
		//int[] a = new int[5];
		
		int  [] price= new int[e.size()];
		
		for (int i=1; i<=e.size()-1;i++) {
			
			String productName=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div["+i+"]/div/div[2]/h4")).getText();
			String productPrice=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div["+i+"]/div/div[2]/p[2]/span")).getText();
			
			String str=productPrice;
			System.out.println(productPrice);
			
			String numericPart = str.replaceAll("[^\\d]", ""); // Remove everything except digits
	        
			String intPart=numericPart.split("\\.")[0];
			
	        int value = Integer.parseInt(intPart);
	        
	        price[i]=value;
	        
	        System.out.println("The extracted value is: " + value);

			
		}
		Arrays.sort(price);
		System.out.println("the lowest price product is;"+ price[1]);
//		for(int num:price) {
//			System.out.println("the price is");
//			System.out.println(num);
//
//		}
		
	}

}
