import java.util.Scanner;

public class Niven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isNiven(n)? "Niven" : "Not Niven");
        sc.close();
    }
    static boolean isNiven(int n){
        // a spy number is the one whose sum of factorial of all the digits gives the original number
        int sum = 0, temp=n;
        while(n>0){
            int digit = n%10;
            sum += digit;
            n/=10;
        }
        if(temp%sum == 0){
            return true;
        }
        return false;
    }
}
