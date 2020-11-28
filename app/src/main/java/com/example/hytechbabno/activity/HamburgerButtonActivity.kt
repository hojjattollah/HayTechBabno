package com.example.hytechbabno.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.babnowidgets.dialog.ToastStyleable
import com.example.hytechbabno.R
import kotlinx.android.synthetic.main.activity_hamburger_button.*


class HamburgerButtonActivity : AppCompatActivity(), View.OnClickListener {


    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hamburger_button)

        cv_filterBox.apply {
            searchButton.setOnClickListener(this@HamburgerButtonActivity)
        }
        cv_hamburgerButtonMenu.apply {
            iconMenu.setOnClickListener(this@HamburgerButtonActivity)
        }

        cv_searchBox.apply {
            searchButton.setOnClickListener(this@HamburgerButtonActivity)
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            cv_filterBox.searchButton.id -> {
                Toast.makeText(this, cv_filterBox.filterBox.text.toString(), Toast.LENGTH_LONG).show()
            }
            cv_hamburgerButtonMenu.iconMenu.id -> {
                Toast.makeText(this, "hamburgerButtonMenu", Toast.LENGTH_LONG).show()
                toastTest()
            }
            cv_searchBox.searchButton.id -> {
                Toast.makeText(this, cv_searchBox.searchBox.text.toString(), Toast.LENGTH_LONG).show()
                toastTestByBuilder()
            }
        }
    }

    private fun toastTest() {
        var testString: String = "  \n" +
                " \n" +
                " test is test \n" +
                " is test is test is \n" +
                "test is test \n" +
                "is test is test  \n"
        when (counter) {
            1 -> ToastStyleable.makeText(this, "ColoredBackground $testString", R.style.ColoredBackground).show()
            2 -> ToastStyleable.makeText(this, "ColoredStroke  $testString ", R.style.ColoredStroke).show()
            3 -> ToastStyleable.makeText(this, "ColoredBoldText  $testString ", R.style.ColoredBoldText).show()
            4 -> ToastStyleable.makeText(this, "BaseStyleableToast  $testString ", R.style.BaseStyleableToast).show()
            5 -> ToastStyleable.makeText(this, "CornerRadius5Dp  $testString ", R.style.CornerRadius5Dp).show()
            6 -> ToastStyleable.makeText(this, "CustomFont  $testString ", R.style.CustomFont).show()
            7 -> ToastStyleable.makeText(this, "IconEnd  $testString ", R.style.IconEnd).show()
            8 -> ToastStyleable.makeText(this, "IconStart  $testString ", R.style.IconStart).show()
            9 -> ToastStyleable.makeText(this, "IconStart  $testString ", R.style.AllStyles).show()
            10 -> counter = 1
        }
        counter++
    }

    private fun toastTestByBuilder() {
        var testString: String = "  \n" +
                " \n" +
                " test is test \n" +
                " is test is test is \n" +
                "test is test \n" +
                "is test is test  \n"
        var testString2: String = "  \n" +
                " \n  از این ارورهایی که ممکنه پیش بیاد و براش صفحه ای دیزاین نشده  "
        counter = 3
        when (counter) {
            1 -> {
                val cardColor = ContextCompat.getColor(this!!, R.color.default_background_color)
                ToastStyleable.Builder(this).text("Builder: ")
                        .backgroundColor(cardColor)
                        .show()
            }
            2 -> {
                ToastStyleable.Builder(this).text("Builder: ")
                        .text(testString2)
                        .stroke(2, Color.BLACK)
                        .backgroundColor(Color.WHITE)
                        .solidBackground()
                        .textColor(Color.RED)
                        .textBold()
                        .font(R.font.dosis)
                        .iconStart(R.drawable.ic_baseline_reply_24)
                        .iconEnd(R.drawable.ic_baseline_add_box_24)
                        .cornerRadius(12)
                        .textSize(18F)
                        .show();
            }
            3 -> {
                ToastStyleable.Builder(this).text("Builder: ")
                        .text(testString)
                        .stroke(2,resources.getColor(R.color.pink))
                        .backgroundColor(resources.getColor(R.color.pink))
                        .solidBackground()
                        .textColor(Color.RED)
                        .textBold()
                        .font(R.font.dosis)
                        .iconStart(R.drawable.ic_baseline_add_box_24)
                        .iconEnd(R.drawable.ic_close_black_24dp)
                        .cornerRadius(12)
                        .textSize(18F)
                        .show();
            }
            4 -> ToastStyleable.makeText(this, "BaseStyleableToast  $testString ", R.style.BaseStyleableToast).show()
            5 -> ToastStyleable.makeText(this, "CornerRadius5Dp  $testString ", R.style.CornerRadius5Dp).show()
            6 -> ToastStyleable.makeText(this, "CustomFont  $testString ", R.style.CustomFont).show()
            7 -> ToastStyleable.makeText(this, "IconEnd  $testString ", R.style.IconEnd).show()
            8 -> ToastStyleable.makeText(this, "IconStart  $testString ", R.style.IconStart).show()
            9 -> ToastStyleable.makeText(this, "IconStart  $testString ", R.style.AllStyles).show()
            10 -> counter = 1
        }
        counter++
    }
}
