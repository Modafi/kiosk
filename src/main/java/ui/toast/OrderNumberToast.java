package ui.toast;

public class OrderNumberToast {
    public void active(final long orderNumber) {
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다.");
        System.out.println("3초후 메뉴판으로 돌아갑니다.");
    }
}
