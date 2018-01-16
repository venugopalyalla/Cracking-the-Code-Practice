
class StackNode {
	int data;
	StackNode next;

	StackNode(int i) {
		data = i;
		next = null;
	}
}

class StackFun {

	StackNode top;

	void push(int i) {
		StackNode n = new StackNode(i);
		n.next = top;
		top = n;
	}

	boolean isEmpty() {
		return top==null;
	}
	int pop() {
		int v = top != null? top.data : -1;
		if(top != null) {
			top = top.next;			
		}
		return v;
	}

	int peek() {
		return (top!=null? top.data : 0);
	}
}

public class StackImpl {
	public static void main(String[] args) {
		StackFun stack = new StackFun();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.pop();
		System.out.println(stack.peek());
	}
}