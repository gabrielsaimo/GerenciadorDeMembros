package com.example.videira_em_celula;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    String url;
    private ProgressBar progressBar;
    private Button btnComent,button22;
    private ImageButton btnestar;
    private TextView nomeDoPonto;
    private TextView StatusDoPonto;
    public Button button21;
    public Button voltar;
    public Button irAteLocal;
    private TextView Datat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        inicializarComponentes();
        startt();
        eventoClicks();
    }

    private void eventoClicks() {
        btnComent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListaMenbros.class);
                startActivity(i);
            }
        });
        irAteLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Cadastro.class);
                startActivity(i);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, IdeiasCelula.class);
                startActivity(i);
            }
        });

    }
    void inicializarComponentes(){
        btnComent =(findViewById(R.id.button20));
        button22 = (findViewById(R.id.button22));
        button21 = (findViewById(R.id.button21));
        nomeDoPonto  = (findViewById(R.id.PontNomeXML));
        StatusDoPonto =  (findViewById(R.id.StatusXML));
        voltar = (findViewById(R.id.ButtVoltarXML));
        btnestar = (findViewById(R.id.btnestar));
        irAteLocal = (findViewById(R.id.button2));
        Datat= (findViewById(R.id.data));
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(MainActivity.this, Login.class);
        startActivity(i);
        finish();
    }
    private void startt(){
        this.progressBar = findViewById(R.id.progressBar);
    }
}