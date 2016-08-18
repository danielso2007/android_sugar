package br.com.daniel.oliveira.projetocadastroitembd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btNovo)
    Button novo;

    @BindView(R.id.btListar)
    Button listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btNovo)
    public void onCLickNovo(View v) {
        startActivity(new Intent(this, NovoItemActivity.class));
    }

    @OnClick(R.id.btListar)
    public void onClickListar(View v) {
        startActivity(new Intent(this, ListarItensActivity.class));
    }
}
