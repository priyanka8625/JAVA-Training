import java.util.*;

public class FindNthLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] eles = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> arr = new ArrayList<>();
        for(String s : eles){
            arr.add(Integer.parseInt(s));
        }
        System.out.println(n+"th largest at : "+find(arr, n));
        sc.close();
    }
    static int find(List<Integer> arr, int n){
        int size = arr.size();
        if(n>size)
            return -1;

        List<Integer> moreCount = new ArrayList<>(size);
        
        for(int i=0; i<size; i++){
            //count how many nos are greater than the curr element
            int count = 0;
            for(int j=0; j<size; j++){
                if(arr.get(j)>arr.get(i)){
                    count++;
                }
            } 
            moreCount.add(i, count);
        }
        //find the index where the less no count is == n
        for(int i=0; i<size; i++){
            if(moreCount.get(i) == n-1){
                return i;
            }
        }
        return -1;
    }
}
