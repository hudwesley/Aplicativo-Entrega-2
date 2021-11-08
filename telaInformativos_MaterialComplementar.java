package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class telaInformativos_MaterialComplementar extends AppCompatActivity {

    //criação do botao de informações do aluno
    private Button botaoInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_informativos_material_complementar);

        //pega o botaoInfo e o linka no botão botaoAluno (button da tela xml)
        botaoInfo = (Button) findViewById(R.id.botaoAluno);

        //evento de click
        botaoInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cria uma variável Intent a fim de realizar a transição entre as telas
                // Referencia a página que está (this) e a página que o usuário será redirecionado (class)
                Intent trocarTela = new Intent(telaInformativos_MaterialComplementar.this, telaInfoAlunos.class);
                startActivity(trocarTela); //executa a variável trocaTela
            }
        });

    }
}