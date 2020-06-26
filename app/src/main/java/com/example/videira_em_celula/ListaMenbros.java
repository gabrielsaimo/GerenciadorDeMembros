package com.example.videira_em_celula;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

public class ListaMenbros extends AppCompatActivity {
    private ListView listView;
    private MenbrosDAO dao;
    private List<Membro> membros;
    private List<Membro>MembrosFiltrados= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_menbros);
        listView = findViewById(R.id.Lista);
        dao = new MenbrosDAO( this);
        membros = dao.obterTodos();
        MembrosFiltrados.addAll(membros);
        registerForContextMenu(listView);
       // ArrayAdapter<Membro> adaptador = new ArrayAdapter<Membro>(this, android.R.layout.simple_list_item_1,MembrosFiltrados);
        MembroAdapiter membroAdapiter = new MembroAdapiter(this,MembrosFiltrados);
        listView.setAdapter(membroAdapiter);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_main,menu);
        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                procuraMembros(newText);
                return false;
            }
        });
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu , v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contesto,menu);
    }

    public  void procuraMembros(String nome){
        MembrosFiltrados.clear();
        for(Membro m : membros){
            if(m.getNome().toLowerCase().contains(nome.toLowerCase())){
                MembrosFiltrados.add(m);
            }
        }
        listView.invalidateViews();
    }


    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Membro membrosExcluir = MembrosFiltrados.get(menuInfo.position);
        AlertDialog dialogo = new AlertDialog.Builder(this).setTitle("Atençáo").setMessage("Realmente deseja excluir o membro?").setNegativeButton("NÂO",null).setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MembrosFiltrados.remove(membrosExcluir);
                membros.remove(membrosExcluir);
                dao.excluir(membrosExcluir);
                listView.invalidateViews();
                finish();

            }
        }).create();
        dialogo.show();
    }
    public void editar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Membro membrosEditar = MembrosFiltrados.get(menuInfo.position);
        Intent it = new Intent(this,Cadastro.class);
        it.putExtra("membros",membrosEditar);
        startActivity(it);
        finish();

    }
}