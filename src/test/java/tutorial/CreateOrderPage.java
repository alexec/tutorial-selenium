
package tutorial;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrderPage {
	public static boolean isAtCreateOrderPage(WebDriver drv, URI siteBase) {
		return drv.getCurrentUrl().equals(siteBase.toString() + "create-order.jsp");
	}

	private final WebDriver drv;
	private final URI siteBase;

	@FindBy(css = "form[name='create-order'] input[name='item']")
	private WebElement itemInput;

	@FindBy(css = "form[name='create-order'] input[name='amount']")
	private WebElement amountInput;

	@FindBy(css = "form[name='create-order'] input[type='submit']")
	private WebElement submit;

	public CreateOrderPage(WebDriver drv, URI siteBase) {
		if (!isAtCreateOrderPage(drv, siteBase)) { throw new IllegalStateException(); }
		PageFactory.initElements(drv, this);
		this.drv = drv;
		this.siteBase = siteBase;
	}
	
	public CreateOrderPage submit(String item, String amount) {
		itemInput.sendKeys(item);
		amountInput.sendKeys(amount);
		submit.click();
		return new CreateOrderPage(drv, siteBase);
	}
}
