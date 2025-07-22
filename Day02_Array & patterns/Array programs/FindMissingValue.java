import java.util.Scanner;
public class FindMissingValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        String[] nums = sc.nextLine().split(" ");
        
        int i=0;
        for(String num : nums){
            arr[i] = Integer.parseInt(num);
            i++;
        }

        System.out.println("missing: "+find(arr, n+1));
        sc.close();
    }
    static int find(int[] arr, int n){
        int sum = 0, expSum = (n*(n+1))/2;
        for(int i=0; i<n-1; i++){
            sum += arr[i];
        }
        return expSum-sum;
    }
    
}
