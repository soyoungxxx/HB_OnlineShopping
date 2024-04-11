package view.admin;

import controller.ItemController;
import controller.MemberController;
import domain.Item;
import exception.AdminException;

import java.util.Scanner;

public class ItemManagementView {
    private Scanner sc = new Scanner(System.in);
    private ItemController itemController = new ItemController();

    public void manageItem() {
        System.out.println();
        System.out.println("진행할 작업을 선택해주세요.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. 상품 목록 | 2. 상품 정보 수정  | 3. 상품 추가 | 4. 상품 삭제 | 5. 뒤로 가기");
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

        if (num == 5) return;

        switch (num) {
            case 1 -> readItem();
            case 2 -> updateItem();
            case 3 -> createItem();
            case 4 -> deleteItem();
        }
    }

    private void createItem() {
        String item_name;
        int price;

        System.out.println();
        System.out.println("추가할 데이터를 입력해주세요.");
        System.out.print("상품 이름 >> ");
        item_name = sc.nextLine();
        System.out.print("상품 가격 >> ");
        price = Integer.parseInt(sc.nextLine());

        itemController.create(item_name, price);
    }

    private void readItem() {
        itemController.read(null);
    }

    private void updateItem() {
        String item_name;
        String[] temp;
        String[] col = new String[4];
        String[] change = new String[4];
        System.out.println();
        System.out.println("!! 한 번에 한 항목만 수정하실 수 있습니다 !!");
        System.out.println("수정할 상품의 이름을 입력해주세요.");
        System.out.print("상품명 >> ");
        item_name = sc.nextLine();
        System.out.println("수정하실 항목을 입력해주세요. (상품명, 가격)");
        System.out.println("수정하지 않을 항목은 적지 말아주세요. ex) 상품명");
        System.out.print("항목 >> ");
        temp = sc.nextLine().split(", ");

        System.out.println("변경하실 내용을 입력해주세요. (변경내용1, 변경내용2, ...)");
        System.out.print("변경 내용 >> ");
        change = sc.nextLine().split(", ");

        for (int i = 0; i < temp.length; i++) {
            switch (temp[i]) {
                case "상품명" -> col[0] = change[i];
                case "가격" -> col[1] = change[i];
            }
        }

        itemController.update(item_name, col);
    }

    private void deleteItem() {
        String name;
        System.out.println();
        System.out.println("삭제할 상품의 이름을 입력해주세요.");
        System.out.print("상품명 >> ");
        name = sc.nextLine();

        itemController.delete(name);
        System.out.println("삭제되었습니다.");
    }
}
