package test.retail.retailstore;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.retail.retailstore.adapter.CartAdapter;
import test.retail.retailstore.bean.SingleCartItem;
import test.retail.retailstore.bean.SingleItem;
import test.retail.retailstore.utility.Utility;

/**
 * Created by robimolte on 19/04/2017.
 */

public class CartActivity extends AppCompatActivity implements CartOperationInterface.View {

    CartItemPresenter cartItemPresenter;
    List<SingleCartItem> singleCartItemsList = new ArrayList<>();

    private RecyclerView recyclerView;
    private CartAdapter mAdapter;

    SingleCartItem itemToRemove = null;

    private TextView cartEmptySection;
    private RelativeLayout cartNoEmptySection;
    TextView priceCart;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        cartEmptySection = (TextView) findViewById(R.id.text_cart_empty);
        cartNoEmptySection = (RelativeLayout) findViewById(R.id.section_cart_no_empty);

        priceCart = (TextView) findViewById(R.id.priceCart);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_cart);

        cartItemPresenter = new CartItemPresenter(this);
        singleCartItemsList = getAllCartItem();

        setActiveSection();

        mAdapter = new CartAdapter(this,singleCartItemsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new CartAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position,int id) {


                if(id == R.id.cart_item_remove){

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CartActivity.this);
                    alertDialogBuilder.setMessage("Are you sure to remove "+singleCartItemsList.get(position).getName()+" ?" ).setPositiveButton("Yes", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();
                    itemToRemove = singleCartItemsList.get(position);

                }
                else {
                    //go to details
                    SingleCartItem sci = singleCartItemsList.get(position);
                    Intent i = new Intent(CartActivity.this, DetailActivity.class);
                    i.putExtra("singleCartItem",sci.getName());
                    CartActivity.this.startActivity(i);

                }

            }
        });

    }

    public void setActiveSection(){

        if(singleCartItemsList.size() == 0) {
            cartEmptySection.setVisibility(View.VISIBLE);
            cartNoEmptySection.setVisibility(View.GONE);
        }
        else {
            cartEmptySection.setVisibility(View.GONE);
            cartNoEmptySection.setVisibility(View.VISIBLE);
            int totalCost = Utility.getTotalItemPrice(singleCartItemsList);
            priceCart.setText("The total price is : "+totalCost);
        }
    }


    @Override
    public void addItemToCart(SingleItem item) {

    }

    @Override
    public void deleteItemFromCart(SingleCartItem item) {

        cartItemPresenter.deleteItemFromCart(item);

    }

    @Override
    public List<SingleCartItem> getAllCartItem() {

        List<SingleCartItem> singleCartItems = cartItemPresenter.getAllCartItem();
        return singleCartItems;
    }



    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:

                    if(itemToRemove != null){
                        deleteItemFromCart(itemToRemove);
                        singleCartItemsList.remove(itemToRemove);
                        int totalCost = Utility.getTotalItemPrice(singleCartItemsList);

                        priceCart.setText("The total price is : "+totalCost);
                        mAdapter.notifyDataSetChanged();
                        setActiveSection();

                    }
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
