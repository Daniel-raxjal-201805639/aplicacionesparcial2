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
import org.json.JSONArray
import org.json.JSONObject

class modificarActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar2)

        //variables con los id de cada caja de texto
        val actualizarid = findViewById<EditText>(R.id.update_id)
        val btnbuscar= findViewById<Button>(R.id.btn_read)

        val updatenom = findViewById<EditText>(R.id.update_nom)
        val updateape = findViewById<EditText>(R.id.update_ape)
        val updategra = findViewById<EditText>(R.id.update_grado)
        val updateacad= findViewById<EditText>(R.id.update_nivel)
        val updatesecc = findViewById<EditText>(R.id.update_secc)
        val updatenota = findViewById<EditText>(R.id.update_nota)
        val btnaguardar = findViewById<Button>(R.id.btn_guardar)
        val btnregresar = findViewById<Button>(R.id.btn_regresar)



        btnbuscar.setOnClickListener {
            // Crea una instancia de RequestQueue.
            val requestQueue = Volley.newRequestQueue(this)
            var url = "https://emanuelraxjal2018.000webhostapp.com/Parcial_No_2/buscar_estudiantes.php?id=" + actualizarid.getText().toString()

            // Solicite una respuesta de cadena de la URL proporcionada.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->

                    val jsonArray = JSONArray(response)

                    var objetoJson = JSONObject(jsonArray.getString(0))
                    updatenom.setText(objetoJson.getString("nombre"))
                    updateape.setText(objetoJson.getString("apellido"))
                    updategra.setText(objetoJson.getString("grado"))
                    updateacad.setText(objetoJson.getString("nivel"))
                    updatesecc.setText(objetoJson.getString("seccion"))
                    updatenota.setText(objetoJson.getString("nota"))
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this, "Error en el servicio", Toast.LENGTH_SHORT).show()

                })

            // Agregue la solicitud a RequestQueue.
            requestQueue.add(stringRequest)
        }

        btnaguardar.setOnClickListener {
            // Crea una instancia de RequestQueue.
            val requestQueue = Volley.newRequestQueue(this)
            var url = "https://emanuelraxjal2018.000webhostapp.com/Parcial_No_2/actualizarestudiantes.php?"
            url += "id=" + actualizarid.getText().toString()
            url += "&nombre=" + updatenom.getText().toString()
            url += "&apellido=" + updateape.getText().toString()
            url += "&grado=" + updategra.getText().toString()
            url += "&nivel=" + updateacad.getText().toString()
            url += "&seccion=" + updatesecc.getText().toString()
            url += "&nota=" + updatenota.getText().toString()

            // Formular la solicitud y manejar la respuesta.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Do something with the response

                    val jsonArray = JSONArray(response)
                    //obtener un elemento del array jsonArray
                    var objetoJson = JSONObject(jsonArray.getString(0))

                    Toast.makeText(this,"Datos modificados", Toast.LENGTH_SHORT).show()


                },
                Response.ErrorListener { error ->
                    // Handle error
                    Toast.makeText(this,"Error en el servicio web", Toast.LENGTH_SHORT).show()

                })

            // Agregue la solicitud a RequestQueue.
            requestQueue.add(stringRequest)

        }
        btnregresar.setOnClickListener {
            val inicio: Intent = Intent(this, MainActivity::class.java)
            startActivity(inicio)
        }

    }
}