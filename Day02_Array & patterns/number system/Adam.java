import java.util.Scanner;

public class Adam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isAdam(n)? "Adam" : "Not Adam");
        sc.close();
    }
    static boolean isAdam(int n){
        int rev = reverse(n);
        int square1 = n*n;
        int square2 = rev*rev;
        int revSquare = reverse(square1);
        if(revSquare == square2)
            return true;
        return false;
    }
    static int reverse(int n){
        int rev = 0;
        while(n>0){
            int digit = n%10;
            rev = rev*10 + digit;
            n /= 10;
        }
        return rev;
    }
}
