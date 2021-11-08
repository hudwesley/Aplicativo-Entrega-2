package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ferramentas.EventoDB;

public class registro extends AppCompatActivity {

    private EditText email, senha;
    private Button cadastro, voltarHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        email = (EditText) findViewById(R.id.emailRegistro);
        senha = (EditText) findViewById(R.id.senhaRegistro);
        cadastro = (Button) findViewById(R.id.registroBtn);
        voltarHome = (Button) findViewById(R.id.btnVoltar);
        EventoDB db = new EventoDB(this);

        //Voltar para a tela inicial
        voltarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trocaTela = new Intent(registro.this, MainActivity.class);
                startActivity(trocaTela);
            }
        });

        //Cadastrar um novo email e senha
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pegar o conteúdo dos campos de texto
                String emailCadastro = email.getText().toString();
                String senhaCadastro = senha.getText().toString();

                //Verifica se os campos estão vazios
                if(emailCadastro.isEmpty() &&  senhaCadastro.isEmpty()){
                    Toast.makeText(registro.this, "PREENCHA TODOS OS CAMPOS", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean validacao = db.validaLogin(emailCadastro); //Verifica se o usuário já existe
                    if(validacao==false){
                        Boolean inserir = db.insereUsuario(emailCadastro, senhaCadastro);
                        if(inserir==true){ //Verifica se a inserção foi efetuada
                            Toast.makeText(registro.this, "CADASTRADO COM SUCESSO", Toast.LENGTH_SHORT).show();
                            Intent trocaTela = new Intent(registro.this, MainActivity.class);
                            startActivity(trocaTela);
                        }
                    }else{ //Caso o usuário já existe, vai aparecer a mensagem 
                        Toast.makeText(registro.this, "USUÁRIO EXISTENTE", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}