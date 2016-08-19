package br.com.daniel.oliveira.projetocadastroitembd.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.daniel.oliveira.projetocadastroitembd.activity.R;
import br.com.daniel.oliveira.projetocadastroitembd.model.Categoria;

public class CategoriaCursorAdapter extends BaseAdapter implements SpinnerAdapter {

    private Activity activity;
    private List<Categoria> list;

    public CategoriaCursorAdapter(Activity activity, List<Categoria> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return list.get(pos).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View spinView;

        if( convertView == null ){
            LayoutInflater inflater = activity.getLayoutInflater();
            spinView = inflater.inflate(R.layout.categoria_spin_layout, null);
        } else {
            spinView = convertView;
        }

        TextView t1 = (TextView) spinView.findViewById(R.id.fieldNome);

        t1.setText(String.valueOf(list.get(position).getNome()));

        return spinView;
    }
}
