import java.util.Scanner;

public class Kapreker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isKapreker(n)? "Kapreker" : "Not Kapreker");
        sc.close();
    }
    static boolean isKapreker(int n){
        int len = 0, square = n*n, temp = square;
        while(square>0){
            len++;
            square /= 10;
        }

        if(len%2 == 1)
            return false;
            
        int divisor = (int) Math.pow(10, len/2);
        int left = temp / divisor;
        int right = temp % divisor;
        
        if(left + right == n)
            return true;
        return false;
    }
}
