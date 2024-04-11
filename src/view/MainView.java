package view;

import java.util.Scanner;
public class MainView {
    private Scanner sc = new Scanner(System.in);
    private String id;
    private String pwd;
    private boolean isAdmin = false;

    public void displayLoginMenu() {
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.print("ID를 입력하세요.");
        id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요.");
        pwd = sc.nextLine();
    }

    public void checkUser() {
        if (id.equals("admin") && pwd.equals("admin1234")) {
            isAdmin = true;
        }
    }
}
