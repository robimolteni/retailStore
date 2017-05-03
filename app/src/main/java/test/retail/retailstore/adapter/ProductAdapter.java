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
import test.retail.retailstore.bean.SingleItem;

/**
 * Created by robimolte on 20/04/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{

    private List<SingleItem> productList;
    private final Context mContext;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView product_name;

        public MyViewHolder(final View view) {
            super(view);
            product_name = (TextView) view.findViewById(R.id.name);
        }
    }



    public ProductAdapter(Context context,List<SingleItem> productList) {
        mContext = context;
        this.productList = productList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.single_item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SingleItem singleCartItem = productList.get(position);
        holder.product_name.setText(singleCartItem.getName());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}