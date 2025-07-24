import java.util.HashMap;
import java.util.Scanner;

public class Leetcode03 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int left=0, right=0, n = s.length(), length=0;
        while(right<n){
            char ch = s.charAt(right);
            //increase it's freq
            if(freq.containsKey(ch)){
                freq.put(ch, freq.get(ch)+1);
            }else{
                freq.put(ch, 1);
            }

            while(left<right && freq.get(ch)>1){
                freq.put(s.charAt(left), freq.get(s.charAt(left))-1);
                left++;
            }

            length = Math.max(length, right-left+1);
            right++;
        }
        return length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Leetcode03 obj = new Leetcode03();
        System.out.println(obj.lengthOfLongestSubstring(str));
    }
}
