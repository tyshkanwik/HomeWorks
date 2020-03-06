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

    //http://developer.alexanderklimov.ru/android/kotlin/companion.php
    companion object {
        //Константы именуются в таком стиле и содержат ключевое слово const
        const val APP_PREFERENCES = "app_preferences"
        const val KEY_INCREMENT_VALUE = "increment_value"
    }

    private var valueText: TextView? = null
    private var incrementButton: FloatingActionButton? = null
    private var container: ConstraintLayout? = null
    private var navigationButton: Button? = null

    //https://medium.com/nuances-of-programming/использование-свойств-lazy-в-kotlin-для-связывания-представлений-android-65844048c465
    private val preferences: SharedPreferences by lazy {
        getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )
    }

    private var resultValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        valueText?.text = preferences.getInt(KEY_INCREMENT_VALUE, 0).toString()
        resultValue = preferences.getInt(KEY_INCREMENT_VALUE, 0)

        incrementButton?.setOnClickListener {
            resultValue++
            valueText?.text = resultValue.toString()
            saveIncrementValue(resultValue)
        }

        container?.setOnClickListener {
            resultValue++
            valueText?.text = resultValue.toString()
            saveIncrementValue(resultValue)
        }


        navigationButton?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


    private fun initViews() {
        valueText = findViewById(R.id.value)
        incrementButton = findViewById(R.id.increment)
        container = findViewById(R.id.container)
        navigationButton = findViewById(R.id.navigation_button)
    }

    //Принцип DRY(Don't repeat yourself) Загугли и почитай
    private fun saveIncrementValue(value: Int) {
        preferences.edit().putInt(KEY_INCREMENT_VALUE, value).apply()
    }
}
