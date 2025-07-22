import java.util.Scanner;

public class CodeForces236A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.println(boyOrGirl(userName));
    }
    static String boyOrGirl(String userName){
        int[] freq = new int[26];
        for(int i=0; i<userName.length(); i++){
            char ch = userName.charAt(i);
            freq[ch-'a']++;
        }
        int count=0;
        for(int i=0; i<26; i++){
            if(freq[i]>0){
                count++;
            }
        }
        return count%2==0 ? "CHAT WITH HER!" : "IGNORE HIM!";
    }
}
