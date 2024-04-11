package view.admin;

import java.util.Scanner;

import controller.MemberController;
import exception.AdminException;

public class MemberManagementView {
    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();

    public void manageMember() {
        System.out.println();
        System.out.println("진행할 작업을 선택해주세요.");
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. 회원 조회 | 2. 뒤로 가기");
        System.out.println("---------------------------------------------------------------");

        int num = 0;
        while(true) {
            try {
                System.out.print("번호 입력 >> ");
                num = Integer.parseInt(sc.nextLine());
                AdminException.isRightManagement(num);
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (num == 2) return;

        readMem();
    }

    private void readMem() {
        mc.read(null);
    }
}
