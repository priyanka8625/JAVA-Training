import java.util.Scanner;

public class CodeForces141A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String guest = sc.nextLine();
        String host = sc.nextLine();
        String pile = sc.nextLine();
        System.out.println(amusingJoke(guest, host, pile));
    }
    static String amusingJoke(String guest, String host, String piles){
        int[] freq = new int[26];
        for(int i=0; i<guest.length(); i++){
            char ch = guest.charAt(i);
            freq[ch-'A']++;
        }
        for(int i=0; i<host.length(); i++){
            char ch = host.charAt(i);
            freq[ch-'A']++;
        }

        for(int i=0; i<piles.length(); i++){
            char ch = piles.charAt(i);
            freq[ch-'A']--;
        }
        
        for(int i=0; i<26; i++){
            if(freq[i]!=0){
                return "NO";
            }
        }

        return "YES";
    }
}
