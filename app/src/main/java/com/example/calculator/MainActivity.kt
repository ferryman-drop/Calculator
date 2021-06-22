package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener{
            input.text=""
            output.text=""
        }


        //Literal
        button_0.setOnClickListener() {
            input.text= addToInputText("0")
        }
        button_1.setOnClickListener {
            input.text= addToInputText("1")
        }
        button_2.setOnClickListener {
            input.text= addToInputText("2")
        }
        button_3.setOnClickListener {
            input.text= addToInputText("3")
        }
        button_4.setOnClickListener {
            input.text= addToInputText("4")
        }
        button_5.setOnClickListener {
            input.text= addToInputText("5")
        }
        button_6.setOnClickListener {
            input.text= addToInputText("6")
        }
        button_7.setOnClickListener {
            input.text= addToInputText("7")
        }
        button_8.setOnClickListener {
            input.text= addToInputText("8")
        }
        button_9.setOnClickListener {
            input.text= addToInputText("9")
        }

        // Operators


        button_bracket_left.setOnClickListener {
            input.text= addToInputText("(")
        }

        button_bracket_rigth.setOnClickListener {
            input.text= addToInputText(")")
        }
        button_dot.setOnClickListener {
            rewriting(".")

        }
        button_addition.setOnClickListener {
            rewriting("+")
        }

        button_division.setOnClickListener {
            rewriting("÷")

        }

        button_multiply.setOnClickListener {
            rewriting("×")

        }

        button_subtration.setOnClickListener {

            rewriting("-")

        }

        button_equls.setOnClickListener {
            showResult()
        }

    }


    private fun rewriting(buttonOperator: String){
        if(checkOperators()){
            dropOperator()
            input.text= addToInputText(buttonOperator)
        }else{
            input.text= addToInputText(buttonOperator)
        }
    }

    private fun addToInputText(buttonValue: String): String{

            return "${input.text}$buttonValue"

    }

    private fun dropOperator(){
        input.text = input.text.toString().dropLast(1)
    }


    private fun getInputExpression():String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = input.text.replace(Regex("×"),"*")
        return expression
    }
    private fun checkOperators(): Boolean {
        return when (input.text[input.text.lastIndex].toString()) {
            "+" -> true
            "-" -> true
            "×" -> true
            "÷" -> true
            "." -> true
            else -> false
        }
    }

    private fun showResult(){
        try {
         val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if(result.isNaN()){
                //Show error
                output.text = "Error Massage"
                output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }else {
                //Show result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this,R.color.green))
            }
        }catch (e:Exception){
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this,R.color.red))
        }

    }
}