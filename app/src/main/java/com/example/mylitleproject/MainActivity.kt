package com.example.mylitleproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private var appPreferences = "settings"
    private var appResultvalue = 1.toString()

    private var resultValue = 1
    private var valueText: TextView? = null
    private var incrementButton: FloatingActionButton? = null
    private var container: ConstraintLayout? = null
    private var navigationButton: Button? = null
    private var mSettings: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        mSettings = getSharedPreferences(appPreferences, Context.MODE_PRIVATE)

        valueText?.text = mSettings?.getInt(appResultvalue, 0).toString()

        incrementButton?.setOnClickListener {
            resultValue++
            valueText?.text = resultValue.toString()
            val editor = mSettings?.edit()
            editor?.putInt(appResultvalue.toString(), resultValue)
            editor?.apply()
        }

        container?.setOnClickListener {
            resultValue++
            valueText?.text = resultValue.toString()
            val editor = mSettings?.edit()
            editor?.putInt(appResultvalue.toString(), resultValue)
            editor?.apply()
        }


        navigationButton?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onResume() {
        super.onResume()
    }

    private fun initViews() {
        valueText = findViewById(R.id.value)
        incrementButton = findViewById(R.id.increment)
        container = findViewById(R.id.container)
        navigationButton = findViewById(R.id.navigation_button)
    }
}
