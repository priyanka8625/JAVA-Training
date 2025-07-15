import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FreqArray {
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

        find(arr, n);
        sc.close();
    }
    static void find(int[] arr, int n){
        Map<Integer, Integer> ans = new HashMap<>();

        for(int i=0; i<n; i++){
            if(ans.containsKey(arr[i])){
                ans.put(arr[i], ans.get(arr[i])+1);
            }else{
                ans.put(arr[i], 1);
            }
        }

        for( int key : ans.keySet()){
            System.out.println(key + " : " + ans.get(key));
        }
    }
}
