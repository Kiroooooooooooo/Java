package View;

import StuData.Data;
import StudentClass.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class InsertDialog extends Dialog {
    //设置图形元素
    TextField stunum = new TextField();
    TextField stuname = new TextField();
    TextField stusex = new TextField();
    TextField stuage = new TextField();

    Label stunumlabel = new Label("StudentNumber:");
    Label stunamelabel = new Label("StudentName:");
    Label stusexlabel = new Label("StudentSex:");
    Label stuagelabel = new Label("StudentAge:");

    Button apply = new Button("Apply");
    Button cancel = new Button("Cancel");

    public InsertDialog(Frame owner, boolean modal){
        super(owner,modal);
        //设置界面大小和位置
        this.setLayout(null);
        this.setLocation(600,250);
        this.setSize(400,350);
        this.setTitle("InsertDialog");

        //设置图形元素的大小和位置
        stunumlabel.setBounds(60,70,90,20);
        stunamelabel.setBounds(60,110,90,20);
        stusexlabel.setBounds(60,150,90,20);
        stuagelabel.setBounds(60,190,90,20);

        this.add(stunumlabel);
        this.add(stunamelabel);
        this.add(stusexlabel);
        this.add(stuagelabel);

        stunum.setBounds(160,70,170,20);
        stuname.setBounds(160,110,170,20);
        stusex.setBounds(160,150,170,20);
        stuage.setBounds(160,190,170,20);

        this.add(stunum);
        this.add(stuname);
        this.add(stusex);
        this.add(stuage);

        apply.setBounds(90,230,90,50);
        cancel.setBounds(240,230,90,50);
        this.add(apply);
        this.add(cancel);

        //添加窗口关闭相应
        this.addWindowListener(new respClose());

        //添加按钮监听
        apply.addActionListener(new respButton());
        cancel.addActionListener(new respButton());
        this.setVisible(true);
    }
    class respClose extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            InsertDialog.this.dispose();
        }
    }
    class respButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            Button b = null;
            String str = null;
            if(o instanceof Button){
                b = (Button)o;
                str = b.getLabel();
            }
            java.util.List<String> allnum = Data.getallsnums();
            if("Apply".equals(str)){
                Student stunow = new Student(stunum.getText(),stuname.getText(), stusex.getText(), stuage.getText());
                Data.students.add(stunow);
                InsertDialog.this.dispose();
            }
            if("Cancel".equals(str)){
                stunum.getText();
                stuname.getText();
                stusex.getText();
                stuage.getText();
                stunum.setText("");
                stuname.setText("");
                stusex.setText("");
                stuage.setText("");
            }
        }
    }
}
