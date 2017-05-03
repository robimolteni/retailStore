package test.retail.retailstore.access_data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import test.retail.retailstore.access_data.Repository;
import test.retail.retailstore.bean.SingleCartItem;
import test.retail.retailstore.bean.SingleItem;
import test.retail.retailstore.access_data.MySQLiteHelper;

/**
 * Created by robimolte on 19/04/2017.
 */

public class DataRepository implements Repository {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    private String[] allColumns = { MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_ITEM_NAME,
            MySQLiteHelper.COLUMN_ITEM_CATEGORY,  MySQLiteHelper.COLUMN_ITEM_PRICE };

    public DataRepository(Context context){
        dbHelper = new MySQLiteHelper(context);

    }



    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }


    @Override
    public List<SingleCartItem> getAllCartItem() {
        List<SingleCartItem> allCartItems = new ArrayList<SingleCartItem>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            SingleCartItem comment = createSingleCartItem(cursor);
            allCartItems.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return allCartItems;    }

    @Override
    public void addCartItem(SingleItem cartItem) {

        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_ITEM_NAME,cartItem.getName());
        values.put(MySQLiteHelper.COLUMN_ITEM_CATEGORY,cartItem.getCategory());
        values.put(MySQLiteHelper.COLUMN_ITEM_PRICE,cartItem.getCost());

        long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        cursor.close();


    }

    @Override
    public void deleteCartItem(SingleCartItem cartItem) {

        long id = cartItem.getId();
        database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);

    }

    private SingleCartItem createSingleCartItem(Cursor cursor) {
        SingleCartItem singleCartItem = new SingleCartItem();
        singleCartItem.setId(cursor.getInt(0));
        singleCartItem.setName(cursor.getString(1));
        singleCartItem.setCategory(cursor.getString(2));
        singleCartItem.setCost(cursor.getInt(3));

        return singleCartItem;
    }
}
