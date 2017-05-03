package test.retail.retailstore.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.retail.retailstore.bean.SingleCartItem;
import test.retail.retailstore.bean.SingleItem;

/**
 * Created by robimolte on 20/04/2017.
 */

public class Utility {

    public static List<SingleItem> electronicsItems = new ArrayList<>();
    public static List<SingleItem> furnitureItems = new ArrayList<>();
    public static List<String> categories = new ArrayList<>();
    public static  Map<String,SingleItem> map = new HashMap<String, SingleItem>();


    public static void createCategories(){
        categories.add("Electronics");
        categories.add("Furniture");
    }

    //List item can be hardcoded. They're not going to change
    public static void createListItems()
    {
        SingleItem cartItem = new SingleItem("Microwave Oven","Electronics", 53, "microwave_oven");
        electronicsItems.add(cartItem);
        map.put("Microwave Oven",cartItem);

        cartItem = new SingleItem("Television","Electronics", 28, "television");
        electronicsItems.add(cartItem);
        map.put("Television",cartItem);

        cartItem = new SingleItem("Vacuum Cleaner","Electronics", 50, "vacuum_cleaner");
        electronicsItems.add(cartItem);
        map.put("Vacuum Cleaner",cartItem);

        cartItem = new SingleItem("Table","Furniture", 30 , "table");
        furnitureItems.add(cartItem);
        map.put("Table",cartItem);

        cartItem = new SingleItem("Chair","Furniture", 32, "chair");
        furnitureItems.add(cartItem);
        map.put("Chair",cartItem);

        cartItem = new SingleItem("Almirah","Furniture", 22, "almirah");
        furnitureItems.add(cartItem);
        map.put("Almirah",cartItem);

    }


    public static int getTotalItemPrice(List<SingleCartItem> singleCartItemsList) {

        int totalPrice = 0;

        for(int i = 0; i < singleCartItemsList.size(); i++){
            totalPrice = totalPrice + singleCartItemsList.get(i).getCost();
        }

        return totalPrice;
    }

}
