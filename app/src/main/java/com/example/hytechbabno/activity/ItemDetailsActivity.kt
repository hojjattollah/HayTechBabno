package com.example.hytechbabno.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hytechbabno.R
import com.example.hytechbabno.databinding.ActivityItemDetailsBinding
import com.example.hytechbabno.model.Item

class ItemDetailsActivity : AppCompatActivity() {
    private var userName: String? = null
    private var userLastName: String? = null
    private var userJob: String? = null
    private var userGender = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ///get login values
        userInfoFromLoginPage

        ///create data model from login values
        var userGenderValue: String
        if (userGender == LoginActivity.MALE_ID) {
            userGenderValue = "Gender: Male"
        } else {
            userGenderValue = "Gender: Female"
        }
        val item: Item = Item("Name: $userName", "LastName: $userLastName", "Job: $userJob", "Job: $userGenderValue")


        ///data Binding!
        val binding: ActivityItemDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_item_details)
        binding.item = item
    }

    private val userInfoFromLoginPage: Unit
        private get() {
            val bundle = intent.extras
            if (bundle != null) {
                userName = bundle.getString("name")
                userLastName = bundle.getString("last_name")
                userJob = bundle.getString("job")
                userGender = bundle.getInt("gender")
            }
        }
}