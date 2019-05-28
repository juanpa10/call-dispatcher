package callCenter;

import java.util.Random;

public class CallThread extends Thread {
	private Thread t;

	private String threadName;
	
	private int callNum;
	
	private Employee emp;

	CallThread (int numCall, Employee nEmp ) {
		emp = nEmp;
		callNum = numCall;
		threadName = nEmp.getName();
	}

	public void run() {
		try {
			Random r = new Random();
			int callTime = r.nextInt((10 - 5) + 1) + 5;
			System.out.println(threadName + " took call # " + callNum  +" for " +callTime+ " seconds");
			Thread.sleep(callTime*1000);
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println(threadName + " Ended call ");
		emp.setFree(true);
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}