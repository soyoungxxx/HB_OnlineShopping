package view.user;

import controller.DeliveryController;
import controller.ItemController;
import exception.AdminException;

import java.util.Scanner;

public class DeliveryUserView {
    private Scanner sc = new Scanner(System.in);
    private DeliveryController deliveryController = new DeliveryController();
    private String id;

    public void deliveryUser(String id) {
        this.id = id;
        System.out.println();
        System.out.println("진행할 작업을 선택해주세요.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. 배송 조회 | 2. 주소 수정 | 3. 뒤로 가기");
        System.out.println("----------------------------------------------------------------------");

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

        if (num == 1) readDelivery();
        else if (num == 2) updateAddress();
        return;
    }

    private void readDelivery() {
        deliveryController.read(id);
    }

    private void updateAddress() {
        String address;
        int order_no;
        System.out.println();
        System.out.println("주소를 변경할 주문의 주문 번호를 입력해주세요.");
        System.out.print("주문 번호 >> ");
        order_no = Integer.parseInt(sc.nextLine());

        System.out.println("변경할 주소를 입력해주세요.");
        System.out.print("새 주소 >> ");
        address = sc.nextLine();

        deliveryController.update(address, id, order_no);
    }
}
