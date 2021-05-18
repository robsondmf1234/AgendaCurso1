package com.example.agendacurso1.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendacurso1.R;
import com.example.agendacurso1.dao.AlunoDAO;
import com.example.agendacurso1.model.Aluno;

public class FomrularioAlunoActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fomrulario_aluno);
        setTitle(getString(R.string.tituloApBar));

        inicializacaoCampos();
        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_fomulario_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = criaAluno();
                salvarAluno(alunoCriado);
            }
        });
    }

    private void inicializacaoCampos() {
        campoNome = findViewById(R.id.activity_fomulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_fomulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_fomulario_aluno_email);
    }

    private void salvarAluno(Aluno alunoCriado) {
        dao.salva(alunoCriado);

        finish();
    }

    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome, telefone, email);
    }
}