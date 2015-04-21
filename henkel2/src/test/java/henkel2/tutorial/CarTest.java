package henkel2.tutorial;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class CarTest {
	@Mock
	private Engine engine;
	
	@InjectMocks
	private Car car;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testWarning(){
		when(engine.getRpm()).thenReturn(6000);
		car.accelerate();
		assertEquals("Slow Down!!!",car.getWarningMessage());
		System.out.println("First Test and first Checking...");
	}
	

}
