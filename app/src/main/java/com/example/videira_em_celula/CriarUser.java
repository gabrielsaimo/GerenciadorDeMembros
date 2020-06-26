package com.example.videira_em_celula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CriarUser extends AppCompatActivity {

    EditText email,senha,confsenha;
    Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_user);

        email = (EditText)findViewById(R.id.editEmail);
        senha = (EditText)findViewById(R.id.textSenha);
        confsenha = (EditText)findViewById(R.id.textConfSenha);

        btCadastrar = (Button)findViewById(R.id.btCasatrar);
        btCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });

    }
}

























