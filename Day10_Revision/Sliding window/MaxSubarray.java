import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSubarray {
    static void findSubArraySum(int[] arr, int target){
        int n = arr.length, left=0, right=0, sum=0, length=0, maxSum=0;

        while(right<n){
            sum += arr[right];

            while(left<right && sum >= target){
                sum -= arr[left++];
            }
            if(sum > maxSum){
                maxSum = Math.max(sum, maxSum);
                length = right-left+1;
            }
            right++;
        }
        System.out.println("Max Sum < target : "+maxSum);
        System.out.println("Length of subarray: "+length);
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
