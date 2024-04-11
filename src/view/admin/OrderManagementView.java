package view.admin;

import exception.AdminException;
import controller.OrderController;

import java.util.Scanner;

public class OrderManagementView {
    private Scanner sc = new Scanner(System.in);
    private OrderController orderController = new OrderController();

    public void manageOrder() {
        System.out.println();
        System.out.println("진행할 작업을 선택해주세요.");
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. 전체주문 조회 | 2. 뒤로 가기");
        System.out.println("---------------------------------------------------------------");

        int num = 0;
        while(true) {
            try {
                System.out.print("번호 입력 >> ");
                num = Integer.parseInt(sc.nextLine());
                AdminException.isRightManageOrder(num);
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (num == 1) readOrder();
        return;
    }

    private void readOrder() {
        orderController.read(null);
    }
}