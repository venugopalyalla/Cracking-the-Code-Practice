public class Budget {
	static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
        int shopsCount = bundleQuantities.length;
        int budget = n;
        
        int[] dp = new int[budget+1];
        for(int i =0; i<=budget; i++){
            for(int j = 0; j < shopsCount; j++){
                if(bundleCosts[j] <= i){
                    dp[i] = Math.max(dp[i], dp[i-bundleCosts[j]] + bundleQuantities[j]);
                }
            }
        }
        return dp[budget];
    }

	public static void main(String[] args) {
		int[] bq = {1,2,10};
		int[] c = {50,60,70};
		System.out.println(budgetShopping(100,bq,c));
	}
}