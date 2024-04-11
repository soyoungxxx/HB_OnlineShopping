package view.admin;

import controller.DeliveryController;
import exception.AdminException;

import java.util.Scanner;

public class DeliveryManagementView {
    private Scanner sc = new Scanner(System.in);
    private DeliveryController deliveryController = new DeliveryController();

    public void manageDelivery() {
        System.out.println();
        System.out.println("진행할 작업을 선택해주세요.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. 배송 조회 | 2. 배송 접수 | 3. 뒤로 가기");
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
            case 1 -> readDelivery();
            case 2 -> createDelivery();
        }
    }

    private void createDelivery() {
        String address, date;
        int order_no;

        System.out.println();
        System.out.println("추가할 데이터를 입력해주세요.");
        System.out.print("주문 번호 >> ");
        order_no = Integer.parseInt(sc.nextLine());
        System.out.print("주소 >> ");
        address = sc.nextLine();
        System.out.print("배송 날짜 >> ");
        date = sc.nextLine();

        deliveryController.create(order_no, address, date);
    }

    private void readDelivery() {
        deliveryController.read(null);
    }
}
