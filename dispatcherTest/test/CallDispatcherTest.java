package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import callCenter.Dispatcher;

/**
 * clase que hace las pruebas unitarias de acuerdo a lo pedido en la prueba
 * @author Juan Pablo Camacho
 *
 */
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
