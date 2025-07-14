import java.util.Scanner;

public class ToUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(strToUpperCase(name));
        sc.close();
    }
    static String strToUpperCase(String name){
        String res = "";
        for(int i=0; i<name.length(); i++){
            char ch  = name.charAt(i);
            if(ch>='a' && ch<='z'){
                ch = (char)('A' + (ch-'a'));
            }
            res += ch;
        }
        return res;
    }
}
