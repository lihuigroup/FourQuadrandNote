package com.android.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.app.fourquadrantnote.R;

public class FourQuadrandActivity extends AppCompatActivity {

    private TextView text_back;
    private TextView quard_u_i;
    private TextView quard_u_ui;
    private TextView quard_uu_i;
    private TextView quard_uu_ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_quadrand);

        text_back=findViewById(R.id.text_back);
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        quard_u_i=findViewById(R.id.quard_urgent_important);
        quard_u_ui=findViewById(R.id.quard_urgent_unimportant);
        quard_uu_i=findViewById(R.id.qurad_unurgent_important);
        quard_uu_ui=findViewById(R.id.quard_unurgent_unimportant);

        quard_u_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FourQuadrandActivity.this, NewNoteActivity.class);
                intent.putExtra("type",0);
                startActivity(intent);
                finish();
            }
        });

        quard_uu_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FourQuadrandActivity.this, NewNoteActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
                finish();
            }
        });

        quard_u_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FourQuadrandActivity.this, NewNoteActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
                finish();
            }
        });

        quard_uu_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FourQuadrandActivity.this, NewNoteActivity.class);
                intent.putExtra("type",3);
                startActivity(intent);
                finish();
            }
        });
    }
}
