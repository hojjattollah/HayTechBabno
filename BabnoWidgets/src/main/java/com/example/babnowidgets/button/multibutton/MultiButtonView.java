package com.example.babnowidgets.button.multibutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.babnowidgets.R;

import java.util.ArrayList;
import java.util.List;

public class MultiButtonView extends ConstraintLayout implements BaseListAdapter.OnItemLongClickListener<ItemStyleModel>, BaseListAdapter.OnItemClickListener<ItemStyleModel> {
    private static final int NONE_SET_VALUE = -1;
    private final Context context;
    private RecyclerView recyclerView;
    private MultiButtonAdapter adapter;
    private List<ItemStyleModel> itemsStyle = null;
    private ItemStyleModel selectedItemStyle;
    private ItemStyleModel unSelectedItemStyle;
    private int numberOfItem;
    private int itemSpace = NONE_SET_VALUE;
    private int graidColumn = NONE_SET_VALUE;
    private int itemDefaultSelect = NONE_SET_VALUE;
    private LinearLayoutManager layoutManager;


    public MultiButtonView(@NonNull Context context) {
        super(context);
        this.context = context;
        inflateView();
    }

    public MultiButtonView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initStyle(context, attrs);
        inflateView();
    }


    private void inflateView() {
        if (this.itemsStyle != null) {
            setAdapter();
        } else prepareData();

    }

    private void setAdapter() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = (ConstraintLayout) layoutInflater.inflate(R.layout.view_multi_button, this, true);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        if (graidColumn > 0) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, graidColumn);
            //0 means sunday and 6 means saturday
//            final int startMounthDayInWeek = 0;
//            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                @Override
//                public int getSpanSize(int position) {
//                    if (position == 0 && startMounthDayInWeek < graidColumn)
//                        return startMounthDayInWeek + 1;
//                    else return 1;
//                }
//            });
            layoutManager = gridLayoutManager;

        }
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MultiButtonAdapter(context, itemsStyle, this, this);

        if (selectedItemStyle == null)
            selectedItemStyle = createSelectedItemStyle();
        adapter.setSelectedItemStyle(selectedItemStyle);

        recyclerView.addItemDecoration(new SpacesItemDecoration());
        recyclerView.setAdapter(adapter);
        adapter.setSelectedItemPosition(itemDefaultSelect);
//            recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.HORIZONTAL));
    }

    private void initStyle(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MultiButtonView);
        if (typedArray.hasValue(R.styleable.MultiButtonView_cv_mbv_itemCount)) {
            numberOfItem = typedArray.getInt(R.styleable.MultiButtonView_cv_mbv_itemCount, 0);
        }
        itemSpace = typedArray.getInt(R.styleable.MultiButtonView_cv_mbv_itemSpace, NONE_SET_VALUE);
        graidColumn = typedArray.getInt(R.styleable.MultiButtonView_cv_mbv_itemColumn, NONE_SET_VALUE);
        int defaultSelect = typedArray.getInt(R.styleable.MultiButtonView_cv_mbv_itemDefaultSelect, 0);
        if (NONE_SET_VALUE < defaultSelect && defaultSelect < numberOfItem)
            itemDefaultSelect = defaultSelect;
        else itemDefaultSelect = 0;
        typedArray.recycle();
    }

    private void prepareData() {
        itemsStyle = createItemStyleList(numberOfItem);
        selectedItemStyle = createSelectedItemStyle();
        inflateView();
    }

    public List<ItemStyleModel> createItemStyleList(int numberOfItem) {
        List<ItemStyleModel> items = new ArrayList<>();
        for (int i = 0; i < numberOfItem; i++) {
            items.add(createUnSelectedItemStyleByName("" + i));
        }
        return items;
    }

    public List<ItemStyleModel> createItemStyleListByName(String[] itemsName) {
        numberOfItem = itemsName.length;
        List<ItemStyleModel> items = new ArrayList<>();
        for (int i = 0; i < itemsName.length; i++) {
            items.add(createUnSelectedItemStyleByName(itemsName[i]));
        }
        return items;
    }

    public ItemStyleModel createUnSelectedItemStyle() {
        return ItemStyleModel.getUnSelectedItemStyle(context);
    }

    public ItemStyleModel createUnSelectedItemStyleByName(String itemName) {
        return ItemStyleModel.getUnSelectedItemStyleByName(context, itemName);
    }

    public ItemStyleModel createSelectedItemStyle() {
        return ItemStyleModel.getSelectedItemStyle(context);
    }


    @Override
    public void onItemClick(ItemStyleModel item, int position) {
        Log.i("LOG", item.getLabelText());
//        setGraidColumn(graidColumn + 1);

    }

    @Override
    public void onItemLongClick(ItemStyleModel item, int position) {
        Log.i("LOG", item.getLabelText());
//        setItemSpace(5);
    }


    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
        adapter = null;
        itemsStyle = null;
        inflateView();
    }

    public List<ItemStyleModel> getItemsStyle() {
        return itemsStyle;
    }

    public void setItemsStyle(List<ItemStyleModel> itemsStyle) {
        this.itemsStyle = itemsStyle;
        adapter.removeItems();
        adapter.setItems(itemsStyle);
    }

    public ItemStyleModel getSelectedItemStyle() {
        return selectedItemStyle;
    }

    public void setSelectedItemStyle(ItemStyleModel selectedItemStyle) {
        this.selectedItemStyle = selectedItemStyle;
        adapter.setSelectedItemStyle(this.selectedItemStyle);
    }

    public ItemStyleModel getUnSelectedItemStyle() {
        return unSelectedItemStyle;
    }

    public void setUnSelectedItemStyle(ItemStyleModel unSelectedItemStyle) {
        this.unSelectedItemStyle = unSelectedItemStyle;
        setItemsStyle(createItemStyleList(numberOfItem));
    }

    public int getItemSpace() {
        return itemSpace;
    }

    public void setItemSpace(int itemSpace) {
        this.itemSpace = itemSpace;
        adapter = null;
        itemsStyle = null;
        inflateView();
    }

    public int getGraidColumn() {
        return graidColumn;
    }

    public void setGraidColumn(int graidColumn) {
        this.graidColumn = graidColumn;
        adapter = null;
        itemsStyle = null;
        inflateView();
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public MultiButtonAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(MultiButtonAdapter adapter) {
        this.adapter = adapter;
    }

    public int getItemDefaultSelect() {
        return itemDefaultSelect;
    }

    public void setItemDefaultSelect(int itemDefaultSelect) {
        this.itemDefaultSelect = itemDefaultSelect;
        if (adapter != null) adapter.setSelectedItemPosition(itemDefaultSelect);
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        public SpacesItemDecoration() {
        }


        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (adapter.getItemCount() != 0) {

                ItemStyleModel item = adapter.getItem(parent.getChildLayoutPosition(view));
                if (itemSpace != NONE_SET_VALUE) {
                    item.getBuilder().setMarginLeft(itemSpace)
                            .setMarginTop(0)
                            .setMarginRight(itemSpace)
                            .setMarginBottom(0).update(item);

                }
                if (item != null && graidColumn == NONE_SET_VALUE) {
                    outRect.left = dp2px(item.getMarginRight());
                    outRect.top = dp2px(item.getMarginTop());
                    outRect.right = dp2px(item.getMarginRight());
                    outRect.bottom = dp2px(item.getMarginBottom());
                    // Add top margin only for the special item

                    if (parent.getChildLayoutPosition(view) == 0) {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            int layoutDirection = recyclerView.getLayoutDirection();
                            if (layoutDirection == LAYOUT_DIRECTION_LTR) {
                                outRect.left = 0;
                                outRect.right = dp2px(item.getMarginRight());
                            } else if (layoutDirection == LAYOUT_DIRECTION_RTL) {
                                outRect.left = dp2px(item.getMarginLeft());
                                outRect.right = 0;
                            }
                        }
                    } else if (parent.getChildLayoutPosition(view) == state.getItemCount() - 1) {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            int layoutDirection = recyclerView.getLayoutDirection();
                            if (layoutDirection == LAYOUT_DIRECTION_LTR) {
                                outRect.right = 0;
                                outRect.left = dp2px(item.getMarginLeft());
                            } else if (layoutDirection == LAYOUT_DIRECTION_RTL) {
                                outRect.left = 0;
                                outRect.right = dp2px(item.getMarginRight());
                            }
                        }
                    }

                } else {
                    outRect.left = itemSpace;
                    outRect.top = itemSpace;
                    outRect.right = itemSpace;
                    outRect.bottom = itemSpace;
                }
                if (itemSpace != NONE_SET_VALUE) {
                    item.getBuilder().setMarginLeft(itemSpace)
                            .setMarginTop(0)
                            .setMarginRight(itemSpace)
                            .setMarginBottom(0);
                }

            }
        }

        public int dp2px(float dpVal) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                    context.getResources().getDisplayMetrics());
        }
    }

}
