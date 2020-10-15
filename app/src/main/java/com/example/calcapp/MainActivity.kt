package com.example.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var result by Delegates.notNull<Double>()

        if (editText1.text.toString().isEmpty() || editText2.text.toString().isEmpty()) {
            val snackbar = Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("OK") {}
            snackbar.show()
        } else {
            val num1: Double = editText1.text.toString().toDouble()
            val num2: Double = editText2.text.toString().toDouble()

            when (v.id) {
                R.id.button1 -> result = num1 + num2
                R.id.button2 -> result = num1 - num2
                R.id.button3 -> result = num1 * num2
                R.id.button4 -> result = num1 / num2
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }

    }

}