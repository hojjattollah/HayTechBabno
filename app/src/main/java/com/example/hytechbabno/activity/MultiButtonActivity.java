package com.example.hytechbabno.activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.babnowidgets.button.multibutton.ItemStyleModel;
import com.example.babnowidgets.button.multibutton.MultiButtonView;
import com.example.hytechbabno.R;

public class MultiButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_button);


        ConstraintLayout rootView = (ConstraintLayout) findViewById(R.id.clt_container);
        ConstraintLayout firstContainer = (ConstraintLayout) findViewById(R.id.clt_firstContainer);
        ConstraintLayout secondContainer = (ConstraintLayout) findViewById(R.id.clt_secondContainer);
        MultiButtonView multiButtonView = (MultiButtonView) findViewById(R.id.cv_multiButtonView);
//        String[] itemNames={"آیتم 1","آیتم 2","آیتم 3"};
//        multiButtonView.setItemsStyle(multiButtonView.createItemStyleListByName(itemNames));
//        ItemStyleModel selectedItemStyle = multiButtonView.getSelectedItemStyle();
//        ItemStyleModel vouria = selectedItemStyle.getBuilder().setLabelText("vouria").build();
//        multiButtonView.setItemsStyle(createItemStyleList(9));
//        multiButtonView.setItemDefaultSelect(5);
//        multiButtonView.setSelectedItemStyle(vouria);
//        multiButtonView.setUnSelectedItemStyle(getUnSelectedItemStyle(getBaseContext()));
//        ItemStyleModel unSelectedItemStyle = multiButtonView.createUnSelectedItemStyle();
//        ItemStyleModel yousof = unSelectedItemStyle.getBuilder().setLabelText("yousof").build();
//        multiButtonView.setUnSelectedItemStyle(yousof);
//        ItemStyleModel selectedItemStyle = multiButtonView.getSelectedItemStyle();
//        selectedItemStyle.getBuilder()
//                .setLabelTextColor(Color.RED)
//                .update(selectedItemStyle);
//        multiButtonView.setSelectedItemStyle(selectedItemStyle);
        multiButtonView.getRecyclerView().addItemDecoration(new DividerItemDecoration(getBaseContext(), DividerItemDecoration.HORIZONTAL));


//        MultiButtonView multiButtonView0 = new MultiButtonView(getBaseContext());
//        multiButtonView0.setNumberOfItem(5);
//        multiButtonView0.setItemsStyle(multiButtonView0.createItemStyleListByName(itemNames));
//        multiButtonView0.setSelectedItemStyle(multiButtonView0.createSelectedItemStyle());
//        multiButtonView0.setItemSpace(10);
//        multiButtonView0.setItemDefaultSelect(4);
//        multiButtonView0.setGraidColumn(3);
//        firstContainer.addView(multiButtonView0);

    }

}