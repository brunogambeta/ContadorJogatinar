package com.brunogambeta.contadorjogatinar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PontuacaoActivity extends AppCompatActivity {

    private TextView nomeJogadorPontuacao1, nomeJogadorPontuacao2, pontuacaoJogador1, pontuacaoJogador2;
    private ImageButton adicionarJogador1, removerJogador1, adicionarJogador2, removerJogador2;

    private String pontuacaoMostrada1, pontuacaoMostrada2;

    private int pontuacao1;
    private int pontuacao2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuacao);

        //Inicia pontuação preenchida pelo usuário
        Bundle dadosPontuacao = getIntent().getExtras();
        pontuacaoMostrada1 = dadosPontuacao.getString("pontuacaoJogador1");
        pontuacaoMostrada2 = dadosPontuacao.getString("pontuacaoJogador2");

        //Configurações iniciais
        inicializarComponente();
        recuperarDadosInicial();

        //Configuração Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Placar");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Adiciona valor na pontuacao do primeiro jogador
        adicionarJogador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pontuacao1 >= 0) {
                    pontuacao1 += 1;
                    pontuacaoMostrada1 = String.valueOf(pontuacao1);
                    pontuacaoJogador1.setText(pontuacaoMostrada1);
                }


            }
        });

        //Remove valor da pontuacao do primeiro jogador
        removerJogador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pontuacao1 > 0) {
                    pontuacao1 -= 1;
                    pontuacaoMostrada1 = String.valueOf(pontuacao1);
                    pontuacaoJogador1.setText(pontuacaoMostrada1);
                }
            }
        });

        //Adiciona valor na pontuacao do segundo jogador
        adicionarJogador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pontuacao2 >= 0) {
                    pontuacao2 += 1;
                    pontuacaoMostrada2 = String.valueOf(pontuacao2);
                    pontuacaoJogador2.setText(pontuacaoMostrada2);
                }


            }
        });

        //Remove valor da pontuacao do segundo jogador
        removerJogador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pontuacao2 > 0) {
                    pontuacao2 -= 1;
                    pontuacaoMostrada2 = String.valueOf(pontuacao2);
                    pontuacaoJogador2.setText(pontuacaoMostrada2);
                }
            }
        });
    }

    //Método inicial
    private void inicializarComponente() {

        nomeJogadorPontuacao1 = findViewById(R.id.textJogador1);
        nomeJogadorPontuacao2 = findViewById(R.id.textJogador2);
        pontuacaoJogador1 = findViewById(R.id.textViewPontuacao);
        pontuacaoJogador2 = findViewById(R.id.textViewPontuacao2);
        adicionarJogador1 = findViewById(R.id.btAdicionaJogador1);
        removerJogador1 = findViewById(R.id.btRemoveJogador1);
        adicionarJogador2 = findViewById(R.id.btAdicionaJogador2);
        removerJogador2 = findViewById(R.id.btRemoveJogador2);

    }

    //Método para abrir novamente a tela inicial
    public void abrirNovoJogo() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    //Método para recuperar os dados passados pelo usuário
    private void recuperarDadosInicial() {

        String nomeJogador1;
        String nomeJogador2;
        String ptJogador1;
        String ptJogador2;

        Bundle dados = getIntent().getExtras();
        nomeJogador1 = dados.getString("primeiroJogador");
        nomeJogador2 = dados.getString("segundoJogador");
        ptJogador1 = dados.getString("pontuacaoJogador1");
        ptJogador2 = dados.getString("pontuacaoJogador2");

        nomeJogadorPontuacao1.setText(nomeJogador1);
        nomeJogadorPontuacao2.setText(nomeJogador2);
        pontuacaoJogador1.setText(ptJogador1);
        pontuacaoJogador2.setText(ptJogador2);

        pontuacao1 = Integer.parseInt(pontuacaoMostrada1);
        pontuacao2 = Integer.parseInt(pontuacaoMostrada2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_jogo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuNovoJogo:
                abrirNovoJogo();
                break;
            case R.id.menuLimparJogo:
                recuperarDadosInicial();
                break;
            case R.id.menuSair:
                finalizarApp();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void finalizarApp(){
        finish();
        onDestroy();
    }
}