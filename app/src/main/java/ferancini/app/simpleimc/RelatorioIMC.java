package ferancini.app.simpleimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RelatorioIMC extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtAltura;
    private TextView txtIdade;
    private TextView txtPeso;
    private TextView txtIMC;
    private TextView txtClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_i_m_c);

        txtNome = (TextView) findViewById(R.id.txtNome);
        txtAltura = (TextView) findViewById(R.id.txtAltura);
        txtIdade = (TextView) findViewById(R.id.txtIdade);
        txtPeso = (TextView) findViewById(R.id.txtPeso);
        txtIMC = (TextView) findViewById(R.id.txtIMC);
        txtClass = (TextView) findViewById(R.id.txtClass);

        Intent it = getIntent();
        Bundle dados = it.getExtras();

        Float altura = dados.getFloat("altura");
        Float peso = dados.getFloat("peso");
        Float imc = peso/(altura*altura);

        txtNome.setText(dados.getString("nome"));
        txtIdade.setText(dados.getInt("idade") + " anos");
        txtAltura.setText(Float.toString(altura) + " m");
        txtPeso.setText(Float.toString(peso) + " kg");
        txtIMC.setText(Float.toString(imc));
        String imcClass = "";
        if(imc < 18.5)
            imcClass = "Abaixo do peso";
        else if(imc <= 24.9 )
            imcClass = "Saudável";
        else if(imc <= 29.9)
            imcClass = "Sobrepeso";
        else if(imc <= 34.9)
            imcClass = "Obesidade Grau I";
        else if(imc <= 39.9)
            imcClass = "Obesidade Grau II (severa)";
        else
            imcClass = "Obesidade Grau III (mórbida)";

        txtClass.setText(imcClass);

        Log.i("CICLO_VIDA", getLocalClassName() + ".onCreate() chamado");
    }

    public void clickDados(View v){

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CICLO_VIDA", getLocalClassName() + ".onStart() chamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CICLO_VIDA", getLocalClassName() + ".onResume() chamado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("CICLO_VIDA", getLocalClassName() + ".onRestart() chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CICLO_VIDA", getLocalClassName() + ".onStop() chamado");
    }
}