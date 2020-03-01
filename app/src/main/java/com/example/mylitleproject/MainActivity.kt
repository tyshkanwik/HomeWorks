package com.example.mylitleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var resultValue = 1
    private var valueText: TextView? = null
    private var incrementButton: FloatingActionButton? = null
    private var container: ConstraintLayout? = null
    private var navigationButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        valueText?.text = resultValue.toString()
        incrementButton?.setOnClickListener {
            resultValue++
            valueText?.text = resultValue.toString()
        }
        container?.setOnClickListener {
            resultValue++
            valueText?.text = resultValue.toString()
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