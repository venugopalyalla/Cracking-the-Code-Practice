class CounterThread extends Thread {

	public void run() {
		synchronized(this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}			
		}
	}
}

public class Example {

	public static void main(String[] args) {
		Thread threadA = new CounterThread();
		Thread threadB = new CounterThread();

		threadA.start();
		threadB.start();
	}
}