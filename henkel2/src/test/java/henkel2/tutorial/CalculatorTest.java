package henkel2.tutorial;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CalculatorTest {
	@Mock
	Calculator cal;
	
	@Mock
	private Engine engine;
	
	@InjectMocks
	private Car car;
	
	@Before
	public void setUp(){
		
		// cal = new Calculator();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAbs(){
		
		
		//int expected = 4;
		//int actual = cal.abs(4);
		//assertEquals(expected, actual);
		when(cal.abs(-20)).thenReturn(20);
		assertEquals(20, cal.abs(-20));
	}
	
	public void testWarning(){
		when(engine.getRpm()).thenReturn(6000);
		car.accelerate();
		assertEquals(car.getWarningMessage(),"Slow Down!!!");
	}

}
