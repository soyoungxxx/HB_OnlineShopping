package exception;

public class CreateException extends Exception {
    private final static String UNIQUE_ERROR = "이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.";

    public static void isDuplicated() {

    }
}
