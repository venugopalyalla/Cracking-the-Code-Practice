import java.util.Stack;

public class SortStacks {

	static Stack<Integer> sortStack2(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		while(!r.isEmpty()) {
			s.push(r.pop());
		}
		return s;
	}
	static void sortedInsert(Stack<Integer> s, int x) {
		if(s.isEmpty() || x > s.peek()) {
			s.push(x);
			return;
		}
		int temp = s.pop();
		sortedInsert(s,x);
		s.push(temp);
	}
	static void sortStackWithoutStack(Stack<Integer> s) {
		if(!s.isEmpty()) {
			int x = s.pop();
			sortStackWithoutStack(s);
			System.out.println("Calling sortedInsert for " + x);
			sortedInsert(s,x);
		}
	}
	public static void main(String[] args) {
		Stack<Integer> unsorted = new Stack<Integer>();
		unsorted.push(3);
		unsorted.push(2);
		unsorted.push(5);
		unsorted.push(1);
		unsorted.push(8);
 		unsorted.push(6);
		unsorted.push(9);
		unsorted.push(7);

		Stack<Integer> sorted = sortStack2(unsorted);
		while(!sorted.isEmpty()) {
			System.out.println(sorted.pop());
		}
/*		sortStackWithoutStack(unsorted);
		while(!unsorted.isEmpty()) {
			System.out.println(unsorted.pop());
		}
*/	}
}
