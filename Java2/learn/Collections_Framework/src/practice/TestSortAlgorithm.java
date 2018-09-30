package practice;

import java.util.*;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * question:
 * 1) suppose a list, which contains some name. now sorting the list by alphabet
 * 2) suppose a map, which contains some key-value pair. The key is a name(unduplicated) and
 * the value is a department. now sorting the map by the key's alphabet.
 */
public class TestSortAlgorithm {

    static String s3 = "Hello";
    static String s1 = "Hello";
    static String s2 = new String(s1);
    //    static String s3 = s1;
ArrayList<String> list = new ArrayList<>();
    ArrayList<Student> listStudent = new ArrayList<>();

    private   TestSortAlgorithm(){
        list.add("az");
        list.add("aa");
        list.add("b");
        list.add("yy");
        list.add("ba");
        System.out.println(list);

        listStudent.add(new Student("az", 18, "china"));
        listStudent.add(new Student("b", 17, "english"));
        listStudent.add(new Student("zz", 53, "french"));
        listStudent.add(new Student("aa", 42, "korean"));
        System.out.println(listStudent);
    }
    public static void sortList(List<String> lst){
        //nalan_*:ArrayList:Arrays:sort:*;
        //ArrayList converted to String array
/*        Object[] obj = lst.toArray();
        String[] str = Arrays.copyOf(obj, obj.length, String[].class);
        printArrays(str);
        Arrays.sort(str);
        printArrays(str);*/

        //nalan_*:Collections:sort:reverse:*;
        System.out.println(lst);
        Collections.sort(lst);
        System.out.println("first: "+lst);
//        Collections.reverse(lst);
        Collections.sort(lst, Collections.reverseOrder());
        System.out.println("second: "+lst);
        Collections.sort(lst);
        System.out.println("third: "+lst);
    }
    public static void printArrays(Object[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i].toString());
        }
    }
    public static void main(String[] args) throws Exception{
        TestSortAlgorithm demo = new TestSortAlgorithm();
        sortList(demo.list);

        System.out.println("Class Initial: "+ demo.listStudent);
        //nalan_*:class:new:*;
        Collections.sort(demo.listStudent, demo.new SortByName());
        System.out.println("Class sort by name: "+ demo.listStudent);

        Collections.sort(demo.listStudent, demo.new SortByAge());
        System.out.println("Class sort by age: "+ demo.listStudent);





        Unsafe unsafe = getUnsafeInstance();

        Field s1Field = TestSortAlgorithm.class.getDeclaredField("s1");
        Field s2Field = TestSortAlgorithm.class.getDeclaredField("s2");
        Field s3Field = TestSortAlgorithm.class.getDeclaredField("s3");

        System.out.println(s1 + " equals " + s2 + "--> " +  s1.equals(s2)); //true
        System.out.println("s1 address is : "+ unsafe.staticFieldOffset(s1Field));

        System.out.println(s1 + " == " + s2 + " --> " + (s1 == s2)); //false
        System.out.println("s2 address is : "+ unsafe.staticFieldOffset(s2Field));
        System.out.println(s1 + " == " + s3+ " --> " + (s1 == s3)); //true
        System.out.println("s3 address is : "+ unsafe.staticFieldOffset(s3Field));

        String s1 = new String("A");
        String s2 = new String("A");
/*        String s1 = "A";
        String s2 = "A";*/
        System.out.println("intern test : "+ (s1 == s2));
    }
    /**
     * question:
     * suppose we have a class, which contains some member variables(name, age, country).
     * create a list of  instances of this class and initial it by some data.
     * sort the list by name and age.
     */
    class Student{
        private String name;
        private int age;
        private String country;

        public Student(String name, int age, String country){
            this.name = name;
            this.age = age;
            this.country = country;
        }

        @Override
        public String toString(){
            return this.name + " " + this.age + " " + this.country;
        }
    }

    class SortByName implements Comparator<Student>{
        @Override
        public int compare(Student one, Student two){
            return one.name.compareTo(two.name);
        }
    }

    class SortByAge implements Comparator<Student> {
        @Override
        public int compare(Student one, Student two) {
            return one.age - two.age;
        }
    }
    //nalan_*:Unsafe::*;
    private static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
}
