import java.util.Scanner;

public class ReverseVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        soln2(number);
    }
    static void soln2(String str){
        int len = str.length();
        
        String vowels = "";
        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(isVowel(ch)){
                vowels += ch;
            }
        }

        vowels = reverse(vowels);

        String res = "";
        int index=0;
        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(isVowel(ch)){
                res += vowels.charAt(index++);
            }else{
                res += ch;
            }
        }

        System.out.println(res);
    }
    static String reverse(String str){
        int start=0, end=str.length()-1;
        String res = "";
        while(start<=end){
            res += str.charAt(end);
            end--;
        }
        return res;
    }
    static boolean isVowel(char ch){
        if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' || 
            ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
}
