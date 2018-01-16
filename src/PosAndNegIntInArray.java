import java.util.HashMap;
import java.util.Map;

public class PosAndNegIntInArray {
    static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey()*(-1))) {
                    count++;
                    System.out.print(entry.getKey());
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
    	int[] a = {1,6,3,8,13,5,-1};
    	System.out.println(findPairs(a,2));
    }
}