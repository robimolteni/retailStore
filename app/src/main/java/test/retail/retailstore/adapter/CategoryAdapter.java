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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>{

    private List<String> categoryList;
    private final Context mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category_name;

        public MyViewHolder(final View view) {
            super(view);
            category_name = (TextView) view.findViewById(R.id.category_name);
        }
    }


    public CategoryAdapter(Context context,List<String> categoryList) {
        mContext = context;
        this.categoryList = categoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.single_category_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String singleCategory = categoryList.get(position);
        holder.category_name.setText(singleCategory);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}