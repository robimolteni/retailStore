package test.retail.retailstore;

import android.view.View;

import java.util.List;

import test.retail.retailstore.bean.SingleCartItem;
import test.retail.retailstore.bean.SingleItem;

/**
 * Created by robimolte on 19/04/2017.
 */

public interface CartOperationInterface {


    interface View {
        void addItemToCart(SingleItem item);
        void deleteItemFromCart(SingleCartItem item);
        List<SingleCartItem> getAllCartItem();

    }

    interface Presenter {

        //getList
        void addItemToCart(SingleItem item);
        void deleteItemFromCart(SingleCartItem item);
        List<SingleCartItem> getAllCartItem();

    }

    interface Model {

        //getList
        void addItemToCart(SingleItem item);
        void deleteItemFromCart(SingleCartItem item);
        List<SingleCartItem> getAllCartItem();

    }
}
