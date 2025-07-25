import java.util.Arrays;

public class Leetcode746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return solve(n, dp, cost);
    }
    int solve(int n, int[] dp, int[] cost){
        if(n <= 1)
            return dp[n] = 0;
        
        if(dp[n] != Integer.MAX_VALUE)
            return dp[n];

        int one = cost[n-1] + solve(n-1, dp, cost);
        int two = cost[n-2] + solve(n-2, dp, cost);
        
        return dp[n] = Math.min(dp[n], Math.min(one, two));
    }
}
