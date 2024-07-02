package StudentClass;

import java.io.Serializable;

public class Student implements Serializable {
    private String stunum;
    private String stuname;
    private String stusex;
    private String stuage;

    public Student(String num, String name, String sex, String age){
        this.stunum = num;
        this.stuname = name;
        this.stusex = sex;
        this.stuage = age;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public String getStuage() {
        return stuage;
    }

    public void setStuage(String stuage) {
        this.stuage = stuage;
    }
}
