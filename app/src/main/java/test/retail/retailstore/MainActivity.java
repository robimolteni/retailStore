package test.retail.retailstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import test.retail.retailstore.adapter.CategoryAdapter;
import test.retail.retailstore.utility.RecyclerItemClickListener;
import test.retail.retailstore.utility.Utility;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private CategoryAdapter mAdapter;
    private List<String> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_products);

        categoryList = Utility.categories;


        mAdapter = new CategoryAdapter(this,categoryList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        String categorySelected = categoryList.get(position);
                        Intent i = new Intent(MainActivity.this, ProductsActivity.class);
                        i.putExtra("categorySelected",categorySelected);
                        MainActivity.this.startActivity(i);

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

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToCart(){
        Intent i = new Intent(MainActivity.this, CartActivity.class);
        MainActivity.this.startActivity(i);
    }


}
