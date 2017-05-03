package test.retail.retailstore;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import test.retail.retailstore.bean.SingleCartItem;
import test.retail.retailstore.bean.SingleItem;
import test.retail.retailstore.utility.Utility;

import static junit.framework.Assert.assertEquals;

/**
 * Created by robimolte on 21/04/2017.
 */

public class UtilityTest {

    @Test
    public void checkTotalCost() {
        List<SingleCartItem> cartItems = new ArrayList<>();
        int price = Utility.getTotalItemPrice(cartItems);
        assertEquals(price,0);
    }

    @Test
    public void checkTotalCostItems() {

        List<SingleCartItem> cartItems = new ArrayList<>();
        cartItems.add(new SingleCartItem(1,"Television","Electronics", 50, "television"));
        cartItems.add(new SingleCartItem(2,"Almirah","Furniture", 40, "almirah"));

        int price = Utility.getTotalItemPrice(cartItems);
        assertEquals(price,90);
    }
}
