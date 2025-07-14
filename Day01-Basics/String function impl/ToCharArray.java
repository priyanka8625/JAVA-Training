import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToCharArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        char [] chars = strToCharArray(name);
        System.out.println(chars);
        sc.close();
    }
    static char[] strToCharArray(String name){
        List<Character> chars = new ArrayList<>();
        for(int i=0; i<name.length(); i++){
            chars.add(name.charAt(i));
        }
        char[] ans = new char[chars.size()];
        int i=0;
        for(char ch : chars){
            ans[i] = ch;
            i++;
        }
        return ans;
    }
}
