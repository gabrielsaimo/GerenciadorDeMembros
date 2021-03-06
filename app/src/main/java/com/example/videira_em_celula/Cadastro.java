package com.example.videira_em_celula;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.videira_em_celula.Banco_de_dados.MenbrosDAO;

public class Cadastro extends AppCompatActivity {

    private EditText nome,telefone,idade,endereco,email,batizado;
    private CheckBox checkBoxSim,checkBoxNao;
    private MenbrosDAO dao;
    private Membro membros = null;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializarComponentes();
        nome = findViewById(R.id.editNome);
        checkBoxSim = findViewById(R.id.checkBoxSim);
        checkBoxNao = findViewById(R.id.checkBoxNao);
        telefone = findViewById(R.id.editTelefone);
        endereco = findViewById(R.id.editEndereco);
        idade = findViewById(R.id.editIdade);
       email = findViewById(R.id.editText);
       batizado = findViewById(R.id.editBatizado);
        dao = new MenbrosDAO(this);
        Intent it = getIntent();
        if(it.hasExtra("membros")){
            membros = (Membro) it.getSerializableExtra("membros");
            nome.setText(membros.getNome());
            telefone.setText(membros.getTelefone());
            endereco.setText(membros.getEndereco());
            idade.setText(membros.getData_de_nacimento());
            email.setText(membros.getEmail());
            batizado.setText(membros.getBatizado());
        }
    }

    public void checkbox(){
        String Texto = "";
        if(checkBoxSim.isChecked()){
            Texto = "SIM";
        }if(checkBoxNao.isChecked()){
            Texto = "Não";
        }
        batizado.setText(Texto);
    }

    public void Cadastrar(View view){
        if(membros == null){
            checkbox();
        membros = new Membro();
        membros.setNome(nome.getText().toString().trim());
        membros.setTelefone(telefone.getText().toString().trim());
        membros.setEndereco(endereco.getText().toString().trim());
        membros.setData_de_nacimento(idade.getText().toString().trim());
        membros.setEmail(email.getText().toString().trim());
        membros.setBatizado(batizado.getText().toString().trim());
        long id = dao.inserir(membros);
            btCadastrar.setVisibility(View.VISIBLE);
            Toast.makeText(this,"Cadastrado",Toast.LENGTH_SHORT).show();
            onBackPressed();
        }else{
            membros.setNome(nome.getText().toString());
            membros.setTelefone(telefone.getText().toString());
            membros.setEndereco(endereco.getText().toString());
            membros.setData_de_nacimento(idade.getText().toString().trim());
            membros.setEmail(email.getText().toString().trim());
            membros.setBatizado(batizado.getText().toString().trim());
            dao.atualizar(membros);
            btCadastrar.setVisibility(View.VISIBLE);
            Toast.makeText(this,"Dabos Do Membro atualizado",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Cadastro.this, ListaMenbros.class);
            startActivity(i);
            finish();
        }
    }
    private void inicializarComponentes() {
        btCadastrar = (Button) findViewById(R.id.btCadastrar);
    }
    //MOSTRA MSG
    private  void alert (String msg){
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        Toast.makeText(Cadastro.this,msg,Toast.LENGTH_SHORT).show();
    }
}