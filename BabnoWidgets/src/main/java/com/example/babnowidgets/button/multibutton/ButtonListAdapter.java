package com.example.babnowidgets.button.multibutton;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.babnowidgets.R;

import java.util.List;

public class ButtonListAdapter extends BaseListAdapter<String> {

    private final Context context;

    public ButtonListAdapter(Context context, @NonNull List<String> items, @Nullable OnItemClickListener<String> clickListener, @Nullable OnItemLongClickListener<String> longClickListener) {
        super(items, clickListener, longClickListener);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_multi_button, parent, false);
        return new MyViewHolder(view);
    }


    public class MyViewHolder extends ViewHolder {
        private TextView buttonItemLabel;

        public MyViewHolder(View view) {
            super(view);
            buttonItemLabel = (AppCompatTextView) itemView.findViewById(R.id.tv_buttonItemLabel);
        }


        @Override
        protected void onBind(String item) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) itemView.getLayoutParams();
//            params.width = dp2px(context, 56);
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.height = dp2px(context, 46);
            itemView.setLayoutParams(params);
            itemView.setPadding(dp2px(context, 8), dp2px(context, 8), dp2px(context, 8), dp2px(context, 8));
            buttonItemLabel.setText(item.toString());
        }

        @NonNull
        @Override
        protected String getItem() {
            return super.getItem();
        }

        @Override
        public void onClick(View v) {
            super.onClick(v);
        }

        @Override
        public boolean onLongClick(View v) {
            return super.onLongClick(v);
        }
    }

    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                context.getResources().getDisplayMetrics());
    }
}
