import java.util.Scanner;

public class ZPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = Integer.parseInt(sc.nextLine());
        print(n);
        sc.close();
    }
    static void print(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==1 || i+j==n+1 || i==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
