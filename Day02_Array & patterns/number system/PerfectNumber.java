import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isPerfect(n)? "Perfect" : "Not Perfect");
        sc.close();
    }
    static boolean isPerfect(int n){
        // a perfect number is a number whose sum after adding all of it's divisors gives the same original number
        int sum = 0;
        for(int i=1; i<=n/2; i++){
            if(n%i == 0){
                sum += i;
            }
        }
        if(sum == n){
            return true;
        }
        return false;
    }
}
