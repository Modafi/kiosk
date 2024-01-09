package data.product;

import data.category.MenuCategory;

import java.math.BigDecimal;

import static data.category.MenuCategory.*;

public enum Product {
    // LARGER
    WORT_LARGER(LARGER, "Wort Larger", BigDecimal.valueOf(7900), "첫번째 맥아즙의 깊고 풍부한 맛과 향을 느낄 수 있는 라거"),
    LEMON_MARMALADE(LARGER, "Lemon Marmalade", BigDecimal.valueOf(6900), "상큼한 레몬향을 은은하게 느낄 수 있는 청량한 라거"),
    LARGER_ON_THE_BEACH(LARGER, "Larger on the beach", BigDecimal.valueOf(5900), "열대과일의 맛이 느껴지는 쿨한 느낌의 라거"),
    DARK_LARGER(LARGER, "Dark Larger", BigDecimal.valueOf(4900), "구운보리의 고소함이 입암 가득 느꺄지는 라거 스타일의 흑맥주"),

    // AIL
    STRAWBERRY_CHOCOLATE_STOUT(ALE, "Strawberry chocolate stout", BigDecimal.valueOf(7900), "초콜릿과 딸기의 진한 여운이 입안에 오랜 감도는 프리미엄 스타우트"),
    STOUT(ALE, "stout", BigDecimal.valueOf(6900), "초콜릿과 커피, 로스팅한 보리의 맛과 향을 제대로 담은 진한 흑맥주"),
    IPA(ALE, "IPA", BigDecimal.valueOf(5900), "홉의 향긋함과 진하고 강한 바디감을 가진 수제맥주의 대명사"),
    PALE_ALE(ALE, "Pale Ale", BigDecimal.valueOf(5900), "향긋한 과일향과 쌉싸름한맛이 조화로운 에일의 교과서"),

    // PIZZA
    CLASSIC_CHEESE_PIZZA(PIZZA, "Classic Cheese Pizza", BigDecimal.valueOf(21900), "모짜렐라치즈, 홈밀크티즈, 고다치즈, 체다치즈 4가지 다양한 치즈가 어우러진 고소한 피자"),
    PEPPERONI_PIZZA(PIZZA, "Pepperoni Pizza", BigDecimal.valueOf(21900), "잘 구워진 페퍼로니와 치즈의 풍미가 어우러진 시그니처 피자"),
    POTATO_PIZZA(PIZZA, "Potato Pizza", BigDecimal.valueOf(21900), "포슬포슬 감자와 양파, 그리고 베이컨이 더해진 피자"),

    // SALAD
    CAJUN_CHICKEN_SALAD(SALAD, "Cajun Chicken Salad", BigDecimal.valueOf(16000), "신선한 야채가 듬뿍 들어간 치킨 샐러드"),
    RICOTTA_CHEESE_SALAD(SALAD, "Ricotta Cheese Salad", BigDecimal.valueOf(8900), "리코타치즈, 방울토마토, 아몬드, 발사믹소스를 곁들인 샐러드"),

    // SODA
    GRAPEFRUIT_ADE(SODA, "Grapefruit Ade", BigDecimal.valueOf(5000), "상큼한 자몽 에이드"),
    COCA_COLA(SODA, "Coca Cola", BigDecimal.valueOf(3000), "");

    private final MenuCategory category;
    private final String name;
    private final BigDecimal price;
    private final String description;

    Product(final MenuCategory category, final String name, final BigDecimal price, final String description) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
