package br.com.opet.tmm.appseriesopet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarActivity extends Activity {

    EditText titulo;
    EditText ingredientes;
    EditText preparo;
    EditText serve;
    EditText tempopreparo;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        titulo = (EditText)findViewById(R.id.editText);
        ingredientes = (EditText)findViewById(R.id.editText1);
        preparo = (EditText)findViewById(R.id.editText2);
        serve = (EditText)findViewById(R.id.editText3);
        tempopreparo = (EditText)findViewById(R.id.editText4);

        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TITULO)));
        ingredientes.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.INGREDIENTES)));
        preparo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PREPARO)));
        serve.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.SERVE)));
        tempopreparo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TEMPOPREPARO)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), titulo.getText().toString(), ingredientes.getText().toString(),
                        preparo.getText().toString(), serve.getText().toString(), tempopreparo.getText().toString());
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
