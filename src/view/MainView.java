package view;

import controller.MemberController;
import exception.LoginException;
import util.DBConn;

import java.util.Scanner;
public class MainView {
    private Scanner sc = new Scanner(System.in);
    private String id;
    private String pwd;

    private MemberController mc = new MemberController();

    public void displayLoginMenu() {
        printMain();

        int num = 0;
        while (true) { // 로그인, 끝내기를 받는 반복문. 바른 값을 입력할 때까지 입력 받는다.
            try {
                System.out.println("로그인하시려면 1번, 끝내시려면 2번을 입력해주세요.");
                num = Integer.parseInt(sc.nextLine());
                LoginException.isRigthNumber(num);
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (num == 2) {
            System.out.println("프로그램을 종료합니다.");
            DBConn.close();
            return;
        }

        while(true) {
            try {
                System.out.print("ID : ");
                id = sc.nextLine();
                System.out.print("PASSWORD : ");
                pwd = sc.nextLine();
                LoginException.isRightAccount(id, pwd, mc);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (id.equals("admin")) {
            AdminView adv = new AdminView();
            adv.start();
        }
        else {
            UserView usv = new UserView(id);
        }
    }

    private void printMain() {
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("･ ｡\n ☆∴｡　*\n　･ﾟ*｡★･\n　　･ *ﾟ｡ *\n　 ･ ﾟ*｡･ﾟ★｡");
        System.out.println("HP Shop에 오신 걸 환영합니다.");
        System.out.println("　　* ☆ ｡･ﾟ*.｡\n　　　 *　★ ﾟ･｡ *  ｡\n　　　　･　º☆ ｡ * ★ ｡");
        System.out.println("------------------------------------------------");
    }
}
