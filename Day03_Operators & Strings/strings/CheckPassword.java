import java.util.Scanner;

public class CheckPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(soln2(str)? "Valid" : "Invalid");
    }
    static boolean soln2(String str){
        if(!(str.length()>=8 && str.length()<=15)){
            return false;
        }
        int count = 0, n=str.length();
        
        count += upper(str)? 1 : 0;
        count += lower(str)? 1 : 0;
        count += digit(str)? 1 : 0;
        count += special(str)? 1 : 0;

        if(count == 4)
            return true;
        return false;
    }
    static boolean upper(String str){
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(isUpper(ch)){
                return true;
            }
        }
        return false;
    }
    static boolean lower(String str){
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(isLower(ch)){
                return true;
            }
        }
        return false;
    }
    static boolean digit(String str){
        for(int i=str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            if(isDigit(ch)){
                return true;
            }else{
                if(!isSpecial(ch)){
                    return false;
                }
            }
        }
        return false;
    }
    static boolean special(String str){
        for(int i=str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            if(isSpecial(ch)){
                return true;
            }else{
                if(!isDigit(ch))
                    return false;
            }
        }
        return false;
    }


    static boolean isUpper(char ch){
        if(ch>='A' && ch<='Z'){
            return true;
        }
        return false;
    }
    static boolean isLower(char ch){
        if(ch>='a' && ch<='z'){
            return true;
        }
        return false;
    }
    static boolean isDigit(char ch){
        if(ch>='0' && ch<='9'){
            return true;
        }
        return false;
    }
    static boolean isSpecial(char ch){
        if(ch=='@'){
            return true;
        }
        return false;
    }


    static boolean soln1(String str){
        if(!(str.length()>=8 && str.length()<=15)){
            return false;
        }
        boolean upper=false, lower=false, digit=false, special=false;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch>='A' && ch<='Z'){
                upper = true;
            }
            if(ch>='a' && ch<='z'){
                lower = true;
            }
            if(ch>='0' && ch<='9'){
                digit = true;
            }
            if(ch == '@'){
                special = true;
            }
        }
        if(upper && lower && digit && special)
            return true;
        return false;
    }
}
