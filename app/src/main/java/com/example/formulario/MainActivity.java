package com.example.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    // declaro variables finales
    EditText nom, ape, mail, tel;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.nom);
        ape = findViewById(R.id.ape);
        mail = findViewById(R.id.email);
        tel = findViewById(R.id.phone);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // recibir parámetros

                String nombre = nom.getText().toString().trim();
                String apellido = ape.getText().toString().trim();
                String email = mail.getText().toString().trim();
                String telefono = tel.getText().toString().trim();

                // Log para ver si mensajes llegan
                Log.d("Campos", "Nombre: " + nombre);
                Log.d("Campos", "Apellido: " + apellido);
                Log.d("Campos", "Email: " + email);
                Log.d("Campos", "Teléfono: " + telefono);


                if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Complete todos los campos", Toast.LENGTH_LONG).show();
                } else {
                    if (!isValidEmail(email)) {
                        Snackbar.make(v, "El correo electrónico no es válido", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    } else if (!isValidPhoneNumber(telefono)) {
                        Snackbar.make(v, "El número de teléfono no es válido", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    } else {
                        enviarDatos(nombre, apellido, email, telefono);
                    }
                }
            }
        });
    }

    public void enviarDatos (String nombre, String apellido, String email, String telefono){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("nom", nombre);
        intent.putExtra("ape", apellido);
        intent.putExtra("email", email);
        intent.putExtra("tel", telefono);
        startActivity(intent);
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Puedes personalizar la validación según tus requisitos
        return android.util.Patterns.PHONE.matcher(phoneNumber).matches();
    }
}