import java.util.ArrayList;
import java.util.LinkedList;

class ResultAnc {
	public TreeNode node;
	public boolean isAncestor;
	public ResultAnc(TreeNode n, boolean isAnc) {
		node = n;
		isAncestor = isAnc;
	}
}
class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
public class MinimalBSTFromArr {
	static TreeNode createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length-1);
	}
	static TreeNode createMinimalBST(int[] array,int start, int end) {
		if(end < start) {
			return null;
		}
		int mid = (start+end)/2;
		TreeNode n = new TreeNode(array[mid]);
		n.left = createMinimalBST(array,start,mid-1);
		n.right = createMinimalBST(array, mid+1, end);
		return n;
	}

	static void createLevelLinkedLists(TreeNode node, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if(node == null) {
			return;
		}
		LinkedList<TreeNode> list;
		if(lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(node);
		createLevelLinkedLists(node.right, lists, level+1);
		createLevelLinkedLists(node.left, lists, level+1);
	}
	static ArrayList<LinkedList<TreeNode>> createLevelLinkedLists(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedLists(root, lists, 0);
		return lists;
	}
	static int checkHeight(TreeNode node) {
		if(node == null) return -1;
		int leftHeight = checkHeight(node.left);
		if(leftHeight == Integer.MIN_VALUE) return leftHeight;
		int rightHeight = checkHeight(node.right);
		if(rightHeight == Integer.MIN_VALUE) return rightHeight;
		int hDiff = leftHeight-rightHeight;
		if(Math.abs(hDiff)>1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	static boolean isBalancedTree(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	static ArrayList<LinkedList<TreeNode>> createLevelListsBFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null) {
			current.add(root);
		}
		while(current.size()>0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode parent:parents) {
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
	static void inOrderTraversal(TreeNode node) {
		if(node == null) return;
		System.out.println(node.val);
		inOrderTraversal(node.left);
		inOrderTraversal(node.right);
	}
	static ResultAnc commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return new ResultAnc(null,false);
		if(root == p && root == q) {
			return new ResultAnc(root,true);
		}
		ResultAnc rx = commonAncestorHelper(root.left,p,q);
		if(rx.isAncestor) {
			return rx;
		}
		ResultAnc ry = commonAncestorHelper(root.right,p,q);
		if(ry.isAncestor) {
			return ry;
		}
		if(rx.node != null && ry.node != null) {
			return new ResultAnc(root,true);
		} else if(root == p || root == q) {
			boolean isAncestor = rx.node != null || ry.node != null;
			return new ResultAnc(root,isAncestor);
		} else {
			return new ResultAnc(rx.node != null? rx.node : ry.node, false);
		}
	}
	static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		ResultAnc r = commonAncestorHelper(root,p,q);
		if(r.isAncestor) {
			return r.node;
		}
		return null;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		TreeNode res = createMinimalBST(a);
		//inOrderTraversal(res);
		TreeNode p = res.left.left;
		TreeNode q = res.left.right;
		TreeNode r = commonAncestor(res,p,q);
		System.out.println(r.val);
		ArrayList<LinkedList<TreeNode>> resLists = createLevelLinkedLists(res);
	}
}
