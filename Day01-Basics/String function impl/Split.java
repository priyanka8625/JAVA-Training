import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Split {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(count(name));
        sc.close();
    }
    static List<String> count(String name){
        List<String> words = new ArrayList<>();
        for(int i=0; i<name.length();){
            String word = "";
            while(i<name.length() && name.charAt(i) != ' '){
                word += name.charAt(i);
                i++;
            }
            while(i<name.length() && name.charAt(i) == ' '){
                i++;
            }
            words.add(word);
        }
        return words;
    }
}
