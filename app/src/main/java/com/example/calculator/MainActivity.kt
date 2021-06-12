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

        button_bracket_left.setOnClickListener {
            input.text= addToImputText("(")
        }

        button_bracket_rigth.setOnClickListener {
            input.text= addToImputText(")")
        }

        button_0.setOnClickListener() {
            input.text= addToImputText("0")
        }
        button_1.setOnClickListener {
            input.text= addToImputText("1")
        }
        button_2.setOnClickListener {
            input.text= addToImputText("2")
        }
        button_3.setOnClickListener {
            input.text= addToImputText("3")
        }
        button_4.setOnClickListener {
            input.text= addToImputText("4")
        }
        button_5.setOnClickListener {
            input.text= addToImputText("5")
        }
        button_6.setOnClickListener {
            input.text= addToImputText("6")
        }
        button_7.setOnClickListener {
            input.text= addToImputText("7")
        }
        button_8.setOnClickListener {
            input.text= addToImputText("8")
        }
        button_9.setOnClickListener {
            input.text= addToImputText("9")
        }
        button_dot.setOnClickListener {
            input.text= addToImputText(".")
        }
        button_addition.setOnClickListener {
            input.text= addToImputText("+")
        }
        button_division.setOnClickListener {
            input.text= addToImputText("÷")
        }

        button_multiply.setOnClickListener {
            input.text= addToImputText("×")
        }
        button_subtration.setOnClickListener {
            input.text= addToImputText("-")
        }
        button_equls.setOnClickListener {
            showResult()
        }

    }


    private fun addToImputText(buttonValue: String): String{

        return "${input.text}$buttonValue"
    }

    private fun getInputExpression():String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = input.text.replace(Regex("×"),"*")
        return expression
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