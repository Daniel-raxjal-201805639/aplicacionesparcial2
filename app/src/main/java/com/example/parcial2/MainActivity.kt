package com.example.parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btndelete = findViewById<Button>(R.id.btn_delete)
        val btncreat = findViewById<Button>(R.id.btn_creat)
        val btnupdate = findViewById<Button>(R.id.btn_update)
        val btncredito = findViewById<Button>(R.id.btn_credito)

        btndelete.setOnClickListener {
            val eliminar: Intent = Intent(this, eliminarActivity2::class.java)
            startActivity(eliminar)
        }
        btncreat.setOnClickListener {
            val insertar: Intent = Intent(this, insertarActivity2::class.java)
            startActivity(insertar)
        }
        btnupdate.setOnClickListener {
            val  modificar: Intent = Intent(this, modificarActivity2::class.java)
            startActivity(modificar)
        }
        btncredito.setOnClickListener {
            val credito: Intent = Intent(this, creditosActivity2::class.java)
            startActivity(credito)
        }
    }
}