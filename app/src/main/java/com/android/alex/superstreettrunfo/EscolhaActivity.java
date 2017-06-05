package com.android.alex.superstreettrunfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EscolhaActivity extends AppCompatActivity {
    private Button btn_soco;
    private Button btn_chute;
    private Button btn_especial;
    private ImageView image_char;
    private String character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_escolha);

        btn_soco = (Button) findViewById(R.id.btn_soco);
        btn_chute = (Button) findViewById(R.id.btn_chute);
        btn_especial = (Button) findViewById(R.id.btn_especial);
        image_char = (ImageView) findViewById(R.id.charimg);
        Bundle bundle = getIntent().getExtras();

        character = bundle.getString("character");

        if(character.equals("ken")) {
            image_char.setImageResource(R.drawable.ken);
            btn_soco.setText("SOCO = 80");
            btn_chute.setText("CHUTE = 70");
            btn_especial.setText("ESPECIAL = 50");
        }else if(character.equals("ryu")) {
            image_char.setImageResource(R.drawable.ryu);
            btn_soco.setText("SOCO = 40");
            btn_chute.setText("CHUTE = 60");
            btn_especial.setText("ESPECIAL = 100");
        }else if(character.equals("chunli")) {
            image_char.setImageResource(R.drawable.chunli);
            btn_soco.setText("SOCO = 30");
            btn_chute.setText("CHUTE = 100");
            btn_especial.setText("ESPECIAL = 70");
        }else if(character.equals("guile")) {
            image_char.setImageResource(R.drawable.guile);
            btn_soco.setText("SOCO = 60");
            btn_chute.setText("CHUTE = 50");
            btn_especial.setText("ESPECIAL = 90");
        }

        btn_soco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                ir.putExtra("character",character);
                ir.putExtra("golpe","soco");
                if(character.equals("ken"))
                    ir.putExtra("forca",80);
                else if(character.equals("ryu"))
                    ir.putExtra("forca",40);
                else if(character.equals("chunli"))
                    ir.putExtra("forca",30);
                else if(character.equals("guile"))
                    ir.putExtra("forca",60);
                startActivity(ir);
            }
        });

        btn_chute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                ir.putExtra("character",character);
                ir.putExtra("golpe","chute");
                if(character.equals("ken"))
                    ir.putExtra("forca",70);
                else if(character.equals("ryu"))
                    ir.putExtra("forca",60);
                else if(character.equals("chunli"))
                    ir.putExtra("forca",100);
                else if(character.equals("guile"))
                    ir.putExtra("forca",50);
                startActivity(ir);
            }
        });

        btn_especial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                ir.putExtra("character",character);
                ir.putExtra("golpe","especial");
                if(character.equals("ken"))
                    ir.putExtra("forca",50);
                else if(character.equals("ryu"))
                    ir.putExtra("forca",100);
                else if(character.equals("chunli"))
                    ir.putExtra("forca",70);
                else if(character.equals("guile"))
                    ir.putExtra("forca",90);
                startActivity(ir);
            }
        });

    }
}
