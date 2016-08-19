package br.com.daniel.oliveira.projetocadastroitembd.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.daniel.oliveira.projetocadastroitembd.activity.R;
import br.com.daniel.oliveira.projetocadastroitembd.model.Item;

public class ItemAdapter extends BaseAdapter {

    private List<Item> lista;
    private Activity activity;

    public ItemAdapter(List<Item> lista, Activity activity) {
        this.lista = lista;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int pos) {
        return this.lista.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return this.lista.get(pos).getId();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.adapter_lista_itens, parent, false);
        Item item = lista.get(pos);

        TextView nome = (TextView) view.findViewById(R.id.lista_nome);
        TextView qdt = (TextView) view.findViewById(R.id.lista_qtd);
        TextView categoria = (TextView) view.findViewById(R.id.lista_cat);

        nome.setText(item.getNome());
        qdt.setText(item.getQuantidade().toString());
        categoria.setText(item.getCategoria().getNome());

        return view;
    }
}
