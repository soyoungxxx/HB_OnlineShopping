package view.user;

import controller.OrderController;
import exception.AdminException;

import java.util.Scanner;

public class OrderUserView {
    private Scanner sc = new Scanner(System.in);
    private OrderController orderController = new OrderController();

    private String id;
    private int member_no;

    public void orderUser(String id) {
        this.id = id;
        System.out.println();
        System.out.println("진행할 작업을 선택해주세요.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. 주문하기 | 2. 주문 조회 | 3. 뒤로 가기");
        System.out.println("----------------------------------------------------------------------");

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

        if (num == 3) return;

        switch (num) {
            case 1 -> createOrder();
            case 2 -> readOrder();
        }
    }

    private void createOrder() {
        int item_no;
        int quantity;

        System.out.println();
        System.out.println("주문할 상품 정보를 입력해주세요.");
        System.out.print("상품 번호 >> ");
        item_no= Integer.parseInt(sc.nextLine());
        System.out.print("수량 >> ");
        quantity = Integer.parseInt(sc.nextLine());

        orderController.create(item_no, quantity, id);
    }

    private void readOrder() {
        orderController.read(id);
    }
}
