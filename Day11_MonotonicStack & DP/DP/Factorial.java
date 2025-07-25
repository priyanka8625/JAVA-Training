import java.util.Arrays;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(recursiveFact(n));
        System.out.println(memoizationFact(n, dp));
        System.out.println(tabulationFact(n, dp));
        System.out.println(spaceOptimizedFact(n));

        sc.close();
    }
    static int recursiveFact(int n){
        if(n==1)
            return n;

        return n*recursiveFact(n-1);
    }
    static int memoizationFact(int n, int[] dp){
        if(n==1)
            return dp[n] = n;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = n*memoizationFact(n-1, dp);
    }
    static int tabulationFact(int n, int[] dp){
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = i * dp[i-1];
        }
        return dp[n];
    }
    static int spaceOptimizedFact(int n){
        int fact = 1;
        for(int i=2; i<=n; i++){
            fact = fact * i;
        }
        return fact;
    }
}
