package test.retail.retailstore.root;

import android.app.Application;

import test.retail.retailstore.utility.Utility;

/**
 * Created by robimolte on 20/04/2017.
 */

public class StartApplication extends Application {

    public int myInt;
    @Override
    public void onCreate() {
        super.onCreate();
        //Load initial data
        Utility.createCategories();;
        Utility.createListItems();;
    }
}

