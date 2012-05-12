package tutorial;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreateOrderPageIT extends AbstractIT {

	@Test
	public void testSubmit() {
		new IndexPage(getDrv(), getSiteBase()).createOrder().submit("foo", "");
	}

}
