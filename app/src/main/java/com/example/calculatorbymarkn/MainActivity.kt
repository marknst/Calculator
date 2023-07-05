package com.example.calculatorbymarkn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculatorbymarkn.databinding.ActivityMainBinding
import com.ezylang.evalex.Expression
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val historyList = mutableListOf<String>()

    private lateinit var binding: ActivityMainBinding
    private val stringBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initializeCalculator()
    }

    private fun initializeCalculator() = with(binding) {

        zeroButton.setOnClickListener {
            stringBuilder.append(0)
            resultTextView.text = stringBuilder
        }

        oneButton.setOnClickListener {
            stringBuilder.append(1)
            resultTextView.text = stringBuilder
        }

        twoButton.setOnClickListener {
            stringBuilder.append(2)
            resultTextView.text = stringBuilder
        }

        threeButton.setOnClickListener {
            stringBuilder.append(3)
            resultTextView.text = stringBuilder
        }

        fourButton.setOnClickListener {
            stringBuilder.append(4)
            resultTextView.text = stringBuilder
        }

        fiveButton.setOnClickListener {
            stringBuilder.append(5)
            resultTextView.text = stringBuilder
        }

        sixButton.setOnClickListener {
            stringBuilder.append(6)
            resultTextView.text = stringBuilder
        }

        sevenButton.setOnClickListener {
            stringBuilder.append(7)
            resultTextView.text = stringBuilder
        }

        eightButton.setOnClickListener {
            stringBuilder.append(8)
            resultTextView.text = stringBuilder
        }

        nineButton.setOnClickListener {
            stringBuilder.append(9)
            resultTextView.text = stringBuilder
        }

        openingBracketButton.setOnClickListener {
            stringBuilder.append("(")
            resultTextView.text = stringBuilder
        }

        closingBracketButton.setOnClickListener {
            stringBuilder.append(")")
            resultTextView.text = stringBuilder
        }

        pointButton.setOnClickListener {
            stringBuilder.append(".")
            resultTextView.text = stringBuilder
        }

        plusButton.setOnClickListener {
            stringBuilder.append("+")
            resultTextView.text = stringBuilder
        }

        minusButton.setOnClickListener {
            stringBuilder.append("-")
            resultTextView.text = stringBuilder
        }

        divideButton.setOnClickListener {
            stringBuilder.append("/")
            resultTextView.text = stringBuilder
        }

        multiplyButton.setOnClickListener {
            stringBuilder.append("*")
            resultTextView.text = stringBuilder
        }

        clearButton.setOnClickListener {
            stringBuilder.clear()
            resultTextView.text = "0"
        }

        clearLastButton.setOnClickListener {

            if (stringBuilder.isNotEmpty()) {
                stringBuilder.deleteCharAt(stringBuilder.length-1)
                resultTextView.text = stringBuilder.toString()
            }

            if (stringBuilder.isEmpty()) {
                resultTextView.text = "0"
            }
        }

        equalButton.setOnClickListener {
            saveToHistory()
            calculate()
        }

        historyButton.setOnClickListener {
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            intent.putExtra("history_list", historyList.toTypedArray())
            startActivity(intent)
        }
    }

    private fun saveToHistory () {
        val expression = stringBuilder.toString()
        historyList.add(expression)
    }

    private fun ActivityMainBinding.calculate() {
        try {
            val expression = Expression(stringBuilder.toString())
            val expressionResult = expression.evaluate().value
            val roundedResult = String.format("%.2f", expressionResult)
            resultTextView.text = roundedResult
            stringBuilder.clear()
            stringBuilder.append(roundedResult)
        } catch (t: Throwable) {
            Toast.makeText(this@MainActivity, "Exception: $t", Toast.LENGTH_LONG).show()
        }
    }
}