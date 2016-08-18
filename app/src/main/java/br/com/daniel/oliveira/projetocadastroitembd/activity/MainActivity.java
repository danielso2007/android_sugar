package br.com.daniel.oliveira.projetocadastroitembd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button novo;
    private Button listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.novo = (Button) findViewById(R.id.btNovo);
        this.listar = (Button) findViewById(R.id.btListar);

        this.novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarActivity(NovoItemActivity.class);
            }
        });

        this.listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarActivity(ListarItensActivity.class);
            }
        });
    }

    private void iniciarActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }
}
