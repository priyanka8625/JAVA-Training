import java.util.Scanner;

public class HealthyDeficient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(isHealthy(n)? "Healthy" : "Deficient");
        sc.close();
    }
    static boolean isHealthy(int n){
        int sum = 0;

        for(int i=1; i<=n/2; i++){
            if(n % i == 0){
                sum += i;
            }
        }
        
        if(sum > n){
            return true;
        }
        return false;
    }   
}
