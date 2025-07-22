import java.util.Arrays;
import java.util.Scanner;

public class CodeForces149A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String[] nums = sc.nextLine().split(" ");
        int i=0;
        int[] arr = new int[12];
        for(String num : nums){
            arr[i++] = Integer.parseInt(num);
        }

        System.out.println(businessTrip(arr, k));
    }
    static int businessTrip(int[] arr, int k){
        Arrays.sort(arr);
        int i=11, height=0, count=0;
        while(i>=0 && height<k){
            height += arr[i];
            count++;
            i--;
        }
        if(height>=k){
            return count;
        }
        return -1;
    }
}
