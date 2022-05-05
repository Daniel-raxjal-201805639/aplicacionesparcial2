package com.example.parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class insertarActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar2)

        //variables con los id de cada caja de texto
        val creatid = findViewById<EditText>(R.id.creat_estudiante_id)
        val creatnom = findViewById<EditText>(R.id.creat_estudiante_nom)
        val creatape = findViewById<EditText>(R.id.creat_estudiante_ape)
        val creatgra = findViewById<EditText>(R.id.creat_estudiante_grado)
        val creatacad = findViewById<EditText>(R.id.creat_estudiante_nivel)
        val creatsecc = findViewById<EditText>(R.id.creat_estudiante_secc)
        val creatnota = findViewById<EditText>(R.id.creat_estudiante_nota)
        val btnaguardar = findViewById<Button>(R.id.creat_btn)
        val btnregresar = findViewById<Button>(R.id.btn_regresar)

        btnaguardar.setOnClickListener {
            // Crea una instancia de RequestQueue.
            val requestQueue = Volley.newRequestQueue(this)
            var url = "https://emanuelraxjal2018.000webhostapp.com/Parcial_No_2/insertarestudiantes.php?"
            url += "id=" + creatid.getText().toString()
            url += "&nombre=" + creatnom.getText().toString()
            url += "&apellido=" + creatape.getText().toString()
            url += "&grado=" + creatgra.getText().toString()
            url += "&nivel=" + creatacad.getText().toString()
            url += "&seccion=" + creatsecc.getText().toString()
            url += "&nota=" + creatnota.getText().toString()

            // Formular la solicitud y manejar la respuesta.
            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->

                    val jsonArray = JSONArray(response)
                    //obtener un elemento del array jsonArray
                    val objeto = JSONObject(jsonArray.getString(0))

                    Log.d("Datos", objeto.toString())
                    Log.d("ID: ", objeto.getString("id"))
                    Log.d("NOMBRE: ", objeto.getString("nombre"))
                    Log.d("APELLIDO: ", objeto.getString("apellido"))
                    Log.d("GRADO: ", objeto.getString("grado"))
                    Log.d("NIVEL:", objeto.getString("nivel"))
                    Log.d("SECCION: ", objeto.getString("seccion"))
                    Log.d("NOTA: ", objeto.getString("nota"))


                    Toast.makeText(this, "Elemento insertado", Toast.LENGTH_SHORT).show()

                },
                Response.ErrorListener { error ->

                    Toast.makeText(this, "Error en el Servicio", Toast.LENGTH_LONG).show()

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