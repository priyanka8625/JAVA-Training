import java.util.Scanner;

public class NPattern {
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
                if(j==1 || i==j || j==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
