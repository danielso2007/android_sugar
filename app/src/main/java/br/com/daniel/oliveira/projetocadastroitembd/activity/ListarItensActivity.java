package br.com.daniel.oliveira.projetocadastroitembd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.daniel.oliveira.projetocadastroitembd.adapter.ItemAdapter;
import br.com.daniel.oliveira.projetocadastroitembd.model.Item;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListarItensActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_itens);

        ButterKnife.bind(this);

        List<Item> listaItens = Item.listAll(Item.class);

//        ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, listaItens);

        ItemAdapter adapter = new ItemAdapter(listaItens, this);

        listView.setAdapter(adapter);
    }
}
