package com.example.videira_em_celula;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MembroAdapiter extends BaseAdapter {

    private List<Membro>membros;
    private Activity activity;

    public MembroAdapiter(Activity activity, List<Membro> membros){
        this.activity = activity;
        this.membros = membros;
    }

    public MembroAdapiter(){
        super();
    }

    @Override
    public int getCount() {
        return membros.size();
    }

    @Override
    public Object getItem(int position) {
        return membros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return membros.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater().inflate(R.layout.item,parent,false);
        TextView nome = view.findViewById(R.id.textNome);
        TextView telefone = view.findViewById(R.id.taextnumero);
        TextView endereco = view.findViewById(R.id.textEndereco);
        TextView data = view.findViewById(R.id.textData);
        TextView email = view.findViewById(R.id.textEmail);
        TextView batizado = view.findViewById(R.id.textBatizado);

        Membro m = membros.get(position);

        nome.setText(m.getNome());
        email.setText(m.getEmail());
        telefone.setText(m.getTelefone());
        endereco.setText(m.getEndereco());
        data.setText(m.getData_de_nacimento());
        batizado.setText(m.getBatizado());
        return view;
    }
}
















