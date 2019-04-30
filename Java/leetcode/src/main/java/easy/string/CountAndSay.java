package easy.string;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.
 从本例中学到：
 1）StringBuilder的初始化、清空、拷贝等用法
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        int low = 0;    //指向参考字符串的当前位置，若无参考字符串，则当前计算为第一次；
        int fast = 0;   //指向参考字符串，相同字符串的当前位置；它的值就是该数字重复的次数；
        int count = 0;  //当前相同字符的个数；


        //对传入的n进行有效性检验
        if (n < 1) {
            System.out.println("the number is : "+ n +", the sequence is : null");
            return "";
        }

        if (n == 1){
            System.out.println("the number is : "+ "1" +", the sequence is : 1");
            return "1";
        }

//        String lastBuf = "1";   //前一个字符串
//        String curBuf = "";
        StringBuilder lastBuf = new StringBuilder("1");
        StringBuilder curBuf = new StringBuilder("");
        //到这里n至少为2，从第二个字符开始循环
        for (int i = 1; i < n; i++){
            curBuf.delete(0, curBuf.length());//清空  //nalan_*:StringBuilder::*;
            low = 0;
            fast = 0;
            while ( fast < lastBuf.length() ){
                while (fast < lastBuf.length() && lastBuf.charAt(fast) == lastBuf.charAt(low)){
                    count++;
                    fast++;
                }
//                curBuf += String.valueOf(count) + lastBuf.charAt(low);
                curBuf.append(String.valueOf(count)).append(lastBuf.charAt(low));
                System.out.println("curBuf is : " + curBuf);
                low = fast;
                count = 0;
            }
//            lastBuf = curBuf;//复制
            lastBuf.delete(0, lastBuf.length());
            lastBuf.append(curBuf);
            System.out.println("the number is : "+ n +",  bufFast is : " + lastBuf);
        }
        System.out.println("the number is : "+ n +",  curBuf is : " + curBuf);
        return curBuf.toString();
    }
}
