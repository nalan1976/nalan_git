package easy.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Test;

public class BuddyStrings {
    static public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length() || A.length() < 2){
            return false;
        }

        Set<Character> set = new HashSet<>();
        if (A.equals(B)){
            for(int i = 0; i < A.length(); ++i){
                set.add(A.charAt(i));
            }
            if (set.size() != A.length())
                return true;
            else
                return false;
        }

        List<Character> lsA = new LinkedList<>();
        List<Character> lsB = new LinkedList<>();
        for(int i = 0; i < A.length(); ++i){
            if(A.charAt(i) != B.charAt(i)){
                lsA.add(A.charAt(i));
                lsB.add(B.charAt(i));
            }
        }

        return lsA.size() == 2 && lsA.get(0) == lsB.get(1) && lsA.get(1) == lsB.get(0);
    }
    @Test
    public void testRun(){
        assertTrue(BuddyStrings.buddyStrings("ab", "ba"));
        assertFalse(BuddyStrings.buddyStrings("ab", "ab"));
        assertTrue(BuddyStrings.buddyStrings("aa", "aa"));
        assertTrue(BuddyStrings.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        assertFalse(BuddyStrings.buddyStrings("", "aa"));

        assertFalse(BuddyStrings.buddyStrings("abcaa", "abcbb"));
        assertFalse(BuddyStrings.buddyStrings("", ""));
        assertFalse(BuddyStrings.buddyStrings("ab", "ca"));
        assertTrue(BuddyStrings.buddyStrings("abab", "abab"));
    }
}

