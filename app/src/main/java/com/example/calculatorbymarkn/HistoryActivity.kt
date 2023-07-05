package com.example.calculatorbymarkn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val historyList = intent.getStringArrayExtra("history_list") ?: arrayOf()
        Log.d("HistoryActivity", "history list size: ${historyList.size}")
    }
}