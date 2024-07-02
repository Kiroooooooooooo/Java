package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends Frame {
    //设置私有成员
    private TextField username = new TextField();
    private TextField pwdname = new TextField();

    private Button loginbutton = new Button("Login");
    private Button cancelbutton = new Button("Cancel");

    private Label userlabel = new Label("Username:");
    private Label pwdlabel = new Label("Password:");

    public Login(){
        this.setLayout(null);    //清空布局

        //设置主窗口位置和大小
        this.setLocation(600,250);
        this.setSize(400,350);
        this.setTitle("Login");

        //设置各元素成员大小和位置
        userlabel.setBounds(50,60,60,50);
        pwdlabel.setBounds(50,110,60,50);
        username.setBounds(120,75,200,20);
        pwdname.setBounds(120,125,200,20);
        loginbutton.setBounds(100,200,90,40);
        cancelbutton.setBounds(220,200,90,40);
        //将图形元素添加到框架之中
        this.add(username);
        this.add(userlabel);
        this.add(pwdlabel);
        this.add(pwdname);
        this.add(loginbutton);
        this.add(cancelbutton);

        cancelbutton.addActionListener(new respButton());
        loginbutton.addActionListener(new respButton());
        this.addWindowListener(new respClose());

        pwdname.setEchoChar('*');     //设置密码输入为星号

        //设置界面可见
        this.setVisible(true);
    }
    //添加内部类，为登录和取消按钮添加监听
    class respButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //获取事件源，并且强转型为Button类型，判断是Login还是Cancel分别处理
            Object o = e.getSource();
            Button b = null;
            String str = null;
            if(o instanceof Button){
                b = (Button) o;
                str = b.getLabel();
            }
            if("Login".equals(str)){
                String usernameinput = username.getText();
                String pwdinput = pwdname.getText();
                if("2022".equals(usernameinput) && "1234".equals(pwdinput)){
                    new MainFrame();
                    Login.this.setVisible(false);
                }
            }
            if("Cancel".equals(str)){
                username.getText();
                pwdname.getText();
                username.setText("");
                pwdname.setText("");
            }
        }
    }
    class respClose extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}

