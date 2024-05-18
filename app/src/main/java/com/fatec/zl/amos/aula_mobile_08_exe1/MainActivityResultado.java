package com.fatec.zl.amos.aula_mobile_08_exe1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.fatec.zl.amos.aula_mobile_08_exe1.model.ingressos;
import com.fatec.zl.amos.aula_mobile_08_exe1.model.ingressosVip;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivityResultado extends AppCompatActivity {

    private  ingressos ing;
    private TextView tvRes;
    private Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnVoltar = findViewById(R.id.btnVoltar);
        TextView tvRes = findViewById(R.id.tvRes);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String tipo = bundle.getString("tipo");

        if (tipo.equals("comum")) {
            ing  = new ingressos();
        } else if (tipo.equals("vip")) {
            ing = new ingressosVip();
        }
        String id = (bundle.getString("id"));
        double val = bundle.getDouble("val");
        BigDecimal valor = BigDecimal.valueOf(val).setScale(2, RoundingMode.HALF_UP);
        tvRes.setText(tipo.toUpperCase()+"\n"+ id + "\n"+ valor);

        btnVoltar.setOnClickListener(op->voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }


}