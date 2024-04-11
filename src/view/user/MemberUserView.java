package view.user;

import controller.MemberController;
import exception.AdminException;

import java.util.Scanner;

public class MemberUserView {
    private String id;
    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();

    public int memberUser(String id) {
        int flag = 0;
        this.id = id;
        System.out.println();
        System.out.println("진행할 작업을 선택해주세요.");
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. 내 정보 조회 | 2. 내 정보 수정  | 3. 회원 탈퇴 | 4. 뒤로 가기");
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

        if (num == 4) return 0;

        switch (num) {
            case 1 -> readMem();
            case 2 -> updateMem();
            case 3 -> flag = deleteMem();
        }
        return flag;
    }

    private void readMem() {
        mc.read(id);
    }

    private void updateMem() {
        int member_no;
        String[] temp;
        String[] col = new String[4];
        String[] change = new String[4];
        System.out.println();
        System.out.println("!! 한 번에 한 항목만 수정하실 수 있습니다 !!");
        System.out.println("수정하실 항목을 입력해주세요. (이름, 아이디, 비밀번호, 전화번호)");
        System.out.println("수정하지 않을 항목은 적지 말아주세요. ex) 이름, 아이디, 전화번호");
        System.out.print("항목 >> ");
        temp = sc.nextLine().split(", ");

        System.out.println("변경하실 내용을 입력해주세요. (변경내용1, 변경내용2, ...)");
        System.out.print("변경 내용 >> ");
        change = sc.nextLine().split(", ");

        for (int i = 0; i < temp.length; i++) {
            switch (temp[i]) {
                case "이름" -> col[0] = change[i];
                case "아이디" -> col[1] = change[i];
                case "비밀번호" -> col[2] = change[i];
                case "전화번호" -> col[3] = change[i];
            }
        }

        mc.update(id, col);
    }

    private int deleteMem() {
        mc.delete(id);
        System.out.println("삭제되었습니다.");
        return 1;
    }

}
