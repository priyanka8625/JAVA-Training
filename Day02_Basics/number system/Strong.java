import java.util.Scanner;

public class Strong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isStrong(n)? "Strong" : "Not Strong");
        sc.close();
    }
    static boolean isStrong(int n){
        // a spy number is the one whose sum of factorial of all the digits gives the original number
        int sum = 0, temp=n;
        while(n>0){
            int digit = n%10;
            sum += fact(digit);
            n/=10;
        }
        if(temp == sum){
            return true;
        }
        return false;
    }
    static int fact(int n ){
        if(n==1){
            return n;
        }
        return n*fact(n-1);
    }
}
