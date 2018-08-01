/**
 * 
 */
package unitTesting;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author estuardolh
 *
 */
public class MainTest {
	@Rule
	public Main main = new Main();
	
	@Test
	public void test() {
		Assert.assertEquals(false, Main.metodo());
	}

}
