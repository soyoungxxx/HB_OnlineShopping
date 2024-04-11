package exception;

public class AdminException {
    private final static String CATEGORY_ERROR = "잘못된 카테고리입니다. 다시 입력해주세요.";
    private final static String MANAGE_ERROR = "잘못된 작업입니다. 다시 입력해주세요.";

    public static void isRightCategory(int number) {
        if (number < 1 || number > 5) {
            throw new IllegalArgumentException(CATEGORY_ERROR);
        }
    }

    public static void isRightManagement(int number) {
        if (number < 1 || number > 5) {
            throw new IllegalArgumentException(MANAGE_ERROR);
        }
    }
}
