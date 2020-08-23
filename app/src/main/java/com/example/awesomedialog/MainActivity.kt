package com.example.awesomedialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val title = "Congratulations"
        val body = "Your New Account has been created"
        val goToMyAccount = "Go To My Account"
        val cancel = "Cancel"
        first.setOnClickListener {
            AwesomeDialog.build(this)
                .title(title)
                .body(body)
        }
        second.setOnClickListener {
            AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .icon(R.drawable.ic_congrts)
        }
        third.setOnClickListener {
            AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .icon(R.drawable.ic_congrts)
                .onPositive(goToMyAccount) {
                    Log.d("TAG", "positive ")
                }
        }
        fourth.setOnClickListener {
            AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .icon(R.drawable.ic_congrts)
                .onPositive(goToMyAccount) {
                    Log.d("TAG", "positive ")
                }
                .onNegative(cancel) {
                    Log.d("TAG", "negative ")
                }
        }
        fifth.setOnClickListener {
            AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .onPositive(goToMyAccount) {
                    Log.d("TAG", "positive ")
                }
        }
        sixth.setOnClickListener {
            AwesomeDialog.build(this)
                .title(title)
                .body(body)
                .onPositive(goToMyAccount) {
                    Log.d("TAG", "positive ")
                }
                .onNegative(cancel) {
                    Log.d("TAG", "negative ")
                }
        }
        seventh.setOnClickListener {
            AwesomeDialog.build(this)
                .title(
                    title,
                    titleColor = ContextCompat.getColor(this, android.R.color.white)
                )
                .body(
                    body,
                    color = ContextCompat.getColor(this, android.R.color.white)
                )
                .background(R.drawable.layout_rounded_green)
                .onPositive(
                    goToMyAccount,
                    buttonBackgroundColor = R.drawable.layout_rounded_dark_white,
                    textColor = ContextCompat.getColor(this, android.R.color.black)
                ) {
                    Log.d("TAG", "positive ")
                }
                .onNegative(
                    cancel,
                    buttonBackgroundColor = R.drawable.layout_rounded_dark_white,
                    textColor = ContextCompat.getColor(this, android.R.color.black)
                ) {
                    Log.d("TAG", "negative ")
                }
        }
        eighth.setOnClickListener {
            AwesomeDialog.build(this)
                .title(
                    title,
                    titleColor = ContextCompat.getColor(this, android.R.color.white)
                )
                .body(
                    body,
                    color = ContextCompat.getColor(this, android.R.color.white)
                )
                .icon(R.drawable.ic_congrts)
                .background(R.drawable.layout_rounded_green)
                .onPositive(
                    goToMyAccount,
                    buttonBackgroundColor = R.drawable.layout_rounded_dark_white,
                    textColor = ContextCompat.getColor(this, android.R.color.black)
                ) {
                    Log.d("TAG", "positive ")
                }
        }
        nine.setOnClickListener {
            AwesomeDialog.build(this)
                .title(
                    title,
                    titleColor = ContextCompat.getColor(this, android.R.color.white)
                )
                .body(
                    body,
                    color = ContextCompat.getColor(this, android.R.color.white)
                )
                .icon(R.drawable.ic_congrts)
                .background(R.drawable.layout_rounded_green)
                .position(AwesomeDialog.POSITIONS.CENTER)
                .onPositive(
                    goToMyAccount,
                    buttonBackgroundColor = R.drawable.layout_rounded_dark_white,
                    textColor = ContextCompat.getColor(this, android.R.color.black)
                ) {
                    Log.d("TAG", "positive ")
                }
        }
    }
}