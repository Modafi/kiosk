package ui.screen;

import domain.screen.YesNoCommand;
import util.InputReader;
import util.StringFormatter;

import java.math.BigDecimal;
import java.util.Map;

public class TotalSalesScreen {

    public void active(final Map<String, BigDecimal> salesHistory, final BigDecimal totalSaleAmount) {
        showTotalSaleAmount(totalSaleAmount);
        System.out.println();
        showTotalSales(salesHistory);
        System.out.println();
        System.out.println("1. 돌아가기");

        InputReader.readCommandInput(YesNoCommand::isYes);
    }

    public void showTotalSales(final Map<String, BigDecimal> salesHistory) {
        System.out.println("[ 총 판매상품 목록 현항 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();
        final StringBuilder sb = new StringBuilder();
        salesHistory.keySet().stream().forEach(key -> {
            sb.append("- ")
                    .append(StringFormatter.namePriceTemplate(key, salesHistory.get(key)))
                    .append("\n");
        });

        System.out.println(sb);
    }

    public void showTotalSaleAmount(final BigDecimal totalSaleAmount) {
        System.out.println("총 판매금액 현항");
        System.out.println("현재까지 총 판매된 금액은 [ W " + StringFormatter.priceToWon(totalSaleAmount) + " ] 입니다.");
    }
}
