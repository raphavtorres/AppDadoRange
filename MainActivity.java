package com.example.appdado;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();

        final ImageView imgDado = findViewById(R.id.imagemDado);
        SeekBar range = findViewById(R.id.slide);

        Switch switchImagem = (Switch) findViewById(R.id.switchImg);
        switchImagem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imgDado.setVisibility(View.VISIBLE);
                } else {
                    imgDado.setVisibility(View.INVISIBLE);
                }
            }
        });

        range.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float scale = ((i / 100.0f) + 1);
                imgDado.setScaleX(scale);
                imgDado.setScaleY(scale);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                imgDado.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                imgDado.setVisibility(View.INVISIBLE);
                switchImagem.setChecked(false);

            }
        });

    }

    public void myButtonListenerMethod(){
        Button botao = findViewById(R.id.botaoRolarDado);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int resultadoRand = rand.nextInt(6) + 1;
                TextView textoRetorno = findViewById(R.id.resultadoDado);
                textoRetorno.setText("Resultado: " + Integer.toString(resultadoRand));
                ImageView imagemDado = findViewById(R.id.imagemDado);
                switch (resultadoRand){
                    case 1:
                        imagemDado.setImageResource(R.drawable.f1);
                        break;
                    case 2:
                        imagemDado.setImageResource(R.drawable.f2);
                        break;
                    case 3:
                        imagemDado.setImageResource(R.drawable.f3);
                        break;
                    case 4:
                        imagemDado.setImageResource(R.drawable.f4);
                        break;
                    case 5:
                        imagemDado.setImageResource(R.drawable.f5);
                        break;
                    case 6:
                        imagemDado.setImageResource(R.drawable.f6);
                        break;
                }
            }
        });
    }
}