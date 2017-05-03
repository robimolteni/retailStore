package test.retail.retailstore;

import android.content.Context;

import java.util.List;

import test.retail.retailstore.access_data.DataRepository;
import test.retail.retailstore.bean.SingleCartItem;
import test.retail.retailstore.bean.SingleItem;

/**
 * Created by robimolte on 19/04/2017.
 */

public class CartItemModel implements CartOperationInterface.Model {


    private DataRepository dataRepository;


    public CartItemModel(Context context) {
        this.dataRepository = new DataRepository(context);
        dataRepository.open();
    }


    @Override
    public void addItemToCart(SingleItem item) {

        dataRepository.addCartItem(item);
    }

    @Override
    public void deleteItemFromCart(SingleCartItem item) {

        dataRepository.deleteCartItem(item);

    }

    @Override
    public List<SingleCartItem> getAllCartItem() {
        List<SingleCartItem> singleCartItemList = dataRepository.getAllCartItem();
        return singleCartItemList;
    }
}
