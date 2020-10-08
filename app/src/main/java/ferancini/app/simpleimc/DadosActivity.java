package ferancini.app.simpleimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class DadosActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtIdade;
    private EditText edtPeso;
    private EditText edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtIdade = (EditText) findViewById(R.id.edtIdade);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);

        Log.i("CICLO_VIDA", getLocalClassName() + ".onCreate() chamado");
    }

    public void clickRelatorio(View v){
        Intent it = new Intent(getBaseContext(), RelatorioIMC.class);

        String nome = edtNome.getText().toString();
        int idade = Integer.valueOf(edtIdade.getText().toString());
        Float altura = Float.valueOf(edtAltura.getText().toString());
        Float peso = Float.valueOf(edtPeso.getText().toString());

        Bundle dados = new Bundle();
        dados.putString("nome", nome);
        dados.putFloat("altura", altura);
        dados.putInt("idade", idade);
        dados.putFloat("peso", peso);

        it.putExtras(dados);
        startActivity(it);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CICLO_VIDA", getLocalClassName() + ".onStart() chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CICLO_VIDA", getLocalClassName() + ".onStop() chamado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("CICLO_VIDA", getLocalClassName() + ".onRestart() chamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CICLO_VIDA", getLocalClassName() + ".onResume() chamado");
    }
}