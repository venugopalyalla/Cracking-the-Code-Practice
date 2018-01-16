class Animal1 {
	static int move() {
		System.out.println("Returning 5 from super");
		return 5;
	}
}
class Dog1 extends Animal1 {
/*	int move() {
		System.out.println("Returning 3 from sub");
		return 3;
	}
*/	int moveNew() {
		System.out.println("Returning 3 from sub");
		return 3;
	}
}
public class InhTest {

	public static void main(String[] args) {
		Dog1 d = new Dog1();
		d.move();
	}
}
