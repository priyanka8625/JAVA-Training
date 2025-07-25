import java.util.Arrays;

public class Leetcode198{
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, 0, n, dp);
    }
    int solve(int[] nums, int i, int n, int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i] != -1)
            return dp[i];

        return dp[i] = Math.max(solve(nums, i+1, n, dp), nums[i]+solve(nums, i+2, n, dp));
    }
}