package com.babilawi.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private lateinit var input: TextView
    private lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById<TextView>(R.id.input)
        output = findViewById<TextView>(R.id.output)
        val button0 = findViewById<TextView>(R.id.button0)
        val button1 = findViewById<TextView>(R.id.button1)
        val button2 = findViewById<TextView>(R.id.button2)
        val button3 = findViewById<TextView>(R.id.button3)
        val button4 = findViewById<TextView>(R.id.button4)
        val button5 = findViewById<TextView>(R.id.button5)
        val button6 = findViewById<TextView>(R.id.button6)
        val button7 = findViewById<TextView>(R.id.button7)
        val button8 = findViewById<TextView>(R.id.button8)
        val button9 = findViewById<TextView>(R.id.button9)
        val buttonAddition = findViewById<TextView>(R.id.buttonAddition)
        val buttonSubtraction = findViewById<TextView>(R.id.buttonSubtraction)
        val buttonMultiplication = findViewById<TextView>(R.id.buttonMultiplication)
        val buttonDivision = findViewById<TextView>(R.id.buttonDivision)
        val buttonEqual = findViewById<TextView>(R.id.buttonEqual)
        val buttonDot = findViewById<TextView>(R.id.buttonDot)
        val buttonC = findViewById<TextView>(R.id.buttonC)
        val buttonOpenParenthesis = findViewById<TextView>(R.id.buttonOpenParenthesis)
        val buttonCloseParenthesis = findViewById<TextView>(R.id.buttonCloseParenthesis)

        button0.setOnClickListener {
            input.text = addNumberToInput("0")
        }

        button1.setOnClickListener {
            input.text = addNumberToInput("1")
        }

        button2.setOnClickListener {
            input.text = addNumberToInput("2")
        }

        button3.setOnClickListener {
            input.text = addNumberToInput("3")
        }

        button4.setOnClickListener {
            input.text = addNumberToInput("4")
        }

        button5.setOnClickListener {
            input.text = addNumberToInput("5")
        }

        button6.setOnClickListener {
            input.text = addNumberToInput("6")
        }

        button7.setOnClickListener {
            input.text = addNumberToInput("7")
        }

        button8.setOnClickListener {
            input.text = addNumberToInput("8")
        }

        button9.setOnClickListener {
            input.text = addNumberToInput("9")
        }

        buttonAddition.setOnClickListener {
            input.text = addNumberToInput("+")
        }

        buttonSubtraction.setOnClickListener {
            input.text = addNumberToInput("-")
        }

        buttonMultiplication.setOnClickListener {
            input.text = addNumberToInput("*")
        }

        buttonDivision.setOnClickListener {
            input.text = addNumberToInput("/")
        }

        buttonDot.setOnClickListener {
            input.text = addNumberToInput(".")
        }

        buttonC.setOnClickListener {
            input.text = ""
            output.text = "0"
        }

        buttonOpenParenthesis.setOnClickListener {
            input.text = addNumberToInput("(")
        }

        buttonCloseParenthesis.setOnClickListener {
            input.text = addNumberToInput(")")
        }

        buttonEqual.setOnClickListener {
            calculate()
        }
    }

    private fun addNumberToInput(number: String) : String {
        return input.text.toString() + number
    }

    private fun calculate() {
        val numeros = input.text.split("+", "-", "*", "/")
        val operadores = input.text.filter { it == '+' || it == '-' || it == '*' || it == '/' }
        var resultado = numeros[0].toDouble()
        try {
            for (i in operadores.indices) {
                resultado = when(operadores[i])
                {
                    '+' -> resultado.toDouble() + numeros[i + 1].toDouble()
                    '-' -> resultado.toDouble() - numeros[i + 1].toDouble()
                    '*' -> resultado.toDouble() * numeros[i + 1].toDouble()
                    '/' -> resultado.toDouble() / numeros[i + 1].toDouble()
                    else -> 0.0
                }
            }
        }catch (e: Exception) {
            resultado = 0.0
            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle("Error")
            alertDialog.setMessage("Operación invalida")
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK") { dialog, _ -> dialog.dismiss() }
            alertDialog.show()
        }
        output.text = resultado.toString()
    }



}