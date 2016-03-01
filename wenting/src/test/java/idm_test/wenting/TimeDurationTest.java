package idm_test.wenting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeDurationTest {
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testTimeDuration() throws BadBadValueException {
		assertEquals(0, new TimeDuration(0).getSeconds());
		assertEquals(732, new TimeDuration(732).getSeconds());
		assertEquals(7242, new TimeDuration(7242).getSeconds());
	}
	@Test
	public void testToString() throws BadBadValueException {
		TimeDuration t1 = new TimeDuration(0);
		assertEquals("0s", t1.toString());
		TimeDuration t2 = new TimeDuration(732);
		assertEquals("12m 12s", t2.toString());
		TimeDuration t3 = new TimeDuration(7242);
		assertEquals("2h 0m 42s", t3.toString());
	}

}
