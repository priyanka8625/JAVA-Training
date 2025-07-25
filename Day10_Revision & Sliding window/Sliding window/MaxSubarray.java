import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSubarray {
    static void findSubArraySum(int[] arr, int target){
        int n = arr.length, left=0, right=0, sum=0, start=-1, end=-1, maxSum=0, length=0;

        while(right<n){
            sum += arr[right];

            while(left<=right && sum >= target){
                sum -= arr[left++];
            }
            if(sum < target && (sum >= maxSum && (right-left+1) > (end-start+1))){
                maxSum = sum;
                start = left;
                end = right;
            }
            right++;
        }
        System.out.println("Max Sum < target : "+maxSum);
        System.out.println("Length of subarray: "+(end-start+1));
        System.out.println("subarray:");
        for(int i=start; i<=end; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int[] arr = new int[nums.length];
        int i=0;
        for(String str : nums){
            arr[i++] = Integer.parseInt(str);
        }

        int target = sc.nextInt();
        findSubArraySum(arr, target);
    }
}
