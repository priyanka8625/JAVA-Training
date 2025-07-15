import java.util.Scanner;

public class SpyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isSpy(n)? "Spy" : "Not Spy");
        sc.close();
    }
    static boolean isSpy(int n){
        // a perfect number is a number whose sum after adding all of it's divisors gives the same original number
        int sum = 0, prod=1;
        while(n>0){
            int digit = n%10;
            sum += digit;
            prod *= digit;
            n/=10;
        }
        if(sum == prod){
            return true;
        }
        return false;
    }
}
