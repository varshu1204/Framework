package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ObjectRepository.CartPage;
import ObjectRepository.LoginPage;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;

public class BaseClass {

	public WebDriver driver=null;
	public static WebDriver sdriver=null;  //listner
	public 		PropertiesFileUtility putil=new PropertiesFileUtility();

	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke","regression"})
	  public void beforeClass() throws Throwable {
		  
		//String BROWSER = putil.toReadDataFromPropFile("Browser");
		String BROWSER = System.getProperty("Browser"); //cmdline


		if(BROWSER.equals("Edge"))
		{		
		 driver=new EdgeDriver();  
			}
		else if(BROWSER.equals("Chrome"))	
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}

		sdriver=driver;
		  Reporter.log("launch browser",true);

	  }
	
	 @BeforeMethod(groups = {"smoke","regression"})
	  public void beforeMethod() throws Throwable {
		 
		 String URL = putil.toReadDataFromPropFile("Url");
			String USERNAME = putil.toReadDataFromPropFile("Username");
			String PASSWORD = putil.toReadDataFromPropFile("Password");

			WebDriverUtility wutil=new WebDriverUtility();

		  
		 driver.manage().window().maximize();
			wutil.waitForPageToLoad(driver);
			driver.get(URL);

			//login
			LoginPage lp=new LoginPage(driver);
			lp.getUn().sendKeys(USERNAME);
			lp.getPwd().sendKeys(PASSWORD);
			lp.getLgnbtn().click();
		  Reporter.log("login",true);

		  

	  }

	  @AfterMethod(groups = {"smoke","regression"})
	  public void afterMethod() {
		  
		  CartPage cp=new CartPage(driver);
		  cp.getBurgerIcon().click();
		  cp.getLogout().click();
			
		  Reporter.log("logout",true);


	  }

	  

	  @AfterClass(groups = {"smoke","regression"})
	  public void afterClass() {
		  
		  driver.quit();
		  Reporter.log("close browser",true);

	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
