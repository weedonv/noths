package noths.promotions;

import noths.models.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Over60PoundsGet10PercentOff implements PromotionalRule {

    @Override
    public Double getPromotionalPrice(List<Item> items, double initialPrice) {
        initialPrice = initialPrice > 60.00 ? initialPrice - initialPrice * 0.10 : initialPrice;

        BigDecimal bd = BigDecimal.valueOf(initialPrice);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public int getPriority() {
        return 2;
    }

}
