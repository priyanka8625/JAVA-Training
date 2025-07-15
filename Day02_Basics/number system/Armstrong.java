import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isArmstrong(n)? "Armstrong" : "Not Armstrong");
        sc.close();
    }
    static boolean isArmstrong(int n){
        int ans = 0, temp=n, len=0;
        while(n>0){
            len++;
            n /= 10;
        }
        n = temp;
        while(n>0){
            int digit = n%10;
            digit = (int)Math.pow(digit, len);
            ans += digit;
            n/=10;
        }
        if(ans == temp){
            return true;
        }
        return false;
    }
}
