import java.util.Scanner;

public class CodeForces144A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] nums = sc.nextLine().split(" ");
        int i=0;
        int[] arr = new int[n];
        for(String num : nums){
            arr[i++] = Integer.parseInt(num);
        }

        System.out.println(arrange(arr, n));
    }
    static int arrange(int[] arr, int n){
        int count = 0;
        int minIndex = min(arr, n);
        if(minIndex != n-1){
            count += n-1-minIndex;
        }

        int maxIndex = max(arr, n);
        if(maxIndex > minIndex){
            count += maxIndex-1;
        }else{
            count += maxIndex;
        }

        return count;
    }
    static int min(int[] arr, int n){
        int min=Integer.MAX_VALUE, minIndex=-1;
        for(int i=0; i<n; i++){
            if(min>=arr[i]){
                minIndex = i;
                min = arr[i];
            }
        }
        return minIndex;
    }
    static int max(int[] arr, int n){
        int max=Integer.MIN_VALUE, maxIndex=-1;
        for(int i=0; i<n; i++){
            if(max<arr[i]){
                maxIndex = i;
                max = arr[i];
            }
        }
        return maxIndex;
    }
}
