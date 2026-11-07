package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Sauce Labs Fleece Jacket']")
	private WebElement prodname;
	
	@FindBy(xpath="//div[text()='Sauce Labs Onesie']")
	private WebElement prodname1;

	@FindBy(id="add-to-cart")
	private WebElement AddtocartBtn;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement cartIcon;
	
	
	public WebElement getCartBtn() {
		return AddtocartBtn;
	}


	public WebElement getCartIcon() {
		return cartIcon;
	}


	public WebElement getProdname() {
		return prodname;
	}

}
