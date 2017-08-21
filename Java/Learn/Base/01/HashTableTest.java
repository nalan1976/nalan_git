/*
 * 本例演示了HashTable的简单用法
 * 1）注意之所以要创建Counter类，是因为不能将基本数据结构放入集合类中，
 * 而java自动封装类一旦封装没法改变所以必须自己建一个类来完成计数工作
 */
import java.util.*;
class Counter {
int i = 1;
public String toString() {
return Integer.toString(i);
}
}
class HashTableTest {
public static void main(String[] args) {
Hashtable ht = new Hashtable();
for(int i = 0; i < 10000; i++) {
// Produce a number between 0 and 20:
Integer r =
new Integer((int)(Math.random() * 20));
if(ht.containsKey(r))
((Counter)ht.get(r)).i++;
else
ht.put(r, new Counter());
}
System.out.println(ht);
}
}