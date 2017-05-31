package br.com.opet.tmm.appseriesopet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsereActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText titulo = (EditText)findViewById(R.id.editText);
                EditText ingredientes = (EditText)findViewById(R.id.editText1);
                EditText preparo = (EditText)findViewById((R.id.editText2));
                EditText serve = (EditText)findViewById(R.id.editText3);
                EditText tempopreparo = (EditText)findViewById(R.id.editText4);
                String tituloString = titulo.getText().toString();
                String ingredientesString = ingredientes.getText().toString();
                String preparoString = preparo.getText().toString();
                String serveString = serve.getText().toString();
                String tempopreparoString = tempopreparo.getText().toString();
                String resultado;

                resultado = crud.insereDado(tituloString,ingredientesString,preparoString,serveString,tempopreparoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
