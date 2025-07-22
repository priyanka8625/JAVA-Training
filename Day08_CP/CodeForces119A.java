import java.util.Scanner;

public class CodeForces119A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(solve(a, b, n));
    }
    static int solve(int a, int b, int n){
        int player=0;//first simon
        while(n>0){
            int stones=0;
            if(player==0){
                stones = gcd(a, n);
                player = 1;
            }else{
                stones = gcd(b, n);
                player = 0;
            }
            n -= stones;
        }
        return player==0? 1 : 0;
    }
    static int gcd(int a, int b){
        if(a==0)
            return b;
        if(b==0)
            return a;
        
        int max=0;
        for(int i=1; i<=Math.min(a, b); i++){
            if(a%i == 0 && b%i == 0){
                max = Math.max(max, i);
            }
        }
        return max;
    }
}
