package other;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.*;
/**Question:
 * Given a string, outputing it in reverse order,  using 3 ways
 *
 */
public class ReverseStrings {
    public static final String INPUT = "abcde";

    public static String reverse(String input){
        LinkedList<Character> temp = new LinkedList <>();
        for(int i = 0; i < input.length(); i++){
            temp.push(input.charAt(i));
        }

        StringBuilder buf = new StringBuilder();
        for(int j = 0; j < input.length(); j++){
            buf.append(temp.pop());
        }

        return buf.toString();
    }

    public static String reverse2(String input){
        //LinkedList<Character> temp = new LinkedList <>();

        StringBuilder buf = new StringBuilder();

        for(int i = input.length() - 1; i >= 0; i--){
           buf.append (input.charAt(i));
        }

//       StringBuilder buf = new StringBuilder();
//       for(int j = 0; j < input.length(); j++){
//           buf.append(temp.pop());
//       }

        return buf.toString();
    }

    public static void main(String[] agrs){
        System.out.println(reverse(INPUT));
        System.out.println(reverse2(INPUT));
    }
}
