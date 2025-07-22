import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isPalindrome(n)? "Palindrome" : "Not palindrome");
        sc.close();
    }
    static boolean isPalindrome(int n){
        int ans = 0, temp=n;
        while(n>0){
            int digit = n%10;
            ans = ans*10 + digit;
            n /= 10;
        }
        if(ans == temp){
            return true;
        }
        return false;
    }
}
