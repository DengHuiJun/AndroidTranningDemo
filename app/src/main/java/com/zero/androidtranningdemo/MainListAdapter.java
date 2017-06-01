package com.zero.androidtranningdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zero on 16-8-17.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ItemView> {
    private static final String TAG = "MainListAdapter";

    private static final int TYPE_HEAD = 1;
    private static final int TYPE_NORMAL = 2;

    private Context context;
    private List<RecyclerMainItem> items;
    private boolean isEditMode = false;
    private boolean isAnim = false;

    private View mHeaderView;

    public interface OnMainItemClickListener {
        void onMainItemClickListener(int id);
    }

    private OnMainItemClickListener mItemClickListener;

    public MainListAdapter(Context context, List<RecyclerMainItem> items) {
        this.context = context;
        this.items = items;
        mItemClickListener = (OnMainItemClickListener) context;
    }

    public void setItems(List<RecyclerMainItem> items) {
        this.items = items;
        notifyAll();
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public void setEditMode(boolean isEdit) {
        if (isEditMode && !isEdit) {
            // 编辑模式-》正常模式
        } else if (!isEditMode && isEdit) {
            // 正常模式 -》编辑模式
            isAnim = true;
        } else {
            return;
        }

        isEditMode = isEdit;
        notifyDataSetChanged();
    }

    public void setIsAnima(boolean isAnim) {
        this.isAnim = isAnim;
    }

    public boolean getEditMode() {
        return isEditMode;
    }

    @Override
    public ItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD && mHeaderView != null) {
            return new ItemView(mHeaderView);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.main_list_item, parent, false);
        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(ItemView holder, int position) {
        if (getItemViewType(position) == TYPE_HEAD) {
            return;
        }

        final int pos = getRealPosition(holder);
        final RecyclerMainItem item = items.get(pos);
        holder.textView.setText(item.getTitle());
        holder.itemLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onMainItemClickListener(item.getId());
                }
            }
        });

        if (pos == 0) {
            holder.title.setVisibility(View.VISIBLE);
        } else {
            holder.title.setVisibility(View.GONE);
        }

        if (isEditMode) {
            holder.deleteIv.setVisibility(View.VISIBLE);
            holder.deleteIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isEditMode = false;
                    notifyDataSetChanged();
                }
            });

            if (isAnim) {
                setEnterEditAnim(holder);
            }

        } else {
            holder.deleteIv.setVisibility(View.GONE);
        }
    }

    private void setEnterEditAnim(ItemView view) {
        float with = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, context.getResources().getDisplayMetrics());
        TranslateAnimation translateAnimation = new TranslateAnimation(-with, 0, 0, 0);
        translateAnimation.setDuration(300L);
        view.rightLy.startAnimation(translateAnimation);
    }

    private void exitEditAnim(ItemView view) {
        final int with = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, context.getResources().getDisplayMetrics());
    }

    private void slide(final View contentView, View deleteView, final int with) {
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(deleteView, "alpha", 0f, 1f);
        fadeInOut.setDuration(300L);

        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
        animator.setDuration(300L);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                float X = (int) (value * with);
                contentView.setX(X);
            }
        });
        animator.start();
        fadeInOut.start();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && mHeaderView != null) {
            return TYPE_HEAD;
        }
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? items.size() : items.size() + 1;
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    public class ItemView extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView deleteIv;
        LinearLayout rightLy;
        View itemLy;
        View title;

        public ItemView(View itemView){
            super(itemView);
            if (itemView == mHeaderView) {
                return;
            }

            deleteIv = (ImageView) itemView.findViewById(R.id.delete_iv);
            textView = (TextView) itemView.findViewById(R.id.main_item_title);
            itemLy = itemView.findViewById(R.id.main_item_ly);
            rightLy = (LinearLayout) itemView.findViewById(R.id.right_content_ly);
            title = itemView.findViewById(R.id.group_title);
        }
    }
}
