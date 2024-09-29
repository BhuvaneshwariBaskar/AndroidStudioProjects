package com.example.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.getRoot()
        setContentView(view)

        binding.btnClr.setOnClickListener {
            binding.input.text=""
            binding.output.text=""
        }
        binding.btnOpen.setOnClickListener {
            binding.input.append("(")
        }
        binding.btnClose.setOnClickListener {
            binding.input.append(")")
        }
        binding.btnOne.setOnClickListener {
            binding.input.append("1")
        }
        binding.btnTwo.setOnClickListener {
            binding.input.append("2")
        }
        binding.btnThree.setOnClickListener {
            binding.input.append("3")
        }
        binding.btnFour.setOnClickListener {
            binding.input.append("4")
        }
        binding.btnFive.setOnClickListener {
            binding.input.append("5")
        }
        binding.btnSix.setOnClickListener {
            binding.input.append("6")
        }
        binding.btnSeven.setOnClickListener {
            binding.input.append("7")
        }
        binding.btnEight.setOnClickListener {
            binding.input.append("8")
        }
        binding.btnNine.setOnClickListener {
            binding.input.append("9")
        }
        binding.btnZero.setOnClickListener {
            binding.input.append("0")
        }
        binding.btnDot.setOnClickListener {
            binding.input.append(".")
        }
        binding.btnPlus.setOnClickListener {
            binding.input.append("+")
        }
        binding.btnMinus.setOnClickListener {
            binding.input.append("-")
        }
        binding.btnDiv.setOnClickListener {
            binding.input.append("÷")
        }
        binding.btnMul.setOnClickListener {
            binding.input.append("*")
        }
        binding.btnEquals.setOnClickListener {
            showResult()
        }
    }

    private fun getExpression(): String {
        return binding.input.text.replace(Regex("÷"), "/")
    }
    private fun showResult(){
        try{
            val expression=getExpression()
            val result= Expression(expression).calculate()
            if(result.isNaN()){
                binding.output.text="ERROR"
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }
            else{
                binding.output.text=DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.green))
            }
        }
        catch (err:Exception){
            binding.output.text="ERROR"
            binding.output.setTextColor(ContextCompat.getColor(this,R.color.red))
        }

    }
}