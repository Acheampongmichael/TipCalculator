package com.example.aaaaaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var result: TextView
    private lateinit var tipText: EditText
    private lateinit var billText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result)
        tipText = findViewById(R.id.tip_pay)
        billText = findViewById(R.id.bill_pay)

        val button = findViewById<Button>(R.id.btnCalculate)
        button.setOnClickListener { btnClick() }
    }

    private fun calculate(): Double {
        val tip = tipText.text.toString().toDoubleOrNull() ?: 0.0
        val bill = billText.text.toString().toDoubleOrNull() ?: 0.0

        val total: Double = bill * (1 + tip/100)
        return total
    }

    private fun btnClick() {
        val total_result = calculate()
        val formattedTotal = String.format("%.2f", total_result)

        val result = findViewById<TextView>(R.id.result)
        result.text = "Total: $formattedTotal"
    }
}
