package noths.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    Item item;

    @Before
    public void before() {
        item = new Item();
        item.setProductCode("001");
        item.setPrice(9.25);
        item.setName("Travel Card Holder");
    }

    @Test
    public void getProductCode() {
        assertEquals( "001", item.getProductCode());
    }

    @Test
    public void getName() {
        assertEquals( "Travel Card Holder", item.getName());
    }

    @Test
    public void getPrice() {
        assertEquals( 9.25, item.getPrice(), 0d);
    }

}