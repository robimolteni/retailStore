package test.retail.retailstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import test.retail.retailstore.R;
import test.retail.retailstore.bean.SingleCartItem;

/**
 * Created by robimolte on 20/04/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{

    private List<SingleCartItem> cartList;
    private final Context mContext;



    // Define listener member variable
    private OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position,int id);
    }
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView cart_item_name, cart_item_price;
        public ImageButton cart_item_remove;

        public MyViewHolder(final View view) {
            super(view);
            cart_item_name = (TextView) view.findViewById(R.id.cart_item_name);
            cart_item_price = (TextView) view.findViewById(R.id.cart_item_price);
            cart_item_remove = (ImageButton) view.findViewById(R.id.cart_item_remove);

            //handle click remove item button
            cart_item_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(view, position,R.id.cart_item_remove);
                        }
                    }
                }
            });

            //click item
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(view, position,0);
                        }
                    }
                }
            });
        }


    }


    public CartAdapter(Context context,List<SingleCartItem> cartList) {
        mContext = context;
        this.cartList = cartList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.single_cart_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SingleCartItem singleCartItem = cartList.get(position);
        holder.cart_item_name.setText(singleCartItem.getName());
        holder.cart_item_price.setText(Integer.toString(singleCartItem.getCost()));
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
}