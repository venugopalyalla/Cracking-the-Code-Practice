import java.util.Stack;

class ValAndMin {
	int val;
	int min;
	ValAndMin next;
	ValAndMin(int val, int min) {
		this.val = val;
		this.min = min;
	}
}
class StackMet {
	ValAndMin top;
	void push(int i) {
		ValAndMin curr = null;
		if(top == null) {
			curr = new ValAndMin(i,i);
		} else {
			if(i<top.min) {
				curr = new ValAndMin(i,i);
			} else {
				curr = new ValAndMin(i,top.min);
			}
			curr.next = top;
		}
		top = curr;
	}
	void pop() {
		if(top != null) {
			top = top.next;			
		}
	}
	int peek() {
		return top != null? top.val : 0;
	}
	int min() {
		return top.min;
	}
}
public class StackWithMin extends Stack<Integer>{

	Stack<Integer> s2;
	StackWithMin() {
		s2 = new Stack<Integer>();
	}
	void push(int i) {
		if(i <= min()) {
			s2.push(i);
		}
		super.push(i);
	}
	public Integer pop() {
		int value = super.pop();
		if(value == min()) {
			s2.pop();
		}
		return value;
	}
	int min() {
		if(s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
	public static void main(String[] args) {
		StackMet sm = new StackMet();
		sm.push(3);
		sm.push(1);
		sm.push(0);
		System.out.println(sm.min());
		sm.pop();
		System.out.println(sm.min());
		
		
		StackWithMin num_stack = new StackWithMin();
		num_stack.push(5);
		num_stack.push(3);
		num_stack.push(2);
		System.out.println(num_stack.min());
	}
}
