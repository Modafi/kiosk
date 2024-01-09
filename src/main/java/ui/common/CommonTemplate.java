package ui.common;

public class CommonTemplate {
    private CommonTemplate() {
    }

    public static void showHeader() {
        System.out.println("NBC BEAR 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
    }

    public static void showMenuTitle(final String title) {
        System.out.println("[ " + title + " MENU ]");
    }
}
