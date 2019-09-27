package noths.promotions;

import noths.models.Item;

import java.util.List;

public interface PromotionalRule {
    Double getPromotionalPrice(List<Item> items, double initialPrice);
    int getPriority();
}
