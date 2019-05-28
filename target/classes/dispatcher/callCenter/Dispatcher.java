package callCenter;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
	
	private static List<Employee> employeeList;
	
	private static int numOpertators = 3;
	private static int numSuperviser = 1;
	private static int numDirector = 1;
	private static int numCalls = 10;

	public static void main(String[] args) {
		dispatchCall(numOpertators,numSuperviser,numDirector,numCalls);

	}
	
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
