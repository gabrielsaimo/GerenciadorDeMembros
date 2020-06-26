package com.example.videira_em_celula;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btnLogar;
    private Button btnPular;
    private EditText editEmail;
    private EditText editSenha;

    DBLogin db;

    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        db = new DBLogin(this);
        inicializarComponentes();
        eventoClicks();
            }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    //EVENTOS DE BOTÕES
    private void eventoClicks() {
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String email = editEmail.getText().toString().trim();
                    String senha = editSenha.getText().toString().trim();
                    login(email, senha);
                    if (TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)){
                        alert("Prencha todos os campos");
                    }else {
                       btnLogar.setVisibility(View.INVISIBLE);
                        String res = db.ValidarLogin(email,senha);
                        if (res.equals("OK")){
                            alert("Logando");
                        }else {
                            alert("Email ou Senha incorretos");
                        }
                    }
            }
        });

        btnPular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, CriarUser.class);
                startActivity(i);
                }

        });
    }
    //FAZ O LOGIN TRADICIONAL
    private void login(String email, String senha) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)) {
            btnLogar.setVisibility(View.VISIBLE);
        } else {
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
            btnLogar.setVisibility(View.VISIBLE);
        }
    }
// INICIALIZA COMPONENTES
    private void inicializarComponentes() {
        btnLogar = (Button) findViewById(R.id.btLogar);
        editEmail = (EditText) findViewById(R.id.editText);
        editSenha = (EditText) findViewById(R.id.editSenha);
        btnPular = (Button) findViewById(R.id.btnPul);
    }
    //MOSTRA MSG
    private  void alert (String msg){
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        Toast.makeText(Login.this,msg,Toast.LENGTH_SHORT).show();
    }
}