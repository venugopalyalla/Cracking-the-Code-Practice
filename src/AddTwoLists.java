import java.util.Stack;

public class AddTwoLists {

	public static void addLists(Node n1, Node n2) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> result = new Stack<Integer>();
		while(n1 != null) {
			stack1.add(n1.data);
			n1 = n1.next;
		}
		while(n2 != null) {
			stack2.add(n2.data);
			n2 = n2.next;
		}
		while(stack1.size()>0 || stack2.size() >0) {
			System.out.println("Stack 1 size : " + stack1.size());
			System.out.println("Stack 2 size : " + stack2.size());
			if(stack1.size()>0 && stack2.size()>0) {
				int val = stack1.pop()+stack2.pop();
				result.push(val);
			} else if(stack1.size() >0) {
				result.push(stack1.pop());
			} else if(stack2.size() >0) {
				result.push(stack2.pop());
			}
		}
		int n= result.size();
		for(int i=0; i<n;i++) {
			System.out.println(result.pop());
		}
	}
	public static void main(String[] args) {
		LinkedListImpl list1 = new LinkedListImpl();
		list1.append(1);
		list1.append(2);
		//list1.append(3);

		LinkedListImpl list2 = new LinkedListImpl();
		list2.append(4);
		list2.append(9);
		list2.append(6);
		
		addLists(list1.head, list2.head);
	}
}
