package callCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que se encarga de la lógica de atender llamadas.
 * @author Juan Pablo Camacho
 *
 */
public class Dispatcher {
	
	private static List<Employee> employeeList;
	
	private static int numOpertators = 3;
	private static int numSuperviser = 1;
	private static int numDirector = 1;
	private static int numCalls = 10;
	
	/**
	 * Metodo main, no se usa, se prueba mediante las prubas unitarias.
	 */
	public static void main(String[] args) {
		dispatchCall(numOpertators,numSuperviser,numDirector,numCalls);

	}
	
	/**
	 * Método que atiende las llamadas, crea la lista de empleados que llegan por parametro y procesa el
	 * número de llamadas que también llega por parametro
	 * @param numOpertators número de empleados tipo operador
	 * @param numSuperviser número de empleados tipo supervisor
	 * @param numDirector número de empleados tipo director
	 * @param numCalls numero de llamadas que serán atendidas
	 * @return
	 */
	public static int dispatchCall(int numOpertators, int numSuperviser, int numDirector,int numCalls) {
		int atendedCall = 0;
		employeeList = new ArrayList<Employee>();
		for(int i=0; i<numOpertators; i++){
			Employee employee = new Employee("Operator", true, "Operator "+(i +1) );
			employeeList.add(employee);
		}
		for(int i=0; i<numSuperviser; i++){
			Employee employee = new Employee("Superviser", true, "Superviser "+ (i +1) );
			employeeList.add(employee);
		}
		for(int i=0; i<numDirector; i++){
			Employee employee = new Employee("Director", true, "Director "+ (i +1) );
			employeeList.add(employee);
		}
		while(atendedCall < numCalls){
			atendedCall = atendCall(atendedCall);
		}
		return atendedCall;
	}
	
	/**
	 * busca los empleados que estan disponibles para que atienda las llamadas
	 * @param antCall numero de llamadas atendidas, este numero va incrementando a medida que se atiende las llamadas
	 * @return numero de llamadas atendidas
	 */
	public static int atendCall(int antCall) {
		int atendedCalls = antCall;
		for(int i=0; i<numCalls; i++){
			Employee emp = getFreeEmployee();
			if(emp !=null){
				CallThread myThread = new CallThread(i, emp);
				myThread.start();
				emp.setFree(false);
				atendedCalls++;
			}
			else {
				//System.out.println("all employees busy "+ i);
			}
		}
		if(atendedCalls > antCall){ System.out.println("atendedCall: "+antCall);}
		return atendedCalls;
	}
	/**
	 * obtiene empleado libre
	 * @return
	 */
	public static Employee getFreeEmployee() {
		Employee retEmp = null;
		boolean found = false;
		for(int i=0; i<employeeList.size() && !found; i++){
			Employee emp = employeeList.get(i);
			if(emp.isFree()){
				retEmp = emp;
				found = true;
			}
		}
		return retEmp;
	}
	

}
