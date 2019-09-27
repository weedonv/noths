package noths.impl;

import noths.api.CheckOut;
import noths.models.Item;
import noths.promotions.PromotionalRule;
import noths.util.ItemPriceCalculation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TODO: Would expect this to be annotated as a service/component running in a servlet container
//could be a service factory assuming that is possible in springBoot
public class CheckOutImpl implements CheckOut {

    //TODO would presume this would be set by some config or easily changed on app restart
    //in AEM world this sort of thing would be content managed and a rules engine would be built around it, would be liable to change on demand in production.
    private List<PromotionalRule> promotionalRules = new ArrayList<>();

    @Override
    public Double calculateFinalPrice(List<Item> items) {

        double initialPrice = ItemPriceCalculation.calculate(items);

        return applyActivePromotionalRules(initialPrice, items);
    }

    private double applyActivePromotionalRules(double initialPrice, List<Item> items) {
        double finalPrice = initialPrice;

        for (PromotionalRule promotionalRule : getPromotionalRules()) {
            finalPrice = promotionalRule.getPromotionalPrice(items, finalPrice);
        }

        return finalPrice;
    }

    private List<PromotionalRule> getPromotionalRules() {
        //TODO improvement implement validation for priorities, throw exception if same priority used
        promotionalRules.sort(Comparator.comparingInt(PromotionalRule::getPriority));
        return promotionalRules;
    }

    public void setPromotionalRules(List<PromotionalRule> promotionalRules) {
        this.promotionalRules = promotionalRules;
    }

}
