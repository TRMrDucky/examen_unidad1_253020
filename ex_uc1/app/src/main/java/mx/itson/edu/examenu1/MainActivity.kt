package mx.itson.edu.examenu1

import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.itson.edu.examenu1.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //labels
        val lblCelcius = findViewById<EditText>(id.etCelcius)
        val lblFahrenheit  = findViewById<EditText>(id.etFahrenheit)
        val lblKelvin = findViewById<EditText>(id.etKelvin)
        val lblAviso = findViewById<TextView>(id.tvAviso)

        //botones
        val btnCelcius = findViewById<Button>(id.btnCelcius)
        val btnFahrenheit = findViewById<Button>(id.btnFahrenheit)
        val btnKelvin = findViewById<Button>(id.btnKelvin)

        btnCelcius.setOnClickListener {
            val c = lblCelcius.text.toString().toDoubleOrNull()

            if (c == null){
                lblAviso.text = "Ingresa datos válidos"
                return@setOnClickListener
            }
            val temperaturas = fromCelcius(c)

            lblFahrenheit.setText(temperaturas.fahrenheit.toString())
            lblKelvin.setText(temperaturas.kelvin.toString())

            lblAviso.text = ""
        }

        btnFahrenheit.setOnClickListener {
            val f = lblFahrenheit.text.toString().toDoubleOrNull()

            if (f == null){
                lblAviso.text = "Ingresa datos válidos"
                return@setOnClickListener
            }
            val temperaturas = fromFahrenheit(f)

            lblCelcius.setText(temperaturas.celcius.toString())
            lblKelvin.setText(temperaturas.kelvin.toString())

            lblAviso.text = ""
        }

        btnKelvin.setOnClickListener {
            val k = lblKelvin.text.toString().toDoubleOrNull()

            if (k == null){
                lblAviso.text = "Ingresa datos válidos"
                return@setOnClickListener
            }
            val temperaturas = fromKelvin(k)

            lblCelcius.setText(temperaturas.celcius.toString())
            lblFahrenheit.setText(temperaturas.fahrenheit.toString())

            lblAviso.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

fun fromCelcius(c: Double) = Temperatura(
    celcius = c,
    fahrenheit = (c * 1.8) + 32,
    kelvin = c + 273.15
)

fun fromFahrenheit(f: Double) = Temperatura(
    celcius = (f - 32) / 1.8,
    fahrenheit = f,
    kelvin = ((f - 32) * 5 / 9) + 273.15
)

fun fromKelvin(k: Double) = Temperatura(
    celcius = k - 273.15,
    fahrenheit = ((k - 273.15) * 9 / 5) + 32,
    kelvin = k
)






















