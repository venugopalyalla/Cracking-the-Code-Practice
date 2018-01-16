import java.util.NoSuchElementException;

class QueueNode {
	int data;
	QueueNode next;
	QueueNode(int data) {
		this.data = data;
		this.next = null;
	}
}
public class MyQueue {
	QueueNode first, last;
	void add(int i) {
		QueueNode node = new QueueNode(i);
		if(last != null) {
			last.next = node;
		}
		last = node;
		if(first == null) {
			first = last;
		}
	}
	int remove() {
		if(first == null) throw new NoSuchElementException();
		int v = first.data;
		first = first.next;
		if(first == null) {
			last = null;
		}
		return v;
	}
	int peek() {
		if(first==null) throw new NoSuchElementException();
		return first.data;
	}
}
