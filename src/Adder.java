abstract class Arithmetic {
	public String getName() {
		return "Arithmetic";
	}
}

public class Adder extends Arithmetic {
	static int add(int a, int b) {
		return a + b;
	}
	public static void main(String[] args) {
		System.out.println(add(5,10));
	}
}