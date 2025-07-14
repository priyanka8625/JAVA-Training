import java.util.Scanner;

public class ConvertCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(change(name));
        sc.close();
    }
    static String change(String name){
        String res = "";
        for(int i=0; i<name.length(); i++){
            char ch = name.charAt(i);
            if(ch>='A' && ch<='Z'){
                ch = (char)('a'+(ch-'A'));
            }else if(ch>='a' && ch<='z'){
                ch = (char)('A'+(ch-'a')); 
            }
            res += ch;
        }
        return res;
    }
}
