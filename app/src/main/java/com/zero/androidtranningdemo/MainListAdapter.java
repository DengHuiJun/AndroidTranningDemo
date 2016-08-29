package com.zero.androidtranningdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zero on 16-8-17.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ItemView> {
    private Context context;
    private List<RecyclerMainItem> items;

    public interface OnMainItemClickListener {
        void onMainItemClickListener(int id);
    }

    private OnMainItemClickListener mItemClickListener;

    public MainListAdapter(Context context, List<RecyclerMainItem> items) {
        this.context = context;
        this.items = items;
        mItemClickListener = (OnMainItemClickListener) context;
    }

    @Override
    public ItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_list_item, parent, false);
        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(ItemView holder, int position) {
        final RecyclerMainItem item = items.get(position);
        holder.imageView.setImageDrawable(item.getIconDrawable());
        holder.textView.setText(item.getTitle());
        holder.itemLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onMainItemClickListener(item.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemView extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        View itemLy;

        public ItemView(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.main_item_img);
            textView = (TextView) itemView.findViewById(R.id.main_item_title);
            itemLy = itemView.findViewById(R.id.main_item_ly);
        }
    }
}
