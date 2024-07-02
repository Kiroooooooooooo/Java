package StuData;

import StudentClass.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Student> students = new ArrayList<Student>();

    public static List <String> getallsnums(){
        List <String> allnums = new ArrayList<String>();
        for(Student s:students){
            String onenum = s.getStunum();
            allnums.add(onenum);
        }
        return allnums;
    }

    public static Student getstudentbynum(String num){
        for(Student s:students){
            String nownum = s.getStunum();
            if(num.equals(nownum)){
                return s;
            }
        }
        return null;
    }

    public static boolean deletestubynum(String stunum){
        for(Student s : students){
            String str = s.getStunum();
            if(stunum.equals(str)){
                students.remove(s);
                return true;
            }
        }
        return false;
    }

    public static void writeStus(String filename) throws Exception{
        FileOutputStream fo = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fo);
        oos.writeObject(students);
    }

    public static boolean readStus(String filename) throws Exception{
        FileInputStream fi = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fi);
        Object o = ois.readObject();
        if(o instanceof List){
            students = (List <Student>)o;
            return true;
        }
        else{
            return false;
        }
    }
}
