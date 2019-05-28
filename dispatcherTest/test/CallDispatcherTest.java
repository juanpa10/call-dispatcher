package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import callCenter.Dispatcher;

public class CallDispatcherTest {

	@Test
	public void test() {
		int numOperator = 4;
		int numSuperviser = 1;
		int numDirectors = 1;
		int numCalls =10;
		assertEquals("Numero de llamadas antendidas es em mismo numero de llamadas", 
				numCalls,  Dispatcher.dispatchCall(numOperator, numSuperviser, numDirectors, numCalls));
		
	}

}
