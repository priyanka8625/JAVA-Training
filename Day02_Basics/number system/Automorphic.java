import java.util.Scanner;

public class Automorphic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isAutomorphic(n)? "Automorphic" : "Not Automorphic");
        sc.close();
    }
    static boolean isAutomorphic(int n){
        // an automorphic number is the one whose sqaure contains the original number at last (ends with org no)
        int square = 0;
        square = n*n;
        while(n>0){
            int digit = n%10;
            int digit2 = square%10;
            if(digit != digit2)
                return false;
            square /= 10;
            n/=10;
        }
        return true;
    }
}
