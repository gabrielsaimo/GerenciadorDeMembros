package com.example.videira_em_celula;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        values.put("telefone",membros.getTelefone());
        values.put("endereco",membros.getEndereco());
        values.put("idade",membros.getData_de_nacimento());


       return banco.insert("membros",null,values);
    }
    public List<Membro>obterTodos(){
        List<Membro>membros = new ArrayList<>();
        Cursor cursor = banco.query("membros",new String[]{"id","nome","telefone","endereco","idade"},
                null,null,null,null,null);
        while (cursor.moveToNext()){
            Membro m = new Membro();
            m.setId(cursor.getInt(0));
            m.setNome(cursor.getString(1));
            m.setTelefone(cursor.getString(2));
            m.setEndereco(cursor.getString(3));
            m.setData_de_nacimento(cursor.getString(4));
            membros.add(m);
        }
        return membros;
    }
    public  void excluir(Membro m){
        banco.delete("membros","id = ?",new String[]{m.getId().toString()});
    }

public void atualizar(Membro membros){
    ContentValues values = new ContentValues();
    values.put("nome",membros.getNome());
    values.put("telefone",membros.getTelefone());
    values.put("endereco",membros.getEndereco());
    values.put("idade",membros.getData_de_nacimento());
    banco.update("membros",values,"id = ?", new String[]{membros.getId().toString()});
    }
}
