package com.example.videira_em_celula.Banco_de_dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.videira_em_celula.Banco_de_dados.conecxao;
import com.example.videira_em_celula.Membro;

import java.util.ArrayList;
import java.util.List;

public class MenbrosDAO {

    private conecxao conexao;
    private SQLiteDatabase banco;

    public MenbrosDAO(Context context){
        conexao =new conecxao(context);
        banco = conexao.getWritableDatabase();
    }
    public long inserir(Membro membros){
        ContentValues values = new ContentValues();
        values.put("nome",membros.getNome());
        values.put("email",membros.getEmail());
        values.put("telefone",membros.getTelefone());
        values.put("endereco",membros.getEndereco());
        values.put("idade",membros.getData_de_nacimento());
        values.put("batizado",membros.getBatizado());
       return banco.insert("membro",null,values);
    }
    public List<Membro>obterTodos(){
        List<Membro>membros = new ArrayList<>();
        Cursor cursor = banco.query("membro",new String[]{"id","nome","email","telefone","endereco","idade","batizado"},
                null,null,null,null,null);
        while (cursor.moveToNext()){
            Membro m = new Membro();
            m.setId(cursor.getInt(0));
            m.setNome(cursor.getString(1));
          //  m.setTelefone(cursor.getString(cursor.getColumnIndex("nome coluna"));
            m.setTelefone(cursor.getString(3));
            m.setEndereco(cursor.getString(4));
            m.setData_de_nacimento(cursor.getString(5));
            m.setEmail(cursor.getString(2));
            m.setBatizado(cursor.getString(6));
            membros.add(m);
        }
        return membros;
    }
    public  void excluir(Membro m){
        banco.delete("membro","id = ?",new String[]{m.getId().toString()});
    }

public void atualizar(Membro membros){
    ContentValues values = new ContentValues();
    values.put("nome",membros.getNome());
    values.put("email",membros.getEmail());
    values.put("telefone",membros.getTelefone());
    values.put("endereco",membros.getEndereco());
    values.put("idade",membros.getData_de_nacimento());
    values.put("batizado",membros.getBatizado());
    banco.update("membro",values,"id = ?", new String[]{membros.getId().toString()});
    }
}
