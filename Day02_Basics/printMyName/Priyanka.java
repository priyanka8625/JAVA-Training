
import java.util.Scanner;

public class Priyanka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = Integer.parseInt(sc.nextLine());
        print(n);
        sc.close();
    }
    static void print(int n){
        for(int i=1; i<=n; i++){
            printP(n, i);
            System.out.print("  ");
            printR(n, i);
            System.out.print("  ");
            printI(n, i);
            System.out.print("  ");
            printY(n, i);
            System.out.print("  ");
            printA(n, i);
            System.out.print("  ");
            printN(n, i);
            System.out.print("  ");
            printK(n, i);
            System.out.print("  ");
            printA(n, i);
            
            System.out.println();
        }
    }
    static void printP(int n, int i){
            for(int j=1; j<=n; j++){
                if(j==1 || i==1 || i==(n/2+1) || (j==n && i<(n/2+1))){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
    }
    static void printR(int n, int i){
            for(int j=1; j<=n; j++){
                if(i==1 || i==n/2+1 || j==1 || (i==j && i>(n/2+1)) || (j==n && i<(n/2+1)) ){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
    }
    static void printI(int n, int i){
            for(int j=1; j<=n; j++){
                if(i==1 || i==n || j==(n/2)+1 ){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
    }
    static void printY(int n, int i){
            for(int j=1; j<=n; j++){
                if((j==(n/2+1) && i>=(n/2+1)) || (i==j && i<(n/2+1)) || (i+j==n+1 && i<(n/2+1))){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
    }
    static void printA(int n, int i){
            for(int j=1; j<=n; j++){
                if(i==1 || i==(n/2+1) || j==1 || j==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
    }
    static void printN(int n, int i){
            for(int j=1; j<=n; j++){
                if(j==1 || i==j || j==n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
    }
    static void printK(int n, int i){
            for(int j=1; j<=n; j++){
                if(j==1 || (i%2==0 && j==2) || (i%2==1 && j==3 && i!=j) ){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
    }
}
