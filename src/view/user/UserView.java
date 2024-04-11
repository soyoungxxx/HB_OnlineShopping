package view.user;

import domain.Item;
import exception.AdminException;
import util.DBConn;
import view.MainView;

import java.util.Scanner;

public class UserView {
    private static Scanner sc = new Scanner(System.in);
    private String id;

    private MemberUserView member = new MemberUserView();
    private ItemUserView item = new ItemUserView();
    private OrderUserView order = new OrderUserView();
    private DeliveryUserView deliver = new DeliveryUserView();

    public UserView(String id) {
        this.id = id;
    }

    public void selectCategory() {
        int flag = 0;
        while(true) {
            System.out.println();
            System.out.println("진행할 카테고리를 선택해주세요.");
            System.out.println("---------------------------------------------------------------");
            System.out.println("1. 내 정보 관리 | 2. 주문 목록 | 3. 배송 목록 | 4. 상품 조회 | 5. 종료");
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
                case 1 -> flag = member.memberUser(id);
                case 2 -> order.manageOrder();
                case 3 -> deliver.manageDelivery();
                case 4 -> item.manageItem();
            }
            if (flag == 1) break;
        }
        if (flag == 1) {
            MainView m = new MainView();
            m.displayLoginMenu();
        }
    }


}
