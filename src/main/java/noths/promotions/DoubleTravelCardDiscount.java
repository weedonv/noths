package noths.promotions;

import noths.models.Item;
import noths.util.ItemPriceCalculation;

import java.util.List;

public class DoubleTravelCardDiscount implements PromotionalRule {
    @Override
    public Double getPromotionalPrice(List<Item> items, double initialPrice) {
       long count = items.stream()
               .map(Item::getProductCode)
               .filter(str -> str.equals("001"))
               .count();
       if (count > 1) {
           items.forEach(item -> {
               if (item.getProductCode().equals("001")) {
                   item.setPrice(8.5);
               }
           });
           return ItemPriceCalculation.calculate(items);
       }

       return initialPrice;
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
