package test.retail.retailstore;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import test.retail.retailstore.adapter.ProductAdapter;
import test.retail.retailstore.bean.SingleItem;
import test.retail.retailstore.utility.RecyclerItemClickListener;
import test.retail.retailstore.utility.Utility;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter mAdapter;
    private List<SingleItem> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_products);

        String category = (String) getIntent().getExtras().getString("categorySelected");

        if(category.equals("Electronics"))
            productList = Utility.electronicsItems;
        else
            productList= Utility.furnitureItems;


        mAdapter = new ProductAdapter(this,productList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        SingleItem sci = productList.get(position);
                        Intent i = new Intent(ProductsActivity.this, DetailActivity.class);
                        i.putExtra("singleCartItem",sci.getName());
                        ProductsActivity.this.startActivity(i);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );




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
        Intent i = new Intent(ProductsActivity.this, CartActivity.class);
        ProductsActivity.this.startActivity(i);
    }
}
