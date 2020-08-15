package com.example.awesomedialog

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.awesomedialog.AwesomeDialog.Companion.body
import com.example.awesomedialog.AwesomeDialog.Companion.icon
import com.example.awesomedialog.AwesomeDialog.Companion.onNegative
import com.example.awesomedialog.AwesomeDialog.Companion.onPositive
import com.example.awesomedialog.AwesomeDialog.Companion.title

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            AwesomeDialog.createDialog(this)
                .title("Congratulations")
                .body("Your Payoneer Account has been linked")
                .icon(R.drawable.ic_congrts)
                .onPositive("Go To My Account") {
                    Log.d("TAG", "positive ")
                }
            /*  .onNegative("Cancel") {
                  Log.d("TAG", "negative ")
              }*/
        }, 2000)
    }
}