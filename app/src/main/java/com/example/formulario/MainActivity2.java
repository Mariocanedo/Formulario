package com.example.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        if(intent != null){

            // recibir parámetros
          String nombre =intent.getStringExtra("nom")  ;

            String apellido =intent.getStringExtra("ape")  ;

            String mail =intent.getStringExtra("email")  ;

            String telefono =intent.getStringExtra("tel")  ;



            TextView nom = findViewById(R.id.nom);
            nom.setText(nombre);

            TextView ape = findViewById(R.id.ape);
            ape.setText(apellido);

            TextView email = findViewById(R.id.email);
            email.setText(mail);
            TextView tel= findViewById(R.id.phone);
            tel.setText(telefono);


        }

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}