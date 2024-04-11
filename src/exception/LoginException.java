package exception;

import controller.MemberController;

public class LoginException extends Exception {
    private final static String WRONG_NUMBER_ERROR = "잘못된 입력입니다. 다시 시도해주세요.";
    private final static String WRONG_ACCOUNT_ERROR = "아이디 혹은 비밀번호가 틀립니다. 다시 시도해주세요.";

    public static void isRigthNumber(int number) {
        if (number != 1 && number != 2 && number != 3) {
            throw new IllegalArgumentException(WRONG_NUMBER_ERROR);
        }
    }

    public static void isRightAccount(String id, String pwd, MemberController mc) {
        if (mc.loginController(id, pwd) == null) {
            throw new IllegalArgumentException(WRONG_ACCOUNT_ERROR);
        }
    }
}
