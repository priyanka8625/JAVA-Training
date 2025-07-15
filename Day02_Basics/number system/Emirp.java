import java.util.Scanner;

public class Emirp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isEmirp(n)? "Emirp" : "Not Emirp");
        sc.close();
    }
    static boolean isEmirp(int n){
        if(!isPrime(n)){
            return false;
        }
        int rev = 0, temp=n;
        while(temp>0){
            int digit = temp%10;
            rev = rev*10 + digit;
            temp/= 10;
        }
        if(isPrime(rev))
            return true;
        return false;
    }
    static boolean isPrime(int n){
        for(int i=2; i<=n/2; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
