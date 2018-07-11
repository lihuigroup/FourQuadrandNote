package com.android.app.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.app.Entry.NoteEntry;
import com.android.app.fourquadrantnote.R;
import com.android.app.model.NoteModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewNoteActivity extends AppCompatActivity {
    private int type;
    private TextView text_back;
    private EditText edit_tittle;
    private EditText edit_content;
    private EditText editTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        type= getIntent().getIntExtra("type",0);

        text_back=findViewById(R.id.text_back);
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        editTime=findViewById(R.id.edit_time);
        editTime.setText(getCurdate());

        edit_tittle=findViewById(R.id.edit_tittle);
        edit_content=findViewById(R.id.edit_content);
    }

    public void submit(View view){
        String s_t=edit_tittle.getText().toString();
        String s_c=edit_content.getText().toString();
        String s_date=editTime.getText().toString();
        Date date=getDate(s_date);

        if(s_t.equals("")){
            return;
        }

        NoteModel.addNote(new NoteEntry(-1,s_t,s_c,date,type,false));
        finish();

    }

    public static String getCurdate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String time = formatter.format(curDate);
        return time;
    }

    public static String DateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = formatter.format(date);
        return time;
    }


    public static Date getDate(String time){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = formatter.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
