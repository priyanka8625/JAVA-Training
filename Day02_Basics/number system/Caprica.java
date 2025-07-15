import java.util.Scanner;

public class Caprica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isCaprica(n)? "Caprica" : "Not Caprica");
        sc.close();
    }
    static boolean isCaprica(int n){
        int len = 0, square = n*n, temp = square;
        while(square>0){
            len++;
            square /= 10;
        }

        if(len%2 == 1)
            return false;
            
        square = temp;
        int half = len/2, n1=0, n2=0;
        
        while(half-- > 0){
            int digit = square%10;
            n2 = n2*10 + digit;
            square /= 10;
        }
        
        half = len/2;
        while(half-- > 0){
            int digit = square%10;
            n1 =  n1*10 + digit;
            square /= 10;
        }
        if(n1 + n2 == n)
            return true;
        return false;
    }
}
