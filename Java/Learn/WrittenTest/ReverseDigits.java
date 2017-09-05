import java.util.LinkedList;

/**
 * 1）String.substring(a,b)是取索引为a到b-1处
 * 2）while(!stk.peek()) 为什么不能编译？
 * 3)String s;使用前要先初始化
 * 4)负数进行取模和除法都是保留符号的
 * 5)LinkedList中peek和poll的异同：
 *      1.当List为空时，2者都返回null；
 *      2.peek从顶部取数据，但并不移除改数据；poll取数据并移除。
 * 6)long型常量赋值要加"L"
 * 疑问：
 * 1）原网站的测试数据9646324351是怎么传进去的，没有加L都传入不了，而且我的代码加了L也不会报错；
 * */
public class ReverseDigits {
     //写得真是比较垃圾，就是用一下容器和字符串操作而已，最终还无法提交
    public static int reverse(long x) {
        //only one digit number

        if(x > -10 && x < 10){
            return (int)x;
        }

        boolean bNagetive = false;
        String s = ((Long)x).toString();

        if(s.substring(0,1) .equals("-")) {
            bNagetive = true;
            s = s.substring(1, s.length());
        }

        LinkedList stk = new LinkedList();//不指定类型应该可以吧？
        for(int i=0; i<s.length(); i++){
            stk.push(s.substring(i, i+1));
        }

        String r = "";
        while(null != stk.peek())//while(!stk.peek()) 为什么不能编译？
            r += stk.poll();

        //need cut the beginning “0”？
        int i = 0;
        while(s.substring(0, 1).equals("0"))
            s = s.substring(1, s.length());

        if(bNagetive)
            r = "-"+ r;
        long l = Long.parseLong(r);
        if( l > Integer.MAX_VALUE || l < Integer.MIN_VALUE)
            return 0;
        return Integer.parseInt(r);

    }

    /**一次改写成功：
     * 1)对10取模是取最后一位；
     * 2）除以10是去掉最后一个；
     * 3）将上一次最后一位数（假设为c）乘以10+本次最后一位即为取得的数反过来的值
     * 4）只要除10后不为空，不断循环即可。
     */
    public static int reverseChg(long x){
        long a, b, c = 0;
        b = x;
        while( b != 0 ){
            a = b%10;
            b = b/10;
            c = 10*c + a;
            /** 有人使用下面语句检测越界，不是很明白
             if(z/10 != y)
             *
             * */
            if( c > Integer.MAX_VALUE || c < Integer.MIN_VALUE)
                return 0;
        }

        return (int) c;
    }
    //别人的代码，比较简洁，而且能够通过测试
    public static int reverse1(long x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }
    public static void main(String[] args) {
        System.out.println(reverse(0));
        System.out.println(reverse(6324351));
        System.out.println(reverse(-6324351));
        System.out.println(reverse(632000));
        System.out.println(reverse(-632000000));
        int ret = reverse(-1646324359L);
        System.out.println(ret);

        System.out.println(reverseChg(0));
        System.out.println(reverseChg(6324351));
        System.out.println(reverseChg(-6324351));
        System.out.println(reverseChg(632000));
        System.out.println(reverseChg(-632000000));
        ret = reverseChg(-1646324359L);
        System.out.println(ret);

        //负数进行取模和除法都是保留符号的
        System.out.println("-123%10 is :"+(-123%10)+" and -123/10 is :"+(-123/10));

        //根据leetcode上面的讨论做的小测试，没什么意义
/*        long r= Integer.MAX_VALUE + 1;
        if(r == (int)r){
            System.out.println("EQUAL, which is wrong:"+r);
        } else {
            System.out.println("NOT EQUAL, which is incorrect");
        }*/
    }
}
