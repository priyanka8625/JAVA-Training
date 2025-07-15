import java.util.Scanner;

public class Duck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isDuck(n)? "Duck" : "Not Duck");
        sc.close();
    }
    static boolean isDuck(int n){
        while(n>0){
            int digit = n%10;
            if(digit == 0){
                return true;
            }
            n/=10;
            if(n>=0 && n<=9){
                //n became a single digit number
                break;
            }
        }
        return false;
    }
}
