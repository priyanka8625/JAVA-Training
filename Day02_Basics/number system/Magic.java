import java.util.Scanner;

public class Magic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isMagic(n)? "Magic" : "Not Magic");
        sc.close();
    }
    static boolean isMagic(int n){
        // an automorphic number is the one whose sqaure contains the original number at last (ends with org no)
        if(n==1)
            return true;
        
        int sum = 0, temp=n;
        while(temp > 0){
            sum += (temp%10);
            temp/=10;
        }
        if(sum == n)
            return false;
            
        return isMagic(sum);
    }
}
