package Lauch;

import StuData.Data;
import View.Login;

public class Main {
    public static void main(String[] args) {
        new Login();

        try {
            Data.readStus("students.data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
