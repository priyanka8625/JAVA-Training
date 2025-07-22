import java.util.Scanner;

public class CodeForces118A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.print(process(word));

        sc.close();
    }
    static String process(String word){
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(isVowel(ch)){
                continue;
            }
            ans.append(".");
            if(isUpper(ch)){
                ch = (char) ((ch-'A')+'a');
            }
            ans.append(ch);
        }
        return ans.toString();
    }
    static boolean isVowel(char ch){
        return ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'
                || ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='y' || ch=='Y';
    }
    static boolean isUpper(char ch){
        return ch>='A' && ch<='Z';
    }
}
