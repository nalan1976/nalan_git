import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DreamBoy on 2016/5/15.
 * Modify by Nalan on 2017/8/22
 */
//学生类  
public class Students {
    //1. 必须为公有的类，不能是final的，最好也别包括final方法
    //2. 至少是默认的 不带参数的默认的构造方法
    //3. 属性私有  
    //4. 属性setter/getter封装
    //5.重写equals()和hashCode()方法：这一个的必要性还没完全理解
    //6.配置文件中必须提供标识属性，与数据表中主键对应
    //7.尽量使用基本数据类型的包装类型(以便区分空值)

    private int sid; //学号  
    private String sname; //姓名  
    private String gender; //性别  
    private Date birthday; //出生日期  
    private String address; //地址
    private List schools = new ArrayList();

     Students() {
    }

    public Students(int sid, String sname, String gender, Date birthday, String address) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    public List getSchools() {
        return schools;
    }

    public void setSchools(List schools) {
        this.schools = schools;
    }
}