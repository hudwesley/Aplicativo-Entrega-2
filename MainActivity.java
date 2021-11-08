package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ferramentas.EventoDB;

public class MainActivity extends AppCompatActivity {

    //criação do botão entrar
    private Button botaoEntrar, registrarBtn;
    private EditText email, senha;
    EventoDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pega o botaoEntrao e o linka no botão entrarBtn (button da tela xml)
        registrarBtn = (Button) findViewById(R.id.registrar);
        botaoEntrar = (Button) findViewById(R.id.entrarBtn);
        email = (EditText) findViewById(R.id.emailTxt);
        senha = (EditText) findViewById(R.id.senhaTxt);
        db = new EventoDB(this);

        //evento de click

        registrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trocaTela = new Intent(MainActivity.this, registro.class);
                startActivity(trocaTela);
            }
        });

       botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cria uma variável Intent a fim de realizar a transição entre as telas
                // Referencia a página que está (this) e a página que o usuário será redirecionado (class)
                String login = email.getText().toString();
                String password = senha.getText().toString();

                //Verifica se os campos estão vazios
                if(login.isEmpty() && password.isEmpty()){
                    Toast.makeText(MainActivity.this, "PREENCHA TODOS OS CAMPOS", Toast.LENGTH_LONG).show();
                }else{
                    //Verifica se existe o email e senha no DB
                    Boolean validacao = db.validaLoginSenha(login, password);
                    if(validacao==true){ //Caso existe, ele vai logar e ir para a tela de Informativos
                        Toast.makeText(MainActivity.this, "LOGIN EFETUADO COM SUCESSO", Toast.LENGTH_SHORT).show();
                        Intent trocaTela = new Intent(MainActivity.this, telaInformativos_MaterialComplementar.class);
                        startActivity(trocaTela);
                    }else{ //Caso não existe, vai aparecer a mensagem de erro
                        Toast.makeText(MainActivity.this, "ERRO NO LOGIN", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}