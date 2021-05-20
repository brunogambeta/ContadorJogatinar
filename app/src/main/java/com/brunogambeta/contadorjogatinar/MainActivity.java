package com.brunogambeta.contadorjogatinar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity implements Serializable {

    private Button botaoComecar;
    private EditText nomeJogador1, nomejogador2, pontuacaoInicialJogador1, pontuacaoInicialJogador2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configuração inicial
        inicializarComponentes();

        //Configuração Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Contador Jogatina");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);


    }

    //Método inicial
    private void inicializarComponentes() {

        nomeJogador1 = findViewById(R.id.editPrimeiroJogador);
        nomejogador2 = findViewById(R.id.editSegundoJogador);
        botaoComecar = findViewById(R.id.buttonComecar);
        pontuacaoInicialJogador1 = findViewById(R.id.editPontuacaoInicialJogado1);
        pontuacaoInicialJogador2 = findViewById(R.id.editPontuacaoInicialJogador2);
    }

    //Método para validar os dados
    public void validarDados(View view) {

        String primeiroJogador = nomeJogador1.getText().toString();
        String segundoJogador = nomejogador2.getText().toString();
        String pontuacaoJogador1 = pontuacaoInicialJogador1.getText().toString();
        String pontuacaoJogador2 = pontuacaoInicialJogador2.getText().toString();

        if (!primeiroJogador.isEmpty()) {
            if (!segundoJogador.isEmpty()) {
                if (!pontuacaoJogador1.isEmpty()) {
                    if (!pontuacaoJogador2.isEmpty()) {
                        Intent i = new Intent(MainActivity.this, PontuacaoActivity.class);
                        i.putExtra("primeiroJogador", primeiroJogador);
                        i.putExtra("segundoJogador", segundoJogador);
                        i.putExtra("pontuacaoJogador1", pontuacaoJogador1);
                        i.putExtra("pontuacaoJogador2", pontuacaoJogador2);
                        startActivity(i);
                    } else {
                        exibeMensagem("Pontuacao do Jogador 2 náo informada, Verifique!");
                    }
                } else {
                    exibeMensagem("Pontuacao do Jogador 1 náo informada, Verifique!");
                }

            } else {
                exibeMensagem("Nome do segundo jogador não informado, Verifique!");
            }
        } else {
            exibeMensagem("Nome do primeiro jogador não informado, Verifique!");
        }


    }

    //Método para exibir mensagens de erro
    private void exibeMensagem(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }

}