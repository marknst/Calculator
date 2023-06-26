package com.example.calculatorbymarkn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.ezylang.evalex.Expression
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        val zeroButton = findViewById<Button>(R.id.zeroButton)
        val oneButton = findViewById<Button>(R.id.oneButton)
        val twoButton = findViewById<Button>(R.id.twoButton)
        val threeButton = findViewById<Button>(R.id.threeButton)
        val fourButton = findViewById<Button>(R.id.fourButton)
        val fiveButton = findViewById<Button>(R.id.fiveButton)
        val sixButton = findViewById<Button>(R.id.sixButton)
        val sevenButton = findViewById<Button>(R.id.sevenButton)
        val eightButton = findViewById<Button>(R.id.eightButton)
        val nineButton = findViewById<Button>(R.id.nineButton)
        val pointButton = findViewById<Button>(R.id.pointButton)
        val equalButton = findViewById<Button>(R.id.equalButton)
        val plusButton = findViewById<Button>(R.id.plusButton)
        val minusButton = findViewById<Button>(R.id.minusButton)
        val divideButton = findViewById<Button>(R.id.divideButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val openingBracketButton = findViewById<Button>(R.id.openingBracketButton)
        val closingBracketButton = findViewById<Button>(R.id.closingBracketButton)
        val clearLastButton = findViewById<Button>(R.id.clearLastButton)


        val stringBuilder = StringBuilder()

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

        equalButton.setOnClickListener {
            try {
                val expression = Expression(stringBuilder.toString())
                val expressionResult = expression.evaluate().value
                val roundedResult = String.format("%.3f", expressionResult)
                resultTextView.text = roundedResult
                stringBuilder.clear()
                stringBuilder.append(roundedResult)
            } catch (t: Throwable) {
                Toast.makeText(this@MainActivity, "Exception: $t", Toast.LENGTH_LONG).show()
            }
        }

        clearButton.setOnClickListener {
            stringBuilder.clear()
            resultTextView.text = "0"
        }

        clearLastButton.setOnClickListener {
            stringBuilder.deleteCharAt(stringBuilder.length-1)
            resultTextView.text = stringBuilder.toString()

        }
    }
}