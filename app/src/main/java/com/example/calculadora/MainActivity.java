package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove, ponto, soma, subtracao, multiplicacao, divisao, igual, botao_limpar, backspace;

    private TextView txtConta, txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtConta.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView conta = findViewById(R.id.txt_conta);
                String string = conta.getText().toString();

                if (!string.isEmpty()) {

                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String txtConta = string.substring(var0, var1);
                    conta.setText(txtConta);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Expression conta = new ExpressionBuilder(txtConta.getText().toString()).build();
                    double resultado = conta.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {

                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });


    }

    private void IniciarComponentes() {
        numeroZero = findViewById(R.id.zero);
        numeroUm = findViewById(R.id.um);
        numeroDois = findViewById(R.id.dois);
        numeroTres = findViewById(R.id.tres);
        numeroQuatro = findViewById(R.id.quatro);
        numeroCinco = findViewById(R.id.cinco);
        numeroSeis = findViewById(R.id.seis);
        numeroSete = findViewById(R.id.sete);
        numeroOito = findViewById(R.id.oito);
        numeroNove = findViewById(R.id.nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        backspace = findViewById(R.id.backspace);
        txtConta = findViewById(R.id.txt_conta);
        txtResultado = findViewById(R.id.txt_resultado);
    }

    public void AcrescentarSoma(String string, boolean limpar_dados) {

        if (txtResultado.getText().equals("")) {
            txtConta.setText("");
        }
        if (limpar_dados) {
            txtResultado.setText(" ");
            txtConta.append(string);
        } else {
            txtConta.append(txtResultado.getText());
            txtConta.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
                AcrescentarSoma("0", true);
                break;

            case R.id.um:
                AcrescentarSoma("1", true);
                break;

            case R.id.dois:
                AcrescentarSoma("2", true);
                break;

            case R.id.tres:
                AcrescentarSoma("3", true);
                break;

            case R.id.quatro:
                AcrescentarSoma("4", true);
                break;

            case R.id.cinco:
                AcrescentarSoma("5", true);
                break;

            case R.id.seis:
                AcrescentarSoma("6", true);
                break;

            case R.id.sete:
                AcrescentarSoma("7", true);
                break;

            case R.id.oito:
                AcrescentarSoma("8", true);
                break;

            case R.id.nove:
                AcrescentarSoma("9", true);
                break;

            case R.id.ponto:
                AcrescentarSoma(".", true);
                break;

            case R.id.soma:
                AcrescentarSoma("+", false);
                break;

            case R.id.subtracao:
                AcrescentarSoma("-", false);
                break;

            case R.id.multiplicacao:
                AcrescentarSoma("*", false);
                break;

            case R.id.divisao:
                AcrescentarSoma("/", false);
                break;
        }
    }
}