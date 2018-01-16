
public class QueueWithStacks {

	StackFun stack1 = new StackFun();
	StackFun stack2 = new StackFun();
	void add(int i) {
		stack1.push(i);
	}
	int remove() {
		shiftStacks();
		return stack2.pop();
	}
	int peek() {
		shiftStacks();
		return stack2.peek();
	}
	boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	void shiftStacks() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	}
	public static void main(String[] args) {
		QueueWithStacks queue = new QueueWithStacks();
		queue.add(5);
		queue.add(4);
		queue.add(3);
		queue.add(2);
		queue.add(1);
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
	}
}
