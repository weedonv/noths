package noths.api;

import noths.models.Item;

import java.util.List;

public interface CheckOut {
    /**
     * @param items
     * I presume this param would be created from a HTTP request from the Front end with a list of product codes
     * Using the product codes you could look up what the item is in a DB or Product Management System
     * Then use that information to create these items data models.
     */
    Double calculateFinalPrice(List<Item> items);
}
