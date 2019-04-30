package test;
import net.jcip.examples.DelegatingVehicleTracker;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;


public class TestCopy {
    @Test
    public void test(){
        Map map = new HashMap<String, Point>();
        map.put("sh", new Point(4, 5));
        DelegatingVehicleTracker dvt = new DelegatingVehicleTracker(map);

        System.out.println("getLocation : "+ dvt.getLocation("sh").hashCode() +
                " X is : " + dvt.getLocation("sh").getX() + " Y is : " + dvt.getLocation("sh").getY());

        Map getLocations = dvt.getLocations();
        Map getLocationsAsStatic = dvt.getLocationsAsStatic();

        System.out.println("getLocations : "+ getLocations.hashCode() +
                " entrySet is : " + getLocations.entrySet());
        System.out.println("getLocationsAsStatic : "+ getLocationsAsStatic.hashCode() +
                " entrySet is : " + getLocationsAsStatic.entrySet());

       dvt.setLocation("sh", 10, 10);

        System.out.println("getLocations : "+ getLocations.hashCode() +
                " entrySet is : " + getLocations.entrySet());
        System.out.println("getLocationsAsStatic : "+ getLocationsAsStatic.hashCode() +
                " entrySet is : " + getLocationsAsStatic.entrySet());
//nalan_*:Collections::*;
//        getLocations.clear(); //运行时报错，函数返回的是不可改变的值；

        /**输出：
         getLocation : -2105802752 X is : 4.0 Y is : 5.0
         getLocations : -2105799083 entrySet is : [sh=java.awt.Point[x=4,y=5]]
         getLocationsAsStatic : -2105799083 entrySet is : [sh=java.awt.Point[x=4,y=5]]
         getLocations : -2072506795 entrySet is : [sh=java.awt.Point[x=10,y=10]]
         getLocationsAsStatic : -2105799083 entrySet is : [sh=java.awt.Point[x=4,y=5]]
         说明：
         1）getLocationsAsStatic返回的是对象（locations）的值拷贝，一旦原值被改变，它的返回值并不会随之改变；
         而getLocations返回的是对象引用，随数据改变而改变
         * */
    }
}
