package practice;

import java.util.*;

public class InterviewPrepare1 {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("aa");
        lst.add("bb");
        lst.add("cc");
        lst.add("dd");
        System.out.println(exist(lst, "cc"));
        System.out.println(exist(lst, "zz"));


        Map map = new HashMap();
        map.put(1,"sam");
        map.put(1,"Ian");
        map.put(1,"Scott");
        map.put(null,"asdf");
        System.out.println(map);

        System.out.println(reverse(""));
        System.out.println(reverse("i am good man."));

        System.out.println(reverseWord("Frank su is good programmer"));
        System.out.println(reverseWord2("    Frank su is a good programmer      "));

        Object o = new String(" hello");
        System.out.println(o);

        for(Integer i =0; i  < 10; i++){
            System.out.println("df");
            int j = i % 2;
        }
    }
    /**
     * Write a code in which a method receives list and string and returns true if the string exists in list and false if it do not exist.
     */
    public static boolean exist(List<String> lst, String s){
        return lst.contains(s);
    }
    //1.	Write a function to reverse a string
    public static String reverse(String str){
        char[] ch = str.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (int i = ch.length-1; i >= 0; i--){
            temp.append(ch[i]);

        }
        return temp.toString();
    }
    /**
     * Write a function to reverse words in a string ex: “how are you” becomes “you are how”.
     */
    public static String reverseWord(String str){
        String[] temp = str.split(" ");
        StringBuffer buf = new StringBuffer();
        for(int i =temp.length -1; i >= 0; i--){
            buf.append(temp[i]);
            if (i > 0) buf.append(" ");
        }

        return buf.toString();
    }
// too bad!!!, just test trim and subString method
    public static String reverseWord2(String str){
        System.out.println("the original string is："+str);
        System.out.println("the string after trim() is: "+str.trim());


        char[] ch = str.toCharArray();

        StringBuilder s = new StringBuilder(str.trim());
        s.append(" ");

        LinkedList<String> lst = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            lst.push(s.substring(0, s.indexOf(" ")));
            s = s.delete(0, s.indexOf(" ")+1);
        }

        StringBuilder s2= new StringBuilder();
        Iterator it = lst.iterator();
        while(it.hasNext()){
            s2.append(lst.pop());
            if (it.hasNext()) s2.append(" ");
        }
        return s2.toString();
    }
}
