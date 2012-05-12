package tutorial;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	/**
	 * @param drv
	 *            A web driver.
	 * @param siteBase
	 *            The root URI of a the expected site.
	 * @return Whether or not the driver is at the index page of the site.
	 */
	public static boolean isAtIndexPage(WebDriver drv, URI siteBase) {
		return drv.getCurrentUrl().equals(siteBase.toString());
	}

	private final WebDriver drv;
	private final URI siteBase;

	@FindBy(css = "a[href='create-order.jsp']")
	private WebElement createOrderLink;

	public IndexPage(WebDriver drv, URI siteBase) {
		if (!isAtIndexPage(drv, siteBase)) { throw new IllegalStateException(); }
		PageFactory.initElements(drv, this);
		this.drv = drv;
		this.siteBase = siteBase;
	}

	public CreateOrderPage createOrder() {
		createOrderLink.click();
		return new CreateOrderPage(drv, siteBase);
	}
}
