package view;

import java.util.Scanner;

import controller.MemberController;
import exception.AdminException;
import util.DBConn;

public class AdminView {
    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();

    public AdminView() {
        System.out.println("관리자 계정으로 로그인하셨습니다.");
        int category = selectCategory();
        if (category == 5) {
            DBConn.close();
            System.out.println("프로그램을 종료합니다.");
            return;
        }
        switch(category) {
            case 1 -> manageMember();
            case 2 -> manageOrder();
            case 3 -> manageDelivery();
            case 4 -> manageItem();
        }
    }

    private int selectCategory() {
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

    private void manageMember() {
        System.out.println();
        System.out.println("진행할 작업을 선택해주세요.");
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. 회원 추가 | 2. 회원 조회  | 3. 회원 수정 | 4. 회원 삭제 | 5. 뒤로 가기");
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

        switch (num) {
            case 1 -> createMem();
            case 2 -> readMem();
            case 3 -> updateMem();
            case 4 -> deleteMem();
            case 5 -> selectCategory();
        }
    }

    private void createMem() {
        String name, id, pwd, tel;
        System.out.println();
        System.out.println("추가할 데이터를 입력해주세요.");
        System.out.print("회원 이름 >> ");
        name = sc.nextLine();
        System.out.print("회원 ID >> ");
        id = sc.nextLine();
        System.out.print("회원 비밀번호 >> ");
        pwd = sc.nextLine();
        System.out.print("회원 전화번호 (빈 칸 입력 가능) >> ");
        tel = sc.nextLine();

        mc.create(name, id, pwd, tel);
    }

    private void readMem() {
        mc.read(null);
    }

    private void updateMem() {

    }

    private void deleteMem() {

    }


    private void manageOrder() {

    }

    private void manageDelivery() {

    }

    private void manageItem() {

    }
}
