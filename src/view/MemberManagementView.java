package view;

import java.util.Scanner;

import controller.MemberController;
import exception.AdminException;

public class MemberManagementView {
    private AdminView adminView = new AdminView();
    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();

    public void manageMember() {
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
            case 5 -> adminView.selectCategory();
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
        adminView.selectCategory();
    }

    private void readMem() {
        mc.read(null);
        adminView.selectCategory();
    }

    private void updateMem() {
        int member_no;
        String col, change;
        System.out.println();
        System.out.println("!! 한 번에 한 항목만 수정하실 수 있습니다 !!");
        System.out.println("수정할 회원의 회원 번호를 입력해주세요.");
        System.out.print("회원 번호 >> ");
        member_no = Integer.parseInt(sc.nextLine());
        System.out.println("수정하실 항목을 입력해주세요. (ex. 이름, 아이디, 비밀번호, 전화번호)");
        System.out.print("항목 >> ");
        col = sc.nextLine();
        System.out.println("변경하실 내용을 입력해주세요.");
        System.out.print("변경 내용 >> ");
        change = sc.nextLine();

        mc.update(member_no, col, change);
        adminView.selectCategory();
    }

    private void deleteMem() {

    }
}
