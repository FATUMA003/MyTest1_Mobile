package com.example.ui_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtResult: TextView
    private var inStr: String = "0"
    private var result: Int = 0
    private var lastOperator: Char = ' '

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResult = findViewById(R.id.txtResultId)
        txtResult.text = "0"

        val btnIds = listOf(
            R.id.btnNum0Id, R.id.btnNum1Id, R.id.btnNum2Id, R.id.btnNum3Id,
            R.id.btnNum4Id, R.id.btnNum5Id, R.id.btnNum6Id, R.id.btnNum7Id,
            R.id.btnNum8Id, R.id.btnNum9Id
        )

        for (id in btnIds) {
            findViewById<Button>(id).setOnClickListener { v ->
                val inDigit = (v as Button).text.toString()
                if (inStr == "0") {
                    inStr = inDigit
                } else {
                    inStr += inDigit
                }
                txtResult.text = inStr
            }
        }

        findViewById<Button>(R.id.btnAddId).setOnClickListener {
            compute()
            lastOperator = '+'
        }
        findViewById<Button>(R.id.btnSubId).setOnClickListener {
            compute()
            lastOperator = '-'
        }
        findViewById<Button>(R.id.btnMulId).setOnClickListener {
            compute()
            lastOperator = '*'
        }
        findViewById<Button>(R.id.btnDivId).setOnClickListener {
            compute()
            lastOperator = '/'
        }
        findViewById<Button>(R.id.btnEqualId).setOnClickListener {
            compute()
            lastOperator = '='
        }
        findViewById<Button>(R.id.btnClearId).setOnClickListener {
            result = 0
            inStr = "0"
            lastOperator = ' '
            txtResult.text = "0"
        }
    }

    private fun compute() {
        val inNum = inStr.toInt()
        inStr = "0"
        result = when (lastOperator) {
            '+' -> result + inNum
            '-' -> result - inNum
            '*' -> result * inNum
            '/' -> if (inNum != 0) result / inNum else 0
            else -> inNum
        }
        txtResult.text = result.toString()
    }
}
