package view;

import controller.MemberController;
import exception.LoginException;
import util.DBConn;
import view.admin.AdminView;
import view.user.UserView;

import java.util.Scanner;
public class MainView {
    private Scanner sc = new Scanner(System.in);
    private String id;
    private String pwd;

    private MemberController mc = new MemberController();

    public void start() {
        printMain();
        displayLoginMenu();
    }

    private void displayLoginMenu() {
        int num = 0;
        while (true) {
            try {
                System.out.println("로그인하시려면 1번, 회원가입은 2번, 종료하시려면 3번을 입력해주세요.");
                num = Integer.parseInt(sc.nextLine());
                LoginException.isRightNumber(num);
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (num == 3) {
            quitProgram();
            return;
        }

        if (num == 2) {
            signIn();
            displayLoginMenu();
        }

        else login();

        if (id.equals("admin")) {
            AdminView adv = new AdminView();
            adv.start();
        }
        else {
            UserView usv = new UserView(id);
        }
    }

    private void login() {
        System.out.println("\n로그인을 진행합니다.");
        while(true) {
            try {
                System.out.println();
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
    }

    private void printMain() {
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("･ ｡\n ☆∴｡　*\n　･ﾟ*｡★･\n　　･ *ﾟ｡ *\n　 🩷🩷･ ﾟ*｡･ﾟ★｡ 🩷🩷");
        System.out.println("HP Shop에 오신 걸 환영합니다.");
        System.out.println("　　🩷🩷* ☆ ｡･ﾟ*.｡🩷🩷\n　　　 *　★ ﾟ･｡ *  ｡\n　　　　･　º☆ ｡ * ★ ｡");
        System.out.println("------------------------------------------------");
    }

    private void quitProgram() {
        System.out.println("프로그램을 종료합니다.");
        DBConn.close();
    }

    private void signIn() {
        System.out.println();
        System.out.println("회원 가입을 진행합니다. 정보를 입력해주세요.");
        System.out.print("ID : ");
        String newId = sc.nextLine();
        System.out.print("PASSWORD : ");
        String newPassword = sc.nextLine();
        System.out.print("Name : ");
        String newName = sc.nextLine();
        System.out.print("Tel : ");
        String newTel = sc.nextLine();

        mc.create(newName, newId, newPassword, newTel);
    }
}
