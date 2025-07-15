import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        String[] nums = sc.nextLine().split(" ");
        sc.close();
        
        int i=0;
        for(String num : nums){
            arr[i] = Integer.parseInt(num);
            i++;
        }
        int target = Integer.parseInt(sc.nextLine());

        List<Integer> ans = new ArrayList<>();
        find(arr, ans, 0, target, n);

        if(ans.size()== 0)
            System.out.println("Not found! ");

        for(i=0; i<ans.size(); i++)
            System.out.print(ans.get(i)+" ");

    }
    static boolean find(int[] arr, List<Integer> ans, int index, int target, int n ){
        if(index==n){
            return false;
        }
        if(target == 0){
            return true;
        }
        if(target < 0){
            return false;
        }

        //include curr element
        ans.add(arr[index]);
        if(find(arr, ans, index+1, target-arr[index], n))
            return true;
        //not include
        ans.removeLast();
        if(find(arr, ans, index+1, target, n))
            return true;

        return false;
    }
}
