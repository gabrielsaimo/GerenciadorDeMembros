package com.example.videira_em_celula;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CriarUser extends AppCompatActivity {

    EditText email,senha,confsenha;
    Button btCadastrar;
    DBLogin db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_user);

        db= new DBLogin(this);

        email = (EditText)findViewById(R.id.editText);
        senha = (EditText)findViewById(R.id.textSenha);
        confsenha = (EditText)findViewById(R.id.textConfSenha);

        btCadastrar = (Button)findViewById(R.id.btCasatrar);
        btCadastrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String mail = email.getText().toString();
                String ssenha = senha.getText().toString();
                String sconfigsenha = confsenha.getText().toString();

                if(mail.equals((""))){
                    alert("Prencha todos os campos");
                }else if (ssenha.equals("") || sconfigsenha.equals("")){
                    alert("Prencha todos os campos de senha");
                }else if (!ssenha.equals(sconfigsenha)){
                    alert("As senhas não estao iguais");
                }else {
                    long res = db.CriarUtilizador(mail,ssenha);
                    if (res>0){
                        alert("Registrado!");
                    }else{
                        alert("Registro invalido, tente novamente");
                    }
                }

                }
        });

    }

    private  void alert (String msg){
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        Toast.makeText(CriarUser.this,msg,Toast.LENGTH_SHORT).show();
    }

}

























