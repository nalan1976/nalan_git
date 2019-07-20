package practise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
        Set<String> set1 = new HashSet<>(Arrays.asList(names1));
        Set<String> set2 = new HashSet<>(Arrays.asList(names2));
        set1.addAll(set2);//nalan

        return set1.toArray(new String[set1.size()]);//nalan
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia



    }
}
