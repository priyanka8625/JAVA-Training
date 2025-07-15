import java.util.Scanner;

public class Disarium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isDisarium(n)? "Disarium" : "Not Disarium");
        sc.close();
    }
    static boolean isDisarium(int n){
        int sum = 0, temp=n, len=length(n);
        
        while(temp>0){
            int digit = temp % 10;
            sum += (int) Math.pow(digit, len);
            len--;
            temp /= 10;
        }
        if(sum == n){
            return true;
        }
        return false;
    }   
    static int length(int n){
        int temp = n, len=0;
        while(temp>0){
            temp/=10;
            len++;
        }
        return len;
    }
}
