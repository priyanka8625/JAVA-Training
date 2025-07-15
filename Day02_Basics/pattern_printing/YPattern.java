import java.util.Scanner;
public class YPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = Integer.parseInt(sc.nextLine());
        print(n);
        sc.close();
    }
    static public void print(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if((j==(n/2+1) && i>=(n/2+1)) || (i==j && i<(n/2+1)) || (i+j==n+1 && i<(n/2+1))){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
