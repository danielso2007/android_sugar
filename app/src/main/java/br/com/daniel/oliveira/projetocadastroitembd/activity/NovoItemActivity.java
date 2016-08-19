package br.com.daniel.oliveira.projetocadastroitembd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.daniel.oliveira.projetocadastroitembd.adapter.CategoriaCursorAdapter;
import br.com.daniel.oliveira.projetocadastroitembd.constant.Constant;
import br.com.daniel.oliveira.projetocadastroitembd.model.Categoria;
import br.com.daniel.oliveira.projetocadastroitembd.model.Item;
import br.com.daniel.oliveira.projetocadastroitembd.util.Util;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NovoItemActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.edNome)
    EditText nome;

    @BindView(R.id.edQtd)
    EditText quantidade;

    private Categoria categoria;

    @BindView(R.id.spCategorias)
    Spinner categorias;

    private Item item = new Item();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_item);

        ButterKnife.bind(this);

        montarCombo();
    }

    private void montarCombo() {
        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        Categoria selectCat = new Categoria();
        selectCat.setId(-1L);
        selectCat.setNome(Constant.SELECIONE);

        listaCategorias.add(selectCat);

        for (Categoria categoria : Categoria.listAll(Categoria.class)) {
            listaCategorias.add(categoria);
        }

//        categorias.setAdapter(new CategoriaCursorAdapter(this, listaCategorias));
        ArrayAdapter arrayCategorias = new ArrayAdapter<Categoria>(this, android.R.layout.simple_spinner_item,  listaCategorias);
        arrayCategorias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(arrayCategorias);
        categorias.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        this.categoria = (Categoria) parent.getItemAtPosition(pos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @OnClick(R.id.btnSalvar)
    public void onCLickSalvar(View v) {
        if (Util.isNotNull(nome) && Util.isNotNull(quantidade) && Util.isNotNull(categorias)) {
            item.setNome(nome.getText().toString());
            item.setQuantidade(Integer.valueOf(quantidade.getText().toString()));
            item.setCategoria(categoria);

            if (item.getId() == null) {
                item.save();
            } else {
                item.update();
            }

            Toast.makeText(this, "Item cadastrado com sucesso!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        }
    }
}
