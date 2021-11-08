package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class telaInfoAlunos extends AppCompatActivity {

    //criação do botão voltar
    private Button botaoVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_info_alunos);

        //pega o botaoVoltar e o linka no botão voltarBtn (button da tela xml)
        botaoVoltar = (Button) findViewById(R.id.voltarBtn);

        //evento de click
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cria uma variável Intent a fim de realizar a transição entre as telas
                // Referencia a página que está (this) e a página que o usuário será redirecionado (class)
                Intent trocaTela = new Intent(telaInfoAlunos.this, telaInformativos_MaterialComplementar.class);
                startActivity(trocaTela);//executa a variável trocaTela
            }
        });
    }
}