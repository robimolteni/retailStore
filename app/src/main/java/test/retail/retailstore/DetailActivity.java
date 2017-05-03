package test.retail.retailstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.retail.retailstore.bean.SingleCartItem;
import test.retail.retailstore.bean.SingleItem;
import test.retail.retailstore.utility.Utility;

/**
 * Created by robimolte on 19/04/2017.
 */

public class DetailActivity extends AppCompatActivity implements CartOperationInterface.View {


    private TextView nameItem;
    private TextView categoryItem;
    private ImageView imageItem;
    private TextView priceItem;

    private SingleItem item;
    private String key;
    private Map<String,Integer> map = new HashMap<String, Integer>();

    CartItemPresenter cartItemPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //get item from the previous activity
        key = (String) getIntent().getExtras().getString("singleCartItem");

        item = Utility.map.get(key);
        initImages();

        nameItem = (TextView) findViewById(R.id.nameItem);
        categoryItem = (TextView) findViewById(R.id.categoryItem);
        imageItem = (ImageView) findViewById(R.id.imageItem);
        priceItem = (TextView) findViewById(R.id.priceItem);

        nameItem.setText(item.getName());
        categoryItem.setText(item.getCategory());

        imageItem.setImageResource(map.get(item.getImage()));

        priceItem.setText("The Price is : "+item.getCost());

        cartItemPresenter = new CartItemPresenter(this);


    }


    private void initImages(){
        map.put("almirah", R.drawable.almirah);
        map.put("chair", R.drawable.chair);
        map.put("microwave_oven", R.drawable.microwave_oven);
        map.put("table", R.drawable.table);
        map.put("television", R.drawable.television);
        map.put("vacuum_cleaner", R.drawable.vacuum_cleaner);
    }

    @Override
    public void addItemToCart(SingleItem item) {
        cartItemPresenter.addItemToCart(item);
    }

    public void onNewItemClick(View v)
    {
        Toast.makeText(this, "Item added to the cart", Toast.LENGTH_LONG).show();
        addItemToCart(item);
    }



    @Override
    public void deleteItemFromCart(SingleCartItem item) {

    }

    @Override
    public List<SingleCartItem> getAllCartItem() {

        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_item_cart:
                goToCart();
                return true;
            case android.R.id.home:
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToCart(){
        Intent i = new Intent(DetailActivity.this, CartActivity.class);
        DetailActivity.this.startActivity(i);
    }
}
