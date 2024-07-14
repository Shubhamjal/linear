package com.example.valuefetch

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var btn: Button?=null//var declaration
    var editText: EditText?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show()

        editText=findViewById(R.id.editTextText)

        btn?.setOnClickListener{

            if (editText?.text.toString().isEmpty()){
                Toast.makeText(this,"Enter the value", Toast.LENGTH_SHORT).show()
                editText?.error="Enter the value"
            }else{
                val intent=Intent(this,SecondActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,editText?.text.toString(),Toast.LENGTH_SHORT).show()
            }
        }


    }
}