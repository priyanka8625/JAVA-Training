import java.util.Scanner;

public class ToLowerCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(strToLowerCase(name));
        sc.close();
    }
    static String strToLowerCase(String name){
        String res = "";
        for(int i=0; i<name.length(); i++){
            char ch  = name.charAt(i);
            if(ch>='A' && ch<='Z'){
                ch = (char)('a' + (ch-'A'));
            }
            res += ch;
        }
        return res;
    }
}
