package com.example.calculatorspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculatorspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.buttonCalculate.setOnClickListener {
            calculate()
        }

        /*binding.edittextNumber1.setOnKeyListener { view, i, keyEvent ->
            calculate()
            false
        }

        binding.edittextNumber2.setOnKeyListener { view, i, keyEvent ->
            calculate()
            false
        }

        // https://android--code.blogspot.com/2020/02/android-kotlin-spinner.html
        binding.spinnerOperation.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                calculate()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
         */
    }

    private fun calculate() {
        val number1str = binding.edittextNumber1.text.toString().trim()
        val number2str = binding.edittextNumber2.text.toString().trim()
        var error = false
        if (number1str.isEmpty()) {
            binding.edittextNumber1.error = "No number"
            error = true
            //return
        }
        if (number2str.isEmpty()) {
            binding.edittextNumber2.error = "No number"
            error = true
            //return
        }
        if (error) return
        val number1 = number1str.toDouble()
        val number2 = number2str.toDouble()
        var result = 0.0
        val operation: String = binding.spinnerOperation.selectedItem as String
        // https://www.geeksforgeeks.org/kotlin-when-expression/
        when (operation) {
            "+" -> result = number1 + number2
            "-" -> result = number1 - number2
            "*" -> result = number1 * number2
            "/" -> result = number1 / number2
        }
        val resultStr = result.toString()
        binding.textviewResult.text = resultStr
    }
}