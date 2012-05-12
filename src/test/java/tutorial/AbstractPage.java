package tutorial;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	public static boolean isErrorPage(WebDriver drv) {
		return drv.getPageSource().contains("<!-- SERVER_INTERNAL_ERROR -->");
	}
}
