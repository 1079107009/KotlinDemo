package com.lp.kotlindemo.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lp.kotlindemo.R


class SplashActivity : android.support.v7.app.AppCompatActivity() {

//    var mSpJumpBtn: Button = null
//    var bg: ImageView = null
//    val countDownTimer = object : CountDownTimer(4000, 1000) {
//        override fun onTick(millisUntilFinished: Long) {
//            mSpJumpBtn.text = "跳过(" + millisUntilFinished / 1000 + "s)"
//        }
//
//        override fun onFinish() {
//            mSpJumpBtn.text = "跳过(" + 0 + "s)"
//            gotoLoginOrMainActivity()
//        }
//    }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.lp.kotlindemo.R.layout.activity_splash)
//        mSpJumpBtn = findViewById(R.id.sp_jump_btn) as Button
//        bg = findViewById(R.id.sp_bg) as ImageView
    }
}
