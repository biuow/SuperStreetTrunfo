package com.android.alex.superstreettrunfo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JogadaActivity extends AppCompatActivity {
    private TextView tv_char_input;
    private TextView tv_enemy_input;
    private TextView char_golpe;
    private TextView enemy_golpe;
    private ImageView iv_enemy;
    private ImageView iv_char;

    private static int TEMPO = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_jogada);
        tv_char_input = (TextView) findViewById(R.id.tv_char_input);
        tv_enemy_input = (TextView) findViewById(R.id.tv_enemy_input);
        char_golpe = (TextView) findViewById(R.id.char_golpe);
        enemy_golpe = (TextView) findViewById(R.id.enemy_golpe);
        iv_enemy = (ImageView) findViewById(R.id.iv_enemy);
        iv_char =  (ImageView) findViewById(R.id.iv_char);

        Intent i = getIntent();
        Bundle valor = i.getExtras();

        final String character = (String) valor.get("character");
        String golpe = (String) valor.get("golpe");
        int forca = (Integer) valor.get("forca");
        int enemy_forca = 0;

        char_golpe.setText(golpe.toUpperCase());
        enemy_golpe.setText(golpe.toUpperCase());
        tv_char_input.setText(String.valueOf(forca));

        if(character.equals("ken")) {
            iv_char.setImageResource(R.drawable.ken);
        }else if(character.equals("ryu")) {
            iv_char.setImageResource(R.drawable.ryu);
        }else if(character.equals("chunli")) {
            iv_char.setImageResource(R.drawable.chunli);
        }else if(character.equals("guile")) {
            iv_char.setImageResource(R.drawable.guile);
        }

        int personagemComputador = (int) (Math.random()*3)+1;

        if(personagemComputador == 1){
            iv_enemy.setImageResource(R.drawable.sagat);
            if(golpe.equals("soco")){
                enemy_forca = 20;
            }else if(golpe.equals("chute")){
                enemy_forca = 110;
            }else if(golpe.equals("especial")){
                enemy_forca = 70;
            }
        }else if(personagemComputador == 2){
            iv_enemy.setImageResource(R.drawable.blanka);
            if(golpe.equals("soco")){
                enemy_forca = 60;
            }else if(golpe.equals("chute")){
                enemy_forca = 30;
            }else if(golpe.equals("especial")){
                enemy_forca = 110;
            }
        }else if(personagemComputador == 3) {
            iv_enemy.setImageResource(R.drawable.bison);
            if(golpe.equals("soco")){
                enemy_forca = 90;
            }else if(golpe.equals("chute")){
                enemy_forca = 40;
            }else if(golpe.equals("especial")){
                enemy_forca = 90;
            }
        }

        tv_enemy_input.setText(Integer.toString(enemy_forca));

        if(enemy_forca == forca){
            Toast.makeText(getBaseContext(),
                    "EMPATE",Toast.LENGTH_LONG).show();
        }else if(enemy_forca < forca){
            Toast.makeText(getBaseContext(),
                    "JOGADOR GANHOU",Toast.LENGTH_LONG).show();
                    Score.score += 200;
        }else if(enemy_forca > forca){
            Toast.makeText(getBaseContext(),
                    "JOGADOR PERDEU",Toast.LENGTH_LONG).show();
                    Score.score -= 100;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), MenuActivity.class);
                i.putExtra("character",character);
                startActivity(i);
                finish();
            }
        },TEMPO);

    }
}
