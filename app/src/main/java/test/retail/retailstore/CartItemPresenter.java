package test.retail.retailstore;

import android.content.Context;

import java.util.List;

import test.retail.retailstore.bean.SingleCartItem;
import test.retail.retailstore.bean.SingleItem;

/**
 * Created by robimolte on 19/04/2017.
 */

public class CartItemPresenter implements CartOperationInterface.Presenter {


    private CartOperationInterface.Model model;

    public CartItemPresenter(Context context) {
        this.model = new CartItemModel(context);
    }

    @Override
    public void addItemToCart(SingleItem item) {

        this.model.addItemToCart(item);

    }

    @Override
    public void deleteItemFromCart(SingleCartItem item) {

        this.model.deleteItemFromCart(item);

    }

    @Override
    public List<SingleCartItem> getAllCartItem() {

        List<SingleCartItem> singleCartItemList = this.model.getAllCartItem();

        return singleCartItemList;


    }
}
