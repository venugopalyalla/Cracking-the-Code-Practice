import java.util.HashMap;

public class SortWithArray {

	static int[] sortWithArr(int[] a1, int[] a2) {
		int[] res = new int[a1.length];
		int counter = 0;
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i< a1.length; i++) {
			if(map.containsKey(a1[i])) {
				int val = map.get(a1[i]);
				map.put(a1[i], val+1);
			} else {
				map.put(a1[i],1);
			}
		}
		for(int j=0; j<a2.length; j++) {
			if(map.containsKey(a2[j])) {
				int val = map.get(a2[j]);
				for(int k=0; k<val;k++) {
					res[counter] = a2[j];
					counter++;
				}
				map.remove(a2[j]);
			}
		}
		Object[] rem = map.keySet().toArray();
		for(int h=0; h<rem.length; h++) {
			res[counter] = (int) (rem[h]);
			counter++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr1 = {2, 1, 2, 5, 7, 1, 9, 3, 10, 8, 8, 4};
		int[] arr2 = {1,2,8,3,11,0};
		int[] op = sortWithArr(arr1,arr2);
		for(int i=0; i< op.length;i++) {
			System.out.print(op[i] + " ");
		}
	}
}
