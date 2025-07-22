import java.util.Scanner;

public class CodeForces151A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();        
        int c = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int nl = sc.nextInt();
        int np = sc.nextInt();

        System.out.println(softDrink(n, k, l, c, d, p, nl, np));
    }
    static int softDrink(int n, int k, int l, int c, int d, int p, int nl, int np){
        int litres = k*l;
        int slices = c*d;
        int toast1 = litres/n;
        int toast2 = slices;
        int toast3 = p/np;
        return Math.min(Math.min(toast1, toast2), toast3)/n;
    }
}
