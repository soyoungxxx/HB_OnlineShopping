package view;

import java.util.Scanner;

import controller.MemberController;
import exception.AdminException;
import util.DBConn;

public class AdminView {
    private Scanner sc = new Scanner(System.in);

    private MemberManagementView memberView;

    public AdminView() {
        System.out.println("관리자 계정으로 로그인하셨습니다.");
        int category = selectCategory();
        if (category == 5) {
            DBConn.close();
            System.out.println("프로그램을 종료합니다.");
            return;
        }
        switch(category) {
            case 1 -> memberView.manageMember();
            case 2 -> manageOrder();
            case 3 -> manageDelivery();
            case 4 -> manageItem();
        }
    }

    public int selectCategory() {
        System.out.println();
        System.out.println("진행할 카테고리를 선택해주세요.");
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. 회원 관리 | 2. 주문 관리 | 3. 배송 관리 | 4. 상품 관리 | 5. 종료");
        System.out.println("---------------------------------------------------------------");

        int num = 0;
        while (true) {
            try {
                System.out.print("번호 입력 >> ");
                num = Integer.parseInt(sc.nextLine());
                AdminException.isRightCategory(num);
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return num;
    }



    private void manageOrder() {

    }

    private void manageDelivery() {

    }

    private void manageItem() {

    }
}
