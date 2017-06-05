package com.android.alex.superstreettrunfo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity{
    private LinearLayout iv_ken;
    private LinearLayout iv_ryu;
    private LinearLayout iv_chunli;
    private LinearLayout iv_guile;
    private Button btn_selecionar1;
    private Button btn_selecionar2;
    private Button btn_selecionar3;
    private Button btn_selecionar4;
    private TextView tv_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);
        iv_ken = (LinearLayout) findViewById(R.id.iv_ken);
        iv_ryu = (LinearLayout) findViewById(R.id.iv_ryu);
        iv_chunli = (LinearLayout) findViewById(R.id.iv_chunli);
        iv_guile = (LinearLayout) findViewById(R.id.iv_guile);

        String character=null;
        if(getIntent().hasExtra("character")){
            Bundle bundle = getIntent().getExtras();
            if(!bundle.getString("character").equals(null)){
                character= bundle.getString("character");
            }
        }
        else
            character="";

        if(character.equals("ken")) {
            iv_ken.setVisibility(View.INVISIBLE);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv_ken.getLayoutParams();
            params.height = 0;
            iv_ken.setLayoutParams(new LinearLayout.LayoutParams(params));
        }
        if(character.equals("ryu")) {
            iv_ryu.setVisibility(View.INVISIBLE);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv_ryu.getLayoutParams();
            params.height = 0;
            iv_ryu.setLayoutParams(new LinearLayout.LayoutParams(params));
        }
        if(character.equals("chunli")) {
            iv_chunli.setVisibility(View.INVISIBLE);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv_chunli.getLayoutParams();
            params.height = 0;
            iv_chunli.setLayoutParams(new LinearLayout.LayoutParams(params));
        }
        if(character.equals("guile") || Score.score < 1000) {
            iv_guile.setVisibility(View.INVISIBLE);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv_guile.getLayoutParams();
            params.height = 0;
            iv_guile.setLayoutParams(new LinearLayout.LayoutParams(params));
        }

        btn_selecionar1 = (Button) findViewById(R.id.btn_selecionar1);
        btn_selecionar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent select1 = new Intent(getBaseContext(), EscolhaActivity.class);
                select1.putExtra("character","ken");
                startActivity(select1);
            }
        });

        btn_selecionar2 = (Button) findViewById(R.id.btn_selecionar2);
        btn_selecionar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent select2 = new Intent(getBaseContext(), EscolhaActivity.class);
                select2.putExtra("character","ryu");
                startActivity(select2);
            }
        });

        btn_selecionar3 = (Button) findViewById(R.id.btn_selecionar3);
        btn_selecionar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent select3 = new Intent(getBaseContext(), EscolhaActivity.class);
                select3.putExtra("character","chunli");
                startActivity(select3);
            }
        });

        btn_selecionar4 = (Button) findViewById(R.id.btn_selecionar4);
        btn_selecionar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent select4 = new Intent(getBaseContext(), EscolhaActivity.class);
                select4.putExtra("character","guile");
                startActivity(select4);
            }
        });

        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_score.setText(Integer.toString(Score.score));

        if (Score.score <= 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent go = new Intent(getBaseContext(), GameOver.class);
                    startActivity(go);
                    finish();
                }
            },1000);
        }

    }
}
