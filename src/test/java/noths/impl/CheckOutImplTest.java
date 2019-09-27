package noths.impl;

import static org.junit.Assert.assertEquals;

import noths.api.CheckOut;
import noths.models.Item;
import noths.promotions.DoubleTravelCardDiscount;
import noths.promotions.Over60PoundsGet10PercentOff;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckOutImplTest {

    private CheckOut checkOut;
    private Item item1;
    private Item item2;
    private Item item3;

    @Before
    public void before() {
        checkOut = new CheckOutImpl();
        ((CheckOutImpl) checkOut).setPromotionalRules(Arrays.asList(new Over60PoundsGet10PercentOff(), new DoubleTravelCardDiscount()));

        buildTestItems();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testServiceBreaksIfFalsyCallMade() {
        assertEquals(19.95, checkOut.calculateFinalPrice(null),0d);
    }

    @Test
    public void noDiscountShouldApply() {
        List<Item> scenario = Collections.singletonList(item3);
        assertEquals(19.95, checkOut.calculateFinalPrice(scenario),0d);
    }

    @Test
    public void over60PoundDiscountShouldApply() {
        List<Item> scenario = Arrays.asList(item1, item2, item3);
        assertEquals(66.78, checkOut.calculateFinalPrice(scenario),0d);
    }

    @Test
    public void doubleTravelCardDiscountShouldApply() {
        List<Item> scenario = Arrays.asList(item1, item3, item1);
        assertEquals(36.95, checkOut.calculateFinalPrice(scenario),0d);
    }

    @Test
    public void over60AndDoubleTravelDiscountsApply() {
        List<Item> scenario = Arrays.asList(item1, item2, item3, item1);
        assertEquals(73.76, checkOut.calculateFinalPrice(scenario),0d);
    }

    private void buildTestItems() {
        item1 = new Item();
        item1.setProductCode("001");
        item1.setPrice(9.25);
        item1.setName("Travel Card Holder");

        item2 = new Item();
        item2.setProductCode("002");
        item2.setPrice(45.00);
        item2.setName("Personalised cufflinks");

        item3 = new Item();
        item3.setProductCode("003");
        item3.setPrice(19.95);
        item3.setName("Kids T-shirt");
    }
}
