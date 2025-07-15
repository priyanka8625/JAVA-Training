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
        int n1 = square % 100;//last two digits
        square /= 100;
        int n2 = square % 100;
        
        if(n1 + n2 == n)
            return true;
        return false;
    }
}
