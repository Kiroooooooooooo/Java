package View;

import StuData.Data;
import StudentClass.Student;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame {
    //设置私有成员列表，文本框，标签，按钮
    List studentlist = new List();

    TextField stunum = new TextField();
    TextField stuname = new TextField();
    TextField stusex = new TextField();
    TextField stuage = new TextField();

    Label stunumlabel = new Label("StudentNumber:");
    Label stunamelabel = new Label("StudentName:");
    Label stusexlabel = new Label("StudentSex:");
    Label stuagelabel = new Label("StudentAge:");

    Button insertButton = new Button("Insert");
    Button updateButton = new Button("Update");
    Button deleteButton = new Button("Delete");
    public MainFrame(){
//        //初始化Data.students
//        Data.students.add(new Student("001","aaa","男","18"));
//        Data.students.add(new Student("002","bbb","女","17"));
//        Data.students.add(new Student("003","ccc","男","18"));
//        Data.students.add(new Student("004","ddd","女","19"));
        //设置框架大小和位置
        this.setLayout(null);
        this.setLocation(600,250);
        this.setSize(400,350);
        this.setTitle("MainFrame");

        //设置列表大小和位置
        studentlist.setBounds(50,55,100,180);
        studentlist.setBackground(new Color(124, 123, 121));
        this.add(studentlist);

        //设置文本框和标签的大小和位置
        stunumlabel.setBounds(160,70,90,20);
        stunamelabel.setBounds(160,110,90,20);
        stusexlabel.setBounds(160,150,90,20);
        stuagelabel.setBounds(160,190,90,20);

        this.add(stunumlabel);
        this.add(stunamelabel);
        this.add(stusexlabel);
        this.add(stuagelabel);

        stunum.setBounds(260,70,90,20);
        stuname.setBounds(260,110,90,20);
        stusex.setBounds(260,150,90,20);
        stuage.setBounds(260,190,90,20);

        this.add(stunum);
        this.add(stuname);
        this.add(stusex);
        this.add(stuage);

        //设置按钮的大小和位置
        insertButton.setBounds(60,260,70,40);
        updateButton.setBounds(170,260,70,40);
        deleteButton.setBounds(280,260,70,40);
        this.add(insertButton);
        this.add(updateButton);
        this.add(deleteButton);

        //将全部的学号添加进列表
                java.util.List<String> studentnums = Data.getallsnums();
                for(String s:studentnums){
                    studentlist.add(s);
                }
        //设置窗口关闭响应respClose
        this.addWindowListener(new respClose());

        //为列表添加监听respItem
        studentlist.addItemListener(new respItem());

        //为三个按钮添加监听
        deleteButton.addActionListener(new respButton());
        updateButton.addActionListener(new respButton());
        insertButton.addActionListener(new respButton());

        this.setVisible(true);
    }
    class respClose extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            try {
                Data.writeStus("students.data");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            finally{
                System.exit(0);
            }
        }
    }
    class respItem implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){
                String stunum_selected = studentlist.getSelectedItem();
                Student stu_selected = Data.getstudentbynum(stunum_selected);
                if(stu_selected == null)return;

                stunum.setText(stu_selected.getStunum());
                stuname.setText(stu_selected.getStuname());
                stusex.setText(stu_selected.getStusex());
                stuage.setText(stu_selected.getStuage());
            }
        }
    }
    class respButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            Button b = null;
            String str = null;
            if(o instanceof Button){
                b = (Button) o;
                str = b.getLabel();
            }
            if("Delete".equals(str)){
                String stunumnow = studentlist.getSelectedItem();
                Data.deletestubynum(stunumnow);
                studentlist.remove(stunumnow);

                stunum.getText();
                stuname.getText();
                stusex.getText();
                stuage.getText();
                stunum.setText("");
                stuname.setText("");
                stusex.setText("");
                stuage.setText("");
            }
            if("Update".equals(str)){
                String stunumnow = studentlist.getSelectedItem();
                Student stu = Data.getstudentbynum(stunumnow);
                stu.setStuage(stuage.getText());
                stu.setStusex(stusex.getText());
                stu.setStuname(stuname.getText());
            }
            if("Insert".equals(str)){
                new InsertDialog(MainFrame.this, true);//妯℃€佸寲锛屽彧鏈夊叧闂�寮瑰嚭鐨勫�硅瘽妗嗗悗锛屾墠浼氭墽琛屽悗闈㈢殑浠ｇ爜
                studentlist.removeAll();//鍦ㄦ坊鍔犳柊淇℃伅涔嬪墠娓呯┖
                java.util.List<String> studentNumbers = Data.getallsnums();
                //澧炲己for寰�鐜�
                for(String s : studentNumbers){
                    studentlist.add(s);		//閫氳繃鍐呯疆鏂规硶add浣垮�﹀彿鏄剧ず鍦↙ist缁勪欢涓�
                }
            }
        }
    }
}

