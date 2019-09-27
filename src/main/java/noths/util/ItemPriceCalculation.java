package noths.util;

import noths.models.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ItemPriceCalculation {

    public static double calculate(List<Item> items) {

        double price = items.stream()
                .map(Item::getPrice)
                .reduce(0d, (a,b) -> a+b);

        BigDecimal bd = BigDecimal.valueOf(price);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
