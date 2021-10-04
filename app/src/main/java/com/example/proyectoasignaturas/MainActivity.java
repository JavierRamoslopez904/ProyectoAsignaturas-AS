package com.example.proyectoasignaturas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** Atributos **/
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private TextView textView1;

    /**
     * Método
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Atributos conectados a cada campo de la parte gráfica
        // Almacenamos en los atributos previamente creados los textos
        editText1 = (EditText) findViewById(R.id.primerTexto);
        editText2 = (EditText) findViewById(R.id.segundoTexto);
        editText3 = (EditText) findViewById(R.id.tercerTexto);
        editText4 = (EditText) findViewById(R.id.cuartoTexto);
        textView1 = (TextView) findViewById(R.id.resultado);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    /***
     * Método mediaNotas va a contener el código para que la aplicación funcione
     */
    public void mediaNotas (View vista) {

        // Variable String que va a recoger el texto que haya en el primer campo, que será el campo de Acceso a datos
        String primerValor = editText1.getText().toString();

        // Variable String que va a recoger el texto que haya en el segundo campo, que será el campo de Desarrollo de Interfaces
        String segundoValor = editText2.getText().toString();

        // Variable String que va a recoger el texto que haya en el segundo campo, que será el campo de Programación Web
        String tercerValor = editText3.getText().toString();

        // Variable String que va a recoger el texto que haya en el segundo campo, que será el campo de Empresa
        String cuartoValor = editText4.getText().toString();

        // Establecemos condiciones para ver si el campo esta vacío, y si es así, que salga un toast, para que la
        // aplicación no colapse y se cierre
        if(primerValor.isEmpty() || segundoValor.isEmpty() || tercerValor.isEmpty() || cuartoValor.isEmpty()){

            Toast.makeText(this, "ERROR, HAY ALGÚN CAMPO VACÍO", Toast.LENGTH_SHORT).show();

        }else{

            /** Creación de variables para parsearlas de String a Double para poder operar con ellas **/
            double primerNumero = Double.parseDouble(primerValor);
            double segundoNumero = Double.parseDouble(segundoValor);
            double tercerNumero = Double.parseDouble(tercerValor);
            double cuartoNumero = Double.parseDouble(cuartoValor);

            // Establecimiento de condiciones para que si los números son mayores que 10, salga un Toast advirtiendo del error
            if(primerNumero > 10 || segundoNumero > 10 || tercerNumero > 10 || cuartoNumero > 10){

                // Muestra mensaje de error
                Toast.makeText(this, "Ha introducido un dato mayor a 10", Toast.LENGTH_SHORT).show();
            }else{

                // Almacenamos en una variable el resultado de la operacion
                double suma = (primerNumero + segundoNumero + tercerNumero + cuartoNumero)/4;

                // Creación de una variable que almacena el valor de la suma pero ya como una cadena de caracteres, no como
                // un double
                String resultadoTotal = String.valueOf(suma);

                // Establecimiento de condiciones
                if(suma < 5){
                    textView1.setText("SUSPENSO");
                    textView1.setTextColor(getColor(R.color.red));
                }else if(suma >= 5) {
                    textView1.setText("APROBADO");
                    textView1.setTextColor(getColor(R.color.green));
                }
            }

        }
    }
}