package testCases;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import ObjectRepository.CartPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;
import genericUtility.ExcelUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;

@Listeners(ListenerUtility.ListenerImplementation.class)
public class AddProdTCartTest extends BaseClass{

	@Test(groups = "smoke")
	public void toAddProdTest() throws Throwable{

		ExcelUtility eutil=new ExcelUtility();
				
		String prodname = eutil.toReadDataFromExcel("Products", 1, 2);
		
		//add prod
		ProductPage pp=new ProductPage(driver);
		CartPage cp=new CartPage(driver);
 		pp.getProdname().click();
 		pp.getCartBtn().click();
 		
 		pp.getCartIcon().click();
 		
 		//validation
 		String cartitem = cp.getInventItem().getText();
		Assert.assertEquals(cartitem,prodname);
		
	}

}
