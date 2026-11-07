package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDAtaFromPropFile {

	public static void main(String[] args) throws Throwable {


FileInputStream fis=new FileInputStream("./src/test/resources/Commondata.properties");		
Properties prop=new Properties();
prop.load(fis);
String BROWSER = prop.getProperty("Browser");
String URL = prop.getProperty("Url");
String USERNAME = prop.getProperty("Username");
String PASSWORD = prop.getProperty("Password");

WebDriver driver=null;

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

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get(URL);

//login
driver.findElement(By.id("user-name")).sendKeys(USERNAME);
driver.findElement(By.id("password")).sendKeys(PASSWORD);
driver.findElement(By.id("login-button")).click();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
