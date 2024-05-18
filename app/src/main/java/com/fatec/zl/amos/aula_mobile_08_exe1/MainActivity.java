package com.fatec.zl.amos.aula_mobile_08_exe1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.fatec.zl.amos.aula_mobile_08_exe1.model.ingressos;
import com.fatec.zl.amos.aula_mobile_08_exe1.model.ingressosVip;

public class MainActivity extends AppCompatActivity {

    private EditText etID;
    private Button btnCalc;
    private CheckBox cbVip;
    private ingressos ing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cbVip = findViewById(R.id.cbVip);
        cbVip.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etID = findViewById(R.id.etID);
        etID.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button  btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());

    }

    private void calc() {
        String tipo;
        double val;
        if (cbVip.isChecked()) {
            tipo = "vip";
            ingressosVip ing = new ingressosVip(); // Inicialize como ingressosVip
            ing.setValor(10);
            val = ing.getValorFinal(20);
        } else {
            tipo = "comum";
            ingressos ing = new ingressos(); // Inicialize como ingressos
            ing.setValor(10);
            val = ing.getValorFinal(10);
        }

        String id = etID.getText().toString();
        Bundle bundle =  new Bundle();
        bundle.putString("id", id); // Corrija a chave para "id"
        bundle.putString("tipo", tipo);
        bundle.putDouble("val", val);

        troca(bundle);
    }


    private void troca(Bundle bundle) {
        Intent i = new Intent(this, MainActivityResultado.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}