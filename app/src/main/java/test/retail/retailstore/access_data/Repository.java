package test.retail.retailstore.access_data;

import java.util.List;

import test.retail.retailstore.bean.SingleCartItem;
import test.retail.retailstore.bean.SingleItem;

/**
 * Created by robimolte on 19/04/2017.
 */

public interface Repository {


        List<SingleCartItem> getAllCartItem();

        void addCartItem(SingleItem cartItem);

        void deleteCartItem(SingleCartItem cartItem);

}
