package com.example.hytechbabno.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.hytechbabno.R;
import com.example.hytechbabno.databinding.ActivityLoginBinding;
import com.example.hytechbabno.databinding.ActivityMainBinding;
import com.example.hytechbabno.model.Item;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    public static final int MALE_ID = 0;
    public static final int FEMALE_ID = 1;
    private int gender;
    private ActivityLoginBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        viewDataBinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }


    private void Login() {
        ///get views Value From User
        String name = viewDataBinding.nameEditText.getText().toString();
        String lastName = viewDataBinding.lastNameEditText.getText().toString();
        String job = viewDataBinding.jobEditText.getText().toString();

        ///get gender from radio buttons!
        viewDataBinding.maleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    gender = MALE_ID;
                }
            }
        });

        viewDataBinding.femaleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    gender = FEMALE_ID;
                }
            }
        });


        if (!name.isEmpty() && !lastName.isEmpty() && !job.isEmpty()) {
            Intent intent = new Intent(this, ItemDetailsActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("last_name", lastName);
            intent.putExtra("job", job);
            intent.putExtra("gender", gender);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Please enter all the values", Toast.LENGTH_SHORT).show();
        }
    }
}