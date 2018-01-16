
public class NewSyncTest {

	public synchronized void methodA(int i, String msg) {
		System.out.println(i);
		System.out.println(msg);
	}
	public void methodB(int i, String msg) {
		synchronized(this) {
			System.out.println(i);
			System.out.println(msg);
		}
	}
	public static void main(String[] args) {
		NewSyncTest threadA = new NewSyncTest();
		threadA.methodA(5, "Method A");
		threadA.methodB(5, "Method B");
	}

}
