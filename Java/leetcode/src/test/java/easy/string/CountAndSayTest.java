package easy.string;
import  easy.string.CountAndSay.*;
import org.junit.Test;
import static org.junit.Assert.*;

//import static org.junit.Assert.assertEquals;

public class CountAndSayTest {
    @Test
    public void Test(){
        assertEquals(CountAndSay.countAndSay(1), "1");
        assertEquals(CountAndSay.countAndSay(2), "11");
        assertEquals(CountAndSay.countAndSay(3), "21");
        assertEquals(CountAndSay.countAndSay(4), "1211");
        assertEquals(CountAndSay.countAndSay(5), "111221");
        assertEquals(CountAndSay.countAndSay(6), "312211");
        assertEquals(CountAndSay.countAndSay(7), "13112221");
        assertEquals(CountAndSay.countAndSay(8), "1113213211");
        assertEquals(CountAndSay.countAndSay(9), "31131211131221");

    }
}
