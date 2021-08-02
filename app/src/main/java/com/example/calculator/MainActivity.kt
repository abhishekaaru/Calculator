package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.apply {

            ac.setOnClickListener{
                binding.input.text = ""
                binding.output.text = ""
            }

            zero.setOnClickListener { binding.input.append("0") }
            one.setOnClickListener { binding.input.append("1") }
            two.setOnClickListener { binding.input.append("2") }
            three.setOnClickListener { binding.input.append("3") }
            four.setOnClickListener { binding.input.append("4") }
            five.setOnClickListener { binding.input.append("5") }
            six.setOnClickListener { binding.input.append("6") }
            seven.setOnClickListener { binding.input.append("7") }
            eight.setOnClickListener { binding.input.append("8") }
            nine.setOnClickListener { binding.input.append("9") }

            plus.setOnClickListener { binding.input.append("+") }
            minus.setOnClickListener { binding.input.append("-") }
            multiply.setOnClickListener { binding.input.append("*") }
            divide.setOnClickListener { binding.input.append("/") }
            dot.setOnClickListener { binding.input.append(".") }
            openBracket.setOnClickListener { binding.input.append("(") }
            closeBracket.setOnClickListener { binding.input.append(")") }

            equal.setOnClickListener { claculation() }
        }
    }

    private fun claculation() {
        val expression = ExpressionBuilder(binding.input.text.toString()).build()
        val result = expression.evaluate()
        val longResult = result.toLong()

        if(result == longResult.toDouble()){
            binding.output.text = longResult.toString()
        }
        else{
            binding.output.text = result.toString()
        }

    }
}