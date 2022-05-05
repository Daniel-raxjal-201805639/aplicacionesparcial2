package com.example.parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class eliminarActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar2)

        //variables con los id de cada caja de texto

        val deleteid= findViewById<EditText>(R.id.delete_id)
        val btneliminar = findViewById<Button>(R.id.btn_eliminar)
        val btnregresar = findViewById<Button>(R.id.btn_regresar)

        //accion para el boton
        btneliminar.setOnClickListener {
            // Instantiate the RequestQueue.
            val requestQueue = Volley.newRequestQueue(this)
            val url =
                "https://emanuelraxjal2018.000webhostapp.com/Parcial_No_2/eliminarestudiante.php?id=" + deleteid.getText()
                    .toString()
            /*var url = "https://emanuelraxjal2018.000webhostapp.com/Parcial_No_2/eliminarestudiante.php?id" + eliminarid.getText().toString()*/
            // Request a string response from the provided URL.
            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    Toast.makeText(this, "Elemento eliminado", Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this, "Error en el servicio", Toast.LENGTH_SHORT).show()

                }
            )

            // Add the request to the RequestQueue.
            requestQueue.add(stringRequest)
        }
        btnregresar.setOnClickListener {
            val inicio: Intent = Intent(this, MainActivity::class.java)
            startActivity(inicio)

        }
    }
}