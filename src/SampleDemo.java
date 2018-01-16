
class SampleR implements Runnable {

	private Thread t;
	private String threadName;
	SampleR(String threadName) {
		this.threadName = threadName;
	}
	public void run() {
		int i = 0;
		synchronized(this) {
			while(i < 100) {
				System.out.println(threadName);
				i++;
			}			
		}
	}
	public void start() {
		if(t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
public class SampleDemo {
	public static void main(String[] args) {
		SampleR A = new SampleR("A");
		SampleR B = new SampleR("B");
		B.start();
		A.start();
	}
}
