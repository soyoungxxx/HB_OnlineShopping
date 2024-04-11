package view;

import java.util.Scanner;

import controller.MemberController;
import domain.Item;
import exception.AdminException;
import util.DBConn;

public class AdminView {
    private static Scanner sc = new Scanner(System.in);
    private MemberManagementView mmv = new MemberManagementView();
    private OrderManagementView omv = new OrderManagementView();
    private ItemManagementView imv = new ItemManagementView();
    private DeliveryManagementView dmv = new DeliveryManagementView();

    public void start() {
        System.out.println("관리자 계정으로 로그인하셨습니다.");
        selectCategory();
    }

    public void selectCategory() {
        while(true) {
            System.out.println();
            System.out.println("진행할 카테고리를 선택해주세요.");
            System.out.println("---------------------------------------------------------------");
            System.out.println("1. 회원 관리 | 2. 주문 관리 | 3. 배송 관리 | 4. 상품 관리 | 5. 종료");
            System.out.println("---------------------------------------------------------------");

            int category = 0;
            while (true) {
                try {
                    System.out.print("번호 입력 >> ");
                    category = Integer.parseInt(sc.nextLine());
                    AdminException.isRightCategory(category);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (category == 5) {
                DBConn.close();
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            switch(category) {
                case 1 -> mmv.manageMember();
                case 2 -> omv.manageOrder();
                case 3 -> dmv.manageDelivery();
                case 4 -> imv.manageItem();
            }
        }
    }

    private void manageDelivery() {

    }

    private void manageItem() {

    }
}
