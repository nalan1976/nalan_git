package easy.string;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public static int numJewelsInStonesMine(String J, String S) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++){
            if (map.containsKey(S.charAt(i))){
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            }else{
                map.put(S.charAt(i), 1);
            }
        }

        int count = 0;
        for (int i = 0; i < J.length(); i++){
            if (map.containsKey(J.charAt(i))){
                count += map.get(J.charAt(i));
            }
        }

        return count;

    }
    public static int numJewelsInStones(String J, String S) {
        boolean[] ascii = new boolean[256];
        for(int i = 0; i < J.length(); i++) {
            ascii[J.charAt(i)] = true;
        }

        int cnt = 0;
        for(int i = 0; i < S.length(); i++) {
            if (ascii[S.charAt(i)] == true) {
                cnt++;
            }
        }
        return cnt;
    }
    public static int numJewelsInStones2(String J, String S) {
        int count = 0;
        for(int i = 0; i < J.length(); i++) {
            char j = J.charAt(i);
            int formerIndex = -1;
            while(true) {
                int index = S.indexOf(j, formerIndex + 1);
                if(index != -1) {
                    formerIndex = index;
                    count++;
                    continue;
                }
                break;
            }
        }
        return count;
    }
    public static int numJewelsInStones3(String J, String S) {
        HashMap<Character, Integer> counts = new HashMap<>();
        int l = S.length();
        int sum = 0;
        for(int i=0; i<l; i++)
            counts.put(S.charAt(i), counts.getOrDefault(S.charAt(i), 0)+1);
        for(int j=0; j<J.length(); j++) {
            sum+=counts.getOrDefault(J.charAt(j), 0);
        }
        return sum;

    }

    public static void main(String[] args) {
        String S = "aaafffdddaa";
        String J = "ad";
        System.out.println(numJewelsInStonesMine(J, S));
        System.out.println(numJewelsInStones(J, S));
        System.out.println(numJewelsInStones2(J, S));
        System.out.println(numJewelsInStones3(J, S));
    }
}
